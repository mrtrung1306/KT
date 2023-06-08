package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Entity
@Table(name="NhanVien")
public class NhanVien {
//    @NotNull(message = "Price is required")
    @Id
    @Column(name="MaNhanVien")
    private String Ma_NV;

    @Column(name="TenNhanVien")
//    @NotEmpty(message = "Title must not be empty")
//    @Size(max=50,min=1,message="Title must be less than 50 characters")
    private String Ten_NV;

    @Column(name="Phai")
    private String Phai;

    @Column(name="NoiSinh")
//    @NotNull(message = "Price is required")
    private String Noi_Sinh;

    @ManyToOne
    @JoinColumn(name="MaPhong")
//    @ValidCategoryId
    private PhongBan PhongBan;

    @Column(name="Luong")
    private int luong;
//    @ManyToOne
//    @JoinColumn(name="user_id",referencedColumnName = "id")
//    @ValidUserId
//    private User user;
}
