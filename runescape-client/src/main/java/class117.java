import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
public class class117 extends class119 {
   @ObfuscatedName("q")
   int field1676;
   @ObfuscatedName("h")
   int field1677;
   @ObfuscatedName("b")
   int field1678;
   @ObfuscatedName("i")
   int field1679;
   @ObfuscatedName("g")
   int field1680;
   @ObfuscatedName("v")
   int field1681;
   @ObfuscatedName("t")
   int field1682;
   @ObfuscatedName("u")
   int field1683;
   @ObfuscatedName("l")
   int field1684;
   @ObfuscatedName("a")
   int field1685;
   @ObfuscatedName("p")
   int field1686;
   @ObfuscatedName("r")
   int field1687;
   @ObfuscatedName("k")
   boolean field1688;
   @ObfuscatedName("x")
   int field1689;
   @ObfuscatedName("o")
   int field1690;

   @ObfuscatedName("h")
   static int method2154(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ao")
   int vmethod2322() {
      int var1 = this.field1680 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1686 == 0) {
         var1 -= var1 * this.field1679 / (((class107)super.field1705).field1602.length << 8);
      } else if(this.field1686 >= 0) {
         var1 -= var1 * this.field1684 / ((class107)super.field1705).field1602.length;
      }

      return var1 > 255?255:var1;
   }

   class117(class107 var1, int var2, int var3) {
      super.field1705 = var1;
      this.field1684 = var1.field1603;
      this.field1685 = var1.field1604;
      this.field1688 = var1.field1601;
      this.field1677 = var2;
      this.field1683 = var3;
      this.field1676 = 8192;
      this.field1679 = 0;
      this.method2158();
   }

   class117(class107 var1, int var2, int var3, int var4) {
      super.field1705 = var1;
      this.field1684 = var1.field1603;
      this.field1685 = var1.field1604;
      this.field1688 = var1.field1601;
      this.field1677 = var2;
      this.field1683 = var3;
      this.field1676 = var4;
      this.field1679 = 0;
      this.method2158();
   }

   @ObfuscatedName("g")
   void method2158() {
      this.field1680 = this.field1683;
      this.field1681 = method2222(this.field1683, this.field1676);
      this.field1682 = method2154(this.field1683, this.field1676);
   }

   @ObfuscatedName("ab")
   static int method2159(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10, int var11, int var12) {
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

      var10.field1679 = var4;
      return var5;
   }

