package stringManipulator;

public class StringManipulator {
	public String trimAndConcat(String str_1, String str_2) {
		return str_1.trim() + str_2.trim();
	}
	public int getIndexOrNull(String str_1, char chr_1) {
		return str_1.indexOf(chr_1);
	}
	public int getIndexOrNull2(String str_1, String str_2) {
		return str_1.indexOf(str_2);
	}
	public String concatSubstring(String str_1, int index_1, int index_2, String str_2) {
			return str_1.substring(index_1, index_2) + str_2;
	}
}
