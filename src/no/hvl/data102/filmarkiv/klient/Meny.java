package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv){
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start(){
        // legg inn en del forhåndsdefinerte filmer for å teste metodene
        this.filmarkiv.leggTilFilm(new Film(1, "MCU", "Iron Man", 2008, Sjanger.ACTION, "Marvel"));
        this.filmarkiv.leggTilFilm(new Film(2, "MCU", "Iron Man 2", 2010, Sjanger.ACTION, "Marvel"));
        this.filmarkiv.leggTilFilm(new Film(3, "MCU", "Captain America", 2011, Sjanger.ACTION, "Marvel"));
        this.filmarkiv.leggTilFilm(new Film(4, "MCU", "Thor", 2011, Sjanger.ACTION, "Marvel"));
        this.filmarkiv.leggTilFilm(new Film(5, "MCU", "The Avengers", 2012, Sjanger.ACTION, "Marvel"));
        
        this.filmarkiv.leggTilFilm(new Film(6, "WB", "Frihetens regn", 1994, Sjanger.DRAMA, "Warner Bros"));
        this.filmarkiv.leggTilFilm(new Film(7, "Paramount", "Godfather", 1972, Sjanger.DRAMA, "Paramount Pictures"));
        this.filmarkiv.leggTilFilm(new Film(8, "WB", "Interstellar", 2014, Sjanger.DRAMA, "Warner Bros"));
        this.filmarkiv.leggTilFilm(new Film(9, "Paramount", "Forrest Gump", 1994, Sjanger.DRAMA, "Paramount Pictures"));
        this.filmarkiv.leggTilFilm(new Film(10, "WB", "The Dark Knight", 2008, Sjanger.ACTION, "Warner Bros"));
        
        System.out.println("Velkommen til Filmarkiv!");
        System.out.println();
        while (true) {
            tekstgr.skrivUtMeny();
            int valg = tekstgr.lesHeltall("Valg: ");
            switch (valg) {
                case 1:
                    Film film = tekstgr.lesFilm();
                    film.setFilmNr(this.filmarkiv.antall() + 1);
                    this.filmarkiv.leggTilFilm(film);
                    break;
                case 2:
                    int filmnr = tekstgr.lesHeltall("Hvilket filmnummer vil du slette?: ");
                    if (this.filmarkiv.slettFilm(filmnr)) {
                        System.out.println("Filmen ble slettet!");
                    } else {
                        System.out.println("Filmen ble ikke funnet!");
                    }
                    break;
                case 3:
                    String delstreng = tekstgr.lesTekst("Søk etter filmtittel: ");
                    tekstgr.skrivUtFilmDelstrengITittel(this.filmarkiv, delstreng);
                    break;
                case 4:
                    String produsent = tekstgr.lesTekst("Søk etter filmprodusent: ");
                    tekstgr.skrivUtFilmProdusent(this.filmarkiv, produsent);
                    break;
                case 5:
                    tekstgr.skrivUtStatistikk(this.filmarkiv);
                    break;
                default:
                    System.out.println("Ugyldig valg!");
                    break;
            }
            System.out.println();
        }
    }
}
