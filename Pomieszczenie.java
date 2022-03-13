import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Pomieszczenie<G extends Przedmiot>implements Comparable<Pomieszczenie>{
    private static int id;
    private int ID;
    private double powierzchnia;
    private double WolneMiejsce;
    private List<Przedmiot> listaPrzedmiotow = new ArrayList<Przedmiot>();
    private boolean CzyWynajete;

    public   Pomieszczenie(int powierzchnia)  {
        this.powierzchnia=powierzchnia;
        this.WolneMiejsce=powierzchnia;
        id++;
        this.ID=id;
        this.CzyWynajete=true;
    }
    public   Pomieszczenie(int dlugosc ,int szerokosc,int wysokosc)  {
        this.powierzchnia=dlugosc*szerokosc*wysokosc;
        this.WolneMiejsce=powierzchnia;
        id++;
        this.ID=id;
        this.CzyWynajete=true;
    }
    public void UsunPrzedmiotZListy(int i){
        listaPrzedmiotow.remove(i);
        AktualizacjaPowierzchni();
    }
    private void AktualizacjaPowierzchni(){
        double AktualizacjaWolnegoMiejsca = 0;
        for(int i = 0;i<listaPrzedmiotow.size();i++){
            AktualizacjaWolnegoMiejsca = AktualizacjaWolnegoMiejsca+listaPrzedmiotow.get(i).getWielkoscPowierzchni();
        }
        this.WolneMiejsce=powierzchnia-AktualizacjaWolnegoMiejsca;
    }

    public boolean getCzyWynajete() {
        return CzyWynajete;
    }
    public void setZrezygnujLUBWynajmij(boolean CzyWynajete) {

        this.CzyWynajete=CzyWynajete;
    }
    public void setWynajmij(boolean Wynajmij) {
        if(CzyWynajete==true){
            System.out.println("Pomieszczenia nie mozna wynajac");
        }else{
            CzyWynajete = Wynajmij;
        }
    }

    public void addPrzedmiot(G przedmiot) throws TooManyThingsExcepiton {
        WolneMiejsce=WolneMiejsce-przedmiot.WielkoscPowierzchni;
        if(WolneMiejsce<0){
            throw new TooManyThingsExcepiton();
        }
        listaPrzedmiotow.add(przedmiot);
    }

    public double getWolneMiejsce() {
        return WolneMiejsce;
    }

    public List<Przedmiot> getListaPrzedmiotow() {
        return listaPrzedmiotow;
    }

    public String getPowierzchnia(){
        return powierzchnia +" m3";
    }

    public int getID(){
        return ID;
    }

    public String getCzyDoWynajecia(){
        String a;
        if(CzyWynajete== false){
            a="nie jest";
        }else{
            a="jest";
        }
        return +ID+" - Pomieszczenie" +ID+ " "+a+" do wynajecia";
    }


    @Override
    public String toString() {
        return "\n"+"Pomieszczenie{" +
                "ID=" + ID +
                ", powierzchnia=" + powierzchnia +
                ", WolneMiejsce=" + WolneMiejsce +
               // ", listaPrzedmiotow=" + listaPrzedmiotow +
                ", CzyWynajete=" + CzyWynajete +
                '}';
    }


    public String toStringBezListy() {
        return "Pomieszczenie{" +
                "ID=" + ID +
                ", powierzchnia=" + powierzchnia +
                ", WolneMiejsce=" + WolneMiejsce +
                ", CzyWynajete=" + CzyWynajete +
                '}';
    }

    public String ZListatoString() {
        return "\n"+"Pomieszczenie{" +
                "ID=" + ID +
                ", powierzchnia=" + powierzchnia +
                ", WolneMiejsce=" + WolneMiejsce +
                ", CzyWynajete=" + CzyWynajete +
                ", listaPrzedmiotow= " + listaPrzedmiotow +
                '}';
    }

    
    @Override
    public int compareTo(Pomieszczenie pomieszczenie) {
        return (int) (this.powierzchnia - pomieszczenie.powierzchnia);
    }
}
