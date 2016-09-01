import java.awt.Canvas;
import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
public class class77 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1437760237
   )
   int field1406;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 372861813
   )
   int field1407;
   @ObfuscatedName("b")
   int[][] field1408;
   @ObfuscatedName("eu")
   static SpritePixels field1412;

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1161991416"
   )
   static void method1624() {
      Client var0 = Client.field377;
      synchronized(Client.field377) {
         Container var1 = Client.field377.method3079();
         if(var1 != null) {
            class47.field1050 = Math.max(var1.getSize().width, ObjectComposition.field935);
            class112.field1970 = Math.max(var1.getSize().height, ItemLayer.field1738);
            if(FaceNormal.field1496 == var1) {
               Insets var2 = FaceNormal.field1496.getInsets();
               class47.field1050 -= var2.left + var2.right;
               class112.field1970 -= var2.top + var2.bottom;
            }

            if(class47.field1050 <= 0) {
               class47.field1050 = 1;
            }

            if(class112.field1970 <= 0) {
               class112.field1970 = 1;
            }

            if(class92.method2124() == 1) {
               FaceNormal.field1499 = Client.field333;
               class212.field3175 = Client.field495 * 503;
            } else {
               FaceNormal.field1499 = Math.min(class47.field1050, 7680);
               class212.field3175 = Math.min(class112.field1970, 2160);
            }

            GameEngine.field2255 = (class47.field1050 - FaceNormal.field1499) / 2;
            GameEngine.field2256 = 0;
            class129.canvas.setSize(FaceNormal.field1499, class212.field3175);
            int var3 = FaceNormal.field1499;
            int var4 = class212.field3175;
            Canvas var5 = class129.canvas;

            Object var16;
            try {
               MainBufferProvider var6 = new MainBufferProvider();
               var6.init(var3, var4, var5);
               var16 = var6;
            } catch (Throwable var14) {
               SecondaryBufferProvider var7 = new SecondaryBufferProvider();
               var7.init(var3, var4, var5);
               var16 = var7;
            }

            class40.bufferProvider = (BufferProvider)var16;
            if(var1 == FaceNormal.field1496) {
               Insets var17 = FaceNormal.field1496.getInsets();
               class129.canvas.setLocation(GameEngine.field2255 + var17.left, GameEngine.field2256 + var17.top);
            } else {
               class129.canvas.setLocation(GameEngine.field2255, GameEngine.field2256);
            }

            int var10 = FaceNormal.field1499;
            int var11 = class212.field3175;
            if(class47.field1050 < var10) {
               var10 = class47.field1050;
            }

            if(class112.field1970 < var11) {
               var11 = class112.field1970;
            }

            if(null != class161.field2659) {
               try {
                  class135.method2898(Client.field377, "resize", new Object[]{Integer.valueOf(class92.method2124())});
               } catch (Throwable var13) {
                  ;
               }
            }

            if(Client.widgetRoot != -1) {
               var10 = Client.widgetRoot;
               var11 = FaceNormal.field1499;
               int var12 = class212.field3175;
               if(class175.method3419(var10)) {
                  Client.method353(Widget.widgets[var10], -1, var11, var12, true);
               }
            }

            WallObject.method2122();
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "2"
   )
   byte[] method1625(byte[] var1) {
      if(this.field1408 != null) {
         int var2 = (int)((long)this.field1407 * (long)var1.length / (long)this.field1406) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1408[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var7 * var8[var9];
            }

            var5 += this.field1407;
            var9 = var5 / this.field1406;
            var4 += var9;
            var5 -= var9 * this.field1406;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = '耀' + var3[var6] >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   public class77(int var1, int var2) {
      if(var1 != var2) {
         int var4 = var1;
         int var5 = var2;
         if(var2 > var1) {
            var4 = var2;
            var5 = var1;
         }

         while(var5 != 0) {
            int var6 = var4 % var5;
            var4 = var5;
            var5 = var6;
         }

         var1 /= var4;
         var2 /= var4;
         this.field1406 = var1;
         this.field1407 = var2;
         this.field1408 = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.field1408[var7];
            double var9 = (double)var7 / (double)var1 + 6.0D;
            int var11 = (int)Math.floor(var9 - 7.0D + 1.0D);
            if(var11 < 0) {
               var11 = 0;
            }

            int var12 = (int)Math.ceil(var9 + 7.0D);
            if(var12 > 14) {
               var12 = 14;
            }

            for(double var13 = (double)var2 / (double)var1; var11 < var12; ++var11) {
               double var15 = ((double)var11 - var9) * 3.141592653589793D;
               double var17 = var13;
               if(var15 < -1.0E-4D || var15 > 1.0E-4D) {
                  var17 = var13 * (Math.sin(var15) / var15);
               }

               var17 *= 0.54D + 0.46D * Math.cos(((double)var11 - var9) * 0.2243994752564138D);
               var8[var11] = (int)Math.floor(65536.0D * var17 + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1986782927"
   )
   int method1629(int var1) {
      if(this.field1408 != null) {
         var1 = 6 + (int)((long)this.field1407 * (long)var1 / (long)this.field1406);
      }

      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Lclass43;",
      garbageValue = "927269366"
   )
   public static class43 method1635(int var0) {
      class43 var1 = (class43)class43.field978.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class43.field982.method3290(1, var0);
         var1 = new class43();
         if(var2 != null) {
            var1.method850(new Buffer(var2), var0);
         }

         var1.method843();
         class43.field978.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "-80"
   )
   public static int method1636(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class31.method663(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "10484"
   )
   public static int method1637(int var0) {
      return var0 >> 11 & 63;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2137765201"
   )
   int method1638(int var1) {
      if(this.field1408 != null) {
         var1 = (int)((long)this.field1407 * (long)var1 / (long)this.field1406);
      }

      return var1;
   }
}
