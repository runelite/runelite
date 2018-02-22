import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class56 {
   @ObfuscatedName("b")
   public static Applet field612;
   @ObfuscatedName("q")
   public static String field616;
   @ObfuscatedName("s")
   static int[][][] field619;
   @ObfuscatedName("aj")
   static java.awt.Font field613;

   static {
      field612 = null;
      field616 = "";
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIB)I",
      garbageValue = "56"
   )
   public static int method842(byte[] var0, int var1) {
      return class25.method201(var0, 0, var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "23971577"
   )
   public static void method845(int var0) {
      if(var0 != -1) {
         if(class89.validInterfaces[var0]) {
            class154.widgetIndex.method4552(var0);
            if(Widget.widgets[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
                  if(Widget.widgets[var0][var2] != null) {
                     if(Widget.widgets[var0][var2].type != 2) {
                        Widget.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  Widget.widgets[var0] = null;
               }

               class89.validInterfaces[var0] = false;
            }
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)[Llm;",
      garbageValue = "1844858013"
   )
   static SpritePixels[] method844() {
      SpritePixels[] var0 = new SpritePixels[class323.field3916];

      for(int var1 = 0; var1 < class323.field3916; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.maxWidth = class323.field3913;
         var2.maxHeight = class323.field3915;
         var2.offsetX = TotalQuantityComparator.field281[var1];
         var2.offsetY = FileSystem.offsetsY[var1];
         var2.width = BaseVarType.field28[var1];
         var2.height = GroundObject.field1751[var1];
         int var3 = var2.height * var2.width;
         byte[] var4 = class323.spritePixels[var1];
         var2.pixels = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.pixels[var5] = class323.field3912[var4[var5] & 255];
         }
      }

      class152.method3133();
      return var0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "23"
   )
   static final void method834() {
      short var0 = 256;
      int var1;
      if(class89.field1330 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class89.field1330 > 768) {
               ChatLineBuffer.field1429[var1] = Parameters.method5597(class28.field385[var1], class153.field2093[var1], 1024 - class89.field1330);
            } else if(class89.field1330 > 256) {
               ChatLineBuffer.field1429[var1] = class153.field2093[var1];
            } else {
               ChatLineBuffer.field1429[var1] = Parameters.method5597(class153.field2093[var1], class28.field385[var1], 256 - class89.field1330);
            }
         }
      } else if(class89.field1306 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class89.field1306 > 768) {
               ChatLineBuffer.field1429[var1] = Parameters.method5597(class28.field385[var1], class27.field370[var1], 1024 - class89.field1306);
            } else if(class89.field1306 > 256) {
               ChatLineBuffer.field1429[var1] = class27.field370[var1];
            } else {
               ChatLineBuffer.field1429[var1] = Parameters.method5597(class27.field370[var1], class28.field385[var1], 256 - class89.field1306);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            ChatLineBuffer.field1429[var1] = class28.field385[var1];
         }
      }

      Rasterizer2D.setDrawRegion(class89.field1324, 9, class89.field1324 + 128, var0 + 7);
      class234.field2759.method5809(class89.field1324, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      int var2 = class324.rasterProvider.width * 9 + class89.field1324;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class89.field1304[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class89.field1307[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = ChatLineBuffer.field1429[var7];
               var10 = class324.rasterProvider.pixels[var2];
               class324.rasterProvider.pixels[var2++] = (var9 * (var10 & 65280) + var8 * (var7 & 65280) & 16711680) + ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class324.rasterProvider.width - 128;
      }

      Rasterizer2D.setDrawRegion(class89.field1324 + 765 - 128, 9, class89.field1324 + 765, var0 + 7);
      class305.field3806.method5809(class89.field1324 + 382, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      var2 = class324.rasterProvider.width * 9 + class89.field1324 + 637 + 24;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class89.field1304[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class89.field1307[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = ChatLineBuffer.field1429[var7];
               var10 = class324.rasterProvider.pixels[var2];
               class324.rasterProvider.pixels[var2++] = ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) + (var8 * (var7 & 65280) + var9 * (var10 & 65280) & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class324.rasterProvider.width - var5 - var4;
      }

   }
}
