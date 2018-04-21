package nl.paisanrietbroek.Model;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by paisanrietbroek on 21/04/2018.
 */

@Data
public class Exame {

    private int id;

    private int categoryId;

    private String name;

    private ArrayList<Question> questionArrayList;
}
