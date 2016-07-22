import java.io.DataInputStream;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class18 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1902517
   )
   int field240;
   @ObfuscatedName("w")
   class149 field241;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1580325221
   )
   int field242;
   @ObfuscatedName("o")
   byte[] field243 = new byte[4];
   @ObfuscatedName("e")
   DataInputStream field244;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1664984447
   )
   int field245;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 3021584421104238433L
   )
   long field246;
   @ObfuscatedName("l")
   byte[] field247;
   @ObfuscatedName("nu")
   static class58 field254;

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIIB)V",
      garbageValue = "-54"
   )
   @Export("generateMenuActionsForPlayer")
   static final void method188(class2 var0, int var1, int var2, int var3) {
      if(var0 != class114.field2010) {
         if(client.field412 < 400) {
            String var4;
            if(var0.field39 == 0) {
               var4 = var0.field58[0] + var0.field43 + var0.field58[1] + class53.method1123(var0.field41, class114.field2010.field41) + " " + " (" + "level-" + var0.field41 + ")" + var0.field58[2];
            } else {
               var4 = var0.field58[0] + var0.field43 + var0.field58[1] + " " + " (" + "skill-" + var0.field39 + ")" + var0.field58[2];
            }

            int var5;
            if(client.field531 == 1) {
               class98.method2276("Use", client.field424 + " " + "->" + " " + class51.method1096(16777215) + var4, 14, var1, var2, var3);
            } else if(client.field444) {
               if((class116.field2016 & 8) == 8) {
                  class98.method2276(client.field428, client.field438 + " " + "->" + " " + class51.method1096(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(client.field399[var5] != null) {
                     short var6 = 0;
                     if(client.field399[var5].equalsIgnoreCase("Attack")) {
                        if(class21.field581 == client.field298) {
                           continue;
                        }

                        if(client.field298 == class21.field568 || class21.field570 == client.field298 && var0.field41 > class114.field2010.field41) {
                           var6 = 2000;
                        }

                        if(class114.field2010.field55 != 0 && var0.field55 != 0) {
                           if(class114.field2010.field55 == var0.field55) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(client.field400[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = client.field398[var5] + var6;
                     class98.method2276(client.field399[var5], class51.method1096(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < client.field412; ++var5) {
               if(client.field415[var5] == 23) {
                  client.field328[var5] = class51.method1096(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "2090253667"
   )
   byte[] method189() throws IOException {
      if(class193.method3805() > this.field246) {
         throw new IOException();
      } else {
         if(this.field245 == 0) {
            if(this.field241.field2278 == 2) {
               throw new IOException();
            }

            if(this.field241.field2278 == 1) {
               this.field244 = (DataInputStream)this.field241.field2282;
               this.field245 = 1;
            }
         }

         int var1;
         if(this.field245 == 1) {
            var1 = this.field244.available();
            if(var1 > 0) {
               if(var1 + this.field240 > 4) {
                  var1 = 4 - this.field240;
               }

               this.field240 += this.field244.read(this.field243, this.field240, var1);
               if(this.field240 == 4) {
                  int var2 = (new class122(this.field243)).method2577();
                  this.field247 = new byte[var2];
                  this.field245 = 2;
               }
            }
         }

         if(this.field245 == 2) {
            var1 = this.field244.available();
            if(var1 > 0) {
               if(var1 + this.field242 > this.field247.length) {
                  var1 = this.field247.length - this.field242;
               }

               this.field242 += this.field244.read(this.field247, this.field242, var1);
               if(this.field247.length == this.field242) {
                  return this.field247;
               }
            }
         }

         return null;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-54"
   )
   static void method191() {
      class79.field1459 = null;
      class79.field1460 = null;
      class79.field1463 = null;
      class117.field2021 = null;
      class79.field1462 = null;
      class10.field151 = null;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIBI)V",
      garbageValue = "336246242"
   )
   static final void method193(class2 var0, int var1, int var2, byte var3) {
      int var4 = var0.field885[0];
      int var5 = var0.field886[0];
      int var6 = var0.method14();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var7 = class92.method2162(var4, var5, var0.method14(), class125.method2821(var1, var2), client.field331[var0.field57], true, client.field442, client.field299);
            if(var7 >= 1) {
               for(int var8 = 0; var8 < var7 - 1; ++var8) {
                  var0.method33(client.field442[var8], client.field299[var8], var3);
               }

            }
         }
      }
   }

   class18(class139 var1, URL var2) {
      this.field241 = var1.method2957(var2);
      this.field245 = 0;
      this.field246 = class193.method3805() + 30000L;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-293023763"
   )
   static final boolean method194() {
      if(class38.field829 == null) {
         return false;
      } else {
         int var2;
         String var17;
         try {
            int var0 = class38.field829.method3044();
            if(var0 == 0) {
               return false;
            }

            if(client.field317 == -1) {
               class38.field829.method3061(client.field315.field2047, 0, 1);
               client.field315.field2045 = 0;
               client.field317 = client.field315.method2805();
               client.field283 = class191.field3082[client.field317];
               --var0;
            }

            if(client.field283 == -1) {
               if(var0 <= 0) {
                  return false;
               }

               class38.field829.method3061(client.field315.field2047, 0, 1);
               client.field283 = client.field315.field2047[0] & 255;
               --var0;
            }

            if(client.field283 == -2) {
               if(var0 <= 1) {
                  return false;
               }

               class38.field829.method3061(client.field315.field2047, 0, 2);
               client.field315.field2045 = 0;
               client.field283 = client.field315.method2706();
               var0 -= 2;
            }

            if(var0 < client.field283) {
               return false;
            }

            client.field315.field2045 = 0;
            class38.field829.method3061(client.field315.field2047, 0, client.field283);
            client.field318 = 0;
            client.field290 = client.field321;
            client.field321 = client.field320 * -1;
            client.field320 = client.field317 * -1;
            if(client.field317 == 212) {
               class13.method159(client.field315, client.field283);
               client.field317 = -1;
               return true;
            }

            int var1;
            int var3;
            int var35;
            if(client.field317 == 52) {
               class4.method44();
               var1 = client.field315.method2598();
               var2 = client.field315.method2556();
               var3 = client.field315.method2702();
               client.field469[var2] = var3;
               client.field407[var2] = var1;
               client.field408[var2] = 1;

               for(var35 = 0; var35 < 98; ++var35) {
                  if(var3 >= class158.field2351[var35]) {
                     client.field408[var2] = var35 + 2;
                  }
               }

               client.field541[++client.field461 - 1 & 31] = var2;
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 199) {
               var1 = client.field315.method2608();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               class28.method648(var1);
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 86) {
               var1 = client.field315.method2655();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               var2 = client.field315.method2610();
               class96.method2248(var1, var2);
               client.field317 = -1;
               return true;
            }

            class176 var16;
            if(client.field317 == 117) {
               var1 = client.field315.method2702();
               var2 = client.field315.method2608();
               var16 = class34.method720(var1);
               if(var16.field2786 != 2 || var16.field2839 != var2) {
                  var16.field2786 = 2;
                  var16.field2839 = var2;
                  class92.method2164(var16);
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 133) {
               class48.method1013(true);
               client.field315.method2805();
               var1 = client.field315.method2706();
               class13.method159(client.field315, var1);
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 239) {
               class27 var68 = new class27();
               var68.field654 = client.field315.method2580();
               var68.field650 = client.field315.method2706();
               var2 = client.field315.method2577();
               var68.field651 = var2;
               class171.method3414(45);
               class38.field829.method3050();
               class38.field829 = null;
               class145.method3040(var68);
               client.field317 = -1;
               return false;
            }

            if(client.field317 == 69) {
               var1 = client.field315.method2577();
               class3 var66 = (class3)client.field535.method3856((long)var1);
               if(null != var66) {
                  class142.method3002(var66, true);
               }

               if(null != client.field402) {
                  class92.method2164(client.field402);
                  client.field402 = null;
               }

               client.field317 = -1;
               return true;
            }

            class176 var61;
            if(client.field317 == 3) {
               var1 = client.field315.method2577();
               var61 = class34.method720(var1);
               var61.field2786 = 3;
               var61.field2839 = class114.field2010.field50.method3544();
               class92.method2164(var61);
               client.field317 = -1;
               return true;
            }

            class176 var38;
            class3 var62;
            if(client.field317 == 148) {
               var1 = client.field315.method2646();
               var2 = client.field315.method2616();
               class3 var79 = (class3)client.field535.method3856((long)var2);
               var62 = (class3)client.field535.method3856((long)var1);
               if(null != var62) {
                  class142.method3002(var62, var79 == null || var79.field66 != var62.field66);
               }

               if(null != var79) {
                  var79.method3990();
                  client.field535.method3849(var79, (long)var1);
               }

               var38 = class34.method720(var2);
               if(var38 != null) {
                  class92.method2164(var38);
               }

               var38 = class34.method720(var1);
               if(var38 != null) {
                  class92.method2164(var38);
                  client.method551(class176.field2814[var38.field2795 >>> 16], var38, true);
               }

               if(client.field430 != -1) {
                  class178.method3501(client.field430, 1);
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 87) {
               var1 = client.field315.method2646();
               var2 = client.field315.method2606();
               var3 = client.field315.method2556();
               var62 = (class3)client.field535.method3856((long)var1);
               if(null != var62) {
                  class142.method3002(var62, var62.field66 != var2);
               }

               class22.method576(var1, var2, var3);
               client.field317 = -1;
               return true;
            }

            int var6;
            int var8;
            int var10;
            long var42;
            boolean var43;
            long var47;
            long var51;
            int var55;
            String var56;
            if(client.field317 == 33) {
               client.field404 = client.field455;
               if(client.field283 == 0) {
                  client.field497 = null;
                  client.field498 = null;
                  class152.field2300 = 0;
                  class17.field236 = null;
                  client.field317 = -1;
                  return true;
               }

               client.field498 = client.field315.method2580();
               long var64 = client.field315.method2578();
               var42 = var64;
               if(var64 > 0L && var64 < 6582952005840035281L) {
                  if(0L == var64 % 37L) {
                     var56 = null;
                  } else {
                     var6 = 0;

                     for(var47 = var64; var47 != 0L; var47 /= 37L) {
                        ++var6;
                     }

                     StringBuilder var9 = new StringBuilder(var6);

                     while(var42 != 0L) {
                        var51 = var42;
                        var42 /= 37L;
                        var9.append(class165.field2707[(int)(var51 - var42 * 37L)]);
                     }

                     var56 = var9.reverse().toString();
                  }
               } else {
                  var56 = null;
               }

               client.field497 = var56;
               class124.field2062 = client.field315.method2573();
               var6 = client.field315.method2556();
               if(var6 == 255) {
                  client.field317 = -1;
                  return true;
               }

               class152.field2300 = var6;
               class25[] var72 = new class25[100];

               for(var8 = 0; var8 < class152.field2300; ++var8) {
                  var72[var8] = new class25();
                  var72[var8].field631 = client.field315.method2580();
                  var72[var8].field629 = class23.method579(var72[var8].field631, class134.field2117);
                  var72[var8].field630 = client.field315.method2706();
                  var72[var8].field634 = client.field315.method2573();
                  client.field315.method2580();
                  if(var72[var8].field631.equals(class114.field2010.field43)) {
                     class13.field181 = var72[var8].field634;
                  }
               }

               var43 = false;
               var10 = class152.field2300;

               while(var10 > 0) {
                  var43 = true;
                  --var10;

                  for(var55 = 0; var55 < var10; ++var55) {
                     if(var72[var55].field629.compareTo(var72[var55 + 1].field629) > 0) {
                        class25 var48 = var72[var55];
                        var72[var55] = var72[var55 + 1];
                        var72[1 + var55] = var48;
                        var43 = false;
                     }
                  }

                  if(var43) {
                     break;
                  }
               }

               class17.field236 = var72;
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 244) {
               class1.field31 = client.field315.method2754();
               class29.field687 = client.field315.method2754();

               while(client.field315.field2045 < client.field283) {
                  client.field317 = client.field315.method2556();
                  class34.method727();
               }

               client.field317 = -1;
               return true;
            }

            class176 var19;
            if(client.field317 == 217) {
               var1 = client.field315.method2608();
               var2 = client.field315.method2606();
               var3 = client.field315.method2702();
               var19 = class34.method720(var3);
               var19.field2845 = var2 + (var1 << 16);
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 229) {
               client.field315.field2045 += 28;
               if(client.field315.method2594()) {
                  class125 var67 = client.field315;
                  var2 = client.field315.field2045 - 28;
                  if(null != class152.field2295) {
                     try {
                        class152.field2295.method4227(0L);
                        class152.field2295.method4241(var67.field2047, var2, 24);
                     } catch (Exception var30) {
                        ;
                     }
                  }
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 48) {
               class88.field1535 = class87.method1986(client.field315.method2556());
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 55) {
               client.field518 = true;
               class50.field1113 = client.field315.method2556();
               class7.field123 = client.field315.method2556();
               class127.field2086 = client.field315.method2706();
               class19.field263 = client.field315.method2556();
               class20.field560 = client.field315.method2556();
               if(class20.field560 >= 100) {
                  class9.field144 = 64 + class50.field1113 * 128;
                  class59.field1256 = 64 + class7.field123 * 128;
                  class24.field622 = class15.method163(class9.field144, class59.field1256, class51.field1119) - class127.field2086;
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 204) {
               for(var1 = 0; var1 < client.field393.length; ++var1) {
                  if(null != client.field393[var1]) {
                     client.field393[var1].field884 = -1;
                  }
               }

               for(var1 = 0; var1 < client.field308.length; ++var1) {
                  if(null != client.field308[var1]) {
                     client.field308[var1].field884 = -1;
                  }
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 198) {
               client.field504 = client.field315.method2556();
               if(client.field504 == 255) {
                  client.field504 = 0;
               }

               client.field464 = client.field315.method2556();
               if(client.field464 == 255) {
                  client.field464 = 0;
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 159) {
               var1 = client.field315.method2575();
               var2 = client.field315.method2702();
               var3 = client.field315.method2575();
               var19 = class34.method720(var2);
               if(var19.field2816 != var3 || var1 != var19.field2805 || var19.field2800 != 0 || var19.field2909 != 0) {
                  var19.field2816 = var3;
                  var19.field2805 = var1;
                  var19.field2800 = 0;
                  var19.field2909 = 0;
                  class92.method2164(var19);
                  class14.method161(var19);
                  if(var19.field2929 == 0) {
                     client.method551(class176.field2814[var2 >> 16], var19, false);
                  }
               }

               client.field317 = -1;
               return true;
            }

            int var21;
            if(client.field317 == 90) {
               var1 = client.field315.method2577();
               var2 = client.field315.method2706();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var16 = class34.method720(var1);
               } else {
                  var16 = null;
               }

               for(; client.field315.field2045 < client.field283; class14.method162(var2, var35, var21 - 1, var6)) {
                  var35 = client.field315.method2585();
                  var21 = client.field315.method2706();
                  var6 = 0;
                  if(var21 != 0) {
                     var6 = client.field315.method2556();
                     if(var6 == 255) {
                        var6 = client.field315.method2577();
                     }
                  }

                  if(null != var16 && var35 >= 0 && var35 < var16.field2869.length) {
                     var16.field2869[var35] = var21;
                     var16.field2830[var35] = var6;
                  }
               }

               if(var16 != null) {
                  class92.method2164(var16);
               }

               class4.method44();
               client.field458[++client.field457 - 1 & 31] = var2 & 32767;
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 220) {
               class34.field777 = 0;

               for(var1 = 0; var1 < 2048; ++var1) {
                  class34.field775[var1] = null;
                  class34.field773[var1] = 1;
               }

               for(var1 = 0; var1 < 2048; ++var1) {
                  client.field393[var1] = null;
               }

               class112.method2486(client.field315);
               client.field317 = -1;
               return true;
            }

            long var40;
            if(client.field317 == 221) {
               var1 = client.field315.method2577();
               var2 = client.field315.method2577();
               if(client.field547 == null || !client.field547.isValid()) {
                  try {
                     Iterator var70 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var70.hasNext()) {
                        GarbageCollectorMXBean var69 = (GarbageCollectorMXBean)var70.next();
                        if(var69.isValid()) {
                           client.field547 = var69;
                           client.field269 = -1L;
                           client.field335 = -1L;
                        }
                     }
                  } catch (Throwable var31) {
                     ;
                  }
               }

               long var44 = class193.method3805();
               var21 = -1;
               if(client.field547 != null) {
                  var40 = client.field547.getCollectionTime();
                  if(-1L != client.field335) {
                     long var45 = var40 - client.field335;
                     var51 = var44 - client.field269;
                     if(var51 != 0L) {
                        var21 = (int)(var45 * 100L / var51);
                     }
                  }

                  client.field335 = var40;
                  client.field269 = var44;
               }

               client.field313.method2797(86);
               client.field313.method2729(var1);
               client.field313.method2723(var2);
               client.field313.method2595(var21);
               client.field313.method2595(class147.field2259);
               client.field317 = -1;
               return true;
            }

            boolean var4;
            Object[] var18;
            boolean var49;
            boolean var54;
            String var58;
            int var75;
            if(client.field317 == 30) {
               while(client.field315.field2045 < client.field283) {
                  var49 = client.field315.method2556() == 1;
                  var58 = client.field315.method2580();
                  var56 = client.field315.method2580();
                  var35 = client.field315.method2706();
                  var21 = client.field315.method2556();
                  var6 = client.field315.method2556();
                  boolean var50 = (var6 & 2) != 0;
                  var43 = (var6 & 1) != 0;
                  if(var35 > 0) {
                     client.field315.method2580();
                     client.field315.method2556();
                     client.field315.method2577();
                  }

                  client.field315.method2580();

                  for(var75 = 0; var75 < client.field537; ++var75) {
                     class17 var74 = client.field273[var75];
                     if(!var49) {
                        if(var58.equals(var74.field229)) {
                           if(var35 != var74.field223) {
                              var54 = true;

                              for(class40 var53 = (class40)client.field401.method3841(); var53 != null; var53 = (class40)client.field401.method3842()) {
                                 if(var53.field894.equals(var58)) {
                                    if(var35 != 0 && var53.field898 == 0) {
                                       var53.method3984();
                                       var54 = false;
                                    } else if(var35 == 0 && var53.field898 != 0) {
                                       var53.method3984();
                                       var54 = false;
                                    }
                                 }
                              }

                              if(var54) {
                                 client.field401.method3845(new class40(var58, var35));
                              }

                              var74.field223 = var35;
                           }

                           var74.field224 = var56;
                           var74.field226 = var21;
                           var74.field227 = var50;
                           var74.field228 = var43;
                           var18 = null;
                           break;
                        }
                     } else if(var56.equals(var74.field229)) {
                        var74.field229 = var58;
                        var74.field224 = var56;
                        var18 = null;
                        break;
                     }
                  }
               }

               client.field538 = 2;
               client.field548 = client.field455;
               var49 = false;
               var2 = client.field537;

               while(var2 > 0) {
                  var49 = true;
                  --var2;

                  for(var3 = 0; var3 < var2; ++var3) {
                     var4 = false;
                     class17 var41 = client.field273[var3];
                     class17 var80 = client.field273[1 + var3];
                     if(var41.field223 != client.field272 && var80.field223 == client.field272) {
                        var4 = true;
                     }

                     if(!var4 && var41.field223 == 0 && var80.field223 != 0) {
                        var4 = true;
                     }

                     if(!var4 && !var41.field227 && var80.field227) {
                        var4 = true;
                     }

                     if(!var4 && !var41.field228 && var80.field228) {
                        var4 = true;
                     }

                     if(var4) {
                        class17 var71 = client.field273[var3];
                        client.field273[var3] = client.field273[var3 + 1];
                        client.field273[var3 + 1] = var71;
                        var49 = false;
                     }
                  }

                  if(var49) {
                     break;
                  }
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 89) {
               class4.method44();
               client.field435 = client.field315.method2556();
               client.field467 = client.field455;
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 155) {
               for(var1 = 0; var1 < class179.field2949.length; ++var1) {
                  if(class179.field2949[var1] != class179.field2950[var1]) {
                     class179.field2949[var1] = class179.field2950[var1];
                     class3.method36(var1);
                     client.field456[++client.field284 - 1 & 31] = var1;
                  }
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 246) {
               class1.field31 = client.field315.method2754();
               class29.field687 = client.field315.method2598();
               client.field317 = -1;
               return true;
            }

            String var5;
            int var14;
            int var25;
            String var63;
            if(client.field317 == 20) {
               var17 = client.field315.method2580();
               class106.field1839 = var17;

               try {
                  var58 = client.field270.getParameter(class193.field3112.field3111);
                  var56 = client.field270.getParameter(class193.field3113.field3111);
                  var63 = var58 + "settings=" + var17 + "; version=1; path=/; domain=" + var56;
                  if(var17.length() == 0) {
                     var63 = var63 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var5 = var63 + "; Expires=";
                     var47 = class193.method3805() + 94608000000L;
                     class114.field2008.setTime(new Date(var47));
                     var75 = class114.field2008.get(7);
                     var10 = class114.field2008.get(5);
                     var55 = class114.field2008.get(2);
                     var25 = class114.field2008.get(1);
                     int var13 = class114.field2008.get(11);
                     var14 = class114.field2008.get(12);
                     int var15 = class114.field2008.get(13);
                     String var78 = class114.field2007[var75 - 1] + ", " + var10 / 10 + var10 % 10 + "-" + class114.field2009[0][var55] + "-" + var25 + " " + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + ":" + var15 / 10 + var15 % 10 + " GMT";
                     var63 = var5 + var78 + "; Max-Age=" + 94608000L;
                  }

                  class135.method2904(client.field270, "document.cookie=\"" + var63 + "\"");
               } catch (Throwable var29) {
                  ;
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 151) {
               var1 = client.field315.method2608();
               byte var52 = client.field315.method2573();
               class179.field2950[var1] = var52;
               if(var52 != class179.field2949[var1]) {
                  class179.field2949[var1] = var52;
               }

               class3.method36(var1);
               client.field456[++client.field284 - 1 & 31] = var1;
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 49) {
               var1 = client.field315.method2577();
               var2 = client.field315.method2575();
               var16 = class34.method720(var1);
               if(var16.field2831 != var2 || var2 == -1) {
                  var16.field2831 = var2;
                  var16.field2917 = 0;
                  var16.field2864 = 0;
                  class92.method2164(var16);
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 234) {
               var1 = client.field315.method2706();
               var2 = client.field315.method2556();
               var3 = client.field315.method2706();
               if(client.field510 != 0 && var2 != 0 && client.field274 < 50) {
                  client.field513[client.field274] = var1;
                  client.field346[client.field274] = var2;
                  client.field434[client.field274] = var3;
                  client.field450[client.field274] = null;
                  client.field288[client.field274] = 0;
                  ++client.field274;
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 134) {
               var17 = client.field315.method2580();
               var58 = class226.method4098(class51.method1093(class224.method4081(client.field315)));
               class59.method1304(6, var17, var58);
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 196) {
               var1 = client.field315.method2606();
               var2 = client.field315.method2702();
               var3 = client.field315.method2606();
               var35 = client.field315.method2606();
               var38 = class34.method720(var2);
               if(var35 != var38.field2853 || var3 != var38.field2847 || var38.field2820 != var1) {
                  var38.field2853 = var35;
                  var38.field2847 = var3;
                  var38.field2820 = var1;
                  class92.method2164(var38);
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 137) {
               class174.method3439(client.field315, client.field283);
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 162) {
               client.field289 = client.field315.method2608() * 30;
               client.field467 = client.field455;
               client.field317 = -1;
               return true;
            }

            long var22;
            String var27;
            long var46;
            if(client.field317 == 152) {
               var17 = client.field315.method2580();
               var46 = client.field315.method2578();
               var42 = (long)client.field315.method2706();
               var40 = (long)client.field315.method2576();
               class155 var81 = (class155)class5.method77(class142.method3000(), client.field315.method2556());
               var22 = var40 + (var42 << 32);
               var54 = false;

               for(var25 = 0; var25 < 100; ++var25) {
                  if(client.field526[var25] == var22) {
                     var54 = true;
                     break;
                  }
               }

               if(var81.field2319 && class53.method1118(var17)) {
                  var54 = true;
               }

               if(!var54 && client.field392 == 0) {
                  client.field526[client.field492] = var22;
                  client.field492 = (1 + client.field492) % 100;
                  String var12 = class226.method4098(class51.method1093(class224.method4081(client.field315)));
                  if(var81.field2323 != -1) {
                     var14 = var81.field2323;
                     var27 = "<img=" + var14 + ">";
                     class23.method580(9, var27 + var17, var12, class59.method1251(var46));
                  } else {
                     class23.method580(9, var17, var12, class59.method1251(var46));
                  }
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 58) {
               class48.method1013(false);
               client.field315.method2805();
               var1 = client.field315.method2706();
               class13.method159(client.field315, var1);
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 79) {
               var1 = client.field315.method2646();
               var61 = class34.method720(var1);

               for(var3 = 0; var3 < var61.field2869.length; ++var3) {
                  var61.field2869[var3] = -1;
                  var61.field2869[var3] = 0;
               }

               class92.method2164(var61);
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 238) {
               var1 = client.field315.method2556();
               var2 = client.field315.method2556();
               var3 = client.field315.method2556();
               var35 = client.field315.method2556();
               client.field519[var1] = true;
               client.field520[var1] = var2;
               client.field491[var1] = var3;
               client.field522[var1] = var35;
               client.field523[var1] = 0;
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 112) {
               var1 = client.field315.method2616();
               var58 = client.field315.method2580();
               var16 = class34.method720(var1);
               if(!var58.equals(var16.field2855)) {
                  var16.field2855 = var58;
                  class92.method2164(var16);
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 23) {
               var1 = client.field315.method2655();
               class128.method2851(var1);
               client.field458[++client.field457 - 1 & 31] = var1 & 32767;
               client.field317 = -1;
               return true;
            }

            boolean var34;
            if(client.field317 == 181) {
               Object var82;
               for(; client.field315.field2045 < client.field283; var82 = null) {
                  var1 = client.field315.method2556();
                  var34 = (var1 & 1) == 1;
                  var56 = client.field315.method2580();
                  var63 = client.field315.method2580();
                  client.field315.method2580();

                  for(var21 = 0; var21 < client.field543; ++var21) {
                     class7 var77 = client.field384[var21];
                     if(var34) {
                        if(var63.equals(var77.field120)) {
                           var77.field120 = var56;
                           var77.field122 = var63;
                           var16 = null;
                           break;
                        }
                     } else if(var56.equals(var77.field120)) {
                        var77.field120 = var56;
                        var77.field122 = var63;
                        var16 = null;
                        break;
                     }
                  }
               }

               client.field548 = client.field455;
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 228) {
               var1 = client.field315.method2706();
               var2 = client.field315.method2646();
               class179.field2950[var1] = var2;
               if(class179.field2949[var1] != var2) {
                  class179.field2949[var1] = var2;
               }

               class3.method36(var1);
               client.field456[++client.field284 - 1 & 31] = var1;
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 211) {
               var49 = client.field315.method2556() == 1;
               var2 = client.field315.method2577();
               var16 = class34.method720(var2);
               if(var16.field2815 != var49) {
                  var16.field2815 = var49;
                  class92.method2164(var16);
               }

               client.field317 = -1;
               return true;
            }

            int var7;
            if(client.field317 == 200) {
               var17 = client.field315.method2580();
               var2 = client.field315.method2706();
               byte var39 = client.field315.method2573();
               var4 = false;
               if(var39 == -128) {
                  var4 = true;
               }

               if(var4) {
                  if(class152.field2300 == 0) {
                     client.field317 = -1;
                     return true;
                  }

                  boolean var76 = false;

                  for(var21 = 0; var21 < class152.field2300 && (!class17.field236[var21].field631.equals(var17) || class17.field236[var21].field630 != var2); ++var21) {
                     ;
                  }

                  if(var21 < class152.field2300) {
                     while(var21 < class152.field2300 - 1) {
                        class17.field236[var21] = class17.field236[1 + var21];
                        ++var21;
                     }

                     --class152.field2300;
                     class17.field236[class152.field2300] = null;
                  }
               } else {
                  client.field315.method2580();
                  class25 var37 = new class25();
                  var37.field631 = var17;
                  var37.field629 = class23.method579(var37.field631, class134.field2117);
                  var37.field630 = var2;
                  var37.field634 = var39;

                  for(var6 = class152.field2300 - 1; var6 >= 0; --var6) {
                     var7 = class17.field236[var6].field629.compareTo(var37.field629);
                     if(var7 == 0) {
                        class17.field236[var6].field630 = var2;
                        class17.field236[var6].field634 = var39;
                        if(var17.equals(class114.field2010.field43)) {
                           class13.field181 = var39;
                        }

                        client.field404 = client.field455;
                        client.field317 = -1;
                        return true;
                     }

                     if(var7 < 0) {
                        break;
                     }
                  }

                  if(class152.field2300 >= class17.field236.length) {
                     client.field317 = -1;
                     return true;
                  }

                  for(var7 = class152.field2300 - 1; var7 > var6; --var7) {
                     class17.field236[var7 + 1] = class17.field236[var7];
                  }

                  if(class152.field2300 == 0) {
                     class17.field236 = new class25[100];
                  }

                  class17.field236[1 + var6] = var37;
                  ++class152.field2300;
                  if(var17.equals(class114.field2010.field43)) {
                     class13.field181 = var39;
                  }
               }

               client.field404 = client.field455;
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 123) {
               var17 = client.field315.method2580();
               var46 = (long)client.field315.method2706();
               var42 = (long)client.field315.method2576();
               class155 var24 = (class155)class5.method77(class142.method3000(), client.field315.method2556());
               var47 = var42 + (var46 << 32);
               boolean var73 = false;

               for(var10 = 0; var10 < 100; ++var10) {
                  if(client.field526[var10] == var47) {
                     var73 = true;
                     break;
                  }
               }

               if(class53.method1118(var17)) {
                  var73 = true;
               }

               if(!var73 && client.field392 == 0) {
                  client.field526[client.field492] = var47;
                  client.field492 = (client.field492 + 1) % 100;
                  String var23 = class226.method4098(class51.method1093(class224.method4081(client.field315)));
                  byte var11;
                  if(var24.field2326) {
                     var11 = 7;
                  } else {
                     var11 = 3;
                  }

                  if(var24.field2323 != -1) {
                     var14 = var24.field2323;
                     var27 = "<img=" + var14 + ">";
                     class59.method1304(var11, var27 + var17, var23);
                  } else {
                     class59.method1304(var11, var17, var23);
                  }
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 60) {
               var49 = client.field315.method2556() == 1;
               if(var49) {
                  class143.field2225 = class193.method3805() - client.field315.method2578();
                  class137.field2125 = new class224(client.field315, true);
               } else {
                  class137.field2125 = null;
               }

               client.field466 = client.field455;
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 185) {
               class48.method997(false);
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 163) {
               var1 = client.field315.field2045 + client.field283;
               var2 = client.field315.method2706();
               var3 = client.field315.method2706();
               if(client.field430 != var2) {
                  client.field430 = var2;
                  var35 = client.field430;
                  var21 = class12.field174;
                  var6 = class19.field264;
                  if(class122.method2739(var35)) {
                     class6.method93(class176.field2814[var35], -1, var21, var6, false);
                  }

                  class117.method2508(client.field430);
                  class104.method2358(client.field430);

                  for(var35 = 0; var35 < 100; ++var35) {
                     client.field460[var35] = true;
                  }
               }

               class3 var65;
               for(; var3-- > 0; var65.field65 = true) {
                  var35 = client.field315.method2577();
                  var21 = client.field315.method2706();
                  var6 = client.field315.method2556();
                  var65 = (class3)client.field535.method3856((long)var35);
                  if(null != var65 && var21 != var65.field66) {
                     class142.method3002(var65, true);
                     var65 = null;
                  }

                  if(var65 == null) {
                     var65 = class22.method576(var35, var21, var6);
                  }
               }

               for(var62 = (class3)client.field535.method3847(); var62 != null; var62 = (class3)client.field535.method3852()) {
                  if(var62.field65) {
                     var62.field65 = false;
                  } else {
                     class142.method3002(var62, true);
                  }
               }

               client.field472 = new class199(512);

               while(client.field315.field2045 < var1) {
                  var35 = client.field315.method2577();
                  var21 = client.field315.method2706();
                  var6 = client.field315.method2706();
                  var7 = client.field315.method2577();

                  for(var8 = var21; var8 <= var6; ++var8) {
                     var22 = (long)var8 + ((long)var35 << 32);
                     client.field472.method3849(new class204(var7), var22);
                  }
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 105) {
               client.field395 = client.field315.method2556();
               client.field552 = client.field315.method2556();
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 158) {
               for(var1 = 0; var1 < class56.field1239; ++var1) {
                  class56 var57 = class4.method41(var1);
                  if(var57 != null) {
                     class179.field2950[var1] = 0;
                     class179.field2949[var1] = 0;
                  }
               }

               class4.method44();
               client.field284 += 32;
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 26) {
               var1 = client.field315.method2616();
               var2 = client.field315.method2706();
               var16 = class34.method720(var1);
               if(var16.field2786 != 1 || var16.field2839 != var2) {
                  var16.field2786 = 1;
                  var16.field2839 = var2;
                  class92.method2164(var16);
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 225) {
               var1 = client.field315.method2646();
               var2 = client.field315.method2606();
               var3 = var2 >> 10 & 31;
               var35 = var2 >> 5 & 31;
               var21 = var2 & 31;
               var6 = (var35 << 11) + (var3 << 19) + (var21 << 3);
               class176 var20 = class34.method720(var1);
               if(var20.field2891 != var6) {
                  var20.field2891 = var6;
                  class92.method2164(var20);
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 171) {
               if(client.field430 != -1) {
                  class178.method3501(client.field430, 0);
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 168) {
               client.field518 = true;
               class49.field1087 = client.field315.method2556();
               class16.field219 = client.field315.method2556();
               class22.field585 = client.field315.method2706();
               class114.field2006 = client.field315.method2556();
               class44.field1008 = client.field315.method2556();
               if(class44.field1008 >= 100) {
                  var1 = class49.field1087 * 128 + 64;
                  var2 = 64 + class16.field219 * 128;
                  var3 = class15.method163(var1, var2, class51.field1119) - class22.field585;
                  var35 = var1 - class9.field144;
                  var21 = var3 - class24.field622;
                  var6 = var2 - class59.field1256;
                  var7 = (int)Math.sqrt((double)(var6 * var6 + var35 * var35));
                  class31.field717 = (int)(Math.atan2((double)var21, (double)var7) * 325.949D) & 2047;
                  class10.field155 = (int)(Math.atan2((double)var35, (double)var6) * -325.949D) & 2047;
                  if(class31.field717 < 128) {
                     class31.field717 = 128;
                  }

                  if(class31.field717 > 383) {
                     class31.field717 = 383;
                  }
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 149) {
               var1 = client.field315.method2655();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               var2 = client.field315.method2706();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var3 = client.field315.method2577();
               var35 = client.field315.method2616();

               for(var21 = var1; var21 <= var2; ++var21) {
                  var40 = (long)var21 + ((long)var35 << 32);
                  class211 var26 = client.field472.method3856(var40);
                  if(null != var26) {
                     var26.method3990();
                  }

                  client.field472.method3849(new class204(var3), var40);
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 103) {
               var17 = client.field315.method2580();
               var18 = new Object[var17.length() + 1];

               for(var3 = var17.length() - 1; var3 >= 0; --var3) {
                  if(var17.charAt(var3) == 115) {
                     var18[var3 + 1] = client.field315.method2580();
                  } else {
                     var18[var3 + 1] = new Integer(client.field315.method2577());
                  }
               }

               var18[0] = new Integer(client.field315.method2577());
               class0 var59 = new class0();
               var59.field1 = var18;
               class43.method884(var59, 200000);
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 121) {
               class15.method178();
               client.field317 = -1;
               return false;
            }

            if(client.field317 == 75) {
               var1 = client.field315.method2577();
               var2 = client.field315.method2706();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var16 = class34.method720(var1);
               } else {
                  var16 = null;
               }

               class30.method666(var2);
               var35 = client.field315.method2706();

               for(var21 = 0; var21 < var35; ++var21) {
                  var6 = client.field315.method2706();
                  var7 = client.field315.method2598();
                  if(var7 == 255) {
                     var7 = client.field315.method2646();
                  }

                  if(var16 != null && var21 < var16.field2869.length) {
                     var16.field2869[var21] = var6;
                     var16.field2830[var21] = var7;
                  }

                  class14.method162(var2, var21, var6 - 1, var7);
               }

               if(var16 != null) {
                  class92.method2164(var16);
               }

               class4.method44();
               client.field458[++client.field457 - 1 & 31] = var2 & 32767;
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 68) {
               client.field538 = 1;
               client.field548 = client.field455;
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 214) {
               class48.method997(true);
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 80) {
               class4.method44();
               client.field436 = client.field315.method2575();
               client.field467 = client.field455;
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 15) {
               var1 = client.field315.method2556();
               if(client.field315.method2556() == 0) {
                  client.field546[var1] = new class223();
                  client.field315.field2045 += 18;
               } else {
                  --client.field315.field2045;
                  client.field546[var1] = new class223(client.field315, false);
               }

               client.field465 = client.field455;
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 240) {
               var1 = client.field315.method2608();
               client.field430 = var1;
               var2 = client.field430;
               var3 = class12.field174;
               var35 = class19.field264;
               if(class122.method2739(var2)) {
                  class6.method93(class176.field2814[var2], -1, var3, var35, false);
               }

               class117.method2508(var1);
               class104.method2358(client.field430);

               for(var2 = 0; var2 < 100; ++var2) {
                  client.field460[var2] = true;
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 206) {
               class1.field31 = client.field315.method2598();
               class29.field687 = client.field315.method2598();

               for(var1 = class1.field31; var1 < 8 + class1.field31; ++var1) {
                  for(var2 = class29.field687; var2 < class29.field687 + 8; ++var2) {
                     if(null != client.field403[class51.field1119][var1][var2]) {
                        client.field403[class51.field1119][var1][var2] = null;
                        class142.method3001(var1, var2);
                     }
                  }
               }

               for(class16 var60 = (class16)client.field369.method3882(); null != var60; var60 = (class16)client.field369.method3891()) {
                  if(var60.field209 >= class1.field31 && var60.field209 < 8 + class1.field31 && var60.field210 >= class29.field687 && var60.field210 < 8 + class29.field687 && var60.field213 == class51.field1119) {
                     var60.field221 = 0;
                  }
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 144) {
               client.field418 = client.field315.method2556();
               if(client.field418 == 1) {
                  client.field291 = client.field315.method2706();
               }

               if(client.field418 >= 2 && client.field418 <= 6) {
                  if(client.field418 == 2) {
                     client.field296 = 64;
                     client.field297 = 64;
                  }

                  if(client.field418 == 3) {
                     client.field296 = 0;
                     client.field297 = 64;
                  }

                  if(client.field418 == 4) {
                     client.field296 = 128;
                     client.field297 = 64;
                  }

                  if(client.field418 == 5) {
                     client.field296 = 64;
                     client.field297 = 0;
                  }

                  if(client.field418 == 6) {
                     client.field296 = 64;
                     client.field297 = 128;
                  }

                  client.field418 = 2;
                  client.field293 = client.field315.method2706();
                  client.field309 = client.field315.method2706();
                  client.field295 = client.field315.method2556();
               }

               if(client.field418 == 10) {
                  client.field336 = client.field315.method2706();
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 81) {
               var17 = client.field315.method2580();
               var2 = client.field315.method2598();
               var3 = client.field315.method2598();
               if(var2 >= 1 && var2 <= 8) {
                  if(var17.equalsIgnoreCase("null")) {
                     var17 = null;
                  }

                  client.field399[var2 - 1] = var17;
                  client.field400[var2 - 1] = var3 == 0;
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 232) {
               var1 = client.field315.method2606();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               var2 = client.field315.method2702();
               var3 = client.field315.method2646();
               var19 = class34.method720(var3);
               class55 var36;
               if(!var19.field2794) {
                  if(var1 == -1) {
                     var19.field2786 = 0;
                     client.field317 = -1;
                     return true;
                  }

                  var36 = class4.method42(var1);
                  var19.field2786 = 4;
                  var19.field2839 = var1;
                  var19.field2853 = var36.field1216;
                  var19.field2847 = var36.field1190;
                  var19.field2820 = var36.field1188 * 100 / var2;
                  class92.method2164(var19);
               } else {
                  var19.field2834 = var1;
                  var19.field2916 = var2;
                  var36 = class4.method42(var1);
                  var19.field2853 = var36.field1216;
                  var19.field2847 = var36.field1190;
                  var19.field2848 = var36.field1189;
                  var19.field2863 = var36.field1192;
                  var19.field2851 = var36.field1193;
                  var19.field2820 = var36.field1188;
                  if(var36.field1194 == 1) {
                     var19.field2913 = 1;
                  } else {
                     var19.field2913 = 2;
                  }

                  if(var19.field2897 > 0) {
                     var19.field2820 = var19.field2820 * 32 / var19.field2897;
                  } else if(var19.field2806 > 0) {
                     var19.field2820 = var19.field2820 * 32 / var19.field2806;
                  }

                  class92.method2164(var19);
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 173) {
               client.field518 = false;

               for(var1 = 0; var1 < 5; ++var1) {
                  client.field519[var1] = false;
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 208) {
               client.field506 = client.field315.method2556();
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 27) {
               var1 = client.field315.method2585();
               var34 = client.field315.method2556() == 1;
               var56 = "";
               var4 = false;
               if(var34) {
                  var56 = client.field315.method2580();
                  if(class53.method1118(var56)) {
                     var4 = true;
                  }
               }

               var5 = client.field315.method2580();
               if(!var4) {
                  class59.method1304(var1, var56, var5);
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 91) {
               var1 = client.field315.method2646();
               class0.field19 = class40.field900.method2947(var1);
               client.field317 = -1;
               return true;
            }

            if(client.field317 == 72) {
               var1 = client.field315.method2606();
               var2 = client.field315.method2702();
               var16 = class34.method720(var2);
               if(null != var16 && var16.field2929 == 0) {
                  if(var1 > var16.field2819 - var16.field2877) {
                     var1 = var16.field2819 - var16.field2877;
                  }

                  if(var1 < 0) {
                     var1 = 0;
                  }

                  if(var16.field2817 != var1) {
                     var16.field2817 = var1;
                     class92.method2164(var16);
                  }
               }

               client.field317 = -1;
               return true;
            }

            if(client.field317 == 10 || client.field317 == 176 || client.field317 == 172 || client.field317 == 157 || client.field317 == 39 || client.field317 == 130 || client.field317 == 47 || client.field317 == 98 || client.field317 == 202 || client.field317 == 114) {
               class34.method727();
               client.field317 = -1;
               return true;
            }

            class54.method1130("" + client.field317 + "," + client.field321 + "," + client.field290 + "," + client.field283, (Throwable)null);
            class15.method178();
         } catch (IOException var32) {
            if(client.field323 > 0) {
               class15.method178();
            } else {
               class171.method3414(40);
               class177.field2937 = class38.field829;
               class38.field829 = null;
            }
         } catch (Exception var33) {
            var17 = "" + client.field317 + "," + client.field321 + "," + client.field290 + "," + client.field283 + "," + (class39.field838 + class114.field2010.field885[0]) + "," + (class114.field2010.field886[0] + class13.field184) + ",";

            for(var2 = 0; var2 < client.field283 && var2 < 50; ++var2) {
               var17 = var17 + client.field315.field2047[var2] + ",";
            }

            class54.method1130(var17, var33);
            class15.method178();
         }

         return true;
      }
   }
}
