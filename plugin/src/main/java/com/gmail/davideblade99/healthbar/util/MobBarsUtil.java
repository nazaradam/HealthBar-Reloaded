package com.gmail.davideblade99.healthbar.util;

import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public final class MobBarsUtil {

    /**
     * Enforce non-instantiability with a private constructor
     */
    private MobBarsUtil() {
        throw new IllegalAccessError();
    }

    /**
     * Used to retrieve the array that contains the health bars from the configs
     *
     * @param barStyle Bar style
     *
     * @return An array in which each element represents the bar to be shown based on the corresponding health of
     * the mob
     */
    @NotNull
    public static String[] getDefaultsBars(final int barStyle) {
        final String[] barArray = new String[21];

        switch (barStyle) {
            case 2:
                barArray[0] = "§c|§7|||||||||||||||||||";
                barArray[1] = "§c|§7|||||||||||||||||||";
                barArray[2] = "§c||§7||||||||||||||||||";
                barArray[3] = "§c|||§7|||||||||||||||||";
                barArray[4] = "§c||||§7||||||||||||||||";
                barArray[5] = "§e|||||§7|||||||||||||||";
                barArray[6] = "§e||||||§7||||||||||||||";
                barArray[7] = "§e|||||||§7|||||||||||||";
                barArray[8] = "§e||||||||§7||||||||||||";
                barArray[9] = "§e|||||||||§7|||||||||||";
                barArray[10] = "§e||||||||||§7||||||||||";
                barArray[11] = "§a|||||||||||§7|||||||||";
                barArray[12] = "§a||||||||||||§7||||||||";
                barArray[13] = "§a|||||||||||||§7|||||||";
                barArray[14] = "§a||||||||||||||§7||||||";
                barArray[15] = "§a|||||||||||||||§7|||||";
                barArray[16] = "§a||||||||||||||||§7||||";
                barArray[17] = "§a|||||||||||||||||§7|||";
                barArray[18] = "§a||||||||||||||||||§7||";
                barArray[19] = "§a|||||||||||||||||||§7|";
                barArray[20] = "§a||||||||||||||||||||";
                break;
            case 3:
                barArray[0] = "§c❤§7❤❤❤❤❤❤❤❤❤";
                barArray[1] = "§c❤§7❤❤❤❤❤❤❤❤❤";
                barArray[2] = "§c❤§7❤❤❤❤❤❤❤❤❤";
                barArray[3] = "§c❤❤§7❤❤❤❤❤❤❤❤";
                barArray[4] = "§c❤❤§7❤❤❤❤❤❤❤❤";
                barArray[5] = "§e❤❤❤§7❤❤❤❤❤❤❤";
                barArray[6] = "§e❤❤❤§7❤❤❤❤❤❤❤";
                barArray[7] = "§e❤❤❤❤§7❤❤❤❤❤❤";
                barArray[8] = "§e❤❤❤❤§7❤❤❤❤❤❤";
                barArray[9] = "§e❤❤❤❤❤§7❤❤❤❤❤";
                barArray[10] = "§e❤❤❤❤❤§7❤❤❤❤❤";
                barArray[11] = "§a❤❤❤❤❤❤§7❤❤❤❤";
                barArray[12] = "§a❤❤❤❤❤❤§7❤❤❤❤";
                barArray[13] = "§a❤❤❤❤❤❤❤§7❤❤❤";
                barArray[14] = "§a❤❤❤❤❤❤❤§7❤❤❤";
                barArray[15] = "§a❤❤❤❤❤❤❤❤§7❤❤";
                barArray[16] = "§a❤❤❤❤❤❤❤❤§7❤❤";
                barArray[17] = "§a❤❤❤❤❤❤❤❤❤§7❤";
                barArray[18] = "§a❤❤❤❤❤❤❤❤❤§7❤";
                barArray[19] = "§a❤❤❤❤❤❤❤❤❤❤";
                barArray[20] = "§a❤❤❤❤❤❤❤❤❤❤";
                break;
            case 4:
                barArray[0] = "§a▌§8▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌";
                barArray[1] = "§a▌§8▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌";
                barArray[2] = "§a▌▌§8▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌";
                barArray[3] = "§a▌▌▌§8▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌";
                barArray[4] = "§a▌▌▌▌§8▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌";
                barArray[5] = "§a▌▌▌▌▌§8▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌";
                barArray[6] = "§a▌▌▌▌▌▌§8▌▌▌▌▌▌▌▌▌▌▌▌▌▌";
                barArray[7] = "§a▌▌▌▌▌▌▌§8▌▌▌▌▌▌▌▌▌▌▌▌▌";
                barArray[8] = "§a▌▌▌▌▌▌▌▌§8▌▌▌▌▌▌▌▌▌▌▌▌";
                barArray[9] = "§a▌▌▌▌▌▌▌▌▌§8▌▌▌▌▌▌▌▌▌▌▌";
                barArray[10] = "§a▌▌▌▌▌▌▌▌▌▌§8▌▌▌▌▌▌▌▌▌▌";
                barArray[11] = "§a▌▌▌▌▌▌▌▌▌▌▌§8▌▌▌▌▌▌▌▌▌";
                barArray[12] = "§a▌▌▌▌▌▌▌▌▌▌▌▌§8▌▌▌▌▌▌▌▌";
                barArray[13] = "§a▌▌▌▌▌▌▌▌▌▌▌▌▌§8▌▌▌▌▌▌▌";
                barArray[14] = "§a▌▌▌▌▌▌▌▌▌▌▌▌▌▌§8▌▌▌▌▌▌";
                barArray[15] = "§a▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌§8▌▌▌▌▌";
                barArray[16] = "§a▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌§8▌▌▌▌";
                barArray[17] = "§a▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌§8▌▌▌";
                barArray[18] = "§a▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌§8▌▌";
                barArray[19] = "§a▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌§8▌";
                barArray[20] = "§a▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌";
                break;
            case 5:
                barArray[0] = "§c█§0█████████";
                barArray[1] = "§c█§0█████████";
                barArray[2] = "§c█§0█████████";
                barArray[3] = "§c██§0████████";
                barArray[4] = "§c██§0████████";
                barArray[5] = "§e███§0███████";
                barArray[6] = "§e███§0███████";
                barArray[7] = "§e████§0██████";
                barArray[8] = "§e████§0██████";
                barArray[9] = "§e█████§0█████";
                barArray[10] = "§e█████§0█████";
                barArray[11] = "§a██████§0████";
                barArray[12] = "§a██████§0████";
                barArray[13] = "§a███████§0███";
                barArray[14] = "§a███████§0███";
                barArray[15] = "§a████████§0██";
                barArray[16] = "§a████████§0██";
                barArray[17] = "§a█████████§0█";
                barArray[18] = "§a█████████§0█";
                barArray[19] = "§a██████████";
                barArray[20] = "§a██████████";
                break;
            default:
                final String SPACES = "\uf802";
                final String frame = "\uE024";

                final String FULL = "\uE025";
                final String EMPTY = "\uE026";
                for (int i = 2; i <= 22; i++) {
                    double current = (((double) (i - 2) / 20) * 16);
                    int percentage = 16 / 3;
                    String color;
                    if (current > percentage * 2 && current <= 16.0) {
                        color = Utils.translateColorCodes("&#00FF00");
                    }
                    else if (current >= percentage && current <= percentage * 2) {
                        color = Utils.translateColorCodes("&#FFFF00");
                    }
                    else {
                        color = Utils.translateColorCodes("&#FF0000");
                    }

                    String salid = color + printMM(16.0, current, FULL, EMPTY, SPACES);
                    salid = frame + SPACES.repeat(38) + salid;
                    barArray[i - 2] = salid;

                    System.out.println(i - 2 + ": " + current);
                }
                break;
        }

        return barArray;
    }


    /**
     * Load the bars from a custom file
     *
     * @param config Configuration file from which to retrieve custom bar settings
     *
     * @return An array in which each element represents the bar to be shown based on the corresponding health of
     * the mob. If the element is {@code null}, it means that no bar is set (and therefore nothing will be shown).
     */
    @NotNull
    public static String[] getCustomBars(@NotNull final FileConfiguration config) {
        final String[] barArray = new String[21];

        for (int i = 1; i < 21; i++) {
            final String cname = config.getString(i * 5 + "-percent-bar");
            if (cname != null)
                barArray[i] = Utils.replaceSymbols(cname);
        }

        return barArray;
    }

    private static String printMM(final double maxDamage, final double currentDamage, final String FULL, final String EMPTY, final String SPACES) {
        if (FULL == null || EMPTY == null || SPACES == null) {
            return null;
        }
        final String s = getStringBars(FULL, SPACES, currentDamage);
        return getStringMM(maxDamage, currentDamage, EMPTY, SPACES, s);
    }

    private static String getStringMM(final double maxDamage, final double currentDamage, final String EMPTY, final String SPACES, String s) {
        double total = maxDamage - currentDamage;
        if (total % 2.0 != 0.0) {
            double sub = total % 2;

            total = total - sub;
        }

        StringBuilder sBuilder = new StringBuilder(s);
        for (int i = 0; i < total / 2.0; ++i) {
            sBuilder.append(EMPTY).append(SPACES);
        }
        s = sBuilder.toString();
        return s;
    }


    private static String getStringBars(final String FULL, final String SPACES, final double aux) {
        StringBuilder sal = new StringBuilder();
        for (int i = 0; i < aux / 2.0; ++i) {
            sal.append(FULL).append(SPACES);
        }
        return sal.toString();
    }
}
