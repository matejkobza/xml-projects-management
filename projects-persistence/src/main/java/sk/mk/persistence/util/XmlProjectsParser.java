package sk.mk.persistence.util;

import sk.mk.persistence.entity.Project;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 4.3.2014
 * Time: 21:19
 */
public class XmlProjectsParser {

    private File file = new File("/Users/matejkobza/projects.xml");

    JAXBContext jaxbContext = null;

    public XmlProjectsParser() {
        try {
            jaxbContext = JAXBContext.newInstance(Projects.class);
        } catch (JAXBException e) {
            //todo log
            e.printStackTrace();
        }
    }

    @XmlRootElement
    private static class Projects {

        @XmlElement(required = true, type = Project.class, name = "project")
        private List<Project> projects;

        private List<Project> getProjects() {
            return projects;
        }

        private void setProjects(List<Project> projects) {
            this.projects = projects;
        }
    }

    /**
     * @return returns list of projects or empty list if no projects or error
     */
    public List<Project> loadProjects() {
        try {
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Projects projects = (Projects) jaxbUnmarshaller.unmarshal(file);
            return projects.getProjects();
        } catch (JAXBException e) {
            //todo log
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * @param projects list of projects to be stored
     */
    public void storeProjects(List<Project> projects) {
        Projects projectz = new Projects();
        projectz.setProjects(projects);
        try {
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(projectz, file);
        } catch (JAXBException e) {
            //todo log
            e.printStackTrace();
        }
    }

}
