package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

	private int antall;
	private LinearNode<Film> start;

	public Filmarkiv2() {
		this.antall = 0;
		this.start = null;
	}

	public Filmarkiv2(LinearNode<Film> start) {
		this.antall = 1;
		this.start = start;
	}

	private Film[] trimTab(Film[] tab, int n) { 
		Film[] tabTrim = new Film[n];
		int i = 0;
		while (i < n) {
			tabTrim[i] = tab[i];
			i++;
		}
		return tabTrim;
	}

	@Override
	public Film finnFilm(int nr) {
		for (LinearNode<Film> node = this.start; node != null; node = node.neste) {
			if (node.data.getFilmNr() == nr) {
				return node.data;
			}
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (this.start == null) {
			this.start = new LinearNode<>(nyFilm);
			this.antall++;
			return;
		}
		antall++;
		LinearNode<Film> node = new LinearNode<>(nyFilm);
		node.data.setFilmNr(this.antall);
		node.neste = this.start;
		this.start = node;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		Boolean slettet = false;

		// Sjekk første node
		if (this.start.data.getFilmNr() == filmnr) {
			this.start = this.start.neste;
			this.antall--;
			slettet = true;
		}

		// Sjekk resten av nodene
		for (LinearNode<Film> node = this.start; node != null; node = node.neste) {
			if (node.neste != null && node.neste.data.getFilmNr() == filmnr) {
				node.neste = node.neste.neste;
				this.antall--;
				slettet = true;
			}
		}

		// Setter filmnr på nytt
		if (slettet) {
			int i = 1;
			for (LinearNode<Film> node = this.start; node != null; node = node.neste) {
				node.data.setFilmNr(i);
				i++;
			}
		}

		return slettet;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] filmer = new Film[this.antall];

		int i = 0;
		for (LinearNode<Film> node = this.start; node != null; node = node.neste) {
			if (node.data.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				filmer[i] = node.data;
				i++;
			}
		}

		return this.trimTab(filmer, i);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] filmer = new Film[this.antall];

		int i = 0;
		for (LinearNode<Film> node = this.start; node != null; node = node.neste) {
			if (node.data.getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
				filmer[i] = node.data;
				i++;
			}
		}

		return this.trimTab(filmer, i);
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antall = 0;
		for (LinearNode<Film> node = this.start; node != null; node = node.neste) {
			if (node.data.getSjanger() == sjanger) {
				antall++;
			}
		}

		return antall;
	}

	@Override
	public int antall() {
		return this.antall;
	}

}
