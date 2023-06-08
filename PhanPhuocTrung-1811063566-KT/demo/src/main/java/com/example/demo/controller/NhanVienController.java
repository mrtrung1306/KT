package com.example.demo.controller;


import com.example.demo.entity.NhanVien;
import com.example.demo.services.NhanVienServices;
import com.example.demo.services.PhongBanServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/nhanviens")
public class NhanVienController {
    @Autowired
    private NhanVienServices NhanVienService;
    @Autowired
    private PhongBanServices PhongBanService;
    @GetMapping
    public String showAllNhanVien(Model model){
        List<NhanVien> nhanviens=NhanVienService.getAllNhanVien();
        model.addAttribute("nhanviens",nhanviens);
        return "Nhanvien/list";
    }
    @GetMapping("/add")
    public String addNhanvienForm(Model model) {
        model.addAttribute("NhanVien", new NhanVien());
        model.addAttribute("phongbans", PhongBanService.getAllPhongBan());
        return "Nhanvien/add";
    }

    @PostMapping("/add")
    public String addNhanVien(@Valid @ModelAttribute("nhanvien") NhanVien nhanvien, BindingResult result, Model model) {
        /*if(result != null && result.hasErrors()){
            List<String> errors = result.getAllErrors()
                    .stream().map(ObjectError::getDefaultMessage).toList();
            model.addAttribute("errors", errors);
            return "nhanvien/add";
        }*/
        NhanVienService.addNhanVien(nhanvien);
        return "redirect:/nhanviens";
    }
    @GetMapping("/edit/{Ma_NV}")
    public String EditBook(@PathVariable("Ma_NV") String Ma_NV,Model model){
        NhanVien nhanvien = NhanVienService.getNhanVienById(Ma_NV);
        model.addAttribute("NhanVien",nhanvien);
        model.addAttribute("phongbans",PhongBanService.getAllPhongBan());
        return "NhanVien/edit";
    }
    @PostMapping("/edit/{Ma_NV}")
    public String EditBook(@PathVariable("Ma_NV") String Ma_NV,NhanVien UpdateNhanVien){
        UpdateNhanVien.setMa_NV(Ma_NV);
        NhanVienService.updateNhanVien(UpdateNhanVien);
        return "redirect:/nhanviens";
    }
    @GetMapping({"/delete/{Ma_NV}"})
    public String deleteNhanvien(@PathVariable("Ma_NV") String Ma_NV) {
        this.NhanVienService.deleteNhanVien(Ma_NV);
        return "redirect:/nhanviens";
    }
//    @GetMapping("/edit/{id}")
//    public String EditBook(@PathVariable("id") Long id, Model model){
//        Book book = bookService.getBookById(id);
//        model.addAttribute("book",book);
//        model.addAttribute("categories",categoryService.getAllCategories());
//        return "book/edit";
//    }
//    @PostMapping("/edit/{id}")
//    public String EditBook(@PathVariable("id") Long id,Book UpdateBook){
//        UpdateBook.setId(id);
//        bookService.updateBook(UpdateBook);
//        return "redirect:/books";
//    }
//    @GetMapping("/delete/{id}")
//    public String DeleteBook(@PathVariable ("id") Long id){
//        bookService.deleteBook(id);
//        return "redirect:/books";
//    }
}
