package ordinationstuderende.ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PN extends Ordination {

    private double antalEnheder;
    private List<LocalDate> dosisDatoerList = new ArrayList<>();
    private int antalGangeAnvendt = 0;

    public PN(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, Patient patient, double antalEnheder) {
        super(startDen, slutDen, laegemiddel, patient);
        this.antalEnheder = antalEnheder;
    }

    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     * @param givesDen
     * @return
     */
    public boolean givDosis(LocalDate givesDen) {
        // TODO
        if (givesDen.isAfter(getStartDen().minusDays(1)) && givesDen.isBefore(getSlutDen().plusDays(1))) {
            dosisDatoerList.add(givesDen);
            antalGangeAnvendt++;
            return true;
        } else {
            return false;
        }
    }

    public double doegnDosis() {
        // TODO
        Collections.sort(dosisDatoerList);
        int diff = antalDage();
        return (antalGangeAnvendt * antalEnheder) / (diff + 1);
    }

    @Override
    public String getType() {
        return "PN";
    }

    public double samletDosis() {
        // TODO
        return antalGangeAnvendt * antalEnheder;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        // TODO
        return antalGangeAnvendt;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

}
