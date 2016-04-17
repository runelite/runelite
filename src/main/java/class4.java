import java.applet.Applet;
import java.math.BigInteger;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("y")
public class class4 {
   @ObfuscatedName("w")
   static final BigInteger field74 = new BigInteger("9c2238fa4d372a31c6b8e426528e1e54cbaa3635704c277068c613dbc76e04492fc8b8642b5119161b7ec58b96abd72931e9d063f1afaaccfc1e6143fb91622506c9e19b816441df3be467b5a9dbd65c4f506144fb264b591a296645f6a9a0d8be7fd72daa0ac378fd3ebbc7992e0ee37252e3d5f2fcbe48e031b0517df155c5", 16);
   @ObfuscatedName("en")
   static class78[] field75;
   @ObfuscatedName("e")
   static class173 field76;
   @ObfuscatedName("t")
   static int[][][] field77;
   @ObfuscatedName("a")
   static final BigInteger field80 = new BigInteger("10001", 16);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)[Lclass153;",
      garbageValue = "649465588"
   )
   public static class153[] method51() {
      return new class153[]{class153.field2276, class153.field2272, class153.field2271, class153.field2273};
   }

   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)Lclass173;",
      garbageValue = "418237357"
   )
   static class173 method52(class173 var0) {
      int var1 = class136.method2992(class31.method776(var0));
      if(var1 == 0) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = class20.method641(var0.field2777);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1605628917"
   )
   public static void method53() {
      class51.field1151.method3843();
      class51.field1120.method3843();
      class51.field1146.method3843();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "-1753739740"
   )
   static boolean method54(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class138.field2135.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var13 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var14 = 0; var14 < var0.length(); ++var14) {
                  if(var13.indexOf(var0.charAt(var14)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var7) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Applet var4 = class138.field2137;
            Object[] var5 = new Object[]{(new URL(class138.field2137.getCodeBase(), var0)).toString()};
            Object var12 = JSObject.getWindow(var4).call(var2, var5);
            return null != var12;
         } catch (Throwable var8) {
            return false;
         }
      } else if(2 == var1) {
         try {
            class138.field2137.getAppletContext().showDocument(new URL(class138.field2137.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var9) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            Applet var3 = class138.field2137;
            JSObject.getWindow(var3).call("loggedout", (Object[])null);
         } catch (Throwable var11) {
            ;
         }

         try {
            class138.field2137.getAppletContext().showDocument(new URL(class138.field2137.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("a")
   public static final void method55(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            class149.method3237(var0 - 1L);
            class149.method3237(1L);
         } else {
            class149.method3237(var0);
         }

      }
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "711822225"
   )
   static final void method56(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      class34 var8;
      if(var2 == 11) {
         var8 = client.field546[var3];
         if(var8 != null) {
            client.field402 = var6;
            client.field403 = var7;
            client.field467 = 2;
            client.field404 = 0;
            client.field528 = var0;
            client.field347 = var1;
            client.field338.method2873(120);
            client.field338.method2599(var3);
            client.field338.method2638(class137.field2115[82]?1:0);
         }
      }

      if(var2 == 19) {
         client.field402 = var6;
         client.field403 = var7;
         client.field467 = 2;
         client.field404 = 0;
         client.field528 = var0;
         client.field347 = var1;
         client.field338.method2873(4);
         client.field338.method2645(class3.field67 + var1);
         client.field338.method2599(var3);
         client.field338.method2603(class137.field2115[82]?1:0);
         client.field338.method2599(class144.field2204 + var0);
      }

      class2 var10;
      if(50 == var2) {
         var10 = client.field550[var3];
         if(var10 != null) {
            client.field402 = var6;
            client.field403 = var7;
            client.field467 = 2;
            client.field404 = 0;
            client.field528 = var0;
            client.field347 = var1;
            client.field338.method2873(0);
            client.field338.method2638(class137.field2115[82]?1:0);
            client.field338.method2745(var3);
         }
      }

      if(var2 == 34) {
         client.field338.method2873(38);
         client.field338.method2634(var0);
         client.field338.method2786(var1);
         client.field338.method2599(var3);
         client.field406 = 0;
         class130.field2061 = class20.method641(var1);
         client.field407 = var0;
      }

      if(var2 == 47) {
         var10 = client.field550[var3];
         if(var10 != null) {
            client.field402 = var6;
            client.field403 = var7;
            client.field467 = 2;
            client.field404 = 0;
            client.field528 = var0;
            client.field347 = var1;
            client.field338.method2873(174);
            client.field338.method2638(class137.field2115[82]?1:0);
            client.field338.method2599(var3);
         }
      }

      class173 var11;
      if(var2 == 1005) {
         var11 = class20.method641(var1);
         if(null != var11 && var11.field2877[var0] >= 100000) {
            class129.method2943(27, "", var11.field2877[var0] + " x " + class11.method178(var3).field1125);
         } else {
            client.field338.method2873(144);
            client.field338.method2645(var3);
         }

         client.field406 = 0;
         class130.field2061 = class20.method641(var1);
         client.field407 = var0;
      }

      if(var2 == 3) {
         client.field402 = var6;
         client.field403 = var7;
         client.field467 = 2;
         client.field404 = 0;
         client.field528 = var0;
         client.field347 = var1;
         client.field338.method2873(253);
         client.field338.method2603(class137.field2115[82]?1:0);
         client.field338.method2599(var3 >> 14 & 32767);
         client.field338.method2745(var0 + class144.field2204);
         client.field338.method2634(var1 + class3.field67);
      }

      if(20 == var2) {
         client.field402 = var6;
         client.field403 = var7;
         client.field467 = 2;
         client.field404 = 0;
         client.field528 = var0;
         client.field347 = var1;
         client.field338.method2873(156);
         client.field338.method2603(class137.field2115[82]?1:0);
         client.field338.method2634(class144.field2204 + var0);
         client.field338.method2634(var3);
         client.field338.method2745(var1 + class3.field67);
      }

      if(35 == var2) {
         client.field338.method2873(2);
         client.field338.method2655(var1);
         client.field338.method2634(var3);
         client.field338.method2645(var0);
         client.field406 = 0;
         class130.field2061 = class20.method641(var1);
         client.field407 = var0;
      }

      if(var2 == 38) {
         class10.method169();
         var11 = class20.method641(var1);
         client.field448 = 1;
         class11.field187 = var0;
         class40.field931 = var1;
         class226.field3212 = var3;
         class23.method657(var11);
         client.field378 = class139.method3046(16748608) + class11.method178(var3).field1125 + class139.method3046(16777215);
         if(null == client.field378) {
            client.field378 = "null";
         }

      } else {
         if(var2 == 45) {
            var10 = client.field550[var3];
            if(null != var10) {
               client.field402 = var6;
               client.field403 = var7;
               client.field467 = 2;
               client.field404 = 0;
               client.field528 = var0;
               client.field347 = var1;
               client.field338.method2873(211);
               client.field338.method2743(class137.field2115[82]?1:0);
               client.field338.method2634(var3);
            }
         }

         if(44 == var2) {
            var10 = client.field550[var3];
            if(var10 != null) {
               client.field402 = var6;
               client.field403 = var7;
               client.field467 = 2;
               client.field404 = 0;
               client.field528 = var0;
               client.field347 = var1;
               client.field338.method2873(72);
               client.field338.method2745(var3);
               client.field338.method2743(class137.field2115[82]?1:0);
            }
         }

         if(6 == var2) {
            client.field402 = var6;
            client.field403 = var7;
            client.field467 = 2;
            client.field404 = 0;
            client.field528 = var0;
            client.field347 = var1;
            client.field338.method2873(67);
            client.field338.method2743(class137.field2115[82]?1:0);
            client.field338.method2599(var3 >> 14 & 32767);
            client.field338.method2645(var1 + class3.field67);
            client.field338.method2745(class144.field2204 + var0);
         }

         if(14 == var2) {
            var10 = client.field550[var3];
            if(null != var10) {
               client.field402 = var6;
               client.field403 = var7;
               client.field467 = 2;
               client.field404 = 0;
               client.field528 = var0;
               client.field347 = var1;
               client.field338.method2873(255);
               client.field338.method2745(class11.field187);
               client.field338.method2634(class226.field3212);
               client.field338.method2634(var3);
               client.field338.method2637(class137.field2115[82]?1:0);
               client.field338.method2786(class40.field931);
            }
         }

         if(var2 == 51) {
            var10 = client.field550[var3];
            if(var10 != null) {
               client.field402 = var6;
               client.field403 = var7;
               client.field467 = 2;
               client.field404 = 0;
               client.field528 = var0;
               client.field347 = var1;
               client.field338.method2873(179);
               client.field338.method2645(var3);
               client.field338.method2638(class137.field2115[82]?1:0);
            }
         }

         if(var2 == 41) {
            client.field338.method2873(107);
            client.field338.method2653(var1);
            client.field338.method2645(var0);
            client.field338.method2745(var3);
            client.field406 = 0;
            class130.field2061 = class20.method641(var1);
            client.field407 = var0;
         }

         if(40 == var2) {
            client.field338.method2873(230);
            client.field338.method2599(var3);
            client.field338.method2653(var1);
            client.field338.method2634(var0);
            client.field406 = 0;
            class130.field2061 = class20.method641(var1);
            client.field407 = var0;
         }

         if(var2 == 1001) {
            client.field402 = var6;
            client.field403 = var7;
            client.field467 = 2;
            client.field404 = 0;
            client.field528 = var0;
            client.field347 = var1;
            client.field338.method2873(102);
            client.field338.method2745(var3 >> 14 & 32767);
            client.field338.method2745(var1 + class3.field67);
            client.field338.method2645(class144.field2204 + var0);
            client.field338.method2743(class137.field2115[82]?1:0);
         }

         if(var2 == 23) {
            class30.field717.method2045(class42.field1002, var0, var1);
         }

         if(var2 == 4) {
            client.field402 = var6;
            client.field403 = var7;
            client.field467 = 2;
            client.field404 = 0;
            client.field528 = var0;
            client.field347 = var1;
            client.field338.method2873(216);
            client.field338.method2603(class137.field2115[82]?1:0);
            client.field338.method2634(var1 + class3.field67);
            client.field338.method2634(var3 >> 14 & 32767);
            client.field338.method2645(var0 + class144.field2204);
         }

         if(var2 == 17) {
            client.field402 = var6;
            client.field403 = var7;
            client.field467 = 2;
            client.field404 = 0;
            client.field528 = var0;
            client.field347 = var1;
            client.field338.method2873(184);
            client.field338.method2599(var1 + class3.field67);
            client.field338.method2645(var3);
            client.field338.method2599(var0 + class144.field2204);
            client.field338.method2745(client.field386);
            client.field338.method2743(class137.field2115[82]?1:0);
            client.field338.method2655(class9.field169);
         }

         if(32 == var2) {
            client.field338.method2873(20);
            client.field338.method2645(var3);
            client.field338.method2634(client.field386);
            client.field338.method2786(var1);
            client.field338.method2745(var0);
            client.field338.method2653(class9.field169);
            client.field406 = 0;
            class130.field2061 = class20.method641(var1);
            client.field407 = var0;
         }

         if(var2 == 1) {
            client.field402 = var6;
            client.field403 = var7;
            client.field467 = 2;
            client.field404 = 0;
            client.field528 = var0;
            client.field347 = var1;
            client.field338.method2873(60);
            client.field338.method2786(class40.field931);
            client.field338.method2645(var1 + class3.field67);
            client.field338.method2634(class226.field3212);
            client.field338.method2634(var3 >> 14 & 32767);
            client.field338.method2638(class137.field2115[82]?1:0);
            client.field338.method2634(class11.field187);
            client.field338.method2645(var0 + class144.field2204);
         }

         if(33 == var2) {
            client.field338.method2873(141);
            client.field338.method2634(var0);
            client.field338.method2645(var3);
            client.field338.method2653(var1);
            client.field406 = 0;
            class130.field2061 = class20.method641(var1);
            client.field407 = var0;
         }

         if(var2 == 49) {
            var10 = client.field550[var3];
            if(null != var10) {
               client.field402 = var6;
               client.field403 = var7;
               client.field467 = 2;
               client.field404 = 0;
               client.field528 = var0;
               client.field347 = var1;
               client.field338.method2873(31);
               client.field338.method2634(var3);
               client.field338.method2603(class137.field2115[82]?1:0);
            }
         }

         int var9;
         if(var2 == 29) {
            client.field338.method2873(92);
            client.field338.method2786(var1);
            var11 = class20.method641(var1);
            if(null != var11.field2870 && 5 == var11.field2870[0][0]) {
               var9 = var11.field2870[0][1];
               if(class176.field2905[var9] != var11.field2770[0]) {
                  class176.field2905[var9] = var11.field2770[0];
                  class0.method2(var9);
               }
            }
         }

         if(var2 == 39) {
            client.field338.method2873(191);
            client.field338.method2745(var3);
            client.field338.method2653(var1);
            client.field338.method2634(var0);
            client.field406 = 0;
            class130.field2061 = class20.method641(var1);
            client.field407 = var0;
         }

         if(25 == var2) {
            var11 = class210.method4010(var1, var0);
            if(var11 != null) {
               class10.method169();
               class98.method2282(var1, var0, class98.method2283(class31.method776(var11)), var11.field2878);
               client.field448 = 0;
               client.field297 = class96.method2276(var11);
               if(null == client.field297) {
                  client.field297 = "Null";
               }

               if(var11.field2757) {
                  client.field534 = var11.field2831 + class139.method3046(16777215);
               } else {
                  client.field534 = class139.method3046('\uff00') + var11.field2874 + class139.method3046(16777215);
               }
            }

         } else {
            if(var2 == 31) {
               client.field338.method2873(23);
               client.field338.method2653(class40.field931);
               client.field338.method2599(class11.field187);
               client.field338.method2599(var3);
               client.field338.method2599(class226.field3212);
               client.field338.method2599(var0);
               client.field338.method2653(var1);
               client.field406 = 0;
               class130.field2061 = class20.method641(var1);
               client.field407 = var0;
            }

            if(10 == var2) {
               var8 = client.field546[var3];
               if(var8 != null) {
                  client.field402 = var6;
                  client.field403 = var7;
                  client.field467 = 2;
                  client.field404 = 0;
                  client.field528 = var0;
                  client.field347 = var1;
                  client.field338.method2873(96);
                  client.field338.method2603(class137.field2115[82]?1:0);
                  client.field338.method2645(var3);
               }
            }

            if(var2 == 15) {
               var10 = client.field550[var3];
               if(var10 != null) {
                  client.field402 = var6;
                  client.field403 = var7;
                  client.field467 = 2;
                  client.field404 = 0;
                  client.field528 = var0;
                  client.field347 = var1;
                  client.field338.method2873(202);
                  client.field338.method2634(var3);
                  client.field338.method2655(class9.field169);
                  client.field338.method2599(client.field386);
                  client.field338.method2638(class137.field2115[82]?1:0);
               }
            }

            if(var2 == 5) {
               client.field402 = var6;
               client.field403 = var7;
               client.field467 = 2;
               client.field404 = 0;
               client.field528 = var0;
               client.field347 = var1;
               client.field338.method2873(180);
               client.field338.method2745(var3 >> 14 & 32767);
               client.field338.method2603(class137.field2115[82]?1:0);
               client.field338.method2634(class144.field2204 + var0);
               client.field338.method2645(class3.field67 + var1);
            }

            if(var2 == 24) {
               var11 = class20.method641(var1);
               boolean var12 = true;
               if(var11.field2762 > 0) {
                  var12 = class155.method3261(var11);
               }

               if(var12) {
                  client.field338.method2873(92);
                  client.field338.method2786(var1);
               }
            }

            if(var2 == 7) {
               var8 = client.field546[var3];
               if(null != var8) {
                  client.field402 = var6;
                  client.field403 = var7;
                  client.field467 = 2;
                  client.field404 = 0;
                  client.field528 = var0;
                  client.field347 = var1;
                  client.field338.method2873(69);
                  client.field338.method2634(class226.field3212);
                  client.field338.method2638(class137.field2115[82]?1:0);
                  client.field338.method2599(var3);
                  client.field338.method2786(class40.field931);
                  client.field338.method2634(class11.field187);
               }
            }

            if(var2 == 28) {
               client.field338.method2873(92);
               client.field338.method2786(var1);
               var11 = class20.method641(var1);
               if(var11.field2870 != null && var11.field2870[0][0] == 5) {
                  var9 = var11.field2870[0][1];
                  class176.field2905[var9] = 1 - class176.field2905[var9];
                  class0.method2(var9);
               }
            }

            if(21 == var2) {
               client.field402 = var6;
               client.field403 = var7;
               client.field467 = 2;
               client.field404 = 0;
               client.field528 = var0;
               client.field347 = var1;
               client.field338.method2873(118);
               client.field338.method2745(var3);
               client.field338.method2599(class3.field67 + var1);
               client.field338.method2645(class144.field2204 + var0);
               client.field338.method2638(class137.field2115[82]?1:0);
            }

            if(var2 == 42) {
               client.field338.method2873(164);
               client.field338.method2745(var0);
               client.field338.method2634(var3);
               client.field338.method2786(var1);
               client.field406 = 0;
               class130.field2061 = class20.method641(var1);
               client.field407 = var0;
            }

            if(2 == var2) {
               client.field402 = var6;
               client.field403 = var7;
               client.field467 = 2;
               client.field404 = 0;
               client.field528 = var0;
               client.field347 = var1;
               client.field338.method2873(10);
               client.field338.method2645(var0 + class144.field2204);
               client.field338.method2743(class137.field2115[82]?1:0);
               client.field338.method2634(var3 >> 14 & 32767);
               client.field338.method2599(client.field386);
               client.field338.method2606(class9.field169);
               client.field338.method2599(var1 + class3.field67);
            }

            if(16 == var2) {
               client.field402 = var6;
               client.field403 = var7;
               client.field467 = 2;
               client.field404 = 0;
               client.field528 = var0;
               client.field347 = var1;
               client.field338.method2873(159);
               client.field338.method2599(var1 + class3.field67);
               client.field338.method2645(class226.field3212);
               client.field338.method2634(var3);
               client.field338.method2603(class137.field2115[82]?1:0);
               client.field338.method2645(class11.field187);
               client.field338.method2645(class144.field2204 + var0);
               client.field338.method2655(class40.field931);
            }

            if(13 == var2) {
               var8 = client.field546[var3];
               if(null != var8) {
                  client.field402 = var6;
                  client.field403 = var7;
                  client.field467 = 2;
                  client.field404 = 0;
                  client.field528 = var0;
                  client.field347 = var1;
                  client.field338.method2873(33);
                  client.field338.method2745(var3);
                  client.field338.method2638(class137.field2115[82]?1:0);
               }
            }

            if(36 == var2) {
               client.field338.method2873(134);
               client.field338.method2745(var3);
               client.field338.method2653(var1);
               client.field338.method2745(var0);
               client.field406 = 0;
               class130.field2061 = class20.method641(var1);
               client.field407 = var0;
            }

            if(26 == var2) {
               class138.method3042();
            }

            if(var2 == 57 || 1007 == var2) {
               var11 = class210.method4010(var1, var0);
               if(var11 != null) {
                  class116.method2555(var3, var1, var0, var11.field2878, var5);
               }
            }

            if(var2 == 1004) {
               client.field402 = var6;
               client.field403 = var7;
               client.field467 = 2;
               client.field404 = 0;
               client.field338.method2873(144);
               client.field338.method2645(var3);
            }

            if(46 == var2) {
               var10 = client.field550[var3];
               if(null != var10) {
                  client.field402 = var6;
                  client.field403 = var7;
                  client.field467 = 2;
                  client.field404 = 0;
                  client.field528 = var0;
                  client.field347 = var1;
                  client.field338.method2873(95);
                  client.field338.method2603(class137.field2115[82]?1:0);
                  client.field338.method2634(var3);
               }
            }

            if(8 == var2) {
               var8 = client.field546[var3];
               if(null != var8) {
                  client.field402 = var6;
                  client.field403 = var7;
                  client.field467 = 2;
                  client.field404 = 0;
                  client.field528 = var0;
                  client.field347 = var1;
                  client.field338.method2873(40);
                  client.field338.method2786(class9.field169);
                  client.field338.method2745(client.field386);
                  client.field338.method2743(class137.field2115[82]?1:0);
                  client.field338.method2634(var3);
               }
            }

            if(var2 == 18) {
               client.field402 = var6;
               client.field403 = var7;
               client.field467 = 2;
               client.field404 = 0;
               client.field528 = var0;
               client.field347 = var1;
               client.field338.method2873(163);
               client.field338.method2599(class3.field67 + var1);
               client.field338.method2745(var0 + class144.field2204);
               client.field338.method2638(class137.field2115[82]?1:0);
               client.field338.method2634(var3);
            }

            if(var2 == 12) {
               var8 = client.field546[var3];
               if(null != var8) {
                  client.field402 = var6;
                  client.field403 = var7;
                  client.field467 = 2;
                  client.field404 = 0;
                  client.field528 = var0;
                  client.field347 = var1;
                  client.field338.method2873(245);
                  client.field338.method2743(class137.field2115[82]?1:0);
                  client.field338.method2745(var3);
               }
            }

            if(var2 == 9) {
               var8 = client.field546[var3];
               if(null != var8) {
                  client.field402 = var6;
                  client.field403 = var7;
                  client.field467 = 2;
                  client.field404 = 0;
                  client.field528 = var0;
                  client.field347 = var1;
                  client.field338.method2873(241);
                  client.field338.method2603(class137.field2115[82]?1:0);
                  client.field338.method2745(var3);
               }
            }

            if(var2 == 1003) {
               client.field402 = var6;
               client.field403 = var7;
               client.field467 = 2;
               client.field404 = 0;
               var8 = client.field546[var3];
               if(var8 != null) {
                  class39 var13 = var8.field784;
                  if(null != var13.field916) {
                     var13 = var13.method862();
                  }

                  if(null != var13) {
                     client.field338.method2873(238);
                     client.field338.method2745(var13.field890);
                  }
               }
            }

            if(1002 == var2) {
               client.field402 = var6;
               client.field403 = var7;
               client.field467 = 2;
               client.field404 = 0;
               client.field338.method2873(29);
               client.field338.method2745(var3 >> 14 & 32767);
            }

            if(58 == var2) {
               var11 = class210.method4010(var1, var0);
               if(null != var11) {
                  client.field338.method2873(209);
                  client.field338.method2745(client.field386);
                  client.field338.method2634(var0);
                  client.field338.method2606(var1);
                  client.field338.method2599(var11.field2878);
                  client.field338.method2655(class9.field169);
                  client.field338.method2645(client.field393);
               }
            }

            if(var2 == 30 && null == client.field526) {
               class219.method4073(var1, var0);
               client.field526 = class210.method4010(var1, var0);
               class23.method657(client.field526);
            }

            if(var2 == 22) {
               client.field402 = var6;
               client.field403 = var7;
               client.field467 = 2;
               client.field404 = 0;
               client.field528 = var0;
               client.field347 = var1;
               client.field338.method2873(240);
               client.field338.method2637(class137.field2115[82]?1:0);
               client.field338.method2634(class3.field67 + var1);
               client.field338.method2645(var3);
               client.field338.method2634(class144.field2204 + var0);
            }

            if(var2 == 37) {
               client.field338.method2873(80);
               client.field338.method2645(var3);
               client.field338.method2745(var0);
               client.field338.method2655(var1);
               client.field406 = 0;
               class130.field2061 = class20.method641(var1);
               client.field407 = var0;
            }

            if(var2 == 43) {
               client.field338.method2873(170);
               client.field338.method2745(var3);
               client.field338.method2655(var1);
               client.field338.method2745(var0);
               client.field406 = 0;
               class130.field2061 = class20.method641(var1);
               client.field407 = var0;
            }

            if(var2 == 48) {
               var10 = client.field550[var3];
               if(var10 != null) {
                  client.field402 = var6;
                  client.field403 = var7;
                  client.field467 = 2;
                  client.field404 = 0;
                  client.field528 = var0;
                  client.field347 = var1;
                  client.field338.method2873(37);
                  client.field338.method2645(var3);
                  client.field338.method2638(class137.field2115[82]?1:0);
               }
            }

            if(0 != client.field448) {
               client.field448 = 0;
               class23.method657(class20.method641(class40.field931));
            }

            if(client.field447) {
               class10.method169();
            }

            if(class130.field2061 != null && 0 == client.field406) {
               class23.method657(class130.field2061);
            }

         }
      }
   }
}
