package com.illy.kafkatest.controller;

import com.illy.kafkatest.domain.TableMappingProperties;
import com.illy.kafkatest.kafka.multi.NotificationConsumerGroup;
import com.illy.kafkatest.kafka.multi.NotificationProducerThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class TableMappingController {

    @Autowired
    private TableMappingProperties tableMappingProperties;

    @RequestMapping(method = RequestMethod.GET)
    public void getMappingInfo(Model model) {

    }

}
