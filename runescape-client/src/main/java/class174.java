import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class174 {
   @ObfuscatedName("s")
   public static final short[] field2900 = new short[]{(short)6798, (short)8741, (short)25238, (short)4626, (short)4550};
   @ObfuscatedName("p")
   public static final short[] field2902 = new short[]{(short)-10304, (short)9104, (short)-1, (short)-1, (short)-1};
   @ObfuscatedName("x")
   public static final short[][] field2903 = new short[][]{{(short)6554, (short)115, (short)10304, (short)28, (short)5702, (short)7756, (short)5681, (short)4510, (short)-31835, (short)22437, (short)2859, (short)-11339, (short)16, (short)5157, (short)10446, (short)3658, (short)-27314, (short)-21965, (short)472, (short)580, (short)784, (short)21966, (short)28950, (short)-15697, (short)-14002}, {(short)9104, (short)10275, (short)7595, (short)3610, (short)7975, (short)8526, (short)918, (short)-26734, (short)24466, (short)10145, (short)-6882, (short)5027, (short)1457, (short)16565, (short)-30545, (short)25486, (short)24, (short)5392, (short)10429, (short)3673, (short)-27335, (short)-21957, (short)192, (short)687, (short)412, (short)21821, (short)28835, (short)-15460, (short)-14019}, new short[0], new short[0], new short[0]};
   @ObfuscatedName("bd")
   static class168 field2905;
   @ObfuscatedName("j")
   public static final short[][] field2907 = new short[][]{{(short)6798, (short)107, (short)10283, (short)16, (short)4797, (short)7744, (short)5799, (short)4634, (short)-31839, (short)22433, (short)2983, (short)-11343, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)8741, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)25239, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)25238, (short)8742, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)4626, (short)11146, (short)6439, (short)12, (short)4758, (short)10270}, {(short)4550, (short)4537, (short)5681, (short)5673, (short)5790, (short)6806, (short)8076, (short)4574, (short)17050, (short)0, (short)127}};

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "394643332"
   )
   public static void method3422() {
      class39.field888.method3750();
      class39.field885.method3750();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1966673195"
   )
   public static void method3426(byte[] var0) {
      class119 var1 = new class119(var0);
      var1.field2005 = var0.length - 2;
      class76.field1395 = var1.method2584();
      class76.field1387 = new int[class76.field1395];
      class76.field1390 = new int[class76.field1395];
      class76.field1389 = new int[class76.field1395];
      class9.field159 = new int[class76.field1395];
      class21.field575 = new byte[class76.field1395][];
      var1.field2005 = var0.length - 7 - class76.field1395 * 8;
      class226.field3214 = var1.method2584();
      class76.field1386 = var1.method2584();
      int var2 = (var1.method2492() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class76.field1395; ++var3) {
         class76.field1387[var3] = var1.method2584();
      }

      for(var3 = 0; var3 < class76.field1395; ++var3) {
         class76.field1390[var3] = var1.method2584();
      }

      for(var3 = 0; var3 < class76.field1395; ++var3) {
         class76.field1389[var3] = var1.method2584();
      }

      for(var3 = 0; var3 < class76.field1395; ++var3) {
         class9.field159[var3] = var1.method2584();
      }

      var1.field2005 = var0.length - 7 - class76.field1395 * 8 - 3 * (var2 - 1);
      class76.field1396 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class76.field1396[var3] = var1.method2513();
         if(class76.field1396[var3] == 0) {
            class76.field1396[var3] = 1;
         }
      }

      var1.field2005 = 0;

      for(var3 = 0; var3 < class76.field1395; ++var3) {
         int var4 = class76.field1389[var3];
         int var5 = class9.field159[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class21.field575[var3] = var7;
         int var8 = var1.method2492();
         int var9;
         if(0 == var8) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2493();
            }
         } else if(1 == var8) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var4 * var10 + var9] = var1.method2493();
               }
            }
         }
      }

   }
}
