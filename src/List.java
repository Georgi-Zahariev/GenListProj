
public class List<T> {
	private Node<T> first, last;

	public List() {
		first = last = null;
	}

	public List(T v) {
		first = last = new Node<T>(v);
	}

	public Node<T> getFirst() {
		return first;
	}
    
	public void setFirst(Node<T> f) {
		first = f;
	}

	public Node<T> getLast() {
		return last;
	}

	public void setLast(Node<T> l) {
		last = l;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public T getFront() throws NullPointerException {	
		if (first == null)
			throw new NullPointerException();
		return first.getData();
	}

	public T getBack() throws NullPointerException {	
		if (last == null)
			throw new NullPointerException();
		return last.getData();
	}
	
	public T getData(int n) throws IllegalArgumentException {
		if (n < 0)
			throw new IllegalArgumentException();
		Node<T> t = first;
		do {
			if (t == null)
				throw new IllegalArgumentException();
			if (n == 0)
				return t.getData();
			n--;
			t = t.getNext();
		} while (true);
	}
	
	public void push_front(T v) {

		if (first == null) {
			first = last = new Node<T>(v);
			return;
		}
		Node<T> t = new Node<T>(v, null, first);
		first.setPrev(t);
		first = t;
	}

	public void push_back(T v) {
		if (first == null)
			first = last = new Node<T>(v);
		else {
			Node<T> t = new Node<T>(v, last, null);
			last.setNext(t);
			last = t;
		}
	}

	public void pop_front() throws NullPointerException {
		if (first == null)
			throw new NullPointerException();
		first = first.getNext();
		if (first == null)
			last = null;
		else
			first.setPrev(null);
	}

	public void pop_back() throws NullPointerException {
		if (last == null)
			throw new NullPointerException();
		last = last.getPrev();
		if (last == null)
			first = null;
		else
			last.setNext(null);
	}

	@Override
	public String toString() {
		String s = "";
		Node<T> t = first;
		while (t != null) {
			if (!s.equals(""))
				s += ", ";
			s += t.getData();
			t = t.getNext();
		}
		s = "{" + s + "}";
		return s;
	}
}
