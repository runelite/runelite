import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class173 {
   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "20316"
   )
   static final void method3252(int var0) {
      int[] var1 = class7.field56.image;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = 2048 * (103 - var3) + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class11.tileSettings[var0][var5][var3] & 24) == 0) {
               class65.region.method1741(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class11.tileSettings[1 + var0][var5][var3] & 8) != 0) {
               class65.region.method1741(var1, var4, 512, 1 + var0, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class7.field56.method4104();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class11.tileSettings[var0][var6][var5] & 24) == 0) {
               Widget.method2830(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class11.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               Widget.method2830(1 + var0, var6, var5, var3, var4);
            }
         }
      }

      Client.field507 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class65.region.method1736(class48.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = class156.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                     int[][] var13 = Client.collisionMaps[class48.plane].flags;

                     for(int var14 = 0; var14 < 10; ++var14) {
                        int var15 = (int)(Math.random() * 4.0D);
                        if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && (var13[var9 - 1][var10] & 19136776) == 0) {
                           --var9;
                        }

                        if(var15 == 1 && var9 < 103 && var9 < var5 + 3 && (var13[1 + var9][var10] & 19136896) == 0) {
                           ++var9;
                        }

                        if(var15 == 2 && var10 > 0 && var10 > var6 - 3 && (var13[var9][var10 - 1] & 19136770) == 0) {
                           --var10;
                        }

                        if(var15 == 3 && var10 < 103 && var10 < 3 + var6 && (var13[var9][1 + var10] & 19136800) == 0) {
                           ++var10;
                        }
                     }
                  }

                  Client.field510[Client.field507] = class99.field1648[var8];
                  Client.field508[Client.field507] = var9;
                  Client.field509[Client.field507] = var10;
                  ++Client.field507;
               }
            }
         }
      }

      class13.bufferProvider.method4046();
   }

   class173() throws Throwable {
      throw new Error();
   }
}
