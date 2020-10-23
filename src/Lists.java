import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Lists {

    static int phoneNumbers[] = new int[10000];
    static int phoneNumbersIndex = 0;

    static String directions[] = {" N", " NE", " E", " SE", " S", " SW", " W", " NW", ""};
    static String placeTypes[] = {" BLVD", " CTR", " CIR", " XING", " HWY", " JCT", " LOOP", " MTN", " PKWY", " PL", " RD", " ST", ""};
    static ArrayList<String> placeNames = new ArrayList<>();
    static ArrayList<Integer> addressNumbers = new ArrayList<>();
    static ArrayList<String> addresses = new ArrayList<>();
    static ArrayList<String> names = new ArrayList<>();
    static int namesIndex = 0;
    static int addressIndex = 0;


    static {

        int start = 100000000;
        int limit = 999999999;
        for(int i = 0, j = 100000000; i < phoneNumbers.length; i++, j += ((limit - start) / phoneNumbers.length)) {
            phoneNumbers[i] = j + (int)(Math.random() * ((limit - start) / phoneNumbers.length));
        }

        BufferedReader reader;
        BufferedReader reader2;
        try {
            reader = new BufferedReader(new FileReader("nouns.txt"));
            reader2 = new BufferedReader(new FileReader("names.txt"));
            String line = reader.readLine();
            while(line != null) {
                placeNames.add(line);
                line = reader.readLine();
            }
            reader.close();
            line = reader2.readLine();
            while(line != null) {
                names.add(line);
                line = reader2.readLine();
            }
            reader2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 1; i < 9999; i++)
            addressNumbers.add(i);

        Collections.shuffle(placeNames);
        Collections.shuffle(addressNumbers);
        Collections.shuffle(names);

        for(int i = 0, j = 0; i < addressNumbers.size() && j < placeNames.size(); i++, j++) {
            addresses.add(
                    addressNumbers.get(i) +
                    directions[(int) Math.floor(Math.random() * directions.length)] +
                    " " + placeNames.get(j) +
                    placeTypes[(int) Math.floor(Math.random() * placeTypes.length)]);
        }

    }

    public static String getAddress() {
        return addresses.get(addressIndex++);
    }

    public static int getPhoneNumber() {
        return phoneNumbers[phoneNumbersIndex++];
    }

    public static String getName() {
        return names.get(namesIndex++);
    }
}
