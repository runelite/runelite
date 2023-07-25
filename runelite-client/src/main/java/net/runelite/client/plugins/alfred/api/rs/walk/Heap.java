package net.runelite.client.plugins.alfred.api.rs.walk;

public class Heap {

//    private final RSTile[] items;
//    private int currentItemCount;
//
//    public Heap(int maxHeapSize) {
//        items = new RSTile[maxHeapSize];
//    }
//
//    public RSTile removeFirst() {
//        RSTile firstItem = items[0];
//        currentItemCount--;
//        items[0] = items[currentItemCount];
//        items[0].setHeapIndex(0);
//        sortDown(items[0]);
//        return firstItem;
//    }
//
//    public void updateItem(RSTile item) {
//        sortUp(item);
//    }
//
//    public int count() {
//        return currentItemCount;
//    }
//
//    public boolean contains(RSTile item) {
//        if (item.getHeapIndex() == -1) {
//            return false;
//        }
//        return items[item.getHeapIndex()].equals(item);
//    }
//
//    public void add(RSTile item) {
//        item.setHeapIndex(currentItemCount);
//        items[currentItemCount] = item;
//        sortUp(item);
//        currentItemCount++;
//    }
//
//    private void sortDown(RSTile item) {
//        while (true) {
//            int childIndexLeft = item.getHeapIndex() * 2 + 1;
//            int childIndexRight = item.getHeapIndex() * 2 + 2;
//            int swapIndex = 0;
//
//            if (childIndexLeft < currentItemCount) {
//                swapIndex = childIndexLeft;
//
//                if (childIndexRight < currentItemCount) {
//                    if (items[childIndexLeft].heapCompare(items[childIndexRight]) < 0) {
//                        swapIndex = childIndexRight;
//                    }
//                }
//
//                if (item.heapCompare(items[swapIndex]) < 0) {
//                    swap(item, items[swapIndex]);
//                } else {
//                    return;
//                }
//            } else {
//                return;
//            }
//        }
//    }
//
//    private void sortUp(RSTile item) {
//        int parentIndex = (item.getHeapIndex() - 1) / 2;
//
//        while (true) {
//            RSTile parentItem = items[parentIndex];
//            if (item.heapCompare(parentItem) > 0) {
//                swap(item, parentItem);
//            } else {
//                break;
//            }
//
//            parentIndex = (item.getHeapIndex() - 1) / 2;
//        }
//    }
//
//    private void swap(RSTile itemA, RSTile itemB) {
//        items[itemA.getHeapIndex()] = itemB;
//        items[itemB.getHeapIndex()] = itemA;
//        int itemAIndex = itemA.getHeapIndex();
//        itemA.setHeapIndex(itemB.getHeapIndex());
//        itemB.setHeapIndex(itemAIndex);
//    }

}
