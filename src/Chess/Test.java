package Chess;
import Chess.Chess;


public class Test {
	
	Chess chess = null;
	public void init(){
		chess = new Chess() ;
	}
	public void teststart(){
		System.out.println("chess start test\n");
		try{
			chess.start();
		}catch( Exception e){
			System.out.println("this modle has a problem");
			e.printStackTrace();
		}
		
		System.out.println("this modle is ok");
		
	}

	public void testplay(){
		System.out.println("chess play test\n");
		try{
			chess.play();
		}catch( Exception e){
			System.out.println("this modle has a problem");
			e.printStackTrace();
		}
		
		System.out.println("this modle is ok");
	
	}
	
	public void testend(){
		System.out.println("chess end test\n");
		try{
			chess.play();
		}catch( Exception e){
			System.out.println("this modle has a problem");
			e.printStackTrace();
		}
		
		System.out.println("this modle is ok");
	}
	
	public static void main(String args[]){

		Test test = new Test();
		test.init();
		test.teststart();
		test.testplay();
		test.testend();
	}

}
