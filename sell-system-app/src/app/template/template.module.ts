import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { CardComponent } from './card/card.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    NavbarComponent,
    SidebarComponent,
    CardComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ], 
  exports: [
    NavbarComponent,
    SidebarComponent,
    CardComponent
  ]
})
export class TemplateModule { }
