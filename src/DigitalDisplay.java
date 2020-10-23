public class DigitalDisplay {

    static String schedulerSystems[] = {"Random", "Smart", "Virtue"};
    static long serialNos[] = new long[200];

    static int serialNosIndex = 0;

    long serialNo;
    String schedulerSystem;
    String modelNo;

    static {
        long limit = 9999999999L;
        long start = 1000000000L;
        int j = 0;

        for(long i = start; j < 200; i += ((limit - start) / 200), j++) {
            serialNos[j] = (long) (i + (Math.random() * ((limit - start) / 200)));
        }
    }

    DigitalDisplay(Model model) {
        serialNo = serialNos[serialNosIndex++];
        schedulerSystem = schedulerSystems[(int) Math.floor(Math.random() * 3)];
        modelNo = model.modelNo;
    }

}
