import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public class class141 {
   @ObfuscatedName("q")
   public static String field2182 = null;
   @ObfuscatedName("nb")
   static class59 field2184;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 902974953
   )
   static int field2187;
   @ObfuscatedName("k")
   public static Applet field2188 = null;

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIB)V",
      garbageValue = "8"
   )
   static void method2964(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = NPC.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field839 = 0;
            var0.actionAnimationDisable = var2;
            var0.field861 = 0;
         }

         if(var3 == 2) {
            var0.field861 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || NPC.getAnimation(var1).field1012 >= NPC.getAnimation(var0.animation).field1012) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field839 = 0;
         var0.actionAnimationDisable = var2;
         var0.field861 = 0;
         var0.field863 = var0.field851;
      }

   }
}
