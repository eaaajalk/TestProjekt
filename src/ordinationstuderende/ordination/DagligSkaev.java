package ordinationstuderende.ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {
    // TODO
    private final ArrayList<Dosis> doser = new ArrayList<>();

    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, Patient patient) {
        super(startDen, slutDen, laegemiddel, patient);
    }

    public ArrayList<Dosis> getDoser() {
        return new ArrayList<>(doser);
    }
    public void opretDosis(LocalTime tid, double antal) {
        // TODO
            doser.add(new Dosis(tid, antal));
    }

    @Override
    public double samletDosis() {
        double samletDosis = 0;
        for (Dosis dosis : doser) {
            samletDosis += dosis.getAntal();
        }
        return samletDosis;
    }

    @Override
    public double doegnDosis() {
        return samletDosis() / antalDage();
    }

    @Override
    public String getType() {
        return "Daglig Skæv";
    }
}
