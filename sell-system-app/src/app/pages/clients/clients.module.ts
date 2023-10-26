import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';

import { ClientsRoutingModule } from './clients-routing.module';
import { ClientsFormComponent } from './clients-form/clients-form.component';
import { NgxMaskDirective, NgxMaskPipe } from 'ngx-mask';


@NgModule({
  declarations: [
    ClientsFormComponent
  ],
  imports: [
    CommonModule,
    ClientsRoutingModule,
    ReactiveFormsModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    NgxMaskDirective,
    NgxMaskPipe
  ],
  exports: [
    ClientsFormComponent
  ],
  providers: [
    NgxMaskPipe,
    DatePipe
  ]
})
export class ClientsModule { }
