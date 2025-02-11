package view.user;

public enum UserSelect{
    LOG_IN(1, "로그인"),
    MAKE_USER(2, "회원가입"),
    EXIT(3, "종료"),
    INVALID(-1, "선택 오류");


    private final int option;
    private final String description;

    UserSelect (int option, String description) {
        this.option = option;
        this.description = description;
    }

    public int getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }

    public static UserSelect fromOption(int option){
        for (UserSelect menu : values()){
            if(menu.getOption() == option){
                return menu;
            }
        }
        return INVALID;
    }
}



