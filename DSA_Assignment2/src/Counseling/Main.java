package Counseling;


public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CollegeCounseling counseling = new CollegeCounseling();
        //counseling.showStudentDetail();
        
        counseling.genrateQueue();
        counseling.show();
        counseling.saveData();

	}

}
