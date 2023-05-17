package com.example.tp_validation_4.controller;

import com.example.tp_validation_4.entity.Client;
import com.example.tp_validation_4.entity.Invoice;
import com.example.tp_validation_4.entity.PaymentMethod;
import com.example.tp_validation_4.form.InvoiceForm;
import com.example.tp_validation_4.service.ClientService;
import com.example.tp_validation_4.service.InvoiceService;
import com.example.tp_validation_4.service.PaymentMethodService;
import lombok.AllArgsConstructor;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/invoice")
@AllArgsConstructor
public class InvoiceController {
    private InvoiceService invoiceService;
    private ClientService clientService;
    private PaymentMethodService paymentMethodService;

    @GetMapping
    public String getAllInvoices(Model model){

        List<Invoice> invoices =
                invoiceService.getAllInvoices();

        model.addAttribute("invoices",invoices);
        return "list-invoice";
    }

    @GetMapping("/{id}")
    public String GetInvoicesById(@PathVariable long id, Model model){

        List<Invoice> clientInvoices
                = invoiceService.getAllByClientId(id);
        model.addAttribute("clientInvoices", clientInvoices);
        return "client-invoice";
    }
    @GetMapping("/add-invoice")
    public String GetInvoiceForm(Model model){

        //create object to add to model
        InvoiceForm invoiceForm = new InvoiceForm();

        model.addAttribute("invoiceForm",invoiceForm);
        return "add-invoice";
    }
    @PostMapping
    public String createInvoice(@ModelAttribute("invoiceForm") InvoiceForm invoiceForm){

        Invoice invoice = invoiceForm.getInvoice();

        Client client =clientService
                .getClientById(invoiceForm
                        .getClient()
                        .getId()) ;

        PaymentMethod paymentMethod = paymentMethodService
                .getByName(invoiceForm
                        .getPaymentMethod()
                        .getName()) ;

        invoice.setClient(client);
        invoice.setPaymentMethod(paymentMethod);

        invoiceService.create(invoice);
        return "redirect:/invoice";
    }
    @PostMapping("/{id}")
    public String addInvoiceToClient(@PathVariable long id,
                                Model model,
                                @ModelAttribute("clientInvoices") Invoice invoice){

        List<Invoice> clientInvoices
                = invoiceService.getAllByClientId(id);
        model.addAttribute("clientInvoices", clientInvoices);
        return "client-invoice";
    }

}
