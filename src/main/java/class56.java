import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class56 {
   @ObfuscatedName("y")
   static class72 field1182;
   @ObfuscatedName("k")
   boolean field1185 = true;
   @ObfuscatedName("l")
   class66 field1186;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1386504887
   )
   int field1187 = 32;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 3547731650712102457L
   )
   long field1188 = class14.method165();
   @ObfuscatedName("ay")
   class66[] field1189 = new class66[8];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1372998549
   )
   int field1190 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -727392559
   )
   int field1191;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -8859698445789947723L
   )
   long field1192 = 0L;
   @ObfuscatedName("v")
   int[] field1193;
   @ObfuscatedName("p")
   public static boolean field1194;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -826722363
   )
   int field1195 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -6613063457806793071L
   )
   long field1196 = 0L;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1898865229
   )
   int field1197 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 944711201
   )
   int field1198;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 2096649175
   )
   int field1199 = 0;
   @ObfuscatedName("ar")
   class66[] field1200 = new class66[8];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1159421641
   )
   int field1202;

   @ObfuscatedName("t")
   int vmethod1512() throws Exception {
      return this.field1198;
   }

   @ObfuscatedName("r")
   public final void method1195() {
      this.field1185 = true;
   }

   @ObfuscatedName("n")
   public final synchronized void method1196() {
      this.field1185 = true;

      try {
         this.vmethod1518();
      } catch (Exception var2) {
         this.vmethod1514();
         this.field1192 = class14.method165() + 2000L;
      }

   }

   @ObfuscatedName("b")
   final void method1198(int var1) {
      this.field1199 -= var1;
      if(this.field1199 < 0) {
         this.field1199 = 0;
      }

      if(null != this.field1186) {
         this.field1186.vmethod3734(var1);
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lclass66;II)V",
      garbageValue = "289191229"
   )
   final void method1200(class66 var1, int var2) {
      int var3 = var2 >> 5;
      class66 var4 = this.field1189[var3];
      if(var4 == null) {
         this.field1200[var3] = var1;
      } else {
         var4.field1272 = var1;
      }

      this.field1189[var3] = var1;
      var1.field1270 = var2;
   }

   @ObfuscatedName("x")
   void vmethod1517(int var1) throws Exception {
   }

   @ObfuscatedName("k")
   public final synchronized void method1203(class66 var1) {
      this.field1186 = var1;
   }

   @ObfuscatedName("w")
   void vmethod1510() throws Exception {
   }

   @ObfuscatedName("y")
   void vmethod1518() throws Exception {
   }

   @ObfuscatedName("af")
   final void method1216(int[] var1, int var2) {
      int var3 = var2;
      if(field1194) {
         var3 = var2 << 1;
      }

      class120.method2707(var1, 0, var3);
      this.field1199 -= var2;
      if(null != this.field1186 && this.field1199 <= 0) {
         this.field1199 += class129.field2058 >> 4;
         class21.method591(this.field1186);
         this.method1200(this.field1186, this.field1186.vmethod1463());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class66 var10;
         label140:
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
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  class66 var11 = this.field1200[var7];

                  label134:
                  while(true) {
                     while(true) {
                        if(null == var11) {
                           break label134;
                        }

                        class65 var12 = var11.field1271;
                        if(var12 != null && var12.field1268 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1272;
                        } else {
                           var11.field1269 = true;
                           int var13 = var11.vmethod3745();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1268 += var13;
                           }

                           if(var4 >= this.field1187) {
                              break label140;
                           }

                           class66 var14 = var11.vmethod3729();
                           if(var14 != null) {
                              for(int var15 = var11.field1270; var14 != null; var14 = var11.vmethod3749()) {
                                 this.method1200(var14, var15 * var14.vmethod1463() >> 8);
                              }
                           }

                           class66 var18 = var11.field1272;
                           var11.field1272 = null;
                           if(var10 == null) {
                              this.field1200[var7] = var18;
                           } else {
                              var10.field1272 = var18;
                           }

                           if(var18 == null) {
                              this.field1189[var7] = var10;
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
            class66 var16 = this.field1200[var6];
            class66[] var17 = this.field1200;
            this.field1189[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1272;
               var16.field1272 = null;
            }
         }
      }

      if(this.field1199 < 0) {
         this.field1199 = 0;
      }

      if(null != this.field1186) {
         this.field1186.vmethod3733(var1, 0, var2);
      }

      this.field1188 = class14.method165();
   }

   @ObfuscatedName("s")
   public static boolean method1217(char var0) {
      return var0 >= 32 && var0 <= 126?true:(var0 >= 160 && var0 <= 255?true:8364 == var0 || 338 == var0 || var0 == 8212 || 339 == var0 || var0 == 376);
   }

   @ObfuscatedName("e")
   void vmethod1514() {
   }

   @ObfuscatedName("g")
   public final synchronized void method1228() {
      if(null != field1182) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(field1182.field1354[var2] == this) {
               field1182.field1354[var2] = null;
            }

            if(field1182.field1354[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1182.field1355 = true;

            while(field1182.field1362) {
               class104.method2291(50L);
            }

            field1182 = null;
         }
      }

      this.vmethod1514();
      this.field1193 = null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-291969130"
   )
   public final synchronized void method1234() {
      if(this.field1193 != null) {
         long var1 = class14.method165();

         try {
            if(this.field1192 != 0L) {
               if(var1 < this.field1192) {
                  return;
               }

               this.vmethod1517(this.field1198);
               this.field1192 = 0L;
               this.field1185 = true;
            }

            int var3 = this.vmethod1512();
            if(this.field1195 - var3 > this.field1190) {
               this.field1190 = this.field1195 - var3;
            }

            int var4 = this.field1191 + this.field1202;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(256 + var4 > this.field1198) {
               this.field1198 += 1024;
               if(this.field1198 > 16384) {
                  this.field1198 = 16384;
               }

               this.vmethod1514();
               this.vmethod1517(this.field1198);
               var3 = 0;
               this.field1185 = true;
               if(var4 + 256 > this.field1198) {
                  var4 = this.field1198 - 256;
                  this.field1191 = var4 - this.field1202;
               }
            }

            while(var3 < var4) {
               this.method1216(this.field1193, 256);
               this.vmethod1513();
               var3 += 256;
            }

            if(var1 > this.field1196) {
               if(!this.field1185) {
                  if(0 == this.field1190 && 0 == this.field1197) {
                     this.vmethod1514();
                     this.field1192 = var1 + 2000L;
                     return;
                  }

                  this.field1191 = Math.min(this.field1197, this.field1190);
                  this.field1197 = this.field1190;
               } else {
                  this.field1185 = false;
               }

               this.field1190 = 0;
               this.field1196 = var1 + 2000L;
            }

            this.field1195 = var3;
         } catch (Exception var6) {
            this.vmethod1514();
            this.field1192 = var1 + 2000L;
         }

         try {
            if(var1 > 500000L + this.field1188) {
               var1 = this.field1188;
            }

            while(var1 > this.field1188 + 5000L) {
               this.method1198(256);
               this.field1188 += (long)(256000 / class129.field2058);
            }
         } catch (Exception var5) {
            this.field1188 = var1;
         }

      }
   }

   @ObfuscatedName("y")
   public static class80[] method1236(class167 var0, String var1, String var2) {
      int var3 = var0.method3303(var1);
      int var4 = var0.method3289(var3, var2);
      return class5.method92(var0, var3, var4);
   }

   @ObfuscatedName("x")
   public static class52 method1237(int var0) {
      class52 var1 = (class52)class52.field1169.method3771((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class52.field1166.method3335(16, var0);
         var1 = new class52();
         if(null != var2) {
            var1.method1105(new class119(var2));
         }

         class52.field1169.method3773(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("x")
   static final void method1238(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("t")
   public static int method1239(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var1 + var0;
   }

   @ObfuscatedName("p")
   void vmethod1513() throws Exception {
   }

   @ObfuscatedName("ac")
   static void method1241() {
      client.field318.method2757(68);
      client.field318.method2573(class44.method979());
      client.field318.method2492(class15.field235);
      client.field318.method2492(class15.field233);
   }
}
