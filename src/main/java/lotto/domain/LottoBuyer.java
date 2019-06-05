package lotto.domain;

import java.util.Iterator;
import java.util.List;

public class LottoBuyer {
    private Budget budget;
    private LottoContainer lottos;

    public LottoBuyer(Budget budget) {
        this.budget = budget;
        lottos = new LottoContainer();
    }

    public void buyManualLotto(List<Lotto> lottos) {
        budget.pay(lottos.size());
        this.lottos.addLotto(lottos);
    }

    public void buyAutoLotto() {
        while (budget.canBuyLotto()) {
            budget.pay();
            lottos.addLotto(Lotto.of());
        }
    }

    public List<String> showLottos() {
        return lottos.showLottos();
    }

    public WinningResult checkWinningLotto(WinningLotto winningLotto) {
        WinningResult result = new WinningResult();
        Iterator<Lotto> iter = lottos.iterator();
        while (iter.hasNext()) {
            result.count(iter.next(), winningLotto);
        }
        return result;
    }

    public int getCountOfLottoMatch(LottoType type) {
        int count = 0;
        Iterator<Lotto> iter = lottos.iterator();
        while (iter.hasNext()) {
            count = (iter.next().matchType(type) ? ++count : count);
        }
        return count;
    }

    public void validateAffordability(int countOfManualLotto) {
        if (!budget.canBuyLotto(countOfManualLotto)) {
            throw new NoMoneyException("구입 금액으로 " + countOfManualLotto + "장의 로또를 살 수 없습니다.");
        }
    }
}