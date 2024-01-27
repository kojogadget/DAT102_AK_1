package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import java.util.Scanner;

public class Tekstgrensesnitt {
    private Scanner input = new Scanner(System.in);

    // Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
    public Film lesFilm(){
        Film film = new Film();

        System.out.println();
        System.out.print("Tittel: ");
        String tittel = input.nextLine();
        film.setTittel(tittel);

        System.out.print("Produsent: ");
        String produsent = input.nextLine();
        film.setProdusent(produsent);

        System.out.print("Sjanger: ");
        Sjanger sjanger = Sjanger.finnSjanger(input.nextLine());
        film.setSjanger(sjanger);

        System.out.print("Filmselskap: ");
        String filmselskap = input.nextLine();
        film.setFilmSelskap(filmselskap);

        System.out.print("Utgivelsesår: ");
        int utgivelsesår = Integer.valueOf(input.nextLine());
        film.setAarLansert(utgivelsesår);
        System.out.println();

        return film;
    }
    // Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {
        System.out.println(film.toString());
    }
    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] soek = arkiv.soekTittel(delstreng);
        for (Film film : soek) {
            this.skrivUtFilm(film);
            System.out.println();
        }
    }
    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] soek = arkiv.soekProdusent(delstreng);
        for (Film film : soek) {
            this.skrivUtFilm(film);
            System.out.println();
        }
    }
    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
    // og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println();
        System.out.println("Antall filmer totalt: " + arkiv.antall());
        System.out.println("Antall actionfilmer: " + arkiv.antall(Sjanger.ACTION));
        System.out.println("Antall dramafilmer: " + arkiv.antall(Sjanger.DRAMA));
        System.out.println("Antall Sci-Fi filmer: " + arkiv.antall(Sjanger.SCIFI));
        System.out.println();
    }
    // osv ... andre metoder
    public int lesHeltall(String ledetekst) {
        System.out.print(ledetekst);
        int tall = Integer.valueOf(input.nextLine());
        return tall;
    }

    public String lesTekst(String ledetekst) {
        System.out.println();
        System.out.print(ledetekst);
        String tekst = input.nextLine();
        System.out.println();
        return tekst;
    }

    public void skrivUtMeny() {
        System.out.println("Valgmeny:\n  1 - Legg til film\n  2 - Slett film\n  3 - Søk etter filmtittel\n  4 - Søk etter filmprodusent\n  5 - Skriv ut statistikk");
    }
}
