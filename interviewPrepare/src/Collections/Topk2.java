package Collections;

/**
 * @author hduser
 * 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
 
/*
 * 
 * 关键字：TopK,url统计,最小堆
 *
 */
public class Topk2 {
	//每行封装成一个记录，便于以后处理其他信息，如时间等等
	static class Record{
		private String searchKey;
		public String getSearchKey() {
			return searchKey;
		}
		public void setSearchKey(String s) {
			this.searchKey = s;
		}
		public Record() {
			
		}
	}
	
	public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		File f=new File("/home/hduser/TopKTest.txt");
		BufferedReader reader=null;
		int k=3;//测试用例记录较少，这里指定为3
		Record record=new Record();
		try {
			reader=new BufferedReader(new FileReader(f));
			String tmp="";
			while((tmp=reader.readLine())!=null){
				record.setSearchKey(tmp);
				insert(record,map);	
			}
			Iterator iter=map.entrySet().iterator();
			while(iter.hasNext()){
				Map.Entry e=(Map.Entry) iter.next();
				System.out.println(e.getKey()+" "+e.getValue());
			}
			Map.Entry[] result=getTopKRecord(map,k);
			for(Map.Entry<String,Integer> e:result){
				System.out.println(e.getKey()+" "+e.getValue());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}
	//Hash表统计次数
	private static void insert(Record record, Map<String, Integer> map) {
		String url=record.getSearchKey();
		if(map.containsKey(url)){
			map.put(url, map.get(url)+1);
		}
		else
			map.put(url, 1);	
	}
	//维持一个大小为k的最小堆
	public static Map.Entry[] getTopKRecord(Map<String, Integer> map,int k){
		int i=0;
		Iterator iter=map.entrySet().iterator();
		Map.Entry[] elements=new Map.Entry[k];
		while(iter.hasNext()){
			Map.Entry e=(Map.Entry) iter.next();
			if(i<=k-1){						
				elements[i]=e;
				if(i==k-1){
					buildMinHeap(elements);
				}
				i++;
			}
			else{
				insertHeap(e,elements);
			}
		}
		return elements;
	}
	private static void insertHeap(Map.Entry n, Map.Entry[] heap) {
		if((int)n.getValue()>(int)heap[0].getValue()){
			heap[0]=n;
			minHeap(heap,0,heap.length);
		}
		
	}
        private static void buildMinHeap(Map.Entry[] heap) {
		int i=heap.length/2-1;
		for(;i>=0;i--){
			minHeap(heap,i,heap.length);
		}
	}
	private static void minHeap(Map.Entry[] heap, int i, int length) {
		int left ,right,min;
		Map.Entry temp;
		left=2*i+1;
		right=2*i+2;
		min=i;
		if(left<=length-1&&(int)heap[left].getValue()<(int)heap[i].getValue()){
			min=left;
		}
		if(right<=length-1&&(int)heap[right].getValue()<(int)heap[min].getValue()){
			min=right;
		}
		if(min!=i){
			temp=heap[i];
			heap[i]=heap[min];
			heap[min]=temp;
			minHeap(heap,min,length);
		}
	}
}
