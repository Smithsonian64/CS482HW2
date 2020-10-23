import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

public class FillDatabase {



    public static void main(String[] args) {
        ArrayList<Video> videos = new ArrayList<>();
        ArrayList<Site> sites = new ArrayList<>();
        ArrayList<Model> models = new ArrayList<>();
        ArrayList<DigitalDisplay> digitalDisplays = new ArrayList<>();
        ArrayList<Client> clients = new ArrayList<>();


        for(int i = 0; i < 200; i++)
            videos.add(new Video());

        for(int i = 0; i < 200; i++) {
            sites.add(new Site());
        }

        for(int i = 0; i < 50; i++) {
            models.add(new Model());
        }

        for(int i = 0; i < 200; i++) {
            digitalDisplays.add(new DigitalDisplay(models.get((int)Math.floor(Math.random() * models.size()))));
        }

        for(int i = 0; i < 1000; i++) {
            clients.add(new Client());
            System.out.println(clients.get(i).name);
        }

    }

}
