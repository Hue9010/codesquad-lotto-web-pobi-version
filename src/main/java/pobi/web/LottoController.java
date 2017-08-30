package pobi.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lotto.model.LottoGenerator;
import lotto.model.Lottos;
import lotto.model.Result;
import lotto.model.Result.Match;
import lotto.model.Result.MatchingResult;
import lotto.model.WinningLotto;

@Controller
public class LottoController {
	private Lottos lottos = null;
	public static final String NEWLINE = System.getProperty("line.separator");

	@GetMapping("/")
	public String Home() {
		return "index";
	}

	@PostMapping("/buyLotto")
	public String show(int inputMoney, String manualNumber, Model model) {
		System.out.println(manualNumber);
		System.out.println(manualNumber.split(NEWLINE).length);
		
//		if (manualNumber.length() > 1) {
//			lottos = LottoGenerator.generateManual(manualNumber);
//		} else {
//			lottos = LottoGenerator.generateByMoney(inputMoney);
//		}
		lottos = LottoGenerator.generateByMoney(inputMoney, manualNumber);
		model.addAttribute("lottos", lottos.getLottos());
		model.addAttribute("size", lottos.count());
		return "show";
	}

	@PostMapping("/matchLotto")
	public String show(String winningNumber, String bonusNumber, Model model) {
		WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
		Result result = lottos.match(winningLotto);
		ResultDto resultDto = ResultDto.fromResult(result);
		model.addAttribute("result", resultDto);
		return "result";
	}
}
