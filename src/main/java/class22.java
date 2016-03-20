import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("q")
public class class22 extends class203 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1613856137
   )
   int field595;
   @ObfuscatedName("r")
   int[] field596;
   @ObfuscatedName("f")
   int[] field597;
   @ObfuscatedName("s")
   String[] field598;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -248173183
   )
   int field599;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1075817171
   )
   int field600;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -749249273
   )
   int field601;
   @ObfuscatedName("a")
   static class192 field604 = new class192(128);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass166;Lclass166;IZB)Lclass102;",
      garbageValue = "0"
   )
   public static class102 method575(class166 var0, class166 var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.method3272(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.method3299(var2, var5[var6]);
         if(null == var7) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9 = var1.method3299(var8, 0);
            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new class102(var0, var1, var2, var3);
         } catch (Exception var10) {
            return null;
         }
      }
   }

   @ObfuscatedName("f")
   public static void method576(int var0, class166 var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.method3278(var2);
      int var7 = var1.method3328(var6, var3);
      class35.method735(var0, var1, var6, var7, var4, var5);
   }

   @ObfuscatedName("j")
   public static int method578(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("f")
   static String method579(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class147) {
         class147 var2 = (class147)var0;
         var1 = var2.field2208 + " | ";
         var0 = var2.field2212;
      } else {
         var1 = "";
      }

      StringWriter var12 = new StringWriter();
      PrintWriter var3 = new PrintWriter(var12);
      var0.printStackTrace(var3);
      var3.close();
      String var4 = var12.toString();
      BufferedReader var5 = new BufferedReader(new StringReader(var4));
      String var6 = var5.readLine();

      while(true) {
         while(true) {
            String var7 = var5.readLine();
            if(var7 == null) {
               var1 = var1 + "| " + var6;
               return var1;
            }

            int var8 = var7.indexOf(40);
            int var9 = var7.indexOf(41, 1 + var8);
            if(var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(1 + var8, var9);
               int var11 = var10.indexOf(".java:");
               if(var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(5 + var11);
                  var1 = var1 + var10 + ' ';
                  continue;
               }

               var7 = var7.substring(0, var8);
            }

            var7 = var7.trim();
            var7 = var7.substring(var7.lastIndexOf(32) + 1);
            var7 = var7.substring(var7.lastIndexOf(9) + 1);
            var1 = var1 + var7 + ' ';
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1402808431"
   )
   static final void method581() {
      try {
         if(client.field335 == 0) {
            if(null != class178.field2912) {
               class178.field2912.method3019();
               class178.field2912 = null;
            }

            class149.field2235 = null;
            client.field346 = false;
            client.field384 = 0;
            client.field335 = 1;
         }

         if(client.field335 == 1) {
            if(class149.field2235 == null) {
               class149.field2235 = class129.field2056.method2884(class32.field768, class36.field800);
            }

            if(2 == class149.field2235.field2202) {
               throw new IOException();
            }

            if(1 == class149.field2235.field2202) {
               class178.field2912 = new class142((Socket)class149.field2235.field2206, class129.field2056);
               class149.field2235 = null;
               client.field335 = 2;
            }
         }

         if(2 == client.field335) {
            client.field301.field1979 = 0;
            client.field301.method2497(14);
            class178.field2912.method3003(client.field301.field1980, 0, 1);
            client.field472.field1979 = 0;
            client.field335 = 3;
         }

         int var0;
         if(3 == client.field335) {
            if(null != class76.field1380) {
               class76.field1380.method1195();
            }

            if(null != class2.field53) {
               class2.field53.method1195();
            }

            var0 = class178.field2912.method3005();
            if(null != class76.field1380) {
               class76.field1380.method1195();
            }

            if(null != class2.field53) {
               class2.field53.method1195();
            }

            if(0 != var0) {
               class4.method55(var0);
               return;
            }

            client.field472.field1979 = 0;
            client.field335 = 5;
         }

         int var1;
         int var2;
         if(5 == client.field335) {
            int[] var11 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            client.field301.field1979 = 0;
            client.field301.method2497(1);
            client.field301.method2497(class31.field715.vmethod3184());
            client.field301.method2663(var11[0]);
            client.field301.method2663(var11[1]);
            client.field301.method2663(var11[2]);
            client.field301.method2663(var11[3]);
            switch(class31.field715.field2582) {
            case 0:
            case 2:
               client.field301.method2499(class177.field2899);
               client.field301.field1979 += 5;
               break;
            case 1:
               client.field301.method2663(((Integer)class89.field1548.field134.get(Integer.valueOf(class128.method2830(class31.field742)))).intValue());
               client.field301.field1979 += 4;
               break;
            case 3:
               client.field301.field1979 += 8;
            }

            client.field301.method2503(class31.field726);
            client.field301.method2551(class4.field70, class4.field64);
            client.field477.field1979 = 0;
            if(40 == client.field552) {
               client.field477.method2497(18);
            } else {
               client.field477.method2497(16);
            }

            client.field477.method2498(0);
            var1 = client.field477.field1979;
            client.field477.method2663(109);
            client.field477.method2699(client.field301.field1980, 0, client.field301.field1979);
            var2 = client.field477.field1979;
            client.field477.method2503(class31.field742);
            client.field477.method2497((client.field508?1:0) << 1 | (client.field297?1:0));
            client.field477.method2498(class6.field107);
            client.field477.method2498(class31.field749);
            class121 var3 = client.field477;
            byte[] var4 = new byte[24];

            int var5;
            try {
               class148.field2223.method4173(0L);
               class148.field2223.method4175(var4);

               for(var5 = 0; var5 < 24 && var4[var5] == 0; ++var5) {
                  ;
               }

               if(var5 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var9) {
               for(int var6 = 0; var6 < 24; ++var6) {
                  var4[var6] = -1;
               }
            }

            var3.method2699(var4, 0, 24);
            client.field477.method2503(class3.field58);
            client.field477.method2663(client.field299);
            class118 var20 = new class118(class9.field154.method3188());
            class9.field154.method3187(var20);
            client.field477.method2699(var20.field1980, 0, var20.field1980.length);
            client.field477.method2497(client.field462);
            client.field477.method2663(class27.field672.field2665);
            client.field477.method2663(class138.field2129.field2665);
            client.field477.method2663(class48.field1079.field2665);
            client.field477.method2663(class188.field3040.field2665);
            client.field477.method2663(class12.field181.field2665);
            client.field477.method2663(class49.field1088.field2665);
            client.field477.method2663(class129.field2054.field2665);
            client.field477.method2663(class175.field2892.field2665);
            client.field477.method2663(class7.field127.field2665);
            client.field477.method2663(class1.field18.field2665);
            client.field477.method2663(class213.field3146.field2665);
            client.field477.method2663(class29.field701.field2665);
            client.field477.method2663(class24.field623.field2665);
            client.field477.method2663(class77.field1391.field2665);
            client.field477.method2663(class124.field2035.field2665);
            client.field477.method2663(class20.field588.field2665);
            client.field477.method2530(var11, var2, client.field477.field1979);
            client.field477.method2508(client.field477.field1979 - var1);
            class178.field2912.method3003(client.field477.field1980, 0, client.field477.field1979);
            client.field301.method2751(var11);

            for(var5 = 0; var5 < 4; ++var5) {
               var11[var5] += 50;
            }

            client.field472.method2751(var11);
            client.field335 = 6;
         }

         if(client.field335 == 6 && class178.field2912.method3001() > 0) {
            var0 = class178.field2912.method3005();
            if(21 == var0 && 20 == client.field552) {
               client.field335 = 7;
            } else if(var0 == 2) {
               client.field335 = 9;
            } else if(var0 == 15 && client.field552 == 40) {
               client.field569 = -1;
               client.field335 = 13;
            } else if(23 == var0 && client.field421 < 1) {
               ++client.field421;
               client.field335 = 0;
            } else {
               if(var0 != 29) {
                  class4.method55(var0);
                  return;
               }

               client.field335 = 11;
            }
         }

         if(7 == client.field335 && class178.field2912.method3001() > 0) {
            client.field328 = (class178.field2912.method3005() + 3) * 60;
            client.field335 = 8;
         }

         if(8 == client.field335) {
            client.field384 = 0;
            class4.method56("You have only just left another world.", "Your profile will be transferred in:", client.field328 / 60 + " seconds.");
            if(--client.field328 <= 0) {
               client.field335 = 0;
            }

         } else {
            if(client.field335 == 9 && class178.field2912.method3001() >= 13) {
               boolean var12 = class178.field2912.method3005() == 1;
               class178.field2912.method3002(client.field472.field1980, 0, 4);
               client.field472.field1979 = 0;
               boolean var13 = false;
               if(var12) {
                  var1 = client.field472.method2752() << 24;
                  var1 |= client.field472.method2752() << 16;
                  var1 |= client.field472.method2752() << 8;
                  var1 |= client.field472.method2752();
                  var2 = class128.method2830(class31.field742);
                  if(class89.field1548.field134.size() >= 10 && !class89.field1548.field134.containsKey(Integer.valueOf(var2))) {
                     Iterator var17 = class89.field1548.field134.entrySet().iterator();
                     var17.next();
                     var17.remove();
                  }

                  class89.field1548.field134.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class108.method2430();
               }

               client.field460 = class178.field2912.method3005();
               client.field471 = class178.field2912.method3005() == 1;
               client.field416 = class178.field2912.method3005();
               client.field416 <<= 8;
               client.field416 += class178.field2912.method3005();
               client.field459 = class178.field2912.method3005();
               class178.field2912.method3002(client.field472.field1980, 0, 1);
               client.field472.field1979 = 0;
               client.field488 = client.field472.method2752();
               class178.field2912.method3002(client.field472.field1980, 0, 2);
               client.field472.field1979 = 0;
               client.field569 = client.field472.method2514();
               client var15;
               if(1 == client.field459) {
                  try {
                     var15 = client.field540;
                     JSObject.getWindow(var15).call("zap", (Object[])null);
                  } catch (Throwable var8) {
                     ;
                  }
               } else {
                  try {
                     var15 = client.field540;
                     JSObject.getWindow(var15).call("unzap", (Object[])null);
                  } catch (Throwable var7) {
                     ;
                  }
               }

               client.field335 = 10;
            }

            if(client.field335 == 10) {
               if(class178.field2912.method3001() >= client.field569) {
                  client.field472.field1979 = 0;
                  class178.field2912.method3002(client.field472.field1980, 0, client.field569);
                  class36.method750();
                  class172.method3414(client.field472);
                  class38.field873 = -1;
                  class39.method802(false);
                  client.field488 = -1;
               }

            } else {
               if(client.field335 == 11 && class178.field2912.method3001() >= 2) {
                  client.field472.field1979 = 0;
                  class178.field2912.method3002(client.field472.field1980, 0, 2);
                  client.field472.field1979 = 0;
                  client.field329 = client.field472.method2514();
                  client.field335 = 12;
               }

               if(client.field335 == 12 && class178.field2912.method3001() >= client.field329) {
                  client.field472.field1979 = 0;
                  class178.field2912.method3002(client.field472.field1980, 0, client.field329);
                  client.field472.field1979 = 0;
                  String var14 = client.field472.method2520();
                  String var16 = client.field472.method2520();
                  String var18 = client.field472.method2520();
                  class4.method56(var14, var16, var18);
                  class1.method9(10);
               }

               if(13 != client.field335) {
                  ++client.field384;
                  if(client.field384 > 2000) {
                     if(client.field421 < 1) {
                        if(class36.field800 == class72.field1350) {
                           class36.field800 = class94.field1612;
                        } else {
                           class36.field800 = class72.field1350;
                        }

                        ++client.field421;
                        client.field335 = 0;
                     } else {
                        class4.method55(-3);
                     }
                  }
               } else {
                  if(-1 == client.field569) {
                     if(class178.field2912.method3001() < 2) {
                        return;
                     }

                     class178.field2912.method3002(client.field472.field1980, 0, 2);
                     client.field472.field1979 = 0;
                     client.field569 = client.field472.method2514();
                  }

                  if(class178.field2912.method3001() >= client.field569) {
                     class178.field2912.method3002(client.field472.field1980, 0, client.field569);
                     client.field472.field1979 = 0;
                     var0 = client.field569;
                     client.field301.field1979 = 0;
                     client.field472.field1979 = 0;
                     client.field488 = -1;
                     client.field342 = 1;
                     client.field343 = -1;
                     client.field344 = -1;
                     client.field569 = 0;
                     client.field340 = 0;
                     client.field310 = 0;
                     client.field435 = 0;
                     client.field470 = false;
                     client.field530 = 0;
                     client.field528 = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        client.field415[var1] = null;
                     }

                     class151.field2253 = null;

                     for(var1 = 0; var1 < client.field358.length; ++var1) {
                        class34 var19 = client.field358[var1];
                        if(var19 != null) {
                           var19.field837 = -1;
                           var19.field818 = false;
                        }
                     }

                     class15.field225 = new class195(32);
                     class1.method9(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        client.field499[var1] = true;
                     }

                     client.field301.method2753(78);
                     class121 var21 = client.field301;
                     var2 = client.field508?2:1;
                     var21.method2497(var2);
                     client.field301.method2498(class6.field107);
                     client.field301.method2498(class31.field749);
                     class172.method3414(client.field472);
                     if(client.field472.field1979 != var0) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var10) {
         if(client.field421 < 1) {
            if(class36.field800 == class72.field1350) {
               class36.field800 = class94.field1612;
            } else {
               class36.field800 = class72.field1350;
            }

            ++client.field421;
            client.field335 = 0;
         } else {
            class4.method55(-2);
         }
      }
   }
}
