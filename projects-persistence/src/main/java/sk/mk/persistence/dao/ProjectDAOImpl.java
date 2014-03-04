package sk.mk.persistence.dao;

import sk.mk.persistence.entity.Project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 4.3.2014
 * Time: 9:34
 */
public class ProjectDAOImpl implements ProjectDAO {

    private List<Project> projects = new ArrayList<>();

    @Override
    public List<Project> getList() {
        return this.projects;
    }

    @Override
    public void create(Project p) {
        this.projects.add(p);
    }

    @Override
    public void update(Project p) {
        this.projects.remove(p);//this is ugly, but who cares in memory impl.
        this.projects.add(p);
    }

    @Override
    public void remove(int id) {// this is due to hibernate, its better to do it this way
        Project p = new Project();
        p.setId(id);
        this.projects.remove(p);
    }

    @Override
    public Project find(int id) {
        for (Project p : projects) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
