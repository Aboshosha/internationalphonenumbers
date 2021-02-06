package com.jumia.exercise.internationalphonenumbers.services.messages;

public interface IMessage {

    OperationStatus getOperationStatus();

    String getErrorMessage();

    void setOperationStatus(OperationStatus status);

    void setErrorMessage(String errorMessage);

}
