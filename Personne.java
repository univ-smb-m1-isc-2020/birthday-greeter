public class Personne {

    ArrayList<Personne> pList = new ArrayList<>();

    private String name;
    private String email;
    private Date birthday;

    public Personne(String name, String email, Date birthday) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public boolean isBirthday() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = new Date();  
        System.out.println(formatter.format(date)); 
        if(this.birthday.compareTo(date) == 0) 
            EmailHelper.sendEmail(this); 
    }

    private ArrayList<Personne> txtToPersonne(File file) {
        int lastSemiCol = 0;
        int nbSemiCol = 0;
  
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
        String s;
        while ((s = br.readLine()) != null) {
            String[] infos = s.split(";", 3); 

            String name = infos.get(0);
            String email = infos.get(1);
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(infos.get(2));

            pList.add(new Personne(name, email, birthday));
        }
        return pList;
    }
}