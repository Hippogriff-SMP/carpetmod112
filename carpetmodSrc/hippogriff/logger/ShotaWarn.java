package hippogriff.logger;

import hippogriff.text.TextBuilder;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import javax.annotation.Nullable;

public class ShotaWarn {

    public static void warn(@Nullable MinecraftServer server, ITextComponent component) {
        component.getStyle().setColor(TextFormatting.RED);
        if (server != null)
            server.getPlayerList().sendMessage(component);
    }

    public static void warn(EntityPlayerMP actor, ITextComponent target, String... langs) {
        for (String lang: langs) {
            warn(actor.getServer(), TextBuilder.mergeTextComponents(actor.getDisplayName(), new TextComponentString(" " + lang + " "), target));
        }
    }

    public static void warn(EntityPlayerMP actor, String target, String... langs) {
        warn(actor, new TextComponentString(target), langs);
    }

    public static void warn(EntityPlayerMP actor, EntityPlayerMP target, String... langs) {
        warn(actor, target.getDisplayName(), langs);
    }

}
