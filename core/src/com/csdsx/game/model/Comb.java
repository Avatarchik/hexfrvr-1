package com.csdsx.game.model;

import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Administrator on 2016-07-09.
 */
public class Comb {
    public int type;//[0,6] consider textures[index] to draw comb
    public int sub_type;//[1,22]every type has sub type which consider shape
    public int logic_x;//[1,9]
    public int logic_y;//[1,9]
    public float pos_x;//float which in screen
    public float pos_y;//float which in screen
    public boolean hited;//is or hited

    static int cell_len = 23;//hexfrvr len size
    static float len = (float)(cell_len*1.732508);//cell diagonals len

    public Comb(int x, int y) {
        type = 0;
        sub_type = 0;
        logic_x = x;
        logic_y = y;
        pos_x = get_X(x, y);
        pos_y = get_Y(y);
    }

    public static float get_X(int x, int y) {
        if (y%2==0) {
            return len*x;
        }else{//奇数
            return len*x-len/2;
        }
    }
    public static float get_Y(int y) {
        return y*cell_len*3/2;
    }

    public static int[] getLogic_xy(float pos_x, float pos_y) {
        int[] result = new int[2];
        //计算y
        int y = (int)(pos_y*2/(3*cell_len));
        if(y > 9||y ==0) {
            return null;
        }
        int x = 0;
        result[1] = y;
        //分奇数和偶数
        if(y %2==0) {
            x = (int)(pos_x/len);
            result[0] = x;
        }else{
            x = (int)((pos_x+len/2)/len);
            result[0] = x;
        }
        if(x >9||x ==0) {
            return null;
        }
        int index = (y-1)*9+x;
        for(int i = 0; i < HMap.noShow.length; i++) {
            if(index == HMap.noShow[i]) {
                return null;
            }
        }
        return result;
    }
}
