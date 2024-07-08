package com.negocio.controladores;

import com.negocio.entidades.Cita;
import com.negocio.service.CitaService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.negocio.entidades.Paciente;
import com.negocio.service.PacienteService;
import com.negocio.service.PacienteServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class EssaludControlador {

    private final PacienteService pacienteService;
    private final PacienteServiceImpl pacienteServiceImpl;

    @Autowired
    private CitaService citaservice;

    @Autowired
    public EssaludControlador(PacienteService pacienteService, PacienteServiceImpl pacienteServiceImpl) {
        this.pacienteService = pacienteService;
        this.pacienteServiceImpl = pacienteServiceImpl;
    }

    @GetMapping("/")
    public String home() {
        return "inicio";
    }

    @GetMapping("/sedes")
    public String sedes() {
        return "sedes";
    }

    @GetMapping("/especialidades")
    public String especialidades() {
        return "especialidades";
    }

    @GetMapping("/lab")
    public String lab() {
        return "lab";
    }

    @GetMapping("/laboratorio")
    public String laboratorio() {
        return "laboratorio";
    }

    @GetMapping("/contactanos")
    public String contactanos() {
        return "contactanos";
    }


    //INICIO ESPECIALIDADES


    @GetMapping("/alergia")
    public String alergia() {
        return "alergia";
    }

    @GetMapping("/cabezacuello")
    public String cabezacuello() {
        return "cabezacuello";
    }

    @GetMapping("/cardiologia")
    public String cardiologia() {
        return "cardiologia";
    }

    @GetMapping("/cirugiageneral")
    public String cirugiageneral() {
        return "cirugiageneral";
    }

    @GetMapping("/cirugiatorax")
    public String cirugiatorax() {
        return "cirugiatorax";
    }

    @GetMapping("/cred")
    public String cred() {
        return "cred";
    }

    @GetMapping("/dermatologia")
    public String dermatologia() {
        return "dermatologia";
    }

    @GetMapping("/endocrinologia")
    public String endocrinologia() {
        return "endocrinologia";
    }

    @GetMapping("/gastroenterologia")
    public String gastroenterologia() {
        return "gastroenterologia";
    }

    @GetMapping("/geriatria")
    public String geriatria() {
        return "geriatria";
    }

    @GetMapping("/ginecologia")
    public String ginecologia() {
        return "ginecologia";
    }

    @GetMapping("/medicinafamiliar")
    public String medicinafamiliar() {
        return "medicinafamiliar";
    }

    @GetMapping("/medicinageneral")
    public String medicinageneral() {
        return "medicinageneral";
    }

    @GetMapping("/neumologia")
    public String neumologia() {
        return "neumologia";
    }

    @GetMapping("/neurologia")
    public String neurologia() {
        return "neurologia";
    }

    @GetMapping("/nutricion")
    public String nutricion() {
        return "nutricion";
    }

    @GetMapping("/odontologia")
    public String odontologia() {
        return "odontologia";
    }

    @GetMapping("/oftalmologia")
    public String oftalmologia() {
        return "oftalmologia";
    }

    @GetMapping("/otorrrinolaringologia")
    public String otorrinolaringologia() {
        return "otorrinolaringologia";
    }

    @GetMapping("/pediatria")
    public String pediatria() {
        return "pediatria";
    }


    //FIN ESPECIALIDADES


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registro/nuevo")
    public String FormPacienteNuevo(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "registro";
    }

    @PostMapping("/registro")
    public String registerPaciente(@ModelAttribute Paciente paciente) {
        pacienteService.save(paciente);
        return "redirect:/login";
    }

    @GetMapping("/login/citainicio")
    public String citainicio(HttpSession session, Model model) {
        Paciente paciente = (Paciente) session.getAttribute("paciente");
        if (paciente != null) {
            model.addAttribute("paciente", paciente);
            return "citainicio";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/login/apresencial")
    public String apresencial(HttpSession session, Model model) {
        Paciente paciente = (Paciente) session.getAttribute("paciente");
        if (paciente != null) {
            model.addAttribute("paciente", paciente);
            return "apresencial";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/citas/register")
    public String registerCitas(HttpSession session, Model model, HttpServletRequest request) {
        String idPaciente = request.getParameter("id_paciente");
        String sede = request.getParameter("sede");
        String modalidad = request.getParameter("modalidad");
        String especialidad = request.getParameter("especialidad");
        String fechaSeleccionada = request.getParameter("fechaSeleccionada");
        System.out.println("ID Paciente: " + idPaciente);
        System.out.println("Sede: " + sede);
        System.out.println("Modalidad: " + modalidad);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Fecha Seleccionada: " + fechaSeleccionada);
        Paciente paciente = (Paciente) session.getAttribute("paciente");
        Cita cita = new Cita();
        cita.setSede(sede);
        cita.setEspecialidad(especialidad);
        cita.setFecha(fechaSeleccionada);
        cita.setModalidad(modalidad);
        cita.setPaciente(paciente);
        citaservice.save(cita);
        return "redirect:/";
    }


    @GetMapping("/login/historialcita")
    public String historialcita() {
        return "historialcita";
    }


    @PostMapping("/autenticar")
    public String autenticar(@RequestParam("dni") String dni,
                             @RequestParam("contraseña") String contraseña,
                             HttpSession session) {
        Paciente paciente = pacienteServiceImpl.autenticar(dni, contraseña);
        if (paciente != null) {
            session.setAttribute("paciente", paciente);
            return "redirect:/login/citainicio";
        } else {
            return "redirect:/login?error";
        }

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}

