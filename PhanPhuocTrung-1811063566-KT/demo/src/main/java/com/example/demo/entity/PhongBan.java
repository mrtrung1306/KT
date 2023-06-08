package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="PhongBan")
public class PhongBan {
    @Id
    @Column(name="MaPhong")
    private String Ma_Phong;

    @Column(name="TenPhong")
    private String Ten_Phong;

    @OneToMany(mappedBy = "PhongBan",cascade = CascadeType.ALL)
    private List<NhanVien> nhanviens;
}
