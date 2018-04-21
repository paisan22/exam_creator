package nl.paisanrietbroek.Model;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by paisanrietbroek on 21/04/2018.
 */

@Data
public class Category {

    private int id;

    private String name;

    private ArrayList<Exam> examArrayList;

}
