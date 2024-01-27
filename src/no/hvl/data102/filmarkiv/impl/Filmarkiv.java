package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

	private Film[] Filmarkiv;
	
	public Filmarkiv(int maksAntall) {
		this.Filmarkiv = new Film[maksAntall];
	}

	private void utvidFilmarkiv() {
		Film[] tmp = this.Filmarkiv;
		int maksAntall = this.Filmarkiv.length * 2;
		this.Filmarkiv = new Film[maksAntall];
		for (Film film : tmp) {
			this.Filmarkiv[this.antall()] = film;
		}
	}

	@Override
	public Film finnFilm(int nr) {
		if (this.antall() == 0) return null;
		for (Film film : this.Filmarkiv) {
			if (film == null) break;
			if (film.getFilmNr() == nr) return film;
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		for (Film film : this.Filmarkiv) {
			if (film == null) break;
			if (film.equals(nyFilm)) return;
		}
		if (this.antall() == this.Filmarkiv.length) this.utvidFilmarkiv();
		this.Filmarkiv[this.antall()] = nyFilm;
		
	}

	@Override
	public boolean slettFilm(int filmnr) {
		if (this.finnFilm(filmnr) == null) return false;
		Boolean slettet = false;
		Film[] tmp = new Film[this.antall()];
		int i = 0;
		for (Film film : this.Filmarkiv) {
			if (film == null) break;
			if (film.getFilmNr() == filmnr) {
				slettet = true;
				continue;
			}
			tmp[i] = film;
			film.setFilmNr(i);
			i++;
		}
		if (slettet) {
			this.Filmarkiv = tmp;
			return true;
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		if (this.antall() == 0) return null;

		int antall = 0;
		for (Film film : this.Filmarkiv) {
			if (film == null) break;
			if (film.getTittel().contains(delstreng)) antall++;
		}

		Film[] filmer = new Film[antall];
		int i = 0;
		for (Film film : this.Filmarkiv) {
			if (film == null) break;
			if (film.getTittel().contains(delstreng)) {
				filmer[i] = film;
				i++;
			}
		}
		return filmer;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		if (this.antall() == 0) return null;

		int antall = 0;
		for (Film film : this.Filmarkiv) {
			if (film == null) break;
			if (film.getProdusent().contains(delstreng)) antall++;
		}

		Film[] filmer = new Film[antall];
		int i = 0;
		for (Film film : this.Filmarkiv) {
			if (film == null) break;
			if (film.getProdusent().contains(delstreng)) {
				filmer[i] = film;
				i++;
			}
		}
		return filmer;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antall = 0;
		for (Film film : this.Filmarkiv) {
			if (film == null) break;
			if (film.getSjanger() == sjanger) antall++;
		}
		return antall;
	}

	@Override
	public int antall() {
		int ant = 0;
		for (Film film : this.Filmarkiv) {
			if (film == null) return ant;
			ant++;
		}
		return ant;
	}

}
