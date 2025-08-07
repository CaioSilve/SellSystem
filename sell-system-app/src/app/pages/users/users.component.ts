import { AfterViewInit, Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ViewForm } from 'src/app/commons/view-form.model';
import { User } from './user.model';
import { UsersService } from 'src/app/services/users.service';
import { NgxMaskPipe } from 'ngx-mask';
import { DatePipe } from '@angular/common';
import { MatPaginator } from '@angular/material/paginator';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

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
  
    userForm = this.fb.group({
      id: [null],
      name: [null, Validators.required],
      cpf: [null],
      birthDate: [null],
      registerDate: [''],
    });
  
    userFilter = this.fb.group({
      id: [null],
      name: [null, Validators.required],
      cpf: [null],
      birthDate: [null],
      registerDate: [''],
    });
  
  
    shownedRows: number[] = [];
    shownedButtons: number[] = [];
    disabledButtons: number[] = [];
    viewForm: ViewForm = new ViewForm;
    users: MatTableDataSource<User>;
    columns: any[] = [];
    pageSize: any;
    displayedColumns: string[] = [];
  
    constructor(private fb: FormBuilder, private service: UsersService, private maskPipe: NgxMaskPipe, private datePipe: DatePipe, private dialog: MatDialog) {
  
    }
  
    ngOnInit(): void {
      this.loadTable(new User());
    }
  
    buttonClick(action: any){
      eval(action);
    }
  
    submit() {
      this.service.postUser(this.userForm.value).subscribe(viewForm => {
        this.loadTable(new User());
        this.clear();
      });
    }
  
    find() {
      this.loadTable(Object.assign(new User, this.userFilter.value));
      this.dialog.closeAll();
    }
  
    clear() {
      this.userForm.reset();
      this.loadTable(new User());
    }
  
    alter() {
      this.service.alterUser(this.userForm.value).subscribe(viewForm => {
        this.loadTable(new User());
        this.clear();
      });
    }
  
    delete() {
      this.openModal(this.confirmModal, '350px', 'null');
    }
  
    select(selected: any) {
      this.userForm.patchValue(selected);
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
        default:
          return row[column.prop]
      }
    }
  
    applyFilter(filterValue: string) {
      this.users.filter = filterValue.trim().toLowerCase();
  
      if (this.users.paginator) {
        this.users.paginator.firstPage();
      }
    }
  
    loadTable(filter: User) {
      this.service.listUsers(filter).subscribe(viewForm => {
        console.log(viewForm.view);
        this.viewForm = viewForm;
        this.users = new MatTableDataSource(viewForm.data);
        this.users.sort = this.sort;
        this.users.paginator = this.paginator;
        this.columns = viewForm.view.table.columns;
        this.pageSize = viewForm.view.table.pageSize;
        this.displayedColumns = ['index', ...this.columns.map(function (c: any) {
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
      this.service.deleteUser(this.userForm.value.id).subscribe(viewForm => {
        this.clear();
        this.validateAll();
        this.loadTable(new User());
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
    }

}
