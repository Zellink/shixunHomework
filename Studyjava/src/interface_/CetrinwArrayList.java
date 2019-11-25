package interface_;

public class CetrinwArrayList<E> implements CetrinwList<E>{

    /**
     * 数组默认长度
     */
    private static final int DEFAULT_SIZE = 10;

    /**
     * 存储队列中的元素
     */
    private Object[] elements = null;

    /**
     *数组大小指针
     */
    private int capacity;

    /**
     * 当前游标
     */
    private int current;


    public CetrinwArrayList(){
        this(DEFAULT_SIZE);
    }

    public CetrinwArrayList(int size){
        if(size < 0){
            throw new RuntimeException("数组大小不能小于0");
        }else{
            this.elements = new Object[size];
            this.current = 0;
            capacity = size;
        }
    }

    public E get(int index) {
        confirmIndex(index);
        return (E) this.elements[index];
    }

    public void add(E e) {
        confirmSize();
        this.elements[current] = e;
        this.current++;
    }

    public void remove(int index) {
        confirmIndex(index);
        for (int i = index; i < elements.length; i++) {
            if(i + 1 < elements.length){
                elements[i] = elements[i+1];
            }
        }
        current--;
    }

    public void insert(int index,E e) {
        confirmIndex(index);
        for (int i = 0; i < elements.length; i++) {
            if(i >= index && i+2 < elements.length){
                elements[i] = e;
                elements[i+1] = elements[i+2];
            }
        }
        current++;
    }

    public boolean contains(Object o) {
        for (Object element : this.elements) {
            if(o.equals(element)){
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.current;
    }

    public boolean isEmpty() {
        if(this.current >0){
            return true;
        }
        return false;
    }

    public void clearList() {
        elements = new Object[DEFAULT_SIZE];
    }

    /**
     * 确认当前数组的容量，如果满足，则不操作，如果不满足，则增加空间
     */
    private void confirmSize(){
        if(this.current == this.capacity){
            this.capacity = this.capacity + this.DEFAULT_SIZE;
            Object[] newElemets = new Object[this.capacity];

            for (int i = 0; i < this.elements.length; i++) {
                newElemets[i] = this.elements[i];
            }

            this.elements = newElemets;
        }
    }

    /**
     * 判断下标是否越界
     */
    private void confirmIndex(int index){
        if(index > capacity || index < 0){
            throw new RuntimeException("下标越界");
        }
    }
}
