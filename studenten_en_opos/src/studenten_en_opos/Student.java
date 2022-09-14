package studenten_en_opos;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @invar | getOPOs() != null
 * @invar | getOPOs().size() <= 12
 * @invar | getOPOs().stream().allMatch(o -> o != null && o.getStudenten().contains(this))
 */
public class Student {
	
	/**
	 * @invar | opos != null
	 * @invar | opos.size() <= 12
	 * @invar | opos.stream().allMatch(o -> o != null && o.studenten.contains(this))
	 * 
	 * @representationObject
	 * @peerObjects
	 */
	Set<OPO> opos = new HashSet<>();
	
	/**
	 * @creates | result
	 * @peerObjects
	 */
	public Set<OPO> getOPOs() { return Set.copyOf(opos); }

	/**
	 * @post | getOPOs().isEmpty()
	 */
	public Student() {}
	
	public Set<Student> getMedestudenten() {
		return opos.stream()
				   .flatMap(o -> o.studenten.stream())
				   .filter(s -> s != this)
				   .collect(Collectors.toSet());
	}
}
