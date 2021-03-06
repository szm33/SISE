public abstract class Solver {

    private int solutionLength = 0;
    private int visitedStates = 0;
    private int proccesedStates = 0;
    private int maxDepth = 0;
    private double time = 0;

    public int getSolutionLength() {
        return solutionLength;
    }

    public void setSolutionLength(int solutionLength) {
        this.solutionLength = solutionLength;
    }

    public int getVisitedStates() {
        return visitedStates;
    }

    public void setVisitedStates(int visitedStates) {
        this.visitedStates = visitedStates;
    }

    public int getProccesedStates() {
        return proccesedStates;
    }

    public void setProccesedStates(int proccesedStates) {
        this.proccesedStates = proccesedStates;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public abstract Puzzle solve(Puzzle puzzle);
}
