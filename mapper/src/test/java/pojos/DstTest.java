package pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import mapper.anotaciones.MappingDateFormat;
import mapper.anotaciones.MappingDeep;
import mapper.anotaciones.MappingName;
import mapper.anotaciones.MappingNumberFormat;

/**
 * Clase destino para los test de mapeo
 * @author atraspuesto
 *
 */
public class DstTest {
	static final String CTE = "cte";
	
	@MappingName("entero")
	private Integer enteroConNombreDistinto;
	private Boolean booleano;
	private Double doubleN;
	private Float floatN;
	private String str;
	
	private String[] array;
	
	@MappingNumberFormat(pattern = "###,###.00")
	private String dobleNum;
	
	@MappingDateFormat(pattern = "dd/MM/yyyy")
	private String fecha;
	
	private java.sql.Date fechaStr;
	
	private Date fechaUtilStr;
	
	@MappingDateFormat(pattern = "dd/MM/yyyy")
	private String fechaUtil;
	
	@MappingNumberFormat(pattern = "###,###.0")
	private String bigDecimal;
	
	@MappingDeep(deep = 2)
	private List<DstNestedTest> lista;
	
	
	private Set<DstNestedTest> set = new HashSet<>();
	
	
	private SortedSet<DstNestedTest> sortedSet = new TreeSet<>();
	
	public DstNestedTest nested;

	public DstTest() {
	}

	@Override
	public String toString() {
		return "DstTest [entero=" + enteroConNombreDistinto + ", booleano=" + booleano + ", doubleN=" + doubleN + ", floatN=" + floatN
				+ ", str=" + str + ", dobleNum=" + dobleNum + ", fecha=" + fecha + ", fechaStr=" + fechaStr
				+ ", nested=" + nested + "]";
	}

	public Integer getEntero() {
		return enteroConNombreDistinto;
	}

	public void setEntero(Integer entero) {
		this.enteroConNombreDistinto = entero;
	}

	public Boolean getBooleano() {
		return booleano;
	}

	public void setBooleano(Boolean booleano) {
		this.booleano = booleano;
	}

	public Double getDoubleN() {
		return doubleN;
	}

	public void setDoubleN(Double doubleN) {
		this.doubleN = doubleN;
	}

	public Float getFloatN() {
		return floatN;
	}

	public void setFloatN(Float floatN) {
		this.floatN = floatN;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getDobleNum() {
		return dobleNum;
	}

	public void setDobleNum(String dobleNum) {
		this.dobleNum = dobleNum;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public java.sql.Date getFechaStr() {
		return fechaStr;
	}

	public void setFechaStr(java.sql.Date fechaStr) {
		this.fechaStr = fechaStr;
	}

	public DstNestedTest getNested() {
		return nested;
	}

	public void setNested(DstNestedTest nested) {
		this.nested = nested;
	}

	public Date getFechaUtilStr() {
		return fechaUtilStr;
	}

	public void setFechaUtilStr(Date fechaUtilStr) {
		this.fechaUtilStr = fechaUtilStr;
	}

	public String getFechaUtil() {
		return fechaUtil;
	}

	public void setFechaUtil(String fechaUtil) {
		this.fechaUtil = fechaUtil;
	}

	public String getBigDecimal() {
		return bigDecimal;
	}

	public void setBigDecimal(String bigDecimal) {
		this.bigDecimal = bigDecimal;
	}

	public List<DstNestedTest> getLista() {
		return lista;
	}

	public void setLista(List<DstNestedTest> lista) {
		this.lista = lista;
	}

	public Set<DstNestedTest> getSet() {
		return set;
	}

	public void setSet(Set<DstNestedTest> set) {
		this.set = set;
	}

	public SortedSet<DstNestedTest> getSortedSet() {
		return sortedSet;
	}

	public void setSortedSet(SortedSet<DstNestedTest> sortedSet) {
		this.sortedSet = sortedSet;
	}

	public Integer getEnteroConNombreDistinto() {
		return enteroConNombreDistinto;
	}

	public void setEnteroConNombreDistinto(Integer enteroConNombreDistinto) {
		this.enteroConNombreDistinto = enteroConNombreDistinto;
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	
	
}



