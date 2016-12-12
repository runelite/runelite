import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class66 extends class68 {
   @ObfuscatedName("i")
   int field1118;
   @ObfuscatedName("e")
   int field1119;
   @ObfuscatedName("f")
   int field1120;
   @ObfuscatedName("k")
   int field1121;
   @ObfuscatedName("g")
   int field1122;
   @ObfuscatedName("n")
   int field1123;
   @ObfuscatedName("a")
   int field1124;
   @ObfuscatedName("m")
   int field1125;
   @ObfuscatedName("c")
   int field1126;
   @ObfuscatedName("h")
   int field1127;
   @ObfuscatedName("q")
   int field1128;
   @ObfuscatedName("l")
   int field1129;
   @ObfuscatedName("p")
   boolean field1130;
   @ObfuscatedName("v")
   int field1131;
   @ObfuscatedName("r")
   int field1132;

   @ObfuscatedName("as")
   int vmethod1324() {
      int var1 = this.field1122 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1128 == 0) {
         var1 -= var1 * this.field1118 / (((class55)super.field1147).field1022.length << 8);
      } else if(this.field1128 >= 0) {
         var1 -= var1 * this.field1131 / ((class55)super.field1147).field1022.length;
      }

      return var1 > 255?255:var1;
   }

   class66(class55 var1, int var2, int var3) {
      super.field1147 = var1;
      this.field1131 = var1.field1023;
      this.field1127 = var1.field1025;
      this.field1130 = var1.field1024;
      this.field1119 = var2;
      this.field1120 = var3;
      this.field1121 = 8192;
      this.field1118 = 0;
      this.method1161();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1158(int var1) {
      this.method1165(var1, this.method1167());
   }

   @ObfuscatedName("f")
   public static class66 method1159(class55 var0, int var1, int var2) {
      return var0.field1022 != null && var0.field1022.length != 0?new class66(var0, (int)((long)var0.field1026 * 256L * (long)var1 / (long)(class57.field1053 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("k")
   public static class66 method1160(class55 var0, int var1, int var2, int var3) {
      return var0.field1022 != null && var0.field1022.length != 0?new class66(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("a")
   void method1161() {
      this.field1122 = this.field1120;
      this.field1123 = method1205(this.field1120, this.field1121);
      this.field1124 = method1271(this.field1120, this.field1121);
   }

   @ObfuscatedName("p")
   public synchronized void method1162(int var1) {
      this.field1128 = var1;
   }

   @ObfuscatedName("c")
   public synchronized void method1163(int var1) {
      this.method1165(var1 << 6, this.method1167());
   }

   @ObfuscatedName("bh")
   static int method1164(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1123 += var9.field1125 * (var6 - var3);
      var9.field1124 += var9.field1132 * (var6 - var3);

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

      var9.field1122 = var4 >> 2;
      var9.field1118 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("r")
   synchronized void method1165(int var1, int var2) {
      this.field1120 = var1;
      this.field1121 = var2;
      this.field1129 = 0;
      this.method1161();
   }

   @ObfuscatedName("u")
   public synchronized int method1166() {
      return this.field1120 == Integer.MIN_VALUE?0:this.field1120;
   }

   @ObfuscatedName("j")
   public synchronized int method1167() {
      return this.field1121 < 0?-1:this.field1121;
   }

   @ObfuscatedName("x")
   public synchronized void method1168(int var1) {
      int var2 = ((class55)super.field1147).field1022.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1118 = var1;
   }

   @ObfuscatedName("aw")
   public synchronized void method1172(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1165(var2, var3);
      } else {
         int var4 = method1205(var2, var3);
         int var5 = method1271(var2, var3);
         if(this.field1123 == var4 && this.field1124 == var5) {
            this.field1129 = 0;
         } else {
            int var6 = var2 - this.field1122;
            if(this.field1122 - var2 > var6) {
               var6 = this.field1122 - var2;
            }

            if(var4 - this.field1123 > var6) {
               var6 = var4 - this.field1123;
            }

            if(this.field1123 - var4 > var6) {
               var6 = this.field1123 - var4;
            }

            if(var5 - this.field1124 > var6) {
               var6 = var5 - this.field1124;
            }

            if(this.field1124 - var5 > var6) {
               var6 = this.field1124 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1129 = var1;
            this.field1120 = var2;
            this.field1121 = var3;
            this.field1126 = (var2 - this.field1122) / var1;
            this.field1125 = (var4 - this.field1123) / var1;
            this.field1132 = (var5 - this.field1124) / var1;
         }
      }
   }

   @ObfuscatedName("am")
   public synchronized void method1173(int var1) {
      if(var1 == 0) {
         this.method1158(0);
         this.unlink();
      } else if(this.field1123 == 0 && this.field1124 == 0) {
         this.field1129 = 0;
         this.field1120 = 0;
         this.field1122 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1122;
         if(this.field1122 > var2) {
            var2 = this.field1122;
         }

         if(-this.field1123 > var2) {
            var2 = -this.field1123;
         }

         if(this.field1123 > var2) {
            var2 = this.field1123;
         }

         if(-this.field1124 > var2) {
            var2 = -this.field1124;
         }

         if(this.field1124 > var2) {
            var2 = this.field1124;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1129 = var1;
         this.field1120 = Integer.MIN_VALUE;
         this.field1126 = -this.field1122 / var1;
         this.field1125 = -this.field1123 / var1;
         this.field1132 = -this.field1124 / var1;
      }
   }

   @ObfuscatedName("av")
   public synchronized void method1174(int var1) {
      if(this.field1119 < 0) {
         this.field1119 = -var1;
      } else {
         this.field1119 = var1;
      }

   }

   @ObfuscatedName("ad")
   public boolean method1176() {
      return this.field1118 < 0 || this.field1118 >= ((class55)super.field1147).field1022.length << 8;
   }

   @ObfuscatedName("q")
   protected class68 vmethod2666() {
      return null;
   }

   @ObfuscatedName("w")
   protected class68 vmethod2658() {
      return null;
   }

   @ObfuscatedName("v")
   protected int vmethod2649() {
      return this.field1120 == 0 && this.field1129 == 0?0:1;
   }

   @ObfuscatedName("l")
   public synchronized void vmethod2651(int var1) {
      if(this.field1129 > 0) {
         if(var1 >= this.field1129) {
            if(this.field1120 == Integer.MIN_VALUE) {
               this.field1120 = 0;
               this.field1124 = 0;
               this.field1123 = 0;
               this.field1122 = 0;
               this.unlink();
               var1 = this.field1129;
            }

            this.field1129 = 0;
            this.method1161();
         } else {
            this.field1122 += this.field1126 * var1;
            this.field1123 += this.field1125 * var1;
            this.field1124 += this.field1132 * var1;
            this.field1129 -= var1;
         }
      }

      class55 var2 = (class55)super.field1147;
      int var3 = this.field1131 << 8;
      int var4 = this.field1127 << 8;
      int var5 = var2.field1022.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1128 = 0;
      }

      if(this.field1118 < 0) {
         if(this.field1119 <= 0) {
            this.method1289();
            this.unlink();
            return;
         }

         this.field1118 = 0;
      }

      if(this.field1118 >= var5) {
         if(this.field1119 >= 0) {
            this.method1289();
            this.unlink();
            return;
         }

         this.field1118 = var5 - 1;
      }

      this.field1118 += this.field1119 * var1;
      if(this.field1128 < 0) {
         if(!this.field1130) {
            if(this.field1119 < 0) {
               if(this.field1118 >= var3) {
                  return;
               }

               this.field1118 = var4 - 1 - (var4 - 1 - this.field1118) % var6;
            } else {
               if(this.field1118 < var4) {
                  return;
               }

               this.field1118 = var3 + (this.field1118 - var3) % var6;
            }

         } else {
            if(this.field1119 < 0) {
               if(this.field1118 >= var3) {
                  return;
               }

               this.field1118 = var3 + var3 - 1 - this.field1118;
               this.field1119 = -this.field1119;
            }

            while(this.field1118 >= var4) {
               this.field1118 = var4 + var4 - 1 - this.field1118;
               this.field1119 = -this.field1119;
               if(this.field1118 >= var3) {
                  return;
               }

               this.field1118 = var3 + var3 - 1 - this.field1118;
               this.field1119 = -this.field1119;
            }

         }
      } else {
         if(this.field1128 > 0) {
            if(this.field1130) {
               label164: {
                  if(this.field1119 < 0) {
                     if(this.field1118 >= var3) {
                        return;
                     }

                     this.field1118 = var3 + var3 - 1 - this.field1118;
                     this.field1119 = -this.field1119;
                     if(--this.field1128 == 0) {
                        break label164;
                     }
                  }

                  do {
                     if(this.field1118 < var4) {
                        return;
                     }

                     this.field1118 = var4 + var4 - 1 - this.field1118;
                     this.field1119 = -this.field1119;
                     if(--this.field1128 == 0) {
                        break;
                     }

                     if(this.field1118 >= var3) {
                        return;
                     }

                     this.field1118 = var3 + var3 - 1 - this.field1118;
                     this.field1119 = -this.field1119;
                  } while(--this.field1128 != 0);
               }
            } else {
               int var7;
               if(this.field1119 < 0) {
                  if(this.field1118 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1118) / var6;
                  if(var7 < this.field1128) {
                     this.field1118 += var6 * var7;
                     this.field1128 -= var7;
                     return;
                  }

                  this.field1118 += var6 * this.field1128;
                  this.field1128 = 0;
               } else {
                  if(this.field1118 < var4) {
                     return;
                  }

                  var7 = (this.field1118 - var3) / var6;
                  if(var7 < this.field1128) {
                     this.field1118 -= var6 * var7;
                     this.field1128 -= var7;
                     return;
                  }

                  this.field1118 -= var6 * this.field1128;
                  this.field1128 = 0;
               }
            }
         }

         if(this.field1119 < 0) {
            if(this.field1118 < 0) {
               this.field1118 = -1;
               this.method1289();
               this.unlink();
            }
         } else if(this.field1118 >= var5) {
            this.field1118 = var5;
            this.method1289();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("al")
   int method1183(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1129 > 0) {
            int var6 = var2 + this.field1129;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1129 += var2;
            if(this.field1119 == 256 && (this.field1118 & 255) == 0) {
               if(class57.field1062) {
                  var2 = method1195(0, ((class55)super.field1147).field1022, var1, this.field1118, var2, this.field1123, this.field1124, this.field1125, this.field1132, 0, var6, var3, this);
               } else {
                  var2 = method1164(((class55)super.field1147).field1022, var1, this.field1118, var2, this.field1122, this.field1126, 0, var6, var3, this);
               }
            } else if(class57.field1062) {
               var2 = method1199(0, 0, ((class55)super.field1147).field1022, var1, this.field1118, var2, this.field1123, this.field1124, this.field1125, this.field1132, 0, var6, var3, this, this.field1119, var5);
            } else {
               var2 = method1198(0, 0, ((class55)super.field1147).field1022, var1, this.field1118, var2, this.field1122, this.field1126, 0, var6, var3, this, this.field1119, var5);
            }

            this.field1129 -= var2;
            if(this.field1129 != 0) {
               return var2;
            }

            if(!this.method1245()) {
               continue;
            }

            return var4;
         }

         if(this.field1119 == 256 && (this.field1118 & 255) == 0) {
            if(class57.field1062) {
               return method1248(0, ((class55)super.field1147).field1022, var1, this.field1118, var2, this.field1123, this.field1124, 0, var4, var3, this);
            }

            return method1186(((class55)super.field1147).field1022, var1, this.field1118, var2, this.field1122, 0, var4, var3, this);
         }

         if(class57.field1062) {
            return method1191(0, 0, ((class55)super.field1147).field1022, var1, this.field1118, var2, this.field1123, this.field1124, 0, var4, var3, this, this.field1119, var5);
         }

         return method1190(0, 0, ((class55)super.field1147).field1022, var1, this.field1118, var2, this.field1122, 0, var4, var3, this, this.field1119, var5);
      }
   }

   @ObfuscatedName("ax")
   static int method1186(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1118 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bq")
   static int method1187(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1118 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ah")
   static int method1188(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1118 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ae")
   static int method1190(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1118 = var4;
      return var5;
   }

   @ObfuscatedName("au")
   static int method1191(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1118 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ag")
   static int method1192(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1118 = var4;
      return var5;
   }

   @ObfuscatedName("aj")
   public synchronized void method1193(int var1, int var2) {
      this.method1172(var1, var2, this.method1167());
   }

   @ObfuscatedName("aa")
   public synchronized int method1194() {
      return this.field1119 < 0?-this.field1119:this.field1119;
   }

   @ObfuscatedName("bw")
   static int method1195(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1122 += var12.field1126 * (var9 - var4);
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

      var12.field1123 = var5 >> 2;
      var12.field1124 = var6 >> 2;
      var12.field1118 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("h")
   public synchronized void vmethod2665(int[] var1, int var2, int var3) {
      if(this.field1120 == 0 && this.field1129 == 0) {
         this.vmethod2651(var3);
      } else {
         class55 var4 = (class55)super.field1147;
         int var5 = this.field1131 << 8;
         int var6 = this.field1127 << 8;
         int var7 = var4.field1022.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1128 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1118 < 0) {
            if(this.field1119 <= 0) {
               this.method1289();
               this.unlink();
               return;
            }

            this.field1118 = 0;
         }

         if(this.field1118 >= var7) {
            if(this.field1119 >= 0) {
               this.method1289();
               this.unlink();
               return;
            }

            this.field1118 = var7 - 1;
         }

         if(this.field1128 < 0) {
            if(this.field1130) {
               if(this.field1119 < 0) {
                  var9 = this.method1286(var1, var2, var5, var3, var4.field1022[this.field1131]);
                  if(this.field1118 >= var5) {
                     return;
                  }

                  this.field1118 = var5 + var5 - 1 - this.field1118;
                  this.field1119 = -this.field1119;
               }

               while(true) {
                  var9 = this.method1183(var1, var9, var6, var3, var4.field1022[this.field1127 - 1]);
                  if(this.field1118 < var6) {
                     return;
                  }

                  this.field1118 = var6 + var6 - 1 - this.field1118;
                  this.field1119 = -this.field1119;
                  var9 = this.method1286(var1, var9, var5, var3, var4.field1022[this.field1131]);
                  if(this.field1118 >= var5) {
                     return;
                  }

                  this.field1118 = var5 + var5 - 1 - this.field1118;
                  this.field1119 = -this.field1119;
               }
            } else if(this.field1119 < 0) {
               while(true) {
                  var9 = this.method1286(var1, var9, var5, var3, var4.field1022[this.field1127 - 1]);
                  if(this.field1118 >= var5) {
                     return;
                  }

                  this.field1118 = var6 - 1 - (var6 - 1 - this.field1118) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1183(var1, var9, var6, var3, var4.field1022[this.field1131]);
                  if(this.field1118 < var6) {
                     return;
                  }

                  this.field1118 = var5 + (this.field1118 - var5) % var8;
               }
            }
         } else {
            if(this.field1128 > 0) {
               if(this.field1130) {
                  label190: {
                     if(this.field1119 < 0) {
                        var9 = this.method1286(var1, var2, var5, var3, var4.field1022[this.field1131]);
                        if(this.field1118 >= var5) {
                           return;
                        }

                        this.field1118 = var5 + var5 - 1 - this.field1118;
                        this.field1119 = -this.field1119;
                        if(--this.field1128 == 0) {
                           break label190;
                        }
                     }

                     do {
                        var9 = this.method1183(var1, var9, var6, var3, var4.field1022[this.field1127 - 1]);
                        if(this.field1118 < var6) {
                           return;
                        }

                        this.field1118 = var6 + var6 - 1 - this.field1118;
                        this.field1119 = -this.field1119;
                        if(--this.field1128 == 0) {
                           break;
                        }

                        var9 = this.method1286(var1, var9, var5, var3, var4.field1022[this.field1131]);
                        if(this.field1118 >= var5) {
                           return;
                        }

                        this.field1118 = var5 + var5 - 1 - this.field1118;
                        this.field1119 = -this.field1119;
                     } while(--this.field1128 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1119 < 0) {
                     while(true) {
                        var9 = this.method1286(var1, var9, var5, var3, var4.field1022[this.field1127 - 1]);
                        if(this.field1118 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1118) / var8;
                        if(var10 >= this.field1128) {
                           this.field1118 += var8 * this.field1128;
                           this.field1128 = 0;
                           break;
                        }

                        this.field1118 += var8 * var10;
                        this.field1128 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1183(var1, var9, var6, var3, var4.field1022[this.field1131]);
                        if(this.field1118 < var6) {
                           return;
                        }

                        var10 = (this.field1118 - var5) / var8;
                        if(var10 >= this.field1128) {
                           this.field1118 -= var8 * this.field1128;
                           this.field1128 = 0;
                           break;
                        }

                        this.field1118 -= var8 * var10;
                        this.field1128 -= var10;
                     }
                  }
               }
            }

            if(this.field1119 < 0) {
               this.method1286(var1, var9, 0, var3, 0);
               if(this.field1118 < 0) {
                  this.field1118 = -1;
                  this.method1289();
                  this.unlink();
               }
            } else {
               this.method1183(var1, var9, var7, var3, 0);
               if(this.field1118 >= var7) {
                  this.field1118 = var7;
                  this.method1289();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("bx")
   static int method1198(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1123 -= var11.field1125 * var5;
      var11.field1124 -= var11.field1132 * var5;
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

      var11.field1123 += var11.field1125 * var5;
      var11.field1124 += var11.field1132 * var5;
      var11.field1122 = var6;
      var11.field1118 = var4;
      return var5;
   }

   @ObfuscatedName("bs")
   static int method1199(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1122 -= var13.field1126 * var5;
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
      var13.field1122 += var13.field1126 * var5;
      var13.field1123 = var6;
      var13.field1124 = var7;
      var13.field1118 = var4;
      return var5;
   }

   @ObfuscatedName("bd")
   static int method1200(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1123 -= var11.field1125 * var5;
      var11.field1124 -= var11.field1132 * var5;
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

      var11.field1123 += var11.field1125 * var5;
      var11.field1124 += var11.field1132 * var5;
      var11.field1122 = var6;
      var11.field1118 = var4;
      return var5;
   }

   @ObfuscatedName("bm")
   static int method1201(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1122 -= var13.field1126 * var5;
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
      var13.field1122 += var13.field1126 * var5;
      var13.field1123 = var6;
      var13.field1124 = var7;
      var13.field1118 = var4;
      return var5;
   }

   @ObfuscatedName("i")
   static int method1205(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ba")
   static int method1243(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1123 += var9.field1125 * (var6 - var3);
      var9.field1124 += var9.field1132 * (var6 - var3);

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

      var9.field1122 = var4 >> 2;
      var9.field1118 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("at")
   boolean method1245() {
      int var1 = this.field1120;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1205(var1, this.field1121);
         var3 = method1271(var1, this.field1121);
      }

      if(this.field1122 == var1 && this.field1123 == var2 && this.field1124 == var3) {
         if(this.field1120 == Integer.MIN_VALUE) {
            this.field1120 = 0;
            this.field1124 = 0;
            this.field1123 = 0;
            this.field1122 = 0;
            this.unlink();
            return true;
         } else {
            this.method1161();
            return false;
         }
      } else {
         if(this.field1122 < var1) {
            this.field1126 = 1;
            this.field1129 = var1 - this.field1122;
         } else if(this.field1122 > var1) {
            this.field1126 = -1;
            this.field1129 = this.field1122 - var1;
         } else {
            this.field1126 = 0;
         }

         if(this.field1123 < var2) {
            this.field1125 = 1;
            if(this.field1129 == 0 || this.field1129 > var2 - this.field1123) {
               this.field1129 = var2 - this.field1123;
            }
         } else if(this.field1123 > var2) {
            this.field1125 = -1;
            if(this.field1129 == 0 || this.field1129 > this.field1123 - var2) {
               this.field1129 = this.field1123 - var2;
            }
         } else {
            this.field1125 = 0;
         }

         if(this.field1124 < var3) {
            this.field1132 = 1;
            if(this.field1129 == 0 || this.field1129 > var3 - this.field1124) {
               this.field1129 = var3 - this.field1124;
            }
         } else if(this.field1124 > var3) {
            this.field1132 = -1;
            if(this.field1129 == 0 || this.field1129 > this.field1124 - var3) {
               this.field1129 = this.field1124 - var3;
            }
         } else {
            this.field1132 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ao")
   static int method1248(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1118 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("e")
   static int method1271(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("be")
   static int method1272(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1122 += var12.field1126 * (var9 - var4);
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

      var12.field1123 = var5 >> 2;
      var12.field1124 = var6 >> 2;
      var12.field1118 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ab")
   public boolean method1276() {
      return this.field1129 != 0;
   }

   @ObfuscatedName("ac")
   static int method1277(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1118 = var3 << 8;
      return var4 >> 1;
   }

   class66(class55 var1, int var2, int var3, int var4) {
      super.field1147 = var1;
      this.field1131 = var1.field1023;
      this.field1127 = var1.field1025;
      this.field1130 = var1.field1024;
      this.field1119 = var2;
      this.field1120 = var3;
      this.field1121 = var4;
      this.field1118 = 0;
      this.method1161();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1282() {
      this.field1119 = (this.field1119 ^ this.field1119 >> 31) + (this.field1119 >>> 31);
      this.field1119 = -this.field1119;
   }

   @ObfuscatedName("ar")
   int method1286(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1129 > 0) {
            int var6 = var2 + this.field1129;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1129 += var2;
            if(this.field1119 == -256 && (this.field1118 & 255) == 0) {
               if(class57.field1062) {
                  var2 = method1272(0, ((class55)super.field1147).field1022, var1, this.field1118, var2, this.field1123, this.field1124, this.field1125, this.field1132, 0, var6, var3, this);
               } else {
                  var2 = method1243(((class55)super.field1147).field1022, var1, this.field1118, var2, this.field1122, this.field1126, 0, var6, var3, this);
               }
            } else if(class57.field1062) {
               var2 = method1201(0, 0, ((class55)super.field1147).field1022, var1, this.field1118, var2, this.field1123, this.field1124, this.field1125, this.field1132, 0, var6, var3, this, this.field1119, var5);
            } else {
               var2 = method1200(0, 0, ((class55)super.field1147).field1022, var1, this.field1118, var2, this.field1122, this.field1126, 0, var6, var3, this, this.field1119, var5);
            }

            this.field1129 -= var2;
            if(this.field1129 != 0) {
               return var2;
            }

            if(!this.method1245()) {
               continue;
            }

            return var4;
         }

         if(this.field1119 == -256 && (this.field1118 & 255) == 0) {
            if(class57.field1062) {
               return method1277(0, ((class55)super.field1147).field1022, var1, this.field1118, var2, this.field1123, this.field1124, 0, var4, var3, this);
            }

            return method1188(((class55)super.field1147).field1022, var1, this.field1118, var2, this.field1122, 0, var4, var3, this);
         }

         if(class57.field1062) {
            return method1187(0, 0, ((class55)super.field1147).field1022, var1, this.field1118, var2, this.field1123, this.field1124, 0, var4, var3, this, this.field1119, var5);
         }

         return method1192(0, 0, ((class55)super.field1147).field1022, var1, this.field1118, var2, this.field1122, 0, var4, var3, this, this.field1119, var5);
      }
   }

   @ObfuscatedName("y")
   void method1289() {
      if(this.field1129 != 0) {
         if(this.field1120 == Integer.MIN_VALUE) {
            this.field1120 = 0;
         }

         this.field1129 = 0;
         this.method1161();
      }

   }
}
