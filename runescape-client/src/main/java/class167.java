import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class167 {
   @ObfuscatedName("x")
   public static final short[] field2178 = new short[]{(short)-10304, (short)9104, (short)-1, (short)-1, (short)-1};
   @ObfuscatedName("g")
   public static final short[][] field2179 = new short[][]{{(short)6798, (short)107, (short)10283, (short)16, (short)4797, (short)7744, (short)5799, (short)4634, (short)-31839, (short)22433, (short)2983, (short)-11343, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)8741, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)25239, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)25238, (short)8742, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)4626, (short)11146, (short)6439, (short)12, (short)4758, (short)10270}, {(short)4550, (short)4537, (short)5681, (short)5673, (short)5790, (short)6806, (short)8076, (short)4574, (short)17050, (short)0, (short)127}};
   @ObfuscatedName("q")
   public static final short[][] field2180 = new short[][]{{(short)6554, (short)115, (short)10304, (short)28, (short)5702, (short)7756, (short)5681, (short)4510, (short)-31835, (short)22437, (short)2859, (short)-11339, (short)16, (short)5157, (short)10446, (short)3658, (short)-27314, (short)-21965, (short)472, (short)580, (short)784, (short)21966, (short)28950, (short)-15697, (short)-14002}, {(short)9104, (short)10275, (short)7595, (short)3610, (short)7975, (short)8526, (short)918, (short)-26734, (short)24466, (short)10145, (short)-6882, (short)5027, (short)1457, (short)16565, (short)-30545, (short)25486, (short)24, (short)5392, (short)10429, (short)3673, (short)-27335, (short)-21957, (short)192, (short)687, (short)412, (short)21821, (short)28835, (short)-15460, (short)-14019}, new short[0], new short[0], new short[0]};
   @ObfuscatedName("p")
   public static final short[] field2181 = new short[]{(short)6798, (short)8741, (short)25238, (short)4626, (short)4550};

   class167() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2145510839"
   )
   static void method3159() {
      Client.field394.method3037(138);
      class159 var0 = Client.field394;
      int var1 = Client.isResized?2:1;
      var0.method2799(var1);
      Client.field394.method2837(class26.field577);
      Client.field394.method2837(class187.field2776);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1180373336"
   )
   static void method3162(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method2374((long)var0);
      if(null == var4) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method2364(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1291920072"
   )
   static String method3163(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "539431865"
   )
   static final void method3165(String var0) {
      if(var0 != null) {
         String var1 = FrameMap.method1697(var0, FaceNormal.field1561);
         if(null != var1) {
            for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
               Ignore var3 = Client.ignores[var2];
               String var4 = var3.name;
               String var5 = FrameMap.method1697(var4, FaceNormal.field1561);
               if(FileOnDisk.method1429(var0, var1, var4, var5)) {
                  --Client.ignoreCount;

                  for(int var6 = var2; var6 < Client.ignoreCount; ++var6) {
                     Client.ignores[var6] = Client.ignores[1 + var6];
                  }

                  Client.field416 = Client.field462;
                  Client.field394.method3037(36);
                  Client.field394.method2799(class37.method737(var0));
                  Client.field394.method2805(var0);
                  break;
               }
            }

         }
      }
   }
}
