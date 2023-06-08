package com.example.demo.services;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienServices {
    @Autowired
    private INhanVienRepository NhanVienRepository;

    public List<NhanVien> getAllNhanVien(){
        return NhanVienRepository.findAll();
    }
    public NhanVien getNhanVienById(String Ma_NV){
        return NhanVienRepository.findById(Ma_NV).orElse(null);
    }
    public void addNhanVien(NhanVien nhanvien){
        NhanVienRepository.save(nhanvien);
    }
    public void updateNhanVien(NhanVien nhanvien){
        NhanVienRepository.save(nhanvien);
    }
    public void deleteNhanVien(String Ma_NV){
        NhanVienRepository.deleteById(Ma_NV);
    }
}
