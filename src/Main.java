public class Main {

    public static void main(String[]args){
        int numberOfKnapsacks = 10;
        int numberOfIterations = 10;

        Search assigmentTwo = new Search(600, numberOfKnapsacks,numberOfIterations);
        assigmentTwo.greedyAlgorithm();
        assigmentTwo.neighborhoodSearch();

    }
}
