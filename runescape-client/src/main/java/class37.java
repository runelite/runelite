import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class37 {
   @ObfuscatedName("x")
   static Widget field515;

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIIIII)V",
      garbageValue = "-1283947101"
   )
   static final void method496(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field995) {
         Client.field912 = 32;
      } else {
         Client.field912 = 0;
      }

      Client.field995 = false;
      int var7;
      if(class59.field716 == 1 || !ItemLayer.field1798 && class59.field716 == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
            var0.scrollY -= 4;
            CombatInfo1.method1515(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
            var0.scrollY += 4;
            CombatInfo1.method1515(var0);
         } else if(var5 >= var1 - Client.field912 && var5 < var1 + 16 + Client.field912 && var6 >= var2 + 16 && var6 < var2 + var3 - 16) {
            var7 = (var3 - 32) * var3 / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = var8 * (var4 - var3) / var9;
            CombatInfo1.method1515(var0);
            Client.field995 = true;
         }
      }

      if(Client.field940 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.scrollY += Client.field940 * 45;
            CombatInfo1.method1515(var0);
         }
      }

   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(LPlayer;III)V",
      garbageValue = "1386355975"
   )
   static void method499(Player var0, int var1, int var2) {
      if(var1 == var0.animation && var1 != -1) {
         int var3 = class169.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1260 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1228 = 0;
         }

         if(var3 == 2) {
            var0.field1228 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class169.getAnimation(var1).forcedPriority >= class169.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1260 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1228 = 0;
         var0.field1285 = var0.queueSize;
      }

   }
}
