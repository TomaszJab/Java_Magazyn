import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class ObslugaProgramu {


    public static void DostepnePolecenia11(){
        System.out.println("0 - Zamkniecie programu");
        System.out.println("1 - Wybierz osobę z listy: ");
        System.out.println("3 - Wyswietl wolne pomieszczenia");
        System.out.println("7 - Zapisanie aktualnego stanu magazynu do pliku");

    }
    public static void DostepnePolecenia22(){
        System.out.println("");
        System.out.println("0 - Zamkniecie program");
        System.out.println("2 - Wloz nowy pojazd/przedmiot do pomieszcznia");
        System.out.println("3 - Wyswietl wolne pomieszczenia");
        System.out.println("4 - Wyswietl przedmioty znajdujace sie w pomieszczeniu");
        System.out.println("5 - Wyjmij pojazdy/przedmioty");
        System.out.println("6 - Wynajmij pomieszczenie");
        System.out.println("7 - Zapisz aktualny stanu magazynu do pliku");
        System.out.println("8 - Zmien pomieszczenie");
        System.out.println("9 - Zmien osobe");

    }

    public  Osoba WybierzOsobe11( HashMap<Osoba, ArrayList<Pomieszczenie>> baza){
        ///wybierz osobe i wyswietl jej pomieszczenia
        System.out.println("0 - Zamkniecie program");
        System.out.println("Wybierz osobe : ");

        Scanner scaner1;
        String userInput1;

        boolean spr = true;
        while (spr){
            for (Map.Entry<Osoba, ArrayList<Pomieszczenie>> entry : baza.entrySet()) {
                System.out.println(entry.getKey().getNazwisko());
            }
            scaner1 = new Scanner(System.in);
            userInput1 = scaner1.nextLine();
            for (Map.Entry<Osoba, ArrayList<Pomieszczenie>> entry : baza.entrySet()) {
                if(entry.getKey().getNazwisko().compareTo(userInput1)==0){
                    System.out.println("Wybrano poprawnie");
                    System.out.println(entry.getKey().toString());
                    System.out.println("Pani/Pan "+ entry.getKey().getNazwisko()+" liczba pomieszczen "+entry.getValue().size()+" :");
                    /// zostala wybrana osoba
                    ///ponizej wyswietlenie pomiesczeni
                    for(int i = 0;i<entry.getValue().size();i++){
                        System.out.println(baza.get(entry.getKey()).get(i).getID()+" - pomieszczenie"+baza.get(entry.getKey()).get(i).getID());
                    }
                    spr=false;
                    //osoba = entry.getKey();
                    return entry.getKey();
                }
            }
            if(userInput1.equals("0")){
                System.exit(0);
            }
            if(spr==true){
                System.out.println("Wybierz jeszcze raz osobę z listy: ");
            }
        }
        return null;
    }
    public static Pomieszczenie WybierzPomieszczenie12( HashMap<Osoba, ArrayList<Pomieszczenie>> baza,Osoba osoba,boolean parametr){
        boolean BrakWynajetychPomieszcen=false;
        for (Map.Entry<Osoba, ArrayList<Pomieszczenie>> entry : baza.entrySet()) {
            if(entry.getKey().getNazwisko().compareTo(osoba.getNazwisko())==0){
                if(entry.getValue().size()==0){
                    System.out.println("Osoba nie ma wynajetych zadnych pomieszczen");
                    BrakWynajetychPomieszcen=true;
                }
            }
        }
        if(BrakWynajetychPomieszcen==false){
            System.out.println("");
            System.out.println("0 - Zamkniecie program");
            System.out.println("Wybierz numer pomieszcznia: ");
            if(parametr==true){
                for (Map.Entry<Osoba, ArrayList<Pomieszczenie>> entry : baza.entrySet()) {
                    if(entry.getKey()==osoba){
                        for(int i = 0;i<entry.getValue().size();i++){
                            System.out.print(baza.get(entry.getKey()).get(i).getID()+" - pomieszczenie"+baza.get(entry.getKey()).get(i).getID());
                            System.out.println();
                        }
                    }
                }
            }
            Scanner scaner1;
            String userInput1;
            Magazyn magazyn = new Magazyn();
            boolean spr = true;
            while (spr){
                scaner1 = new Scanner(System.in);
                userInput1 = scaner1.nextLine();

                for (Map.Entry<Osoba, ArrayList<Pomieszczenie>> entry : baza.entrySet()) {
                    if(entry.getKey()==osoba){
                        for(int i = 0;i<entry.getValue().size();i++){
                            try {
                                if(baza.get(entry.getKey()).get(i).getID()==Integer.valueOf(userInput1)){
                                    System.out.println("Wybrano pomieszczenie"+Integer.valueOf(userInput1));

                                    //System.out.println(magazyn.getInfoPomieszczenieZLista(baza.get(osoba).get(Integer.parseInt(userInput1)-1)));
                                    spr=false;
                                    return baza.get(entry.getKey()).get(i);
                                }
                            }catch (NumberFormatException e){
                                System.out.println("Nie podano poprawnego numeru pomieszczenia");
                            }

                        }

                    }
                }
                if(userInput1.equals("0")){
                    System.exit(0);
                }
                if(spr==true){
                    System.out.println("Wybierz jeszcze raz pomieszczenie: ");
                    for (Map.Entry<Osoba, ArrayList<Pomieszczenie>> entry : baza.entrySet()) {
                        if(entry.getKey()==osoba){
                            for(int i = 0;i<entry.getValue().size();i++){
                                System.out.print(baza.get(entry.getKey()).get(i).getID()+" - pomieszczenie"+baza.get(entry.getKey()).get(i).getID());
                                System.out.println();
                            }
                        }
                    }

                }

            }
        }

        return null;
    }
    public static void WyswietlZawartoscPomieszczenia121(Pomieszczenie pomieszczenie){
        Magazyn magazyn = new Magazyn();
        System.out.println(magazyn.getInfoPomieszczenieZLista(pomieszczenie));

    }
    public static void WlozNowePojazdyPrzedmioty22(Pomieszczenie pomieszczenie) {
        String nazwa;
        boolean homologacja = false;
        double WielkoscPowierzchni = 0;
        int IloscPrzerzutek;
        Scanner scaner1 = scaner1 = new Scanner(System.in);;
        String userInput1;
        boolean a = true;
        if(pomieszczenie.getWolneMiejsce()<=0){
            System.out.println("Ilosc wolnego miejsca w pomieszczeniu wynosi 0. Nie mozna dodac nowego przedmiotu");
        }else {
            System.out.println("0 - Zamkniecie programu");
            System.out.println("Ilosc wolnego miejsca w pomieszczeniu "+pomieszczenie.getWolneMiejsce());
            System.out.println("Wybierz co chcesz wlozyc do pomieszczenia:");
            System.out.println("1 - Rower");
            System.out.println("2 - Motocykl");
            System.out.println("3 - Samochod");
            System.out.println("4 - Przedmiot");

            boolean b = true;
            while (b){
                userInput1 = scaner1.nextLine();
                if(userInput1.equals("4")){
                    System.out.println("0 - Zamkniecie programu");
                    System.out.println("Wybrales Przedmiot");
                    System.out.println("Podaj nazwe Przedmiotu");
                    nazwa = scaner1.nextLine();
                    if(userInput1.equals("0")){System.exit(0);}
                    boolean m = true;
                    boolean wymiary = true;
                    while (m){
                        System.out.println("0 - Zamkniecie programu");
                        System.out.println("Podaj w jaki sposob chcesz podac wielkosc powierzchni zajmowanej przez przedmiot");
                        System.out.println("1 - Podajac wymiar calego pomieszczenia");
                        System.out.println("2 - Podajac trzy wymiary: szerokosc, dlugosc, wysokosc pomieszczenia");
                        userInput1 = scaner1.nextLine();
                        if(userInput1.equals("0")){System.exit(0);}
                        if(userInput1.equals("2")){

                            boolean ma = true,mb=true,mc=true;
                            while(ma){
                                try {
                                    System.out.println("0 - Zamkniecie programu");
                                    System.out.println("Podaj szerokosc pomieszczenia");
                                    userInput1 = scaner1.nextLine();
                                    if(userInput1.equals("0")){System.exit(0);}
                                    WielkoscPowierzchni = Double.parseDouble(userInput1);
                                    ma=false;
                                }catch (NumberFormatException e){
                                    System.out.println("Sprobuj jeszcze raz");
                                }
                            }


                            while(mb){
                                try {
                                    if(userInput1.equals("0")){System.exit(0);}
                                    System.out.println("0 - Zamkniecie programu");
                                    System.out.println("Podaj dlugosc pomieszczenia");
                                    userInput1 = scaner1.nextLine();
                                    WielkoscPowierzchni = WielkoscPowierzchni*Double.parseDouble(userInput1);
                                    mb=false;
                                }catch (NumberFormatException e){
                                    System.out.println("Sprobuj jeszcze raz");
                                }
                            }


                            while(mc){
                                try {
                                    if(userInput1.equals("0")){System.exit(0);}
                                    System.out.println("0 - Zamkniecie programu");
                                    System.out.println("Podaj wysokosc pomieszczenia");
                                    userInput1 = scaner1.nextLine();
                                    WielkoscPowierzchni = WielkoscPowierzchni*Double.parseDouble(userInput1);
                                    if(userInput1.equals("0")){System.exit(0);}
                                    mc=false;
                                }catch (NumberFormatException e){
                                    System.out.println("Sprobuj jeszcze raz");
                                }
                            }

                            wymiary = false;
                            m = false;
                        }else if (userInput1.equals("1")){m = false;}
                        else{
                            System.out.println("Sprobuj jeszcze raz");
                        }
                    }


                    Przedmiot przedmiot;
                    while (a){
                        try{
                            if(wymiary=true){
                                System.out.println("0 - Zamkniecie programu");
                                System.out.println("Podaj wielkosc powierzchni zajmowanej przez przedmiot");
                                WielkoscPowierzchni= Double.parseDouble(scaner1.nextLine());
                                if(userInput1.equals("0")){System.exit(0);}
                            }
                            if(WielkoscPowierzchni>0){
                                przedmiot = new Przedmiot(nazwa,WielkoscPowierzchni);
                                pomieszczenie.addPrzedmiot(przedmiot);
                                a=false;
                                b=false;
                            }else{
                                System.out.println("Wielkosc powierzchni musi być liczba wieksza od 0");
                            }

                        }catch (NumberFormatException e){
                            System.out.println("Podana powierzchnia nie byla liczba");
                            System.out.println("Sprobuj jeszcze raz");
                        } catch (TooManyThingsExcepiton e) {
                            System.out.println("Nie mozna dodac przedmiotu za malo miejsca w pomieszczeniu");
                            System.out.println("Ilosc wolnego miejsca w pomieszczeniu "+pomieszczenie.getWolneMiejsce());
                            a=false;
                            b=false;
                        }
                    }

                }else if(userInput1.compareTo("2")==0){
                    System.out.println("0 - Zamkniecie programu");
                    System.out.println("Wybrales Motocykl");
                    System.out.println("Podaj nazwe Motocyklu");
                    nazwa = scaner1.nextLine();
                    if(userInput1.equals("0")){System.exit(0);}
                    boolean z = true;
                    while(z){
                        System.out.println("0 - Zamkniecie programu");
                        System.out.println("Czy motocykl posiada homologacje:");
                        System.out.println("t - Tak");
                        System.out.println("n - Nie");
                        userInput1 = scaner1.nextLine();
                        if(userInput1.equals("t")){
                            homologacja = true;
                            z = false;
                        }else if(userInput1.equals("n")){
                            homologacja = false;
                            z = false;
                        }else if(userInput1.equals("0")){ System.exit(0);}
                        else {
                            System.out.println("Sprobuj jeszcze raz");
                        }
                    }
                    boolean m = true;
                    boolean wymiary = true;
                    while (m){
                        System.out.println("0 - Zamkniecie programu");
                        System.out.println("Podaj w jaki sposob chcesz podac wielkosc powierzchni zajmowanej przez Motocyklt");
                        System.out.println("1 - Podajac wymiar calego pomieszczenia");
                        System.out.println("2 - Podajac trzy wymiary: szerokosc, dlugosc, wysokosc pomieszczenia");
                        userInput1 = scaner1.nextLine();
                        if(userInput1.equals("0")){System.exit(0);}
                        if(userInput1.equals("2")){
                            boolean ma=true,mb=true,mc=true;
                            while (ma){
                                try {
                                    System.out.println("0 - Zamkniecie programu");
                                    System.out.println("Podaj szerokosc pomieszczenia");
                                    userInput1 = scaner1.nextLine();
                                    WielkoscPowierzchni = Double.parseDouble(userInput1);
                                    if(userInput1.equals("0")){System.exit(0);}
                                  ma=false;
                                }catch (NumberFormatException e){
                                    System.out.println("Sprobuj jeszcze raz");
                                }
                            }

                            while (mb){
                                try {
                                    System.out.println("0 - Zamkniecie programu");
                                    System.out.println("Podaj dlugosc pomieszczenia");
                                    userInput1 = scaner1.nextLine();
                                    WielkoscPowierzchni = WielkoscPowierzchni*Double.parseDouble(userInput1);
                                    mb=false;
                                }catch (NumberFormatException e){
                                    System.out.println("Sprobuj jeszcze raz");
                                }
                            }

                            while (mc){
                                try {
                                    if(userInput1.equals("0")){System.exit(0);}
                                    System.out.println("0 - Zamkniecie programu");
                                    System.out.println("Podaj wysokosc pomieszczenia");
                                    userInput1 = scaner1.nextLine();
                                    WielkoscPowierzchni = WielkoscPowierzchni*Double.parseDouble(userInput1);
                                    mc=false;
                                }catch (NumberFormatException e){
                                    System.out.println("Sprobuj jeszcze raz");
                                }
                            }

                            if(userInput1.equals("0")){System.exit(0);}
                            wymiary = false;
                            m = false;
                        }else if (userInput1.equals("1")){m = false;}
                        else{
                            System.out.println("Sprobuj jeszcze raz");
                        }
                    }

                    while (a){
                        try{
                            if(wymiary==true){
                                System.out.println("0 - Zamkniecie programu");
                                System.out.println("Podaj wielkosc powierzchni zajmowanej przez motocykl");
                                WielkoscPowierzchni= Double.parseDouble(scaner1.nextLine());
                                if(userInput1.equals("0")){System.exit(0);}
                            }
                            if(userInput1.equals("0")){System.exit(0);}
                            if(WielkoscPowierzchni>0){
                                Motocykl motocykl = new Motocykl(nazwa,homologacja,WielkoscPowierzchni);
                                pomieszczenie.addPrzedmiot(motocykl);
                                System.out.println("Dodano motocykl do pomieszczenia");
                                a=false;
                                b=false;
                            }else{
                                System.out.println("Wielkosc powierzchni musi być liczba wieksza od 0");
                            }
                        }catch (NumberFormatException e){
                            System.out.println("Podana powierzchnia nie byla liczba");
                            System.out.println("Sprobuj jeszcze raz");
                        } catch (TooManyThingsExcepiton tooManyThingsExcepiton) {
                            System.out.println("Nie mozna dodac przedmiotu za malo miejsca w pomieszczeniu");
                            System.out.println("Ilosc wolnego miejsca w pomieszczeniu "+pomieszczenie.getWolneMiejsce());
                            a=false;
                            b=false;
                        }
                    }


                }else if(userInput1.equals("1")){
                    System.out.println("0 - Zamkniecie programu");
                    System.out.println("Wybrales Rower");
                    System.out.println("Podaj nazwe Roweru");
                    nazwa = scaner1.nextLine();
                    if(userInput1.equals("0")){System.exit(0);}
                    System.out.println("0 - Zamkniecie programu");
                    System.out.println("Podaj ilosc przerzutek");
                    while (a){
                        try{
                            userInput1 = scaner1.nextLine();
                            IloscPrzerzutek = Integer.parseInt(userInput1);
                            if(userInput1.equals("0")){System.exit(0);}
                            boolean m = true;
                            boolean wymiary = true;
                            while (m){
                                System.out.println("0 - Zamkniecie programu");
                                System.out.println("Podaj w jaki sposob chcesz podac wielkosc powierzchni zajmowanej przez przedmiot");
                                System.out.println("1 - Podajac wymiar calego pomieszczenia");
                                System.out.println("2 - Podajac trzy wymiary: szerokosc, dlugosc, wysokosc pomieszczenia");
                                userInput1 = scaner1.nextLine();
                                if(userInput1.equals("0")){System.exit(0);}
                                if(userInput1.equals("2")){
                                    System.out.println("0 - Zamkniecie programu");
                                    System.out.println("Podaj szerokosc pomieszczenia");
                                    userInput1 = scaner1.nextLine();
                                    WielkoscPowierzchni = Double.parseDouble(userInput1);
                                    if(userInput1.equals("0")){System.exit(0);}
                                    System.out.println("0 - Zamkniecie programu");
                                    System.out.println("Podaj dlugosc pomieszczenia");
                                    userInput1 = scaner1.nextLine();
                                    WielkoscPowierzchni = WielkoscPowierzchni*Double.parseDouble(userInput1);
                                    if(userInput1.equals("0")){System.exit(0);}
                                    System.out.println("0 - Zamkniecie programu");
                                    System.out.println("Podaj wysokosc pomieszczenia");
                                    userInput1 = scaner1.nextLine();
                                    WielkoscPowierzchni = WielkoscPowierzchni*Double.parseDouble(userInput1);
                                    if(userInput1.equals("0")){System.exit(0);}
                                    wymiary = false;
                                    m = false;
                                }else if (userInput1.equals("1")){m = false;}
                                else{
                                    System.out.println("Sprobuj jeszcze raz");
                                }
                            }

                            while (a){
                                try{
                                    if(wymiary==true){
                                        System.out.println("0 - Zamkniecie programu");
                                        System.out.println("Podaj wielkosc powierzchni zajmowanej przez rower");
                                        if(userInput1.equals("0")){System.exit(0);}
                                        userInput1 = scaner1.nextLine();
                                        WielkoscPowierzchni= Double.parseDouble(userInput1);
                                    }
                                    if(WielkoscPowierzchni>0){
                                        Rower rower = new Rower(nazwa,IloscPrzerzutek,WielkoscPowierzchni);
                                        pomieszczenie.addPrzedmiot(rower);
                                        System.out.println("Dodano rower do pomieszczenia");
                                        a=false;
                                        b=false;
                                    }else {
                                        System.out.println("Wielkosc powierzchni musi być liczba wieksza od 0");
                                    }
                                }catch (NumberFormatException e){
                                    System.out.println("Podana wielkosc powierzchni nie byla liczba");
                                    System.out.println("Sprobuj jeszcze raz");
                                } catch (TooManyThingsExcepiton tooManyThingsExcepiton) {
                                    System.out.println("Nie mozna dodac przedmiotu za malo miejsca w pomieszczeniu");
                                    System.out.println("Ilosc wolnego miejsca w pomieszczeniu "+pomieszczenie.getWolneMiejsce());
                                    a=false;
                                    b=false;
                                }
                            }
                        }catch (NumberFormatException e){
                            System.out.println("Podana liczba przerzutek nie byla liczba");
                            System.out.println("Sprobuj jeszcze raz");
                        }
                    }


                }else if(userInput1.equals("3")){
                    System.out.println("0 - Zamkniecie programu");
                    System.out.println("Wybrales Samochod");
                    System.out.println("Podaj nazwe Samochodu");
                    nazwa = scaner1.nextLine();
                    if(userInput1.equals("0")){System.exit(0);}
                    RodzajPaliwa rodzajPaliwa = RodzajPaliwa.Dizel;
                    boolean s = true;
                    while (s){
                        System.out.println("0 - Zamkniecie programu");
                        System.out.println("Podaj rodzaj paliwa");
                        System.out.println("d - dizel");
                        System.out.println("b - benzyna");
                        System.out.println("g - gaz");
                        System.out.println("h - hybryda");
                        userInput1 = scaner1.nextLine();
                        if(userInput1.equals("0")){System.exit(0);}
                        if(userInput1.compareTo("d")==0){
                            rodzajPaliwa = RodzajPaliwa.Dizel;
                            s = false;
                        }else if(userInput1.compareTo("b")==0){
                            rodzajPaliwa = RodzajPaliwa.Benzyna;
                            s = false;
                        }else if(userInput1.compareTo("g")==0){
                            rodzajPaliwa = RodzajPaliwa.Gaz;
                            s = false;
                        }else if(userInput1.compareTo("h")==0){
                            rodzajPaliwa = RodzajPaliwa.Hybryda;
                            s = false;
                        }else{
                            System.out.println("Zle podano rodzaj paliwa");
                        }
                    }
                    while (a){
                        boolean m = true;
                        boolean wymiary = true;
                        while (m){
                            System.out.println("0 - Zamkniecie programu");
                            System.out.println("Podaj w jaki sposob chcesz podac wielkosc powierzchni zajmowanej przez przedmiot");
                            System.out.println("1 - Podajac wymiar calego pomieszczenia");
                            System.out.println("2 - Podajac trzy wymiary: szerokosc, dlugosc, wysokosc pomieszczenia");
                            userInput1 = scaner1.nextLine();
                            if(userInput1.equals("0")){System.exit(0);}
                            if(userInput1.equals("2")){

                                boolean ma = true,mb=true,mc=true;
                                while (ma){
                                    try {
                                        System.out.println("0 - Zamkniecie programu");
                                        System.out.println("Podaj szerokosc pomieszczenia");
                                        userInput1 = scaner1.nextLine();
                                        WielkoscPowierzchni = Double.parseDouble(userInput1);
                                        if(userInput1.equals("0")){System.exit(0);}
                                        ma=false;
                                    }catch (NumberFormatException e){
                                        System.out.println("Podany znak nie jest liczba");
                                    }
                                }

                                while (mb){
                                    try{
                                        System.out.println("0 - Zamkniecie programu");
                                        System.out.println("Podaj dlugosc pomieszczenia");
                                        userInput1 = scaner1.nextLine();
                                        WielkoscPowierzchni = WielkoscPowierzchni*Double.parseDouble(userInput1);
                                        if(userInput1.equals("0")){System.exit(0);}
                                        mb=false;
                                    }catch (NumberFormatException e){
                                        System.out.println("Podany znak nie jest liczba");
                                    }
                                }

                                while (mc){
                                    try {
                                        System.out.println("0 - Zamkniecie programu");
                                        System.out.println("Podaj wysokosc pomieszczenia");
                                        userInput1 = scaner1.nextLine();
                                        WielkoscPowierzchni = WielkoscPowierzchni*Double.parseDouble(userInput1);
                                        if(userInput1.equals("0")){System.exit(0);}
                                        mc=false;
                                    }catch (NumberFormatException e){
                                        System.out.println("Podany znak nie jest liczba");
                                    }
                                }

                                wymiary = false;
                                m = false;
                            }else if (userInput1.equals("1")){m = false;}
                            else{
                                System.out.println("Sprobuj jeszcze raz");
                            }
                        }


                        if(userInput1.equals("0")){System.exit(0);}
                        try{
                            if(wymiary==true){
                                System.out.println("Podaj wielkosc powierzchni zajmowanej przez Samochod");
                                userInput1 = scaner1.nextLine();
                                WielkoscPowierzchni= Double.parseDouble(userInput1);
                            }
                            if(WielkoscPowierzchni>0){
                                Samochod samochod = new Samochod(nazwa,rodzajPaliwa,WielkoscPowierzchni);
                                pomieszczenie.addPrzedmiot(samochod);
                                System.out.println("Dodano samochod do pomieszczenia");
                                a=false;
                                b=false;
                            }else {
                                System.out.println("Wielkosc powierzchni musi być liczba wieksza od 0");
                            }
                        }catch (NumberFormatException e){
                            System.out.println("Podana wielkosc powierzchni nie byla liczba");
                        } catch (TooManyThingsExcepiton tooManyThingsExcepiton) {
                            System.out.println("Nie mozna dodac przedmiotu za malo miejsca w pomieszczeniu");
                            System.out.println("Ilosc wolnego miejsca w pomieszczeniu "+pomieszczenie.getWolneMiejsce());
                            a=false;
                            b=false;
                        }
                    }


                }else if(userInput1.equals("0")){
                    System.exit(0);
                }else {
                    System.out.println("Nie wybrano poprawnie rzeczy, ktora chcesz wlozyc do pomieszczenia");
                }
            }
            boolean z = true;
            while (z){
                System.out.println("0 - Zamkniecie programu");
                System.out.println("1 - dodanie przedmiotu do pomieszczenia");
                System.out.println("2 - wyswietlenie zawatosci pomieszczenia");
                System.out.println("3 - Wyjscie z opcji dodawania pomieszczen");
                userInput1 = scaner1.nextLine();
                if(userInput1.equals("1")){
                    ObslugaProgramu.WlozNowePojazdyPrzedmioty22(pomieszczenie);
                    z = false;
                }else if(userInput1.equals("2")){
                    ObslugaProgramu.WyswietlZawartoscPomieszczenia121(pomieszczenie);
                }else if(userInput1.equals("3")){
                    z = false;
                }else  if(userInput1.equals("0")){System.exit(0);
                }else{
                    System.out.println("Wybierz jeszcze raz");
                }
            }
        }


    }
    public static void WyswietlWolnePomieszczenie23(List<Pomieszczenie<Przedmiot>> ListaPomieszczen){
        System.out.println("Wolne pomieszczenia");
        Magazyn magazyn = new Magazyn();
        for(int i = 0;i<ListaPomieszczen.size();i++){
            if((magazyn.getWolnePomieszczenia(ListaPomieszczen.get(i)))==false){
                System.out.println(ListaPomieszczen.get(i).getID()+" - pomieszczenie"+ListaPomieszczen.get(i).getID());
            }
        }
    }
    public static void DostepnePrzedmiotyWPomieszczeniu24(Pomieszczenie pomieszczenie){
        System.out.println("Dostepne przedmioty w pomieszczeniu");
        Magazyn magazyn = new Magazyn();
        int j;
        for( j = 0;j<pomieszczenie.getListaPrzedmiotow().size();j++){
            System.out.println((j+1)+" - "+magazyn.BezEntera((Przedmiot) pomieszczenie.getListaPrzedmiotow().get(j)));
        }
    }
    public static void WyjmijPojazdyPrzedmioty25(Pomieszczenie pomieszczenie){
        System.out.println("Dostepne przedmioty w pomieszczeniu");
        boolean brakPrzedmiotow = false;
        try{
            pomieszczenie.getListaPrzedmiotow().get(0);
        }catch(IndexOutOfBoundsException e){
            brakPrzedmiotow = true;
            System.out.println("Brak przedmiotow w pomieszczeniu");
        }
       if(brakPrzedmiotow==false){
           Magazyn magazyn = new Magazyn();
           int j;
           for( j = 0;j<pomieszczenie.getListaPrzedmiotow().size();j++){
               System.out.println((j+1)+" - "+magazyn.BezEntera((Przedmiot) pomieszczenie.getListaPrzedmiotow().get(j)));
           }
           System.out.println("");
           System.out.println("0 - Zamkniecie programu");
           System.out.println("Podaj numer przedmiotu jaki chcesz wyjac z pomieszczenia:");
           Scanner scaner1 = new Scanner(System.in);
           String userInput1  = scaner1.nextLine();
           if(userInput1.equals("0")){System.exit(0);}
           try{
               if(Integer.parseInt(userInput1)+1>(j+1)||Integer.parseInt(userInput1)+1<=0){
                   System.out.println("Nie znaleziono przedmiotu");
               }else{
                   boolean n = true;
                   Scanner scaner2 = new Scanner(System.in);
                   String userInput2;
                   while(n){
                       System.out.println("0 - Zamkniecie programu");
                       System.out.println("Czy na pewno chcesz wyjac przedmiot z pomieszczenia?");
                       for(int i = 0;i<pomieszczenie.getListaPrzedmiotow().size();i++){
                           if((i+1)==Integer.parseInt(userInput1)) {
                               System.out.println((i+1)+" - "+magazyn.BezEntera((Przedmiot) pomieszczenie.getListaPrzedmiotow().get(i)));
                           }
                       }

                       System.out.println("t - tak");
                       System.out.println("n - nie");
                       scaner2 = new Scanner(System.in);
                       userInput2= scaner2.nextLine();

                       if(userInput2.equals("0")){System.exit(0);}
                       if(userInput2.equals("t")){
                           pomieszczenie.UsunPrzedmiotZListy(Integer.parseInt(userInput1)-1);
                           System.out.println("Wyjeto przedmiot z pomieszczenia");
                           n=false;
                       }else if(userInput2.equals("n")){
                           System.out.println("Przedmiot nie zostal usuniety z pomieszczenia");
                           n=false;
                       }else{
                           System.out.println("Sprobuj jeszcze raz");
                       }
                   }

                   boolean c = true;
                   while (c){
                       System.out.println("0 - Zamkniecie programu");
                       System.out.println("Czy chcesz zobaczyc stan pomieszczenia");
                       System.out.println("t - tak");
                       System.out.println("n - nie");
                       userInput2= scaner2.nextLine();
                       if(userInput2.equals("0")){System.exit(0);}
                       if(userInput2.equals("t")){
                           for(int i = 0;i<pomieszczenie.getListaPrzedmiotow().size();i++){
                               //System.out.println((j+1)+" - "+magazyn.BezEntera(pomieszczenie.getListaPrzedmiotow().get(i)));
                               System.out.println((i+1)+" - "+magazyn.BezEntera((Przedmiot) pomieszczenie.getListaPrzedmiotow().get(i)));
                           }
                           System.out.println("pow"+pomieszczenie.getWolneMiejsce());
                           c = false;
                       }else if(userInput2.equals("n")){
                           c = false;
                       }else{
                           System.out.println("Wybierz jeszcze raz");
                       }
                   }
                   System.out.println("");
               }
           }catch (NumberFormatException e){
               System.out.println("Podany znak nie był liczba");
           }

       }
       }


    public static void WynajmijPomieszczenie26(List<Pomieszczenie<Przedmiot>> ListaPomieszczen,HashMap<Osoba, ArrayList<Pomieszczenie>> baza,Osoba osoba){
        System.out.println("Wolne pomieszczenia");
        Magazyn magazyn = new Magazyn();
        Scanner scaner1;
        String userInput1;
        for(int i = 0;i<ListaPomieszczen.size();i++){
            if((magazyn.getWolnePomieszczenia(ListaPomieszczen.get(i)))==false){
                System.out.println((i+1)+" - pomieszczenie"+ListaPomieszczen.get(i).getID());
            }
        }
        System.out.println("Napisz numer pomieszczenia ktore chcesz wynajac: ");
        scaner1 = new Scanner(System.in);
        userInput1 = scaner1.nextLine();
        try {
            if((magazyn.getWolnePomieszczenia(ListaPomieszczen.get(Integer.parseInt(userInput1)-1)))==false){
                ListaPomieszczen.get(Integer.parseInt(userInput1)-1).setZrezygnujLUBWynajmij(true);
                System.out.println("Wynajeto pomieszczenie:");
                System.out.println((Integer.parseInt(userInput1))+" - pomieszczenie"+ListaPomieszczen.get(Integer.parseInt(userInput1)-1).getID());
                baza.get(osoba).add(ListaPomieszczen.get(Integer.parseInt(userInput1)-1));
            }else{
                System.out.println("Wybrano pomieszczenie, ktore nie jest do wynajecia");

            }

        }catch (IndexOutOfBoundsException e){
            System.out.println("Wybrano numer pomieszczenia ktorego nie ma w magazynie");
        }

            ObslugaProgramu.ZapiszAktualnyStanMagazynu27(ListaPomieszczen,baza);

    }
    public static void ZapiszAktualnyStanMagazynu27(List<Pomieszczenie<Przedmiot>> ListaPomieszczen,HashMap<Osoba, ArrayList<Pomieszczenie>> baza){
        Collections.sort(ListaPomieszczen);

        for (Pomieszczenie<Przedmiot> ListaPomieszczen1 : ListaPomieszczen) {
            List<Przedmiot> getListaPrzedmiotow = ListaPomieszczen1.getListaPrzedmiotow();
            Collections.sort(getListaPrzedmiotow);
        }

        for (Map.Entry<Osoba, ArrayList<Pomieszczenie>> bazaEntry:baza.entrySet()) {
            Collections.sort(bazaEntry.getValue());
            //System.out.println(bazaEntry.getKey()+ " wynajmuje "+bazaEntry.getValue());
        }

        File file = new File("stanMagazynu.txt");
        Magazyn magazyn = new Magazyn();
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Nie udalo sie utworzyc pliku");
        }
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.println("Lista pomieszczen");
            writer.println("");
            for(int i = 0;i<ListaPomieszczen.size();i++){
                writer.println(magazyn.getInfoPomieszczenieBezListy(ListaPomieszczen.get(i)));
            }
            writer.println("");
            writer.println("Osoby wraz z wynajmowanymi pomieszczeniami: ");
            writer.println("");
            for (Map.Entry<Osoba, ArrayList<Pomieszczenie>> bazaEntry:baza.entrySet()) {
                writer.println((bazaEntry.getKey()+ " wynajmuje "+bazaEntry.getValue()));
            }
            writer.println("");
            writer.println("Infromacja o przedmiotach znajdujacych sie w pomieszczeniach");
            for(int i = 0;i<ListaPomieszczen.size();i++){
                writer.println(magazyn.getInfoPomieszczenieZLista(ListaPomieszczen.get(i)));
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Zapisano stan magazynu");
        //System.exit(0);
        /*
        Magazyn magazyn = new Magazyn();
        System.out.println("Lista pomieszczen");
        System.out.println("");
        for(int i = 0;i<ListaPomieszczen.size();i++){
            System.out.println(magazyn.getInfoPomieszczenieBezListy(ListaPomieszczen.get(i)));
        }
        System.out.println("");
        System.out.println("Osoby wraz z wynajmowanymi pomieszczeniami: ");
        System.out.println("");
        for (Map.Entry<Osoba, ArrayList<Pomieszczenie>> bazaEntry:baza.entrySet()) {
            System.out.println(bazaEntry.getKey()+ " wynajmuje "+bazaEntry.getValue());
        }
        System.out.println("");
        System.out.println("Infromacja o przedmiotach znajdujacych sie w pomieszczeniach");
        for(int i = 0;i<ListaPomieszczen.size();i++){
            System.out.println(magazyn.getInfoPomieszczenie(ListaPomieszczen.get(i)));
        }
        */
    }




}
