import { Cell } from './cell';

export class Board {
    minesLeft: number;
    board: Cell[][];
    cols: number;
    rows: number;
}