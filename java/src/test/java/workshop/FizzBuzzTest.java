package workshop;

import workshop.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class FizzBuzzTest {
    FizzBuzz fizzBuzz;

    public void  initializer (){
        PatternMatcher patternMatcher =new FizzPatternMatcher() ;
        PatternMatcher buzzPatternMatcher =new BuzzPatternMatcher() ;
        PatternMatcher nullObject=new NullResponse();
        List <PatternMatcher> list=new ArrayList<>();
        list.add(patternMatcher);
        list.add(buzzPatternMatcher);
        fizzBuzz=new FizzBuzz(list,nullObject);

    }




    @Test
    public void returnsANumber() {
        initializer();
        assertEquals("1", fizzBuzz.say(1));
        assertEquals("4", fizzBuzz.say(4));
        assertEquals("7", fizzBuzz.say(7));
    }

    @Test
    public void factorOf3() {
        initializer();
        assertEquals("Fizz", fizzBuzz.say(3));
        assertEquals("Fizz", fizzBuzz.say(6));
        assertEquals("Fizz", fizzBuzz.say(9));
    }

    @Test
    public void factorOf5() {
        initializer();
        assertEquals("Buzz", fizzBuzz.say(5));
        assertEquals("Buzz", fizzBuzz.say(10));
        assertEquals("Buzz", fizzBuzz.say(20));
    }

    @Test
    public void factorOf3And5() {
        initializer();
        assertEquals("FizzBuzz", fizzBuzz.say(15));
        assertEquals("FizzBuzz", fizzBuzz.say(30));
        assertEquals("FizzBuzz", fizzBuzz.say(60));
    }
}