import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientsComponent } from './clients/clients.component';
import { LayoutComponent } from 'src/app/layout/layout.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UsersComponent } from './users/users.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo:'dashboard'},
  {path: 'clients', component: LayoutComponent, children: [
    {path: '', component: ClientsComponent}
  ]},
  {path: 'users', component: LayoutComponent, children: [
    {path: '', component: UsersComponent}
  ]},
  {path: 'dashboard', component: LayoutComponent, children: [
    {path: '', component: DashboardComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PagesRoutingModule { }
