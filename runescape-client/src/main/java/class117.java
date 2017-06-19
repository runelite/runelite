import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public class class117 extends class119 {
   @ObfuscatedName("o")
   int field1688;
   @ObfuscatedName("m")
   int field1689;
   @ObfuscatedName("e")
   int field1690;
   @ObfuscatedName("t")
   int field1691;
   @ObfuscatedName("i")
   int field1692;
   @ObfuscatedName("n")
   int field1693;
   @ObfuscatedName("j")
   int field1694;
   @ObfuscatedName("p")
   int field1695;
   @ObfuscatedName("c")
   int field1696;
   @ObfuscatedName("f")
   int field1697;
   @ObfuscatedName("q")
   boolean field1698;
   @ObfuscatedName("v")
   int field1699;
   @ObfuscatedName("a")
   int field1700;
   @ObfuscatedName("g")
   int field1701;
   @ObfuscatedName("z")
   int field1702;

   @ObfuscatedName("m")
   static int method2034(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("e")
   public static class117 method2038(class107 var0, int var1, int var2) {
      return var0.field1605 != null && var0.field1605.length != 0?new class117(var0, (int)((long)var0.field1604 * 256L * (long)var1 / (long)(class109.field1635 * 100)), var2 << 6):null;
   }

   @ObfuscatedName("t")
   public static class117 method2039(class107 var0, int var1, int var2, int var3) {
      return var0.field1605 != null && var0.field1605.length != 0?new class117(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("w")
   void method2040() {
      this.field1702 = this.field1690;
      this.field1694 = method2125(this.field1690, this.field1691);
      this.field1692 = method2034(this.field1690, this.field1691);
   }

   @ObfuscatedName("a")
   public synchronized void method2042(int var1) {
      this.method2044(var1 << 6, this.method2046());
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method2043(int var1) {
      this.method2044(var1, this.method2046());
   }

   @ObfuscatedName("v")
   synchronized void method2044(int var1, int var2) {
      this.field1690 = var1;
      this.field1691 = var2;
      this.field1693 = 0;
      this.method2040();
   }

   @ObfuscatedName("k")
   public synchronized int method2046() {
      return this.field1691 < 0?-1:this.field1691;
   }

   @ObfuscatedName("r")
   public synchronized void method2047(int var1) {
      int var2 = ((class107)super.field1717).field1605.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1695 = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2048() {
      this.field1689 = (this.field1689 ^ this.field1689 >> 31) + (this.field1689 >>> 31);
      this.field1689 = -this.field1689;
   }

   @ObfuscatedName("d")
   void method2049() {
      if(this.field1693 != 0) {
         if(this.field1690 == Integer.MIN_VALUE) {
            this.field1690 = 0;
         }

         this.field1693 = 0;
         this.method2040();
      }

   }

   @ObfuscatedName("x")
   public synchronized void method2050(int var1, int var2) {
      this.method2051(var1, var2, this.method2046());
   }

   @ObfuscatedName("b")
   public synchronized void method2051(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2044(var2, var3);
      } else {
         int var4 = method2125(var2, var3);
         int var5 = method2034(var2, var3);
         if(this.field1694 == var4 && var5 == this.field1692) {
            this.field1693 = 0;
         } else {
            int var6 = var2 - this.field1702;
            if(this.field1702 - var2 > var6) {
               var6 = this.field1702 - var2;
            }

            if(var4 - this.field1694 > var6) {
               var6 = var4 - this.field1694;
            }

            if(this.field1694 - var4 > var6) {
               var6 = this.field1694 - var4;
            }

            if(var5 - this.field1692 > var6) {
               var6 = var5 - this.field1692;
            }

            if(this.field1692 - var5 > var6) {
               var6 = this.field1692 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1693 = var1;
            this.field1690 = var2;
            this.field1691 = var3;
            this.field1700 = (var2 - this.field1702) / var1;
            this.field1701 = (var4 - this.field1694) / var1;
            this.field1699 = (var5 - this.field1692) / var1;
         }
      }

   }

   @ObfuscatedName("y")
   public synchronized void method2052(int var1) {
      if(var1 == 0) {
         this.method2043(0);
         this.unlink();
      } else if(this.field1694 == 0 && this.field1692 == 0) {
         this.field1693 = 0;
         this.field1690 = 0;
         this.field1702 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1702;
         if(this.field1702 > var2) {
            var2 = this.field1702;
         }

         if(-this.field1694 > var2) {
            var2 = -this.field1694;
         }

         if(this.field1694 > var2) {
            var2 = this.field1694;
         }

         if(-this.field1692 > var2) {
            var2 = -this.field1692;
         }

         if(this.field1692 > var2) {
            var2 = this.field1692;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1693 = var1;
         this.field1690 = Integer.MIN_VALUE;
         this.field1700 = -this.field1702 / var1;
         this.field1701 = -this.field1694 / var1;
         this.field1699 = -this.field1692 / var1;
      }

   }

   @ObfuscatedName("ar")
   public boolean method2055() {
      return this.field1695 < 0 || this.field1695 >= ((class107)super.field1717).field1605.length << 8;
   }

   @ObfuscatedName("az")
   boolean method2056() {
      int var1 = this.field1690;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2125(var1, this.field1691);
         var3 = method2034(var1, this.field1691);
      }

      if(this.field1702 == var1 && var2 == this.field1694 && var3 == this.field1692) {
         if(this.field1690 == Integer.MIN_VALUE) {
            this.field1690 = 0;
            this.field1692 = 0;
            this.field1694 = 0;
            this.field1702 = 0;
            this.unlink();
            return true;
         } else {
            this.method2040();
            return false;
         }
      } else {
         if(this.field1702 < var1) {
            this.field1700 = 1;
            this.field1693 = var1 - this.field1702;
         } else if(this.field1702 > var1) {
            this.field1700 = -1;
            this.field1693 = this.field1702 - var1;
         } else {
            this.field1700 = 0;
         }

         if(this.field1694 < var2) {
            this.field1701 = 1;
            if(this.field1693 == 0 || this.field1693 > var2 - this.field1694) {
               this.field1693 = var2 - this.field1694;
            }
         } else if(this.field1694 > var2) {
            this.field1701 = -1;
            if(this.field1693 == 0 || this.field1693 > this.field1694 - var2) {
               this.field1693 = this.field1694 - var2;
            }
         } else {
            this.field1701 = 0;
         }

         if(this.field1692 < var3) {
            this.field1699 = 1;
            if(this.field1693 == 0 || this.field1693 > var3 - this.field1692) {
               this.field1693 = var3 - this.field1692;
            }
         } else if(this.field1692 > var3) {
            this.field1699 = -1;
            if(this.field1693 == 0 || this.field1693 > this.field1692 - var3) {
               this.field1693 = this.field1692 - var3;
            }
         } else {
            this.field1699 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("z")
   protected class119 vmethod3771() {
      return null;
   }

   @ObfuscatedName("j")
   protected class119 vmethod3780() {
      return null;
   }

   @ObfuscatedName("c")
   protected int vmethod3772() {
      return this.field1690 == 0 && this.field1693 == 0?0:1;
   }

   @ObfuscatedName("o")
   public synchronized void vmethod3775(int[] var1, int var2, int var3) {
      if(this.field1690 == 0 && this.field1693 == 0) {
         this.vmethod3773(var3);
      } else {
         class107 var4 = (class107)super.field1717;
         int var5 = this.field1696 << 8;
         int var6 = this.field1688 << 8;
         int var7 = var4.field1605.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1697 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1695 < 0) {
            if(this.field1689 <= 0) {
               this.method2049();
               this.unlink();
               return;
            }

            this.field1695 = 0;
         }

         if(this.field1695 >= var7) {
            if(this.field1689 >= 0) {
               this.method2049();
               this.unlink();
               return;
            }

            this.field1695 = var7 - 1;
         }

         if(this.field1697 < 0) {
            if(this.field1698) {
               if(this.field1689 < 0) {
                  var9 = this.method2063(var1, var2, var5, var3, var4.field1605[this.field1696]);
                  if(this.field1695 >= var5) {
                     return;
                  }

                  this.field1695 = var5 + var5 - 1 - this.field1695;
                  this.field1689 = -this.field1689;
               }

               while(true) {
                  var9 = this.method2062(var1, var9, var6, var3, var4.field1605[this.field1688 - 1]);
                  if(this.field1695 < var6) {
                     return;
                  }

                  this.field1695 = var6 + var6 - 1 - this.field1695;
                  this.field1689 = -this.field1689;
                  var9 = this.method2063(var1, var9, var5, var3, var4.field1605[this.field1696]);
                  if(this.field1695 >= var5) {
                     return;
                  }

                  this.field1695 = var5 + var5 - 1 - this.field1695;
                  this.field1689 = -this.field1689;
               }
            }

            if(this.field1689 < 0) {
               while(true) {
                  var9 = this.method2063(var1, var9, var5, var3, var4.field1605[this.field1688 - 1]);
                  if(this.field1695 >= var5) {
                     return;
                  }

                  this.field1695 = var6 - 1 - (var6 - 1 - this.field1695) % var8;
               }
            }

            while(true) {
               var9 = this.method2062(var1, var9, var6, var3, var4.field1605[this.field1696]);
               if(this.field1695 < var6) {
                  return;
               }

               this.field1695 = var5 + (this.field1695 - var5) % var8;
            }
         }

         if(this.field1697 > 0) {
            if(this.field1698) {
               label118: {
                  if(this.field1689 < 0) {
                     var9 = this.method2063(var1, var2, var5, var3, var4.field1605[this.field1696]);
                     if(this.field1695 >= var5) {
                        return;
                     }

                     this.field1695 = var5 + var5 - 1 - this.field1695;
                     this.field1689 = -this.field1689;
                     if(--this.field1697 == 0) {
                        break label118;
                     }
                  }

                  do {
                     var9 = this.method2062(var1, var9, var6, var3, var4.field1605[this.field1688 - 1]);
                     if(this.field1695 < var6) {
                        return;
                     }

                     this.field1695 = var6 + var6 - 1 - this.field1695;
                     this.field1689 = -this.field1689;
                     if(--this.field1697 == 0) {
                        break;
                     }

                     var9 = this.method2063(var1, var9, var5, var3, var4.field1605[this.field1696]);
                     if(this.field1695 >= var5) {
                        return;
                     }

                     this.field1695 = var5 + var5 - 1 - this.field1695;
                     this.field1689 = -this.field1689;
                  } while(--this.field1697 != 0);
               }
            } else {
               int var10;
               if(this.field1689 < 0) {
                  while(true) {
                     var9 = this.method2063(var1, var9, var5, var3, var4.field1605[this.field1688 - 1]);
                     if(this.field1695 >= var5) {
                        return;
                     }

                     var10 = (var6 - 1 - this.field1695) / var8;
                     if(var10 >= this.field1697) {
                        this.field1695 += var8 * this.field1697;
                        this.field1697 = 0;
                        break;
                     }

                     this.field1695 += var10 * var8;
                     this.field1697 -= var10;
                  }
               } else {
                  while(true) {
                     var9 = this.method2062(var1, var9, var6, var3, var4.field1605[this.field1696]);
                     if(this.field1695 < var6) {
                        return;
                     }

                     var10 = (this.field1695 - var5) / var8;
                     if(var10 >= this.field1697) {
                        this.field1695 -= var8 * this.field1697;
                        this.field1697 = 0;
                        break;
                     }

                     this.field1695 -= var10 * var8;
                     this.field1697 -= var10;
                  }
               }
            }
         }

         if(this.field1689 < 0) {
            this.method2063(var1, var9, 0, var3, 0);
            if(this.field1695 < 0) {
               this.field1695 = -1;
               this.method2049();
               this.unlink();
            }
         } else {
            this.method2062(var1, var9, var7, var3, 0);
            if(this.field1695 >= var7) {
               this.field1695 = var7;
               this.method2049();
               this.unlink();
            }
         }
      }

   }

   @ObfuscatedName("bp")
   static int method2061(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
      var11.field1694 -= var11.field1701 * var5;
      var11.field1692 -= var11.field1699 * var5;
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      byte var14;
      int var15;
      while(var5 < var8) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var15 = var5++;
         var3[var15] += ((var2[var1 + 1] - var14) * (var4 & 255) + (var14 << 8)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      for(var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var15 = var5++;
         var3[var15] += ((var1 - var14) * (var4 & 255) + (var14 << 8)) * var6 >> 6;
         var6 += var7;
      }

      var11.field1694 += var11.field1701 * var5;
      var11.field1692 += var11.field1699 * var5;
      var11.field1702 = var6;
      var11.field1695 = var4;
      return var5;
   }

   @ObfuscatedName("ac")
   int method2062(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1693 > 0) {
            int var6 = var2 + this.field1693;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1693 += var2;
            if(this.field1689 == 256 && (this.field1695 & 255) == 0) {
               if(class222.field2849) {
                  var2 = method2073(0, ((class107)super.field1717).field1605, var1, this.field1695, var2, this.field1694, this.field1692, this.field1701, this.field1699, 0, var6, var3, this);
               } else {
                  var2 = method2100(((class107)super.field1717).field1605, var1, this.field1695, var2, this.field1702, this.field1700, 0, var6, var3, this);
               }
            } else if(class222.field2849) {
               var2 = method2077(0, 0, ((class107)super.field1717).field1605, var1, this.field1695, var2, this.field1694, this.field1692, this.field1701, this.field1699, 0, var6, var3, this, this.field1689, var5);
            } else {
               var2 = method2061(0, 0, ((class107)super.field1717).field1605, var1, this.field1695, var2, this.field1702, this.field1700, 0, var6, var3, this, this.field1689, var5);
            }

            this.field1693 -= var2;
            if(this.field1693 != 0) {
               return var2;
            }

            if(!this.method2056()) {
               continue;
            }

            return var4;
         }

         if(this.field1689 == 256 && (this.field1695 & 255) == 0) {
            if(class222.field2849) {
               return method2088(0, ((class107)super.field1717).field1605, var1, this.field1695, var2, this.field1694, this.field1692, 0, var4, var3, this);
            }

            return method2065(((class107)super.field1717).field1605, var1, this.field1695, var2, this.field1702, 0, var4, var3, this);
         }

         if(class222.field2849) {
            return method2154(0, 0, ((class107)super.field1717).field1605, var1, this.field1695, var2, this.field1694, this.field1692, 0, var4, var3, this, this.field1689, var5);
         }

         return method2064(0, 0, ((class107)super.field1717).field1605, var1, this.field1695, var2, this.field1702, 0, var4, var3, this, this.field1689, var5);
      }
   }

   @ObfuscatedName("as")
   int method2063(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1693 > 0) {
            int var6 = var2 + this.field1693;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1693 += var2;
            if(this.field1689 == -256 && (this.field1695 & 255) == 0) {
               if(class222.field2849) {
                  var2 = method2075(0, ((class107)super.field1717).field1605, var1, this.field1695, var2, this.field1694, this.field1692, this.field1701, this.field1699, 0, var6, var3, this);
               } else {
                  var2 = method2074(((class107)super.field1717).field1605, var1, this.field1695, var2, this.field1702, this.field1700, 0, var6, var3, this);
               }
            } else if(class222.field2849) {
               var2 = method2079(0, 0, ((class107)super.field1717).field1605, var1, this.field1695, var2, this.field1694, this.field1692, this.field1701, this.field1699, 0, var6, var3, this, this.field1689, var5);
            } else {
               var2 = method2078(0, 0, ((class107)super.field1717).field1605, var1, this.field1695, var2, this.field1702, this.field1700, 0, var6, var3, this, this.field1689, var5);
            }

            this.field1693 -= var2;
            if(this.field1693 != 0) {
               return var2;
            }

            if(!this.method2056()) {
               continue;
            }

            return var4;
         }

         if(this.field1689 == -256 && (this.field1695 & 255) == 0) {
            if(class222.field2849) {
               return method2157(0, ((class107)super.field1717).field1605, var1, this.field1695, var2, this.field1694, this.field1692, 0, var4, var3, this);
            }

            return method2072(((class107)super.field1717).field1605, var1, this.field1695, var2, this.field1702, 0, var4, var3, this);
         }

         if(class222.field2849) {
            return method2071(0, 0, ((class107)super.field1717).field1605, var1, this.field1695, var2, this.field1694, this.field1692, 0, var4, var3, this, this.field1689, var5);
         }

         return method2070(0, 0, ((class107)super.field1717).field1605, var1, this.field1695, var2, this.field1702, 0, var4, var3, this, this.field1689, var5);
      }
   }

   @ObfuscatedName("ad")
   static int method2064(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 257) / var11) > var8) {
         var7 = var8;
      }

      byte var13;
      int var14;
      while(var5 < var7) {
         var1 = var4 >> 8;
         var13 = var2[var1];
         var14 = var5++;
         var3[var14] += ((var13 << 8) + (var4 & 255) * (var2[var1 + 1] - var13)) * var6 >> 6;
         var4 += var11;
      }

      if(var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 1) / var11) > var8) {
         var7 = var8;
      }

      for(var1 = var12; var5 < var7; var4 += var11) {
         var13 = var2[var4 >> 8];
         var14 = var5++;
         var3[var14] += ((var13 << 8) + (var1 - var13) * (var4 & 255)) * var6 >> 6;
      }

      var10.field1695 = var4;
      return var5;
   }

   @ObfuscatedName("ai")
   static int method2065(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class117 var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if((var5 = var3 + var7 - var2) > var6) {
         var5 = var6;
      }

      int var9;
      for(var5 -= 3; var3 < var5; var1[var9] += var0[var2++] * var4) {
         var9 = var3++;
         var1[var9] += var0[var2++] * var4;
         var9 = var3++;
         var1[var9] += var0[var2++] * var4;
         var9 = var3++;
         var1[var9] += var0[var2++] * var4;
         var9 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var9] += var0[var2++] * var4) {
         var9 = var3++;
      }

      var8.field1695 = var2 << 8;
      return var3;
   }

   class117(class107 var1, int var2, int var3) {
      super.field1717 = var1;
      this.field1696 = var1.field1606;
      this.field1688 = var1.field1607;
      this.field1698 = var1.field1608;
      this.field1689 = var2;
      this.field1690 = var3;
      this.field1691 = 8192;
      this.field1695 = 0;
      this.method2040();
   }

   @ObfuscatedName("bg")
   static int method2070(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var11 + (var9 + 256 - var4)) / var11) > var8) {
         var7 = var8;
      }

      int var13;
      while(var5 < var7) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var13 = var5++;
         var3[var13] += ((var2[var1] - var14) * (var4 & 255) + (var14 << 8)) * var6 >> 6;
         var4 += var11;
      }

      if(var11 == 0 || (var7 = var5 + (var11 + (var9 - var4)) / var11) > var8) {
         var7 = var8;
      }

      var0 = var12;

      for(var1 = var11; var5 < var7; var4 += var1) {
         var13 = var5++;
         var3[var13] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
      }

      var10.field1695 = var4;
      return var5;
   }

   @ObfuscatedName("bf")
   static int method2071(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      int var14;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         byte var15 = var2[var1 - 1];
         var0 = (var2[var1] - var15) * (var4 & 255) + (var15 << 8);
         var14 = var5++;
         var3[var14] += var0 * var6 >> 6;
         var14 = var5++;
         var3[var14] += var0 * var7 >> 6;
      }

      if(var12 == 0 || (var8 = (var10 - var4 + var12) / var12 + (var5 >> 1)) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for(var1 = var13; var5 < var8; var4 += var12) {
         var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
         var14 = var5++;
         var3[var14] += var0 * var6 >> 6;
         var14 = var5++;
         var3[var14] += var0 * var7 >> 6;
      }

      var11.field1695 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("au")
   static int method2072(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class117 var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if((var5 = var3 + var2 - (var7 - 1)) > var6) {
         var5 = var6;
      }

      int var9;
      for(var5 -= 3; var3 < var5; var1[var9] += var0[var2--] * var4) {
         var9 = var3++;
         var1[var9] += var0[var2--] * var4;
         var9 = var3++;
         var1[var9] += var0[var2--] * var4;
         var9 = var3++;
         var1[var9] += var0[var2--] * var4;
         var9 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var9] += var0[var2--] * var4) {
         var9 = var3++;
      }

      var8.field1695 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bv")
   static int method2073(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class117 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1702 += (var9 - var4) * var12.field1700;
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var14;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      var12.field1694 = var5 >> 2;
      var12.field1692 = var6 >> 2;
      var12.field1695 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bz")
   static int method2074(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class117 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1694 += var9.field1701 * (var6 - var3);
      var9.field1692 += var9.field1699 * (var6 - var3);

      int var10;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10 = var3++;
         var1[var10] += var0[var2--] * var4;
         var4 += var5;
         var10 = var3++;
         var1[var10] += var0[var2--] * var4;
         var4 += var5;
         var10 = var3++;
         var1[var10] += var0[var2--] * var4;
         var4 += var5;
         var10 = var3++;
         var1[var10] += var0[var2--] * var4;
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10 = var3++;
         var1[var10] += var0[var2--] * var4;
      }

      var9.field1702 = var4 >> 2;
      var9.field1695 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ba")
   static int method2075(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class117 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1702 += (var9 - var4) * var12.field1700;
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var14;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      var12.field1694 = var5 >> 2;
      var12.field1692 = var6 >> 2;
      var12.field1695 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bn")
   static int method2077(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class117 var13, int var14, int var15) {
      var13.field1702 -= var5 * var13.field1700;
      if(var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      byte var16;
      int var17;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         var16 = var2[var1];
         var0 = (var2[var1 + 1] - var16) * (var4 & 255) + (var16 << 8);
         var17 = var5++;
         var3[var17] += var0 * var6 >> 6;
         var6 += var8;
         var17 = var5++;
         var3[var17] += var0 * var7 >> 6;
         var7 += var9;
      }

      if(var14 == 0 || (var10 = (var12 - var4 + var14 - 1) / var14 + (var5 >> 1)) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for(var1 = var15; var5 < var10; var4 += var14) {
         var16 = var2[var4 >> 8];
         var0 = (var1 - var16) * (var4 & 255) + (var16 << 8);
         var17 = var5++;
         var3[var17] += var0 * var6 >> 6;
         var6 += var8;
         var17 = var5++;
         var3[var17] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field1702 += var5 * var13.field1700;
      var13.field1694 = var6;
      var13.field1692 = var7;
      var13.field1695 = var4;
      return var5;
   }

   @ObfuscatedName("br")
   static int method2078(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
      var11.field1694 -= var11.field1701 * var5;
      var11.field1692 -= var11.field1699 * var5;
      if(var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      int var14;
      while(var5 < var8) {
         var1 = var4 >> 8;
         byte var15 = var2[var1 - 1];
         var14 = var5++;
         var3[var14] += ((var2[var1] - var15) * (var4 & 255) + (var15 << 8)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var0 = var13;

      for(var1 = var12; var5 < var8; var4 += var1) {
         var14 = var5++;
         var3[var14] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field1694 += var11.field1701 * var5;
      var11.field1692 += var11.field1699 * var5;
      var11.field1702 = var6;
      var11.field1695 = var4;
      return var5;
   }

   @ObfuscatedName("bc")
   static int method2079(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class117 var13, int var14, int var15) {
      var13.field1702 -= var5 * var13.field1700;
      if(var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      int var16;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         byte var17 = var2[var1 - 1];
         var0 = (var17 << 8) + (var2[var1] - var17) * (var4 & 255);
         var16 = var5++;
         var3[var16] += var0 * var6 >> 6;
         var6 += var8;
         var16 = var5++;
         var3[var16] += var0 * var7 >> 6;
         var7 += var9;
      }

      if(var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for(var1 = var15; var5 < var10; var4 += var14) {
         var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
         var16 = var5++;
         var3[var16] += var0 * var6 >> 6;
         var6 += var8;
         var16 = var5++;
         var3[var16] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field1702 += var5 * var13.field1700;
      var13.field1694 = var6;
      var13.field1692 = var7;
      var13.field1695 = var4;
      return var5;
   }

   class117(class107 var1, int var2, int var3, int var4) {
      super.field1717 = var1;
      this.field1696 = var1.field1606;
      this.field1688 = var1.field1607;
      this.field1698 = var1.field1608;
      this.field1689 = var2;
      this.field1690 = var3;
      this.field1691 = var4;
      this.field1695 = 0;
      this.method2040();
   }

   @ObfuscatedName("aw")
   static int method2088(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if((var7 = var4 + var9 - var3) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var11;
      byte var12;
      for(var7 -= 6; var4 < var7; var2[var11] += var12 * var6) {
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var5 * var12;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var5 * var12;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var5 * var12;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var5 * var12;
         var11 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var11] += var12 * var6) {
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var5 * var12;
         var11 = var4++;
      }

      var10.field1695 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bi")
   static int method2100(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class117 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1694 += var9.field1701 * (var6 - var3);
      var9.field1692 += var9.field1699 * (var6 - var3);

      int var10;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10 = var3++;
         var1[var10] += var0[var2++] * var4;
         var4 += var5;
         var10 = var3++;
         var1[var10] += var0[var2++] * var4;
         var4 += var5;
         var10 = var3++;
         var1[var10] += var0[var2++] * var4;
         var4 += var5;
         var10 = var3++;
         var1[var10] += var0[var2++] * var4;
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10 = var3++;
         var1[var10] += var0[var2++] * var4;
      }

      var9.field1702 = var4 >> 2;
      var9.field1695 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("s")
   public synchronized int method2107() {
      return this.field1690 == Integer.MIN_VALUE?0:this.field1690;
   }

   @ObfuscatedName("n")
   public synchronized void vmethod3773(int var1) {
      if(this.field1693 > 0) {
         if(var1 >= this.field1693) {
            if(this.field1690 == Integer.MIN_VALUE) {
               this.field1690 = 0;
               this.field1692 = 0;
               this.field1694 = 0;
               this.field1702 = 0;
               this.unlink();
               var1 = this.field1693;
            }

            this.field1693 = 0;
            this.method2040();
         } else {
            this.field1702 += this.field1700 * var1;
            this.field1694 += this.field1701 * var1;
            this.field1692 += this.field1699 * var1;
            this.field1693 -= var1;
         }
      }

      class107 var2 = (class107)super.field1717;
      int var3 = this.field1696 << 8;
      int var4 = this.field1688 << 8;
      int var5 = var2.field1605.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1697 = 0;
      }

      if(this.field1695 < 0) {
         if(this.field1689 <= 0) {
            this.method2049();
            this.unlink();
            return;
         }

         this.field1695 = 0;
      }

      if(this.field1695 >= var5) {
         if(this.field1689 >= 0) {
            this.method2049();
            this.unlink();
            return;
         }

         this.field1695 = var5 - 1;
      }

      this.field1695 += this.field1689 * var1;
      if(this.field1697 < 0) {
         if(!this.field1698) {
            if(this.field1689 < 0) {
               if(this.field1695 >= var3) {
                  return;
               }

               this.field1695 = var4 - 1 - (var4 - 1 - this.field1695) % var6;
            } else {
               if(this.field1695 < var4) {
                  return;
               }

               this.field1695 = var3 + (this.field1695 - var3) % var6;
            }
         } else {
            if(this.field1689 < 0) {
               if(this.field1695 >= var3) {
                  return;
               }

               this.field1695 = var3 + var3 - 1 - this.field1695;
               this.field1689 = -this.field1689;
            }

            while(this.field1695 >= var4) {
               this.field1695 = var4 + var4 - 1 - this.field1695;
               this.field1689 = -this.field1689;
               if(this.field1695 >= var3) {
                  return;
               }

               this.field1695 = var3 + var3 - 1 - this.field1695;
               this.field1689 = -this.field1689;
            }
         }
      } else {
         if(this.field1697 > 0) {
            if(this.field1698) {
               label113: {
                  if(this.field1689 < 0) {
                     if(this.field1695 >= var3) {
                        return;
                     }

                     this.field1695 = var3 + var3 - 1 - this.field1695;
                     this.field1689 = -this.field1689;
                     if(--this.field1697 == 0) {
                        break label113;
                     }
                  }

                  do {
                     if(this.field1695 < var4) {
                        return;
                     }

                     this.field1695 = var4 + var4 - 1 - this.field1695;
                     this.field1689 = -this.field1689;
                     if(--this.field1697 == 0) {
                        break;
                     }

                     if(this.field1695 >= var3) {
                        return;
                     }

                     this.field1695 = var3 + var3 - 1 - this.field1695;
                     this.field1689 = -this.field1689;
                  } while(--this.field1697 != 0);
               }
            } else {
               int var7;
               if(this.field1689 < 0) {
                  if(this.field1695 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1695) / var6;
                  if(var7 < this.field1697) {
                     this.field1695 += var7 * var6;
                     this.field1697 -= var7;
                     return;
                  }

                  this.field1695 += this.field1697 * var6;
                  this.field1697 = 0;
               } else {
                  if(this.field1695 < var4) {
                     return;
                  }

                  var7 = (this.field1695 - var3) / var6;
                  if(var7 < this.field1697) {
                     this.field1695 -= var7 * var6;
                     this.field1697 -= var7;
                     return;
                  }

                  this.field1695 -= this.field1697 * var6;
                  this.field1697 = 0;
               }
            }
         }

         if(this.field1689 < 0) {
            if(this.field1695 < 0) {
               this.field1695 = -1;
               this.method2049();
               this.unlink();
            }
         } else if(this.field1695 >= var5) {
            this.field1695 = var5;
            this.method2049();
            this.unlink();
         }
      }

   }

   @ObfuscatedName("am")
   public synchronized int method2124() {
      return this.field1689 < 0?-this.field1689:this.field1689;
   }

   @ObfuscatedName("p")
   static int method2125(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("an")
   int vmethod2209() {
      int var1 = this.field1702 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1697 == 0) {
         var1 -= this.field1695 * var1 / (((class107)super.field1717).field1605.length << 8);
      } else if(this.field1697 >= 0) {
         var1 -= this.field1696 * var1 / ((class107)super.field1717).field1605.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("u")
   public synchronized void method2146(int var1) {
      if(this.field1689 < 0) {
         this.field1689 = -var1;
      } else {
         this.field1689 = var1;
      }

   }

   @ObfuscatedName("q")
   public synchronized void method2149(int var1) {
      this.field1697 = var1;
   }

   @ObfuscatedName("ao")
   public boolean method2151() {
      return this.field1693 != 0;
   }

   @ObfuscatedName("at")
   static int method2154(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      byte var14;
      int var15;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var0 = (var2[var1 + 1] - var14) * (var4 & 255) + (var14 << 8);
         var15 = var5++;
         var3[var15] += var0 * var6 >> 6;
         var15 = var5++;
         var3[var15] += var0 * var7 >> 6;
      }

      if(var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for(var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var0 = (var1 - var14) * (var4 & 255) + (var14 << 8);
         var15 = var5++;
         var3[var15] += var0 * var6 >> 6;
         var15 = var5++;
         var3[var15] += var0 * var7 >> 6;
      }

      var11.field1695 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ah")
   static int method2157(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if((var7 = var3 + var4 - (var9 - 1)) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var11;
      byte var12;
      for(var7 -= 6; var4 < var7; var2[var11] += var12 * var6) {
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var5 * var12;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var5 * var12;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var5 * var12;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var5 * var12;
         var11 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var11] += var12 * var6) {
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var5 * var12;
         var11 = var4++;
      }

      var10.field1695 = var3 << 8;
      return var4 >> 1;
   }
}
