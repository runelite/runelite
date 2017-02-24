import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public class class66 extends class68 {
   @ObfuscatedName("n")
   int field1129;
   @ObfuscatedName("d")
   int field1130;
   @ObfuscatedName("h")
   int field1131;
   @ObfuscatedName("p")
   int field1132;
   @ObfuscatedName("u")
   int field1133;
   @ObfuscatedName("o")
   int field1134;
   @ObfuscatedName("r")
   int field1135;
   @ObfuscatedName("c")
   int field1136;
   @ObfuscatedName("i")
   int field1137;
   @ObfuscatedName("j")
   int field1138;
   @ObfuscatedName("m")
   boolean field1139;
   @ObfuscatedName("s")
   int field1140;
   @ObfuscatedName("v")
   int field1141;
   @ObfuscatedName("b")
   int field1142;
   @ObfuscatedName("q")
   int field1143;

   @ObfuscatedName("ab")
   static int method1231(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1143 = var4;
      return var5;
   }

   @ObfuscatedName("d")
   static int method1232(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("an")
   int vmethod1401() {
      int var1 = this.field1138 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1136 == 0) {
         var1 -= var1 * this.field1143 / (((class55)super.field1156).field1044.length << 8);
      } else if(this.field1136 >= 0) {
         var1 -= var1 * this.field1137 / ((class55)super.field1156).field1044.length;
      }

      return var1 > 255?255:var1;
   }

   class66(class55 var1, int var2, int var3, int var4) {
      super.field1156 = var1;
      this.field1137 = var1.field1046;
      this.field1134 = var1.field1043;
      this.field1139 = var1.field1047;
      this.field1130 = var2;
      this.field1131 = var3;
      this.field1132 = var4;
      this.field1143 = 0;
      this.method1342();
   }

   @ObfuscatedName("h")
   public static class66 method1235(class55 var0, int var1, int var2) {
      return var0.field1044 != null && var0.field1044.length != 0?new class66(var0, (int)((long)var0.field1045 * 256L * (long)var1 / (long)(class57.field1061 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("p")
   public static class66 method1236(class55 var0, int var1, int var2, int var3) {
      return var0.field1044 != null && var0.field1044.length != 0?new class66(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("v")
   public synchronized void method1237(int var1) {
      this.method1241(var1 << 6, this.method1278());
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method1240(int var1) {
      this.method1241(var1, this.method1278());
   }

   @ObfuscatedName("z")
   synchronized void method1241(int var1, int var2) {
      this.field1131 = var1;
      this.field1132 = var2;
      this.field1140 = 0;
      this.method1342();
   }

   @ObfuscatedName("u")
   public synchronized void method1243(int var1) {
      this.field1136 = var1;
   }

   @ObfuscatedName("w")
   public synchronized void method1244(int var1) {
      int var2 = ((class55)super.field1156).field1044.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1143 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method1245() {
      this.field1130 = (this.field1130 ^ this.field1130 >> 31) + (this.field1130 >>> 31);
      this.field1130 = -this.field1130;
   }

   @ObfuscatedName("l")
   public synchronized void method1247(int var1, int var2) {
      this.method1248(var1, var2, this.method1278());
   }

   @ObfuscatedName("x")
   public synchronized void method1248(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method1241(var2, var3);
      } else {
         int var4 = method1327(var2, var3);
         int var5 = method1232(var2, var3);
         if(this.field1129 == var4 && this.field1135 == var5) {
            this.field1140 = 0;
         } else {
            int var6 = var2 - this.field1138;
            if(this.field1138 - var2 > var6) {
               var6 = this.field1138 - var2;
            }

            if(var4 - this.field1129 > var6) {
               var6 = var4 - this.field1129;
            }

            if(this.field1129 - var4 > var6) {
               var6 = this.field1129 - var4;
            }

            if(var5 - this.field1135 > var6) {
               var6 = var5 - this.field1135;
            }

            if(this.field1135 - var5 > var6) {
               var6 = this.field1135 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1140 = var1;
            this.field1131 = var2;
            this.field1132 = var3;
            this.field1133 = (var2 - this.field1138) / var1;
            this.field1142 = (var4 - this.field1129) / var1;
            this.field1141 = (var5 - this.field1135) / var1;
         }
      }
   }

   @ObfuscatedName("e")
   public synchronized void method1250(int var1) {
      if(this.field1130 < 0) {
         this.field1130 = -var1;
      } else {
         this.field1130 = var1;
      }

   }

   @ObfuscatedName("as")
   public boolean method1253() {
      return this.field1140 != 0;
   }

   @ObfuscatedName("n")
   protected class68 vmethod2734() {
      return null;
   }

   @ObfuscatedName("c")
   protected class68 vmethod2717() {
      return null;
   }

   @ObfuscatedName("o")
   protected int vmethod2716() {
      return this.field1131 == 0 && this.field1140 == 0?0:1;
   }

   @ObfuscatedName("aa")
   int method1257(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1140 > 0) {
            int var6 = var2 + this.field1140;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1140 += var2;
            if(this.field1130 == 256 && (this.field1143 & 255) == 0) {
               if(class57.field1070) {
                  var2 = method1351(0, ((class55)super.field1156).field1044, var1, this.field1143, var2, this.field1129, this.field1135, this.field1142, this.field1141, 0, var6, var3, this);
               } else {
                  var2 = method1270(((class55)super.field1156).field1044, var1, this.field1143, var2, this.field1138, this.field1133, 0, var6, var3, this);
               }
            } else if(class57.field1070) {
               var2 = method1275(0, 0, ((class55)super.field1156).field1044, var1, this.field1143, var2, this.field1129, this.field1135, this.field1142, this.field1141, 0, var6, var3, this, this.field1130, var5);
            } else {
               var2 = method1280(0, 0, ((class55)super.field1156).field1044, var1, this.field1143, var2, this.field1138, this.field1133, 0, var6, var3, this, this.field1130, var5);
            }

            this.field1140 -= var2;
            if(this.field1140 != 0) {
               return var2;
            }

            if(!this.method1261()) {
               continue;
            }

            return var4;
         }

         if(this.field1130 == 256 && (this.field1143 & 255) == 0) {
            if(class57.field1070) {
               return method1334(0, ((class55)super.field1156).field1044, var1, this.field1143, var2, this.field1129, this.field1135, 0, var4, var3, this);
            }

            return method1262(((class55)super.field1156).field1044, var1, this.field1143, var2, this.field1138, 0, var4, var3, this);
         }

         if(class57.field1070) {
            return method1332(0, 0, ((class55)super.field1156).field1044, var1, this.field1143, var2, this.field1129, this.field1135, 0, var4, var3, this, this.field1130, var5);
         }

         return method1231(0, 0, ((class55)super.field1156).field1044, var1, this.field1143, var2, this.field1138, 0, var4, var3, this, this.field1130, var5);
      }
   }

   @ObfuscatedName("b")
   public synchronized void vmethod2719(int var1) {
      if(this.field1140 > 0) {
         if(var1 >= this.field1140) {
            if(this.field1131 == Integer.MIN_VALUE) {
               this.field1131 = 0;
               this.field1135 = 0;
               this.field1129 = 0;
               this.field1138 = 0;
               this.unlink();
               var1 = this.field1140;
            }

            this.field1140 = 0;
            this.method1342();
         } else {
            this.field1138 += this.field1133 * var1;
            this.field1129 += this.field1142 * var1;
            this.field1135 += this.field1141 * var1;
            this.field1140 -= var1;
         }
      }

      class55 var2 = (class55)super.field1156;
      int var3 = this.field1137 << 8;
      int var4 = this.field1134 << 8;
      int var5 = var2.field1044.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1136 = 0;
      }

      if(this.field1143 < 0) {
         if(this.field1130 <= 0) {
            this.method1272();
            this.unlink();
            return;
         }

         this.field1143 = 0;
      }

      if(this.field1143 >= var5) {
         if(this.field1130 >= 0) {
            this.method1272();
            this.unlink();
            return;
         }

         this.field1143 = var5 - 1;
      }

      this.field1143 += this.field1130 * var1;
      if(this.field1136 < 0) {
         if(!this.field1139) {
            if(this.field1130 < 0) {
               if(this.field1143 >= var3) {
                  return;
               }

               this.field1143 = var4 - 1 - (var4 - 1 - this.field1143) % var6;
            } else {
               if(this.field1143 < var4) {
                  return;
               }

               this.field1143 = var3 + (this.field1143 - var3) % var6;
            }

         } else {
            if(this.field1130 < 0) {
               if(this.field1143 >= var3) {
                  return;
               }

               this.field1143 = var3 + var3 - 1 - this.field1143;
               this.field1130 = -this.field1130;
            }

            while(this.field1143 >= var4) {
               this.field1143 = var4 + var4 - 1 - this.field1143;
               this.field1130 = -this.field1130;
               if(this.field1143 >= var3) {
                  return;
               }

               this.field1143 = var3 + var3 - 1 - this.field1143;
               this.field1130 = -this.field1130;
            }

         }
      } else {
         if(this.field1136 > 0) {
            if(this.field1139) {
               label171: {
                  if(this.field1130 < 0) {
                     if(this.field1143 >= var3) {
                        return;
                     }

                     this.field1143 = var3 + var3 - 1 - this.field1143;
                     this.field1130 = -this.field1130;
                     if(--this.field1136 == 0) {
                        break label171;
                     }
                  }

                  do {
                     if(this.field1143 < var4) {
                        return;
                     }

                     this.field1143 = var4 + var4 - 1 - this.field1143;
                     this.field1130 = -this.field1130;
                     if(--this.field1136 == 0) {
                        break;
                     }

                     if(this.field1143 >= var3) {
                        return;
                     }

                     this.field1143 = var3 + var3 - 1 - this.field1143;
                     this.field1130 = -this.field1130;
                  } while(--this.field1136 != 0);
               }
            } else {
               int var7;
               if(this.field1130 < 0) {
                  if(this.field1143 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1143) / var6;
                  if(var7 < this.field1136) {
                     this.field1143 += var6 * var7;
                     this.field1136 -= var7;
                     return;
                  }

                  this.field1143 += var6 * this.field1136;
                  this.field1136 = 0;
               } else {
                  if(this.field1143 < var4) {
                     return;
                  }

                  var7 = (this.field1143 - var3) / var6;
                  if(var7 < this.field1136) {
                     this.field1143 -= var6 * var7;
                     this.field1136 -= var7;
                     return;
                  }

                  this.field1143 -= var6 * this.field1136;
                  this.field1136 = 0;
               }
            }
         }

         if(this.field1130 < 0) {
            if(this.field1143 < 0) {
               this.field1143 = -1;
               this.method1272();
               this.unlink();
            }
         } else if(this.field1143 >= var5) {
            this.field1143 = var5;
            this.method1272();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("ah")
   int method1260(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1140 > 0) {
            int var6 = var2 + this.field1140;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1140 += var2;
            if(this.field1130 == -256 && (this.field1143 & 255) == 0) {
               if(class57.field1070) {
                  var2 = method1273(0, ((class55)super.field1156).field1044, var1, this.field1143, var2, this.field1129, this.field1135, this.field1142, this.field1141, 0, var6, var3, this);
               } else {
                  var2 = method1366(((class55)super.field1156).field1044, var1, this.field1143, var2, this.field1138, this.field1133, 0, var6, var3, this);
               }
            } else if(class57.field1070) {
               var2 = method1301(0, 0, ((class55)super.field1156).field1044, var1, this.field1143, var2, this.field1129, this.field1135, this.field1142, this.field1141, 0, var6, var3, this, this.field1130, var5);
            } else {
               var2 = method1276(0, 0, ((class55)super.field1156).field1044, var1, this.field1143, var2, this.field1138, this.field1133, 0, var6, var3, this, this.field1130, var5);
            }

            this.field1140 -= var2;
            if(this.field1140 != 0) {
               return var2;
            }

            if(!this.method1261()) {
               continue;
            }

            return var4;
         }

         if(this.field1130 == -256 && (this.field1143 & 255) == 0) {
            if(class57.field1070) {
               return method1324(0, ((class55)super.field1156).field1044, var1, this.field1143, var2, this.field1129, this.field1135, 0, var4, var3, this);
            }

            return method1340(((class55)super.field1156).field1044, var1, this.field1143, var2, this.field1138, 0, var4, var3, this);
         }

         if(class57.field1070) {
            return method1274(0, 0, ((class55)super.field1156).field1044, var1, this.field1143, var2, this.field1129, this.field1135, 0, var4, var3, this, this.field1130, var5);
         }

         return method1268(0, 0, ((class55)super.field1156).field1044, var1, this.field1143, var2, this.field1138, 0, var4, var3, this, this.field1130, var5);
      }
   }

   @ObfuscatedName("aj")
   boolean method1261() {
      int var1 = this.field1131;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method1327(var1, this.field1132);
         var3 = method1232(var1, this.field1132);
      }

      if(this.field1138 == var1 && this.field1129 == var2 && this.field1135 == var3) {
         if(this.field1131 == Integer.MIN_VALUE) {
            this.field1131 = 0;
            this.field1135 = 0;
            this.field1129 = 0;
            this.field1138 = 0;
            this.unlink();
            return true;
         } else {
            this.method1342();
            return false;
         }
      } else {
         if(this.field1138 < var1) {
            this.field1133 = 1;
            this.field1140 = var1 - this.field1138;
         } else if(this.field1138 > var1) {
            this.field1133 = -1;
            this.field1140 = this.field1138 - var1;
         } else {
            this.field1133 = 0;
         }

         if(this.field1129 < var2) {
            this.field1142 = 1;
            if(this.field1140 == 0 || this.field1140 > var2 - this.field1129) {
               this.field1140 = var2 - this.field1129;
            }
         } else if(this.field1129 > var2) {
            this.field1142 = -1;
            if(this.field1140 == 0 || this.field1140 > this.field1129 - var2) {
               this.field1140 = this.field1129 - var2;
            }
         } else {
            this.field1142 = 0;
         }

         if(this.field1135 < var3) {
            this.field1141 = 1;
            if(this.field1140 == 0 || this.field1140 > var3 - this.field1135) {
               this.field1140 = var3 - this.field1135;
            }
         } else if(this.field1135 > var3) {
            this.field1141 = -1;
            if(this.field1140 == 0 || this.field1140 > this.field1135 - var3) {
               this.field1140 = this.field1135 - var3;
            }
         } else {
            this.field1141 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ak")
   static int method1262(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1143 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("t")
   public synchronized int method1263() {
      return this.field1131 == Integer.MIN_VALUE?0:this.field1131;
   }

   @ObfuscatedName("ay")
   static int method1268(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10, int var11, int var12) {
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

      var10.field1143 = var4;
      return var5;
   }

   @ObfuscatedName("af")
   static int method1270(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1129 += var9.field1142 * (var6 - var3);
      var9.field1135 += var9.field1141 * (var6 - var3);

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

      var9.field1138 = var4 >> 2;
      var9.field1143 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("s")
   public synchronized void vmethod2718(int[] var1, int var2, int var3) {
      if(this.field1131 == 0 && this.field1140 == 0) {
         this.vmethod2719(var3);
      } else {
         class55 var4 = (class55)super.field1156;
         int var5 = this.field1137 << 8;
         int var6 = this.field1134 << 8;
         int var7 = var4.field1044.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1136 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1143 < 0) {
            if(this.field1130 <= 0) {
               this.method1272();
               this.unlink();
               return;
            }

            this.field1143 = 0;
         }

         if(this.field1143 >= var7) {
            if(this.field1130 >= 0) {
               this.method1272();
               this.unlink();
               return;
            }

            this.field1143 = var7 - 1;
         }

         if(this.field1136 < 0) {
            if(this.field1139) {
               if(this.field1130 < 0) {
                  var9 = this.method1260(var1, var2, var5, var3, var4.field1044[this.field1137]);
                  if(this.field1143 >= var5) {
                     return;
                  }

                  this.field1143 = var5 + var5 - 1 - this.field1143;
                  this.field1130 = -this.field1130;
               }

               while(true) {
                  var9 = this.method1257(var1, var9, var6, var3, var4.field1044[this.field1134 - 1]);
                  if(this.field1143 < var6) {
                     return;
                  }

                  this.field1143 = var6 + var6 - 1 - this.field1143;
                  this.field1130 = -this.field1130;
                  var9 = this.method1260(var1, var9, var5, var3, var4.field1044[this.field1137]);
                  if(this.field1143 >= var5) {
                     return;
                  }

                  this.field1143 = var5 + var5 - 1 - this.field1143;
                  this.field1130 = -this.field1130;
               }
            } else if(this.field1130 < 0) {
               while(true) {
                  var9 = this.method1260(var1, var9, var5, var3, var4.field1044[this.field1134 - 1]);
                  if(this.field1143 >= var5) {
                     return;
                  }

                  this.field1143 = var6 - 1 - (var6 - 1 - this.field1143) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method1257(var1, var9, var6, var3, var4.field1044[this.field1137]);
                  if(this.field1143 < var6) {
                     return;
                  }

                  this.field1143 = var5 + (this.field1143 - var5) % var8;
               }
            }
         } else {
            if(this.field1136 > 0) {
               if(this.field1139) {
                  label176: {
                     if(this.field1130 < 0) {
                        var9 = this.method1260(var1, var2, var5, var3, var4.field1044[this.field1137]);
                        if(this.field1143 >= var5) {
                           return;
                        }

                        this.field1143 = var5 + var5 - 1 - this.field1143;
                        this.field1130 = -this.field1130;
                        if(--this.field1136 == 0) {
                           break label176;
                        }
                     }

                     do {
                        var9 = this.method1257(var1, var9, var6, var3, var4.field1044[this.field1134 - 1]);
                        if(this.field1143 < var6) {
                           return;
                        }

                        this.field1143 = var6 + var6 - 1 - this.field1143;
                        this.field1130 = -this.field1130;
                        if(--this.field1136 == 0) {
                           break;
                        }

                        var9 = this.method1260(var1, var9, var5, var3, var4.field1044[this.field1137]);
                        if(this.field1143 >= var5) {
                           return;
                        }

                        this.field1143 = var5 + var5 - 1 - this.field1143;
                        this.field1130 = -this.field1130;
                     } while(--this.field1136 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1130 < 0) {
                     while(true) {
                        var9 = this.method1260(var1, var9, var5, var3, var4.field1044[this.field1134 - 1]);
                        if(this.field1143 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1143) / var8;
                        if(var10 >= this.field1136) {
                           this.field1143 += var8 * this.field1136;
                           this.field1136 = 0;
                           break;
                        }

                        this.field1143 += var8 * var10;
                        this.field1136 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method1257(var1, var9, var6, var3, var4.field1044[this.field1137]);
                        if(this.field1143 < var6) {
                           return;
                        }

                        var10 = (this.field1143 - var5) / var8;
                        if(var10 >= this.field1136) {
                           this.field1143 -= var8 * this.field1136;
                           this.field1136 = 0;
                           break;
                        }

                        this.field1143 -= var8 * var10;
                        this.field1136 -= var10;
                     }
                  }
               }
            }

            if(this.field1130 < 0) {
               this.method1260(var1, var9, 0, var3, 0);
               if(this.field1143 < 0) {
                  this.field1143 = -1;
                  this.method1272();
                  this.unlink();
               }
            } else {
               this.method1257(var1, var9, var7, var3, 0);
               if(this.field1143 >= var7) {
                  this.field1143 = var7;
                  this.method1272();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("k")
   void method1272() {
      if(this.field1140 != 0) {
         if(this.field1131 == Integer.MIN_VALUE) {
            this.field1131 = 0;
         }

         this.field1140 = 0;
         this.method1342();
      }

   }

   @ObfuscatedName("bp")
   static int method1273(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1138 += var12.field1133 * (var9 - var4);
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

      var12.field1129 = var5 >> 2;
      var12.field1135 = var6 >> 2;
      var12.field1143 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("av")
   static int method1274(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1143 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bj")
   static int method1275(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1138 -= var13.field1133 * var5;
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
      var13.field1138 += var13.field1133 * var5;
      var13.field1129 = var6;
      var13.field1135 = var7;
      var13.field1143 = var4;
      return var5;
   }

   @ObfuscatedName("bw")
   static int method1276(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1129 -= var11.field1142 * var5;
      var11.field1135 -= var11.field1141 * var5;
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

      var11.field1129 += var11.field1142 * var5;
      var11.field1135 += var11.field1141 * var5;
      var11.field1138 = var6;
      var11.field1143 = var4;
      return var5;
   }

   class66(class55 var1, int var2, int var3) {
      super.field1156 = var1;
      this.field1137 = var1.field1046;
      this.field1134 = var1.field1043;
      this.field1139 = var1.field1047;
      this.field1130 = var2;
      this.field1131 = var3;
      this.field1132 = 8192;
      this.field1143 = 0;
      this.method1342();
   }

   @ObfuscatedName("y")
   public synchronized int method1278() {
      return this.field1132 < 0?-1:this.field1132;
   }

   @ObfuscatedName("bt")
   static int method1280(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
      var11.field1129 -= var11.field1142 * var5;
      var11.field1135 -= var11.field1141 * var5;
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

      var11.field1129 += var11.field1142 * var5;
      var11.field1135 += var11.field1141 * var5;
      var11.field1138 = var6;
      var11.field1143 = var4;
      return var5;
   }

   @ObfuscatedName("bd")
   static int method1301(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class66 var13, int var14, int var15) {
      var13.field1138 -= var13.field1133 * var5;
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
      var13.field1138 += var13.field1133 * var5;
      var13.field1129 = var6;
      var13.field1135 = var7;
      var13.field1143 = var4;
      return var5;
   }

   @ObfuscatedName("g")
   public synchronized void method1316(int var1) {
      if(var1 == 0) {
         this.method1240(0);
         this.unlink();
      } else if(this.field1129 == 0 && this.field1135 == 0) {
         this.field1140 = 0;
         this.field1131 = 0;
         this.field1138 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1138;
         if(this.field1138 > var2) {
            var2 = this.field1138;
         }

         if(-this.field1129 > var2) {
            var2 = -this.field1129;
         }

         if(this.field1129 > var2) {
            var2 = this.field1129;
         }

         if(-this.field1135 > var2) {
            var2 = -this.field1135;
         }

         if(this.field1135 > var2) {
            var2 = this.field1135;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1140 = var1;
         this.field1131 = Integer.MIN_VALUE;
         this.field1133 = -this.field1138 / var1;
         this.field1142 = -this.field1129 / var1;
         this.field1141 = -this.field1135 / var1;
      }
   }

   @ObfuscatedName("ar")
   static int method1324(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1143 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("q")
   static int method1327(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("aq")
   public boolean method1329() {
      return this.field1143 < 0 || this.field1143 >= ((class55)super.field1156).field1044.length << 8;
   }

   @ObfuscatedName("az")
   static int method1332(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class66 var11, int var12, int var13) {
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

      var11.field1143 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ag")
   static int method1334(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class66 var10) {
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

      var10.field1143 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ae")
   public synchronized int method1338() {
      return this.field1130 < 0?-this.field1130:this.field1130;
   }

   @ObfuscatedName("al")
   static int method1340(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class66 var8) {
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

      var8.field1143 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("j")
   void method1342() {
      this.field1138 = this.field1131;
      this.field1129 = method1327(this.field1131, this.field1132);
      this.field1135 = method1232(this.field1131, this.field1132);
   }

   @ObfuscatedName("ax")
   static int method1351(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class66 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1138 += var12.field1133 * (var9 - var4);
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

      var12.field1129 = var5 >> 2;
      var12.field1135 = var6 >> 2;
      var12.field1143 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bn")
   static int method1366(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class66 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1129 += var9.field1142 * (var6 - var3);
      var9.field1135 += var9.field1141 * (var6 - var3);

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

      var9.field1138 = var4 >> 2;
      var9.field1143 = var2 << 8;
      return var3;
   }
}
