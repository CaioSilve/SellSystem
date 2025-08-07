import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';

import { PagesRoutingModule } from './pages-routing.module';
import { ClientsComponent } from './clients/clients.component';
import { NgxMaskDirective, NgxMaskPipe } from 'ngx-mask';
import { UsersComponent } from './users/users.component';



@NgModule({
  declarations: [
    ClientsComponent,
    UsersComponent
  ],
  imports: [
    CommonModule,
    PagesRoutingModule,
    ReactiveFormsModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    NgxMaskDirective,
    NgxMaskPipe,
    MatDialogModule,
    MatButtonModule
  ],
  exports: [
    ClientsComponent
  ],
  providers: [
    NgxMaskPipe,
    DatePipe
  ]
})
export class PagesModule { }
