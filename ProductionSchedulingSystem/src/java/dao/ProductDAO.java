/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Department;
import entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

public class ProductDAO {

    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT [pid]\n"
                + "      ,[pname]\n"
                + "      ,[description]\n"
                + "  FROM [Products]";

        try (PreparedStatement pstmt = DBUtils.getConnection1().prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setpId(rs.getInt("pid"));
                product.setpName(rs.getString("pname"));
                product.setDescription(rs.getString("description"));
                
                products.add(product);
            }
        } catch (SQLException | ClassNotFoundException ex) {
        }
        return products;
    }
}
