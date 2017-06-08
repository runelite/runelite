import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
public class class117 extends class119 {
   @ObfuscatedName("o")
   int field1696;
   @ObfuscatedName("f")
   int field1697;
   @ObfuscatedName("n")
   int field1698;
   @ObfuscatedName("j")
   int field1699;
   @ObfuscatedName("x")
   int field1700;
   @ObfuscatedName("m")
   int field1701;
   @ObfuscatedName("c")
   int field1702;
   @ObfuscatedName("z")
   int field1703;
   @ObfuscatedName("i")
   int field1704;
   @ObfuscatedName("g")
   int field1705;
   @ObfuscatedName("e")
   boolean field1706;
   @ObfuscatedName("h")
   int field1707;
   @ObfuscatedName("p")
   int field1708;
   @ObfuscatedName("a")
   int field1709;
   @ObfuscatedName("y")
   int field1710;

   @ObfuscatedName("y")
   public synchronized int method2117() {
      return this.field1704 == Integer.MIN_VALUE?0:this.field1704;
   }

   @ObfuscatedName("p")
   static int method2118(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ag")
   int vmethod2306() {
      int var1 = this.field1697 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1703 == 0) {
         var1 -= var1 * this.field1698 / (((class107)super.field1723).field1613.length << 8);
      } else if(this.field1703 >= 0) {
         var1 -= var1 * this.field1707 / ((class107)super.field1723).field1613.length;
      }

      return var1 > 255?255:var1;
   }

   class117(class107 var1, int var2, int var3, int var4) {
      super.field1723 = var1;
      this.field1707 = var1.field1614;
      this.field1705 = var1.field1612;
      this.field1706 = var1.field1616;
      this.field1708 = var2;
      this.field1704 = var3;
      this.field1699 = var4;
      this.field1698 = 0;
      this.method2123();
   }

