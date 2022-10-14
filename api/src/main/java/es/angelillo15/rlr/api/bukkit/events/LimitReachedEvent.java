package es.angelillo15.rlr.api.bukkit.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * This event would be fired when the limit is reached
 * <p>
 * This event doesn't have any method or variable
 * it's just a event to notify that the limit has been reached
 */
public class LimitReachedEvent extends Event {
    private final HandlerList handlers = new HandlerList();
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
