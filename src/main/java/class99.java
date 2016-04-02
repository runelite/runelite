import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("ItemLayer")
public final class class99 {
   @ObfuscatedName("al")
   static class168 field1651;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -538901565
   )
   @Export("x")
   int field1652;
   @ObfuscatedName("p")
   @Export("middle")
   class85 field1653;
   @ObfuscatedName("h")
   @Export("top")
   class85 field1654;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1864848395
   )
   @Export("y")
   int field1655;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 740682169
   )
   @Export("hash")
   int field1656;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1271756415
   )
   @Export("flags")
   int field1657;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 219272133
   )
   @Export("height")
   int field1658;
   @ObfuscatedName("s")
   @Export("bottom")
   class85 field1661;
   @ObfuscatedName("bo")
   static class80 field1662;

   @ObfuscatedName("w")
   public static class45 method2211(int var0) {
      class45 var1 = (class45)class45.field1017.method3754((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class45.field1024.method3280(19, var0);
         var1 = new class45();
         if(null != var2) {
            var1.method947(new class119(var2));
         }

         class45.field1017.method3756(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   public static byte[] method2212(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?class43.method916(var3):var3;
      } else if(var0 instanceof class125) {
         class125 var2 = (class125)var0;
         return var2.vmethod2794();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass136;Ljava/awt/Component;III)Lclass56;",
      garbageValue = "0"
   )
   public static final class56 method2213(class136 var0, int var1, int var2) {
      if(0 == class56.field1153) {
         throw new IllegalStateException();
      } else {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            class69 var6 = new class69();
            var6.field1151 = new int[(class56.field1160?2:1) * 256];
            var6.field1156 = var2;
            var6.vmethod1510();
            var6.field1161 = 1024 + (var2 & -1024);
            if(var6.field1161 > 16384) {
               var6.field1161 = 16384;
            }

            var6.vmethod1526(var6.field1161);
            if(class2.field60 > 0 && class56.field1150 == null) {
               class56.field1150 = new class72();
               class56.field1150.field1325 = var0;
               var0.method2888(class56.field1150, class2.field60);
            }

            if(class56.field1150 != null) {
               if(class56.field1150.field1321[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class56.field1150.field1321[var1] = var6;
            }

            return var6;
         } catch (Throwable var5) {
            try {
               class54 var3 = new class54(var0, var1);
               var3.field1151 = new int[256 * (class56.field1160?2:1)];
               var3.field1156 = var2;
               var3.vmethod1510();
               var3.field1161 = 16384;
               var3.vmethod1526(var3.field1161);
               if(class2.field60 > 0 && class56.field1150 == null) {
                  class56.field1150 = new class72();
                  class56.field1150.field1325 = var0;
                  var0.method2888(class56.field1150, class2.field60);
               }

               if(null != class56.field1150) {
                  if(class56.field1150.field1321[var1] != null) {
                     throw new IllegalArgumentException();
                  }

                  class56.field1150.field1321[var1] = var3;
               }

               return var3;
            } catch (Throwable var4) {
               return new class56();
            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-33582443"
   )
   static final void method2214() {
      try {
         if(0 == client.field542) {
            if(null != class46.field1040) {
               class46.field1040.method2982();
               class46.field1040 = null;
            }

            class15.field218 = null;
            client.field332 = false;
            client.field424 = 0;
            client.field542 = 1;
         }

         if(1 == client.field542) {
            if(null == class15.field218) {
               class15.field218 = class125.field2028.method2874(class101.field1732, class51.field1103);
            }

            if(class15.field218.field2213 == 2) {
               throw new IOException();
            }

            if(1 == class15.field218.field2213) {
               class46.field1040 = new class143((Socket)class15.field218.field2216, class125.field2028);
               class15.field218 = null;
               client.field542 = 2;
            }
         }

         if(client.field542 == 2) {
            client.field321.field1976 = 0;
            client.field321.method2565(14);
            class46.field1040.method2983(client.field321.field1980, 0, 1);
            client.field323.field1976 = 0;
            client.field542 = 3;
         }

         int var0;
         if(client.field542 == 3) {
            if(null != class221.field3179) {
               class221.field3179.method1176();
            }

            if(class5.field94 != null) {
               class5.field94.method1176();
            }

            var0 = class46.field1040.method2984();
            if(null != class221.field3179) {
               class221.field3179.method1176();
            }

            if(null != class5.field94) {
               class5.field94.method1176();
            }

            if(var0 != 0) {
               class9.method127(var0);
               return;
            }

            client.field323.field1976 = 0;
            client.field542 = 5;
         }

         int var1;
         int var2;
         if(client.field542 == 5) {
            int[] var8 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            client.field321.field1976 = 0;
            client.field321.method2565(1);
            client.field321.method2565(class31.field716.vmethod3172());
            client.field321.method2617(var8[0]);
            client.field321.method2617(var8[1]);
            client.field321.method2617(var8[2]);
            client.field321.method2617(var8[3]);
            switch(class31.field716.field2601) {
            case 0:
               client.field321.method2617(((Integer)class39.field865.field144.get(Integer.valueOf(class16.method181(class31.field703)))).intValue());
               client.field321.field1976 += 4;
               break;
            case 1:
            case 2:
               client.field321.method2510(class5.field99);
               client.field321.field1976 += 5;
               break;
            case 3:
               client.field321.field1976 += 8;
            }

            client.field321.method2514(class31.field715);
            client.field321.method2641(class4.field78, class4.field72);
            client.field429.field1976 = 0;
            if(40 == client.field287) {
               client.field429.method2565(18);
            } else {
               client.field429.method2565(16);
            }

            client.field429.method2713(0);
            var1 = client.field429.field1976;
            client.field429.method2617(111);
            client.field429.method2517(client.field321.field1980, 0, client.field321.field1976);
            var2 = client.field429.field1976;
            client.field429.method2514(class31.field703);
            client.field429.method2565((client.field398?1:0) << 1 | (client.field285?1:0));
            client.field429.method2713(class35.field762);
            client.field429.method2713(class21.field575);
            class1.method17(client.field429);
            client.field429.method2514(class0.field8);
            client.field429.method2617(class107.field1860);
            class119 var3 = new class119(class36.field784.method3180());
            class36.field784.method3179(var3);
            client.field429.method2517(var3.field1980, 0, var3.field1980.length);
            client.field429.method2565(class10.field166);
            client.field429.method2617(field1651.field2681);
            client.field429.method2617(class216.field3157.field2681);
            client.field429.method2617(class104.field1772.field2681);
            client.field429.method2617(class27.field659.field2681);
            client.field429.method2617(class143.field2175.field2681);
            client.field429.method2617(class32.field743.field2681);
            client.field429.method2617(class24.field611.field2681);
            client.field429.method2617(class19.field272.field2681);
            client.field429.method2617(class17.field246.field2681);
            client.field429.method2617(class124.field2023.field2681);
            client.field429.method2617(class108.field1880.field2681);
            client.field429.method2617(class82.field1406.field2681);
            client.field429.method2617(class59.field1189.field2681);
            client.field429.method2617(class72.field1319.field2681);
            client.field429.method2617(class133.field2057.field2681);
            client.field429.method2617(class115.field1956.field2681);
            client.field429.method2534(var8, var2, client.field429.field1976);
            client.field429.method2519(client.field429.field1976 - var1);
            class46.field1040.method2983(client.field429.field1980, 0, client.field429.field1976);
            client.field321.method2772(var8);

            for(int var4 = 0; var4 < 4; ++var4) {
               var8[var4] += 50;
            }

            client.field323.method2772(var8);
            client.field542 = 6;
         }

         if(client.field542 == 6 && class46.field1040.method2985() > 0) {
            var0 = class46.field1040.method2984();
            if(var0 == 21 && client.field287 == 20) {
               client.field542 = 7;
            } else if(var0 == 2) {
               client.field542 = 9;
            } else if(var0 == 15 && client.field287 == 40) {
               client.field324 = -1;
               client.field542 = 13;
            } else if(23 == var0 && client.field314 < 1) {
               ++client.field314;
               client.field542 = 0;
            } else {
               if(29 != var0) {
                  class9.method127(var0);
                  return;
               }

               client.field542 = 11;
            }
         }

         if(7 == client.field542 && class46.field1040.method2985() > 0) {
            client.field315 = (class46.field1040.method2984() + 3) * 60;
            client.field542 = 8;
         }

         if(8 == client.field542) {
            client.field424 = 0;
            class121.method2750("You have only just left another world.", "Your profile will be transferred in:", client.field315 / 60 + " seconds.");
            if(--client.field315 <= 0) {
               client.field542 = 0;
            }

         } else {
            if(client.field542 == 9 && class46.field1040.method2985() >= 13) {
               boolean var9 = class46.field1040.method2984() == 1;
               class46.field1040.method2991(client.field323.field1980, 0, 4);
               client.field323.field1976 = 0;
               boolean var10 = false;
               if(var9) {
                  var1 = client.field323.method2766() << 24;
                  var1 |= client.field323.method2766() << 16;
                  var1 |= client.field323.method2766() << 8;
                  var1 |= client.field323.method2766();
                  var2 = class16.method181(class31.field703);
                  if(class39.field865.field144.size() >= 10 && !class39.field865.field144.containsKey(Integer.valueOf(var2))) {
                     Iterator var15 = class39.field865.field144.entrySet().iterator();
                     var15.next();
                     var15.remove();
                  }

                  class39.field865.field144.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class43.method915();
               }

               client.field482 = class46.field1040.method2984();
               client.field447 = class46.field1040.method2984() == 1;
               client.field401 = class46.field1040.method2984();
               client.field401 <<= 8;
               client.field401 += class46.field1040.method2984();
               client.field402 = class46.field1040.method2984();
               class46.field1040.method2991(client.field323.field1980, 0, 1);
               client.field323.field1976 = 0;
               client.field325 = client.field323.method2766();
               class46.field1040.method2991(client.field323.field1980, 0, 2);
               client.field323.field1976 = 0;
               client.field324 = client.field323.method2700();
               if(1 == client.field402) {
                  try {
                     class132.method2836(client.field374, "zap");
                  } catch (Throwable var6) {
                     ;
                  }
               } else {
                  try {
                     class132.method2836(client.field374, "unzap");
                  } catch (Throwable var5) {
                     ;
                  }
               }

               client.field542 = 10;
            }

            if(10 == client.field542) {
               if(class46.field1040.method2985() >= client.field324) {
                  client.field323.field1976 = 0;
                  class46.field1040.method2991(client.field323.field1980, 0, client.field324);
                  class27.method645();
                  class10.method137(client.field323);
                  class5.field100 = -1;
                  class22.method582(false);
                  client.field325 = -1;
               }

            } else {
               if(client.field542 == 11 && class46.field1040.method2985() >= 2) {
                  client.field323.field1976 = 0;
                  class46.field1040.method2991(client.field323.field1980, 0, 2);
                  client.field323.field1976 = 0;
                  class162.field2647 = client.field323.method2700();
                  client.field542 = 12;
               }

               if(12 == client.field542 && class46.field1040.method2985() >= class162.field2647) {
                  client.field323.field1976 = 0;
                  class46.field1040.method2991(client.field323.field1980, 0, class162.field2647);
                  client.field323.field1976 = 0;
                  String var11 = client.field323.method2531();
                  String var13 = client.field323.method2531();
                  String var12 = client.field323.method2531();
                  class121.method2750(var11, var13, var12);
                  class141.method2971(10);
               }

               if(client.field542 != 13) {
                  ++client.field424;
                  if(client.field424 > 2000) {
                     if(client.field314 < 1) {
                        if(class51.field1103 == class155.field2281) {
                           class51.field1103 = class113.field1947;
                        } else {
                           class51.field1103 = class155.field2281;
                        }

                        ++client.field314;
                        client.field542 = 0;
                     } else {
                        class9.method127(-3);
                     }
                  }
               } else {
                  if(client.field324 == -1) {
                     if(class46.field1040.method2985() < 2) {
                        return;
                     }

                     class46.field1040.method2991(client.field323.field1980, 0, 2);
                     client.field323.field1976 = 0;
                     client.field324 = client.field323.method2700();
                  }

                  if(class46.field1040.method2985() >= client.field324) {
                     class46.field1040.method2991(client.field323.field1980, 0, client.field324);
                     client.field323.field1976 = 0;
                     var0 = client.field324;
                     client.field321.field1976 = 0;
                     client.field323.field1976 = 0;
                     client.field325 = -1;
                     client.field328 = -1;
                     client.field329 = -1;
                     client.field419 = -1;
                     client.field324 = 0;
                     client.field326 = 0;
                     client.field430 = 0;
                     client.field420 = 0;
                     client.field331 = false;
                     client.field514 = 0;
                     client.field432 = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        client.field387[var1] = null;
                     }

                     class20.field572 = null;

                     for(var1 = 0; var1 < client.field316.length; ++var1) {
                        class34 var14 = client.field316[var1];
                        if(null != var14) {
                           var14.field845 = -1;
                           var14.field800 = false;
                        }
                     }

                     class15.field216 = new class196(32);
                     class141.method2971(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        client.field483[var1] = true;
                     }

                     class17.method183();
                     class10.method137(client.field323);
                     if(client.field323.field1976 != var0) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var7) {
         if(client.field314 < 1) {
            if(class155.field2281 == class51.field1103) {
               class51.field1103 = class113.field1947;
            } else {
               class51.field1103 = class155.field2281;
            }

            ++client.field314;
            client.field542 = 0;
         } else {
            class9.method127(-2);
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1256410189"
   )
   static final void method2215(int var0) {
      short var1 = 256;
      class31.field697 += var0 * 128;
      int var2;
      if(class31.field697 > class27.field656.length) {
         class31.field697 -= class27.field656.length;
         var2 = (int)(Math.random() * 12.0D);
         class43.method917(class31.field695[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = 128 * (var1 - var0);

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = class77.field1369[var2 + var3] - var0 * class27.field656[class31.field697 + var2 & class27.field656.length - 1] / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         class77.field1369[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               class77.field1369[var6 + var7] = 255;
            } else {
               class77.field1369[var7 + var6] = 0;
            }
         }
      }

      if(class31.field701 > 0) {
         class31.field701 -= var0 * 4;
      }

      if(class31.field693 > 0) {
         class31.field693 -= var0 * 4;
      }

      if(0 == class31.field701 && 0 == class31.field693) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class31.field701 = 1024;
         }

         if(1 == var5) {
            class31.field693 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class31.field708[var5] = class31.field708[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class31.field708[var5] = (int)(Math.sin((double)class31.field706 / 14.0D) * 16.0D + Math.sin((double)class31.field706 / 15.0D) * 14.0D + Math.sin((double)class31.field706 / 16.0D) * 12.0D);
         ++class31.field706;
      }

      class31.field709 += var0;
      var5 = (var0 + (client.field289 & 1)) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class31.field709 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            class77.field1369[(var8 << 7) + var7] = 192;
         }

         class31.field709 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var9 + var5 < 128) {
                  var7 += class77.field1369[var5 + var8 + var9];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= class77.field1369[var8 + var9 - (1 + var5)];
               }

               if(var9 >= 0) {
                  class47.field1047[var8 + var9] = var7 / (1 + 2 * var5);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var5 + var8 < var1) {
                  var7 += class47.field1047[128 * var5 + var6 + var9];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= class47.field1047[var6 + var9 - (1 + var5) * 128];
               }

               if(var8 >= 0) {
                  class77.field1369[var9 + var6] = var7 / (var5 * 2 + 1);
               }
            }
         }
      }

   }

   @ObfuscatedName("e")
   public static class131 method2216() {
      try {
         return new class145();
      } catch (Throwable var1) {
         return null;
      }
   }

   @ObfuscatedName("w")
   public static int method2217(char var0) {
      int var1 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var1 = 1 + (var0 << 4);
      }

      return var1;
   }

   @ObfuscatedName("e")
   public static void method2218(class167 var0, int var1, int var2, int var3, boolean var4) {
      class183.field2958 = 1;
      class14.field209 = var0;
      class148.field2219 = var1;
      class164.field2656 = var2;
      class96.field1611 = var3;
      class125.field2030 = var4;
      class209.field3118 = 10000;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "93"
   )
   static final void method2219(boolean var0) {
      client.field403 = 0;
      client.field502 = 0;
      client.field323.method2755();
      int var1 = client.field323.method2756(8);
      int var2;
      if(var1 < client.field317) {
         for(var2 = var1; var2 < client.field317; ++var2) {
            client.field404[++client.field403 - 1] = client.field318[var2];
         }
      }

      if(var1 > client.field317) {
         throw new RuntimeException("");
      } else {
         client.field317 = 0;

         int var5;
         int var6;
         int var7;
         int var8;
         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = client.field318[var2];
            class34 var4 = client.field316[var3];
            var5 = client.field323.method2756(1);
            if(0 == var5) {
               client.field318[++client.field317 - 1] = var3;
               var4.field846 = client.field289;
            } else {
               var6 = client.field323.method2756(2);
               if(var6 == 0) {
                  client.field318[++client.field317 - 1] = var3;
                  var4.field846 = client.field289;
                  client.field445[++client.field502 - 1] = var3;
               } else if(var6 == 1) {
                  client.field318[++client.field317 - 1] = var3;
                  var4.field846 = client.field289;
                  var7 = client.field323.method2756(3);
                  var4.method716(var7, (byte)1);
                  var8 = client.field323.method2756(1);
                  if(1 == var8) {
                     client.field445[++client.field502 - 1] = var3;
                  }
               } else if(2 == var6) {
                  client.field318[++client.field317 - 1] = var3;
                  var4.field846 = client.field289;
                  var7 = client.field323.method2756(3);
                  var4.method716(var7, (byte)2);
                  var8 = client.field323.method2756(3);
                  var4.method716(var8, (byte)2);
                  int var9 = client.field323.method2756(1);
                  if(var9 == 1) {
                     client.field445[++client.field502 - 1] = var3;
                  }
               } else if(var6 == 3) {
                  client.field404[++client.field403 - 1] = var3;
               }
            }
         }

         class34 var11;
         int var12;
         while(client.field323.method2758(client.field324) >= 27) {
            var1 = client.field323.method2756(15);
            if(var1 == 32767) {
               break;
            }

            boolean var10 = false;
            if(client.field316[var1] == null) {
               client.field316[var1] = new class34();
               var10 = true;
            }

            var11 = client.field316[var1];
            client.field318[++client.field317 - 1] = var1;
            var11.field846 = client.field289;
            if(var0) {
               var12 = client.field323.method2756(8);
               if(var12 > 127) {
                  var12 -= 256;
               }
            } else {
               var12 = client.field323.method2756(5);
               if(var12 > 15) {
                  var12 -= 32;
               }
            }

            var11.field755 = class172.method3370(client.field323.method2756(14));
            var5 = client.field408[client.field323.method2756(3)];
            if(var10) {
               var11.field793 = var11.field790 = var5;
            }

            var6 = client.field323.method2756(1);
            if(1 == var6) {
               client.field445[++client.field502 - 1] = var1;
            }

            if(var0) {
               var7 = client.field323.method2756(8);
               if(var7 > 127) {
                  var7 -= 256;
               }
            } else {
               var7 = client.field323.method2756(5);
               if(var7 > 15) {
                  var7 -= 32;
               }
            }

            var8 = client.field323.method2756(1);
            var11.field792 = var11.field755.field871;
            var11.field841 = var11.field755.field887;
            if(0 == var11.field841) {
               var11.field790 = 0;
            }

            var11.field796 = var11.field755.field870;
            var11.field829 = var11.field755.field897;
            var11.field798 = var11.field755.field872;
            var11.field799 = var11.field755.field862;
            var11.field847 = var11.field755.field867;
            var11.field794 = var11.field755.field868;
            var11.field795 = var11.field755.field869;
            var11.method713(class20.field572.field842[0] + var12, class20.field572.field843[0] + var7, 1 == var8);
         }

         client.field323.method2754();

         for(var1 = 0; var1 < client.field502; ++var1) {
            var2 = client.field445[var1];
            var11 = client.field316[var2];
            var12 = client.field323.method2523();
            if(0 != (var12 & 64)) {
               var5 = client.field323.method2700();
               if(var5 == '\uffff') {
                  var5 = -1;
               }

               var6 = client.field323.method2523();
               if(var5 == var11.field819 && -1 != var5) {
                  var7 = class46.method974(var5).field971;
                  if(1 == var7) {
                     var11.field789 = 0;
                     var11.field821 = 0;
                     var11.field822 = var6;
                     var11.field823 = 0;
                  }

                  if(2 == var7) {
                     var11.field823 = 0;
                  }
               } else if(var5 == -1 || var11.field819 == -1 || class46.method974(var5).field973 >= class46.method974(var11.field819).field973) {
                  var11.field819 = var5;
                  var11.field789 = 0;
                  var11.field821 = 0;
                  var11.field822 = var6;
                  var11.field823 = 0;
                  var11.field811 = var11.field834;
               }
            }

            if(0 != (var12 & 4)) {
               var5 = client.field323.method2587();
               var6 = client.field323.method2700();
               var7 = var11.field804 - 64 * (var5 - class85.field1439 - class85.field1439);
               var8 = var11.field814 - 64 * (var6 - class6.field128 - class6.field128);
               if(0 != var7 || 0 != var8) {
                  var11.field815 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
               }
            }

            if((var12 & 32) != 0) {
               var5 = client.field323.method2551();
               var6 = client.field323.method2523();
               var11.method743(var5, var6, client.field289);
               var11.field810 = 300 + client.field289;
               var11.field836 = client.field323.method2557();
               var11.field812 = client.field323.method2587();
            }

            if((var12 & 128) != 0) {
               var11.field824 = client.field323.method2700();
               var5 = client.field323.method2566();
               var11.field828 = var5 >> 16;
               var11.field827 = (var5 & '\uffff') + client.field289;
               var11.field817 = 0;
               var11.field826 = 0;
               if(var11.field827 > client.field289) {
                  var11.field817 = -1;
               }

               if('\uffff' == var11.field824) {
                  var11.field824 = -1;
               }
            }

            if(0 != (var12 & 2)) {
               var11.field801 = client.field323.method2531();
               var11.field837 = 100;
            }

            if(0 != (var12 & 16)) {
               var11.field845 = client.field323.method2561();
               if('\uffff' == var11.field845) {
                  var11.field845 = -1;
               }
            }

            if((var12 & 8) != 0) {
               var5 = client.field323.method2549();
               var6 = client.field323.method2550();
               var11.method743(var5, var6, client.field289);
               var11.field810 = 300 + client.field289;
               var11.field836 = client.field323.method2561();
               var11.field812 = client.field323.method2587();
            }

            if((var12 & 1) != 0) {
               var11.field755 = class172.method3370(client.field323.method2700());
               var11.field792 = var11.field755.field871;
               var11.field841 = var11.field755.field887;
               var11.field796 = var11.field755.field870;
               var11.field829 = var11.field755.field897;
               var11.field798 = var11.field755.field872;
               var11.field799 = var11.field755.field862;
               var11.field847 = var11.field755.field867;
               var11.field794 = var11.field755.field868;
               var11.field795 = var11.field755.field869;
            }
         }

         for(var1 = 0; var1 < client.field403; ++var1) {
            var2 = client.field404[var1];
            if(client.field289 != client.field316[var2].field846) {
               client.field316[var2].field755 = null;
               client.field316[var2] = null;
            }
         }

         if(client.field324 != client.field323.field1976) {
            throw new RuntimeException(client.field323.field1976 + "," + client.field324);
         } else {
            for(var1 = 0; var1 < client.field317; ++var1) {
               if(client.field316[client.field318[var1]] == null) {
                  throw new RuntimeException(var1 + "," + client.field317);
               }
            }

         }
      }
   }
}
