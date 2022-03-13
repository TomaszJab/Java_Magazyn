import java.util.ArrayList;
import java.util.List;

public class Osoba {

    private String imie, nazwisko;
    private String pesel, DataUrodzenia,DataPierwszegoNajmu;
    private int RokUrodzenia;

    public Osoba(String imie, String nazwisko, String pesel, String dataUrodzenia, int rokUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.DataUrodzenia = dataUrodzenia;
        this.RokUrodzenia = rokUrodzenia;
        this.DataPierwszegoNajmu="0";

    }


    public void setDataPierwszegoNajmu(String dataPierwszegoNajmu) {
        DataPierwszegoNajmu = dataPierwszegoNajmu;
    }

    public String getDataPierwszegoNajmu() throws NeverRentException {
        if(DataPierwszegoNajmu.equals("0")){
            throw new NeverRentException();
        }
        return DataPierwszegoNajmu;
    }

    public String getNazwisko(){
        return nazwisko;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                ", DataUrodzenia='" + DataUrodzenia + '\'' +
                ", DataPierwszegoNajmu='" + DataPierwszegoNajmu + '\'' +
                ", RokUrodzenia=" + RokUrodzenia +
                '}';
    }
}
