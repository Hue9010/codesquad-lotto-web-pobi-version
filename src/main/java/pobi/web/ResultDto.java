package pobi.web;

import lotto.model.Result;
import lotto.model.Result.Match;

public class ResultDto {
	private double profits;
	private int countOfLotto;
	private int countOfMatch3;
	private int countOfMatch4;
	private int countOfMatch5;
	private int countOfMatch6;
	private int countOfMatchBonus;

	public double getProfits() {
		return profits;
	}

	public int getCountOfLotto() {
		return countOfLotto;
	}

	public int getCountOfMatch3() {
		return countOfMatch3;
	}

	public int getCountOfMatch4() {
		return countOfMatch4;
	}

	public int getCountOfMatch5() {
		return countOfMatch5;
	}

	public int getCountOfMatch6() {
		return countOfMatch6;
	}
	
	public int getCountOfMatchBonus() {
		return countOfMatchBonus;
	}

	public static ResultDto fromResult(Result result) {
		ResultDto resultDto = new ResultDto();
		resultDto.profits = result.getProfit();
		resultDto.countOfLotto = result.getCountOfLotto();
		resultDto.countOfMatch3 = result.getCountOfMatchingLotto(Match.MATCH3);
		resultDto.countOfMatch4 = result.getCountOfMatchingLotto(Match.MATCH4);
		resultDto.countOfMatch5 = result.getCountOfMatchingLotto(Match.MATCH5);
		resultDto.countOfMatch6 = result.getCountOfMatchingLotto(Match.MATCH6);
		resultDto.countOfMatchBonus = result.getCountOfMatchingLotto(Match.MATCHBONUS);
		return resultDto;
	}
}
