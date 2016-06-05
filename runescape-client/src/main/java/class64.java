import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
public class class64 extends class66 {
   @ObfuscatedName("k")
   int field1251;
   @ObfuscatedName("i")
   int field1252;
   @ObfuscatedName("d")
   int field1253;
   @ObfuscatedName("t")
   int field1254;
   @ObfuscatedName("z")
   int field1255;
   @ObfuscatedName("r")
   int field1256;
   @ObfuscatedName("f")
   int field1257;
   @ObfuscatedName("s")
   int field1258;
   @ObfuscatedName("h")
   int field1259;
   @ObfuscatedName("l")
   int field1260;
   @ObfuscatedName("y")
   boolean field1261;
   @ObfuscatedName("p")
   int field1262;
   @ObfuscatedName("o")
   int field1263;
   @ObfuscatedName("b")
   int field1264;
   @ObfuscatedName("g")
   int field1265;

   @ObfuscatedName("d")
   public synchronized void vmethod3679(int[] var1, int var2, int var3) {
      if(this.field1265 == 0 && this.field1262 == 0) {
         this.vmethod3686(var3);
      } else {
         class62 var4 = (class62)super.field1267;
         int var5 = this.field1253 << 8;
         int var6 = this.field1260 << 8;
         int var7 = var4.field1235.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1258 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1254 < 0) {
            if(this.field1252 <= 0) {
               this.method1378();
               this.method3870();
               return;
            }

            this.field1254 = 0;
         }

         if(this.field1254 >= var7) {
            if(this.field1252 >= 0) {
               this.method1378();
               this.method3870();
               return;
            }

            this.field1254 = var7 - 1;
         }

         if(this.field1258 < 0) {
            if(this.field1261) {
               if(this.field1252 < 0) {
                  var9 = this.method1384(var1, var2, var5, var3, var4.field1235[this.field1253]);
                  if(this.field1254 >= var5) {
                     return;
                  }

                  this.field1254 = var5 + var5 - 1 - this.field1254;
                  this.field1252 = -this.field1252;
               }

               while(true) {
                  var9 = this.method1386(var1, var9, var6, var3, var4.field1235[this.field1260 - 1]);
                  if(this.field1254 < var6) {
                     return;
                  }

                  this.field1254 = var6 + var6 - 1 - this.field1254;
                  this.field1252 = -this.field1252;
                  var9 = this.method1384(var1, var9, var5, var3, var4.field1235[this.field1253]);
                  if(this.field1254 >= var5) {
                     return;
                  }

                  this.field1254 = var5 + var5 - 1 - this.field1254;
                  this.field1252 = -this.field1252;
               }
            } else if(this.field1252 < 0) {
               while(true) {
                  var9 = this.method1384(var1, var9, var5, var3, var4.field1235[this.field1260 - 1]);
                  if(this.field1254 >= var5) {
                     return;
                  }

                  this.field1254 = var6 - 1 - (var6 - 1 - this.field1254) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1386(var1, var9, var6, var3, var4.field1235[this.field1253]);
                  if(this.field1254 < var6) {
                     return;
                  }

                  this.field1254 = var5 + (this.field1254 - var5) % var8;
               }
            }
         } else {
            if(this.field1258 > 0) {
               if(this.field1261) {
                  label177: {
                     if(this.field1252 < 0) {
                        var9 = this.method1384(var1, var2, var5, var3, var4.field1235[this.field1253]);
                        if(this.field1254 >= var5) {
                           return;
                        }

                        this.field1254 = var5 + var5 - 1 - this.field1254;
                        this.field1252 = -this.field1252;
                        if(--this.field1258 == 0) {
                           break label177;
                        }
                     }

                     do {
                        var9 = this.method1386(var1, var9, var6, var3, var4.field1235[this.field1260 - 1]);
                        if(this.field1254 < var6) {
                           return;
                        }

                        this.field1254 = var6 + var6 - 1 - this.field1254;
                        this.field1252 = -this.field1252;
                        if(--this.field1258 == 0) {
                           break;
                        }

                        var9 = this.method1384(var1, var9, var5, var3, var4.field1235[this.field1253]);
                        if(this.field1254 >= var5) {
                           return;
                        }

                        this.field1254 = var5 + var5 - 1 - this.field1254;
                        this.field1252 = -this.field1252;
                     } while(--this.field1258 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1252 < 0) {
                     while(true) {
                        var9 = this.method1384(var1, var9, var5, var3, var4.field1235[this.field1260 - 1]);
                        if(this.field1254 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1254) / var8;
                        if(var10 >= this.field1258) {
                           this.field1254 += var8 * this.field1258;
                           this.field1258 = 0;
                           break;
                        }

                        this.field1254 += var8 * var10;
                        this.field1258 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1386(var1, var9, var6, var3, var4.field1235[this.field1253]);
                        if(this.field1254 < var6) {
                           return;
                        }

                        var10 = (this.field1254 - var5) / var8;
                        if(var10 >= this.field1258) {
                           this.field1254 -= var8 * this.field1258;
                           this.field1258 = 0;
                           break;
                        }

                        this.field1254 -= var8 * var10;
                        this.field1258 -= var10;
                     }
                  }
               }
            }

            if(this.field1252 < 0) {
               this.method1384(var1, var9, 0, var3, 0);
               if(this.field1254 < 0) {
                  this.field1254 = -1;
                  this.method1378();
                  this.method3870();
               }
            } else {
               this.method1386(var1, var9, var7, var3, 0);
               if(this.field1254 >= var7) {
                  this.field1254 = var7;
                  this.method1378();
                  this.method3870();
               }
            }

         }
      }
   }

