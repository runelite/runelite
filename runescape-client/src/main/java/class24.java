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
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = client.field339.method1925(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class74.field1370.field1414;
         var11 = 2048 * (103 - var2) + 24624 + 4 * var1;
         var12 = var5 >> 14 & 32767;
         class40 var13 = class9.method120(var12);
         if(var13.field953 != -1) {
            class80 var14 = class2.field60[var13.field953];
            if(null != var14) {
               int var15 = (var13.field939 * 4 - var14.field1427) / 2;
               int var16 = (var13.field966 * 4 - var14.field1429) / 2;
               var14.method1841(48 + var1 * 4 + var15, (104 - var2 - var13.field966) * 4 + 48 + var16);
            }
         } else {
            if(var8 == 0 || 2 == var8) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[1024 + var11] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[2 + var11] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[3 + var11] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[var11 + 3 + 1024] = var9;
                  var10[1536 + 3 + var11] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[1 + 1536 + var11] = var9;
                  var10[2 + var11 + 1536] = var9;
                  var10[3 + 1536 + var11] = var9;
               }
            }

            if(3 == var8) {
               if(0 == var7) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3 + 1536] = var9;
               } else if(3 == var7) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(2 == var8) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[var11 + 1024] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[2 + var11] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[1024 + var11 + 3] = var9;
                  var10[1536 + 3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[1 + 1536 + var11] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[1536 + var11 + 3] = var9;
               }
            }
         }
      }

      var5 = client.field339.method1944(var0, var1, var2);
      if(var5 != 0) {
         var6 = client.field339.method1925(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         class40 var19 = class9.method120(var9);
         int var23;
         if(-1 != var19.field953) {
            class80 var21 = class2.field60[var19.field953];
            if(var21 != null) {
               var12 = (var19.field939 * 4 - var21.field1427) / 2;
               var23 = (var19.field966 * 4 - var21.field1429) / 2;
               var21.method1841(48 + 4 * var1 + var12, 48 + 4 * (104 - var2 - var19.field966) + var23);
            }
         } else if(9 == var8) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = class74.field1370.field1414;
            var23 = (103 - var2) * 2048 + var1 * 4 + 24624;
            if(0 != var7 && var7 != 2) {
               var22[var23] = var11;
               var22[var23 + 512 + 1] = var11;
               var22[2 + 1024 + var23] = var11;
               var22[1536 + var23 + 3] = var11;
            } else {
               var22[var23 + 1536] = var11;
               var22[var23 + 1024 + 1] = var11;
               var22[512 + var23 + 2] = var11;
               var22[3 + var23] = var11;
            }
         }
      }

      var5 = client.field339.method1924(var0, var1, var2);
      if(0 != var5) {
         var6 = var5 >> 14 & 32767;
         class40 var17 = class9.method120(var6);
         if(var17.field953 != -1) {
            class80 var18 = class2.field60[var17.field953];
            if(var18 != null) {
               var9 = (var17.field939 * 4 - var18.field1427) / 2;
               int var20 = (var17.field966 * 4 - var18.field1429) / 2;
               var18.method1841(var9 + var1 * 4 + 48, var20 + 48 + (104 - var2 - var17.field966) * 4);
            }
         }
      }

   }
}
