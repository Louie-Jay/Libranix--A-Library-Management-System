package sample;
public class LoginWindowControllerSample {
	LoginWindowSample myLogin = new LoginWindowSample();
	LoginListener myListener = new LoginListener() {

		@Override
		public void login() {
			System.out.println(myLogin.getUsername());
			System.out.println(myLogin.getPassword());
			myLogin.clearLogin();
			
			//myLogin.increaseDisplay();
			myLogin.addPanel();
		}

		@Override
		public void exit() {
			System.exit(0);
			
		}

		@Override
		public void test() {
			myLogin.clearLogin();
			myLogin.test();
			
		}

		@Override
		public void creak() {
			myLogin.creak();
			
		}

		@Override
		public void x() {
			myLogin.increaseX();
			
			
		}

		@Override
		public void y() {
			myLogin.increaseY();
			
		}

		/*@Override
		public void x() {
			
			
		}

		@Override
		public void y() {
			// TODO Auto-generated method stub
			
		}*/
		
	};
	
	
	LoginWindowControllerSample(){
		myLogin.setListener(myListener);
	}
}
