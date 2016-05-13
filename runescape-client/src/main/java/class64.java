import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public class class64 extends class66 {
   @ObfuscatedName("d")
   int field1253;
   @ObfuscatedName("j")
   int field1254;
   @ObfuscatedName("p")
   int field1255;
   @ObfuscatedName("x")
   int field1256;
   @ObfuscatedName("b")
   int field1257;
   @ObfuscatedName("u")
   int field1258;
   @ObfuscatedName("s")
   int field1259;
   @ObfuscatedName("o")
   int field1260;
   @ObfuscatedName("k")
   int field1261;
   @ObfuscatedName("c")
   int field1262;
   @ObfuscatedName("l")
   boolean field1263;
   @ObfuscatedName("t")
   int field1264;
   @ObfuscatedName("i")
   int field1265;
   @ObfuscatedName("r")
   int field1266;
   @ObfuscatedName("m")
   int field1267;

   @ObfuscatedName("j")
   static int method1277(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ao")
   int vmethod1442() {
      int var1 = this.field1253 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1257 == 0) {
         var1 -= var1 * this.field1259 / (((class62)super.field1271).field1237.length << 8);
      } else if(this.field1257 >= 0) {
         var1 -= var1 * this.field1261 / ((class62)super.field1271).field1237.length;
      }

      return var1 > 255?255:var1;
   }

   class64(class62 var1, int var2, int var3, int var4) {
      super.field1271 = var1;
      this.field1261 = var1.field1236;
      this.field1262 = var1.field1239;
      this.field1263 = var1.field1238;
      this.field1254 = var2;
      this.field1255 = var3;
      this.field1256 = var4;
      this.field1259 = 0;
      this.method1410();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass62;II)Lclass64;",
      garbageValue = "100"
   )
   public static class64 method1280(class62 var0, int var1, int var2) {
      return var0.field1237 != null && var0.field1237.length != 0?new class64(var0, (int)((long)var0.field1240 * 256L * (long)var1 / (long)(class56.field1186 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("x")
   public static class64 method1281(class62 var0, int var1, int var2, int var3) {
      return var0.field1237 != null && var0.field1237.length != 0?new class64(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("aa")
   int method1283(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1264 > 0) {
            int var6 = var2 + this.field1264;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1264 += var2;
            if(this.field1254 == -256 && (this.field1259 & 255) == 0) {
               if(class56.field1180) {
                  var2 = method1298(0, ((class62)super.field1271).field1237, var1, this.field1259, var2, this.field1258, this.field1260, this.field1266, this.field1267, 0, var6, var3, this);
               } else {
                  var2 = method1317(((class62)super.field1271).field1237, var1, this.field1259, var2, this.field1253, this.field1265, 0, var6, var3, this);
               }
            } else if(class56.field1180) {
               var2 = method1322(0, 0, ((class62)super.field1271).field1237, var1, this.field1259, var2, this.field1258, this.field1260, this.field1266, this.field1267, 0, var6, var3, this, this.field1254, var5);
            } else {
               var2 = method1321(0, 0, ((class62)super.field1271).field1237, var1, this.field1259, var2, this.field1253, this.field1265, 0, var6, var3, this, this.field1254, var5);
            }

            this.field1264 -= var2;
            if(this.field1264 != 0) {
               return var2;
            }

            if(!this.method1306()) {
               continue;
            }

            return var4;
         }

         if(this.field1254 == -256 && (this.field1259 & 255) == 0) {
            if(class56.field1180) {
               return method1310(0, ((class62)super.field1271).field1237, var1, this.field1259, var2, this.field1258, this.field1260, 0, var4, var3, this);
            }

            return method1309(((class62)super.field1271).field1237, var1, this.field1259, var2, this.field1253, 0, var4, var3, this);
         }

         if(class56.field1180) {
            return method1330(0, 0, ((class62)super.field1271).field1237, var1, this.field1259, var2, this.field1258, this.field1260, 0, var4, var3, this, this.field1254, var5);
         }

         return method1369(0, 0, ((class62)super.field1271).field1237, var1, this.field1259, var2, this.field1253, 0, var4, var3, this, this.field1254, var5);
      }
   }

   @ObfuscatedName("t")
   public synchronized void method1284(int var1) {
      this.method1286(var1 << 6, this.method1346());
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1285(int var1) {
      this.method1286(var1, this.method1346());
   }

   @ObfuscatedName("r")
   synchronized void method1286(int var1, int var2) {
      this.field1255 = var1;
      this.field1256 = var2;
      this.field1264 = 0;
      this.method1410();
   }

   @ObfuscatedName("ai")
   public boolean method1287() {
      return this.field1259 < 0 || this.field1259 >= ((class62)super.field1271).field1237.length << 8;
   }

   @ObfuscatedName("h")
   public synchronized void method1289(int var1) {
      int var2 = ((class62)super.field1271).field1237.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1259 = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1290() {
      this.field1254 = (this.field1254 ^ this.field1254 >> 31) + (this.field1254 >>> 31);
      this.field1254 = -this.field1254;
   }

   @ObfuscatedName("ae")
   public synchronized void method1295(int var1) {
      if(this.field1254 < 0) {
         this.field1254 = -var1;
      } else {
         this.field1254 = var1;
      }

   }

   @ObfuscatedName("as")
   public synchronized int method1296() {
      return this.field1254 < 0?-this.field1254:this.field1254;
   }

   @ObfuscatedName("at")
   static int method1297(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var9 - var4 + var11 - 257) / var11) > var8) {
         var7 = var8;
      }

      byte var13;
      int var14;
      while(var5 < var7) {
         var1 = var4 >> 8;
         var13 = var2[var1];
         var14 = var5++;
         var3[var14] += ((var13 << 8) + (var2[var1 + 1] - var13) * (var4 & 255)) * var6 >> 6;
         var4 += var11;
      }

      if(var11 == 0 || (var7 = var5 + (var9 - var4 + var11 - 1) / var11) > var8) {
         var7 = var8;
      }

      for(var1 = var12; var5 < var7; var4 += var11) {
         var13 = var2[var4 >> 8];
         var14 = var5++;
         var3[var14] += ((var13 << 8) + (var1 - var13) * (var4 & 255)) * var6 >> 6;
      }

      var10.field1259 = var4;
      return var5;
   }

   @ObfuscatedName("az")
   static int method1298(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1253 += var12.field1265 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var14;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      var12.field1258 = var5 >> 2;
      var12.field1260 = var6 >> 2;
      var12.field1259 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("u")
   protected class66 vmethod3709() {
      return null;
   }

   @ObfuscatedName("o")
   protected class66 vmethod3704() {
      return null;
   }

   @ObfuscatedName("l")
   public synchronized void vmethod3707(int var1) {
      if(this.field1264 > 0) {
         if(var1 >= this.field1264) {
            if(this.field1255 == Integer.MIN_VALUE) {
               this.field1255 = 0;
               this.field1260 = 0;
               this.field1258 = 0;
               this.field1253 = 0;
               this.method3898();
               var1 = this.field1264;
            }

            this.field1264 = 0;
            this.method1410();
         } else {
            this.field1253 += this.field1265 * var1;
            this.field1258 += this.field1266 * var1;
            this.field1260 += this.field1267 * var1;
            this.field1264 -= var1;
         }
      }

      class62 var2 = (class62)super.field1271;
      int var3 = this.field1261 << 8;
      int var4 = this.field1262 << 8;
      int var5 = var2.field1237.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1257 = 0;
      }

      if(this.field1259 < 0) {
         if(this.field1254 <= 0) {
            this.method1418();
            this.method3898();
            return;
         }

         this.field1259 = 0;
      }

      if(this.field1259 >= var5) {
         if(this.field1254 >= 0) {
            this.method1418();
            this.method3898();
            return;
         }

         this.field1259 = var5 - 1;
      }

      this.field1259 += this.field1254 * var1;
      if(this.field1257 < 0) {
         if(!this.field1263) {
            if(this.field1254 < 0) {
               if(this.field1259 >= var3) {
                  return;
               }

               this.field1259 = var4 - 1 - (var4 - 1 - this.field1259) % var6;
            } else {
               if(this.field1259 < var4) {
                  return;
               }

               this.field1259 = var3 + (this.field1259 - var3) % var6;
            }
         } else {
            if(this.field1254 < 0) {
               if(this.field1259 >= var3) {
                  return;
               }

               this.field1259 = var3 + var3 - 1 - this.field1259;
               this.field1254 = -this.field1254;
            }

            while(this.field1259 >= var4) {
               this.field1259 = var4 + var4 - 1 - this.field1259;
               this.field1254 = -this.field1254;
               if(this.field1259 >= var3) {
                  return;
               }

               this.field1259 = var3 + var3 - 1 - this.field1259;
               this.field1254 = -this.field1254;
            }
         }
      } else {
         if(this.field1257 > 0) {
            if(this.field1263) {
               label113: {
                  if(this.field1254 < 0) {
                     if(this.field1259 >= var3) {
                        return;
                     }

                     this.field1259 = var3 + var3 - 1 - this.field1259;
                     this.field1254 = -this.field1254;
                     if(--this.field1257 == 0) {
                        break label113;
                     }
                  }

                  do {
                     if(this.field1259 < var4) {
                        return;
                     }

                     this.field1259 = var4 + var4 - 1 - this.field1259;
                     this.field1254 = -this.field1254;
                     if(--this.field1257 == 0) {
                        break;
                     }

                     if(this.field1259 >= var3) {
                        return;
                     }

                     this.field1259 = var3 + var3 - 1 - this.field1259;
                     this.field1254 = -this.field1254;
                  } while(--this.field1257 != 0);
               }
            } else {
               int var7;
               if(this.field1254 < 0) {
                  if(this.field1259 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1259) / var6;
                  if(var7 < this.field1257) {
                     this.field1259 += var6 * var7;
                     this.field1257 -= var7;
                     return;
                  }

                  this.field1259 += var6 * this.field1257;
                  this.field1257 = 0;
               } else {
                  if(this.field1259 < var4) {
                     return;
                  }

                  var7 = (this.field1259 - var3) / var6;
                  if(var7 < this.field1257) {
                     this.field1259 -= var6 * var7;
                     this.field1257 -= var7;
                     return;
                  }

                  this.field1259 -= var6 * this.field1257;
                  this.field1257 = 0;
               }
            }
         }

         if(this.field1254 < 0) {
            if(this.field1259 < 0) {
               this.field1259 = -1;
               this.method1418();
               this.method3898();
            }
         } else if(this.field1259 >= var5) {
            this.field1259 = var5;
            this.method1418();
            this.method3898();
         }
      }

   }

   @ObfuscatedName("aq")
   boolean method1306() {
      int var1 = this.field1255;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1437(var1, this.field1256);
         var3 = method1277(var1, this.field1256);
      }

      if(this.field1253 == var1 && this.field1258 == var2 && this.field1260 == var3) {
         if(this.field1255 == Integer.MIN_VALUE) {
            this.field1255 = 0;
            this.field1260 = 0;
            this.field1258 = 0;
            this.field1253 = 0;
            this.method3898();
            return true;
         } else {
            this.method1410();
            return false;
         }
      } else {
         if(this.field1253 < var1) {
            this.field1265 = 1;
            this.field1264 = var1 - this.field1253;
         } else if(this.field1253 > var1) {
            this.field1265 = -1;
            this.field1264 = this.field1253 - var1;
         } else {
            this.field1265 = 0;
         }

         if(this.field1258 < var2) {
            this.field1266 = 1;
            if(this.field1264 == 0 || this.field1264 > var2 - this.field1258) {
               this.field1264 = var2 - this.field1258;
            }
         } else if(this.field1258 > var2) {
            this.field1266 = -1;
            if(this.field1264 == 0 || this.field1264 > this.field1258 - var2) {
               this.field1264 = this.field1258 - var2;
            }
         } else {
            this.field1266 = 0;
         }

         if(this.field1260 < var3) {
            this.field1267 = 1;
            if(this.field1264 == 0 || this.field1264 > var3 - this.field1260) {
               this.field1264 = var3 - this.field1260;
            }
         } else if(this.field1260 > var3) {
            this.field1267 = -1;
            if(this.field1264 == 0 || this.field1264 > this.field1260 - var3) {
               this.field1264 = this.field1260 - var3;
            }
         } else {
            this.field1267 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ay")
   static int method1307(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if((var5 = var3 + var7 - var2) > var6) {
         var5 = var6;
      }

      int var9;
      for(var5 -= 3; var3 < var5; var1[var9] += var0[var2++] * var4) {
         var9 = var3++;
         var1[var9] += var0[var2++] * var4;
         var9 = var3++;
         var1[var9] += var0[var2++] * var4;
         var9 = var3++;
         var1[var9] += var0[var2++] * var4;
         var9 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var9] += var0[var2++] * var4) {
         var9 = var3++;
      }

      var8.field1259 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("aj")
   static int method1308(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if((var7 = var4 + var9 - var3) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var11;
      byte var12;
      for(var7 -= 6; var4 < var7; var2[var11] += var12 * var6) {
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var11] += var12 * var6) {
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
      }

      var10.field1259 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ar")
   static int method1309(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if((var5 = var3 + var2 - (var7 - 1)) > var6) {
         var5 = var6;
      }

      int var9;
      for(var5 -= 3; var3 < var5; var1[var9] += var0[var2--] * var4) {
         var9 = var3++;
         var1[var9] += var0[var2--] * var4;
         var9 = var3++;
         var1[var9] += var0[var2--] * var4;
         var9 = var3++;
         var1[var9] += var0[var2--] * var4;
         var9 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var9] += var0[var2--] * var4) {
         var9 = var3++;
      }

      var8.field1259 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("aw")
   static int method1310(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if((var7 = var4 + var3 - (var9 - 1)) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var11;
      byte var12;
      for(var7 -= 6; var4 < var7; var2[var11] += var12 * var6) {
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var11] += var12 * var6) {
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
      }

      var10.field1259 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bt")
   static int method1313(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1253 -= var13.field1265 * var5;
      if(var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      byte var16;
      int var17;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         var16 = var2[var1];
         var0 = (var16 << 8) + (var2[var1 + 1] - var16) * (var4 & 255);
         var17 = var5++;
         var3[var17] += var0 * var6 >> 6;
         var6 += var8;
         var17 = var5++;
         var3[var17] += var0 * var7 >> 6;
         var7 += var9;
      }

      if(var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14 - 1) / var14) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for(var1 = var15; var5 < var10; var4 += var14) {
         var16 = var2[var4 >> 8];
         var0 = (var16 << 8) + (var1 - var16) * (var4 & 255);
         var17 = var5++;
         var3[var17] += var0 * var6 >> 6;
         var6 += var8;
         var17 = var5++;
         var3[var17] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field1253 += var13.field1265 * var5;
      var13.field1258 = var6;
      var13.field1260 = var7;
      var13.field1259 = var4;
      return var5;
   }

   @ObfuscatedName("ac")
   static int method1315(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1258 += var9.field1266 * (var6 - var3);
      var9.field1260 += var9.field1267 * (var6 - var3);

      int var10;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10 = var3++;
         var1[var10] += var0[var2++] * var4;
         var4 += var5;
         var10 = var3++;
         var1[var10] += var0[var2++] * var4;
         var4 += var5;
         var10 = var3++;
         var1[var10] += var0[var2++] * var4;
         var4 += var5;
         var10 = var3++;
         var1[var10] += var0[var2++] * var4;
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10 = var3++;
         var1[var10] += var0[var2++] * var4;
      }

      var9.field1253 = var4 >> 2;
      var9.field1259 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ak")
   static int method1316(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1253 += var12.field1265 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var14;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      var12.field1258 = var5 >> 2;
      var12.field1260 = var6 >> 2;
      var12.field1259 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("av")
   static int method1317(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1258 += var9.field1266 * (var6 - var3);
      var9.field1260 += var9.field1267 * (var6 - var3);

      int var10;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10 = var3++;
         var1[var10] += var0[var2--] * var4;
         var4 += var5;
         var10 = var3++;
         var1[var10] += var0[var2--] * var4;
         var4 += var5;
         var10 = var3++;
         var1[var10] += var0[var2--] * var4;
         var4 += var5;
         var10 = var3++;
         var1[var10] += var0[var2--] * var4;
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10 = var3++;
         var1[var10] += var0[var2--] * var4;
      }

      var9.field1253 = var4 >> 2;
      var9.field1259 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bd")
   static int method1319(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1258 -= var11.field1266 * var5;
      var11.field1260 -= var11.field1267 * var5;
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      byte var14;
      int var15;
      while(var5 < var8) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var15 = var5++;
         var3[var15] += ((var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      for(var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var15 = var5++;
         var3[var15] += ((var14 << 8) + (var1 - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field1258 += var11.field1266 * var5;
      var11.field1260 += var11.field1267 * var5;
      var11.field1253 = var6;
      var11.field1259 = var4;
      return var5;
   }

   @ObfuscatedName("bq")
   static int method1321(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1258 -= var11.field1266 * var5;
      var11.field1260 -= var11.field1267 * var5;
      if(var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      int var14;
      while(var5 < var8) {
         var1 = var4 >> 8;
         byte var15 = var2[var1 - 1];
         var14 = var5++;
         var3[var14] += ((var15 << 8) + (var2[var1] - var15) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var0 = var13;

      for(var1 = var12; var5 < var8; var4 += var1) {
         var14 = var5++;
         var3[var14] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field1258 += var11.field1266 * var5;
      var11.field1260 += var11.field1267 * var5;
      var11.field1253 = var6;
      var11.field1259 = var4;
      return var5;
   }

   @ObfuscatedName("bj")
   static int method1322(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1253 -= var13.field1265 * var5;
      if(var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      int var16;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         byte var17 = var2[var1 - 1];
         var0 = (var17 << 8) + (var2[var1] - var17) * (var4 & 255);
         var16 = var5++;
         var3[var16] += var0 * var6 >> 6;
         var6 += var8;
         var16 = var5++;
         var3[var16] += var0 * var7 >> 6;
         var7 += var9;
      }

      if(var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for(var1 = var15; var5 < var10; var4 += var14) {
         var0 = (var1 << 8) + (var2[var4 >> 8] - var1) * (var4 & 255);
         var16 = var5++;
         var3[var16] += var0 * var6 >> 6;
         var6 += var8;
         var16 = var5++;
         var3[var16] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field1253 += var13.field1265 * var5;
      var13.field1258 = var6;
      var13.field1260 = var7;
      var13.field1259 = var4;
      return var5;
   }

   class64(class62 var1, int var2, int var3) {
      super.field1271 = var1;
      this.field1261 = var1.field1236;
      this.field1262 = var1.field1239;
      this.field1263 = var1.field1238;
      this.field1254 = var2;
      this.field1255 = var3;
      this.field1256 = 8192;
      this.field1259 = 0;
      this.method1410();
   }

   @ObfuscatedName("ah")
   public boolean method1326() {
      return this.field1264 != 0;
   }

   @ObfuscatedName("ag")
   static int method1330(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      int var14;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         byte var15 = var2[var1 - 1];
         var0 = (var15 << 8) + (var2[var1] - var15) * (var4 & 255);
         var14 = var5++;
         var3[var14] += var0 * var6 >> 6;
         var14 = var5++;
         var3[var14] += var0 * var7 >> 6;
      }

      if(var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for(var1 = var13; var5 < var8; var4 += var12) {
         var0 = (var1 << 8) + (var2[var4 >> 8] - var1) * (var4 & 255);
         var14 = var5++;
         var3[var14] += var0 * var6 >> 6;
         var14 = var5++;
         var3[var14] += var0 * var7 >> 6;
      }

      var11.field1259 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("e")
   public synchronized int method1346() {
      return this.field1256 < 0?-1:this.field1256;
   }

   @ObfuscatedName("m")
   public synchronized int method1354() {
      return this.field1255 == Integer.MIN_VALUE?0:this.field1255;
   }

   @ObfuscatedName("ax")
   int method1363(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1264 > 0) {
            int var6 = var2 + this.field1264;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1264 += var2;
            if(this.field1254 == 256 && (this.field1259 & 255) == 0) {
               if(class56.field1180) {
                  var2 = method1316(0, ((class62)super.field1271).field1237, var1, this.field1259, var2, this.field1258, this.field1260, this.field1266, this.field1267, 0, var6, var3, this);
               } else {
                  var2 = method1315(((class62)super.field1271).field1237, var1, this.field1259, var2, this.field1253, this.field1265, 0, var6, var3, this);
               }
            } else if(class56.field1180) {
               var2 = method1313(0, 0, ((class62)super.field1271).field1237, var1, this.field1259, var2, this.field1258, this.field1260, this.field1266, this.field1267, 0, var6, var3, this, this.field1254, var5);
            } else {
               var2 = method1319(0, 0, ((class62)super.field1271).field1237, var1, this.field1259, var2, this.field1253, this.field1265, 0, var6, var3, this, this.field1254, var5);
            }

            this.field1264 -= var2;
            if(this.field1264 != 0) {
               return var2;
            }

            if(!this.method1306()) {
               continue;
            }

            return var4;
         }

         if(this.field1254 == 256 && (this.field1259 & 255) == 0) {
            if(class56.field1180) {
               return method1308(0, ((class62)super.field1271).field1237, var1, this.field1259, var2, this.field1258, this.field1260, 0, var4, var3, this);
            }

            return method1307(((class62)super.field1271).field1237, var1, this.field1259, var2, this.field1253, 0, var4, var3, this);
         }

         if(class56.field1180) {
            return method1388(0, 0, ((class62)super.field1271).field1237, var1, this.field1259, var2, this.field1258, this.field1260, 0, var4, var3, this, this.field1254, var5);
         }

         return method1297(0, 0, ((class62)super.field1271).field1237, var1, this.field1259, var2, this.field1253, 0, var4, var3, this, this.field1254, var5);
      }
   }

   @ObfuscatedName("al")
   static int method1369(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var9 + 256 - var4 + var11) / var11) > var8) {
         var7 = var8;
      }

      int var13;
      while(var5 < var7) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var13 = var5++;
         var3[var13] += ((var14 << 8) + (var2[var1] - var14) * (var4 & 255)) * var6 >> 6;
         var4 += var11;
      }

      if(var11 == 0 || (var7 = var5 + (var9 - var4 + var11) / var11) > var8) {
         var7 = var8;
      }

      var0 = var12;

      for(var1 = var11; var5 < var7; var4 += var1) {
         var13 = var5++;
         var3[var13] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
      }

      var10.field1259 = var4;
      return var5;
   }

   @ObfuscatedName("af")
   static int method1388(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      byte var14;
      int var15;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var0 = (var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255);
         var15 = var5++;
         var3[var15] += var0 * var6 >> 6;
         var15 = var5++;
         var3[var15] += var0 * var7 >> 6;
      }

      if(var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for(var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var0 = (var14 << 8) + (var1 - var14) * (var4 & 255);
         var15 = var5++;
         var3[var15] += var0 * var6 >> 6;
         var15 = var5++;
         var3[var15] += var0 * var7 >> 6;
      }

      var11.field1259 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ap")
   public synchronized void method1395(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1286(var2, var3);
      } else {
         int var4 = method1437(var2, var3);
         int var5 = method1277(var2, var3);
         if(this.field1258 == var4 && this.field1260 == var5) {
            this.field1264 = 0;
         } else {
            int var6 = var2 - this.field1253;
            if(this.field1253 - var2 > var6) {
               var6 = this.field1253 - var2;
            }

            if(var4 - this.field1258 > var6) {
               var6 = var4 - this.field1258;
            }

            if(this.field1258 - var4 > var6) {
               var6 = this.field1258 - var4;
            }

            if(var5 - this.field1260 > var6) {
               var6 = var5 - this.field1260;
            }

            if(this.field1260 - var5 > var6) {
               var6 = this.field1260 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1264 = var1;
            this.field1255 = var2;
            this.field1256 = var3;
            this.field1265 = (var2 - this.field1253) / var1;
            this.field1266 = (var4 - this.field1258) / var1;
            this.field1267 = (var5 - this.field1260) / var1;
         }
      }

   }

   @ObfuscatedName("d")
   void method1410() {
      this.field1253 = this.field1255;
      this.field1258 = method1437(this.field1255, this.field1256);
      this.field1260 = method1277(this.field1255, this.field1256);
   }

   @ObfuscatedName("a")
   void method1418() {
      if(this.field1264 != 0) {
         if(this.field1255 == Integer.MIN_VALUE) {
            this.field1255 = 0;
         }

         this.field1264 = 0;
         this.method1410();
      }

   }

   @ObfuscatedName("k")
   public synchronized void vmethod3706(int[] var1, int var2, int var3) {
      if(this.field1255 == 0 && this.field1264 == 0) {
         this.vmethod3707(var3);
      } else {
         class62 var4 = (class62)super.field1271;
         int var5 = this.field1261 << 8;
         int var6 = this.field1262 << 8;
         int var7 = var4.field1237.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1257 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1259 < 0) {
            if(this.field1254 <= 0) {
               this.method1418();
               this.method3898();
               return;
            }

            this.field1259 = 0;
         }

         if(this.field1259 >= var7) {
            if(this.field1254 >= 0) {
               this.method1418();
               this.method3898();
               return;
            }

            this.field1259 = var7 - 1;
         }

         if(this.field1257 < 0) {
            if(this.field1263) {
               if(this.field1254 < 0) {
                  var9 = this.method1283(var1, var2, var5, var3, var4.field1237[this.field1261]);
                  if(this.field1259 >= var5) {
                     return;
                  }

                  this.field1259 = var5 + var5 - 1 - this.field1259;
                  this.field1254 = -this.field1254;
               }

               while(true) {
                  var9 = this.method1363(var1, var9, var6, var3, var4.field1237[this.field1262 - 1]);
                  if(this.field1259 < var6) {
                     return;
                  }

                  this.field1259 = var6 + var6 - 1 - this.field1259;
                  this.field1254 = -this.field1254;
                  var9 = this.method1283(var1, var9, var5, var3, var4.field1237[this.field1261]);
                  if(this.field1259 >= var5) {
                     return;
                  }

                  this.field1259 = var5 + var5 - 1 - this.field1259;
                  this.field1254 = -this.field1254;
               }
            }

            if(this.field1254 < 0) {
               while(true) {
                  var9 = this.method1283(var1, var9, var5, var3, var4.field1237[this.field1262 - 1]);
                  if(this.field1259 >= var5) {
                     return;
                  }

                  this.field1259 = var6 - 1 - (var6 - 1 - this.field1259) % var8;
               }
            }

            while(true) {
               var9 = this.method1363(var1, var9, var6, var3, var4.field1237[this.field1261]);
               if(this.field1259 < var6) {
                  return;
               }

               this.field1259 = var5 + (this.field1259 - var5) % var8;
            }
         }

         if(this.field1257 > 0) {
            if(this.field1263) {
               label118: {
                  if(this.field1254 < 0) {
                     var9 = this.method1283(var1, var2, var5, var3, var4.field1237[this.field1261]);
                     if(this.field1259 >= var5) {
                        return;
                     }

                     this.field1259 = var5 + var5 - 1 - this.field1259;
                     this.field1254 = -this.field1254;
                     if(--this.field1257 == 0) {
                        break label118;
                     }
                  }

                  do {
                     var9 = this.method1363(var1, var9, var6, var3, var4.field1237[this.field1262 - 1]);
                     if(this.field1259 < var6) {
                        return;
                     }

                     this.field1259 = var6 + var6 - 1 - this.field1259;
                     this.field1254 = -this.field1254;
                     if(--this.field1257 == 0) {
                        break;
                     }

                     var9 = this.method1283(var1, var9, var5, var3, var4.field1237[this.field1261]);
                     if(this.field1259 >= var5) {
                        return;
                     }

                     this.field1259 = var5 + var5 - 1 - this.field1259;
                     this.field1254 = -this.field1254;
                  } while(--this.field1257 != 0);
               }
            } else {
               int var10;
               if(this.field1254 < 0) {
                  while(true) {
                     var9 = this.method1283(var1, var9, var5, var3, var4.field1237[this.field1262 - 1]);
                     if(this.field1259 >= var5) {
                        return;
                     }

                     var10 = (var6 - 1 - this.field1259) / var8;
                     if(var10 >= this.field1257) {
                        this.field1259 += var8 * this.field1257;
                        this.field1257 = 0;
                        break;
                     }

                     this.field1259 += var8 * var10;
                     this.field1257 -= var10;
                  }
               } else {
                  while(true) {
                     var9 = this.method1363(var1, var9, var6, var3, var4.field1237[this.field1261]);
                     if(this.field1259 < var6) {
                        return;
                     }

                     var10 = (this.field1259 - var5) / var8;
                     if(var10 >= this.field1257) {
                        this.field1259 -= var8 * this.field1257;
                        this.field1257 = 0;
                        break;
                     }

                     this.field1259 -= var8 * var10;
                     this.field1257 -= var10;
                  }
               }
            }
         }

         if(this.field1254 < 0) {
            this.method1283(var1, var9, 0, var3, 0);
            if(this.field1259 < 0) {
               this.field1259 = -1;
               this.method1418();
               this.method3898();
            }
         } else {
            this.method1363(var1, var9, var7, var3, 0);
            if(this.field1259 >= var7) {
               this.field1259 = var7;
               this.method1418();
               this.method3898();
            }
         }
      }

   }

   @ObfuscatedName("b")
   protected int vmethod3705() {
      return this.field1255 == 0 && this.field1264 == 0?0:1;
   }

   @ObfuscatedName("c")
   public synchronized void method1428(int var1) {
      this.field1257 = var1;
   }

   @ObfuscatedName("ad")
   public synchronized void method1430(int var1, int var2) {
      this.method1395(var1, var2, this.method1346());
   }

   @ObfuscatedName("s")
   static int method1437(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("am")
   public synchronized void method1439(int var1) {
      if(var1 == 0) {
         this.method1285(0);
         this.method3898();
      } else if(this.field1258 == 0 && this.field1260 == 0) {
         this.field1264 = 0;
         this.field1255 = 0;
         this.field1253 = 0;
         this.method3898();
      } else {
         int var2 = -this.field1253;
         if(this.field1253 > var2) {
            var2 = this.field1253;
         }

         if(-this.field1258 > var2) {
            var2 = -this.field1258;
         }

         if(this.field1258 > var2) {
            var2 = this.field1258;
         }

         if(-this.field1260 > var2) {
            var2 = -this.field1260;
         }

         if(this.field1260 > var2) {
            var2 = this.field1260;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1264 = var1;
         this.field1255 = Integer.MIN_VALUE;
         this.field1265 = -this.field1253 / var1;
         this.field1266 = -this.field1258 / var1;
         this.field1267 = -this.field1260 / var1;
      }

   }
}
