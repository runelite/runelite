import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public final class class9 {
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = -1786904095
   )
   static int field83;
   @ObfuscatedName("ev")
   static SpritePixels[] field87;

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(III)Lclass119;",
      garbageValue = "231164823"
   )
   static class119 method114(int var0, int var1) {
      Client.field566.field1856 = var0;
      Client.field566.field1849 = var1;
      Client.field566.field1851 = 1;
      Client.field566.field1850 = 1;
      return Client.field566;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lclass184;",
      garbageValue = "627414260"
   )
   static class184 method115(int var0, boolean var1, boolean var2, boolean var3) {
      class116 var4 = null;
      if(null != class104.field1680) {
         var4 = new class116(var0, class104.field1680, class104.field1688[var0], 1000000);
      }

      return new class184(var4, class44.field895, var0, var1, var2, var3);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1537426692"
   )
   static String method116(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-673891694"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.field348 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.field348) {
         var1 = Client.field370.method3153();
         var2 = Client.field370.readUnsignedShort();
         var3 = Client.field370.readUnsignedShort();
         class28.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class28.xteaKeys[var4][var5] = Client.field370.method2995();
            }
         }

         FrameMap.mapRegions = new int[var3];
         PlayerComposition.field2044 = new int[var3];
         class32.field728 = new int[var3];
         class11.field104 = new byte[var3][];
         class22.field239 = new byte[var3][];
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
                  FrameMap.mapRegions[var3] = var7;
                  PlayerComposition.field2044[var3] = Client.field413.method3350("m" + var5 + "_" + var6);
                  class32.field728[var3] = Client.field413.method3350("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class194.method3601(var1, var2);
      } else {
         var1 = Client.field370.method3153();
         var2 = Client.field370.method3026();
         var3 = Client.field370.readUnsignedShort();
         Client.field370.method3232();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field370.method3237(1);
                  if(var7 == 1) {
                     Client.field349[var4][var5][var6] = Client.field370.method3237(26);
                  } else {
                     Client.field349[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.field370.method3238();
         class28.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class28.xteaKeys[var4][var5] = Client.field370.method2995();
            }
         }

         FrameMap.mapRegions = new int[var3];
         PlayerComposition.field2044 = new int[var3];
         class32.field728 = new int[var3];
         class11.field104 = new byte[var3][];
         class22.field239 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field349[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = var9 / 8 + (var8 / 8 << 8);

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(FrameMap.mapRegions[var11] == var10) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        FrameMap.mapRegions[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        PlayerComposition.field2044[var3] = Client.field413.method3350("m" + var11 + "_" + var12);
                        class32.field728[var3] = Client.field413.method3350("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class194.method3601(var2, var1);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)LSequence;",
      garbageValue = "-377815830"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field3045.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.field3049.method3329(12, var0);
         var1 = new Sequence();
         if(null != var2) {
            var1.method3798(new Buffer(var2));
         }

         var1.method3800();
         Sequence.field3045.put(var1, (long)var0);
         return var1;
      }
   }
}
