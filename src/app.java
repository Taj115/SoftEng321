package src;

// Main Class to Tie Everything in with Each Other
public class app {
    private static workflow table;

    public static void main(String[] args) {
        table = new workflow();
        table.startDataEntry();
    }
}
