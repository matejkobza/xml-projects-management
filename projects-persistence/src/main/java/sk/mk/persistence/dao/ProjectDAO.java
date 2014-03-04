package sk.mk.persistence.dao;

import sk.mk.persistence.entity.Project;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 4.3.2014
 * Time: 9:25
 */
public interface ProjectDAO {

    public List<Project> getList();

    public void create(Project p);

    public void update(Project p);

    public void remove(String id);

    public Project find(String id);

}
