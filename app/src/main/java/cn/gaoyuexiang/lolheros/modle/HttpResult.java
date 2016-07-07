package cn.gaoyuexiang.lolheros.modle;

import java.util.List;

/**
 * Created by kbyyd on 2016/7/7.
 */
public class HttpResult {

    private int errorCode;
    private List<Hero> heros;

    public HttpResult() {
    }

    public HttpResult(int errorCode, List<Hero> heros) {
        this.errorCode = errorCode;
        this.heros = heros;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public List<Hero> getHeros() {
        return heros;
    }

    public void setHeros(List<Hero> heros) {
        this.heros = heros;
    }
}
