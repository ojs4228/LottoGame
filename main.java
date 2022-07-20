import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lt {
    public static void main(String[] args) throws InterruptedException {

        int money = 10000;
        int min = 1;
        int max = 10;
        int price = 1000;//가격
        int win = 50000000;//당첨금수
        Util ut = new Util();
        Lotto lt = new Lotto();


        int[] number = new int[6];

        lt.setLottoMax(max);
        lt.setLottoMin(min);

        System.out.println(Arrays.toString(lt.Ltn())); // 디버그용
        System.out.println("나의 소지금은" + money + "입니다");
        Thread.sleep(1000);
        System.out.println("로또를 " + price + "원에 구매할려면 10이내의 수를 6자리 수를 입력하세요");
        System.out.println(lt.comparison(number, lt.Ltn()));


        Scanner sc = new Scanner(System.in);


        if (money < price) {
            System.out.println("로또를 구매할 돈이 부족합니다 ");
            System.out.println("현재 소지금 :" + money + "원");

            return;

        }
        for (int i = 0; i < 6; i++) {
            number[i] = sc.nextInt();
            if (!ut.isBetween(min, number[i], max)) {
                System.out.println(min + "이상," + max + "이하의 숫자를 입력하세요");

                return;
            }

        }

        money = money - price;
        System.out.println("소지금에서" + price + "원을 차감 했습니다");
        Thread.sleep(1000);
        System.out.println("남은 소직금은" + money + "원 입니다");
        Thread.sleep(1000);

        System.out.println(lt.comparison(number, lt.Ltn()));
        System.out.println("5");
        Thread.sleep(1000);
        System.out.println("4");
        Thread.sleep(1000);
        System.out.println("3");
        Thread.sleep(1000);
        System.out.println("2");
        Thread.sleep(1000);
        System.out.println("1");
        Thread.sleep(1000);


        if (lt.comparison(lt.Ltn(), lt.Ltn())) {

            money = money + win;

            int sw = lt.drawNumbers(7);

            switch (sw) {
                case 1:
                    System.out.println("10억 당첨이네요 세금으로 4억 가져갑니다");
                    break;
                case 2:
                    System.out.println("10억 당첨이지만 로또용지를 버려버렸다..!");
                    break;
                case 3:
                    System.out.println("10억 당첨이지만 당첨자가 너무많아 5천만 받았다");
                    break;
                case 4:
                    System.out.println("50억 당첨! 인생역전!");
                    break;
                case 5:
                    System.out.println("50억 당첨 이지만 세금으로 49억 9999만 9999원을 뜯기고 1원만 받았다(-999원)");
                    break;
                case 6:
                    System.out.println("100억 당첨이지만 로또용지를 도둑맞았다");
                    break;
                case 7:
                    System.out.println("5억 당첨이지만 대출금을 갚아야했다(...) 아직 1억 갚아야한다");
                    break;
            }

            if (lt.comparison(lt.Ltn(), lt.Ltn())) {

                System.out.println("다음기회에");
            }



            Thread.sleep(5000);

            return;
        }





    }
}

class Lotto {

    private int min;
    private int max;

    public int[] Ltn() {

        int[] numt = new int[6];
        Random rand = new Random();


        for (int i = 0; i < 6; i++) {

            numt[i] = rand.nextInt(min, max);

        }

        return numt;
    }

    public void setLottoMax(int max) {
        this.max = max;
    }

    public void setLottoMin(int min) {
        this.min = min;

    }

    public boolean comparison(int[] Lotto, int[] rand) {

        for (int i = 0; i < 6; i++) {

            if (Lotto[i] != rand[i]) {
                return false;
            }
        }
        return true;
    }

    public int drawNumbers(int mess) {

        int winning;

        Random rand = new Random();

        for (int i = 0; i == 1; i++) {

            rand.nextInt(mess);

            return mess;
        }

        return mess;
    }
}


class Util {
    public boolean isBetween(int min, int target, int max) {


        if (target < min) {

            return false;
        }

        if (target > max) {


            return false;
        }


        return true;

    }
}
