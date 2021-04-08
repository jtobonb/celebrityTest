package com.celebrity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public List<String> getCelebrity(List<Person> people){
        Map<String, Integer> map = new HashMap<>();
        people.stream()
            .map(p -> {
                p.getPeople().stream().map(q -> {
                    map.put(q.getName(), map.getOrDefault(q.getName(), 0) + 1);
                    return p;
                }).reduce((u, v) -> v);
                return p;
            }).reduce((u, v) -> v);

        List<Person> pe = people.stream()
                .filter(p -> p.getPeople().size() == 0)
                .collect(Collectors.toList());

        return pe.stream()
                .filter(p -> map.get(p.getName()).intValue() == people.size()-pe.size())
                .map(p -> p.getName())
                .collect(Collectors.toList());


    }
}
