package controller;

import domain.Game;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/game")
public class GameController {
    
    private Game game;

    @RequestMapping(method = RequestMethod.GET)
    public String initGame(Model model){
        model.addAttribute("game", new Game());
        return "startGame";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid Game game, BindingResult result, Model model){
        if(result.hasErrors())
            return "startGame";
        
        this.game = game;
        game.startGame();
        return "game";
    }
}
