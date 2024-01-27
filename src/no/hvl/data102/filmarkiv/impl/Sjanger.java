package no.hvl.data102.filmarkiv.impl;

public enum Sjanger {
	ACTION, DRAMA, HISTORY, SCIFI;

	public static Sjanger finnSjanger(String navn) {
		for (Sjanger s : Sjanger.values()) {
			if (s.toString().equals(navn.toUpperCase())) {
				return s;
			}
		}
		return null;
	}

	public static String toString(Sjanger sjanger) {
		switch (sjanger) {
		case ACTION:
			return "Action";
		case DRAMA:
			return "Drama";
		case HISTORY:
			return "History";
		case SCIFI:
			return "Sci-Fi";
		default:
			return "Ukjent";
		}
	}
}
