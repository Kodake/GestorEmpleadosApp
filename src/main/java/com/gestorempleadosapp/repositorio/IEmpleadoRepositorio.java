package com.gestorempleadosapp.repositorio;

import com.gestorempleadosapp.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
}
