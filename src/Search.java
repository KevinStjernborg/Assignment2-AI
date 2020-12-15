import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Search {
    private LinkedList<Item> itemList = new LinkedList<Item>();
    private LinkedList<Knapsack> knapsackList = new LinkedList<>();
    private int counter = 0;
    int maxValue = 0;
    int totalValue = 0;

    public Search(int numberOfItems, int numberOfKnapsacks, int numberOfIterations){
        initializeItems(numberOfItems);
        initializeKnapsacks(numberOfKnapsacks);






    }

    public void initializeKnapsacks(int numberOfKnapsacks){
        for(int i = 0; i<numberOfKnapsacks; i++){
            knapsackList.add(new Knapsack(300));
        }
    }

    public void initializeItems(int numberOfItems){
        Random rand = new Random();
        for(int i = 0; i<numberOfItems ; i++){
            if(i < numberOfItems/2){
                int weight = 1+ rand.nextInt(10);
                int value = 5+ rand.nextInt(10);
                Item item = new Item(weight,value);
                itemList.add(item);
            }else{
                int weight = 1+ rand.nextInt(10);
                int value = 5+ rand.nextInt(10);
                Item item = new Item(weight,value);
                itemList.add(item);
            }

        }
    }

    public void greedyAlgorithm(){
       Collections.sort(itemList);
       for(int i =0; i< itemList.size(); i++){
           for(int j = 0; j < knapsackList.size(); j++){
                   if(knapsackList.get(j).checkCapacity(itemList.get(i).getWeight())){
                       knapsackList.get(j).addItem(itemList.get(i));
                       itemList.remove(i);
                   }
           }
        }



    }

    public void printValue(){
        for(int i=0; i< knapsackList.size(); i++){
            totalValue = getTotalKnapsackValue();
            System.out.println("Knapsack number " + i + " has a total weight of " + knapsackList.get(i).getCurrentWeight() +
                    ". It has a total value of " + knapsackList.get(i).getValue() +".");
        }
        System.out.println("Total value of "+ totalValue);
        System.out.println("");
    }

    public int getTotalKnapsackValue(){
        int value = 0;
        for(int i = 0; i < knapsackList.size();i++){
            value += knapsackList.get(i).getValue();
        }
        return value;
    }

      public void neighborhoodSearch(){
          Item tempItem = new Item(0,0);
          for(int i = 0; i < knapsackList.size(); i++) {
              tempItem = knapsackList.get(i).getItem();
              for (int j = 0; j < knapsackList.size(); j++) {
                  if (j == i) {
                  } else if(knapsackList.get(j).addItem(tempItem)) {
                    knapsackList.get(i).removeItem(tempItem);
                  }
              }

          }
          greedyAlgorithm();

          if(totalValue> maxValue){
              maxValue = totalValue;
          }else{
              counter++;
          }
         if(counter>5){
              System.out.println("Exiting. Counter = " + counter);
              System.exit(0);
          }

      }

/*
• Phase 3
– Try to exclude the selected item from a knapsack, only if it can be
replaced by one or more remaining items that increase the
knapsack’s value.
 */

    public void phaseThree(){
        Item tempItem = new Item(0,0);
        for(int i = 0; i < knapsackList.size(); i++){
            for(int j = 0; j < knapsackList.get(i).getNumberOfItems()-1; j++){
                if(itemList.getFirst().getValue() > knapsackList.get(i).getItemByIndex(j).getValue()
                        +knapsackList.get(i).getItemByIndex(j +1).getValue() && itemList.getFirst().getWeight() <=
                knapsackList.get(i).getItemByIndex(j).getWeight() + knapsackList.get(i).getItemByIndex(j+1).getWeight()){
                    knapsackList.get(i).removeItem(knapsackList.get(i).getItemByIndex(j));
                    knapsackList.get(i).removeItem(knapsackList.get(i).getItemByIndex(j+1));
                    knapsackList.get(i).addItem(itemList.getFirst());
                    System.out.println("-----------------");
                    System.out.println("Phase 3: Added!");
                    System.out.println("-----------------");
                }
            }
        }
        greedyAlgorithm();
    }
}
    /*
          int index = 0;
        for(int i = 0; i < knapsackList.size(); i++ ){
            if(knapsackList.get(i).getCurrentWeight() < knapsackList.get(index).getCurrentWeight()){
                index = i;
            }
        }

        for(int i = 0; i< knapsackList.get(index).getNumberOfItems(); i++){
            for( int j = 0; j < knapsackList.size(); j++){
                if(j == index){
                    break;
                }
                if(knapsackList.get(j).addItem(knapsackList.get(index).getItem())){
                    knapsackList.get(index).removeItem(knapsackList.get(index).getItem());
                    System.out.println("Item added in neighboorhood method");
                }

            }
        }


          int totalValue = 0;
          for(int i=0; i< knapsackList.size(); i++){
               totalValue =+ knapsackList.get(i).getValue();
              System.out.println("Knapsack number " + i + " has a total weight of " + knapsackList.get(i).getCurrentWeight() +
                      ". It has a total value of " + knapsackList.get(i).getValue() +".");

          }
          System.out.println("Total value of "+ totalValue);

     */


    /*
            Item tempItem = new Item(0,0);
        for(int i = 0; i < knapsackList.size(); i++){
            tempItem = knapsackList.get(i).getItem();
            if(i == knapsackList.size()-1 ){
                if(knapsackList.get(0).addItem(tempItem)){
                    knapsackList.get(i).removeItem(tempItem);

                }
                break;
            }
            if(i < knapsackList.size() &&  knapsackList.get(i+1).addItem(tempItem)){
                knapsackList.get(i).removeItem(tempItem);
            }
        }
        greedyAlgorithm();

          int totalValue = 0;
          for(int i=0; i< knapsackList.size(); i++){
              totalValue += knapsackList.get(i).getValue();
              System.out.println("Knapsack number " + i + " has a total weight of " + knapsackList.get(i).getCurrentWeight() +
                      ". It has a total value of " + knapsackList.get(i).getValue() +".");

          }
          System.out.println("Total value of "+ totalValue);



              public void neighborhoodSearchTwo(){
        Item tempItem = new Item(0,0);
        for(int i = 0; i < knapsackList.size()-1; i++){
            tempItem = knapsackList.get(i).getItem();
                knapsackList.get(i+1).removeLastItem();
                 knapsackList.get(i+1).addItem(tempItem);
               if(knapsackList.get(i).addItem(itemList.getFirst())){
               }else{
                   System.out.println("Couldn't add item via neighborhood two");
               }
        }
        greedyAlgorithm();

        int totalValue = 0;
        for(int i=0; i< knapsackList.size(); i++){
            totalValue += knapsackList.get(i).getValue();
            System.out.println("Knapsack number " + i + " has a total weight of " + knapsackList.get(i).getCurrentWeight() +
                    ". It has a total value of " + knapsackList.get(i).getValue() +".");

        }
        System.out.println("Total value of "+ totalValue);
    }
     */

    /*
          public void neighborhoodSearch(){
          Item tempItem = new Item(0,0);
          for(int i = 0; i < knapsackList.size(); i++){
              tempItem = knapsackList.get(i).getItem();
              if(i == knapsackList.size()-1 ){
                  if(knapsackList.get(0).addItem(tempItem)){
                      knapsackList.get(i).removeItem(tempItem);
                  }
                  break;
              }
              if(i < knapsackList.size() &&  knapsackList.get(i+1).addItem(tempItem)){
                  knapsackList.get(i).removeItem(tempItem);
              }
          }
          greedyAlgorithm();

          int totalValue = 0;
          for(int i=0; i< knapsackList.size(); i++){
              totalValue += knapsackList.get(i).getValue();
              System.out.println("Knapsack number " + i + " has a total weight of " + knapsackList.get(i).getCurrentWeight() +
                      ". It has a total value of " + knapsackList.get(i).getValue() +".");

          }
          System.out.println("Total value of "+ totalValue);
      }
     */




