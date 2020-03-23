import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class FriendshipAsserJTest {
    private Friendship friendships;
    
    @Before
    public void setup(){
        friendships=new Friendship();
    }
    
    @Test
    public void testFriendsMapIsEmpty(){
        assertThat(friendships.friendships).hasSize(0);
    }
    
    
    
    @Test
    public void testFriendshipMakeFriends(){
        String friend="Adam";
        String friend1="Jan";
        String friend2="Tosia";
        friendships.makeFriends(friend,friend1);
        assertThat(friendships.getFriendsList(friend)).hasSize(1).contains(friend1).doesNotContain(friend2);
    }
    
    @Test
    public void testFriendshipGetFriends(){
        String friend="Adam";
        String friend1="Jan";
        friendships.makeFriends(friend,friend1);
        assertThat(friendships.getFriendsList(friend)).isNotEmpty();
    }
    
    @Test
    public void testFriendshipGetFriendsWithNotFriends(){
        String friend="Adam";
        String friend1="Jan";
        String friend2="Tosia";
        friendships.makeFriends(friend,friend1);
        assertThat(friendships.getFriendsList(friend2)).isEqualTo(null);
    }
    
    @Test
    public void testFriendshipAreFriends(){
        String friend="Adam";
        String friend1="Jan";
        friendships.makeFriends(friend,friend1);
        assertThat(friendships.areFriends(friend,friend1)).isTrue();
    }
    
    @Test
    public void testFriendshipAreNotFriends(){
        String friend="Adam";
        String friend1="Jan";
        String friend2="Tosia";
        friendships.makeFriends(friend,friend1);
        assertThat(friendships.areFriends(friend,friend2)).isFalse();
    }
    
    @Test
    public void testFriendshipMakeFriendsWithTheSameFriend(){
        String friend="Adam";
        String friend1="Jan";
        String friend2="Tosia";
        friendships.makeFriends(friend,friend1);
        friendships.makeFriends(friend,friend1);
        assertThat(friendships.getFriendsList(friend)).hasSize(1).doesNotContain(friend2).contains(friend1);
    }
    
    @Test
    public void testCustomMatcher(){
        String friend="Adam";
        String friend1="Jan";
        friendships.makeFriends(friend,friend1);
        AssertJMatcher.assertThat(friendships).hasNoFriends("Adam");
    }
    
    @Test
    public void testCustomMatcher1(){
        String friend="Adam";
        String friend1="Jan";
        friendships.makeFriends(friend,friend1);
        AssertJMatcher.assertThat(friendships).hasFriendship(friend,friend1);
    }
    
    @After
    public void teardown(){
        friendships=null;
    }
}
