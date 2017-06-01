import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
public class class117 extends class119 {
   @ObfuscatedName("v")
   int field1705;
   @ObfuscatedName("i")
   int field1706;
   @ObfuscatedName("c")
   int field1707;
   @ObfuscatedName("e")
   int field1708;
   @ObfuscatedName("b")
   int field1709;
   @ObfuscatedName("y")
   int field1710;
   @ObfuscatedName("q")
   int field1711;
   @ObfuscatedName("x")
   int field1712;
   @ObfuscatedName("h")
   int field1713;
   @ObfuscatedName("f")
   int field1714;
   @ObfuscatedName("a")
   boolean field1715;
   @ObfuscatedName("o")
   int field1716;
   @ObfuscatedName("z")
   int field1717;
   @ObfuscatedName("n")
   int field1718;
   @ObfuscatedName("j")
   int field1719;

   @ObfuscatedName("c")
   static int method2104(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   class117(class107 var1, int var2, int var3) {
      super.field1734 = var1;
      this.field1714 = var1.field1621;
      this.field1718 = var1.field1623;
      this.field1715 = var1.field1624;
      this.field1707 = var2;
      this.field1708 = var3;
      this.field1705 = 8192;
      this.field1706 = 0;
      this.method2108();
   }

   class117(class107 var1, int var2, int var3, int var4) {
      super.field1734 = var1;
      this.field1714 = var1.field1621;
      this.field1718 = var1.field1623;
      this.field1715 = var1.field1624;
      this.field1707 = var2;
      this.field1708 = var3;
      this.field1705 = var4;
      this.field1706 = 0;
      this.method2108();
   }

   @ObfuscatedName("e")
   public static class117 method2106(class107 var0, int var1, int var2) {
      return var0.field1620 != null && var0.field1620.length != 0?new class117(var0, (int)((long)var0.field1622 * 256L * (long)var1 / (long)(class109.field1640 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("v")
   public static class117 method2107(class107 var0, int var1, int var2, int var3) {
      return var0.field1620 != null && var0.field1620.length != 0?new class117(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("b")
   void method2108() {
      this.field1709 = this.field1708;
      this.field1710 = method2122(this.field1708, this.field1705);
      this.field1713 = method2104(this.field1708, this.field1705);
   }

   @ObfuscatedName("o")
   public synchronized void method2110(int var1) {
      this.method2211(var1 << 6, this.method2114());
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method2111(int var1) {
      this.method2211(var1, this.method2114());
   }

   @ObfuscatedName("by")
   static int method2113(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class117 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1710 += var9.field1711 * (var6 - var3);
      var9.field1713 += var9.field1719 * (var6 - var3);

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

      var9.field1709 = var4 >> 2;
      var9.field1706 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("l")
   public synchronized int method2114() {
      return this.field1705 < 0?-1:this.field1705;
   }

   @ObfuscatedName("u")
   public synchronized void method2115(int var1) {
      int var2 = ((class107)super.field1734).field1620.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1706 = var1;
   }

   @ObfuscatedName("bi")
   static int method2117(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
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

      var11.field1706 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("x")
   protected int vmethod3860() {
      return this.field1708 == 0 && this.field1716 == 0?0:1;
   }

   @ObfuscatedName("an")
   public synchronized void method2119(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2211(var2, var3);
      } else {
         int var4 = method2122(var2, var3);
         int var5 = method2104(var2, var3);
         if(this.field1710 == var4 && this.field1713 == var5) {
            this.field1716 = 0;
         } else {
            int var6 = var2 - this.field1709;
            if(this.field1709 - var2 > var6) {
               var6 = this.field1709 - var2;
            }

            if(var4 - this.field1710 > var6) {
               var6 = var4 - this.field1710;
            }

            if(this.field1710 - var4 > var6) {
               var6 = this.field1710 - var4;
            }

            if(var5 - this.field1713 > var6) {
               var6 = var5 - this.field1713;
            }

            if(this.field1713 - var5 > var6) {
               var6 = this.field1713 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1716 = var1;
            this.field1708 = var2;
            this.field1705 = var3;
            this.field1717 = (var2 - this.field1709) / var1;
            this.field1711 = (var4 - this.field1710) / var1;
            this.field1719 = (var5 - this.field1713) / var1;
         }
      }
   }

   @ObfuscatedName("ak")
   public synchronized void method2121(int var1) {
      if(this.field1707 < 0) {
         this.field1707 = -var1;
      } else {
         this.field1707 = var1;
      }

   }

   @ObfuscatedName("i")
   static int method2122(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ad")
   void method2124() {
      if(this.field1716 != 0) {
         if(this.field1708 == Integer.MIN_VALUE) {
            this.field1708 = 0;
         }

         this.field1716 = 0;
         this.method2108();
      }

   }

   @ObfuscatedName("y")
   protected class119 vmethod3858() {
      return null;
   }

   @ObfuscatedName("h")
   protected class119 vmethod3886() {
      return null;
   }

   @ObfuscatedName("f")
   public synchronized void vmethod3878(int[] var1, int var2, int var3) {
      if(this.field1708 == 0 && this.field1716 == 0) {
         this.vmethod3862(var3);
      } else {
         class107 var4 = (class107)super.field1734;
         int var5 = this.field1714 << 8;
         int var6 = this.field1718 << 8;
         int var7 = var4.field1620.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1712 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1706 < 0) {
            if(this.field1707 <= 0) {
               this.method2124();
               this.unlink();
               return;
            }

            this.field1706 = 0;
         }

         if(this.field1706 >= var7) {
            if(this.field1707 >= 0) {
               this.method2124();
               this.unlink();
               return;
            }

            this.field1706 = var7 - 1;
         }

         if(this.field1712 < 0) {
            if(this.field1715) {
               if(this.field1707 < 0) {
                  var9 = this.method2153(var1, var2, var5, var3, var4.field1620[this.field1714]);
                  if(this.field1706 >= var5) {
                     return;
                  }

                  this.field1706 = var5 + var5 - 1 - this.field1706;
                  this.field1707 = -this.field1707;
               }

               while(true) {
                  var9 = this.method2221(var1, var9, var6, var3, var4.field1620[this.field1718 - 1]);
                  if(this.field1706 < var6) {
                     return;
                  }

                  this.field1706 = var6 + var6 - 1 - this.field1706;
                  this.field1707 = -this.field1707;
                  var9 = this.method2153(var1, var9, var5, var3, var4.field1620[this.field1714]);
                  if(this.field1706 >= var5) {
                     return;
                  }

                  this.field1706 = var5 + var5 - 1 - this.field1706;
                  this.field1707 = -this.field1707;
               }
            } else if(this.field1707 < 0) {
               while(true) {
                  var9 = this.method2153(var1, var9, var5, var3, var4.field1620[this.field1718 - 1]);
                  if(this.field1706 >= var5) {
                     return;
                  }

                  this.field1706 = var6 - 1 - (var6 - 1 - this.field1706) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2221(var1, var9, var6, var3, var4.field1620[this.field1714]);
                  if(this.field1706 < var6) {
                     return;
                  }

                  this.field1706 = var5 + (this.field1706 - var5) % var8;
               }
            }
         } else {
            if(this.field1712 > 0) {
               if(this.field1715) {
                  label174: {
                     if(this.field1707 < 0) {
                        var9 = this.method2153(var1, var2, var5, var3, var4.field1620[this.field1714]);
                        if(this.field1706 >= var5) {
                           return;
                        }

                        this.field1706 = var5 + var5 - 1 - this.field1706;
                        this.field1707 = -this.field1707;
                        if(--this.field1712 == 0) {
                           break label174;
                        }
                     }

                     do {
                        var9 = this.method2221(var1, var9, var6, var3, var4.field1620[this.field1718 - 1]);
                        if(this.field1706 < var6) {
                           return;
                        }

                        this.field1706 = var6 + var6 - 1 - this.field1706;
                        this.field1707 = -this.field1707;
                        if(--this.field1712 == 0) {
                           break;
                        }

                        var9 = this.method2153(var1, var9, var5, var3, var4.field1620[this.field1714]);
                        if(this.field1706 >= var5) {
                           return;
                        }

                        this.field1706 = var5 + var5 - 1 - this.field1706;
                        this.field1707 = -this.field1707;
                     } while(--this.field1712 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1707 < 0) {
                     while(true) {
                        var9 = this.method2153(var1, var9, var5, var3, var4.field1620[this.field1718 - 1]);
                        if(this.field1706 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1706) / var8;
                        if(var10 >= this.field1712) {
                           this.field1706 += var8 * this.field1712;
                           this.field1712 = 0;
                           break;
                        }

                        this.field1706 += var8 * var10;
                        this.field1712 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2221(var1, var9, var6, var3, var4.field1620[this.field1714]);
                        if(this.field1706 < var6) {
                           return;
                        }

                        var10 = (this.field1706 - var5) / var8;
                        if(var10 >= this.field1712) {
                           this.field1706 -= var8 * this.field1712;
                           this.field1712 = 0;
                           break;
                        }

                        this.field1706 -= var8 * var10;
                        this.field1712 -= var10;
                     }
                  }
               }
            }

            if(this.field1707 < 0) {
               this.method2153(var1, var9, 0, var3, 0);
               if(this.field1706 < 0) {
                  this.field1706 = -1;
                  this.method2124();
                  this.unlink();
               }
            } else {
               this.method2221(var1, var9, var7, var3, 0);
               if(this.field1706 >= var7) {
                  this.field1706 = var7;
                  this.method2124();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("bf")
   static int method2134(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10) {
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

      var10.field1706 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bg")
   static int method2135(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class117 var8) {
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

      var8.field1706 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bz")
   static int method2137(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10, int var11, int var12) {
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

      var10.field1706 = var4;
      return var5;
   }

   @ObfuscatedName("bq")
   static int method2138(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
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

      var11.field1706 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bt")
   static int method2139(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10, int var11, int var12) {
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

      var10.field1706 = var4;
      return var5;
   }

   @ObfuscatedName("bb")
   static int method2142(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class117 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1709 += var12.field1717 * (var9 - var4);
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

      var12.field1710 = var5 >> 2;
      var12.field1713 = var6 >> 2;
      var12.field1706 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ba")
   static int method2143(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class117 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1710 += var9.field1711 * (var6 - var3);
      var9.field1713 += var9.field1719 * (var6 - var3);

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

      var9.field1709 = var4 >> 2;
      var9.field1706 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bw")
   static int method2144(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class117 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1709 += var12.field1717 * (var9 - var4);
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

      var12.field1710 = var5 >> 2;
      var12.field1713 = var6 >> 2;
      var12.field1706 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bk")
   static int method2145(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
      var11.field1710 -= var11.field1711 * var5;
      var11.field1713 -= var11.field1719 * var5;
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

      var11.field1710 += var11.field1711 * var5;
      var11.field1713 += var11.field1719 * var5;
      var11.field1709 = var6;
      var11.field1706 = var4;
      return var5;
   }

   @ObfuscatedName("bd")
   static int method2147(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
      var11.field1710 -= var11.field1711 * var5;
      var11.field1713 -= var11.field1719 * var5;
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

      var11.field1710 += var11.field1711 * var5;
      var11.field1713 += var11.field1719 * var5;
      var11.field1709 = var6;
      var11.field1706 = var4;
      return var5;
   }

   @ObfuscatedName("bo")
   int method2153(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1716 > 0) {
            int var6 = var2 + this.field1716;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1716 += var2;
            if(this.field1707 == -256 && (this.field1706 & 255) == 0) {
               if(class275.field3732) {
                  var2 = method2144(0, ((class107)super.field1734).field1620, var1, this.field1706, var2, this.field1710, this.field1713, this.field1711, this.field1719, 0, var6, var3, this);
               } else {
                  var2 = method2143(((class107)super.field1734).field1620, var1, this.field1706, var2, this.field1709, this.field1717, 0, var6, var3, this);
               }
            } else if(class275.field3732) {
               var2 = method2167(0, 0, ((class107)super.field1734).field1620, var1, this.field1706, var2, this.field1710, this.field1713, this.field1711, this.field1719, 0, var6, var3, this, this.field1707, var5);
            } else {
               var2 = method2147(0, 0, ((class107)super.field1734).field1620, var1, this.field1706, var2, this.field1709, this.field1717, 0, var6, var3, this, this.field1707, var5);
            }

            this.field1716 -= var2;
            if(this.field1716 != 0) {
               return var2;
            }

            if(!this.method2255()) {
               continue;
            }

            return var4;
         }

         if(this.field1707 == -256 && (this.field1706 & 255) == 0) {
            if(class275.field3732) {
               return method2154(0, ((class107)super.field1734).field1620, var1, this.field1706, var2, this.field1710, this.field1713, 0, var4, var3, this);
            }

            return method2135(((class107)super.field1734).field1620, var1, this.field1706, var2, this.field1709, 0, var4, var3, this);
         }

         if(class275.field3732) {
            return method2117(0, 0, ((class107)super.field1734).field1620, var1, this.field1706, var2, this.field1710, this.field1713, 0, var4, var3, this, this.field1707, var5);
         }

         return method2139(0, 0, ((class107)super.field1734).field1620, var1, this.field1706, var2, this.field1709, 0, var4, var3, this, this.field1707, var5);
      }
   }

   @ObfuscatedName("bl")
   static int method2154(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10) {
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

      var10.field1706 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("br")
   static int method2164(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class117 var13, int var14, int var15) {
      var13.field1709 -= var13.field1717 * var5;
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
      var13.field1709 += var13.field1717 * var5;
      var13.field1710 = var6;
      var13.field1713 = var7;
      var13.field1706 = var4;
      return var5;
   }

   @ObfuscatedName("bv")
   static int method2167(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class117 var13, int var14, int var15) {
      var13.field1709 -= var13.field1717 * var5;
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
      var13.field1709 += var13.field1717 * var5;
      var13.field1710 = var6;
      var13.field1713 = var7;
      var13.field1706 = var4;
      return var5;
   }

   @ObfuscatedName("ar")
   public synchronized void method2171(int var1, int var2) {
      this.method2119(var1, var2, this.method2114());
   }

   @ObfuscatedName("bs")
   public boolean method2176() {
      return this.field1716 != 0;
   }

   @ObfuscatedName("be")
   int vmethod2273() {
      int var1 = this.field1709 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1712 == 0) {
         var1 -= var1 * this.field1706 / (((class107)super.field1734).field1620.length << 8);
      } else if(this.field1712 >= 0) {
         var1 -= var1 * this.field1714 / ((class107)super.field1734).field1620.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2196() {
      this.field1707 = (this.field1707 ^ this.field1707 >> 31) + (this.field1707 >>> 31);
      this.field1707 = -this.field1707;
   }

   @ObfuscatedName("q")
   synchronized void method2211(int var1, int var2) {
      this.field1708 = var1;
      this.field1705 = var2;
      this.field1716 = 0;
      this.method2108();
   }

   @ObfuscatedName("bu")
   int method2221(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1716 > 0) {
            int var6 = var2 + this.field1716;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1716 += var2;
            if(this.field1707 == 256 && (this.field1706 & 255) == 0) {
               if(class275.field3732) {
                  var2 = method2142(0, ((class107)super.field1734).field1620, var1, this.field1706, var2, this.field1710, this.field1713, this.field1711, this.field1719, 0, var6, var3, this);
               } else {
                  var2 = method2113(((class107)super.field1734).field1620, var1, this.field1706, var2, this.field1709, this.field1717, 0, var6, var3, this);
               }
            } else if(class275.field3732) {
               var2 = method2164(0, 0, ((class107)super.field1734).field1620, var1, this.field1706, var2, this.field1710, this.field1713, this.field1711, this.field1719, 0, var6, var3, this, this.field1707, var5);
            } else {
               var2 = method2145(0, 0, ((class107)super.field1734).field1620, var1, this.field1706, var2, this.field1709, this.field1717, 0, var6, var3, this, this.field1707, var5);
            }

            this.field1716 -= var2;
            if(this.field1716 != 0) {
               return var2;
            }

            if(!this.method2255()) {
               continue;
            }

            return var4;
         }

         if(this.field1707 == 256 && (this.field1706 & 255) == 0) {
            if(class275.field3732) {
               return method2134(0, ((class107)super.field1734).field1620, var1, this.field1706, var2, this.field1710, this.field1713, 0, var4, var3, this);
            }

            return method2232(((class107)super.field1734).field1620, var1, this.field1706, var2, this.field1709, 0, var4, var3, this);
         }

         if(class275.field3732) {
            return method2138(0, 0, ((class107)super.field1734).field1620, var1, this.field1706, var2, this.field1710, this.field1713, 0, var4, var3, this, this.field1707, var5);
         }

         return method2137(0, 0, ((class107)super.field1734).field1620, var1, this.field1706, var2, this.field1709, 0, var4, var3, this, this.field1707, var5);
      }
   }

   @ObfuscatedName("n")
   public synchronized void method2224(int var1) {
      this.field1712 = var1;
   }

   @ObfuscatedName("j")
   public synchronized int method2230() {
      return this.field1708 == Integer.MIN_VALUE?0:this.field1708;
   }

   @ObfuscatedName("bh")
   static int method2232(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class117 var8) {
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

      var8.field1706 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ac")
   public synchronized void method2236(int var1) {
      if(var1 == 0) {
         this.method2111(0);
         this.unlink();
      } else if(this.field1710 == 0 && this.field1713 == 0) {
         this.field1716 = 0;
         this.field1708 = 0;
         this.field1709 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1709;
         if(this.field1709 > var2) {
            var2 = this.field1709;
         }

         if(-this.field1710 > var2) {
            var2 = -this.field1710;
         }

         if(this.field1710 > var2) {
            var2 = this.field1710;
         }

         if(-this.field1713 > var2) {
            var2 = -this.field1713;
         }

         if(this.field1713 > var2) {
            var2 = this.field1713;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1716 = var1;
         this.field1708 = Integer.MIN_VALUE;
         this.field1717 = -this.field1709 / var1;
         this.field1711 = -this.field1710 / var1;
         this.field1719 = -this.field1713 / var1;
      }
   }

   @ObfuscatedName("am")
   public boolean method2239() {
      return this.field1706 < 0 || this.field1706 >= ((class107)super.field1734).field1620.length << 8;
   }

   @ObfuscatedName("a")
   public synchronized void vmethod3862(int var1) {
      if(this.field1716 > 0) {
         if(var1 >= this.field1716) {
            if(this.field1708 == Integer.MIN_VALUE) {
               this.field1708 = 0;
               this.field1713 = 0;
               this.field1710 = 0;
               this.field1709 = 0;
               this.unlink();
               var1 = this.field1716;
            }

            this.field1716 = 0;
            this.method2108();
         } else {
            this.field1709 += this.field1717 * var1;
            this.field1710 += this.field1711 * var1;
            this.field1713 += this.field1719 * var1;
            this.field1716 -= var1;
         }
      }

      class107 var2 = (class107)super.field1734;
      int var3 = this.field1714 << 8;
      int var4 = this.field1718 << 8;
      int var5 = var2.field1620.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1712 = 0;
      }

      if(this.field1706 < 0) {
         if(this.field1707 <= 0) {
            this.method2124();
            this.unlink();
            return;
         }

         this.field1706 = 0;
      }

      if(this.field1706 >= var5) {
         if(this.field1707 >= 0) {
            this.method2124();
            this.unlink();
            return;
         }

         this.field1706 = var5 - 1;
      }

      this.field1706 += this.field1707 * var1;
      if(this.field1712 < 0) {
         if(!this.field1715) {
            if(this.field1707 < 0) {
               if(this.field1706 >= var3) {
                  return;
               }

               this.field1706 = var4 - 1 - (var4 - 1 - this.field1706) % var6;
            } else {
               if(this.field1706 < var4) {
                  return;
               }

               this.field1706 = var3 + (this.field1706 - var3) % var6;
            }

         } else {
            if(this.field1707 < 0) {
               if(this.field1706 >= var3) {
                  return;
               }

               this.field1706 = var3 + var3 - 1 - this.field1706;
               this.field1707 = -this.field1707;
            }

            while(this.field1706 >= var4) {
               this.field1706 = var4 + var4 - 1 - this.field1706;
               this.field1707 = -this.field1707;
               if(this.field1706 >= var3) {
                  return;
               }

               this.field1706 = var3 + var3 - 1 - this.field1706;
               this.field1707 = -this.field1707;
            }

         }
      } else {
         if(this.field1712 > 0) {
            if(this.field1715) {
               label172: {
                  if(this.field1707 < 0) {
                     if(this.field1706 >= var3) {
                        return;
                     }

                     this.field1706 = var3 + var3 - 1 - this.field1706;
                     this.field1707 = -this.field1707;
                     if(--this.field1712 == 0) {
                        break label172;
                     }
                  }

                  do {
                     if(this.field1706 < var4) {
                        return;
                     }

                     this.field1706 = var4 + var4 - 1 - this.field1706;
                     this.field1707 = -this.field1707;
                     if(--this.field1712 == 0) {
                        break;
                     }

                     if(this.field1706 >= var3) {
                        return;
                     }

                     this.field1706 = var3 + var3 - 1 - this.field1706;
                     this.field1707 = -this.field1707;
                  } while(--this.field1712 != 0);
               }
            } else {
               label204: {
                  int var7;
                  if(this.field1707 < 0) {
                     if(this.field1706 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1706) / var6;
                     if(var7 >= this.field1712) {
                        this.field1706 += var6 * this.field1712;
                        this.field1712 = 0;
                        break label204;
                     }

                     this.field1706 += var6 * var7;
                     this.field1712 -= var7;
                  } else {
                     if(this.field1706 < var4) {
                        return;
                     }

                     var7 = (this.field1706 - var3) / var6;
                     if(var7 >= this.field1712) {
                        this.field1706 -= var6 * this.field1712;
                        this.field1712 = 0;
                        break label204;
                     }

                     this.field1706 -= var6 * var7;
                     this.field1712 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1707 < 0) {
            if(this.field1706 < 0) {
               this.field1706 = -1;
               this.method2124();
               this.unlink();
            }
         } else if(this.field1706 >= var5) {
            this.field1706 = var5;
            this.method2124();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("bj")
   boolean method2255() {
      int var1 = this.field1708;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2122(var1, this.field1705);
         var3 = method2104(var1, this.field1705);
      }

      if(this.field1709 == var1 && this.field1710 == var2 && this.field1713 == var3) {
         if(this.field1708 == Integer.MIN_VALUE) {
            this.field1708 = 0;
            this.field1713 = 0;
            this.field1710 = 0;
            this.field1709 = 0;
            this.unlink();
            return true;
         } else {
            this.method2108();
            return false;
         }
      } else {
         if(this.field1709 < var1) {
            this.field1717 = 1;
            this.field1716 = var1 - this.field1709;
         } else if(this.field1709 > var1) {
            this.field1717 = -1;
            this.field1716 = this.field1709 - var1;
         } else {
            this.field1717 = 0;
         }

         if(this.field1710 < var2) {
            this.field1711 = 1;
            if(this.field1716 == 0 || this.field1716 > var2 - this.field1710) {
               this.field1716 = var2 - this.field1710;
            }
         } else if(this.field1710 > var2) {
            this.field1711 = -1;
            if(this.field1716 == 0 || this.field1716 > this.field1710 - var2) {
               this.field1716 = this.field1710 - var2;
            }
         } else {
            this.field1711 = 0;
         }

         if(this.field1713 < var3) {
            this.field1719 = 1;
            if(this.field1716 == 0 || this.field1716 > var3 - this.field1713) {
               this.field1716 = var3 - this.field1713;
            }
         } else if(this.field1713 > var3) {
            this.field1719 = -1;
            if(this.field1716 == 0 || this.field1716 > this.field1713 - var3) {
               this.field1716 = this.field1713 - var3;
            }
         } else {
            this.field1719 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ao")
   public synchronized int method2256() {
      return this.field1707 < 0?-this.field1707:this.field1707;
   }
}
