package nl.paisanrietbroek.Model;

import lombok.Data;

/**
 * Created by paisanrietbroek on 21/04/2018.
 */

@Data
public class Question {
    private int id;
    private String question;
    private String answer;
    private boolean passed;
}
