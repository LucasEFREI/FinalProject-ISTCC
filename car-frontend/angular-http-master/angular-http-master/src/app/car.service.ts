import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { Car } from './car';

export const CARS: Car[] = [
  { id: 0, plateNumber: '11AA22', model: 'Ferrari', price: 1500, numberOfDays: 0, rented: false },
  { id: 1, plateNumber: '22BB33', model: 'Porsche', price: 1200, numberOfDays: 0, rented: false },
  { id: 2, plateNumber: '44CC55', model: 'Mac Laren', price: 1000, numberOfDays: 0, rented: false }
];

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private http: HttpClient) {}

  public getCarsWithObservable(): Observable<Car[]> {
    return this.http.get<Car[]>('http://localhost:8080/cars');
  }

  public rent(car): Observable<any> {
    car.rented = true;
    console.warn('Request to: ' + 'http://localhost:8080/cars/' + car.plateNumber + '/rent?louer=true');
    return this.http.put('http://localhost:8080/cars/' + car.plateNumber + '/rent?louer=true', null);
  }

  public getBack(car): Observable<any> {
    car.rented = false;
    console.warn('Request to: ' + 'http://localhost:8080/cars/' + car.plateNumber + '/getback?louer=false');
    return this.http.put('http://localhost:8080/cars/' + car.plateNumber + '/getback?louer=false', null);
  }


}
