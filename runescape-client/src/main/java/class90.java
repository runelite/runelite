import java.awt.Component;
import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
public class class90 {
   @ObfuscatedName("d")
   @Export("rsaKeyExponent")
   static final BigInteger rsaKeyExponent;
   @ObfuscatedName("q")
   @Export("rsaKeyModulus")
   static final BigInteger rsaKeyModulus;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1897650325
   )
   static int field1377;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljw;"
   )
   static IndexedSprite field1378;

   static {
      rsaKeyExponent = new BigInteger("10001", 16);
      rsaKeyModulus = new BigInteger("9f57be50a31c006ac9c2326fe4a42574c49a5d1dce4bee5bceec2c95aee831eea1c0986a60a0ed7ca7a013dd4a08e76f51072037cd743ffa5564630067000020993214e568c7928b320cb91bd6b921b35ebedf9041f7bb2cf64381b0e3bd712b7c58d202834b9dd2f263a13c085ebd6c329c665ce8d3abf5e5c8f33d01659817", 16);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "96"
   )
   static void method1719(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(KeyFocusListener.keyboard);
      var0.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-110"
   )
   public static int method1720(int var0) {
      Varbit var1 = Actor.method1533(var0);
      int var2 = var1.configId;
      int var3 = var1.leastSignificantBit;
      int var4 = var1.mostSignificantBit;
      int var5 = class211.field2582[var4 - var3];
      return class211.widgetSettings[var2] >> var3 & var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)[Lid;",
      garbageValue = "1340147906"
   )
   static class257[] method1721() {
      return new class257[]{class257.field3525, class257.field3527, class257.field3523};
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1608975995"
   )
   static final void method1718() {
      short var0 = 256;
      int var1;
      if(class92.field1403 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class92.field1403 > 768) {
               class60.field719[var1] = class7.method38(ISAACCipher.field2404[var1], WorldMapData.field433[var1], 1024 - class92.field1403);
            } else if(class92.field1403 > 256) {
               class60.field719[var1] = WorldMapData.field433[var1];
            } else {
               class60.field719[var1] = class7.method38(WorldMapData.field433[var1], ISAACCipher.field2404[var1], 256 - class92.field1403);
            }
         }
      } else if(class92.field1402 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class92.field1402 > 768) {
               class60.field719[var1] = class7.method38(ISAACCipher.field2404[var1], class47.field566[var1], 1024 - class92.field1402);
            } else if(class92.field1402 > 256) {
               class60.field719[var1] = class47.field566[var1];
            } else {
               class60.field719[var1] = class7.method38(class47.field566[var1], ISAACCipher.field2404[var1], 256 - class92.field1402);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class60.field719[var1] = ISAACCipher.field2404[var1];
         }
      }

      Rasterizer2D.setDrawRegion(class92.field1416, 9, class92.field1416 + 128, var0 + 7);
      class92.field1411.method5067(class92.field1416, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      int var2 = class48.field582.width * 9 + class92.field1416;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class92.field1427[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = XClanMember.field889[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class60.field719[var7];
               var10 = class48.field582.pixels[var2];
               class48.field582.pixels[var2++] = (var9 * (var10 & 16711935) + var8 * (var7 & 16711935) & -16711936) + (var9 * (var10 & '\uff00') + var8 * (var7 & '\uff00') & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class48.field582.width - 128;
      }

      Rasterizer2D.setDrawRegion(class92.field1416 + 765 - 128, 9, class92.field1416 + 765, var0 + 7);
      class92.field1399.method5067(class92.field1416 + 382, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      var2 = class48.field582.width * 9 + 24 + 637 + class92.field1416;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class92.field1427[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = XClanMember.field889[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class60.field719[var7];
               var10 = class48.field582.pixels[var2];
               class48.field582.pixels[var2++] = (var9 * (var10 & '\uff00') + var8 * (var7 & '\uff00') & 16711680) + (var9 * (var10 & 16711935) + var8 * (var7 & 16711935) & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class48.field582.width - var5 - var4;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIZIZB)V",
      garbageValue = "16"
   )
   static void method1722(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = World.worldList[var9];
            int var12 = class28.method235(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = class28.method235(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var14;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method1722(var0, var7 - 1, var2, var3, var4, var5);
         method1722(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
