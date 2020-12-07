public class Main {
    public static void main(String[] args) {
        File file = new File(".\\birthdays.txt");
        ArrayList<Personne> pList = Personne.txtToPersonne(file);
        for(int i = 0; i < pList.size(); i++) {
            if(pList.get(i).isBirthday())
                EmailHelper.sendEmail(pList.get(i));
        }
    }
}

