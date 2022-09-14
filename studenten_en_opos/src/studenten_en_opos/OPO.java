package studenten_en_opos;

import java.util.HashSet;
import java.util.Set;

import logicalcollections.LogicalSet;

/**
 * @invar | getAantalStudiepunten() > 0
 * @invar | getStudenten() != null
 * @invar | getStudenten().stream().allMatch(s -> s.getOPOs().contains(this))
 *
 */
public class OPO {
	
	/**
	 * @invar | aantalStudiepunten > 0
	 * @invar | studenten != null
	 * @invar | studenten.stream().allMatch(s -> s != null && s.opos.contains(this))
	 */
	int aantalStudiepunten;
	/**
	 * @representationObject
	 * @peerObjects
	 */
	Set<Student> studenten = new HashSet<>();

	/**
	 * @immutable
	 */
	public int getAantalStudiepunten() { return aantalStudiepunten; }

	/**
	 * @creates | result
	 * @peerObjects
	 */
	public Set<Student> getStudenten() { return Set.copyOf(studenten); }
	
	/**
	 * @throws IllegalArgumentException | aantalStudiepunten <= 0
	 * 
	 * @post | getAantalStudiepunten() == aantalStudiepunten
	 * @post | getStudenten().isEmpty()
	 */
	public OPO(int aantalStudiepunten) {
		if (aantalStudiepunten <= 0)
			throw new IllegalArgumentException("`aantalStudiepunten` is niet groter dan nul");
		this.aantalStudiepunten = aantalStudiepunten;
	}
	
	/**
	 * @pre | student != null
	 * @pre | student.getOPOs().size() < 12
	 * 
	 * @mutates_properties | getStudenten(), student.getOPOs()
	 * 
	 * @post | getStudenten().equals(LogicalSet.plus(old(getStudenten()), student))
	 * @post | student.getOPOs().equals(LogicalSet.plus(old(student.getOPOs()), this))
	 */
	public void schrijfIn(Student student) {
		studenten.add(student);
		student.opos.add(this);
	}
	
	/**
	 * @pre | student != null
	 * 
	 * @mutates_properties | getStudenten(), student.getOPOs()
	 * 
	 * @post | getStudenten().equals(LogicalSet.minus(old(getStudenten()), student))
	 * @post | student.getOPOs().equals(LogicalSet.minus(old(student.getOPOs()), this))
	 */
	public void schrijfUit(Student student) {
		studenten.remove(student);
		student.opos.remove(this);
	}
	
}
