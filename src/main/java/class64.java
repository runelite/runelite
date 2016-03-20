import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public class class64 extends class66 {
   @ObfuscatedName("m")
   int field1247;
   @ObfuscatedName("y")
   int field1248;
   @ObfuscatedName("f")
   int field1249;
   @ObfuscatedName("i")
   int field1250;
   @ObfuscatedName("n")
   int field1251;
   @ObfuscatedName("e")
   int field1252;
   @ObfuscatedName("g")
   int field1253;
   @ObfuscatedName("r")
   int field1254;
   @ObfuscatedName("j")
   int field1255;
   @ObfuscatedName("a")
   int field1256;
   @ObfuscatedName("l")
   boolean field1257;
   @ObfuscatedName("h")
   int field1258;
   @ObfuscatedName("s")
   int field1259;
   @ObfuscatedName("v")
   int field1260;
   @ObfuscatedName("z")
   int field1261;

   @ObfuscatedName("r")
   static int method1324(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ag")
   int vmethod1487() {
      int var1 = this.field1248 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1247 == 0) {
         var1 -= var1 * this.field1256 / (((class62)super.field1266).field1231.length << 8);
      } else if(this.field1247 >= 0) {
         var1 -= var1 * this.field1255 / ((class62)super.field1266).field1231.length;
      }

      return var1 > 255?255:var1;
   }

   class64(class62 var1, int var2, int var3) {
      super.field1266 = var1;
      this.field1255 = var1.field1230;
      this.field1251 = var1.field1233;
      this.field1257 = var1.field1234;
      this.field1254 = var2;
      this.field1249 = var3;
      this.field1259 = 8192;
      this.field1256 = 0;
      this.method1328();
   }

   class64(class62 var1, int var2, int var3, int var4) {
      super.field1266 = var1;
      this.field1255 = var1.field1230;
      this.field1251 = var1.field1233;
      this.field1257 = var1.field1234;
      this.field1254 = var2;
      this.field1249 = var3;
      this.field1259 = var4;
      this.field1256 = 0;
      this.method1328();
   }

   @ObfuscatedName("s")
   public static class64 method1327(class62 var0, int var1, int var2, int var3) {
      return var0.field1231 != null && var0.field1231.length != 0?new class64(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("y")
   void method1328() {
      this.field1248 = this.field1249;
      this.field1252 = method1398(this.field1249, this.field1259);
      this.field1253 = method1324(this.field1249, this.field1259);
   }

   @ObfuscatedName("n")
   public synchronized void method1329(int var1) {
      this.field1247 = var1;
   }

   @ObfuscatedName("h")
   public synchronized void method1330(int var1) {
      this.method1332(var1 << 6, this.method1441());
   }

   @ObfuscatedName("i")
   synchronized void method1331(int var1) {
      this.method1332(var1, this.method1441());
   }

   @ObfuscatedName("v")
   synchronized void method1332(int var1, int var2) {
      this.field1249 = var1;
      this.field1259 = var2;
      this.field1258 = 0;
      this.method1328();
   }

   @ObfuscatedName("z")
   public synchronized int method1333() {
      return this.field1249 == Integer.MIN_VALUE?0:this.field1249;
   }

   @ObfuscatedName("bp")
   static int method1334(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1252 += var9.field1260 * (var6 - var3);
      var9.field1253 += var9.field1261 * (var6 - var3);

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

      var9.field1248 = var4 >> 2;
      var9.field1256 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bv")
   static int method1335(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1252 -= var11.field1260 * var5;
      var11.field1253 -= var11.field1261 * var5;
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

      var11.field1252 += var11.field1260 * var5;
      var11.field1253 += var11.field1261 * var5;
      var11.field1248 = var6;
      var11.field1256 = var4;
      return var5;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1336() {
      this.field1254 = (this.field1254 ^ this.field1254 >> 31) + (this.field1254 >>> 31);
      this.field1254 = -this.field1254;
   }

   @ObfuscatedName("c")
   void method1337() {
      if(this.field1258 != 0) {
         if(this.field1249 == Integer.MIN_VALUE) {
            this.field1249 = 0;
         }

         this.field1258 = 0;
         this.method1328();
      }

   }

   @ObfuscatedName("ai")
   public synchronized int method1342() {
      return this.field1254 < 0?-this.field1254:this.field1254;
   }

   @ObfuscatedName("ab")
   public boolean method1343() {
      return this.field1256 < 0 || this.field1256 >= ((class62)super.field1266).field1231.length << 8;
   }

   @ObfuscatedName("g")
   protected class66 vmethod3752() {
      return null;
   }

   @ObfuscatedName("br")
   static int method1347(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1252 += var9.field1260 * (var6 - var3);
      var9.field1253 += var9.field1261 * (var6 - var3);

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

      var9.field1248 = var4 >> 2;
      var9.field1256 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("j")
   public synchronized void vmethod3779(int[] var1, int var2, int var3) {
      if(this.field1249 == 0 && this.field1258 == 0) {
         this.vmethod3765(var3);
      } else {
         class62 var4 = (class62)super.field1266;
         int var5 = this.field1255 << 8;
         int var6 = this.field1251 << 8;
         int var7 = var4.field1231.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1247 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1256 < 0) {
            if(this.field1254 <= 0) {
               this.method1337();
               this.method3946();
               return;
            }

            this.field1256 = 0;
         }

         if(this.field1256 >= var7) {
            if(this.field1254 >= 0) {
               this.method1337();
               this.method3946();
               return;
            }

            this.field1256 = var7 - 1;
         }

         if(this.field1247 < 0) {
            if(this.field1257) {
               if(this.field1254 < 0) {
                  var9 = this.method1438(var1, var2, var5, var3, var4.field1231[this.field1255]);
                  if(this.field1256 >= var5) {
                     return;
                  }

                  this.field1256 = var5 + var5 - 1 - this.field1256;
                  this.field1254 = -this.field1254;
               }

               while(true) {
                  var9 = this.method1350(var1, var9, var6, var3, var4.field1231[this.field1251 - 1]);
                  if(this.field1256 < var6) {
                     return;
                  }

                  this.field1256 = var6 + var6 - 1 - this.field1256;
                  this.field1254 = -this.field1254;
                  var9 = this.method1438(var1, var9, var5, var3, var4.field1231[this.field1255]);
                  if(this.field1256 >= var5) {
                     return;
                  }

                  this.field1256 = var5 + var5 - 1 - this.field1256;
                  this.field1254 = -this.field1254;
               }
            } else if(this.field1254 < 0) {
               while(true) {
                  var9 = this.method1438(var1, var9, var5, var3, var4.field1231[this.field1251 - 1]);
                  if(this.field1256 >= var5) {
                     return;
                  }

                  this.field1256 = var6 - 1 - (var6 - 1 - this.field1256) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1350(var1, var9, var6, var3, var4.field1231[this.field1255]);
                  if(this.field1256 < var6) {
                     return;
                  }

                  this.field1256 = var5 + (this.field1256 - var5) % var8;
               }
            }
         } else {
            if(this.field1247 > 0) {
               if(this.field1257) {
                  label184: {
                     if(this.field1254 < 0) {
                        var9 = this.method1438(var1, var2, var5, var3, var4.field1231[this.field1255]);
                        if(this.field1256 >= var5) {
                           return;
                        }

                        this.field1256 = var5 + var5 - 1 - this.field1256;
                        this.field1254 = -this.field1254;
                        if(--this.field1247 == 0) {
                           break label184;
                        }
                     }

                     do {
                        var9 = this.method1350(var1, var9, var6, var3, var4.field1231[this.field1251 - 1]);
                        if(this.field1256 < var6) {
                           return;
                        }

                        this.field1256 = var6 + var6 - 1 - this.field1256;
                        this.field1254 = -this.field1254;
                        if(--this.field1247 == 0) {
                           break;
                        }

                        var9 = this.method1438(var1, var9, var5, var3, var4.field1231[this.field1255]);
                        if(this.field1256 >= var5) {
                           return;
                        }

                        this.field1256 = var5 + var5 - 1 - this.field1256;
                        this.field1254 = -this.field1254;
                     } while(--this.field1247 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1254 < 0) {
                     while(true) {
                        var9 = this.method1438(var1, var9, var5, var3, var4.field1231[this.field1251 - 1]);
                        if(this.field1256 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1256) / var8;
                        if(var10 >= this.field1247) {
                           this.field1256 += var8 * this.field1247;
                           this.field1247 = 0;
                           break;
                        }

                        this.field1256 += var8 * var10;
                        this.field1247 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1350(var1, var9, var6, var3, var4.field1231[this.field1255]);
                        if(this.field1256 < var6) {
                           return;
                        }

                        var10 = (this.field1256 - var5) / var8;
                        if(var10 >= this.field1247) {
                           this.field1256 -= var8 * this.field1247;
                           this.field1247 = 0;
                           break;
                        }

                        this.field1256 -= var8 * var10;
                        this.field1247 -= var10;
                     }
                  }
               }
            }

            if(this.field1254 < 0) {
               this.method1438(var1, var9, 0, var3, 0);
               if(this.field1256 < 0) {
                  this.field1256 = -1;
                  this.method1337();
                  this.method3946();
               }
            } else {
               this.method1350(var1, var9, var7, var3, 0);
               if(this.field1256 >= var7) {
                  this.field1256 = var7;
                  this.method1337();
                  this.method3946();
               }
            }

         }
      }
   }

   @ObfuscatedName("l")
   public synchronized void vmethod3765(int var1) {
      if(this.field1258 > 0) {
         if(var1 >= this.field1258) {
            if(this.field1249 == Integer.MIN_VALUE) {
               this.field1249 = 0;
               this.field1253 = 0;
               this.field1252 = 0;
               this.field1248 = 0;
               this.method3946();
               var1 = this.field1258;
            }

            this.field1258 = 0;
            this.method1328();
         } else {
            this.field1248 += this.field1250 * var1;
            this.field1252 += this.field1260 * var1;
            this.field1253 += this.field1261 * var1;
            this.field1258 -= var1;
         }
      }

      class62 var2 = (class62)super.field1266;
      int var3 = this.field1255 << 8;
      int var4 = this.field1251 << 8;
      int var5 = var2.field1231.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1247 = 0;
      }

      if(this.field1256 < 0) {
         if(this.field1254 <= 0) {
            this.method1337();
            this.method3946();
            return;
         }

         this.field1256 = 0;
      }

      if(this.field1256 >= var5) {
         if(this.field1254 >= 0) {
            this.method1337();
            this.method3946();
            return;
         }

         this.field1256 = var5 - 1;
      }

      this.field1256 += this.field1254 * var1;
      if(this.field1247 < 0) {
         if(!this.field1257) {
            if(this.field1254 < 0) {
               if(this.field1256 >= var3) {
                  return;
               }

               this.field1256 = var4 - 1 - (var4 - 1 - this.field1256) % var6;
            } else {
               if(this.field1256 < var4) {
                  return;
               }

               this.field1256 = var3 + (this.field1256 - var3) % var6;
            }

         } else {
            if(this.field1254 < 0) {
               if(this.field1256 >= var3) {
                  return;
               }

               this.field1256 = var3 + var3 - 1 - this.field1256;
               this.field1254 = -this.field1254;
            }

            while(this.field1256 >= var4) {
               this.field1256 = var4 + var4 - 1 - this.field1256;
               this.field1254 = -this.field1254;
               if(this.field1256 >= var3) {
                  return;
               }

               this.field1256 = var3 + var3 - 1 - this.field1256;
               this.field1254 = -this.field1254;
            }

         }
      } else {
         if(this.field1247 > 0) {
            if(this.field1257) {
               label173: {
                  if(this.field1254 < 0) {
                     if(this.field1256 >= var3) {
                        return;
                     }

                     this.field1256 = var3 + var3 - 1 - this.field1256;
                     this.field1254 = -this.field1254;
                     if(--this.field1247 == 0) {
                        break label173;
                     }
                  }

                  do {
                     if(this.field1256 < var4) {
                        return;
                     }

                     this.field1256 = var4 + var4 - 1 - this.field1256;
                     this.field1254 = -this.field1254;
                     if(--this.field1247 == 0) {
                        break;
                     }

                     if(this.field1256 >= var3) {
                        return;
                     }

                     this.field1256 = var3 + var3 - 1 - this.field1256;
                     this.field1254 = -this.field1254;
                  } while(--this.field1247 != 0);
               }
            } else {
               int var7;
               if(this.field1254 < 0) {
                  if(this.field1256 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1256) / var6;
                  if(var7 < this.field1247) {
                     this.field1256 += var6 * var7;
                     this.field1247 -= var7;
                     return;
                  }

                  this.field1256 += var6 * this.field1247;
                  this.field1247 = 0;
               } else {
                  if(this.field1256 < var4) {
                     return;
                  }

                  var7 = (this.field1256 - var3) / var6;
                  if(var7 < this.field1247) {
                     this.field1256 -= var6 * var7;
                     this.field1247 -= var7;
                     return;
                  }

                  this.field1256 -= var6 * this.field1247;
                  this.field1247 = 0;
               }
            }
         }

         if(this.field1254 < 0) {
            if(this.field1256 < 0) {
               this.field1256 = -1;
               this.method1337();
               this.method3946();
            }
         } else if(this.field1256 >= var5) {
            this.field1256 = var5;
            this.method1337();
            this.method3946();
         }

      }
   }

   @ObfuscatedName("an")
   int method1350(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1258 > 0) {
            int var6 = var2 + this.field1258;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1258 += var2;
            if(this.field1254 == 256 && (this.field1256 & 255) == 0) {
               if(class56.field1173) {
                  var2 = method1362(0, ((class62)super.field1266).field1231, var1, this.field1256, var2, this.field1252, this.field1253, this.field1260, this.field1261, 0, var6, var3, this);
               } else {
                  var2 = method1347(((class62)super.field1266).field1231, var1, this.field1256, var2, this.field1248, this.field1250, 0, var6, var3, this);
               }
            } else if(class56.field1173) {
               var2 = method1466(0, 0, ((class62)super.field1266).field1231, var1, this.field1256, var2, this.field1252, this.field1253, this.field1260, this.field1261, 0, var6, var3, this, this.field1254, var5);
            } else {
               var2 = method1335(0, 0, ((class62)super.field1266).field1231, var1, this.field1256, var2, this.field1248, this.field1250, 0, var6, var3, this, this.field1254, var5);
            }

            this.field1258 -= var2;
            if(this.field1258 != 0) {
               return var2;
            }

            if(!this.method1352()) {
               continue;
            }

            return var4;
         }

         if(this.field1254 == 256 && (this.field1256 & 255) == 0) {
            if(class56.field1173) {
               return method1477(0, ((class62)super.field1266).field1231, var1, this.field1256, var2, this.field1252, this.field1253, 0, var4, var3, this);
            }

            return method1353(((class62)super.field1266).field1231, var1, this.field1256, var2, this.field1248, 0, var4, var3, this);
         }

         if(class56.field1173) {
            return method1358(0, 0, ((class62)super.field1266).field1231, var1, this.field1256, var2, this.field1252, this.field1253, 0, var4, var3, this, this.field1254, var5);
         }

         return method1357(0, 0, ((class62)super.field1266).field1231, var1, this.field1256, var2, this.field1248, 0, var4, var3, this, this.field1254, var5);
      }
   }

   @ObfuscatedName("aj")
   boolean method1352() {
      int var1 = this.field1249;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1398(var1, this.field1259);
         var3 = method1324(var1, this.field1259);
      }

      if(this.field1248 == var1 && this.field1252 == var2 && this.field1253 == var3) {
         if(this.field1249 == Integer.MIN_VALUE) {
            this.field1249 = 0;
            this.field1253 = 0;
            this.field1252 = 0;
            this.field1248 = 0;
            this.method3946();
            return true;
         } else {
            this.method1328();
            return false;
         }
      } else {
         if(this.field1248 < var1) {
            this.field1250 = 1;
            this.field1258 = var1 - this.field1248;
         } else if(this.field1248 > var1) {
            this.field1250 = -1;
            this.field1258 = this.field1248 - var1;
         } else {
            this.field1250 = 0;
         }

         if(this.field1252 < var2) {
            this.field1260 = 1;
            if(this.field1258 == 0 || this.field1258 > var2 - this.field1252) {
               this.field1258 = var2 - this.field1252;
            }
         } else if(this.field1252 > var2) {
            this.field1260 = -1;
            if(this.field1258 == 0 || this.field1258 > this.field1252 - var2) {
               this.field1258 = this.field1252 - var2;
            }
         } else {
            this.field1260 = 0;
         }

         if(this.field1253 < var3) {
            this.field1261 = 1;
            if(this.field1258 == 0 || this.field1258 > var3 - this.field1253) {
               this.field1258 = var3 - this.field1253;
            }
         } else if(this.field1253 > var3) {
            this.field1261 = -1;
            if(this.field1258 == 0 || this.field1258 > this.field1253 - var3) {
               this.field1258 = this.field1253 - var3;
            }
         } else {
            this.field1261 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ap")
   static int method1353(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1256 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("d")
   public synchronized void method1354(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1332(var2, var3);
      } else {
         int var4 = method1398(var2, var3);
         int var5 = method1324(var2, var3);
         if(this.field1252 == var4 && this.field1253 == var5) {
            this.field1258 = 0;
         } else {
            int var6 = var2 - this.field1248;
            if(this.field1248 - var2 > var6) {
               var6 = this.field1248 - var2;
            }

            if(var4 - this.field1252 > var6) {
               var6 = var4 - this.field1252;
            }

            if(this.field1252 - var4 > var6) {
               var6 = this.field1252 - var4;
            }

            if(var5 - this.field1253 > var6) {
               var6 = var5 - this.field1253;
            }

            if(this.field1253 - var5 > var6) {
               var6 = this.field1253 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1258 = var1;
            this.field1249 = var2;
            this.field1259 = var3;
            this.field1250 = (var2 - this.field1248) / var1;
            this.field1260 = (var4 - this.field1252) / var1;
            this.field1261 = (var5 - this.field1253) / var1;
         }
      }
   }

   @ObfuscatedName("af")
   static int method1355(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1256 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ay")
   static int method1356(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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

      var10.field1256 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("au")
   static int method1357(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
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

      var10.field1256 = var4;
      return var5;
   }

   @ObfuscatedName("az")
   static int method1358(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
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

      var11.field1256 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("t")
   public synchronized void method1359(int var1) {
      int var2 = ((class62)super.field1266).field1231.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1256 = var1;
   }

   @ObfuscatedName("bd")
   static int method1360(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
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

      var11.field1256 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bt")
   static int method1362(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1248 += var12.field1250 * (var9 - var4);
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

      var12.field1252 = var5 >> 2;
      var12.field1253 = var6 >> 2;
      var12.field1256 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bq")
   static int method1364(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1248 += var12.field1250 * (var9 - var4);
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

      var12.field1252 = var5 >> 2;
      var12.field1253 = var6 >> 2;
      var12.field1256 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bu")
   static int method1367(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1252 -= var11.field1260 * var5;
      var11.field1253 -= var11.field1261 * var5;
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

      var11.field1252 += var11.field1260 * var5;
      var11.field1253 += var11.field1261 * var5;
      var11.field1248 = var6;
      var11.field1256 = var4;
      return var5;
   }

   @ObfuscatedName("bo")
   static int method1368(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1248 -= var13.field1250 * var5;
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
      var13.field1248 += var13.field1250 * var5;
      var13.field1252 = var6;
      var13.field1253 = var7;
      var13.field1256 = var4;
      return var5;
   }

   @ObfuscatedName("p")
   public synchronized void method1380(int var1) {
      if(var1 == 0) {
         this.method1331(0);
         this.method3946();
      } else if(this.field1252 == 0 && this.field1253 == 0) {
         this.field1258 = 0;
         this.field1249 = 0;
         this.field1248 = 0;
         this.method3946();
      } else {
         int var2 = -this.field1248;
         if(this.field1248 > var2) {
            var2 = this.field1248;
         }

         if(-this.field1252 > var2) {
            var2 = -this.field1252;
         }

         if(this.field1252 > var2) {
            var2 = this.field1252;
         }

         if(-this.field1253 > var2) {
            var2 = -this.field1253;
         }

         if(this.field1253 > var2) {
            var2 = this.field1253;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1258 = var1;
         this.field1249 = Integer.MIN_VALUE;
         this.field1250 = -this.field1248 / var1;
         this.field1260 = -this.field1252 / var1;
         this.field1261 = -this.field1253 / var1;
      }
   }

   @ObfuscatedName("a")
   static int method1398(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("e")
   protected class66 vmethod3767() {
      return null;
   }

   @ObfuscatedName("m")
   protected int vmethod3770() {
      return this.field1249 == 0 && this.field1258 == 0?0:1;
   }

   @ObfuscatedName("f")
   public static class64 method1432(class62 var0, int var1, int var2) {
      return var0.field1231 != null && var0.field1231.length != 0?new class64(var0, (int)((long)var0.field1232 * 256L * (long)var1 / (long)(class56.field1185 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("av")
   int method1438(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1258 > 0) {
            int var6 = var2 + this.field1258;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1258 += var2;
            if(this.field1254 == -256 && (this.field1256 & 255) == 0) {
               if(class56.field1173) {
                  var2 = method1364(0, ((class62)super.field1266).field1231, var1, this.field1256, var2, this.field1252, this.field1253, this.field1260, this.field1261, 0, var6, var3, this);
               } else {
                  var2 = method1334(((class62)super.field1266).field1231, var1, this.field1256, var2, this.field1248, this.field1250, 0, var6, var3, this);
               }
            } else if(class56.field1173) {
               var2 = method1368(0, 0, ((class62)super.field1266).field1231, var1, this.field1256, var2, this.field1252, this.field1253, this.field1260, this.field1261, 0, var6, var3, this, this.field1254, var5);
            } else {
               var2 = method1367(0, 0, ((class62)super.field1266).field1231, var1, this.field1256, var2, this.field1248, this.field1250, 0, var6, var3, this, this.field1254, var5);
            }

            this.field1258 -= var2;
            if(this.field1258 != 0) {
               return var2;
            }

            if(!this.method1352()) {
               continue;
            }

            return var4;
         }

         if(this.field1254 == -256 && (this.field1256 & 255) == 0) {
            if(class56.field1173) {
               return method1356(0, ((class62)super.field1266).field1231, var1, this.field1256, var2, this.field1252, this.field1253, 0, var4, var3, this);
            }

            return method1355(((class62)super.field1266).field1231, var1, this.field1256, var2, this.field1248, 0, var4, var3, this);
         }

         if(class56.field1173) {
            return method1360(0, 0, ((class62)super.field1266).field1231, var1, this.field1256, var2, this.field1252, this.field1253, 0, var4, var3, this, this.field1254, var5);
         }

         return method1479(0, 0, ((class62)super.field1266).field1231, var1, this.field1256, var2, this.field1248, 0, var4, var3, this, this.field1254, var5);
      }
   }

   @ObfuscatedName("u")
   public synchronized int method1441() {
      return this.field1259 < 0?-1:this.field1259;
   }

   @ObfuscatedName("aa")
   public boolean method1442() {
      return this.field1258 != 0;
   }

   @ObfuscatedName("q")
   public synchronized void method1462(int var1) {
      if(this.field1254 < 0) {
         this.field1254 = -var1;
      } else {
         this.field1254 = var1;
      }

   }

   @ObfuscatedName("by")
   static int method1466(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1248 -= var13.field1250 * var5;
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
      var13.field1248 += var13.field1250 * var5;
      var13.field1252 = var6;
      var13.field1253 = var7;
      var13.field1256 = var4;
      return var5;
   }

   @ObfuscatedName("aq")
   static int method1477(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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

      var10.field1256 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ae")
   static int method1479(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
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

      var10.field1256 = var4;
      return var5;
   }

   @ObfuscatedName("x")
   public synchronized void method1483(int var1, int var2) {
      this.method1354(var1, var2, this.method1441());
   }
}
