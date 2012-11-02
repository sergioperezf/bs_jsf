/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.BsPost;

/**
 *
 * @author Sergio
 */
@Stateless
public class BsPostFacade extends AbstractFacade<BsPost> {
    @PersistenceContext(unitName = "BlogSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BsPostFacade() {
        super(BsPost.class);
    }
    
}
