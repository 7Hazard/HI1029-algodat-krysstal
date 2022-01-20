package f1;

import java.util.Arrays;

public class NArrayList<E> {
    private E[] data;
    private int nrElements;
    private int maxSize;
    public NArrayList(){
        nrElements = 0;
        maxSize = 10;
        data = (E[]) new Object[maxSize];
    }

    public boolean add(E element){
        if(nrElements==maxSize)
            reallocate();
        data[nrElements++]=element;
        return true;
    }

    public void add(int index, E element){
        if(0<=index && index <= nrElements)
        {
            if(nrElements==maxSize)
                reallocate();
            for(int i=nrElements;i>index;i--)
                data[i]=data[i-1];
            data[index]=element;
            nrElements++;
            return;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public E get(int index){
        if(0<=index && index < nrElements)
            return data[index];
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public E remove(int index) {
        if(nrElements == 0 || index < 0 || index >= nrElements)
            throw new ArrayIndexOutOfBoundsException(index);
        var removed = data[index];
        for(int i = index; i < nrElements-1; i++){
            data[i] = data[i+1];
        }
        data[nrElements-1] = null;
        nrElements--;
        return removed;
    }

    public int indexOf(E item) {
        for(int i = 0; i < nrElements; i++) {
            if(data[i].equals(item))
                return i;
        }
        return -1;
    }

    public E set(int index, E item) {
        if(nrElements == 0 || index < 0 || index >= nrElements)
            throw new ArrayIndexOutOfBoundsException(index);
        return data[index] = item;
    }

    private void reallocate(){
        maxSize*=2;
        data=Arrays.copyOf(data,maxSize);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < nrElements; i++){
            sb.append(data[i]);
            if(i != nrElements-1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
