import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public final class class5 {
   @ObfuscatedName("h")
   @Export("tileSettings")
   static byte[][][] field84 = new byte[4][104][104];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -976831173
   )
   static int field85 = 99;
   @ObfuscatedName("au")
   static int[] field86;
   @ObfuscatedName("x")
   static byte[][][] field87;
   @ObfuscatedName("i")
   static byte[][][] field88;
   @ObfuscatedName("n")
   static int[][] field89;
   @ObfuscatedName("u")
   static int[] field90;
   @ObfuscatedName("j")
   @Export("tileHeights")
   static int[][][] field91 = new int[4][105][105];
   @ObfuscatedName("y")
   static final int[] field92 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("w")
   static final int[] field93 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("g")
   static final int[] field94 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("s")
   static final int[] field95 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("k")
   static final int[] field96 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("o")
   static final int[] field97 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -720219139
   )
   static int field98 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -632058959
   )
   static int field99 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("z")
   static byte[][][] field100;
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = 1761871377
   )
   public static int field102;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "-210861940"
   )
   static final void method41(class122 var0) {
      var0.method2736();
      int var1 = client.field397;
      class2 var2 = class47.field1053 = client.field396[var1] = new class2();
      var2.field52 = var1;
      int var3 = var0.method2737(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.field848[0] = var5 - class187.field3014;
      var2.field816 = (var2.field848[0] << 7) + (var2.method10() << 6);
      var2.field822[0] = var6 - class0.field12;
      var2.field840 = (var2.field822[0] << 7) + (var2.method10() << 6);
      class28.field655 = var2.field57 = var4;
      if(null != class32.field736[var1]) {
         var2.method8(class32.field736[var1]);
      }

      class32.field737 = 0;
      class32.field738[++class32.field737 - 1] = var1;
      class32.field734[var1] = 0;
      class32.field739 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.method2737(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class32.field741[var7] = var11 + (var9 << 28) + (var10 << 14);
            class32.field742[var7] = 0;
            class32.field743[var7] = -1;
            class32.field740[++class32.field739 - 1] = var7;
            class32.field734[var7] = 0;
         }
      }

      var0.method2733();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1593392392"
   )
   public static void method69(boolean var0) {
      if(class226.field3216 != null) {
         try {
            class119 var1 = new class119(4);
            var1.method2503(var0?2:3);
            var1.method2487(0);
            class226.field3216.method2967(var1.field1973, 0, 4);
         } catch (IOException var4) {
            try {
               class226.field3216.method2964();
            } catch (Exception var3) {
               ;
            }

            ++class171.field2725;
            class226.field3216 = null;
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "2141341955"
   )
   static final int method86(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var0 / 4 << 10) + (var1 / 32 << 7) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "30"
   )
   public static void method88() {
      class211.field3140 = new class202();
   }
}
