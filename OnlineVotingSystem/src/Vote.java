public enum Vote {
    Party1("A Partisi"),
    Party2("B Partisi"),
    Party3("C Partisi");

    private final String partyName;

    Vote(String partyName) {
        this.partyName = partyName;
    }

    @Override
    public String toString() {
        return partyName;
    }
}
