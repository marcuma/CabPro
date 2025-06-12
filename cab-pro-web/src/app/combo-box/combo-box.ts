import {Component, HostBinding, Input } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-combo-box',
  imports: [
    FormsModule,
    //NgClass,
  ],
  templateUrl: './combo-box.html',
  standalone: true,
  styleUrl: './combo-box.css'
})
export class ComboBox {
  @HostBinding('style.display') display = 'block';
  @HostBinding('style.width') width = '100%';

  itemList: any;
  @Input() inputItem: string = "";

  constructor(private httpClient: HttpClient) {
  }

  addressAutocomplete(): any {
    let currentTimeout = 0;
    const MIN_ADDRESS_LENGTH = 3;
    const DEBOUNCE_DELAY = 300;

    if (currentTimeout) {
      clearTimeout(currentTimeout);
    }

    if (this.inputItem.length < MIN_ADDRESS_LENGTH) {
      console.error('Input item must be greater than 0');
      return false;
    }

    currentTimeout = setTimeout(() => {
      console.log(currentTimeout);
      currentTimeout = 0;

      const apiKey: string = "15b33ee5683b458c87b96a68bc9cfa35";
      const url: string = `https://api.geoapify.com/v1/geocode/autocomplete?text=${encodeURIComponent(this.inputItem)}&format=json&limit=5&apiKey=${apiKey}`;

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
}
