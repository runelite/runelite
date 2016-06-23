import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
public class class64 extends class66 {
   @ObfuscatedName("x")
   int field1263;
   @ObfuscatedName("u")
   int field1264;
   @ObfuscatedName("s")
   int field1265;
   @ObfuscatedName("b")
   int field1266;
   @ObfuscatedName("f")
   int field1267;
   @ObfuscatedName("d")
   int field1268;
   @ObfuscatedName("n")
   int field1269;
   @ObfuscatedName("m")
   int field1270;
   @ObfuscatedName("g")
   int field1271;
   @ObfuscatedName("l")
   int field1272;
   @ObfuscatedName("r")
   boolean field1273;
   @ObfuscatedName("k")
   int field1274;
   @ObfuscatedName("o")
   int field1275;
   @ObfuscatedName("q")
   int field1276;
   @ObfuscatedName("p")
   int field1277;

   @ObfuscatedName("u")
   static int method1358(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ah")
   int vmethod1519() {
      int var1 = this.field1272 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1270 == 0) {
         var1 -= var1 * this.field1267 / (((class62)super.field1281).field1247.length << 8);
      } else if(this.field1270 >= 0) {
         var1 -= var1 * this.field1271 / ((class62)super.field1281).field1247.length;
      }

      return var1 > 255?255:var1;
   }

   class64(class62 var1, int var2, int var3) {
      super.field1281 = var1;
      this.field1271 = var1.field1246;
      this.field1265 = var1.field1249;
      this.field1273 = var1.field1250;
      this.field1264 = var2;
      this.field1263 = var3;
      this.field1266 = 8192;
      this.field1267 = 0;
      this.method1414();
   }

