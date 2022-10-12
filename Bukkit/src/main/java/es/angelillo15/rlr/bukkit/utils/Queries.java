package es.angelillo15.rlr.bukkit.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import es.angelillo15.rlr.bukkit.RamLimitRestart;
import es.angelillo15.rlr.bukkit.config.ConfigLoader;

public class Queries {
    public static long getUsageMemory() {
        String panel = ConfigLoader.getConfig().getString("Config.pterodactyl.panel-url");
        String serverUUID = ConfigLoader.getConfig().getString("Config.pterodactyl.serverUUID");
        try {
            HttpResponse<String> response = Unirest.get((panel+"api/client/servers/{uuid}/resources").replace("{uuid}", serverUUID))
                    .header("Authorization", "Bearer " + ConfigLoader.getConfig().getString("Config.pterodactyl.api-key"))
                    .asString();
            JsonElement jsonElement = JsonParser.parseString(response.getBody());
            long memory_bytes = jsonElement.getAsJsonObject().get("attributes").getAsJsonObject().get("resources")
                    .getAsJsonObject().get("memory_bytes").getAsLong()/1024/1024;
            if(memory_bytes == 0){
                RamLimitRestart.getPluginLogger().info("Error getting memory from panel, check your config.yml");
            }
            return memory_bytes;
        } catch (UnirestException e) {
            RamLimitRestart.getPluginLogger().error("Error getting memory from panel, check your config.yml");
            RamLimitRestart.getPluginLogger().debug(e.getMessage());
        }

        return 0;
    }

    public static int getMaxMemory(){
        String panel = ConfigLoader.getConfig().getString("Config.pterodactyl.panel-url");
        String serverUUID = ConfigLoader.getConfig().getString("Config.pterodactyl.serverUUID");

        try {
            HttpResponse<String> response = Unirest.get((panel+"api/client/servers/{uuid}/").replace("{uuid}", serverUUID))
                    .header("Authorization", "Bearer " + ConfigLoader.getConfig().getString("Config.pterodactyl.api-key"))
                    .asString();
            JsonElement jsonElement = JsonParser.parseString(response.getBody());

            int memory = jsonElement.getAsJsonObject().get("attributes").getAsJsonObject().get("limits")
                    .getAsJsonObject().get("memory").getAsInt();

            if(memory == 0){
                RamLimitRestart.getPluginLogger().info("Error getting memory from panel, check your config.yml");
            }
            return memory;

        } catch (UnirestException e) {
            RamLimitRestart.getPluginLogger().error("Error getting memory max from panel, check your config.yml");
            RamLimitRestart.getPluginLogger().debug(e.getMessage());
        }
        return 0;
    }
}
