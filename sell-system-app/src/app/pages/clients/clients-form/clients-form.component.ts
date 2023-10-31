import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ViewForm } from 'src/app/commons/view-form.model';
import { Client } from '../client.model';
import { ClientsService } from 'src/app/services/clients.service';
import { NgxMaskPipe } from 'ngx-mask';
import { DatePipe } from '@angular/common';
import { MatPaginator } from '@angular/material/paginator';
import { MatDialog, MatDialogRef, MatDialogModule } from '@angular/material/dialog';

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

  @ViewChild('confirmModal')
  confirmModal: TemplateRef<any>;

  @ViewChild('findModal')
  findModal: TemplateRef<any>;


  cpfMask = '000.000.000-00';
  dateMask = 'dd/MM/yyyy';

  clientForm = this.fb.group({
    id: [null],
    name: [null, Validators.required],
    cpf: [null],
    birthDate: [null],
    registerDate: [''],
  });

  clientFilter = this.fb.group({
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

  constructor(private fb: FormBuilder, private service: ClientsService, private maskPipe: NgxMaskPipe, private datePipe: DatePipe, private dialog: MatDialog) {

  }

  ngOnInit(): void {
    this.loadTable(new Client());
  }

  onSubmit() {
    this.service.postClient(this.clientForm.value).subscribe(viewForm => {
      this.loadTable(new Client());
      this.clear();
    });
  }

  find(){
    this.loadTable(Object.assign(new Client, this.clientFilter.value));
    this.dialog.closeAll();
  }

  clear() {
    this.clientForm.reset();
  }

  alter() {
    this.service.alterClient(this.clientForm.value).subscribe(viewForm => {
      this.loadTable(new Client());
      this.clear();
    });
  }

  delete() {
    this.openModal(this.confirmModal, '350px', 'null');
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

  loadTable(filter: Client) {
    this.service.listClients(filter).subscribe(viewForm => {
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

  openModal(templateRef: any, width: string, height: string) {
    let dialogRef = this.dialog.open(templateRef, {
      width: width,
      height: height
    });

    dialogRef.afterClosed().subscribe(confirmed => {
      console.log(confirmed);
    });
  }

  onConfirmDeleteModalClick(): void {
    this.service.deleteClient(this.clientForm.value.id).subscribe(viewForm => {
      this.loadTable(new Client());
    });
    this.dialog.closeAll();
  }

}
