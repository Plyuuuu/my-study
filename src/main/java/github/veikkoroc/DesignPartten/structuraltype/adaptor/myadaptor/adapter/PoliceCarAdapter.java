package github.veikkoroc.DesignPartten.structuraltype.adaptor.myadaptor.adapter;

import github.veikkoroc.DesignPartten.structuraltype.adaptor.myadaptor.adaptee.PoliceLamp;
import github.veikkoroc.DesignPartten.structuraltype.adaptor.myadaptor.adaptee.PoliceSound;
import github.veikkoroc.DesignPartten.structuraltype.adaptor.myadaptor.target.CarController;

/**
 * 适配器
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/8 23:49
 */
public class PoliceCarAdapter extends CarController {
    /**
     * 两个适配者
     */
    private PoliceSound policeSound;
    private PoliceLamp policeLamp;

    public PoliceCarAdapter() {
        policeSound = new PoliceSound();
        policeLamp = new PoliceLamp();
    }

    @Override
    public void phonate() {
        policeSound.alarmSound();
    }

    @Override
    public void twinkle() {
        policeLamp.alarmLamp();
    }
}
