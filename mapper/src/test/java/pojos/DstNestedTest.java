package pojos;

import mapper.anotaciones.MappingDeep;

public class DstNestedTest implements Comparable<DstNestedTest>{
	private Integer nestedId;
	private String nestedStr;
	
	@MappingDeep(deep = 1)
	private DstTest srcTest;
	
	@MappingDeep(deep = 1)
	private DstTest srcTest2;

	@MappingDeep(deep = 3)
	private DstNested2 nested2;
	
	public DstNestedTest() {
	}

	public Integer getNestedId() {
		return nestedId;
	}

	public String getNestedStr() {
		return nestedStr;
	}

	@Override
	public String toString() {
		return "DstNestedTest [nestedId=" + nestedId + ", nestedStr=" + nestedStr + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nestedId == null) ? 0 : nestedId.hashCode());
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
		DstNestedTest other = (DstNestedTest) obj;
		if (nestedId == null) {
			if (other.nestedId != null)
				return false;
		} else if (!nestedId.equals(other.nestedId))
			return false;
		return true;
	}

	public void setNestedId(Integer nestedId) {
		this.nestedId = nestedId;
	}

	public void setNestedStr(String nestedStr) {
		this.nestedStr = nestedStr;
	}

	@Override
	public int compareTo(DstNestedTest o) {
		
		return nestedId - o.getNestedId();
	}

	public DstTest getSrcTest() {
		return srcTest;
	}

	public void setSrcTest(DstTest srcTest) {
		this.srcTest = srcTest;
	}

	public DstTest getSrcTest2() {
		return srcTest2;
	}

	public void setSrcTest2(DstTest srcTest2) {
		this.srcTest2 = srcTest2;
	}

	public DstNested2 getNested2() {
		return nested2;
	}

	public void setNested2(DstNested2 nested2) {
		this.nested2 = nested2;
	}

	
}