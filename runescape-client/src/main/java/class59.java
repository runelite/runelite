import java.awt.Component;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
public class class59 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2076770607
   )
   int field1213;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1365517443
   )
   public static int field1215;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1024865157
   )
   public static int field1219;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1074795625
   )
   int field1220 = 32;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 9022162346464555945L
   )
   long field1221 = class113.method2394();
   @ObfuscatedName("z")
   public static boolean field1222;
   @ObfuscatedName("f")
   class69 field1223;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -646449777
   )
   int field1224;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -5448252001310087137L
   )
   long field1225 = 0L;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1896458113
   )
   int field1226 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 297028983
   )
   int field1227 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -963406555
   )
   int field1228 = 0;
   @ObfuscatedName("o")
   boolean field1230 = true;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -697950883
   )
   int field1232 = 0;
   @ObfuscatedName("j")
   class69[] field1233 = new class69[8];
   @ObfuscatedName("ae")
   class69[] field1234 = new class69[8];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -3155247299084339093L
   )
   long field1235 = 0L;
   @ObfuscatedName("qm")
   protected static Image field1236;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = 903512265
   )
   static int field1237;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 37019843
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("m")
   int[] field1240;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 466300533
   )
   int field1241;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass69;I)V",
      garbageValue = "1545502600"
   )
   public final synchronized void method1176(class69 var1) {
      this.field1223 = var1;
   }

   @ObfuscatedName("n")
   void vmethod1527() throws Exception {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1035989554"
   )
   public final synchronized void method1179() {
      this.field1230 = true;

      try {
         this.vmethod1531();
      } catch (Exception var2) {
         this.vmethod1521();
         this.field1225 = class113.method2394() + 2000L;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "80377495"
   )
   public final synchronized void method1180() {
      if(class219.field3209 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(class219.field3209.field1390[var2] == this) {
               class219.field3209.field1390[var2] = null;
            }

            if(class219.field3209.field1390[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            class219.field3209.field1391 = true;

            while(class219.field3209.field1392) {
               class16.method185(50L);
            }

            class219.field3209 = null;
         }
      }

      this.vmethod1521();
      this.field1240 = null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "12"
   )
   final void method1181(int var1) {
      this.field1232 -= var1;
      if(this.field1232 < 0) {
         this.field1232 = 0;
      }

      if(this.field1223 != null) {
         this.field1223.vmethod3712(var1);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass69;II)V",
      garbageValue = "-992012840"
   )
   final void method1183(class69 var1, int var2) {
      int var3 = var2 >> 5;
      class69 var4 = this.field1234[var3];
      if(var4 == null) {
         this.field1233[var3] = var1;
      } else {
         var4.field1308 = var1;
      }

      this.field1234[var3] = var1;
      var1.field1307 = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "196143351"
   )
   public final synchronized void method1184() {
      if(this.field1240 != null) {
         long var1 = class113.method2394();

         try {
            if(0L != this.field1225) {
               if(var1 < this.field1225) {
                  return;
               }

               this.vmethod1518(this.field1213);
               this.field1225 = 0L;
               this.field1230 = true;
            }

            int var3 = this.vmethod1520();
            if(this.field1228 - var3 > this.field1226) {
               this.field1226 = this.field1228 - var3;
            }

            int var4 = this.field1241 + this.field1224;
            if(256 + var4 > 16384) {
               var4 = 16128;
            }

            if(256 + var4 > this.field1213) {
               this.field1213 += 1024;
               if(this.field1213 > 16384) {
                  this.field1213 = 16384;
               }

               this.vmethod1521();
               this.vmethod1518(this.field1213);
               var3 = 0;
               this.field1230 = true;
               if(var4 + 256 > this.field1213) {
                  var4 = this.field1213 - 256;
                  this.field1224 = var4 - this.field1241;
               }
            }

            while(var3 < var4) {
               this.method1207(this.field1240, 256);
               this.vmethod1527();
               var3 += 256;
            }

            if(var1 > this.field1235) {
               if(!this.field1230) {
                  if(this.field1226 == 0 && this.field1227 == 0) {
                     this.vmethod1521();
                     this.field1225 = 2000L + var1;
                     return;
                  }

                  this.field1224 = Math.min(this.field1227, this.field1226);
                  this.field1227 = this.field1226;
               } else {
                  this.field1230 = false;
               }

               this.field1226 = 0;
               this.field1235 = var1 + 2000L;
            }

            this.field1228 = var3;
         } catch (Exception var7) {
            this.vmethod1521();
            this.field1225 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1221) {
               var1 = this.field1221;
            }

            while(var1 > this.field1221 + 5000L) {
               this.method1181(256);
               this.field1221 += (long)(256000 / field1219);
            }
         } catch (Exception var6) {
            this.field1221 = var1;
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-240558021"
   )
   void vmethod1518(int var1) throws Exception {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-459554410"
   )
   void vmethod1521() {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "-759712527"
   )
   public static int method1188(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2001671099"
   )
   int vmethod1520() throws Exception {
      return this.field1213;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1207(int[] var1, int var2) {
      int var3 = var2;
      if(field1222) {
         var3 = var2 << 1;
      }

      class123.method2697(var1, 0, var3);
      this.field1232 -= var2;
      if(null != this.field1223 && this.field1232 <= 0) {
         this.field1232 += field1219 >> 4;
         Sequence.method898(this.field1223);
         this.method1183(this.field1223, this.field1223.vmethod1472());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class69 var10;
         label136:
         for(var6 = 7; var5 != 0; --var6) {
            int var7;
            int var17;
            if(var6 < 0) {
               var7 = var6 & 3;
               var17 = -(var6 >> 2);
            } else {
               var7 = var6;
               var17 = 0;
            }

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  class69 var11 = this.field1233[var7];

                  label130:
                  while(true) {
                     while(true) {
                        if(null == var11) {
                           break label130;
                        }

                        class68 var12 = var11.field1305;
                        if(null != var12 && var12.field1304 > var17) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1308;
                        } else {
                           var11.field1306 = true;
                           int var13 = var11.vmethod3707();
                           var4 += var13;
                           if(null != var12) {
                              var12.field1304 += var13;
                           }

                           if(var4 >= this.field1220) {
                              break label136;
                           }

                           class69 var14 = var11.vmethod3708();
                           if(null != var14) {
                              for(int var18 = var11.field1307; var14 != null; var14 = var11.vmethod3709()) {
                                 this.method1183(var14, var18 * var14.vmethod1472() >> 8);
                              }
                           }

                           class69 var15 = var11.field1308;
                           var11.field1308 = null;
                           if(var10 == null) {
                              this.field1233[var7] = var15;
                           } else {
                              var10.field1308 = var15;
                           }

                           if(var15 == null) {
                              this.field1234[var7] = var10;
                           }

                           var11 = var15;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var17;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class69 var16 = this.field1233[var6];
            class69[] var8 = this.field1233;
            this.field1234[var6] = null;

            for(var8[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1308;
               var16.field1308 = null;
            }
         }
      }

      if(this.field1232 < 0) {
         this.field1232 = 0;
      }

      if(this.field1223 != null) {
         this.field1223.vmethod3711(var1, 0, var2);
      }

      this.field1221 = class113.method2394();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1531665772"
   )
   void vmethod1531() throws Exception {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1119957445"
   )
   void vmethod1522(Component var1) throws Exception {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-27"
   )
   static final int method1227(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class169.method3246(var3, var5);
      int var8 = class169.method3246(1 + var3, var5);
      int var9 = class169.method3246(var3, 1 + var5);
      int var10 = class169.method3246(var3 + 1, 1 + var5);
      int var11 = class49.method970(var7, var8, var4, var2);
      int var12 = class49.method970(var9, var10, var4, var2);
      return class49.method970(var11, var12, var6, var2);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)Z",
      garbageValue = "5"
   )
   public static boolean method1228(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  return false;
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               return false;
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var1 * var5 + var10;
            if(var9 / var1 != var5) {
               return false;
            }

            var5 = var9;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2144544619"
   )
   public final void method1229() {
      this.field1230 = true;
   }
}
