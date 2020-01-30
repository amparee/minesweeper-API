import { Component, OnInit } from '@angular/core';
import { GameService } from 'src/app/services/game.service';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {

  constructor(private gameService: GameService) { }

  ngOnInit() {
  }

  enviar() {
    alert('llegue');
    alert(this.gameService.newGame(4, 4, 1).subscribe(res => console.log(res), error => console.log(error)));
  }

}