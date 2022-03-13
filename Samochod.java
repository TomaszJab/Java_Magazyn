public class Samochod  extends Przedmiot{
    private RodzajPaliwa rodzajPaliwa;

   public Samochod(String nazwa,RodzajPaliwa rodzajPaliwa,double WielkoscPowierzchni){
       super(nazwa,WielkoscPowierzchni);
        this.rodzajPaliwa=rodzajPaliwa;
        this.WielkoscPowierzchni=WielkoscPowierzchni;
   }
    public  Samochod(String nazwa,RodzajPaliwa rodzajPaliwa,double dlugosc ,double szerokosc,double wysokosc){
        super(nazwa,dlugosc,szerokosc,wysokosc);
        this.rodzajPaliwa=rodzajPaliwa;
    }

    public RodzajPaliwa getRodzajPaliwa() {
        return rodzajPaliwa;
    }

    public double getWielkoscPowierzchni() {
        return WielkoscPowierzchni;
    }

    @Override
    public String toString() {
        return "\n"+"Samochod{" +
                "rodzajPaliwa=" + rodzajPaliwa +
                ", WielkoscPowierzchni=" + WielkoscPowierzchni +
                ", Nazwa='" + Nazwa + '\'' +
                '}';
    }
    public String toStringBezEntera() {
        return  "Samochod{" +
                "rodzajPaliwa=" + rodzajPaliwa +
                ", WielkoscPowierzchni=" + WielkoscPowierzchni +
                ", Nazwa='" + Nazwa + '\'' +
                '}';
    }
}
