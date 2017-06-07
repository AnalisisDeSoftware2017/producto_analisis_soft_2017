package ar.edu.unlam.analisis.software.grupo2.controller.impl;

import ar.edu.unlam.analisis.software.grupo2.controller.AbstractEntitySaveController;
import ar.edu.unlam.analisis.software.grupo2.core.model.Medico;
import ar.edu.unlam.analisis.software.grupo2.core.services.impl.AbstractServiceCRUD;
import ar.edu.unlam.analisis.software.grupo2.ui.SaveForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by sbogado on 6/6/17.
 */
@Controller
public class SaveMedicoController extends AbstractEntitySaveController<Medico,Long> {

    @Autowired
    public SaveMedicoController(AbstractServiceCRUD<Medico, Long> service, SaveForm<Medico> form) {
        super(service, form);
    }

    @Override
    protected void setTextoFrame() {

    }


    @Override
    protected List<String> validateData() {
        return null;
    }
}
