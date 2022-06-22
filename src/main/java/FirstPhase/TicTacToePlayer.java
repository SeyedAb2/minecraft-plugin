package FirstPhase;

import java.io.Serializable;

public class TicTacToePlayer implements Serializable {

    private String name ;
    private final String sign ;
    private String[] selectItem = {" "," "," "," "," "," "," "," "," "};


    public TicTacToePlayer(String name,String sign){
        this.name = name;
        this.sign = sign;

    }
    public String getName() {
        return name;
    }
    public String getSign() {
        return sign;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(String[] selectItem) {
        this.selectItem = selectItem;
    }

    public void selectItem(int item){
        if (item <= 8 && item >= 0) {
            selectItem[item-1] = " ";
        }
    }
}

