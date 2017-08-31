package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
	public static final String NEWLINE = System.getProperty("line.separator");

	public static Lottos generateByMoney(int money, String input){
		if(!(money >= 1000)) {
			throw new InvalidLottoException("천원 이상 및 정상 적인 금액을 입력 하세요.");
		}
		
		int buyingNo = money / UserLotto.MONEY_PER_TICKET;
		ArrayList<UserLotto> lottos = new ArrayList<>();

		if (input.length() > 1) {
			lottos = generateManual(input);
		}
		int manualLottoSize = lottos.size();
		for (int i = 0; i < buyingNo - manualLottoSize; i++) {
			lottos.add(generateAuto());
		}
		return new Lottos(lottos);
	}

	public static UserLotto generateAuto() {
		List<Integer> seed = createSeed();
		Collections.shuffle(seed);
		return new UserLotto(seed.subList(0, 6));
	}

	public static ArrayList<UserLotto> generateManual(String userInput) throws InvalidLottoException, NumberFormatException {
		ArrayList<UserLotto> lottos = new ArrayList<>();

		String[] inputArr = userInput.split(NEWLINE);
		for (String input : inputArr) {
			lottos.add(manualLotto(input));
		}
		return lottos;
	}

	private static UserLotto manualLotto(String input) throws NumberFormatException{
		List<Integer> userLotto = new ArrayList<>();
		String[] numbers = input.split(",");
		if(numbers.length != 6) {
			throw new InvalidLottoException("6개의 숫자를 입력 해 주세요.");
		}
		for (String number : numbers) {
			int num = Integer.parseInt(number.trim());
			if(num > 45 | num < 0) {
				throw new InvalidLottoException("1~45의 숫자를 입력 해 주세요.");
			}
			if( userLotto.contains(num)) {
				throw new InvalidLottoException("중복 된 숫자가 있습니다.");
			}
			userLotto.add(num);
		}
		return new UserLotto(userLotto);
	}

	private static List<Integer> createSeed() {
		return IntStream.range(1, 46).boxed().collect(Collectors.toList());
	}
}
