package com.intellect.repositoryImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import com.intellect.entity.User;
import com.intellect.repository.UserRepository;

@SuppressWarnings("unchecked")
public class UserRepositoryImpl implements UserRepository {

	@SuppressWarnings("resource")
	@Override
	public User saveUser(User user) {
		OutputStream ops = null;
        ObjectOutputStream objOps = null;
        
        InputStream fileIs = null;
        ObjectInputStream objIs = null;
        
        try {
        	fileIs = new FileInputStream("Users.txt");
            objIs = new ObjectInputStream(fileIs);
			List<User> users = (List<User>) objIs.readObject();
			if(users != null || users.size() > 0) {
				for (User userToUpdate : users) {
					if(userToUpdate.getId() == user.getId()) {
						userToUpdate.setPinCode(user.getPinCode());
						userToUpdate.setBirthDate(user.getBirthDate());
					}
				}
				objOps = writeToFile(users);
			} else {
				List<User> newUsers = Arrays.asList(user);
				objOps = writeToFile(newUsers);
			}
            objOps.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
            try{
                if(objOps != null) objOps.close();
            } catch (Exception ex){
                 
            }
        }
		return user;
	}

	private ObjectOutputStream writeToFile(List<User> users) throws FileNotFoundException, IOException {
		OutputStream ops;
		ObjectOutputStream objOps;
		ops = new FileOutputStream("Users.txt");
		objOps = new ObjectOutputStream(ops);
		objOps.writeObject(users);
		return objOps;
	}
	
	@Override
	public List<User> getUsers(){
        
        InputStream fileIs = null;
        ObjectInputStream objIs = null;
        List<User> users = null;
		try {
            fileIs = new FileInputStream("Users.txt");
            objIs = new ObjectInputStream(fileIs);
			users  = (List<User>) objIs.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(objIs != null) objIs.close();
            } catch (Exception ex){
                 
            }
        }
		return users;
         
    }

	@Override
	public void saveUsers(List<User> users) {
		OutputStream ops = null;
        ObjectOutputStream objOps = null;
        try {
        	ops = new FileOutputStream("Users.txt");
        	objOps = new ObjectOutputStream(ops);
			objOps = writeToFile(users);
            objOps.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if(objOps != null) objOps.close();
            } catch (Exception ex){
                 
            }
        }
	}

}
