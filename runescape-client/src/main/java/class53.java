import java.awt.Image;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
public class class53 extends CacheableNode {
   @ObfuscatedName("x")
   public static class170 field1133;
   @ObfuscatedName("r")
   public static NodeCache field1134 = new NodeCache(64);
   @ObfuscatedName("j")
   public boolean field1135 = false;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      longValue = 2943502760163033495L
   )
   static long field1137;
   @ObfuscatedName("qi")
   protected static Image field1138;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = 909210597
   )
   @Export("cameraPitch")
   static int cameraPitch;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1574713489"
   )
   public void method1072(Buffer var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method1078(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;ZI)V",
      garbageValue = "1506282554"
   )
   public static void method1073(class170 var0, class170 var1, boolean var2) {
      ObjectComposition.field924 = var0;
      class180.field2962 = var1;
      ObjectComposition.field954 = var2;
   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1726257027"
   )
   static void method1077(String var0) {
      class40.field878 = var0;

      try {
         String var1 = Client.field377.getParameter(class193.field3121.field3110);
         String var2 = Client.field377.getParameter(class193.field3116.field3110);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            String var4 = var3 + "; Expires=";
            long var6 = class34.method713() + 94608000000L;
            class114.field2013.setTime(new Date(var6));
            int var8 = class114.field2013.get(7);
            int var9 = class114.field2013.get(5);
            int var10 = class114.field2013.get(2);
            int var11 = class114.field2013.get(1);
            int var12 = class114.field2013.get(11);
            int var13 = class114.field2013.get(12);
            int var14 = class114.field2013.get(13);
            String var5 = class114.field2012[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + class114.field2015[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
            var3 = var4 + var5 + "; Max-Age=" + 94608000L;
         }

         class135.method2897(Client.field377, "document.cookie=\"" + var3 + "\"");
      } catch (Throwable var15) {
         ;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "12"
   )
   void method1078(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1135 = true;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)LSpritePixels;",
      garbageValue = "-1185182235"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var4 << 40) + ((long)var1 << 16) + (long)var0 + ((long)var2 << 38) + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = MessageNode.getItemDefinition(var0);
      if(var1 > 1 && null != var9.field1192) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field1193[var11] && var9.field1193[var11] != 0) {
               var10 = var9.field1192[var11];
            }
         }

         if(var10 != -1) {
            var9 = MessageNode.getItemDefinition(var10);
         }
      }

      Model var19 = var9.getModel(1);
      if(var19 == null) {
         return null;
      } else {
         SpritePixels var20 = null;
         if(var9.field1195 != -1) {
            var20 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var20 == null) {
               return null;
            }
         } else if(var9.field1204 != -1) {
            var20 = createSprite(var9.field1154, var1, var2, var3, 0, false);
            if(var20 == null) {
               return null;
            }
         } else if(var9.field1206 != -1) {
            var20 = createSprite(var9.field1205, var1, 0, 0, 0, false);
            if(null == var20) {
               return null;
            }
         }

         int[] var12 = class82.graphicsPixels;
         int var13 = class82.graphicsPixelsWidth;
         int var14 = class82.graphicsPixelsHeight;
         int[] var15 = new int[4];
         class82.method1884(var15);
         var8 = new SpritePixels(36, 32);
         class82.setRasterBuffer(var8.image, 36, 32);
         class82.method1829();
         class94.method2146();
         class94.method2134(16, 16);
         class94.rasterGouraudLowRes = false;
         if(var9.field1206 != -1) {
            var20.method1740(0, 0);
         }

         int var16 = var9.field1169;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = class94.field1639[var9.field1167] * var16 >> 16;
         int var18 = class94.field1640[var9.field1167] * var16 >> 16;
         var19.method2391();
         var19.method2366(0, var9.field1171, var9.field1203, var9.field1167, var9.field1158, var9.field1168 + var19.modelHeight / 2 + var17, var9.field1168 + var18);
         if(var9.field1204 != -1) {
            var20.method1740(0, 0);
         }

         if(var2 >= 1) {
            var8.method1793(1);
         }

         if(var2 >= 2) {
            var8.method1793(16777215);
         }

         if(var3 != 0) {
            var8.method1783(var3);
         }

         class82.setRasterBuffer(var8.image, 36, 32);
         if(var9.field1195 != -1) {
            var20.method1740(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            class28.field676.method4079(class127.method2848(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         class82.setRasterBuffer(var12, var13, var14);
         class82.method1828(var15);
         class94.method2146();
         class94.rasterGouraudLowRes = true;
         return var8;
      }
   }
}
