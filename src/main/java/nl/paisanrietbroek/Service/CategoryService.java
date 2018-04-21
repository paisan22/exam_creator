package nl.paisanrietbroek.Service;

import nl.paisanrietbroek.DAO.CategoryDAO;
import nl.paisanrietbroek.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by paisanrietbroek on 21/04/2018.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    public ArrayList<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

}
