import java.util.ArrayList;

public class Client {

    static int[] clientIds = new int[10000];
    static int clientIdIndex = 0;

    static {
        int start = 100000;
        int limit = 999999;

        for(int i = start, j = 0; j < clientIds.length; i += (limit - start) / clientIds.length, j++)
            clientIds[j] = i + (int) (Math.random() * (limit - start) / clientIds.length);
    }

    int clientId;
    String name;
    int phone;
    String address;

    Client() {
        clientId = getClientId();
        name = Lists.getName();
        name = name.substring(0, 1) + name.toLowerCase().substring(1);
        phone = Lists.getPhoneNumber();
        address = Lists.getAddress();
    }

    public int getClientId() {
        return clientIds[clientIdIndex++];
    }

}
