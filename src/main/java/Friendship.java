import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Friendship {
    Map<String, List<String>> friendships = new HashMap<>();
    
    //Dodanie przyjaciół - wykorzystuje funkcje addFriend!
    public void makeFriends(String person1, String person2) {
        addFriend(person1, person2);
        addFriend(person2, person1);
    }
    
    //Pobranie listy przyjaciol
    public List<String> getFriendsList(String person) {
        return friendships.get(person);
    }
    
    //Sprawdzenie czy przyjaciele
    public boolean areFriends(String person1, String person2) {
        return getFriendsList(person1).contains(person2);
    }
    //Dodanie do listy przyjaciol do danej osoby
    private void addFriend(String person, String friend) {
        friendships.put(person,new ArrayList<>());
        getFriendsList(person).add(friend);
    }
}
