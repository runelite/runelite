import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
public class class66 extends class68 {
   @ObfuscatedName("a")
   int field1097;
   @ObfuscatedName("b")
   int field1098;
   @ObfuscatedName("i")
   int field1099;
   @ObfuscatedName("t")
   int field1100;
   @ObfuscatedName("k")
   int field1101;
   @ObfuscatedName("n")
   int field1102;
   @ObfuscatedName("x")
   boolean field1103;
   @ObfuscatedName("f")
   int field1104;
   @ObfuscatedName("p")
   int field1105;
   @ObfuscatedName("l")
   int field1106;
   @ObfuscatedName("r")
   int field1107;
   @ObfuscatedName("z")
   int field1108;
   @ObfuscatedName("o")
   int field1109;
   @ObfuscatedName("s")
   int field1110;
   @ObfuscatedName("h")
   int field1111;

   @ObfuscatedName("ab")
   public synchronized int method1233() {
      return this.field1106 < 0?-this.field1106:this.field1106;
   }

   @ObfuscatedName("l")
   static int method1234(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ad")
   int vmethod1397() {
      int var1 = this.field1101 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1104 == 0) {
         var1 -= var1 * this.field1098 / (((class55)super.field1127).field1009.length << 8);
      } else if(this.field1104 >= 0) {
         var1 -= var1 * this.field1097 / ((class55)super.field1127).field1009.length;
      }

      return var1 > 255?255:var1;
   }

   class66(class55 var1, int var2, int var3) {
      super.field1127 = var1;
      this.field1097 = var1.field1010;
      this.field1107 = var1.field1008;
      this.field1103 = var1.field1012;
      this.field1106 = var2;
      this.field1099 = var3;
      this.field1100 = 8192;
      this.field1098 = 0;
      this.method1238();
   }

   class66(class55 var1, int var2, int var3, int var4) {
      super.field1127 = var1;
      this.field1097 = var1.field1010;
      this.field1107 = var1.field1008;
      this.field1103 = var1.field1012;
      this.field1106 = var2;
      this.field1099 = var3;
      this.field1100 = var4;
      this.field1098 = 0;
      this.method1238();
   }

