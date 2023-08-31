package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class ReadingJsonFIle {

	public static User Readingfile()
	{
		Gson gson = new Gson();
		try {
		User user = gson.fromJson(new JsonReader(new FileReader(new File("user.json"))), User.class);
		System.out.println(user);
		return user;
		}
		catch(FileNotFoundException e)
		{
			//TODO:handle exception
		}
		return null;
	}
}
