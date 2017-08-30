package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
	public static final String NEWLINE = System.getProperty("line.separator");

	public static Lottos generateByMoney(int money, String input) throws InvalidLottoException {
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

	public static ArrayList<UserLotto> generateManual(String userInput) throws InvalidLottoException {
		ArrayList<UserLotto> lottos = new ArrayList<>();

		String[] inputArr = userInput.split(NEWLINE);
		for (String input : inputArr) {
			lottos.add(manualLotto(input));
		}
		// return new Lottos(lottos);
		return lottos;
	}

	private static UserLotto manualLotto(String input) {
		List<Integer> userLotto = new ArrayList<>();
		String[] numbers = input.split(",");
		for (String number : numbers) {
			userLotto.add(Integer.parseInt(number.trim()));
		}
		return new UserLotto(userLotto);
	}

	private static List<Integer> createSeed() {
		return IntStream.range(1, 46).boxed().collect(Collectors.toList());
	}
}
