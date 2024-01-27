package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {
	private int filmNr;
	private String produsent;
	private String tittel;
	private int aarLansert;
	private Sjanger sjanger;
	private String filmSelskap;
	
	public Film() {
		this.filmNr = 0;
		this.produsent = null;
		this.tittel = null;
		this.aarLansert = 0;
		this.sjanger = null;
		this.filmSelskap = null;
	}
	
	public Film(int filmNr, String produsent, String tittel, int aarLansert, Sjanger sjanger, String filmSelskap) {
		this.filmNr = filmNr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.aarLansert = aarLansert;
		this.sjanger = sjanger;
		this.filmSelskap = filmSelskap;
	}

	public Integer getFilmNr() {
		return filmNr;
	}

	public void setFilmNr(int filmNr) {
		this.filmNr = filmNr;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public Integer getAarLansert() {
		return aarLansert;
	}

	public void setAarLansert(int aarLansert) {
		this.aarLansert = aarLansert;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmSelskap() {
		return filmSelskap;
	}

	public void setFilmSelskap(String filmSelskap) {
		this.filmSelskap = filmSelskap;
	}

	public String toString() {
		return "FilmNr: " + filmNr + "\nProdusent: " + produsent + "\nTittel: " + tittel + "\nUtgivelsesår: "
				+ aarLansert + "\nSjanger: " + Sjanger.toString(sjanger) + "\nFilmselskap: " + filmSelskap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmNr);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(filmNr, other.filmNr);
	}
	
	
}
