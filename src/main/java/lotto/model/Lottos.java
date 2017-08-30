package lotto.model;

import java.util.List;

public class Lottos {
    private List<UserLotto> lottos;

    public Lottos(List<UserLotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    public Result match(WinningLotto winningLotto) {
        Result result = new Result(lottos.size());
        for (UserLotto userLotto : lottos) {
            result.add(userLotto.countOfMatch(winningLotto));
        }
        return result;
    }
    
    public List<UserLotto> getLottos() {
		return lottos;
	}

	@Override
    public String toString() {
        return "Lottos [lottos=" + lottos + "]";
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lottos == null) ? 0 : lottos.hashCode());
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
		Lottos other = (Lottos) obj;
		if (lottos == null) {
			if (other.lottos != null)
				return false;
		} else if (!lottos.equals(other.lottos))
			return false;
		return true;
	}
	
}
