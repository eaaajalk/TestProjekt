package ordinationstuderende.ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DagligSkaevTest {

    ArrayList<Dosis> doser;
    DagligSkaev dagligSkaev;
    Laegemiddel l;
    Patient p;

    @BeforeEach
    void setUp() {
        doser = new ArrayList<>();
        p = new Patient("1122334455","Jacob",70);
        l = new Laegemiddel("Fucidin", 25,50,75,"Fucidin");
        dagligSkaev = new DagligSkaev(LocalDate.now(),LocalDate.now().plusDays(2),l,p);
    }

    @Test
    void samletdosisTC1() {
        dagligSkaev.opretDosis(LocalTime.now(), 5);

        double actualResult = dagligSkaev.samletDosis();
        assertEquals(5, actualResult);

    }

    @Test
    void samletdosisTC2() {
        dagligSkaev.opretDosis(LocalTime.now(), 5);
        dagligSkaev.opretDosis(LocalTime.now(), 5);

        double actualResult = dagligSkaev.samletDosis();
        assertEquals(10, actualResult);

    }

    @Test
    void samletdosisTC3() {
        dagligSkaev.opretDosis(LocalTime.now(), 0);

        double actualResult = dagligSkaev.samletDosis();
        assertEquals(0, actualResult);

    }

    @Test
    void samletdosisTC4() {
        dagligSkaev.opretDosis(LocalTime.now(), -5);

        double actualResult = dagligSkaev.samletDosis();
        assertEquals(-5, actualResult);

    }

    @Test
    void doegndosisTC1() {
        DagligSkaev TC1 = new DagligSkaev(LocalDate.now(),LocalDate.now().plusDays(5),l,p);
        TC1.opretDosis(LocalTime.now(), 6);
        double actualResult = TC1.samletDosis() / TC1.antalDage();
        assertEquals(1,actualResult);
    }
    @Test
    void doegndosisTC2() {
        DagligSkaev TC2 = new DagligSkaev(LocalDate.now(),LocalDate.now().plusDays(1),l,p);
        TC2.opretDosis(LocalTime.now(), 1);
        double actualResult = TC2.samletDosis() / TC2.antalDage();
        assertEquals(0.5,actualResult);
    }
    @Test
    void doegndosisTC3() {
        DagligSkaev TC3 = new DagligSkaev(LocalDate.now(),LocalDate.now().plusDays(3),l,p);
        TC3.opretDosis(LocalTime.now(), 1);
        double actualResult = TC3.samletDosis() / TC3.antalDage();
        assertEquals(0.25,actualResult);
    }
}