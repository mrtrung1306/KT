package com.example.demo.services;

import com.example.demo.entity.PhongBan;
import com.example.demo.repository.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhongBanServices {
    @Autowired
    private IPhongBanRepository phongbanRepository;
    public List<PhongBan> getAllPhongBan(){
        return phongbanRepository.findAll();
    }
    public PhongBan getPhongBanById(String Ma_Phong){
        return phongbanRepository.findById(Ma_Phong).orElse(null);
    }
    public PhongBan savePhongBan(PhongBan category){
        return phongbanRepository.save(category);
    }
    public void deletePhongBan(String Ma_Phong){
        phongbanRepository.deleteById(Ma_Phong);
    }
}
