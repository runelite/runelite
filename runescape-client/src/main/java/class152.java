import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class152 {
   @ObfuscatedName("n")
   public static class231[] field2271;
   @ObfuscatedName("y")
   static File field2272;
   @ObfuscatedName("p")
   static File field2273;
   @ObfuscatedName("a")
   static String[] field2274;
   @ObfuscatedName("r")
   public static class231 field2276 = null;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1758763089
   )
   static int field2277;
   @ObfuscatedName("u")
   public static class231 field2278 = null;
   @ObfuscatedName("w")
   public static class231 field2279 = null;
   @ObfuscatedName("bw")
   static class171 field2281;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-4"
   )
   static void method3124() {
      class220.field3213 = null;
      class5.field67 = null;
      class5.field69 = null;
      class62.field1261 = null;
      class16.field216 = null;
      class217.field3197 = null;
      class11.field164 = null;
      class5.field70 = null;
      MessageNode.field776 = null;
      class5.field65 = null;
      class124.field2052 = null;
      class5.field72 = null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "28"
   )
   public static String method3134(CharSequence var0) {
      int var2 = var0.length();
      char[] var3 = new char[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = 42;
      }

      String var1 = new String(var3);
      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1929216154"
   )
   public static boolean method3136(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1339069104"
   )
   static final void method3138() {
      if(null != class32.field695) {
         class32.field695.method2986();
         class32.field695 = null;
      }

      class117.method2418();
      class114.region.method1915();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method2360();
      }

      System.gc();
      class52.method1044(2);
      Client.field506 = -1;
      Client.field507 = false;
      class22.method568();
      class112.setGameState(10);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BIILRegion;[LCollisionData;I)V",
      garbageValue = "1528918829"
   )
   static final void method3140(byte[] var0, int var1, int var2, Region var3, CollisionData[] var4) {
      Buffer var5 = new Buffer(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.method2654();
         if(var7 == 0) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.method2654();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.method2481();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var11 + var1;
            int var17 = var2 + var10;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if((class5.tileSettings[1][var16][var17] & 2) == 2) {
                  var18 = var12 - 1;
               }

               CollisionData var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               class51.method1032(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "3"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.field428 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.field428) {
         var1 = Client.field312.method2516();
         var2 = Client.field312.method2517();
         var3 = Client.field312.method2668();
         class26.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class26.xteaKeys[var4][var5] = Client.field312.method2526();
            }
         }

         class9.mapRegions = new int[var3];
         Client.field327 = new int[var3];
         class186.field2998 = new int[var3];
         Client.field551 = new byte[var3][];
         class132.field2091 = new byte[var3][];
         boolean var13 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var13 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (6 + var1) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
               var7 = (var5 << 8) + var6;
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class9.mapRegions[var3] = var7;
                  Client.field327[var3] = class24.field603.method3265("m" + var5 + "_" + var6);
                  class186.field2998[var3] = class24.field603.method3265("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         Item.method671(var1, var2);
      } else {
         var1 = Client.field312.method2658();
         var2 = Client.field312.method2517();
         var3 = Client.field312.method2668();
         Client.field312.method2750();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field312.method2762(1);
                  if(var7 == 1) {
                     Client.field330[var4][var5][var6] = Client.field312.method2762(26);
                  } else {
                     Client.field330[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.field312.method2751();
         class26.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class26.xteaKeys[var4][var5] = Client.field312.method2526();
            }
         }

         class9.mapRegions = new int[var3];
         Client.field327 = new int[var3];
         class186.field2998 = new int[var3];
         Client.field551 = new byte[var3][];
         class132.field2091 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field330[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = (var8 / 8 << 8) + var9 / 8;

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(class9.mapRegions[var11] == var10) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class9.mapRegions[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        Client.field327[var3] = class24.field603.method3265("m" + var11 + "_" + var12);
                        class186.field2998[var3] = class24.field603.method3265("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         Item.method671(var1, var2);
      }

   }
}
