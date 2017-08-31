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
        if(values.length != 6) {
			throw new InvalidLottoException("6개의 숫자를 입력 해 주세요.");
		}
        List<Integer> lotto = new ArrayList<>();
        for (String value : values) {
			int num = Integer.parseInt(value.trim());
			if(num > 45 | num < 0) {
				throw new InvalidLottoException("1~45의 숫자를 입력 해 주세요.");
			}
			if( lotto.contains(num)) {
				throw new InvalidLottoException("중복 된 숫자가 있습니다.");
			}
            lotto.add(Integer.parseInt(value.trim()));
        }
        Collections.sort(lotto);
        this.lotto = lotto;
        this.bonusNumber = Integer.parseInt(bonusNumber);
        if(lotto.contains(this.bonusNumber) || this.bonusNumber > 45 | this.bonusNumber < 1) {
    		throw new InvalidLottoException("보너스 번호를 잘못 입력 하셨습니다.");
    }
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
