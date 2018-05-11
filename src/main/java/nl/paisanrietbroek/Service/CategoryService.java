package nl.paisanrietbroek.Service;

import nl.paisanrietbroek.DAO.ICategoryDAO;
import nl.paisanrietbroek.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by paisanrietbroek on 21/04/2018.
 */
@Service
public class CategoryService {

    @Autowired
    private ICategoryDAO categoryDAO;

    @Autowired
    private LogToFile logToFile;

    public List<Category> getAllCategories() {
        return categoryDAO.findAll();
    }

    public Category createCategory(HashMap<String, String> body) throws IOException {
        Category category = Category.builder()
                .name(body.get("name"))
                .build();

        try {
            return categoryDAO.save(category);

        } catch (PersistenceException e) {
            logToFile.logWarningToFile(e.getMessage());
        }
        return null;
    }

    public Category getCategory(HashMap<String, String> body) throws IOException {

        try {
            int id = Integer.parseInt(body.get("id"));
            return categoryDAO.getOne(id);
        } catch (PersistenceException e) {
            logToFile.logWarningToFile(e.getMessage());
        }
        return null;
    }

    public boolean deleteCategory(HashMap<String, String> body) throws IOException {

        boolean result = false;

        try {
            int id = Integer.parseInt(body.get("id"));
            Category category = categoryDAO.getOne(id);
            categoryDAO.delete(category);
            result = true;
        } catch (PersistenceException e) {
            logToFile.logWarningToFile(e.getMessage());
        }
        return result;
    }

    public Category updateCategory(HashMap<String, String> body) throws IOException {

        try {
            int id = Integer.parseInt(body.get("id"));
            Category one = categoryDAO.getOne(id);
            one.setName(body.get("name"));
            return categoryDAO.save(one);

        } catch (PersistenceException e) {
            logToFile.logWarningToFile(e.getMessage());
        }

        return null;
    }
}
