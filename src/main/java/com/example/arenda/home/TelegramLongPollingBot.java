package com.example.arenda.home;

import org.telegram.telegrambots.meta.api.objects.Update;

public abstract class TelegramLongPollingBot {
    public abstract String getBotUsername();

    public abstract String getBotToken();

    public abstract void onUpdateReceived(Update update);
}
