package ar.edu.unlam.analisis.software.grupo2.controller.impl;

import ar.edu.unlam.analisis.software.grupo2.controller.AbstractEntitySaveController;
import ar.edu.unlam.analisis.software.grupo2.core.model.Medico;
import ar.edu.unlam.analisis.software.grupo2.core.services.impl.AbstractServiceCRUD;
import ar.edu.unlam.analisis.software.grupo2.core.services.impl.MedicoService;
import ar.edu.unlam.analisis.software.grupo2.ui.SaveForm;
import ar.edu.unlam.analisis.software.grupo2.utils.AppContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by sbogado on 6/6/17.
 */
@Controller
public class SaveMedicoController extends AbstractEntitySaveController<Medico,Long> {

    private static final int LONG_NOMBRE = 40;
    private static final int LONG_APELLIDO = 40;
    private static final int LONG_CODIGO = 20;

    @Autowired
    public SaveMedicoController(AbstractServiceCRUD<Medico, Long> service, SaveForm<Medico> form) {
        super(service, form);
    }

    @Override
    protected void setTextoFrame() {

    }


    @Override
    protected List<String> validateData(Medico entidad) {
        List<String> errores = new ArrayList<>();
        if(null == entidad.getNombre() || entidad.getNombre().isEmpty()){
            errores.add(messageSource.getMessage("ar.edu.unlam.los.laureles.error.nombrePersona", null, AppContext.getLocale()));
        }else{
            if(entidad.getNombre().length()>LONG_NOMBRE){
                errores.add(messageSource.getMessage("ar.edu.unlam.los.laureles.error.violation.max.length.nombrePersona",null, AppContext.getLocale()));
            }
        }
        if(null == entidad.getApellido() || entidad.getApellido().isEmpty()){
            errores.add(messageSource.getMessage("ar.edu.unlam.los.laureles.error.apellidoPersona",null,AppContext.getLocale()));
        }else{
            if(entidad.getApellido().length()>LONG_APELLIDO){
                errores.add(messageSource.getMessage("ar.edu.unlam.los.laureles.error.violation.max.length.apellidoPersona",null, AppContext.getLocale()));
            }
        }
        if(entidad.getCodigo()==null || entidad.getCodigo().isEmpty()){
            errores.add(messageSource.getMessage("ar.edu.unlam.los.laureles.error.codigoPersona",null,AppContext.getLocale()));
        }else{
            if(entidad.getNombre().length()>LONG_CODIGO){
                errores.add(messageSource.getMessage("ar.edu.unlam.los.laureles.error.violation.max.length",null, AppContext.getLocale()));
            }
        }
        if(entidad.getNumeroDocumento()==null || entidad.getNumeroDocumento().isEmpty()){
            errores.add(messageSource.getMessage("ar.edu.unlam.los.laureles.error.codigoRepetidoPersona",null,AppContext.getLocale()));
        }else{
            if(!documentValid()){
                errores.add(messageSource.getMessage("ar.edu.unlam.los.laureles.error.numeroDocumentoNoValido",null, AppContext.getLocale()));
            }
        }
        Optional<Medico> optMedico =((MedicoService)service ).findMedicoByCode(entidad.getCodigo());
        if( optMedico.isPresent() &&  optMedico.get().getId().equals(this.frame.getEntity().getId())){
            errores.add(messageSource.getMessage("ar.edu.unlam.los.laureles.error.codigoRepetidoPersona",null, AppContext.getLocale()));
        }

        return errores;
    }

    private boolean documentValid() {
        return true;
    }
}
