package sk.mk.web.controller;

import sk.mk.ejb.manager.ProjectManager;
import sk.mk.persistence.entity.Project;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 4.3.2014
 * Time: 16:27
 */
@ManagedBean
@ViewScoped
public class ProjectsBean implements Serializable {

    private static final long serialVersionUID = -2723678842328731137L;

    @EJB(name = "ProjectManager")
    private ProjectManager projectManager;

    private List<Project> projects;
    private Project project;

    @PostConstruct
    public void init() {
        this.project = new Project();
        this.projects = projectManager.list();
    }

    public void reset() {
        this.project = new Project();
    }

    public List<Project> getProjects() {
        return projectManager.list();
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void createOrUpdate() {
        projectManager.createOrUpdate(this.project);
        this.init();
    }

    public void delete(Project p) {
        projectManager.delete(p);
    }

    public void edit(Project p) {
        this.project = p;
    }
}
