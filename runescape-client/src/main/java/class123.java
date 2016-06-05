import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedHashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
public final class class123 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 969940805
   )
   int field2029;
   @ObfuscatedName("z")
   int[] field2033 = new int[256];
   @ObfuscatedName("r")
   int[] field2034 = new int[256];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 357973769
   )
   int field2035;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -802235891
   )
   int field2036;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 407186623
   )
   int field2037;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 614566343
   )
   static int field2038;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-811725619"
   )
   static final void method2734() {
      try {
         if(client.field316 == 0) {
            if(null != class51.field1112) {
               class51.field1112.method2960();
               class51.field1112 = null;
            }

            class166.field2699 = null;
            client.field336 = false;
            client.field317 = 0;
            client.field316 = 1;
         }

         if(client.field316 == 1) {
            if(null == class166.field2699) {
               class166.field2699 = class77.field1400.method2867(class161.field2670, class35.field782);
            }

            if(class166.field2699.field2249 == 2) {
               throw new IOException();
            }

            if(class166.field2699.field2249 == 1) {
               class51.field1112 = new class143((Socket)class166.field2699.field2246, class77.field1400);
               class166.field2699 = null;
               client.field316 = 2;
            }
         }

         if(client.field316 == 2) {
            client.field325.field2000 = 0;
            client.field325.method2453(14);
            class51.field1112.method2964(client.field325.field2001, 0, 1);
            client.field327.field2000 = 0;
            client.field316 = 3;
         }

         int var0;
         if(client.field316 == 3) {
            if(class17.field247 != null) {
               class17.field247.method1136();
            }

            if(client.field331 != null) {
               client.field331.method1136();
            }

            var0 = class51.field1112.method2961();
            if(class17.field247 != null) {
               class17.field247.method1136();
            }

            if(client.field331 != null) {
               client.field331.method1136();
            }

            if(var0 != 0) {
               class101.method2233(var0);
               return;
            }

            client.field327.field2000 = 0;
            client.field316 = 5;
         }

         int var5;
         int var6;
         int var9;
         int var12;
         if(client.field316 == 5) {
            int[] var8 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            client.field325.field2000 = 0;
            client.field325.method2453(1);
            client.field325.method2453(class31.field724.vmethod3145());
            client.field325.method2456(var8[0]);
            client.field325.method2456(var8[1]);
            client.field325.method2456(var8[2]);
            client.field325.method2456(var8[3]);
            switch(class31.field724.field2629) {
            case 0:
               class122 var1 = client.field325;
               LinkedHashMap var2 = class116.field1988.field141;
               String var4 = class31.field722;
               var5 = var4.length();
               var6 = 0;

               for(int var7 = 0; var7 < var5; ++var7) {
                  var6 = (var6 << 5) - var6 + var4.charAt(var7);
               }

               var1.method2456(((Integer)var2.get(Integer.valueOf(var6))).intValue());
               client.field325.field2000 += 4;
               break;
            case 1:
            case 2:
               client.field325.method2455(class1.field33);
               client.field325.field2000 += 5;
               break;
            case 3:
               client.field325.field2000 += 8;
            }

            client.field325.method2586(class31.field723);
            client.field325.method2640(class4.field77, class4.field70);
            client.field326.field2000 = 0;
            if(client.field462 == 40) {
               client.field326.method2453(18);
            } else {
               client.field326.method2453(16);
            }

            client.field326.method2454(0);
            var9 = client.field326.field2000;
            client.field326.method2456(115);
            client.field326.method2462(client.field325.field2001, 0, client.field325.field2000);
            int var10 = client.field326.field2000;
            client.field326.method2586(class31.field722);
            client.field326.method2453((client.field496?1:0) << 1 | (client.field287?1:0));
            client.field326.method2454(class10.field162);
            client.field326.method2454(class41.field966);
            class44.method920(client.field326);
            client.field326.method2586(client.field289);
            client.field326.method2456(class7.field131);
            class119 var11 = new class119(class2.field62.method3150());
            class2.field62.method3153(var11);
            client.field326.method2462(var11.field2001, 0, var11.field2001.length);
            client.field326.method2453(client.field290);
            client.field326.method2456(class15.field223.field2713);
            client.field326.method2456(class33.field765.field2713);
            client.field326.method2456(class144.field2241.field2713);
            client.field326.method2456(class21.field576.field2713);
            client.field326.method2456(class42.field1000.field2713);
            client.field326.method2456(class19.field272.field2713);
            client.field326.method2456(class103.field1783.field2713);
            client.field326.method2456(class122.field2028.field2713);
            client.field326.method2456(class13.field203.field2713);
            client.field326.method2456(class186.field3024.field2713);
            client.field326.method2456(class138.field2161.field2713);
            client.field326.method2456(class106.field1878.field2713);
            client.field326.method2456(class129.field2067.field2713);
            client.field326.method2456(class74.field1371.field2713);
            client.field326.method2456(class3.field67.field2713);
            client.field326.method2456(class4.field76.field2713);
            client.field326.method2486(var8, var10, client.field326.field2000);
            client.field326.method2471(client.field326.field2000 - var9);
            class51.field1112.method2964(client.field326.field2001, 0, client.field326.field2000);
            client.field325.method2709(var8);

            for(var12 = 0; var12 < 4; ++var12) {
               var8[var12] += 50;
            }

            client.field327.method2709(var8);
            client.field316 = 6;
         }

         if(client.field316 == 6 && class51.field1112.method2980() > 0) {
            var0 = class51.field1112.method2961();
            if(var0 == 21 && client.field462 == 20) {
               client.field316 = 7;
            } else if(var0 == 2) {
               client.field316 = 9;
            } else if(var0 == 15 && client.field462 == 40) {
               client.field328 = -1;
               client.field316 = 13;
            } else if(var0 == 23 && client.field318 < 1) {
               ++client.field318;
               client.field316 = 0;
            } else {
               if(var0 != 29) {
                  class101.method2233(var0);
                  return;
               }

               client.field316 = 11;
            }
         }

         if(client.field316 == 7 && class51.field1112.method2980() > 0) {
            client.field360 = (class51.field1112.method2961() + 3) * 60;
            client.field316 = 8;
         }

         if(client.field316 == 8) {
            client.field317 = 0;
            class50.method987("You have only just left another world.", "Your profile will be transferred in:", client.field360 / 60 + " seconds.");
            if(--client.field360 <= 0) {
               client.field316 = 0;
            }

         } else {
            if(client.field316 == 9 && class51.field1112.method2980() >= 13) {
               boolean var17 = class51.field1112.method2961() == 1;
               class51.field1112.method2963(client.field327.field2001, 0, 4);
               client.field327.field2000 = 0;
               boolean var22 = false;
               if(var17) {
                  var9 = client.field327.method2728() << 24;
                  var9 |= client.field327.method2728() << 16;
                  var9 |= client.field327.method2728() << 8;
                  var9 |= client.field327.method2728();
                  String var23 = class31.field722;
                  var12 = var23.length();
                  var5 = 0;

                  for(var6 = 0; var6 < var12; ++var6) {
                     var5 = (var5 << 5) - var5 + var23.charAt(var6);
                  }

                  if(class116.field1988.field141.size() >= 10 && !class116.field1988.field141.containsKey(Integer.valueOf(var5))) {
                     Iterator var13 = class116.field1988.field141.entrySet().iterator();
                     var13.next();
                     var13.remove();
                  }

                  class116.field1988.field141.put(Integer.valueOf(var5), Integer.valueOf(var9));
                  class25.method590();
               }

               client.field449 = class51.field1112.method2961();
               client.field539 = class51.field1112.method2961() == 1;
               client.field460 = class51.field1112.method2961();
               client.field460 <<= 8;
               client.field460 += class51.field1112.method2961();
               client.field451 = class51.field1112.method2961();
               class51.field1112.method2963(client.field327.field2001, 0, 1);
               client.field327.field2000 = 0;
               client.field329 = client.field327.method2728();
               class51.field1112.method2963(client.field327.field2001, 0, 2);
               client.field327.field2000 = 0;
               client.field328 = client.field327.method2470();
               if(client.field451 == 1) {
                  try {
                     class132.method2814(client.field280, "zap");
                  } catch (Throwable var15) {
                     ;
                  }
               } else {
                  try {
                     class132.method2814(client.field280, "unzap");
                  } catch (Throwable var14) {
                     ;
                  }
               }

               client.field316 = 10;
            }

            if(client.field316 == 10) {
               if(class51.field1112.method2980() >= client.field328) {
                  client.field327.field2000 = 0;
                  class51.field1112.method2963(client.field327.field2001, 0, client.field328);
                  class34.method717();
                  class164.method3188(client.field327);
                  class40.field964 = -1;
                  class215.method3894(false);
                  client.field329 = -1;
               }

            } else {
               if(client.field316 == 11 && class51.field1112.method2980() >= 2) {
                  client.field327.field2000 = 0;
                  class51.field1112.method2963(client.field327.field2001, 0, 2);
                  client.field327.field2000 = 0;
                  class87.field1542 = client.field327.method2470();
                  client.field316 = 12;
               }

               if(client.field316 == 12 && class51.field1112.method2980() >= class87.field1542) {
                  client.field327.field2000 = 0;
                  class51.field1112.method2963(client.field327.field2001, 0, class87.field1542);
                  client.field327.field2000 = 0;
                  String var21 = client.field327.method2476();
                  String var18 = client.field327.method2476();
                  String var19 = client.field327.method2476();
                  class50.method987(var21, var18, var19);
                  class2.method14(10);
               }

               if(client.field316 != 13) {
                  ++client.field317;
                  if(client.field317 > 2000) {
                     if(client.field318 < 1) {
                        if(class110.field1939 == class35.field782) {
                           class35.field782 = class107.field1886;
                        } else {
                           class35.field782 = class110.field1939;
                        }

                        ++client.field318;
                        client.field316 = 0;
                     } else {
                        class101.method2233(-3);
                     }
                  }
               } else {
                  if(client.field328 == -1) {
                     if(class51.field1112.method2980() < 2) {
                        return;
                     }

                     class51.field1112.method2963(client.field327.field2001, 0, 2);
                     client.field327.field2000 = 0;
                     client.field328 = client.field327.method2470();
                  }

                  if(class51.field1112.method2980() >= client.field328) {
                     class51.field1112.method2963(client.field327.field2001, 0, client.field328);
                     client.field327.field2000 = 0;
                     var0 = client.field328;
                     client.field325.field2000 = 0;
                     client.field327.field2000 = 0;
                     client.field329 = -1;
                     client.field390 = -1;
                     client.field333 = -1;
                     client.field334 = -1;
                     client.field328 = 0;
                     client.field481 = 0;
                     client.field300 = 0;
                     client.field294 = 0;
                     client.field423 = false;
                     client.field549 = 0;
                     client.field545 = 0;

                     for(var9 = 0; var9 < 2048; ++var9) {
                        client.field405[var9] = null;
                     }

                     class152.field2301 = null;

                     for(var9 = 0; var9 < client.field320.length; ++var9) {
                        class34 var20 = client.field320[var9];
                        if(var20 != null) {
                           var20.field828 = -1;
                           var20.field829 = false;
                        }
                     }

                     class15.field222 = new class196(32);
                     class2.method14(30);

                     for(var9 = 0; var9 < 100; ++var9) {
                        client.field396[var9] = true;
                     }

                     class189.method3707();
                     class164.method3188(client.field327);
                     if(var0 != client.field327.field2000) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var16) {
         if(client.field318 < 1) {
            if(class110.field1939 == class35.field782) {
               class35.field782 = class107.field1886;
            } else {
               class35.field782 = class110.field1939;
            }

            ++client.field318;
            client.field316 = 0;
         } else {
            class101.method2233(-2);
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "487045420"
   )
   final int method2735() {
      if(--this.field2029 + 1 == 0) {
         this.method2736();
         this.field2029 = 255;
      }

      return this.field2033[this.field2029];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1038826373"
   )
   final void method2736() {
      this.field2036 += ++this.field2037;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2034[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2035 ^= this.field2035 << 13;
            } else {
               this.field2035 ^= this.field2035 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2035 ^= this.field2035 << 2;
         } else {
            this.field2035 ^= this.field2035 >>> 16;
         }

         this.field2035 += this.field2034[128 + var1 & 255];
         int var3;
         this.field2034[var1] = var3 = this.field2036 + this.field2034[(var2 & 1020) >> 2] + this.field2035;
         this.field2033[var1] = this.field2036 = this.field2034[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1250486936"
   )
   final void method2738() {
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;
      int var2 = -1640531527;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2033[var1];
         var3 += this.field2033[1 + var1];
         var4 += this.field2033[2 + var1];
         var5 += this.field2033[var1 + 3];
         var6 += this.field2033[var1 + 4];
         var7 += this.field2033[var1 + 5];
         var8 += this.field2033[var1 + 6];
         var9 += this.field2033[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2034[var1] = var2;
         this.field2034[1 + var1] = var3;
         this.field2034[2 + var1] = var4;
         this.field2034[3 + var1] = var5;
         this.field2034[var1 + 4] = var6;
         this.field2034[var1 + 5] = var7;
         this.field2034[6 + var1] = var8;
         this.field2034[7 + var1] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2034[var1];
         var3 += this.field2034[1 + var1];
         var4 += this.field2034[2 + var1];
         var5 += this.field2034[var1 + 3];
         var6 += this.field2034[4 + var1];
         var7 += this.field2034[var1 + 5];
         var8 += this.field2034[6 + var1];
         var9 += this.field2034[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2034[var1] = var2;
         this.field2034[var1 + 1] = var3;
         this.field2034[var1 + 2] = var4;
         this.field2034[3 + var1] = var5;
         this.field2034[var1 + 4] = var6;
         this.field2034[var1 + 5] = var7;
         this.field2034[var1 + 6] = var8;
         this.field2034[7 + var1] = var9;
      }

      this.method2736();
      this.field2029 = 256;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Lclass51;",
      garbageValue = "-1899920045"
   )
   @Export("getItemDefinition")
   public static class51 method2743(int var0) {
      class51 var1 = (class51)class51.field1114.method3716((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class51.field1163.method3221(10, var0);
         var1 = new class51();
         var1.field1118 = var0;
         if(var2 != null) {
            var1.method1025(new class119(var2));
         }

         var1.method992();
         if(var1.field1151 != -1) {
            var1.method995(method2743(var1.field1151), method2743(var1.field1150));
         }

         if(var1.field1128 != -1) {
            var1.method1007(method2743(var1.field1128), method2743(var1.field1159));
         }

         if(var1.field1162 != -1) {
            var1.method1044(method2743(var1.field1162), method2743(var1.field1161));
         }

         if(!class51.field1160 && var1.field1134) {
            var1.field1120 = "Members object";
            var1.field1158 = false;
            var1.field1155 = null;
            var1.field1121 = null;
            var1.field1157 = 0;
         }

         class51.field1114.method3724(var1, (long)var0);
         return var1;
      }
   }

   class123(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2033[var2] = var1[var2];
      }

      this.method2738();
   }
}
