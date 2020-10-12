package hippogriff.text;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class TextBuilder {

    public static ITextComponent mergeTextComponents(TextComponentBase... components) {
        TextComponentBase base = new TextComponentString("");
        for (TextComponentBase component: components) {
            base.appendSibling(component);
        }
        return ITextComponent.Serializer.jsonToComponent(ITextComponent.Serializer.componentToJson(base));
    }

    public static TextComponentBase getColored(String text, TextFormatting color) {
        TextComponentBase component = new TextComponentString(text);
        component.getStyle().setColor(color);
        return component;
    }

    public static TextComponentBase getBolded(String text, boolean bold) {
        TextComponentBase component = new TextComponentString(text);
        component.getStyle().setBold(bold);
        return component;
    }

    public static TextComponentBase getObfuscated(String text, boolean bold) {
        TextComponentBase component = new TextComponentString(text);
        component.getStyle().setObfuscated(bold);
        return component;
    }

}
