class UnderException extends RuntimeException {
    public UnderException(String msg) {
        super(msg);
    }
}

class OverException extends Exception {
    public OverException(String msg) {
        super(msg);
    }
}

public class age {

    public static void checkVotingEligibility(int age) throws OverException {
        if (age < 18) {
            throw new UnderException("age " + age + " is below 18. not eligible to vote.");
        } else if (age > 120) {
            throw new OverException("age " + age + " is unrealistic.");
        } else {
            System.out.println("age " + age + " is eligible to vote.");
        }
    }

    public static void main(String[] args) {
        int[] testAges = {15, 25, 130};

        for (int a : testAges) {
            try {
                System.out.println("\nchecking age: " + a);
                checkVotingEligibility(a);
            } catch (UnderException e) {
                System.out.println("caught unchecked exception: " + e.getMessage());
            } catch (OverException e) {
                System.out.println("caught checked exception: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("caught unexpected exception: " + e.getMessage());
            }
        }
    }
}
