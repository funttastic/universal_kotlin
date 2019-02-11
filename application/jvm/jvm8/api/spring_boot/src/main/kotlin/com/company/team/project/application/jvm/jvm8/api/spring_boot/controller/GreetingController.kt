package com.company.team.project.application.jvm.jvm8.api.spring_boot.controller

import com.company.team.project.common.jvm.common.commonJvm
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@CrossOrigin(origins = ["*"])
@RequestMapping("/greeting")
class GreetingController {

	/**
	 *
	 */
	@RequestMapping("hello", method= [RequestMethod.GET])
	@Throws(Exception::class)
	fun hello(): ResponseEntity<String> {
		return ResponseEntity(commonJvm(), HttpStatus.OK)
	}
}
