package pl.lambdastream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {

    public static void main(String[] args){
        //IStringPrinter printer = (t -> System.out.println(t));
        //testStringPrinter(t -> System.out.println(t));
        List<Person> persons = getPersonsList();
        //persons.stream().filter(o -> o.getAge() >= 18).forEach(person -> System.out.println(person.getName() + " " +  person.getAge()));

        //strumien typów prostych
        //System.out.println(IntStream.range(1,5).sum());
        //IntStream.range(1,5).forEach(l -> System.out.println(l));

        /*List<Person> personList = getPersonsList();
        printList(personList);
        List<Person> personList1 = personList.stream().filter(person -> person.getAge() >= 18)
                .sorted((p1,p2) -> p1.getName().compareTo(p2.getName())).collect(Collectors.toList());
        printList(personList1); */

        //Zaawansowane opearacje na strumieniach
        persons.stream().flatMap(p -> Arrays.asList(p, "test").stream()).forEach(o -> {
           if(o instanceof Person) System.out.println(((Person)o).getName());
           else System.out.println(o);
           });
    }

  /*  public static void testStringPrinter(Consumer<String> printer){
        //printer.accept("Accept test");
    }   */


  private static List<Person> getPersonsList() {
    List<Person> result = new ArrayList<Person>();
    result.add(new Person("Jan",15));
    result.add(new Person("Pawel",18));
    result.add(new Person("Monika",21));
    return result;
  }

    private static void printList(List<Person> list){
      list.stream().forEach(person -> System.out.println(person.getName() + " | " + person.getAge()));
    }

}
