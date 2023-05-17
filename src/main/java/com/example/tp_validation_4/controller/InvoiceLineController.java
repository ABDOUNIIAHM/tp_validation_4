package com.example.tp_validation_4.controller;

import com.example.tp_validation_4.entity.InvoiceLine;
import com.example.tp_validation_4.service.InvoiceLineService;
import com.example.tp_validation_4.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Controller
@RequestMapping("/invoice-detail")
@AllArgsConstructor
public class InvoiceLineController {
    private InvoiceLineService invoiceLineService;
    private InvoiceService invoiceService;

    @GetMapping
    public String getAllInvoiceLineById(@RequestParam(name = "detail") long id, Model model){

        List<InvoiceLine> invoiceLines
                = invoiceLineService.getAllInvoiceLinesByInvoiceId(id);

        double total = 0;

        for (int i = 0; i < invoiceLines.size(); i++) {
            InvoiceLine e = invoiceLines.get(i);
            int quantity = e.getQuantity();
            double linePrice = (e.getProduct().getUnitPrice().doubleValue()) * (quantity);
            total+= linePrice;
        }

        model.addAttribute("total",total);
        model.addAttribute("id",id);
        model.addAttribute("invoiceLines",invoiceLines);

        return "invoice-lines";
    }
}
