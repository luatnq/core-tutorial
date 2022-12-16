package com.example.coreexception;

public class SystemInternalException extends BaseException {
    public SystemInternalException() {
        super();
        setStatus(500);
    }
}
