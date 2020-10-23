import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Model {
    String modelNo;
    float width;
    float height;
    float weight;
    float depth;
    float screenSize;

    static ArrayList<String> modelNos = new ArrayList<>();

    static int modelNoIndex = 0;

    static {






        for(int i = 0; i < 200; i++) {

            ArrayList<ArrayList<Character>> characterCombos = new ArrayList<>();

            for(int j = 0; j < 10; j++){
                characterCombos.add(new ArrayList<Character>());
                for(int k = 0; k < 26; k++) {
                    characterCombos.get(j).add((char)(97 + k));
                }
                Collections.shuffle(characterCombos.get(j));
            }

            String line = "";
            for(int j = 0; j < 10; j++) {
                line += (String.valueOf(characterCombos.get(j).get(0)));

            }
            modelNos.add(line);
        }
    }

    Model() {

        NumberFormat formatter = new DecimalFormat("####.##");

        modelNo = modelNos.get(modelNoIndex++);
        width = Float.parseFloat(formatter.format(Math.random() * 9999));
        height = Float.parseFloat(formatter.format(Math.random() * 9999));
        weight = Float.parseFloat(formatter.format(Math.random() * 9999));
        depth = Float.parseFloat(formatter.format(Math.random() * 9999));
        screenSize = Float.parseFloat(formatter.format(Math.random() * 9999));
    }

}
