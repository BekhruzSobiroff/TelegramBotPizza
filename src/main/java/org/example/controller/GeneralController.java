package org.example.controller;

import org.example.enums.CodeMessageType;
import org.example.model.CodeMessage;
import org.example.model.InlineButtonUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;

public class GeneralController {
    public CodeMessage handle(String text, Long chatId, Integer messageId){
       CodeMessage codeMessage=new CodeMessage();
        SendMessage sendMessage=new SendMessage();
        sendMessage.setChatId(chatId);
        EditMessageText editMessageText=new EditMessageText();
        editMessageText.setChatId(chatId);
        editMessageText.setMessageId(messageId);

        if (text.equals("/start")){
            sendMessage.setText("Tanalng");
            sendMessage.setReplyMarkup(InlineButtonUtil.markup(
                    InlineButtonUtil.rowCollection(
                            InlineButtonUtil.row(InlineButtonUtil.button("\uD83C\uDF55 Pizza zakaz berish \uD83C\uDF55","zakaz")),
                            InlineButtonUtil.row(InlineButtonUtil.button("\uD83D\uDCDE Biz bilan boglanish \uD83D\uDCDE","callWithUs")))));
             codeMessage.setSendMessage(sendMessage);
             codeMessage.setType(CodeMessageType.MS);

        } else if (text.equals("/help")) {
             sendMessage.setText("Sizga qanday yordam beramiz");
            codeMessage.setSendMessage(sendMessage);
            codeMessage.setType(CodeMessageType.MS);
        } else if (text.equals("/settings")) {
            sendMessage.setText("settinglar mavjud emas");
            codeMessage.setSendMessage(sendMessage);
            codeMessage.setType(CodeMessageType.MS);

}

        else if (text.equals("callWithUs")||text.equals("zakaz")) {
    if (text.equals("callWithUs")){
    editMessageText.setText("☎ Biz bilan boglanish ☎ \n" +
                         "https://t.me/bexruz_3488");

    }else if (text.equals("zakaz")){
        editMessageText.setText("You need choose which one");
        editMessageText.setReplyMarkup(InlineButtonUtil.markup(InlineButtonUtil.rowCollection(
                InlineButtonUtil.row(InlineButtonUtil.button("Dangerous pizza","/pizza/danger"),InlineButtonUtil.button("Italiano pizza","/pizza/Italian"),InlineButtonUtil.button("China pizza","/pizza/Chinese")),
                InlineButtonUtil.row(InlineButtonUtil.button("Lavash Pizza","/pizza/lavash"),InlineButtonUtil.button("Danar pizza","/pizza/danar"),InlineButtonUtil.button("Gigant pizza","/pizza/gigant")),
                InlineButtonUtil.row(InlineButtonUtil.button("Global pizza","/pizza/global"),InlineButtonUtil.button("National pizza","/pizza/national"),InlineButtonUtil.button("Local pizza","/pizza/local")),
                InlineButtonUtil.row(InlineButtonUtil.button("Cancel","cancel"))
        )));

    }
            codeMessage.setEditMessageText(editMessageText);
            codeMessage.setType(CodeMessageType.ET);
}
        return codeMessage;}
}