   @ObfuscatedName("j")
   public static class117 method2122(class107 var0, int var1, int var2, int var3) {
      return var0.field1613 != null && var0.field1613.length != 0?new class117(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("f")
   void method2123() {
      this.field1697 = this.field1704;
      this.field1701 = method2255(this.field1704, this.field1699);
      this.field1702 = method2118(this.field1704, this.field1699);
   }

   @ObfuscatedName("g")
   public synchronized void method2124(int var1) {
      this.field1703 = var1;
   }

   @ObfuscatedName("o")
   public synchronized void method2125(int var1) {
      this.method2243(var1 << 6, this.method2144());
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method2126(int var1) {
      this.method2243(var1, this.method2144());
   }

   @ObfuscatedName("bv")
   static int method2128(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
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

      var11.field1698 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("b")
   public synchronized void method2130(int var1) {
      int var2 = ((class107)super.field1723).field1613.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1698 = var1;
   }

   @ObfuscatedName("v")
   void method2131() {
      if(this.field1696 != 0) {
         if(this.field1704 == Integer.MIN_VALUE) {
            this.field1704 = 0;
         }

         this.field1696 = 0;
         this.method2123();
      }

   }

   @ObfuscatedName("ac")
   public boolean method2132() {
      return this.field1696 != 0;
   }

   @ObfuscatedName("t")
   public synchronized void method2133(int var1, int var2) {
      this.method2134(var1, var2, this.method2144());
   }

   @ObfuscatedName("w")
   public synchronized void method2134(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2243(var2, var3);
      } else {
         int var4 = method2255(var2, var3);
         int var5 = method2118(var2, var3);
         if(this.field1701 == var4 && this.field1702 == var5) {
            this.field1696 = 0;
         } else {
            int var6 = var2 - this.field1697;
            if(this.field1697 - var2 > var6) {
               var6 = this.field1697 - var2;
            }

            if(var4 - this.field1701 > var6) {
               var6 = var4 - this.field1701;
            }

            if(this.field1701 - var4 > var6) {
               var6 = this.field1701 - var4;
            }

            if(var5 - this.field1702 > var6) {
               var6 = var5 - this.field1702;
            }

            if(this.field1702 - var5 > var6) {
               var6 = this.field1702 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1696 = var1;
            this.field1704 = var2;
            this.field1699 = var3;
            this.field1700 = (var2 - this.field1697) / var1;
            this.field1709 = (var4 - this.field1701) / var1;
            this.field1710 = (var5 - this.field1702) / var1;
         }
      }
   }

   @ObfuscatedName("u")
   public synchronized void method2135(int var1) {
      if(var1 == 0) {
         this.method2126(0);
         this.unlink();
      } else if(this.field1701 == 0 && this.field1702 == 0) {
         this.field1696 = 0;
         this.field1704 = 0;
         this.field1697 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1697;
         if(this.field1697 > var2) {
            var2 = this.field1697;
         }

         if(-this.field1701 > var2) {
            var2 = -this.field1701;
         }

         if(this.field1701 > var2) {
            var2 = this.field1701;
         }

         if(-this.field1702 > var2) {
            var2 = -this.field1702;
         }

         if(this.field1702 > var2) {
            var2 = this.field1702;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1696 = var1;
         this.field1704 = Integer.MIN_VALUE;
         this.field1700 = -this.field1697 / var1;
         this.field1709 = -this.field1701 / var1;
         this.field1710 = -this.field1702 / var1;
      }
   }

   @ObfuscatedName("c")
   protected class119 vmethod3907() {
      return null;
   }

   @ObfuscatedName("z")
   protected int vmethod3908() {
      return this.field1704 == 0 && this.field1696 == 0?0:1;
   }

   @ObfuscatedName("h")
   public synchronized void vmethod3909(int[] var1, int var2, int var3) {
      if(this.field1704 == 0 && this.field1696 == 0) {
         this.vmethod3910(var3);
      } else {
         class107 var4 = (class107)super.field1723;
         int var5 = this.field1707 << 8;
         int var6 = this.field1705 << 8;
         int var7 = var4.field1613.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1703 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1698 < 0) {
            if(this.field1708 <= 0) {
               this.method2131();
               this.unlink();
               return;
            }

            this.field1698 = 0;
         }

         if(this.field1698 >= var7) {
            if(this.field1708 >= 0) {
               this.method2131();
               this.unlink();
               return;
            }

            this.field1698 = var7 - 1;
         }

         if(this.field1703 < 0) {
            if(this.field1706) {
               if(this.field1708 < 0) {
                  var9 = this.method2146(var1, var2, var5, var3, var4.field1613[this.field1707]);
                  if(this.field1698 >= var5) {
                     return;
                  }

                  this.field1698 = var5 + var5 - 1 - this.field1698;
                  this.field1708 = -this.field1708;
               }

               while(true) {
                  var9 = this.method2145(var1, var9, var6, var3, var4.field1613[this.field1705 - 1]);
                  if(this.field1698 < var6) {
                     return;
                  }

                  this.field1698 = var6 + var6 - 1 - this.field1698;
                  this.field1708 = -this.field1708;
                  var9 = this.method2146(var1, var9, var5, var3, var4.field1613[this.field1707]);
                  if(this.field1698 >= var5) {
                     return;
                  }

                  this.field1698 = var5 + var5 - 1 - this.field1698;
                  this.field1708 = -this.field1708;
               }
            } else if(this.field1708 < 0) {
               while(true) {
                  var9 = this.method2146(var1, var9, var5, var3, var4.field1613[this.field1705 - 1]);
                  if(this.field1698 >= var5) {
                     return;
                  }

                  this.field1698 = var6 - 1 - (var6 - 1 - this.field1698) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2145(var1, var9, var6, var3, var4.field1613[this.field1707]);
                  if(this.field1698 < var6) {
                     return;
                  }

                  this.field1698 = var5 + (this.field1698 - var5) % var8;
               }
            }
         } else {
            if(this.field1703 > 0) {
               if(this.field1706) {
                  label184: {
                     if(this.field1708 < 0) {
                        var9 = this.method2146(var1, var2, var5, var3, var4.field1613[this.field1707]);
                        if(this.field1698 >= var5) {
                           return;
                        }

                        this.field1698 = var5 + var5 - 1 - this.field1698;
                        this.field1708 = -this.field1708;
                        if(--this.field1703 == 0) {
                           break label184;
                        }
                     }

                     do {
                        var9 = this.method2145(var1, var9, var6, var3, var4.field1613[this.field1705 - 1]);
                        if(this.field1698 < var6) {
                           return;
                        }

                        this.field1698 = var6 + var6 - 1 - this.field1698;
                        this.field1708 = -this.field1708;
                        if(--this.field1703 == 0) {
                           break;
                        }

                        var9 = this.method2146(var1, var9, var5, var3, var4.field1613[this.field1707]);
                        if(this.field1698 >= var5) {
                           return;
                        }

                        this.field1698 = var5 + var5 - 1 - this.field1698;
                        this.field1708 = -this.field1708;
                     } while(--this.field1703 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1708 < 0) {
                     while(true) {
                        var9 = this.method2146(var1, var9, var5, var3, var4.field1613[this.field1705 - 1]);
                        if(this.field1698 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1698) / var8;
                        if(var10 >= this.field1703) {
                           this.field1698 += var8 * this.field1703;
                           this.field1703 = 0;
                           break;
                        }

                        this.field1698 += var8 * var10;
                        this.field1703 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2145(var1, var9, var6, var3, var4.field1613[this.field1707]);
                        if(this.field1698 < var6) {
                           return;
                        }

                        var10 = (this.field1698 - var5) / var8;
                        if(var10 >= this.field1703) {
                           this.field1698 -= var8 * this.field1703;
                           this.field1703 = 0;
                           break;
                        }

                        this.field1698 -= var8 * var10;
                        this.field1703 -= var10;
                     }
                  }
               }
            }

            if(this.field1708 < 0) {
               this.method2146(var1, var9, 0, var3, 0);
               if(this.field1698 < 0) {
                  this.field1698 = -1;
                  this.method2131();
                  this.unlink();
               }
            } else {
               this.method2145(var1, var9, var7, var3, 0);
               if(this.field1698 >= var7) {
                  this.field1698 = var7;
                  this.method2131();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("r")
   public synchronized int method2144() {
      return this.field1699 < 0?-1:this.field1699;
   }

   @ObfuscatedName("aq")
   int method2145(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1696 > 0) {
            int var6 = var2 + this.field1696;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1696 += var2;
            if(this.field1708 == 256 && (this.field1698 & 255) == 0) {
               if(class109.field1630) {
                  var2 = method2157(0, ((class107)super.field1723).field1613, var1, this.field1698, var2, this.field1701, this.field1702, this.field1709, this.field1710, 0, var6, var3, this);
               } else {
                  var2 = method2156(((class107)super.field1723).field1613, var1, this.field1698, var2, this.field1697, this.field1700, 0, var6, var3, this);
               }
            } else if(class109.field1630) {
               var2 = method2161(0, 0, ((class107)super.field1723).field1613, var1, this.field1698, var2, this.field1701, this.field1702, this.field1709, this.field1710, 0, var6, var3, this, this.field1708, var5);
            } else {
               var2 = method2240(0, 0, ((class107)super.field1723).field1613, var1, this.field1698, var2, this.field1697, this.field1700, 0, var6, var3, this, this.field1708, var5);
            }

            this.field1696 -= var2;
            if(this.field1696 != 0) {
               return var2;
            }

            if(!this.method2147()) {
               continue;
            }

            return var4;
         }

         if(this.field1708 == 256 && (this.field1698 & 255) == 0) {
            if(class109.field1630) {
               return method2160(0, ((class107)super.field1723).field1613, var1, this.field1698, var2, this.field1701, this.field1702, 0, var4, var3, this);
            }

            return method2158(((class107)super.field1723).field1613, var1, this.field1698, var2, this.field1697, 0, var4, var3, this);
         }

         if(class109.field1630) {
            return method2128(0, 0, ((class107)super.field1723).field1613, var1, this.field1698, var2, this.field1701, this.field1702, 0, var4, var3, this, this.field1708, var5);
         }

         return method2238(0, 0, ((class107)super.field1723).field1613, var1, this.field1698, var2, this.field1697, 0, var4, var3, this, this.field1708, var5);
      }
   }

   @ObfuscatedName("af")
   int method2146(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1696 > 0) {
            int var6 = var2 + this.field1696;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1696 += var2;
            if(this.field1708 == -256 && (this.field1698 & 255) == 0) {
               if(class109.field1630) {
                  var2 = method2195(0, ((class107)super.field1723).field1613, var1, this.field1698, var2, this.field1701, this.field1702, this.field1709, this.field1710, 0, var6, var3, this);
               } else {
                  var2 = method2176(((class107)super.field1723).field1613, var1, this.field1698, var2, this.field1697, this.field1700, 0, var6, var3, this);
               }
            } else if(class109.field1630) {
               var2 = method2223(0, 0, ((class107)super.field1723).field1613, var1, this.field1698, var2, this.field1701, this.field1702, this.field1709, this.field1710, 0, var6, var3, this, this.field1708, var5);
            } else {
               var2 = method2197(0, 0, ((class107)super.field1723).field1613, var1, this.field1698, var2, this.field1697, this.field1700, 0, var6, var3, this, this.field1708, var5);
            }

            this.field1696 -= var2;
            if(this.field1696 != 0) {
               return var2;
            }

            if(!this.method2147()) {
               continue;
            }

            return var4;
         }

         if(this.field1708 == -256 && (this.field1698 & 255) == 0) {
            if(class109.field1630) {
               return method2151(0, ((class107)super.field1723).field1613, var1, this.field1698, var2, this.field1701, this.field1702, 0, var4, var3, this);
            }

            return method2150(((class107)super.field1723).field1613, var1, this.field1698, var2, this.field1697, 0, var4, var3, this);
         }

         if(class109.field1630) {
            return method2155(0, 0, ((class107)super.field1723).field1613, var1, this.field1698, var2, this.field1701, this.field1702, 0, var4, var3, this, this.field1708, var5);
         }

         return method2154(0, 0, ((class107)super.field1723).field1613, var1, this.field1698, var2, this.field1697, 0, var4, var3, this, this.field1708, var5);
      }
   }

   @ObfuscatedName("ar")
   boolean method2147() {
      int var1 = this.field1704;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2255(var1, this.field1699);
         var3 = method2118(var1, this.field1699);
      }

      if(this.field1697 == var1 && this.field1701 == var2 && this.field1702 == var3) {
         if(this.field1704 == Integer.MIN_VALUE) {
            this.field1704 = 0;
            this.field1702 = 0;
            this.field1701 = 0;
            this.field1697 = 0;
            this.unlink();
            return true;
         } else {
            this.method2123();
            return false;
         }
      } else {
         if(this.field1697 < var1) {
            this.field1700 = 1;
            this.field1696 = var1 - this.field1697;
         } else if(this.field1697 > var1) {
            this.field1700 = -1;
            this.field1696 = this.field1697 - var1;
         } else {
            this.field1700 = 0;
         }

         if(this.field1701 < var2) {
            this.field1709 = 1;
            if(this.field1696 == 0 || this.field1696 > var2 - this.field1701) {
               this.field1696 = var2 - this.field1701;
            }
         } else if(this.field1701 > var2) {
            this.field1709 = -1;
            if(this.field1696 == 0 || this.field1696 > this.field1701 - var2) {
               this.field1696 = this.field1701 - var2;
            }
         } else {
            this.field1709 = 0;
         }

         if(this.field1702 < var3) {
            this.field1710 = 1;
            if(this.field1696 == 0 || this.field1696 > var3 - this.field1702) {
               this.field1696 = var3 - this.field1702;
            }
         } else if(this.field1702 > var3) {
            this.field1710 = -1;
            if(this.field1696 == 0 || this.field1696 > this.field1702 - var3) {
               this.field1696 = this.field1702 - var3;
            }
         } else {
            this.field1710 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ap")
   static int method2150(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class117 var8) {
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

      var8.field1698 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ai")
   static int method2151(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10) {
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

      var10.field1698 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bd")
   static int method2154(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10, int var11, int var12) {
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

      var10.field1698 = var4;
      return var5;
   }

   @ObfuscatedName("bc")
   static int method2155(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
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

      var11.field1698 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bj")
   static int method2156(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class117 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1701 += var9.field1709 * (var6 - var3);
      var9.field1702 += var9.field1710 * (var6 - var3);

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

      var9.field1697 = var4 >> 2;
      var9.field1698 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bx")
   static int method2157(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class117 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.field1697 += var12.field1700 * (var9 - var4);
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

      var12.field1701 = var5 >> 2;
      var12.field1702 = var6 >> 2;
      var12.field1698 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("aj")
   static int method2158(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class117 var8) {
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

      var8.field1698 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ay")
   static int method2160(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10) {
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

      var10.field1698 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bm")
   static int method2161(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class117 var13, int var14, int var15) {
      var13.field1697 -= var13.field1700 * var5;
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
      var13.field1697 += var13.field1700 * var5;
      var13.field1701 = var6;
      var13.field1702 = var7;
      var13.field1698 = var4;
      return var5;
   }

   @ObfuscatedName("i")
   public static class117 method2162(class107 var0, int var1, int var2) {
      return var0.field1613 != null && var0.field1613.length != 0?new class117(var0, (int)((long)var0.field1615 * 256L * (long)var1 / (long)(class109.field1633 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("bf")
   static int method2176(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class117 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1701 += var9.field1709 * (var6 - var3);
      var9.field1702 += var9.field1710 * (var6 - var3);

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

      var9.field1697 = var4 >> 2;
      var9.field1698 = var2 << 8;
      return var3;
   }

   class117(class107 var1, int var2, int var3) {
      super.field1723 = var1;
      this.field1707 = var1.field1614;
      this.field1705 = var1.field1612;
      this.field1706 = var1.field1616;
      this.field1708 = var2;
      this.field1704 = var3;
      this.field1699 = 8192;
      this.field1698 = 0;
      this.method2123();
   }

   @ObfuscatedName("aw")
   public synchronized int method2193() {
      return this.field1708 < 0?-this.field1708:this.field1708;
   }

   @ObfuscatedName("bn")
   static int method2195(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class117 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1697 += var12.field1700 * (var9 - var4);
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

      var12.field1701 = var5 >> 2;
      var12.field1702 = var6 >> 2;
      var12.field1698 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bs")
   static int method2197(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
      var11.field1701 -= var11.field1709 * var5;
      var11.field1702 -= var11.field1710 * var5;
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

      var11.field1701 += var11.field1709 * var5;
      var11.field1702 += var11.field1710 * var5;
      var11.field1697 = var6;
      var11.field1698 = var4;
      return var5;
   }

   @ObfuscatedName("bo")
   static int method2223(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class117 var13, int var14, int var15) {
      var13.field1697 -= var13.field1700 * var5;
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
      var13.field1697 += var13.field1700 * var5;
      var13.field1701 = var6;
      var13.field1702 = var7;
      var13.field1698 = var4;
      return var5;
   }

   @ObfuscatedName("am")
   public boolean method2237() {
      return this.field1698 < 0 || this.field1698 >= ((class107)super.field1723).field1613.length << 8;
   }

   @ObfuscatedName("az")
   static int method2238(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10, int var11, int var12) {
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

      var10.field1698 = var4;
      return var5;
   }

   @ObfuscatedName("bh")
   static int method2240(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
      var11.field1701 -= var11.field1709 * var5;
      var11.field1702 -= var11.field1710 * var5;
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

      var11.field1701 += var11.field1709 * var5;
      var11.field1702 += var11.field1710 * var5;
      var11.field1697 = var6;
      var11.field1698 = var4;
      return var5;
   }

   @ObfuscatedName("a")
   synchronized void method2243(int var1, int var2) {
      this.field1704 = var1;
      this.field1699 = var2;
      this.field1696 = 0;
      this.method2123();
   }

   @ObfuscatedName("e")
   public synchronized void vmethod3910(int var1) {
      if(this.field1696 > 0) {
         if(var1 >= this.field1696) {
            if(this.field1704 == Integer.MIN_VALUE) {
               this.field1704 = 0;
               this.field1702 = 0;
               this.field1701 = 0;
               this.field1697 = 0;
               this.unlink();
               var1 = this.field1696;
            }

            this.field1696 = 0;
            this.method2123();
         } else {
            this.field1697 += this.field1700 * var1;
            this.field1701 += this.field1709 * var1;
            this.field1702 += this.field1710 * var1;
            this.field1696 -= var1;
         }
      }

      class107 var2 = (class107)super.field1723;
      int var3 = this.field1707 << 8;
      int var4 = this.field1705 << 8;
      int var5 = var2.field1613.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1703 = 0;
      }

      if(this.field1698 < 0) {
         if(this.field1708 <= 0) {
            this.method2131();
            this.unlink();
            return;
         }

         this.field1698 = 0;
      }

      if(this.field1698 >= var5) {
         if(this.field1708 >= 0) {
            this.method2131();
            this.unlink();
            return;
         }

         this.field1698 = var5 - 1;
      }

      this.field1698 += this.field1708 * var1;
      if(this.field1703 < 0) {
         if(!this.field1706) {
            if(this.field1708 < 0) {
               if(this.field1698 >= var3) {
                  return;
               }

               this.field1698 = var4 - 1 - (var4 - 1 - this.field1698) % var6;
            } else {
               if(this.field1698 < var4) {
                  return;
               }

               this.field1698 = var3 + (this.field1698 - var3) % var6;
            }

         } else {
            if(this.field1708 < 0) {
               if(this.field1698 >= var3) {
                  return;
               }

               this.field1698 = var3 + var3 - 1 - this.field1698;
               this.field1708 = -this.field1708;
            }

            while(this.field1698 >= var4) {
               this.field1698 = var4 + var4 - 1 - this.field1698;
               this.field1708 = -this.field1708;
               if(this.field1698 >= var3) {
                  return;
               }

               this.field1698 = var3 + var3 - 1 - this.field1698;
               this.field1708 = -this.field1708;
            }

         }
      } else {
         if(this.field1703 > 0) {
            if(this.field1706) {
               label172: {
                  if(this.field1708 < 0) {
                     if(this.field1698 >= var3) {
                        return;
                     }

                     this.field1698 = var3 + var3 - 1 - this.field1698;
                     this.field1708 = -this.field1708;
                     if(--this.field1703 == 0) {
                        break label172;
                     }
                  }

                  do {
                     if(this.field1698 < var4) {
                        return;
                     }

                     this.field1698 = var4 + var4 - 1 - this.field1698;
                     this.field1708 = -this.field1708;
                     if(--this.field1703 == 0) {
                        break;
                     }

                     if(this.field1698 >= var3) {
                        return;
                     }

                     this.field1698 = var3 + var3 - 1 - this.field1698;
                     this.field1708 = -this.field1708;
                  } while(--this.field1703 != 0);
               }
            } else {
               label204: {
                  int var7;
                  if(this.field1708 < 0) {
                     if(this.field1698 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1698) / var6;
                     if(var7 >= this.field1703) {
                        this.field1698 += var6 * this.field1703;
                        this.field1703 = 0;
                        break label204;
                     }

                     this.field1698 += var6 * var7;
                     this.field1703 -= var7;
                  } else {
                     if(this.field1698 < var4) {
                        return;
                     }

                     var7 = (this.field1698 - var3) / var6;
                     if(var7 >= this.field1703) {
                        this.field1698 -= var6 * this.field1703;
                        this.field1703 = 0;
                        break label204;
                     }

                     this.field1698 -= var6 * var7;
                     this.field1703 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1708 < 0) {
            if(this.field1698 < 0) {
               this.field1698 = -1;
               this.method2131();
               this.unlink();
            }
         } else if(this.field1698 >= var5) {
            this.field1698 = var5;
            this.method2131();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("n")
   static int method2255(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("m")
   protected class119 vmethod3906() {
      return null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2264() {
      this.field1708 = (this.field1708 ^ this.field1708 >> 31) + (this.field1708 >>> 31);
      this.field1708 = -this.field1708;
   }

   @ObfuscatedName("aa")
   public synchronized void method2266(int var1) {
      if(this.field1708 < 0) {
         this.field1708 = -var1;
      } else {
         this.field1708 = var1;
      }

   }
}
