package mapper;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import pojos.DstNestedTest;
import pojos.DstTest;
import pojos.SrcNestedTest;
import pojos.SrcTest;

/**
 * Test de la clase Mapper
 * 
 * @author atraspuesto
 *
 */
public class MapperImplTest {
	
	private static MapperInterface mapper = MapperFactory.getInstance(Locale.GERMAN);
	
	private static SrcTest src;
	
	private static DstTest dst;
	
	@BeforeClass
	public static void init(){
		src = new SrcTest("1","true", "32,45", "29,35", 23_000_111.45, "str",  new SrcNestedTest(5, "nested"));
		src.setFecha( new java.sql.Date(System.currentTimeMillis()));
		src.setFechaStr("26/08/2016");
		src.setFechaUtil(new Date());
		src.setFechaUtilStr("26/08/2016");
		src.setBigDecimal(new BigDecimal("123456789.123456"));
		src.getNested().setSrcTest(src);
		src.getNested().setSrcTest2(src);
		//src.setArray(new Integer[]{1,2,3});
		dst = mapper.map(DstTest.class, src);
	}

	/**
	 * Comprueba que campos de igual tipo se mapean bien
	 */
	@Test
	public void mapeaCamposDeIgualTipo(){
		assertEquals(src.getStr(), dst.getStr());		
	}
	
	/**
	 * Comprueba que se mapea bien de string a Integer
	 */
	@Test
	public void mapeaStringAInteger(){
		assertEquals(src.getEntero(), dst.getEntero().toString());		
	}
	
	/**
	 * Comprueba que se mapean bien strings de numeros donde los decimales
	 * se separan por coma a objetos Double
	 */
	@Test
	public void mapeaStringDoubleComaSeparadorDecimalADouble(){
		Double expected = 32.45;
		assertEquals(expected, dst.getDoubleN());
	}
	
	/**
	 * Comprueba que se formatean bien numeros Double atendiendo
	 * al patron especificado mediante la anotacion MappingNumberFormat
	 * y el locale
	 */
	@Test
	public void mapeaDoubleAStringConFormato(){
		String expected = "23.000.111,45";
		assertEquals(expected, dst.getDobleNum());
	}
	
	/**
	 * Comprueba que se mapean bien objetos complejos anidados
	 */
	@Test
	public void mapeaObjetosComplejosAnidados(){
		Integer srcId = src.getNested().getNestedId();
		assertEquals(srcId, dst.getNested().getNestedId());
		assertEquals(src.getNested().getNestedStr(), dst.getNested().getNestedStr());
	}
	
	/**
	 * Comprueba que se mapean bien objetos java.sql.Date a 
	 * String atendiendo al patron definido con la anotacion MappingDateFormat sobre el campo String
	 */
	@Test
	public void mapeaSqlDateAStringSegunFormato(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String expected = sdf.format(new Date());
		assertEquals(expected, dst.getFecha());
	}
	
	/**
	 * Comprueba que se mapea bien un String que contiene una fecha que casa
	 * con el patron definido con la anotacion MappingDateFormat a un 
	 * objeto java.sql.Date
	 * 
	 * @throws ParseException
	 */
	@Test
	public void mapeaStringASqlDateSegunFormato() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date expected = sdf.parse("26/08/2016");
		java.sql.Date fechaExpected = new java.sql.Date(expected.getTime());
		assertEquals(fechaExpected, dst.getFechaStr());
	}
	
	/**
	 * Comprueba que se mapean bien objetos java.util.Date a 
	 * String atendiendo al patron definido con la anotacion MappingDateFormat sobre el campo String
	 */
	@Test
	public void mapeaUtilDateAStringSegunFormato(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String expected = sdf.format(new Date());
		assertEquals(expected, dst.getFechaUtil());
	}
	
	/**
	 * Comprueba que se mapea bien un String que contiene una fecha que casa
	 * con el patron definido con la anotacion MappingDateFormat a un 
	 * objeto java.util.Date
	 * 
	 * @throws ParseException
	 */
	@Test
	public void mapeaStringAUtilDateSegunFormato() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date expected = sdf.parse("26/08/2016");
		
		assertEquals(expected, dst.getFechaUtilStr());
	}

	/**
	 * Comprueba que se mapea bien un bigdecimal a un string atendiendo
	 * al formato y locale especificados
	 */
	@Test
	public void mapeaBigDecimalAStringSegunFormato(){
		String expected = "123.456.789,1";
		assertEquals(expected, dst.getBigDecimal());
	}
	
	/**
	 * Comprueba que se mapean bien las listas
	 */
	@Test
	public void mapeaListas(){
		List<DstNestedTest> lista = dst.getLista();
		for(int i = 0; i < src.getLista().size(); i++){
			Integer srcId = src.getLista().get(i).getNestedId();
			assertEquals(srcId, lista.get(i).getNestedId());
			assertNotNull(lista.get(i).getSrcTest());
			
		}
		
	}
	/**
	 * Comprueba que se mapean bien los arrays
	 */
	@Ignore
	@Test
	public void mapeaArrays(){		
		
	}
	
	/**
	 * Comprueba que se mapean bien los HashSet
	 */
	@Test
	public void mapeaHashSet(){
		Set<DstNestedTest> set = dst.getSet();
		for(SrcNestedTest nest: src.getSet()){
			Integer srcId = nest.getNestedId();
			DstNestedTest dstNest = new DstNestedTest();
			dstNest.setNestedId(srcId);
			assertTrue(set.contains(dstNest));
			
		}
		
	}
	
	/**
	 * Comprueba que se mapean bien los HashSet
	 */
	@Test
	public void mapeaTreeSet(){
		Set<DstNestedTest> set = dst.getSortedSet();
		for(SrcNestedTest nest: src.getSortedSet()){
			Integer srcId = nest.getNestedId();
			DstNestedTest dstNest = new DstNestedTest();
			dstNest.setNestedId(srcId);
			assertTrue(set.contains(dstNest));
			
		}
		
	}
	
	/**
	 * Comprueba que la profundidad del mapeo concuerda con
	 * la definida en MappingDeep, en este caso 1
	 */
	@Test
	public void deep(){
		assertEquals(dst.getEntero(), dst.getNested().getSrcTest().getEntero());
		assertNull(dst.getNested().getSrcTest().getNested());
		assertEquals(dst.getEntero(), dst.getNested().getSrcTest2().getEntero());
		assertNull(dst.getNested().getSrcTest2().getNested());
		assertNull(dst.getLista().get(0).getSrcTest().getNested());
		assertNotNull(dst.getSortedSet().first().getNested2());
	}
}



