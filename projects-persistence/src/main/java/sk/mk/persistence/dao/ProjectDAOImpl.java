package sk.mk.persistence.dao;

import sk.mk.persistence.entity.Project;
import sk.mk.persistence.util.XmlProjectsParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 4.3.2014
 * Time: 9:34
 *
 * I would suggest to use something more sophisticated more like hibernate or any other ORM framework
 */
public class ProjectDAOImpl implements ProjectDAO {

    private XmlProjectsParser dataInitializer = new XmlProjectsParser();

    private List<Project> projects = new ArrayList<>();

    @Override
    public List<Project> getList() {
        this.projects = dataInitializer.loadProjects();
        return this.projects;
    }

    @Override
    public void create(Project p) {
        this.projects.add(p);
        dataInitializer.storeProjects(this.projects);
    }

    @Override
    public void update(Project p) {
        this.projects.remove(p);//this is ugly, but who cares in memory impl.
        this.projects.add(p);
        dataInitializer.storeProjects(this.projects);
    }

    @Override
    public void remove(String id) {// this is due to hibernate, its better to do it this way
        Project p = new Project();
        p.setId(id);
        this.projects.remove(p);
        dataInitializer.storeProjects(this.projects);
    }

    @Override
    public Project find(String id) {
        for (Project p : projects) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
