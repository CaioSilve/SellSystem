import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientsFormComponent } from './clients-form/clients-form.component';

const routes: Routes = [
  {path: 'clients', component: ClientsFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientsRoutingModule { }
