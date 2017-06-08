import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public class class231 {
   @ObfuscatedName("f")
   public final String field3184;
   @ObfuscatedName("n")
   static final class231 field3185;
   @ObfuscatedName("i")
   static final class231 field3186;
   @ObfuscatedName("j")
   static final class231 field3187;
   @ObfuscatedName("p")
   static final class231 field3188;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2029967575
   )
   final int field3189;

   static {
      field3185 = new class231("LIVE", 0);
      field3188 = new class231("BUILDLIVE", 3);
      field3186 = new class231("RC", 1);
      field3187 = new class231("WIP", 2);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class231(String var1, int var2) {
      this.field3184 = var1;
      this.field3189 = var2;
   }
}
