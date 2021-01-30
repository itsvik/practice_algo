package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FindAnagrams {

    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        Person a = new Person("A");
        map.put(a, "A");
        Person b = new Person("B");
        map.put(b, "B");
        System.out.println(map.get(a));
        System.out.println(map.get(b));


    }

//    public List<Integer> findAnagrams(String s, String p) {
//        Map<>
//    }

    public static class Person{
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public int hashCode(){
            return 1;
        }

        @Override
        public boolean equals(Object b){
            return true;
        }
    }
}