   @ObfuscatedName("at")
   static int method1261(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
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

      var11.field1254 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1262(int var1) {
      this.method1372(var1, this.method1271());
   }

   class64(class62 var1, int var2, int var3, int var4) {
      super.field1267 = var1;
      this.field1253 = var1.field1238;
      this.field1260 = var1.field1237;
      this.field1261 = var1.field1236;
      this.field1252 = var2;
      this.field1265 = var3;
      this.field1259 = var4;
      this.field1254 = 0;
      this.method1265();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass62;II)Lclass64;",
      garbageValue = "100"
   )
   public static class64 method1263(class62 var0, int var1, int var2) {
      return var0.field1235 != null && var0.field1235.length != 0?new class64(var0, (int)((long)var0.field1234 * 256L * (long)var1 / (long)(class56.field1194 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("w")
   public boolean method1264() {
      return this.field1254 < 0 || this.field1254 >= ((class62)super.field1267).field1235.length << 8;
   }

   @ObfuscatedName("z")
   void method1265() {
      this.field1255 = this.field1265;
      this.field1256 = method1356(this.field1265, this.field1259);
      this.field1257 = method1397(this.field1265, this.field1259);
   }

   @ObfuscatedName("l")
   public synchronized void method1266(int var1) {
      this.field1258 = var1;
   }

   @ObfuscatedName("p")
   public synchronized void method1267(int var1) {
      this.method1372(var1 << 6, this.method1271());
   }

   @ObfuscatedName("b")
   public synchronized int method1270() {
      return this.field1265 == Integer.MIN_VALUE?0:this.field1265;
   }

   @ObfuscatedName("j")
   public synchronized int method1271() {
      return this.field1259 < 0?-1:this.field1259;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1273() {
      this.field1252 = (this.field1252 ^ this.field1252 >> 31) + (this.field1252 >>> 31);
      this.field1252 = -this.field1252;
   }

   @ObfuscatedName("n")
   public synchronized void method1275(int var1, int var2) {
      this.method1291(var1, var2, this.method1271());
   }

   @ObfuscatedName("x")
   public synchronized void method1277(int var1) {
      if(var1 == 0) {
         this.method1262(0);
         this.method3870();
      } else if(this.field1256 == 0 && this.field1257 == 0) {
         this.field1262 = 0;
         this.field1265 = 0;
         this.field1255 = 0;
         this.method3870();
      } else {
         int var2 = -this.field1255;
         if(this.field1255 > var2) {
            var2 = this.field1255;
         }

         if(-this.field1256 > var2) {
            var2 = -this.field1256;
         }

         if(this.field1256 > var2) {
            var2 = this.field1256;
         }

         if(-this.field1257 > var2) {
            var2 = -this.field1257;
         }

         if(this.field1257 > var2) {
            var2 = this.field1257;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1262 = var1;
         this.field1265 = Integer.MIN_VALUE;
         this.field1251 = -this.field1255 / var1;
         this.field1263 = -this.field1256 / var1;
         this.field1264 = -this.field1257 / var1;
      }
   }

   @ObfuscatedName("v")
   public synchronized void method1278(int var1) {
      if(this.field1252 < 0) {
         this.field1252 = -var1;
      } else {
         this.field1252 = var1;
      }

   }

   @ObfuscatedName("aq")
   public boolean method1281() {
      return this.field1262 != 0;
   }

   @ObfuscatedName("r")
   protected class66 vmethod3695() {
      return null;
   }

   @ObfuscatedName("s")
   protected int vmethod3678() {
      return this.field1265 == 0 && this.field1262 == 0?0:1;
   }

   @ObfuscatedName("y")
   public synchronized void vmethod3686(int var1) {
      if(this.field1262 > 0) {
         if(var1 >= this.field1262) {
            if(this.field1265 == Integer.MIN_VALUE) {
               this.field1265 = 0;
               this.field1257 = 0;
               this.field1256 = 0;
               this.field1255 = 0;
               this.method3870();
               var1 = this.field1262;
            }

            this.field1262 = 0;
            this.method1265();
         } else {
            this.field1255 += this.field1251 * var1;
            this.field1256 += this.field1263 * var1;
            this.field1257 += this.field1264 * var1;
            this.field1262 -= var1;
         }
      }

      class62 var2 = (class62)super.field1267;
      int var3 = this.field1253 << 8;
      int var4 = this.field1260 << 8;
      int var5 = var2.field1235.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1258 = 0;
      }

      if(this.field1254 < 0) {
         if(this.field1252 <= 0) {
            this.method1378();
            this.method3870();
            return;
         }

         this.field1254 = 0;
      }

      if(this.field1254 >= var5) {
         if(this.field1252 >= 0) {
            this.method1378();
            this.method3870();
            return;
         }

         this.field1254 = var5 - 1;
      }

      this.field1254 += this.field1252 * var1;
      if(this.field1258 < 0) {
         if(!this.field1261) {
            if(this.field1252 < 0) {
               if(this.field1254 >= var3) {
                  return;
               }

               this.field1254 = var4 - 1 - (var4 - 1 - this.field1254) % var6;
            } else {
               if(this.field1254 < var4) {
                  return;
               }

               this.field1254 = var3 + (this.field1254 - var3) % var6;
            }

         } else {
            if(this.field1252 < 0) {
               if(this.field1254 >= var3) {
                  return;
               }

               this.field1254 = var3 + var3 - 1 - this.field1254;
               this.field1252 = -this.field1252;
            }

            while(this.field1254 >= var4) {
               this.field1254 = var4 + var4 - 1 - this.field1254;
               this.field1252 = -this.field1252;
               if(this.field1254 >= var3) {
                  return;
               }

               this.field1254 = var3 + var3 - 1 - this.field1254;
               this.field1252 = -this.field1252;
            }

         }
      } else {
         if(this.field1258 > 0) {
            if(this.field1261) {
               label175: {
                  if(this.field1252 < 0) {
                     if(this.field1254 >= var3) {
                        return;
                     }

                     this.field1254 = var3 + var3 - 1 - this.field1254;
                     this.field1252 = -this.field1252;
                     if(--this.field1258 == 0) {
                        break label175;
                     }
                  }

                  do {
                     if(this.field1254 < var4) {
                        return;
                     }

                     this.field1254 = var4 + var4 - 1 - this.field1254;
                     this.field1252 = -this.field1252;
                     if(--this.field1258 == 0) {
                        break;
                     }

                     if(this.field1254 >= var3) {
                        return;
                     }

                     this.field1254 = var3 + var3 - 1 - this.field1254;
                     this.field1252 = -this.field1252;
                  } while(--this.field1258 != 0);
               }
            } else {
               label207: {
                  int var7;
                  if(this.field1252 < 0) {
                     if(this.field1254 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1254) / var6;
                     if(var7 >= this.field1258) {
                        this.field1254 += var6 * this.field1258;
                        this.field1258 = 0;
                        break label207;
                     }

                     this.field1254 += var6 * var7;
                     this.field1258 -= var7;
                  } else {
                     if(this.field1254 < var4) {
                        return;
                     }

                     var7 = (this.field1254 - var3) / var6;
                     if(var7 >= this.field1258) {
                        this.field1254 -= var6 * this.field1258;
                        this.field1258 = 0;
                        break label207;
                     }

                     this.field1254 -= var6 * var7;
                     this.field1258 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1252 < 0) {
            if(this.field1254 < 0) {
               this.field1254 = -1;
               this.method1378();
               this.method3870();
            }
         } else if(this.field1254 >= var5) {
            this.field1254 = var5;
            this.method1378();
            this.method3870();
         }

      }
   }

   @ObfuscatedName("ap")
   boolean method1289() {
      int var1 = this.field1265;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1356(var1, this.field1259);
         var3 = method1397(var1, this.field1259);
      }

      if(this.field1255 == var1 && this.field1256 == var2 && this.field1257 == var3) {
         if(this.field1265 == Integer.MIN_VALUE) {
            this.field1265 = 0;
            this.field1257 = 0;
            this.field1256 = 0;
            this.field1255 = 0;
            this.method3870();
            return true;
         } else {
            this.method1265();
            return false;
         }
      } else {
         if(this.field1255 < var1) {
            this.field1251 = 1;
            this.field1262 = var1 - this.field1255;
         } else if(this.field1255 > var1) {
            this.field1251 = -1;
            this.field1262 = this.field1255 - var1;
         } else {
            this.field1251 = 0;
         }

         if(this.field1256 < var2) {
            this.field1263 = 1;
            if(this.field1262 == 0 || this.field1262 > var2 - this.field1256) {
               this.field1262 = var2 - this.field1256;
            }
         } else if(this.field1256 > var2) {
            this.field1263 = -1;
            if(this.field1262 == 0 || this.field1262 > this.field1256 - var2) {
               this.field1262 = this.field1256 - var2;
            }
         } else {
            this.field1263 = 0;
         }

         if(this.field1257 < var3) {
            this.field1264 = 1;
            if(this.field1262 == 0 || this.field1262 > var3 - this.field1257) {
               this.field1262 = var3 - this.field1257;
            }
         } else if(this.field1257 > var3) {
            this.field1264 = -1;
            if(this.field1262 == 0 || this.field1262 > this.field1257 - var3) {
               this.field1262 = this.field1257 - var3;
            }
         } else {
            this.field1264 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ab")
   static int method1290(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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

      var10.field1254 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("q")
   public synchronized void method1291(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1372(var2, var3);
      } else {
         int var4 = method1356(var2, var3);
         int var5 = method1397(var2, var3);
         if(this.field1256 == var4 && this.field1257 == var5) {
            this.field1262 = 0;
         } else {
            int var6 = var2 - this.field1255;
            if(this.field1255 - var2 > var6) {
               var6 = this.field1255 - var2;
            }

            if(var4 - this.field1256 > var6) {
               var6 = var4 - this.field1256;
            }

            if(this.field1256 - var4 > var6) {
               var6 = this.field1256 - var4;
            }

            if(var5 - this.field1257 > var6) {
               var6 = var5 - this.field1257;
            }

            if(this.field1257 - var5 > var6) {
               var6 = this.field1257 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1262 = var1;
            this.field1265 = var2;
            this.field1259 = var3;
            this.field1251 = (var2 - this.field1255) / var1;
            this.field1263 = (var4 - this.field1256) / var1;
            this.field1264 = (var5 - this.field1257) / var1;
         }
      }
   }

   @ObfuscatedName("bn")
   static int method1293(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1255 -= var13.field1251 * var5;
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
      var13.field1255 += var13.field1251 * var5;
      var13.field1256 = var6;
      var13.field1257 = var7;
      var13.field1254 = var4;
      return var5;
   }

   @ObfuscatedName("am")
   static int method1294(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
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

      var10.field1254 = var4;
      return var5;
   }

   @ObfuscatedName("az")
   static int method1296(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
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

      var10.field1254 = var4;
      return var5;
   }

   @ObfuscatedName("af")
   static int method1297(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
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

      var11.field1254 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ax")
   static int method1298(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1256 += var9.field1263 * (var6 - var3);
      var9.field1257 += var9.field1264 * (var6 - var3);

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

      var9.field1255 = var4 >> 2;
      var9.field1254 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bi")
   static int method1300(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1256 += var9.field1263 * (var6 - var3);
      var9.field1257 += var9.field1264 * (var6 - var3);

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

      var9.field1255 = var4 >> 2;
      var9.field1254 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("br")
   static int method1301(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1255 += var12.field1251 * (var9 - var4);
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

      var12.field1256 = var5 >> 2;
      var12.field1257 = var6 >> 2;
      var12.field1254 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bd")
   static int method1302(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1256 -= var11.field1263 * var5;
      var11.field1257 -= var11.field1264 * var5;
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

      var11.field1256 += var11.field1263 * var5;
      var11.field1257 += var11.field1264 * var5;
      var11.field1255 = var6;
      var11.field1254 = var4;
      return var5;
   }

   @ObfuscatedName("bh")
   static int method1304(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1256 -= var11.field1263 * var5;
      var11.field1257 -= var11.field1264 * var5;
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

      var11.field1256 += var11.field1263 * var5;
      var11.field1257 += var11.field1264 * var5;
      var11.field1255 = var6;
      var11.field1254 = var4;
      return var5;
   }

   @ObfuscatedName("bg")
   static int method1305(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1255 -= var13.field1251 * var5;
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
      var13.field1255 += var13.field1251 * var5;
      var13.field1256 = var6;
      var13.field1257 = var7;
      var13.field1254 = var4;
      return var5;
   }

   @ObfuscatedName("ae")
   static int method1306(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1254 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bf")
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

      var12.field1255 += var12.field1251 * (var9 - var4);
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

      var12.field1256 = var5 >> 2;
      var12.field1257 = var6 >> 2;
      var12.field1254 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("au")
   static int method1317(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1254 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("f")
   protected class66 vmethod3677() {
      return null;
   }

   @ObfuscatedName("h")
   public static class64 method1340(class62 var0, int var1, int var2, int var3) {
      return var0.field1235 != null && var0.field1235.length != 0?new class64(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("ah")
   int vmethod1421() {
      int var1 = this.field1255 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1258 == 0) {
         var1 -= var1 * this.field1254 / (((class62)super.field1267).field1235.length << 8);
      } else if(this.field1258 >= 0) {
         var1 -= var1 * this.field1253 / ((class62)super.field1267).field1235.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("a")
   public synchronized void method1349(int var1) {
      int var2 = ((class62)super.field1267).field1235.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1254 = var1;
   }

   class64(class62 var1, int var2, int var3) {
      super.field1267 = var1;
      this.field1253 = var1.field1238;
      this.field1260 = var1.field1237;
      this.field1261 = var1.field1236;
      this.field1252 = var2;
      this.field1265 = var3;
      this.field1259 = 8192;
      this.field1254 = 0;
      this.method1265();
   }

   @ObfuscatedName("t")
   static int method1356(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("aa")
   static int method1369(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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

      var10.field1254 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("o")
   synchronized void method1372(int var1, int var2) {
      this.field1265 = var1;
      this.field1259 = var2;
      this.field1262 = 0;
      this.method1265();
   }

   @ObfuscatedName("c")
   void method1378() {
      if(this.field1262 != 0) {
         if(this.field1265 == Integer.MIN_VALUE) {
            this.field1265 = 0;
         }

         this.field1262 = 0;
         this.method1265();
      }

   }

   @ObfuscatedName("aw")
   int method1384(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1262 > 0) {
            int var6 = var2 + this.field1262;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1262 += var2;
            if(this.field1252 == -256 && (this.field1254 & 255) == 0) {
               if(class21.field575) {
                  var2 = method1301(0, ((class62)super.field1267).field1235, var1, this.field1254, var2, this.field1256, this.field1257, this.field1263, this.field1264, 0, var6, var3, this);
               } else {
                  var2 = method1300(((class62)super.field1267).field1235, var1, this.field1254, var2, this.field1255, this.field1251, 0, var6, var3, this);
               }
            } else if(class21.field575) {
               var2 = method1293(0, 0, ((class62)super.field1267).field1235, var1, this.field1254, var2, this.field1256, this.field1257, this.field1263, this.field1264, 0, var6, var3, this, this.field1252, var5);
            } else {
               var2 = method1304(0, 0, ((class62)super.field1267).field1235, var1, this.field1254, var2, this.field1255, this.field1251, 0, var6, var3, this, this.field1252, var5);
            }

            this.field1262 -= var2;
            if(this.field1262 != 0) {
               return var2;
            }

            if(!this.method1289()) {
               continue;
            }

            return var4;
         }

         if(this.field1252 == -256 && (this.field1254 & 255) == 0) {
            if(class21.field575) {
               return method1290(0, ((class62)super.field1267).field1235, var1, this.field1254, var2, this.field1256, this.field1257, 0, var4, var3, this);
            }

            return method1317(((class62)super.field1267).field1235, var1, this.field1254, var2, this.field1255, 0, var4, var3, this);
         }

         if(class21.field575) {
            return method1297(0, 0, ((class62)super.field1267).field1235, var1, this.field1254, var2, this.field1256, this.field1257, 0, var4, var3, this, this.field1252, var5);
         }

         return method1296(0, 0, ((class62)super.field1267).field1235, var1, this.field1254, var2, this.field1255, 0, var4, var3, this, this.field1252, var5);
      }
   }

   @ObfuscatedName("ai")
   int method1386(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1262 > 0) {
            int var6 = var2 + this.field1262;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1262 += var2;
            if(this.field1252 == 256 && (this.field1254 & 255) == 0) {
               if(class21.field575) {
                  var2 = method1316(0, ((class62)super.field1267).field1235, var1, this.field1254, var2, this.field1256, this.field1257, this.field1263, this.field1264, 0, var6, var3, this);
               } else {
                  var2 = method1298(((class62)super.field1267).field1235, var1, this.field1254, var2, this.field1255, this.field1251, 0, var6, var3, this);
               }
            } else if(class21.field575) {
               var2 = method1305(0, 0, ((class62)super.field1267).field1235, var1, this.field1254, var2, this.field1256, this.field1257, this.field1263, this.field1264, 0, var6, var3, this, this.field1252, var5);
            } else {
               var2 = method1302(0, 0, ((class62)super.field1267).field1235, var1, this.field1254, var2, this.field1255, this.field1251, 0, var6, var3, this, this.field1252, var5);
            }

            this.field1262 -= var2;
            if(this.field1262 != 0) {
               return var2;
            }

            if(!this.method1289()) {
               continue;
            }

            return var4;
         }

         if(this.field1252 == 256 && (this.field1254 & 255) == 0) {
            if(class21.field575) {
               return method1369(0, ((class62)super.field1267).field1235, var1, this.field1254, var2, this.field1256, this.field1257, 0, var4, var3, this);
            }

            return method1306(((class62)super.field1267).field1235, var1, this.field1254, var2, this.field1255, 0, var4, var3, this);
         }

         if(class21.field575) {
            return method1261(0, 0, ((class62)super.field1267).field1235, var1, this.field1254, var2, this.field1256, this.field1257, 0, var4, var3, this, this.field1252, var5);
         }

         return method1294(0, 0, ((class62)super.field1267).field1235, var1, this.field1254, var2, this.field1255, 0, var4, var3, this, this.field1252, var5);
      }
   }

   @ObfuscatedName("i")
   static int method1397(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("m")
   public synchronized int method1404() {
      return this.field1252 < 0?-this.field1252:this.field1252;
   }
}
