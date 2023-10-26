import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientsModule } from './pages/clients/clients.module';
import { TemplateModule } from './template/template.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ClientsService } from './services/clients.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { IConfig, provideEnvironmentNgxMask } from 'ngx-mask';


const maskConfig: Partial<IConfig> = {
  validation: false,
};

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ClientsModule,
    TemplateModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [
    ClientsService,
    provideEnvironmentNgxMask(maskConfig) 
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
