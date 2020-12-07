public class Personne {
    String prénom;
    String mail;
    String dateNaissance;

    Personne(String _prénom, String _mail, String _dateNaissance){
        this.prénom = _prénom;
        this.mail = _mail;
        this.dateNaissance = _dateNaissance;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "prénom='" + prénom + '\'' +
                ", mail='" + mail + '\'' +
                ", dateNaissance='" + dateNaissance + '\'' +
                '}';
    }

    public String getPrénom() {
        return prénom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
