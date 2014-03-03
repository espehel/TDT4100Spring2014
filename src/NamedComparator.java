import java.util.Comparator;

public class NamedComparator implements Comparator<Named>
    {
    public int compare(Named named1, Named named2)
        {
        return (named1.getFamilyName() + named1.getGivenName()).compareTo(
                named2.getFamilyName() + named2.getGivenName());
        }
    
    }