package algos.cracking.coding.book.Ch8.Q8_01_Triple_Step.Q8_13_Stack_of_Boxes;

import java.util.Comparator;

public class BoxComparator implements Comparator<Box> {
	@Override
	public int compare(Box x, Box y){
		return y.height - x.height;
	}
}
