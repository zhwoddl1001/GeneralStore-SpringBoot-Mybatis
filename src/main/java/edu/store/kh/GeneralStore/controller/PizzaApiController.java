import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaApiController {



    @GetMapping("/pizzas")
    public void getAllPizzas() {

    }

    @PostMapping("/pizzas")
    public  void createPizza() {

        return ;
    }
}
