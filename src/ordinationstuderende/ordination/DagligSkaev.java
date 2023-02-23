package ordinationstuderende.ordination;

import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev {
    // TODO
    private final ArrayList<Dosis> doser = new ArrayList<>();
    public ArrayList<Dosis> getDoser() {
        return new ArrayList<>(doser);
    }
    public void opretDosis(LocalTime tid, double antal) {
        // TODO
        doser.add(new Dosis(tid,antal));
    }
}
