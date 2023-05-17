package com.example.tp_validation_4.controller;

import com.example.tp_validation_4.service.InvoiceLineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/invoice-detail")
@AllArgsConstructor
public class InvoiceLineController {
    private InvoiceLineService invoiceLineService;

    @GetMapping
    public String getAllInvoiceLineById(@RequestParam long id, Model model){
        return "invoice-lines";
    }
}
