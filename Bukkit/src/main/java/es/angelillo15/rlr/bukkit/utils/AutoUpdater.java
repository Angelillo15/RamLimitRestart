package es.angelillo15.rlr.bukkit.utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import es.angelillo15.rlr.bukkit.RamLimitRestart;

import java.util.Objects;

public class AutoUpdater {
    private String spigotVersion;
    private final int pluginId;
    private String currentVersion;

    public AutoUpdater(int pluginId) {
        this.pluginId = pluginId;
        this.currentVersion = RamLimitRestart.getInstance().getDescription().getVersion();
    }

    public void checkForUpdates() {
        try {
            HttpResponse<String> response = Unirest.get("https://api.spigotmc.org/legacy/update.php?resource=%pluginID%".
                    replace("%pluginID%", String.valueOf(this.pluginId)))
                    .asString();
            this.spigotVersion = response.getBody();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean hasUpdate() {
        if (this.spigotVersion == null) {
            checkForUpdates();
        }
        return !(Objects.equals(currentVersion, spigotVersion));
    }

    public String getSpigotVersion() {
        return spigotVersion;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }
}
