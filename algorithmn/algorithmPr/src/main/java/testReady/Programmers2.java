package testReady;

public class Programmers2 {


    public static void main(String[] args) {


        String video_len = "07:22";
        String pos = "04:05";
        String op_start = "00:15";
        String op_end = "04:07";
        String[] commands = {"next", "prev"};


        int lenTime = calculTime(video_len);
        int ost = calculTime(op_start);
        int est = calculTime(op_end);
        int pst = calculTime(pos);

        if (pst >= ost && est >= pst) {
            pst = est;
        }

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            if(command.equals("next")){
                pst += 10;
                if(pst % 100 > 59){
                    pst += 41;
                }

                if(pst > lenTime){
                    pst = lenTime;
                }

            }else{
                pst -= 10;
                if (pst % 100 > 59) {
                    pst -= 41;
                }

                if (pst < 0) {
                    pst = 0;
                }

            }

            if (pst >= ost && est >= pst) {
                pst = est;
            }
        }

        String resultTime = String.valueOf(pst / 100);
        String resultMinute = String.valueOf(pst % 100);

        resultMinute = resultMinute.length() < 2 ? "0" + resultMinute : resultMinute;

        System.out.println( resultTime + ":" + resultMinute);


    }

    public static int calculTime(String time){
        int opStartTime =Integer.parseInt(time.substring(0, 2));
        int opStartMinute = Integer.parseInt(time.substring(3,5));
        return opStartTime * 100 + opStartMinute;
    }




}
