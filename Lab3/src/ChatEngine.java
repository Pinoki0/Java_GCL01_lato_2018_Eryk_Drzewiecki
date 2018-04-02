import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ChatEngine
{
	
	Map<Long, User> hmap= new HashMap<>();
	
	public void loginUser(User user) throws UserLoginException
	{
		if(hmap.containsValue(user)==true)
		{
			throw new UserLoginException();
		}
		hmap.put((long) hmap.size(),user);
		user.id=hmap.size();
	}
	
	public void logoutUser(long userld) throws UserRemoveException
	{
		if(hmap.size()>0)
		{
			hmap.remove(hmap.size());
		}
		else
		{
		throw new UserRemoveException();
		}
	}
	
	public int getNumberOfUsers()
	{
		return hmap.size();
	}
	
	public void addUserStar(String userName)
	{
		
		
	}
	
	

	public void removeUserStar(String userName)
	{
		
		
	}
	
	public boolean hasUser(long userId)
	{
		return userId.constains();
	}
	
	public boolean hasUser(String userName)
	{
		return userName.constains(User);
	}
	
}
