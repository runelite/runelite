import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class11 {
   @ObfuscatedName("c")
   public static final class11 field263;
   @ObfuscatedName("cn")
   static class153 field265;
   @ObfuscatedName("pf")
   static class109 field267;
   @ObfuscatedName("i")
   public static final class11 field268;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "339"
   )
   public static int method50(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   static {
      field268 = new class11();
      field263 = new class11();
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIB)V",
      garbageValue = "-10"
   )
   static void method51(Player var0, int var1, int var2) {
      if(var1 == var0.animation && var1 != -1) {
         int var3 = class227.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1260 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1278 = 0;
         }

         if(var3 == 2) {
            var0.field1278 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class227.getAnimation(var1).forcedPriority >= class227.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1260 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1278 = 0;
         var0.field1301 = var0.field1263;
      }

   }
}
