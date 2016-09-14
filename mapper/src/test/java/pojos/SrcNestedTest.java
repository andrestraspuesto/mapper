package pojos;

public class SrcNestedTest implements Comparable<SrcNestedTest>{
	private int nestedId;
	private String nestedStr;

	private SrcTest srcTest;
	
	private SrcTest srcTest2;
	
	private SrcNested2 nested2;
	
	public SrcNestedTest() {
	}

	public SrcNestedTest(int nestedId, String nestedStr) {
		super();
		this.nestedId = nestedId;
		this.nestedStr = nestedStr;
		nested2 = new SrcNested2();
		nested2.setParent(this);
	}

	@Override
	public String toString() {
		return "SrcNestedTest [nestedId=" + nestedId + ", nestedStr=" + nestedStr + "]";
	}

	public int getNestedId() {
		return nestedId;
	}

	public void setNestedId(int nestedId) {
		this.nestedId = nestedId;
	}

	public String getNestedStr() {
		return nestedStr;
	}

	public void setNestedStr(String nestedStr) {
		this.nestedStr = nestedStr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nestedId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SrcNestedTest other = (SrcNestedTest) obj;
		if (nestedId != other.nestedId)
			return false;
		return true;
	}

	@Override
	public int compareTo(SrcNestedTest o) {
		
		return nestedId - o.nestedId;
	}

	public SrcTest getSrcTest() {
		return srcTest;
	}

	public void setSrcTest(SrcTest srcTest) {
		this.srcTest = srcTest;
	}

	public SrcTest getSrcTest2() {
		return srcTest2;
	}

	public void setSrcTest2(SrcTest srcTest2) {
		this.srcTest2 = srcTest2;
	}

	public SrcNested2 getNested2() {
		return nested2;
	}

	public void setNested2(SrcNested2 nested2) {
		this.nested2 = nested2;
	}
	
	
}