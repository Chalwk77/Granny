// Copyright (c) 2023, Jericho Crosby <jericho.crosby227@gmail.com>

package com.chalwk.listeners;

import com.chalwk.util.NewTimer;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EventListeners extends ListenerAdapter {

    @Override
    public void onGuildReady(GuildReadyEvent event) {

        System.out.println("Guild ready: " + event.getGuild().getName());
        System.out.println("Bot name: " + event.getJDA().getSelfUser().getName());

        NewTimer timer = new NewTimer();

        timer.initTimer(1);
    }
}