class GuessNumberGame {
    void guessTheNumber(int secretNumber, int maxTries, int[] guesses) {
        int tries = 0;
        boolean guessed = false;

        while (tries < maxTries && tries < guesses.length && !guessed) {
            int guess = guesses[tries];

            if (guess > secretNumber) {
                System.out.println("Too high");
            } else if (guess < secretNumber) {
                System.out.println("Too low");
            } else {
                System.out.println("Correct! You guessed it");
                guessed = true;
                break;
            }

            tries++;
        }

        if (!guessed) {
            System.out.println("Out of tries — the number was " + secretNumber);
        }
    }

    public static void main(String[] args) {
        GuessNumberGame g = new GuessNumberGame();

        int[] guesses1 = {20, 60, 42};
        g.guessTheNumber(42, 4, guesses1);

        int[] guesses2 = {10, 15};
        g.guessTheNumber(42, 2, guesses2);
    }
}
