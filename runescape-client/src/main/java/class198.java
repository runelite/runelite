import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class198 {
   @ObfuscatedName("kn")
   @ObfuscatedSignature(
      signature = "(Lho;I)Ljava/lang/String;",
      garbageValue = "1713547686"
   )
   static String method3745(Widget var0) {
      return class211.method4107(class1.getWidgetClickMask(var0)) == 0?null:(var0.spellActionName != null && var0.spellActionName.trim().length() != 0?var0.spellActionName:null);
   }
}
