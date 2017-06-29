package ar.edu.unlam.analisis.software.grupo2.ui;

import ar.edu.unlam.analisis.software.grupo2.core.model.Persona;
import ar.edu.unlam.analisis.software.grupo2.data.PersonaData;

import javax.swing.*;

public abstract class AbstractContainerPersonaFormSearch<T extends Persona, E extends PersonaData> extends JFrame {

    protected AbstractPersonaFormSearch<T, E> searchForm;
    private JButton btnAnterior;
    private JButton btnBuscar;


    public AbstractContainerPersonaFormSearch(AbstractPersonaFormSearch<T, E> form) {
        setLayout(null);

        this.searchForm = form;

        JPanel formContainer = new JPanel();
        formContainer.setBounds(22, 20, 1040, 530);
        add(formContainer);
        formContainer.setLayout(null);

        JPanel botonera = new JPanel();
        botonera.setBounds(22, 562, 1040, 101);
        add(botonera);
        botonera.setLayout(null);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(193, 47, 117, 29);
        botonera.add(btnBuscar);

        btnAnterior = new JButton("Anterior");
        btnAnterior.setBounds(597, 47, 117, 29);
        botonera.add(btnAnterior);
    }

    public E getEntity() {
        return this.searchForm.getEntity();
    }

    public JButton getBtnAnterior() {
        return btnAnterior;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }
}