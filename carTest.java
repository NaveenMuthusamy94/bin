import HOMEWORK1.*;
import static org.junit.Assert.*;
import org.junit.Test;

import java.io.*;

class carTest
 {
private String[] carToStringArray(car c) {
    String[] carInfo = {c.getMake(), c.getModel(), Integer.toString(c.getMileage()), 
            Integer.toString(c.getYear()), Integer.toString(c.getPrice())};
    return carInfo;
}
@Test
void verifyCarEqualityWithMakeModelYear() {
    String[] expected = {"Toyota", "RAV4", "2018"};
    car actual = new car("Honda", "Altima",45000, 2015, 12000);
    assertArrayEquals(expected, carToStringArray(actual));
}
}