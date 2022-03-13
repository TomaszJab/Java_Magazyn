public class Motocykl extends Przedmiot{
    boolean homologacja;

    public  Motocykl(String nazwa,boolean homologacja,double WielkoscPowierzchni){
        super(nazwa,WielkoscPowierzchni);
        this.homologacja=homologacja;
        this.WielkoscPowierzchni=WielkoscPowierzchni;
    }
    public  Motocykl(String nazwa,boolean homologacja,double dlugosc ,double szerokosc,double wysokosc){
        super(nazwa,dlugosc,szerokosc,wysokosc);
        this.homologacja=homologacja;
        this.WielkoscPowierzchni=dlugosc*szerokosc*wysokosc;
    }

    public boolean isHomologacja() {
        return homologacja;
    }

    public double getWielkoscPowierzchni() {
        return WielkoscPowierzchni;
    }

    @Override
    public String toString() {
        return "\n"+"Motocykl{" +
                "homologacja=" + homologacja +
                ", WielkoscPowierzchni=" + WielkoscPowierzchni +
                ", Nazwa='" + Nazwa + '\'' +
                '}';
    }
    public String toStringBezEntera() {
        return  "Motocykl{" +
                "homologacja=" + homologacja +
                ", WielkoscPowierzchni=" + WielkoscPowierzchni +
                ", Nazwa='" + Nazwa + '\'' +
                '}';
    }
}
