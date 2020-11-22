package github.veikkoroc.designpartten.structuraltype.adaptor.myadaptor.client;

import github.veikkoroc.designpartten.structuraltype.adaptor.myadaptor.adapter.PoliceCarAdapter;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/8 23:53
 */
public class Client {
    public static void main(String[] args) {
        PoliceCarAdapter policeCarAdapter = new PoliceCarAdapter();
        policeCarAdapter.move();
        policeCarAdapter.phonate();
        policeCarAdapter.twinkle();

    }
}
