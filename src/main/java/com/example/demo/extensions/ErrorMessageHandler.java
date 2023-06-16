package com.example.demo.extensions;

public class ErrorMessageHandler {
	private boolean flag;
    private String message;

    public ErrorMessageHandler(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
        System.err.println(this.message);
        throw new IllegalStateException(this.message);
    }
    
    @Override
    public void finalize() {
      System.out.println("Book instance is getting destroyed");
    }

    public boolean isFlag() {
        return flag;
    }

    public String getMessage() {
        return message;
    }
    
    
}
