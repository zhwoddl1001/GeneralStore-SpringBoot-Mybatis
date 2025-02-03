/**
 * ViewController는 HTML 파일의 경로를 반환
 */
@Controller
public class PizzaViewController {

    /**
     * 메뉴 목록 페이지
     * URL: /pizzas
     * 반환: pizzas.html
     */
    @GetMapping("/pizzas")
    public String showPizzaList() {
        return "pizzas"; // src/main/resources/templates/pizzas.html
    }

    /**
     * 메뉴 추가 페이지
     * URL: /pizzas/add
     * 반환: add-pizza.html
     */
    @GetMapping("/pizzas/add")
    public String showAddPizzaForm() {
        return "add-pizza"; // src/main/resources/templates/add-pizza.html
    }

    /**
     * 메뉴 상세보기 페이지
     * URL: /pizzas/detail?id={id}
     * 반환: pizza-detail.html
     */
    @GetMapping("/pizzas/detail")
    public String showPizzaDetail(@RequestParam("id") int id) {
        // pizza-detail.html에서 id를 URL 파라미터로 사용
        return "pizza-detail"; // src/main/resources/templates/pizza-detail.html
    }

    /**
     * 메뉴 수정 페이지
     * URL: /pizzas/edit?id={id}
     * 반환: edit-pizza.html
     */
    @GetMapping("/pizzas/edit")
    public String showEditPizzaForm(@RequestParam("id") int id) {
        // edit-pizza.html에서 id를 URL 파라미터로 사용
        return "edit-pizza"; // src/main/resources/templates/edit-pizza.html
    }
}
