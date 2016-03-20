import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class10 extends class106 {
   @ObfuscatedName("m")
   static class80 field159;
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = 1930894879
   )
   static int field160;
   @ObfuscatedName("mz")
   static byte field162;

   @ObfuscatedName("dp")
   static boolean method140(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class128.method2832(var0, class132.field2062);

         for(int var3 = 0; var3 < client.field562; ++var3) {
            if(var2.equalsIgnoreCase(class128.method2832(client.field513[var3].field261, class132.field2062)) && (!var1 || client.field513[var3].field249 != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class128.method2832(class151.field2253.field40, class132.field2062))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("a")
   protected boolean vmethod2388(int var1, int var2) {
      return var1 == super.field1871 && super.field1864 == var2;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-1408255657"
   )
   static final void method145(int var0, int var1, int var2, int var3, String var4, int var5, int var6) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      class172 var7;
      if(var2 == 58) {
         var7 = class13.method183(var1, var0);
         if(null != var7) {
            client.field301.method2753(254);
            client.field301.method2545(client.field382);
            client.field301.method2545(var7.field2834);
            client.field301.method2673(var1);
            client.field301.method2552(class8.field135);
            client.field301.method2545(client.field450);
            client.field301.method2498(var0);
         }
      }

      class2 var14;
      if(45 == var2) {
         var14 = client.field415[var3];
         if(var14 != null) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field355 = 0;
            client.field528 = var0;
            client.field529 = var1;
            client.field301.method2753(21);
            client.field301.method2648(class136.field2087[82]?1:0);
            client.field301.method2666(var3);
         }
      }

      if(var2 == 16) {
         client.field402 = var5;
         client.field403 = var6;
         client.field405 = 2;
         client.field355 = 0;
         client.field528 = var0;
         client.field529 = var1;
         client.field301.method2753(0);
         client.field301.method2544(var3);
         client.field301.method2498(class28.field683);
         client.field301.method2666(class147.field2214 + var0);
         client.field301.method2535(class136.field2087[82]?1:0);
         client.field301.method2663(class88.field1536);
         client.field301.method2498(class152.field2264);
         client.field301.method2498(var1 + class17.field257);
      }

      if(21 == var2) {
         client.field402 = var5;
         client.field403 = var6;
         client.field405 = 2;
         client.field355 = 0;
         client.field528 = var0;
         client.field529 = var1;
         client.field301.method2753(116);
         client.field301.method2498(class17.field257 + var1);
         client.field301.method2648(class136.field2087[82]?1:0);
         client.field301.method2545(var3);
         client.field301.method2498(var0 + class147.field2214);
      }

      class34 var15;
      if(9 == var2) {
         var15 = client.field358[var3];
         if(var15 != null) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field355 = 0;
            client.field528 = var0;
            client.field529 = var1;
            client.field301.method2753(63);
            client.field301.method2535(class136.field2087[82]?1:0);
            client.field301.method2498(var3);
         }
      }

      if(20 == var2) {
         client.field402 = var5;
         client.field403 = var6;
         client.field405 = 2;
         client.field355 = 0;
         client.field528 = var0;
         client.field529 = var1;
         client.field301.method2753(158);
         client.field301.method2666(var0 + class147.field2214);
         client.field301.method2666(class17.field257 + var1);
         client.field301.method2497(class136.field2087[82]?1:0);
         client.field301.method2666(var3);
      }

      if(var2 == 5) {
         client.field402 = var5;
         client.field403 = var6;
         client.field405 = 2;
         client.field355 = 0;
         client.field528 = var0;
         client.field529 = var1;
         client.field301.method2753(188);
         client.field301.method2536(class136.field2087[82]?1:0);
         client.field301.method2666(var3 >> 14 & 32767);
         client.field301.method2544(class147.field2214 + var0);
         client.field301.method2498(var1 + class17.field257);
      }

      if(var2 == 34) {
         client.field301.method2753(144);
         client.field301.method2498(var0);
         client.field301.method2652(var1);
         client.field301.method2666(var3);
         client.field406 = 0;
         class28.field679 = class92.method2180(var1);
         client.field350 = var0;
      }

      if(40 == var2) {
         client.field301.method2753(195);
         client.field301.method2498(var3);
         client.field301.method2673(var1);
         client.field301.method2498(var0);
         client.field406 = 0;
         class28.field679 = class92.method2180(var1);
         client.field350 = var0;
      }

      if(var2 == 24) {
         var7 = class92.method2180(var1);
         boolean var8 = true;
         if(var7.field2747 > 0) {
            var8 = class18.method212(var7);
         }

         if(var8) {
            client.field301.method2753(230);
            client.field301.method2663(var1);
         }
      }

      if(43 == var2) {
         client.field301.method2753(245);
         client.field301.method2498(var0);
         client.field301.method2544(var3);
         client.field301.method2663(var1);
         client.field406 = 0;
         class28.field679 = class92.method2180(var1);
         client.field350 = var0;
      }

      if(48 == var2) {
         var14 = client.field415[var3];
         if(var14 != null) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field355 = 0;
            client.field528 = var0;
            client.field529 = var1;
            client.field301.method2753(75);
            client.field301.method2498(var3);
            client.field301.method2648(class136.field2087[82]?1:0);
         }
      }

      if(1004 == var2) {
         client.field402 = var5;
         client.field403 = var6;
         client.field405 = 2;
         client.field355 = 0;
         client.field301.method2753(210);
         client.field301.method2545(var3);
      }

      if(10 == var2) {
         var15 = client.field358[var3];
         if(null != var15) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field355 = 0;
            client.field528 = var0;
            client.field529 = var1;
            client.field301.method2753(207);
            client.field301.method2544(var3);
            client.field301.method2535(class136.field2087[82]?1:0);
         }
      }

      if(var2 == 1005) {
         var7 = class92.method2180(var1);
         if(var7 != null && var7.field2860[var0] >= 100000) {
            class137.method2943(27, "", var7.field2860[var0] + " x " + class75.method1648(var3).field1115);
         } else {
            client.field301.method2753(210);
            client.field301.method2545(var3);
         }

         client.field406 = 0;
         class28.field679 = class92.method2180(var1);
         client.field350 = var0;
      }

      if(39 == var2) {
         client.field301.method2753(154);
         client.field301.method2544(var0);
         client.field301.method2673(var1);
         client.field301.method2498(var3);
         client.field406 = 0;
         class28.field679 = class92.method2180(var1);
         client.field350 = var0;
      }

      if(var2 == 7) {
         var15 = client.field358[var3];
         if(var15 != null) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field355 = 0;
            client.field528 = var0;
            client.field529 = var1;
            client.field301.method2753(73);
            client.field301.method2545(var3);
            client.field301.method2666(class152.field2264);
            client.field301.method2545(class28.field683);
            client.field301.method2673(class88.field1536);
            client.field301.method2535(class136.field2087[82]?1:0);
         }
      }

      if(1002 == var2) {
         client.field402 = var5;
         client.field403 = var6;
         client.field405 = 2;
         client.field355 = 0;
         client.field301.method2753(83);
         client.field301.method2545(var3 >> 14 & 32767);
      }

      if(var2 == 57 || 1007 == var2) {
         var7 = class13.method183(var1, var0);
         if(var7 != null) {
            class41.method866(var3, var1, var0, var7.field2834, var4);
         }
      }

      if(1003 == var2) {
         client.field402 = var5;
         client.field403 = var6;
         client.field405 = 2;
         client.field355 = 0;
         var15 = client.field358[var3];
         if(null != var15) {
            class39 var16 = var15.field785;
            if(null != var16.field909) {
               var16 = var16.method774();
            }

            if(null != var16) {
               client.field301.method2753(127);
               client.field301.method2544(var16.field911);
            }
         }
      }

      if(1001 == var2) {
         client.field402 = var5;
         client.field403 = var6;
         client.field405 = 2;
         client.field355 = 0;
         client.field528 = var0;
         client.field529 = var1;
         client.field301.method2753(19);
         client.field301.method2666(class147.field2214 + var0);
         client.field301.method2498(var3 >> 14 & 32767);
         client.field301.method2545(var1 + class17.field257);
         client.field301.method2535(class136.field2087[82]?1:0);
      }

      int var17;
      if(25 == var2) {
         var7 = class13.method183(var1, var0);
         if(var7 != null) {
            class103.method2300();
            int var9 = class101.method2294(var7);
            var17 = var9 >> 11 & 63;
            int var11 = var7.field2834;
            class172 var12 = class13.method183(var1, var0);
            if(var12 != null && null != var12.field2832) {
               class0 var13 = new class0();
               var13.field6 = var12;
               var13.field8 = var12.field2832;
               class150.method3148(var13);
            }

            client.field450 = var11;
            client.field448 = true;
            class8.field135 = var1;
            client.field382 = var0;
            class15.field218 = var17;
            class36.method745(var12);
            client.field446 = 0;
            client.field451 = class6.method114(var7);
            if(client.field451 == null) {
               client.field451 = "Null";
            }

            if(var7.field2742) {
               client.field452 = var7.field2814 + class51.method1090(16777215);
            } else {
               client.field452 = class51.method1090('\uff00') + var7.field2857 + class51.method1090(16777215);
            }
         }

      } else {
         if(var2 == 4) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field355 = 0;
            client.field528 = var0;
            client.field529 = var1;
            client.field301.method2753(179);
            client.field301.method2544(class17.field257 + var1);
            client.field301.method2545(var3 >> 14 & 32767);
            client.field301.method2536(class136.field2087[82]?1:0);
            client.field301.method2498(class147.field2214 + var0);
         }

         if(51 == var2) {
            var14 = client.field415[var3];
            if(null != var14) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field355 = 0;
               client.field528 = var0;
               client.field529 = var1;
               client.field301.method2753(28);
               client.field301.method2498(var3);
               client.field301.method2497(class136.field2087[82]?1:0);
            }
         }

         if(var2 == 29) {
            client.field301.method2753(230);
            client.field301.method2663(var1);
            var7 = class92.method2180(var1);
            if(null != var7.field2853 && var7.field2853[0][0] == 5) {
               var17 = var7.field2853[0][1];
               if(var7.field2855[0] != class175.field2890[var17]) {
                  class175.field2890[var17] = var7.field2855[0];
                  class45.method959(var17);
               }
            }
         }

         if(var2 == 1) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field355 = 0;
            client.field528 = var0;
            client.field529 = var1;
            client.field301.method2753(41);
            client.field301.method2535(class136.field2087[82]?1:0);
            client.field301.method2666(class28.field683);
            client.field301.method2666(class147.field2214 + var0);
            client.field301.method2666(var3 >> 14 & 32767);
            client.field301.method2544(class152.field2264);
            client.field301.method2652(class88.field1536);
            client.field301.method2545(var1 + class17.field257);
         }

         if(38 == var2) {
            class103.method2300();
            var7 = class92.method2180(var1);
            client.field446 = 1;
            class152.field2264 = var0;
            class88.field1536 = var1;
            class28.field683 = var3;
            class36.method745(var7);
            client.field447 = class51.method1090(16748608) + class75.method1648(var3).field1115 + class51.method1090(16777215);
            if(null == client.field447) {
               client.field447 = "null";
            }

         } else {
            if(var2 == 37) {
               client.field301.method2753(222);
               client.field301.method2545(var3);
               client.field301.method2666(var0);
               client.field301.method2663(var1);
               client.field406 = 0;
               class28.field679 = class92.method2180(var1);
               client.field350 = var0;
            }

            if(50 == var2) {
               var14 = client.field415[var3];
               if(var14 != null) {
                  client.field402 = var5;
                  client.field403 = var6;
                  client.field405 = 2;
                  client.field355 = 0;
                  client.field528 = var0;
                  client.field529 = var1;
                  client.field301.method2753(40);
                  client.field301.method2666(var3);
                  client.field301.method2497(class136.field2087[82]?1:0);
               }
            }

            if(19 == var2) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field355 = 0;
               client.field528 = var0;
               client.field529 = var1;
               client.field301.method2753(109);
               client.field301.method2497(class136.field2087[82]?1:0);
               client.field301.method2666(var3);
               client.field301.method2545(class147.field2214 + var0);
               client.field301.method2498(class17.field257 + var1);
            }

            if(46 == var2) {
               var14 = client.field415[var3];
               if(null != var14) {
                  client.field402 = var5;
                  client.field403 = var6;
                  client.field405 = 2;
                  client.field355 = 0;
                  client.field528 = var0;
                  client.field529 = var1;
                  client.field301.method2753(141);
                  client.field301.method2545(var3);
                  client.field301.method2497(class136.field2087[82]?1:0);
               }
            }

            if(23 == var2) {
               class77.field1396.method1959(class48.field1078, var0, var1);
            }

            if(8 == var2) {
               var15 = client.field358[var3];
               if(null != var15) {
                  client.field402 = var5;
                  client.field403 = var6;
                  client.field405 = 2;
                  client.field355 = 0;
                  client.field528 = var0;
                  client.field529 = var1;
                  client.field301.method2753(12);
                  client.field301.method2663(class8.field135);
                  client.field301.method2498(var3);
                  client.field301.method2648(class136.field2087[82]?1:0);
                  client.field301.method2498(client.field382);
               }
            }

            if(32 == var2) {
               client.field301.method2753(226);
               client.field301.method2666(var0);
               client.field301.method2673(class8.field135);
               client.field301.method2498(var3);
               client.field301.method2498(client.field382);
               client.field301.method2552(var1);
               client.field406 = 0;
               class28.field679 = class92.method2180(var1);
               client.field350 = var0;
            }

            if(28 == var2) {
               client.field301.method2753(230);
               client.field301.method2663(var1);
               var7 = class92.method2180(var1);
               if(null != var7.field2853 && 5 == var7.field2853[0][0]) {
                  var17 = var7.field2853[0][1];
                  class175.field2890[var17] = 1 - class175.field2890[var17];
                  class45.method959(var17);
               }
            }

            if(var2 == 41) {
               client.field301.method2753(4);
               client.field301.method2666(var0);
               client.field301.method2544(var3);
               client.field301.method2652(var1);
               client.field406 = 0;
               class28.field679 = class92.method2180(var1);
               client.field350 = var0;
            }

            if(11 == var2) {
               var15 = client.field358[var3];
               if(null != var15) {
                  client.field402 = var5;
                  client.field403 = var6;
                  client.field405 = 2;
                  client.field355 = 0;
                  client.field528 = var0;
                  client.field529 = var1;
                  client.field301.method2753(86);
                  client.field301.method2497(class136.field2087[82]?1:0);
                  client.field301.method2545(var3);
               }
            }

            if(18 == var2) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field355 = 0;
               client.field528 = var0;
               client.field529 = var1;
               client.field301.method2753(136);
               client.field301.method2666(class17.field257 + var1);
               client.field301.method2544(var0 + class147.field2214);
               client.field301.method2648(class136.field2087[82]?1:0);
               client.field301.method2544(var3);
            }

            if(15 == var2) {
               var14 = client.field415[var3];
               if(var14 != null) {
                  client.field402 = var5;
                  client.field403 = var6;
                  client.field405 = 2;
                  client.field355 = 0;
                  client.field528 = var0;
                  client.field529 = var1;
                  client.field301.method2753(88);
                  client.field301.method2497(class136.field2087[82]?1:0);
                  client.field301.method2545(var3);
                  client.field301.method2498(client.field382);
                  client.field301.method2663(class8.field135);
               }
            }

            if(22 == var2) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field355 = 0;
               client.field528 = var0;
               client.field529 = var1;
               client.field301.method2753(209);
               client.field301.method2666(var1 + class17.field257);
               client.field301.method2545(class147.field2214 + var0);
               client.field301.method2498(var3);
               client.field301.method2536(class136.field2087[82]?1:0);
            }

            if(var2 == 42) {
               client.field301.method2753(199);
               client.field301.method2666(var3);
               client.field301.method2652(var1);
               client.field301.method2666(var0);
               client.field406 = 0;
               class28.field679 = class92.method2180(var1);
               client.field350 = var0;
            }

            if(var2 == 35) {
               client.field301.method2753(202);
               client.field301.method2498(var0);
               client.field301.method2663(var1);
               client.field301.method2498(var3);
               client.field406 = 0;
               class28.field679 = class92.method2180(var1);
               client.field350 = var0;
            }

            if(var2 == 14) {
               var14 = client.field415[var3];
               if(var14 != null) {
                  client.field402 = var5;
                  client.field403 = var6;
                  client.field405 = 2;
                  client.field355 = 0;
                  client.field528 = var0;
                  client.field529 = var1;
                  client.field301.method2753(64);
                  client.field301.method2498(class28.field683);
                  client.field301.method2498(class152.field2264);
                  client.field301.method2652(class88.field1536);
                  client.field301.method2544(var3);
                  client.field301.method2535(class136.field2087[82]?1:0);
               }
            }

            if(var2 == 33) {
               client.field301.method2753(113);
               client.field301.method2666(var0);
               client.field301.method2545(var3);
               client.field301.method2673(var1);
               client.field406 = 0;
               class28.field679 = class92.method2180(var1);
               client.field350 = var0;
            }

            if(44 == var2) {
               var14 = client.field415[var3];
               if(null != var14) {
                  client.field402 = var5;
                  client.field403 = var6;
                  client.field405 = 2;
                  client.field355 = 0;
                  client.field528 = var0;
                  client.field529 = var1;
                  client.field301.method2753(165);
                  client.field301.method2498(var3);
                  client.field301.method2536(class136.field2087[82]?1:0);
               }
            }

            if(12 == var2) {
               var15 = client.field358[var3];
               if(null != var15) {
                  client.field402 = var5;
                  client.field403 = var6;
                  client.field405 = 2;
                  client.field355 = 0;
                  client.field528 = var0;
                  client.field529 = var1;
                  client.field301.method2753(46);
                  client.field301.method2498(var3);
                  client.field301.method2648(class136.field2087[82]?1:0);
               }
            }

            if(36 == var2) {
               client.field301.method2753(201);
               client.field301.method2552(var1);
               client.field301.method2666(var3);
               client.field301.method2544(var0);
               client.field406 = 0;
               class28.field679 = class92.method2180(var1);
               client.field350 = var0;
            }

            if(var2 == 6) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field355 = 0;
               client.field528 = var0;
               client.field529 = var1;
               client.field301.method2753(193);
               client.field301.method2545(var3 >> 14 & 32767);
               client.field301.method2666(var0 + class147.field2214);
               client.field301.method2536(class136.field2087[82]?1:0);
               client.field301.method2498(var1 + class17.field257);
            }

            if(30 == var2 && client.field431 == null) {
               client.field301.method2753(159);
               client.field301.method2652(var1);
               client.field301.method2545(var0);
               client.field431 = class13.method183(var1, var0);
               class36.method745(client.field431);
            }

            if(17 == var2) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field355 = 0;
               client.field528 = var0;
               client.field529 = var1;
               client.field301.method2753(96);
               client.field301.method2545(client.field382);
               client.field301.method2666(class147.field2214 + var0);
               client.field301.method2648(class136.field2087[82]?1:0);
               client.field301.method2663(class8.field135);
               client.field301.method2545(var3);
               client.field301.method2498(class17.field257 + var1);
            }

            if(47 == var2) {
               var14 = client.field415[var3];
               if(var14 != null) {
                  client.field402 = var5;
                  client.field403 = var6;
                  client.field405 = 2;
                  client.field355 = 0;
                  client.field528 = var0;
                  client.field529 = var1;
                  client.field301.method2753(248);
                  client.field301.method2648(class136.field2087[82]?1:0);
                  client.field301.method2545(var3);
               }
            }

            if(13 == var2) {
               var15 = client.field358[var3];
               if(null != var15) {
                  client.field402 = var5;
                  client.field403 = var6;
                  client.field405 = 2;
                  client.field355 = 0;
                  client.field528 = var0;
                  client.field529 = var1;
                  client.field301.method2753(169);
                  client.field301.method2544(var3);
                  client.field301.method2536(class136.field2087[82]?1:0);
               }
            }

            if(var2 == 31) {
               client.field301.method2753(77);
               client.field301.method2666(var3);
               client.field301.method2545(class152.field2264);
               client.field301.method2673(class88.field1536);
               client.field301.method2545(var0);
               client.field301.method2545(class28.field683);
               client.field301.method2652(var1);
               client.field406 = 0;
               class28.field679 = class92.method2180(var1);
               client.field350 = var0;
            }

            if(var2 == 3) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field355 = 0;
               client.field528 = var0;
               client.field529 = var1;
               client.field301.method2753(100);
               client.field301.method2666(class17.field257 + var1);
               client.field301.method2544(class147.field2214 + var0);
               client.field301.method2498(var3 >> 14 & 32767);
               client.field301.method2497(class136.field2087[82]?1:0);
            }

            if(49 == var2) {
               var14 = client.field415[var3];
               if(var14 != null) {
                  client.field402 = var5;
                  client.field403 = var6;
                  client.field405 = 2;
                  client.field355 = 0;
                  client.field528 = var0;
                  client.field529 = var1;
                  client.field301.method2753(234);
                  client.field301.method2666(var3);
                  client.field301.method2535(class136.field2087[82]?1:0);
               }
            }

            if(2 == var2) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field355 = 0;
               client.field528 = var0;
               client.field529 = var1;
               client.field301.method2753(224);
               client.field301.method2544(var3 >> 14 & 32767);
               client.field301.method2545(var0 + class147.field2214);
               client.field301.method2652(class8.field135);
               client.field301.method2648(class136.field2087[82]?1:0);
               client.field301.method2666(client.field382);
               client.field301.method2544(class17.field257 + var1);
            }

            if(26 == var2) {
               client.field301.method2753(138);

               for(class3 var18 = (class3)client.field454.method3836(); null != var18; var18 = (class3)client.field454.method3827()) {
                  if(var18.field62 == 0 || var18.field62 == 3) {
                     class112.method2446(var18, true);
                  }
               }

               if(client.field431 != null) {
                  class36.method745(client.field431);
                  client.field431 = null;
               }
            }

            if(0 != client.field446) {
               client.field446 = 0;
               class36.method745(class92.method2180(class88.field1536));
            }

            if(client.field448) {
               class103.method2300();
            }

            if(null != class28.field679 && client.field406 == 0) {
               class36.method745(class28.field679);
            }

         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method146() {
      if(null != class2.field53) {
         class2.field53.method1194();
      }

      if(class76.field1380 != null) {
         class76.field1380.method1194();
      }

   }

   @ObfuscatedName("s")
   public static void method147() {
      while(true) {
         class198 var1 = class169.field2696;
         class168 var0;
         synchronized(class169.field2696) {
            var0 = (class168)class169.field2694.method3866();
         }

         if(var0 == null) {
            return;
         }

         var0.field2690.method3361(var0.field2689, (int)var0.field3111, var0.field2687, false);
      }
   }

   @ObfuscatedName("a")
   public static class189[] method148() {
      return new class189[]{class189.field3058, class189.field3048, class189.field3054, class189.field3050, class189.field3052, class189.field3047, class189.field3053, class189.field3051, class189.field3059, class189.field3046, class189.field3045, class189.field3056, class189.field3060, class189.field3057, class189.field3055};
   }
}
