import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class171 {
   class171() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1811078532"
   )
   static final void method3265() {
      short var0 = 256;
      int var1;
      if(class41.field858 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class41.field858 > 768) {
               class7.field71[var1] = class32.method752(class8.field83[var1], class176.field2648[var1], 1024 - class41.field858);
            } else if(class41.field858 > 256) {
               class7.field71[var1] = class176.field2648[var1];
            } else {
               class7.field71[var1] = class32.method752(class176.field2648[var1], class8.field83[var1], 256 - class41.field858);
            }
         }
      } else if(class41.field845 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class41.field845 > 768) {
               class7.field71[var1] = class32.method752(class8.field83[var1], class41.field857[var1], 1024 - class41.field845);
            } else if(class41.field845 > 256) {
               class7.field71[var1] = class41.field857[var1];
            } else {
               class7.field71[var1] = class32.method752(class41.field857[var1], class8.field83[var1], 256 - class41.field845);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class7.field71[var1] = class8.field83[var1];
         }
      }

      Rasterizer2D.method4016(class41.field846, 9, 128 + class41.field846, 7 + var0);
      class41.field880.method4147(class41.field846, 0);
      Rasterizer2D.method3997();
      var1 = 0;
      int var2 = Frames.bufferProvider.width * 9 + class41.field846;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class41.field859[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = XGrandExchangeOffer.field48[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class7.field71[var7];
               var10 = Frames.bufferProvider.pixels[var2];
               Frames.bufferProvider.pixels[var2++] = ((var10 & 16711935) * var9 + var8 * (var7 & 16711935) & -16711936) + ((var10 & '\uff00') * var9 + (var7 & '\uff00') * var8 & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + Frames.bufferProvider.width - 128;
      }

      Rasterizer2D.method4016(765 + class41.field846 - 128, 9, 765 + class41.field846, 7 + var0);
      class41.field850.method4147(class41.field846 + 382, 0);
      Rasterizer2D.method3997();
      var1 = 0;
      var2 = 637 + 24 + Frames.bufferProvider.width * 9 + class41.field846;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = (var0 - var3) * class41.field859[var3] / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = XGrandExchangeOffer.field48[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class7.field71[var7];
               var10 = Frames.bufferProvider.pixels[var2];
               Frames.bufferProvider.pixels[var2++] = (var8 * (var7 & 16711935) + var9 * (var10 & 16711935) & -16711936) + (var8 * (var7 & '\uff00') + var9 * (var10 & '\uff00') & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += Frames.bufferProvider.width - var5 - var4;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Lclass196;",
      garbageValue = "2143775501"
   )
   public static class196 method3266(int var0) {
      class196 var1 = (class196)class196.field2867.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class196.field2883.getConfigData(32, var0);
         var1 = new class196();
         if(var2 != null) {
            var1.method3583(new Buffer(var2));
         }

         class196.field2867.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "-1650535008"
   )
   static void method3267(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class114.field1794.startsWith("win") && !var3) {
            class150.method2802(var0, 0, "openjs");
            return;
         }

         if(class114.field1794.startsWith("mac")) {
            class150.method2802(var0, 1, var2);
            return;
         }

         class150.method2802(var0, 2, "openjs");
      } else {
         class150.method2802(var0, 3, "openjs");
      }

   }
}
