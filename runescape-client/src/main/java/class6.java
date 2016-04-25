import java.applet.Applet;
import java.io.DataInputStream;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
@Implements("Projectile")
public final class class6 extends class85 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -634446535
   )
   int field105;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1612680969
   )
   int field106;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1781354569
   )
   int field107;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -135250603
   )
   int field108;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1623256661
   )
   int field109;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -823808231
   )
   int field110;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1595852297
   )
   int field111;
   @ObfuscatedName("w")
   double field112;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1762792469
   )
   int field113;
   @ObfuscatedName("p")
   double field114;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 740901973
   )
   int field115;
   @ObfuscatedName("r")
   @Export("isMoving")
   boolean field116 = false;
   @ObfuscatedName("a")
   double field117;
   @ObfuscatedName("d")
   @Export("velocityZ")
   double field118;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2126732629
   )
   int field119;
   @ObfuscatedName("q")
   double field120;
   @ObfuscatedName("b")
   @Export("scalar")
   double field121;
   @ObfuscatedName("t")
   @Export("velocityY")
   double field122;
   @ObfuscatedName("y")
   @Export("velocityX")
   double field123;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1313938663
   )
   int field124;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2085590381
   )
   int field125;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1842227307
   )
   int field126;
   @ObfuscatedName("k")
   @Export("animationSequence")
   class42 field127;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1636488935
   )
   int field128 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 707751951
   )
   int field129 = 0;

   class6(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.field109 = var1;
      this.field106 = var2;
      this.field107 = var3;
      this.field108 = var4;
      this.field113 = var5;
      this.field111 = var6;
      this.field110 = var7;
      this.field119 = var8;
      this.field124 = var9;
      this.field115 = var10;
      this.field105 = var11;
      this.field116 = false;
      int var12 = class19.method239(this.field109).field993;
      if(-1 != var12) {
         this.field127 = class161.method3153(var12);
      } else {
         this.field127 = null;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "-11192"
   )
   final void method89(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.field116) {
         var5 = (double)(var1 - this.field107);
         double var7 = (double)(var2 - this.field108);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.field117 = (double)this.field124 * var5 / var9 + (double)this.field107;
         this.field118 = var7 * (double)this.field124 / var9 + (double)this.field108;
         this.field114 = (double)this.field113;
      }

      var5 = (double)(1 + this.field110 - var4);
      this.field120 = ((double)var1 - this.field117) / var5;
      this.field121 = ((double)var2 - this.field118) / var5;
      this.field122 = Math.sqrt(this.field121 * this.field121 + this.field120 * this.field120);
      if(!this.field116) {
         this.field123 = -this.field122 * Math.tan(0.02454369D * (double)this.field119);
      }

      this.field112 = 2.0D * ((double)var3 - this.field114 - this.field123 * var5) / (var5 * var5);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1523594596"
   )
   final void method90(int var1) {
      this.field116 = true;
      this.field117 += (double)var1 * this.field120;
      this.field118 += (double)var1 * this.field121;
      this.field114 += (double)var1 * 0.5D * this.field112 * (double)var1 + (double)var1 * this.field123;
      this.field123 += this.field112 * (double)var1;
      this.field125 = (int)(Math.atan2(this.field120, this.field121) * 325.949D) + 1024 & 2047;
      this.field126 = (int)(Math.atan2(this.field123, this.field122) * 325.949D) & 2047;
      if(null != this.field127) {
         this.field129 += var1;

         while(true) {
            do {
               do {
                  if(this.field129 <= this.field127.field974[this.field128]) {
                     return;
                  }

                  this.field129 -= this.field127.field974[this.field128];
                  ++this.field128;
               } while(this.field128 < this.field127.field972.length);

               this.field128 -= this.field127.field967;
            } while(this.field128 >= 0 && this.field128 < this.field127.field972.length);

            this.field128 = 0;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "-1145523992"
   )
   protected final class105 vmethod1900() {
      class43 var1 = class19.method239(this.field109);
      class105 var2 = var1.method888(this.field128);
      if(var2 == null) {
         return null;
      } else {
         var2.method2330(this.field126);
         return var2;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;B)V",
      garbageValue = "-48"
   )
   public static void method97(Applet var0, String var1) {
      class138.field2115 = var0;
      class138.field2110 = var1;
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "([Lclass173;IB)V",
      garbageValue = "0"
   )
   static final void method98(class173[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class173 var3 = var0[var2];
         if(null != var3 && var1 == var3.field2763 && (!var3.field2768 || !class30.method659(var3))) {
            if(0 == var3.field2820) {
               if(!var3.field2768 && class30.method659(var3) && var3 != class143.field2170) {
                  continue;
               }

               method98(var0, var3.field2774);
               if(null != var3.field2868) {
                  method98(var3.field2868, var3.field2774);
               }

               class3 var4 = (class3)client.field434.method3742((long)var3.field2774);
               if(null != var4) {
                  class7.method107(var4.field65);
               }
            }

            if(var3.field2820 == 6) {
               int var5;
               if(-1 != var3.field2848 || -1 != var3.field2864) {
                  boolean var7 = class48.method995(var3);
                  if(var7) {
                     var5 = var3.field2864;
                  } else {
                     var5 = var3.field2848;
                  }

                  if(-1 != var5) {
                     class42 var6 = class161.method3153(var5);

                     for(var3.field2867 += client.field351; var3.field2867 > var6.field974[var3.field2866]; class2.method28(var3)) {
                        var3.field2867 -= var6.field974[var3.field2866];
                        ++var3.field2866;
                        if(var3.field2866 >= var6.field972.length) {
                           var3.field2866 -= var6.field967;
                           if(var3.field2866 < 0 || var3.field2866 >= var6.field972.length) {
                              var3.field2866 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2761 != 0 && !var3.field2768) {
                  int var8 = var3.field2761 >> 16;
                  var5 = var3.field2761 << 16 >> 16;
                  var8 *= client.field351;
                  var5 *= client.field351;
                  var3.field2795 = var3.field2795 + var8 & 2047;
                  var3.field2832 = var3.field2832 + var5 & 2047;
                  class2.method28(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(Lclass173;III)V",
      garbageValue = "-1456165118"
   )
   static final void method100(class173 var0, int var1, int var2) {
      if(var0.field2747 == 1) {
         class125.method2769(var0.field2861, "", 24, 0, 0, var0.field2774);
      }

      String var3;
      if(var0.field2747 == 2 && !client.field511) {
         if(class159.method3139(class144.method3075(var0)) == 0) {
            var3 = null;
         } else if(var0.field2823 != null && var0.field2823.trim().length() != 0) {
            var3 = var0.field2823;
         } else {
            var3 = null;
         }

         if(var3 != null) {
            class125.method2769(var3, class219.method3968('\uff00') + var0.field2860, 25, 0, -1, var0.field2774);
         }
      }

      if(var0.field2747 == 3) {
         class125.method2769("Close", "", 26, 0, 0, var0.field2774);
      }

      if(var0.field2747 == 4) {
         class125.method2769(var0.field2861, "", 28, 0, 0, var0.field2774);
      }

      if(var0.field2747 == 5) {
         class125.method2769(var0.field2861, "", 29, 0, 0, var0.field2774);
      }

      if(6 == var0.field2747 && null == client.field437) {
         class125.method2769(var0.field2861, "", 30, 0, -1, var0.field2774);
      }

      int var5;
      int var6;
      int var16;
      if(var0.field2820 == 2) {
         var16 = 0;

         for(int var4 = 0; var4 < var0.field2746; ++var4) {
            for(var5 = 0; var5 < var0.field2840; ++var5) {
               var6 = (32 + var0.field2810) * var5;
               int var7 = (var0.field2811 + 32) * var4;
               if(var16 < 20) {
                  var6 += var0.field2812[var16];
                  var7 += var0.field2813[var16];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < 32 + var6 && var2 < 32 + var7) {
                  client.field392 = var16;
                  class166.field2657 = var0;
                  if(var0.field2862[var16] > 0) {
                     class51 var8 = class89.method2081(var0.field2862[var16] - 1);
                     if(1 == client.field280 && class119.method2589(class144.method3075(var0))) {
                        if(var0.field2774 != class109.field1894 || class15.field214 != var16) {
                           class125.method2769("Use", client.field427 + " " + "->" + " " + class219.method3968(16748608) + var8.field1095, 31, var8.field1093, var16, var0.field2774);
                        }
                     } else if(client.field511 && class119.method2589(class144.method3075(var0))) {
                        if(16 == (class11.field174 & 16)) {
                           class125.method2769(client.field362, client.field313 + " " + "->" + " " + class219.method3968(16748608) + var8.field1095, 32, var8.field1093, var16, var0.field2774);
                        }
                     } else {
                        String[] var9 = var8.field1110;
                        if(client.field444) {
                           var9 = class50.method1017(var9);
                        }

                        if(class119.method2589(class144.method3075(var0))) {
                           for(int var10 = 4; var10 >= 3; --var10) {
                              if(null != var9 && var9[var10] != null) {
                                 byte var11;
                                 if(3 == var10) {
                                    var11 = 36;
                                 } else {
                                    var11 = 37;
                                 }

                                 class125.method2769(var9[var10], class219.method3968(16748608) + var8.field1095, var11, var8.field1093, var16, var0.field2774);
                              } else if(4 == var10) {
                                 class125.method2769("Drop", class219.method3968(16748608) + var8.field1095, 37, var8.field1093, var16, var0.field2774);
                              }
                           }
                        }

                        int var21 = class144.method3075(var0);
                        boolean var20 = (var21 >> 31 & 1) != 0;
                        if(var20) {
                           class125.method2769("Use", class219.method3968(16748608) + var8.field1095, 38, var8.field1093, var16, var0.field2774);
                        }

                        int var13 = class144.method3075(var0);
                        boolean var12 = (var13 >> 30 & 1) != 0;
                        int var14;
                        byte var15;
                        if(var12 && null != var9) {
                           for(var14 = 2; var14 >= 0; --var14) {
                              if(var9[var14] != null) {
                                 var15 = 0;
                                 if(var14 == 0) {
                                    var15 = 33;
                                 }

                                 if(1 == var14) {
                                    var15 = 34;
                                 }

                                 if(2 == var14) {
                                    var15 = 35;
                                 }

                                 class125.method2769(var9[var14], class219.method3968(16748608) + var8.field1095, var15, var8.field1093, var16, var0.field2774);
                              }
                           }
                        }

                        var9 = var0.field2815;
                        if(client.field444) {
                           var9 = class50.method1017(var9);
                        }

                        if(null != var9) {
                           for(var14 = 4; var14 >= 0; --var14) {
                              if(var9[var14] != null) {
                                 var15 = 0;
                                 if(0 == var14) {
                                    var15 = 39;
                                 }

                                 if(var14 == 1) {
                                    var15 = 40;
                                 }

                                 if(2 == var14) {
                                    var15 = 41;
                                 }

                                 if(3 == var14) {
                                    var15 = 42;
                                 }

                                 if(var14 == 4) {
                                    var15 = 43;
                                 }

                                 class125.method2769(var9[var14], class219.method3968(16748608) + var8.field1095, var15, var8.field1093, var16, var0.field2774);
                              }
                           }
                        }

                        class125.method2769("Examine", class219.method3968(16748608) + var8.field1095, 1005, var8.field1093, var16, var0.field2774);
                     }
                  }
               }

               ++var16;
            }
         }
      }

      if(var0.field2768) {
         if(client.field511) {
            if(class106.method2372(class144.method3075(var0)) && 32 == (class11.field174 & 32)) {
               class125.method2769(client.field362, client.field313 + " " + "->" + " " + var0.field2817, 58, 0, var0.field2798, var0.field2774);
            }
         } else {
            for(var16 = 9; var16 >= 5; --var16) {
               String var17 = class45.method939(var0, var16);
               if(null != var17) {
                  class125.method2769(var17, var0.field2817, 1007, var16 + 1, var0.field2798, var0.field2774);
               }
            }

            if(class159.method3139(class144.method3075(var0)) == 0) {
               var3 = null;
            } else if(var0.field2823 != null && var0.field2823.trim().length() != 0) {
               var3 = var0.field2823;
            } else {
               var3 = null;
            }

            if(null != var3) {
               class125.method2769(var3, var0.field2817, 25, 0, var0.field2798, var0.field2774);
            }

            for(var5 = 4; var5 >= 0; --var5) {
               String var19 = class45.method939(var0, var5);
               if(null != var19) {
                  class125.method2769(var19, var0.field2817, 57, var5 + 1, var0.field2798, var0.field2774);
               }
            }

            var6 = class144.method3075(var0);
            boolean var18 = (var6 & 1) != 0;
            if(var18) {
               class125.method2769("Continue", "", 30, 0, var0.field2798, var0.field2774);
            }
         }
      }

   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-707709386"
   )
   static void method101() {
      for(int var0 = 0; var0 < client.field415; ++var0) {
         int var2 = client.field418[var0];
         boolean var1 = 57 == var2 || 58 == var2 || 1007 == var2 || 25 == var2 || var2 == 30;
         if(var1) {
            if(var0 < client.field415 - 1) {
               for(int var3 = var0; var3 < client.field415 - 1; ++var3) {
                  client.field420[var3] = client.field420[1 + var3];
                  client.field290[var3] = client.field290[1 + var3];
                  client.field418[var3] = client.field418[var3 + 1];
                  client.field502[var3] = client.field502[1 + var3];
                  client.field385[var3] = client.field385[1 + var3];
                  client.field417[var3] = client.field417[1 + var3];
               }
            }

            --client.field415;
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-36929010"
   )
   public static void method102(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(null != var1) {
            var2 = class10.method139(var1);
         }

         if(null != var0) {
            if(var1 != null) {
               var2 = var2 + " | ";
            }

            var2 = var2 + var0;
         }

         System.out.println("Error: " + var2);
         var2 = var2.replace(':', '.');
         var2 = var2.replace('@', '_');
         var2 = var2.replace('&', '_');
         var2 = var2.replace('#', '_');
         if(class148.field2202 == null) {
            return;
         }

         URL var3 = new URL(class148.field2202.getCodeBase(), "clienterror.ws?c=" + class148.field2205 + "&u=" + class148.field2201 + "&v1=" + class136.field2076 + "&v2=" + class136.field2071 + "&e=" + var2);
         DataInputStream var4 = new DataInputStream(var3.openStream());
         var4.read();
         var4.close();
      } catch (Exception var5) {
         ;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BIB)I",
      garbageValue = "0"
   )
   public static int method103(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(8364 == var7) {
            var3[var4 + var6] = -128;
         } else if(8218 == var7) {
            var3[var4 + var6] = -126;
         } else if(var7 == 402) {
            var3[var4 + var6] = -125;
         } else if(8222 == var7) {
            var3[var6 + var4] = -124;
         } else if(var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var6 + var4] = -122;
         } else if(8225 == var7) {
            var3[var6 + var4] = -121;
         } else if(var7 == 710) {
            var3[var4 + var6] = -120;
         } else if(8240 == var7) {
            var3[var4 + var6] = -119;
         } else if(var7 == 352) {
            var3[var6 + var4] = -118;
         } else if(8249 == var7) {
            var3[var4 + var6] = -117;
         } else if(338 == var7) {
            var3[var4 + var6] = -116;
         } else if(381 == var7) {
            var3[var6 + var4] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(8217 == var7) {
            var3[var4 + var6] = -110;
         } else if(var7 == 8220) {
            var3[var4 + var6] = -109;
         } else if(8221 == var7) {
            var3[var6 + var4] = -108;
         } else if(8226 == var7) {
            var3[var6 + var4] = -107;
         } else if(var7 == 8211) {
            var3[var6 + var4] = -106;
         } else if(8212 == var7) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var4 + var6] = -104;
         } else if(var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if(var7 == 353) {
            var3[var6 + var4] = -102;
         } else if(var7 == 8250) {
            var3[var6 + var4] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var6 + var4] = -98;
         } else if(376 == var7) {
            var3[var6 + var4] = -97;
         } else {
            var3[var6 + var4] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-117"
   )
   static void method104(int var0, int var1) {
      class174.method3404(class179.field2925, var0, var1);
      class179.field2925 = null;
   }
}
