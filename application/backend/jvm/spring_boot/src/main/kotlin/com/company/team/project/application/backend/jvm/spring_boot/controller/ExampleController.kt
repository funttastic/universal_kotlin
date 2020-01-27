package com.company.team.project.application.backend.jvm.spring_boot.controller

import com.company.team.project.application.backend.jvm.spring_boot.model.exampleValue
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 *
 */
@Controller
@CrossOrigin(origins = ["*"])
@RequestMapping("/exampleController")
class ExampleController {

	/**
	 *
	 */
	@RequestMapping("exampleMethod", method= [RequestMethod.GET])
	@Throws(Exception::class)
	fun example(): ResponseEntity<String> {
		return ResponseEntity(exampleValue, HttpStatus.OK)
	}
}
