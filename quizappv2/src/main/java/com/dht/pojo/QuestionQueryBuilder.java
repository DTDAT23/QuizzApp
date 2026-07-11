/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.pojo;

import com.dht.utils.MyConnectionSingleton;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionQueryBuilder {
    private StringBuilder query;
    private StringBuilder where;
    private String orderBy;
    
    private List<Object> params;

    public QuestionQueryBuilder() {
        this.query = new StringBuilder("Select * from question where 1=1 %s Orderby %s");
        this.where = new StringBuilder();
        this.orderBy = "id DESC";
        this.params = new ArrayList<>();
    }
    
    public QuestionQueryBuilder withKeywords(String kw){
        if(kw != null && !kw.isEmpty()){
            this.where.append("And content like contcat('%',?,'%')");
            this.params.add(kw);
        }
        return this;
    }
    
    public QuestionQueryBuilder withCategory(Category c){
        if(c != null){
            this.where.append("And category_id=?");
            params.add(c.getId());
        }
        return this;
    }
    
    public QuestionQueryBuilder withLevel(Level lvl){
        if(lvl != null){
            this.where.append("And level_id=?");
            this.params.add(lvl.getId());
        }
        return this;
    }
    
    public QuestionQueryBuilder setOrderby(String orderby){
        this.orderBy = orderby;
        return this;
    }
    
    public PreparedStatement build() throws SQLException{
        String s = String.format(this.query.toString(), this.where.toString(), this.orderBy);
        PreparedStatement stm = MyConnectionSingleton.getInstance().connect().prepareCall(s);
        for(int i = 0; i < this.params.size(); i++){
            stm.setObject(i + 1, this.params.get(i));
            
        }
        return stm;
    }
    
}
