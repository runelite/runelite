import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.math.BigInteger;

@ObfuscatedName("cs")
public class class89 {
   @ObfuscatedName("a")
   static final BigInteger field1303;
   @ObfuscatedName("w")
   static final BigInteger field1301;
   @ObfuscatedName("ak")
   static int[] field1302;

   static {
      field1303 = new BigInteger("10001", 16);
      field1301 = new BigInteger("d37352e6594218ca32e9324ea325fae348313b095f68a7edb308c4f8cbbf855adac2dff9dadf1e3f5a517766b8ef02c3630d3872b44775a2da59a6b9dbfd3c783ec612dd3d2a6dfc80a7abd9c4a52a6c75d48283813bf057875ba3851078020abc55bd0114d124f058ff3dfa75d22fa5de1893ec0120f622df390a7e6a23fc5b", 16);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lis;",
      garbageValue = "-941995943"
   )
   public static InvType method1665(int var0) {
      InvType var1 = (InvType)InvType.inventoryCache.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = InvType.field3371.getConfigData(5, var0);
         var1 = new InvType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         InvType.inventoryCache.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lib;Lib;IIB)Ljm;",
      garbageValue = "-107"
   )
   @Export("loadFont")
   public static Font loadFont(IndexDataBase var0, IndexDataBase var1, int var2, int var3) {
      if(!Parameters.spriteDataValid(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.getConfigData(var2, var3);
         Font var4;
         if(var5 == null) {
            var4 = null;
         } else {
            Font var6 = new Font(var5, class299.field3867, class299.offsetsY, Item.field1387, class276.field3727, FaceNormal.field2025, Bounds.spritePixels);
            ContextMenuRow.resetCachedStaticSpriteData();
            var4 = var6;
         }

         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "585277700"
   )
   static final void method1664(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2784(var0, var1, var2);
      int[] var8 = Region.method2784(var3, var4, var5);
      Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(Lhz;IIZI)V",
      garbageValue = "-13607508"
   )
   static void method1666(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2766 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2766 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2766 == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.buttonType == 0) {
         var0.height = var0.field2817;
      } else if(var0.buttonType == 1) {
         var0.height = var2 - var0.field2817;
      } else if(var0.buttonType == 2) {
         var0.height = var2 * var0.field2817 >> 14;
      }

      if(var0.field2766 == 4) {
         var0.width = var0.height * var0.field2776 / var0.field2777;
      }

      if(var0.buttonType == 4) {
         var0.height = var0.field2777 * var0.width / var0.field2776;
      }

      if(Client.field978 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field1000 = var0;
      }

      if(var3 && var0.field2868 != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.objs = var0.field2868;
         Client.field1027.addFront(var6);
      }

   }
}
