import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class HamcrestTest {
    private Friendship friendships;
    
    @Before
    public void setup(){
        friendships=new Friendship();
    }
    
    @Test
    public void testFriendsMapIsEmpty(){
        assertThat(friendships.friendships.size(),is(0));
    }
    
    
    
    @Test
    public void testFriendshipMakeFriends(){
        String friend="Adam";
        String friend1="Jan";
        friendships.makeFriends(friend,friend1);
        assertThat(friendships.getFriendsList(friend),contains(friend1));
        assertThat(friendships.getFriendsList(friend1),contains(friend));
    }
    
    @Test
    public void testFriendshipGetFriends(){
        String friend="Adam";
        String friend1="Jan";
        friendships.makeFriends(friend,friend1);
        assertThat(friendships.getFriendsList(friend),not(empty()));
    }
    
    @Test
    public void testFriendshipGetFriendsWithNotFriends(){
        String friend="Adam";
        String friend1="Jan";
        String friend2="Tosia";
        friendships.makeFriends(friend,friend1);
        assertThat(friendships.getFriendsList(friend2),is(equalTo(null)));
    }
    
    @Test
    public void testFriendshipAreFriends(){
        String friend="Adam";
        String friend1="Jan";
        friendships.makeFriends(friend,friend1);
        assertThat(friendships.areFriends(friend,friend1),equalTo(true));
    }
    
    @Test
    public void testFriendshipAreNotFriends(){
        String friend="Adam";
        String friend1="Jan";
        String friend2="Tosia";
        friendships.makeFriends(friend,friend1);
        assertThat(friendships.areFriends(friend,friend2),equalTo(false));
    }
    
    @Test
    public void testFriendshipMakeFriendsWithTheSameFriend(){
        String friend="Adam";
        String friend1="Jan";
        String friend2="Tosia";
        friendships.makeFriends(friend,friend1);
        friendships.makeFriends(friend,friend1);
        assertThat(friendships.getFriendsList(friend),hasSize(1));
    }
    
    @Test
    public void testCustomMatcher(){
        String friend="Adam";
        assertThat(friendships,HamcrestMatcher.hasNoFriends(friend));
    }
    
    @Test
    public void testCustomMatcher1(){
        String friend="Adam";
        String friend1="Jan";
        String friend2="Zosia";
        friendships.makeFriends(friend,friend1);
        friendships.makeFriends(friend1,friend2);
        assertThat(friendships,HamcrestMatcher.hasFriendship(friend,friend2));
    }
    
    @After
    public void teardown(){
        friendships=null;
    }
}
