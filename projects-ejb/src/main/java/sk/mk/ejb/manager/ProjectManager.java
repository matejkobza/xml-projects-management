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

    /**
     * creates new project if no id set or updates existing project if id is present in project p
     * @param p
     */
    public void createOrUpdate(Project p);

    public void delete(Project p);

    /**
     * how about to use infinispan here
     * @return
     */
    public List<Project> list();
}
