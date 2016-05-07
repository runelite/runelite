import java.applet.Applet;
import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class9 {
   @ObfuscatedName("ba")
   static class168 field155;
   @ObfuscatedName("u")
   static final BigInteger field158 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("o")
   public static int[] field159;
   @ObfuscatedName("d")
   static final BigInteger field161 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("t")
   static class180 field162;

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(IIII)Lclass3;",
      garbageValue = "1067639821"
   )
   static final class3 method118(int var0, int var1, int var2) {
      class3 var3 = new class3();
      var3.field69 = var1;
      var3.field62 = var2;
      client.field308.method3778(var3, (long)var0);
      class156.method3148(var1);
      class173 var4 = class29.method645(var0);
      class34.method701(var4);
      if(null != client.field441) {
         class34.method701(client.field441);
         client.field441 = null;
      }

      class6.method96();
      class125.method2796(class217.field3171[var0 >> 16], var4, false);
      class16.method198(var1);
      if(-1 != client.field412) {
         class87.method2065(client.field412, 1);
      }

      return var3;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass40;",
      garbageValue = "-968168982"
   )
   public static class40 method120(int var0) {
      class40 var1 = (class40)class40.field926.method3743((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class103.field1782.method3239(6, var0);
         var1 = new class40();
         var1.field931 = var0;
         if(null != var2) {
            var1.method775(new class119(var2));
         }

         var1.method797();
         if(var1.field929) {
            var1.field941 = 0;
            var1.field963 = false;
         }

         class40.field926.method3745(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "0"
   )
   static final void method125(boolean var0) {
      int var1 = client.field412;
      int var2 = class15.field214;
      int var3 = class15.field215;
      if(class188.method3731(var1)) {
         class191.method3737(class217.field3171[var1], -1, var2, var3, var0);
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lclass37;IIIIIS)V",
      garbageValue = "-4182"
   )
   static final void method126(class37 var0, int var1, int var2, int var3, int var4, int var5) {
      if(null != var0 && var0.vmethod727()) {
         if(var0 instanceof class34) {
            class39 var6 = ((class34)var0).field782;
            if(null != var6.field921) {
               var6 = var6.method740();
            }

            if(null == var6) {
               return;
            }
         }

         int var10 = class32.field755;
         int[] var7 = class32.field756;
         int var8;
         if(var1 < var10) {
            var8 = 30;
            class2 var9 = (class2)var0;
            if(var9.field58) {
               return;
            }

            if(var9.field35 != -1 || var9.field49 != -1) {
               class8.method115(var0, var0.field816 + 15);
               if(client.field385 > -1) {
                  if(var9.field35 != -1) {
                     class210.field3141[var9.field35].method1676(client.field385 + var2 - 12, client.field386 + var3 - var8);
                     var8 += 25;
                  }

                  if(var9.field49 != -1) {
                     class164.field2668[var9.field49].method1676(var2 + client.field385 - 12, client.field386 + var3 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && client.field476 == 10 && var7[var1] == client.field298) {
               class8.method115(var0, var0.field816 + 15);
               if(client.field385 > -1) {
                  class39.field919[1].method1676(client.field385 + var2 - 12, var3 + client.field386 - var8);
               }
            }
         } else {
            class39 var12 = ((class34)var0).field782;
            if(null != var12.field921) {
               var12 = var12.method740();
            }

            if(var12.field910 >= 0 && var12.field910 < class164.field2668.length) {
               class8.method115(var0, var0.field816 + 15);
               if(client.field385 > -1) {
                  class164.field2668[var12.field910].method1676(client.field385 + var2 - 12, var3 + client.field386 - 30);
               }
            }

            if(1 == client.field476 && client.field297 == client.field318[var1 - var10] && client.field335 % 20 < 10) {
               class8.method115(var0, 15 + var0.field816);
               if(client.field385 > -1) {
                  class39.field919[0].method1676(var2 + client.field385 - 12, var3 + client.field386 - 28);
               }
            }
         }

         if(null != var0.field819 && (var1 >= var10 || !var0.field865 && (client.field495 == 4 || !var0.field827 && (client.field495 == 0 || client.field495 == 3 || client.field495 == 1 && class19.method241(((class2)var0).field59, false))))) {
            class8.method115(var0, var0.field816);
            if(client.field385 > -1 && client.field373 < client.field374) {
               client.field466[client.field373] = class164.field2665.method3997(var0.field819) / 2;
               client.field377[client.field373] = class164.field2665.field3189;
               client.field375[client.field373] = client.field385;
               client.field376[client.field373] = client.field386;
               client.field379[client.field373] = var0.field829;
               client.field380[client.field373] = var0.field830;
               client.field381[client.field373] = var0.field828;
               client.field384[client.field373] = var0.field819;
               ++client.field373;
            }
         }

         if(var0.field867 > client.field335) {
            class8.method115(var0, 15 + var0.field816);
            if(client.field385 > -1) {
               if(var1 < var10) {
                  var8 = 30;
               } else {
                  class39 var11 = ((class34)var0).field782;
                  var8 = var11.field917;
               }

               int var13 = var0.field846 * var8 / var0.field835;
               if(var13 > var8) {
                  var13 = var8;
               } else if(var13 == 0 && var0.field846 > 0) {
                  var13 = 1;
               }

               class79.method1808(client.field385 + var2 - var8 / 2, client.field386 + var3 - 3, var13, 5, '\uff00');
               class79.method1808(var2 + client.field385 - var8 / 2 + var13, client.field386 + var3 - 3, var8 - var13, 5, 16711680);
            }
         }

         for(var8 = 0; var8 < 4; ++var8) {
            if(var0.field833[var8] > client.field335) {
               class8.method115(var0, var0.field816 / 2);
               if(client.field385 > -1) {
                  if(var8 == 1) {
                     client.field386 -= 20;
                  }

                  if(var8 == 2) {
                     client.field385 -= 15;
                     client.field386 -= 10;
                  }

                  if(3 == var8) {
                     client.field385 += 15;
                     client.field386 -= 10;
                  }

                  class77.field1405[var0.field832[var8]].method1676(client.field385 + var2 - 12, client.field386 + var3 - 12);
                  class12.field187.method4004(Integer.toString(var0.field831[var8]), client.field385 + var2 - 1, var3 + client.field386 + 3, 16777215, 0);
               }
            }
         }

      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "68"
   )
   static void method127(int var0) {
      client.field490 = 0L;
      if(var0 >= 2) {
         client.field336 = true;
      } else {
         client.field336 = false;
      }

      class102.method2268();
      if(client.field286 >= 25) {
         class16.method195();
      }

      class144.field2212 = true;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass51;",
      garbageValue = "1310796580"
   )
   public static class51 method128(int var0) {
      class51 var1 = (class51)class51.field1140.method3743((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class177.field2924.method3239(10, var0);
         var1 = new class51();
         var1.field1114 = var0;
         if(var2 != null) {
            var1.method1012(new class119(var2));
         }

         var1.method993();
         if(var1.field1147 != -1) {
            var1.method996(method128(var1.field1147), method128(var1.field1146));
         }

         if(-1 != var1.field1156) {
            var1.method997(method128(var1.field1156), method128(var1.field1155));
         }

         if(var1.field1109 != -1) {
            var1.method998(method128(var1.field1109), method128(var1.field1157));
         }

         if(!class49.field1091 && var1.field1129) {
            var1.field1128 = "Members object";
            var1.field1154 = false;
            var1.field1130 = null;
            var1.field1124 = null;
            var1.field1153 = 0;
         }

         class51.field1140.method3745(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
      garbageValue = "-1887072438"
   )
   public static void method129(Applet var0, String var1) {
      class138.field2148 = var0;
      class138.field2147 = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2"
   )
   public static void method130(int var0) {
      class183.field2973 = 1;
      class183.field2974 = null;
      class221.field3184 = -1;
      class151.field2268 = -1;
      class183.field2971 = 0;
      class183.field2977 = false;
      class183.field2976 = var0;
   }
}
