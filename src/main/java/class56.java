import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public class class56 {
   @ObfuscatedName("s")
   public static boolean field1173;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -941463199
   )
   public static int field1174;
   @ObfuscatedName("at")
   class66[] field1176 = new class66[8];
   @ObfuscatedName("n")
   class66 field1177;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 274452005
   )
   int field1178 = 32;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -441584457
   )
   int field1179;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1186211563
   )
   int field1180;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2019328419
   )
   int field1181;
   @ObfuscatedName("j")
   int[] field1182;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 4918589655481448397L
   )
   long field1183 = 0L;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1353965733
   )
   int field1184 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -468695443
   )
   public static int field1185;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -639116871
   )
   int field1186 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 5710137329416353919L
   )
   long field1187 = 0L;
   @ObfuscatedName("d")
   boolean field1188 = true;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 293217361
   )
   int field1191 = 0;
   @ObfuscatedName("aw")
   class66[] field1192 = new class66[8];
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -4252485475618770901L
   )
   long field1193 = class18.method214();
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1786711607
   )
   int field1195 = 0;

   @ObfuscatedName("k")
   public final synchronized void method1193(class66 var1) {
      this.field1177 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "125"
   )
   public final synchronized void method1194() {
      if(this.field1182 != null) {
         long var1 = class18.method214();

         try {
            if(this.field1183 != 0L) {
               if(var1 < this.field1183) {
                  return;
               }

               this.vmethod1545(this.field1180);
               this.field1183 = 0L;
               this.field1188 = true;
            }

            int var3 = this.vmethod1542();
            if(this.field1186 - var3 > this.field1184) {
               this.field1184 = this.field1186 - var3;
            }

            int var4 = this.field1181 + this.field1179;
            if(256 + var4 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1180) {
               this.field1180 += 1024;
               if(this.field1180 > 16384) {
                  this.field1180 = 16384;
               }

               this.vmethod1547();
               this.vmethod1545(this.field1180);
               var3 = 0;
               this.field1188 = true;
               if(var4 + 256 > this.field1180) {
                  var4 = this.field1180 - 256;
                  this.field1179 = var4 - this.field1181;
               }
            }

            while(var3 < var4) {
               this.method1210(this.field1182, 256);
               this.vmethod1546();
               var3 += 256;
            }

            if(var1 > this.field1187) {
               if(!this.field1188) {
                  if(0 == this.field1184 && this.field1195 == 0) {
                     this.vmethod1547();
                     this.field1183 = var1 + 2000L;
                     return;
                  }

                  this.field1179 = Math.min(this.field1195, this.field1184);
                  this.field1195 = this.field1184;
               } else {
                  this.field1188 = false;
               }

               this.field1184 = 0;
               this.field1187 = var1 + 2000L;
            }

            this.field1186 = var3;
         } catch (Exception var6) {
            this.vmethod1547();
            this.field1183 = var1 + 2000L;
         }

         try {
            if(var1 > this.field1193 + 500000L) {
               var1 = this.field1193;
            }

            while(var1 > this.field1193 + 5000L) {
               this.method1198(256);
               this.field1193 += (long)(256000 / field1185);
            }
         } catch (Exception var5) {
            this.field1193 = var1;
         }

      }
   }

   @ObfuscatedName("ad")
   public final void method1195() {
      this.field1188 = true;
   }

   @ObfuscatedName("at")
   public final synchronized void method1196() {
      this.field1188 = true;

      try {
         this.vmethod1548();
      } catch (Exception var2) {
         this.vmethod1547();
         this.field1183 = class18.method214() + 2000L;
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1909340306"
   )
   public final synchronized void method1197() {
      if(null != class221.field3176) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(class221.field3176.field1349[var2] == this) {
               class221.field3176.field1349[var2] = null;
            }

            if(class221.field3176.field1349[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            class221.field3176.field1353 = true;

            while(class221.field3176.field1354) {
               class103.method2301(50L);
            }

            class221.field3176 = null;
         }
      }

      this.vmethod1547();
      this.field1182 = null;
   }

   @ObfuscatedName("ax")
   final void method1198(int var1) {
      this.field1191 -= var1;
      if(this.field1191 < 0) {
         this.field1191 = 0;
      }

      if(null != this.field1177) {
         this.field1177.vmethod3765(var1);
      }

   }

   @ObfuscatedName("ac")
   final void method1200(class66 var1, int var2) {
      int var3 = var2 >> 5;
      class66 var4 = this.field1192[var3];
      if(var4 == null) {
         this.field1176[var3] = var1;
      } else {
         var4.field1265 = var1;
      }

      this.field1192[var3] = var1;
      var1.field1264 = var2;
   }

   @ObfuscatedName("a")
   void vmethod1563() throws Exception {
   }

   @ObfuscatedName("f")
   int vmethod1542() throws Exception {
      return this.field1180;
   }

   @ObfuscatedName("s")
   void vmethod1546() throws Exception {
   }

   @ObfuscatedName("y")
   void vmethod1547() {
   }

   @ObfuscatedName("e")
   void vmethod1548() throws Exception {
   }

   @ObfuscatedName("ak")
   final void method1210(int[] var1, int var2) {
      int var3 = var2;
      if(field1173) {
         var3 = var2 << 1;
      }

      class119.method2718(var1, 0, var3);
      this.field1191 -= var2;
      if(this.field1177 != null && this.field1191 <= 0) {
         this.field1191 += field1185 >> 4;
         class98.method2216(this.field1177);
         this.method1200(this.field1177, this.field1177.vmethod1487());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class66 var10;
         label143:
         for(var6 = 7; 0 != var5; --var6) {
            int var7;
            int var8;
            if(var6 < 0) {
               var7 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var7 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if(0 != (var9 & 1)) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  class66 var11 = this.field1176[var7];

                  label137:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label137;
                        }

                        class65 var12 = var11.field1266;
                        if(var12 != null && var12.field1262 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1265;
                        } else {
                           var11.field1263 = true;
                           int var13 = var11.vmethod3770();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1262 += var13;
                           }

                           if(var4 >= this.field1178) {
                              break label143;
                           }

                           class66 var14 = var11.vmethod3767();
                           if(null != var14) {
                              for(int var15 = var11.field1264; var14 != null; var14 = var11.vmethod3752()) {
                                 this.method1200(var14, var15 * var14.vmethod1487() >> 8);
                              }
                           }

                           class66 var18 = var11.field1265;
                           var11.field1265 = null;
                           if(null == var10) {
                              this.field1176[var7] = var18;
                           } else {
                              var10.field1265 = var18;
                           }

                           if(var18 == null) {
                              this.field1192[var7] = var10;
                           }

                           var11 = var18;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class66 var16 = this.field1176[var6];
            class66[] var17 = this.field1176;
            this.field1192[var6] = null;

            for(var17[var6] = null; null != var16; var16 = var10) {
               var10 = var16.field1265;
               var16.field1265 = null;
            }
         }
      }

      if(this.field1191 < 0) {
         this.field1191 = 0;
      }

      if(null != this.field1177) {
         this.field1177.vmethod3779(var1, 0, var2);
      }

      this.field1193 = class18.method214();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1164371349"
   )
   static final void method1229(int var0, int var1, int var2, int var3) {
      ++client.field399;
      class26.method634(class33.field776);
      boolean var4 = false;
      int var5;
      int var7;
      if(client.field521 >= 0) {
         var5 = class32.field774;
         int[] var6 = class32.field759;

         for(var7 = 0; var7 < var5; ++var7) {
            if(client.field521 == var6[var7]) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class26.method634(class33.field783);
      }

      class74.method1628(true);
      class26.method634(var4?class33.field778:class33.field777);
      class74.method1628(false);

      for(class6 var16 = (class6)client.field385.method3860(); null != var16; var16 = (class6)client.field385.method3861()) {
         if(var16.field96 == class48.field1078 && client.field303 <= var16.field102) {
            if(client.field303 >= var16.field122) {
               if(var16.field105 > 0) {
                  class34 var17 = client.field358[var16.field105 - 1];
                  if(var17 != null && var17.field870 >= 0 && var17.field870 < 13312 && var17.field813 >= 0 && var17.field813 < 13312) {
                     var16.method103(var17.field870, var17.field813, class4.method52(var17.field870, var17.field813, var16.field96) - var16.field100, client.field303);
                  }
               }

               if(var16.field105 < 0) {
                  var7 = -var16.field105 - 1;
                  class2 var18;
                  if(client.field416 == var7) {
                     var18 = class151.field2253;
                  } else {
                     var18 = client.field415[var7];
                  }

                  if(null != var18 && var18.field870 >= 0 && var18.field870 < 13312 && var18.field813 >= 0 && var18.field813 < 13312) {
                     var16.method103(var18.field870, var18.field813, class4.method52(var18.field870, var18.field813, var16.field96) - var16.field100, client.field303);
                  }
               }

               var16.method104(client.field409);
               class77.field1396.method1968(class48.field1078, (int)var16.field113, (int)var16.field108, (int)var16.field109, 60, var16, var16.field115, -1, false);
            }
         } else {
            var16.method3946();
         }
      }

      class151.method3162();
      class12.method175(var0, var1, var2, var3, true);
      var0 = client.field557;
      var1 = client.field558;
      var2 = client.field559;
      var3 = client.field560;
      class79.method1852(var0, var1, var2 + var0, var3 + var1);
      class90.method2153();
      int var19;
      if(!client.field542) {
         var5 = client.field554;
         if(client.field387 / 256 > var5) {
            var5 = client.field387 / 256;
         }

         if(client.field390[4] && 128 + client.field511[4] > var5) {
            var5 = 128 + client.field511[4];
         }

         var19 = client.field360 + client.field495 & 2047;
         class139.method2980(class151.field2251, class4.method52(class151.field2253.field870, class151.field2253.field813, class48.field1078) - client.field333, class118.field1984, var5, var19, var5 * 3 + 600);
      }

      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var15;
      if(!client.field542) {
         if(class89.field1548.field131) {
            var19 = class48.field1078;
         } else {
            label419: {
               var7 = 3;
               if(class15.field219 < 310) {
                  var8 = class44.field1037 >> 7;
                  var9 = class17.field254 >> 7;
                  var10 = class151.field2253.field870 >> 7;
                  var11 = class151.field2253.field813 >> 7;
                  if(var8 < 0 || var9 < 0 || var8 >= 104 || var9 >= 104) {
                     var19 = class48.field1078;
                     break label419;
                  }

                  if((class5.field90[class48.field1078][var8][var9] & 4) != 0) {
                     var7 = class48.field1078;
                  }

                  if(var10 > var8) {
                     var12 = var10 - var8;
                  } else {
                     var12 = var8 - var10;
                  }

                  if(var11 > var9) {
                     var13 = var11 - var9;
                  } else {
                     var13 = var9 - var11;
                  }

                  int var14;
                  if(var12 > var13) {
                     var14 = var13 * 65536 / var12;
                     var15 = '耀';

                     while(var10 != var8) {
                        if(var8 < var10) {
                           ++var8;
                        } else if(var8 > var10) {
                           --var8;
                        }

                        if(0 != (class5.field90[class48.field1078][var8][var9] & 4)) {
                           var7 = class48.field1078;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var9 < var11) {
                              ++var9;
                           } else if(var9 > var11) {
                              --var9;
                           }

                           if((class5.field90[class48.field1078][var8][var9] & 4) != 0) {
                              var7 = class48.field1078;
                           }
                        }
                     }
                  } else {
                     var14 = 65536 * var12 / var13;
                     var15 = '耀';

                     while(var9 != var11) {
                        if(var9 < var11) {
                           ++var9;
                        } else if(var9 > var11) {
                           --var9;
                        }

                        if(0 != (class5.field90[class48.field1078][var8][var9] & 4)) {
                           var7 = class48.field1078;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var8 < var10) {
                              ++var8;
                           } else if(var8 > var10) {
                              --var8;
                           }

                           if((class5.field90[class48.field1078][var8][var9] & 4) != 0) {
                              var7 = class48.field1078;
                           }
                        }
                     }
                  }
               }

               if(class151.field2253.field870 >= 0 && class151.field2253.field813 >= 0 && class151.field2253.field870 < 13312 && class151.field2253.field813 < 13312) {
                  if(0 != (class5.field90[class48.field1078][class151.field2253.field870 >> 7][class151.field2253.field813 >> 7] & 4)) {
                     var7 = class48.field1078;
                  }

                  var19 = var7;
               } else {
                  var19 = class48.field1078;
               }
            }
         }

         var5 = var19;
      } else {
         var5 = class153.method3171();
      }

      var19 = class44.field1037;
      var7 = class30.field713;
      var8 = class17.field254;
      var9 = class15.field219;
      var10 = class13.field193;

      for(var11 = 0; var11 < 5; ++var11) {
         if(client.field390[var11]) {
            var12 = (int)(Math.random() * (double)(1 + 2 * client.field425[var11]) - (double)client.field425[var11] + Math.sin((double)client.field422[var11] * ((double)client.field547[var11] / 100.0D)) * (double)client.field511[var11]);
            if(0 == var11) {
               class44.field1037 += var12;
            }

            if(var11 == 1) {
               class30.field713 += var12;
            }

            if(var11 == 2) {
               class17.field254 += var12;
            }

            if(3 == var11) {
               class13.field193 = var12 + class13.field193 & 2047;
            }

            if(4 == var11) {
               class15.field219 += var12;
               if(class15.field219 < 128) {
                  class15.field219 = 128;
               }

               if(class15.field219 > 383) {
                  class15.field219 = 383;
               }
            }
         }
      }

      var11 = class139.field2140;
      var12 = class139.field2135;
      if(class139.field2145 != 0) {
         var11 = class139.field2146;
         var12 = class139.field2147;
      }

      if(var11 >= var0 && var11 < var2 + var0 && var12 >= var1 && var12 < var1 + var3) {
         class104.field1795 = true;
         class104.field1844 = 0;
         class104.field1842 = var11 - var0;
         class104.field1843 = var12 - var1;
      } else {
         class104.field1795 = false;
         class104.field1844 = 0;
      }

      class10.method146();
      class79.method1830(var0, var1, var2, var3, 0);
      class10.method146();
      var13 = class90.field1562;
      class90.field1562 = client.field347;
      class77.field1396.method1960(class44.field1037, class30.field713, class17.field254, class15.field219, class13.field193, var5);
      class90.field1562 = var13;
      class10.method146();
      class77.field1396.method1936();
      class8.method121(var0, var1, var2, var3);
      if(2 == client.field311) {
         class59.method1289((client.field418 - class147.field2214 << 7) + client.field289, client.field318 + (client.field315 - class17.field257 << 7), client.field316 * 2);
         if(client.field400 * -1 > -1 && client.field303 % 20 < 10) {
            client.field370[0].method1805(client.field400 * -1 + var0 - 12, var1 + client.field401 * -1 - 28);
         }
      }

      ((class94)class90.field1574).method2209(client.field409);
      class46.method984();
      class44.field1037 = var19;
      class30.field713 = var7;
      class17.field254 = var8;
      class15.field219 = var9;
      class13.field193 = var10;
      if(client.field426) {
         byte var20 = 0;
         var15 = var20 + class170.field2717 + class170.field2725;
         if(var15 == 0) {
            client.field426 = false;
         }
      }

      if(client.field426) {
         class79.method1830(var0, var1, var2, var3, 0);
         class185.method3778("Loading - please wait.", false);
      }

   }

   @ObfuscatedName("r")
   void vmethod1545(int var1) throws Exception {
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "-16"
   )
   static void method1241(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class165.field2655; ++var4) {
         class51 var5 = class75.method1648(var4);
         if((!var1 || var5.field1132) && -1 == var5.field1120 && var5.field1115.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class31.field751 = -1;
               class101.field1757 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[2 * var2.length];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class101.field1757 = var2;
      class38.field879 = 0;
      class31.field751 = var3;
      String[] var8 = new String[class31.field751];

      for(int var9 = 0; var9 < class31.field751; ++var9) {
         var8[var9] = class75.method1648(var2[var9]).field1115;
      }

      short[] var10 = class101.field1757;
      class75.method1671(var8, var10, 0, var8.length - 1);
   }
}
