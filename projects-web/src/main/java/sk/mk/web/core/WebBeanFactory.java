package sk.mk.web.core;

import sk.mk.web.controller.IdentityBean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

/**
 * Purpose of this Factory is to make available all the web beans to the java code.
 * Handy for backend developers.
 *
 * Should contain all the beans but as far as they are useless for such a small application
 * we might don't want to write what we don't use.
 */
@ManagedBean
@ApplicationScoped
public class WebBeanFactory implements Serializable {

    /**
     * use this like WebBeanFactory.getBean("sessionScope.backingBean", BackingBean.class)
     * @param beanScope scope of the bean we are looking for
     * @param cls type of bean
     * @return bean instance
     */
    public static Object getBean(String beanScope, Class<?> cls) {
        Object bean = WebApplication.getReference().getFacesBean(beanScope, cls);
        if (bean == null) {
            try {
                bean = cls.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
            WebApplication.getReference().setFacesBean(beanScope, bean);
        }
        return bean;
    }

    /**
     * make Identity bean accessible from java implementation
     * @return IdentityBean
     */
    public static IdentityBean getIdentityBean() {
        return (IdentityBean)getBean("sessionScope.identityBean", IdentityBean.class);
    }



}
