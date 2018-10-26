package com.github.torczuk.infrastructure;

public class EmailSender {
    public void send(String can_not_register, String sorry_the_limit_exceeded, String email) {
        throw new RuntimeException("Configure email sender, it does not work in this machine");
    }
}
