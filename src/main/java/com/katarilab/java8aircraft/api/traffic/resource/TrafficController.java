package com.katarilab.java8aircraft.api.traffic.resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/traffic")
public class TrafficController {

    private static final Queue<Long> State = new ConcurrentLinkedQueue<>();

    @GetMapping
    public List<Integer> get(){
        List<Long> copy = new ArrayList<>(TrafficController.State);
        HashMap<Long, Integer> temporal = new HashMap<>();
        for (Long temp: copy) {
            int value = temporal.getOrDefault(temp, -1);
            if ( value != -1 ){
                temporal.put(temp, value + 1);
            }
            else{
                temporal.put(temp, 1);
            }
        }
        List<Integer> result = new ArrayList<>(temporal.values());
        return result.stream().distinct().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

    @PostMapping("/reset")
    public long postReset(){
        TrafficController.State.clear();
        return 0;
    }

    @PostMapping
    public long post(){
        long key = System.currentTimeMillis();
        TrafficController.State.add(key);
        return key;
    }

}