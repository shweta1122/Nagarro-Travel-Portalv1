package com.nagarro.controller;

import java.util.List;

import javax.validation.Valid;

import com.nagarro.exception.ResourceNotFoundException;
import com.nagarro.model.Ticket;
import com.nagarro.repository.EmployeeRepository;
import com.nagarro.repository.TicketRepository;
import com.nagarro.service.EmployeeService;
import com.nagarro.service.TicketServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class TicketController {

	@Autowired
	TicketServices ticketServices;

	@GetMapping("/employee/{employeeId}/tickets")
	public List<Ticket> getTicketsByEmployee(@PathVariable(value = "employeeId") Long employeeId) {
		return ticketServices.getTicketByEmployee(employeeId);
	}

	@PostMapping("/employee/{employeeId}/tickets")
	public Ticket createTicket(@PathVariable(value = "employeeId") Long employeeId, @Valid @RequestBody Ticket ticket) {
		return ticketServices.createTicket(employeeId,ticket);
	}

	@PutMapping("/tickets/{employeeId}/tickets/{ticketID}")
	public Ticket updateTicket(@PathVariable(value = "employeeId") Long employeeId,
			@PathVariable(value = "ticketID") Long ticketId, @RequestBody Ticket ticketRequest){
//		if (!employeeRepository.existsById(employeeId)) {
//			new ResourceNotFoundException("Employee", "id", employeeId);
//		}
		return ticketServices.updateTicket(employeeId,ticketId,ticketRequest);
	}
}
