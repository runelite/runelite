import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class66 extends class68 {
   @ObfuscatedName("f")
   int field1116;
   @ObfuscatedName("m")
   int field1117;
   @ObfuscatedName("b")
   int field1118;
   @ObfuscatedName("g")
   int field1119;
   @ObfuscatedName("h")
   int field1120;
   @ObfuscatedName("v")
   int field1121;
   @ObfuscatedName("l")
   int field1122;
   @ObfuscatedName("p")
   int field1123;
   @ObfuscatedName("u")
   int field1124;
   @ObfuscatedName("c")
   int field1125;
   @ObfuscatedName("k")
   int field1126;
   @ObfuscatedName("y")
   int field1127;
   @ObfuscatedName("j")
   int field1128;
   @ObfuscatedName("z")
   boolean field1129;
   @ObfuscatedName("o")
   int field1130;

   @ObfuscatedName("ab")
   int vmethod1329() {
      int var1 = this.field1120 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1125 == 0) {
         var1 -= var1 * this.field1130 / (((class55)super.field1143).field1022.length << 8);
      } else if(this.field1125 >= 0) {
         var1 -= var1 * this.field1124 / ((class55)super.field1143).field1022.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1167() {
      this.field1117 = (this.field1117 ^ this.field1117 >> 31) + (this.field1117 >>> 31);
      this.field1117 = -this.field1117;
   }

   @ObfuscatedName("o")
   static int method1168(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("c")
   protected class68 vmethod2625() {
      return null;
   }

   @ObfuscatedName("l")
   void method1170() {
      this.field1120 = this.field1118;
      this.field1121 = method1168(this.field1118, this.field1119);
      this.field1122 = method1191(this.field1118, this.field1119);
   }

   @ObfuscatedName("bd")
   static int method1171(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1120 -= var13.field1128 * var5;
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
      var13.field1120 += var13.field1128 * var5;
      var13.field1121 = var6;
      var13.field1122 = var7;
      var13.field1130 = var4;
      return var5;
   }

   @ObfuscatedName("f")
   public synchronized void method1172(int var1) {
      this.method1174(var1 << 6, this.method1176());
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1173(int var1) {
      this.method1174(var1, this.method1176());
   }

   @ObfuscatedName("i")
   synchronized void method1174(int var1, int var2) {
      this.field1118 = var1;
      this.field1119 = var2;
      this.field1127 = 0;
      this.method1170();
   }

   @ObfuscatedName("s")
   public synchronized int method1175() {
      return this.field1118 == Integer.MIN_VALUE?0:this.field1118;
   }

   @ObfuscatedName("x")
   public synchronized int method1176() {
      return this.field1119 < 0?-1:this.field1119;
   }

   @ObfuscatedName("d")
   public synchronized void method1177(int var1) {
      int var2 = ((class55)super.field1143).field1022.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1130 = var1;
   }

   @ObfuscatedName("t")
   public synchronized void method1181(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1174(var2, var3);
      } else {
         int var4 = method1168(var2, var3);
         int var5 = method1191(var2, var3);
         if(this.field1121 == var4 && this.field1122 == var5) {
            this.field1127 = 0;
         } else {
            int var6 = var2 - this.field1120;
            if(this.field1120 - var2 > var6) {
               var6 = this.field1120 - var2;
            }

            if(var4 - this.field1121 > var6) {
               var6 = var4 - this.field1121;
            }

            if(this.field1121 - var4 > var6) {
               var6 = this.field1121 - var4;
            }

            if(var5 - this.field1122 > var6) {
               var6 = var5 - this.field1122;
            }

            if(this.field1122 - var5 > var6) {
               var6 = this.field1122 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1127 = var1;
            this.field1118 = var2;
            this.field1119 = var3;
            this.field1128 = (var2 - this.field1120) / var1;
            this.field1116 = (var4 - this.field1121) / var1;
            this.field1123 = (var5 - this.field1122) / var1;
         }
      }
   }

   @ObfuscatedName("r")
   public synchronized void method1182(int var1) {
      if(var1 == 0) {
         this.method1173(0);
         this.unlink();
      } else if(this.field1121 == 0 && this.field1122 == 0) {
         this.field1127 = 0;
         this.field1118 = 0;
         this.field1120 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1120;
         if(this.field1120 > var2) {
            var2 = this.field1120;
         }

         if(-this.field1121 > var2) {
            var2 = -this.field1121;
         }

         if(this.field1121 > var2) {
            var2 = this.field1121;
         }

         if(-this.field1122 > var2) {
            var2 = -this.field1122;
         }

         if(this.field1122 > var2) {
            var2 = this.field1122;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1127 = var1;
         this.field1118 = Integer.MIN_VALUE;
         this.field1128 = -this.field1120 / var1;
         this.field1116 = -this.field1121 / var1;
         this.field1123 = -this.field1122 / var1;
      }
   }

   @ObfuscatedName("av")
   public synchronized int method1183() {
      return this.field1117 < 0?-this.field1117:this.field1117;
   }

   @ObfuscatedName("br")
   static int method1184(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1121 -= var11.field1116 * var5;
      var11.field1122 -= var11.field1123 * var5;
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

      var11.field1121 += var11.field1116 * var5;
      var11.field1122 += var11.field1123 * var5;
      var11.field1120 = var6;
      var11.field1130 = var4;
      return var5;
   }

   @ObfuscatedName("ak")
   public boolean method1185() {
      return this.field1130 < 0 || this.field1130 >= ((class55)super.field1143).field1022.length << 8;
   }

   @ObfuscatedName("ay")
   public boolean method1186() {
      return this.field1127 != 0;
   }

   @ObfuscatedName("bm")
   static int method1187(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1121 -= var11.field1116 * var5;
      var11.field1122 -= var11.field1123 * var5;
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

      var11.field1121 += var11.field1116 * var5;
      var11.field1122 += var11.field1123 * var5;
      var11.field1120 = var6;
      var11.field1130 = var4;
      return var5;
   }

   @ObfuscatedName("k")
   protected int vmethod2624() {
      return this.field1118 == 0 && this.field1127 == 0?0:1;
   }

   @ObfuscatedName("m")
   static int method1191(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("an")
   int method1192(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1127 > 0) {
            int var6 = var2 + this.field1127;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1127 += var2;
            if(this.field1117 == 256 && (this.field1130 & 255) == 0) {
               if(class57.field1044) {
                  var2 = method1204(0, ((class55)super.field1143).field1022, var1, this.field1130, var2, this.field1121, this.field1122, this.field1116, this.field1123, 0, var6, var3, this);
               } else {
                  var2 = method1203(((class55)super.field1143).field1022, var1, this.field1130, var2, this.field1120, this.field1128, 0, var6, var3, this);
               }
            } else if(class57.field1044) {
               var2 = method1171(0, 0, ((class55)super.field1143).field1022, var1, this.field1130, var2, this.field1121, this.field1122, this.field1116, this.field1123, 0, var6, var3, this, this.field1117, var5);
            } else {
               var2 = method1187(0, 0, ((class55)super.field1143).field1022, var1, this.field1130, var2, this.field1120, this.field1128, 0, var6, var3, this, this.field1117, var5);
            }

            this.field1127 -= var2;
            if(this.field1127 != 0) {
               return var2;
            }

            if(!this.method1194()) {
               continue;
            }

            return var4;
         }

         if(this.field1117 == 256 && (this.field1130 & 255) == 0) {
            if(class57.field1044) {
               return method1196(0, ((class55)super.field1143).field1022, var1, this.field1130, var2, this.field1121, this.field1122, 0, var4, var3, this);
            }

            return method1195(((class55)super.field1143).field1022, var1, this.field1130, var2, this.field1120, 0, var4, var3, this);
         }

         if(class57.field1044) {
            return method1200(0, 0, ((class55)super.field1143).field1022, var1, this.field1130, var2, this.field1121, this.field1122, 0, var4, var3, this, this.field1117, var5);
         }

         return method1199(0, 0, ((class55)super.field1143).field1022, var1, this.field1130, var2, this.field1120, 0, var4, var3, this, this.field1117, var5);
      }
   }

   @ObfuscatedName("aw")
   int method1193(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1127 > 0) {
            int var6 = var2 + this.field1127;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1127 += var2;
            if(this.field1117 == -256 && (this.field1130 & 255) == 0) {
               if(class57.field1044) {
                  var2 = method1265(0, ((class55)super.field1143).field1022, var1, this.field1130, var2, this.field1121, this.field1122, this.field1116, this.field1123, 0, var6, var3, this);
               } else {
                  var2 = method1205(((class55)super.field1143).field1022, var1, this.field1130, var2, this.field1120, this.field1128, 0, var6, var3, this);
               }
            } else if(class57.field1044) {
               var2 = method1290(0, 0, ((class55)super.field1143).field1022, var1, this.field1130, var2, this.field1121, this.field1122, this.field1116, this.field1123, 0, var6, var3, this, this.field1117, var5);
            } else {
               var2 = method1184(0, 0, ((class55)super.field1143).field1022, var1, this.field1130, var2, this.field1120, this.field1128, 0, var6, var3, this, this.field1117, var5);
            }

            this.field1127 -= var2;
            if(this.field1127 != 0) {
               return var2;
            }

            if(!this.method1194()) {
               continue;
            }

            return var4;
         }

         if(this.field1117 == -256 && (this.field1130 & 255) == 0) {
            if(class57.field1044) {
               return method1198(0, ((class55)super.field1143).field1022, var1, this.field1130, var2, this.field1121, this.field1122, 0, var4, var3, this);
            }

            return method1197(((class55)super.field1143).field1022, var1, this.field1130, var2, this.field1120, 0, var4, var3, this);
         }

         if(class57.field1044) {
            return method1300(0, 0, ((class55)super.field1143).field1022, var1, this.field1130, var2, this.field1121, this.field1122, 0, var4, var3, this, this.field1117, var5);
         }

         return method1201(0, 0, ((class55)super.field1143).field1022, var1, this.field1130, var2, this.field1120, 0, var4, var3, this, this.field1117, var5);
      }
   }

   @ObfuscatedName("af")
   boolean method1194() {
      int var1 = this.field1118;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1168(var1, this.field1119);
         var3 = method1191(var1, this.field1119);
      }

      if(this.field1120 == var1 && this.field1121 == var2 && this.field1122 == var3) {
         if(this.field1118 == Integer.MIN_VALUE) {
            this.field1118 = 0;
            this.field1122 = 0;
            this.field1121 = 0;
            this.field1120 = 0;
            this.unlink();
            return true;
         } else {
            this.method1170();
            return false;
         }
      } else {
         if(this.field1120 < var1) {
            this.field1128 = 1;
            this.field1127 = var1 - this.field1120;
         } else if(this.field1120 > var1) {
            this.field1128 = -1;
            this.field1127 = this.field1120 - var1;
         } else {
            this.field1128 = 0;
         }

         if(this.field1121 < var2) {
            this.field1116 = 1;
            if(this.field1127 == 0 || this.field1127 > var2 - this.field1121) {
               this.field1127 = var2 - this.field1121;
            }
         } else if(this.field1121 > var2) {
            this.field1116 = -1;
            if(this.field1127 == 0 || this.field1127 > this.field1121 - var2) {
               this.field1127 = this.field1121 - var2;
            }
         } else {
            this.field1116 = 0;
         }

         if(this.field1122 < var3) {
            this.field1123 = 1;
            if(this.field1127 == 0 || this.field1127 > var3 - this.field1122) {
               this.field1127 = var3 - this.field1122;
            }
         } else if(this.field1122 > var3) {
            this.field1123 = -1;
            if(this.field1127 == 0 || this.field1127 > this.field1122 - var3) {
               this.field1127 = this.field1122 - var3;
            }
         } else {
            this.field1123 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ac")
   static int method1195(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1130 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ar")
   static int method1196(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1130 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("at")
   static int method1197(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1130 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("al")
   static int method1198(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1130 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ax")
   static int method1199(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1130 = var4;
      return var5;
   }

   @ObfuscatedName("az")
   static int method1200(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1130 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ai")
   static int method1201(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1130 = var4;
      return var5;
   }

   @ObfuscatedName("aj")
   static int method1203(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1121 += var9.field1116 * (var6 - var3);
      var9.field1122 += var9.field1123 * (var6 - var3);

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

      var9.field1120 = var4 >> 2;
      var9.field1130 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("aq")
   static int method1204(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1120 += var12.field1128 * (var9 - var4);
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

      var12.field1121 = var5 >> 2;
      var12.field1122 = var6 >> 2;
      var12.field1130 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("as")
   static int method1205(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1121 += var9.field1116 * (var6 - var3);
      var9.field1122 += var9.field1123 * (var6 - var3);

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

      var9.field1120 = var4 >> 2;
      var9.field1130 = var2 << 8;
      return var3;
   }

   class66(class55 var1, int var2, int var3, int var4) {
      super.field1143 = var1;
      this.field1124 = var1.field1025;
      this.field1126 = var1.field1024;
      this.field1129 = var1.field1023;
      this.field1117 = var2;
      this.field1118 = var3;
      this.field1119 = var4;
      this.field1130 = 0;
      this.method1170();
   }

   @ObfuscatedName("z")
   public synchronized void vmethod2628(int[] var1, int var2, int var3) {
      if(this.field1118 == 0 && this.field1127 == 0) {
         this.vmethod2629(var3);
      } else {
         class55 var4 = (class55)super.field1143;
         int var5 = this.field1124 << 8;
         int var6 = this.field1126 << 8;
         int var7 = var4.field1022.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1125 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1130 < 0) {
            if(this.field1117 <= 0) {
               this.method1281();
               this.unlink();
               return;
            }

            this.field1130 = 0;
         }

         if(this.field1130 >= var7) {
            if(this.field1117 >= 0) {
               this.method1281();
               this.unlink();
               return;
            }

            this.field1130 = var7 - 1;
         }

         if(this.field1125 < 0) {
            if(this.field1129) {
               if(this.field1117 < 0) {
                  var9 = this.method1193(var1, var2, var5, var3, var4.field1022[this.field1124]);
                  if(this.field1130 >= var5) {
                     return;
                  }

                  this.field1130 = var5 + var5 - 1 - this.field1130;
                  this.field1117 = -this.field1117;
               }

               while(true) {
                  var9 = this.method1192(var1, var9, var6, var3, var4.field1022[this.field1126 - 1]);
                  if(this.field1130 < var6) {
                     return;
                  }

                  this.field1130 = var6 + var6 - 1 - this.field1130;
                  this.field1117 = -this.field1117;
                  var9 = this.method1193(var1, var9, var5, var3, var4.field1022[this.field1124]);
                  if(this.field1130 >= var5) {
                     return;
                  }

                  this.field1130 = var5 + var5 - 1 - this.field1130;
                  this.field1117 = -this.field1117;
               }
            } else if(this.field1117 < 0) {
               while(true) {
                  var9 = this.method1193(var1, var9, var5, var3, var4.field1022[this.field1126 - 1]);
                  if(this.field1130 >= var5) {
                     return;
                  }

                  this.field1130 = var6 - 1 - (var6 - 1 - this.field1130) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1192(var1, var9, var6, var3, var4.field1022[this.field1124]);
                  if(this.field1130 < var6) {
                     return;
                  }

                  this.field1130 = var5 + (this.field1130 - var5) % var8;
               }
            }
         } else {
            if(this.field1125 > 0) {
               if(this.field1129) {
                  label173: {
                     if(this.field1117 < 0) {
                        var9 = this.method1193(var1, var2, var5, var3, var4.field1022[this.field1124]);
                        if(this.field1130 >= var5) {
                           return;
                        }

                        this.field1130 = var5 + var5 - 1 - this.field1130;
                        this.field1117 = -this.field1117;
                        if(--this.field1125 == 0) {
                           break label173;
                        }
                     }

                     do {
                        var9 = this.method1192(var1, var9, var6, var3, var4.field1022[this.field1126 - 1]);
                        if(this.field1130 < var6) {
                           return;
                        }

                        this.field1130 = var6 + var6 - 1 - this.field1130;
                        this.field1117 = -this.field1117;
                        if(--this.field1125 == 0) {
                           break;
                        }

                        var9 = this.method1193(var1, var9, var5, var3, var4.field1022[this.field1124]);
                        if(this.field1130 >= var5) {
                           return;
                        }

                        this.field1130 = var5 + var5 - 1 - this.field1130;
                        this.field1117 = -this.field1117;
                     } while(--this.field1125 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1117 < 0) {
                     while(true) {
                        var9 = this.method1193(var1, var9, var5, var3, var4.field1022[this.field1126 - 1]);
                        if(this.field1130 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1130) / var8;
                        if(var10 >= this.field1125) {
                           this.field1130 += var8 * this.field1125;
                           this.field1125 = 0;
                           break;
                        }

                        this.field1130 += var8 * var10;
                        this.field1125 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1192(var1, var9, var6, var3, var4.field1022[this.field1124]);
                        if(this.field1130 < var6) {
                           return;
                        }

                        var10 = (this.field1130 - var5) / var8;
                        if(var10 >= this.field1125) {
                           this.field1130 -= var8 * this.field1125;
                           this.field1125 = 0;
                           break;
                        }

                        this.field1130 -= var8 * var10;
                        this.field1125 -= var10;
                     }
                  }
               }
            }

            if(this.field1117 < 0) {
               this.method1193(var1, var9, 0, var3, 0);
               if(this.field1130 < 0) {
                  this.field1130 = -1;
                  this.method1281();
                  this.unlink();
               }
            } else {
               this.method1192(var1, var9, var7, var3, 0);
               if(this.field1130 >= var7) {
                  this.field1130 = var7;
                  this.method1281();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("u")
   protected class68 vmethod2626() {
      return null;
   }

   @ObfuscatedName("a")
   public synchronized void method1222(int var1) {
      if(this.field1117 < 0) {
         this.field1117 = -var1;
      } else {
         this.field1117 = var1;
      }

   }

   @ObfuscatedName("b")
   public static class66 method1251(class55 var0, int var1, int var2) {
      return var0.field1022 != null && var0.field1022.length != 0?new class66(var0, (int)((long)var0.field1021 * 256L * (long)var1 / (long)(class57.field1042 * 100)), var2 << 6):null;
   }

   class66(class55 var1, int var2, int var3) {
      super.field1143 = var1;
      this.field1124 = var1.field1025;
      this.field1126 = var1.field1024;
      this.field1129 = var1.field1023;
      this.field1117 = var2;
      this.field1118 = var3;
      this.field1119 = 8192;
      this.field1130 = 0;
      this.method1170();
   }

   @ObfuscatedName("ad")
   static int method1265(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1120 += var12.field1128 * (var9 - var4);
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

      var12.field1121 = var5 >> 2;
      var12.field1122 = var6 >> 2;
      var12.field1130 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("y")
   public synchronized void method1268(int var1) {
      this.field1125 = var1;
   }

   @ObfuscatedName("j")
   public synchronized void vmethod2629(int var1) {
      if(this.field1127 > 0) {
         if(var1 >= this.field1127) {
            if(this.field1118 == Integer.MIN_VALUE) {
               this.field1118 = 0;
               this.field1122 = 0;
               this.field1121 = 0;
               this.field1120 = 0;
               this.unlink();
               var1 = this.field1127;
            }

            this.field1127 = 0;
            this.method1170();
         } else {
            this.field1120 += this.field1128 * var1;
            this.field1121 += this.field1116 * var1;
            this.field1122 += this.field1123 * var1;
            this.field1127 -= var1;
         }
      }

      class55 var2 = (class55)super.field1143;
      int var3 = this.field1124 << 8;
      int var4 = this.field1126 << 8;
      int var5 = var2.field1022.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1125 = 0;
      }

      if(this.field1130 < 0) {
         if(this.field1117 <= 0) {
            this.method1281();
            this.unlink();
            return;
         }

         this.field1130 = 0;
      }

      if(this.field1130 >= var5) {
         if(this.field1117 >= 0) {
            this.method1281();
            this.unlink();
            return;
         }

         this.field1130 = var5 - 1;
      }

      this.field1130 += this.field1117 * var1;
      if(this.field1125 < 0) {
         if(!this.field1129) {
            if(this.field1117 < 0) {
               if(this.field1130 >= var3) {
                  return;
               }

               this.field1130 = var4 - 1 - (var4 - 1 - this.field1130) % var6;
            } else {
               if(this.field1130 < var4) {
                  return;
               }

               this.field1130 = var3 + (this.field1130 - var3) % var6;
            }

         } else {
            if(this.field1117 < 0) {
               if(this.field1130 >= var3) {
                  return;
               }

               this.field1130 = var3 + var3 - 1 - this.field1130;
               this.field1117 = -this.field1117;
            }

            while(this.field1130 >= var4) {
               this.field1130 = var4 + var4 - 1 - this.field1130;
               this.field1117 = -this.field1117;
               if(this.field1130 >= var3) {
                  return;
               }

               this.field1130 = var3 + var3 - 1 - this.field1130;
               this.field1117 = -this.field1117;
            }

         }
      } else {
         if(this.field1125 > 0) {
            if(this.field1129) {
               label171: {
                  if(this.field1117 < 0) {
                     if(this.field1130 >= var3) {
                        return;
                     }

                     this.field1130 = var3 + var3 - 1 - this.field1130;
                     this.field1117 = -this.field1117;
                     if(--this.field1125 == 0) {
                        break label171;
                     }
                  }

                  do {
                     if(this.field1130 < var4) {
                        return;
                     }

                     this.field1130 = var4 + var4 - 1 - this.field1130;
                     this.field1117 = -this.field1117;
                     if(--this.field1125 == 0) {
                        break;
                     }

                     if(this.field1130 >= var3) {
                        return;
                     }

                     this.field1130 = var3 + var3 - 1 - this.field1130;
                     this.field1117 = -this.field1117;
                  } while(--this.field1125 != 0);
               }
            } else {
               int var7;
               if(this.field1117 < 0) {
                  if(this.field1130 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1130) / var6;
                  if(var7 < this.field1125) {
                     this.field1130 += var6 * var7;
                     this.field1125 -= var7;
                     return;
                  }

                  this.field1130 += var6 * this.field1125;
                  this.field1125 = 0;
               } else {
                  if(this.field1130 < var4) {
                     return;
                  }

                  var7 = (this.field1130 - var3) / var6;
                  if(var7 < this.field1125) {
                     this.field1130 -= var6 * var7;
                     this.field1125 -= var7;
                     return;
                  }

                  this.field1130 -= var6 * this.field1125;
                  this.field1125 = 0;
               }
            }
         }

         if(this.field1117 < 0) {
            if(this.field1130 < 0) {
               this.field1130 = -1;
               this.method1281();
               this.unlink();
            }
         } else if(this.field1130 >= var5) {
            this.field1130 = var5;
            this.method1281();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("n")
   void method1281() {
      if(this.field1127 != 0) {
         if(this.field1118 == Integer.MIN_VALUE) {
            this.field1118 = 0;
         }

         this.field1127 = 0;
         this.method1170();
      }

   }

   @ObfuscatedName("bh")
   static int method1290(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1120 -= var13.field1128 * var5;
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
      var13.field1120 += var13.field1128 * var5;
      var13.field1121 = var6;
      var13.field1122 = var7;
      var13.field1130 = var4;
      return var5;
   }

   @ObfuscatedName("g")
   public static class66 method1294(class55 var0, int var1, int var2, int var3) {
      return var0.field1022 != null && var0.field1022.length != 0?new class66(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("ap")
   static int method1300(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1130 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("q")
   public synchronized void method1303(int var1, int var2) {
      this.method1181(var1, var2, this.method1176());
   }
}
