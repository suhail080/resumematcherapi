package code.frenzy.resume.matcher.service;

import code.frenzy.resume.matcher.model.SearchOutput;
import code.frenzy.resume.matcher.model.SearchParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ResumeJobService {

    private static final Logger LOGGER = LogManager.getLogger(ResumeJobService.class);

    @Value("${azure.search.service.url}")
    private String searchApiUrl;

    @Value("${azure.search.api.key}")
    private String searchApiKey;

    public final RestTemplate restTemplate;

    public ResumeJobService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public SearchOutput match(SearchParam searchParam) {


        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("api-key",searchApiKey);
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<SearchParam> entity = new HttpEntity<>(searchParam,headers);
        ResponseEntity<SearchOutput> result = restTemplate.exchange(searchApiUrl, HttpMethod.POST, entity, SearchOutput.class);
        if(result == null)
        {
            LOGGER.info("search result returned null");
        }
        SearchOutput searchOutput = result.getBody();
        LOGGER.info("search output received : {}", searchOutput);
        return searchOutput;
    }
}
