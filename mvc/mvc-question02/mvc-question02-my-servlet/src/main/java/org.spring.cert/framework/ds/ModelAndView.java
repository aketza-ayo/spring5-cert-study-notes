package org.spring.cert.framework.ds;

import org.spring.cert.framework.model.Model;
import org.spring.cert.framework.view.View;

public class ModelAndView {
    private Model model;
    private View view;

    public ModelAndView(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }
}
