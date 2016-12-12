package parametres;

/**
 *
 * @author Elias Touil <info@eliastouil.com>
 */
public interface Parametre {
	int getMin();
	int getMax();
	double traduireValeur(double i);
	void modifier(double i);
	void ajouter();
	void retirer();
	int getValeurDefaut();
	double valider(double i);
	void mettreAJour(double i);
	String getNom();
}
