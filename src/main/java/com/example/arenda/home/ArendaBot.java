package com.example.arenda.home;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

@Component
public class ArendaBot extends TelegramLongPollingBot {

    private final String username;
    private final String token;

    public ArendaBot(
            @Value("${telegram.bot.username}") String username,
            @Value("${telegram.bot.token}") String token) {

        this.username = username;
        this.token = token;
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

            String text = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            switch (text) {

                case "/start" -> sendMainMenu(chatId);

                case "/ijara" -> sendRayonMenu(chatId);

                case "/sotuv" ->
                        send(chatId,
                                "🏠 Sotuv kanali:\nhttps://t.me/sotuvkanal");

                case "/help" ->
                        send(chatId,
                                "Yordam:\n" +
                                        "/start - menyu\n" +
                                        "/ijara - ijara uylar\n" +
                                        "/sotuv - sotuv uylar");

                case "🏢 Ijara" -> sendRayonMenu(chatId);

                case "🏠 Sotuv" ->
                        send(chatId,
                                "🏠 Sotuv kanali:\nhttps://t.me/sotuvkanal");

                case "📍 Chilonzor" ->
                        send(chatId,
                                "Chilonzor ijara kanali:\nhttps://t.me/chilonzorijara");

                case "📍 Yunusobod" ->
                        send(chatId,
                                "Yunusobod ijara kanali:\nhttps://t.me/yunusobodijara");

                case "📍 Olmazor" ->
                        send(chatId,
                                "Olmazor ijara kanali:\nhttps://t.me/olmazorijara");
            }
        }
    }

    private void sendMainMenu(Long chatId) {

        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        keyboard.setResizeKeyboard(true);

        KeyboardRow row = new KeyboardRow();
        row.add("🏠 Sotuv");
        row.add("🏢 Ijara");

        keyboard.setKeyboard(List.of(row));

        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText("Kerakli bo‘limni tanlang:");
        message.setReplyMarkup(keyboard);

        try {
            execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendRayonMenu(Long chatId) {

        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        keyboard.setResizeKeyboard(true);

        KeyboardRow row1 = new KeyboardRow();
        row1.add("📍 Chilonzor");
        row1.add("📍 Yunusobod");

        KeyboardRow row2 = new KeyboardRow();
        row2.add("📍 Olmazor");

        keyboard.setKeyboard(List.of(row1, row2));

        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText("Rayonni tanlang:");
        message.setReplyMarkup(keyboard);

        try {
            execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void send(Long chatId, String text) {

        try {
            execute(new SendMessage(chatId.toString(), text));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
