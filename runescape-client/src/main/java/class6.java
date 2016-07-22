import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("Projectile")
public final class class6 extends class88 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 291680193
   )
   @Export("id")
   int field92;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 506277629
   )
   @Export("floor")
   int field93;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1961156761
   )
   int field94;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2109851939
   )
   @Export("y1")
   int field95;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -759563405
   )
   @Export("z1")
   int field96;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -792399161
   )
   int field97;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 119958447
   )
   @Export("startTime")
   int field98;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 604685667
   )
   int field99;
   @ObfuscatedName("h")
   @Export("isMoving")
   boolean field100 = false;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -180070263
   )
   @Export("start")
   int field101;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1183766177
   )
   @Export("interacting")
   int field102;
   @ObfuscatedName("u")
   @Export("x")
   double field104;
   @ObfuscatedName("y")
   @Export("velocityZ")
   double field105;
   @ObfuscatedName("t")
   @Export("az")
   double field106;
   @ObfuscatedName("s")
   double field107;
   @ObfuscatedName("f")
   @Export("scalar")
   double field108;
   @ObfuscatedName("i")
   @Export("velocityY")
   double field109;
   @ObfuscatedName("d")
   @Export("velocityX")
   double field110;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 428422753
   )
   @Export("x1")
   int field111;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1036220239
   )
   int field112;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1082991647
   )
   int field113 = 0;
   @ObfuscatedName("n")
   @Export("animationSequence")
   class44 field114;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -257847043
   )
   int field116 = 0;
   @ObfuscatedName("p")
   @Export("z")
   double field117;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      intValue = -1335473733
   )
   protected static int field118;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1726826957
   )
   int field119;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2073660675"
   )
   final void method80(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.field100) {
         var5 = (double)(var1 - this.field111);
         double var7 = (double)(var2 - this.field95);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.field104 = (double)this.field111 + (double)this.field101 * var5 / var9;
         this.field105 = (double)this.field95 + var7 * (double)this.field101 / var9;
         this.field117 = (double)this.field96;
      }

      var5 = (double)(this.field99 + 1 - var4);
      this.field107 = ((double)var1 - this.field104) / var5;
      this.field108 = ((double)var2 - this.field105) / var5;
      this.field109 = Math.sqrt(this.field108 * this.field108 + this.field107 * this.field107);
      if(!this.field100) {
         this.field110 = -this.field109 * Math.tan(0.02454369D * (double)this.field112);
      }

      this.field106 = ((double)var3 - this.field117 - this.field110 * var5) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1669689415"
   )
   final void method81(int var1) {
      this.field100 = true;
      this.field104 += (double)var1 * this.field107;
      this.field105 += this.field108 * (double)var1;
      this.field117 += this.field110 * (double)var1 + (double)var1 * this.field106 * 0.5D * (double)var1;
      this.field110 += (double)var1 * this.field106;
      this.field94 = (int)(Math.atan2(this.field107, this.field108) * 325.949D) + 1024 & 2047;
      this.field119 = (int)(Math.atan2(this.field110, this.field109) * 325.949D) & 2047;
      if(null != this.field114) {
         this.field116 += var1;

         while(true) {
            do {
               do {
                  if(this.field116 <= this.field114.field1011[this.field113]) {
                     return;
                  }

                  this.field116 -= this.field114.field1011[this.field113];
                  ++this.field113;
               } while(this.field113 < this.field114.field1009.length);

               this.field113 -= this.field114.field1013;
            } while(this.field113 >= 0 && this.field113 < this.field114.field1009.length);

            this.field113 = 0;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lclass108;",
      garbageValue = "-990594109"
   )
   protected final class108 vmethod1992() {
      class45 var1 = class175.method3442(this.field92);
      class108 var2 = var1.method942(this.field113);
      if(var2 == null) {
         return null;
      } else {
         var2.method2379(this.field119);
         return var2;
      }
   }

   class6(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.field92 = var1;
      this.field93 = var2;
      this.field111 = var3;
      this.field95 = var4;
      this.field96 = var5;
      this.field98 = var6;
      this.field99 = var7;
      this.field112 = var8;
      this.field101 = var9;
      this.field102 = var10;
      this.field97 = var11;
      this.field100 = false;
      int var12 = class175.method3442(this.field92).field1028;
      if(var12 != -1) {
         this.field114 = class28.method646(var12);
      } else {
         this.field114 = null;
      }

   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1086992200"
   )
   static final void method87(int var0, int var1) {
      if(client.field412 >= 2 || client.field531 != 0 || client.field444) {
         String var2;
         if(client.field531 == 1 && client.field412 < 2) {
            var2 = "Use" + " " + client.field424 + " " + "->";
         } else if(client.field444 && client.field412 < 2) {
            var2 = client.field428 + " " + client.field438 + " " + "->";
         } else {
            int var4 = client.field412 - 1;
            String var3;
            if(client.field328[var4].length() > 0) {
               var3 = client.field417[var4] + " " + client.field328[var4];
            } else {
               var3 = client.field417[var4];
            }

            var2 = var3;
         }

         if(client.field412 > 2) {
            var2 = var2 + class51.method1096(16777215) + " " + '/' + " " + (client.field412 - 2) + " more options";
         }

         class1.field25.method4140(var2, 4 + var0, var1 + 15, 16777215, 0, client.field282 / 1000);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-110"
   )
   static void method91() {
      class11.field156.clear();
      class11.field157.method3863();
      class11.field158.method3914();
      class11.field159 = 0;
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "([Lclass176;IIIZB)V",
      garbageValue = "-65"
   )
   static void method93(class176[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         class176 var6 = var0[var5];
         if(var6 != null && var6.field2836 == var1) {
            class77.method1689(var6, var2, var3, var4);
            class78.method1728(var6, var2, var3);
            if(var6.field2894 > var6.field2818 - var6.field2926) {
               var6.field2894 = var6.field2818 - var6.field2926;
            }

            if(var6.field2894 < 0) {
               var6.field2894 = 0;
            }

            if(var6.field2817 > var6.field2819 - var6.field2877) {
               var6.field2817 = var6.field2819 - var6.field2877;
            }

            if(var6.field2817 < 0) {
               var6.field2817 = 0;
            }

            if(var6.field2929 == 0) {
               client.method551(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;I)Ljava/lang/String;",
      garbageValue = "-802686913"
   )
   static String method94(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class151) {
         class151 var2 = (class151)var0;
         var1 = var2.field2288 + " | ";
         var0 = var2.field2287;
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
            if(null == var7) {
               var1 = var1 + "| " + var6;
               return var1;
            }

            int var8 = var7.indexOf(40);
            int var9 = var7.indexOf(41, var8 + 1);
            if(var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(var8 + 1, var9);
               int var11 = var10.indexOf(".java:");
               if(var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass89;[Lclass111;I)V",
      garbageValue = "1939025110"
   )
   static final void method95(class89 var0, class111[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class5.field78[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((class5.field78[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method2454(var3, var4);
                  }
               }
            }
         }
      }

      class5.field88 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field88 < -8) {
         class5.field88 = -8;
      }

      if(class5.field88 > 8) {
         class5.field88 = 8;
      }

      class5.field89 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field89 < -16) {
         class5.field89 = -16;
      }

      if(class5.field89 > 16) {
         class5.field89 = 16;
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var18;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var44 = class78.field1455[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = 768 * var9 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class5.field77[var2][1 + var12][var11] - class5.field77[var2][var12 - 1][var11];
               var14 = class5.field77[var2][var12][var11 + 1] - class5.field77[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(65536 + var13 * var13 + var14 * var14));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (-50 * var18 + var17 * -10 + -50 * var16) / var10 + 96;
               var20 = (var44[var12][var11] >> 1) + (var44[var12 - 1][var11] >> 2) + (var44[var12 + 1][var11] >> 3) + (var44[var12][var11 - 1] >> 2) + (var44[var12][1 + var11] >> 3);
               class161.field2650[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class189.field3053[var11] = 0;
            class19.field260[var11] = 0;
            class124.field2052[var11] = 0;
            class4.field67[var11] = 0;
            class182.field2964[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class5.field80[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     var16 = var14 - 1;
                     class43 var45 = (class43)class43.field995.method3817((long)var16);
                     class43 var46;
                     if(var45 != null) {
                        var46 = var45;
                     } else {
                        byte[] var47 = class43.field994.method3304(1, var16);
                        var45 = new class43();
                        if(null != var47) {
                           var45.method883(new class122(var47), var16);
                        }

                        var45.method890();
                        class43.field995.method3823(var45, (long)var16);
                        var46 = var45;
                     }

                     class189.field3053[var12] += var46.field997;
                     class19.field260[var12] += var46.field996;
                     class124.field2052[var12] += var46.field999;
                     class4.field67[var12] += var46.field1000;
                     ++class182.field2964[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class5.field80[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     var17 = var15 - 1;
                     class43 var54 = (class43)class43.field995.method3817((long)var17);
                     class43 var49;
                     if(null != var54) {
                        var49 = var54;
                     } else {
                        byte[] var48 = class43.field994.method3304(1, var17);
                        var54 = new class43();
                        if(var48 != null) {
                           var54.method883(new class122(var48), var17);
                        }

                        var54.method890();
                        class43.field995.method3823(var54, (long)var17);
                        var49 = var54;
                     }

                     class189.field3053[var12] -= var49.field997;
                     class19.field260[var12] -= var49.field996;
                     class124.field2052[var12] -= var49.field999;
                     class4.field67[var12] -= var49.field1000;
                     --class182.field2964[var12];
                  }
               }
            }

            if(var11 >= 1 && var11 < 103) {
               var12 = 0;
               var13 = 0;
               var14 = 0;
               var15 = 0;
               var16 = 0;

               for(var17 = -5; var17 < 109; ++var17) {
                  var18 = var17 + 5;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += class189.field3053[var18];
                     var13 += class19.field260[var18];
                     var14 += class124.field2052[var18];
                     var15 += class4.field67[var18];
                     var16 += class182.field2964[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class189.field3053[var19];
                     var13 -= class19.field260[var19];
                     var14 -= class124.field2052[var19];
                     var15 -= class4.field67[var19];
                     var16 -= class182.field2964[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!client.field277 || (class5.field78[0][var11][var17] & 2) != 0 || (class5.field78[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class5.field87) {
                        class5.field87 = var2;
                     }

                     var20 = class5.field80[var2][var11][var17] & 255;
                     int var21 = class5.field81[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class5.field77[var2][var11][var17];
                        int var23 = class5.field77[var2][var11 + 1][var17];
                        int var24 = class5.field77[var2][1 + var11][1 + var17];
                        int var25 = class5.field77[var2][var11][1 + var17];
                        int var26 = class161.field2650[var11][var17];
                        int var27 = class161.field2650[var11 + 1][var17];
                        int var28 = class161.field2650[1 + var11][1 + var17];
                        int var29 = class161.field2650[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class7.method104(var32, var33, var34);
                           var32 = var32 + class5.field88 & 255;
                           var34 += class5.field89;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class7.method104(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var52 = true;
                           if(var20 == 0 && class158.field2353[var2][var11][var17] != 0) {
                              var52 = false;
                           }

                           if(var21 > 0 && !class21.method563(var21 - 1).field1075) {
                              var52 = false;
                           }

                           if(var52 && var23 == var22 && var22 == var24 && var25 == var22) {
                              class33.field762[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class94.field1656[class117.method2507(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method2004(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class117.method2507(var30, var26), class117.method2507(var30, var27), class117.method2507(var30, var28), class117.method2507(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class158.field2353[var2][var11][var17] + 1;
                           byte var53 = class138.field2141[var2][var11][var17];
                           int var36 = var21 - 1;
                           class48 var37 = (class48)class48.field1072.method3817((long)var36);
                           class48 var35;
                           if(var37 != null) {
                              var35 = var37;
                           } else {
                              byte[] var50 = class48.field1083.method3304(4, var36);
                              var37 = new class48();
                              if(var50 != null) {
                                 var37.method995(new class122(var50), var36);
                              }

                              var37.method994();
                              class48.field1072.method3823(var37, (long)var36);
                              var35 = var37;
                           }

                           int var38 = var35.field1074;
                           int var39;
                           int var40;
                           int var41;
                           int var42;
                           if(var38 >= 0) {
                              var40 = class94.field1657.vmethod2253(var38);
                              var39 = -1;
                           } else if(var35.field1073 == 16711935) {
                              var39 = -2;
                              var38 = -1;
                              var40 = -2;
                           } else {
                              var39 = class7.method104(var35.field1077, var35.field1078, var35.field1080);
                              var41 = var35.field1077 + class5.field88 & 255;
                              var42 = class5.field89 + var35.field1080;
                              if(var42 < 0) {
                                 var42 = 0;
                              } else if(var42 > 255) {
                                 var42 = 255;
                              }

                              var40 = class7.method104(var41, var35.field1078, var42);
                           }

                           var41 = 0;
                           if(var40 != -2) {
                              var41 = class94.field1656[class146.method3041(var40, 96)];
                           }

                           if(var35.field1076 != -1) {
                              var42 = class5.field88 + var35.field1071 & 255;
                              int var43 = var35.field1082 + class5.field89;
                              if(var43 < 0) {
                                 var43 = 0;
                              } else if(var43 > 255) {
                                 var43 = 255;
                              }

                              var40 = class7.method104(var42, var35.field1081, var43);
                              var41 = class94.field1656[class146.method3041(var40, 96)];
                           }

                           var0.method2004(var2, var11, var17, var33, var53, var38, var22, var23, var24, var25, class117.method2507(var30, var26), class117.method2507(var30, var27), class117.method2507(var30, var28), class117.method2507(var30, var29), class146.method3041(var39, var26), class146.method3041(var39, var27), class146.method3041(var39, var28), class146.method3041(var39, var29), var32, var41);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var0.method2003(var2, var12, var11, class140.method2983(var2, var12, var11));
            }
         }

         class5.field80[var2] = null;
         class5.field81[var2] = null;
         class158.field2353[var2] = null;
         class138.field2141[var2] = null;
         class78.field1455[var2] = null;
      }

      var0.method2029(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class5.field78[1][var2][var3] & 2) == 2) {
               var0.method2001(var2, var3);
            }
         }
      }

      var2 = 1;
      var3 = 2;
      var4 = 4;

      for(var5 = 0; var5 < 4; ++var5) {
         if(var5 > 0) {
            var2 <<= 3;
            var3 <<= 3;
            var4 <<= 3;
         }

         for(int var6 = 0; var6 <= var5; ++var6) {
            for(int var7 = 0; var7 <= 104; ++var7) {
               for(int var8 = 0; var8 <= 104; ++var8) {
                  short var51;
                  if((class33.field762[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class33.field762[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class33.field762[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label568:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class33.field762[var11 - 1][var8][var13] & var2) == 0) {
                              break label568;
                           }
                        }

                        --var11;
                     }

                     label557:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class33.field762[var12 + 1][var8][var13] & var2) == 0) {
                              break label557;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (1 + (var10 - var9));
                     if(var13 >= 8) {
                        var51 = 240;
                        var15 = class5.field77[var12][var8][var9] - var51;
                        var16 = class5.field77[var11][var8][var9];
                        class89.method2109(var5, 1, 128 * var8, var8 * 128, var9 * 128, 128 * var10 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class33.field762[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class33.field762[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class33.field762[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class33.field762[var6][1 + var10][var7] & var3) != 0) {
                        ++var10;
                     }

                     label621:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class33.field762[var11 - 1][var13][var7] & var3) == 0) {
                              break label621;
                           }
                        }

                        --var11;
                     }

                     label610:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class33.field762[var12 + 1][var13][var7] & var3) == 0) {
                              break label610;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (var10 - var9 + 1);
                     if(var13 >= 8) {
                        var51 = 240;
                        var15 = class5.field77[var12][var9][var7] - var51;
                        var16 = class5.field77[var11][var9][var7];
                        class89.method2109(var5, 2, 128 * var9, 128 * var10 + 128, 128 * var7, 128 * var7, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class33.field762[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class33.field762[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class33.field762[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class33.field762[var6][var8][1 + var12] & var4) != 0) {
                        ++var12;
                     }

                     label674:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class33.field762[var6][var9 - 1][var13] & var4) == 0) {
                              break label674;
                           }
                        }

                        --var9;
                     }

                     label663:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class33.field762[var6][1 + var10][var13] & var4) == 0) {
                              break label663;
                           }
                        }

                        ++var10;
                     }

                     if((1 + (var10 - var9)) * (1 + (var12 - var11)) >= 4) {
                        var13 = class5.field77[var6][var9][var11];
                        class89.method2109(var5, 4, var9 * 128, 128 + 128 * var10, 128 * var11, 128 + var12 * 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class33.field762[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }
}
