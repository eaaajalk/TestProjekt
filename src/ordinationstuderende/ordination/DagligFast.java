package ordinationstuderende.ordination;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;


public class DagligFast extends Ordination {
    // TODO
    private Dosis[] doser = new Dosis[4];



    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, Patient patient, Dosis[] doser) {
        super(startDen, slutDen, laegemiddel, patient);
        this.doser = doser;
    }

    public Dosis[] getDoser() {
        return doser;
    }


    @Override
    public double samletDosis() {
        double sum = antalDage() * doegnDosis();
        return sum;
    }

    @Override
    public double doegnDosis() {
        double sum = 0;
        for (int i = 0; i < 4; i++) {
            sum = doser[i].getAntal();
        }
        return sum;
    }

    @Override
    public String getType() {
        return "DagligFast";
    }


}
