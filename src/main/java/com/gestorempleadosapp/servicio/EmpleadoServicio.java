package com.gestorempleadosapp.servicio;

import com.gestorempleadosapp.modelo.Empleado;
import com.gestorempleadosapp.repositorio.IEmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicio implements IEmpleadoServicio {
    @Autowired
    private IEmpleadoRepositorio empleadoRepositorio;

    @Override
    public List<Empleado> listar() {
        return empleadoRepositorio.findAll();
    }

    @Override
    public Empleado buscarPorId(Integer idEmpleado) {
        return empleadoRepositorio.findById(idEmpleado).orElse(null);
    }

    @Override
    public void guardar(Empleado empleado) {
        empleadoRepositorio.save(empleado);
    }

    @Override
    public void eliminar(Empleado empleado) {
        empleadoRepositorio.delete(empleado);
    }
}