   @ObfuscatedName("i")
   public static class66 method1236(class55 var0, int var1, int var2) {
      return var0.field1009 != null && var0.field1009.length != 0?new class66(var0, (int)((long)var0.field1011 * 256L * (long)var1 / (long)(class202.field3079 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("t")
   public static class66 method1237(class55 var0, int var1, int var2, int var3) {
      return var0.field1009 != null && var0.field1009.length != 0?new class66(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("k")
   void method1238() {
      this.field1101 = this.field1099;
      this.field1111 = method1274(this.field1099, this.field1100);
      this.field1102 = method1234(this.field1099, this.field1100);
   }

   @ObfuscatedName("o")
   public synchronized void method1239(int var1) {
      this.field1104 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1241(int var1) {
      this.method1355(var1, this.method1288());
   }

   @ObfuscatedName("bi")
   static int method1242(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1111 -= var11.field1110 * var5;
      var11.field1102 -= var11.field1109 * var5;
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

      var11.field1111 += var11.field1110 * var5;
      var11.field1102 += var11.field1109 * var5;
      var11.field1101 = var6;
      var11.field1098 = var4;
      return var5;
   }

   @ObfuscatedName("q")
   public synchronized int method1243() {
      return this.field1099 == Integer.MIN_VALUE?0:this.field1099;
   }

   @ObfuscatedName("ag")
   int method1245(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1108 > 0) {
            int var6 = var2 + this.field1108;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1108 += var2;
            if(this.field1106 == -256 && (this.field1098 & 255) == 0) {
               if(class57.field1032) {
                  var2 = method1255(0, ((class55)super.field1127).field1009, var1, this.field1098, var2, this.field1111, this.field1102, this.field1110, this.field1109, 0, var6, var3, this);
               } else {
                  var2 = method1296(((class55)super.field1127).field1009, var1, this.field1098, var2, this.field1101, this.field1105, 0, var6, var3, this);
               }
            } else if(class57.field1032) {
               var2 = method1278(0, 0, ((class55)super.field1127).field1009, var1, this.field1098, var2, this.field1111, this.field1102, this.field1110, this.field1109, 0, var6, var3, this, this.field1106, var5);
            } else {
               var2 = method1277(0, 0, ((class55)super.field1127).field1009, var1, this.field1098, var2, this.field1101, this.field1105, 0, var6, var3, this, this.field1106, var5);
            }

            this.field1108 -= var2;
            if(this.field1108 != 0) {
               return var2;
            }

            if(!this.method1262()) {
               continue;
            }

            return var4;
         }

         if(this.field1106 == -256 && (this.field1098 & 255) == 0) {
            if(class57.field1032) {
               return method1266(0, ((class55)super.field1127).field1009, var1, this.field1098, var2, this.field1111, this.field1102, 0, var4, var3, this);
            }

            return method1265(((class55)super.field1127).field1009, var1, this.field1098, var2, this.field1101, 0, var4, var3, this);
         }

         if(class57.field1032) {
            return method1352(0, 0, ((class55)super.field1127).field1009, var1, this.field1098, var2, this.field1111, this.field1102, 0, var4, var3, this, this.field1106, var5);
         }

         return method1270(0, 0, ((class55)super.field1127).field1009, var1, this.field1098, var2, this.field1101, 0, var4, var3, this, this.field1106, var5);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1246() {
      this.field1106 = (this.field1106 ^ this.field1106 >> 31) + (this.field1106 >>> 31);
      this.field1106 = -this.field1106;
   }

   @ObfuscatedName("v")
   public synchronized void method1247(int var1) {
      int var2 = ((class55)super.field1127).field1009.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1098 = var1;
   }

   @ObfuscatedName("d")
   public synchronized void method1248(int var1, int var2) {
      this.method1371(var1, var2, this.method1288());
   }

   @ObfuscatedName("aj")
   public synchronized void method1251(int var1) {
      if(this.field1106 < 0) {
         this.field1106 = -var1;
      } else {
         this.field1106 = var1;
      }

   }

   @ObfuscatedName("ay")
   public boolean method1253() {
      return this.field1098 < 0 || this.field1098 >= ((class55)super.field1127).field1009.length << 8;
   }

   @ObfuscatedName("aa")
   public boolean method1254() {
      return this.field1108 != 0;
   }

   @ObfuscatedName("ba")
   static int method1255(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1101 += var12.field1105 * (var9 - var4);
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

      var12.field1111 = var5 >> 2;
      var12.field1102 = var6 >> 2;
      var12.field1098 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("z")
   protected class68 vmethod2746() {
      return null;
   }

   @ObfuscatedName("p")
   protected int vmethod2763() {
      return this.field1099 == 0 && this.field1108 == 0?0:1;
   }

   @ObfuscatedName("s")
   public synchronized void vmethod2747(int[] var1, int var2, int var3) {
      if(this.field1099 == 0 && this.field1108 == 0) {
         this.vmethod2748(var3);
      } else {
         class55 var4 = (class55)super.field1127;
         int var5 = this.field1097 << 8;
         int var6 = this.field1107 << 8;
         int var7 = var4.field1009.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1104 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1098 < 0) {
            if(this.field1106 <= 0) {
               this.method1372();
               this.unlink();
               return;
            }

            this.field1098 = 0;
         }

         if(this.field1098 >= var7) {
            if(this.field1106 >= 0) {
               this.method1372();
               this.unlink();
               return;
            }

            this.field1098 = var7 - 1;
         }

         if(this.field1104 < 0) {
            if(this.field1103) {
               if(this.field1106 < 0) {
                  var9 = this.method1245(var1, var2, var5, var3, var4.field1009[this.field1097]);
                  if(this.field1098 >= var5) {
                     return;
                  }

                  this.field1098 = var5 + var5 - 1 - this.field1098;
                  this.field1106 = -this.field1106;
               }

               while(true) {
                  var9 = this.method1260(var1, var9, var6, var3, var4.field1009[this.field1107 - 1]);
                  if(this.field1098 < var6) {
                     return;
                  }

                  this.field1098 = var6 + var6 - 1 - this.field1098;
                  this.field1106 = -this.field1106;
                  var9 = this.method1245(var1, var9, var5, var3, var4.field1009[this.field1097]);
                  if(this.field1098 >= var5) {
                     return;
                  }

                  this.field1098 = var5 + var5 - 1 - this.field1098;
                  this.field1106 = -this.field1106;
               }
            } else if(this.field1106 < 0) {
               while(true) {
                  var9 = this.method1245(var1, var9, var5, var3, var4.field1009[this.field1107 - 1]);
                  if(this.field1098 >= var5) {
                     return;
                  }

                  this.field1098 = var6 - 1 - (var6 - 1 - this.field1098) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1260(var1, var9, var6, var3, var4.field1009[this.field1097]);
                  if(this.field1098 < var6) {
                     return;
                  }

                  this.field1098 = var5 + (this.field1098 - var5) % var8;
               }
            }
         } else {
            if(this.field1104 > 0) {
               if(this.field1103) {
                  label183: {
                     if(this.field1106 < 0) {
                        var9 = this.method1245(var1, var2, var5, var3, var4.field1009[this.field1097]);
                        if(this.field1098 >= var5) {
                           return;
                        }

                        this.field1098 = var5 + var5 - 1 - this.field1098;
                        this.field1106 = -this.field1106;
                        if(--this.field1104 == 0) {
                           break label183;
                        }
                     }

                     do {
                        var9 = this.method1260(var1, var9, var6, var3, var4.field1009[this.field1107 - 1]);
                        if(this.field1098 < var6) {
                           return;
                        }

                        this.field1098 = var6 + var6 - 1 - this.field1098;
                        this.field1106 = -this.field1106;
                        if(--this.field1104 == 0) {
                           break;
                        }

                        var9 = this.method1245(var1, var9, var5, var3, var4.field1009[this.field1097]);
                        if(this.field1098 >= var5) {
                           return;
                        }

                        this.field1098 = var5 + var5 - 1 - this.field1098;
                        this.field1106 = -this.field1106;
                     } while(--this.field1104 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1106 < 0) {
                     while(true) {
                        var9 = this.method1245(var1, var9, var5, var3, var4.field1009[this.field1107 - 1]);
                        if(this.field1098 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1098) / var8;
                        if(var10 >= this.field1104) {
                           this.field1098 += var8 * this.field1104;
                           this.field1104 = 0;
                           break;
                        }

                        this.field1098 += var8 * var10;
                        this.field1104 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1260(var1, var9, var6, var3, var4.field1009[this.field1097]);
                        if(this.field1098 < var6) {
                           return;
                        }

                        var10 = (this.field1098 - var5) / var8;
                        if(var10 >= this.field1104) {
                           this.field1098 -= var8 * this.field1104;
                           this.field1104 = 0;
                           break;
                        }

                        this.field1098 -= var8 * var10;
                        this.field1104 -= var10;
                     }
                  }
               }
            }

            if(this.field1106 < 0) {
               this.method1245(var1, var9, 0, var3, 0);
               if(this.field1098 < 0) {
                  this.field1098 = -1;
                  this.method1372();
                  this.unlink();
               }
            } else {
               this.method1260(var1, var9, var7, var3, 0);
               if(this.field1098 >= var7) {
                  this.field1098 = var7;
                  this.method1372();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("w")
   public synchronized void method1259(int var1) {
      this.method1355(var1 << 6, this.method1288());
   }

   @ObfuscatedName("ar")
   int method1260(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1108 > 0) {
            int var6 = var2 + this.field1108;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1108 += var2;
            if(this.field1106 == 256 && (this.field1098 & 255) == 0) {
               if(class57.field1032) {
                  var2 = method1272(0, ((class55)super.field1127).field1009, var1, this.field1098, var2, this.field1111, this.field1102, this.field1110, this.field1109, 0, var6, var3, this);
               } else {
                  var2 = method1376(((class55)super.field1127).field1009, var1, this.field1098, var2, this.field1101, this.field1105, 0, var6, var3, this);
               }
            } else if(class57.field1032) {
               var2 = method1269(0, 0, ((class55)super.field1127).field1009, var1, this.field1098, var2, this.field1111, this.field1102, this.field1110, this.field1109, 0, var6, var3, this, this.field1106, var5);
            } else {
               var2 = method1242(0, 0, ((class55)super.field1127).field1009, var1, this.field1098, var2, this.field1101, this.field1105, 0, var6, var3, this, this.field1106, var5);
            }

            this.field1108 -= var2;
            if(this.field1108 != 0) {
               return var2;
            }

            if(!this.method1262()) {
               continue;
            }

            return var4;
         }

         if(this.field1106 == 256 && (this.field1098 & 255) == 0) {
            if(class57.field1032) {
               return method1264(0, ((class55)super.field1127).field1009, var1, this.field1098, var2, this.field1111, this.field1102, 0, var4, var3, this);
            }

            return method1283(((class55)super.field1127).field1009, var1, this.field1098, var2, this.field1101, 0, var4, var3, this);
         }

         if(class57.field1032) {
            return method1268(0, 0, ((class55)super.field1127).field1009, var1, this.field1098, var2, this.field1111, this.field1102, 0, var4, var3, this, this.field1106, var5);
         }

         return method1316(0, 0, ((class55)super.field1127).field1009, var1, this.field1098, var2, this.field1101, 0, var4, var3, this, this.field1106, var5);
      }
   }

   @ObfuscatedName("al")
   boolean method1262() {
      int var1 = this.field1099;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1274(var1, this.field1100);
         var3 = method1234(var1, this.field1100);
      }

      if(this.field1101 == var1 && this.field1111 == var2 && this.field1102 == var3) {
         if(this.field1099 == Integer.MIN_VALUE) {
            this.field1099 = 0;
            this.field1102 = 0;
            this.field1111 = 0;
            this.field1101 = 0;
            this.unlink();
            return true;
         } else {
            this.method1238();
            return false;
         }
      } else {
         if(this.field1101 < var1) {
            this.field1105 = 1;
            this.field1108 = var1 - this.field1101;
         } else if(this.field1101 > var1) {
            this.field1105 = -1;
            this.field1108 = this.field1101 - var1;
         } else {
            this.field1105 = 0;
         }

         if(this.field1111 < var2) {
            this.field1110 = 1;
            if(this.field1108 == 0 || this.field1108 > var2 - this.field1111) {
               this.field1108 = var2 - this.field1111;
            }
         } else if(this.field1111 > var2) {
            this.field1110 = -1;
            if(this.field1108 == 0 || this.field1108 > this.field1111 - var2) {
               this.field1108 = this.field1111 - var2;
            }
         } else {
            this.field1110 = 0;
         }

         if(this.field1102 < var3) {
            this.field1109 = 1;
            if(this.field1108 == 0 || this.field1108 > var3 - this.field1102) {
               this.field1108 = var3 - this.field1102;
            }
         } else if(this.field1102 > var3) {
            this.field1109 = -1;
            if(this.field1108 == 0 || this.field1108 > this.field1102 - var3) {
               this.field1108 = this.field1102 - var3;
            }
         } else {
            this.field1109 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ak")
   static int method1264(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1098 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ax")
   static int method1265(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1098 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("av")
   static int method1266(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1098 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ao")
   static int method1268(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1098 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bf")
   static int method1269(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1101 -= var13.field1105 * var5;
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
      var13.field1101 += var13.field1105 * var5;
      var13.field1111 = var6;
      var13.field1102 = var7;
      var13.field1098 = var4;
      return var5;
   }

   @ObfuscatedName("aq")
   static int method1270(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1098 = var4;
      return var5;
   }

   @ObfuscatedName("bg")
   static int method1272(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1101 += var12.field1105 * (var9 - var4);
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

      var12.field1111 = var5 >> 2;
      var12.field1102 = var6 >> 2;
      var12.field1098 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("b")
   static int method1274(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("y")
   public synchronized void vmethod2748(int var1) {
      if(this.field1108 > 0) {
         if(var1 >= this.field1108) {
            if(this.field1099 == Integer.MIN_VALUE) {
               this.field1099 = 0;
               this.field1102 = 0;
               this.field1111 = 0;
               this.field1101 = 0;
               this.unlink();
               var1 = this.field1108;
            }

            this.field1108 = 0;
            this.method1238();
         } else {
            this.field1101 += this.field1105 * var1;
            this.field1111 += this.field1110 * var1;
            this.field1102 += this.field1109 * var1;
            this.field1108 -= var1;
         }
      }

      class55 var2 = (class55)super.field1127;
      int var3 = this.field1097 << 8;
      int var4 = this.field1107 << 8;
      int var5 = var2.field1009.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1104 = 0;
      }

      if(this.field1098 < 0) {
         if(this.field1106 <= 0) {
            this.method1372();
            this.unlink();
            return;
         }

         this.field1098 = 0;
      }

      if(this.field1098 >= var5) {
         if(this.field1106 >= 0) {
            this.method1372();
            this.unlink();
            return;
         }

         this.field1098 = var5 - 1;
      }

      this.field1098 += this.field1106 * var1;
      if(this.field1104 < 0) {
         if(!this.field1103) {
            if(this.field1106 < 0) {
               if(this.field1098 >= var3) {
                  return;
               }

               this.field1098 = var4 - 1 - (var4 - 1 - this.field1098) % var6;
            } else {
               if(this.field1098 < var4) {
                  return;
               }

               this.field1098 = var3 + (this.field1098 - var3) % var6;
            }

         } else {
            if(this.field1106 < 0) {
               if(this.field1098 >= var3) {
                  return;
               }

               this.field1098 = var3 + var3 - 1 - this.field1098;
               this.field1106 = -this.field1106;
            }

            while(this.field1098 >= var4) {
               this.field1098 = var4 + var4 - 1 - this.field1098;
               this.field1106 = -this.field1106;
               if(this.field1098 >= var3) {
                  return;
               }

               this.field1098 = var3 + var3 - 1 - this.field1098;
               this.field1106 = -this.field1106;
            }

         }
      } else {
         if(this.field1104 > 0) {
            if(this.field1103) {
               label168: {
                  if(this.field1106 < 0) {
                     if(this.field1098 >= var3) {
                        return;
                     }

                     this.field1098 = var3 + var3 - 1 - this.field1098;
                     this.field1106 = -this.field1106;
                     if(--this.field1104 == 0) {
                        break label168;
                     }
                  }

                  do {
                     if(this.field1098 < var4) {
                        return;
                     }

                     this.field1098 = var4 + var4 - 1 - this.field1098;
                     this.field1106 = -this.field1106;
                     if(--this.field1104 == 0) {
                        break;
                     }

                     if(this.field1098 >= var3) {
                        return;
                     }

                     this.field1098 = var3 + var3 - 1 - this.field1098;
                     this.field1106 = -this.field1106;
                  } while(--this.field1104 != 0);
               }
            } else {
               label200: {
                  int var7;
                  if(this.field1106 < 0) {
                     if(this.field1098 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1098) / var6;
                     if(var7 >= this.field1104) {
                        this.field1098 += var6 * this.field1104;
                        this.field1104 = 0;
                        break label200;
                     }

                     this.field1098 += var6 * var7;
                     this.field1104 -= var7;
                  } else {
                     if(this.field1098 < var4) {
                        return;
                     }

                     var7 = (this.field1098 - var3) / var6;
                     if(var7 >= this.field1104) {
                        this.field1098 -= var6 * this.field1104;
                        this.field1104 = 0;
                        break label200;
                     }

                     this.field1098 -= var6 * var7;
                     this.field1104 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1106 < 0) {
            if(this.field1098 < 0) {
               this.field1098 = -1;
               this.method1372();
               this.unlink();
            }
         } else if(this.field1098 >= var5) {
            this.field1098 = var5;
            this.method1372();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("bd")
   static int method1277(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1111 -= var11.field1110 * var5;
      var11.field1102 -= var11.field1109 * var5;
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

      var11.field1111 += var11.field1110 * var5;
      var11.field1102 += var11.field1109 * var5;
      var11.field1101 = var6;
      var11.field1098 = var4;
      return var5;
   }

   @ObfuscatedName("bk")
   static int method1278(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1101 -= var13.field1105 * var5;
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
      var13.field1101 += var13.field1105 * var5;
      var13.field1111 = var6;
      var13.field1102 = var7;
      var13.field1098 = var4;
      return var5;
   }

   @ObfuscatedName("ah")
   static int method1283(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1098 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("c")
   public synchronized int method1288() {
      return this.field1100 < 0?-1:this.field1100;
   }

   @ObfuscatedName("bl")
   static int method1296(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1111 += var9.field1110 * (var6 - var3);
      var9.field1102 += var9.field1109 * (var6 - var3);

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

      var9.field1101 = var4 >> 2;
      var9.field1098 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ap")
   public synchronized void method1300(int var1) {
      if(var1 == 0) {
         this.method1241(0);
         this.unlink();
      } else if(this.field1111 == 0 && this.field1102 == 0) {
         this.field1108 = 0;
         this.field1099 = 0;
         this.field1101 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1101;
         if(this.field1101 > var2) {
            var2 = this.field1101;
         }

         if(-this.field1111 > var2) {
            var2 = -this.field1111;
         }

         if(this.field1111 > var2) {
            var2 = this.field1111;
         }

         if(-this.field1102 > var2) {
            var2 = -this.field1102;
         }

         if(this.field1102 > var2) {
            var2 = this.field1102;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1108 = var1;
         this.field1099 = Integer.MIN_VALUE;
         this.field1105 = -this.field1101 / var1;
         this.field1110 = -this.field1111 / var1;
         this.field1109 = -this.field1102 / var1;
      }
   }

   @ObfuscatedName("az")
   static int method1316(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1098 = var4;
      return var5;
   }

   @ObfuscatedName("x")
   protected class68 vmethod2744() {
      return null;
   }

   @ObfuscatedName("by")
   static int method1352(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1098 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("u")
   synchronized void method1355(int var1, int var2) {
      this.field1099 = var1;
      this.field1100 = var2;
      this.field1108 = 0;
      this.method1238();
   }

   @ObfuscatedName("g")
   public synchronized void method1371(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1355(var2, var3);
      } else {
         int var4 = method1274(var2, var3);
         int var5 = method1234(var2, var3);
         if(this.field1111 == var4 && this.field1102 == var5) {
            this.field1108 = 0;
         } else {
            int var6 = var2 - this.field1101;
            if(this.field1101 - var2 > var6) {
               var6 = this.field1101 - var2;
            }

            if(var4 - this.field1111 > var6) {
               var6 = var4 - this.field1111;
            }

            if(this.field1111 - var4 > var6) {
               var6 = this.field1111 - var4;
            }

            if(var5 - this.field1102 > var6) {
               var6 = var5 - this.field1102;
            }

            if(this.field1102 - var5 > var6) {
               var6 = this.field1102 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1108 = var1;
            this.field1099 = var2;
            this.field1100 = var3;
            this.field1105 = (var2 - this.field1101) / var1;
            this.field1110 = (var4 - this.field1111) / var1;
            this.field1109 = (var5 - this.field1102) / var1;
         }
      }
   }

   @ObfuscatedName("j")
   void method1372() {
      if(this.field1108 != 0) {
         if(this.field1099 == Integer.MIN_VALUE) {
            this.field1099 = 0;
         }

         this.field1108 = 0;
         this.method1238();
      }

   }

   @ObfuscatedName("bj")
   static int method1376(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1111 += var9.field1110 * (var6 - var3);
      var9.field1102 += var9.field1109 * (var6 - var3);

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

      var9.field1101 = var4 >> 2;
      var9.field1098 = var2 << 8;
      return var3;
   }
}
