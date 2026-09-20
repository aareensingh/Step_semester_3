class NumberClassifier {
    void classifyNumber(int number) {
        if (number > 0) {
            System.out.println("Positive");
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }
    }

    public static void main(String[] args) {
        NumberClassifier n = new NumberClassifier();

        n.classifyNumber(15);
        n.classifyNumber(-4);
        n.classifyNumber(0);
    }
}
