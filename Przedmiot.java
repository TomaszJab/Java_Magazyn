public class Przedmiot implements Comparable<Przedmiot>{
    double WielkoscPowierzchni;
    String Nazwa;

    public Przedmiot(String nazwa,double WielkoscPowierzchni) {
        this.WielkoscPowierzchni = WielkoscPowierzchni;
        this.Nazwa = nazwa;
    }
    public  Przedmiot(String nazwa,double dlugosc ,double szerokosc,double wysokosc){
        this.Nazwa = nazwa;
        this.WielkoscPowierzchni=dlugosc*szerokosc*wysokosc;
    }

    public double getWielkoscPowierzchni() {
        return WielkoscPowierzchni;
    }

    @Override
    public String toString() {
        return "\n"+"Przedmiot{" +
                "WielkoscPowierzchni=" + WielkoscPowierzchni +
                ", Nazwa='" + Nazwa + '\'' +
                '}';
    }

    public String toStringBezEntera() {
        return  "Przedmiot{" +
                "WielkoscPowierzchni=" + WielkoscPowierzchni +
                ", Nazwa='" + Nazwa + '\'' +
                '}';
    }
    @Override
    public int compareTo(Przedmiot przedmiot) {
        if(-1*(int)(this.WielkoscPowierzchni-przedmiot.WielkoscPowierzchni)==0){
            return this.Nazwa.compareTo(przedmiot.Nazwa);
        }else{
            return -1*(int)(this.WielkoscPowierzchni-przedmiot.WielkoscPowierzchni);
        }
    }
}
