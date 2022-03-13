import java.util.*;

public class Main {
    public static void main(String[] args) {

        Przedmiot hulajnoga1 = new Przedmiot("Xaomi",80);
        Samochod samochod1 = new Samochod("Audi",RodzajPaliwa.Benzyna,20);
        Motocykl motocykl1 = new Motocykl("Harley",true,50);
        Motocykl motocykl11 = new Motocykl("Yamaha",true,50);

        Przedmiot przyczepa2 = new Przedmiot("Cargobuul",30);
        Samochod samochod2 = new Samochod("Fiat",RodzajPaliwa.Gaz,100);
        Motocykl motocyk2 = new Motocykl("Harley",false,20);

        Przedmiot kosiarka3 = new Przedmiot("Keeway",15);
        Samochod samochod3 = new Samochod("Oper",RodzajPaliwa.Hybryda,210);
        Motocykl motocyk3 = new Motocykl("Superlight ",false,150);

        Przedmiot ul4 = new Przedmiot("Sterodur",50);
        Samochod samochod4 = new Samochod("Audi",RodzajPaliwa.Dizel,22);
        Motocykl motocykl4 = new Motocykl("Keeway",true,18);

        Rower rower10 = new Rower("Kross",3,2,0.5,1);
        Rower rower11 = new Rower("Inda",3,2,0.5,1);

        Pomieszczenie<Przedmiot> pomieszczenie1 = new Pomieszczenie(200);
        try {
            pomieszczenie1.addPrzedmiot(samochod1);
            pomieszczenie1.addPrzedmiot(motocykl1);
            pomieszczenie1.addPrzedmiot(hulajnoga1);
            pomieszczenie1.addPrzedmiot(motocykl11);
        } catch (TooManyThingsExcepiton e) {
            System.out.println("Zbyt duzo przedmiotow w pomieszczeniu");
        }

        Pomieszczenie<Przedmiot> pomieszczenie2 = new Pomieszczenie(400);
        try{
            pomieszczenie2.addPrzedmiot(przyczepa2);
            pomieszczenie2.addPrzedmiot(samochod2);
            pomieszczenie2.addPrzedmiot(motocyk2);
        }catch (TooManyThingsExcepiton e){
            System.out.println("Zbyt duzo przedmiotow w pomieszczeniu");
        }

        Pomieszczenie<Przedmiot> pomieszczenie3 = new Pomieszczenie(10,20,2);
        try{
            pomieszczenie3.addPrzedmiot(kosiarka3);
            pomieszczenie3.addPrzedmiot(samochod3);
            pomieszczenie3.addPrzedmiot(motocyk3);
        }catch (TooManyThingsExcepiton e){
            System.out.println("Zbyt duzo przedmiotow w pomieszczeniu");
        }
        Pomieszczenie<Przedmiot> pomieszczenie4 = new Pomieszczenie(100);
        try{
            pomieszczenie4.addPrzedmiot(ul4);
            pomieszczenie4.addPrzedmiot(samochod4);
            pomieszczenie4.addPrzedmiot(motocykl4);
        }catch (TooManyThingsExcepiton e){
            System.out.println("Zbyt duzo przedmiotow w pomieszczeniu");
        }
        Pomieszczenie<Przedmiot> pomieszczenie5 = new Pomieszczenie(10,500,2);
        pomieszczenie5.setZrezygnujLUBWynajmij(false);
        Pomieszczenie<Przedmiot> pomieszczenie6 = new Pomieszczenie(450);
        pomieszczenie6.setZrezygnujLUBWynajmij(false);
        Pomieszczenie<Przedmiot> pomieszczenie7 = new Pomieszczenie(50);

        Pomieszczenie<Przedmiot> pomieszczenie8 = new Pomieszczenie(1000);

        Pomieszczenie<Przedmiot> pomieszczenie9 = new Pomieszczenie(325);
        pomieszczenie9.setZrezygnujLUBWynajmij(false);
        Pomieszczenie<Przedmiot> pomieszczenie10 = new Pomieszczenie(150,20,2);
        try {
            pomieszczenie10.addPrzedmiot(rower10);
        } catch (TooManyThingsExcepiton e) {
            System.out.println("Zbyt duzo przedmiotow w pomieszczeniu");
        }
        Pomieszczenie<Przedmiot> pomieszczenie11 = new Pomieszczenie(100,6,25);
        try {
            pomieszczenie10.addPrzedmiot(rower11);
        } catch (TooManyThingsExcepiton e) {
            System.out.println("Zbyt duzo przedmiotow w pomieszczeniu");
        }
        Pomieszczenie<Przedmiot> pomieszczenie12 = new Pomieszczenie(18,10,55);
        Magazyn magazyn = new Magazyn();
        magazyn.setMagazyn(pomieszczenie1);
        magazyn.setMagazyn(pomieszczenie2);
        magazyn.setMagazyn(pomieszczenie3);
        magazyn.setMagazyn(pomieszczenie4);
        magazyn.setMagazyn(pomieszczenie5);
        magazyn.setMagazyn(pomieszczenie6);
        magazyn.setMagazyn(pomieszczenie7);
        magazyn.setMagazyn(pomieszczenie8);
        magazyn.setMagazyn(pomieszczenie9);
        magazyn.setMagazyn(pomieszczenie10);
        magazyn.setMagazyn(pomieszczenie11);
        magazyn.setMagazyn(pomieszczenie12);

        Osoba Kowalski = new Osoba("Jan","Kowalski", "64020776697","26-10",1980);
        Osoba Jablonska = new Osoba("Anna", "Jablonska","52060968622","01-01",1980);
        Osoba Jerczynski = new Osoba("Tomasz", "Jerczynski","57040815446","08-04",1945);
        Osoba Nowakowski = new Osoba("Stanislaw", "Nowakowski","66020128436","30-07",1960);
        Osoba Lastkowska = new Osoba("Justyna", "Lastkowska","03302252917","13-02",1996);
        Kowalski.setDataPierwszegoNajmu("01-01-2020");
        Jablonska.setDataPierwszegoNajmu("05-09-2019");
        Jerczynski.setDataPierwszegoNajmu("05-09-2019");
        Nowakowski.setDataPierwszegoNajmu("05-09-2019");
        Lastkowska.setDataPierwszegoNajmu("05-09-2019");

        HashMap<Osoba, ArrayList<Pomieszczenie>> baza= new HashMap();
        baza.put(Kowalski,new ArrayList<Pomieszczenie>());
        baza.get(Kowalski).add(pomieszczenie1);
        baza.get(Kowalski).add(pomieszczenie2);
        baza.get(Kowalski).add(pomieszczenie10);
        baza.put(Jablonska,new ArrayList<Pomieszczenie>());
        baza.get(Jablonska).add(pomieszczenie4);
        baza.get(Jablonska).add(pomieszczenie7);
        baza.put(Jerczynski,new ArrayList<Pomieszczenie>());
        baza.get(Jerczynski).add(pomieszczenie3);
        baza.put(Nowakowski,new ArrayList<Pomieszczenie>());
        baza.get(Nowakowski).add(pomieszczenie8);
        baza.put(Lastkowska,new ArrayList<Pomieszczenie>());
        baza.get(Lastkowska).add(pomieszczenie12);

        String konsola = "10";
        Scanner scaner = new Scanner(System.in);
        Osoba WybranaOsoba1=null;
        Pomieszczenie pomieszczenie=null;
        ObslugaProgramu obslugaProgramu= new ObslugaProgramu();
        List<Pomieszczenie<Przedmiot>> ListaWolnychPomieszczen = magazyn.getMagazyn();
        while(konsola!="0"){
            System.out.println("");
            ObslugaProgramu.DostepnePolecenia11();
            konsola = scaner.nextLine();
            if(konsola.equals("1")){
                WybranaOsoba1 = obslugaProgramu.WybierzOsobe11(baza);
                pomieszczenie = ObslugaProgramu.WybierzPomieszczenie12(baza,WybranaOsoba1,false);
                ObslugaProgramu.WyswietlZawartoscPomieszczenia121(pomieszczenie);
            }else if(konsola.equals("3")) {
                ObslugaProgramu.WyswietlWolnePomieszczenie23(ListaWolnychPomieszczen);
            }else if(konsola.equals("7")){
                ObslugaProgramu.ZapiszAktualnyStanMagazynu27(ListaWolnychPomieszczen,baza);
            }else if(konsola.equals("0")) {
                konsola="0";
                //System.exit(0);
            }else{
                System.out.println("Wybierz poniownie cyfre");
            }

            while((konsola!="0")&&(WybranaOsoba1!=null)&&(ListaWolnychPomieszczen!=null)){
                ObslugaProgramu.DostepnePolecenia22();
                konsola = scaner.nextLine();
                if(konsola.equals("2")){
                    ObslugaProgramu.WlozNowePojazdyPrzedmioty22(pomieszczenie);
                }else if(konsola.equals("3")) {
                    ObslugaProgramu.WyswietlWolnePomieszczenie23(ListaWolnychPomieszczen);
                }else if(konsola.equals("4")){
                   ObslugaProgramu.DostepnePrzedmiotyWPomieszczeniu24(pomieszczenie);
                }else if(konsola.equals("5")){
                    ObslugaProgramu.WyjmijPojazdyPrzedmioty25(pomieszczenie);
                }else if(konsola.equals("6")){
                    ObslugaProgramu.WynajmijPomieszczenie26(ListaWolnychPomieszczen,baza,WybranaOsoba1);
                }else if(konsola.equals("7")){
                    ObslugaProgramu.ZapiszAktualnyStanMagazynu27(ListaWolnychPomieszczen,baza);
                }else if(konsola.equals("8")) {
                    System.out.println("Zmiana pomieszczenia");
                    pomieszczenie = obslugaProgramu.WybierzPomieszczenie12(baza,WybranaOsoba1,true);
                    ObslugaProgramu.WyswietlZawartoscPomieszczenia121(pomieszczenie);
                }else if(konsola.equals("9")) {
                    System.out.println("Zmiana osoby");
                    WybranaOsoba1 = obslugaProgramu.WybierzOsobe11(baza);
                    pomieszczenie = ObslugaProgramu.WybierzPomieszczenie12(baza,WybranaOsoba1,false);
                    ObslugaProgramu.WyswietlZawartoscPomieszczenia121(pomieszczenie);
                }else if(konsola.equals("0")) {
                    konsola="0";
                    //System.exit(0);
                }
            }
        }
    }
}