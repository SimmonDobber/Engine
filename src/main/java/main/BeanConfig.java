package main;

import assets.AssetsBean;
import display.DisplayBean;
import input.InputBean;
import scene.SceneBean;
import threader.ThreaderBean;

public class BeanConfig {

    BeanConfig() {
    }

    void buildBeans() {
        AssetsBean.getAssets();
        DisplayBean.getDisplay();
        InputBean.getInput();
        SceneBean.getScene();
        ThreaderBean.getThreader();
    }

}
