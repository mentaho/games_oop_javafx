package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;

class BishopBlackTest {

    @Test
    void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell expected = Cell.C8;
        assertThat(expected).isEqualTo(bishopBlack.position());
    }

    @Test
    void way() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] way = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(way).isEqualTo(expected);

    }

    @Test
    void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Figure copyOfBishopBlack = bishopBlack.copy(Cell.C8);
        assertThat(bishopBlack.position()).isEqualTo(copyOfBishopBlack.position());
    }
}