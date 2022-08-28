package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    // 1. Find people aged less or equal 18
    List<Person> youngPerson=Lists.newArrayList();
    for (Person person:people)
          {if (person.getAge()<=18){
            youngPerson.add(person);
          }
            System.out.println();

    }
    for (Person young:youngPerson) {
      System.out.println(young);

    }
    // 2. Then change implementation to find first 10 people

  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();

    List<Person> youngPeople=people.stream()
            .filter(person -> person.getAge()<=18)
            .limit(10)
            .collect(Collectors.toList());
    youngPeople.forEach(System.out::println);

  }
}
