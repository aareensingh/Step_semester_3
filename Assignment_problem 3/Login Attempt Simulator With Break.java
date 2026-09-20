class LoginSimulator {
    void simulateLogin(String correctCode, String[] attempts) {
        boolean granted = false;

        for (int i = 0; i < attempts.length; i++) {
            if (attempts[i].equals(correctCode)) {
                System.out.println("Access granted on attempt " + (i + 1));
                granted = true;
                break;
            }
        }

        if (!granted) {
            System.out.println("Access denied — all attempts used");
        }
    }

    public static void main(String[] args) {
        LoginSimulator l = new LoginSimulator();

        String[] attempts1 = {"0000", "1234", "9999"};
        l.simulateLogin("1234", attempts1);

        String[] attempts2 = {"1111", "2222", "3333"};
        l.simulateLogin("1234", attempts2);
    }
}
