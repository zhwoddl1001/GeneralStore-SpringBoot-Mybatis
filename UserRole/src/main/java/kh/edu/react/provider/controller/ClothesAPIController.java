package kh.edu.react.provider.controller;
import kh.edu.react.provider.dto.Clothes;
import kh.edu.react.provider.service.ClothesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/clothes")
public class ClothesAPIController {

    @Autowired
    private ClothesServiceImpl clothesService;

    @GetMapping
    public List<Clothes> getAllClothes() {
        return clothesService.getAllClothes();
    }

    // -parameters 라는 문구가 보이면 sql 컬럼명, dto 명칭과 매개변수 명칭이 일치하는지 확인
    @GetMapping("/{cId}")
    public Clothes getClothesById(@PathVariable("cId") int cId) {
        return clothesService.getClothesById(cId);
    }
    @PostMapping
    public void insertClothes(@RequestBody Clothes clothes) {
        if(clothes != null) {
          clothesService.insertClothes(clothes);

        } else {
            System.out.println("############ Clothes is null ############ ");
            System.out.println(clothes.toString());
        }
        //clothesService.insertClothes(clothes);
        //System.out.println("받은 데이터: " + clothes);
    }


    /*

    @PostMapping
    public void insertClothes(@RequestBody Clothes clothes) {
        clothesService.insertClothes(clothes);
        System.out.println("받은 데이터: " + clothes);
    }
*/
    @PutMapping
    public void updateClothes(@RequestBody Clothes clothes) {
        clothesService.updateClothes(clothes);
    }

    @DeleteMapping("/{id}")
    public void deleteClothes(@PathVariable int id) {
        clothesService.deleteClothes(id);
    }
}
