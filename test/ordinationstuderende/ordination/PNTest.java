package ordinationstuderende.ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.time.LocalDateTime;
import java.time.LocalTime;
>>>>>>> c56d5f932e72a0967a5b852f13c839dba64ae1b8

import static org.junit.jupiter.api.Assertions.*;

class PNTest {

    PN pn;
    Laegemiddel laegemiddel;
    Patient patient;
<<<<<<< HEAD

    @BeforeEach
    void setup(){
        ArrayList<LocalDate> list = new ArrayList<>();
        patient = new Patient("1234","kevin",80);
        laegemiddel = new Laegemiddel("penodil",1,2,3,"stk");
    }

    @Test
    void doegnDosisTC1() {
        pn = new PN(LocalDate.of(2023,02,10),LocalDate.of(2023,02,10),laegemiddel,patient,0);
        double actualResult = pn.doegnDosis();
        assertEquals(0, actualResult);

    }
    @Test
    void doegnDosisTC2() {
        pn = new PN(LocalDate.of(2023,02,10),LocalDate.of(2023,02,11),laegemiddel,patient,1);
        pn.givDosis(LocalDate.of(2023,02,10));
        double actualResult = pn.doegnDosis();
        assertEquals(1, actualResult);

    }
    @Test
    void doegnDosisTC3() {
        pn = new PN(LocalDate.of(2023,02,10),LocalDate.of(2023,02,15),laegemiddel,patient,5);
        pn.givDosis(LocalDate.of(2023,02,10));
        pn.givDosis(LocalDate.of(2023,02,10));
        pn.givDosis(LocalDate.of(2023,02,10));
        pn.givDosis(LocalDate.of(2023,02,10));
        pn.givDosis(LocalDate.of(2023,02,15));
        double actualResult = pn.doegnDosis();
        assertEquals(5, actualResult);
    }

=======
    @BeforeEach
    void setUp() {
        laegemiddel = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
        patient = new Patient("1234", "Testperson", 1);
        pn = new PN(LocalDate.of(2023, 2, 27), LocalDate.of(2023, 3, 2), laegemiddel, patient, 2);
    }

    @Test
    void givDosisTC1() {
        boolean actualResult = pn.givDosis(LocalDate.of(2023, 2, 27));
        assertEquals(true, actualResult);
    }
    @Test
    void givDosisTC2() {
        boolean actualResult = pn.givDosis(LocalDate.of(2023, 3, 2));
        assertEquals(true, actualResult);
    }
    @Test
    void givDosisTC3() {
        boolean actualResult = pn.givDosis(LocalDate.of(2023, 3, 1));
        assertEquals(true, actualResult);
    }
    @Test
    void givDosisTC4() {
        boolean actualResult = pn.givDosis(LocalDate.of(2023, 2, 26));
        assertEquals(false, actualResult);
    }
    @Test
    void givDosisTC5() {
        boolean actualResult = pn.givDosis(LocalDate.of(2023, 3, 3));
        assertEquals(false, actualResult);
    }
>>>>>>> c56d5f932e72a0967a5b852f13c839dba64ae1b8
}