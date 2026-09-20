class ATM {
    void atmPinRetry(String correctPin, String[] attempts) {
        int attempt = 0;
        boolean success = false;

        while (attempt < attempts.length && attempt < 3 && !success) {
            if (attempts[attempt].equals(correctPin)) {
                success = true;
                System.out.println("PIN accepted");
                break;
            }

            attempt++;
        }

        if (!success) {
            System.out.println("Card blocked — too many incorrect attempts");
        }
    }

    public static void main(String[] args) {
        ATM a = new ATM();

        String[] attempts1 = {"1111", "4821"};
        a.atmPinRetry("4821", attempts1);

        String[] attempts2 = {"1111", "2222", "3333"};
        a.atmPinRetry("4821", attempts2);
    }
}
