package github.veikkoroc.design_partten.createtype.factory;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/8 23:09
 */
public class LetvTvFactory implements TvFactory {
    @Override
    public Tv createTv() {
        return new TvLetv();
    }
}
