package com.tracker.LastSeen.controller;

import com.tracker.LastSeen.service.LastSeenCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LastSeenController {

    @Autowired
    private LastSeenCalculatorService lastSeenCalculatorService;

    @RequestMapping(value = "/last-seen", method = RequestMethod.GET)
    public String getLastSeen (@RequestParam(required = true) String lastSeenDateTime) {
        return lastSeenCalculatorService.calculateDaysDifference(lastSeenDateTime);
    }
}
