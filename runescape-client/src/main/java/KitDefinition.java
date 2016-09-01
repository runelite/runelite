import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1419489183
   )
   public int field1033 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1471674701
   )
   public static int field1034;
   @ObfuscatedName("z")
   public static NodeCache field1035 = new NodeCache(64);
   @ObfuscatedName("x")
   static class170 field1036;
   @ObfuscatedName("b")
   int[] field1037;
   @ObfuscatedName("r")
   static class170 field1038;
   @ObfuscatedName("m")
   short[] field1039;
   @ObfuscatedName("p")
   short[] field1040;
   @ObfuscatedName("f")
   short[] field1041;
   @ObfuscatedName("d")
   int[] field1042 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("v")
   public boolean field1043 = false;
   @ObfuscatedName("l")
   short[] field1044;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "115484426"
   )
   void method923(Buffer var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method938(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "2"
   )
   @Export("ready")
   public boolean ready() {
      if(null == this.field1037) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1037.length; ++var2) {
            if(!field1038.method3292(this.field1037[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-638510284"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.field1037 == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.field1037.length];

         for(int var2 = 0; var2 < this.field1037.length; ++var2) {
            var1[var2] = ModelData.method2262(field1038, this.field1037[var2], 0);
         }

         ModelData var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new ModelData(var1, var1.length);
         }

         int var3;
         if(null != this.field1044) {
            for(var3 = 0; var3 < this.field1044.length; ++var3) {
               var4.method2337(this.field1044[var3], this.field1039[var3]);
            }
         }

         if(this.field1040 != null) {
            for(var3 = 0; var3 < this.field1040.length; ++var3) {
               var4.method2276(this.field1040[var3], this.field1041[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2141450732"
   )
   public boolean method927() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field1042[var2] != -1 && !field1038.method3292(this.field1042[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "2081907367"
   )
   public ModelData method932() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field1042[var3] != -1) {
            var1[var2++] = ModelData.method2262(field1038, this.field1042[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(this.field1044 != null) {
         for(var4 = 0; var4 < this.field1044.length; ++var4) {
            var5.method2337(this.field1044[var4], this.field1039[var4]);
         }
      }

      if(null != this.field1040) {
         for(var4 = 0; var4 < this.field1040.length; ++var4) {
            var5.method2276(this.field1040[var4], this.field1041[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-5"
   )
   static final int method936(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class5.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class5.tileHeights[var5][var3][var4] + var6 * class5.tileHeights[var5][var3 + 1][var4] >> 7;
         int var9 = class5.tileHeights[var5][var3][var4 + 1] * (128 - var6) + class5.tileHeights[var5][1 + var3][var4 + 1] * var6 >> 7;
         return (128 - var7) * var8 + var7 * var9 >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "5"
   )
   void method938(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1033 = var1.method2556();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.method2556();
            this.field1037 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1037[var4] = var1.method2551();
            }
         } else if(var2 == 3) {
            this.field1043 = true;
         } else if(var2 == 40) {
            var3 = var1.method2556();
            this.field1044 = new short[var3];
            this.field1039 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1044[var4] = (short)var1.method2551();
               this.field1039[var4] = (short)var1.method2551();
            }
         } else if(var2 == 41) {
            var3 = var1.method2556();
            this.field1040 = new short[var3];
            this.field1041 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1040[var4] = (short)var1.method2551();
               this.field1041[var4] = (short)var1.method2551();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1042[var2 - 60] = var1.method2551();
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "84"
   )
   static final void method941(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = class158.field2347.method4040(var0, 250);
      int var6 = class158.field2347.method4041(var0, 250) * 13;
      class82.method1831(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 0);
      class82.method1837(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 16777215);
      class158.field2347.method4100(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class124.method2815(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6);
      if(var1) {
         try {
            Graphics var7 = class129.canvas.getGraphics();
            class40.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var13) {
            class129.canvas.repaint();
         }
      } else {
         int var12 = var3;
         int var8 = var4;
         int var9 = var5;
         int var10 = var6;

         for(int var11 = 0; var11 < Client.field547; ++var11) {
            if(Client.widgetBoundsWidth[var11] + Client.widgetPositionX[var11] > var12 && Client.widgetPositionX[var11] < var12 + var9 && Client.widgetPositionY[var11] + Client.widgetBoundsHeight[var11] > var8 && Client.widgetPositionY[var11] < var10 + var8) {
               Client.field485[var11] = true;
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "35421301"
   )
   public static void method948() {
      class56.field1210.reset();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1826368776"
   )
   static final int method949(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
