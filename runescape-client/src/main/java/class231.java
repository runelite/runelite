import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public class class231 {
   @ObfuscatedName("h")
   static final class231 field3173;
   @ObfuscatedName("p")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("i")
   static final class231 field3175;
   @ObfuscatedName("g")
   public final String field3176;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -605656049
   )
   final int field3177;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -137028267
   )
   static int field3178;
   @ObfuscatedName("q")
   static final class231 field3179;
   @ObfuscatedName("u")
   static final class231 field3180;

   static {
      field3175 = new class231("LIVE", 0);
      field3173 = new class231("BUILDLIVE", 3);
      field3180 = new class231("RC", 1);
      field3179 = new class231("WIP", 2);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class231(String var1, int var2) {
      this.field3176 = var1;
      this.field3177 = var2;
   }
}
