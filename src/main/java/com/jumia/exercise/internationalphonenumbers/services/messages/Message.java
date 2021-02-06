package com.jumia.exercise.internationalphonenumbers.services.messages;

public class Message implements IMessage {

    private OperationStatus oprationStatus;
    private String errorMessage;

    @Override
    public OperationStatus getOperationStatus() {

        return oprationStatus;
    }

    @Override
    public String getErrorMessage() {

        return errorMessage;
    }

    @Override
    public void setOperationStatus(OperationStatus status) {

        this.oprationStatus = status;
    }

    @Override
    public void setErrorMessage(String errorMessage) {

        this.errorMessage = errorMessage;
    }

}
