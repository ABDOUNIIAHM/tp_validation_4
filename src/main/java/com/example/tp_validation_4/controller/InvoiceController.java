package com.example.tp_validation_4.controller;

import com.example.tp_validation_4.entity.*;
import com.example.tp_validation_4.form.InvoiceForm;
import com.example.tp_validation_4.service.*;
import lombok.AllArgsConstructor;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/invoice")
@AllArgsConstructor
public class InvoiceController {
    private InvoiceService invoiceService;
    private InvoiceLineService invoiceLineService;
    private ClientService clientService;
    private ProductService productService;
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
        List<Product> products = productService.getAll();
        model.addAttribute("products",products);

        model.addAttribute("invoiceForm",invoiceForm);
        return "add-invoice";
    }
    @PostMapping
    public String createInvoice(@RequestParam(value = "productList") List<Long> productList,
                                @RequestParam(value = "quantityList") List<Integer> quantityList,
                                @ModelAttribute("invoiceForm") InvoiceForm invoiceForm){

        Map productQuantity = new HashMap<>();

        //getting the list of products
        List<Product> products = productList
                .stream()
                .map(id-> productService.getById(id))
                .collect(Collectors.toList());

        //getting List of quantities
        for (int i = 0; i < products.size(); i++) {
            productQuantity.put(products.get(i), quantityList.get(i));
        }

        //getting the invoice object
        Invoice invoice = invoiceForm.getInvoice();

        //getting the client object
        Client client =clientService
                .getClientById(invoiceForm
                        .getClient()
                        .getId()) ;

        //getting the payment method object
        PaymentMethod paymentMethod = paymentMethodService
                .getByName(invoiceForm
                        .getPaymentMethod()
                        .getName()) ;

        //setting attributs to invoice
        invoice.setClient(client);
        invoice.setPaymentMethod(paymentMethod);

        invoiceService.create(invoice);
        List<InvoiceLine> invoiceLines = products
                .stream()
                .map(p -> {
                    InvoiceLine invoiceLine = new InvoiceLine();
                    invoiceLine.setProduct(p);
                    invoiceLine.setQuantity((Integer) productQuantity.get(p));
                    invoiceLine.setInvoice(invoice);
                    return invoiceLineService.create(invoiceLine);
                })
                .collect(Collectors.toList());

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
