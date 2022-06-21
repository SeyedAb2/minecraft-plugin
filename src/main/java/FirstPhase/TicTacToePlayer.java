package FirstPhase;

import java.io.Serializable;

public class TicTacToePlayer implements Serializable {

    private String name ;
    private String sign ;
    private int[] selectItem = {0,0,0,0,0,0,0,0,0};


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

    public int[] getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(int[] selectItem) {
        this.selectItem = selectItem;
    }

    public void selectItem(int item){
        if (item <= 8 && item >= 0) {
            selectItem[item-1] = 1;
        }
    }
}

