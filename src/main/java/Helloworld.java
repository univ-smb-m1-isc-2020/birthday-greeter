import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.internet.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import javax.mail.Session;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Helloworld {

    public static void main(String[] args) {

        //Liste de personnes
        ArrayList<Person> persons = new ArrayList<Person>();
        String filename = "C:\\Users\\Tom\\Desktop\\Fac\\Info806\\birthday-greeter\\src\\main\\java\\birthdays.txt";
        persons = readFile(filename);
        System.out.println(persons);

        //Date du jour
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now).toString();

        System.out.println(date);

        //Envoie des mails
        VerifIfSendEmail(persons,date);

    }


    private static ArrayList<Person> readFile(String filename)
    {
        ArrayList<Person> records = new ArrayList<Person>();

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null)
            {
                String personString = line;
                String lines[] = personString.split(";");
                records.add(new Person(lines[0],lines[1],lines[2]));


            }
            reader.close();
            return records;
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
            return null;
        }
    }

    public static void VerifIfSendEmail(ArrayList<Person> persons, String dateToday){
        for (int i = 0; i < persons.size(); i++) {


            String date = persons.get(i).getDate();
            String lines[] = date.split("-");
            date = lines[1] + "-" + lines[2];

            if (date.equals(dateToday)) {
                sendEmail(persons.get(i));
            }
        }

    }

    private static void sendEmail(Person person) {
        System.out.println("Bon anniversaire " + person.getName() + " on lui envoie un mail a l'adresse : " + person.getEmail());

        Properties props = System.getProperties();
        String smtpHostServer = "smtp.example.com";
        props.put("mail.smtp.host", smtpHostServer);
        Session session = Session.getInstance(props, null);

        try
        {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

            msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

            msg.setSubject("mot gentil", "UTF-8");

            msg.setText("Happy birthday " + person.getName() + " !!", "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(person.getEmail(), false));
            System.out.println("Message is ready");
            Transport.send(msg);

            System.out.println("EMail Sent Successfully!!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

}
