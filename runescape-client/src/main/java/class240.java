import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
public class class240 {
   @ObfuscatedName("g")
   public static final short[] field2806;
   @ObfuscatedName("e")
   public static final short[][] field2805;
   @ObfuscatedName("b")
   public static final short[] field2807;
   @ObfuscatedName("z")
   public static final short[][] field2808;

   static {
      field2806 = new short[]{(short)6798, (short)8741, (short)25238, (short)4626, (short)4550};
      field2805 = new short[][]{{(short)6798, (short)107, (short)10283, (short)16, (short)4797, (short)7744, (short)5799, (short)4634, (short)-31839, (short)22433, (short)2983, (short)-11343, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)8741, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)25239, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)25238, (short)8742, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)4626, (short)11146, (short)6439, (short)12, (short)4758, (short)10270}, {(short)4550, (short)4537, (short)5681, (short)5673, (short)5790, (short)6806, (short)8076, (short)4574, (short)17050, (short)0, (short)127, (short)-31821}};
      field2807 = new short[]{(short)-10304, (short)9104, (short)-1, (short)-1, (short)-1};
      field2808 = new short[][]{{(short)6554, (short)115, (short)10304, (short)28, (short)5702, (short)7756, (short)5681, (short)4510, (short)-31835, (short)22437, (short)2859, (short)-11339, (short)16, (short)5157, (short)10446, (short)3658, (short)-27314, (short)-21965, (short)472, (short)580, (short)784, (short)21966, (short)28950, (short)-15697, (short)-14002}, {(short)9104, (short)10275, (short)7595, (short)3610, (short)7975, (short)8526, (short)918, (short)-26734, (short)24466, (short)10145, (short)-6882, (short)5027, (short)1457, (short)16565, (short)-30545, (short)25486, (short)24, (short)5392, (short)10429, (short)3673, (short)-27335, (short)-21957, (short)192, (short)687, (short)412, (short)21821, (short)28835, (short)-15460, (short)-14019}, new short[0], new short[0], new short[0]};
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1413353904"
   )
   static final void method4523(int var0) {
      int[] var1 = class44.minimapSprite.pixels;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = (103 - var3) * 2048 + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class62.tileSettings[var0][var5][var3] & 24) == 0) {
               GameSocket.region.drawTile(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class62.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               GameSocket.region.drawTile(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class44.minimapSprite.setRaster();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class62.tileSettings[var0][var6][var5] & 24) == 0) {
               class80.drawObject(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class62.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               class80.drawObject(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field1114 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = GameSocket.region.getGroundObjectHash(ScriptVarType.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = class80.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  Client.mapIcons[Client.field1114] = class190.mapAreaType[var8].getMapIcon(false);
                  Client.field1105[Client.field1114] = var5;
                  Client.field1087[Client.field1114] = var6;
                  ++Client.field1114;
               }
            }
         }
      }

      GrandExchangeOffer.rasterProvider.setRaster();
   }
}
