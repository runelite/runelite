import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class35 {
   @ObfuscatedName("t")
   static final class35 field777 = new class35();
   @ObfuscatedName("n")
   static final class35 field778 = new class35();
   @ObfuscatedName("f")
   static final class35 field779 = new class35();
   @ObfuscatedName("c")
   static int[][] field780;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 267406787
   )
   static int field781;
   @ObfuscatedName("i")
   public static boolean field782;
   @ObfuscatedName("e")
   static final class35 field785 = new class35();

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "127"
   )
   static final void method738(boolean var0) {
      for(int var1 = 0; var1 < Client.field321; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field405[var1]];
         int var3 = (Client.field405[var1] << 14) + 536870912;
         if(null != var2 && var2.vmethod787() && var0 == var2.composition.isVisible && var2.composition.method799()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field842 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field385[var4][var5] == Client.field386) {
                     continue;
                  }

                  Client.field385[var4][var5] = Client.field386;
               }

               if(!var2.composition.field916) {
                  var3 -= Integer.MIN_VALUE;
               }

               class9.region.method2020(XItemContainer.plane, var2.x, var2.y, Renderable.method1960(var2.x + (var2.field842 * 64 - 64), var2.y + (var2.field842 * 64 - 64), XItemContainer.plane), 60 + (var2.field842 * 64 - 64), var2, var2.angle, var3, var2.field819);
            }
         }
      }

   }
}
