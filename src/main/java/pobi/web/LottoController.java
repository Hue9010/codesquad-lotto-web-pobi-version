package pobi.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lotto.model.InvalidLottoException;
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
		
		try {
			lottos = LottoGenerator.generateByMoney(inputMoney, manualNumber);
		} catch(InvalidLottoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			model.addAttribute("err", e.getMessage());
			return "index";
		} catch(NumberFormatException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			model.addAttribute("err", e.getMessage());
			return "index";
		}
		model.addAttribute("lottos", lottos.getLottos());
		model.addAttribute("size", lottos.count());
		return "show";
	}

	@PostMapping("/matchLotto")
	public String show(String winningNumber, String bonusNumber, Model model) {
		WinningLotto winningLotto = null;
		try {
			winningLotto = new WinningLotto(winningNumber, bonusNumber);
		} catch(InvalidLottoException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			model.addAttribute("lottos", lottos.getLottos());
			model.addAttribute("size", lottos.count());
			model.addAttribute("err", e.getMessage());
			return "show";
		} catch(NumberFormatException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			model.addAttribute("lottos", lottos.getLottos());
			model.addAttribute("size", lottos.count());
			model.addAttribute("err", e.getMessage());
			return "show";
		}
		Result result = lottos.match(winningLotto);
		ResultDto resultDto = ResultDto.fromResult(result);
		model.addAttribute("result", resultDto);
		return "result";
	}
}
