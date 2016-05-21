package me.edagarli.disruptor;

import com.lmax.disruptor.ExceptionHandler;

/**
 * User: edagarli
 * Email: lizhi@edagarli.com
 * Date: 16/5/21
 * Time: 15:21
 * Desc:
 */
public class IntEventExceptionHandler implements ExceptionHandler {
    @Override
    public void handleEventException(Throwable throwable, long l, Object o) {
    }

    @Override
    public void handleOnStartException(Throwable throwable) {
    }

    @Override
    public void handleOnShutdownException(Throwable throwable) {
    }
}
