package code.frenzy.resume.matcher.controller;

import code.frenzy.resume.matcher.model.SearchOutput;
import code.frenzy.resume.matcher.model.SearchParam;
import code.frenzy.resume.matcher.service.ResumeJobService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resume-job-matcher")
public class ResumeJobController {

    private static final Logger LOGGER = LogManager.getLogger(ResumeJobController.class);

    private  final ResumeJobService resumeJobService;

    public ResumeJobController(ResumeJobService resumeJobService) {
        this.resumeJobService = resumeJobService;
    }

    @PostMapping("/match")
    public ResponseEntity<SearchOutput> matchResumeOrJob(SearchParam searchParam)
    {
        LOGGER.info("matchResumeOrJob() started");
        LOGGER.info("Search parameters: {}",searchParam);
        SearchOutput searchOutput = this.resumeJobService.match(searchParam);

        LOGGER.info("matchResumeOrJob() completed");
        return new ResponseEntity<>(searchOutput, HttpStatus.OK);
    }
    @GetMapping("/ping")
    public String ping(){
        return "Ping is working";
    }
}
