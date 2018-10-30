package cn.ek1o.ehmq;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EHyperMQTest {
    @Test
    public void testGetInstance() {
        EHyperMQ mq = EHyperMQ.getInstance();
        Assertions.assertNotNull(mq);
    }

}
