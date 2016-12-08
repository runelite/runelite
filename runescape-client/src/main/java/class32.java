import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class32 {
   @ObfuscatedName("h")
   static int[] field726 = new int[5];
   @ObfuscatedName("c")
   @Export("chatboxSegments")
   static String[] chatboxSegments = new String[1000];
   @ObfuscatedName("f")
   static final String[] field729 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("g")
   static String[] field731;
   @ObfuscatedName("l")
   static int[] field732 = new int[1000];
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -977735643
   )
   static int field733 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 387154545
   )
   static int field734 = 0;
   @ObfuscatedName("k")
   static class11[] field735 = new class11[50];
   @ObfuscatedName("y")
   static Widget field736;
   @ObfuscatedName("j")
   static Calendar field737 = Calendar.getInstance();
   @ObfuscatedName("v")
   static int[][] field738 = new int[5][5000];
   @ObfuscatedName("b")
   static int[] field739;
   @ObfuscatedName("eg")
   static SpritePixels[] field740;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1847200912"
   )
   static final void method668(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var2 + var0; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class10.field80[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][1 + var5][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][1 + var4];
               }
            }
         }
      }

   }
}
