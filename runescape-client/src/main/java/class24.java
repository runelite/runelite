import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
@Implements("XClanMember")
public class class24 extends class208 {
   @ObfuscatedName("s")
   @Export("username")
   String field616;
   @ObfuscatedName("j")
   String field617;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 870108713
   )
   @Export("world")
   int field618;
   @ObfuscatedName("ep")
   static class78 field620;
   @ObfuscatedName("x")
   @Export("rank")
   byte field622;

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1665845938"
   )
   static final void method578(int var0, int var1, int var2, int var3, int var4) {
      int var5 = client.field339.method1964(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      class80 var14;
      if(var5 != 0) {
         var6 = client.field339.method1925(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var12 = class74.field1370.field1414;
         var10 = 2048 * (103 - var2) + 24624 + 4 * var1;
         var11 = var5 >> 14 & 32767;
         class40 var13 = class9.method120(var11);
         if(var13.field953 != -1) {
            var14 = class2.field60[var13.field953];
            if(null != var14) {
               int var15 = (var13.field939 * 4 - var14.field1427) / 2;
               int var16 = (var13.field966 * 4 - var14.field1429) / 2;
               var14.method1841(48 + var1 * 4 + var15, (104 - var2 - var13.field966) * 4 + 48 + var16);
            }
         } else {
            if(var8 == 0 || 2 == var8) {
               if(var7 == 0) {
                  var12[var10] = var9;
                  var12[512 + var10] = var9;
                  var12[1024 + var10] = var9;
                  var12[var10 + 1536] = var9;
               } else if(var7 == 1) {
                  var12[var10] = var9;
                  var12[1 + var10] = var9;
                  var12[2 + var10] = var9;
                  var12[var10 + 3] = var9;
               } else if(var7 == 2) {
                  var12[3 + var10] = var9;
                  var12[512 + var10 + 3] = var9;
                  var12[var10 + 3 + 1024] = var9;
                  var12[1539 + var10] = var9;
               } else if(var7 == 3) {
                  var12[var10 + 1536] = var9;
                  var12[1537 + var10] = var9;
                  var12[2 + var10 + 1536] = var9;
                  var12[1539 + var10] = var9;
               }
            }

            if(3 == var8) {
               if(0 == var7) {
                  var12[var10] = var9;
               } else if(var7 == 1) {
                  var12[var10 + 3] = var9;
               } else if(var7 == 2) {
                  var12[var10 + 3 + 1536] = var9;
               } else if(3 == var7) {
                  var12[var10 + 1536] = var9;
               }
            }

            if(2 == var8) {
               if(var7 == 3) {
                  var12[var10] = var9;
                  var12[512 + var10] = var9;
                  var12[var10 + 1024] = var9;
                  var12[1536 + var10] = var9;
               } else if(var7 == 0) {
                  var12[var10] = var9;
                  var12[var10 + 1] = var9;
                  var12[2 + var10] = var9;
                  var12[3 + var10] = var9;
               } else if(var7 == 1) {
                  var12[var10 + 3] = var9;
                  var12[512 + var10 + 3] = var9;
                  var12[1024 + var10 + 3] = var9;
                  var12[1539 + var10] = var9;
               } else if(var7 == 2) {
                  var12[var10 + 1536] = var9;
                  var12[1537 + var10] = var9;
                  var12[var10 + 1536 + 2] = var9;
                  var12[1536 + var10 + 3] = var9;
               }
            }
         }
      }

      var5 = client.field339.method1944(var0, var1, var2);
      class40 var17;
      if(var5 != 0) {
         var6 = client.field339.method1925(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         var17 = class9.method120(var9);
         int var18;
         if(-1 != var17.field953) {
            var14 = class2.field60[var17.field953];
            if(var14 != null) {
               var11 = (var17.field939 * 4 - var14.field1427) / 2;
               var18 = (var17.field966 * 4 - var14.field1429) / 2;
               var14.method1841(48 + 4 * var1 + var11, 48 + 4 * (104 - var2 - var17.field966) + var18);
            }
         } else if(9 == var8) {
            var10 = 15658734;
            if(var5 > 0) {
               var10 = 15597568;
            }

            int[] var20 = class74.field1370.field1414;
            var18 = (103 - var2) * 2048 + var1 * 4 + 24624;
            if(0 != var7 && var7 != 2) {
               var20[var18] = var10;
               var20[var18 + 512 + 1] = var10;
               var20[1026 + var18] = var10;
               var20[1536 + var18 + 3] = var10;
            } else {
               var20[var18 + 1536] = var10;
               var20[var18 + 1024 + 1] = var10;
               var20[512 + var18 + 2] = var10;
               var20[3 + var18] = var10;
            }
         }
      }

      var5 = client.field339.method1924(var0, var1, var2);
      if(0 != var5) {
         var6 = var5 >> 14 & 32767;
         var17 = class9.method120(var6);
         if(var17.field953 != -1) {
            class80 var19 = class2.field60[var17.field953];
            if(var19 != null) {
               var9 = (var17.field939 * 4 - var19.field1427) / 2;
               int var21 = (var17.field966 * 4 - var19.field1429) / 2;
               var19.method1841(var9 + var1 * 4 + 48, var21 + 48 + (104 - var2 - var17.field966) * 4);
            }
         }
      }

   }
}
