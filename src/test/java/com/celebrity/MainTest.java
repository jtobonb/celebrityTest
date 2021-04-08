package com.celebrity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainTest {

    private Main main;
    private List<Person> team;

    @Before
    public void init(){
        main = new Main();
        team = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            team.add(new Person(String.valueOf(i), new ArrayList<>()));
        }
    }

    @Test
    public void detectOneCelebrityTest(){
        List<Person> peopleList = team.stream()
                .map(p -> {
                    if(!p.getName().equals("4")) {
                        p.getPeople().add(team.get(4));
                        p.getPeople().add(team.get(5));
                    }
                    return p;
                }).collect(Collectors.toList());

        List<String> test = main.getCelebrity(peopleList);

        Assert.assertEquals( 1, test.size());
        Assert.assertEquals( "4", test.get(0));
    }

    @Test
    public void detectTwoCelebrityTest(){
        List<Person> peopleList = team.stream()
                .map(p -> {
                    if(!p.getName().equals("2") && !p.getName().equals("3") ) {
                        p.getPeople().add(team.get(2));
                        p.getPeople().add(team.get(3));
                    }
                    return p;
                }).collect(Collectors.toList());

        List<String> test = main.getCelebrity(peopleList);

        Assert.assertEquals( 2, test.size());
        Assert.assertEquals("2", test.get(0));
        Assert.assertEquals("3", test.get(1));
    }

    @Test
    public void detectOneCelebrityWithPersonTest(){
        List<Person> peopleList = team.stream()
                .map(p -> {
                    if(!p.getName().equals("2")) {
                        p.getPeople().add(team.get(2));
                        p.getPeople().add(team.get(3));
                    }
                    return p;
                }).collect(Collectors.toList());

        List<String> test = main.getCelebrity(peopleList);

        Assert.assertEquals( 1, test.size());
        Assert.assertEquals("2", test.get(0));
    }
}
