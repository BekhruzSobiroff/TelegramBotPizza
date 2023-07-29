package org.example.controller;

import org.example.enums.CodeMessageType;
import org.example.model.CodeMessage;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

public class MyBot extends TelegramLongPollingBot {
    private String BOT_USERNAME="https://t.me/Pitza_zakaz_01_bot";
    private String BOT_TOKEN="6427659303:AAFhpabZEhtOm7ZWdkS2V9mh8u7KM9izcvM";
    private GeneralController generalController;
    public MyBot(){
        this.generalController=new GeneralController();
    }
    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message=update.getMessage();

        try {

             if (update.hasCallbackQuery()){
                 CallbackQuery callbackQuery=update.getCallbackQuery();
                 String data=callbackQuery.getData();
              //   User user=callbackQuery.getFrom();
                 message=callbackQuery.getMessage();
                 if (data.equals("callWithUs")||data.equals("zakaz")||data.equals())this.sendMsg(this.generalController.handle(data,message.getChatId(),message.getMessageId()));

             }

             else if (message !=null) {
                 SendMessage sendMessage=new SendMessage();
                 sendMessage.setChatId(message.getChatId());
                 String text=message.getText();
                 Integer messageId = message.getMessageId();
                 User user=message.getFrom();
                 if (text.equals("/start")||text.equals("/help")||text.equals("/settings"))this.sendMsg(this.generalController.handle(text, message.getChatId(),messageId));

             }else this.sendMsg(new SendMessage(message.getChatId().toString(),"Salom"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void sendMsg(SendMessage sendMessage){
        try {
            execute(sendMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }public void sendMsg(CodeMessage codeMessage){
        try {
            switch (codeMessage.getType()){
                case MS -> execute(codeMessage.getSendMessage());
                case ET -> execute(codeMessage.getEditMessageText());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
