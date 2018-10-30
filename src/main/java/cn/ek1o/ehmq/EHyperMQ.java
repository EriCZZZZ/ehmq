package cn.ek1o.ehmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EHyperMQ {
    public static void main(String[] args) {
        EHyperMQ mq = EHyperMQ.getInstance();
        mq.start();
    }

    public static EHyperMQ getInstance() {
        if (instance == null) {
            synchronized (EHyperMQ.class) {
                if (instance == null) {
                    instance = EHyperMQ.init();
                }
            }
        }
        return instance;
    }

    public void start() {
        EHyperMQ.logger.info("start");
    }

    private static EHyperMQ init() {
        return new EHyperMQ();
    }

    private volatile static EHyperMQ instance;
    private static Logger logger = LoggerFactory.getLogger("EHyperMQ");
    private EHyperMQ() {}

}
