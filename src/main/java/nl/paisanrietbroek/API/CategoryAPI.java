package nl.paisanrietbroek.API;

import nl.paisanrietbroek.Model.Category;
import nl.paisanrietbroek.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by paisanrietbroek on 21/04/2018.
 */

@RestController
@RequestMapping("/category")
public class CategoryAPI {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/create")
    public boolean createCategory(@RequestBody HashMap<String, String> body) throws IOException {
        return categoryService.createCategory(body);
    }

    @GetMapping("/")
    public Category getCategoryById(@RequestHeader HashMap<String, String> body) throws IOException {
        return categoryService.getCategory(body);
    }

    @DeleteMapping("/delete")
    public boolean deleteCategory(@RequestBody HashMap<String, String> body) throws IOException {
        return categoryService.deleteCategory(body);
    }

    @PutMapping("update")
    public boolean updateCategory(@RequestBody HashMap<String, String> body) throws IOException {
        return categoryService.updateCategory(body);
    }
}
