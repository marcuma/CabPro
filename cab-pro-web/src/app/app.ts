import { Component } from '@angular/core';
import { Home } from './home/home'


@Component({
  selector: 'app-root',
  imports: [Home],
  templateUrl: 'app.html',
  standalone: true,
  styleUrl: 'app.css'
})
export class App {
  protected title = 'cab-pro-web';
}
