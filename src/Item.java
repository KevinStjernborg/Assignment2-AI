import java.util.Comparator;

public class Item implements Comparable<Item> {
    private int weight;
    private int value;
    private int valuePerUnit;


    public Item(int weight, int value){
        this.weight = weight;
        this.value = value;
        valuePerUnit =  value/weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Integer getValuePerUnit() {
        return valuePerUnit;
    }

    public void setValuePerUnit(int valuePerUnit) {
        this.valuePerUnit = valuePerUnit;
    }


    @Override
    public int compareTo(Item itemTwo) {
        return  itemTwo.getValuePerUnit() -this.getValuePerUnit() ;
    }
}
