package net.runelite.rs.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("az")
public final class class34 extends class37 {
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      longValue = 489952066535864061L
   )
   static long field759;
   @ObfuscatedName("ew")
   static class80[] field760;
   @ObfuscatedName("j")
   class39 field761;
   @ObfuscatedName("s")
   static int[] field764;

   @ObfuscatedName("m")
   final void method757(int var1, int var2, boolean var3) {
      if(super.field829 != -1 && client.method584(super.field829).field985 == 1) {
         super.field829 = -1;
      }

      if(!var3) {
         int var4 = var1 - super.field809[0];
         int var5 = var2 - super.field816[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field851 < 9) {
               ++super.field851;
            }

            for(int var6 = super.field851; var6 > 0; --var6) {
               super.field809[var6] = super.field809[var6 - 1];
               super.field816[var6] = super.field816[var6 - 1];
               super.field855[var6] = super.field855[var6 - 1];
            }

            super.field809[0] = var1;
            super.field816[0] = var2;
            super.field855[0] = 1;
            return;
         }
      }

      super.field851 = 0;
      super.field856 = 0;
      super.field831 = 0;
      super.field809[0] = var1;
      super.field816[0] = var2;
      super.field846 = 128 * super.field809[0] + super.field802 * 64;
      super.field834 = super.field816[0] * 128 + super.field802 * 64;
   }

   @ObfuscatedName("h")
   final boolean vmethod791() {
      return this.field761 != null;
   }

   @ObfuscatedName("j")
   final void method759(int var1, byte var2) {
      int var3 = super.field809[0];
      int var4 = super.field816[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(2 == var1) {
         ++var3;
         ++var4;
      }

      if(3 == var1) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(5 == var1) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.field829 != -1 && client.method584(super.field829).field985 == 1) {
         super.field829 = -1;
      }

      if(super.field851 < 9) {
         ++super.field851;
      }

      for(int var5 = super.field851; var5 > 0; --var5) {
         super.field809[var5] = super.field809[var5 - 1];
         super.field816[var5] = super.field816[var5 - 1];
         super.field855[var5] = super.field855[var5 - 1];
      }

      super.field809[0] = var3;
      super.field816[0] = var4;
      super.field855[0] = var2;
   }

   @ObfuscatedName("f")
   protected final class104 vmethod1921() {
      if(null == this.field761) {
         return null;
      } else {
         class42 var1 = -1 != super.field829 && super.field832 == 0?client.method584(super.field829):null;
         class42 var2 = super.field826 != -1 && (super.field826 != super.field803 || null == var1)?client.method584(super.field826):null;
         class104 var3 = this.field761.method823(var1, super.field830, var2, super.field827);
         if(null == var3) {
            return null;
         } else {
            var3.method2334();
            super.field811 = var3.field1441;
            if(super.field805 != -1 && -1 != super.field835) {
               class104 var4 = class10.method156(super.field805).method948(super.field835);
               if(var4 != null) {
                  var4.method2344(0, -super.field838, 0);
                  class104[] var5 = new class104[]{var3, var4};
                  var3 = new class104(var5, 2);
               }
            }

            if(this.field761.field871 == 1) {
               var3.field1821 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("p")
   static final void method766() {
      try {
         if(client.field309 == 0) {
            if(null != class11.field170) {
               class11.field170.method3022();
               class11.field170 = null;
            }

            class19.field259 = null;
            client.field329 = false;
            client.field310 = 0;
            client.field309 = 1;
         }

         if(1 == client.field309) {
            if(null == class19.field259) {
               class19.field259 = class25.field630.method2915(class41.field959, class15.field219);
            }

            if(2 == class19.field259.field2198) {
               throw new IOException();
            }

            if(class19.field259.field2198 == 1) {
               class11.field170 = new class142((Socket)class19.field259.field2204, class25.field630);
               class19.field259 = null;
               client.field309 = 2;
            }
         }

         if(client.field309 == 2) {
            client.field318.field1981 = 0;
            client.field318.method2521(14);
            class11.field170.method3042(client.field318.field1980, 0, 1);
            client.field320.field1981 = 0;
            client.field309 = 3;
         }

         int var0;
         if(client.field309 == 3) {
            if(class15.field212 != null) {
               class15.field212.method1219();
            }

            if(class29.field675 != null) {
               class29.field675.method1219();
            }

            var0 = class11.field170.method3023();
            if(class15.field212 != null) {
               class15.field212.method1219();
            }

            if(null != class29.field675) {
               class29.field675.method1219();
            }

            if(var0 != 0) {
               class26.method676(var0);
               return;
            }

            client.field320.field1981 = 0;
            client.field309 = 5;
         }

         int var1;
         int var2;
         if(5 == client.field309) {
            int[] var11 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            client.field318.field1981 = 0;
            client.field318.method2521(1);
            client.field318.method2521(class31.field720.vmethod3208());
            client.field318.method2524(var11[0]);
            client.field318.method2524(var11[1]);
            client.field318.method2524(var11[2]);
            client.field318.method2524(var11[3]);
            switch(class31.field720.field2580) {
            case 0:
            case 3:
               client.field318.method2523(class3.field64);
               client.field318.field1981 += 5;
               break;
            case 1:
               client.field318.method2524(((Integer)class153.field2277.field137.get(Integer.valueOf(class20.method597(class31.field713)))).intValue());
               client.field318.field1981 += 4;
               break;
            case 2:
               client.field318.field1981 += 8;
            }

            client.field318.method2527(class31.field726);
            client.field318.method2555(class4.field67, class4.field69);
            client.field319.field1981 = 0;
            if(40 == client.field296) {
               client.field319.method2521(18);
            } else {
               client.field319.method2521(16);
            }

            client.field319.method2522(0);
            var1 = client.field319.field1981;
            client.field319.method2524(100);
            client.field319.method2530(client.field318.field1980, 0, client.field318.field1981);
            var2 = client.field319.field1981;
            client.field319.method2527(class31.field713);
            client.field319.method2521((client.field426?1:0) << 1 | (client.field527?1:0));
            client.field319.method2522(class129.field2048);
            client.field319.method2522(class136.field2101);
            class121 var3 = client.field319;
            byte[] var4 = new byte[24];

            int var5;
            try {
               class148.field2220.method4188(0L);
               class148.field2220.method4190(var4);

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

            var3.method2530(var4, 0, 24);
            client.field319.method2527(class11.field165);
            client.field319.method2524(class52.field1146);
            class118 var18 = new class118(class125.field2029.method3215());
            class125.field2029.method3214(var18);
            client.field319.method2530(var18.field1980, 0, var18.field1980.length);
            client.field319.method2521(class35.field773);
            client.field319.method2524(class44.field1019.field2661);
            client.field319.method2524(class92.field1579.field2661);
            client.field319.method2524(class50.field1087.field2661);
            client.field319.method2524(class180.field2917.field2661);
            client.field319.method2524(class158.field2583.field2661);
            client.field319.method2524(class12.field185.field2661);
            client.field319.method2524(class142.field2165.field2661);
            client.field319.method2524(class152.field2268.field2661);
            client.field319.method2524(class4.field70.field2661);
            client.field319.method2524(class22.field586.field2661);
            client.field319.method2524(class48.field1071.field2661);
            client.field319.method2524(class118.field1985.field2661);
            client.field319.method2524(class5.field90.field2661);
            client.field319.method2524(class7.field131.field2661);
            client.field319.method2524(class153.field2278.field2661);
            client.field319.method2524(class75.field1364.field2661);
            client.field319.method2689(var11, var2, client.field319.field1981);
            client.field319.method2719(client.field319.field1981 - var1);
            class11.field170.method3042(client.field319.field1980, 0, client.field319.field1981);
            client.field318.method2782(var11);

            for(var5 = 0; var5 < 4; ++var5) {
               var11[var5] += 50;
            }

            client.field320.method2782(var11);
            client.field309 = 6;
         }

         if(client.field309 == 6 && class11.field170.method3024() > 0) {
            var0 = class11.field170.method3023();
            if(21 == var0 && client.field296 == 20) {
               client.field309 = 7;
            } else if(var0 == 2) {
               client.field309 = 9;
            } else if(var0 == 15 && client.field296 == 40) {
               client.field289 = -1;
               client.field309 = 13;
            } else if(var0 == 23 && client.field307 < 1) {
               ++client.field307;
               client.field309 = 0;
            } else {
               if(var0 != 29) {
                  class26.method676(var0);
                  return;
               }

               client.field309 = 11;
            }
         }

         if(7 == client.field309 && class11.field170.method3024() > 0) {
            client.field312 = (class11.field170.method3023() + 3) * 60;
            client.field309 = 8;
         }

         if(client.field309 == 8) {
            client.field310 = 0;
            class9.method143("You have only just left another world.", "Your profile will be transferred in:", client.field312 / 60 + " seconds.");
            if(--client.field312 <= 0) {
               client.field309 = 0;
            }

         } else {
            if(9 == client.field309 && class11.field170.method3024() >= 13) {
               boolean var12 = class11.field170.method3023() == 1;
               class11.field170.method3028(client.field320.field1980, 0, 4);
               client.field320.field1981 = 0;
               boolean var13 = false;
               if(var12) {
                  var1 = client.field320.method2796() << 24;
                  var1 |= client.field320.method2796() << 16;
                  var1 |= client.field320.method2796() << 8;
                  var1 |= client.field320.method2796();
                  var2 = class20.method597(class31.field713);
                  if(class153.field2277.field137.size() >= 10 && !class153.field2277.field137.containsKey(Integer.valueOf(var2))) {
                     Iterator var17 = class153.field2277.field137.entrySet().iterator();
                     var17.next();
                     var17.remove();
                  }

                  class153.field2277.field137.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class125.method2852();
               }

               client.field441 = class11.field170.method3023();
               client.field383 = class11.field170.method3023() == 1;
               client.field523 = class11.field170.method3023();
               client.field523 <<= 8;
               client.field523 += class11.field170.method3023();
               client.field351 = class11.field170.method3023();
               class11.field170.method3028(client.field320.field1980, 0, 1);
               client.field320.field1981 = 0;
               client.field446 = client.field320.method2796();
               class11.field170.method3028(client.field320.field1980, 0, 2);
               client.field320.field1981 = 0;
               client.field289 = client.field320.method2538();
               if(client.field351 == 1) {
                  try {
                     class131.method2879(client.field274, "zap");
                  } catch (Throwable var8) {
                     ;
                  }
               } else {
                  try {
                     class131.method2879(client.field274, "unzap");
                  } catch (Throwable var7) {
                     ;
                  }
               }

               client.field309 = 10;
            }

            if(10 == client.field309) {
               if(class11.field170.method3024() >= client.field289) {
                  client.field320.field1981 = 0;
                  class11.field170.method3028(client.field320.field1980, 0, client.field289);
                  class27.method680();
                  class155.method3205(client.field320);
                  class135.field2084 = -1;
                  class114.method2467(false);
                  client.field446 = -1;
               }

            } else {
               if(11 == client.field309 && class11.field170.method3024() >= 2) {
                  client.field320.field1981 = 0;
                  class11.field170.method3028(client.field320.field1980, 0, 2);
                  client.field320.field1981 = 0;
                  class10.field161 = client.field320.method2538();
                  client.field309 = 12;
               }

               if(client.field309 == 12 && class11.field170.method3024() >= class10.field161) {
                  client.field320.field1981 = 0;
                  class11.field170.method3028(client.field320.field1980, 0, class10.field161);
                  client.field320.field1981 = 0;
                  String var14 = client.field320.method2544();
                  String var16 = client.field320.method2544();
                  String var15 = client.field320.method2544();
                  class9.method143(var14, var16, var15);
                  class31.method714(10);
               }

               if(13 == client.field309) {
                  if(-1 == client.field289) {
                     if(class11.field170.method3024() < 2) {
                        return;
                     }

                     class11.field170.method3028(client.field320.field1980, 0, 2);
                     client.field320.field1981 = 0;
                     client.field289 = client.field320.method2538();
                  }

                  if(class11.field170.method3024() >= client.field289) {
                     class11.field170.method3028(client.field320.field1980, 0, client.field289);
                     client.field320.field1981 = 0;
                     var0 = client.field289;
                     class162.method3271();
                     class155.method3205(client.field320);
                     if(var0 != client.field320.field1981) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++client.field310;
                  if(client.field310 > 2000) {
                     if(client.field307 < 1) {
                        if(class10.field164 == class15.field219) {
                           class15.field219 = class120.field1989;
                        } else {
                           class15.field219 = class10.field164;
                        }

                        ++client.field307;
                        client.field309 = 0;
                     } else {
                        class26.method676(-3);
                     }
                  }
               }
            }
         }
      } catch (IOException var10) {
         if(client.field307 < 1) {
            if(class10.field164 == class15.field219) {
               class15.field219 = class120.field1989;
            } else {
               class15.field219 = class10.field164;
            }

            ++client.field307;
            client.field309 = 0;
         } else {
            class26.method676(-2);
         }
      }
   }

   @ObfuscatedName("ad")
   static final int method774(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && 2 == (class5.field86[1][var3][var4] & 2)) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class5.field79[var5][var3][var4] + class5.field79[var5][var3 + 1][var4] * var6 >> 7;
         int var9 = (128 - var6) * class5.field79[var5][var3][1 + var4] + class5.field79[var5][var3 + 1][1 + var4] * var6 >> 7;
         return var7 * var9 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }
}
