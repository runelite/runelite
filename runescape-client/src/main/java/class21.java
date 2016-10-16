import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class21 implements class115 {
   @ObfuscatedName("z")
   static final class21 field561 = new class21(1);
   @ObfuscatedName("s")
   static final class21 field562 = new class21(0);
   @ObfuscatedName("t")
   static final class21 field563 = new class21(2);
   @ObfuscatedName("y")
   static final class21 field564 = new class21(3);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -636181705
   )
   final int field565;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int vmethod3162() {
      return this.field565;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)LSpritePixels;",
      garbageValue = "946654651"
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
         if(null != var8) {
            return var8;
         }
      }

      ItemComposition var9 = class174.getItemDefinition(var0);
      if(var1 > 1 && null != var9.field1178) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field1179[var11] && var9.field1179[var11] != 0) {
               var10 = var9.field1178[var11];
            }
         }

         if(var10 != -1) {
            var9 = class174.getItemDefinition(var10);
         }
      }

      Model var21 = var9.getModel(1);
      if(null == var21) {
         return null;
      } else {
         SpritePixels var22 = null;
         if(var9.field1181 != -1) {
            var22 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(null == var22) {
               return null;
            }
         } else if(var9.field1190 != -1) {
            var22 = createSprite(var9.field1189, var1, var2, var3, 0, false);
            if(var22 == null) {
               return null;
            }
         } else if(var9.field1154 != -1) {
            var22 = createSprite(var9.field1191, var1, 0, 0, 0, false);
            if(var22 == null) {
               return null;
            }
         }

         int[] var12 = class82.graphicsPixels;
         int var13 = class82.graphicsPixelsWidth;
         int var14 = class82.graphicsPixelsHeight;
         int[] var15 = new int[4];
         class82.method1861(var15);
         var8 = new SpritePixels(36, 32);
         class82.setRasterBuffer(var8.image, 36, 32);
         class82.method1867();
         class94.method2081();
         class94.method2089(16, 16);
         class94.rasterGouraudLowRes = false;
         if(var9.field1154 != -1) {
            var22.method1712(0, 0);
         }

         int var16 = var9.field1151;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = class94.field1631[var9.field1183] * var16 >> 16;
         int var18 = var16 * class94.field1621[var9.field1183] >> 16;
         var21.method2275();
         var21.method2287(0, var9.field1157, var9.field1159, var9.field1183, var9.field1155, var9.field1186 + var17 + var21.modelHeight / 2, var18 + var9.field1186);
         if(var9.field1190 != -1) {
            var22.method1712(0, 0);
         }

         if(var2 >= 1) {
            var8.method1698(1);
         }

         if(var2 >= 2) {
            var8.method1698(16777215);
         }

         if(var3 != 0) {
            var8.method1764(var3);
         }

         class82.setRasterBuffer(var8.image, 36, 32);
         if(var9.field1181 != -1) {
            var22.method1712(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            class227 var19 = ItemComposition.field1152;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method4032(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         class82.setRasterBuffer(var12, var13, var14);
         class82.method1792(var15);
         class94.method2081();
         class94.rasterGouraudLowRes = true;
         return var8;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass170;B)V",
      garbageValue = "0"
   )
   public static void method543(class170 var0) {
      class54.field1136 = var0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;ZLclass227;I)V",
      garbageValue = "-1683787955"
   )
   public static void method547(class170 var0, class170 var1, boolean var2, class227 var3) {
      ItemComposition.field1142 = var0;
      ItemComposition.field1143 = var1;
      class49.isMembersWorld = var2;
      class138.field2126 = ItemComposition.field1142.method3260(10);
      ItemComposition.field1152 = var3;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class21(int var1) {
      this.field565 = var1;
   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "69"
   )
   static final boolean method551(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field548 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field541.method3491(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field541.method3477(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field541.method3478(false);
         }

         if(var1 == 325) {
            Client.field541.method3478(true);
         }

         if(var1 == 326) {
            Client.field300.method2748(111);
            Client.field541.method3479(Client.field300);
            return true;
         } else {
            return false;
         }
      }
   }
}
