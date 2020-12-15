public class Main {

    public static void main(String[]args){
        int numberOfKnapsacks = 10;
        int numberOfIterations = 10;
        int numberOfNeighborhoodSearch = 10;


        Search assigmentTwo = new Search(650, numberOfKnapsacks,numberOfIterations);
        assigmentTwo.greedyAlgorithm();
        assigmentTwo.printValue();

        for(int i = 0; i< numberOfNeighborhoodSearch; i++){
            assigmentTwo.neighborhoodSearch();
            assigmentTwo.printValue();
            assigmentTwo.phaseThree();

        }


    }
}
