package sk.mk.web.core;

import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ResourceBundle;

/**
 * Application instance representation. Support for faces messages and other handy staff for development
 */
public class WebApplication {

    private static WebApplication ref;

    public Application getApplication() {
        return getFacesContext().getApplication();
    }

    public static WebApplication getReference() {
        if (ref == null) {
            ref = new WebApplication();
        }
        return ref;
    }

    public void setFacesBean(String beanScopeAndName, Object value) {
        Application app = getApplication();
        ValueExpression ve = app.getExpressionFactory().createValueExpression(
                getFacesContext().getELContext(), "#{" + beanScopeAndName + "}",
                value.getClass());
        ve.setValue(getFacesContext().getELContext(), value);
    }

    public Object getFacesBean(String beanScopeAndName, Class<?> cls) {
        Application app = getApplication();
        ValueExpression ve = app.getExpressionFactory().createValueExpression(
                getFacesContext().getELContext(), "#{" + beanScopeAndName + "}", cls);
        return ve.getValue(getFacesContext().getELContext());
    }

    public void addInfoMessage(String title, String message) {
        getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, title, message));
    }

    public void addWarnMessage(String title, String message) {
        getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, title, message));
    }

    public void addErrorMessage(String title, String message) {
        getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, message));
    }

    public void addFatalMessage(String title, String message) {
        getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, title, message));
    }

    public void addInfoMessage(String message) {
        addInfoMessage(null, message);
    }

    public void addWarnMessage(String message) {
        addWarnMessage(null, message);
    }

    public void addErrorMessage(String message) {
        addErrorMessage(null, message);
    }

    public void addFatalMessage(String message) {
        addFatalMessage(null, message);
    }

    /**
     * @return return current resource bundle
     */
    public ResourceBundle getResourceBundle() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        return resourceBundle;
    }

    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

}
