import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.IOExeption;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDateTime;  

public class emailSender
{
    public static ArrayList<Personne> fileParser()
    {
        BufferedReader lecteur;

        ArrayList<Personne> listeEmail = new ArrayList<Personne>();

        try
        {
            lecteur = new BufferedReader(new FileReader("birthday-greeter.txt"));
            String ligne = lecteur.readline();
            while (ligne != null)
            {
                String[] token = line.split(";");

                listeEmail.add(new Personne(token[0], token[1], token [2]));
            }
            lecteur.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static boolean dateCorrespond(int indexe, ArrayList<Personne> liste)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateAnniv = sdf.parse(liste.get(indexe).getDateAnniv());
        Date ajd = LocalDateTime.now();

        if (ajd.compareTo(dateAnniv) == 0)
            return true;
        else
            return false;
       }

    public static void main(String[] args) throws Exeption
    {
        ArrayList<Personne> listeEmail = new ArrayList<Personne>();
        listeEmail = fileParser();

        String de = "machin@hotmail.net";
        String host = "localhost";

        Properties propriete = System.getProperties();

        propriete.setProperty("mail.smpt.host", host);

        Session session = Session.getDefaultInstance(propriete);

        try
        {
            for (int i = 0; i < listeEmail.size(); i++)
            {
                if (dateCorrespond(i, listeEmail) )
                {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(de));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(listeEmail.get(i).getEmail()));
                    message.setSubject("anniversaire");
                    String texte = "bon anniversaire" + listeEmail.get(i).getName();
                    message.setText(texte);

                    Transport.send(message);

                }
            }
        }
        catch(MessagingException mex)
        {
            mex.printStackTrace();
        }
    }
}