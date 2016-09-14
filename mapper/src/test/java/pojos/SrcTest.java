package pojos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import mapper.anotaciones.MappingDateFormat;
import mapper.anotaciones.MappingName;
import mapper.anotaciones.MappingNumberFormat;

/**
 * Calse origen para los test de mapeo
 * @author atraspuesto
 *
 */
public class SrcTest {
	static final String CTE = "cte";
	
	@MappingNumberFormat(pattern = "###,###")
	@MappingName("entero")
	private String numeroEntero;
	private String booleano;
	private String doubleN;
	private String floatN;
	private Double dobleNum;
	private String str;
	private SrcNestedTest nested;
	private java.sql.Date fecha = new java.sql.Date(System.currentTimeMillis());
	private Date fechaUtil;
	
	//private Integer[] array;
	
	private String campoNoMapeado = "no mapeado";
	
	@MappingDateFormat(pattern = "dd/MM/yyyy")
	private String fechaUtilStr;
	
	@MappingDateFormat(pattern = "dd/MM/yyyy")
	private String fechaStr = "25/05/2005";
	
	private BigDecimal bigDecimal;

	private List<SrcNestedTest> lista = new ArrayList<>();
	
	private Set<SrcNestedTest> set = new HashSet<>();
	
	private SortedSet<SrcNestedTest> sortedSet = new TreeSet<>();
	
	public SrcTest(String booleano, String doubleN, String floatN, Double dobleNum) {
		this.booleano = booleano;
		this.doubleN = doubleN;
		this.floatN = floatN;
		this.dobleNum = dobleNum;
	}

	public SrcTest(String entero, String booleano, String doubleN, String floatN, Double dobleNum, String str,
			SrcNestedTest nested) {
		super();
		this.numeroEntero = entero;
		this.booleano = booleano;
		this.doubleN = doubleN;
		this.floatN = floatN;
		this.dobleNum = dobleNum;
		this.str = str;
		this.nested = nested;
		SrcNestedTest nest2 = new SrcNestedTest(6, "segundo");
		nest2.setSrcTest(this);
		lista.add(nested);
		lista.add(nest2);
		set.add(nested);
		set.add(nest2);
		sortedSet.add(nested);
		sortedSet.add(nest2);
	}

	public String getEntero() {
		return numeroEntero;
	}

	public void setEntero(String entero) {
		this.numeroEntero = entero;
	}

	public String getBooleano() {
		return booleano;
	}

	public void setBooleano(String booleano) {
		this.booleano = booleano;
	}

	public String getDoubleN() {
		return doubleN;
	}

	public void setDoubleN(String doubleN) {
		this.doubleN = doubleN;
	}

	public String getFloatN() {
		return floatN;
	}

	public void setFloatN(String floatN) {
		this.floatN = floatN;
	}

	public Double getDobleNum() {
		return dobleNum;
	}

	public void setDobleNum(Double dobleNum) {
		this.dobleNum = dobleNum;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public SrcNestedTest getNested() {
		return nested;
	}

	public void setNested(SrcNestedTest nested) {
		this.nested = nested;
	}

	public java.sql.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.sql.Date fecha) {
		this.fecha = fecha;
	}

	public String getFechaStr() {
		return fechaStr;
	}

	public void setFechaStr(String fechaStr) {
		this.fechaStr = fechaStr;
	}

	public Date getFechaUtil() {
		return fechaUtil;
	}

	public void setFechaUtil(Date fechaUtil) {
		this.fechaUtil = fechaUtil;
	}

	public String getFechaUtilStr() {
		return fechaUtilStr;
	}

	public void setFechaUtilStr(String fechaUtilStr) {
		this.fechaUtilStr = fechaUtilStr;
	}

	public BigDecimal getBigDecimal() {
		return bigDecimal;
	}

	public void setBigDecimal(BigDecimal bigDecimal) {
		this.bigDecimal = bigDecimal;
	}

	public List<SrcNestedTest> getLista() {
		return lista;
	}

	public void setLista(List<SrcNestedTest> lista) {
		this.lista = lista;
	}

	public Set<SrcNestedTest> getSet() {
		return set;
	}

	public void setSet(Set<SrcNestedTest> set) {
		this.set = set;
	}

	public SortedSet<SrcNestedTest> getSortedSet() {
		return sortedSet;
	}

	public void setSortedSet(SortedSet<SrcNestedTest> sortedSet) {
		this.sortedSet = sortedSet;
	}

	public String getNumeroEntero() {
		return numeroEntero;
	}

	public void setNumeroEntero(String numeroEntero) {
		this.numeroEntero = numeroEntero;
	}

	/*public Integer[] getArray() {
		return array;
	}

	public void setArray(Integer[] array) {
		this.array = array;
	}*/

}
