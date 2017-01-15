import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class179 implements class158 {
   @ObfuscatedName("c")
   public static final class179 field2660 = new class179("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("x")
   public static final class179 field2661 = new class179("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("i")
   public static final class179 field2662 = new class179("game3", "Game 3", 2);
   @ObfuscatedName("ki")
   static class112 field2663;
   @ObfuscatedName("f")
   public static final class179 field2664 = new class179("game5", "Game 5", 4);
   @ObfuscatedName("a")
   public static final class179 field2665 = new class179("game4", "Game 4", 3);
   @ObfuscatedName("u")
   public static final class179 field2666 = new class179("runescape", "RuneScape", 0);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1011839827
   )
   final int field2667;
   @ObfuscatedName("mx")
   static SpritePixels field2668;
   @ObfuscatedName("d")
   public final String field2669;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class179(String var1, String var2, int var3) {
      this.field2669 = var1;
      this.field2667 = var3;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int vmethod4062() {
      return this.field2667;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1976327063"
   )
   public static void method3256() {
      Object var0 = class183.field2706;
      Object var1 = class183.field2706;
      synchronized(class183.field2706) {
         if(class183.field2704 != 0) {
            class183.field2704 = 1;

            try {
               class183.field2706.wait();
            } catch (InterruptedException var4) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "16"
   )
   static final void method3257(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class174.field2619[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][1 + var5][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }
}
