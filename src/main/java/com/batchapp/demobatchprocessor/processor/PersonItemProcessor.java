package com.batchapp.demobatchprocessor.processor;

import com.batchapp.demobatchprocessor.dto.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * Main procesor. It represents the action that we want to perform. In this case, we only have a simple result
 * which is converting name, lastname to uppercase.
 */
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(Person person) throws Exception {

        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final Person transformedPerson = new Person(firstName, lastName);

        LOGGER.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }
}
