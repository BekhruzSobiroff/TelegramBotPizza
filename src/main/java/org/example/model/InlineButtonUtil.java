package org.example.model;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InlineButtonUtil {
    public static InlineKeyboardButton button(String text, String callbackQueryData){
        return InlineKeyboardButton.builder().text(text).callbackData(callbackQueryData).build();
    }
    public static List<InlineKeyboardButton> row(InlineKeyboardButton... buttons){
        List<InlineKeyboardButton> row=new LinkedList<>();
        row.addAll(Arrays.asList(buttons));
        return row;
    }
    public static List<List<InlineKeyboardButton>> rowCollection(List<InlineKeyboardButton>... row){
        List<List<InlineKeyboardButton>> rowCollection=new LinkedList<>();
        rowCollection.addAll(Arrays.asList(row));
    return rowCollection;}
    public static InlineKeyboardMarkup markup(List<List<InlineKeyboardButton>> rowCollection){
        InlineKeyboardMarkup inlineKeyboardMarkup=new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowCollection);
        return inlineKeyboardMarkup;
    }
}
