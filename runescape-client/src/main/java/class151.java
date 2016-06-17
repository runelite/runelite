import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("en")
public class class151 {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1128243488"
   )
   public static boolean method3154(int var0) {
      return (var0 >> 29 & 1) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1680674133"
   )
   static final void method3155() {
      try {
         if(client.field482 == 0) {
            if(null != class13.field195) {
               class13.field195.method3025();
               class13.field195 = null;
            }

            class130.field2046 = null;
            client.field342 = false;
            client.field345 = 0;
            client.field482 = 1;
         }

         if(client.field482 == 1) {
            if(class130.field2046 == null) {
               class130.field2046 = class40.field924.method2916(class43.field1002, class16.field239);
            }

            if(class130.field2046.field2199 == 2) {
               throw new IOException();
            }

            if(class130.field2046.field2199 == 1) {
               class13.field195 = new class143((Socket)class130.field2046.field2201, class40.field924);
               class130.field2046 = null;
               client.field482 = 2;
            }
         }

         if(client.field482 == 2) {
            client.field331.field1976 = 0;
            client.field331.method2650(14);
            class13.field195.method3020(client.field331.field1982, 0, 1);
            client.field332.field1976 = 0;
            client.field482 = 3;
         }

         int var0;
         if(client.field482 == 3) {
            if(class93.field1572 != null) {
               class93.field1572.method1193();
            }

            if(class50.field1074 != null) {
               class50.field1074.method1193();
            }

            var0 = class13.field195.method3026();
            if(class93.field1572 != null) {
               class93.field1572.method1193();
            }

            if(null != class50.field1074) {
               class50.field1074.method1193();
            }

            if(var0 != 0) {
               class90.method2089(var0);
               return;
            }

            client.field332.field1976 = 0;
            client.field482 = 5;
         }

         int var1;
         int var2;
         if(client.field482 == 5) {
            int[] var5 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            client.field331.field1976 = 0;
            client.field331.method2650(1);
            client.field331.method2650(class31.field722.vmethod3185());
            client.field331.method2502(var5[0]);
            client.field331.method2502(var5[1]);
            client.field331.method2502(var5[2]);
            client.field331.method2502(var5[3]);
            switch(class31.field722.field2593) {
            case 0:
            case 3:
               client.field331.method2501(class38.field854);
               client.field331.field1976 += 5;
               break;
            case 1:
               client.field331.method2502(((Integer)class162.field2637.field133.get(Integer.valueOf(class52.method1080(class31.field726)))).intValue());
               client.field331.field1976 += 4;
               break;
            case 2:
               client.field331.field1976 += 8;
            }

            client.field331.method2505(class31.field716);
            client.field331.method2677(class4.field67, class4.field63);
            client.field479.field1976 = 0;
            if(client.field294 == 40) {
               client.field479.method2650(18);
            } else {
               client.field479.method2650(16);
            }

            client.field479.method2695(0);
            var1 = client.field479.field1976;
            client.field479.method2502(116);
            client.field479.method2508(client.field331.field1982, 0, client.field331.field1976);
            var2 = client.field479.field1976;
            client.field479.method2505(class31.field726);
            client.field479.method2650((client.field501?1:0) << 1 | (client.field383?1:0));
            client.field479.method2695(class45.field1026);
            client.field479.method2695(class143.field2169);
            class173.method3449(client.field479);
            client.field479.method2505(client.field563);
            client.field479.method2502(class17.field254);
            class119 var3 = new class119(class102.field1742.method3192());
            class102.field1742.method3190(var3);
            client.field479.method2508(var3.field1982, 0, var3.field1982.length);
            client.field479.method2650(class44.field1018);
            client.field479.method2502(client.field317.field2677);
            client.field479.method2502(class8.field137.field2677);
            client.field479.method2502(class144.field2185.field2677);
            client.field479.method2502(class50.field1071.field2677);
            client.field479.method2502(client.field466.field2677);
            client.field479.method2502(class35.field771.field2677);
            client.field479.method2502(client.field358.field2677);
            client.field479.method2502(class21.field583.field2677);
            client.field479.method2502(class129.field2038.field2677);
            client.field479.method2502(class168.field2692.field2677);
            client.field479.method2502(class12.field186.field2677);
            client.field479.method2502(class84.field1422.field2677);
            client.field479.method2502(class172.field2735.field2677);
            client.field479.method2502(class43.field995.field2677);
            client.field479.method2502(class135.field2069.field2677);
            client.field479.method2502(class104.field1778.field2677);
            client.field479.method2532(var5, var2, client.field479.field1976);
            client.field479.method2510(client.field479.field1976 - var1);
            class13.field195.method3020(client.field479.field1982, 0, client.field479.field1976);
            client.field331.method2780(var5);

            for(int var4 = 0; var4 < 4; ++var4) {
               var5[var4] += 50;
            }

            client.field332.method2780(var5);
            client.field482 = 6;
         }

         if(client.field482 == 6 && class13.field195.method3018() > 0) {
            var0 = class13.field195.method3026();
            if(var0 == 21 && client.field294 == 20) {
               client.field482 = 7;
            } else if(var0 == 2) {
               client.field482 = 9;
            } else if(var0 == 15 && client.field294 == 40) {
               client.field334 = -1;
               client.field482 = 13;
            } else if(var0 == 23 && client.field566 < 1) {
               ++client.field566;
               client.field482 = 0;
            } else {
               if(var0 != 29) {
                  class90.method2089(var0);
                  return;
               }

               client.field482 = 11;
            }
         }

         if(client.field482 == 7 && class13.field195.method3018() > 0) {
            client.field468 = (class13.field195.method3026() + 3) * 60;
            client.field482 = 8;
         }

         if(client.field482 == 8) {
            client.field345 = 0;
            class12.method152("You have only just left another world.", "Your profile will be transferred in:", client.field468 / 60 + " seconds.");
            if(--client.field468 <= 0) {
               client.field482 = 0;
            }

         } else {
            if(client.field482 == 9 && class13.field195.method3018() >= 13) {
               boolean var11 = class13.field195.method3026() == 1;
               class13.field195.method3019(client.field332.field1982, 0, 4);
               client.field332.field1976 = 0;
               boolean var12 = false;
               if(var11) {
                  var1 = client.field332.method2787() << 24;
                  var1 |= client.field332.method2787() << 16;
                  var1 |= client.field332.method2787() << 8;
                  var1 |= client.field332.method2787();
                  var2 = class52.method1080(class31.field726);
                  if(class162.field2637.field133.size() >= 10 && !class162.field2637.field133.containsKey(Integer.valueOf(var2))) {
                     Iterator var13 = class162.field2637.field133.entrySet().iterator();
                     var13.next();
                     var13.remove();
                  }

                  class162.field2637.field133.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class8.method96();
               }

               client.field354 = class13.field195.method3026();
               client.field454 = class13.field195.method3026() == 1;
               client.field430 = class13.field195.method3026();
               client.field430 <<= 8;
               client.field430 += class13.field195.method3026();
               client.field412 = class13.field195.method3026();
               class13.field195.method3019(client.field332.field1982, 0, 1);
               client.field332.field1976 = 0;
               client.field335 = client.field332.method2787();
               class13.field195.method3019(client.field332.field1982, 0, 2);
               client.field332.field1976 = 0;
               client.field334 = client.field332.method2516();
               client var6;
               if(client.field412 == 1) {
                  try {
                     var6 = client.field284;
                     JSObject.getWindow(var6).call("zap", (Object[])null);
                  } catch (Throwable var9) {
                     ;
                  }
               } else {
                  try {
                     var6 = client.field284;
                     JSObject.getWindow(var6).call("unzap", (Object[])null);
                  } catch (Throwable var8) {
                     ;
                  }
               }

               client.field482 = 10;
            }

            if(client.field482 != 10) {
               if(client.field482 == 11 && class13.field195.method3018() >= 2) {
                  client.field332.field1976 = 0;
                  class13.field195.method3019(client.field332.field1982, 0, 2);
                  client.field332.field1976 = 0;
                  class158.field2587 = client.field332.method2516();
                  client.field482 = 12;
               }

               if(client.field482 == 12 && class13.field195.method3018() >= class158.field2587) {
                  client.field332.field1976 = 0;
                  class13.field195.method3019(client.field332.field1982, 0, class158.field2587);
                  client.field332.field1976 = 0;
                  String var16 = client.field332.method2522();
                  String var18 = client.field332.method2522();
                  String var17 = client.field332.method2522();
                  class12.method152(var16, var18, var17);
                  class43.method919(10);
               }

               if(client.field482 == 13) {
                  if(client.field334 == -1) {
                     if(class13.field195.method3018() < 2) {
                        return;
                     }

                     class13.field195.method3019(client.field332.field1982, 0, 2);
                     client.field332.field1976 = 0;
                     client.field334 = client.field332.method2516();
                  }

                  if(class13.field195.method3018() >= client.field334) {
                     class13.field195.method3019(client.field332.field1982, 0, client.field334);
                     client.field332.field1976 = 0;
                     var0 = client.field334;
                     class20.method555();
                     class115.method2453(client.field332);
                     if(var0 != client.field332.field1976) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++client.field345;
                  if(client.field345 > 2000) {
                     if(client.field566 < 1) {
                        if(class13.field200 == class16.field239) {
                           class16.field239 = client.field472;
                        } else {
                           class16.field239 = class13.field200;
                        }

                        ++client.field566;
                        client.field482 = 0;
                     } else {
                        class90.method2089(-3);
                     }
                  }
               }
            } else {
               if(class13.field195.method3018() >= client.field334) {
                  client.field332.field1976 = 0;
                  class13.field195.method3019(client.field332.field1982, 0, client.field334);
                  client.field297 = -1L;
                  client.field300 = -1;
                  class12.field182.field197 = 0;
                  class108.field1871 = true;
                  client.field301 = true;
                  client.field505 = -1L;
                  class141.method3009();
                  client.field331.field1976 = 0;
                  client.field332.field1976 = 0;
                  client.field335 = -1;
                  client.field338 = 1;
                  client.field406 = -1;
                  client.field540 = -1;
                  client.field441 = 0;
                  client.field519 = 0;
                  client.field399 = 0;
                  client.field323 = 0;
                  client.field429 = 0;
                  client.field428 = false;
                  class87.method2087(0);
                  class7.method91();
                  client.field352 = 0;
                  client.field442 = false;
                  client.field504 = 0;
                  client.field444 = (int)(Math.random() * 100.0D) - 50;
                  client.field523 = (int)(Math.random() * 110.0D) - 55;
                  client.field357 = (int)(Math.random() * 80.0D) - 40;
                  client.field360 = (int)(Math.random() * 120.0D) - 60;
                  client.field558 = (int)(Math.random() * 30.0D) - 20;
                  client.field322 = (int)(Math.random() * 20.0D) - 10 & 2047;
                  client.field493 = 0;
                  client.field303 = -1;
                  client.field521 = 0;
                  client.field522 = 0;
                  client.field312 = class20.field574;
                  client.field313 = class20.field574;
                  client.field449 = 0;
                  class32.field738 = 0;

                  for(var0 = 0; var0 < 2048; ++var0) {
                     class32.field737[var0] = null;
                     class32.field736[var0] = 1;
                  }

                  for(var0 = 0; var0 < 2048; ++var0) {
                     client.field410[var0] = null;
                  }

                  for(var0 = 0; var0 < '耀'; ++var0) {
                     client.field326[var0] = null;
                  }

                  client.field329 = -1;
                  client.field422.method3823();
                  client.field423.method3823();

                  for(var0 = 0; var0 < 4; ++var0) {
                     for(var1 = 0; var1 < 104; ++var1) {
                        for(var2 = 0; var2 < 104; ++var2) {
                           client.field420[var0][var1][var2] = null;
                        }
                     }
                  }

                  client.field421 = new class199();
                  client.field555 = 0;
                  client.field340 = 0;
                  client.field513 = 0;

                  for(var0 = 0; var0 < class52.field1129; ++var0) {
                     class52 var7 = class20.method553(var0);
                     if(var7 != null) {
                        class176.field2894[var0] = 0;
                        class176.field2896[var0] = 0;
                     }
                  }

                  class139.field2124.method200();
                  client.field374 = -1;
                  if(client.field456 != -1) {
                     class50.method1007(client.field456);
                  }

                  for(class3 var14 = (class3)client.field448.method3799(); null != var14; var14 = (class3)client.field448.method3800()) {
                     class139.method2971(var14, true);
                  }

                  client.field456 = -1;
                  client.field448 = new class196(8);
                  client.field451 = null;
                  client.field428 = false;
                  client.field429 = 0;
                  client.field339.method3516((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var0 = 0; var0 < 8; ++var0) {
                     client.field416[var0] = null;
                     client.field417[var0] = false;
                  }

                  class15.field221 = new class196(32);
                  client.field295 = true;

                  for(var0 = 0; var0 < 100; ++var0) {
                     client.field507[var0] = true;
                  }

                  client.field331.method2781(174);
                  class122 var15 = client.field331;
                  var1 = client.field501?2:1;
                  var15.method2650(var1);
                  client.field331.method2695(class45.field1026);
                  client.field331.method2695(class143.field2169);
                  client.field514 = null;
                  class116.field1957 = 0;
                  class40.field923 = null;

                  for(var0 = 0; var0 < 8; ++var0) {
                     client.field528[var0] = new class220();
                  }

                  class143.field2172 = null;
                  class115.method2453(client.field332);
                  class153.field2265 = -1;
                  class0.method0(false);
                  client.field335 = -1;
               }

            }
         }
      } catch (IOException var10) {
         if(client.field566 < 1) {
            if(class16.field239 == class13.field200) {
               class16.field239 = client.field472;
            } else {
               class16.field239 = class13.field200;
            }

            ++client.field566;
            client.field482 = 0;
         } else {
            class90.method2089(-2);
         }
      }
   }
}
