package main.day14.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * 插入、删除和随机访问都是O(1)的容器<br><br>
 * 设计一个数据结构，使如下操作的时间复杂度都是O(1):<br>
 * 1.insert(value):若数据集中不包含一个数值，则把它添加到数据集中；<br>
 * 2.remove(value):若数据集包含一个数值，则把它删除；<br>
 * 3.getRandom():随机返回数据集中的一个数值，要求数据集中每个数子被返回的概率相同。<br>
 * @author fisher
 * @version 1.0
 */
public class RandomizedSet {
    /**
     * 数据到数据在动态数组中的位置的映射
     */
    HashMap<Integer,Integer> numToLocation;
    /**
     * 存放数据的动态数组
     */
    ArrayList<Integer> nums;

    public RandomizedSet(){
        numToLocation = new HashMap<>();
        nums = new ArrayList<>();
    }

    /**
     * 若数据集中不包含一个数值，则把它添加到数据集中<br>
     * <br>
     * 时间复杂度：O(1)
     * @param value <code>int</code> 要插入的数据
     * @return <code>boolean</code> -若插入成功返回true；否则返回false
     */
    public boolean insert(int value){
        if (numToLocation.containsKey(value)){
            return false;
        }
        numToLocation.put(value,nums.size());
        nums.add(value);
        return true;
    }

    /**
     * 若数据集包含一个数值，则把它删除<br>
     * <br>
     * 时间复杂度：O(1)
     * @param value <code>int</code> 要插入的数据
     * @return <code>boolean</code> -若删除成功返回true；否则返回false
     */
    public boolean remove(int value){
        int location = numToLocation.getOrDefault(value,-1);
        if (location == -1){
            return false;
        }
        //获取数组追后一个数据
        int last = nums.get(nums.size()-1);
        //更新数组最后一个数据位置记录到要删除数据的位置
        numToLocation.put(last,location);
        //删除数据位置映射
        numToLocation.remove(value);
        //将最后一个数据位置放在要删除数据的位置上
        nums.set(location,last);
        //删除最后一个数据
        nums.remove(nums.size()-1);
        return true;
    }

    /**
     * 随机返回数据集中的一个数值，要求数据集中每个数子被返回的概率相同。<br>
     * <br>
     * 时间复杂度：O(1)
     * @return <code>int</code> -随机获取的数据
     */
    public int randomGet(){
        Random random = new Random();
        return nums.get(random.nextInt(nums.size()));
    }

}
