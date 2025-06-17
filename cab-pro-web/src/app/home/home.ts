import {Component, OnInit} from '@angular/core';
import {Cab} from '../model/cab';
import {FormsModule} from '@angular/forms';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {TripForm} from '../trip-form/trip-form';

@Component({
  selector: 'app-home',
  templateUrl: './home.html',
  standalone: true,
  imports: [
    FormsModule,
    TripForm
  ],
  styleUrl: './home.css'
})
export class Home implements OnInit {
  source = "";
  cabs: Cab[] | undefined;

  constructor(private httpClient : HttpClient) {}

  ngOnInit() : void {
    this.httpClient.get<Cab[]>("http://localhost:8080/v1/cabs").subscribe({
     next: (data: Cab[]) => { this.cabs = data; },
     error: (error: HttpErrorResponse) => { console.log(error); },
    });
  }
}
