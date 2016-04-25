import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("NPC")
public final class class34 extends class37 {
   @ObfuscatedName("j")
   @Export("composition")
   class39 field761;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "1"
   )
   final void method710(int var1, byte var2) {
      int var3 = super.field848[0];
      int var4 = super.field822[0];
      if(0 == var1) {
         --var3;
         ++var4;
      }

      if(1 == var1) {
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

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(6 == var1) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(-1 != super.field825 && class161.method3153(super.field825).field976 == 1) {
         super.field825 = -1;
      }

      if(super.field820 < 9) {
         ++super.field820;
      }

      for(int var5 = super.field820; var5 > 0; --var5) {
         super.field848[var5] = super.field848[var5 - 1];
         super.field822[var5] = super.field822[var5 - 1];
         super.field850[var5] = super.field850[var5 - 1];
      }

      super.field848[0] = var3;
      super.field822[0] = var4;
      super.field850[0] = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "1"
   )
   final void method711(int var1, int var2, boolean var3) {
      if(-1 != super.field825 && class161.method3153(super.field825).field976 == 1) {
         super.field825 = -1;
      }

      super.field820 = 0;
      super.field852 = 0;
      super.field823 = 0;
      super.field848[0] = var1;
      super.field822[0] = var2;
      super.field816 = super.field795 * 64 + 128 * super.field848[0];
      super.field840 = super.field822[0] * 128 + super.field795 * 64;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "-1145523992"
   )
   protected final class105 vmethod1900() {
      if(this.field761 == null) {
         return null;
      } else {
         class42 var1 = super.field825 != -1 && 0 == super.field849?class161.method3153(super.field825):null;
         class42 var2 = -1 == super.field854 || super.field854 == super.field799 && var1 != null?null:class161.method3153(super.field854);
         class105 var3 = this.field761.method755(var1, super.field826, var2, super.field798);
         if(var3 == null) {
            return null;
         } else {
            var3.method2335();
            super.field794 = var3.field1443;
            if(-1 != super.field856 && -1 != super.field831) {
               class105 var4 = class19.method239(super.field856).method888(super.field831);
               if(null != var4) {
                  var4.method2297(0, -super.field834, 0);
                  class105[] var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
               }
            }

            if(this.field761.field868 == 1) {
               var3.field1809 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1978515490"
   )
   public static void method715() {
      class39.field902.method3707();
      class39.field878.method3707();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Lclass41;",
      garbageValue = "-1289373174"
   )
   public static class41 method719(int var0) {
      class41 var1 = (class41)class41.field958.method3704((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class41.field959.method3217(1, var0);
         var1 = new class41();
         if(var2 != null) {
            var1.method836(new class119(var2), var0);
         }

         var1.method827();
         class41.field958.method3706(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;B)[Lclass80;",
      garbageValue = "-42"
   )
   public static class80[] method722(class167 var0, String var1, String var2) {
      int var3 = var0.method3232(var1);
      int var4 = var0.method3233(var3, var2);
      return class114.method2437(var0, var3, var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-216843888"
   )
   final boolean vmethod742() {
      return null != this.field761;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-89"
   )
   static final void method724() {
      try {
         if(0 == client.field308) {
            if(class99.field1660 != null) {
               class99.field1660.method2964();
               class99.field1660 = null;
            }

            class18.field246 = null;
            client.field329 = false;
            client.field293 = 0;
            client.field308 = 1;
         }

         if(1 == client.field308) {
            if(null == class18.field246) {
               class18.field246 = class142.field2153.method2850(client.field312, class47.field1055);
            }

            if(2 == class18.field246.field2195) {
               throw new IOException();
            }

            if(1 == class18.field246.field2195) {
               class99.field1660 = new class143((Socket)class18.field246.field2194, class142.field2153);
               class18.field246 = null;
               client.field308 = 2;
            }
         }

         if(2 == client.field308) {
            client.field318.field1971 = 0;
            client.field318.method2503(14);
            class99.field1660.method2967(client.field318.field1973, 0, 1);
            client.field320.field1971 = 0;
            client.field308 = 3;
         }

         int var0;
         if(3 == client.field308) {
            if(null != class17.field244) {
               class17.field244.method1176();
            }

            if(null != class14.field203) {
               class14.field203.method1176();
            }

            var0 = class99.field1660.method2968();
            if(class17.field244 != null) {
               class17.field244.method1176();
            }

            if(class14.field203 != null) {
               class14.field203.method1176();
            }

            if(0 != var0) {
               class152.method3122(var0);
               return;
            }

            client.field320.field1971 = 0;
            client.field308 = 5;
         }

         int var1;
         int var2;
         if(5 == client.field308) {
            int[] var11 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            client.field318.field1971 = 0;
            client.field318.method2503(1);
            client.field318.method2503(class31.field727.vmethod3136());
            client.field318.method2488(var11[0]);
            client.field318.method2488(var11[1]);
            client.field318.method2488(var11[2]);
            client.field318.method2488(var11[3]);
            switch(class31.field727.field2589) {
            case 0:
               client.field318.field1971 += 8;
               break;
            case 1:
            case 3:
               client.field318.method2487(class31.field720);
               client.field318.field1971 += 5;
               break;
            case 2:
               client.field318.method2488(((Integer)class4.field75.field142.get(Integer.valueOf(class89.method2082(class31.field698)))).intValue());
               client.field318.field1971 += 4;
            }

            client.field318.method2491(class31.field710);
            client.field318.method2519(class4.field80, class4.field72);
            client.field319.field1971 = 0;
            if(client.field283 == 40) {
               client.field319.method2503(18);
            } else {
               client.field319.method2503(16);
            }

            client.field319.method2486(0);
            var1 = client.field319.field1971;
            client.field319.method2488(113);
            client.field319.method2494(client.field318.field1973, 0, client.field318.field1971);
            var2 = client.field319.field1971;
            client.field319.method2491(class31.field698);
            client.field319.method2503((client.field487?1:0) << 1 | (client.field303?1:0));
            client.field319.method2486(class5.field102);
            client.field319.method2486(class39.field901);
            class122 var3 = client.field319;
            byte[] var4 = new byte[24];

            int var5;
            try {
               class149.field2215.method4132(0L);
               class149.field2215.method4109(var4);

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

            var3.method2494(var4, 0, 24);
            client.field319.method2491(class185.field3005);
            client.field319.method2488(client.field282);
            class119 var19 = new class119(class3.field70.method3142());
            class3.field70.method3143(var19);
            client.field319.method2494(var19.field1973, 0, var19.field1973.length);
            client.field319.method2503(class14.field207);
            client.field319.method2488(class101.field1738.field2674);
            client.field319.method2488(class26.field646.field2674);
            client.field319.method2488(class0.field13.field2674);
            client.field319.method2488(class28.field659.field2674);
            client.field319.method2488(class101.field1741.field2674);
            client.field319.method2488(class158.field2578.field2674);
            client.field319.method2488(class135.field2069.field2674);
            client.field319.method2488(class26.field628.field2674);
            client.field319.method2488(class178.field2917.field2674);
            client.field319.method2488(class22.field582.field2674);
            client.field319.method2488(client.field306.field2674);
            client.field319.method2488(class136.field2080.field2674);
            client.field319.method2488(class104.field1776.field2674);
            client.field319.method2488(class123.field1997.field2674);
            client.field319.method2488(class9.field156.field2674);
            client.field319.method2488(class18.field247.field2674);
            client.field319.method2517(var11, var2, client.field319.field1971);
            client.field319.method2496(client.field319.field1971 - var1);
            class99.field1660.method2967(client.field319.field1973, 0, client.field319.field1971);
            client.field318.method2734(var11);

            for(var5 = 0; var5 < 4; ++var5) {
               var11[var5] += 50;
            }

            client.field320.method2734(var11);
            client.field308 = 6;
         }

         if(6 == client.field308 && class99.field1660.method2972() > 0) {
            var0 = class99.field1660.method2968();
            if(var0 == 21 && 20 == client.field283) {
               client.field308 = 7;
            } else if(2 == var0) {
               client.field308 = 9;
            } else if(var0 == 15 && client.field283 == 40) {
               client.field523 = -1;
               client.field308 = 13;
            } else if(23 == var0 && client.field310 < 1) {
               ++client.field310;
               client.field308 = 0;
            } else {
               if(29 != var0) {
                  class152.method3122(var0);
                  return;
               }

               client.field308 = 11;
            }
         }

         if(client.field308 == 7 && class99.field1660.method2972() > 0) {
            client.field311 = (class99.field1660.method2968() + 3) * 60;
            client.field308 = 8;
         }

         if(8 == client.field308) {
            client.field293 = 0;
            class114.method2436("You have only just left another world.", "Your profile will be transferred in:", client.field311 / 60 + " seconds.");
            if(--client.field311 <= 0) {
               client.field308 = 0;
            }

         } else {
            if(9 == client.field308 && class99.field1660.method2972() >= 13) {
               boolean var12 = class99.field1660.method2968() == 1;
               class99.field1660.method2966(client.field320.field1973, 0, 4);
               client.field320.field1971 = 0;
               boolean var13 = false;
               if(var12) {
                  var1 = client.field320.method2741() << 24;
                  var1 |= client.field320.method2741() << 16;
                  var1 |= client.field320.method2741() << 8;
                  var1 |= client.field320.method2741();
                  var2 = class89.method2082(class31.field698);
                  if(class4.field75.field142.size() >= 10 && !class4.field75.field142.containsKey(Integer.valueOf(var2))) {
                     Iterator var18 = class4.field75.field142.entrySet().iterator();
                     var18.next();
                     var18.remove();
                  }

                  class4.field75.field142.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class45.method946();
               }

               client.field440 = class99.field1660.method2968();
               client.field376 = class99.field1660.method2968() == 1;
               client.field397 = class99.field1660.method2968();
               client.field397 <<= 8;
               client.field397 += class99.field1660.method2968();
               client.field398 = class99.field1660.method2968();
               class99.field1660.method2966(client.field320.field1973, 0, 1);
               client.field320.field1971 = 0;
               client.field322 = client.field320.method2741();
               class99.field1660.method2966(client.field320.field1973, 0, 2);
               client.field320.field1971 = 0;
               client.field523 = client.field320.method2502();
               if(client.field398 == 1) {
                  try {
                     class132.method2815(client.field272, "zap");
                  } catch (Throwable var8) {
                     ;
                  }
               } else {
                  try {
                     class132.method2815(client.field272, "unzap");
                  } catch (Throwable var7) {
                     ;
                  }
               }

               client.field308 = 10;
            }

            if(10 == client.field308) {
               if(class99.field1660.method2972() >= client.field523) {
                  client.field320.field1971 = 0;
                  class99.field1660.method2966(client.field320.field1973, 0, client.field523);
                  class12.method158();
                  class5.method41(client.field320);
                  class156.field2294 = -1;
                  class187.method3698(false);
                  client.field322 = -1;
               }

            } else {
               if(client.field308 == 11 && class99.field1660.method2972() >= 2) {
                  client.field320.field1971 = 0;
                  class99.field1660.method2966(client.field320.field1973, 0, 2);
                  client.field320.field1971 = 0;
                  class33.field756 = client.field320.method2502();
                  client.field308 = 12;
               }

               if(client.field308 == 12 && class99.field1660.method2972() >= class33.field756) {
                  client.field320.field1971 = 0;
                  class99.field1660.method2966(client.field320.field1973, 0, class33.field756);
                  client.field320.field1971 = 0;
                  String var14 = client.field320.method2508();
                  String var16 = client.field320.method2508();
                  String var15 = client.field320.method2508();
                  class114.method2436(var14, var16, var15);
                  class13.method162(10);
               }

               if(13 != client.field308) {
                  ++client.field293;
                  if(client.field293 > 2000) {
                     if(client.field310 < 1) {
                        if(class39.field903 == class47.field1055) {
                           class47.field1055 = class127.field2020;
                        } else {
                           class47.field1055 = class39.field903;
                        }

                        ++client.field310;
                        client.field308 = 0;
                     } else {
                        class152.method3122(-3);
                     }
                  }
               } else {
                  if(-1 == client.field523) {
                     if(class99.field1660.method2972() < 2) {
                        return;
                     }

                     class99.field1660.method2966(client.field320.field1973, 0, 2);
                     client.field320.field1971 = 0;
                     client.field523 = client.field320.method2502();
                  }

                  if(class99.field1660.method2972() >= client.field523) {
                     class99.field1660.method2966(client.field320.field1973, 0, client.field523);
                     client.field320.field1971 = 0;
                     var0 = client.field523;
                     client.field318.field1971 = 0;
                     client.field320.field1971 = 0;
                     client.field322 = -1;
                     client.field325 = 1;
                     client.field326 = -1;
                     client.field281 = -1;
                     client.field523 = 0;
                     client.field323 = 0;
                     client.field404 = 0;
                     client.field415 = 0;
                     client.field453 = false;
                     client.field509 = 0;
                     client.field507 = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        client.field396[var1] = null;
                     }

                     class47.field1053 = null;

                     for(var1 = 0; var1 < client.field517.length; ++var1) {
                        class34 var17 = client.field517[var1];
                        if(var17 != null) {
                           var17.field819 = -1;
                           var17.field836 = false;
                        }
                     }

                     class15.field210 = new class196(32);
                     class13.method162(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        client.field478[var1] = true;
                     }

                     client.field318.method2735(98);
                     class122 var20 = client.field318;
                     var2 = client.field487?2:1;
                     var20.method2503(var2);
                     client.field318.method2486(class5.field102);
                     client.field318.method2486(class39.field901);
                     class5.method41(client.field320);
                     if(client.field320.field1971 != var0) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var10) {
         if(client.field310 < 1) {
            if(class39.field903 == class47.field1055) {
               class47.field1055 = class127.field2020;
            } else {
               class47.field1055 = class39.field903;
            }

            ++client.field310;
            client.field308 = 0;
         } else {
            class152.method3122(-2);
         }
      }
   }
}
