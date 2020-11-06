# AngularHttp

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 10.1.6.

## The backend Rest web service

This project is running on an Angular presentation server that manages HTML and Javascript code. 
This presentation server receives its data from another web server where a rest web service is running.
This web service should be started first:  

https://github.com/charroux/CorrectionWebServiceJPA

## Angular Development server

Run `npm update` and `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Adding http library

https://github.com/charroux/angular-http/blob/master/src/app/app.module.ts

import { HttpClientModule } from '@angular/common/http';

...

imports: [
    BrowserModule,
    HttpClientModule
  ]

## HTTP requests

https://github.com/charroux/angular-http/blob/master/src/app/car.service.ts

Subsription of the Obervable: this.carService.getCarsWithObservable().subscribe(cars => this.cars = cars); in

https://github.com/charroux/angular-http/blob/master/src/app/cars/cars.component.ts

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
