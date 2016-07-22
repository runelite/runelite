import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public class class67 extends class69 {
   @ObfuscatedName("v")
   int field1321;
   @ObfuscatedName("e")
   int field1322;
   @ObfuscatedName("y")
   int field1323;
   @ObfuscatedName("g")
   int field1324;
   @ObfuscatedName("l")
   int field1325;
   @ObfuscatedName("m")
   int field1326;
   @ObfuscatedName("h")
   boolean field1327;
   @ObfuscatedName("r")
   int field1328;
   @ObfuscatedName("k")
   int field1329;
   @ObfuscatedName("o")
   int field1330;
   @ObfuscatedName("x")
   int field1331;
   @ObfuscatedName("u")
   int field1332;
   @ObfuscatedName("j")
   int field1333;
   @ObfuscatedName("p")
   int field1334;
   @ObfuscatedName("s")
   int field1335;

   @ObfuscatedName("w")
   static int method1386(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ao")
   int vmethod1547() {
      int var1 = this.field1325 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1331 == 0) {
         var1 -= var1 * this.field1326 / (((class65)super.field1338).field1305.length << 8);
      } else if(this.field1331 >= 0) {
         var1 -= var1 * this.field1329 / ((class65)super.field1338).field1305.length;
      }

      return var1 > 255?255:var1;
   }

   class67(class65 var1, int var2, int var3) {
      super.field1338 = var1;
      this.field1329 = var1.field1308;
      this.field1321 = var1.field1307;
      this.field1327 = var1.field1304;
      this.field1322 = var2;
      this.field1330 = var3;
      this.field1324 = 8192;
      this.field1326 = 0;
      this.method1391();
   }

   class67(class65 var1, int var2, int var3, int var4) {
      super.field1338 = var1;
      this.field1329 = var1.field1308;
      this.field1321 = var1.field1307;
      this.field1327 = var1.field1304;
      this.field1322 = var2;
      this.field1330 = var3;
      this.field1324 = var4;
      this.field1326 = 0;
      this.method1391();
   }

   @ObfuscatedName("o")
   public static class67 method1390(class65 var0, int var1, int var2, int var3) {
      return var0.field1305 != null && var0.field1305.length != 0?new class67(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("g")
   void method1391() {
      this.field1325 = this.field1330;
      this.field1333 = method1434(this.field1330, this.field1324);
      this.field1328 = method1386(this.field1330, this.field1324);
   }

   @ObfuscatedName("k")
   public synchronized void method1392(int var1) {
      this.field1331 = var1;
   }

   @ObfuscatedName("d")
   void method1393() {
      if(this.field1332 != 0) {
         if(this.field1330 == Integer.MIN_VALUE) {
            this.field1330 = 0;
         }

         this.field1332 = 0;
         this.method1391();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1394(int var1) {
      this.method1395(var1, this.method1417());
   }

   @ObfuscatedName("y")
   synchronized void method1395(int var1, int var2) {
      this.field1330 = var1;
      this.field1324 = var2;
      this.field1332 = 0;
      this.method1391();
   }

   @ObfuscatedName("p")
   public synchronized int method1396() {
      return this.field1330 == Integer.MIN_VALUE?0:this.field1330;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1399() {
      this.field1322 = (this.field1322 ^ this.field1322 >> 31) + (this.field1322 >>> 31);
      this.field1322 = -this.field1322;
   }

   @ObfuscatedName("t")
   public synchronized void method1401(int var1, int var2) {
      this.method1402(var1, var2, this.method1417());
   }

   @ObfuscatedName("c")
   public synchronized void method1402(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1395(var2, var3);
      } else {
         int var4 = method1434(var2, var3);
         int var5 = method1386(var2, var3);
         if(this.field1333 == var4 && this.field1328 == var5) {
            this.field1332 = 0;
         } else {
            int var6 = var2 - this.field1325;
            if(this.field1325 - var2 > var6) {
               var6 = this.field1325 - var2;
            }

            if(var4 - this.field1333 > var6) {
               var6 = var4 - this.field1333;
            }

            if(this.field1333 - var4 > var6) {
               var6 = this.field1333 - var4;
            }

            if(var5 - this.field1328 > var6) {
               var6 = var5 - this.field1328;
            }

            if(this.field1328 - var5 > var6) {
               var6 = this.field1328 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1332 = var1;
            this.field1330 = var2;
            this.field1324 = var3;
            this.field1323 = (var2 - this.field1325) / var1;
            this.field1334 = (var4 - this.field1333) / var1;
            this.field1335 = (var5 - this.field1328) / var1;
         }
      }
   }

   @ObfuscatedName("z")
   public synchronized void method1403(int var1) {
      if(var1 == 0) {
         this.method1394(0);
         this.method3990();
      } else if(this.field1333 == 0 && this.field1328 == 0) {
         this.field1332 = 0;
         this.field1330 = 0;
         this.field1325 = 0;
         this.method3990();
      } else {
         int var2 = -this.field1325;
         if(this.field1325 > var2) {
            var2 = this.field1325;
         }

         if(-this.field1333 > var2) {
            var2 = -this.field1333;
         }

         if(this.field1333 > var2) {
            var2 = this.field1333;
         }

         if(-this.field1328 > var2) {
            var2 = -this.field1328;
         }

         if(this.field1328 > var2) {
            var2 = this.field1328;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1332 = var1;
         this.field1330 = Integer.MIN_VALUE;
         this.field1323 = -this.field1325 / var1;
         this.field1334 = -this.field1333 / var1;
         this.field1335 = -this.field1328 / var1;
      }
   }

   @ObfuscatedName("n")
   public synchronized void method1404(int var1) {
      if(this.field1322 < 0) {
         this.field1322 = -var1;
      } else {
         this.field1322 = var1;
      }

   }

   @ObfuscatedName("q")
   public synchronized int method1405() {
      return this.field1322 < 0?-this.field1322:this.field1322;
   }

   @ObfuscatedName("a")
   public boolean method1406() {
      return this.field1326 < 0 || this.field1326 >= ((class65)super.field1338).field1305.length << 8;
   }

   @ObfuscatedName("at")
   public boolean method1407() {
      return this.field1332 != 0;
   }

   @ObfuscatedName("ak")
   static int method1409(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var9 + 256 - var4 + var11) / var11) > var8) {
         var7 = var8;
      }

      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         byte var13 = var2[var1 - 1];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var2[var1] - var13) * (var4 & 255)) * var6 >> 6;
         var4 += var11;
      }

      if(var11 == 0 || (var7 = var5 + (var9 - var4 + var11) / var11) > var8) {
         var7 = var8;
      }

      var0 = var12;

      for(var1 = var11; var5 < var7; var4 += var1) {
         var10001 = var5++;
         var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
      }

      var10.field1326 = var4;
      return var5;
   }

   @ObfuscatedName("r")
   protected int vmethod3783() {
      return this.field1330 == 0 && this.field1332 == 0?0:1;
   }

   @ObfuscatedName("ae")
   static int method1412(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var0 = (var14 << 8) + (var2[var1] - var14) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      if(var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for(var1 = var13; var5 < var8; var4 += var12) {
         var0 = (var1 << 8) + (var2[var4 >> 8] - var1) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      var11.field1326 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("aw")
   int method1413(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1332 > 0) {
            int var6 = var2 + this.field1332;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1332 += var2;
            if(this.field1322 == 256 && (this.field1326 & 255) == 0) {
               if(class59.field1247) {
                  var2 = method1425(0, ((class65)super.field1338).field1305, var1, this.field1326, var2, this.field1333, this.field1328, this.field1334, this.field1335, 0, var6, var3, this);
               } else {
                  var2 = method1424(((class65)super.field1338).field1305, var1, this.field1326, var2, this.field1325, this.field1323, 0, var6, var3, this);
               }
            } else if(class59.field1247) {
               var2 = method1429(0, 0, ((class65)super.field1338).field1305, var1, this.field1326, var2, this.field1333, this.field1328, this.field1334, this.field1335, 0, var6, var3, this, this.field1322, var5);
            } else {
               var2 = method1428(0, 0, ((class65)super.field1338).field1305, var1, this.field1326, var2, this.field1325, this.field1323, 0, var6, var3, this, this.field1322, var5);
            }

            this.field1332 -= var2;
            if(this.field1332 != 0) {
               return var2;
            }

            if(!this.method1415()) {
               continue;
            }

            return var4;
         }

         if(this.field1322 == 256 && (this.field1326 & 255) == 0) {
            if(class59.field1247) {
               return method1514(0, ((class65)super.field1338).field1305, var1, this.field1326, var2, this.field1333, this.field1328, 0, var4, var3, this);
            }

            return method1521(((class65)super.field1338).field1305, var1, this.field1326, var2, this.field1325, 0, var4, var3, this);
         }

         if(class59.field1247) {
            return method1421(0, 0, ((class65)super.field1338).field1305, var1, this.field1326, var2, this.field1333, this.field1328, 0, var4, var3, this, this.field1322, var5);
         }

         return method1420(0, 0, ((class65)super.field1338).field1305, var1, this.field1326, var2, this.field1325, 0, var4, var3, this, this.field1322, var5);
      }
   }

   @ObfuscatedName("al")
   boolean method1415() {
      int var1 = this.field1330;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1434(var1, this.field1324);
         var3 = method1386(var1, this.field1324);
      }

      if(this.field1325 == var1 && this.field1333 == var2 && this.field1328 == var3) {
         if(this.field1330 == Integer.MIN_VALUE) {
            this.field1330 = 0;
            this.field1328 = 0;
            this.field1333 = 0;
            this.field1325 = 0;
            this.method3990();
            return true;
         } else {
            this.method1391();
            return false;
         }
      } else {
         if(this.field1325 < var1) {
            this.field1323 = 1;
            this.field1332 = var1 - this.field1325;
         } else if(this.field1325 > var1) {
            this.field1323 = -1;
            this.field1332 = this.field1325 - var1;
         } else {
            this.field1323 = 0;
         }

         if(this.field1333 < var2) {
            this.field1334 = 1;
            if(this.field1332 == 0 || this.field1332 > var2 - this.field1333) {
               this.field1332 = var2 - this.field1333;
            }
         } else if(this.field1333 > var2) {
            this.field1334 = -1;
            if(this.field1332 == 0 || this.field1332 > this.field1333 - var2) {
               this.field1332 = this.field1333 - var2;
            }
         } else {
            this.field1334 = 0;
         }

         if(this.field1328 < var3) {
            this.field1335 = 1;
            if(this.field1332 == 0 || this.field1332 > var3 - this.field1328) {
               this.field1332 = var3 - this.field1328;
            }
         } else if(this.field1328 > var3) {
            this.field1335 = -1;
            if(this.field1332 == 0 || this.field1332 > this.field1328 - var3) {
               this.field1332 = this.field1328 - var3;
            }
         } else {
            this.field1335 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("e")
   public static class67 method1416(class65 var0, int var1, int var2) {
      return var0.field1305 != null && var0.field1305.length != 0?new class67(var0, (int)((long)var0.field1306 * 256L * (long)var1 / (long)(class59.field1268 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("s")
   public synchronized int method1417() {
      return this.field1324 < 0?-1:this.field1324;
   }

   @ObfuscatedName("au")
   static int method1418(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class67 var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if((var5 = var3 + var2 - (var7 - 1)) > var6) {
         var5 = var6;
      }

      int var10001;
      for(var5 -= 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var10001 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
         var10001 = var3++;
      }

      var8.field1326 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("am")
   static int method1419(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if((var7 = var4 + var3 - (var9 - 1)) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var10001;
      byte var11;
      for(var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      var10.field1326 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ag")
   static int method1420(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var9 - var4 + var11 - 257) / var11) > var8) {
         var7 = var8;
      }

      byte var13;
      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         var13 = var2[var1];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var2[var1 + 1] - var13) * (var4 & 255)) * var6 >> 6;
         var4 += var11;
      }

      if(var11 == 0 || (var7 = var5 + (var9 - var4 + var11 - 1) / var11) > var8) {
         var7 = var8;
      }

      for(var1 = var12; var5 < var7; var4 += var11) {
         var13 = var2[var4 >> 8];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var1 - var13) * (var4 & 255)) * var6 >> 6;
      }

      var10.field1326 = var4;
      return var5;
   }

   @ObfuscatedName("az")
   static int method1421(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      byte var14;
      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var0 = (var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      if(var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for(var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var0 = (var14 << 8) + (var1 - var14) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      var11.field1326 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("h")
   public synchronized void method1422(int var1) {
      this.method1395(var1 << 6, this.method1417());
   }

   @ObfuscatedName("br")
   static int method1424(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class67 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1333 += var9.field1334 * (var6 - var3);
      var9.field1328 += var9.field1335 * (var6 - var3);

      int var10001;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
      }

      var9.field1325 = var4 >> 2;
      var9.field1326 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bi")
   static int method1425(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class67 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1325 += var12.field1323 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      var12.field1333 = var5 >> 2;
      var12.field1328 = var6 >> 2;
      var12.field1326 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bx")
   static int method1426(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class67 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1333 += var9.field1334 * (var6 - var3);
      var9.field1328 += var9.field1335 * (var6 - var3);

      int var10001;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
      }

      var9.field1325 = var4 >> 2;
      var9.field1326 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bs")
   static int method1427(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class67 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1325 += var12.field1323 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      var12.field1333 = var5 >> 2;
      var12.field1328 = var6 >> 2;
      var12.field1326 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bt")
   static int method1428(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      var11.field1333 -= var11.field1334 * var5;
      var11.field1328 -= var11.field1335 * var5;
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      byte var14;
      int var10001;
      while(var5 < var8) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      for(var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var1 - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field1333 += var11.field1334 * var5;
      var11.field1328 += var11.field1335 * var5;
      var11.field1325 = var6;
      var11.field1326 = var4;
      return var5;
   }

   @ObfuscatedName("bh")
   static int method1429(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class67 var13, int var14, int var15) {
      var13.field1325 -= var13.field1323 * var5;
      if(var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      byte var16;
      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         var16 = var2[var1];
         var0 = (var16 << 8) + (var2[var1 + 1] - var16) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      if(var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14 - 1) / var14) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for(var1 = var15; var5 < var10; var4 += var14) {
         var16 = var2[var4 >> 8];
         var0 = (var16 << 8) + (var1 - var16) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field1325 += var13.field1323 * var5;
      var13.field1333 = var6;
      var13.field1328 = var7;
      var13.field1326 = var4;
      return var5;
   }

   @ObfuscatedName("be")
   static int method1430(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class67 var11, int var12, int var13) {
      var11.field1333 -= var11.field1334 * var5;
      var11.field1328 -= var11.field1335 * var5;
      if(var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      int var10001;
      while(var5 < var8) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var2[var1] - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var0 = var13;

      for(var1 = var12; var5 < var8; var4 += var1) {
         var10001 = var5++;
         var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field1333 += var11.field1334 * var5;
      var11.field1328 += var11.field1335 * var5;
      var11.field1325 = var6;
      var11.field1326 = var4;
      return var5;
   }

   @ObfuscatedName("bq")
   static int method1431(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class67 var13, int var14, int var15) {
      var13.field1325 -= var13.field1323 * var5;
      if(var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         byte var16 = var2[var1 - 1];
         var0 = (var16 << 8) + (var2[var1] - var16) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      if(var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for(var1 = var15; var5 < var10; var4 += var14) {
         var0 = (var1 << 8) + (var2[var4 >> 8] - var1) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field1325 += var13.field1323 * var5;
      var13.field1333 = var6;
      var13.field1328 = var7;
      var13.field1326 = var4;
      return var5;
   }

   @ObfuscatedName("m")
   static int method1434(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("l")
   protected class69 vmethod3775() {
      return null;
   }

   @ObfuscatedName("f")
   public synchronized void method1495(int var1) {
      int var2 = ((class65)super.field1338).field1305.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1326 = var1;
   }

   @ObfuscatedName("v")
   public synchronized void vmethod3779(int var1) {
      if(this.field1332 > 0) {
         if(var1 >= this.field1332) {
            if(this.field1330 == Integer.MIN_VALUE) {
               this.field1330 = 0;
               this.field1328 = 0;
               this.field1333 = 0;
               this.field1325 = 0;
               this.method3990();
               var1 = this.field1332;
            }

            this.field1332 = 0;
            this.method1391();
         } else {
            this.field1325 += this.field1323 * var1;
            this.field1333 += this.field1334 * var1;
            this.field1328 += this.field1335 * var1;
            this.field1332 -= var1;
         }
      }

      class65 var2 = (class65)super.field1338;
      int var3 = this.field1329 << 8;
      int var4 = this.field1321 << 8;
      int var5 = var2.field1305.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1331 = 0;
      }

      if(this.field1326 < 0) {
         if(this.field1322 <= 0) {
            this.method1393();
            this.method3990();
            return;
         }

         this.field1326 = 0;
      }

      if(this.field1326 >= var5) {
         if(this.field1322 >= 0) {
            this.method1393();
            this.method3990();
            return;
         }

         this.field1326 = var5 - 1;
      }

      this.field1326 += this.field1322 * var1;
      if(this.field1331 < 0) {
         if(!this.field1327) {
            if(this.field1322 < 0) {
               if(this.field1326 >= var3) {
                  return;
               }

               this.field1326 = var4 - 1 - (var4 - 1 - this.field1326) % var6;
            } else {
               if(this.field1326 < var4) {
                  return;
               }

               this.field1326 = var3 + (this.field1326 - var3) % var6;
            }

         } else {
            if(this.field1322 < 0) {
               if(this.field1326 >= var3) {
                  return;
               }

               this.field1326 = var3 + var3 - 1 - this.field1326;
               this.field1322 = -this.field1322;
            }

            while(this.field1326 >= var4) {
               this.field1326 = var4 + var4 - 1 - this.field1326;
               this.field1322 = -this.field1322;
               if(this.field1326 >= var3) {
                  return;
               }

               this.field1326 = var3 + var3 - 1 - this.field1326;
               this.field1322 = -this.field1322;
            }

         }
      } else {
         if(this.field1331 > 0) {
            if(this.field1327) {
               label171: {
                  if(this.field1322 < 0) {
                     if(this.field1326 >= var3) {
                        return;
                     }

                     this.field1326 = var3 + var3 - 1 - this.field1326;
                     this.field1322 = -this.field1322;
                     if(--this.field1331 == 0) {
                        break label171;
                     }
                  }

                  do {
                     if(this.field1326 < var4) {
                        return;
                     }

                     this.field1326 = var4 + var4 - 1 - this.field1326;
                     this.field1322 = -this.field1322;
                     if(--this.field1331 == 0) {
                        break;
                     }

                     if(this.field1326 >= var3) {
                        return;
                     }

                     this.field1326 = var3 + var3 - 1 - this.field1326;
                     this.field1322 = -this.field1322;
                  } while(--this.field1331 != 0);
               }
            } else {
               label203: {
                  int var7;
                  if(this.field1322 < 0) {
                     if(this.field1326 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1326) / var6;
                     if(var7 >= this.field1331) {
                        this.field1326 += var6 * this.field1331;
                        this.field1331 = 0;
                        break label203;
                     }

                     this.field1326 += var6 * var7;
                     this.field1331 -= var7;
                  } else {
                     if(this.field1326 < var4) {
                        return;
                     }

                     var7 = (this.field1326 - var3) / var6;
                     if(var7 >= this.field1331) {
                        this.field1326 -= var6 * this.field1331;
                        this.field1331 = 0;
                        break label203;
                     }

                     this.field1326 -= var6 * var7;
                     this.field1331 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1322 < 0) {
            if(this.field1326 < 0) {
               this.field1326 = -1;
               this.method1393();
               this.method3990();
            }
         } else if(this.field1326 >= var5) {
            this.field1326 = var5;
            this.method1393();
            this.method3990();
         }

      }
   }

   @ObfuscatedName("j")
   protected class69 vmethod3776() {
      return null;
   }

   @ObfuscatedName("ac")
   static int method1514(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class67 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if((var7 = var4 + var9 - var3) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var10001;
      byte var11;
      for(var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      var10.field1326 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("as")
   static int method1521(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class67 var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if((var5 = var3 + var7 - var2) > var6) {
         var5 = var6;
      }

      int var10001;
      for(var5 -= 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var10001 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
         var10001 = var3++;
      }

      var8.field1326 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("x")
   public synchronized void vmethod3778(int[] var1, int var2, int var3) {
      if(this.field1330 == 0 && this.field1332 == 0) {
         this.vmethod3779(var3);
      } else {
         class65 var4 = (class65)super.field1338;
         int var5 = this.field1329 << 8;
         int var6 = this.field1321 << 8;
         int var7 = var4.field1305.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1331 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1326 < 0) {
            if(this.field1322 <= 0) {
               this.method1393();
               this.method3990();
               return;
            }

            this.field1326 = 0;
         }

         if(this.field1326 >= var7) {
            if(this.field1322 >= 0) {
               this.method1393();
               this.method3990();
               return;
            }

            this.field1326 = var7 - 1;
         }

         if(this.field1331 < 0) {
            if(this.field1327) {
               if(this.field1322 < 0) {
                  var9 = this.method1530(var1, var2, var5, var3, var4.field1305[this.field1329]);
                  if(this.field1326 >= var5) {
                     return;
                  }

                  this.field1326 = var5 + var5 - 1 - this.field1326;
                  this.field1322 = -this.field1322;
               }

               while(true) {
                  var9 = this.method1413(var1, var9, var6, var3, var4.field1305[this.field1321 - 1]);
                  if(this.field1326 < var6) {
                     return;
                  }

                  this.field1326 = var6 + var6 - 1 - this.field1326;
                  this.field1322 = -this.field1322;
                  var9 = this.method1530(var1, var9, var5, var3, var4.field1305[this.field1329]);
                  if(this.field1326 >= var5) {
                     return;
                  }

                  this.field1326 = var5 + var5 - 1 - this.field1326;
                  this.field1322 = -this.field1322;
               }
            } else if(this.field1322 < 0) {
               while(true) {
                  var9 = this.method1530(var1, var9, var5, var3, var4.field1305[this.field1321 - 1]);
                  if(this.field1326 >= var5) {
                     return;
                  }

                  this.field1326 = var6 - 1 - (var6 - 1 - this.field1326) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1413(var1, var9, var6, var3, var4.field1305[this.field1329]);
                  if(this.field1326 < var6) {
                     return;
                  }

                  this.field1326 = var5 + (this.field1326 - var5) % var8;
               }
            }
         } else {
            if(this.field1331 > 0) {
               if(this.field1327) {
                  label183: {
                     if(this.field1322 < 0) {
                        var9 = this.method1530(var1, var2, var5, var3, var4.field1305[this.field1329]);
                        if(this.field1326 >= var5) {
                           return;
                        }

                        this.field1326 = var5 + var5 - 1 - this.field1326;
                        this.field1322 = -this.field1322;
                        if(--this.field1331 == 0) {
                           break label183;
                        }
                     }

                     do {
                        var9 = this.method1413(var1, var9, var6, var3, var4.field1305[this.field1321 - 1]);
                        if(this.field1326 < var6) {
                           return;
                        }

                        this.field1326 = var6 + var6 - 1 - this.field1326;
                        this.field1322 = -this.field1322;
                        if(--this.field1331 == 0) {
                           break;
                        }

                        var9 = this.method1530(var1, var9, var5, var3, var4.field1305[this.field1329]);
                        if(this.field1326 >= var5) {
                           return;
                        }

                        this.field1326 = var5 + var5 - 1 - this.field1326;
                        this.field1322 = -this.field1322;
                     } while(--this.field1331 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1322 < 0) {
                     while(true) {
                        var9 = this.method1530(var1, var9, var5, var3, var4.field1305[this.field1321 - 1]);
                        if(this.field1326 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1326) / var8;
                        if(var10 >= this.field1331) {
                           this.field1326 += var8 * this.field1331;
                           this.field1331 = 0;
                           break;
                        }

                        this.field1326 += var8 * var10;
                        this.field1331 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1413(var1, var9, var6, var3, var4.field1305[this.field1329]);
                        if(this.field1326 < var6) {
                           return;
                        }

                        var10 = (this.field1326 - var5) / var8;
                        if(var10 >= this.field1331) {
                           this.field1326 -= var8 * this.field1331;
                           this.field1331 = 0;
                           break;
                        }

                        this.field1326 -= var8 * var10;
                        this.field1331 -= var10;
                     }
                  }
               }
            }

            if(this.field1322 < 0) {
               this.method1530(var1, var9, 0, var3, 0);
               if(this.field1326 < 0) {
                  this.field1326 = -1;
                  this.method1393();
                  this.method3990();
               }
            } else {
               this.method1413(var1, var9, var7, var3, 0);
               if(this.field1326 >= var7) {
                  this.field1326 = var7;
                  this.method1393();
                  this.method3990();
               }
            }

         }
      }
   }

   @ObfuscatedName("ay")
   int method1530(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1332 > 0) {
            int var6 = var2 + this.field1332;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1332 += var2;
            if(this.field1322 == -256 && (this.field1326 & 255) == 0) {
               if(class59.field1247) {
                  var2 = method1427(0, ((class65)super.field1338).field1305, var1, this.field1326, var2, this.field1333, this.field1328, this.field1334, this.field1335, 0, var6, var3, this);
               } else {
                  var2 = method1426(((class65)super.field1338).field1305, var1, this.field1326, var2, this.field1325, this.field1323, 0, var6, var3, this);
               }
            } else if(class59.field1247) {
               var2 = method1431(0, 0, ((class65)super.field1338).field1305, var1, this.field1326, var2, this.field1333, this.field1328, this.field1334, this.field1335, 0, var6, var3, this, this.field1322, var5);
            } else {
               var2 = method1430(0, 0, ((class65)super.field1338).field1305, var1, this.field1326, var2, this.field1325, this.field1323, 0, var6, var3, this, this.field1322, var5);
            }

            this.field1332 -= var2;
            if(this.field1332 != 0) {
               return var2;
            }

            if(!this.method1415()) {
               continue;
            }

            return var4;
         }

         if(this.field1322 == -256 && (this.field1326 & 255) == 0) {
            if(class59.field1247) {
               return method1419(0, ((class65)super.field1338).field1305, var1, this.field1326, var2, this.field1333, this.field1328, 0, var4, var3, this);
            }

            return method1418(((class65)super.field1338).field1305, var1, this.field1326, var2, this.field1325, 0, var4, var3, this);
         }

         if(class59.field1247) {
            return method1412(0, 0, ((class65)super.field1338).field1305, var1, this.field1326, var2, this.field1333, this.field1328, 0, var4, var3, this, this.field1322, var5);
         }

         return method1409(0, 0, ((class65)super.field1338).field1305, var1, this.field1326, var2, this.field1325, 0, var4, var3, this, this.field1322, var5);
      }
   }
}
