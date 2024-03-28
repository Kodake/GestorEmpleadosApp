package com.gestorempleadosapp.controlador;

import com.gestorempleadosapp.modelo.Empleado;
import com.gestorempleadosapp.servicio.IEmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(IndexControlador.class);

    @Autowired
    IEmpleadoServicio empleadoServicio;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String iniciar(ModelMap modelo) {
        List<Empleado> empleados = empleadoServicio.listar();
        empleados.forEach((empleado) -> logger.info(empleado.toString()));
        modelo.put("empleados", empleados);
        return "index";
    }

    @RequestMapping(value="/agregar", method = RequestMethod.GET)
    public String mostrarAgregar(){
        return "agregar";//agregar.jsp
    }

    @RequestMapping(value="/agregar", method = RequestMethod.POST)
    public String agregar(@ModelAttribute("empleadoForm") Empleado empleado){
        logger.info("Empleado a agregar: " + empleado);
        empleadoServicio.guardar(empleado);
        return "redirect:/";//redirige al path "/"
    }

    @RequestMapping(value="/editar", method=RequestMethod.GET)
    public String mostrarEditar(@RequestParam int idEmpleado, ModelMap modelo) {
        Empleado empleado = empleadoServicio.buscarPorId(idEmpleado);
        logger.info("Empleado a actualizar: " + empleado);
        modelo.put("empleado", empleado);
        return "editar";
    }

    @RequestMapping(value="/editar", method = RequestMethod.POST)
    public String editar(@ModelAttribute("empleadoForm") Empleado empleado){
        logger.info("Empleado a actualizar: " + empleado);
        empleadoServicio.guardar(empleado);
        return "redirect:/";//redirige al path "/"
    }

    @RequestMapping(value="/eliminar", method=RequestMethod.GET)
    public String eliminar(@RequestParam int idEmpleado) {
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(idEmpleado);
        logger.info("Empleado a eliminar: " + empleado);
        empleadoServicio.eliminar(empleado);
        return "redirect:/";
    }

}
