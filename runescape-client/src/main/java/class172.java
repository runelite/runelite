import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class172 extends class211 {
   @ObfuscatedName("g")
   byte[] field2755;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -780685089
   )
   int field2757;
   @ObfuscatedName("e")
   class171 field2758;
   @ObfuscatedName("r")
   class137 field2759;

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(Lclass176;IIIB)V",
      garbageValue = "35"
   )
   static final void method3512(class176 var0, int var1, int var2, int var3) {
      class47.method1009();
      class178 var4 = var0.method3557(false);
      if(null != var4) {
         class82.method1908(var1, var2, var1 + var4.field2953, var4.field2950 + var2);
         if(client.field530 != 2 && client.field530 != 5) {
            int var5 = client.field399 + client.field365 & 2047;
            int var6 = class3.field65.field875 / 32 + 48;
            int var7 = 464 - class3.field65.field832 / 32;
            class23.field619.method1801(var1, var2, var4.field2953, var4.field2950, var6, var7, var5, client.field367 + 256, var4.field2954, var4.field2951);

            int var8;
            int var9;
            int var17;
            for(var8 = 0; var8 < client.field524; ++var8) {
               var9 = client.field525[var8] * 4 + 2 - class3.field65.field875 / 32;
               var17 = 2 + client.field526[var8] * 4 - class3.field65.field832 / 32;
               class0.method1(var1, var2, var9, var17, client.field453[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  class202 var10 = client.field426[class99.field1701][var8][var9];
                  if(var10 != null) {
                     var11 = 4 * var8 + 2 - class3.field65.field875 / 32;
                     var12 = var9 * 4 + 2 - class3.field65.field832 / 32;
                     class0.method1(var1, var2, var11, var12, class19.field283[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < client.field486; ++var8) {
               class36 var19 = client.field332[client.field334[var8]];
               if(var19 != null && var19.vmethod794()) {
                  class41 var20 = var19.field803;
                  if(null != var20 && null != var20.field937) {
                     var20 = var20.method820();
                  }

                  if(null != var20 && var20.field933 && var20.field940) {
                     var11 = var19.field875 / 32 - class3.field65.field875 / 32;
                     var12 = var19.field832 / 32 - class3.field65.field832 / 32;
                     class0.method1(var1, var2, var11, var12, class19.field283[1], var4);
                  }
               }
            }

            var8 = class34.field783;
            int[] var24 = class34.field784;

            for(var17 = 0; var17 < var8; ++var17) {
               class2 var18 = client.field302[var24[var17]];
               if(null != var18 && var18.vmethod794() && !var18.field51 && var18 != class3.field65) {
                  var12 = var18.field875 / 32 - class3.field65.field875 / 32;
                  int var13 = var18.field832 / 32 - class3.field65.field832 / 32;
                  boolean var14 = false;
                  if(class145.method3128(var18.field58, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < client.field522; ++var16) {
                     if(var18.field58.equals(class4.field74[var16].field645)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var23 = false;
                  if(class3.field65.field44 != 0 && var18.field44 != 0 && var18.field44 == class3.field65.field44) {
                     var23 = true;
                  }

                  if(var14) {
                     class0.method1(var1, var2, var12, var13, class19.field283[3], var4);
                  } else if(var23) {
                     class0.method1(var1, var2, var12, var13, class19.field283[4], var4);
                  } else if(var15) {
                     class0.method1(var1, var2, var12, var13, class19.field283[5], var4);
                  } else {
                     class0.method1(var1, var2, var12, var13, class19.field283[2], var4);
                  }
               }
            }

            if(client.field313 != 0 && client.field305 % 20 < 10) {
               if(client.field313 == 1 && client.field314 >= 0 && client.field314 < client.field332.length) {
                  class36 var21 = client.field332[client.field314];
                  if(null != var21) {
                     var11 = var21.field875 / 32 - class3.field65.field875 / 32;
                     var12 = var21.field832 / 32 - class3.field65.field832 / 32;
                     class44.method945(var1, var2, var11, var12, client.field463[1], var4);
                  }
               }

               if(client.field313 == 2) {
                  var17 = 2 + (client.field316 * 4 - class0.field11 * 4) - class3.field65.field875 / 32;
                  var11 = 2 + (client.field317 * 4 - class21.field592 * 4) - class3.field65.field832 / 32;
                  class44.method945(var1, var2, var17, var11, client.field463[1], var4);
               }

               if(client.field313 == 10 && client.field315 >= 0 && client.field315 < client.field302.length) {
                  class2 var22 = client.field302[client.field315];
                  if(null != var22) {
                     var11 = var22.field875 / 32 - class3.field65.field875 / 32;
                     var12 = var22.field832 / 32 - class3.field65.field832 / 32;
                     class44.method945(var1, var2, var11, var12, client.field463[1], var4);
                  }
               }
            }

            if(client.field371 != 0) {
               var17 = 2 + client.field371 * 4 - class3.field65.field875 / 32;
               var11 = client.field529 * 4 + 2 - class3.field65.field832 / 32;
               class0.method1(var1, var2, var17, var11, client.field463[0], var4);
            }

            if(!class3.field65.field51) {
               class82.method1907(var4.field2953 / 2 + var1 - 1, var4.field2950 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            class82.method1899(var1, var2, 0, var4.field2954, var4.field2951);
         }

         client.field499[var3] = true;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ZZB)I",
      garbageValue = "-23"
   )
   public static int method3513(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class174.field2774 + class174.field2781;
      return var3;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1855255590"
   )
   static final void method3514(int var0, int var1) {
      int var2 = class59.field1268.method4165("Choose Option");

      int var3;
      int var4;
      for(var3 = 0; var3 < client.field368; ++var3) {
         var4 = class59.field1268.method4165(class104.method2382(var3));
         if(var4 > var2) {
            var2 = var4;
         }
      }

      var2 += 8;
      var3 = client.field368 * 15 + 22;
      var4 = var0 - var2 / 2;
      if(var4 + var2 > class189.field3056) {
         var4 = class189.field3056 - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var5 = var1;
      if(var3 + var1 > class39.field892) {
         var5 = class39.field892 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      client.field434 = true;
      class13.field202 = var4;
      class14.field218 = var5;
      class30.field708 = var2;
      class77.field1442 = client.field368 * 15 + 22;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lclass35;I)V",
      garbageValue = "-1671353199"
   )
   static final void method3515(class35 var0) {
      if(client.field371 == class3.field65.field875 >> 7 && class3.field65.field832 >> 7 == client.field529) {
         client.field371 = 0;
      }

      int var1 = class34.field783;
      int[] var2 = class34.field784;
      int var3 = var1;
      if(var0 == class35.field796 || class35.field800 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         class2 var5;
         int var6;
         if(class35.field796 == var0) {
            var5 = class3.field65;
            var6 = class3.field65.field53 << 14;
         } else if(var0 == class35.field800) {
            var5 = client.field302[client.field425];
            var6 = client.field425 << 14;
         } else {
            var5 = client.field302[var2[var4]];
            var6 = var2[var4] << 14;
            if(class35.field798 == var0 && var2[var4] == client.field425) {
               continue;
            }
         }

         if(null != var5 && var5.vmethod794() && !var5.field51) {
            var5.field39 = false;
            if((client.field301 && var1 > 50 || var1 > 200) && class35.field796 != var0 && var5.field838 == var5.field860) {
               var5.field39 = true;
            }

            int var7 = var5.field875 >> 7;
            int var8 = var5.field832 >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.field36 != null && client.field305 >= var5.field43 && client.field305 < var5.field40) {
                  var5.field39 = false;
                  var5.field38 = class127.method2936(var5.field875, var5.field832, class99.field1701);
                  class136.field2126.method2131(class99.field1701, var5.field875, var5.field832, var5.field38, 60, var5, var5.field857, var6, var5.field55, var5.field46, var5.field47, var5.field48);
               } else {
                  if((var5.field875 & 127) == 64 && (var5.field832 & 127) == 64) {
                     if(client.field400 == client.field560[var7][var8]) {
                        continue;
                     }

                     client.field560[var7][var8] = client.field400;
                  }

                  var5.field38 = class127.method2936(var5.field875, var5.field832, class99.field1701);
                  class136.field2126.method2003(class99.field1701, var5.field875, var5.field832, var5.field38, 60, var5, var5.field857, var6, var5.field834);
               }
            }
         }
      }

   }
}
