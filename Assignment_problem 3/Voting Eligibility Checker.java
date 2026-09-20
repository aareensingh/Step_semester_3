class VotingEligibility {
    void checkVotingEligibility(int age) {
        boolean eligible = age >= 18;

        if (eligible) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }
    }

    public static void main(String[] args) {
        VotingEligibility v = new VotingEligibility();

        v.checkVotingEligibility(20);
        v.checkVotingEligibility(16);
    }
}
