import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class226 {
   @ObfuscatedName("m")
   public static final short[] field1132;
   @ObfuscatedName("f")
   public static final short[][] field1133;
   @ObfuscatedName("q")
   public static final short[] field1134;
   @ObfuscatedName("w")
   public static final short[][] field1135;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)Lln;",
      garbageValue = "-76173898"
   )
   @Export("getItemSprite")
   public static final Sprite getItemSprite(int var0, int quantity, int var2, int var3, int var4, boolean var5) {
      if (quantity == -1) {
         var4 = 0;
      } else if (var4 == 2 && quantity != 1) {
         var4 = 1;
      }

      long var6 = ((long)quantity << 16) + (long)var0 + ((long)var2 << 38) + ((long)var4 << 40) + ((long)var3 << 42);
      Sprite var8;
      if (!var5) {
         var8 = (Sprite)ItemDefinition.Sprite_cached.get(var6);
         if (var8 != null) {
            return var8;
         }
      }

      ItemDefinition var9 = Skills.getItemDefinition(var0);
      if (quantity > 1 && var9.countobj != null) {
         int var10 = -1;

         for (int var11 = 0; var11 < 10; ++var11) {
            if (quantity >= var9.countco[var11] && var9.countco[var11] != 0) {
               var10 = var9.countobj[var11];
            }
         }

         if (var10 != -1) {
            var9 = Skills.getItemDefinition(var10);
         }
      }

      Model var19 = var9.getModel(1);
      if (var19 == null) {
         return null;
      } else {
         Sprite var20 = null;
         if (var9.noteTemplate != -1) {
            var20 = getItemSprite(var9.note, 10, 1, 0, 0, true);
            if (var20 == null) {
               return null;
            }
         } else if (var9.notedId != -1) {
            var20 = getItemSprite(var9.unnotedId, quantity, var2, var3, 0, false);
            if (var20 == null) {
               return null;
            }
         } else if (var9.placeholderTemplate != -1) {
            var20 = getItemSprite(var9.placeholder, quantity, 0, 0, 0, false);
            if (var20 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.Rasterizer2D_pixels;
         int var13 = Rasterizer2D.Rasterizer2D_width;
         int var14 = Rasterizer2D.Rasterizer2D_height;
         int[] var15 = new int[4];
         Rasterizer2D.Rasterizer2D_getClipArray(var15);
         var8 = new Sprite(36, 32);
         Rasterizer2D.Rasterizer2D_replace(var8.pixels, 36, 32);
         Rasterizer2D.Rasterizer2D_clear();
         Rasterizer3D.Rasterizer3D_method1();
         Rasterizer3D.method2989(16, 16);
         Rasterizer3D.field741 = false;
         if (var9.placeholderTemplate != -1) {
            var20.drawAt2(0, 0);
         }

         int var16 = var9.zoom2d;
         if (var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if (var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * Rasterizer3D.Rasterizer3D_sine[var9.xan2d] >> 16;
         int var18 = var16 * Rasterizer3D.Rasterizer3D_cosine[var9.xan2d] >> 16;
         var19.calculateBoundsCylinder();
         var19.method199(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var19.height / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
         if (var9.notedId != -1) {
            var20.drawAt2(0, 0);
         }

         if (var2 >= 1) {
            var8.method307(1);
         }

         if (var2 >= 2) {
            var8.method307(16777215);
         }

         if (var3 != 0) {
            var8.method308(var3);
         }

         Rasterizer2D.Rasterizer2D_replace(var8.pixels, 36, 32);
         if (var9.noteTemplate != -1) {
            var20.drawAt2(0, 0);
         }

         if (var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            class204.field1122.draw(class196.method3735(quantity), 0, 9, 16776960, 1);
         }

         if (!var5) {
            ItemDefinition.Sprite_cached.put(var8, var6);
         }

         Rasterizer2D.Rasterizer2D_replace(var12, var13, var14);
         Rasterizer2D.Rasterizer2D_setClipArray(var15);
         Rasterizer3D.Rasterizer3D_method1();
         Rasterizer3D.field741 = true;
         return var8;
      }
   }

   static {
      field1132 = new short[]{6798, 8741, 25238, 4626, 4550};
      field1133 = new short[][]{{6798, 107, 10283, 16, 4797, 7744, 5799, 4634, -31839, 22433, 2983, -11343, 8, 5281, 10438, 3650, -27322, -21845, 200, 571, 908, 21830, 28946, -15701, -14010}, {8741, 12, -1506, -22374, 7735, 8404, 1701, -27106, 24094, 10153, -8915, 4783, 1341, 16578, -30533, 25239, 8, 5281, 10438, 3650, -27322, -21845, 200, 571, 908, 21830, 28946, -15701, -14010}, {25238, 8742, 12, -1506, -22374, 7735, 8404, 1701, -27106, 24094, 10153, -8915, 4783, 1341, 16578, -30533, 8, 5281, 10438, 3650, -27322, -21845, 200, 571, 908, 21830, 28946, -15701, -14010}, {4626, 11146, 6439, 12, 4758, 10270}, {4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574, 17050, 0, 127, -31821, -17991}};
      field1134 = new short[]{-10304, 9104, -1, -1, -1};
      field1135 = new short[][]{{6554, 115, 10304, 28, 5702, 7756, 5681, 4510, -31835, 22437, 2859, -11339, 16, 5157, 10446, 3658, -27314, -21965, 472, 580, 784, 21966, 28950, -15697, -14002}, {9104, 10275, 7595, 3610, 7975, 8526, 918, -26734, 24466, 10145, -6882, 5027, 1457, 16565, -30545, 25486, 24, 5392, 10429, 3673, -27335, -21957, 192, 687, 412, 21821, 28835, -15460, -14019}, new short[0], new short[0], new short[0]};
   }
}
