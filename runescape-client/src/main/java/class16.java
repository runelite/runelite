import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public final class class16 extends class208 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2102814607
   )
   int field222;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1531215371
   )
   int field224;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1276562245
   )
   int field225;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1287319925
   )
   int field227;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -854408099
   )
   int field228;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1298184905
   )
   int field229;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1789755187
   )
   int field230;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1460416425
   )
   int field231;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2029852281
   )
   int field232 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 744914611
   )
   int field233 = -1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1517224873
   )
   int field234;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1792231463
   )
   int field236;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2135016762"
   )
   static final void method184() {
      for(int var0 = 0; var0 < client.field515; ++var0) {
         --client.field518[var0];
         if(client.field518[var0] >= -10) {
            class58 var9 = client.field543[var0];
            if(var9 == null) {
               class58 var10000 = (class58)null;
               var9 = class58.method1237(class101.field1741, client.field439[var0], 0);
               if(null == var9) {
                  continue;
               }

               client.field518[var0] += var9.method1245();
               client.field543[var0] = var9;
            }

            if(client.field518[var0] < 0) {
               int var2;
               if(0 != client.field519[var0]) {
                  int var3 = 128 * (client.field519[var0] & 255);
                  int var4 = client.field519[var0] >> 16 & 255;
                  int var5 = 64 + 128 * var4 - class47.field1053.field816;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = client.field519[var0] >> 8 & 255;
                  int var7 = 64 + 128 * var6 - class47.field1053.field840;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     client.field518[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * client.field514 / var3;
               } else {
                  var2 = client.field513;
               }

               if(var2 > 0) {
                  class62 var10 = var9.method1246().method1277(class108.field1886);
                  class64 var11 = class64.method1313(var10, 100, var2);
                  var11.method1303(client.field460[var0] - 1);
                  class135.field2066.method1146(var11);
               }

               client.field518[var0] = -100;
            }
         } else {
            --client.field515;

            for(int var1 = var0; var1 < client.field515; ++var1) {
               client.field439[var1] = client.field439[1 + var1];
               client.field543[var1] = client.field543[1 + var1];
               client.field460[var1] = client.field460[1 + var1];
               client.field518[var1] = client.field518[1 + var1];
               client.field519[var1] = client.field519[var1 + 1];
            }

            --var0;
         }
      }

      if(client.field512 && !class12.method161()) {
         if(client.field409 != 0 && client.field532 != -1) {
            class126.method2783(class135.field2069, client.field532, 0, client.field409, false);
         }

         client.field512 = false;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "0"
   )
   public static Object method185(byte[] var0, boolean var1) {
      if(null == var0) {
         return null;
      } else {
         if(var0.length > 136 && !class125.field2015) {
            try {
               class118 var2 = new class118();
               var2.vmethod2768(var0);
               return var2;
            } catch (Throwable var3) {
               class125.field2015 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-351157272"
   )
   static final void method186(int var0, int var1, int var2, int var3) {
      client.field516 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class32.field737;
      int[] var7 = class32.field738;

      int var8;
      for(var8 = 0; var8 < var6 + client.field314; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = client.field396[var7[var8]];
            if(var7[var8] == client.field405) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = client.field517[client.field459[var8 - var6]];
         }

         class59.method1260((class37)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class59.method1260(client.field396[client.field405], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < client.field516; ++var8) {
         int var18 = client.field371[var8];
         int var10 = client.field372[var8];
         int var11 = client.field374[var8];
         int var12 = client.field373[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(2 + var10 > client.field372[var14] - client.field373[var14] && var10 - var12 < 2 + client.field372[var14] && var18 - var11 < client.field371[var14] + client.field374[var14] && var11 + var18 > client.field371[var14] - client.field374[var14] && client.field372[var14] - client.field373[var14] < var10) {
                  var10 = client.field372[var14] - client.field373[var14];
                  var13 = true;
               }
            }
         }

         client.field277 = client.field371[var8];
         client.field382 = client.field372[var8] = var10;
         String var19 = client.field378[var8];
         if(0 == client.field435) {
            int var15 = 16776960;
            if(client.field375[var8] < 6) {
               var15 = client.field540[client.field375[var8]];
            }

            if(client.field375[var8] == 6) {
               var15 = client.field473 % 20 < 10?16711680:16776960;
            }

            if(7 == client.field375[var8]) {
               var15 = client.field473 % 20 < 10?255:'\uffff';
            }

            if(client.field375[var8] == 8) {
               var15 = client.field473 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(client.field375[var8] == 9) {
               var16 = 150 - client.field377[var8];
               if(var16 < 50) {
                  var15 = 16711680 + 1280 * var16;
               } else if(var16 < 100) {
                  var15 = 16776960 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = '\uff00' + (var16 - 100) * 5;
               }
            }

            if(client.field375[var8] == 10) {
               var16 = 150 - client.field377[var8];
               if(var16 < 50) {
                  var15 = 16711680 + var16 * 5;
               } else if(var16 < 100) {
                  var15 = 16711935 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = 327680 * (var16 - 100) + 255 - (var16 - 100) * 5;
               }
            }

            if(11 == client.field375[var8]) {
               var16 = 150 - client.field377[var8];
               if(var16 < 50) {
                  var15 = 16777215 - 327685 * var16;
               } else if(var16 < 100) {
                  var15 = '\uff00' + 327685 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = 16777215 - (var16 - 100) * 327680;
               }
            }

            if(client.field381[var8] == 0) {
               class95.field1606.method4007(var19, client.field277 + var0, var1 + client.field382, var15, 0);
            }

            if(client.field381[var8] == 1) {
               class95.field1606.method4009(var19, var0 + client.field277, client.field382 + var1, var15, 0, client.field473);
            }

            if(2 == client.field381[var8]) {
               class95.field1606.method4010(var19, client.field277 + var0, client.field382 + var1, var15, 0, client.field473);
            }

            if(client.field381[var8] == 3) {
               class95.field1606.method4011(var19, var0 + client.field277, client.field382 + var1, var15, 0, client.field473, 150 - client.field377[var8]);
            }

            if(4 == client.field381[var8]) {
               var16 = (150 - client.field377[var8]) * (class95.field1606.method4002(var19) + 100) / 150;
               class79.method1778(var0 + client.field277 - 50, var1, 50 + client.field277 + var0, var1 + var3);
               class95.field1606.method4006(var19, var0 + client.field277 + 50 - var16, var1 + client.field382, var15, 0);
               class79.method1777(var0, var1, var0 + var2, var1 + var3);
            }

            if(5 == client.field381[var8]) {
               var16 = 150 - client.field377[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               class79.method1778(var0, client.field382 + var1 - class95.field1606.field3192 - 1, var2 + var0, var1 + client.field382 + 5);
               class95.field1606.method4007(var19, var0 + client.field277, var17 + client.field382 + var1, var15, 0);
               class79.method1777(var0, var1, var2 + var0, var3 + var1);
            }
         } else {
            class95.field1606.method4007(var19, client.field277 + var0, client.field382 + var1, 16776960, 0);
         }
      }

   }
}
