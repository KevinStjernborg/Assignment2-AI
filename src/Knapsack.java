import java.util.LinkedList;

public class Knapsack {
    private int capacity;
    private int currentWeight;
    private LinkedList<Item> itemList = new LinkedList<Item>();


    public Knapsack(int capacity){
        this.capacity = capacity;
        currentWeight = 0;
    }

    public int getValue(){
        int value = 0;
        for(int i = 0; i< itemList.size(); i++){
            value += itemList.get(i).getValue();
        }
        return value;
    }

    public Item getItemByIndex(int index){
        return itemList.get(index);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public boolean addItem(Item item){
        if(checkCapacity(item.getWeight())){
            itemList.add(item);
            currentWeight += item.getWeight();
            return true;
        }else{
            return false;
        }
    }



    public boolean removeItem(Item item){
        if(itemList.contains(item)){
            itemList.remove(item);
            currentWeight -= item.getWeight();
            return true;
        }else{
            return false;
        }
    }

    public void removeLastItem(){
        itemList.removeLast();
    }

    public Item getAndRemoveItem(){
      /*  Item item = new Item(0,0);
        for(int i = 0; i < itemList.size(); i ++ ){
            if(itemList.get(i).getValuePerUnit() >= item.getValuePerUnit()){
                item = itemList.get(i);
            }
        }
       */
      Item item = itemList.getLast();
      itemList.remove(item);
        return item;
    }

    public Item getItem(){
    /*    Item item = new Item(0,0);
        for(int i = 0; i < itemList.size(); i ++ ){
            if(itemList.get(i).getValuePerUnit() >= item.getValuePerUnit()){
                item = itemList.get(i);
            }
            }
      */

        return itemList.getLast();
    }

    public int getNumberOfItems(){
        return itemList.size();
    }

    public boolean checkCapacity(int weight){
        if(currentWeight + weight <= capacity){
            return true;
        }
        else{
            return false;
        }

    }



}
