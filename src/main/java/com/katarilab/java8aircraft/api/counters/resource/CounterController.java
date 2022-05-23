package com.katarilab.java8aircraft.api.counters.resource;
import com.katarilab.java8aircraft.SessionTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.*;

@RestController
@RequestMapping("/counters")
public class CounterController {

    private final SessionTemplate sessionTemplate;
    public CounterController(SessionTemplate sessionTemplate){
        this.sessionTemplate = sessionTemplate;
    }

    @GetMapping
    public List<Integer> get(){
        HashMap<Integer, Integer> temporal = new HashMap<>();
        HashMap<Integer, Integer> temp;
        temp = (HashMap<Integer, Integer>)this.sessionTemplate.getAttribute("numbers");

        if (temp != null){
            temporal = temp;
        }

        int stop = temporal.size() + 10;
        for(int i=0; i < stop ; i++){
            temporal.put(i, i);
        }
        this.sessionTemplate.setAttribute("numbers", temporal);
        return new ArrayList<>(temporal.values());
    }    
}