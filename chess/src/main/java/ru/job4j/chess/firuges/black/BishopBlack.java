package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }

        int size = Math.abs(dest.getX() - this.position.getX());
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() - this.position.getX();
        int deltaY = dest.getY() - this.position.getY();
        for (int index = 0; index < size; index++) {
            int x = (int) ((index + 1) * Math.signum(deltaX));
            int y = (int) ((index + 1) * Math.signum(deltaY));

            steps[index] = Cell.findBy(this.position.getX() + x, this.position.getY() + y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if (Math.abs(dest.getX() - source.getX()) == Math.abs(dest.getY() - source.getY())) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
