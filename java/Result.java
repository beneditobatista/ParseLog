
public class Result implements Comparable<Result>{
	
	private String name;
	private int count;
	
	public Result(String name){
		this.name = name;
		this.count = 1;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCount() {
		return count;
	}
	
	public void inc(int n) {
		this.count = this.count+n;
	}
	
	public void inc() {
		this.inc(1);
	}

	@Override
	public int compareTo(Result outroResult) {
		if (this.count > outroResult.getCount()) {
	          return -1;
	     }
	     if (this.count < outroResult.getCount()) {
	          return 1;
	     }
		return 0;
	}

}
