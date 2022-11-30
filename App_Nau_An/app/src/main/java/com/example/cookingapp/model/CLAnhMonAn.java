package com.example.cookingapp.model;

public class CLAnhMonAn {
   private int idmonan ;
   private int mamonan;
   private String anhmonan;

   public CLAnhMonAn(int idmonan, int mamonan, String anhmonan) {
      this.idmonan = idmonan;
      this.mamonan = mamonan;
      this.anhmonan = anhmonan;
   }

   public int getIdmonan() {
      return idmonan;
   }

   public void setIdmonan(int idmonan) {
      this.idmonan = idmonan;
   }

   public int getMamonan() {
      return mamonan;
   }

   public void setMamonan(int mamonan) {
      this.mamonan = mamonan;
   }

   public String getAnhmonan() {
      return anhmonan;
   }

   public void setAnhmonan(String anhmonan) {
      this.anhmonan = anhmonan;
   }
}
