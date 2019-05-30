package mironouz.com.logic;

import java.util.List;

public class Logger {
    private int log_level;

    public Logger(int log_level) {
        this.log_level = log_level;
    }

    public void log(List l) {
        if (l.size() % log_level == 0) {
            l.forEach((e) -> {
                System.out.println("*********************************");
                System.out.println(e);
                System.out.println("*********************************");
            });
        }
    }
}
