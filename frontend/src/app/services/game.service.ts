import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};



@Injectable({
  providedIn: 'root'
})
export class GameService {

  public GAME_API = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  newGame(x: number, y: number, mines: number): Observable<any> {
    return this.http.get(this.GAME_API + '/game/new-game/' + x + '/' + y + '/' + mines);
  }


}
