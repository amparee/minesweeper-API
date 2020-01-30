import { Component, OnInit, ChangeDetectorRef, HostListener } from '@angular/core';
import { GameService } from 'src/app/services/game.service';
import { Game } from 'src/app/entities/game';
import { Board } from 'src/app/entities/board';
import { Cell } from 'src/app/entities/cell';
import { TypeCell } from 'src/app/entities/type-cell';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {

  game: Game = new Game();
  board: Board = new Board();
  types = TypeCell;
  time = new Date();

  constructor(private gameService: GameService, private changeDetectorRefs: ChangeDetectorRef) { }

  ngOnInit() {
      setInterval(() => {
       this.time = new Date();
    }, 1000);
  }

  enviar() {
    console.log('llegue');
    this.gameService.newGame(5, 5, 2).subscribe(
      data => {
        console.log(data);
        this.game = data;
        this.board = this.game.board;
        console.log(this.game);
      },
      error => console.log(error)
      );
    console.log('aca');

  }

  alerta() {
    alert('clicked');
  }

  getBackgroundColor(cell: Cell) {
    if (cell.isFlagged) {
      return 'red'; }
    if (cell.revealed) {
      if (cell.type == this.types.BOMB) {
        return 'red';
      } else if (!(cell.type == this.types.FLAG) && !(cell.type == this.types.EMPTY)) {
        return 'blue';
      }
      return 'white';
    } else {
      return 'black';
    }

  }

  sendClick(row: number, col: number) {
    console.log('Row: ' + row + ' - Col:' + col);
    this.gameService.sendClick(row, col).subscribe(res => {
      this.board = res.board;
      this.game = res;
      console.log(res);
    });
    this.changeDetectorRefs.detectChanges();
  }

  saveGame() {
    this.gameService.saveGame().subscribe(res => {
      console.log(res);
    });
  }

  @HostListener('contextmenu', ['$event'])
  onRightClick(event, row, col) {
    event.preventDefault();
    this.gameService.sendRightClick(row, col).subscribe(res => {
      this.board = res.board;
      this.game = res;
      console.log(res);
    });
    this.changeDetectorRefs.detectChanges();
  }
}
