import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public class class64 extends class66 {
   @ObfuscatedName("p")
   int field1230;
   @ObfuscatedName("h")
   int field1231;
   @ObfuscatedName("m")
   int field1232;
   @ObfuscatedName("z")
   int field1233;
   @ObfuscatedName("x")
   int field1234;
   @ObfuscatedName("a")
   int field1235;
   @ObfuscatedName("i")
   int field1236;
   @ObfuscatedName("c")
   int field1237;
   @ObfuscatedName("n")
   int field1238;
   @ObfuscatedName("l")
   int field1239;
   @ObfuscatedName("e")
   int field1240;
   @ObfuscatedName("r")
   int field1241;
   @ObfuscatedName("d")
   int field1242;
   @ObfuscatedName("u")
   boolean field1243;
   @ObfuscatedName("j")
   int field1244;

   @ObfuscatedName("h")
   static int method1298(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ar")
   static int method1299(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
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

      var10.field1244 = var4;
      return var5;
   }

   class64(class62 var1, int var2, int var3) {
      super.field1249 = var1;
      this.field1238 = var1.field1215;
      this.field1239 = var1.field1216;
      this.field1243 = var1.field1217;
      this.field1231 = var2;
      this.field1232 = var3;
      this.field1233 = 8192;
      this.field1244 = 0;
      this.method1302();
   }

   class64(class62 var1, int var2, int var3, int var4) {
      super.field1249 = var1;
      this.field1238 = var1.field1215;
      this.field1239 = var1.field1216;
      this.field1243 = var1.field1217;
      this.field1231 = var2;
      this.field1232 = var3;
      this.field1233 = var4;
      this.field1244 = 0;
      this.method1302();
   }

   @ObfuscatedName("d")
   synchronized void method1301(int var1, int var2) {
      this.field1232 = var1;
      this.field1233 = var2;
      this.field1241 = 0;
      this.method1302();
   }

   @ObfuscatedName("x")
   void method1302() {
      this.field1234 = this.field1232;
      this.field1240 = method1396(this.field1232, this.field1233);
      this.field1236 = method1298(this.field1232, this.field1233);
   }

   @ObfuscatedName("l")
   public synchronized void method1303(int var1) {
      this.field1237 = var1;
   }

   @ObfuscatedName("r")
   public synchronized void method1304(int var1) {
      this.method1301(var1 << 6, this.method1338());
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1305(int var1) {
      this.method1301(var1, this.method1338());
   }

   @ObfuscatedName("p")
   public synchronized int method1307() {
      return this.field1232 == Integer.MIN_VALUE?0:this.field1232;
   }

   @ObfuscatedName("ak")
   static int method1308(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1234 += var12.field1235 * (var9 - var4);
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

      var12.field1240 = var5 >> 2;
      var12.field1236 = var6 >> 2;
      var12.field1244 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("b")
   public synchronized void method1309(int var1) {
      int var2 = ((class62)super.field1249).field1213.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1244 = var1;
   }

   @ObfuscatedName("w")
   public synchronized void method1312(int var1, int var2) {
      this.method1402(var1, var2, this.method1338());
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass62;II)Lclass64;",
      garbageValue = "100"
   )
   public static class64 method1313(class62 var0, int var1, int var2) {
      return var0.field1213 != null && var0.field1213.length != 0?new class64(var0, (int)((long)var0.field1214 * 256L * (long)var1 / (long)(class56.field1181 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("k")
   public synchronized void method1315(int var1) {
      if(this.field1231 < 0) {
         this.field1231 = -var1;
      } else {
         this.field1231 = var1;
      }

   }

   @ObfuscatedName("o")
   public synchronized int method1316() {
      return this.field1231 < 0?-this.field1231:this.field1231;
   }

   @ObfuscatedName("y")
   void method1317() {
      if(this.field1241 != 0) {
         if(this.field1232 == Integer.MIN_VALUE) {
            this.field1232 = 0;
         }

         this.field1241 = 0;
         this.method1302();
      }

   }

   @ObfuscatedName("aj")
   public boolean method1318() {
      return this.field1241 != 0;
   }

   @ObfuscatedName("e")
   protected class66 vmethod3673() {
      return null;
   }

   @ObfuscatedName("i")
   protected class66 vmethod3674() {
      return null;
   }

   @ObfuscatedName("n")
   public synchronized void vmethod3676(int[] var1, int var2, int var3) {
      if(this.field1232 == 0 && this.field1241 == 0) {
         this.vmethod3677(var3);
      } else {
         class62 var4 = (class62)super.field1249;
         int var5 = this.field1238 << 8;
         int var6 = this.field1239 << 8;
         int var7 = var4.field1213.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1237 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1244 < 0) {
            if(this.field1231 <= 0) {
               this.method1317();
               this.method3883();
               return;
            }

            this.field1244 = 0;
         }

         if(this.field1244 >= var7) {
            if(this.field1231 >= 0) {
               this.method1317();
               this.method3883();
               return;
            }

            this.field1244 = var7 - 1;
         }

         if(this.field1237 < 0) {
            if(this.field1243) {
               if(this.field1231 < 0) {
                  var9 = this.method1325(var1, var2, var5, var3, var4.field1213[this.field1238]);
                  if(this.field1244 >= var5) {
                     return;
                  }

                  this.field1244 = var5 + var5 - 1 - this.field1244;
                  this.field1231 = -this.field1231;
               }

               while(true) {
                  var9 = this.method1401(var1, var9, var6, var3, var4.field1213[this.field1239 - 1]);
                  if(this.field1244 < var6) {
                     return;
                  }

                  this.field1244 = var6 + var6 - 1 - this.field1244;
                  this.field1231 = -this.field1231;
                  var9 = this.method1325(var1, var9, var5, var3, var4.field1213[this.field1238]);
                  if(this.field1244 >= var5) {
                     return;
                  }

                  this.field1244 = var5 + var5 - 1 - this.field1244;
                  this.field1231 = -this.field1231;
               }
            } else if(this.field1231 < 0) {
               while(true) {
                  var9 = this.method1325(var1, var9, var5, var3, var4.field1213[this.field1239 - 1]);
                  if(this.field1244 >= var5) {
                     return;
                  }

                  this.field1244 = var6 - 1 - (var6 - 1 - this.field1244) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1401(var1, var9, var6, var3, var4.field1213[this.field1238]);
                  if(this.field1244 < var6) {
                     return;
                  }

                  this.field1244 = var5 + (this.field1244 - var5) % var8;
               }
            }
         } else {
            if(this.field1237 > 0) {
               if(this.field1243) {
                  label182: {
                     if(this.field1231 < 0) {
                        var9 = this.method1325(var1, var2, var5, var3, var4.field1213[this.field1238]);
                        if(this.field1244 >= var5) {
                           return;
                        }

                        this.field1244 = var5 + var5 - 1 - this.field1244;
                        this.field1231 = -this.field1231;
                        if(--this.field1237 == 0) {
                           break label182;
                        }
                     }

                     do {
                        var9 = this.method1401(var1, var9, var6, var3, var4.field1213[this.field1239 - 1]);
                        if(this.field1244 < var6) {
                           return;
                        }

                        this.field1244 = var6 + var6 - 1 - this.field1244;
                        this.field1231 = -this.field1231;
                        if(--this.field1237 == 0) {
                           break;
                        }

                        var9 = this.method1325(var1, var9, var5, var3, var4.field1213[this.field1238]);
                        if(this.field1244 >= var5) {
                           return;
                        }

                        this.field1244 = var5 + var5 - 1 - this.field1244;
                        this.field1231 = -this.field1231;
                     } while(--this.field1237 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1231 < 0) {
                     while(true) {
                        var9 = this.method1325(var1, var9, var5, var3, var4.field1213[this.field1239 - 1]);
                        if(this.field1244 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1244) / var8;
                        if(var10 >= this.field1237) {
                           this.field1244 += var8 * this.field1237;
                           this.field1237 = 0;
                           break;
                        }

                        this.field1244 += var8 * var10;
                        this.field1237 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1401(var1, var9, var6, var3, var4.field1213[this.field1238]);
                        if(this.field1244 < var6) {
                           return;
                        }

                        var10 = (this.field1244 - var5) / var8;
                        if(var10 >= this.field1237) {
                           this.field1244 -= var8 * this.field1237;
                           this.field1237 = 0;
                           break;
                        }

                        this.field1244 -= var8 * var10;
                        this.field1237 -= var10;
                     }
                  }
               }
            }

            if(this.field1231 < 0) {
               this.method1325(var1, var9, 0, var3, 0);
               if(this.field1244 < 0) {
                  this.field1244 = -1;
                  this.method1317();
                  this.method3883();
               }
            } else {
               this.method1401(var1, var9, var7, var3, 0);
               if(this.field1244 >= var7) {
                  this.field1244 = var7;
                  this.method1317();
                  this.method3883();
               }
            }

         }
      }
   }

   @ObfuscatedName("u")
   public synchronized void vmethod3677(int var1) {
      if(this.field1241 > 0) {
         if(var1 >= this.field1241) {
            if(this.field1232 == Integer.MIN_VALUE) {
               this.field1232 = 0;
               this.field1236 = 0;
               this.field1240 = 0;
               this.field1234 = 0;
               this.method3883();
               var1 = this.field1241;
            }

            this.field1241 = 0;
            this.method1302();
         } else {
            this.field1234 += this.field1235 * var1;
            this.field1240 += this.field1242 * var1;
            this.field1236 += this.field1230 * var1;
            this.field1241 -= var1;
         }
      }

      class62 var2 = (class62)super.field1249;
      int var3 = this.field1238 << 8;
      int var4 = this.field1239 << 8;
      int var5 = var2.field1213.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1237 = 0;
      }

      if(this.field1244 < 0) {
         if(this.field1231 <= 0) {
            this.method1317();
            this.method3883();
            return;
         }

         this.field1244 = 0;
      }

      if(this.field1244 >= var5) {
         if(this.field1231 >= 0) {
            this.method1317();
            this.method3883();
            return;
         }

         this.field1244 = var5 - 1;
      }

      this.field1244 += this.field1231 * var1;
      if(this.field1237 < 0) {
         if(!this.field1243) {
            if(this.field1231 < 0) {
               if(this.field1244 >= var3) {
                  return;
               }

               this.field1244 = var4 - 1 - (var4 - 1 - this.field1244) % var6;
            } else {
               if(this.field1244 < var4) {
                  return;
               }

               this.field1244 = var3 + (this.field1244 - var3) % var6;
            }

         } else {
            if(this.field1231 < 0) {
               if(this.field1244 >= var3) {
                  return;
               }

               this.field1244 = var3 + var3 - 1 - this.field1244;
               this.field1231 = -this.field1231;
            }

            while(this.field1244 >= var4) {
               this.field1244 = var4 + var4 - 1 - this.field1244;
               this.field1231 = -this.field1231;
               if(this.field1244 >= var3) {
                  return;
               }

               this.field1244 = var3 + var3 - 1 - this.field1244;
               this.field1231 = -this.field1231;
            }

         }
      } else {
         if(this.field1237 > 0) {
            if(this.field1243) {
               label169: {
                  if(this.field1231 < 0) {
                     if(this.field1244 >= var3) {
                        return;
                     }

                     this.field1244 = var3 + var3 - 1 - this.field1244;
                     this.field1231 = -this.field1231;
                     if(--this.field1237 == 0) {
                        break label169;
                     }
                  }

                  do {
                     if(this.field1244 < var4) {
                        return;
                     }

                     this.field1244 = var4 + var4 - 1 - this.field1244;
                     this.field1231 = -this.field1231;
                     if(--this.field1237 == 0) {
                        break;
                     }

                     if(this.field1244 >= var3) {
                        return;
                     }

                     this.field1244 = var3 + var3 - 1 - this.field1244;
                     this.field1231 = -this.field1231;
                  } while(--this.field1237 != 0);
               }
            } else {
               label201: {
                  int var7;
                  if(this.field1231 < 0) {
                     if(this.field1244 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1244) / var6;
                     if(var7 >= this.field1237) {
                        this.field1244 += var6 * this.field1237;
                        this.field1237 = 0;
                        break label201;
                     }

                     this.field1244 += var6 * var7;
                     this.field1237 -= var7;
                  } else {
                     if(this.field1244 < var4) {
                        return;
                     }

                     var7 = (this.field1244 - var3) / var6;
                     if(var7 >= this.field1237) {
                        this.field1244 -= var6 * this.field1237;
                        this.field1237 = 0;
                        break label201;
                     }

                     this.field1244 -= var6 * var7;
                     this.field1237 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1231 < 0) {
            if(this.field1244 < 0) {
               this.field1244 = -1;
               this.method1317();
               this.method3883();
            }
         } else if(this.field1244 >= var5) {
            this.field1244 = var5;
            this.method1317();
            this.method3883();
         }

      }
   }

   @ObfuscatedName("ao")
   int method1325(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1241 > 0) {
            int var6 = var2 + this.field1241;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1241 += var2;
            if(this.field1231 == -256 && (this.field1244 & 255) == 0) {
               if(class113.field1944) {
                  var2 = method1308(0, ((class62)super.field1249).field1213, var1, this.field1244, var2, this.field1240, this.field1236, this.field1242, this.field1230, 0, var6, var3, this);
               } else {
                  var2 = method1337(((class62)super.field1249).field1213, var1, this.field1244, var2, this.field1234, this.field1235, 0, var6, var3, this);
               }
            } else if(class113.field1944) {
               var2 = method1342(0, 0, ((class62)super.field1249).field1213, var1, this.field1244, var2, this.field1240, this.field1236, this.field1242, this.field1230, 0, var6, var3, this, this.field1231, var5);
            } else {
               var2 = method1341(0, 0, ((class62)super.field1249).field1213, var1, this.field1244, var2, this.field1234, this.field1235, 0, var6, var3, this, this.field1231, var5);
            }

            this.field1241 -= var2;
            if(this.field1241 != 0) {
               return var2;
            }

            if(!this.method1326()) {
               continue;
            }

            return var4;
         }

         if(this.field1231 == -256 && (this.field1244 & 255) == 0) {
            if(class113.field1944) {
               return method1388(0, ((class62)super.field1249).field1213, var1, this.field1244, var2, this.field1240, this.field1236, 0, var4, var3, this);
            }

            return method1329(((class62)super.field1249).field1213, var1, this.field1244, var2, this.field1234, 0, var4, var3, this);
         }

         if(class113.field1944) {
            return method1334(0, 0, ((class62)super.field1249).field1213, var1, this.field1244, var2, this.field1240, this.field1236, 0, var4, var3, this, this.field1231, var5);
         }

         return method1400(0, 0, ((class62)super.field1249).field1213, var1, this.field1244, var2, this.field1234, 0, var4, var3, this, this.field1231, var5);
      }
   }

   @ObfuscatedName("ag")
   boolean method1326() {
      int var1 = this.field1232;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1396(var1, this.field1233);
         var3 = method1298(var1, this.field1233);
      }

      if(this.field1234 == var1 && this.field1240 == var2 && this.field1236 == var3) {
         if(this.field1232 == Integer.MIN_VALUE) {
            this.field1232 = 0;
            this.field1236 = 0;
            this.field1240 = 0;
            this.field1234 = 0;
            this.method3883();
            return true;
         } else {
            this.method1302();
            return false;
         }
      } else {
         if(this.field1234 < var1) {
            this.field1235 = 1;
            this.field1241 = var1 - this.field1234;
         } else if(this.field1234 > var1) {
            this.field1235 = -1;
            this.field1241 = this.field1234 - var1;
         } else {
            this.field1235 = 0;
         }

         if(this.field1240 < var2) {
            this.field1242 = 1;
            if(this.field1241 == 0 || this.field1241 > var2 - this.field1240) {
               this.field1241 = var2 - this.field1240;
            }
         } else if(this.field1240 > var2) {
            this.field1242 = -1;
            if(this.field1241 == 0 || this.field1241 > this.field1240 - var2) {
               this.field1241 = this.field1240 - var2;
            }
         } else {
            this.field1242 = 0;
         }

         if(this.field1236 < var3) {
            this.field1230 = 1;
            if(this.field1241 == 0 || this.field1241 > var3 - this.field1236) {
               this.field1241 = var3 - this.field1236;
            }
         } else if(this.field1236 > var3) {
            this.field1230 = -1;
            if(this.field1241 == 0 || this.field1241 > this.field1236 - var3) {
               this.field1241 = this.field1236 - var3;
            }
         } else {
            this.field1230 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("as")
   static int method1327(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1244 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("az")
   static int method1328(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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

      var10.field1244 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("av")
   static int method1329(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1244 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("aw")
   static int method1332(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
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

      var11.field1244 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("s")
   public synchronized void method1333(int var1) {
      if(var1 == 0) {
         this.method1305(0);
         this.method3883();
      } else if(this.field1240 == 0 && this.field1236 == 0) {
         this.field1241 = 0;
         this.field1232 = 0;
         this.field1234 = 0;
         this.method3883();
      } else {
         int var2 = -this.field1234;
         if(this.field1234 > var2) {
            var2 = this.field1234;
         }

         if(-this.field1240 > var2) {
            var2 = -this.field1240;
         }

         if(this.field1240 > var2) {
            var2 = this.field1240;
         }

         if(-this.field1236 > var2) {
            var2 = -this.field1236;
         }

         if(this.field1236 > var2) {
            var2 = this.field1236;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1241 = var1;
         this.field1232 = Integer.MIN_VALUE;
         this.field1235 = -this.field1234 / var1;
         this.field1242 = -this.field1240 / var1;
         this.field1230 = -this.field1236 / var1;
      }
   }

   @ObfuscatedName("ap")
   static int method1334(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
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

      var11.field1244 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ad")
   static int method1337(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1240 += var9.field1242 * (var6 - var3);
      var9.field1236 += var9.field1230 * (var6 - var3);

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

      var9.field1234 = var4 >> 2;
      var9.field1244 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("q")
   public synchronized int method1338() {
      return this.field1233 < 0?-1:this.field1233;
   }

   @ObfuscatedName("bb")
   static int method1339(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1240 -= var11.field1242 * var5;
      var11.field1236 -= var11.field1230 * var5;
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

      var11.field1240 += var11.field1242 * var5;
      var11.field1236 += var11.field1230 * var5;
      var11.field1234 = var6;
      var11.field1244 = var4;
      return var5;
   }

   @ObfuscatedName("bd")
   static int method1341(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1240 -= var11.field1242 * var5;
      var11.field1236 -= var11.field1230 * var5;
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

      var11.field1240 += var11.field1242 * var5;
      var11.field1236 += var11.field1230 * var5;
      var11.field1234 = var6;
      var11.field1244 = var4;
      return var5;
   }

   @ObfuscatedName("bx")
   static int method1342(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1234 -= var13.field1235 * var5;
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
      var13.field1234 += var13.field1235 * var5;
      var13.field1240 = var6;
      var13.field1236 = var7;
      var13.field1244 = var4;
      return var5;
   }

   @ObfuscatedName("at")
   static int method1388(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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

      var10.field1244 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ae")
   int vmethod1459() {
      int var1 = this.field1234 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1237 == 0) {
         var1 -= var1 * this.field1244 / (((class62)super.field1249).field1213.length << 8);
      } else if(this.field1237 >= 0) {
         var1 -= var1 * this.field1238 / ((class62)super.field1249).field1213.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("j")
   static int method1396(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ac")
   static int method1400(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
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

      var10.field1244 = var4;
      return var5;
   }

   @ObfuscatedName("ay")
   int method1401(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1241 > 0) {
            int var6 = var2 + this.field1241;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1241 += var2;
            if(this.field1231 == 256 && (this.field1244 & 255) == 0) {
               if(class113.field1944) {
                  var2 = method1419(0, ((class62)super.field1249).field1213, var1, this.field1244, var2, this.field1240, this.field1236, this.field1242, this.field1230, 0, var6, var3, this);
               } else {
                  var2 = method1446(((class62)super.field1249).field1213, var1, this.field1244, var2, this.field1234, this.field1235, 0, var6, var3, this);
               }
            } else if(class113.field1944) {
               var2 = method1441(0, 0, ((class62)super.field1249).field1213, var1, this.field1244, var2, this.field1240, this.field1236, this.field1242, this.field1230, 0, var6, var3, this, this.field1231, var5);
            } else {
               var2 = method1339(0, 0, ((class62)super.field1249).field1213, var1, this.field1244, var2, this.field1234, this.field1235, 0, var6, var3, this, this.field1231, var5);
            }

            this.field1241 -= var2;
            if(this.field1241 != 0) {
               return var2;
            }

            if(!this.method1326()) {
               continue;
            }

            return var4;
         }

         if(this.field1231 == 256 && (this.field1244 & 255) == 0) {
            if(class113.field1944) {
               return method1328(0, ((class62)super.field1249).field1213, var1, this.field1244, var2, this.field1240, this.field1236, 0, var4, var3, this);
            }

            return method1327(((class62)super.field1249).field1213, var1, this.field1244, var2, this.field1234, 0, var4, var3, this);
         }

         if(class113.field1944) {
            return method1332(0, 0, ((class62)super.field1249).field1213, var1, this.field1244, var2, this.field1240, this.field1236, 0, var4, var3, this, this.field1231, var5);
         }

         return method1299(0, 0, ((class62)super.field1249).field1213, var1, this.field1244, var2, this.field1234, 0, var4, var3, this, this.field1231, var5);
      }
   }

   @ObfuscatedName("g")
   public synchronized void method1402(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1301(var2, var3);
      } else {
         int var4 = method1396(var2, var3);
         int var5 = method1298(var2, var3);
         if(this.field1240 == var4 && this.field1236 == var5) {
            this.field1241 = 0;
         } else {
            int var6 = var2 - this.field1234;
            if(this.field1234 - var2 > var6) {
               var6 = this.field1234 - var2;
            }

            if(var4 - this.field1240 > var6) {
               var6 = var4 - this.field1240;
            }

            if(this.field1240 - var4 > var6) {
               var6 = this.field1240 - var4;
            }

            if(var5 - this.field1236 > var6) {
               var6 = var5 - this.field1236;
            }

            if(this.field1236 - var5 > var6) {
               var6 = this.field1236 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1241 = var1;
            this.field1232 = var2;
            this.field1233 = var3;
            this.field1235 = (var2 - this.field1234) / var1;
            this.field1242 = (var4 - this.field1240) / var1;
            this.field1230 = (var5 - this.field1236) / var1;
         }
      }
   }

   @ObfuscatedName("an")
   public boolean method1403() {
      return this.field1244 < 0 || this.field1244 >= ((class62)super.field1249).field1213.length << 8;
   }

   @ObfuscatedName("c")
   protected int vmethod3675() {
      return this.field1232 == 0 && this.field1241 == 0?0:1;
   }

   @ObfuscatedName("al")
   static int method1419(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1234 += var12.field1235 * (var9 - var4);
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

      var12.field1240 = var5 >> 2;
      var12.field1236 = var6 >> 2;
      var12.field1244 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bt")
   static int method1441(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1234 -= var13.field1235 * var5;
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
      var13.field1234 += var13.field1235 * var5;
      var13.field1240 = var6;
      var13.field1236 = var7;
      var13.field1244 = var4;
      return var5;
   }

   @ObfuscatedName("af")
   static int method1446(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1240 += var9.field1242 * (var6 - var3);
      var9.field1236 += var9.field1230 * (var6 - var3);

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

      var9.field1234 = var4 >> 2;
      var9.field1244 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("z")
   public static class64 method1447(class62 var0, int var1, int var2, int var3) {
      return var0.field1213 != null && var0.field1213.length != 0?new class64(var0, var1, var2, var3):null;
   }
}
