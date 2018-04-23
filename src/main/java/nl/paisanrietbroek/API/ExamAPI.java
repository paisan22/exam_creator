package nl.paisanrietbroek.API;

import nl.paisanrietbroek.Model.Exam;
import nl.paisanrietbroek.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by paisanrietbroek on 22/04/2018.
 */

@RestController
@RequestMapping("/exam")
public class ExamAPI {

    @Autowired
    private ExamService examService;

    @PostMapping
    public boolean createExam(@RequestBody Exam exam) throws IOException {
        return examService.createExam(exam);
    }

    @GetMapping
    public List<Exam> getAllExams() throws IOException {
        return examService.getAllExams();
    }

    @PutMapping("/update")
    public boolean updateExam(@RequestBody Exam exam) throws IOException {
        return examService.updateExam(exam);
    }

    @DeleteMapping("/delete")
    public boolean deleteExam(@RequestBody HashMap<String, String> body) throws IOException {
        return examService.deleteExame(body);
    }
}
