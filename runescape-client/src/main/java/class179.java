import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class179 implements class158 {
   @ObfuscatedName("k")
   public static final class179 field2681 = new class179("game4", "Game 4", 3);
   @ObfuscatedName("e")
   public static final class179 field2682 = new class179("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("f")
   public static final class179 field2683 = new class179("game3", "Game 3", 2);
   @ObfuscatedName("g")
   public static final class179 field2684 = new class179("game5", "Game 5", 4);
   @ObfuscatedName("n")
   public static final class179 field2686 = new class179("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("a")
   public final String field2687;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1970656293
   )
   final int field2688;
   @ObfuscatedName("i")
   public static final class179 field2689 = new class179("runescape", "RuneScape", 0);
   @ObfuscatedName("dl")
   static byte[][] field2690;

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1502678813"
   )
   static final void method3202(boolean var0) {
      for(int var1 = 0; var1 < Client.field322; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field323[var1]];
         int var3 = 536870912 + (Client.field323[var1] << 14);
         if(null != var2 && var2.vmethod679() && var2.composition.isVisible == var0 && var2.composition.method3637()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field640 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field391[var4][var5] == Client.field312) {
                     continue;
                  }

                  Client.field391[var4][var5] = Client.field312;
               }

               if(!var2.composition.field3009) {
                  var3 -= Integer.MIN_VALUE;
               }

               Client.region.method1739(class171.plane, var2.x, var2.y, class85.method1686(var2.x + (var2.field640 * 64 - 64), var2.y + (var2.field640 * 64 - 64), class171.plane), 60 + (var2.field640 * 64 - 64), var2, var2.angle, var3, var2.field605);
            }
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class179(String var1, String var2, int var3) {
      this.field2687 = var1;
      this.field2688 = var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2056039019"
   )
   public int vmethod3974() {
      return this.field2688;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1535845526"
   )
   static final void method3205(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field281; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field560[var4] = true;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;Ljava/lang/String;B)I",
      garbageValue = "-62"
   )
   public static int method3206(Buffer var0, String var1) {
      int var2 = var0.offset;
      byte[] var3 = class15.method174(var1);
      var0.method2865(var3.length);
      var0.offset += class210.field3114.method2687(var3, 0, var3.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }
}
