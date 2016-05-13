import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class12 extends class85 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 278695137
   )
   int field175;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 987838465
   )
   int field176;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1406200345
   )
   int field177;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -713459725
   )
   int field178;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 4315861
   )
   int field179;
   @ObfuscatedName("o")
   class42 field181;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1820055323
   )
   int field182;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1875789419
   )
   int field184;
   @ObfuscatedName("l")
   static class173 field185;
   @ObfuscatedName("cy")
   static class224 field187;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2063426451
   )
   int field189;
   @ObfuscatedName("c")
   public static short[][] field190;

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIII)V",
      garbageValue = "-215501057"
   )
   @Export("generateMenuActionsForPlayer")
   static final void method155(class2 var0, int var1, int var2, int var3) {
      if(var0 != class106.field1881 && client.field496 < 400) {
         String var4;
         if(var0.field40 == 0) {
            var4 = var0.field50[0] + var0.field59 + var0.field50[1] + class10.method136(var0.field39, class106.field1881.field39) + " " + " (" + "level-" + var0.field39 + ")" + var0.field50[2];
         } else {
            var4 = var0.field50[0] + var0.field59 + var0.field50[1] + " " + " (" + "skill-" + var0.field40 + ")" + var0.field50[2];
         }

         int var5;
         if(client.field430 == 1) {
            class14.method175("Use", client.field431 + " " + "->" + " " + method163(16777215) + var4, 14, var1, var2, var3);
         } else if(client.field432) {
            if((class89.field1555 & 8) == 8) {
               class14.method175(client.field435, client.field436 + " " + "->" + " " + method163(16777215) + var4, 15, var1, var2, var3);
            }
         } else {
            for(var5 = 7; var5 >= 0; --var5) {
               if(client.field442[var5] != null) {
                  short var6 = 0;
                  if(client.field442[var5].equalsIgnoreCase("Attack")) {
                     if(client.field304 == class20.field567) {
                        continue;
                     }

                     if(client.field304 == class20.field565 || class20.field571 == client.field304 && var0.field39 > class106.field1881.field39) {
                        var6 = 2000;
                     }

                     if(0 != class106.field1881.field53 && var0.field53 != 0) {
                        if(var0.field53 == class106.field1881.field53) {
                           var6 = 2000;
                        } else {
                           var6 = 0;
                        }
                     }
                  } else if(client.field294[var5]) {
                     var6 = 2000;
                  }

                  boolean var7 = false;
                  int var8 = var6 + client.field405[var5];
                  class14.method175(client.field442[var5], method163(16777215) + var4, var8, var1, var2, var3);
               }
            }
         }

         for(var5 = 0; var5 < client.field496; ++var5) {
            if(client.field422[var5] == 23) {
               client.field425[var5] = method163(16777215) + var4;
               break;
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass167;I)V",
      garbageValue = "2065409792"
   )
   public static void method156(class167 var0) {
      class50.field1102 = var0;
   }

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLclass85;)V",
      garbageValue = "1"
   )
   class12(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, class85 var9) {
      this.field184 = var1;
      this.field176 = var2;
      this.field177 = var3;
      this.field179 = var4;
      this.field175 = var5;
      this.field189 = var6;
      if(var7 != -1) {
         this.field181 = class4.method42(var7);
         this.field182 = 0;
         this.field178 = client.field335 - 1;
         if(this.field181.field988 == 0 && null != var9 && var9 instanceof class12) {
            class12 var10 = (class12)var9;
            if(var10.field181 == this.field181) {
               this.field182 = var10.field182;
               this.field178 = var10.field178;
               return;
            }
         }

         if(-1 != this.field181.field991) {
            this.field182 = (int)(Math.random() * (double)this.field181.field986.length);
            this.field178 -= (int)(Math.random() * (double)this.field181.field999[this.field182]);
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lclass105;",
      garbageValue = "1"
   )
   protected final class105 vmethod1888() {
      if(null != this.field181) {
         int var1 = client.field335 - this.field178;
         if(var1 > 100 && this.field181.field991 > 0) {
            var1 = 100;
         }

         label47: {
            do {
               do {
                  if(var1 <= this.field181.field999[this.field182]) {
                     break label47;
                  }

                  var1 -= this.field181.field999[this.field182];
                  ++this.field182;
               } while(this.field182 < this.field181.field986.length);

               this.field182 -= this.field181.field991;
            } while(this.field182 >= 0 && this.field182 < this.field181.field986.length);

            this.field181 = null;
         }

         this.field178 = client.field335 - var1;
      }

      class40 var12 = class9.method120(this.field184);
      if(var12.field965 != null) {
         var12 = var12.method783();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(1 != this.field177 && this.field177 != 3) {
            var2 = var12.field939;
            var3 = var12.field966;
         } else {
            var2 = var12.field966;
            var3 = var12.field939;
         }

         int var4 = (var2 >> 1) + this.field175;
         int var5 = (var2 + 1 >> 1) + this.field175;
         int var6 = this.field189 + (var3 >> 1);
         int var7 = (1 + var3 >> 1) + this.field189;
         int[][] var8 = class5.field93[this.field179];
         int var9 = var8[var5][var7] + var8[var5][var6] + var8[var4][var6] + var8[var4][var7] >> 2;
         int var10 = (var2 << 6) + (this.field175 << 7);
         int var11 = (var3 << 6) + (this.field189 << 7);
         return var12.method796(this.field176, this.field177, var8, var10, var9, var11, this.field181, this.field182);
      }
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-2098524811"
   )
   static final void method160(int var0, int var1, int var2, int var3) {
      if(client.field430 == 0 && !client.field432) {
         class14.method175("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class105.field1808; ++var6) {
         var7 = class105.field1867[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var7 != var5) {
            var5 = var7;
            if(var10 == 2 && client.field339.method1925(class21.field581, var8, var9, var7) >= 0) {
               class40 var12 = class9.method120(var11);
               if(var12.field965 != null) {
                  var12 = var12.method783();
               }

               if(var12 == null) {
                  continue;
               }

               if(client.field430 == 1) {
                  class14.method175("Use", client.field431 + " " + "->" + " " + method163('\uffff') + var12.field934, 1, var7, var8, var9);
               } else if(client.field432) {
                  if(4 == (class89.field1555 & 4)) {
                     class14.method175(client.field435, client.field436 + " " + "->" + " " + method163('\uffff') + var12.field934, 2, var7, var8, var9);
                  }
               } else {
                  String[] var13 = var12.field962;
                  if(client.field448) {
                     var13 = class49.method976(var13);
                  }

                  if(null != var13) {
                     for(int var14 = 4; var14 >= 0; --var14) {
                        if(null != var13[var14]) {
                           short var15 = 0;
                           if(0 == var14) {
                              var15 = 3;
                           }

                           if(var14 == 1) {
                              var15 = 4;
                           }

                           if(var14 == 2) {
                              var15 = 5;
                           }

                           if(3 == var14) {
                              var15 = 6;
                           }

                           if(4 == var14) {
                              var15 = 1001;
                           }

                           class14.method175(var13[var14], method163('\uffff') + var12.field934, var15, var7, var8, var9);
                        }
                     }
                  }

                  class14.method175("Examine", method163('\uffff') + var12.field934, 1002, var12.field931 << 14, var8, var9);
               }
            }

            int var16;
            class2 var24;
            int var25;
            class34 var26;
            int[] var28;
            if(1 == var10) {
               class34 var17 = client.field515[var11];
               if(null == var17) {
                  continue;
               }

               if(var17.field782.field887 == 1 && (var17.field823 & 127) == 64 && (var17.field813 & 127) == 64) {
                  for(var25 = 0; var25 < client.field317; ++var25) {
                     var26 = client.field515[client.field318[var25]];
                     if(null != var26 && var26 != var17 && 1 == var26.field782.field887 && var17.field823 == var26.field823 && var17.field813 == var26.field813) {
                        class161.method3167(var26.field782, client.field318[var25], var8, var9);
                     }
                  }

                  var25 = class32.field755;
                  var28 = class32.field756;

                  for(var16 = 0; var16 < var25; ++var16) {
                     var24 = client.field491[var28[var16]];
                     if(null != var24 && var17.field823 == var24.field823 && var17.field813 == var24.field813) {
                        method155(var24, var28[var16], var8, var9);
                     }
                  }
               }

               class161.method3167(var17.field782, var11, var8, var9);
            }

            if(0 == var10) {
               class2 var27 = client.field491[var11];
               if(var27 == null) {
                  continue;
               }

               if(64 == (var27.field823 & 127) && 64 == (var27.field813 & 127)) {
                  for(var25 = 0; var25 < client.field317; ++var25) {
                     var26 = client.field515[client.field318[var25]];
                     if(var26 != null && 1 == var26.field782.field887 && var27.field823 == var26.field823 && var26.field813 == var27.field813) {
                        class161.method3167(var26.field782, client.field318[var25], var8, var9);
                     }
                  }

                  var25 = class32.field755;
                  var28 = class32.field756;

                  for(var16 = 0; var16 < var25; ++var16) {
                     var24 = client.field491[var28[var16]];
                     if(var24 != null && var27 != var24 && var27.field823 == var24.field823 && var24.field813 == var27.field813) {
                        method155(var24, var28[var16], var8, var9);
                     }
                  }
               }

               if(client.field409 != var11) {
                  method155(var27, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(3 == var10) {
               class199 var29 = client.field345[class21.field581][var8][var9];
               if(var29 != null) {
                  for(class28 var18 = (class28)var29.method3831(); var18 != null; var18 = (class28)var29.method3814()) {
                     class51 var19 = class9.method128(var18.field686);
                     if(1 == client.field430) {
                        class14.method175("Use", client.field431 + " " + "->" + " " + method163(16748608) + var19.field1128, 16, var18.field686, var8, var9);
                     } else if(client.field432) {
                        if(1 == (class89.field1555 & 1)) {
                           class14.method175(client.field435, client.field436 + " " + "->" + " " + method163(16748608) + var19.field1128, 17, var18.field686, var8, var9);
                        }
                     } else {
                        String[] var20 = var19.field1130;
                        if(client.field448) {
                           var20 = class49.method976(var20);
                        }

                        for(int var21 = 4; var21 >= 0; --var21) {
                           if(var20 != null && var20[var21] != null) {
                              byte var22 = 0;
                              if(0 == var21) {
                                 var22 = 18;
                              }

                              if(var21 == 1) {
                                 var22 = 19;
                              }

                              if(var21 == 2) {
                                 var22 = 20;
                              }

                              if(var21 == 3) {
                                 var22 = 21;
                              }

                              if(4 == var21) {
                                 var22 = 22;
                              }

                              class14.method175(var20[var21], method163(16748608) + var19.field1128, var22, var18.field686, var8, var9);
                           } else if(2 == var21) {
                              class14.method175("Take", method163(16748608) + var19.field1128, 20, var18.field686, var8, var9);
                           }
                        }

                        class14.method175("Examine", method163(16748608) + var19.field1128, 1004, var18.field686, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         class2 var23 = client.field491[client.field409];
         method155(var23, client.field409, var6, var7);
      }

   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "2"
   )
   @Export("groundItemSpawned")
   static final void method161(int var0, int var1) {
      class199 var2 = client.field345[class21.field581][var0][var1];
      if(null == var2) {
         client.field339.method1996(class21.field581, var0, var1);
      } else {
         long var3 = -99999999L;
         class28 var5 = null;

         class28 var6;
         for(var6 = (class28)var2.method3812(); var6 != null; var6 = (class28)var2.method3817()) {
            class51 var7 = class9.method128(var6.field686);
            long var8 = (long)var7.field1111;
            if(1 == var7.field1127) {
               var8 *= (long)(1 + var6.field680);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            client.field339.method1996(class21.field581, var0, var1);
         } else {
            var2.method3808(var5);
            class28 var10 = null;
            class28 var11 = null;

            for(var6 = (class28)var2.method3812(); var6 != null; var6 = (class28)var2.method3817()) {
               if(var5.field686 != var6.field686) {
                  if(null == var10) {
                     var10 = var6;
                  }

                  if(var6.field686 != var10.field686 && null == var11) {
                     var11 = var6;
                  }
               }
            }

            int var9 = 1610612736 + var0 + (var1 << 7);
            client.field339.method1917(class21.field581, var0, var1, class107.method2369(128 * var0 + 64, var1 * 128 + 64, class21.field581), var5, var9, var10, var11);
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-65"
   )
   public static synchronized long method162() {
      long var0 = System.currentTimeMillis();
      if(var0 < class115.field1986) {
         class115.field1983 += class115.field1986 - var0;
      }

      class115.field1986 = var0;
      return var0 + class115.field1983;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "16776960"
   )
   static String method163(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }
}
