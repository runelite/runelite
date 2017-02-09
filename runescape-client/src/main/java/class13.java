import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public class class13 {
   @ObfuscatedName("qc")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(LPlayer;III)V",
      garbageValue = "-1531173747"
   )
   static void method188(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = TextureProvider.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field624 = 0;
            var0.actionAnimationDisable = var2;
            var0.field590 = 0;
         }

         if(var3 == 2) {
            var0.field590 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || TextureProvider.getAnimation(var1).forcedPriority >= TextureProvider.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field624 = 0;
         var0.actionAnimationDisable = var2;
         var0.field590 = 0;
         var0.field645 = var0.field644;
      }

   }

   class13() throws Throwable {
      throw new Error();
   }
}
