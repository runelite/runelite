package net.runelite.rs.client;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("i")
@Implements("Ignore")
public class class7 {
   @ObfuscatedName("m")
   @Export("previousName")
   String field126;
   @ObfuscatedName("j")
   @Export("name")
   String field130;
   @ObfuscatedName("bl")
   static class167 field131;

   @ObfuscatedName("k")
   public static void method121() {
      class39.field879.method3806();
      class39.field884.method3806();
   }

   @ObfuscatedName("j")
   public static void method122(class166 var0, class166 var1, class166 var2) {
      class42.field989 = var0;
      class141.field2161 = var1;
      class42.field974 = var2;
   }

   @ObfuscatedName("bj")
   static final void method123(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class24.field610.method1958(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(0 != var5) {
         var6 = class24.field610.method1962(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class97.field1655.field1394;
         var11 = (103 - var2) * 2048 + 4 * var1 + 24624;
         var12 = var5 >> 14 & 32767;
         class40 var13 = class33.method755(var12);
         if(-1 != var13.field934) {
            class80 var14 = class118.field1986[var13.field934];
            if(null != var14) {
               int var15 = (var13.field919 * 4 - var14.field1407) / 2;
               int var16 = (var13.field920 * 4 - var14.field1410) / 2;
               var14.method1881(var15 + 48 + 4 * var1, 48 + 4 * (104 - var2 - var13.field920) + var16);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[1024 + var11] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(2 == var7) {
                  var10[var11 + 3] = var9;
                  var10[512 + 3 + var11] = var9;
                  var10[3 + var11 + 1024] = var9;
                  var10[1536 + 3 + var11] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
                  var10[1536 + var11 + 1] = var9;
                  var10[2 + var11 + 1536] = var9;
                  var10[1536 + var11 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(0 == var7) {
                  var10[var11] = var9;
               } else if(1 == var7) {
                  var10[3 + var11] = var9;
               } else if(2 == var7) {
                  var10[1536 + var11 + 3] = var9;
               } else if(3 == var7) {
                  var10[1536 + var11] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[2 + var11] = var9;
                  var10[var11 + 3] = var9;
               } else if(1 == var7) {
                  var10[var11 + 3] = var9;
                  var10[3 + var11 + 512] = var9;
                  var10[1024 + 3 + var11] = var9;
                  var10[1536 + 3 + var11] = var9;
               } else if(2 == var7) {
                  var10[1536 + var11] = var9;
                  var10[1 + 1536 + var11] = var9;
                  var10[2 + 1536 + var11] = var9;
                  var10[3 + 1536 + var11] = var9;
               }
            }
         }
      }

      var5 = class24.field610.method2046(var0, var1, var2);
      if(var5 != 0) {
         var6 = class24.field610.method1962(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         class40 var19 = class33.method755(var9);
         int var23;
         if(-1 != var19.field934) {
            class80 var21 = class118.field1986[var19.field934];
            if(var21 != null) {
               var12 = (var19.field919 * 4 - var21.field1407) / 2;
               var23 = (var19.field920 * 4 - var21.field1410) / 2;
               var21.method1881(var1 * 4 + 48 + var12, var23 + 48 + (104 - var2 - var19.field920) * 4);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = class97.field1655.field1394;
            var23 = (103 - var2) * 2048 + var1 * 4 + 24624;
            if(0 != var7 && var7 != 2) {
               var22[var23] = var11;
               var22[1 + 512 + var23] = var11;
               var22[var23 + 1024 + 2] = var11;
               var22[3 + 1536 + var23] = var11;
            } else {
               var22[1536 + var23] = var11;
               var22[1024 + var23 + 1] = var11;
               var22[var23 + 512 + 2] = var11;
               var22[3 + var23] = var11;
            }
         }
      }

      var5 = class24.field610.method2082(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         class40 var17 = class33.method755(var6);
         if(var17.field934 != -1) {
            class80 var18 = class118.field1986[var17.field934];
            if(null != var18) {
               var9 = (var17.field919 * 4 - var18.field1407) / 2;
               int var20 = (var17.field920 * 4 - var18.field1410) / 2;
               var18.method1881(48 + var1 * 4 + var9, (104 - var2 - var17.field920) * 4 + 48 + var20);
            }
         }
      }

   }

   @ObfuscatedName("ax")
   static final void method124(class66 var0) {
      var0.field1251 = false;
      if(null != var0.field1253) {
         var0.field1253.field1250 = 0;
      }

      for(class66 var1 = var0.vmethod3774(); null != var1; var1 = var0.vmethod3770()) {
         method124(var1);
      }

   }

   @ObfuscatedName("db")
   static final void method125(class3 var0, boolean var1) {
      int var2 = var0.field63;
      int var3 = (int)var0.field3104;
      var0.method3965();
      if(var1) {
         class120.method2780(var2);
      }

      class12.method188(var2);
      class172 var4 = class48.method1036(var3);
      if(var4 != null) {
         class42.method942(var4);
      }

      for(int var5 = 0; var5 < client.field416; ++var5) {
         if(class120.method2775(client.field419[var5])) {
            if(var5 < client.field416 - 1) {
               for(int var6 = var5; var6 < client.field416 - 1; ++var6) {
                  client.field297[var6] = client.field297[var6 + 1];
                  client.field422[var6] = client.field422[1 + var6];
                  client.field419[var6] = client.field419[var6 + 1];
                  client.field415[var6] = client.field415[var6 + 1];
                  client.field417[var6] = client.field417[1 + var6];
                  client.field418[var6] = client.field418[1 + var6];
               }
            }

            --client.field416;
         }
      }

      if(-1 != client.field438) {
         class15.method198(client.field438, 1);
      }

   }

   @ObfuscatedName("dq")
   static int method126(class172 var0) {
      class200 var1 = (class200)client.field476.method3836((long)var0.field2735 + ((long)(var0.field2734 * -1) << 32));
      return var1 != null?var1.field3089:var0.field2864;
   }
}
