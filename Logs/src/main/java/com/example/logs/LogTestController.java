package com.example.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogTestController {

    static final Logger logger = LoggerFactory.getLogger(LogTestController.class);

    @GetMapping("/trace")
    public String getTrace(){
        logger.trace("The TRACE information is recorded");
        logger.debug("The DEBUG information is recorded");
        logger.info("The INFO information is recorded");
        logger.warn("The WARN information is recorded");
        logger.error("The ERROR information is recorded");
        return "the Trace log";
    }

    @GetMapping("/debug")
    public String getDebug(){
        logger.trace("The TRACE information is recorded");
        logger.debug("The DEBUG information is recorded");
        logger.info("The INFO information is recorded");
        logger.warn("The WARN information is recorded");
        logger.error("The ERROR information is recorded");
        return "the Debug log";
    }

    @GetMapping("/info")
    public String getInfo(){
        logger.trace("The TRACE information is recorded");
        logger.debug("The DEBUG information is recorded");
        logger.info("The INFO information is recorded");
        logger.warn("The WARN information is recorded");
        logger.error("The ERROR information is recorded");
        return "the Info log";
    }

    @GetMapping("/warn")
    public String getWarn(){
        logger.trace("The TRACE information is recorded");
        logger.debug("The DEBUG information is recorded");
        logger.info("The INFO information is recorded");
        logger.warn("The WARN information is recorded");
        logger.error("The ERROR information is recorded");
        return "the Warn log";
    }

    @GetMapping("/error")
    public String getError(){
        logger.trace("The TRACE information is recorded");
        logger.debug("The DEBUG information is recorded");
        logger.info("The INFO information is recorded");
        logger.warn("The WARN information is recorded");
        logger.error("The ERROR information is recorded");
        return "the Error log";
    }
}
