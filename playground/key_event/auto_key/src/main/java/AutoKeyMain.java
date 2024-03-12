import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;

public class AutoKeyMain extends JFrame{

    private Robot robot;
    private volatile boolean keepRunning = false;

    public AutoKeyMain() {
        // Set up the GUI
        setTitle("Key Press Simulator");
        setSize(300, 100);
        //나가면 닫는것
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

        //start버튼 누르면 start리스너 실행
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keepRunning = true;
                startKeyPressing();
            }
        });

        //stop버튼 누르면 종료리스너 생성
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keepRunning = false;
            }
        });

        add(startButton);
        add(stopButton);

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void startKeyPressing() {
        // This method should run in its own thread to avoid blocking the GUI
        //스레드로 만들어서 스레드 자체를 실행시키고 멈추게 함.
        new Thread(() -> {
            while (keepRunning) {
                try {
                    /**
                     * 이용방식은 포탈이 있는곳에서
                     * 위쪽 방향키 어느정도 누르고 있고 -> 컨트롤키 어느정도 누르고 있고 (pattern1)
                     * 패턴1을 빠르게 반복하는 방법(pattern2)
                     *
                     */
                    //컨트롤 키 누르기
                    //사용하는 키보드키는 CNTL
                    robot.keyPress(KeyEvent.VK_UP); //
                    robot.keyRelease(KeyEvent.VK_UP); //

                    //랜덤값으로 바꾸기
                    Thread.sleep(1000); // Wait for 1 second before pressing again
                    robot.keyPress(KeyEvent.VK_CONTROL); //
                    robot.keyRelease(KeyEvent.VK_CONTROL); //





                    //스레드 슬립을 랜덤으로 줘서 최대한 사람의 패턴과 비슷하게 구현
                    Thread.sleep(1000); // Wait for 1 second before pressing again
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void patternOne() throws InterruptedException {
        //윗키 누르기
        //사용하는 키보드키는 CNTL
        robot.keyPress(KeyEvent.VK_UP); //
        Thread.sleep(createRandomNumber(801,600)); //0.8초에서 1.4초까지 랜덤숫자
        robot.keyRelease(KeyEvent.VK_UP); //
        Thread.sleep(createRandomNumber(101,200)); //0.1초에서 0.3초까지 랜덤숫자

        //컨트롤 키 누르기
        robot.keyPress(KeyEvent.VK_CONTROL); //
        Thread.sleep(createRandomNumber(601,700)); //0.6초에서 1.3초까지 랜덤숫자
        robot.keyRelease(KeyEvent.VK_CONTROL); //
        Thread.sleep(createRandomNumber(101,150)); //0.1초에서 0.25초까지 랜덤숫자





        //랜덤값으로 바꾸기
        robot.keyPress(KeyEvent.VK_CONTROL); //
        robot.keyRelease(KeyEvent.VK_CONTROL); //

    }

    private long createRandomNumber(int min, int max) {
        //0.5초에서 1.0초까지 랜덤 숫자;

        Random rand = new Random();
        int randomNum = rand.nextInt(min)+max;
        return (long) randomNum;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AutoKeyMain().setVisible(true);
        });
    }
}
