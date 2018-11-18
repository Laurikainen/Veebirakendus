package TronGame.Tron.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SudokuController {
    @RequestMapping(value = "/play_game", method = RequestMethod.GET)
    public String getPlay() { return "play_game"; }

    @RequestMapping(value = "/play_game", method = RequestMethod.POST)
    public String sudoku(@RequestParam("sudoku") String[] sudoku, Model model) {
        Integer[] kontrollitav = {5,3,4,6,7,8,9,1,2,6,7,2,1,9,5,3,4,8,1,9,8,
        3,4,2,5,6,7,8,5,9,7,6,1,4,2,3,4,2,6,8,5,3,7,9,1,7,1,3,9,2,4,8,5,6,
        9,6,1,5,3,7,2,8,4,2,8,7,4,1,9,6,3,5,3,4,5,2,8,6,1,7,9};
        Integer i = 0;
        for(String element : sudoku) {
            System.out.println(element);
            System.out.println(kontrollitav[i]);
            if (!kontrollitav[i].toString().equals(element)) {
                model.addAttribute("incorrect", true);
                return "play_game";
            }
            i+=1;
        }
        model.addAttribute("correct", true);
        return "play_game";
    }
}
