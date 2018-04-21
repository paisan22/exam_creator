package nl.paisanrietbroek.API;

import nl.paisanrietbroek.Model.Category;
import nl.paisanrietbroek.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by paisanrietbroek on 21/04/2018.
 */

@RestController
@RequestMapping("/category")
public class CategoryAPI {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public ArrayList<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

}
