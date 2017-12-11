package api;

import entity.data.DataAttachment;
import entity.domain.Attachment;

import javax.persistence.EntityManager;


public class AttachementController extends Controller
{
    public AttachementController (EntityManager em)
    {
        super(em);
    }
    
    public static DataAttachment dataFromDomain(Attachment attachment)
    {
        return null;
    }
}
