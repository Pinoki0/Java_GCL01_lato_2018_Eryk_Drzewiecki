
public class User 
{
long id=0;
String name = "Kasia";
long numberOfStars=0;
long numberOfSentMessages=0;

public long pobierzID()
{
	return id;
	
}

public String pobierzName()
{
	return name;
	
	
}

public long pobierzNumberOfStars()
{
	return numberOfStars;
	
}

public long pobierzNumberOfSentMessages()
{
	return numberOfSentMessages;
}

public void zmienPola(long id, String name, long numberOfStars, long numberOfSentMessages)
{
	this.id=id;
	this.name=name;
	this.numberOfStars=numberOfStars;
	this.numberOfSentMessages=numberOfSentMessages;
}






}