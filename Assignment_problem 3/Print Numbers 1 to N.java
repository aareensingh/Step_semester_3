class NumberPrinter {
    void printNumbersUpToN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        NumberPrinter p = new NumberPrinter();

        p.printNumbersUpToN(5);
    }
}
