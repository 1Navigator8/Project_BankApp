package com.example.bankapp.controller;

import com.example.bankapp.dto.ManagerDTO;
import com.example.bankapp.entity.Manager;
import com.example.bankapp.service.ManagerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1/managers")
public class ManagerController {

    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping(path = "{findManager}")
    public ManagerDTO showManagerDTO(@PathVariable("findManager") String name) {
        return managerService.findManagerByNameDTO(name);
    }

    @PostMapping(path = "/registerManager")
    public String addNewManager(@RequestBody Manager manager) {
        return managerService.addNewManager(manager);
    }

    @PutMapping(path = "/update")
    @Transactional
    public String update(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {
        return managerService.updateManager(firstName, lastName);
    }

}
