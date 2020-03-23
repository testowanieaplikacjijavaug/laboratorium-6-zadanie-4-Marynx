import org.assertj.core.api.AbstractAssert;

public class AssertJMatcher extends AbstractAssert<AssertJMatcher,Friendship> {
    
    public AssertJMatcher(Friendship friendship) {
        super(friendship, AssertJMatcher.class);
    }
    
    public static AssertJMatcher assertThat(Friendship actual) {
        return new AssertJMatcher(actual);
    }
    
    public AssertJMatcher hasNoFriends(String name){
        if(actual.getFriendsList(name)==null){
            failWithMessage("This person has no friends");
        }
        return this;
    }
    
    public AssertJMatcher hasFriendship(String person,String person1){
        if(!actual.friendships.get(person).contains(person1)||!actual.friendships.get(person1).contains(person)){
            failWithMessage("No friends between them");
        }
        return this;
    }
    
}
