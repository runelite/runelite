import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("e")
@Implements("Player")
public final class class2 extends class39 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -661322467
   )
   int field36;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1470411743
   )
   int field37;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 116647957
   )
   int field38 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1616991477
   )
   int field39;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1572454455
   )
   int field40;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1244522263
   )
   @Export("combatLevel")
   int field41;
   @ObfuscatedName("m")
   @Export("name")
   String field43;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1996458139
   )
   @Export("totalLevel")
   int field44;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2006986487
   )
   int field45;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1778389895
   )
   int field46;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 793688191
   )
   int field47;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -180713555
   )
   int field48;
   @ObfuscatedName("p")
   @Export("model")
   class108 field49;
   @ObfuscatedName("w")
   @Export("composition")
   class182 field50;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -829535551
   )
   int field51;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -864913049
   )
   int field52;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -258121135
   )
   int field53;
   @ObfuscatedName("t")
   boolean field54;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1271929765
   )
   @Export("team")
   int field55;
   @ObfuscatedName("z")
   boolean field56;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1834657529
   )
   int field57;
   @ObfuscatedName("l")
   @Export("actions")
   String[] field58 = new String[3];
   @ObfuscatedName("a")
   boolean field59;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1123081983
   )
   int field60;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1487389091
   )
   int field61;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1429339585
   )
   int field62 = -1;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "-1468244473"
   )
   final void method12(class122 var1) {
      var1.field2045 = 0;
      int var2 = var1.method2556();
      this.field38 = var1.method2573();
      this.field62 = var1.method2573();
      int var3 = -1;
      this.field55 = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.method2556();
         if(var6 == 0) {
            var4[var5] = 0;
         } else {
            var7 = var1.method2556();
            var4[var5] = var7 + (var6 << 8);
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.method2706();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = class4.method42(var4[var5] - 512).field1182;
               if(var8 != 0) {
                  this.field55 = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2556();
         if(var7 < 0 || var7 >= class182.field2969[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.field847 = var1.method2706();
      if(super.field847 == '\uffff') {
         super.field847 = -1;
      }

      super.field876 = var1.method2706();
      if(super.field876 == '\uffff') {
         super.field876 = -1;
      }

      super.field837 = super.field876;
      super.field839 = var1.method2706();
      if(super.field839 == '\uffff') {
         super.field839 = -1;
      }

      super.field878 = var1.method2706();
      if(super.field878 == '\uffff') {
         super.field878 = -1;
      }

      super.field840 = var1.method2706();
      if(super.field840 == '\uffff') {
         super.field840 = -1;
      }

      super.field841 = var1.method2706();
      if(super.field841 == '\uffff') {
         super.field841 = -1;
      }

      super.field842 = var1.method2706();
      if(super.field842 == '\uffff') {
         super.field842 = -1;
      }

      this.field43 = var1.method2580();
      if(this == class114.field2010) {
         class46.field1060 = this.field43;
      }

      this.field41 = var1.method2556();
      this.field39 = var1.method2706();
      this.field56 = var1.method2556() == 1;
      if(client.field275 == 0 && client.field409 >= 2) {
         this.field56 = false;
      }

      if(this.field50 == null) {
         this.field50 = new class182();
      }

      this.field50.method3536(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-15"
   )
   int method14() {
      return null != this.field50 && this.field50.field2966 != -1?class1.method7(this.field50.field2966).field906:1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "66"
   )
   final void method16(int var1, int var2, byte var3) {
      if(super.field884 != -1 && class28.method646(super.field884).field1020 == 1) {
         super.field884 = -1;
      }

      super.field867 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.field885[0] >= 0 && super.field885[0] < 104 && super.field886[0] >= 0 && super.field886[0] < 104) {
            if(var3 == 2) {
               class18.method193(this, var1, var2, (byte)2);
            }

            this.method33(var1, var2, var3);
         } else {
            this.method17(var1, var2);
         }
      } else {
         this.method17(var1, var2);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1913320965"
   )
   void method17(int var1, int var2) {
      super.field875 = 0;
      super.field851 = 0;
      super.field888 = 0;
      super.field885[0] = var1;
      super.field886[0] = var2;
      int var3 = this.method14();
      super.field864 = 64 * var3 + super.field885[0] * 128;
      super.field831 = var3 * 64 + super.field886[0] * 128;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1508410134"
   )
   static final void method18() {
      try {
         if(client.field304 == 0) {
            if(null != class38.field829) {
               class38.field829.method3050();
               class38.field829 = null;
            }

            class122.field2050 = null;
            client.field324 = false;
            client.field305 = 0;
            client.field304 = 1;
         }

         if(client.field304 == 1) {
            if(null == class122.field2050) {
               class122.field2050 = class40.field900.method2936(class124.field2060, class42.field991);
            }

            if(class122.field2050.field2278 == 2) {
               throw new IOException();
            }

            if(class122.field2050.field2278 == 1) {
               class38.field829 = new class146((Socket)class122.field2050.field2282, class40.field900);
               class122.field2050 = null;
               client.field304 = 2;
            }
         }

         if(client.field304 == 2) {
            client.field313.field2045 = 0;
            client.field313.method2557(14);
            class38.field829.method3045(client.field313.field2047, 0, 1);
            client.field315.field2045 = 0;
            client.field304 = 3;
         }

         int var0;
         if(client.field304 == 3) {
            if(null != class36.field799) {
               class36.field799.method1261();
            }

            if(null != class158.field2354) {
               class158.field2354.method1261();
            }

            var0 = class38.field829.method3042();
            if(null != class36.field799) {
               class36.field799.method1261();
            }

            if(class158.field2354 != null) {
               class158.field2354.method1261();
            }

            if(var0 != 0) {
               class30.method664(var0);
               return;
            }

            client.field315.field2045 = 0;
            client.field304 = 5;
         }

         int var1;
         int var2;
         if(client.field304 == 5) {
            int[] var5 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            client.field313.field2045 = 0;
            client.field313.method2557(1);
            client.field313.method2557(class33.field753.vmethod3218());
            client.field313.method2560(var5[0]);
            client.field313.method2560(var5[1]);
            client.field313.method2560(var5[2]);
            client.field313.method2560(var5[3]);
            switch(class33.field753.field2660) {
            case 0:
               client.field313.method2560(((Integer)class12.field162.field126.get(Integer.valueOf(class130.method2876(class33.field758)))).intValue());
               client.field313.field2045 += 4;
               break;
            case 1:
            case 3:
               client.field313.method2559(class17.field232);
               client.field313.field2045 += 5;
               break;
            case 2:
               client.field313.field2045 += 8;
            }

            client.field313.method2563(class33.field735);
            client.field313.method2673(class4.field76, class4.field75);
            client.field314.field2045 = 0;
            if(client.field280 == 40) {
               client.field314.method2557(18);
            } else {
               client.field314.method2557(16);
            }

            client.field314.method2558(0);
            var1 = client.field314.field2045;
            client.field314.method2560(119);
            client.field314.method2742(client.field313.field2047, 0, client.field313.field2045);
            var2 = client.field314.field2045;
            client.field314.method2563(class33.field758);
            client.field314.method2557((client.field360?1:0) << 1 | (client.field277?1:0));
            client.field314.method2558(class12.field174);
            client.field314.method2558(class19.field264);
            class129.method2869(client.field314);
            client.field314.method2563(class106.field1839);
            client.field314.method2560(class35.field796);
            class122 var3 = new class122(class21.field577.method3225());
            class21.field577.method3226(var3);
            client.field314.method2742(var3.field2047, 0, var3.field2047.length);
            client.field314.method2557(class145.field2237);
            client.field314.method2560(class22.field584.field2736);
            client.field314.method2560(class217.field3199.field2736);
            client.field314.method2560(class56.field1231.field2736);
            client.field314.method2560(class50.field1115.field2736);
            client.field314.method2560(class127.field2083.field2736);
            client.field314.method2560(class129.field2097.field2736);
            client.field314.method2560(class38.field814.field2736);
            client.field314.method2560(class184.field2985.field2736);
            client.field314.method2560(class42.field993.field2736);
            client.field314.method2560(class157.field2345.field2736);
            client.field314.method2560(class40.field895.field2736);
            client.field314.method2560(class139.field2155.field2736);
            client.field314.method2560(class182.field2967.field2736);
            client.field314.method2560(class87.field1531.field2736);
            client.field314.method2560(class40.field899.field2736);
            client.field314.method2560(class20.field559.field2736);
            client.field314.method2590(var5, var2, client.field314.field2045);
            client.field314.method2568(client.field314.field2045 - var1);
            class38.field829.method3045(client.field314.field2047, 0, client.field314.field2045);
            client.field313.method2796(var5);

            for(int var4 = 0; var4 < 4; ++var4) {
               var5[var4] += 50;
            }

            client.field315.method2796(var5);
            client.field304 = 6;
         }

         if(client.field304 == 6 && class38.field829.method3044() > 0) {
            var0 = class38.field829.method3042();
            if(var0 == 21 && client.field280 == 20) {
               client.field304 = 7;
            } else if(var0 == 2) {
               client.field304 = 9;
            } else if(var0 == 15 && client.field280 == 40) {
               client.field283 = -1;
               client.field304 = 13;
            } else if(var0 == 23 && client.field420 < 1) {
               ++client.field420;
               client.field304 = 0;
            } else {
               if(var0 != 29) {
                  class30.method664(var0);
                  return;
               }

               client.field304 = 11;
            }
         }

         if(client.field304 == 7 && class38.field829.method3044() > 0) {
            client.field307 = (class38.field829.method3042() + 3) * 60;
            client.field304 = 8;
         }

         if(client.field304 == 8) {
            client.field305 = 0;
            class126.method2836("You have only just left another world.", "Your profile will be transferred in:", client.field307 / 60 + " seconds.");
            if(--client.field307 <= 0) {
               client.field304 = 0;
            }

         } else {
            if(client.field304 == 9 && class38.field829.method3044() >= 13) {
               boolean var10 = class38.field829.method3042() == 1;
               class38.field829.method3061(client.field315.field2047, 0, 4);
               client.field315.field2045 = 0;
               boolean var11 = false;
               if(var10) {
                  var1 = client.field315.method2805() << 24;
                  var1 |= client.field315.method2805() << 16;
                  var1 |= client.field315.method2805() << 8;
                  var1 |= client.field315.method2805();
                  var2 = class130.method2876(class33.field758);
                  if(class12.field162.field126.size() >= 10 && !class12.field162.field126.containsKey(Integer.valueOf(var2))) {
                     Iterator var12 = class12.field162.field126.entrySet().iterator();
                     var12.next();
                     var12.remove();
                  }

                  class12.field162.field126.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class32.method679();
               }

               client.field409 = class38.field829.method3042();
               client.field439 = class38.field829.method3042() == 1;
               client.field551 = class38.field829.method3042();
               client.field551 <<= 8;
               client.field551 += class38.field829.method3042();
               client.field549 = class38.field829.method3042();
               class38.field829.method3061(client.field315.field2047, 0, 1);
               client.field315.field2045 = 0;
               client.field317 = client.field315.method2805();
               class38.field829.method3061(client.field315.field2047, 0, 2);
               client.field315.field2045 = 0;
               client.field283 = client.field315.method2706();

               try {
                  client var6 = client.field270;
                  JSObject.getWindow(var6).call("zap", (Object[])null);
               } catch (Throwable var8) {
                  ;
               }

               client.field304 = 10;
            }

            if(client.field304 == 10) {
               if(class38.field829.method3044() >= client.field283) {
                  client.field315.field2045 = 0;
                  class38.field829.method3061(client.field315.field2047, 0, client.field283);
                  class109.method2445();
                  class112.method2486(client.field315);
                  class9.field149 = -1;
                  class48.method1013(false);
                  client.field317 = -1;
               }

            } else {
               if(client.field304 == 11 && class38.field829.method3044() >= 2) {
                  client.field315.field2045 = 0;
                  class38.field829.method3061(client.field315.field2047, 0, 2);
                  client.field315.field2045 = 0;
                  client.field553 = client.field315.method2706();
                  client.field304 = 12;
               }

               if(client.field304 == 12 && class38.field829.method3044() >= client.field553) {
                  client.field315.field2045 = 0;
                  class38.field829.method3061(client.field315.field2047, 0, client.field553);
                  client.field315.field2045 = 0;
                  String var13 = client.field315.method2580();
                  String var7 = client.field315.method2580();
                  String var14 = client.field315.method2580();
                  class126.method2836(var13, var7, var14);
                  class171.method3414(10);
               }

               if(client.field304 == 13) {
                  if(client.field283 == -1) {
                     if(class38.field829.method3044() < 2) {
                        return;
                     }

                     class38.field829.method3061(client.field315.field2047, 0, 2);
                     client.field315.field2045 = 0;
                     client.field283 = client.field315.method2706();
                  }

                  if(class38.field829.method3044() >= client.field283) {
                     class38.field829.method3061(client.field315.field2047, 0, client.field283);
                     client.field315.field2045 = 0;
                     var0 = client.field283;
                     class48.method1015();
                     class112.method2486(client.field315);
                     if(var0 != client.field315.field2045) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++client.field305;
                  if(client.field305 > 2000) {
                     if(client.field420 < 1) {
                        if(class116.field2019 == class42.field991) {
                           class42.field991 = class0.field6;
                        } else {
                           class42.field991 = class116.field2019;
                        }

                        ++client.field420;
                        client.field304 = 0;
                     } else {
                        class30.method664(-3);
                     }
                  }
               }
            }
         }
      } catch (IOException var9) {
         if(client.field420 < 1) {
            if(class42.field991 == class116.field2019) {
               class42.field991 = class0.field6;
            } else {
               class42.field991 = class116.field2019;
            }

            ++client.field420;
            client.field304 = 0;
         } else {
            class30.method664(-2);
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-58"
   )
   final boolean vmethod786() {
      return this.field50 != null;
   }

   class2() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.field58[var1] = "";
      }

      this.field41 = 0;
      this.field39 = 0;
      this.field44 = 0;
      this.field36 = 0;
      this.field54 = false;
      this.field55 = 0;
      this.field56 = false;
      this.field59 = false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lclass108;",
      garbageValue = "-990594109"
   )
   protected final class108 vmethod1992() {
      if(this.field50 == null) {
         return null;
      } else {
         class44 var1 = super.field884 != -1 && super.field865 == 0?class28.method646(super.field884):null;
         class44 var2 = super.field859 == -1 || this.field54 || super.field859 == super.field847 && var1 != null?null:class28.method646(super.field859);
         class108 var3 = this.field50.method3542(var1, super.field863, var2, super.field860);
         if(var3 == null) {
            return null;
         } else {
            var3.method2385();
            super.field880 = var3.field1536;
            class108 var4;
            class108[] var5;
            if(!this.field54 && super.field834 != -1 && super.field868 != -1) {
               var4 = class175.method3442(super.field834).method942(super.field868);
               if(null != var4) {
                  var4.method2372(0, -super.field871, 0);
                  var5 = new class108[]{var3, var4};
                  var3 = new class108(var5, 2);
               }
            }

            if(!this.field54 && null != this.field49) {
               if(client.field282 >= this.field36) {
                  this.field49 = null;
               }

               if(client.field282 >= this.field44 && client.field282 < this.field36) {
                  var4 = this.field49;
                  var4.method2372(this.field40 - super.field864, this.field47 - this.field45, this.field48 - super.field831);
                  if(super.field881 == 512) {
                     var4.method2376();
                     var4.method2376();
                     var4.method2376();
                  } else if(super.field881 == 1024) {
                     var4.method2376();
                     var4.method2376();
                  } else if(super.field881 == 1536) {
                     var4.method2376();
                  }

                  var5 = new class108[]{var3, var4};
                  var3 = new class108(var5, 2);
                  if(super.field881 == 512) {
                     var4.method2376();
                  } else if(super.field881 == 1024) {
                     var4.method2376();
                     var4.method2376();
                  } else if(super.field881 == 1536) {
                     var4.method2376();
                     var4.method2376();
                     var4.method2376();
                  }

                  var4.method2372(super.field864 - this.field40, this.field45 - this.field47, super.field831 - this.field48);
               }
            }

            var3.field1924 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2128487510"
   )
   static void method32(int var0) {
      for(class204 var1 = (class204)client.field472.method3847(); var1 != null; var1 = (class204)client.field472.method3852()) {
         if((long)var0 == (var1.field3167 >> 48 & 65535L)) {
            var1.method3990();
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIBS)V",
      garbageValue = "22886"
   )
   final void method33(int var1, int var2, byte var3) {
      if(super.field875 < 9) {
         ++super.field875;
      }

      for(int var4 = super.field875; var4 > 0; --var4) {
         super.field885[var4] = super.field885[var4 - 1];
         super.field886[var4] = super.field886[var4 - 1];
         super.field887[var4] = super.field887[var4 - 1];
      }

      super.field885[0] = var1;
      super.field886[0] = var2;
      super.field887[0] = var3;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "10918"
   )
   static final void method34(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         class12.field162.field127 = !class12.field162.field127;
         class32.method679();
         if(class12.field162.field127) {
            class59.method1304(99, "", "Roofs are now all hidden");
         } else {
            class59.method1304(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         client.field338 = !client.field338;
      }

      if(client.field409 >= 2) {
         if(var0.equalsIgnoreCase("fpson")) {
            client.field338 = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            client.field338 = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            if(client.field323 > 0) {
               class15.method178();
            } else {
               class171.method3414(40);
               class177.field2937 = class38.field829;
               class38.field829 = null;
            }
         }

         if(var0.equalsIgnoreCase("errortest") && client.field275 == 2) {
            throw new RuntimeException();
         }
      }

      client.field313.method2797(231);
      client.field313.method2557(var0.length() + 1);
      client.field313.method2563(var0);
   }
}
