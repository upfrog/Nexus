package models;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import views.LoginController;
import views.ProfileController;
import views.SidebarController;

/*
 * Stores methods to transition between views
 */
public class ViewTransitionModel implements ViewTransitionModelInterface
{
	Stage stage;
	
	BorderPane view;
	
	public ViewTransitionModel(Stage stage)
	{
		this.stage = stage;
	}
	
	public ViewTransitionModel(BorderPane view)
	{
		this.view = view;
	}

	
	@Override
	public void showProfileView()
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
				.getResource("../views/ProfileView.fxml"));
		
		
		//Get the sidebar images
		/*
		File f = new File("../img/search.png");
		Image img = new Image(f.toURI().toString());
		ImageView iview1 = new ImageView(img);
		*/
		try
		{
			BorderPane view = loader.load();
			this.view.setCenter(view);
			
			
			ProfileController cont = loader.getController();
			cont.setVTM(this);
			cont.populatePage();
			FXMLLoader sidebarLoader = new FXMLLoader();
			
			sidebarLoader.setLocation(getClass().getResource("../views/Sidebar.fxml"));
			SidebarController sidebarCont = sidebarLoader.getController();
			this.view.setLeft(sidebarLoader.load());
			/*
			User user = new User("Individual");
			cont.setVTM(this);
			cont.setUser(user);
			cont.populatePage();
			*/
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showLoginView()
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
				.getResource("../views/LoginView.fxml"));
		try
		{
			BorderPane view = loader.load();
			LoginController controller = new LoginController();
			this.view.setCenter(view);
			ViewTransitionModel vtm = new ViewTransitionModel(view);
			controller.setVTM(vtm);
			
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	My work
	public void showProfileView()
	{
		ProfileController profileController = new ProfileController();
		profileController.setUser(new User("Individual"));
		profileController.setVTM(this);
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../views/ProfileView.fxml"));
		
		try
		{
			Node view = loader.load();
			
		}
		
		
	}
	*/
	
	
	/*
	ProfileController cont = loader.getController();
	User user = new User("Individual");
	cont.setVTM(this);
	cont.setUser(user);
	cont.populatePage();
	*/
}