   @ObfuscatedName("a")
   public synchronized void method2160(int var1) {
      this.field1686 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method2161(int var1) {
      this.method2268(var1, this.method2164());
   }

   @ObfuscatedName("m")
   public synchronized int method2164() {
      return this.field1676 < 0?-1:this.field1676;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2166() {
      this.field1677 = (this.field1677 ^ this.field1677 >> 31) + (this.field1677 >>> 31);
      this.field1677 = -this.field1677;
   }

   @ObfuscatedName("y")
   void method2167() {
      if(this.field1687 != 0) {
         if(this.field1683 == Integer.MIN_VALUE) {
            this.field1683 = 0;
         }

         this.field1687 = 0;
         this.method2158();
      }

   }

   @ObfuscatedName("w")
   public synchronized void method2168(int var1, int var2) {
      this.method2205(var1, var2, this.method2164());
   }

   @ObfuscatedName("c")
   public synchronized void method2170(int var1) {
      if(var1 == 0) {
         this.method2161(0);
         this.unlink();
      } else if(this.field1681 == 0 && this.field1682 == 0) {
         this.field1687 = 0;
         this.field1683 = 0;
         this.field1680 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1680;
         if(this.field1680 > var2) {
            var2 = this.field1680;
         }

         if(-this.field1681 > var2) {
            var2 = -this.field1681;
         }

         if(this.field1681 > var2) {
            var2 = this.field1681;
         }

         if(-this.field1682 > var2) {
            var2 = -this.field1682;
         }

         if(this.field1682 > var2) {
            var2 = this.field1682;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1687 = var1;
         this.field1683 = Integer.MIN_VALUE;
         this.field1678 = -this.field1680 / var1;
         this.field1689 = -this.field1681 / var1;
         this.field1690 = -this.field1682 / var1;
      }
   }

   @ObfuscatedName("z")
   public synchronized void method2171(int var1) {
      if(this.field1677 < 0) {
         this.field1677 = -var1;
      } else {
         this.field1677 = var1;
      }

   }

   @ObfuscatedName("ay")
   public synchronized int method2172() {
      return this.field1677 < 0?-this.field1677:this.field1677;
   }

   @ObfuscatedName("av")
   public boolean method2173() {
      return this.field1679 < 0 || this.field1679 >= ((class107)super.field1705).field1602.length << 8;
   }

   @ObfuscatedName("ai")
   public boolean method2174() {
      return this.field1687 != 0;
   }

   @ObfuscatedName("v")
   protected class119 vmethod3944() {
      return null;
   }

   @ObfuscatedName("t")
   protected class119 vmethod3945() {
      return null;
   }

   @ObfuscatedName("am")
   int method2180(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1687 > 0) {
            int var6 = var2 + this.field1687;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1687 += var2;
            if(this.field1677 == 256 && (this.field1679 & 255) == 0) {
               if(class168.field2315) {
                  var2 = method2192(0, ((class107)super.field1705).field1602, var1, this.field1679, var2, this.field1681, this.field1682, this.field1689, this.field1690, 0, var6, var3, this);
               } else {
                  var2 = method2260(((class107)super.field1705).field1602, var1, this.field1679, var2, this.field1680, this.field1678, 0, var6, var3, this);
               }
            } else if(class168.field2315) {
               var2 = method2196(0, 0, ((class107)super.field1705).field1602, var1, this.field1679, var2, this.field1681, this.field1682, this.field1689, this.field1690, 0, var6, var3, this, this.field1677, var5);
            } else {
               var2 = method2195(0, 0, ((class107)super.field1705).field1602, var1, this.field1679, var2, this.field1680, this.field1678, 0, var6, var3, this, this.field1677, var5);
            }

            this.field1687 -= var2;
            if(this.field1687 != 0) {
               return var2;
            }

            if(!this.method2182()) {
               continue;
            }

            return var4;
         }

         if(this.field1677 == 256 && (this.field1679 & 255) == 0) {
            if(class168.field2315) {
               return method2278(0, ((class107)super.field1705).field1602, var1, this.field1679, var2, this.field1681, this.field1682, 0, var4, var3, this);
            }

            return method2183(((class107)super.field1705).field1602, var1, this.field1679, var2, this.field1680, 0, var4, var3, this);
         }

         if(class168.field2315) {
            return method2213(0, 0, ((class107)super.field1705).field1602, var1, this.field1679, var2, this.field1681, this.field1682, 0, var4, var3, this, this.field1677, var5);
         }

         return method2187(0, 0, ((class107)super.field1705).field1602, var1, this.field1679, var2, this.field1680, 0, var4, var3, this, this.field1677, var5);
      }
   }

   @ObfuscatedName("ap")
   int method2181(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1687 > 0) {
            int var6 = var2 + this.field1687;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1687 += var2;
            if(this.field1677 == -256 && (this.field1679 & 255) == 0) {
               if(class168.field2315) {
                  var2 = method2194(0, ((class107)super.field1705).field1602, var1, this.field1679, var2, this.field1681, this.field1682, this.field1689, this.field1690, 0, var6, var3, this);
               } else {
                  var2 = method2197(((class107)super.field1705).field1602, var1, this.field1679, var2, this.field1680, this.field1678, 0, var6, var3, this);
               }
            } else if(class168.field2315) {
               var2 = method2198(0, 0, ((class107)super.field1705).field1602, var1, this.field1679, var2, this.field1681, this.field1682, this.field1689, this.field1690, 0, var6, var3, this, this.field1677, var5);
            } else {
               var2 = method2253(0, 0, ((class107)super.field1705).field1602, var1, this.field1679, var2, this.field1680, this.field1678, 0, var6, var3, this, this.field1677, var5);
            }

            this.field1687 -= var2;
            if(this.field1687 != 0) {
               return var2;
            }

            if(!this.method2182()) {
               continue;
            }

            return var4;
         }

         if(this.field1677 == -256 && (this.field1679 & 255) == 0) {
            if(class168.field2315) {
               return method2300(0, ((class107)super.field1705).field1602, var1, this.field1679, var2, this.field1681, this.field1682, 0, var4, var3, this);
            }

            return method2185(((class107)super.field1705).field1602, var1, this.field1679, var2, this.field1680, 0, var4, var3, this);
         }

         if(class168.field2315) {
            return method2246(0, 0, ((class107)super.field1705).field1602, var1, this.field1679, var2, this.field1681, this.field1682, 0, var4, var3, this, this.field1677, var5);
         }

         return method2159(0, 0, ((class107)super.field1705).field1602, var1, this.field1679, var2, this.field1680, 0, var4, var3, this, this.field1677, var5);
      }
   }

   @ObfuscatedName("as")
   boolean method2182() {
      int var1 = this.field1683;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2222(var1, this.field1676);
         var3 = method2154(var1, this.field1676);
      }

      if(this.field1680 == var1 && this.field1681 == var2 && this.field1682 == var3) {
         if(this.field1683 == Integer.MIN_VALUE) {
            this.field1683 = 0;
            this.field1682 = 0;
            this.field1681 = 0;
            this.field1680 = 0;
            this.unlink();
            return true;
         } else {
            this.method2158();
            return false;
         }
      } else {
         if(this.field1680 < var1) {
            this.field1678 = 1;
            this.field1687 = var1 - this.field1680;
         } else if(this.field1680 > var1) {
            this.field1678 = -1;
            this.field1687 = this.field1680 - var1;
         } else {
            this.field1678 = 0;
         }

         if(this.field1681 < var2) {
            this.field1689 = 1;
            if(this.field1687 == 0 || this.field1687 > var2 - this.field1681) {
               this.field1687 = var2 - this.field1681;
            }
         } else if(this.field1681 > var2) {
            this.field1689 = -1;
            if(this.field1687 == 0 || this.field1687 > this.field1681 - var2) {
               this.field1687 = this.field1681 - var2;
            }
         } else {
            this.field1689 = 0;
         }

         if(this.field1682 < var3) {
            this.field1690 = 1;
            if(this.field1687 == 0 || this.field1687 > var3 - this.field1682) {
               this.field1687 = var3 - this.field1682;
            }
         } else if(this.field1682 > var3) {
            this.field1690 = -1;
            if(this.field1687 == 0 || this.field1687 > this.field1682 - var3) {
               this.field1687 = this.field1682 - var3;
            }
         } else {
            this.field1690 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("aw")
   static int method2183(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class117 var8) {
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

      var8.field1679 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ak")
   static int method2185(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class117 var8) {
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

      var8.field1679 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("an")
   static int method2187(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10, int var11, int var12) {
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

      var10.field1679 = var4;
      return var5;
   }

   @ObfuscatedName("bp")
   static int method2192(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class117 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1680 += var12.field1678 * (var9 - var4);
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

      var12.field1681 = var5 >> 2;
      var12.field1682 = var6 >> 2;
      var12.field1679 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bb")
   static int method2194(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class117 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1680 += var12.field1678 * (var9 - var4);
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

      var12.field1681 = var5 >> 2;
      var12.field1682 = var6 >> 2;
      var12.field1679 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bw")
   static int method2195(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
      var11.field1681 -= var11.field1689 * var5;
      var11.field1682 -= var11.field1690 * var5;
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

      var11.field1681 += var11.field1689 * var5;
      var11.field1682 += var11.field1690 * var5;
      var11.field1680 = var6;
      var11.field1679 = var4;
      return var5;
   }

   @ObfuscatedName("bh")
   static int method2196(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class117 var13, int var14, int var15) {
      var13.field1680 -= var13.field1678 * var5;
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
      var13.field1680 += var13.field1678 * var5;
      var13.field1681 = var6;
      var13.field1682 = var7;
      var13.field1679 = var4;
      return var5;
   }

   @ObfuscatedName("bf")
   static int method2197(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class117 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1681 += var9.field1689 * (var6 - var3);
      var9.field1682 += var9.field1690 * (var6 - var3);

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

      var9.field1680 = var4 >> 2;
      var9.field1679 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bi")
   static int method2198(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class117 var13, int var14, int var15) {
      var13.field1680 -= var13.field1678 * var5;
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
      var13.field1680 += var13.field1678 * var5;
      var13.field1681 = var6;
      var13.field1682 = var7;
      var13.field1679 = var4;
      return var5;
   }

   @ObfuscatedName("f")
   public synchronized void method2205(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2268(var2, var3);
      } else {
         int var4 = method2222(var2, var3);
         int var5 = method2154(var2, var3);
         if(this.field1681 == var4 && this.field1682 == var5) {
            this.field1687 = 0;
         } else {
            int var6 = var2 - this.field1680;
            if(this.field1680 - var2 > var6) {
               var6 = this.field1680 - var2;
            }

            if(var4 - this.field1681 > var6) {
               var6 = var4 - this.field1681;
            }

            if(this.field1681 - var4 > var6) {
               var6 = this.field1681 - var4;
            }

            if(var5 - this.field1682 > var6) {
               var6 = var5 - this.field1682;
            }

            if(this.field1682 - var5 > var6) {
               var6 = this.field1682 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1687 = var1;
            this.field1683 = var2;
            this.field1676 = var3;
            this.field1678 = (var2 - this.field1680) / var1;
            this.field1689 = (var4 - this.field1681) / var1;
            this.field1690 = (var5 - this.field1682) / var1;
         }
      }
   }

   @ObfuscatedName("j")
   public synchronized int method2211() {
      return this.field1683 == Integer.MIN_VALUE?0:this.field1683;
   }

   @ObfuscatedName("au")
   static int method2213(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
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

      var11.field1679 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("p")
   protected int vmethod3946() {
      return this.field1683 == 0 && this.field1687 == 0?0:1;
   }

   @ObfuscatedName("l")
   public synchronized void vmethod3949(int[] var1, int var2, int var3) {
      if(this.field1683 == 0 && this.field1687 == 0) {
         this.vmethod3969(var3);
      } else {
         class107 var4 = (class107)super.field1705;
         int var5 = this.field1684 << 8;
         int var6 = this.field1685 << 8;
         int var7 = var4.field1602.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1686 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1679 < 0) {
            if(this.field1677 <= 0) {
               this.method2167();
               this.unlink();
               return;
            }

            this.field1679 = 0;
         }

         if(this.field1679 >= var7) {
            if(this.field1677 >= 0) {
               this.method2167();
               this.unlink();
               return;
            }

            this.field1679 = var7 - 1;
         }

         if(this.field1686 < 0) {
            if(this.field1688) {
               if(this.field1677 < 0) {
                  var9 = this.method2181(var1, var2, var5, var3, var4.field1602[this.field1684]);
                  if(this.field1679 >= var5) {
                     return;
                  }

                  this.field1679 = var5 + var5 - 1 - this.field1679;
                  this.field1677 = -this.field1677;
               }

               while(true) {
                  var9 = this.method2180(var1, var9, var6, var3, var4.field1602[this.field1685 - 1]);
                  if(this.field1679 < var6) {
                     return;
                  }

                  this.field1679 = var6 + var6 - 1 - this.field1679;
                  this.field1677 = -this.field1677;
                  var9 = this.method2181(var1, var9, var5, var3, var4.field1602[this.field1684]);
                  if(this.field1679 >= var5) {
                     return;
                  }

                  this.field1679 = var5 + var5 - 1 - this.field1679;
                  this.field1677 = -this.field1677;
               }
            } else if(this.field1677 < 0) {
               while(true) {
                  var9 = this.method2181(var1, var9, var5, var3, var4.field1602[this.field1685 - 1]);
                  if(this.field1679 >= var5) {
                     return;
                  }

                  this.field1679 = var6 - 1 - (var6 - 1 - this.field1679) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2180(var1, var9, var6, var3, var4.field1602[this.field1684]);
                  if(this.field1679 < var6) {
                     return;
                  }

                  this.field1679 = var5 + (this.field1679 - var5) % var8;
               }
            }
         } else {
            if(this.field1686 > 0) {
               if(this.field1688) {
                  label172: {
                     if(this.field1677 < 0) {
                        var9 = this.method2181(var1, var2, var5, var3, var4.field1602[this.field1684]);
                        if(this.field1679 >= var5) {
                           return;
                        }

                        this.field1679 = var5 + var5 - 1 - this.field1679;
                        this.field1677 = -this.field1677;
                        if(--this.field1686 == 0) {
                           break label172;
                        }
                     }

                     do {
                        var9 = this.method2180(var1, var9, var6, var3, var4.field1602[this.field1685 - 1]);
                        if(this.field1679 < var6) {
                           return;
                        }

                        this.field1679 = var6 + var6 - 1 - this.field1679;
                        this.field1677 = -this.field1677;
                        if(--this.field1686 == 0) {
                           break;
                        }

                        var9 = this.method2181(var1, var9, var5, var3, var4.field1602[this.field1684]);
                        if(this.field1679 >= var5) {
                           return;
                        }

                        this.field1679 = var5 + var5 - 1 - this.field1679;
                        this.field1677 = -this.field1677;
                     } while(--this.field1686 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1677 < 0) {
                     while(true) {
                        var9 = this.method2181(var1, var9, var5, var3, var4.field1602[this.field1685 - 1]);
                        if(this.field1679 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1679) / var8;
                        if(var10 >= this.field1686) {
                           this.field1679 += var8 * this.field1686;
                           this.field1686 = 0;
                           break;
                        }

                        this.field1679 += var8 * var10;
                        this.field1686 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2180(var1, var9, var6, var3, var4.field1602[this.field1684]);
                        if(this.field1679 < var6) {
                           return;
                        }

                        var10 = (this.field1679 - var5) / var8;
                        if(var10 >= this.field1686) {
                           this.field1679 -= var8 * this.field1686;
                           this.field1686 = 0;
                           break;
                        }

                        this.field1679 -= var8 * var10;
                        this.field1686 -= var10;
                     }
                  }
               }
            }

            if(this.field1677 < 0) {
               this.method2181(var1, var9, 0, var3, 0);
               if(this.field1679 < 0) {
                  this.field1679 = -1;
                  this.method2167();
                  this.unlink();
               }
            } else {
               this.method2180(var1, var9, var7, var3, 0);
               if(this.field1679 >= var7) {
                  this.field1679 = var7;
                  this.method2167();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("i")
   static int method2222(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("s")
   public synchronized void method2226(int var1) {
      int var2 = ((class107)super.field1705).field1602.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1679 = var1;
   }

   @ObfuscatedName("bz")
   static int method2246(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
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

      var11.field1679 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("b")
   public synchronized void method2248(int var1) {
      this.method2268(var1 << 6, this.method2164());
   }

   @ObfuscatedName("u")
   public static class117 method2249(class107 var0, int var1, int var2) {
      return var0.field1602 != null && var0.field1602.length != 0?new class117(var0, (int)((long)var0.field1605 * 256L * (long)var1 / (long)(class109.field1628 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("bl")
   static int method2253(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
      var11.field1681 -= var11.field1689 * var5;
      var11.field1682 -= var11.field1690 * var5;
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

      var11.field1681 += var11.field1689 * var5;
      var11.field1682 += var11.field1690 * var5;
      var11.field1680 = var6;
      var11.field1679 = var4;
      return var5;
   }

   @ObfuscatedName("bd")
   static int method2260(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class117 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1681 += var9.field1689 * (var6 - var3);
      var9.field1682 += var9.field1690 * (var6 - var3);

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

      var9.field1680 = var4 >> 2;
      var9.field1679 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("k")
   public synchronized void vmethod3969(int var1) {
      if(this.field1687 > 0) {
         if(var1 >= this.field1687) {
            if(this.field1683 == Integer.MIN_VALUE) {
               this.field1683 = 0;
               this.field1682 = 0;
               this.field1681 = 0;
               this.field1680 = 0;
               this.unlink();
               var1 = this.field1687;
            }

            this.field1687 = 0;
            this.method2158();
         } else {
            this.field1680 += this.field1678 * var1;
            this.field1681 += this.field1689 * var1;
            this.field1682 += this.field1690 * var1;
            this.field1687 -= var1;
         }
      }

      class107 var2 = (class107)super.field1705;
      int var3 = this.field1684 << 8;
      int var4 = this.field1685 << 8;
      int var5 = var2.field1602.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1686 = 0;
      }

      if(this.field1679 < 0) {
         if(this.field1677 <= 0) {
            this.method2167();
            this.unlink();
            return;
         }

         this.field1679 = 0;
      }

      if(this.field1679 >= var5) {
         if(this.field1677 >= 0) {
            this.method2167();
            this.unlink();
            return;
         }

         this.field1679 = var5 - 1;
      }

      this.field1679 += this.field1677 * var1;
      if(this.field1686 < 0) {
         if(!this.field1688) {
            if(this.field1677 < 0) {
               if(this.field1679 >= var3) {
                  return;
               }

               this.field1679 = var4 - 1 - (var4 - 1 - this.field1679) % var6;
            } else {
               if(this.field1679 < var4) {
                  return;
               }

               this.field1679 = var3 + (this.field1679 - var3) % var6;
            }

         } else {
            if(this.field1677 < 0) {
               if(this.field1679 >= var3) {
                  return;
               }

               this.field1679 = var3 + var3 - 1 - this.field1679;
               this.field1677 = -this.field1677;
            }

            while(this.field1679 >= var4) {
               this.field1679 = var4 + var4 - 1 - this.field1679;
               this.field1677 = -this.field1677;
               if(this.field1679 >= var3) {
                  return;
               }

               this.field1679 = var3 + var3 - 1 - this.field1679;
               this.field1677 = -this.field1677;
            }

         }
      } else {
         if(this.field1686 > 0) {
            if(this.field1688) {
               label167: {
                  if(this.field1677 < 0) {
                     if(this.field1679 >= var3) {
                        return;
                     }

                     this.field1679 = var3 + var3 - 1 - this.field1679;
                     this.field1677 = -this.field1677;
                     if(--this.field1686 == 0) {
                        break label167;
                     }
                  }

                  do {
                     if(this.field1679 < var4) {
                        return;
                     }

                     this.field1679 = var4 + var4 - 1 - this.field1679;
                     this.field1677 = -this.field1677;
                     if(--this.field1686 == 0) {
                        break;
                     }

                     if(this.field1679 >= var3) {
                        return;
                     }

                     this.field1679 = var3 + var3 - 1 - this.field1679;
                     this.field1677 = -this.field1677;
                  } while(--this.field1686 != 0);
               }
            } else {
               label199: {
                  int var7;
                  if(this.field1677 < 0) {
                     if(this.field1679 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1679) / var6;
                     if(var7 >= this.field1686) {
                        this.field1679 += var6 * this.field1686;
                        this.field1686 = 0;
                        break label199;
                     }

                     this.field1679 += var6 * var7;
                     this.field1686 -= var7;
                  } else {
                     if(this.field1679 < var4) {
                        return;
                     }

                     var7 = (this.field1679 - var3) / var6;
                     if(var7 >= this.field1686) {
                        this.field1679 -= var6 * this.field1686;
                        this.field1686 = 0;
                        break label199;
                     }

                     this.field1679 -= var6 * var7;
                     this.field1686 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1677 < 0) {
            if(this.field1679 < 0) {
               this.field1679 = -1;
               this.method2167();
               this.unlink();
            }
         } else if(this.field1679 >= var5) {
            this.field1679 = var5;
            this.method2167();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("o")
   synchronized void method2268(int var1, int var2) {
      this.field1683 = var1;
      this.field1676 = var2;
      this.field1687 = 0;
      this.method2158();
   }

   @ObfuscatedName("q")
   public static class117 method2271(class107 var0, int var1, int var2, int var3) {
      return var0.field1602 != null && var0.field1602.length != 0?new class117(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("al")
   static int method2278(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10) {
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

      var10.field1679 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("aa")
   static int method2300(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10) {
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

      var10.field1679 = var3 << 8;
      return var4 >> 1;
   }
}
