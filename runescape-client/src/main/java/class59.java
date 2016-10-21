import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public class class59 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2042815891
   )
   int field1218;
   @ObfuscatedName("e")
   static boolean field1219;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -6631745536468104955L
   )
   long field1220 = 0L;
   @ObfuscatedName("q")
   boolean field1221 = true;
   @ObfuscatedName("m")
   int[] field1223;
   @ObfuscatedName("k")
   class69 field1224;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2090939989
   )
   int field1225 = 32;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 7919377245303565153L
   )
   long field1226 = class11.method139();
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 398192613
   )
   int field1227;
   @ObfuscatedName("pm")
   static class137 field1228;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 764163515
   )
   int field1229;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -697905766784900095L
   )
   long field1230 = 0L;
   @ObfuscatedName("g")
   class69[] field1231 = new class69[8];
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1077010933
   )
   int field1232 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -545523919
   )
   int field1233 = 0;
   @ObfuscatedName("ns")
   static class77 field1234;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1378459517
   )
   public static int field1235;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 100706365
   )
   int field1237 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1903626999
   )
   int field1238 = 0;
   @ObfuscatedName("aj")
   class69[] field1239 = new class69[8];
   @ObfuscatedName("t")
   static class75 field1240;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -765846539
   )
   static int field1241;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1361154490"
   )
   public final synchronized void method1222() {
      if(null != this.field1223) {
         long var1 = class11.method139();

         try {
            if(0L != this.field1230) {
               if(var1 < this.field1230) {
                  return;
               }

               this.vmethod1561(this.field1227);
               this.field1230 = 0L;
               this.field1221 = true;
            }

            int var3 = this.vmethod1574();
            if(this.field1233 - var3 > this.field1238) {
               this.field1238 = this.field1233 - var3;
            }

            int var4 = this.field1229 + this.field1218;
            if(256 + var4 > 16384) {
               var4 = 16128;
            }

            if(256 + var4 > this.field1227) {
               this.field1227 += 1024;
               if(this.field1227 > 16384) {
                  this.field1227 = 16384;
               }

               this.vmethod1577();
               this.vmethod1561(this.field1227);
               var3 = 0;
               this.field1221 = true;
               if(256 + var4 > this.field1227) {
                  var4 = this.field1227 - 256;
                  this.field1229 = var4 - this.field1218;
               }
            }

            while(var3 < var4) {
               this.method1252(this.field1223, 256);
               this.vmethod1566();
               var3 += 256;
            }

            if(var1 > this.field1220) {
               if(!this.field1221) {
                  if(this.field1238 == 0 && this.field1232 == 0) {
                     this.vmethod1577();
                     this.field1230 = var1 + 2000L;
                     return;
                  }

                  this.field1229 = Math.min(this.field1232, this.field1238);
                  this.field1232 = this.field1238;
               } else {
                  this.field1221 = false;
               }

               this.field1238 = 0;
               this.field1220 = 2000L + var1;
            }

            this.field1233 = var3;
         } catch (Exception var7) {
            this.vmethod1577();
            this.field1230 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1226) {
               var1 = this.field1226;
            }

            while(var1 > this.field1226 + 5000L) {
               this.method1226(256);
               this.field1226 += (long)(256000 / field1235);
            }
         } catch (Exception var6) {
            this.field1226 = var1;
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "303957322"
   )
   public final void method1223() {
      this.field1221 = true;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "574477008"
   )
   public final synchronized void method1224() {
      this.field1221 = true;

      try {
         this.vmethod1567();
      } catch (Exception var2) {
         this.vmethod1577();
         this.field1230 = class11.method139() + 2000L;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1804177451"
   )
   public final synchronized void method1225() {
      if(null != field1240) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == field1240.field1394[var2]) {
               field1240.field1394[var2] = null;
            }

            if(field1240.field1394[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1240.field1396 = true;

            while(field1240.field1397) {
               class110.method2407(50L);
            }

            field1240 = null;
         }
      }

      this.vmethod1577();
      this.field1223 = null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-6738952"
   )
   final void method1226(int var1) {
      this.field1237 -= var1;
      if(this.field1237 < 0) {
         this.field1237 = 0;
      }

      if(this.field1224 != null) {
         this.field1224.vmethod3780(var1);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "97"
   )
   int vmethod1574() throws Exception {
      return this.field1227;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass69;IB)V",
      garbageValue = "-127"
   )
   final void method1228(class69 var1, int var2) {
      int var3 = var2 >> 5;
      class69 var4 = this.field1239[var3];
      if(null == var4) {
         this.field1231[var3] = var1;
      } else {
         var4.field1310 = var1;
      }

      this.field1239[var3] = var1;
      var1.field1311 = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "106"
   )
   void vmethod1573(Component var1) throws Exception {
   }

   @ObfuscatedName("x")
   void vmethod1566() throws Exception {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   void vmethod1577() {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-18"
   )
   void vmethod1567() throws Exception {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "72413541"
   )
   void vmethod1561(int var1) throws Exception {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1252(int[] var1, int var2) {
      int var3 = var2;
      if(field1219) {
         var3 = var2 << 1;
      }

      class123.method2741(var1, 0, var3);
      this.field1237 -= var2;
      if(null != this.field1224 && this.field1237 <= 0) {
         this.field1237 += field1235 >> 4;
         Projectile.method91(this.field1224);
         this.method1228(this.field1224, this.field1224.vmethod1511());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class69 var10;
         label139:
         for(var6 = 7; var5 != 0; --var6) {
            int var8;
            int var16;
            if(var6 < 0) {
               var16 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var16 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var16 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var16);
                  var10 = null;
                  class69 var11 = this.field1231[var16];

                  label133:
                  while(true) {
                     while(true) {
                        if(null == var11) {
                           break label133;
                        }

                        class68 var12 = var11.field1312;
                        if(var12 != null && var12.field1309 > var8) {
                           var5 |= 1 << var16;
                           var10 = var11;
                           var11 = var11.field1310;
                        } else {
                           var11.field1313 = true;
                           int var13 = var11.vmethod3778();
                           var4 += var13;
                           if(null != var12) {
                              var12.field1309 += var13;
                           }

                           if(var4 >= this.field1225) {
                              break label139;
                           }

                           class69 var14 = var11.vmethod3776();
                           if(null != var14) {
                              for(int var17 = var11.field1311; var14 != null; var14 = var11.vmethod3777()) {
                                 this.method1228(var14, var17 * var14.vmethod1511() >> 8);
                              }
                           }

                           class69 var15 = var11.field1310;
                           var11.field1310 = null;
                           if(null == var10) {
                              this.field1231[var16] = var15;
                           } else {
                              var10.field1310 = var15;
                           }

                           if(null == var15) {
                              this.field1239[var16] = var10;
                           }

                           var11 = var15;
                        }
                     }
                  }
               }

               var16 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class69 var7 = this.field1231[var6];
            class69[] var18 = this.field1231;
            this.field1239[var6] = null;

            for(var18[var6] = null; null != var7; var7 = var10) {
               var10 = var7.field1310;
               var7.field1310 = null;
            }
         }
      }

      if(this.field1237 < 0) {
         this.field1237 = 0;
      }

      if(null != this.field1224) {
         this.field1224.vmethod3796(var1, 0, var2);
      }

      this.field1226 = class11.method139();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass69;I)V",
      garbageValue = "2073041838"
   )
   public final synchronized void method1267(class69 var1) {
      this.field1224 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "2067732641"
   )
   static void method1273(String var0, String var1, String var2) {
      class33.loginMessage1 = var0;
      class33.loginMessage2 = var1;
      class33.loginMessage3 = var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[LCollisionData;I)V",
      garbageValue = "-1857650634"
   )
   static final void method1274(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var9 + var2 > 0 && var9 + var2 < 103 && var10 + var3 > 0 && var10 + var3 < 103) {
               var8[var1].flags[var2 + var9][var3 + var10] &= -16777217;
            }
         }
      }

      Buffer var21 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var10 == var4 && var11 >= var5 && var11 < 8 + var5 && var12 >= var6 && var12 < 8 + var6) {
                  int var15 = var2 + class109.method2394(var11 & 7, var12 & 7, var7);
                  int var18 = var11 & 7;
                  int var19 = var12 & 7;
                  int var20 = var7 & 3;
                  int var17;
                  if(var20 == 0) {
                     var17 = var19;
                  } else if(var20 == 1) {
                     var17 = 7 - var18;
                  } else if(var20 == 2) {
                     var17 = 7 - var19;
                  } else {
                     var17 = var18;
                  }

                  class143.method2998(var21, var1, var15, var17 + var3, 0, 0, var7);
               } else {
                  class143.method2998(var21, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }
}
