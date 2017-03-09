import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public final class class10 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1360477017
   )
   static int field105 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("l")
   static int[] field106;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1429338143
   )
   static int field107 = 99;
   @ObfuscatedName("n")
   static final int[] field109 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("d")
   @Export("underlayIds")
   static byte[][][] underlayIds;
   @ObfuscatedName("k")
   static byte[][][] field111;
   @ObfuscatedName("g")
   static int[][] field112;
   @ObfuscatedName("h")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;
   @ObfuscatedName("b")
   static final int[] field117 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("t")
   static final int[] field118 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("y")
   static int[] field119;
   @ObfuscatedName("p")
   static final int[] field120 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -826885703
   )
   static int field121 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("j")
   @Export("tileSettings")
   static byte[][][] tileSettings = new byte[4][104][104];
   @ObfuscatedName("z")
   static final int[] field123 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      intValue = 929668455
   )
   static int field126;
   @ObfuscatedName("f")
   static final int[] field127 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("w")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("ey")
   static SpritePixels[] field129;
   @ObfuscatedName("x")
   @Export("tileHeights")
   static int[][][] tileHeights = new int[4][105][105];

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "5"
   )
   static int method115(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = World.method670(class32.field756[--class32.field752]);
      } else {
         var3 = var2?class26.field624:class32.field754;
      }

      if(var0 == 1927) {
         if(class32.field759 >= 10) {
            throw new RuntimeException();
         } else if(null == var3.field2295) {
            return 0;
         } else {
            class18 var4 = new class18();
            var4.field223 = var3;
            var4.field232 = var3.field2295;
            var4.field231 = class32.field759 + 1;
            Client.field512.method2458(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   class10() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "563376909"
   )
   static void method167() {
      XItemContainer.itemContainers = new XHashTable(32);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-128730151"
   )
   static final boolean method168(int var0, int var1) {
      ObjectComposition var2 = class195.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method3614(var1);
   }
}
