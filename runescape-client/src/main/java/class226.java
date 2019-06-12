import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class226 {
   @ObfuscatedName("m")
   @Export("__ht_m")
   public static final short[] __ht_m;
   @ObfuscatedName("f")
   @Export("__ht_f")
   public static final short[][] __ht_f;
   @ObfuscatedName("q")
   @Export("__ht_q")
   public static final short[] __ht_q;
   @ObfuscatedName("w")
   @Export("__ht_w")
   public static final short[][] __ht_w;

   static {
      __ht_m = new short[]{(short)6798, (short)8741, (short)25238, (short)4626, (short)4550};
      __ht_f = new short[][]{{(short)6798, (short)107, (short)10283, (short)16, (short)4797, (short)7744, (short)5799, (short)4634, (short)-31839, (short)22433, (short)2983, (short)-11343, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)8741, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)25239, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)25238, (short)8742, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)4626, (short)11146, (short)6439, (short)12, (short)4758, (short)10270}, {(short)4550, (short)4537, (short)5681, (short)5673, (short)5790, (short)6806, (short)8076, (short)4574, (short)17050, (short)0, (short)127, (short)-31821, (short)-17991}};
      __ht_q = new short[]{(short)-10304, (short)9104, (short)-1, (short)-1, (short)-1};
      __ht_w = new short[][]{{(short)6554, (short)115, (short)10304, (short)28, (short)5702, (short)7756, (short)5681, (short)4510, (short)-31835, (short)22437, (short)2859, (short)-11339, (short)16, (short)5157, (short)10446, (short)3658, (short)-27314, (short)-21965, (short)472, (short)580, (short)784, (short)21966, (short)28950, (short)-15697, (short)-14002}, {(short)9104, (short)10275, (short)7595, (short)3610, (short)7975, (short)8526, (short)918, (short)-26734, (short)24466, (short)10145, (short)-6882, (short)5027, (short)1457, (short)16565, (short)-30545, (short)25486, (short)24, (short)5392, (short)10429, (short)3673, (short)-27335, (short)-21957, (short)192, (short)687, (short)412, (short)21821, (short)28835, (short)-15460, (short)-14019}, new short[0], new short[0], new short[0]};
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)Lln;",
      garbageValue = "-76173898"
   )
   @Export("getItemSprite")
   public static final Sprite getItemSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var1 << 16) + (long)var0 + ((long)var2 << 38) + ((long)var4 << 40) + ((long)var3 << 42);
      Sprite var8;
      if(!var5) {
         var8 = (Sprite)ItemDefinition.Sprite_cached.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemDefinition var9 = Skills.getItemDefinition(var0);
      if(var1 > 1 && var9.__az != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.__au[var11] && var9.__au[var11] != 0) {
               var10 = var9.__az[var11];
            }
         }

         if(var10 != -1) {
            var9 = Skills.getItemDefinition(var10);
         }
      }

      Model var19 = var9.getModel(1);
      if(var19 == null) {
         return null;
      } else {
         Sprite var20 = null;
         if(var9.noteTemplate != -1) {
            var20 = getItemSprite(var9.note, 10, 1, 0, 0, true);
            if(var20 == null) {
               return null;
            }
         } else if(var9.notedId != -1) {
            var20 = getItemSprite(var9.unnotedId, var1, var2, var3, 0, false);
            if(var20 == null) {
               return null;
            }
         } else if(var9.placeholderTemplate != -1) {
            var20 = getItemSprite(var9.placeholder, var1, 0, 0, 0, false);
            if(var20 == null) {
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
         Rasterizer3D.__et_w = false;
         if(var9.placeholderTemplate != -1) {
            var20.drawAt2(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * Rasterizer3D.Rasterizer3D_sine[var9.xan2d] >> 16;
         int var18 = var16 * Rasterizer3D.Rasterizer3D_cosine[var9.xan2d] >> 16;
         var19.calculateBoundsCylinder();
         var19.__c_234(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var19.height / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.notedId != -1) {
            var20.drawAt2(0, 0);
         }

         if(var2 >= 1) {
            var8.__l_502(1);
         }

         if(var2 >= 2) {
            var8.__l_502(16777215);
         }

         if(var3 != 0) {
            var8.__e_503(var3);
         }

         Rasterizer2D.Rasterizer2D_replace(var8.pixels, 36, 32);
         if(var9.noteTemplate != -1) {
            var20.drawAt2(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            class204.__gx_n.draw(class196.method3735(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemDefinition.Sprite_cached.put(var8, var6);
         }

         Rasterizer2D.Rasterizer2D_replace(var12, var13, var14);
         Rasterizer2D.Rasterizer2D_setClipArray(var15);
         Rasterizer3D.Rasterizer3D_method1();
         Rasterizer3D.__et_w = true;
         return var8;
      }
   }
}
