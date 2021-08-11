package bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();

        SendMessage message = new SendMessage();

        System.out.println(command);

        message.setChatId(update.getMessage().getChatId());
        message.setText(update.getMessage().getText());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotToken() {
        return "BOT_TOKEN";
    }

    @Override
    public String getBotUsername() {
        return "BOT_USERNAME";
    }
}
