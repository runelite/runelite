import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public class class66 extends class68 {
   @ObfuscatedName("m")
   int field1137;
   @ObfuscatedName("i")
   int field1138;
   @ObfuscatedName("u")
   int field1139;
   @ObfuscatedName("h")
   int field1140;
   @ObfuscatedName("f")
   int field1141;
   @ObfuscatedName("l")
   int field1142;
   @ObfuscatedName("o")
   int field1143;
   @ObfuscatedName("n")
   int field1144;
   @ObfuscatedName("s")
   boolean field1145;
   @ObfuscatedName("j")
   int field1146;
   @ObfuscatedName("r")
   int field1147;
   @ObfuscatedName("q")
   int field1148;
   @ObfuscatedName("d")
   int field1149;
   @ObfuscatedName("p")
   int field1150;
   @ObfuscatedName("y")
   int field1151;

   @ObfuscatedName("q")
   public synchronized void method1206(int var1) {
      this.method1233(var1 << 6, this.method1219());
   }

   @ObfuscatedName("i")
   static int method1207(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("as")
   int vmethod1397() {
      int var1 = this.field1147 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1144 == 0) {
         var1 -= var1 * this.field1141 / (((class55)super.field1164).field1044.length << 8);
      } else if(this.field1144 >= 0) {
         var1 -= var1 * this.field1137 / ((class55)super.field1164).field1044.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("u")
   public static class66 method1211(class55 var0, int var1, int var2) {
      return var0.field1044 != null && var0.field1044.length != 0?new class66(var0, (int)((long)var0.field1047 * 256L * (long)var1 / (long)(class57.field1077 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("aa")
   static int method1212(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1141 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("m")
   protected int vmethod2766() {
      return this.field1139 == 0 && this.field1148 == 0?0:1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1216(int var1) {
      this.method1233(var1, this.method1219());
   }

   @ObfuscatedName("j")
   public synchronized void method1217(int var1) {
      this.field1144 = var1;
   }

   @ObfuscatedName("a")
   public synchronized int method1219() {
      return this.field1140 < 0?-1:this.field1140;
   }

   @ObfuscatedName("v")
   public synchronized void method1220(int var1) {
      int var2 = ((class55)super.field1164).field1044.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1141 = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1221() {
      this.field1138 = (this.field1138 ^ this.field1138 >> 31) + (this.field1138 >>> 31);
      this.field1138 = -this.field1138;
   }

   @ObfuscatedName("x")
   void method1222() {
      if(this.field1148 != 0) {
         if(this.field1139 == Integer.MIN_VALUE) {
            this.field1139 = 0;
         }

         this.field1148 = 0;
         this.method1253();
      }

   }

   @ObfuscatedName("g")
   public synchronized void method1223(int var1, int var2) {
      this.method1224(var1, var2, this.method1219());
   }

   @ObfuscatedName("b")
   public synchronized void method1224(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1233(var2, var3);
      } else {
         int var4 = method1315(var2, var3);
         int var5 = method1207(var2, var3);
         if(this.field1143 == var4 && this.field1142 == var5) {
            this.field1148 = 0;
         } else {
            int var6 = var2 - this.field1147;
            if(this.field1147 - var2 > var6) {
               var6 = this.field1147 - var2;
            }

            if(var4 - this.field1143 > var6) {
               var6 = var4 - this.field1143;
            }

            if(this.field1143 - var4 > var6) {
               var6 = this.field1143 - var4;
            }

            if(var5 - this.field1142 > var6) {
               var6 = var5 - this.field1142;
            }

            if(this.field1142 - var5 > var6) {
               var6 = this.field1142 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1148 = var1;
            this.field1139 = var2;
            this.field1140 = var3;
            this.field1149 = (var2 - this.field1147) / var1;
            this.field1150 = (var4 - this.field1143) / var1;
            this.field1151 = (var5 - this.field1142) / var1;
         }
      }
   }

   class66(class55 var1, int var2, int var3, int var4) {
      super.field1164 = var1;
      this.field1137 = var1.field1045;
      this.field1146 = var1.field1046;
      this.field1145 = var1.field1048;
      this.field1138 = var2;
      this.field1139 = var3;
      this.field1140 = var4;
      this.field1141 = 0;
      this.method1253();
   }

   @ObfuscatedName("c")
   public synchronized int method1226() {
      return this.field1138 < 0?-this.field1138:this.field1138;
   }

   @ObfuscatedName("au")
   public boolean method1227() {
      return this.field1148 != 0;
   }

   @ObfuscatedName("n")
   protected class68 vmethod2753() {
      return null;
   }

   @ObfuscatedName("bj")
   static int method1231(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1147 += var12.field1149 * (var9 - var4);
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

      var12.field1143 = var5 >> 2;
      var12.field1142 = var6 >> 2;
      var12.field1141 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("p")
   synchronized void method1233(int var1, int var2) {
      this.field1139 = var1;
      this.field1140 = var2;
      this.field1148 = 0;
      this.method1253();
   }

   @ObfuscatedName("ad")
   int method1234(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1148 > 0) {
            int var6 = var2 + this.field1148;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1148 += var2;
            if(this.field1138 == 256 && (this.field1141 & 255) == 0) {
               if(class57.field1078) {
                  var2 = method1231(0, ((class55)super.field1164).field1044, var1, this.field1141, var2, this.field1143, this.field1142, this.field1150, this.field1151, 0, var6, var3, this);
               } else {
                  var2 = method1245(((class55)super.field1164).field1044, var1, this.field1141, var2, this.field1147, this.field1149, 0, var6, var3, this);
               }
            } else if(class57.field1078) {
               var2 = method1250(0, 0, ((class55)super.field1164).field1044, var1, this.field1141, var2, this.field1143, this.field1142, this.field1150, this.field1151, 0, var6, var3, this, this.field1138, var5);
            } else {
               var2 = method1249(0, 0, ((class55)super.field1164).field1044, var1, this.field1141, var2, this.field1147, this.field1149, 0, var6, var3, this, this.field1138, var5);
            }

            this.field1148 -= var2;
            if(this.field1148 != 0) {
               return var2;
            }

            if(!this.method1236()) {
               continue;
            }

            return var4;
         }

         if(this.field1138 == 256 && (this.field1141 & 255) == 0) {
            if(class57.field1078) {
               return method1212(0, ((class55)super.field1164).field1044, var1, this.field1141, var2, this.field1143, this.field1142, 0, var4, var3, this);
            }

            return method1237(((class55)super.field1164).field1044, var1, this.field1141, var2, this.field1147, 0, var4, var3, this);
         }

         if(class57.field1078) {
            return method1318(0, 0, ((class55)super.field1164).field1044, var1, this.field1141, var2, this.field1143, this.field1142, 0, var4, var3, this, this.field1138, var5);
         }

         return method1241(0, 0, ((class55)super.field1164).field1044, var1, this.field1141, var2, this.field1147, 0, var4, var3, this, this.field1138, var5);
      }
   }

   @ObfuscatedName("av")
   int method1235(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1148 > 0) {
            int var6 = var2 + this.field1148;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1148 += var2;
            if(this.field1138 == -256 && (this.field1141 & 255) == 0) {
               if(class57.field1078) {
                  var2 = method1324(0, ((class55)super.field1164).field1044, var1, this.field1141, var2, this.field1143, this.field1142, this.field1150, this.field1151, 0, var6, var3, this);
               } else {
                  var2 = method1247(((class55)super.field1164).field1044, var1, this.field1141, var2, this.field1147, this.field1149, 0, var6, var3, this);
               }
            } else if(class57.field1078) {
               var2 = method1252(0, 0, ((class55)super.field1164).field1044, var1, this.field1141, var2, this.field1143, this.field1142, this.field1150, this.field1151, 0, var6, var3, this, this.field1138, var5);
            } else {
               var2 = method1251(0, 0, ((class55)super.field1164).field1044, var1, this.field1141, var2, this.field1147, this.field1149, 0, var6, var3, this, this.field1138, var5);
            }

            this.field1148 -= var2;
            if(this.field1148 != 0) {
               return var2;
            }

            if(!this.method1236()) {
               continue;
            }

            return var4;
         }

         if(this.field1138 == -256 && (this.field1141 & 255) == 0) {
            if(class57.field1078) {
               return method1240(0, ((class55)super.field1164).field1044, var1, this.field1141, var2, this.field1143, this.field1142, 0, var4, var3, this);
            }

            return method1239(((class55)super.field1164).field1044, var1, this.field1141, var2, this.field1147, 0, var4, var3, this);
         }

         if(class57.field1078) {
            return method1295(0, 0, ((class55)super.field1164).field1044, var1, this.field1141, var2, this.field1143, this.field1142, 0, var4, var3, this, this.field1138, var5);
         }

         return method1243(0, 0, ((class55)super.field1164).field1044, var1, this.field1141, var2, this.field1147, 0, var4, var3, this, this.field1138, var5);
      }
   }

   @ObfuscatedName("ao")
   boolean method1236() {
      int var1 = this.field1139;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1315(var1, this.field1140);
         var3 = method1207(var1, this.field1140);
      }

      if(this.field1147 == var1 && this.field1143 == var2 && this.field1142 == var3) {
         if(this.field1139 == Integer.MIN_VALUE) {
            this.field1139 = 0;
            this.field1142 = 0;
            this.field1143 = 0;
            this.field1147 = 0;
            this.unlink();
            return true;
         } else {
            this.method1253();
            return false;
         }
      } else {
         if(this.field1147 < var1) {
            this.field1149 = 1;
            this.field1148 = var1 - this.field1147;
         } else if(this.field1147 > var1) {
            this.field1149 = -1;
            this.field1148 = this.field1147 - var1;
         } else {
            this.field1149 = 0;
         }

         if(this.field1143 < var2) {
            this.field1150 = 1;
            if(this.field1148 == 0 || this.field1148 > var2 - this.field1143) {
               this.field1148 = var2 - this.field1143;
            }
         } else if(this.field1143 > var2) {
            this.field1150 = -1;
            if(this.field1148 == 0 || this.field1148 > this.field1143 - var2) {
               this.field1148 = this.field1143 - var2;
            }
         } else {
            this.field1150 = 0;
         }

         if(this.field1142 < var3) {
            this.field1151 = 1;
            if(this.field1148 == 0 || this.field1148 > var3 - this.field1142) {
               this.field1148 = var3 - this.field1142;
            }
         } else if(this.field1142 > var3) {
            this.field1151 = -1;
            if(this.field1148 == 0 || this.field1148 > this.field1142 - var3) {
               this.field1148 = this.field1142 - var3;
            }
         } else {
            this.field1151 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ae")
   static int method1237(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1141 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("l")
   protected class68 vmethod2768() {
      return null;
   }

   @ObfuscatedName("al")
   static int method1239(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1141 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("az")
   static int method1240(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1141 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ay")
   static int method1241(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1141 = var4;
      return var5;
   }

   @ObfuscatedName("af")
   static int method1243(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1141 = var4;
      return var5;
   }

   @ObfuscatedName("bh")
   static int method1245(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1143 += var9.field1150 * (var6 - var3);
      var9.field1142 += var9.field1151 * (var6 - var3);

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

      var9.field1147 = var4 >> 2;
      var9.field1141 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("k")
   public synchronized void method1246(int var1) {
      if(var1 == 0) {
         this.method1216(0);
         this.unlink();
      } else if(this.field1143 == 0 && this.field1142 == 0) {
         this.field1148 = 0;
         this.field1139 = 0;
         this.field1147 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1147;
         if(this.field1147 > var2) {
            var2 = this.field1147;
         }

         if(-this.field1143 > var2) {
            var2 = -this.field1143;
         }

         if(this.field1143 > var2) {
            var2 = this.field1143;
         }

         if(-this.field1142 > var2) {
            var2 = -this.field1142;
         }

         if(this.field1142 > var2) {
            var2 = this.field1142;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1148 = var1;
         this.field1139 = Integer.MIN_VALUE;
         this.field1149 = -this.field1147 / var1;
         this.field1150 = -this.field1143 / var1;
         this.field1151 = -this.field1142 / var1;
      }
   }

   @ObfuscatedName("br")
   static int method1247(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1143 += var9.field1150 * (var6 - var3);
      var9.field1142 += var9.field1151 * (var6 - var3);

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

      var9.field1147 = var4 >> 2;
      var9.field1141 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bu")
   static int method1249(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1143 -= var11.field1150 * var5;
      var11.field1142 -= var11.field1151 * var5;
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

      var11.field1143 += var11.field1150 * var5;
      var11.field1142 += var11.field1151 * var5;
      var11.field1147 = var6;
      var11.field1141 = var4;
      return var5;
   }

   @ObfuscatedName("by")
   static int method1250(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1147 -= var13.field1149 * var5;
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
      var13.field1147 += var13.field1149 * var5;
      var13.field1143 = var6;
      var13.field1142 = var7;
      var13.field1141 = var4;
      return var5;
   }

   @ObfuscatedName("bl")
   static int method1251(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1143 -= var11.field1150 * var5;
      var11.field1142 -= var11.field1151 * var5;
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

      var11.field1143 += var11.field1150 * var5;
      var11.field1142 += var11.field1151 * var5;
      var11.field1147 = var6;
      var11.field1141 = var4;
      return var5;
   }

   @ObfuscatedName("bv")
   static int method1252(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1147 -= var13.field1149 * var5;
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
      var13.field1147 += var13.field1149 * var5;
      var13.field1143 = var6;
      var13.field1142 = var7;
      var13.field1141 = var4;
      return var5;
   }

   @ObfuscatedName("o")
   void method1253() {
      this.field1147 = this.field1139;
      this.field1143 = method1315(this.field1139, this.field1140);
      this.field1142 = method1207(this.field1139, this.field1140);
   }

   @ObfuscatedName("r")
   public static class66 method1266(class55 var0, int var1, int var2, int var3) {
      return var0.field1044 != null && var0.field1044.length != 0?new class66(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("t")
   public synchronized void method1286(int var1) {
      if(this.field1138 < 0) {
         this.field1138 = -var1;
      } else {
         this.field1138 = var1;
      }

   }

   @ObfuscatedName("bc")
   static int method1295(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1141 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("w")
   public synchronized void vmethod2755(int[] var1, int var2, int var3) {
      if(this.field1139 == 0 && this.field1148 == 0) {
         this.vmethod2756(var3);
      } else {
         class55 var4 = (class55)super.field1164;
         int var5 = this.field1137 << 8;
         int var6 = this.field1146 << 8;
         int var7 = var4.field1044.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1144 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1141 < 0) {
            if(this.field1138 <= 0) {
               this.method1222();
               this.unlink();
               return;
            }

            this.field1141 = 0;
         }

         if(this.field1141 >= var7) {
            if(this.field1138 >= 0) {
               this.method1222();
               this.unlink();
               return;
            }

            this.field1141 = var7 - 1;
         }

         if(this.field1144 < 0) {
            if(this.field1145) {
               if(this.field1138 < 0) {
                  var9 = this.method1235(var1, var2, var5, var3, var4.field1044[this.field1137]);
                  if(this.field1141 >= var5) {
                     return;
                  }

                  this.field1141 = var5 + var5 - 1 - this.field1141;
                  this.field1138 = -this.field1138;
               }

               while(true) {
                  var9 = this.method1234(var1, var9, var6, var3, var4.field1044[this.field1146 - 1]);
                  if(this.field1141 < var6) {
                     return;
                  }

                  this.field1141 = var6 + var6 - 1 - this.field1141;
                  this.field1138 = -this.field1138;
                  var9 = this.method1235(var1, var9, var5, var3, var4.field1044[this.field1137]);
                  if(this.field1141 >= var5) {
                     return;
                  }

                  this.field1141 = var5 + var5 - 1 - this.field1141;
                  this.field1138 = -this.field1138;
               }
            } else if(this.field1138 < 0) {
               while(true) {
                  var9 = this.method1235(var1, var9, var5, var3, var4.field1044[this.field1146 - 1]);
                  if(this.field1141 >= var5) {
                     return;
                  }

                  this.field1141 = var6 - 1 - (var6 - 1 - this.field1141) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1234(var1, var9, var6, var3, var4.field1044[this.field1137]);
                  if(this.field1141 < var6) {
                     return;
                  }

                  this.field1141 = var5 + (this.field1141 - var5) % var8;
               }
            }
         } else {
            if(this.field1144 > 0) {
               if(this.field1145) {
                  label177: {
                     if(this.field1138 < 0) {
                        var9 = this.method1235(var1, var2, var5, var3, var4.field1044[this.field1137]);
                        if(this.field1141 >= var5) {
                           return;
                        }

                        this.field1141 = var5 + var5 - 1 - this.field1141;
                        this.field1138 = -this.field1138;
                        if(--this.field1144 == 0) {
                           break label177;
                        }
                     }

                     do {
                        var9 = this.method1234(var1, var9, var6, var3, var4.field1044[this.field1146 - 1]);
                        if(this.field1141 < var6) {
                           return;
                        }

                        this.field1141 = var6 + var6 - 1 - this.field1141;
                        this.field1138 = -this.field1138;
                        if(--this.field1144 == 0) {
                           break;
                        }

                        var9 = this.method1235(var1, var9, var5, var3, var4.field1044[this.field1137]);
                        if(this.field1141 >= var5) {
                           return;
                        }

                        this.field1141 = var5 + var5 - 1 - this.field1141;
                        this.field1138 = -this.field1138;
                     } while(--this.field1144 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1138 < 0) {
                     while(true) {
                        var9 = this.method1235(var1, var9, var5, var3, var4.field1044[this.field1146 - 1]);
                        if(this.field1141 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1141) / var8;
                        if(var10 >= this.field1144) {
                           this.field1141 += var8 * this.field1144;
                           this.field1144 = 0;
                           break;
                        }

                        this.field1141 += var8 * var10;
                        this.field1144 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1234(var1, var9, var6, var3, var4.field1044[this.field1137]);
                        if(this.field1141 < var6) {
                           return;
                        }

                        var10 = (this.field1141 - var5) / var8;
                        if(var10 >= this.field1144) {
                           this.field1141 -= var8 * this.field1144;
                           this.field1144 = 0;
                           break;
                        }

                        this.field1141 -= var8 * var10;
                        this.field1144 -= var10;
                     }
                  }
               }
            }

            if(this.field1138 < 0) {
               this.method1235(var1, var9, 0, var3, 0);
               if(this.field1141 < 0) {
                  this.field1141 = -1;
                  this.method1222();
                  this.unlink();
               }
            } else {
               this.method1234(var1, var9, var7, var3, 0);
               if(this.field1141 >= var7) {
                  this.field1141 = var7;
                  this.method1222();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("f")
   static int method1315(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ac")
   static int method1318(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1141 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ap")
   public boolean method1320() {
      return this.field1141 < 0 || this.field1141 >= ((class55)super.field1164).field1044.length << 8;
   }

   @ObfuscatedName("bk")
   static int method1324(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1147 += var12.field1149 * (var9 - var4);
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

      var12.field1143 = var5 >> 2;
      var12.field1142 = var6 >> 2;
      var12.field1141 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("s")
   public synchronized void vmethod2756(int var1) {
      if(this.field1148 > 0) {
         if(var1 >= this.field1148) {
            if(this.field1139 == Integer.MIN_VALUE) {
               this.field1139 = 0;
               this.field1142 = 0;
               this.field1143 = 0;
               this.field1147 = 0;
               this.unlink();
               var1 = this.field1148;
            }

            this.field1148 = 0;
            this.method1253();
         } else {
            this.field1147 += this.field1149 * var1;
            this.field1143 += this.field1150 * var1;
            this.field1142 += this.field1151 * var1;
            this.field1148 -= var1;
         }
      }

      class55 var2 = (class55)super.field1164;
      int var3 = this.field1137 << 8;
      int var4 = this.field1146 << 8;
      int var5 = var2.field1044.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1144 = 0;
      }

      if(this.field1141 < 0) {
         if(this.field1138 <= 0) {
            this.method1222();
            this.unlink();
            return;
         }

         this.field1141 = 0;
      }

      if(this.field1141 >= var5) {
         if(this.field1138 >= 0) {
            this.method1222();
            this.unlink();
            return;
         }

         this.field1141 = var5 - 1;
      }

      this.field1141 += this.field1138 * var1;
      if(this.field1144 < 0) {
         if(!this.field1145) {
            if(this.field1138 < 0) {
               if(this.field1141 >= var3) {
                  return;
               }

               this.field1141 = var4 - 1 - (var4 - 1 - this.field1141) % var6;
            } else {
               if(this.field1141 < var4) {
                  return;
               }

               this.field1141 = var3 + (this.field1141 - var3) % var6;
            }

         } else {
            if(this.field1138 < 0) {
               if(this.field1141 >= var3) {
                  return;
               }

               this.field1141 = var3 + var3 - 1 - this.field1141;
               this.field1138 = -this.field1138;
            }

            while(this.field1141 >= var4) {
               this.field1141 = var4 + var4 - 1 - this.field1141;
               this.field1138 = -this.field1138;
               if(this.field1141 >= var3) {
                  return;
               }

               this.field1141 = var3 + var3 - 1 - this.field1141;
               this.field1138 = -this.field1138;
            }

         }
      } else {
         if(this.field1144 > 0) {
            if(this.field1145) {
               label168: {
                  if(this.field1138 < 0) {
                     if(this.field1141 >= var3) {
                        return;
                     }

                     this.field1141 = var3 + var3 - 1 - this.field1141;
                     this.field1138 = -this.field1138;
                     if(--this.field1144 == 0) {
                        break label168;
                     }
                  }

                  do {
                     if(this.field1141 < var4) {
                        return;
                     }

                     this.field1141 = var4 + var4 - 1 - this.field1141;
                     this.field1138 = -this.field1138;
                     if(--this.field1144 == 0) {
                        break;
                     }

                     if(this.field1141 >= var3) {
                        return;
                     }

                     this.field1141 = var3 + var3 - 1 - this.field1141;
                     this.field1138 = -this.field1138;
                  } while(--this.field1144 != 0);
               }
            } else {
               int var7;
               if(this.field1138 < 0) {
                  if(this.field1141 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1141) / var6;
                  if(var7 < this.field1144) {
                     this.field1141 += var6 * var7;
                     this.field1144 -= var7;
                     return;
                  }

                  this.field1141 += var6 * this.field1144;
                  this.field1144 = 0;
               } else {
                  if(this.field1141 < var4) {
                     return;
                  }

                  var7 = (this.field1141 - var3) / var6;
                  if(var7 < this.field1144) {
                     this.field1141 -= var6 * var7;
                     this.field1144 -= var7;
                     return;
                  }

                  this.field1141 -= var6 * this.field1144;
                  this.field1144 = 0;
               }
            }
         }

         if(this.field1138 < 0) {
            if(this.field1141 < 0) {
               this.field1141 = -1;
               this.method1222();
               this.unlink();
            }
         } else if(this.field1141 >= var5) {
            this.field1141 = var5;
            this.method1222();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("y")
   public synchronized int method1341() {
      return this.field1139 == Integer.MIN_VALUE?0:this.field1139;
   }

   class66(class55 var1, int var2, int var3) {
      super.field1164 = var1;
      this.field1137 = var1.field1045;
      this.field1146 = var1.field1046;
      this.field1145 = var1.field1048;
      this.field1138 = var2;
      this.field1139 = var3;
      this.field1140 = 8192;
      this.field1141 = 0;
      this.method1253();
   }
}
