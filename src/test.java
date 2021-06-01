
public class test {
	public static void main(String[] args) {
		Node<Integer> n = new Node<Integer>(new Integer(5));
		System.out.println(n.toString());

		Node<String> s = new Node<String>(new String("Paper"));
		System.out.println(s.toString());

		Node<Fraction> f = new Node<Fraction>(new Fraction(1, 2));
		System.out.println(f.toString());

		List<String> l = new List<String>(new String("Lunch"));
		System.out.println(l.toString());
		l.push_back(new String("Diner"));
		System.out.println(l.toString());
		l.push_front(new String("Breakfast"));
		System.out.println(l.toString());

		l.pop_front();
		System.out.println(l.toString());

		List<Integer> i = new List<Integer>();
		for (int j = 10; j <= 20; j++)
			i.push_back(j);
		System.out.println(i.toString());

		try {
			System.out.println(i.getData(6));
		} catch (Exception e) {
			System.out.println("There are fewer elements");

		}

	}
}
