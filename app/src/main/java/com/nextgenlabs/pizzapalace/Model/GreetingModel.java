package com.nextgenlabs.pizzapalace.Model;

import android.util.Log;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.Calendar;

public class GreetingModel {
    static FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    private String getGreeting = timeGreeting();
    private String username = userName();

   private static String userName(){
        String usernameString;
        String username = "";
        if(firebaseUser != null){
            usernameString = firebaseUser.getDisplayName() + "!";

            int i = 0;
            while (usernameString.charAt(i) != ' ') {
                username = username + usernameString.charAt(i);
                i++;
            }
        }
        else {
            username = "Stranger!";
        }
        return username;
   }

    public static String timeGreeting(){
        int time = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        String timeGreeting = "";
        Log.d("GreetingModel", "timeGreeting: " + time);

        if(time >= 6 && time <= 11 ){
            timeGreeting = "Good Morning";
        }
        else if (time >= 12 && time <= 16){
            timeGreeting = "Good AfterNoon";
        }
        else {
            timeGreeting = "Good Evening";
        }
        Log.i("time", "timeGreeting: " + timeGreeting);
        return timeGreeting;
    }

    public String getGetGreeting() {
        return getGreeting;
    }

    public String getUsername() {
        return username;
    }
}
