package Affichage;

public class Plateau	{
  private final PlateauFenetre plateauFenetre;
  
  public Plateau(int largeur, int hauteur, PlateauCase[][] plateauCases)
  {
    this.plateauFenetre = new PlateauFenetre(largeur, hauteur, plateauCases);
  }
  
  public void placerPiece(PlateauPiece piece)
  {
    this.plateauFenetre.placerPiece(piece);
  }
  
  public void rafraichir()
  {
    this.plateauFenetre.rafraichir();
  }
}
