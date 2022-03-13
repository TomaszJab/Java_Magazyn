public class Rower extends Przedmiot{
    int IloscPrzerzutek;

    public  Rower(String nazwa,int IloscPrzerzutek,double WielkoscPowierzchni){
        super(nazwa,WielkoscPowierzchni);
        this.IloscPrzerzutek=IloscPrzerzutek;
        this.WielkoscPowierzchni=WielkoscPowierzchni;
    }
    public  Rower(String nazwa,int IloscPrzerzutek,double dlugosc ,double szerokosc,double wysokosc){
        super(nazwa,dlugosc,szerokosc,wysokosc);
        this.IloscPrzerzutek=IloscPrzerzutek;
    }

    public int getIloscPrzerzutek() {
        return IloscPrzerzutek;
    }


    public double getWielkoscPowierzchni() {
        return WielkoscPowierzchni;
    }

    @Override
    public String toString() {
        return "\n"+"Rower{" +
                "IloscPrzerzutek=" + IloscPrzerzutek +
                ", WielkoscPowierzchni=" + WielkoscPowierzchni +
                ", Nazwa='" + Nazwa + '\'' +
                '}';
    }

    public String toStringBezEntera() {
        return  "Rower{" +
                "IloscPrzerzutek=" + IloscPrzerzutek +
                ", WielkoscPowierzchni=" + WielkoscPowierzchni +
                ", Nazwa='" + Nazwa + '\'' +
                '}';
    }
}
