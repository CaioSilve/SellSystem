import { Injectable, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TemplateModule } from './template/template.module';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { ClientsService } from './services/clients.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { IConfig, provideEnvironmentNgxMask } from 'ngx-mask';
import { LoginComponent } from './pages/login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { LayoutComponent } from './layout/layout.component';
import { PagesModule } from './pages/pages.module';
import { AppService } from './services/app.service';
import { UsersService } from './services/users.service';


const maskConfig: Partial<IConfig> = {
  validation: false,
};

@Injectable()
export class XhrInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const xhr = req.clone({
      headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
    });
    return next.handle(xhr);
  }
}

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    LoginComponent,
    LayoutComponent
  ],
  imports: [
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    PagesModule,
    TemplateModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [
    ClientsService,
    UsersService,
    AppService,
    provideEnvironmentNgxMask(maskConfig), { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

