package com.company.commands.telegramcommands;

import com.company.database.IDatabaseWrapper;
import com.company.database.mongoDB.mongoDBtemplates.User;
import org.telegram.abilitybots.api.sender.SilentSender;

public class TelegramStartCommand extends TelegramBaseCommand {
    public TelegramStartCommand(SilentSender silentSender, IDatabaseWrapper db){
        super("start",
                "Начало работы",
                ctx -> silentSender.send(
                        "Привет!\n Этот бот будет помогать тебе учить большие объемы информации.\n📕",
                        ctx.chatId()),
                ctx -> db.registerUser(new User(ctx.chatId(), ctx.user().getFirstName())));
    }
}
