package lotto;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import lotto.model.LottoGenerator;
import lotto.model.Lottos;
import lotto.model.UserLotto;

public class lottoTest {

	@Test
	public void manualInput() {
//		Lottos lottos = null;
//		Lottos myLottos = null;
//		UserLotto myLotto = new UserLotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
//		UserLotto myLotto2 = new UserLotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
//		List<UserLotto> users = new ArrayList<>();
//		users.add(myLotto);
//		users.add(myLotto2);
//		myLottos = new Lottos(users);
//		String userInput = "1,2,3,4,5,6\n1,2,3,4,5,6";
//		
////		lottos = LottoGenerator.generateManual(userInput);
//		
//		assertEquals(lottos,myLottos);
	}
	
	@Test
	public void bonusNumberTest() throws Exception {
		String string = "";
		String[] st = string.split("\n");
		System.out.println(st.length);
	}
}
