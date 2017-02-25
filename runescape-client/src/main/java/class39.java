import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class39 {
   @ObfuscatedName("q")
   static final BigInteger field825 = new BigInteger("10001", 16);
   @ObfuscatedName("d")
   static final BigInteger field827 = new BigInteger("b135c4e99e07ed10b5dbdf922b7f9041f9737bde40ed7e89c87b52cbe976601e579900c83be719d2edbd4487174e45253e728cfed8c2521a591ba26f5be215cd9ff51e6385401162b7b34d6b135b046f13a4ad829af055c2e26868f4741bf63df2376e095179bad8163a584ad3cf9e8c408efae18ec4e553eac79ea335300459", 16);

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-629153298"
   )
   static final void method824(int var0) {
      int[] var1 = class16.field183.image;
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
            if((class10.tileSettings[var0][var5][var3] & 24) == 0) {
               Script.region.method1781(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class10.tileSettings[1 + var0][var5][var3] & 8) != 0) {
               Script.region.method1781(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class16.field183.method4192();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class10.tileSettings[var0][var6][var5] & 24) == 0) {
               WidgetNode.method194(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class10.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               WidgetNode.method194(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field512 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = Script.region.method1776(WallObject.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = class187.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                     int[][] var13 = Client.collisionMaps[WallObject.plane].flags;

                     for(int var14 = 0; var14 < 10; ++var14) {
                        int var15 = (int)(Math.random() * 4.0D);
                        if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && (var13[var9 - 1][var10] & 19136776) == 0) {
                           --var9;
                        }

                        if(var15 == 1 && var9 < 103 && var9 < 3 + var5 && (var13[var9 + 1][var10] & 19136896) == 0) {
                           ++var9;
                        }

                        if(var15 == 2 && var10 > 0 && var10 > var6 - 3 && (var13[var9][var10 - 1] & 19136770) == 0) {
                           --var10;
                        }

                        if(var15 == 3 && var10 < 103 && var10 < 3 + var6 && (var13[var9][var10 + 1] & 19136800) == 0) {
                           ++var10;
                        }
                     }
                  }

                  Client.field538[Client.field512] = Tile.field1355[var8];
                  Client.field536[Client.field512] = var9;
                  Client.field537[Client.field512] = var10;
                  ++Client.field512;
               }
            }
         }
      }

      CombatInfo1.bufferProvider.method4085();
   }

   class39() throws Throwable {
      throw new Error();
   }
}
