import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Cab} from '../model/cab';
import {Trip} from '../model/trip'

@Component({
  selector: 'app-trip-form',
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  standalone: true,
  templateUrl: './trip-form.html',
  styleUrl: './trip-form.css'
})
export class TripForm implements OnInit{
  cabs: Cab[] | undefined;
  inputItem = "";
  itemList :string[] = [];
  tripForm :FormGroup;
  source: string = '';
  destination: string = '';
  trip: Trip | null = null;

  constructor(private httpClient :HttpClient, private fb: FormBuilder) {
    this.tripForm = this.fb.group({
      source: new FormControl(''),
      destination: new FormControl(''),
      cabType: new FormControl(''),
     });
  }

  onSubmit() {
    console.log(this.tripForm.value);
    let tripContainer = document.getElementById('tripContainer');
    let confirmContainer = document.getElementById('confirmContainer');
    tripContainer?.classList.add('hidden');
    confirmContainer?.classList.remove('hidden');


  }

  ngOnInit() : void {
    this.httpClient.get<Cab[]>("http://localhost:8080/v1/cabs").subscribe({
      next: (data: Cab[]) => { this.cabs = data; },
      error: (error: HttpErrorResponse) => { console.log(error); },
    });
  }
  getDestination() {
    this.addressAutocomplete(this.tripForm.value.destination)
  }

  getSource() {
    this.addressAutocomplete(this.tripForm.value.source)
  }
  addressAutocomplete(inputItem : string): any {

    //this.inputItem = this.tripForm.value.source != '' ? this.tripForm.value.source : this.tripForm.value.destination;
    console.log(this.inputItem);

    let currentTimeout = 0;
    const MIN_ADDRESS_LENGTH = 3;
    const DEBOUNCE_DELAY = 300;

    if (currentTimeout) {
      clearTimeout(currentTimeout);
    }

    if (inputItem.length < MIN_ADDRESS_LENGTH) {
      console.error('Input item must be greater than 0');
      return false;
    }

    currentTimeout = setTimeout(() => {
      currentTimeout = 0;

      const apiKey: string = "15b33ee5683b458c87b96a68bc9cfa35";
      const url: string = `https://api.geoapify.com/v1/geocode/autocomplete?text=${encodeURIComponent(inputItem)}&format=json&limit=5&apiKey=${apiKey}`;

      this.httpClient.get<any>(url).subscribe({
        next: (response: any) => {
          this.itemList = response.results;
          this.handleData();
        },
        error: (error) => console.log('error: ', error),
      });
    }, DEBOUNCE_DELAY);
  }

  handleData() {
    const autoCompleteItemsElement: HTMLElement | null = document.getElementById('datalist');
    this.itemList.forEach(((item: any) => {
      const itemElement: HTMLOptionElement = document.createElement("option");
      itemElement.innerHTML = item.formatted;
      autoCompleteItemsElement?.append(itemElement);
    }));
  }

  getTrip() {
    let cabType :string = this.tripForm.value.cabType;
    this.httpClient.get<Trip>(`http://localhost:8080/v1/trip/${cabType}?fromAddress=${this.tripForm.value.source}&toAddress=${this.tripForm.value.destination}`)
      .subscribe({
      next: (response :Trip) => {
        this.trip = response;
      },
      error: (error) => console.log('error: ', error),
    });
  }
}
