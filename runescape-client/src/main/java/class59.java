import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class59 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 478016793
   )
   int field1241;
   @ObfuscatedName("l")
   public static boolean field1242;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1618576847
   )
   public static int field1243;
   @ObfuscatedName("h")
   static class75 field1244;
   @ObfuscatedName("b")
   int[] field1247;
   @ObfuscatedName("u")
   class69 field1248;
   @ObfuscatedName("ah")
   class69[] field1249 = new class69[8];
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -2256520622956164629L
   )
   long field1250 = client.method424();
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -559387655
   )
   int field1251 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1513471957
   )
   int field1253;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1732803949
   )
   int field1254;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1057823789
   )
   int field1255 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 328856801
   )
   int field1256 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1395464601
   )
   int field1257 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1685894553
   )
   int field1258 = 32;
   @ObfuscatedName("z")
   boolean field1259 = true;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 38361827
   )
   public static int field1260;
   @ObfuscatedName("s")
   class69[] field1261 = new class69[8];
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 2306382847700741037L
   )
   long field1262 = 0L;
   @ObfuscatedName("rf")
   protected static boolean field1263;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 3167685202176703213L
   )
   long field1264 = 0L;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass69;I)V",
      garbageValue = "1922364644"
   )
   public final synchronized void method1276(class69 var1) {
      this.field1248 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1726976103"
   )
   public final synchronized void method1277() {
      if(null != this.field1247) {
         long var1 = client.method424();

         try {
            if(0L != this.field1262) {
               if(var1 < this.field1262) {
                  return;
               }

               this.vmethod1602(this.field1254);
               this.field1262 = 0L;
               this.field1259 = true;
            }

            int var3 = this.vmethod1603();
            if(this.field1257 - var3 > this.field1255) {
               this.field1255 = this.field1257 - var3;
            }

            int var4 = this.field1241 + this.field1253;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(256 + var4 > this.field1254) {
               this.field1254 += 1024;
               if(this.field1254 > 16384) {
                  this.field1254 = 16384;
               }

               this.vmethod1600();
               this.vmethod1602(this.field1254);
               var3 = 0;
               this.field1259 = true;
               if(var4 + 256 > this.field1254) {
                  var4 = this.field1254 - 256;
                  this.field1253 = var4 - this.field1241;
               }
            }

            while(var3 < var4) {
               this.method1326(this.field1247, 256);
               this.vmethod1604();
               var3 += 256;
            }

            if(var1 > this.field1264) {
               if(!this.field1259) {
                  if(this.field1255 == 0 && this.field1256 == 0) {
                     this.vmethod1600();
                     this.field1262 = var1 + 2000L;
                     return;
                  }

                  this.field1253 = Math.min(this.field1256, this.field1255);
                  this.field1256 = this.field1255;
               } else {
                  this.field1259 = false;
               }

               this.field1255 = 0;
               this.field1264 = var1 + 2000L;
            }

            this.field1257 = var3;
         } catch (Exception var7) {
            this.vmethod1600();
            this.field1262 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1250) {
               var1 = this.field1250;
            }

            while(var1 > this.field1250 + 5000L) {
               this.method1281(256);
               this.field1250 += (long)(256000 / field1260);
            }
         } catch (Exception var6) {
            this.field1250 = var1;
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "56"
   )
   public final void method1278() {
      this.field1259 = true;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1527156289"
   )
   public final synchronized void method1279() {
      this.field1259 = true;

      try {
         this.vmethod1620();
      } catch (Exception var2) {
         this.vmethod1600();
         this.field1262 = client.method424() + 2000L;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1937882196"
   )
   public final synchronized void method1280() {
      if(field1244 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == field1244.field1418[var2]) {
               field1244.field1418[var2] = null;
            }

            if(field1244.field1418[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1244.field1419 = true;

            while(field1244.field1417) {
               class125.method2881(50L);
            }

            field1244 = null;
         }
      }

      this.vmethod1600();
      this.field1247 = null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1618305831"
   )
   final void method1281(int var1) {
      this.field1251 -= var1;
      if(this.field1251 < 0) {
         this.field1251 = 0;
      }

      if(this.field1248 != null) {
         this.field1248.vmethod3807(var1);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)Lclass41;",
      garbageValue = "-125"
   )
   @Export("getNpcDefinition")
   public static class41 method1282(int var0) {
      class41 var1 = (class41)class41.field920.method3834((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class41.field951.method3340(9, var0);
         var1 = new class41();
         var1.field922 = var0;
         if(var2 != null) {
            var1.method808(new class122(var2));
         }

         var1.method806();
         class41.field920.method3836(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass69;II)V",
      garbageValue = "418928497"
   )
   final void method1283(class69 var1, int var2) {
      int var3 = var2 >> 5;
      class69 var4 = this.field1249[var3];
      if(var4 == null) {
         this.field1261[var3] = var1;
      } else {
         var4.field1335 = var1;
      }

      this.field1249[var3] = var1;
      var1.field1334 = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "117"
   )
   void vmethod1610(Component var1) throws Exception {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1465181803"
   )
   void vmethod1602(int var1) throws Exception {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1337764375"
   )
   int vmethod1603() throws Exception {
      return this.field1254;
   }

   @ObfuscatedName("j")
   void vmethod1604() throws Exception {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2010510773"
   )
   void vmethod1600() {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-43"
   )
   void vmethod1620() throws Exception {
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1167206544"
   )
   static final void method1321() {
      int var0 = 64 + class17.field258 * 128;
      int var1 = class98.field1684 * 128 + 64;
      int var2 = class105.method2370(var0, var1, class50.field1119) - class27.field688;
      if(class85.field1500 < var0) {
         class85.field1500 += class26.field668 + (var0 - class85.field1500) * class146.field2237 / 1000;
         if(class85.field1500 > var0) {
            class85.field1500 = var0;
         }
      }

      if(class85.field1500 > var0) {
         class85.field1500 -= class26.field668 + (class85.field1500 - var0) * class146.field2237 / 1000;
         if(class85.field1500 < var0) {
            class85.field1500 = var0;
         }
      }

      if(class41.field955 < var2) {
         class41.field955 += class146.field2237 * (var2 - class41.field955) / 1000 + class26.field668;
         if(class41.field955 > var2) {
            class41.field955 = var2;
         }
      }

      if(class41.field955 > var2) {
         class41.field955 -= class26.field668 + (class41.field955 - var2) * class146.field2237 / 1000;
         if(class41.field955 < var2) {
            class41.field955 = var2;
         }
      }

      if(class157.field2342 < var1) {
         class157.field2342 += (var1 - class157.field2342) * class146.field2237 / 1000 + class26.field668;
         if(class157.field2342 > var1) {
            class157.field2342 = var1;
         }
      }

      if(class157.field2342 > var1) {
         class157.field2342 -= class26.field668 + (class157.field2342 - var1) * class146.field2237 / 1000;
         if(class157.field2342 < var1) {
            class157.field2342 = var1;
         }
      }

      var0 = 64 + class96.field1663 * 128;
      var1 = class163.field2681 * 128 + 64;
      var2 = class105.method2370(var0, var1, class50.field1119) - class182.field2965;
      int var3 = var0 - class85.field1500;
      int var4 = var2 - class41.field955;
      int var5 = var1 - class157.field2342;
      int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class98.field1694 < var7) {
         class98.field1694 += class99.field1705 + (var7 - class98.field1694) * class10.field181 / 1000;
         if(class98.field1694 > var7) {
            class98.field1694 = var7;
         }
      }

      if(class98.field1694 > var7) {
         class98.field1694 -= class10.field181 * (class98.field1694 - var7) / 1000 + class99.field1705;
         if(class98.field1694 < var7) {
            class98.field1694 = var7;
         }
      }

      int var9 = var8 - class99.field1703;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class99.field1703 += var9 * class10.field181 / 1000 + class99.field1705;
         class99.field1703 &= 2047;
      }

      if(var9 < 0) {
         class99.field1703 -= class99.field1705 + class10.field181 * -var9 / 1000;
         class99.field1703 &= 2047;
      }

      int var10 = var8 - class99.field1703;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class99.field1703 = var8;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "-41"
   )
   static final byte[] method1325(byte[] var0) {
      class122 var1 = new class122(var0);
      int var2 = var1.method2610();
      int var3 = var1.method2614();
      if(var3 >= 0 && (class170.field2713 == 0 || var3 <= class170.field2713)) {
         if(var2 == 0) {
            byte[] var4 = new byte[var3];
            var1.method2737(var4, 0, var3);
            return var4;
         } else {
            int var6 = var1.method2614();
            if(var6 < 0 || class170.field2713 != 0 && var6 > class170.field2713) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var6];
               if(var2 == 1) {
                  class120.method2550(var5, var6, var0, var3, 9);
               } else {
                  class170.field2725.method2545(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1326(int[] var1, int var2) {
      int var3 = var2;
      if(field1242) {
         var3 = var2 << 1;
      }

      class123.method2829(var1, 0, var3);
      this.field1251 -= var2;
      if(this.field1248 != null && this.field1251 <= 0) {
         this.field1251 += field1260 >> 4;
         class139.method2992(this.field1248);
         this.method1283(this.field1248, this.field1248.vmethod1568());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class69 var10;
         label137:
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
                  class69 var11 = this.field1261[var7];

                  label131:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label131;
                        }

                        class68 var12 = var11.field1333;
                        if(null != var12 && var12.field1332 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1335;
                        } else {
                           var11.field1336 = true;
                           int var13 = var11.vmethod3805();
                           var4 += var13;
                           if(null != var12) {
                              var12.field1332 += var13;
                           }

                           if(var4 >= this.field1258) {
                              break label137;
                           }

                           class69 var14 = var11.vmethod3803();
                           if(null != var14) {
                              for(int var17 = var11.field1334; null != var14; var14 = var11.vmethod3804()) {
                                 this.method1283(var14, var17 * var14.vmethod1568() >> 8);
                              }
                           }

                           class69 var15 = var11.field1335;
                           var11.field1335 = null;
                           if(null == var10) {
                              this.field1261[var7] = var15;
                           } else {
                              var10.field1335 = var15;
                           }

                           if(null == var15) {
                              this.field1249[var7] = var10;
                           }

                           var11 = var15;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class69 var16 = this.field1261[var6];
            class69[] var18 = this.field1261;
            this.field1249[var6] = null;

            for(var18[var6] = null; null != var16; var16 = var10) {
               var10 = var16.field1335;
               var16.field1335 = null;
            }
         }
      }

      if(this.field1251 < 0) {
         this.field1251 = 0;
      }

      if(this.field1248 != null) {
         this.field1248.vmethod3806(var1, 0, var2);
      }

      this.field1250 = client.method424();
   }
}
