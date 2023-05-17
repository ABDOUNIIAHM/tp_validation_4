package com.example.tp_validation_4.controller;

import com.example.tp_validation_4.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/invoice")
@AllArgsConstructor
public class InvoiceController {
    private InvoiceService invoiceService;

}
