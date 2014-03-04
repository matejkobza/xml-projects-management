package sk.mk.ejb.manager;

import sk.mk.persistence.dao.ProjectDAO;
import sk.mk.persistence.entity.Project;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 4.3.2014
 * Time: 9:37
 */
@Dependent
@Named("projectManager")
@Stateless
@Remote
public class ProjectManagerImpl implements ProjectManager {

    @Inject
    private ProjectDAO projectDAO;

    @Override
    public void createOrUpdate(Project p) {
        if (p.getId() != null) {
            projectDAO.update(p);
        } else {
            p.setId(UUID.randomUUID().hashCode());
            projectDAO.create(p);
        }
    }

    @Override
    public void delete(Project p) {
        projectDAO.remove(p.getId());
    }

    @Override
    public void update(Project p) {
        projectDAO.update(p);
    }

    @Override
    public void find(int id) {
        projectDAO.find(id);
    }

    @Override
    public List<Project> list() {
        // infinispan - cache
        return projectDAO.getList();
    }
}
