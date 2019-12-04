package homework.ls_14_Set.maximum;

import java.util.Comparator;

public class Commodity implements Comparable<Commodity> {

    private String name;
    private int weight;
    private int length;
    private int height;

    public Commodity(String name, int weight, int length, int height) {
        this.name = name;
        this.weight = weight;
        this.length = length;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    @Override
    public int compareTo(Commodity commodity) {
        int diff = getHeight() - commodity.getHeight();

        if (diff < 0) {
            return -1;
        } else if (diff == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static Comparator<Commodity> comparatorByName = new Comparator<Commodity>() {
        @Override
        public int compare(Commodity commodity, Commodity t1) {
            return commodity.compareTo(t1);
        }
    };


    public static Comparator<Commodity> comparatorByLength = new Comparator<Commodity>() {
        @Override
        public int compare(Commodity commodity, Commodity t1) {
            return Integer.compare(commodity.getLength(), t1.getLength());
        }
    };

    public static Comparator<Commodity> comparatorByHeight = new Comparator<Commodity>() {
        @Override
        public int compare(Commodity commodity, Commodity t1) {
            return Integer.compare(commodity.getHeight(), t1.getHeight());
        }
    };

    public static Comparator<Commodity> comparatorByWeight = new Comparator<Commodity>() {
        @Override
        public int compare(Commodity commodity, Commodity t1) {
            return Integer.compare(commodity.getHeight(), t1.getWeight());
        }
    };

}
