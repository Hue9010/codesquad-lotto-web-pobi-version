package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.model.Result.Match;

public class WinningLotto {
    private List<Integer> lotto;
    private int bonusNumber;

    public WinningLotto(String lottoNo) {
        String[] values = lottoNo.split(",");
        List<Integer> lotto = new ArrayList<>();
        for (String value : values) {
            lotto.add(Integer.parseInt(value.trim()));
        }
        Collections.sort(lotto);
        this.lotto = lotto;
    }
    
    public WinningLotto(String lottoNo, String bonusNumber) {
        String[] values = lottoNo.split(",");
        List<Integer> lotto = new ArrayList<>();
        for (String value : values) {
            lotto.add(Integer.parseInt(value.trim()));
        }
        Collections.sort(lotto);
        this.lotto = lotto;
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }
    
    public Match countOfMatch(List<Integer> lotto) {
        List<Integer> result = new ArrayList<>(lotto);
        result.retainAll(this.lotto);

        if (result.size() < 3) {
            return null;
        }
        if( result.size() == 5 && lotto.contains(bonusNumber)) {
        		return Match.valueOf(7);
        }
        return Match.valueOf(result.size());
    }
    
}
