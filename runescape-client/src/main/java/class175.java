import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class175 {
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = -712215183
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("ek")
   static SpritePixels[] field2644;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;I)V",
      garbageValue = "-172563408"
   )
   public static void method3241(class182 var0, class182 var1) {
      class168.field2183 = var0;
      class217.field3170 = var1;
   }

   class175() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIB)V",
      garbageValue = "-81"
   )
   static void method3242(Player var0, int var1, int var2) {
      if(var1 == var0.animation && var1 != -1) {
         int var3 = class146.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field626 = 0;
            var0.actionAnimationDisable = var2;
            var0.field648 = 0;
         }

         if(var3 == 2) {
            var0.field648 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class146.getAnimation(var1).forcedPriority >= class146.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field626 = 0;
         var0.actionAnimationDisable = var2;
         var0.field648 = 0;
         var0.field651 = var0.field646;
      }

   }
}
