import { Board } from './board';

export class Game {
    minesLeft: number;
    flags: number;
    inGame: boolean;
    board: Board;
    timeElapsed: number;
    notRevealed: number;
}