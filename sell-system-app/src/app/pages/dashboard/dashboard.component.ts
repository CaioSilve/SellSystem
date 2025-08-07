import { Component } from '@angular/core';
import { CardComponent } from '../../template/card/card.component';
import { ViewForm } from '../../commons/view-form.model';

@Component({
  selector: 'dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  viewForm: ViewForm = new ViewForm;
  cards: Array<CardComponent> = [];
}
