package pl.edu.zse.bmiCalc.exceptions;

public class ValidationException extends RuntimeException {
    private String validationInfo;

    public ValidationException(String validationInfo) {
        this.validationInfo = validationInfo;
    }
    public String getValidationInfo() {
        return validationInfo;
    }
}