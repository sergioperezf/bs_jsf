/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.BsComment;

/**
 *
 * @author Sergio
 */
@Stateless
public class BsCommentFacade extends AbstractFacade<BsComment> {
    @PersistenceContext(unitName = "BlogSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BsCommentFacade() {
        super(BsComment.class);
    }
    
}
