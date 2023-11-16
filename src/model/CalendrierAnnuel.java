package model;

public class CalendrierAnnuel {
	private Mois[] calendrier = new Mois[12];
	
	public CalendrierAnnuel() {
		String[][] mois = new String[][] {{"Janvier","31"},{"Février","28"},{"Mars","31"},{"Avril","30"}
		,{"Mai","31"},{"Juin","30"},{"Juillet","31"},{"Août","31"},{"Septembre","30"},{"Octobre","31"}
		,{"Novembre","30"},{"Décembre","31"}};
		for(int i = 0; i < calendrier.length; i++) {
			calendrier[i] = new Mois(mois[i][0],Integer.valueOf(mois[i][1]));
		}
	}
	
	private class Mois {
		private String mois;
		private boolean[] jours;
		
		private Mois(String nom, int nbJours) {
			this.mois = nom;
			jours = new boolean[nbJours];
			for (int i = 0; i < nbJours; i++) {
				jours[i] = false;
			}
		}
		
		private boolean estLibre(int jour) {
			//renvoie true s'il n'y a pas de réservation ce jour là
			return !jours[jour-1];
		}
		
		private void reserver(int jour) throws IllegalStateException {
			if (estLibre(jour-1)) {
				jours[jour-1] = true;
			} else {
				throw new IllegalStateException("Jour déjà réservé");
			}
		}
	}
	
	//Méthodes
	public boolean estLibre(int jour, int mois) {
		return calendrier[mois-1].estLibre(jour);
	}
	
	public boolean reserver(int jour, int mois) {
		Mois moisRes = calendrier[mois-1];
		if (moisRes.estLibre(jour)){
			moisRes.reserver(jour);
			return true;
		} else {
			return false;
		}
	}
}
	
