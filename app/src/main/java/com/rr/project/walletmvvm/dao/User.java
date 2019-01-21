package com.rr.project.walletmvvm.dao;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by admin on 13-Jul-18.
 */

public class User implements Serializable {
    @SerializedName("MobileNumber")
    private String mobile;
    @SerializedName("FirstName")
    private String firstName;
    @SerializedName("MiddleName")
    private String middleName;
    @SerializedName("LastName")
    private String lastName;
    @SerializedName("email")
    private String email;
    @SerializedName("DeviceID")
    private String deviceID;
    @SerializedName("TokenID")
    private String tokenID;
    @SerializedName("DeviceType")
    private String deviceType = "Android";
    @SerializedName("RegistrationID")
    private long registrationID;
    @SerializedName("password")
    private String password;
    @SerializedName("Otp")
    private String Otp;

    @SerializedName("UserMobileNumber")
    private String userMobileNumber;
    @SerializedName("Gender")
    private String gender;
    @SerializedName("dob")
    private String DOB;
    @SerializedName("UserId")
    private int userID;
    @SerializedName("IsActive")
    private boolean isActive;
    @SerializedName("FamilyRelation")
    private String familyRelation;
    @SerializedName("FamilyType")
    private String familyType;

    @SerializedName("StatusCode")
    private String statusCode;
    @SerializedName("ErrorCode")
    private String errorCode;
    @SerializedName("ErrorMessage")
    private String errorMessage;

    private int timeSlotId;
    private String testDate;

    public User() {
    }

    public User(String mobile, String password, String deviceID, String tokenID) {
        setMobile(mobile);
        setPassword(password);
        setDeviceID(deviceID);
        setTokenID(tokenID);
    }

    public User(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    public int getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(int timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getTokenID() {
        return tokenID;
    }

    public void setTokenID(String tokenID) {
        this.tokenID = tokenID;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public long getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(long registrationID) {
        this.registrationID = registrationID;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOtp() {
        return Otp;
    }

    public void setOtp(String otp) {
        Otp = otp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getFamilyRelation() {
        return familyRelation;
    }

    public void setFamilyRelation(String familyRelation) {
        this.familyRelation = familyRelation;
    }

    public String getFamilyType() {
        return familyType;
    }

    public void setFamilyType(String familyType) {
        this.familyType = familyType;
    }
}
