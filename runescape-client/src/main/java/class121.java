import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public class class121 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1118727041
   )
   static int field2010 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1214577103
   )
   static int field2013 = 0;
   @ObfuscatedName("z")
   static byte[][] field2014 = new byte[250][];
   @ObfuscatedName("r")
   static byte[][] field2015 = new byte[50][];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 377791199
   )
   static int field2017 = 0;
   @ObfuscatedName("h")
   static byte[][] field2018 = new byte[1000][];

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1070252327"
   )
   static synchronized byte[] method2703(int var0) {
      byte[] var1;
      if(var0 == 100 && field2013 > 0) {
         var1 = field2018[--field2013];
         field2018[field2013] = null;
         return var1;
      } else if(var0 == 5000 && field2010 > 0) {
         var1 = field2014[--field2010];
         field2014[field2010] = null;
         return var1;
      } else if(var0 == 30000 && field2017 > 0) {
         var1 = field2015[--field2017];
         field2015[field2017] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "1594019429"
   )
   @Export("menuAction")
   static final void method2707(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 31) {
         client.field325.method2733(216);
         client.field325.method2483(class143.field2208);
         client.field325.method2501(var0);
         client.field325.method2509(var1);
         client.field325.method2502(var3);
         client.field325.method2501(class123.field2038);
         client.field325.method2454(class127.field2059);
         client.field564 = 0;
         client.field291 = class170.method3344(var1);
         client.field397 = var0;
      }

      class34 var8;
      if(var2 == 9) {
         var8 = client.field320[var3];
         if(var8 != null) {
            client.field391 = var6;
            client.field321 = var7;
            client.field394 = 2;
            client.field393 = 0;
            client.field545 = var0;
            client.field517 = var1;
            client.field325.method2733(90);
            client.field325.method2594(class137.field2133[82]?1:0);
            client.field325.method2454(var3);
         }
      }

      class2 var17;
      if(var2 == 15) {
         var17 = client.field405[var3];
         if(var17 != null) {
            client.field391 = var6;
            client.field321 = var7;
            client.field394 = 2;
            client.field393 = 0;
            client.field545 = var0;
            client.field517 = var1;
            client.field325.method2733(183);
            client.field325.method2453(class137.field2133[82]?1:0);
            client.field325.method2501(var3);
            client.field325.method2501(client.field342);
            client.field325.method2483(class27.field669);
         }
      }

      if(var2 == 12) {
         var8 = client.field320[var3];
         if(var8 != null) {
            client.field391 = var6;
            client.field321 = var7;
            client.field394 = 2;
            client.field393 = 0;
            client.field545 = var0;
            client.field517 = var1;
            client.field325.method2733(138);
            client.field325.method2453(class137.field2133[82]?1:0);
            client.field325.method2501(var3);
         }
      }

      int var9;
      class173 var18;
      if(var2 == 28) {
         client.field325.method2733(132);
         client.field325.method2456(var1);
         var18 = class170.method3344(var1);
         if(var18.field2888 != null && var18.field2888[0][0] == 5) {
            var9 = var18.field2888[0][1];
            class176.field2923[var9] = 1 - class176.field2923[var9];
            class76.method1635(var9);
         }
      }

      if(var2 == 48) {
         var17 = client.field405[var3];
         if(var17 != null) {
            client.field391 = var6;
            client.field321 = var7;
            client.field394 = 2;
            client.field393 = 0;
            client.field545 = var0;
            client.field517 = var1;
            client.field325.method2733(99);
            client.field325.method2488(class137.field2133[82]?1:0);
            client.field325.method2454(var3);
         }
      }

      if(var2 == 23) {
         class214.field3161.method1907(class32.field754, var0, var1);
      }

      if(var2 == 22) {
         client.field391 = var6;
         client.field321 = var7;
         client.field394 = 2;
         client.field393 = 0;
         client.field545 = var0;
         client.field517 = var1;
         client.field325.method2733(54);
         client.field325.method2501(var3);
         client.field325.method2453(class137.field2133[82]?1:0);
         client.field325.method2454(client.field358 + var1);
         client.field325.method2454(var0 + class89.field1565);
      }

      if(var2 == 32) {
         client.field325.method2733(230);
         client.field325.method2456(var1);
         client.field325.method2483(class27.field669);
         client.field325.method2501(var3);
         client.field325.method2454(var0);
         client.field325.method2454(client.field342);
         client.field564 = 0;
         client.field291 = class170.method3344(var1);
         client.field397 = var0;
      }

      if(var2 == 44) {
         var17 = client.field405[var3];
         if(var17 != null) {
            client.field391 = var6;
            client.field321 = var7;
            client.field394 = 2;
            client.field393 = 0;
            client.field545 = var0;
            client.field517 = var1;
            client.field325.method2733(79);
            client.field325.method2500(var3);
            client.field325.method2594(class137.field2133[82]?1:0);
         }
      }

      if(var2 == 20) {
         client.field391 = var6;
         client.field321 = var7;
         client.field394 = 2;
         client.field393 = 0;
         client.field545 = var0;
         client.field517 = var1;
         client.field325.method2733(213);
         client.field325.method2502(class89.field1565 + var0);
         client.field325.method2594(class137.field2133[82]?1:0);
         client.field325.method2454(client.field358 + var1);
         client.field325.method2500(var3);
      }

      if(var2 == 13) {
         var8 = client.field320[var3];
         if(var8 != null) {
            client.field391 = var6;
            client.field321 = var7;
            client.field394 = 2;
            client.field393 = 0;
            client.field545 = var0;
            client.field517 = var1;
            client.field325.method2733(33);
            client.field325.method2594(class137.field2133[82]?1:0);
            client.field325.method2500(var3);
         }
      }

      if(var2 == 2) {
         client.field391 = var6;
         client.field321 = var7;
         client.field394 = 2;
         client.field393 = 0;
         client.field545 = var0;
         client.field517 = var1;
         client.field325.method2733(241);
         client.field325.method2488(class137.field2133[82]?1:0);
         client.field325.method2500(var3 >> 14 & 32767);
         client.field325.method2500(var0 + class89.field1565);
         client.field325.method2501(var1 + client.field358);
         client.field325.method2509(class27.field669);
         client.field325.method2502(client.field342);
      }

      if(var2 == 8) {
         var8 = client.field320[var3];
         if(var8 != null) {
            client.field391 = var6;
            client.field321 = var7;
            client.field394 = 2;
            client.field393 = 0;
            client.field545 = var0;
            client.field517 = var1;
            client.field325.method2733(105);
            client.field325.method2454(var3);
            client.field325.method2454(client.field342);
            client.field325.method2509(class27.field669);
            client.field325.method2492(class137.field2133[82]?1:0);
         }
      }

      if(var2 == 4) {
         client.field391 = var6;
         client.field321 = var7;
         client.field394 = 2;
         client.field393 = 0;
         client.field545 = var0;
         client.field517 = var1;
         client.field325.method2733(36);
         client.field325.method2501(class89.field1565 + var0);
         client.field325.method2453(class137.field2133[82]?1:0);
         client.field325.method2502(var3 >> 14 & 32767);
         client.field325.method2500(var1 + client.field358);
      }

      if(var2 == 24) {
         var18 = class170.method3344(var1);
         boolean var19 = true;
         if(var18.field2780 > 0) {
            var19 = class101.method2234(var18);
         }

         if(var19) {
            client.field325.method2733(132);
            client.field325.method2456(var1);
         }
      }

      if(var2 == 14) {
         var17 = client.field405[var3];
         if(null != var17) {
            client.field391 = var6;
            client.field321 = var7;
            client.field394 = 2;
            client.field393 = 0;
            client.field545 = var0;
            client.field517 = var1;
            client.field325.method2733(118);
            client.field325.method2500(class123.field2038);
            client.field325.method2510(class143.field2208);
            client.field325.method2492(class137.field2133[82]?1:0);
            client.field325.method2501(var3);
            client.field325.method2500(class127.field2059);
         }
      }

      if(var2 == 57 || var2 == 1007) {
         var18 = class74.method1561(var1, var0);
         if(null != var18) {
            class11.method129(var3, var1, var0, var18.field2896, var5);
         }
      }

      if(var2 == 45) {
         var17 = client.field405[var3];
         if(null != var17) {
            client.field391 = var6;
            client.field321 = var7;
            client.field394 = 2;
            client.field393 = 0;
            client.field545 = var0;
            client.field517 = var1;
            client.field325.method2733(115);
            client.field325.method2492(class137.field2133[82]?1:0);
            client.field325.method2454(var3);
         }
      }

      if(var2 == 58) {
         var18 = class74.method1561(var1, var0);
         if(var18 != null) {
            client.field325.method2733(207);
            client.field325.method2483(var1);
            client.field325.method2501(client.field342);
            client.field325.method2500(var18.field2896);
            client.field325.method2510(class27.field669);
            client.field325.method2502(client.field439);
            client.field325.method2454(var0);
         }
      }

      if(var2 == 11) {
         var8 = client.field320[var3];
         if(null != var8) {
            client.field391 = var6;
            client.field321 = var7;
            client.field394 = 2;
            client.field393 = 0;
            client.field545 = var0;
            client.field517 = var1;
            client.field325.method2733(199);
            client.field325.method2488(class137.field2133[82]?1:0);
            client.field325.method2500(var3);
         }
      }

      if(var2 == 1001) {
         client.field391 = var6;
         client.field321 = var7;
         client.field394 = 2;
         client.field393 = 0;
         client.field545 = var0;
         client.field517 = var1;
         client.field325.method2733(181);
         client.field325.method2500(var1 + client.field358);
         client.field325.method2502(class89.field1565 + var0);
         client.field325.method2502(var3 >> 14 & 32767);
         client.field325.method2492(class137.field2133[82]?1:0);
      }

      if(var2 == 50) {
         var17 = client.field405[var3];
         if(null != var17) {
            client.field391 = var6;
            client.field321 = var7;
            client.field394 = 2;
            client.field393 = 0;
            client.field545 = var0;
            client.field517 = var1;
            client.field325.method2733(38);
            client.field325.method2502(var3);
            client.field325.method2492(class137.field2133[82]?1:0);
         }
      }

      if(var2 == 1003) {
         client.field391 = var6;
         client.field321 = var7;
         client.field394 = 2;
         client.field393 = 0;
         var8 = client.field320[var3];
         if(null != var8) {
            class39 var16 = var8.field772;
            if(null != var16.field907) {
               var16 = var16.method752();
            }

            if(null != var16) {
               client.field325.method2733(43);
               client.field325.method2454(var16.field911);
            }
         }
      }

      if(var2 == 26) {
         client.field325.method2733(39);

         for(class3 var20 = (class3)client.field443.method3751(); var20 != null; var20 = (class3)client.field443.method3752()) {
            if(var20.field64 == 0 || var20.field64 == 3) {
               class44.method912(var20, true);
            }
         }

         if(null != client.field399) {
            class20.method547(client.field399);
            client.field399 = null;
         }
      }

      if(var2 == 3) {
         client.field391 = var6;
         client.field321 = var7;
         client.field394 = 2;
         client.field393 = 0;
         client.field545 = var0;
         client.field517 = var1;
         client.field325.method2733(121);
         client.field325.method2501(client.field358 + var1);
         client.field325.method2501(var3 >> 14 & 32767);
         client.field325.method2500(var0 + class89.field1565);
         client.field325.method2492(class137.field2133[82]?1:0);
      }

      if(var2 == 25) {
         var18 = class74.method1561(var1, var0);
         if(var18 != null) {
            class106.method2343();
            int var12 = class138.method2906(var18);
            int var11 = var12 >> 11 & 63;
            class110.method2385(var1, var0, var11, var18.field2896);
            client.field379 = 0;
            int var15 = class138.method2906(var18);
            int var14 = var15 >> 11 & 63;
            String var13;
            if(var14 == 0) {
               var13 = null;
            } else if(var18.field2796 != null && var18.field2796.trim().length() != 0) {
               var13 = var18.field2796;
            } else {
               var13 = null;
            }

            client.field432 = var13;
            if(client.field432 == null) {
               client.field432 = "Null";
            }

            if(var18.field2775) {
               client.field441 = var18.field2833 + class155.method3132(16777215);
            } else {
               client.field441 = class155.method3132('\uff00') + var18.field2892 + class155.method3132(16777215);
            }
         }

      } else {
         if(var2 == 19) {
            client.field391 = var6;
            client.field321 = var7;
            client.field394 = 2;
            client.field393 = 0;
            client.field545 = var0;
            client.field517 = var1;
            client.field325.method2733(32);
            client.field325.method2500(var3);
            client.field325.method2454(var0 + class89.field1565);
            client.field325.method2488(class137.field2133[82]?1:0);
            client.field325.method2500(client.field358 + var1);
         }

         if(var2 == 43) {
            client.field325.method2733(134);
            client.field325.method2510(var1);
            client.field325.method2502(var3);
            client.field325.method2502(var0);
            client.field564 = 0;
            client.field291 = class170.method3344(var1);
            client.field397 = var0;
         }

         if(var2 == 47) {
            var17 = client.field405[var3];
            if(var17 != null) {
               client.field391 = var6;
               client.field321 = var7;
               client.field394 = 2;
               client.field393 = 0;
               client.field545 = var0;
               client.field517 = var1;
               client.field325.method2733(87);
               client.field325.method2501(var3);
               client.field325.method2594(class137.field2133[82]?1:0);
            }
         }

         if(var2 == 16) {
            client.field391 = var6;
            client.field321 = var7;
            client.field394 = 2;
            client.field393 = 0;
            client.field545 = var0;
            client.field517 = var1;
            client.field325.method2733(214);
            client.field325.method2454(class123.field2038);
            client.field325.method2500(var0 + class89.field1565);
            client.field325.method2456(class143.field2208);
            client.field325.method2501(var3);
            client.field325.method2500(class127.field2059);
            client.field325.method2502(client.field358 + var1);
            client.field325.method2594(class137.field2133[82]?1:0);
         }

         if(var2 == 36) {
            client.field325.method2733(127);
            client.field325.method2510(var1);
            client.field325.method2502(var0);
            client.field325.method2500(var3);
            client.field564 = 0;
            client.field291 = class170.method3344(var1);
            client.field397 = var0;
         }

         if(var2 == 33) {
            client.field325.method2733(8);
            client.field325.method2501(var3);
            client.field325.method2509(var1);
            client.field325.method2501(var0);
            client.field564 = 0;
            client.field291 = class170.method3344(var1);
            client.field397 = var0;
         }

         if(var2 == 17) {
            client.field391 = var6;
            client.field321 = var7;
            client.field394 = 2;
            client.field393 = 0;
            client.field545 = var0;
            client.field517 = var1;
            client.field325.method2733(178);
            client.field325.method2488(class137.field2133[82]?1:0);
            client.field325.method2502(client.field342);
            client.field325.method2510(class27.field669);
            client.field325.method2500(client.field358 + var1);
            client.field325.method2500(class89.field1565 + var0);
            client.field325.method2502(var3);
         }

         if(var2 == 1002) {
            client.field391 = var6;
            client.field321 = var7;
            client.field394 = 2;
            client.field393 = 0;
            client.field325.method2733(57);
            client.field325.method2454(var3 >> 14 & 32767);
         }

         if(var2 == 1) {
            client.field391 = var6;
            client.field321 = var7;
            client.field394 = 2;
            client.field393 = 0;
            client.field545 = var0;
            client.field517 = var1;
            client.field325.method2733(244);
            client.field325.method2501(var3 >> 14 & 32767);
            client.field325.method2453(class137.field2133[82]?1:0);
            client.field325.method2500(class127.field2059);
            client.field325.method2456(class143.field2208);
            client.field325.method2500(class123.field2038);
            client.field325.method2500(var0 + class89.field1565);
            client.field325.method2454(var1 + client.field358);
         }

         if(var2 == 51) {
            var17 = client.field405[var3];
            if(var17 != null) {
               client.field391 = var6;
               client.field321 = var7;
               client.field394 = 2;
               client.field393 = 0;
               client.field545 = var0;
               client.field517 = var1;
               client.field325.method2733(108);
               client.field325.method2500(var3);
               client.field325.method2594(class137.field2133[82]?1:0);
            }
         }

         if(var2 == 30 && client.field399 == null) {
            class178.method3422(var1, var0);
            client.field399 = class74.method1561(var1, var0);
            class20.method547(client.field399);
         }

         if(var2 == 1004) {
            client.field391 = var6;
            client.field321 = var7;
            client.field394 = 2;
            client.field393 = 0;
            client.field325.method2733(152);
            client.field325.method2454(var3);
         }

         if(var2 == 1005) {
            var18 = class170.method3344(var1);
            if(var18 != null && var18.field2868[var0] >= 100000) {
               class33.method702(27, "", var18.field2868[var0] + " x " + class123.method2743(var3).field1120);
            } else {
               client.field325.method2733(152);
               client.field325.method2454(var3);
            }

            client.field564 = 0;
            client.field291 = class170.method3344(var1);
            client.field397 = var0;
         }

         if(var2 == 18) {
            client.field391 = var6;
            client.field321 = var7;
            client.field394 = 2;
            client.field393 = 0;
            client.field545 = var0;
            client.field517 = var1;
            client.field325.method2733(63);
            client.field325.method2500(var3);
            client.field325.method2500(client.field358 + var1);
            client.field325.method2492(class137.field2133[82]?1:0);
            client.field325.method2500(var0 + class89.field1565);
         }

         if(var2 == 21) {
            client.field391 = var6;
            client.field321 = var7;
            client.field394 = 2;
            client.field393 = 0;
            client.field545 = var0;
            client.field517 = var1;
            client.field325.method2733(151);
            client.field325.method2500(client.field358 + var1);
            client.field325.method2454(var3);
            client.field325.method2500(var0 + class89.field1565);
            client.field325.method2488(class137.field2133[82]?1:0);
         }

         if(var2 == 46) {
            var17 = client.field405[var3];
            if(var17 != null) {
               client.field391 = var6;
               client.field321 = var7;
               client.field394 = 2;
               client.field393 = 0;
               client.field545 = var0;
               client.field517 = var1;
               client.field325.method2733(11);
               client.field325.method2488(class137.field2133[82]?1:0);
               client.field325.method2501(var3);
            }
         }

         if(var2 == 35) {
            client.field325.method2733(96);
            client.field325.method2501(var0);
            client.field325.method2456(var1);
            client.field325.method2500(var3);
            client.field564 = 0;
            client.field291 = class170.method3344(var1);
            client.field397 = var0;
         }

         if(var2 == 40) {
            client.field325.method2733(40);
            client.field325.method2456(var1);
            client.field325.method2501(var0);
            client.field325.method2501(var3);
            client.field564 = 0;
            client.field291 = class170.method3344(var1);
            client.field397 = var0;
         }

         if(var2 == 7) {
            var8 = client.field320[var3];
            if(var8 != null) {
               client.field391 = var6;
               client.field321 = var7;
               client.field394 = 2;
               client.field393 = 0;
               client.field545 = var0;
               client.field517 = var1;
               client.field325.method2733(64);
               client.field325.method2500(class127.field2059);
               client.field325.method2510(class143.field2208);
               client.field325.method2454(class123.field2038);
               client.field325.method2500(var3);
               client.field325.method2488(class137.field2133[82]?1:0);
            }
         }

         if(var2 == 29) {
            client.field325.method2733(132);
            client.field325.method2456(var1);
            var18 = class170.method3344(var1);
            if(var18.field2888 != null && var18.field2888[0][0] == 5) {
               var9 = var18.field2888[0][1];
               if(class176.field2923[var9] != var18.field2890[0]) {
                  class176.field2923[var9] = var18.field2890[0];
                  class76.method1635(var9);
               }
            }
         }

         if(var2 == 37) {
            client.field325.method2733(245);
            client.field325.method2483(var1);
            client.field325.method2501(var0);
            client.field325.method2502(var3);
            client.field564 = 0;
            client.field291 = class170.method3344(var1);
            client.field397 = var0;
         }

         if(var2 == 39) {
            client.field325.method2733(236);
            client.field325.method2500(var3);
            client.field325.method2456(var1);
            client.field325.method2454(var0);
            client.field564 = 0;
            client.field291 = class170.method3344(var1);
            client.field397 = var0;
         }

         if(var2 == 42) {
            client.field325.method2733(172);
            client.field325.method2501(var3);
            client.field325.method2454(var0);
            client.field325.method2483(var1);
            client.field564 = 0;
            client.field291 = class170.method3344(var1);
            client.field397 = var0;
         }

         if(var2 == 49) {
            var17 = client.field405[var3];
            if(null != var17) {
               client.field391 = var6;
               client.field321 = var7;
               client.field394 = 2;
               client.field393 = 0;
               client.field545 = var0;
               client.field517 = var1;
               client.field325.method2733(89);
               client.field325.method2488(class137.field2133[82]?1:0);
               client.field325.method2500(var3);
            }
         }

         if(var2 == 41) {
            client.field325.method2733(252);
            client.field325.method2483(var1);
            client.field325.method2500(var3);
            client.field325.method2454(var0);
            client.field564 = 0;
            client.field291 = class170.method3344(var1);
            client.field397 = var0;
         }

         if(var2 == 10) {
            var8 = client.field320[var3];
            if(var8 != null) {
               client.field391 = var6;
               client.field321 = var7;
               client.field394 = 2;
               client.field393 = 0;
               client.field545 = var0;
               client.field517 = var1;
               client.field325.method2733(176);
               client.field325.method2488(class137.field2133[82]?1:0);
               client.field325.method2454(var3);
            }
         }

         if(var2 == 38) {
            class106.method2343();
            var18 = class170.method3344(var1);
            client.field379 = 1;
            class127.field2059 = var0;
            class143.field2208 = var1;
            class123.field2038 = var3;
            class20.method547(var18);
            client.field463 = class155.method3132(16748608) + class123.method2743(var3).field1120 + class155.method3132(16777215);
            if(null == client.field463) {
               client.field463 = "null";
            }

         } else {
            if(var2 == 6) {
               client.field391 = var6;
               client.field321 = var7;
               client.field394 = 2;
               client.field393 = 0;
               client.field545 = var0;
               client.field517 = var1;
               client.field325.method2733(162);
               client.field325.method2454(var3 >> 14 & 32767);
               client.field325.method2502(var0 + class89.field1565);
               client.field325.method2488(class137.field2133[82]?1:0);
               client.field325.method2454(client.field358 + var1);
            }

            if(var2 == 5) {
               client.field391 = var6;
               client.field321 = var7;
               client.field394 = 2;
               client.field393 = 0;
               client.field545 = var0;
               client.field517 = var1;
               client.field325.method2733(113);
               client.field325.method2500(var3 >> 14 & 32767);
               client.field325.method2502(var0 + class89.field1565);
               client.field325.method2454(var1 + client.field358);
               client.field325.method2488(class137.field2133[82]?1:0);
            }

            if(var2 == 34) {
               client.field325.method2733(195);
               client.field325.method2500(var0);
               client.field325.method2501(var3);
               client.field325.method2510(var1);
               client.field564 = 0;
               client.field291 = class170.method3344(var1);
               client.field397 = var0;
            }

            if(client.field379 != 0) {
               client.field379 = 0;
               class20.method547(class170.method3344(class143.field2208));
            }

            if(client.field437) {
               class106.method2343();
            }

            if(null != client.field291 && client.field564 == 0) {
               class20.method547(client.field291);
            }

         }
      }
   }
}
