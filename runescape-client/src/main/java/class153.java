import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public final class class153 {
   @ObfuscatedName("v")
   static class170 field2311;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1082392636"
   )
   public static int method3184(int var0) {
      class50 var1 = XClanMember.method604(var0);
      int var2 = var1.field1111;
      int var3 = var1.field1110;
      int var4 = var1.field1113;
      int var5 = class179.field2967[var4 - var3];
      return class179.widgetSettings[var2] >> var3 & var5;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2085355777"
   )
   static final void method3185() {
      if(Item.plane != Client.field466) {
         Client.field466 = Item.plane;
         int var0 = Item.plane;
         int[] var1 = TextureProvider.field1712.image;
         int var2 = var1.length;

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            var1[var3] = 0;
         }

         int var4;
         int var5;
         for(var3 = 1; var3 < 103; ++var3) {
            var4 = 24628 + (103 - var3) * 2048;

            for(var5 = 1; var5 < 103; ++var5) {
               if((class5.tileSettings[var0][var5][var3] & 24) == 0) {
                  class16.region.method1982(var1, var4, 512, var0, var5, var3);
               }

               if(var0 < 3 && (class5.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
                  class16.region.method1982(var1, var4, 512, var0 + 1, var5, var3);
               }

               var4 += 4;
            }
         }

         var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
         var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
         TextureProvider.field1712.method1736();

         int var6;
         for(var5 = 1; var5 < 103; ++var5) {
            for(var6 = 1; var6 < 103; ++var6) {
               if((class5.tileSettings[var0][var6][var5] & 24) == 0) {
                  class9.method131(var0, var6, var5, var3, var4);
               }

               if(var0 < 3 && (class5.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
                  class9.method131(var0 + 1, var6, var5, var3, var4);
               }
            }
         }

         Client.field510 = 0;

         for(var5 = 0; var5 < 104; ++var5) {
            for(var6 = 0; var6 < 104; ++var6) {
               int var7 = class16.region.method1977(Item.plane, var5, var6);
               if(var7 != 0) {
                  var7 = var7 >> 14 & 32767;
                  int var8 = class165.getObjectDefinition(var7).field971;
                  if(var8 >= 0) {
                     int var9 = var5;
                     int var10 = var6;
                     if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                        int[][] var13 = Client.collisionMaps[Item.plane].flags;

                        for(int var14 = 0; var14 < 10; ++var14) {
                           int var15 = (int)(Math.random() * 4.0D);
                           if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && (var13[var9 - 1][var10] & 19136776) == 0) {
                              --var9;
                           }

                           if(var15 == 1 && var9 < 103 && var9 < 3 + var5 && (var13[1 + var9][var10] & 19136896) == 0) {
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

                     Client.field513[Client.field510] = class14.field209[var8];
                     Client.field365[Client.field510] = var9;
                     Client.field512[Client.field510] = var10;
                     ++Client.field510;
                  }
               }
            }
         }

         Buffer.bufferProvider.method1716();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1654950426"
   )
   static String method3186(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }
}
