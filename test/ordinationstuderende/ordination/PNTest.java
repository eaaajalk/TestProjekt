package ordinationstuderende.ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PNTest {

    PN pn;
    Laegemiddel laegemiddel;
    Patient patient;

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

}