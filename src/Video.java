import java.util.ArrayList;
import java.util.Collections;

public class Video {

    static ArrayList<Integer> videoCodes = new ArrayList<>();
    static ArrayList<Integer> videoLengths = new ArrayList<>();

    static int videoCodeIndex = 0;
    static int videoLengthIndex = 0;

    static {
        for(int i = 1; i < 999999; i++)
            videoCodes.add(i);

        for(int i = 1; i < 600; i++)
            videoLengths.add(i);

        Collections.shuffle(videoCodes);
        Collections.shuffle(videoLengths);
    }

    int videoCode;
    int videoLength;

    Video() {
        videoCode = videoCodes.get(videoCodeIndex++);
        videoLength = videoLengths.get(videoLengthIndex++);
    }

}
