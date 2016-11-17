package leetcode3;

public class one_edit_distance {
	public static void main(String[] args) {
		one_edit_distance o = new one_edit_distance();
		o.isOneEditDistance("ABC", "AB");
	}

	public boolean isOneEditDistance(String s, String t) {
		if (s == null || t == null) return false;
		int i = 0;
		int j = 0;
		if (s.length() < t.length()) {
			String tmp = t;
			t = s;
			s = tmp;
		}
		while (i < s.length() && j < t.length()) {
			char a = s.charAt(i);
			char b = t.charAt(j);
			if (a == b) {
				i++;
				j++;
			} else {
				if (s.length() == t.length()) {
					return s.substring(i + 1, s.length()).equals(t.substring(j + 1, t.length()));
				} else {
					return s.substring(i + 1, s.length()).equals(t.substring(j, t.length()));
				}
			}
		}

		return Math.abs(s.length() - t.length()) == 1;
	}
}
