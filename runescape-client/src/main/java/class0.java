import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
final class class0 implements Comparator {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1579874753
   )
   public static int field0;
   @ObfuscatedName("o")
   public static class182 field3;
   @ObfuscatedName("pp")
   static short[] field4;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "14"
   )
   int method0(class2 var1, class2 var2) {
      return var1.field17 < var2.field17?-1:(var1.field17 == var2.field17?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method0((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-294294420"
   )
   static final void method2(int var0, int var1) {
      if(var0 != class7.field54 || var1 != class36.field787) {
         class7.field54 = var0;
         class36.field787 = var1;
         class20.setGameState(25);
         DecorativeObject.method1875("Loading - please wait.", true);
         int var2 = class107.baseX;
         int var3 = XClanMember.baseY;
         class107.baseX = (var0 - 6) * 8;
         XClanMember.baseY = (var1 - 6) * 8;
         int var4 = class107.baseX - var2;
         int var5 = XClanMember.baseY - var3;
         var2 = class107.baseX;
         var3 = XClanMember.baseY;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            NPC var7 = Client.cachedNPCs[var6];
            if(null != var7) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.pathX[var8] -= var4;
                  var7.pathY[var8] -= var5;
               }

               var7.x -= var4 * 128;
               var7.y -= var5 * 128;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var20 = Client.cachedPlayers[var6];
            if(var20 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.pathX[var8] -= var4;
                  var20.pathY[var8] -= var5;
               }

               var20.x -= var4 * 128;
               var20.y -= 128 * var5;
            }
         }

         byte var19 = 0;
         byte var18 = 104;
         byte var21 = 1;
         if(var4 < 0) {
            var19 = 103;
            var18 = -1;
            var21 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var17 = var19; var17 != var18; var17 += var21) {
            for(var13 = var9; var13 != var10; var13 += var11) {
               int var14 = var17 + var4;
               int var15 = var13 + var5;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     Client.groundItemDeque[var16][var17][var13] = Client.groundItemDeque[var16][var14][var15];
                  } else {
                     Client.groundItemDeque[var16][var17][var13] = null;
                  }
               }
            }
         }

         for(class25 var12 = (class25)Client.field300.method2349(); null != var12; var12 = (class25)Client.field300.method2351()) {
            var12.field584 -= var4;
            var12.field573 -= var5;
            if(var12.field584 < 0 || var12.field573 < 0 || var12.field584 >= 104 || var12.field573 >= 104) {
               var12.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var4;
            Client.flagY -= var5;
         }

         Client.field526 = 0;
         Client.field554 = false;
         Client.field513 = -1;
         Client.field511.method2348();
         Client.projectiles.method2348();

         for(var13 = 0; var13 < 4; ++var13) {
            Client.collisionMaps[var13].method2199();
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(CB)B",
      garbageValue = "-17"
   )
   public static byte method6(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(var0 == 8230) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(var0 == 710) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(var0 == 8482) {
         var1 = -103;
      } else if(var0 == 353) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "94665416"
   )
   static final int method7(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = Frames.method1851(var3, var5);
      int var8 = Frames.method1851(var3 + 1, var5);
      int var9 = Frames.method1851(var3, 1 + var5);
      int var10 = Frames.method1851(1 + var3, 1 + var5);
      int var11 = class138.method2434(var7, var8, var4, var2);
      int var12 = class138.method2434(var9, var10, var4, var2);
      return class138.method2434(var11, var12, var6, var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-109635697"
   )
   public static boolean method8(int var0) {
      return (var0 >> 30 & 1) != 0;
   }
}
