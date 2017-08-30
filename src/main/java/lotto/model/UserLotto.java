package lotto.model;

import java.util.Collections;
import java.util.List;

import lotto.model.Result.Match;

public class UserLotto {
    public static final int MONEY_PER_TICKET = 1000;
    
    private List<Integer> lotto;

    public UserLotto(List<Integer> lotto) {
        Collections.sort(lotto);
        this.lotto = lotto;
    }
    
    public List<Integer> getLotto() {
		return lotto;
	}

	public Match countOfMatch(WinningLotto winningLotto) {
        return winningLotto.countOfMatch(lotto);
    }
    
    @Override
    public String toString() {
        return "Lotto [lotto=" + lotto + "]";
    }

	public static int getMoneyPerTicket() {
		return MONEY_PER_TICKET;
	}

	public void setLotto(List<Integer> lotto) {
		this.lotto = lotto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lotto == null) ? 0 : lotto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLotto other = (UserLotto) obj;
		if (lotto == null) {
			if (other.lotto != null)
				return false;
		} else if (!lotto.equals(other.lotto))
			return false;
		return true;
	}
	
    
}
