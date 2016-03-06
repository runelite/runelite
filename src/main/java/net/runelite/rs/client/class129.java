package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dx")
public class class129 {
   @ObfuscatedName("l")
   public static final class129 field2061 = new class129(1);
   @ObfuscatedName("a")
   static final class129 field2062 = new class129(2);
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1175877741
   )
   public final int field2063;
   @ObfuscatedName("j")
   static final class129 field2064 = new class129(0);

   @ObfuscatedName("dn")
   static final void method2758(int var0) {
      class83.method1864();
      class101.method2246();
      int var1 = class7.method97(var0).field1168;
      if(var1 != 0) {
         int var2 = class175.field2906[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class90.method2064(0.9D);
               ((class94)class90.field1576).method2141(0.9D);
            }

            if(var2 == 2) {
               class90.method2064(0.8D);
               ((class94)class90.field1576).method2141(0.8D);
            }

            if(var2 == 3) {
               class90.method2064(0.7D);
               ((class94)class90.field1576).method2141(0.7D);
            }

            if(4 == var2) {
               class90.method2064(0.6D);
               ((class94)class90.field1576).method2141(0.6D);
            }

            class51.field1118.method3720();
         }

         if(3 == var1) {
            short var3 = 0;
            if(0 == var2) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(3 == var2) {
               var3 = 64;
            }

            if(4 == var2) {
               var3 = 0;
            }

            if(client.field525 != var3) {
               if(client.field525 == 0 && client.field453 != -1) {
                  class108.method2379(class137.field2139, client.field453, 0, var3, false);
                  client.field527 = false;
               } else if(var3 == 0) {
                  class45.method951();
                  client.field527 = false;
               } else {
                  class108.method2375(var3);
               }

               client.field525 = var3;
            }
         }

         if(4 == var1) {
            if(var2 == 0) {
               client.field300 = 127;
            }

            if(var2 == 1) {
               client.field300 = 96;
            }

            if(2 == var2) {
               client.field300 = 64;
            }

            if(3 == var2) {
               client.field300 = 32;
            }

            if(var2 == 4) {
               client.field300 = 0;
            }
         }

         if(5 == var1) {
            client.field427 = var2;
         }

         if(6 == var1) {
            client.field361 = var2;
         }

         if(var1 == 9) {
            client.field451 = var2;
         }

         if(var1 == 10) {
            if(0 == var2) {
               client.field502 = 127;
            }

            if(1 == var2) {
               client.field502 = 96;
            }

            if(var2 == 2) {
               client.field502 = 64;
            }

            if(3 == var2) {
               client.field502 = 32;
            }

            if(4 == var2) {
               client.field502 = 0;
            }
         }

         if(17 == var1) {
            client.field450 = var2 & '\uffff';
         }

         class20[] var4;
         if(18 == var1) {
            var4 = new class20[]{class20.field578, class20.field576, class20.field577, class20.field579};
            client.field313 = (class20)class150.method3104(var4, var2);
            if(client.field313 == null) {
               client.field313 = class20.field578;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               client.field419 = -1;
            } else {
               client.field419 = var2 & 2047;
            }
         }

         if(22 == var1) {
            var4 = new class20[]{class20.field578, class20.field576, class20.field577, class20.field579};
            client.field357 = (class20)class150.method3104(var4, var2);
            if(null == client.field357) {
               client.field357 = class20.field578;
            }
         }

      }
   }

   @ObfuscatedName("m")
   public static class78[] method2761(class166 var0, String var1, String var2) {
      int var3 = var0.method3248(var1);
      int var4 = var0.method3238(var3, var2);
      class78[] var5;
      if(!class11.method148(var0, var3, var4)) {
         var5 = null;
      } else {
         class78[] var7 = new class78[class76.field1395];

         for(int var8 = 0; var8 < class76.field1395; ++var8) {
            class78 var9 = var7[var8] = new class78();
            var9.field1421 = class76.field1390;
            var9.field1416 = class76.field1391;
            var9.field1413 = class76.field1392[var8];
            var9.field1420 = class106.field1884[var8];
            var9.field1411 = class215.field3153[var8];
            var9.field1414 = class147.field2230[var8];
            int var10 = var9.field1414 * var9.field1411;
            byte[] var11 = class41.field977[var8];
            var9.field1412 = new int[var10];

            for(int var12 = 0; var12 < var10; ++var12) {
               var9.field1412[var12] = class126.field2048[var11[var12] & 255];
            }
         }

         class76.field1392 = null;
         class106.field1884 = null;
         class215.field3153 = null;
         class147.field2230 = null;
         class126.field2048 = null;
         class41.field977 = (byte[][])null;
         var5 = var7;
      }

      return var5;
   }

   class129(int var1) {
      this.field2063 = var1;
   }
}
