package com.swagger.swaggerdemo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class ApController {


    @RequestMapping("/hello",method = [RequestMethod.GET])
    fun sayHi():String{
        return "Swagger Docs For Apis"
    }
}