   @ObfuscatedName("x")
   public static class64 method1361(class62 var0, int var1, int var2) {
      return var0.field1247 != null && var0.field1247.length != 0?new class64(var0, (int)((long)var0.field1248 * 256L * (long)var1 / (long)(class56.field1196 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("b")
   public static class64 method1362(class62 var0, int var1, int var2, int var3) {
      return var0.field1247 != null && var0.field1247.length != 0?new class64(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("k")
   public synchronized void method1365(int var1) {
      this.method1452(var1 << 6, this.method1369());
   }

   @ObfuscatedName("h")
   public synchronized int method1369() {
      return this.field1266 < 0?-1:this.field1266;
   }

   @ObfuscatedName("e")
   public synchronized void method1370(int var1) {
      int var2 = ((class62)super.field1281).field1247.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1267 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1371() {
      this.field1264 = (this.field1264 ^ this.field1264 >> 31) + (this.field1264 >>> 31);
      this.field1264 = -this.field1264;
   }

   @ObfuscatedName("w")
   void method1372() {
      if(this.field1274 != 0) {
         if(this.field1263 == Integer.MIN_VALUE) {
            this.field1263 = 0;
         }

         this.field1274 = 0;
         this.method1414();
      }

   }

   @ObfuscatedName("ac")
   public synchronized void method1375(int var1) {
      if(var1 == 0) {
         this.method1397(0);
         this.method3946();
      } else if(this.field1268 == 0 && this.field1269 == 0) {
         this.field1274 = 0;
         this.field1263 = 0;
         this.field1272 = 0;
         this.method3946();
      } else {
         int var2 = -this.field1272;
         if(this.field1272 > var2) {
            var2 = this.field1272;
         }

         if(-this.field1268 > var2) {
            var2 = -this.field1268;
         }

         if(this.field1268 > var2) {
            var2 = this.field1268;
         }

         if(-this.field1269 > var2) {
            var2 = -this.field1269;
         }

         if(this.field1269 > var2) {
            var2 = this.field1269;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1274 = var1;
         this.field1263 = Integer.MIN_VALUE;
         this.field1275 = -this.field1272 / var1;
         this.field1276 = -this.field1268 / var1;
         this.field1277 = -this.field1269 / var1;
      }
   }

   @ObfuscatedName("d")
   protected class66 vmethod3760() {
      return null;
   }

   @ObfuscatedName("n")
   protected class66 vmethod3752() {
      return null;
   }

   @ObfuscatedName("m")
   protected int vmethod3753() {
      return this.field1263 == 0 && this.field1274 == 0?0:1;
   }

   @ObfuscatedName("s")
   public synchronized void method1383(int var1) {
      this.field1270 = var1;
   }

   @ObfuscatedName("r")
   public synchronized void vmethod3755(int var1) {
      if(this.field1274 > 0) {
         if(var1 >= this.field1274) {
            if(this.field1263 == Integer.MIN_VALUE) {
               this.field1263 = 0;
               this.field1269 = 0;
               this.field1268 = 0;
               this.field1272 = 0;
               this.method3946();
               var1 = this.field1274;
            }

            this.field1274 = 0;
            this.method1414();
         } else {
            this.field1272 += this.field1275 * var1;
            this.field1268 += this.field1276 * var1;
            this.field1269 += this.field1277 * var1;
            this.field1274 -= var1;
         }
      }

      class62 var2 = (class62)super.field1281;
      int var3 = this.field1271 << 8;
      int var4 = this.field1265 << 8;
      int var5 = var2.field1247.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1270 = 0;
      }

      if(this.field1267 < 0) {
         if(this.field1264 <= 0) {
            this.method1372();
            this.method3946();
            return;
         }

         this.field1267 = 0;
      }

      if(this.field1267 >= var5) {
         if(this.field1264 >= 0) {
            this.method1372();
            this.method3946();
            return;
         }

         this.field1267 = var5 - 1;
      }

      this.field1267 += this.field1264 * var1;
      if(this.field1270 < 0) {
         if(!this.field1273) {
            if(this.field1264 < 0) {
               if(this.field1267 >= var3) {
                  return;
               }

               this.field1267 = var4 - 1 - (var4 - 1 - this.field1267) % var6;
            } else {
               if(this.field1267 < var4) {
                  return;
               }

               this.field1267 = var3 + (this.field1267 - var3) % var6;
            }

         } else {
            if(this.field1264 < 0) {
               if(this.field1267 >= var3) {
                  return;
               }

               this.field1267 = var3 + var3 - 1 - this.field1267;
               this.field1264 = -this.field1264;
            }

            while(this.field1267 >= var4) {
               this.field1267 = var4 + var4 - 1 - this.field1267;
               this.field1264 = -this.field1264;
               if(this.field1267 >= var3) {
                  return;
               }

               this.field1267 = var3 + var3 - 1 - this.field1267;
               this.field1264 = -this.field1264;
            }

         }
      } else {
         if(this.field1270 > 0) {
            if(this.field1273) {
               label173: {
                  if(this.field1264 < 0) {
                     if(this.field1267 >= var3) {
                        return;
                     }

                     this.field1267 = var3 + var3 - 1 - this.field1267;
                     this.field1264 = -this.field1264;
                     if(--this.field1270 == 0) {
                        break label173;
                     }
                  }

                  do {
                     if(this.field1267 < var4) {
                        return;
                     }

                     this.field1267 = var4 + var4 - 1 - this.field1267;
                     this.field1264 = -this.field1264;
                     if(--this.field1270 == 0) {
                        break;
                     }

                     if(this.field1267 >= var3) {
                        return;
                     }

                     this.field1267 = var3 + var3 - 1 - this.field1267;
                     this.field1264 = -this.field1264;
                  } while(--this.field1270 != 0);
               }
            } else {
               int var7;
               if(this.field1264 < 0) {
                  if(this.field1267 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1267) / var6;
                  if(var7 < this.field1270) {
                     this.field1267 += var6 * var7;
                     this.field1270 -= var7;
                     return;
                  }

                  this.field1267 += var6 * this.field1270;
                  this.field1270 = 0;
               } else {
                  if(this.field1267 < var4) {
                     return;
                  }

                  var7 = (this.field1267 - var3) / var6;
                  if(var7 < this.field1270) {
                     this.field1267 -= var6 * var7;
                     this.field1270 -= var7;
                     return;
                  }

                  this.field1267 -= var6 * this.field1270;
                  this.field1270 = 0;
               }
            }
         }

         if(this.field1264 < 0) {
            if(this.field1267 < 0) {
               this.field1267 = -1;
               this.method1372();
               this.method3946();
            }
         } else if(this.field1267 >= var5) {
            this.field1267 = var5;
            this.method1372();
            this.method3946();
         }

      }
   }

   @ObfuscatedName("ap")
   int method1385(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1274 > 0) {
            int var6 = var2 + this.field1274;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1274 += var2;
            if(this.field1264 == 256 && (this.field1267 & 255) == 0) {
               if(class56.field1200) {
                  var2 = method1415(0, ((class62)super.field1281).field1247, var1, this.field1267, var2, this.field1268, this.field1269, this.field1276, this.field1277, 0, var6, var3, this);
               } else {
                  var2 = method1396(((class62)super.field1281).field1247, var1, this.field1267, var2, this.field1272, this.field1275, 0, var6, var3, this);
               }
            } else if(class56.field1200) {
               var2 = method1479(0, 0, ((class62)super.field1281).field1247, var1, this.field1267, var2, this.field1268, this.field1269, this.field1276, this.field1277, 0, var6, var3, this, this.field1264, var5);
            } else {
               var2 = method1400(0, 0, ((class62)super.field1281).field1247, var1, this.field1267, var2, this.field1272, this.field1275, 0, var6, var3, this, this.field1264, var5);
            }

            this.field1274 -= var2;
            if(this.field1274 != 0) {
               return var2;
            }

            if(!this.method1387()) {
               continue;
            }

            return var4;
         }

         if(this.field1264 == 256 && (this.field1267 & 255) == 0) {
            if(class56.field1200) {
               return method1389(0, ((class62)super.field1281).field1247, var1, this.field1267, var2, this.field1268, this.field1269, 0, var4, var3, this);
            }

            return method1470(((class62)super.field1281).field1247, var1, this.field1267, var2, this.field1272, 0, var4, var3, this);
         }

         if(class56.field1200) {
            return method1393(0, 0, ((class62)super.field1281).field1247, var1, this.field1267, var2, this.field1268, this.field1269, 0, var4, var3, this, this.field1264, var5);
         }

         return method1392(0, 0, ((class62)super.field1281).field1247, var1, this.field1267, var2, this.field1272, 0, var4, var3, this, this.field1264, var5);
      }
   }

   @ObfuscatedName("af")
   int method1386(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1274 > 0) {
            int var6 = var2 + this.field1274;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1274 += var2;
            if(this.field1264 == -256 && (this.field1267 & 255) == 0) {
               if(class56.field1200) {
                  var2 = method1439(0, ((class62)super.field1281).field1247, var1, this.field1267, var2, this.field1268, this.field1269, this.field1276, this.field1277, 0, var6, var3, this);
               } else {
                  var2 = method1503(((class62)super.field1281).field1247, var1, this.field1267, var2, this.field1272, this.field1275, 0, var6, var3, this);
               }
            } else if(class56.field1200) {
               var2 = method1403(0, 0, ((class62)super.field1281).field1247, var1, this.field1267, var2, this.field1268, this.field1269, this.field1276, this.field1277, 0, var6, var3, this, this.field1264, var5);
            } else {
               var2 = method1402(0, 0, ((class62)super.field1281).field1247, var1, this.field1267, var2, this.field1272, this.field1275, 0, var6, var3, this, this.field1264, var5);
            }

            this.field1274 -= var2;
            if(this.field1274 != 0) {
               return var2;
            }

            if(!this.method1387()) {
               continue;
            }

            return var4;
         }

         if(this.field1264 == -256 && (this.field1267 & 255) == 0) {
            if(class56.field1200) {
               return method1391(0, ((class62)super.field1281).field1247, var1, this.field1267, var2, this.field1268, this.field1269, 0, var4, var3, this);
            }

            return method1390(((class62)super.field1281).field1247, var1, this.field1267, var2, this.field1272, 0, var4, var3, this);
         }

         if(class56.field1200) {
            return method1395(0, 0, ((class62)super.field1281).field1247, var1, this.field1267, var2, this.field1268, this.field1269, 0, var4, var3, this, this.field1264, var5);
         }

         return method1394(0, 0, ((class62)super.field1281).field1247, var1, this.field1267, var2, this.field1272, 0, var4, var3, this, this.field1264, var5);
      }
   }

   @ObfuscatedName("aa")
   boolean method1387() {
      int var1 = this.field1263;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1504(var1, this.field1266);
         var3 = method1358(var1, this.field1266);
      }

      if(this.field1272 == var1 && this.field1268 == var2 && this.field1269 == var3) {
         if(this.field1263 == Integer.MIN_VALUE) {
            this.field1263 = 0;
            this.field1269 = 0;
            this.field1268 = 0;
            this.field1272 = 0;
            this.method3946();
            return true;
         } else {
            this.method1414();
            return false;
         }
      } else {
         if(this.field1272 < var1) {
            this.field1275 = 1;
            this.field1274 = var1 - this.field1272;
         } else if(this.field1272 > var1) {
            this.field1275 = -1;
            this.field1274 = this.field1272 - var1;
         } else {
            this.field1275 = 0;
         }

         if(this.field1268 < var2) {
            this.field1276 = 1;
            if(this.field1274 == 0 || this.field1274 > var2 - this.field1268) {
               this.field1274 = var2 - this.field1268;
            }
         } else if(this.field1268 > var2) {
            this.field1276 = -1;
            if(this.field1274 == 0 || this.field1274 > this.field1268 - var2) {
               this.field1274 = this.field1268 - var2;
            }
         } else {
            this.field1276 = 0;
         }

         if(this.field1269 < var3) {
            this.field1277 = 1;
            if(this.field1274 == 0 || this.field1274 > var3 - this.field1269) {
               this.field1274 = var3 - this.field1269;
            }
         } else if(this.field1269 > var3) {
            this.field1277 = -1;
            if(this.field1274 == 0 || this.field1274 > this.field1269 - var3) {
               this.field1274 = this.field1269 - var3;
            }
         } else {
            this.field1277 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("aw")
   static int method1389(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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

      var10.field1267 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ak")
   static int method1390(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1267 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ae")
   static int method1391(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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

      var10.field1267 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ad")
   static int method1392(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
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

      var10.field1267 = var4;
      return var5;
   }

   @ObfuscatedName("au")
   static int method1393(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
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

      var11.field1267 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ar")
   static int method1394(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
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

      var10.field1267 = var4;
      return var5;
   }

   @ObfuscatedName("at")
   static int method1395(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
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

      var11.field1267 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ab")
   static int method1396(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1268 += var9.field1276 * (var6 - var3);
      var9.field1269 += var9.field1277 * (var6 - var3);

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

      var9.field1272 = var4 >> 2;
      var9.field1267 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1397(int var1) {
      this.method1452(var1, this.method1369());
   }

   @ObfuscatedName("bx")
   static int method1400(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1268 -= var11.field1276 * var5;
      var11.field1269 -= var11.field1277 * var5;
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

      var11.field1268 += var11.field1276 * var5;
      var11.field1269 += var11.field1277 * var5;
      var11.field1272 = var6;
      var11.field1267 = var4;
      return var5;
   }

   @ObfuscatedName("bc")
   static int method1402(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1268 -= var11.field1276 * var5;
      var11.field1269 -= var11.field1277 * var5;
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

      var11.field1268 += var11.field1276 * var5;
      var11.field1269 += var11.field1277 * var5;
      var11.field1272 = var6;
      var11.field1267 = var4;
      return var5;
   }

   @ObfuscatedName("ba")
   static int method1403(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1272 -= var13.field1275 * var5;
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
      var13.field1272 += var13.field1275 * var5;
      var13.field1268 = var6;
      var13.field1269 = var7;
      var13.field1267 = var4;
      return var5;
   }

   @ObfuscatedName("an")
   public synchronized int method1407() {
      return this.field1264 < 0?-this.field1264:this.field1264;
   }

   @ObfuscatedName("am")
   public boolean method1408() {
      return this.field1267 < 0 || this.field1267 >= ((class62)super.field1281).field1247.length << 8;
   }

   @ObfuscatedName("y")
   public synchronized void method1411(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1452(var2, var3);
      } else {
         int var4 = method1504(var2, var3);
         int var5 = method1358(var2, var3);
         if(this.field1268 == var4 && this.field1269 == var5) {
            this.field1274 = 0;
         } else {
            int var6 = var2 - this.field1272;
            if(this.field1272 - var2 > var6) {
               var6 = this.field1272 - var2;
            }

            if(var4 - this.field1268 > var6) {
               var6 = var4 - this.field1268;
            }

            if(this.field1268 - var4 > var6) {
               var6 = this.field1268 - var4;
            }

            if(var5 - this.field1269 > var6) {
               var6 = var5 - this.field1269;
            }

            if(this.field1269 - var5 > var6) {
               var6 = this.field1269 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1274 = var1;
            this.field1263 = var2;
            this.field1266 = var3;
            this.field1275 = (var2 - this.field1272) / var1;
            this.field1276 = (var4 - this.field1268) / var1;
            this.field1277 = (var5 - this.field1269) / var1;
         }
      }
   }

   @ObfuscatedName("l")
   void method1414() {
      this.field1272 = this.field1263;
      this.field1268 = method1504(this.field1263, this.field1266);
      this.field1269 = method1358(this.field1263, this.field1266);
   }

   @ObfuscatedName("bp")
   static int method1415(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1272 += var12.field1275 * (var9 - var4);
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

      var12.field1268 = var5 >> 2;
      var12.field1269 = var6 >> 2;
      var12.field1267 = var3 << 8;
      return var4 >> 1;
   }

   class64(class62 var1, int var2, int var3, int var4) {
      super.field1281 = var1;
      this.field1271 = var1.field1246;
      this.field1265 = var1.field1249;
      this.field1273 = var1.field1250;
      this.field1264 = var2;
      this.field1263 = var3;
      this.field1266 = var4;
      this.field1267 = 0;
      this.method1414();
   }

   @ObfuscatedName("bf")
   static int method1439(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1272 += var12.field1275 * (var9 - var4);
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

      var12.field1268 = var5 >> 2;
      var12.field1269 = var6 >> 2;
      var12.field1267 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("q")
   synchronized void method1452(int var1, int var2) {
      this.field1263 = var1;
      this.field1266 = var2;
      this.field1274 = 0;
      this.method1414();
   }

   @ObfuscatedName("p")
   public synchronized int method1460() {
      return this.field1263 == Integer.MIN_VALUE?0:this.field1263;
   }

   @ObfuscatedName("v")
   public synchronized void method1461(int var1, int var2) {
      this.method1411(var1, var2, this.method1369());
   }

   @ObfuscatedName("ay")
   static int method1470(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1267 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bq")
   static int method1479(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1272 -= var13.field1275 * var5;
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
      var13.field1272 += var13.field1275 * var5;
      var13.field1268 = var6;
      var13.field1269 = var7;
      var13.field1267 = var4;
      return var5;
   }

   @ObfuscatedName("g")
   public synchronized void vmethod3764(int[] var1, int var2, int var3) {
      if(this.field1263 == 0 && this.field1274 == 0) {
         this.vmethod3755(var3);
      } else {
         class62 var4 = (class62)super.field1281;
         int var5 = this.field1271 << 8;
         int var6 = this.field1265 << 8;
         int var7 = var4.field1247.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1270 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1267 < 0) {
            if(this.field1264 <= 0) {
               this.method1372();
               this.method3946();
               return;
            }

            this.field1267 = 0;
         }

         if(this.field1267 >= var7) {
            if(this.field1264 >= 0) {
               this.method1372();
               this.method3946();
               return;
            }

            this.field1267 = var7 - 1;
         }

         if(this.field1270 < 0) {
            if(this.field1273) {
               if(this.field1264 < 0) {
                  var9 = this.method1386(var1, var2, var5, var3, var4.field1247[this.field1271]);
                  if(this.field1267 >= var5) {
                     return;
                  }

                  this.field1267 = var5 + var5 - 1 - this.field1267;
                  this.field1264 = -this.field1264;
               }

               while(true) {
                  var9 = this.method1385(var1, var9, var6, var3, var4.field1247[this.field1265 - 1]);
                  if(this.field1267 < var6) {
                     return;
                  }

                  this.field1267 = var6 + var6 - 1 - this.field1267;
                  this.field1264 = -this.field1264;
                  var9 = this.method1386(var1, var9, var5, var3, var4.field1247[this.field1271]);
                  if(this.field1267 >= var5) {
                     return;
                  }

                  this.field1267 = var5 + var5 - 1 - this.field1267;
                  this.field1264 = -this.field1264;
               }
            } else if(this.field1264 < 0) {
               while(true) {
                  var9 = this.method1386(var1, var9, var5, var3, var4.field1247[this.field1265 - 1]);
                  if(this.field1267 >= var5) {
                     return;
                  }

                  this.field1267 = var6 - 1 - (var6 - 1 - this.field1267) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1385(var1, var9, var6, var3, var4.field1247[this.field1271]);
                  if(this.field1267 < var6) {
                     return;
                  }

                  this.field1267 = var5 + (this.field1267 - var5) % var8;
               }
            }
         } else {
            if(this.field1270 > 0) {
               if(this.field1273) {
                  label181: {
                     if(this.field1264 < 0) {
                        var9 = this.method1386(var1, var2, var5, var3, var4.field1247[this.field1271]);
                        if(this.field1267 >= var5) {
                           return;
                        }

                        this.field1267 = var5 + var5 - 1 - this.field1267;
                        this.field1264 = -this.field1264;
                        if(--this.field1270 == 0) {
                           break label181;
                        }
                     }

                     do {
                        var9 = this.method1385(var1, var9, var6, var3, var4.field1247[this.field1265 - 1]);
                        if(this.field1267 < var6) {
                           return;
                        }

                        this.field1267 = var6 + var6 - 1 - this.field1267;
                        this.field1264 = -this.field1264;
                        if(--this.field1270 == 0) {
                           break;
                        }

                        var9 = this.method1386(var1, var9, var5, var3, var4.field1247[this.field1271]);
                        if(this.field1267 >= var5) {
                           return;
                        }

                        this.field1267 = var5 + var5 - 1 - this.field1267;
                        this.field1264 = -this.field1264;
                     } while(--this.field1270 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1264 < 0) {
                     while(true) {
                        var9 = this.method1386(var1, var9, var5, var3, var4.field1247[this.field1265 - 1]);
                        if(this.field1267 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1267) / var8;
                        if(var10 >= this.field1270) {
                           this.field1267 += var8 * this.field1270;
                           this.field1270 = 0;
                           break;
                        }

                        this.field1267 += var8 * var10;
                        this.field1270 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1385(var1, var9, var6, var3, var4.field1247[this.field1271]);
                        if(this.field1267 < var6) {
                           return;
                        }

                        var10 = (this.field1267 - var5) / var8;
                        if(var10 >= this.field1270) {
                           this.field1267 -= var8 * this.field1270;
                           this.field1270 = 0;
                           break;
                        }

                        this.field1267 -= var8 * var10;
                        this.field1270 -= var10;
                     }
                  }
               }
            }

            if(this.field1264 < 0) {
               this.method1386(var1, var9, 0, var3, 0);
               if(this.field1267 < 0) {
                  this.field1267 = -1;
                  this.method1372();
                  this.method3946();
               }
            } else {
               this.method1385(var1, var9, var7, var3, 0);
               if(this.field1267 >= var7) {
                  this.field1267 = var7;
                  this.method1372();
                  this.method3946();
               }
            }

         }
      }
   }

   @ObfuscatedName("aj")
   public synchronized void method1499(int var1) {
      if(this.field1264 < 0) {
         this.field1264 = -var1;
      } else {
         this.field1264 = var1;
      }

   }

   @ObfuscatedName("bo")
   static int method1503(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1268 += var9.field1276 * (var6 - var3);
      var9.field1269 += var9.field1277 * (var6 - var3);

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

      var9.field1272 = var4 >> 2;
      var9.field1267 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("f")
   static int method1504(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("az")
   public boolean method1505() {
      return this.field1274 != 0;
   }
}
