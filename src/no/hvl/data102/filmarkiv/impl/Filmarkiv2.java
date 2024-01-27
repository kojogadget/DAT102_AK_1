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
		for (LinearNode<Film> node = this.start; node != null; node = node.getNeste()) {
			if (node.getData().getFilmNr() == nr) {
				return node.getData();
			}
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (this.start == null) {
			this.start = new LinearNode<Film>(nyFilm);
			this.antall++;
			return;
		}
		for (LinearNode<Film> node = this.start; node != null; node = node.getNeste()) {
			if (node.getNeste() == null) {
				node.setNeste(new LinearNode<Film>(nyFilm));
				this.antall++;
				break;
			}
		}
	}

	@Override
	public boolean slettFilm(int filmnr) {
		Boolean slettet = false;
		for (LinearNode<Film> node = this.start; node != null; node = node.getNeste()) {
			if (this.start.getData().getFilmNr() == filmnr) {
				this.start = this.start.getNeste();
				this.antall--;
				slettet = true;
				continue;
			}
			if (node.getNeste() != null && node.getNeste().getData().getFilmNr() == filmnr) {
				node.setNeste(node.getNeste().getNeste());
				this.antall--;
				slettet = true;
			}
		}
		int i = 1;
		for (LinearNode<Film> node = this.start; node != null; node = node.getNeste()) {
			node.getData().setFilmNr(i);
			i++;
		}
		return slettet;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] filmer = new Film[this.antall];
		int i = 0;
		for (LinearNode<Film> node = this.start; node != null; node = node.getNeste()) {
			if (node.getData().getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				filmer[i] = node.getData();
				i++;
			}
		}
		return this.trimTab(filmer, i);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] filmer = new Film[this.antall];
		int i = 0;
		for (LinearNode<Film> node = this.start; node != null; node = node.getNeste()) {
			if (node.getData().getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
				filmer[i] = node.getData();
				i++;
			}
		}
		return this.trimTab(filmer, i);
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antall = 0;
		for (LinearNode<Film> node = this.start; node != null; node = node.getNeste()) {
			if (node.getData().getSjanger() == sjanger) {
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
