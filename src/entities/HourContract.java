package entities;
import java.util.Date;
public class HourContract {
    private Date date;
    private Double valuePerHour;
    private Integer hours;
    private String dateString;


    public HourContract(){

    }
    public HourContract(Date data, Double valuePerHour, Integer hours){
        this.date = data;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }
    public String getDateString(){
        return dateString;
    }
    public void setDateString(String parse){
        this.dateString = parse;
    }
    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public Double getValuePerHour() {
        return valuePerHour;
    }
    public void setValuePerHour(Double valuePerHour){
        this.valuePerHour = valuePerHour;
    }
    public Integer getHours(){
        return hours;
    }
    public void setHours(Integer hours){
        this.hours = hours;
    }
    public double totalValue() {
        return valuePerHour * hours;
    }
}
