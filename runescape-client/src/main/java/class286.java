import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kn")
public class class286 {
   @ObfuscatedName("g")
   static int[] field3783;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1908062655
   )
   static int field3784;
   @ObfuscatedName("q")
   static int[] field3785;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1914184237
   )
   static int field3786;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 695589077
   )
   static int field3787;

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-46"
   )
   static final void method5212(int var0) {
      int[] var1 = class172.field2368.image;
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
            if((class61.tileSettings[var0][var5][var3] & 24) == 0) {
               class46.region.method2806(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               class46.region.method2806(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = ((int)(Math.random() * 20.0D) + 238 - 10 << 16) + ((int)(Math.random() * 20.0D) + 238 - 10 << 8) + ((int)(Math.random() * 20.0D) + 238 - 10);
      var4 = (int)(Math.random() * 20.0D) + 238 - 10 << 16;
      class172.field2368.method5199();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class61.tileSettings[var0][var6][var5] & 24) == 0) {
               class140.method2900(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               class140.method2900(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field1118 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class46.region.method2736(Sequence.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = class43.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                     int[][] var13 = Client.collisionMaps[Sequence.plane].flags;

                     for(int var14 = 0; var14 < 10; ++var14) {
                        int var15 = (int)(Math.random() * 4.0D);
                        if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && (var13[var9 - 1][var10] & 19136776) == 0) {
                           --var9;
                        }

                        if(var15 == 1 && var9 < 103 && var9 < var5 + 3 && (var13[var9 + 1][var10] & 19136896) == 0) {
                           ++var9;
                        }

                        if(var15 == 2 && var10 > 0 && var10 > var6 - 3 && (var13[var9][var10 - 1] & 19136770) == 0) {
                           --var10;
                        }

                        if(var15 == 3 && var10 < 103 && var10 < var6 + 3 && (var13[var9][var10 + 1] & 19136800) == 0) {
                           ++var10;
                        }
                     }
                  }

                  Client.field1124[Client.field1118] = class242.field3276[var8].method4370(false);
                  Client.field918[Client.field1118] = var9;
                  Client.field1064[Client.field1118] = var10;
                  ++Client.field1118;
               }
            }
         }
      }

      class40.field541.method5082();
   }
}
