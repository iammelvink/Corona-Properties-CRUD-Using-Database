package coronaproperties;

/**
 *
 * @author Melvin K
 */
public class CreateProp
{
    static boolean createSomeProp = false;
    static boolean createSome()
    {
        createSomeProp = true;

        CRUDViewTemplate aCRUDViewTemplate = new CRUDViewTemplate();
        aCRUDViewTemplate.setTitle("Add New Property");
        SetJFrameIcon setJFrameIcon = new SetJFrameIcon(aCRUDViewTemplate);

        return createSomeProp;
    }

}
