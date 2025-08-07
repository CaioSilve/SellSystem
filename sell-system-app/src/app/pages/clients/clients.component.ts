import { AfterViewInit, Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ViewForm } from 'src/app/commons/view-form.model';
import { Client } from './client.model';
import { ClientsService } from 'src/app/services/clients.service';
import { NgxMaskPipe } from 'ngx-mask';
import { DatePipe } from '@angular/common';
import { MatPaginator } from '@angular/material/paginator';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

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
  cellphoneMask = '(00) 0 0000-0000';

  customPatterns = {'A': { pattern: new RegExp('\[a-z0-9.\]')}};
  
  clientForm = this.fb.group({
    id: [null],
    name: [null, Validators.required],
    cpf: [null],
    birthDate: [null],
    registerDate: [''],
    email: [null],
    cellphone: [null],
    address: [null],
    numberAddress: [null],
    observation: [null]
  });

  clientFilter = this.fb.group({
    id: [null],
    name: [null, Validators.required],
    cpf: [null],
    birthDate: [null],
    registerDate: [''],
    email: [null],
    cellphone: [null],
    address: [null],
    numberAddress: [null],
    observation: [null]
  });


  shownedRows: number[] = [];
  shownedButtons: number[] = [];
  shownedValidations: string[] = [];
  disabledButtons: number[] = [];
  viewForm: ViewForm = new ViewForm;
  clients: MatTableDataSource<Client>;
  columns: any[] = [];
  pageSize: any;
  displayedColumns: string[] = [];

  constructor(private fb: FormBuilder, private service: ClientsService, private maskPipe: NgxMaskPipe, private datePipe: DatePipe, private dialog: MatDialog) {

  }

  ngOnInit(): void {
    this.loadTable(new Client());
  }

  buttonClick(action: any){
    eval(action);
  }

  submit() {
    this.service.postClient(this.clientForm.value).subscribe(viewForm => {
      this.loadTable(new Client());
      this.clear();
    });
  }

  find() {
    this.loadTable(Object.assign(new Client, this.clientFilter.value));
    this.dialog.closeAll();
  }

  clear() {
    this.clientForm.reset();
    this.loadTable(new Client());
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
    this.validateAll();
  }

  validatePipe(row: any, column: any): any {
    switch (column.prop) {
      case 'cpf':
        return this.maskPipe.transform(row[column.prop], this.cpfMask);
      case 'birthDate':
        return this.datePipe.transform(row[column.prop], this.dateMask);
      case 'registerDate':
        return this.datePipe.transform(row[column.prop], this.dateMask);
      // case 'cellphone':
      //   return this.maskPipe.transform(row[column.prop], this.cellphoneMask);
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
      console.log(viewForm.view);
      this.viewForm = viewForm;
      this.clients = new MatTableDataSource(viewForm.data);
      this.clients.sort = this.sort;
      this.clients.paginator = this.paginator;
      this.columns = viewForm.view.table.columns;
      this.pageSize = viewForm.view.table.pageSize;
      this.displayedColumns = ['index', ...this.columns.filter((c) => c.active == true).map(function (c: any) {
        return c.prop;
      })];
      this.validateAll();
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
      this.clear();
      this.validateAll();
      this.loadTable(new Client());
    });
    this.dialog.closeAll();
  }

  validateShownedRows() {
    this.shownedRows = [];
    this.viewForm.view.rows.forEach((row: any) => {
      if (row.condition == null || (row.condition != null && eval(row.condition)))
        this.shownedRows.push(row.orderRow);
    });
  }

  validateShownedButtons() {
    this.shownedButtons = [];
    this.viewForm.view.buttons.forEach((button: any) => {
      if (button.condition == null || (button.condition != null && eval(button.condition)))
        this.shownedButtons.push(button.orderButton);
    });
  }

  validateShownedValidations() {
    this.shownedValidations = [];
    this.viewForm.view.rows.forEach((row: any) => {
      row.fields.forEach((field: any) => {
        field.listValidationLabels.forEach((validation: any) => {
          if (validation.condition == null || (validation.condition != null && eval(validation.condition)))
            this.shownedValidations.push(validation.keyValidation);
        });
      });
    });
  }

  validateDisabledButtons(){
    this.disabledButtons = [];
    this.viewForm.view.buttons.forEach((button: any) => {
      if (button.disable != null && eval(button.disable))
        this.disabledButtons.push(button.orderButton);
    });
  }

  validateAll(){
    this.validateDisabledButtons();
    this.validateShownedButtons();
    this.validateShownedRows();
    this.validateShownedValidations();
  }

  

}
