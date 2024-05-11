package models;

public interface ViewTransitionModelInterface
{
	public void showProfileView();
	public void showLoginView();
	public void setUser(User user);
	public User getUser();
	public void showMakePostView();
	public void showEditProfileView();
	public void showFeed();
	public void showForeignProfile(User user);
	//void showProfileView(User user);
}
