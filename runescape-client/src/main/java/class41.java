import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class41 extends class204 {
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = -398584821
   )
   protected static int field966;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -177653715
   )
   int field967 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1597594349
   )
   public int field968;
   @ObfuscatedName("l")
   @Export("worldServersDownload")
   static class18 field969;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 985584155
   )
   public int field970;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1069515977
   )
   public int field973;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1156573283
   )
   public int field974;
   @ObfuscatedName("i")
   public static class193 field977 = new class193(64);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass119;III)V",
      garbageValue = "-553601530"
   )
   void method833(class119 var1, int var2, int var3) {
      if(var2 == 1) {
         this.field967 = var1.method2472();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "29"
   )
   void method834(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field974 = (int)(256.0D * var14);
      this.field970 = (int)(var16 * 256.0D);
      if(this.field974 < 0) {
         this.field974 = 0;
      } else if(this.field974 > 255) {
         this.field974 = 255;
      }

      if(this.field970 < 0) {
         this.field970 = 0;
      } else if(this.field970 > 255) {
         this.field970 = 255;
      }

      if(var16 > 0.5D) {
         this.field973 = (int)(512.0D * var14 * (1.0D - var16));
      } else {
         this.field973 = (int)(var14 * var16 * 512.0D);
      }

      if(this.field973 < 1) {
         this.field973 = 1;
      }

      this.field968 = (int)((double)this.field973 * var12);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-1128315014"
   )
   void method836(class119 var1, int var2) {
      while(true) {
         int var3 = var1.method2494();
         if(var3 == 0) {
            return;
         }

         this.method833(var1, var3, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass167;B)V",
      garbageValue = "112"
   )
   public static void method840(class167 var0) {
      class218.field3169 = var0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1816532817"
   )
   void method846() {
      this.method834(this.field967);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-54962449"
   )
   static void method847(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         class25 var8 = class25.field636[var6];
         class25.field636[var6] = class25.field636[var1];
         class25.field636[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class76.method1636(class25.field636[var9], var8, var2, var3, var4, var5) <= 0) {
               class25 var10 = class25.field636[var9];
               class25.field636[var9] = class25.field636[var7];
               class25.field636[var7++] = var10;
            }
         }

         class25.field636[var1] = class25.field636[var7];
         class25.field636[var7] = var8;
         method847(var0, var7 - 1, var2, var3, var4, var5);
         method847(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
