package cybagenet.pojos;

public class BookReview {
	private long isbn;
	private int empId;
	private String review;
	
	public BookReview() {
	}
	public BookReview(int empId, String review) {
		this.empId = empId;
		this.review = review;
	}
	public BookReview(long isbn, int empId, String review) {
		super();
		this.isbn = isbn;
		this.empId = empId;
		this.review = review;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	@Override
	public String toString() {
		return "BookReview [isbn=" + isbn + ", empId=" + empId + ", review=" + review + "]";
	}
	
	
	
	
}
