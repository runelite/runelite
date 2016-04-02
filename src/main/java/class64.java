import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class64 extends class66 {
   @ObfuscatedName("j")
   int field1219;
   @ObfuscatedName("f")
   int field1220;
   @ObfuscatedName("s")
   int field1221;
   @ObfuscatedName("p")
   int field1222;
   @ObfuscatedName("h")
   int field1223;
   @ObfuscatedName("m")
   int field1224;
   @ObfuscatedName("a")
   int field1225;
   @ObfuscatedName("r")
   int field1226;
   @ObfuscatedName("k")
   int field1227;
   @ObfuscatedName("y")
   int field1228;
   @ObfuscatedName("n")
   boolean field1229;
   @ObfuscatedName("e")
   int field1230;
   @ObfuscatedName("i")
   int field1231;
   @ObfuscatedName("g")
   int field1232;
   @ObfuscatedName("l")
   int field1233;

   @ObfuscatedName("w")
   static int method1296(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   class64(class62 var1, int var2, int var3) {
      super.field1237 = var1;
      this.field1227 = var1.field1205;
      this.field1224 = var1.field1202;
      this.field1229 = var1.field1206;
      this.field1220 = var2;
      this.field1221 = var3;
      this.field1222 = 8192;
      this.field1230 = 0;
      this.method1301();
   }

   @ObfuscatedName("m")
   public synchronized void vmethod3717(int var1) {
      if(this.field1228 > 0) {
         if(var1 >= this.field1228) {
            if(this.field1221 == Integer.MIN_VALUE) {
               this.field1221 = 0;
               this.field1225 = 0;
               this.field1232 = 0;
               this.field1223 = 0;
               this.method3913();
               var1 = this.field1228;
            }

            this.field1228 = 0;
            this.method1301();
         } else {
            this.field1223 += this.field1231 * var1;
            this.field1232 += this.field1219 * var1;
            this.field1225 += this.field1233 * var1;
            this.field1228 -= var1;
         }
      }

      class62 var2 = (class62)super.field1237;
      int var3 = this.field1227 << 8;
      int var4 = this.field1224 << 8;
      int var5 = var2.field1203.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1226 = 0;
      }

      if(this.field1230 < 0) {
         if(this.field1220 <= 0) {
            this.method1310();
            this.method3913();
            return;
         }

         this.field1230 = 0;
      }

      if(this.field1230 >= var5) {
         if(this.field1220 >= 0) {
            this.method1310();
            this.method3913();
            return;
         }

         this.field1230 = var5 - 1;
      }

      this.field1230 += this.field1220 * var1;
      if(this.field1226 < 0) {
         if(!this.field1229) {
            if(this.field1220 < 0) {
               if(this.field1230 >= var3) {
                  return;
               }

               this.field1230 = var4 - 1 - (var4 - 1 - this.field1230) % var6;
            } else {
               if(this.field1230 < var4) {
                  return;
               }

               this.field1230 = var3 + (this.field1230 - var3) % var6;
            }

         } else {
            if(this.field1220 < 0) {
               if(this.field1230 >= var3) {
                  return;
               }

               this.field1230 = var3 + var3 - 1 - this.field1230;
               this.field1220 = -this.field1220;
            }

            while(this.field1230 >= var4) {
               this.field1230 = var4 + var4 - 1 - this.field1230;
               this.field1220 = -this.field1220;
               if(this.field1230 >= var3) {
                  return;
               }

               this.field1230 = var3 + var3 - 1 - this.field1230;
               this.field1220 = -this.field1220;
            }

         }
      } else {
         if(this.field1226 > 0) {
            if(this.field1229) {
               label171: {
                  if(this.field1220 < 0) {
                     if(this.field1230 >= var3) {
                        return;
                     }

                     this.field1230 = var3 + var3 - 1 - this.field1230;
                     this.field1220 = -this.field1220;
                     if(--this.field1226 == 0) {
                        break label171;
                     }
                  }

                  do {
                     if(this.field1230 < var4) {
                        return;
                     }

                     this.field1230 = var4 + var4 - 1 - this.field1230;
                     this.field1220 = -this.field1220;
                     if(--this.field1226 == 0) {
                        break;
                     }

                     if(this.field1230 >= var3) {
                        return;
                     }

                     this.field1230 = var3 + var3 - 1 - this.field1230;
                     this.field1220 = -this.field1220;
                  } while(--this.field1226 != 0);
               }
            } else {
               int var7;
               if(this.field1220 < 0) {
                  if(this.field1230 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1230) / var6;
                  if(var7 < this.field1226) {
                     this.field1230 += var6 * var7;
                     this.field1226 -= var7;
                     return;
                  }

                  this.field1230 += var6 * this.field1226;
                  this.field1226 = 0;
               } else {
                  if(this.field1230 < var4) {
                     return;
                  }

                  var7 = (this.field1230 - var3) / var6;
                  if(var7 < this.field1226) {
                     this.field1230 -= var6 * var7;
                     this.field1226 -= var7;
                     return;
                  }

                  this.field1230 -= var6 * this.field1226;
                  this.field1226 = 0;
               }
            }
         }

         if(this.field1220 < 0) {
            if(this.field1230 < 0) {
               this.field1230 = -1;
               this.method1310();
               this.method3913();
            }
         } else if(this.field1230 >= var5) {
            this.field1230 = var5;
            this.method1310();
            this.method3913();
         }

      }
   }

   @ObfuscatedName("s")
   public static class64 method1300(class62 var0, int var1, int var2, int var3) {
      return var0.field1203 != null && var0.field1203.length != 0?new class64(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("p")
   void method1301() {
      this.field1223 = this.field1221;
      this.field1232 = method1429(this.field1221, this.field1222);
      this.field1225 = method1296(this.field1221, this.field1222);
   }

   @ObfuscatedName("n")
   public synchronized void method1303(int var1) {
      this.method1305(var1 << 6, this.method1307());
   }

   @ObfuscatedName("y")
   synchronized void method1304(int var1) {
      this.method1305(var1, this.method1307());
   }

   @ObfuscatedName("i")
   synchronized void method1305(int var1, int var2) {
      this.field1221 = var1;
      this.field1222 = var2;
      this.field1228 = 0;
      this.method1301();
   }

   @ObfuscatedName("l")
   public synchronized int method1307() {
      return this.field1222 < 0?-1:this.field1222;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1309() {
      this.field1220 = (this.field1220 ^ this.field1220 >> 31) + (this.field1220 >>> 31);
      this.field1220 = -this.field1220;
   }

   @ObfuscatedName("x")
   void method1310() {
      if(this.field1228 != 0) {
         if(this.field1221 == Integer.MIN_VALUE) {
            this.field1221 = 0;
         }

         this.field1228 = 0;
         this.method1301();
      }

   }

   @ObfuscatedName("b")
   public synchronized void method1311(int var1, int var2) {
      this.method1358(var1, var2, this.method1307());
   }

   @ObfuscatedName("t")
   public synchronized void method1314(int var1) {
      if(this.field1220 < 0) {
         this.field1220 = -var1;
      } else {
         this.field1220 = var1;
      }

   }

   @ObfuscatedName("z")
   public boolean method1316() {
      return this.field1230 < 0 || this.field1230 >= ((class62)super.field1237).field1203.length << 8;
   }

   @ObfuscatedName("v")
   public boolean method1317() {
      return this.field1228 != 0;
   }

   @ObfuscatedName("h")
   protected class66 vmethod3713() {
      return null;
   }

   @ObfuscatedName("g")
   protected class66 vmethod3733() {
      return null;
   }

   @ObfuscatedName("a")
   protected int vmethod3715() {
      return this.field1221 == 0 && this.field1228 == 0?0:1;
   }

   @ObfuscatedName("r")
   public synchronized void vmethod3716(int[] var1, int var2, int var3) {
      if(this.field1221 == 0 && this.field1228 == 0) {
         this.vmethod3717(var3);
      } else {
         class62 var4 = (class62)super.field1237;
         int var5 = this.field1227 << 8;
         int var6 = this.field1224 << 8;
         int var7 = var4.field1203.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1226 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1230 < 0) {
            if(this.field1220 <= 0) {
               this.method1310();
               this.method3913();
               return;
            }

            this.field1230 = 0;
         }

         if(this.field1230 >= var7) {
            if(this.field1220 >= 0) {
               this.method1310();
               this.method3913();
               return;
            }

            this.field1230 = var7 - 1;
         }

         if(this.field1226 < 0) {
            if(this.field1229) {
               if(this.field1220 < 0) {
                  var9 = this.method1324(var1, var2, var5, var3, var4.field1203[this.field1227]);
                  if(this.field1230 >= var5) {
                     return;
                  }

                  this.field1230 = var5 + var5 - 1 - this.field1230;
                  this.field1220 = -this.field1220;
               }

               while(true) {
                  var9 = this.method1323(var1, var9, var6, var3, var4.field1203[this.field1224 - 1]);
                  if(this.field1230 < var6) {
                     return;
                  }

                  this.field1230 = var6 + var6 - 1 - this.field1230;
                  this.field1220 = -this.field1220;
                  var9 = this.method1324(var1, var9, var5, var3, var4.field1203[this.field1227]);
                  if(this.field1230 >= var5) {
                     return;
                  }

                  this.field1230 = var5 + var5 - 1 - this.field1230;
                  this.field1220 = -this.field1220;
               }
            } else if(this.field1220 < 0) {
               while(true) {
                  var9 = this.method1324(var1, var9, var5, var3, var4.field1203[this.field1224 - 1]);
                  if(this.field1230 >= var5) {
                     return;
                  }

                  this.field1230 = var6 - 1 - (var6 - 1 - this.field1230) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1323(var1, var9, var6, var3, var4.field1203[this.field1227]);
                  if(this.field1230 < var6) {
                     return;
                  }

                  this.field1230 = var5 + (this.field1230 - var5) % var8;
               }
            }
         } else {
            if(this.field1226 > 0) {
               if(this.field1229) {
                  label182: {
                     if(this.field1220 < 0) {
                        var9 = this.method1324(var1, var2, var5, var3, var4.field1203[this.field1227]);
                        if(this.field1230 >= var5) {
                           return;
                        }

                        this.field1230 = var5 + var5 - 1 - this.field1230;
                        this.field1220 = -this.field1220;
                        if(--this.field1226 == 0) {
                           break label182;
                        }
                     }

                     do {
                        var9 = this.method1323(var1, var9, var6, var3, var4.field1203[this.field1224 - 1]);
                        if(this.field1230 < var6) {
                           return;
                        }

                        this.field1230 = var6 + var6 - 1 - this.field1230;
                        this.field1220 = -this.field1220;
                        if(--this.field1226 == 0) {
                           break;
                        }

                        var9 = this.method1324(var1, var9, var5, var3, var4.field1203[this.field1227]);
                        if(this.field1230 >= var5) {
                           return;
                        }

                        this.field1230 = var5 + var5 - 1 - this.field1230;
                        this.field1220 = -this.field1220;
                     } while(--this.field1226 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1220 < 0) {
                     while(true) {
                        var9 = this.method1324(var1, var9, var5, var3, var4.field1203[this.field1224 - 1]);
                        if(this.field1230 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1230) / var8;
                        if(var10 >= this.field1226) {
                           this.field1230 += var8 * this.field1226;
                           this.field1226 = 0;
                           break;
                        }

                        this.field1230 += var8 * var10;
                        this.field1226 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1323(var1, var9, var6, var3, var4.field1203[this.field1227]);
                        if(this.field1230 < var6) {
                           return;
                        }

                        var10 = (this.field1230 - var5) / var8;
                        if(var10 >= this.field1226) {
                           this.field1230 -= var8 * this.field1226;
                           this.field1226 = 0;
                           break;
                        }

                        this.field1230 -= var8 * var10;
                        this.field1226 -= var10;
                     }
                  }
               }
            }

            if(this.field1220 < 0) {
               this.method1324(var1, var9, 0, var3, 0);
               if(this.field1230 < 0) {
                  this.field1230 = -1;
                  this.method1310();
                  this.method3913();
               }
            } else {
               this.method1323(var1, var9, var7, var3, 0);
               if(this.field1230 >= var7) {
                  this.field1230 = var7;
                  this.method1310();
                  this.method3913();
               }
            }

         }
      }
   }

   @ObfuscatedName("f")
   public static class64 method1322(class62 var0, int var1, int var2) {
      return var0.field1203 != null && var0.field1203.length != 0?new class64(var0, (int)((long)var0.field1204 * 256L * (long)var1 / (long)(class56.field1153 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("ag")
   int method1323(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1228 > 0) {
            int var6 = var2 + this.field1228;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1228 += var2;
            if(this.field1220 == 256 && (this.field1230 & 255) == 0) {
               if(class56.field1160) {
                  var2 = method1335(0, ((class62)super.field1237).field1203, var1, this.field1230, var2, this.field1232, this.field1225, this.field1219, this.field1233, 0, var6, var3, this);
               } else {
                  var2 = method1334(((class62)super.field1237).field1203, var1, this.field1230, var2, this.field1223, this.field1231, 0, var6, var3, this);
               }
            } else if(class56.field1160) {
               var2 = method1339(0, 0, ((class62)super.field1237).field1203, var1, this.field1230, var2, this.field1232, this.field1225, this.field1219, this.field1233, 0, var6, var3, this, this.field1220, var5);
            } else {
               var2 = method1338(0, 0, ((class62)super.field1237).field1203, var1, this.field1230, var2, this.field1223, this.field1231, 0, var6, var3, this, this.field1220, var5);
            }

            this.field1228 -= var2;
            if(this.field1228 != 0) {
               return var2;
            }

            if(!this.method1440()) {
               continue;
            }

            return var4;
         }

         if(this.field1220 == 256 && (this.field1230 & 255) == 0) {
            if(class56.field1160) {
               return method1327(0, ((class62)super.field1237).field1203, var1, this.field1230, var2, this.field1232, this.field1225, 0, var4, var3, this);
            }

            return method1326(((class62)super.field1237).field1203, var1, this.field1230, var2, this.field1223, 0, var4, var3, this);
         }

         if(class56.field1160) {
            return method1331(0, 0, ((class62)super.field1237).field1203, var1, this.field1230, var2, this.field1232, this.field1225, 0, var4, var3, this, this.field1220, var5);
         }

         return method1431(0, 0, ((class62)super.field1237).field1203, var1, this.field1230, var2, this.field1223, 0, var4, var3, this, this.field1220, var5);
      }
   }

   @ObfuscatedName("av")
   int method1324(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1228 > 0) {
            int var6 = var2 + this.field1228;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1228 += var2;
            if(this.field1220 == -256 && (this.field1230 & 255) == 0) {
               if(class56.field1160) {
                  var2 = method1325(0, ((class62)super.field1237).field1203, var1, this.field1230, var2, this.field1232, this.field1225, this.field1219, this.field1233, 0, var6, var3, this);
               } else {
                  var2 = method1442(((class62)super.field1237).field1203, var1, this.field1230, var2, this.field1223, this.field1231, 0, var6, var3, this);
               }
            } else if(class56.field1160) {
               var2 = method1341(0, 0, ((class62)super.field1237).field1203, var1, this.field1230, var2, this.field1232, this.field1225, this.field1219, this.field1233, 0, var6, var3, this, this.field1220, var5);
            } else {
               var2 = method1340(0, 0, ((class62)super.field1237).field1203, var1, this.field1230, var2, this.field1223, this.field1231, 0, var6, var3, this, this.field1220, var5);
            }

            this.field1228 -= var2;
            if(this.field1228 != 0) {
               return var2;
            }

            if(!this.method1440()) {
               continue;
            }

            return var4;
         }

         if(this.field1220 == -256 && (this.field1230 & 255) == 0) {
            if(class56.field1160) {
               return method1329(0, ((class62)super.field1237).field1203, var1, this.field1230, var2, this.field1232, this.field1225, 0, var4, var3, this);
            }

            return method1328(((class62)super.field1237).field1203, var1, this.field1230, var2, this.field1223, 0, var4, var3, this);
         }

         if(class56.field1160) {
            return method1333(0, 0, ((class62)super.field1237).field1203, var1, this.field1230, var2, this.field1232, this.field1225, 0, var4, var3, this, this.field1220, var5);
         }

         return method1332(0, 0, ((class62)super.field1237).field1203, var1, this.field1230, var2, this.field1223, 0, var4, var3, this, this.field1220, var5);
      }
   }

   @ObfuscatedName("bl")
   static int method1325(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1223 += var12.field1231 * (var9 - var4);
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

      var12.field1232 = var5 >> 2;
      var12.field1225 = var6 >> 2;
      var12.field1230 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("an")
   static int method1326(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1230 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ax")
   static int method1327(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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

      var10.field1230 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("at")
   static int method1328(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class64 var8) {
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

      var8.field1230 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ao")
   static int method1329(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10) {
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

      var10.field1230 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ak")
   static int method1331(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
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

      var11.field1230 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("as")
   static int method1332(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
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

      var10.field1230 = var4;
      return var5;
   }

   @ObfuscatedName("bj")
   static int method1333(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
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

      var11.field1230 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bq")
   static int method1334(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1232 += var9.field1219 * (var6 - var3);
      var9.field1225 += var9.field1233 * (var6 - var3);

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

      var9.field1223 = var4 >> 2;
      var9.field1230 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bo")
   static int method1335(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class64 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1223 += var12.field1231 * (var9 - var4);
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

      var12.field1232 = var5 >> 2;
      var12.field1225 = var6 >> 2;
      var12.field1230 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bd")
   static int method1338(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1232 -= var11.field1219 * var5;
      var11.field1225 -= var11.field1233 * var5;
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

      var11.field1232 += var11.field1219 * var5;
      var11.field1225 += var11.field1233 * var5;
      var11.field1223 = var6;
      var11.field1230 = var4;
      return var5;
   }

   @ObfuscatedName("bh")
   static int method1339(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1223 -= var13.field1231 * var5;
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
      var13.field1223 += var13.field1231 * var5;
      var13.field1232 = var6;
      var13.field1225 = var7;
      var13.field1230 = var4;
      return var5;
   }

   @ObfuscatedName("bw")
   static int method1340(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class64 var11, int var12, int var13) {
      var11.field1232 -= var11.field1219 * var5;
      var11.field1225 -= var11.field1233 * var5;
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

      var11.field1232 += var11.field1219 * var5;
      var11.field1225 += var11.field1233 * var5;
      var11.field1223 = var6;
      var11.field1230 = var4;
      return var5;
   }

   @ObfuscatedName("bn")
   static int method1341(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class64 var13, int var14, int var15) {
      var13.field1223 -= var13.field1231 * var5;
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
      var13.field1223 += var13.field1231 * var5;
      var13.field1232 = var6;
      var13.field1225 = var7;
      var13.field1230 = var4;
      return var5;
   }

   @ObfuscatedName("o")
   public synchronized void method1349(int var1) {
      int var2 = ((class62)super.field1237).field1203.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1230 = var1;
   }

   @ObfuscatedName("q")
   public synchronized void method1358(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1305(var2, var3);
      } else {
         int var4 = method1429(var2, var3);
         int var5 = method1296(var2, var3);
         if(this.field1232 == var4 && this.field1225 == var5) {
            this.field1228 = 0;
         } else {
            int var6 = var2 - this.field1223;
            if(this.field1223 - var2 > var6) {
               var6 = this.field1223 - var2;
            }

            if(var4 - this.field1232 > var6) {
               var6 = var4 - this.field1232;
            }

            if(this.field1232 - var4 > var6) {
               var6 = this.field1232 - var4;
            }

            if(var5 - this.field1225 > var6) {
               var6 = var5 - this.field1225;
            }

            if(this.field1225 - var5 > var6) {
               var6 = this.field1225 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1228 = var1;
            this.field1221 = var2;
            this.field1222 = var3;
            this.field1231 = (var2 - this.field1223) / var1;
            this.field1219 = (var4 - this.field1232) / var1;
            this.field1233 = (var5 - this.field1225) / var1;
         }
      }
   }

   @ObfuscatedName("j")
   public synchronized int method1364() {
      return this.field1221 == Integer.MIN_VALUE?0:this.field1221;
   }

   class64(class62 var1, int var2, int var3, int var4) {
      super.field1237 = var1;
      this.field1227 = var1.field1205;
      this.field1224 = var1.field1202;
      this.field1229 = var1.field1206;
      this.field1220 = var2;
      this.field1221 = var3;
      this.field1222 = var4;
      this.field1230 = 0;
      this.method1301();
   }

   @ObfuscatedName("au")
   int vmethod1461() {
      int var1 = this.field1223 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1226 == 0) {
         var1 -= var1 * this.field1230 / (((class62)super.field1237).field1203.length << 8);
      } else if(this.field1226 >= 0) {
         var1 -= var1 * this.field1227 / ((class62)super.field1237).field1203.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("d")
   public synchronized int method1396() {
      return this.field1220 < 0?-this.field1220:this.field1220;
   }

   @ObfuscatedName("e")
   static int method1429(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("al")
   static int method1431(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class64 var10, int var11, int var12) {
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

      var10.field1230 = var4;
      return var5;
   }

   @ObfuscatedName("ac")
   boolean method1440() {
      int var1 = this.field1221;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1429(var1, this.field1222);
         var3 = method1296(var1, this.field1222);
      }

      if(this.field1223 == var1 && this.field1232 == var2 && this.field1225 == var3) {
         if(this.field1221 == Integer.MIN_VALUE) {
            this.field1221 = 0;
            this.field1225 = 0;
            this.field1232 = 0;
            this.field1223 = 0;
            this.method3913();
            return true;
         } else {
            this.method1301();
            return false;
         }
      } else {
         if(this.field1223 < var1) {
            this.field1231 = 1;
            this.field1228 = var1 - this.field1223;
         } else if(this.field1223 > var1) {
            this.field1231 = -1;
            this.field1228 = this.field1223 - var1;
         } else {
            this.field1231 = 0;
         }

         if(this.field1232 < var2) {
            this.field1219 = 1;
            if(this.field1228 == 0 || this.field1228 > var2 - this.field1232) {
               this.field1228 = var2 - this.field1232;
            }
         } else if(this.field1232 > var2) {
            this.field1219 = -1;
            if(this.field1228 == 0 || this.field1228 > this.field1232 - var2) {
               this.field1228 = this.field1232 - var2;
            }
         } else {
            this.field1219 = 0;
         }

         if(this.field1225 < var3) {
            this.field1233 = 1;
            if(this.field1228 == 0 || this.field1228 > var3 - this.field1225) {
               this.field1228 = var3 - this.field1225;
            }
         } else if(this.field1225 > var3) {
            this.field1233 = -1;
            if(this.field1228 == 0 || this.field1228 > this.field1225 - var3) {
               this.field1228 = this.field1225 - var3;
            }
         } else {
            this.field1233 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("k")
   public synchronized void method1441(int var1) {
      this.field1226 = var1;
   }

   @ObfuscatedName("br")
   static int method1442(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class64 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1232 += var9.field1219 * (var6 - var3);
      var9.field1225 += var9.field1233 * (var6 - var3);

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

      var9.field1223 = var4 >> 2;
      var9.field1230 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("u")
   public synchronized void method1444(int var1) {
      if(var1 == 0) {
         this.method1304(0);
         this.method3913();
      } else if(this.field1232 == 0 && this.field1225 == 0) {
         this.field1228 = 0;
         this.field1221 = 0;
         this.field1223 = 0;
         this.method3913();
      } else {
         int var2 = -this.field1223;
         if(this.field1223 > var2) {
            var2 = this.field1223;
         }

         if(-this.field1232 > var2) {
            var2 = -this.field1232;
         }

         if(this.field1232 > var2) {
            var2 = this.field1232;
         }

         if(-this.field1225 > var2) {
            var2 = -this.field1225;
         }

         if(this.field1225 > var2) {
            var2 = this.field1225;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1228 = var1;
         this.field1221 = Integer.MIN_VALUE;
         this.field1231 = -this.field1223 / var1;
         this.field1219 = -this.field1232 / var1;
         this.field1233 = -this.field1225 / var1;
      }
   }
}
