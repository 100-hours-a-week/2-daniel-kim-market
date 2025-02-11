package util;

public class Validator{
    public Validator(){
        this.constant = new Constant();
    }
    
    boolean isUpDown = false;
    Constant constant;
    public boolean isUpDown(int start){
        if(start >= constant.min_price && start <= constant.max_price){ //수정해보기. 자주 쓸지 안 쓸지도 생각해보면서 static으로 만들건지도 파악해보자
            return true;
        }
        return false;
    }

    public boolean isCanPayment(int price, int myprice){
        if(price <= myprice){
            return true;
        }
        return false;
    }
}