package ordinationstuderende.controller;

import ordinationstuderende.ordination.Laegemiddel;
import ordinationstuderende.ordination.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    Controller controller;
    Laegemiddel l;
    Patient p;

    @BeforeEach
    void setUp() {
        controller = Controller.getTestController();
       l = controller.opretLaegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
        p = controller.opretPatient("1234", "Testperson", 1);
    }
    @Test
    void anbefaletDosisTC1() {

        // Act
        double actualResult = controller.anbefaletDosisPrDoegn(p, l);
        // Assert
        assertEquals(1, actualResult, 0.0001);
    }

    @Test
    void anbefaletDosisTC2() {
        p.setVaegt(24);
        // Act
        double actualResult = controller.anbefaletDosisPrDoegn(p, l);
        // Assert
        assertEquals(24, actualResult, 0.0001);
    }
    @Test
    void anbefaletDosisTC3() {
        p.setVaegt(25);
        // Act
        double actualResult = controller.anbefaletDosisPrDoegn(p, l);
        // Assert
        assertEquals(37.5, actualResult, 0.0001);
    }
    @Test
    void anbefaletDosisTC4() {
        p.setVaegt(120);
        // Act
        double actualResult = controller.anbefaletDosisPrDoegn(p, l);
        // Assert
        assertEquals(180, actualResult, 0.0001);
    }
    @Test
    void anbefaletDosisTC5() {
        p.setVaegt(121);
        // Act
        double actualResult = controller.anbefaletDosisPrDoegn(p, l);
        // Assert
        assertEquals(242, actualResult, 0.0001);
    }
    @Test
    void anbefaletDosisTC6() {
        p.setVaegt(500);
        // Act
        double actualResult = controller.anbefaletDosisPrDoegn(p, l);
        // Assert
        assertEquals(1000, actualResult, 0.0001);
    }
    @Test
    void anbefaletDosisTC7() {
        p.setVaegt(0);
        // Act
        // Assert
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
            controller.anbefaletDosisPrDoegn(p, l);
        });
        assertEquals(runtimeException.getMessage(), "Vægten kan ikke være 0");
        }
}