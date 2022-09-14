package studenten_en_opos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

class StudentenEnOPOsTest {

	@Test
	void test() {
		Student jan = new Student();
		assertEquals(Set.of(), jan.getOPOs());
		
		OPO ogp = new OPO(6);
		assertEquals(6, ogp.getAantalStudiepunten());
		assertEquals(Set.of(), ogp.getStudenten());
		
		ogp.schrijfIn(jan);
		assertEquals(Set.of(jan), ogp.getStudenten());
		assertEquals(Set.of(ogp), jan.getOPOs());
		
		Student marijke = new Student();
		ogp.schrijfIn(marijke);
		assertEquals(Set.of(jan, marijke), ogp.getStudenten());
		assertEquals(Set.of(ogp), jan.getOPOs());
		assertEquals(Set.of(ogp), marijke.getOPOs());
		
		assertEquals(Set.of(jan), marijke.getMedestudenten());
		
		ogp.schrijfUit(jan);
		assertEquals(Set.of(marijke), ogp.getStudenten());
		assertEquals(Set.of(), jan.getOPOs());
		assertEquals(Set.of(ogp), marijke.getOPOs());
	}

}
