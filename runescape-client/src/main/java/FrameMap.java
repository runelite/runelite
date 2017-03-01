import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1845793197
   )
   int field1470;
   @ObfuscatedName("g")
   int[] field1471;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 401613847
   )
   int field1472;
   @ObfuscatedName("v")
   int[][] field1473;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "667809384"
   )
   static int method1786(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = ChatLineBuffer.method993(class32.field726[--class32.field735]);
      } else {
         var3 = var2?class32.field731:class108.field1738;
      }

      if(var0 == 1927) {
         if(class32.field730 >= 10) {
            throw new RuntimeException();
         } else if(null == var3.field2315) {
            return 0;
         } else {
            class18 var4 = new class18();
            var4.field188 = var3;
            var4.field196 = var3.field2315;
            var4.field187 = 1 + class32.field730;
            Client.field488.method2511(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   FrameMap(int var1, byte[] var2) {
      this.field1470 = var1;
      Buffer var3 = new Buffer(var2);
      this.field1472 = var3.readUnsignedByte();
      this.field1471 = new int[this.field1472];
      this.field1473 = new int[this.field1472][];

      int var4;
      for(var4 = 0; var4 < this.field1472; ++var4) {
         this.field1471[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.field1472; ++var4) {
         this.field1473[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.field1472; ++var4) {
         for(int var5 = 0; var5 < this.field1473[var4].length; ++var5) {
            this.field1473[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LModIcon;I)V",
      garbageValue = "1212315845"
   )
   static final void method1787(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class185.field2768.length; ++var2) {
         class185.field2768[var2] = 0;
      }

      int var8;
      for(var2 = 0; var2 < 5000; ++var2) {
         var8 = (int)(Math.random() * 128.0D * (double)var1);
         class185.field2768[var8] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var8 = 1; var8 < var1 - 1; ++var8) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = (var8 << 7) + var4;
               XGrandExchangeOffer.field34[var5] = (class185.field2768[1 + var5] + class185.field2768[var5 - 1] + class185.field2768[var5 - 128] + class185.field2768[var5 + 128]) / 4;
            }
         }

         int[] var3 = class185.field2768;
         class185.field2768 = XGrandExchangeOffer.field34;
         XGrandExchangeOffer.field34 = var3;
      }

      if(var0 != null) {
         var2 = 0;

         for(var8 = 0; var8 < var0.height; ++var8) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var0.offsetX + var4 + 16;
                  int var6 = var0.offsetY + 16 + var8;
                  int var7 = (var6 << 7) + var5;
                  class185.field2768[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1126040227"
   )
   static final int method1788(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }
}
