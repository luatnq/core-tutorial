package com.example.coreexception;

public class NotSupportException extends BaseException {
    public NotSupportException() {
        setStatus(400);
        setCode("com.example.coreexception.NotSupportException");
    }
}
