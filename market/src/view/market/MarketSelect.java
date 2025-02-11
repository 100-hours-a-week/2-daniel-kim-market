package view.market;

public enum MarketSelect{
    SELL_BOOK(1, "책 판매 등록"),
    SHOW_LIST(2, "판매중인 책 보기"),
    BUY_BOOK(3, "책 구매"),
    INVALID(-1, "선택 오류");

    private final int option;
    private final String description;

    MarketSelect(int option, String description){
        this.option = option;
        this.description = description;
    }

    public int getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }

    public static MarketSelect fromOption(int option){
        for (MarketSelect menu : values()){
            if(menu.getOption() == option){
                return menu;
            }
        }
        return INVALID;
    }
}