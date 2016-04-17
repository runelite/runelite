import java.awt.Container;
import java.awt.Insets;
import java.io.IOException;
import java.math.BigInteger;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("m")
public class class9 {
   @ObfuscatedName("y")
   static final BigInteger field160 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("k")
   static final BigInteger field161 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("dw")
   static byte[][] field168;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = 212492173
   )
   static int field169;

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "24"
   )
   static final void method159(String var0) {
      if(var0 != null) {
         String var1 = class23.method672(var0, client.field551);
         if(null != var1) {
            for(int var2 = 0; var2 < client.field561; ++var2) {
               class17 var3 = client.field563[var2];
               String var4 = var3.field261;
               String var5 = class23.method672(var4, client.field551);
               if(class159.method3267(var0, var1, var4, var5)) {
                  --client.field561;

                  for(int var6 = var2; var6 < client.field561; ++var6) {
                     client.field563[var6] = client.field563[var6 + 1];
                  }

                  client.field486 = client.field477;
                  client.field338.method2873(59);
                  client.field338.method2603(class104.method2383(var0));
                  client.field338.method2694(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1623478432"
   )
   static void method160() {
      client var0 = client.field294;
      synchronized(client.field294) {
         Container var1 = client.field294.method3128();
         if(var1 != null) {
            class133.field2071 = Math.max(var1.getSize().width, class191.field3076);
            class8.field155 = Math.max(var1.getSize().height, class30.field719);
            Insets var2;
            if(class32.field760 == var1) {
               var2 = class32.field760.getInsets();
               class133.field2071 -= var2.left + var2.right;
               class8.field155 -= var2.bottom + var2.top;
            }

            if(class133.field2071 <= 0) {
               class133.field2071 = 1;
            }

            if(class8.field155 <= 0) {
               class8.field155 = 1;
            }

            if(class24.method674() == 1) {
               class37.field876 = client.field438;
               class98.field1671 = client.field509;
            } else {
               class37.field876 = Math.min(class133.field2071, 7680);
               class98.field1671 = Math.min(class8.field155, 2160);
            }

            class144.field2192 = (class133.field2071 - class37.field876) / 2;
            class144.field2191 = 0;
            class158.field2585.setSize(class37.field876, class98.field1671);
            class28.field695 = class49.method1098(class37.field876, class98.field1671, class158.field2585);
            if(class32.field760 == var1) {
               var2 = class32.field760.getInsets();
               class158.field2585.setLocation(var2.left + class144.field2192, class144.field2191 + var2.top);
            } else {
               class158.field2585.setLocation(class144.field2192, class144.field2191);
            }

            int var9 = class37.field876;
            int var3 = class98.field1671;
            if(class133.field2071 < var9) {
               var9 = class133.field2071;
            }

            if(class8.field155 < var3) {
               var3 = class8.field155;
            }

            if(null != class134.field2078) {
               try {
                  client var4 = client.field294;
                  Object[] var5 = new Object[]{Integer.valueOf(class24.method674())};
                  JSObject.getWindow(var4).call("resize", var5);
               } catch (Throwable var7) {
                  ;
               }
            }

            if(client.field452 != -1) {
               class47.method1085(true);
            }

            class93.method2250();
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "-32480"
   )
   public static boolean method161(int var0) {
      if(class163.field2642[var0]) {
         return true;
      } else if(!class173.field2802.method3373(var0)) {
         return false;
      } else {
         int var1 = class173.field2802.method3372(var0);
         if(0 == var1) {
            class163.field2642[var0] = true;
            return true;
         } else {
            if(null == class173.field2886[var0]) {
               class173.field2886[var0] = new class173[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(null == class173.field2886[var0][var2]) {
                  byte[] var3 = class173.field2802.method3403(var0, var2);
                  if(var3 != null) {
                     class173.field2886[var0][var2] = new class173();
                     class173.field2886[var0][var2].field2842 = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        class173.field2886[var0][var2].method3499(new class119(var3));
                     } else {
                        class173.field2886[var0][var2].method3489(new class119(var3));
                     }
                  }
               }
            }

            class163.field2642[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1"
   )
   static final void method162(boolean var0) {
      client.field356 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!client.field356) {
         var1 = client.field441.method2648();
         var2 = client.field441.method2597();
         var3 = client.field441.method2615();
         class106.field1859 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class106.field1859[var4][var5] = client.field441.method2618();
            }
         }

         class12.field203 = new int[var3];
         class72.field1359 = new int[var3];
         class110.field1929 = new int[var3];
         field168 = new byte[var3][];
         class7.field136 = new byte[var3][];
         boolean var13 = false;
         if((48 == var1 / 8 || 49 == var1 / 8) && var2 / 8 == 48) {
            var13 = true;
         }

         if(var1 / 8 == 48 && 148 == var2 / 8) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (6 + var1) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (6 + var2) / 8; ++var6) {
               var7 = (var5 << 8) + var6;
               if(!var13 || 49 != var6 && 149 != var6 && 147 != var6 && 50 != var5 && (var5 != 49 || var6 != 47)) {
                  class12.field203[var3] = var7;
                  class72.field1359[var3] = class8.field156.method3377("m" + var5 + "_" + var6);
                  class110.field1929[var3] = class8.field156.method3377("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class28.method735(var1, var2);
      } else {
         var1 = client.field441.method2648();
         var2 = client.field441.method2597();
         var3 = client.field441.method2615();
         client.field441.method2866();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field441.method2863(1);
                  if(var7 == 1) {
                     client.field529[var4][var5][var6] = client.field441.method2863(26);
                  } else {
                     client.field529[var4][var5][var6] = -1;
                  }
               }
            }
         }

         client.field441.method2868();
         class106.field1859 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class106.field1859[var4][var5] = client.field441.method2618();
            }
         }

         class12.field203 = new int[var3];
         class72.field1359 = new int[var3];
         class110.field1929 = new int[var3];
         field168 = new byte[var3][];
         class7.field136 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field529[var4][var5][var6];
                  if(-1 != var7) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = var9 / 8 + (var8 / 8 << 8);

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(var10 == class12.field203[var11]) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(-1 != var10) {
                        class12.field203[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class72.field1359[var3] = class8.field156.method3377("m" + var11 + "_" + var12);
                        class110.field1929[var3] = class8.field156.method3377("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class28.method735(var1, var2);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "2048"
   )
   public static void method163() {
      class183.field2973.method3683();
      class183.field2967 = 1;
      class114.field1965 = null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1139447644"
   )
   static final void method164() {
      try {
         if(0 == client.field328) {
            if(class127.field2047 != null) {
               class127.field2047.method3095();
               class127.field2047 = null;
            }

            class135.field2086 = null;
            client.field349 = false;
            client.field329 = 0;
            client.field328 = 1;
         }

         if(client.field328 == 1) {
            if(class135.field2086 == null) {
               class135.field2086 = class107.field1874.method2990(class12.field191, class42.field1000);
            }

            if(2 == class135.field2086.field2210) {
               throw new IOException();
            }

            if(1 == class135.field2086.field2210) {
               class127.field2047 = new class143((Socket)class135.field2086.field2211, class107.field1874);
               class135.field2086 = null;
               client.field328 = 2;
            }
         }

         if(client.field328 == 2) {
            client.field338.field1992 = 0;
            client.field338.method2603(14);
            class127.field2047.method3100(client.field338.field1993, 0, 1);
            client.field441.field1992 = 0;
            client.field328 = 3;
         }

         int var0;
         if(3 == client.field328) {
            if(class96.field1627 != null) {
               class96.field1627.method1305();
            }

            if(null != client.field577) {
               client.field577.method1305();
            }

            var0 = class127.field2047.method3097();
            if(null != class96.field1627) {
               class96.field1627.method1305();
            }

            if(client.field577 != null) {
               client.field577.method1305();
            }

            if(var0 != 0) {
               class21.method644(var0);
               return;
            }

            client.field441.field1992 = 0;
            client.field328 = 5;
         }

         int var1;
         int var2;
         if(client.field328 == 5) {
            int[] var11 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            client.field338.field1992 = 0;
            client.field338.method2603(1);
            client.field338.method2603(class31.field739.vmethod3266());
            client.field338.method2786(var11[0]);
            client.field338.method2786(var11[1]);
            client.field338.method2786(var11[2]);
            client.field338.method2786(var11[3]);
            switch(class31.field739.field2593) {
            case 0:
            case 1:
               client.field338.method2675(class154.field2287);
               client.field338.field1992 += 5;
               break;
            case 2:
               client.field338.method2786(((Integer)class134.field2078.field150.get(Integer.valueOf(class113.method2541(class31.field749)))).intValue());
               client.field338.field1992 += 4;
               break;
            case 3:
               client.field338.field1992 += 8;
            }

            client.field338.method2694(class31.field740);
            client.field338.method2633(class4.field80, class4.field74);
            client.field339.field1992 = 0;
            if(40 == client.field554) {
               client.field339.method2603(18);
            } else {
               client.field339.method2603(16);
            }

            client.field339.method2599(0);
            var1 = client.field339.field1992;
            client.field339.method2786(112);
            client.field339.method2607(client.field338.field1993, 0, client.field338.field1992);
            var2 = client.field339.field1992;
            client.field339.method2694(class31.field749);
            client.field339.method2603((client.field344?1:0) << 1 | (client.field302?1:0));
            client.field339.method2599(class37.field876);
            client.field339.method2599(class98.field1671);
            class122 var3 = client.field339;
            byte[] var4 = new byte[24];

            int var5;
            try {
               class149.field2234.method4222(0L);
               class149.field2234.method4224(var4);

               for(var5 = 0; var5 < 24 && 0 == var4[var5]; ++var5) {
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

            var3.method2607(var4, 0, 24);
            client.field339.method2694(class14.field220);
            client.field339.method2786(class23.field611);
            class119 var19 = new class119(class20.field579.method3283());
            class20.field579.method3272(var19);
            client.field339.method2607(var19.field1993, 0, var19.field1993.length);
            client.field339.method2603(class129.field2050);
            client.field339.method2786(class45.field1057.field2672);
            client.field339.method2786(class99.field1682.field2672);
            client.field339.method2786(class29.field709.field2672);
            client.field339.method2786(class181.field2943.field2672);
            client.field339.method2786(class114.field1967.field2672);
            client.field339.method2786(class8.field156.field2672);
            client.field339.method2786(class38.field884.field2672);
            client.field339.method2786(class19.field279.field2672);
            client.field339.method2786(class103.field1768.field2672);
            client.field339.method2786(class135.field2082.field2672);
            client.field339.method2786(class48.field1089.field2672);
            client.field339.method2786(class36.field814.field2672);
            client.field339.method2786(class211.field3137.field2672);
            client.field339.method2786(class14.field219.field2672);
            client.field339.method2786(class21.field591.field2672);
            client.field339.method2786(class176.field2911.field2672);
            client.field339.method2602(var11, var2, client.field339.field1992);
            client.field339.method2811(client.field339.field1992 - var1);
            class127.field2047.method3100(client.field339.field1993, 0, client.field339.field1992);
            client.field338.method2878(var11);

            for(var5 = 0; var5 < 4; ++var5) {
               var11[var5] += 50;
            }

            client.field441.method2878(var11);
            client.field328 = 6;
         }

         if(6 == client.field328 && class127.field2047.method3098() > 0) {
            var0 = class127.field2047.method3097();
            if(var0 == 21 && client.field554 == 20) {
               client.field328 = 7;
            } else if(var0 == 2) {
               client.field328 = 9;
            } else if(var0 == 15 && 40 == client.field554) {
               client.field341 = -1;
               client.field328 = 13;
            } else if(var0 == 23 && client.field392 < 1) {
               ++client.field392;
               client.field328 = 0;
            } else {
               if(29 != var0) {
                  class21.method644(var0);
                  return;
               }

               client.field328 = 11;
            }
         }

         if(client.field328 == 7 && class127.field2047.method3098() > 0) {
            client.field331 = (class127.field2047.method3097() + 3) * 60;
            client.field328 = 8;
         }

         if(8 == client.field328) {
            client.field329 = 0;
            class39.method878("You have only just left another world.", "Your profile will be transferred in:", client.field331 / 60 + " seconds.");
            if(--client.field331 <= 0) {
               client.field328 = 0;
            }

         } else {
            if(9 == client.field328 && class127.field2047.method3098() >= 13) {
               boolean var12 = class127.field2047.method3097() == 1;
               class127.field2047.method3099(client.field441.field1993, 0, 4);
               client.field441.field1992 = 0;
               boolean var13 = false;
               if(var12) {
                  var1 = client.field441.method2865() << 24;
                  var1 |= client.field441.method2865() << 16;
                  var1 |= client.field441.method2865() << 8;
                  var1 |= client.field441.method2865();
                  var2 = class113.method2541(class31.field749);
                  if(class134.field2078.field150.size() >= 10 && !class134.field2078.field150.containsKey(Integer.valueOf(var2))) {
                     Iterator var17 = class134.field2078.field150.entrySet().iterator();
                     var17.next();
                     var17.remove();
                  }

                  class134.field2078.field150.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class213.method4031();
               }

               client.field345 = class127.field2047.method3097();
               client.field461 = class127.field2047.method3097() == 1;
               client.field457 = class127.field2047.method3097();
               client.field457 <<= 8;
               client.field457 += class127.field2047.method3097();
               client.field417 = class127.field2047.method3097();
               class127.field2047.method3099(client.field441.field1993, 0, 1);
               client.field441.field1992 = 0;
               client.field394 = client.field441.method2865();
               class127.field2047.method3099(client.field441.field1993, 0, 2);
               client.field441.field1992 = 0;
               client.field341 = client.field441.method2615();
               client var15;
               if(1 == client.field417) {
                  try {
                     var15 = client.field294;
                     JSObject.getWindow(var15).call("zap", (Object[])null);
                  } catch (Throwable var8) {
                     ;
                  }
               } else {
                  try {
                     var15 = client.field294;
                     JSObject.getWindow(var15).call("unzap", (Object[])null);
                  } catch (Throwable var7) {
                     ;
                  }
               }

               client.field328 = 10;
            }

            if(client.field328 == 10) {
               if(class127.field2047.method3098() >= client.field341) {
                  client.field441.field1992 = 0;
                  class127.field2047.method3099(client.field441.field1993, 0, client.field341);
                  class31.method774();
                  class175.method3525(client.field441);
                  class30.field710 = -1;
                  method162(false);
                  client.field394 = -1;
               }

            } else {
               if(client.field328 == 11 && class127.field2047.method3098() >= 2) {
                  client.field441.field1992 = 0;
                  class127.field2047.method3099(client.field441.field1993, 0, 2);
                  client.field441.field1992 = 0;
                  class116.field1981 = client.field441.method2615();
                  client.field328 = 12;
               }

               if(12 == client.field328 && class127.field2047.method3098() >= class116.field1981) {
                  client.field441.field1992 = 0;
                  class127.field2047.method3099(client.field441.field1993, 0, class116.field1981);
                  client.field441.field1992 = 0;
                  String var14 = client.field441.method2621();
                  String var16 = client.field441.method2621();
                  String var18 = client.field441.method2621();
                  class39.method878(var14, var16, var18);
                  class3.method49(10);
               }

               if(13 == client.field328) {
                  if(-1 == client.field341) {
                     if(class127.field2047.method3098() < 2) {
                        return;
                     }

                     class127.field2047.method3099(client.field441.field1993, 0, 2);
                     client.field441.field1992 = 0;
                     client.field341 = client.field441.method2615();
                  }

                  if(class127.field2047.method3098() >= client.field341) {
                     class127.field2047.method3099(client.field441.field1993, 0, client.field341);
                     client.field441.field1992 = 0;
                     var0 = client.field341;
                     class12.method193();
                     class175.method3525(client.field441);
                     if(var0 != client.field441.field1992) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++client.field329;
                  if(client.field329 > 2000) {
                     if(client.field392 < 1) {
                        if(class42.field1000 == class27.field680) {
                           class42.field1000 = client.field332;
                        } else {
                           class42.field1000 = class27.field680;
                        }

                        ++client.field392;
                        client.field328 = 0;
                     } else {
                        class21.method644(-3);
                     }
                  }
               }
            }
         }
      } catch (IOException var10) {
         if(client.field392 < 1) {
            if(class27.field680 == class42.field1000) {
               class42.field1000 = client.field332;
            } else {
               class42.field1000 = class27.field680;
            }

            ++client.field392;
            client.field328 = 0;
         } else {
            class21.method644(-2);
         }
      }
   }
}
