package edu.udea.main.controladores;

import edu.udea.main.entidades.Movimiento;
import edu.udea.main.servicios.ServicioMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ControladorMovimiento {


    @Autowired
    private ServicioMovimiento servicioMovimiento;



    // ***** LISTAR MOVIMIENTOS ***** //

    @GetMapping({"/movimientos"})
    public String listarMovimientos(Model modelo) {
        List<Movimiento> movimientos = servicioMovimiento.listarMovimiento();
        modelo.addAttribute("movimientos", movimientos);

        double ingresos = 0;
        double egresos = 0;
        double totales = 0;
        for(int i = 0; i < movimientos.size(); i++){
            ingresos += movimientos.get(i).getIngreso();
        }
        for(int i = 0; i < movimientos.size(); i++){
            egresos += movimientos.get(i).getEgreso();
        }

        totales = ingresos - egresos;
        modelo.addAttribute("totales", totales);
        return "movimientos";
    }


    // ****** CREAR NUEVO REGISTRO ******

    @GetMapping("/nuevoRegMov")
    public String mostrarFormMov(Model modelo) {
        modelo.addAttribute("movimientos", new Movimiento());
        return "nuevoRegMov";
    }

    @PostMapping("/nuevoRegMov")
    public String crearNuevoMovimiento(@Validated @DateTimeFormat(pattern = "YYYY-MM-DD") Movimiento movimiento, BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
        if(bindingResult.hasErrors()) {
            modelo.addAttribute("movimientos", movimiento);
            return "/nuevoRegMov";
        }
        servicioMovimiento.guardarMovimiento(movimiento);
        redirect.addFlashAttribute("msgExito", "El contacto ha sido agregado con exito");
        return "redirect:/movimientos";
    }



    // ***** MODIFICAR ******

    @GetMapping("/{id}/editar")
    public String mostrarFormularioDeEditarMov(@PathVariable Long id, Model modelo) {
        Movimiento movimiento = servicioMovimiento.obtenerMovimiento(id);
        modelo.addAttribute("movimientos", movimiento);
        return "editarRegMov";
    }


    @PostMapping("/{id}/editar")
    public String actualizarMovi(@PathVariable Long id, @ModelAttribute("movimientos") Movimiento movimiento, Model modelo) {
        Movimiento movActual = servicioMovimiento.obtenerMovimiento(id);
        movActual.setId(id);
        movActual.setConcepto(movimiento.getConcepto());
        movActual.setIngreso(movimiento.getIngreso());
        movActual.setEgreso(movimiento.getEgreso());
        movActual.setIdEmpleado(movimiento.getIdEmpleado());
        movActual.setIdEmpresa(movimiento.getIdEmpresa());
        movActual.setCreatedAt(movimiento.getCreatedAt());
        movActual.setUpdateAt(movimiento.getUpdateAt());
        servicioMovimiento.guardarMovimiento(movActual);
        return "redirect:/movimientos";
    }


    //**** ELIMINAR ******

    @PostMapping("/{id}/eliminar")
    public String eliminarMovimiento(@PathVariable Long id,RedirectAttributes redirect) {
        Movimiento movimiento = servicioMovimiento.obtenerMovimiento(id);
        servicioMovimiento.eliminarMovimiento(movimiento.id);
        redirect.addFlashAttribute("msgExito", "El contacto ha sido eliminado correctamente");
        return "redirect:/movimientos";
    }


}
