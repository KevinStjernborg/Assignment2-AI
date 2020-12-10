import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Greedy {
    private LinkedList<Item> itemList = new LinkedList<Item>();
    private Knapsack knapsackOne = new Knapsack(25); // hur många? Hålla i linkedlist?
    private Knapsack knapsackTwo = new Knapsack(25); //


    public  Greedy(int nbr){
        initializeItems(nbr);
        greedyAlgorithm();
    }

    public void initializeItems(int numberOfItems){
        Random rand = new Random();
        for(int i = 0; i<numberOfItems; i++){
            int weight = 1+ rand.nextInt(5);
            int value = 5+ rand.nextInt(100);
            Item item = new Item(weight,value);
            itemList.add(item);
        }
    }

    public void greedyAlgorithm(){
        Collections.sort(itemList);
       for(int i =0; i< itemList.size()-1; i++){
           if(knapsackOne.checkCapacity(itemList.get(i).getWeight()) || knapsackTwo.checkCapacity(itemList.get(i).getWeight())){
               if(knapsackOne.getCurrentWeight() < knapsackTwo.getCurrentWeight()){
                   knapsackOne.addItem(itemList.get(i));
                   System.out.println("Item added with a value per unit of " + itemList.get(i).getValuePerUnit() + "." +
                           " To knapsack One with a current weight of " + knapsackOne.getCurrentWeight() +
                           ". Item value with " + itemList.get(i).getValue() +
                           ". Item weight of " + itemList.get(i).getWeight());
               }else{
                   knapsackTwo.addItem(itemList.get(i));
                   System.out.println("Item added with a value per unit of " + itemList.get(i).getValuePerUnit() + "." +
                           " To knapsack Two with a current weight of " + knapsackTwo.getCurrentWeight() +
                           ". Item value with " + itemList.get(i).getValue() +
                           ". Item weight of " + itemList.get(i).getWeight());
               }
           }else{  // Loopa igenom alla items och kolla med resterande kvaranande items i itemlistan ifall om ett enda item ger högre value än totalen för knapsacken
               System.out.println("Knapsacks are full, terminating greedy algo");
               break;
           }

        }
      }
    }


