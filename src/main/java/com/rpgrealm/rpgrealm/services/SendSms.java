package com.rpgrealm.rpgrealm.services;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.lookups.v1.PhoneNumber;


public class SendSms {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "";
  public static final String AUTH_TOKEN = "";

  public static void sendTxt(String phoneNumber, String textMessage) {

    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message.creator(new PhoneNumber("+1" + phoneNumber),
            new PhoneNumber("+17377779078"),
            textMessage).create();
    System.out.println("Sending Twilio Message: ");
    System.out.println(message.getSid());
  }

  public static void main(String[] args) {

    sendTxt("5125010416", "Test message from Chase's Java App");

  }

}