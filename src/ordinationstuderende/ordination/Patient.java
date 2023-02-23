package ordinationstuderende.ordination;

import java.util.ArrayList;

public class Patient {
    private String cprnr;
    private String navn;
    private double vaegt;
    private final ArrayList<Ordination> ordinationer = new ArrayList<>();

    // TODO: Link til Ordination

    public Patient(String cprnr, String navn, double vaegt) {
        this.cprnr = cprnr;
        this.navn = navn;
        this.vaegt = vaegt;
    }

    public String getCprnr() {
        return cprnr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getVaegt(){
        return vaegt;
    }

    public void setVaegt(double vaegt){
        this.vaegt = vaegt;
    }

    public ArrayList<Ordination> getOrdination() {
        return new ArrayList<>(ordinationer);
    }
    public void addPerson(Ordination ordination) {
        if (!ordinationer.contains(ordination)) {
        ordinationer.add(ordination);
    }
    }
    public void removePerson(Ordination ordination) {
        if (ordinationer.contains(ordination)) {
            ordinationer.remove(ordination);
        }
    }

    //TODO: Metoder (med specifikation) til at vedligeholde link til Ordination

    @Override
    public String toString(){
        return navn + "  " + cprnr;
    }

}
