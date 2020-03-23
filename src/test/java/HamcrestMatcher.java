import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class HamcrestMatcher {
    
    
    public static Matcher<Friendship> hasNoFriends(final String person) {
        return new TypeSafeMatcher<Friendship>() {
    
            @Override
            protected boolean matchesSafely(Friendship friendship) {
                if (friendship.getFriendsList(person) == null){
                    return true;
                }
                return false;
            }
            
            @Override
            public void describeTo(Description description) {
                description.appendText("This person has no friends");
            }
    
           
        };
    }
    
    public static Matcher<Friendship> hasFriendship(final String person,final String person1) {
        return new TypeSafeMatcher<Friendship>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("No friends between them");
            }
    
            @Override
            protected boolean matchesSafely(Friendship item) {
                if(!item.friendships.get(person).contains(person1)||!item.friendships.get(person1).contains(person)) {
                    return true;
                }
                return false;
            }
        };
    }
}
