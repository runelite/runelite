import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public final class class5 {
   @ObfuscatedName("w")
   static int[] field65;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 741612033
   )
   static int field66 = 99;
   @ObfuscatedName("p")
   static byte[][][] field67;
   @ObfuscatedName("g")
   static byte[][][] field69;
   @ObfuscatedName("h")
   static int[] field70;
   @ObfuscatedName("l")
   static final int[] field71 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("n")
   static int[] field72;
   @ObfuscatedName("o")
   static final int[] field74 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("i")
   static final int[] field76 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("x")
   static final int[] field77 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("v")
   static final int[] field78 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("z")
   @Export("tileSettings")
   static byte[][][] tileSettings = new byte[4][104][104];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -36371017
   )
   static int field80 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 606204411
   )
   static int field81 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("s")
   @Export("tileHeights")
   static int[][][] tileHeights = new int[4][105][105];
   @ObfuscatedName("c")
   static final int[] field84 = new int[]{16, 32, 64, 128};

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-1763049215"
   )
   static final void method52(Widget var0, int var1, int var2) {
      if(null == Client.field441 && !Client.isMenuOpen) {
         if(null != var0) {
            Widget var4 = class35.method730(var0);
            if(var4 == null) {
               var4 = var0.parent;
            }

            if(var4 != null) {
               Client.field441 = var0;
               var4 = class35.method730(var0);
               if(null == var4) {
                  var4 = var0.parent;
               }

               Client.field391 = var4;
               Client.field280 = var1;
               Client.field444 = var2;
               class155.field2311 = 0;
               Client.field473 = false;
               if(Client.menuOptionCount > 0) {
                  class179.method3455(Client.menuOptionCount - 1);
               }

               return;
            }
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lclass171;",
      garbageValue = "1446857719"
   )
   static class171 method63(int var0, boolean var1, boolean var2, boolean var3) {
      class137 var4 = null;
      if(null != class152.field2279) {
         var4 = new class137(var0, class152.field2279, class152.field2271[var0], 1000000);
      }

      return new class171(var4, class10.field159, var0, var1, var2, var3);
   }
}
