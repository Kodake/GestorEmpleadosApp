package com.gestorempleadosapp.servicio;

import com.gestorempleadosapp.modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio {
    public List<Empleado> listar();
    public Empleado buscarPorId(Integer idEmpleado);
    public void guardar(Empleado empleado);
    public void eliminar(Empleado empleado);
}
