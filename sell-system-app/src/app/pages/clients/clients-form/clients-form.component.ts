import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { MatSort, Sort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ViewForm } from 'src/app/commons/view-form.model';
import { Client } from '../client.model';
import { ClientsService } from 'src/app/services/clients.service';
import { NgxMaskPipe } from 'ngx-mask';
import { DatePipe } from '@angular/common';
import { MatPaginator } from '@angular/material/paginator';

@Component({
  selector: 'clients-form',
  templateUrl: './clients-form.component.html',
  styleUrls: ['./clients-form.component.css']
})
export class ClientsFormComponent implements OnInit {

  @ViewChild(MatSort)
  sort: MatSort;
  
  @ViewChild(MatPaginator) 
  paginator: MatPaginator;


  cpfMask = '000.000.000-00';
  dateMask = 'dd/MM/yyyy';

  clientForm = this.fb.group({
    id: [null],
    name: [null, Validators.required],
    cpf: [null],
    birthDate: [null],
    registerDate: [''],
  });

  viewForm: ViewForm = new ViewForm;
  clients: MatTableDataSource<Client>;
  columns: any[] = [];
  displayedColumns: string[] = [];

  constructor(private fb: FormBuilder, private service: ClientsService, private maskPipe: NgxMaskPipe, private datePipe: DatePipe) {

  }

  ngOnInit(): void {
    this.loadTable();
  }

  onSubmit() {
    this.service.postClient(this.clientForm.value).subscribe(viewForm => {
      this.loadTable();
    });
  }

  clear() {
    this.clientForm.reset();
  }

  alter(){
    this.service.alterClient(this.clientForm.value).subscribe(viewForm => {
      this.loadTable();
    });
  }

  delete(){
    this.service.deleteClient(this.clientForm.value.id).subscribe(viewForm => {
      this.loadTable();
    });
  }

  select(selected: any) {
    this.clientForm.patchValue(selected);
  }

  validatePipe(row: any, column: any): any {
    switch (column.prop) {
      case 'cpf':
        return this.maskPipe.transform(row[column.prop], this.cpfMask);
      case 'birthDate':
        return this.datePipe.transform(row[column.prop], this.dateMask);
      case 'registerDate':
        return this.datePipe.transform(row[column.prop], this.dateMask);
      default:
        return row[column.prop]
    }
  }

  applyFilter(filterValue: string) {
    this.clients.filter = filterValue.trim().toLowerCase();

    if (this.clients.paginator) {
      this.clients.paginator.firstPage();
    }
  }

  loadTable() {
    this.service.listClients(new Client()).subscribe(viewForm => {
      this.viewForm = viewForm;
      this.clients = new MatTableDataSource(viewForm.data);
      this.clients.sort = this.sort;
      this.clients.paginator = this.paginator;
      this.columns = viewForm.view.columns;
      this.displayedColumns = ['index', ...viewForm.view.columns.map(function (c: any) {
        return c.prop;
      })];
    });
  }

}
