package com.gmail.davideblade99.healthbar.util;

import me.clip.placeholderapi.PlaceholderAPI;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Utils {

    /**
     * Enforce non-instantiability with a private constructor
     */
    private Utils() {
        throw new IllegalAccessError();
    }

    /**
     * Replace symbols used for the health bars
     *
     * @param input String in which to replace symbols
     *
     * @return String with replaced symbols and colors or {@code null} if input is {@code null}
     */
    @Contract("null -> null; !null -> !null")
    @Nullable
    public static String replaceSymbols(@Nullable final String input) {
        if (input == null || input.length() == 0)
            return input;

        // Replace colors and symbols
        return ChatColor.translateAlternateColorCodes('&', input)
                .replace("<3", "\u2764")
                .replace("[x]", "\u2588")
                .replace("[/]", "\u2588")
                .replace("[*]", "\u2605")
                .replace("[p]", "\u25CF")
                .replace("[+]", "\u25C6")
                .replace("[++]", "\u2726");

    }

    /**
     * If it does not exist, create the specified file by copying it from the .jar and then load it
     *
     * @param plugin Plugin instance
     * @param path   File path within the plugin folder
     *
     * @return {@link FileConfiguration} of the file or {@code null} in case of error
     */
    @Nullable
    public static FileConfiguration loadYamlFile(@NotNull String path, @NotNull final Plugin plugin) {
        if (!path.endsWith(".yml"))
            path += ".yml";

        final File file = new File(plugin.getDataFolder(), path);
        if (!file.exists()) {
            try {
                plugin.saveResource(path, false);
            } catch (final Exception e) {
                e.printStackTrace();

                final ConsoleCommandSender console = Bukkit.getConsoleSender();
                console.sendMessage("§c-------------------------------------------------");
                console.sendMessage("§c[HealthBar] Cannot copy " + path + " to disk!");
                console.sendMessage("§c-------------------------------------------------");
                return null;
            }
        }

        return YamlConfiguration.loadConfiguration(file);
    }

    /**
     * Create the locale.yml file by copying it from the .jar if it does not exist and then load it
     *
     * @param plugin Plugin instance
     *
     * @return A map that associates the entity name with the translated name
     */
    @NotNull
    public static Map<String, String> getTranslationMap(@NotNull final Plugin plugin) {
        final Map<String, String> localeMap = new HashMap<>();

        FileConfiguration config = loadYamlFile("locale.yml", plugin);
        if (config == null)
            config = new YamlConfiguration();

        for (EntityType entityType : EntityType.values()) {
            if (entityType.isAlive() && !entityType.equals(EntityType.PLAYER)) {
                final String name = entityType.toString();

                if (config.isSet(name))
                    localeMap.put(name, config.getString(name));
                else {
                    config.set(name, WordUtils.capitalizeFully(name.replace("_", " ")));
                    localeMap.put(name, WordUtils.capitalizeFully(name.replace("_", " ")));
                }
            }
        }

        try {
            config.save(new File(plugin.getDataFolder(), "locale.yml"));
        } catch (final IOException e) {
            e.printStackTrace();

            final ConsoleCommandSender console = Bukkit.getConsoleSender();
            console.sendMessage("§c-------------------------------------------------");
            console.sendMessage("§c[HealthBar] Cannot save locale.yml to disk!");
            console.sendMessage("§c-------------------------------------------------");
        }

        return localeMap;
    }

    /**
     * Parse the string to identify a list of entity types
     *
     * @param input String to parse
     *
     * @return A list of all {@link EntityType} found
     */
    @NotNull
    public static List<EntityType> getTypesFromString(@Nullable final String input) {
        final List<EntityType> list = new ArrayList<>();
        if (input == null || input.length() == 0)
            return list;

        for (String s : input.split(",")) {
            final EntityType type = getTypeFromString(s);
            if (type == null)
                Bukkit.getConsoleSender().sendMessage("§cCannot find entity type: '" + s + "'. Valid types are listed in locale.yml (The uppercase names, with the underscore)");
            else
                list.add(type);
        }

        return list;
    }

    /**
     * Attempts to match the {@link EntityType} to the string given as input
     *
     * @param str String to parse
     *
     * @return {@link EntityType} if found, otherwise null
     */
    @Nullable
    public static EntityType getTypeFromString(@NotNull final String str) {
        for (EntityType type : EntityType.values())
            if (str.replace(" ", "").replace("_", "").equalsIgnoreCase(type.toString().replace("_", "")))
                return type;

        return null;
    }

    /**
     * @param d Number to round up
     *
     * @return The number passed as parameter rounded up if it is positive. Returns 0 if it is negative.
     */
    public static int roundUpPositive(final double d) {
        int i = (int) d;
        double remainder = d - i;
        if (remainder > 0.0)
            i++;

        return Math.max(i, 0);
    }

    /**
     * @param d   Number to round up
     * @param max Upper limit
     *
     * @return {@code max} if the number passed as parameter exceeds the maximum while it returns 0 if it is
     * negative. If {@literal d > 0} and {@literal d <= max} then the number is rounded up and returned.
     *
     * @see #roundUpPositive(double)
     */
    public static int roundUpPositiveWithMax(final double d, final int max) {
        return d > max ? max : roundUpPositive(d);
    }

    /**
     * Creates an array of empty strings of the specified size
     *
     * @param size Array length
     *
     * @return The string array created
     *
     * @since v.2.0.3
     */
    @NotNull
    public static String[] initialiseEmptyStringArray(final int size) {
        final String[] ret = new String[size];
        Arrays.fill(ret, "");
        return ret;
    }

    public static String translateColorCodes(final String message) {
        if (message == null) {
            return null;
        }
        final String startTag = "&#";
        final String endTag = "";
        final char COLOR_CHAR = '§';
        final Pattern hexPattern = Pattern.compile(startTag + "([A-Fa-f0-9]{6})" + endTag);
        final Matcher matcher = hexPattern.matcher(message);
        final StringBuffer buffer = new StringBuffer(message.length() + 32);
        while (matcher.find()) {
            final String group = matcher.group(1);
            matcher.appendReplacement(buffer, COLOR_CHAR + "x" + COLOR_CHAR + group.charAt(0) + COLOR_CHAR + group.charAt(1) + COLOR_CHAR + group.charAt(2) + COLOR_CHAR + group.charAt(3) + COLOR_CHAR + group.charAt(4) + COLOR_CHAR + group.charAt(5));
        }
        String sr = matcher.appendTail(buffer).toString();
        sr = translatePlaceHolder(sr);
        return ChatColor.translateAlternateColorCodes('&', sr);
    }

    public static String translatePlaceHolder(String sr) {
        if (sr == null) {
            return null;
        }
        String aux = null;
        try {
            aux = PlaceholderAPI.setPlaceholders(null, sr);
        }
        catch (Exception ignored) {}
        if (aux != null) {
            sr = aux;
        }
        if (aux != null) {
            sr = aux;
        }
        if (aux != null) {
            sr = aux;
        }
        return sr;
    }

    public static String getHexCodeLightness(String colorStr, final int intensity, final int numb) {
        if (colorStr == null) {
            return null;
        }
        if (numb <= 0) {
            return translateColorCodes(colorStr);
        }
        if (!colorStr.startsWith("&#")) {
            return translateColorCodes(colorStr);
        }
        colorStr = colorStr.substring(1);
        int r = Integer.valueOf(colorStr.substring(1, 3), 16) - intensity * numb;
        int g = Integer.valueOf(colorStr.substring(3, 5), 16) - intensity * numb;
        int b = Integer.valueOf(colorStr.substring(5, 7), 16) - intensity * numb;
        if (r < 0) {
            r = 0;
        }
        if (g < 0) {
            g = 0;
        }
        if (b < 0) {
            b = 0;
        }
        String format = String.format("&#%02x%02x%02x", r, g, b);
        format = translateColorCodes(format);
        return format;
    }
}
