import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Site {

    static String types[] = {"bar", "restaurant"};

    static ArrayList<Integer> phoneNumbers = new ArrayList<>();
    static ArrayList<Integer> siteCodes = new ArrayList<>();

    static int siteCodesIndex = 0;

    static {

        for(int i = 100; i < 999; i++)
            siteCodes.add(i);

        Collections.shuffle(phoneNumbers);
        Collections.shuffle(siteCodes);

    }

    int siteCode;
    String type;
    String address;
    int phone;

    Site() {
        siteCode = siteCodes.get(siteCodesIndex++);
        type = types[(int) Math.round(Math.random())];
        phone = Lists.getPhoneNumber();
        address = Lists.getAddress();

    }

}
