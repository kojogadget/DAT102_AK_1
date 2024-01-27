package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

class FilmarkivTest {
	
	static Film film1 = new Film(1, "MCU", "Iron Man", 2008, Sjanger.ACTION, "Marvel");
	static Film film2 = new Film(2, "MCU", "Iron Man 2", 2010, Sjanger.ACTION, "Marvel");
	static Film film3 = new Film(3, "MCU", "Captain America", 2011, Sjanger.ACTION, "Marvel");
	
	@Test
	void testConstructor() {
		FilmarkivADT testFilmArkiv = new Filmarkiv(10);
		
		testFilmArkiv.leggTilFilm(film1);
		assertNotNull(testFilmArkiv);
	}

	
	@Test
	void testFinnFilm() {
		FilmarkivADT testFilmArkiv = new Filmarkiv(10);
		
		assertEquals(null, testFilmArkiv.finnFilm(0));
		testFilmArkiv.leggTilFilm(film1);
		testFilmArkiv.leggTilFilm(film2);
		assertEquals(film1, testFilmArkiv.finnFilm(1));
	}	
	
	@Test
	void testAntall() {
		FilmarkivADT testFilmArkiv = new Filmarkiv(10);
		
		assertEquals(0, testFilmArkiv.antall());
		testFilmArkiv.leggTilFilm(film1);
		assertEquals(1, testFilmArkiv.antall());
	}

	@Test
	void testLeggTilFilm() {
		FilmarkivADT testFilmArkiv = new Filmarkiv(10);
		
		testFilmArkiv.leggTilFilm(film1);
		assertEquals(1, testFilmArkiv.antall());
	}

	@Test
	void testSlettFilm() {
		FilmarkivADT testFilmArkiv = new Filmarkiv(10);
		
		testFilmArkiv.leggTilFilm(film1);
		testFilmArkiv.leggTilFilm(film2);
		testFilmArkiv.leggTilFilm(film3);
		assertEquals(3, testFilmArkiv.antall());
		assertFalse(testFilmArkiv.slettFilm(5));
		assertTrue(testFilmArkiv.slettFilm(2));
		assertEquals(2, testFilmArkiv.antall());
	}

	@Test
	void testSoekTittel() {
		FilmarkivADT testFilmArkiv = new Filmarkiv(10);
		
		testFilmArkiv.leggTilFilm(film1);
		testFilmArkiv.leggTilFilm(film2);
		testFilmArkiv.leggTilFilm(film3);
		assertEquals(3, testFilmArkiv.antall());
		assertEquals(2, testFilmArkiv.soekTittel("Iron").length);
	}

	@Test
	void testSoekProdusent() {
		FilmarkivADT testFilmArkiv = new Filmarkiv(10);
		
		testFilmArkiv.leggTilFilm(film1);
		testFilmArkiv.leggTilFilm(film2);
		testFilmArkiv.leggTilFilm(film3);
		assertEquals(3, testFilmArkiv.antall());
		assertEquals(3, testFilmArkiv.soekProdusent("MCU").length);
	}

	@Test
	void testAntallSjanger() {
		FilmarkivADT testFilmArkiv = new Filmarkiv(10);
		
		testFilmArkiv.leggTilFilm(film1);
		testFilmArkiv.leggTilFilm(film2);
		testFilmArkiv.leggTilFilm(film3);
		assertEquals(3, testFilmArkiv.antall());
		assertEquals(3, testFilmArkiv.antall(Sjanger.ACTION));
	}
	
}
