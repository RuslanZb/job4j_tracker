package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void notAdd() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizenNew = new Citizen("2f44a", "Aa Bb");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertFalse(office.add(citizenNew));
    }
}