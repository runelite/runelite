import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("World")
public class class27 {
   @ObfuscatedName("ic")
   static class176 field642;
   @ObfuscatedName("p")
   @Export("activity")
   String field645;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1212199073
   )
   static int field646 = 0;
   @ObfuscatedName("r")
   static int[] field648 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("x")
   static int[] field649 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1288131525
   )
   @Export("id")
   int field650;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -721546955
   )
   @Export("mask")
   int field651;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 573345373
   )
   @Export("playerCount")
   int field652;
   @ObfuscatedName("y")
   @Export("address")
   String field654;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -485974601
   )
   @Export("location")
   int field655;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -814419229
   )
   @Export("index")
   int field656;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 932494441
   )
   static int field661 = 0;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = -284412405
   )
   protected static int field662;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-106"
   )
   boolean method614() {
      return (1 & this.field651) != 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1889099403"
   )
   boolean method616() {
      return (4 & this.field651) != 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "39"
   )
   boolean method617() {
      return (8 & this.field651) != 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "78"
   )
   boolean method618() {
      return (2 & this.field651) != 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "31"
   )
   boolean method622() {
      return (536870912 & this.field651) != 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "301510550"
   )
   static final int method626(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class94.field1661[var2 * 1024 / var3] >> 1;
      return (var0 * (65536 - var4) >> 16) + (var1 * var4 >> 16);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-896122188"
   )
   boolean method630() {
      return (33554432 & this.field651) != 0;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static final void method644() {
      if(client.field410 != class51.field1119) {
         client.field410 = class51.field1119;
         int var0 = class51.field1119;
         int[] var1 = class20.field561.field1486;
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
               if((class5.field78[var0][var5][var3] & 24) == 0) {
                  class5.field91.method2032(var1, var4, 512, var0, var5, var3);
               }

               if(var0 < 3 && (class5.field78[1 + var0][var5][var3] & 8) != 0) {
                  class5.field91.method2032(var1, var4, 512, 1 + var0, var5, var3);
               }

               var4 += 4;
            }
         }

         var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
         var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
         class20.field561.method1790();

         int var6;
         for(var5 = 1; var5 < 103; ++var5) {
            for(var6 = 1; var6 < 103; ++var6) {
               if((class5.field78[var0][var6][var5] & 24) == 0) {
                  class153.method3189(var0, var6, var5, var3, var4);
               }

               if(var0 < 3 && (class5.field78[var0 + 1][var6][var5] & 8) != 0) {
                  class153.method3189(1 + var0, var6, var5, var3, var4);
               }
            }
         }

         client.field500 = 0;

         for(var5 = 0; var5 < 104; ++var5) {
            for(var6 = 0; var6 < 104; ++var6) {
               int var7 = class5.field91.method2027(class51.field1119, var5, var6);
               if(var7 != 0) {
                  var7 = var7 >> 14 & 32767;
                  int var8 = class7.method100(var7).field958;
                  if(var8 >= 0) {
                     int var9 = var5;
                     int var10 = var6;
                     if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                        int[][] var13 = client.field331[class51.field1119].field1954;

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

                           if(var15 == 3 && var10 < 103 && var10 < var6 + 3 && (var13[var9][var10 + 1] & 19136800) == 0) {
                              ++var10;
                           }
                        }
                     }

                     client.field503[client.field500] = class24.field608[var8];
                     client.field501[client.field500] = var9;
                     client.field502[client.field500] = var10;
                     ++client.field500;
                  }
               }
            }
         }

         class78.field1454.method1782();
      }

   }
}
