import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public class class118 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -4016271253659228945L
   )
   static long field2029;
   @ObfuscatedName("rs")
   protected static String field2030;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 7678208967150448219L
   )
   static long field2031;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1629925407"
   )
   static byte[] method2561(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-75"
   )
   static final void method2567() {
      try {
         if(client.field349 == 0) {
            if(class40.field904 != null) {
               class40.field904.method3131();
               class40.field904 = null;
            }

            class50.field1123 = null;
            client.field348 = false;
            client.field411 = 0;
            client.field349 = 1;
         }

         if(client.field349 == 1) {
            if(null == class50.field1123) {
               class50.field1123 = class125.field2070.method3028(class105.field1842, class109.field1943);
            }

            if(class50.field1123.field2276 == 2) {
               throw new IOException();
            }

            if(class50.field1123.field2276 == 1) {
               class40.field904 = new class146((Socket)class50.field1123.field2272, class125.field2070);
               class50.field1123 = null;
               client.field349 = 2;
            }
         }

         if(client.field349 == 2) {
            client.field337.field2050 = 0;
            client.field337.method2783(14);
            class40.field904.method3135(client.field337.field2051, 0, 1);
            client.field339.field2050 = 0;
            client.field349 = 3;
         }

         int var0;
         if(client.field349 == 3) {
            if(null != class6.field127) {
               class6.field127.method1292();
            }

            if(class125.field2069 != null) {
               class125.field2069.method1292();
            }

            var0 = class40.field904.method3140();
            if(null != class6.field127) {
               class6.field127.method1292();
            }

            if(null != class125.field2069) {
               class125.field2069.method1292();
            }

            if(var0 != 0) {
               class30.method686(var0);
               return;
            }

            client.field339.field2050 = 0;
            client.field349 = 5;
         }

         int var1;
         int var2;
         if(client.field349 == 5) {
            int[] var7 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            client.field337.field2050 = 0;
            client.field337.method2783(1);
            client.field337.method2783(class33.field766.vmethod3316());
            client.field337.method2728(var7[0]);
            client.field337.method2728(var7[1]);
            client.field337.method2728(var7[2]);
            client.field337.method2728(var7[3]);
            switch(class33.field766.field2663) {
            case 0:
               client.field337.method2728(((Integer)class136.field2123.field147.get(Integer.valueOf(class55.method1234(class33.field764)))).intValue());
               client.field337.field2050 += 4;
               break;
            case 1:
            case 3:
               client.field337.method2849(class174.field2788);
               client.field337.field2050 += 5;
               break;
            case 2:
               client.field337.field2050 += 8;
            }

            client.field337.method2703(class33.field765);
            client.field337.method2781(class4.field76, class4.field73);
            client.field333.field2050 = 0;
            if(client.field303 == 40) {
               client.field333.method2783(18);
            } else {
               client.field333.method2783(16);
            }

            client.field333.method2619(0);
            var1 = client.field333.field2050;
            client.field333.method2728(120);
            client.field333.method2627(client.field337.field2051, 0, client.field337.field2050);
            var2 = client.field333.field2050;
            client.field333.method2703(class33.field764);
            client.field333.method2783((client.field507?1:0) << 1 | (client.field301?1:0));
            client.field333.method2619(class189.field3056);
            client.field333.method2619(class39.field892);
            class125 var3 = client.field333;
            byte[] var4 = new byte[24];

            int var5;
            try {
               class152.field2301.method4293(0L);
               class152.field2301.method4297(var4);

               for(var5 = 0; var5 < 24 && var4[var5] == 0; ++var5) {
                  ;
               }

               if(var5 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var12) {
               for(int var6 = 0; var6 < 24; ++var6) {
                  var4[var6] = -1;
               }
            }

            var3.method2627(var4, 0, 24);
            client.field333.method2703(class48.field1097);
            client.field333.method2728(class133.field2112);
            class122 var17 = new class122(class3.field69.method3323());
            class3.field69.method3322(var17);
            client.field333.method2627(var17.field2051, 0, var17.field2051.length);
            client.field333.method2783(class165.field2705);
            client.field333.method2728(class16.field240.field2737);
            client.field333.method2728(class56.field1236.field2737);
            client.field333.method2728(class78.field1448.field2737);
            client.field333.method2728(class164.field2699.field2737);
            client.field333.method2728(class119.field2039.field2737);
            client.field333.method2728(class80.field1476.field2737);
            client.field333.method2728(class188.field3051.field2737);
            client.field333.method2728(class7.field137.field2737);
            client.field333.method2728(client.field451.field2737);
            client.field333.method2728(class42.field964.field2737);
            client.field333.method2728(class25.field644.field2737);
            client.field333.method2728(class0.field12.field2737);
            client.field333.method2728(class20.field581.field2737);
            client.field333.method2728(class104.field1811.field2737);
            client.field333.method2728(class10.field172.field2737);
            client.field333.method2728(class138.field2139.field2737);
            client.field333.method2681(var7, var2, client.field333.field2050);
            client.field333.method2629(client.field333.field2050 - var1);
            class40.field904.method3135(client.field333.field2051, 0, client.field333.field2050);
            client.field337.method2908(var7);

            for(var5 = 0; var5 < 4; ++var5) {
               var7[var5] += 50;
            }

            client.field339.method2908(var7);
            client.field349 = 6;
         }

         if(client.field349 == 6 && class40.field904.method3141() > 0) {
            var0 = class40.field904.method3140();
            if(var0 == 21 && client.field303 == 20) {
               client.field349 = 7;
            } else if(var0 == 2) {
               client.field349 = 9;
            } else if(var0 == 15 && client.field303 == 40) {
               client.field340 = -1;
               client.field349 = 13;
            } else if(var0 == 23 && client.field308 < 1) {
               ++client.field308;
               client.field349 = 0;
            } else {
               if(var0 != 29) {
                  class30.method686(var0);
                  return;
               }

               client.field349 = 11;
            }
         }

         if(client.field349 == 7 && class40.field904.method3141() > 0) {
            client.field450 = (class40.field904.method3140() + 3) * 60;
            client.field349 = 8;
         }

         if(client.field349 == 8) {
            client.field411 = 0;
            class37.method781("You have only just left another world.", "Your profile will be transferred in:", client.field450 / 60 + " seconds.");
            if(--client.field450 <= 0) {
               client.field349 = 0;
            }

         } else {
            if(client.field349 == 9 && class40.field904.method3141() >= 13) {
               boolean var14 = class40.field904.method3140() == 1;
               class40.field904.method3132(client.field339.field2051, 0, 4);
               client.field339.field2050 = 0;
               boolean var15 = false;
               if(var14) {
                  var1 = client.field339.method2898() << 24;
                  var1 |= client.field339.method2898() << 16;
                  var1 |= client.field339.method2898() << 8;
                  var1 |= client.field339.method2898();
                  var2 = class55.method1234(class33.field764);
                  if(class136.field2123.field147.size() >= 10 && !class136.field2123.field147.containsKey(Integer.valueOf(var2))) {
                     Iterator var16 = class136.field2123.field147.entrySet().iterator();
                     var16.next();
                     var16.remove();
                  }

                  class136.field2123.field147.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class42.method886();
               }

               client.field460 = class40.field904.method3140();
               client.field506 = class40.field904.method3140() == 1;
               client.field417 = class40.field904.method3140();
               client.field417 <<= 8;
               client.field417 += class40.field904.method3140();
               client.field418 = class40.field904.method3140();
               class40.field904.method3132(client.field339.field2051, 0, 1);
               client.field339.field2050 = 0;
               client.field341 = client.field339.method2898();
               class40.field904.method3132(client.field339.field2051, 0, 2);
               client.field339.field2050 = 0;
               client.field340 = client.field339.method2635();

               try {
                  class135.method2990(client.field477, "zap");
               } catch (Throwable var11) {
                  ;
               }

               client.field349 = 10;
            }

            if(client.field349 == 10) {
               if(class40.field904.method3141() >= client.field340) {
                  client.field339.field2050 = 0;
                  class40.field904.method3132(client.field339.field2051, 0, client.field340);
                  class212.method4079();
                  class30.method685(client.field339);
                  class48.field1092 = -1;
                  class2.method33(false);
                  client.field341 = -1;
               }

            } else {
               if(client.field349 == 11 && class40.field904.method3141() >= 2) {
                  client.field339.field2050 = 0;
                  class40.field904.method3132(client.field339.field2051, 0, 2);
                  client.field339.field2050 = 0;
                  class10.field171 = client.field339.method2635();
                  client.field349 = 12;
               }

               if(client.field349 == 12 && class40.field904.method3141() >= class10.field171) {
                  client.field339.field2050 = 0;
                  class40.field904.method3132(client.field339.field2051, 0, class10.field171);
                  client.field339.field2050 = 0;
                  String var18 = client.field339.method2663();
                  String var10 = client.field339.method2663();
                  String var9 = client.field339.method2663();
                  class37.method781(var18, var10, var9);
                  class138.method3024(10);
               }

               if(client.field349 != 13) {
                  ++client.field411;
                  if(client.field411 > 2000) {
                     if(client.field308 < 1) {
                        if(class109.field1943 == class12.field198) {
                           class109.field1943 = class56.field1235;
                        } else {
                           class109.field1943 = class12.field198;
                        }

                        ++client.field308;
                        client.field349 = 0;
                     } else {
                        class30.method686(-3);
                     }
                  }
               } else {
                  if(client.field340 == -1) {
                     if(class40.field904.method3141() < 2) {
                        return;
                     }

                     class40.field904.method3132(client.field339.field2051, 0, 2);
                     client.field339.field2050 = 0;
                     client.field340 = client.field339.method2635();
                  }

                  if(class40.field904.method3141() >= client.field340) {
                     class40.field904.method3132(client.field339.field2051, 0, client.field340);
                     client.field339.field2050 = 0;
                     var0 = client.field340;
                     client.field337.field2050 = 0;
                     client.field339.field2050 = 0;
                     client.field341 = -1;
                     client.field344 = 1;
                     client.field345 = -1;
                     client.field311 = -1;
                     client.field340 = 0;
                     client.field378 = 0;
                     client.field312 = 0;
                     client.field368 = 0;
                     client.field434 = false;
                     client.field530 = 0;
                     client.field371 = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        client.field302[var1] = null;
                     }

                     class3.field65 = null;

                     for(var1 = 0; var1 < client.field332.length; ++var1) {
                        class36 var19 = client.field332[var1];
                        if(null != var19) {
                           var19.field844 = -1;
                           var19.field865 = false;
                        }
                     }

                     class21.method581();
                     class138.method3024(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        client.field498[var1] = true;
                     }

                     class6.method103();
                     class30.method685(client.field339);
                     if(var0 != client.field339.field2050) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var13) {
         if(client.field308 < 1) {
            if(class109.field1943 == class12.field198) {
               class109.field1943 = class56.field1235;
            } else {
               class109.field1943 = class12.field198;
            }

            ++client.field308;
            client.field349 = 0;
         } else {
            class30.method686(-2);
         }
      }
   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1921486415"
   )
   static final void method2568(String var0) {
      if(var0 != null) {
         if((client.field391 < 200 || client.field418 == 1) && client.field391 < 400) {
            String var1 = class156.method3300(var0, client.field518);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < client.field391; ++var2) {
                  class17 var3 = client.field456[var2];
                  var4 = class156.method3300(var3.field250, client.field518);
                  if(var4 != null && var4.equals(var1)) {
                     class78.method1721(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var3.field246 != null) {
                     var5 = class156.method3300(var3.field246, client.field518);
                     if(null != var5 && var5.equals(var1)) {
                        class78.method1721(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < client.field565; ++var2) {
                  class7 var6 = client.field566[var2];
                  var4 = class156.method3300(var6.field132, client.field518);
                  if(null != var4 && var4.equals(var1)) {
                     class78.method1721(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(var6.field131 != null) {
                     var5 = class156.method3300(var6.field131, client.field518);
                     if(var5 != null && var5.equals(var1)) {
                        class78.method1721(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class156.method3300(class3.field65.field58, client.field518).equals(var1)) {
                  class78.method1721(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  client.field337.method2903(189);
                  client.field337.method2783(class54.method1165(var0));
                  client.field337.method2703(var0);
               }
            }
         } else {
            class78.method1721(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Lclass37;",
      garbageValue = "-88"
   )
   static class37 method2569(int var0) {
      return (class37)class11.field174.method3950((long)var0);
   }
}
