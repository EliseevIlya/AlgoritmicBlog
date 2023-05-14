package AlgoritmicBlog.AlgoritmicBlog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("title", "Главная страница");
        return "main";
    }
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", " О нас");
        return "about";
    }


}

