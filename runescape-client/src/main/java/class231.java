import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public class class231 {
   @ObfuscatedName("a")
   static final class231 field3191;
   @ObfuscatedName("w")
   static final class231 field3192;
   @ObfuscatedName("i")
   static final class231 field3193;
   @ObfuscatedName("s")
   public final String field3194;
   @ObfuscatedName("t")
   static final class231 field3195;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -892837143
   )
   public final int field3196;

   static {
      field3193 = new class231("LIVE", 0);
      field3192 = new class231("BUILDLIVE", 3);
      field3191 = new class231("RC", 1);
      field3195 = new class231("WIP", 2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-22"
   )
   public static void method4105() {
      if(class238.field3272 != null) {
         class238.field3272.close();
      }

   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class231(String var1, int var2) {
      this.field3194 = var1;
      this.field3196 = var2;
   }
}
