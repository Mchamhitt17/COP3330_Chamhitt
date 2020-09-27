import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BodyMassIndexTest {

    @Test
    void bmiCalc() {
        BodyMassIndex b = new BodyMassIndex(65, 145);
       assertEquals(24.0, b.bmiCalc());
    }

    @Test
    void bmiUnder() {
        BodyMassIndex b = new BodyMassIndex(65, 91);
        assertEquals("Underweight", b.bmiUnder());
    }

    @Test
    void bmiNormal() {
        BodyMassIndex b = new BodyMassIndex(65, 115);
        assertEquals("Normal Weight", b.bmiNormal());
    }

    @Test
    void bmiOverweight() {
        BodyMassIndex b = new BodyMassIndex(65, 155);
        assertEquals("Overweight", b.bmiOverweight());
    }

    @Test
    void bmiObese() {
        BodyMassIndex b = new BodyMassIndex(65, 200);
        assertEquals("Obese", b.bmiObese());
    }
}