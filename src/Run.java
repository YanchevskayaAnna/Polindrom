import java.util.Arrays;

//A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 * 99.
//Find the largest palindrome made from the product of two 3-digit numbers.

public class Run {

    static int[] simpleMultipliers;

    public static void main(String[] args) {

        fillSimpleMultipliers();
        for (int i = 998001; i > 10000; i--) {
            if (polindrom(i) && findMultipliers(i)) {
                break;
            }
        }

    }


    private static void fillSimpleMultipliers() {

        String str = "2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199";
        simpleMultipliers = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();

    }

    private static boolean findMultipliers(int polindrom) {

        int[] multipliers = new int[100];

        int myNunber = polindrom;
        int j = 0;
        boolean findMultiplier;

        while (true) {

            findMultiplier = false;

            for (int k : simpleMultipliers) {

                if (myNunber % k == 0) {
                    multipliers[j++] = k;
                    myNunber = myNunber / k;
                    findMultiplier = true;
                    break;
                }

            }

            if (findMultiplier == false) {

                multipliers[j] = myNunber;
                if (myNunber > 1000) {
                    return false;
                }
                break;
            }

        }

        int firstMultiplier;
        int secondMultiplier;

        for (int i = 0; i <= j; i++) {

            int f = i;
            while (f < j) {

                firstMultiplier = multipliers[i];

                for (int k = f + 1; k <= j; k++) {

                    firstMultiplier = firstMultiplier * multipliers[k];

                    if ((firstMultiplier > 100) && (firstMultiplier < 1000)) {

                        secondMultiplier = polindrom / firstMultiplier;
                        if ((firstMultiplier < 1000) && (firstMultiplier > 100) && (secondMultiplier < 1000) && (secondMultiplier > 100)) {
                            System.out.println("Polindrom " + polindrom + " = " + firstMultiplier + " * " + secondMultiplier);
                            return true;
                        }

                    }

                    if (firstMultiplier > 1000) {

                        firstMultiplier = firstMultiplier / multipliers[k - 1];
                        break;

                    }
                }

                secondMultiplier = polindrom / firstMultiplier;

                if ((firstMultiplier < 1000) && (firstMultiplier > 100) && (secondMultiplier < 1000) && (secondMultiplier > 100)) {
                    System.out.println("Polindrom " + polindrom + " = " + firstMultiplier + " * " + secondMultiplier);
                    return true;
                }

                f++;
            }

        }

        return false;

    }

    private static boolean polindrom(Integer i) {
        char[] s = i.toString().toCharArray();
        int k = 0;
        for (int j = s.length; j > s.length / 2; j--) {
            if (!(s[k] == s[j - 1])) return false;
            k++;
        }
        return true;
    }
}
