public class Personne
{
    private String nom;
    private String email;
    private String dateAnniv;
    public Personne(String nom, String email, String dateAnniv)
    {
        this.nom = nom;
        this.email = email;
        this.dateAnniv = dateAnniv;
    }

    public String getNom()
    {
        return nom;
    }

    public String getEmail()
    {
        return email;
    }

    public String getDateAnniv()
    {
        return dateAnniv;
    }
}