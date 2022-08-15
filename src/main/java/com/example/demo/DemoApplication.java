package com.example.demo;

import com.tidal.spring.filters.annotations.EnableLogRequestResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@SpringBootApplication
//@EnableLogRequestResponse
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RestController
    @RequestMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public static class resourceNameController {

        public resourceNameController() {
            log.info("oi");
        }

        @PostMapping(path = "/feedback")
        public ResponseEntity<String> handleNonBrowserSubmissions(Optional<Feedback> feedback,
		                                                          @RequestParam(required = false) String myextra,
		                                                          @RequestParam(required = false) String hello)
		        throws Exception {
            // Save feedback data
            return new ResponseEntity<String>("Thank you for submitting feedback", HttpStatus.OK);
        }
    }

    // @Bean
    // public CommonsRequestLoggingFilter logFilter() {
    // 	CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();

    // 	filter.setIncludeQueryString(true);
    // 	filter.setIncludePayload(true);
    // 	filter.setMaxPayloadLength(10000);
    // 	filter.setIncludeHeaders(true);
    // 	filter.setIncludeClientInfo(true);

    // 	return filter;
    // }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Feedback {
        private String emailId;
        private String comment;
        private String myextra;
        private String hello;
    }

}
