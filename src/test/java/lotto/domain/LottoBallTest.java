package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoBallTest {
    @Test
    void 로또_번호로_1보다_작은수가_들어왔을경우() {
        assertThrows(InvalidNumberException.class, () -> new LottoNo(0));
    }

    @Test
    void 로또_번호로_45보다_작은수가_들어왔을경우() {
        assertThrows(InvalidNumberException.class, () -> new LottoNo(46));
    }
}