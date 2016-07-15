import java.awt.Frame;
import java.io.IOException;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
@Implements("FrameMap")
public class class105 extends class211 {
   @ObfuscatedName("lf")
   static class133 field1835;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 884267755
   )
   int field1836;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -330526845
   )
   int field1837;
   @ObfuscatedName("h")
   int[][] field1838;
   @ObfuscatedName("c")
   int[] field1843;
   @ObfuscatedName("ql")
   protected static Frame field1845;

   class105(int var1, byte[] var2) {
      this.field1837 = var1;
      class122 var3 = new class122(var2);
      this.field1836 = var3.method2610();
      this.field1843 = new int[this.field1836];
      this.field1838 = new int[this.field1836][];

      int var4;
      for(var4 = 0; var4 < this.field1836; ++var4) {
         this.field1843[var4] = var3.method2610();
      }

      for(var4 = 0; var4 < this.field1836; ++var4) {
         this.field1838[var4] = new int[var3.method2610()];
      }

      for(var4 = 0; var4 < this.field1836; ++var4) {
         for(int var5 = 0; var5 < this.field1838[var4].length; ++var5) {
            this.field1838[var4][var5] = var3.method2610();
         }
      }

   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-805317193"
   )
   static final void method2369(boolean var0) {
      class110.method2469();
      ++client.field342;
      if(client.field342 >= 50 || var0) {
         client.field342 = 0;
         if(!client.field553 && class8.field150 != null) {
            client.field336.method2854(35);

            try {
               class8.field150.method3083(client.field336.field2054, 0, client.field336.field2061);
               client.field336.field2061 = 0;
            } catch (IOException var2) {
               client.field553 = true;
            }
         }

      }
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-111"
   )
   static final int method2370(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class5.field89[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = class5.field78[var5][var3][var4] * (128 - var6) + var6 * class5.field78[var5][var3 + 1][var4] >> 7;
         int var9 = var6 * class5.field78[var5][1 + var3][1 + var4] + class5.field78[var5][var3][1 + var4] * (128 - var6) >> 7;
         return var8 * (128 - var7) + var9 * var7 >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "22"
   )
   public static void method2371() {
      class43.field1008.method3835();
   }
}
