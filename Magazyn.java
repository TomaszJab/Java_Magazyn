import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Magazyn <G extends Przedmiot>{
    private List<Pomieszczenie<G>> magazyn = new ArrayList<>();


    public List<Pomieszczenie<G>> getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(Pomieszczenie pomieszczenie) {
        magazyn.add(pomieszczenie);
    }
    public void zawartosc(){
        magazyn.toString();
    }
    public int getID(Pomieszczenie pomieszczenie){
        return pomieszczenie.getID();
    }
    public static double getWielkoscPowierzchni1(Przedmiot przedmiot){
        return przedmiot.getWielkoscPowierzchni();
    }
    public boolean getWolnePomieszczenia(Pomieszczenie pomieszczenie){
        return pomieszczenie.getCzyWynajete();
    }

    public String getInfoPomieszczenieBezListy(Pomieszczenie pomieszczenie){
        return pomieszczenie.toStringBezListy();
    }
    public String getInfoPomieszczenieZLista(Pomieszczenie pomieszczenie){
        return pomieszczenie.ZListatoString();
    }
    public String BezEntera(Przedmiot przedmiot){
        return przedmiot.toStringBezEntera();
    }

}
