package edu.store.kh.GeneralStore.controller;


import edu.store.kh.GeneralStore.dto.Pizza;
import edu.store.kh.GeneralStore.service.PizzaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RequestMapping("/api")
@RestController
public class PizzaApiController {
    // ServiceImpl -> Autowired 호출
    @Autowired
    private PizzaServiceImpl pizzaService;
    @GetMapping("/pizzas") //   /api/pizzas
    public List<Pizza> selectAll() {
        return pizzaService.selectAll();
    }
    
    // 피자 추가하기
    @PostMapping("/pizzas") //   /api/pizzas
    public int insert(@RequestBody Pizza pizza) {
        return pizzaService.insertPizza(pizza);
    }
    //피자 아이디로 찾아서 보기
    @GetMapping("/pizzas/{id}")
    public Pizza selectPizzaById(@PathVariable int id) {
        return pizzaService.selectById(id);
    }
    
    // 피자 수정하기
    @PutMapping("pizzas/{id}")
    public void updatePizza(
            @PathVariable int id,
            @RequestParam("name") String name,
            @RequestParam("price") int price,
            @RequestParam("description") String description,
            @RequestParam(value = "image", required = false) MultipartFile image) {

    }
    // 피자 지우기
    @DeleteMapping("/pizzas/{id}")
    public void deletePizza(@PathVariable int id) {
        pizzaService.deletePizza(id);
    }
}