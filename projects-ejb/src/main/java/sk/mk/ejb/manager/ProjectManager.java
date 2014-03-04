package sk.mk.ejb.manager;

import sk.mk.persistence.entity.Project;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 4.3.2014
 * Time: 9:37
 */
public interface ProjectManager {

    public void createOrUpdate(Project p);

    public void delete(Project p);

    public void update(Project p);

    public void find(int id);

    public List<Project> list();
}
