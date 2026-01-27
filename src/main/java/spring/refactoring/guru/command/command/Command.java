package spring.refactoring.guru.command.command;

public interface Command<T> {
    void execute(T context);
}
