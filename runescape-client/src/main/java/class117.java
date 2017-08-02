import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class117 extends class119 {
   @ObfuscatedName("u")
   int field1662;
   @ObfuscatedName("i")
   int field1659;
   @ObfuscatedName("g")
   int field1657;
   @ObfuscatedName("x")
   int field1660;
   @ObfuscatedName("v")
   int field1664;
   @ObfuscatedName("o")
   int field1656;
   @ObfuscatedName("c")
   int field1654;
   @ObfuscatedName("m")
   int field1658;
   @ObfuscatedName("p")
   int field1661;
   @ObfuscatedName("s")
   int field1666;
   @ObfuscatedName("k")
   int field1667;
   @ObfuscatedName("h")
   int field1653;
   @ObfuscatedName("t")
   int field1665;
   @ObfuscatedName("r")
   boolean field1663;
   @ObfuscatedName("a")
   int field1655;

   @ObfuscatedSignature(
      signature = "(Ldm;III)V"
   )
   class117(class107 var1, int var2, int var3, int var4) {
      super.field1682 = var1;
      this.field1661 = var1.field1577;
      this.field1667 = var1.field1578;
      this.field1663 = var1.field1575;
      this.field1656 = var2;
      this.field1659 = var3;
      this.field1662 = var4;
      this.field1654 = 0;
      this.method2112();
   }

   @ObfuscatedSignature(
      signature = "(Ldm;II)V"
   )
   class117(class107 var1, int var2, int var3) {
      super.field1682 = var1;
      this.field1661 = var1.field1577;
      this.field1667 = var1.field1578;
      this.field1663 = var1.field1575;
      this.field1656 = var2;
      this.field1659 = var3;
      this.field1662 = 8192;
      this.field1654 = 0;
      this.method2112();
   }

   @ObfuscatedName("l")
   public synchronized int method2062() {
      return this.field1662 < 0?-1:this.field1662;
   }

   @ObfuscatedName("v")
   synchronized void method2192(int var1) {
      this.method2060(var1, this.method2062());
   }

   @ObfuscatedName("h")
   synchronized void method2060(int var1, int var2) {
      this.field1659 = var1;
      this.field1662 = var2;
      this.field1664 = 0;
      this.method2112();
   }

   @ObfuscatedName("z")
   public synchronized void method2170(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2060(var2, var3);
      } else {
         int var4 = method2123(var2, var3);
         int var5 = method2052(var2, var3);
         if(var4 == this.field1658 && var5 == this.field1666) {
            this.field1664 = 0;
         } else {
            int var6 = var2 - this.field1657;
            if(this.field1657 - var2 > var6) {
               var6 = this.field1657 - var2;
            }

            if(var4 - this.field1658 > var6) {
               var6 = var4 - this.field1658;
            }

            if(this.field1658 - var4 > var6) {
               var6 = this.field1658 - var4;
            }

            if(var5 - this.field1666 > var6) {
               var6 = var5 - this.field1666;
            }

            if(this.field1666 - var5 > var6) {
               var6 = this.field1666 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1664 = var1;
            this.field1659 = var2;
            this.field1662 = var3;
            this.field1653 = (var2 - this.field1657) / var1;
            this.field1665 = (var4 - this.field1658) / var1;
            this.field1655 = (var5 - this.field1666) / var1;
         }
      }
   }

   @ObfuscatedName("p")
   public synchronized void vmethod3826(int[] var1, int var2, int var3) {
      if(this.field1659 == 0 && this.field1664 == 0) {
         this.vmethod3827(var3);
      } else {
         class107 var4 = (class107)super.field1682;
         int var5 = this.field1661 << 8;
         int var6 = this.field1667 << 8;
         int var7 = var4.field1576.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1660 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1654 < 0) {
            if(this.field1656 <= 0) {
               this.method2065();
               this.unlink();
               return;
            }

            this.field1654 = 0;
         }

         if(this.field1654 >= var7) {
            if(this.field1656 >= 0) {
               this.method2065();
               this.unlink();
               return;
            }

            this.field1654 = var7 - 1;
         }

         if(this.field1660 < 0) {
            if(this.field1663) {
               if(this.field1656 < 0) {
                  var9 = this.method2079(var1, var2, var5, var3, var4.field1576[this.field1661]);
                  if(this.field1654 >= var5) {
                     return;
                  }

                  this.field1654 = var5 + var5 - 1 - this.field1654;
                  this.field1656 = -this.field1656;
               }

               while(true) {
                  var9 = this.method2078(var1, var9, var6, var3, var4.field1576[this.field1667 - 1]);
                  if(this.field1654 < var6) {
                     return;
                  }

                  this.field1654 = var6 + var6 - 1 - this.field1654;
                  this.field1656 = -this.field1656;
                  var9 = this.method2079(var1, var9, var5, var3, var4.field1576[this.field1661]);
                  if(this.field1654 >= var5) {
                     return;
                  }

                  this.field1654 = var5 + var5 - 1 - this.field1654;
                  this.field1656 = -this.field1656;
               }
            } else if(this.field1656 < 0) {
               while(true) {
                  var9 = this.method2079(var1, var9, var5, var3, var4.field1576[this.field1667 - 1]);
                  if(this.field1654 >= var5) {
                     return;
                  }

                  this.field1654 = var6 - 1 - (var6 - 1 - this.field1654) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2078(var1, var9, var6, var3, var4.field1576[this.field1661]);
                  if(this.field1654 < var6) {
                     return;
                  }

                  this.field1654 = var5 + (this.field1654 - var5) % var8;
               }
            }
         } else {
            if(this.field1660 > 0) {
               if(this.field1663) {
                  label140: {
                     if(this.field1656 < 0) {
                        var9 = this.method2079(var1, var2, var5, var3, var4.field1576[this.field1661]);
                        if(this.field1654 >= var5) {
                           return;
                        }

                        this.field1654 = var5 + var5 - 1 - this.field1654;
                        this.field1656 = -this.field1656;
                        if(--this.field1660 == 0) {
                           break label140;
                        }
                     }

                     do {
                        var9 = this.method2078(var1, var9, var6, var3, var4.field1576[this.field1667 - 1]);
                        if(this.field1654 < var6) {
                           return;
                        }

                        this.field1654 = var6 + var6 - 1 - this.field1654;
                        this.field1656 = -this.field1656;
                        if(--this.field1660 == 0) {
                           break;
                        }

                        var9 = this.method2079(var1, var9, var5, var3, var4.field1576[this.field1661]);
                        if(this.field1654 >= var5) {
                           return;
                        }

                        this.field1654 = var5 + var5 - 1 - this.field1654;
                        this.field1656 = -this.field1656;
                     } while(--this.field1660 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1656 < 0) {
                     while(true) {
                        var9 = this.method2079(var1, var9, var5, var3, var4.field1576[this.field1667 - 1]);
                        if(this.field1654 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1654) / var8;
                        if(var10 >= this.field1660) {
                           this.field1654 += var8 * this.field1660;
                           this.field1660 = 0;
                           break;
                        }

                        this.field1654 += var8 * var10;
                        this.field1660 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2078(var1, var9, var6, var3, var4.field1576[this.field1661]);
                        if(this.field1654 < var6) {
                           return;
                        }

                        var10 = (this.field1654 - var5) / var8;
                        if(var10 >= this.field1660) {
                           this.field1654 -= var8 * this.field1660;
                           this.field1660 = 0;
                           break;
                        }

                        this.field1654 -= var8 * var10;
                        this.field1660 -= var10;
                     }
                  }
               }
            }

            if(this.field1656 < 0) {
               this.method2079(var1, var9, 0, var3, 0);
               if(this.field1654 < 0) {
                  this.field1654 = -1;
                  this.method2065();
                  this.unlink();
               }
            } else {
               this.method2078(var1, var9, var7, var3, 0);
               if(this.field1654 >= var7) {
                  this.field1654 = var7;
                  this.method2065();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("r")
   public synchronized void vmethod3827(int var1) {
      if(this.field1664 > 0) {
         if(var1 >= this.field1664) {
            if(this.field1659 == Integer.MIN_VALUE) {
               this.field1659 = 0;
               this.field1666 = 0;
               this.field1658 = 0;
               this.field1657 = 0;
               this.unlink();
               var1 = this.field1664;
            }

            this.field1664 = 0;
            this.method2112();
         } else {
            this.field1657 += this.field1653 * var1;
            this.field1658 += this.field1665 * var1;
            this.field1666 += this.field1655 * var1;
            this.field1664 -= var1;
         }
      }

      class107 var2 = (class107)super.field1682;
      int var3 = this.field1661 << 8;
      int var4 = this.field1667 << 8;
      int var5 = var2.field1576.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1660 = 0;
      }

      if(this.field1654 < 0) {
         if(this.field1656 <= 0) {
            this.method2065();
            this.unlink();
            return;
         }

         this.field1654 = 0;
      }

      if(this.field1654 >= var5) {
         if(this.field1656 >= 0) {
            this.method2065();
            this.unlink();
            return;
         }

         this.field1654 = var5 - 1;
      }

      this.field1654 += this.field1656 * var1;
      if(this.field1660 < 0) {
         if(!this.field1663) {
            if(this.field1656 < 0) {
               if(this.field1654 >= var3) {
                  return;
               }

               this.field1654 = var4 - 1 - (var4 - 1 - this.field1654) % var6;
            } else {
               if(this.field1654 < var4) {
                  return;
               }

               this.field1654 = var3 + (this.field1654 - var3) % var6;
            }

         } else {
            if(this.field1656 < 0) {
               if(this.field1654 >= var3) {
                  return;
               }

               this.field1654 = var3 + var3 - 1 - this.field1654;
               this.field1656 = -this.field1656;
            }

            while(this.field1654 >= var4) {
               this.field1654 = var4 + var4 - 1 - this.field1654;
               this.field1656 = -this.field1656;
               if(this.field1654 >= var3) {
                  return;
               }

               this.field1654 = var3 + var3 - 1 - this.field1654;
               this.field1656 = -this.field1656;
            }

         }
      } else {
         if(this.field1660 > 0) {
            if(this.field1663) {
               label120: {
                  if(this.field1656 < 0) {
                     if(this.field1654 >= var3) {
                        return;
                     }

                     this.field1654 = var3 + var3 - 1 - this.field1654;
                     this.field1656 = -this.field1656;
                     if(--this.field1660 == 0) {
                        break label120;
                     }
                  }

                  do {
                     if(this.field1654 < var4) {
                        return;
                     }

                     this.field1654 = var4 + var4 - 1 - this.field1654;
                     this.field1656 = -this.field1656;
                     if(--this.field1660 == 0) {
                        break;
                     }

                     if(this.field1654 >= var3) {
                        return;
                     }

                     this.field1654 = var3 + var3 - 1 - this.field1654;
                     this.field1656 = -this.field1656;
                  } while(--this.field1660 != 0);
               }
            } else {
               label152: {
                  int var7;
                  if(this.field1656 < 0) {
                     if(this.field1654 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1654) / var6;
                     if(var7 >= this.field1660) {
                        this.field1654 += var6 * this.field1660;
                        this.field1660 = 0;
                        break label152;
                     }

                     this.field1654 += var6 * var7;
                     this.field1660 -= var7;
                  } else {
                     if(this.field1654 < var4) {
                        return;
                     }

                     var7 = (this.field1654 - var3) / var6;
                     if(var7 >= this.field1660) {
                        this.field1654 -= var6 * this.field1660;
                        this.field1660 = 0;
                        break label152;
                     }

                     this.field1654 -= var6 * var7;
                     this.field1660 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1656 < 0) {
            if(this.field1654 < 0) {
               this.field1654 = -1;
               this.method2065();
               this.unlink();
            }
         } else if(this.field1654 >= var5) {
            this.field1654 = var5;
            this.method2065();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("q")
   public synchronized void method2063(int var1) {
      int var2 = ((class107)super.field1682).field1576.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1654 = var1;
   }

   @ObfuscatedName("g")
   void method2112() {
      this.field1657 = this.field1659;
      this.field1658 = method2123(this.field1659, this.field1662);
      this.field1666 = method2052(this.field1659, this.field1662);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected class119 vmethod3835() {
      return null;
   }

   @ObfuscatedName("ak")
   public boolean method2071() {
      return this.field1654 < 0 || this.field1654 >= ((class107)super.field1682).field1576.length << 8;
   }

   @ObfuscatedName("aj")
   public synchronized void method2182(int var1) {
      if(this.field1656 < 0) {
         this.field1656 = -var1;
      } else {
         this.field1656 = var1;
      }

   }

   @ObfuscatedName("ap")
   public synchronized void method2068(int var1) {
      if(var1 == 0) {
         this.method2192(0);
         this.unlink();
      } else if(this.field1658 == 0 && this.field1666 == 0) {
         this.field1664 = 0;
         this.field1659 = 0;
         this.field1657 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1657;
         if(this.field1657 > var2) {
            var2 = this.field1657;
         }

         if(-this.field1658 > var2) {
            var2 = -this.field1658;
         }

         if(this.field1658 > var2) {
            var2 = this.field1658;
         }

         if(-this.field1666 > var2) {
            var2 = -this.field1666;
         }

         if(this.field1666 > var2) {
            var2 = this.field1666;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1664 = var1;
         this.field1659 = Integer.MIN_VALUE;
         this.field1653 = -this.field1657 / var1;
         this.field1665 = -this.field1658 / var1;
         this.field1655 = -this.field1666 / var1;
      }
   }

   @ObfuscatedName("j")
   void method2065() {
      if(this.field1664 != 0) {
         if(this.field1659 == Integer.MIN_VALUE) {
            this.field1659 = 0;
         }

         this.field1664 = 0;
         this.method2112();
      }

   }

   @ObfuscatedName("ar")
   public boolean method2072() {
      return this.field1664 != 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2064() {
      this.field1656 = (this.field1656 ^ this.field1656 >> 31) + (this.field1656 >>> 31);
      this.field1656 = -this.field1656;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected class119 vmethod3823() {
      return null;
   }

   @ObfuscatedName("aa")
   int vmethod2228() {
      int var1 = this.field1657 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1660 == 0) {
         var1 -= var1 * this.field1654 / (((class107)super.field1682).field1576.length << 8);
      } else if(this.field1660 >= 0) {
         var1 -= var1 * this.field1661 / ((class107)super.field1682).field1576.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("af")
   public synchronized int method2122() {
      return this.field1656 < 0?-this.field1656:this.field1656;
   }

   @ObfuscatedName("t")
   public synchronized int method2061() {
      return this.field1659 == Integer.MIN_VALUE?0:this.field1659;
   }

   @ObfuscatedName("ah")
   boolean method2080() {
      int var1 = this.field1659;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2123(var1, this.field1662);
         var3 = method2052(var1, this.field1662);
      }

      if(var1 == this.field1657 && var2 == this.field1658 && var3 == this.field1666) {
         if(this.field1659 == Integer.MIN_VALUE) {
            this.field1659 = 0;
            this.field1666 = 0;
            this.field1658 = 0;
            this.field1657 = 0;
            this.unlink();
            return true;
         } else {
            this.method2112();
            return false;
         }
      } else {
         if(this.field1657 < var1) {
            this.field1653 = 1;
            this.field1664 = var1 - this.field1657;
         } else if(this.field1657 > var1) {
            this.field1653 = -1;
            this.field1664 = this.field1657 - var1;
         } else {
            this.field1653 = 0;
         }

         if(this.field1658 < var2) {
            this.field1665 = 1;
            if(this.field1664 == 0 || this.field1664 > var2 - this.field1658) {
               this.field1664 = var2 - this.field1658;
            }
         } else if(this.field1658 > var2) {
            this.field1665 = -1;
            if(this.field1664 == 0 || this.field1664 > this.field1658 - var2) {
               this.field1664 = this.field1658 - var2;
            }
         } else {
            this.field1665 = 0;
         }

         if(this.field1666 < var3) {
            this.field1655 = 1;
            if(this.field1664 == 0 || this.field1664 > var3 - this.field1666) {
               this.field1664 = var3 - this.field1666;
            }
         } else if(this.field1666 > var3) {
            this.field1655 = -1;
            if(this.field1664 == 0 || this.field1664 > this.field1666 - var3) {
               this.field1664 = this.field1666 - var3;
            }
         } else {
            this.field1655 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("an")
   int method2078(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1664 > 0) {
            int var6 = var2 + this.field1664;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1664 += var2;
            if(this.field1656 == 256 && (this.field1654 & 255) == 0) {
               if(class8.highMemory) {
                  var2 = method2090(0, ((class107)super.field1682).field1576, var1, this.field1654, var2, this.field1658, this.field1666, this.field1665, this.field1655, 0, var6, var3, this);
               } else {
                  var2 = method2089(((class107)super.field1682).field1576, var1, this.field1654, var2, this.field1657, this.field1653, 0, var6, var3, this);
               }
            } else if(class8.highMemory) {
               var2 = method2148(0, 0, ((class107)super.field1682).field1576, var1, this.field1654, var2, this.field1658, this.field1666, this.field1665, this.field1655, 0, var6, var3, this, this.field1656, var5);
            } else {
               var2 = method2093(0, 0, ((class107)super.field1682).field1576, var1, this.field1654, var2, this.field1657, this.field1653, 0, var6, var3, this, this.field1656, var5);
            }

            this.field1664 -= var2;
            if(this.field1664 != 0) {
               return var2;
            }

            if(!this.method2080()) {
               continue;
            }

            return var4;
         }

         if(this.field1656 == 256 && (this.field1654 & 255) == 0) {
            if(class8.highMemory) {
               return method2082(0, ((class107)super.field1682).field1576, var1, this.field1654, var2, this.field1658, this.field1666, 0, var4, var3, this);
            }

            return method2081(((class107)super.field1682).field1576, var1, this.field1654, var2, this.field1657, 0, var4, var3, this);
         }

         if(class8.highMemory) {
            return method2086(0, 0, ((class107)super.field1682).field1576, var1, this.field1654, var2, this.field1658, this.field1666, 0, var4, var3, this, this.field1656, var5);
         }

         return method2085(0, 0, ((class107)super.field1682).field1576, var1, this.field1654, var2, this.field1657, 0, var4, var3, this, this.field1656, var5);
      }
   }

   @ObfuscatedName("ae")
   int method2079(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1664 > 0) {
            int var6 = var2 + this.field1664;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1664 += var2;
            if(this.field1656 == -256 && (this.field1654 & 255) == 0) {
               if(class8.highMemory) {
                  var2 = method2157(0, ((class107)super.field1682).field1576, var1, this.field1654, var2, this.field1658, this.field1666, this.field1665, this.field1655, 0, var6, var3, this);
               } else {
                  var2 = method2155(((class107)super.field1682).field1576, var1, this.field1654, var2, this.field1657, this.field1653, 0, var6, var3, this);
               }
            } else if(class8.highMemory) {
               var2 = method2096(0, 0, ((class107)super.field1682).field1576, var1, this.field1654, var2, this.field1658, this.field1666, this.field1665, this.field1655, 0, var6, var3, this, this.field1656, var5);
            } else {
               var2 = method2095(0, 0, ((class107)super.field1682).field1576, var1, this.field1654, var2, this.field1657, this.field1653, 0, var6, var3, this, this.field1656, var5);
            }

            this.field1664 -= var2;
            if(this.field1664 != 0) {
               return var2;
            }

            if(!this.method2080()) {
               continue;
            }

            return var4;
         }

         if(this.field1656 == -256 && (this.field1654 & 255) == 0) {
            if(class8.highMemory) {
               return method2051(0, ((class107)super.field1682).field1576, var1, this.field1654, var2, this.field1658, this.field1666, 0, var4, var3, this);
            }

            return method2083(((class107)super.field1682).field1576, var1, this.field1654, var2, this.field1657, 0, var4, var3, this);
         }

         if(class8.highMemory) {
            return method2088(0, 0, ((class107)super.field1682).field1576, var1, this.field1654, var2, this.field1658, this.field1666, 0, var4, var3, this, this.field1656, var5);
         }

         return method2137(0, 0, ((class107)super.field1682).field1576, var1, this.field1654, var2, this.field1657, 0, var4, var3, this, this.field1656, var5);
      }
   }

   @ObfuscatedName("k")
   public synchronized void method2057(int var1) {
      this.field1660 = var1;
   }

   @ObfuscatedName("x")
   protected int vmethod3825() {
      return this.field1659 == 0 && this.field1664 == 0?0:1;
   }

   @ObfuscatedName("n")
   public synchronized void method2066(int var1, int var2) {
      this.method2170(var1, var2, this.method2062());
   }

   @ObfuscatedName("w")
   public synchronized void method2058(int var1) {
      this.method2060(var1 << 6, this.method2062());
   }

   @ObfuscatedName("c")
   static int method2123(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("o")
   static int method2052(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILde;II)I"
   )
   static int method2085(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 257) / var11) > var8) {
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

      if(var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 1) / var11) > var8) {
         var7 = var8;
      }

      for(var1 = var12; var5 < var7; var4 += var11) {
         var13 = var2[var4 >> 8];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var1 - var13) * (var4 & 255)) * var6 >> 6;
      }

      var10.field1654 = var4;
      return var5;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILde;II)I"
   )
   static int method2137(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10, int var11, int var12) {
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

      if(var11 == 0 || (var7 = var5 + (var11 + (var9 - var4)) / var11) > var8) {
         var7 = var8;
      }

      var0 = var12;

      for(var1 = var11; var5 < var7; var4 += var1) {
         var10001 = var5++;
         var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
      }

      var10.field1654 = var4;
      return var5;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILde;)I"
   )
   static int method2081(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class117 var8) {
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

      var8.field1654 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILde;II)I"
   )
   static int method2086(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
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

      var11.field1654 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILde;)I"
   )
   static int method2083(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class117 var8) {
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

      var8.field1654 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILde;II)I"
   )
   static int method2088(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var0 = (var2[var1] - var14) * (var4 & 255) + (var14 << 8);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      if(var12 == 0 || (var8 = (var10 - var4 + var12) / var12 + (var5 >> 1)) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for(var1 = var13; var5 < var8; var4 += var12) {
         var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      var11.field1654 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILde;)I"
   )
   static int method2082(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10) {
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
         var2[var10001] += var5 * var11;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var5 * var11;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var5 * var11;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var5 * var11;
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var5 * var11;
         var10001 = var4++;
      }

      var10.field1654 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILde;)I"
   )
   static int method2051(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if((var7 = var3 + var4 - (var9 - 1)) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var10001;
      byte var11;
      for(var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var5 * var11;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var5 * var11;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var5 * var11;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var5 * var11;
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var5 * var11;
         var10001 = var4++;
      }

      var10.field1654 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILde;II)I"
   )
   static int method2093(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
      var11.field1658 -= var11.field1665 * var5;
      var11.field1666 -= var11.field1655 * var5;
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

      var11.field1658 += var11.field1665 * var5;
      var11.field1666 += var11.field1655 * var5;
      var11.field1657 = var6;
      var11.field1654 = var4;
      return var5;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILde;II)I"
   )
   static int method2095(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
      var11.field1658 -= var11.field1665 * var5;
      var11.field1666 -= var11.field1655 * var5;
      if(var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      int var10001;
      while(var5 < var8) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var10001 = var5++;
         var3[var10001] += ((var2[var1] - var14) * (var4 & 255) + (var14 << 8)) * var6 >> 6;
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

      var11.field1658 += var11.field1665 * var5;
      var11.field1666 += var11.field1655 * var5;
      var11.field1657 = var6;
      var11.field1654 = var4;
      return var5;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILde;)I"
   )
   static int method2089(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class117 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1658 += var9.field1665 * (var6 - var3);
      var9.field1666 += var9.field1655 * (var6 - var3);

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

      var9.field1657 = var4 >> 2;
      var9.field1654 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILde;)I"
   )
   static int method2155(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class117 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1658 += var9.field1665 * (var6 - var3);
      var9.field1666 += var9.field1655 * (var6 - var3);

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

      var9.field1657 = var4 >> 2;
      var9.field1654 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILde;II)I"
   )
   static int method2148(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class117 var13, int var14, int var15) {
      var13.field1657 -= var5 * var13.field1653;
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
      var13.field1657 += var5 * var13.field1653;
      var13.field1658 = var6;
      var13.field1666 = var7;
      var13.field1654 = var4;
      return var5;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILde;II)I"
   )
   static int method2096(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class117 var13, int var14, int var15) {
      var13.field1657 -= var5 * var13.field1653;
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
         var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field1657 += var5 * var13.field1653;
      var13.field1658 = var6;
      var13.field1666 = var7;
      var13.field1654 = var4;
      return var5;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILde;)I"
   )
   static int method2090(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class117 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1657 += (var9 - var4) * var12.field1653;
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      var12.field1658 = var5 >> 2;
      var12.field1666 = var6 >> 2;
      var12.field1654 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILde;)I"
   )
   static int method2157(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class117 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1657 += (var9 - var4) * var12.field1653;
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var5 * var13;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      var12.field1658 = var5 >> 2;
      var12.field1666 = var6 >> 2;
      var12.field1654 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ldm;III)Lde;"
   )
   public static class117 method2055(class107 var0, int var1, int var2, int var3) {
      return var0.field1576 != null && var0.field1576.length != 0?new class117(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ldm;II)Lde;"
   )
   public static class117 method2054(class107 var0, int var1, int var2) {
      return var0.field1576 != null && var0.field1576.length != 0?new class117(var0, (int)((long)var0.field1579 * 256L * (long)var1 / (long)(CombatInfo1.sampleRate * 100)), var2 << 6):null;
   }
}
