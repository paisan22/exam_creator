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
@CrossOrigin
public class ExamAPI {

    @Autowired
    private ExamService examService;

    @PostMapping
    public boolean createExam(@RequestBody Exam exam) throws IOException {
        return examService.createExam(exam);
    }

    @GetMapping("/all")
    public List<Exam> getAllExams() throws IOException {
        return examService.getAllExams();
    }

    @GetMapping
    public Exam getExamById(@RequestHeader HashMap<String, String> header) {
        return examService.getExamById(header);
    }

    @GetMapping("/by_category")
    public List<Exam> getExamsByCategory(@RequestHeader HashMap<String, String> header) {
        return examService.getExamsByCategory(header);
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
