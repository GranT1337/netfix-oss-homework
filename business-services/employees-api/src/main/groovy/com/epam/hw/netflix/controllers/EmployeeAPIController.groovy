package com.epam.hw.netflix.controllers

import com.epam.hw.netflix.api.WorkspaceAPI
import com.epam.hw.netflix.domain.Workspace
import com.epam.hw.netflix.services.EmployeeService
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import lombok.extern.log4j.Log4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.netflix.hystrix.EnableHystrix
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


import static com.epam.hw.netflix.domain.OSFamily.WINDOWS
import static java.util.UUID.randomUUID

@RestController
@RequestMapping("/employees")
@EnableHystrix
class EmployeeAPIController {

    private Logger log = LoggerFactory.getLogger(EmployeeAPIController.class)

    @Autowired
    EmployeeService employeeService

    @Autowired
    WorkspaceAPI workspaceAPIClient

    @RequestMapping("/{id}")
    def describeEmployee(@PathVariable("id") String id) {
        def employee = employeeService.findEmployee(id)
        log.info("EPAM KU")
        [
                id       : employee.id,
                firstName: employee.firstName,
                lastName : employee.lastName,
                email    : employee.email,
                workspace: workspaceAPIClient.getWorkspaceById(id)
        ]
    }
}
