package nl.paisanrietbroek.DAO;

import nl.paisanrietbroek.Model.Category;
import nl.paisanrietbroek.Model.Exame;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by paisanrietbroek on 21/04/2018.
 */

@Service
public class CategoryDAO {

    private ArrayList<Category> categoryArrayList;

    public CategoryDAO() {
        this.categoryArrayList = new ArrayList<>();

        Exame exame = new Exame();
        exame.setName("test exame");

        Exame exame2 = new Exame();
        exame2.setName("test2 exame");

        ArrayList<Exame> exames = new ArrayList<>();
        exames.add(exame);
        exames.add(exame2);

        Category category = new Category();
        category.setName("category1");
        category.setExameArrayList(exames);

        Category category2 = new Category();

        categoryArrayList.add(category);
        categoryArrayList.add(category2);

    }

    public ArrayList<Category> getAllCategories() {
        return this.categoryArrayList;
    }
}
