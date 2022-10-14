package es.angelillo15.rlr.api.bukkit.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * This event would be fired when the limit is reached and a command is executed
 * <p>
 * This event has a method to get the command and another to cancel the execution
 * of the command
 * @see CommandOnLimitReachedEvent#getCommand()
 * @see CommandOnLimitReachedEvent#setCancelled(boolean)
 */
public class CommandOnLimitReachedEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();
    private boolean cancelled;
    private final String command;

    public CommandOnLimitReachedEvent(String command) {
        this.command = command;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * <p>If you cancel the event
     * the command will not be executed</p>
     * @param cancel true if you wish to cancel this event
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }


    /**
     * @return HandlerList
     */
    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    /**
     * @return the command that is going to be executed
     */
    public String getCommand() {
        return command;
    }
}
