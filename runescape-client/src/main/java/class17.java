import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
@Implements("Friend")
public class class17 {
   @ObfuscatedName("x")
   boolean field242;
   @ObfuscatedName("b")
   @Export("name")
   String field243;
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = 2034708677
   )
   static int field244;
   @ObfuscatedName("g")
   @Export("previousName")
   String field246;
   @ObfuscatedName("y")
   boolean field247;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1432689521
   )
   @Export("rank")
   int field248;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1632433401
   )
   @Export("world")
   int field249;
   @ObfuscatedName("aa")
   static class146 field250;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = 1403976973
   )
   protected static int field253;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 783239323
   )
   static int field254;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Lclass42;",
      garbageValue = "1772533073"
   )
   @Export("getAnimation")
   public static class42 method178(int var0) {
      class42 var1 = (class42)class42.field972.method3764((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class42.field969.method3266(12, var0);
         var1 = new class42();
         if(var2 != null) {
            var1.method870(new class119(var2));
         }

         var1.method868();
         class42.field972.method3759(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IZII)V",
      garbageValue = "1883535768"
   )
   public static final void method179(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= '뮀') {
         class56.field1153 = var0;
         class21.field581 = var1;
         class107.field1863 = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1856331674"
   )
   static final void method180(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class150.field2230.method1951(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var17;
      if(var5 != 0) {
         var6 = class150.field2230.method1955(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class44.field1017.field1380;
         var11 = 4 * var1 + 24624 + 2048 * (103 - var2);
         var17 = var5 >> 14 & 32767;
         class40 var13 = class172.method3399(var17);
         if(var13.field903 != -1) {
            class80 var14 = class136.field2073[var13.field903];
            if(null != var14) {
               int var15 = (var13.field915 * 4 - var14.field1390) / 2;
               int var16 = (var13.field904 * 4 - var14.field1391) / 2;
               var14.method1873(var1 * 4 + 48 + var15, 4 * (104 - var2 - var13.field904) + 48 + var16);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[var11 + 1024] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[3 + var11] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[3 + var11 + 1024] = var9;
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[1536 + var11 + 1] = var9;
                  var10[2 + 1536 + var11] = var9;
                  var10[3 + 1536 + var11] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[3 + var11 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[var11 + 1024] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[2 + var11] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[3 + var11 + 512] = var9;
                  var10[3 + var11 + 1024] = var9;
                  var10[3 + var11 + 1536] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var11] = var9;
                  var10[1 + 1536 + var11] = var9;
                  var10[1536 + var11 + 2] = var9;
                  var10[3 + 1536 + var11] = var9;
               }
            }
         }
      }

      var5 = class150.field2230.method1953(var0, var1, var2);
      if(var5 != 0) {
         var6 = class150.field2230.method1955(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         class40 var23 = class172.method3399(var9);
         int var18;
         if(var23.field903 != -1) {
            class80 var20 = class136.field2073[var23.field903];
            if(null != var20) {
               var17 = (var23.field915 * 4 - var20.field1390) / 2;
               var18 = (var23.field904 * 4 - var20.field1391) / 2;
               var20.method1873(var17 + 48 + var1 * 4, var18 + 48 + (104 - var2 - var23.field904) * 4);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var12 = class44.field1017.field1380;
            var18 = 24624 + var1 * 4 + 2048 * (103 - var2);
            if(var7 != 0 && var7 != 2) {
               var12[var18] = var11;
               var12[512 + var18 + 1] = var11;
               var12[1024 + var18 + 2] = var11;
               var12[var18 + 1536 + 3] = var11;
            } else {
               var12[var18 + 1536] = var11;
               var12[var18 + 1024 + 1] = var11;
               var12[var18 + 512 + 2] = var11;
               var12[var18 + 3] = var11;
            }
         }
      }

      var5 = class150.field2230.method1954(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         class40 var19 = class172.method3399(var6);
         if(var19.field903 != -1) {
            class80 var21 = class136.field2073[var19.field903];
            if(var21 != null) {
               var9 = (var19.field915 * 4 - var21.field1390) / 2;
               int var22 = (var19.field904 * 4 - var21.field1391) / 2;
               var21.method1873(48 + var1 * 4 + var9, (104 - var2 - var19.field904) * 4 + 48 + var22);
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1154240242"
   )
   public static boolean method181() {
      class210 var0 = (class210)class211.field3127.method3864();
      return null != var0;
   }
}
