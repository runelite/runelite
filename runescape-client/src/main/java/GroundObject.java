import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lep;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1501256669
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1526383403
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1620618967
   )
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -44846263
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -882539847
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("d")
   public static final void method2492(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var7) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var6) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var8) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1229238034"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class238.field3235 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class238.field3235.queueForWrite(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class238.field3235.close();
            } catch (Exception var3) {
               ;
            }

            ++class238.field3252;
            class238.field3235 = null;
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2022232535"
   )
   static final void method2491(int var0) {
      short var1 = 256;
      class92.field1405 += var0 * 128;
      int var2;
      if(class92.field1405 > class174.field2373.length) {
         class92.field1405 -= class174.field2373.length;
         var2 = (int)(Math.random() * 12.0D);
         class28.method234(class164.field2293[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = XClanMember.field889[var2 + var3] - var0 * class174.field2373[var2 + class92.field1405 & class174.field2373.length - 1] / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         XClanMember.field889[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               XClanMember.field889[var6 + var7] = 255;
            } else {
               XClanMember.field889[var6 + var7] = 0;
            }
         }
      }

      if(class92.field1403 > 0) {
         class92.field1403 -= var0 * 4;
      }

      if(class92.field1402 > 0) {
         class92.field1402 -= var0 * 4;
      }

      if(class92.field1403 == 0 && class92.field1402 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class92.field1403 = 1024;
         }

         if(var5 == 1) {
            class92.field1402 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class92.field1427[var5] = class92.field1427[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class92.field1427[var5] = (int)(Math.sin((double)class92.field1408 / 14.0D) * 16.0D + Math.sin((double)class92.field1408 / 15.0D) * 14.0D + Math.sin((double)class92.field1408 / 16.0D) * 12.0D);
         ++class92.field1408;
      }

      class92.field1406 += var0;
      var5 = ((Client.gameCycle & 1) + var0) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class92.field1406 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            XClanMember.field889[var7 + (var8 << 7)] = 192;
         }

         class92.field1406 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var9 + var5 < 128) {
                  var7 += XClanMember.field889[var5 + var8 + var9];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= XClanMember.field889[var8 + var9 - (var5 + 1)];
               }

               if(var9 >= 0) {
                  class21.field324[var9 + var8] = var7 / (var5 * 2 + 1);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var8 + var5 < var1) {
                  var7 += class21.field324[var5 * 128 + var6 + var9];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= class21.field324[var9 + var6 - (var5 + 1) * 128];
               }

               if(var8 >= 0) {
                  XClanMember.field889[var9 + var6] = var7 / (var5 * 2 + 1);
               }
            }
         }
      }

   }
}
