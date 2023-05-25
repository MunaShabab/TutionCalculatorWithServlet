/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uakron.munashabab;

/**
 *
 * @author munashabab
 */
public class TuitionCalculator {
    private String residencyCode;
    private int creditHours;
    static final double IN_COUNTY_RATE=154.03;
    static final double OUT_OF_COUNTY_RATE=179.21;
    static final double OUT_OF_STATE_RATE=330.78;

    public String getResidencyCode() {
        return residencyCode;
    }

    public void setResidencyCode(String residencyCode) {
        this.residencyCode = residencyCode;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }
   public double getRate(){
       double rate;
       if(this.getResidencyCode().equalsIgnoreCase("ic")){
           rate=IN_COUNTY_RATE;
       }
       else if(this.getResidencyCode().equalsIgnoreCase("oc")) {
           rate=OUT_OF_COUNTY_RATE;
       }
       else{
           rate=OUT_OF_STATE_RATE;
       }
       return rate;
   }
   public double getTuition(){
       double tuition;
       double tuitionRate=getRate();
        if ((this.getCreditHours()>18)){
                tuition=(this.getCreditHours()-5)*tuitionRate;
                
            }
            else if(this.getCreditHours()>13){
                tuition=13*tuitionRate;
                
            }
            else {
                tuition=this.getCreditHours()*tuitionRate;
            }
        
        return tuition;
   } 
    
}