import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public class class56 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -603026819
   )
   int field1186;
   @ObfuscatedName("ax")
   class66[] field1187 = new class66[8];
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1169803463
   )
   static int field1188;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 9189784817390840565L
   )
   long field1190 = class130.method2846();
   @ObfuscatedName("g")
   int[] field1191;
   @ObfuscatedName("s")
   class66 field1192;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1331129261
   )
   int field1193 = 32;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = -5546788892085683555L
   )
   long field1194 = 0L;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1044558525
   )
   public static int field1196;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1524447237
   )
   int field1197;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 3275352765763985421L
   )
   long field1198 = 0L;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 44495387
   )
   int field1199 = 0;
   @ObfuscatedName("b")
   static boolean field1200;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1360105645
   )
   int field1201 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1095638927
   )
   int field1202;
   @ObfuscatedName("y")
   boolean field1203 = true;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1994399017
   )
   int field1205 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1844186265
   )
   int field1206 = 0;
   @ObfuscatedName("ao")
   class66[] field1207 = new class66[8];

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2129710110"
   )
   public final void method1237() {
      this.field1203 = true;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lclass66;I)V",
      garbageValue = "851508323"
   )
   public final synchronized void method1238(class66 var1) {
      this.field1192 = var1;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "769417902"
   )
   public final synchronized void method1241() {
      this.field1203 = true;

      try {
         this.vmethod1562();
      } catch (Exception var2) {
         this.vmethod1567();
         this.field1198 = class130.method2846() + 2000L;
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1244(int[] var1, int var2) {
      int var3 = var2;
      if(field1200) {
         var3 = var2 << 1;
      }

      class120.method2748(var1, 0, var3);
      this.field1205 -= var2;
      if(this.field1192 != null && this.field1205 <= 0) {
         this.field1205 += field1196 >> 4;
         class40.method876(this.field1192);
         this.method1245(this.field1192, this.field1192.vmethod1519());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class66 var10;
         label146:
         for(var6 = 7; var5 != 0; --var6) {
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
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  class66 var11 = this.field1187[var7];

                  label140:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label140;
                        }

                        class65 var12 = var11.field1281;
                        if(null != var12 && var12.field1278 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1280;
                        } else {
                           var11.field1282 = true;
                           int var13 = var11.vmethod3753();
                           var4 += var13;
                           if(null != var12) {
                              var12.field1278 += var13;
                           }

                           if(var4 >= this.field1193) {
                              break label146;
                           }

                           class66 var14 = var11.vmethod3760();
                           if(var14 != null) {
                              for(int var15 = var11.field1279; null != var14; var14 = var11.vmethod3752()) {
                                 this.method1245(var14, var15 * var14.vmethod1519() >> 8);
                              }
                           }

                           class66 var17 = var11.field1280;
                           var11.field1280 = null;
                           if(null == var10) {
                              this.field1187[var7] = var17;
                           } else {
                              var10.field1280 = var17;
                           }

                           if(var17 == null) {
                              this.field1207[var7] = var10;
                           }

                           var11 = var17;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class66 var16 = this.field1187[var6];
            class66[] var18 = this.field1187;
            this.field1207[var6] = null;

            for(var18[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1280;
               var16.field1280 = null;
            }
         }
      }

      if(this.field1205 < 0) {
         this.field1205 = 0;
      }

      if(null != this.field1192) {
         this.field1192.vmethod3764(var1, 0, var2);
      }

      this.field1190 = class130.method2846();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lclass66;II)V",
      garbageValue = "-2108111358"
   )
   final void method1245(class66 var1, int var2) {
      int var3 = var2 >> 5;
      class66 var4 = this.field1207[var3];
      if(var4 == null) {
         this.field1187[var3] = var1;
      } else {
         var4.field1280 = var1;
      }

      this.field1207[var3] = var1;
      var1.field1279 = var2;
   }

   @ObfuscatedName("f")
   void vmethod1576(Component var1) throws Exception {
   }

   @ObfuscatedName("u")
   void vmethod1575(int var1) throws Exception {
   }

   @ObfuscatedName("b")
   void vmethod1566() throws Exception {
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "4217"
   )
   final void method1250(int var1) {
      this.field1205 -= var1;
      if(this.field1205 < 0) {
         this.field1205 = 0;
      }

      if(this.field1192 != null) {
         this.field1192.vmethod3755(var1);
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1494482129"
   )
   public final synchronized void method1251() {
      if(this.field1191 != null) {
         long var1 = class130.method2846();

         try {
            if(0L != this.field1198) {
               if(var1 < this.field1198) {
                  return;
               }

               this.vmethod1575(this.field1202);
               this.field1198 = 0L;
               this.field1203 = true;
            }

            int var3 = this.vmethod1585();
            if(this.field1201 - var3 > this.field1199) {
               this.field1199 = this.field1201 - var3;
            }

            int var4 = this.field1197 + this.field1186;
            if(256 + var4 > 16384) {
               var4 = 16128;
            }

            if(256 + var4 > this.field1202) {
               this.field1202 += 1024;
               if(this.field1202 > 16384) {
                  this.field1202 = 16384;
               }

               this.vmethod1567();
               this.vmethod1575(this.field1202);
               var3 = 0;
               this.field1203 = true;
               if(256 + var4 > this.field1202) {
                  var4 = this.field1202 - 256;
                  this.field1186 = var4 - this.field1197;
               }
            }

            while(var3 < var4) {
               this.method1244(this.field1191, 256);
               this.vmethod1566();
               var3 += 256;
            }

            if(var1 > this.field1194) {
               if(!this.field1203) {
                  if(this.field1199 == 0 && this.field1206 == 0) {
                     this.vmethod1567();
                     this.field1198 = var1 + 2000L;
                     return;
                  }

                  this.field1186 = Math.min(this.field1206, this.field1199);
                  this.field1206 = this.field1199;
               } else {
                  this.field1203 = false;
               }

               this.field1199 = 0;
               this.field1194 = var1 + 2000L;
            }

            this.field1201 = var3;
         } catch (Exception var7) {
            this.vmethod1567();
            this.field1198 = 2000L + var1;
         }

         try {
            if(var1 > this.field1190 + 500000L) {
               var1 = this.field1190;
            }

            while(var1 > this.field1190 + 5000L) {
               this.method1250(256);
               this.field1190 += (long)(256000 / field1196);
            }
         } catch (Exception var6) {
            this.field1190 = var1;
         }

      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1697527658"
   )
   public final synchronized void method1253() {
      if(null != class38.field888) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == class38.field888.field1364[var2]) {
               class38.field888.field1364[var2] = null;
            }

            if(null != class38.field888.field1364[var2]) {
               var1 = false;
            }
         }

         if(var1) {
            class38.field888.field1365 = true;

            while(class38.field888.field1369) {
               class98.method2264(50L);
            }

            class38.field888 = null;
         }
      }

      this.vmethod1567();
      this.field1191 = null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1091417312"
   )
   static final int method1266(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("d")
   void vmethod1562() throws Exception {
   }

   @ObfuscatedName("l")
   void vmethod1567() {
   }

   @ObfuscatedName("x")
   int vmethod1585() throws Exception {
      return this.field1202;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Lclass35;",
      garbageValue = "-213439382"
   )
   static class35 method1289(int var0, int var1) {
      class27 var2 = (class27)class11.field178.get(Integer.valueOf(var0));
      return var2.method681(var1);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "13997399"
   )
   static final void method1291() {
      boolean var0 = false;

      int var1;
      int var10;
      while(!var0) {
         var0 = true;

         for(var1 = 0; var1 < client.field429 - 1; ++var1) {
            if(client.field329[var1] < 1000 && client.field329[var1 + 1] > 1000) {
               String var2 = client.field435[var1];
               client.field435[var1] = client.field435[var1 + 1];
               client.field435[1 + var1] = var2;
               String var9 = client.field459[var1];
               client.field459[var1] = client.field459[1 + var1];
               client.field459[1 + var1] = var9;
               var10 = client.field329[var1];
               client.field329[var1] = client.field329[1 + var1];
               client.field329[1 + var1] = var10;
               var10 = client.field434[var1];
               client.field434[var1] = client.field434[var1 + 1];
               client.field434[1 + var1] = var10;
               var10 = client.field431[var1];
               client.field431[var1] = client.field431[1 + var1];
               client.field431[1 + var1] = var10;
               var10 = client.field433[var1];
               client.field433[var1] = client.field433[var1 + 1];
               client.field433[1 + var1] = var10;
               var0 = false;
            }
         }
      }

      if(class167.field2675 == null) {
         if(client.field428 == null) {
            int var12 = class140.field2156;
            int var3;
            int var6;
            int var11;
            int var13;
            if(client.field310) {
               if(var12 != 1 && (class148.field2224 || var12 != 4)) {
                  var1 = class140.field2146;
                  var11 = class140.field2151;
                  if(var1 < class37.field881 - 10 || var1 > 10 + class37.field881 + class39.field931 || var11 < class19.field284 - 10 || var11 > class19.field284 + class33.field774 + 10) {
                     client.field310 = false;
                     class26.method672(class37.field881, class19.field284, class39.field931, class33.field774);
                  }
               }

               if(var12 == 1 || !class148.field2224 && var12 == 4) {
                  var1 = class37.field881;
                  var11 = class19.field284;
                  var3 = class39.field931;
                  var10 = class140.field2161;
                  var13 = class140.field2158;
                  var6 = -1;

                  for(int var7 = 0; var7 < client.field429; ++var7) {
                     int var8 = var11 + 31 + 15 * (client.field429 - 1 - var7);
                     if(var10 > var1 && var10 < var3 + var1 && var13 > var8 - 13 && var13 < var8 + 3) {
                        var6 = var7;
                     }
                  }

                  if(var6 != -1) {
                     class11.method157(var6);
                  }

                  client.field310 = false;
                  class26.method672(class37.field881, class19.field284, class39.field931, class33.field774);
               }
            } else {
               if((var12 == 1 || !class148.field2224 && var12 == 4) && client.field429 > 0) {
                  var1 = client.field329[client.field429 - 1];
                  if(var1 == 39 || var1 == 40 || var1 == 41 || var1 == 42 || var1 == 43 || var1 == 33 || var1 == 34 || var1 == 35 || var1 == 36 || var1 == 37 || var1 == 38 || var1 == 1005) {
                     label307: {
                        var11 = client.field434[client.field429 - 1];
                        var3 = client.field431[client.field429 - 1];
                        class173 var4 = class153.method3177(var3);
                        if(!class0.method1(class18.method205(var4))) {
                           var6 = class18.method205(var4);
                           boolean var5 = (var6 >> 29 & 1) != 0;
                           if(!var5) {
                              break label307;
                           }
                        }

                        if(null != class167.field2675 && !client.field407 && client.field474 != 1 && !class37.method795(client.field429 - 1) && client.field429 > 0) {
                           var13 = client.field504;
                           var6 = client.field405;
                           class14.method176(class13.field203, var13, var6);
                           class13.field203 = null;
                        }

                        client.field407 = false;
                        client.field471 = 0;
                        if(class167.field2675 != null) {
                           class39.method818(class167.field2675);
                        }

                        class167.field2675 = class153.method3177(var3);
                        client.field403 = var11;
                        client.field504 = class140.field2161;
                        client.field405 = class140.field2158;
                        if(client.field429 > 0) {
                           var13 = client.field429 - 1;
                           class13.field203 = new class30();
                           class13.field203.field712 = client.field434[var13];
                           class13.field203.field704 = client.field431[var13];
                           class13.field203.field705 = client.field329[var13];
                           class13.field203.field703 = client.field433[var13];
                           class13.field203.field707 = client.field459[var13];
                        }

                        class39.method818(class167.field2675);
                        return;
                     }
                  }
               }

               if((var12 == 1 || !class148.field2224 && var12 == 4) && (client.field474 == 1 && client.field429 > 2 || class37.method795(client.field429 - 1))) {
                  var12 = 2;
               }

               if((var12 == 1 || !class148.field2224 && var12 == 4) && client.field429 > 0) {
                  class11.method157(client.field429 - 1);
               }

               if(var12 == 2 && client.field429 > 0) {
                  class148.method3156(class140.field2161, class140.field2158);
               }
            }

         }
      }
   }
}
