import { Component, Input } from '@angular/core';


export enum bgColor{
  primary = 'primary',
  warning = 'warning',
  success = 'success',
  danger = 'danger'
}

export enum textColor{
  white = 'white',
  primary = 'primary',
  warning = 'warning',
  success = 'success',
  danger = 'danger'
}

export class Card{
  title: string
  color: string
}

@Component({
  selector: 'card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent {

  @Input()
  title: string;
  @Input()
  details: string;
  @Input()
  color?: string;
  @Input()
  textColor?: string;

  



}
