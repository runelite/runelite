import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class118 extends class120 {
   @ObfuscatedName("p")
   int field1702;
   @ObfuscatedName("f")
   int field1705;
   @ObfuscatedName("x")
   int field1703;
   @ObfuscatedName("l")
   int field1704;
   @ObfuscatedName("i")
   int field1710;
   @ObfuscatedName("h")
   int field1700;
   @ObfuscatedName("j")
   int field1699;
   @ObfuscatedName("g")
   int field1701;
   @ObfuscatedName("b")
   int field1707;
   @ObfuscatedName("c")
   int field1709;
   @ObfuscatedName("o")
   int field1708;
   @ObfuscatedName("s")
   int field1711;
   @ObfuscatedName("r")
   int field1712;
   @ObfuscatedName("m")
   boolean field1706;
   @ObfuscatedName("e")
   int field1713;

   @ObfuscatedSignature(
      signature = "(Lde;III)V"
   )
   class118(class108 var1, int var2, int var3, int var4) {
      super.field1729 = var1;
      this.field1707 = var1.field1616;
      this.field1708 = var1.field1614;
      this.field1706 = var1.field1617;
      this.field1700 = var2;
      this.field1705 = var3;
      this.field1702 = var4;
      this.field1699 = 0;
      this.method2251();
   }

   @ObfuscatedSignature(
      signature = "(Lde;II)V"
   )
   class118(class108 var1, int var2, int var3) {
      super.field1729 = var1;
      this.field1707 = var1.field1616;
      this.field1708 = var1.field1614;
      this.field1706 = var1.field1617;
      this.field1700 = var2;
      this.field1705 = var3;
      this.field1702 = 8192;
      this.field1699 = 0;
      this.method2251();
   }

   @ObfuscatedName("t")
   public synchronized int method2183() {
      return this.field1702 < 0?-1:this.field1702;
   }

   @ObfuscatedName("e")
   synchronized void method2147(int var1) {
      this.method2145(var1, this.method2183());
   }

   @ObfuscatedName("a")
   synchronized void method2145(int var1, int var2) {
      this.field1705 = var1;
      this.field1702 = var2;
      this.field1710 = 0;
      this.method2251();
   }

   @ObfuscatedName("ax")
   public synchronized void method2155(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2145(var2, var3);
      } else {
         int var4 = method2198(var2, var3);
         int var5 = method2141(var2, var3);
         if(var4 == this.field1701 && var5 == this.field1709) {
            this.field1710 = 0;
         } else {
            int var6 = var2 - this.field1703;
            if(this.field1703 - var2 > var6) {
               var6 = this.field1703 - var2;
            }

            if(var4 - this.field1701 > var6) {
               var6 = var4 - this.field1701;
            }

            if(this.field1701 - var4 > var6) {
               var6 = this.field1701 - var4;
            }

            if(var5 - this.field1709 > var6) {
               var6 = var5 - this.field1709;
            }

            if(this.field1709 - var5 > var6) {
               var6 = this.field1709 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1710 = var1;
            this.field1705 = var2;
            this.field1702 = var3;
            this.field1711 = (var2 - this.field1703) / var1;
            this.field1712 = (var4 - this.field1701) / var1;
            this.field1713 = (var5 - this.field1709) / var1;
         }
      }
   }

   @ObfuscatedName("w")
   public synchronized void vmethod3904(int[] var1, int var2, int var3) {
      if(this.field1705 == 0 && this.field1710 == 0) {
         this.vmethod3893(var3);
      } else {
         class108 var4 = (class108)super.field1729;
         int var5 = this.field1707 << 8;
         int var6 = this.field1708 << 8;
         int var7 = var4.field1618.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1704 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1699 < 0) {
            if(this.field1700 <= 0) {
               this.method2153();
               this.unlink();
               return;
            }

            this.field1699 = 0;
         }

         if(this.field1699 >= var7) {
            if(this.field1700 >= 0) {
               this.method2153();
               this.unlink();
               return;
            }

            this.field1699 = var7 - 1;
         }

         if(this.field1704 < 0) {
            if(this.field1706) {
               if(this.field1700 < 0) {
                  var9 = this.method2270(var1, var2, var5, var3, var4.field1618[this.field1707]);
                  if(this.field1699 >= var5) {
                     return;
                  }

                  this.field1699 = var5 + var5 - 1 - this.field1699;
                  this.field1700 = -this.field1700;
               }

               while(true) {
                  var9 = this.method2166(var1, var9, var6, var3, var4.field1618[this.field1708 - 1]);
                  if(this.field1699 < var6) {
                     return;
                  }

                  this.field1699 = var6 + var6 - 1 - this.field1699;
                  this.field1700 = -this.field1700;
                  var9 = this.method2270(var1, var9, var5, var3, var4.field1618[this.field1707]);
                  if(this.field1699 >= var5) {
                     return;
                  }

                  this.field1699 = var5 + var5 - 1 - this.field1699;
                  this.field1700 = -this.field1700;
               }
            } else if(this.field1700 < 0) {
               while(true) {
                  var9 = this.method2270(var1, var9, var5, var3, var4.field1618[this.field1708 - 1]);
                  if(this.field1699 >= var5) {
                     return;
                  }

                  this.field1699 = var6 - 1 - (var6 - 1 - this.field1699) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2166(var1, var9, var6, var3, var4.field1618[this.field1707]);
                  if(this.field1699 < var6) {
                     return;
                  }

                  this.field1699 = var5 + (this.field1699 - var5) % var8;
               }
            }
         } else {
            if(this.field1704 > 0) {
               if(this.field1706) {
                  label139: {
                     if(this.field1700 < 0) {
                        var9 = this.method2270(var1, var2, var5, var3, var4.field1618[this.field1707]);
                        if(this.field1699 >= var5) {
                           return;
                        }

                        this.field1699 = var5 + var5 - 1 - this.field1699;
                        this.field1700 = -this.field1700;
                        if(--this.field1704 == 0) {
                           break label139;
                        }
                     }

                     do {
                        var9 = this.method2166(var1, var9, var6, var3, var4.field1618[this.field1708 - 1]);
                        if(this.field1699 < var6) {
                           return;
                        }

                        this.field1699 = var6 + var6 - 1 - this.field1699;
                        this.field1700 = -this.field1700;
                        if(--this.field1704 == 0) {
                           break;
                        }

                        var9 = this.method2270(var1, var9, var5, var3, var4.field1618[this.field1707]);
                        if(this.field1699 >= var5) {
                           return;
                        }

                        this.field1699 = var5 + var5 - 1 - this.field1699;
                        this.field1700 = -this.field1700;
                     } while(--this.field1704 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1700 < 0) {
                     while(true) {
                        var9 = this.method2270(var1, var9, var5, var3, var4.field1618[this.field1708 - 1]);
                        if(this.field1699 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1699) / var8;
                        if(var10 >= this.field1704) {
                           this.field1699 += var8 * this.field1704;
                           this.field1704 = 0;
                           break;
                        }

                        this.field1699 += var8 * var10;
                        this.field1704 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2166(var1, var9, var6, var3, var4.field1618[this.field1707]);
                        if(this.field1699 < var6) {
                           return;
                        }

                        var10 = (this.field1699 - var5) / var8;
                        if(var10 >= this.field1704) {
                           this.field1699 -= var8 * this.field1704;
                           this.field1704 = 0;
                           break;
                        }

                        this.field1699 -= var8 * var10;
                        this.field1704 -= var10;
                     }
                  }
               }
            }

            if(this.field1700 < 0) {
               this.method2270(var1, var9, 0, var3, 0);
               if(this.field1699 < 0) {
                  this.field1699 = -1;
                  this.method2153();
                  this.unlink();
               }
            } else {
               this.method2166(var1, var9, var7, var3, 0);
               if(this.field1699 >= var7) {
                  this.field1699 = var7;
                  this.method2153();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("o")
   public synchronized void vmethod3893(int var1) {
      if(this.field1710 > 0) {
         if(var1 >= this.field1710) {
            if(this.field1705 == Integer.MIN_VALUE) {
               this.field1705 = 0;
               this.field1709 = 0;
               this.field1701 = 0;
               this.field1703 = 0;
               this.unlink();
               var1 = this.field1710;
            }

            this.field1710 = 0;
            this.method2251();
         } else {
            this.field1703 += this.field1711 * var1;
            this.field1701 += this.field1712 * var1;
            this.field1709 += this.field1713 * var1;
            this.field1710 -= var1;
         }
      }

      class108 var2 = (class108)super.field1729;
      int var3 = this.field1707 << 8;
      int var4 = this.field1708 << 8;
      int var5 = var2.field1618.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1704 = 0;
      }

      if(this.field1699 < 0) {
         if(this.field1700 <= 0) {
            this.method2153();
            this.unlink();
            return;
         }

         this.field1699 = 0;
      }

      if(this.field1699 >= var5) {
         if(this.field1700 >= 0) {
            this.method2153();
            this.unlink();
            return;
         }

         this.field1699 = var5 - 1;
      }

      this.field1699 += this.field1700 * var1;
      if(this.field1704 < 0) {
         if(!this.field1706) {
            if(this.field1700 < 0) {
               if(this.field1699 >= var3) {
                  return;
               }

               this.field1699 = var4 - 1 - (var4 - 1 - this.field1699) % var6;
            } else {
               if(this.field1699 < var4) {
                  return;
               }

               this.field1699 = var3 + (this.field1699 - var3) % var6;
            }

         } else {
            if(this.field1700 < 0) {
               if(this.field1699 >= var3) {
                  return;
               }

               this.field1699 = var3 + var3 - 1 - this.field1699;
               this.field1700 = -this.field1700;
            }

            while(this.field1699 >= var4) {
               this.field1699 = var4 + var4 - 1 - this.field1699;
               this.field1700 = -this.field1700;
               if(this.field1699 >= var3) {
                  return;
               }

               this.field1699 = var3 + var3 - 1 - this.field1699;
               this.field1700 = -this.field1700;
            }

         }
      } else {
         if(this.field1704 > 0) {
            if(this.field1706) {
               label126: {
                  if(this.field1700 < 0) {
                     if(this.field1699 >= var3) {
                        return;
                     }

                     this.field1699 = var3 + var3 - 1 - this.field1699;
                     this.field1700 = -this.field1700;
                     if(--this.field1704 == 0) {
                        break label126;
                     }
                  }

                  do {
                     if(this.field1699 < var4) {
                        return;
                     }

                     this.field1699 = var4 + var4 - 1 - this.field1699;
                     this.field1700 = -this.field1700;
                     if(--this.field1704 == 0) {
                        break;
                     }

                     if(this.field1699 >= var3) {
                        return;
                     }

                     this.field1699 = var3 + var3 - 1 - this.field1699;
                     this.field1700 = -this.field1700;
                  } while(--this.field1704 != 0);
               }
            } else {
               int var7;
               if(this.field1700 < 0) {
                  if(this.field1699 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1699) / var6;
                  if(var7 < this.field1704) {
                     this.field1699 += var6 * var7;
                     this.field1704 -= var7;
                     return;
                  }

                  this.field1699 += var6 * this.field1704;
                  this.field1704 = 0;
               } else {
                  if(this.field1699 < var4) {
                     return;
                  }

                  var7 = (this.field1699 - var3) / var6;
                  if(var7 < this.field1704) {
                     this.field1699 -= var6 * var7;
                     this.field1704 -= var7;
                     return;
                  }

                  this.field1699 -= var6 * this.field1704;
                  this.field1704 = 0;
               }
            }
         }

         if(this.field1700 < 0) {
            if(this.field1699 < 0) {
               this.field1699 = -1;
               this.method2153();
               this.unlink();
            }
         } else if(this.field1699 >= var5) {
            this.field1699 = var5;
            this.method2153();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("y")
   public synchronized void method2200(int var1) {
      int var2 = ((class108)super.field1729).field1618.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1699 = var1;
   }

   @ObfuscatedName("x")
   void method2251() {
      this.field1703 = this.field1705;
      this.field1701 = method2198(this.field1705, this.field1702);
      this.field1709 = method2141(this.field1705, this.field1702);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "()Lda;"
   )
   protected class120 vmethod3888() {
      return null;
   }

   @ObfuscatedName("ag")
   public boolean method2159() {
      return this.field1699 < 0 || this.field1699 >= ((class108)super.field1729).field1618.length << 8;
   }

   @ObfuscatedName("an")
   public synchronized void method2157(int var1) {
      if(this.field1700 < 0) {
         this.field1700 = -var1;
      } else {
         this.field1700 = var1;
      }

   }

   @ObfuscatedName("ao")
   public synchronized void method2199(int var1) {
      if(var1 == 0) {
         this.method2147(0);
         this.unlink();
      } else if(this.field1701 == 0 && this.field1709 == 0) {
         this.field1710 = 0;
         this.field1705 = 0;
         this.field1703 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1703;
         if(this.field1703 > var2) {
            var2 = this.field1703;
         }

         if(-this.field1701 > var2) {
            var2 = -this.field1701;
         }

         if(this.field1701 > var2) {
            var2 = this.field1701;
         }

         if(-this.field1709 > var2) {
            var2 = -this.field1709;
         }

         if(this.field1709 > var2) {
            var2 = this.field1709;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1710 = var1;
         this.field1705 = Integer.MIN_VALUE;
         this.field1711 = -this.field1703 / var1;
         this.field1712 = -this.field1701 / var1;
         this.field1713 = -this.field1709 / var1;
      }
   }

   @ObfuscatedName("n")
   void method2153() {
      if(this.field1710 != 0) {
         if(this.field1705 == Integer.MIN_VALUE) {
            this.field1705 = 0;
         }

         this.field1710 = 0;
         this.method2251();
      }

   }

   @ObfuscatedName("ap")
   public boolean method2204() {
      return this.field1710 != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2152() {
      this.field1700 = (this.field1700 ^ this.field1700 >> 31) + (this.field1700 >>> 31);
      this.field1700 = -this.field1700;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Lda;"
   )
   protected class120 vmethod3894() {
      return null;
   }

   @ObfuscatedName("ay")
   int vmethod2315() {
      int var1 = this.field1703 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1704 == 0) {
         var1 -= var1 * this.field1699 / (((class108)super.field1729).field1618.length << 8);
      } else if(this.field1704 >= 0) {
         var1 -= var1 * this.field1707 / ((class108)super.field1729).field1618.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("ar")
   public synchronized int method2158() {
      return this.field1700 < 0?-this.field1700:this.field1700;
   }

   @ObfuscatedName("aa")
   int method2270(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1710 > 0) {
            int var6 = var2 + this.field1710;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1710 += var2;
            if(this.field1700 == -256 && (this.field1699 & 255) == 0) {
               if(class135.highMemory) {
                  var2 = method2180(0, ((class108)super.field1729).field1618, var1, this.field1699, var2, this.field1701, this.field1709, this.field1712, this.field1713, 0, var6, var3, this);
               } else {
                  var2 = method2179(((class108)super.field1729).field1618, var1, this.field1699, var2, this.field1703, this.field1711, 0, var6, var3, this);
               }
            } else if(class135.highMemory) {
               var2 = method2216(0, 0, ((class108)super.field1729).field1618, var1, this.field1699, var2, this.field1701, this.field1709, this.field1712, this.field1713, 0, var6, var3, this, this.field1700, var5);
            } else {
               var2 = method2210(0, 0, ((class108)super.field1729).field1618, var1, this.field1699, var2, this.field1703, this.field1711, 0, var6, var3, this, this.field1700, var5);
            }

            this.field1710 -= var2;
            if(this.field1710 != 0) {
               return var2;
            }

            if(!this.method2168()) {
               continue;
            }

            return var4;
         }

         if(this.field1700 == -256 && (this.field1699 & 255) == 0) {
            if(class135.highMemory) {
               return method2172(0, ((class108)super.field1729).field1618, var1, this.field1699, var2, this.field1701, this.field1709, 0, var4, var3, this);
            }

            return method2171(((class108)super.field1729).field1618, var1, this.field1699, var2, this.field1703, 0, var4, var3, this);
         }

         if(class135.highMemory) {
            return method2176(0, 0, ((class108)super.field1729).field1618, var1, this.field1699, var2, this.field1701, this.field1709, 0, var4, var3, this, this.field1700, var5);
         }

         return method2175(0, 0, ((class108)super.field1729).field1618, var1, this.field1699, var2, this.field1703, 0, var4, var3, this, this.field1700, var5);
      }
   }

   @ObfuscatedName("v")
   public synchronized int method2149() {
      return this.field1705 == Integer.MIN_VALUE?0:this.field1705;
   }

   @ObfuscatedName("ai")
   boolean method2168() {
      int var1 = this.field1705;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2198(var1, this.field1702);
         var3 = method2141(var1, this.field1702);
      }

      if(var1 == this.field1703 && var2 == this.field1701 && var3 == this.field1709) {
         if(this.field1705 == Integer.MIN_VALUE) {
            this.field1705 = 0;
            this.field1709 = 0;
            this.field1701 = 0;
            this.field1703 = 0;
            this.unlink();
            return true;
         } else {
            this.method2251();
            return false;
         }
      } else {
         if(this.field1703 < var1) {
            this.field1711 = 1;
            this.field1710 = var1 - this.field1703;
         } else if(this.field1703 > var1) {
            this.field1711 = -1;
            this.field1710 = this.field1703 - var1;
         } else {
            this.field1711 = 0;
         }

         if(this.field1701 < var2) {
            this.field1712 = 1;
            if(this.field1710 == 0 || this.field1710 > var2 - this.field1701) {
               this.field1710 = var2 - this.field1701;
            }
         } else if(this.field1701 > var2) {
            this.field1712 = -1;
            if(this.field1710 == 0 || this.field1710 > this.field1701 - var2) {
               this.field1710 = this.field1701 - var2;
            }
         } else {
            this.field1712 = 0;
         }

         if(this.field1709 < var3) {
            this.field1713 = 1;
            if(this.field1710 == 0 || this.field1710 > var3 - this.field1709) {
               this.field1710 = var3 - this.field1709;
            }
         } else if(this.field1709 > var3) {
            this.field1713 = -1;
            if(this.field1710 == 0 || this.field1710 > this.field1709 - var3) {
               this.field1710 = this.field1709 - var3;
            }
         } else {
            this.field1713 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ad")
   int method2166(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1710 > 0) {
            int var6 = var2 + this.field1710;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1710 += var2;
            if(this.field1700 == 256 && (this.field1699 & 255) == 0) {
               if(class135.highMemory) {
                  var2 = method2182(0, ((class108)super.field1729).field1618, var1, this.field1699, var2, this.field1701, this.field1709, this.field1712, this.field1713, 0, var6, var3, this);
               } else {
                  var2 = method2177(((class108)super.field1729).field1618, var1, this.field1699, var2, this.field1703, this.field1711, 0, var6, var3, this);
               }
            } else if(class135.highMemory) {
               var2 = method2254(0, 0, ((class108)super.field1729).field1618, var1, this.field1699, var2, this.field1701, this.field1709, this.field1712, this.field1713, 0, var6, var3, this, this.field1700, var5);
            } else {
               var2 = method2181(0, 0, ((class108)super.field1729).field1618, var1, this.field1699, var2, this.field1703, this.field1711, 0, var6, var3, this, this.field1700, var5);
            }

            this.field1710 -= var2;
            if(this.field1710 != 0) {
               return var2;
            }

            if(!this.method2168()) {
               continue;
            }

            return var4;
         }

         if(this.field1700 == 256 && (this.field1699 & 255) == 0) {
            if(class135.highMemory) {
               return method2170(0, ((class108)super.field1729).field1618, var1, this.field1699, var2, this.field1701, this.field1709, 0, var4, var3, this);
            }

            return method2169(((class108)super.field1729).field1618, var1, this.field1699, var2, this.field1703, 0, var4, var3, this);
         }

         if(class135.highMemory) {
            return method2174(0, 0, ((class108)super.field1729).field1618, var1, this.field1699, var2, this.field1701, this.field1709, 0, var4, var3, this, this.field1700, var5);
         }

         return method2173(0, 0, ((class108)super.field1729).field1618, var1, this.field1699, var2, this.field1703, 0, var4, var3, this, this.field1700, var5);
      }
   }

   @ObfuscatedName("b")
   public synchronized void method2184(int var1) {
      this.field1704 = var1;
   }

   @ObfuscatedName("l")
   protected int vmethod3889() {
      return this.field1705 == 0 && this.field1710 == 0?0:1;
   }

   @ObfuscatedName("d")
   public synchronized void method2154(int var1, int var2) {
      this.method2155(var1, var2, this.method2183());
   }

   @ObfuscatedName("m")
   public synchronized void method2146(int var1) {
      this.method2145(var1 << 6, this.method2183());
   }

   @ObfuscatedName("j")
   static int method2198(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("h")
   static int method2141(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdq;II)I"
   )
   static int method2173(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class118 var10, int var11, int var12) {
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

      var10.field1699 = var4;
      return var5;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdq;II)I"
   )
   static int method2175(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class118 var10, int var11, int var12) {
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

      var10.field1699 = var4;
      return var5;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdq;)I"
   )
   static int method2169(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class118 var8) {
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

      var8.field1699 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdq;II)I"
   )
   static int method2174(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class118 var11, int var12, int var13) {
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

      var11.field1699 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdq;)I"
   )
   static int method2171(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class118 var8) {
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

      var8.field1699 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdq;II)I"
   )
   static int method2176(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class118 var11, int var12, int var13) {
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
         var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      var11.field1699 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdq;)I"
   )
   static int method2170(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class118 var10) {
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

      var10.field1699 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdq;)I"
   )
   static int method2172(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class118 var10) {
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

      var10.field1699 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdq;II)I"
   )
   static int method2181(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class118 var11, int var12, int var13) {
      var11.field1701 -= var11.field1712 * var5;
      var11.field1709 -= var11.field1713 * var5;
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      byte var14;
      int var10001;
      while(var5 < var8) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var4 & 255) * (var2[var1 + 1] - var14)) * var6 >> 6;
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

      var11.field1701 += var11.field1712 * var5;
      var11.field1709 += var11.field1713 * var5;
      var11.field1703 = var6;
      var11.field1699 = var4;
      return var5;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdq;II)I"
   )
   static int method2210(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class118 var11, int var12, int var13) {
      var11.field1701 -= var11.field1712 * var5;
      var11.field1709 -= var11.field1713 * var5;
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

      var11.field1701 += var11.field1712 * var5;
      var11.field1709 += var11.field1713 * var5;
      var11.field1703 = var6;
      var11.field1699 = var4;
      return var5;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdq;)I"
   )
   static int method2177(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class118 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1701 += var9.field1712 * (var6 - var3);
      var9.field1709 += var9.field1713 * (var6 - var3);

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

      var9.field1703 = var4 >> 2;
      var9.field1699 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdq;)I"
   )
   static int method2179(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class118 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1701 += var9.field1712 * (var6 - var3);
      var9.field1709 += var9.field1713 * (var6 - var3);

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

      var9.field1703 = var4 >> 2;
      var9.field1699 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdq;II)I"
   )
   static int method2254(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class118 var13, int var14, int var15) {
      var13.field1703 -= var5 * var13.field1711;
      if(var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      byte var16;
      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         var16 = var2[var1];
         var0 = (var16 << 8) + (var4 & 255) * (var2[var1 + 1] - var16);
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
      var13.field1703 += var5 * var13.field1711;
      var13.field1701 = var6;
      var13.field1709 = var7;
      var13.field1699 = var4;
      return var5;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdq;II)I"
   )
   static int method2216(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class118 var13, int var14, int var15) {
      var13.field1703 -= var5 * var13.field1711;
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
      var13.field1703 += var5 * var13.field1711;
      var13.field1701 = var6;
      var13.field1709 = var7;
      var13.field1699 = var4;
      return var5;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdq;)I"
   )
   static int method2182(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class118 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1703 += (var9 - var4) * var12.field1711;
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

      var12.field1701 = var5 >> 2;
      var12.field1709 = var6 >> 2;
      var12.field1699 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdq;)I"
   )
   static int method2180(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class118 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1703 += (var9 - var4) * var12.field1711;
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

      var12.field1701 = var5 >> 2;
      var12.field1709 = var6 >> 2;
      var12.field1699 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lde;III)Ldq;"
   )
   public static class118 method2261(class108 var0, int var1, int var2, int var3) {
      return var0.field1618 != null && var0.field1618.length != 0?new class118(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lde;II)Ldq;"
   )
   public static class118 method2232(class108 var0, int var1, int var2) {
      return var0.field1618 != null && var0.field1618.length != 0?new class118(var0, (int)((long)var0.field1615 * 256L * (long)var1 / (long)(AbstractSoundSystem.sampleRate * 100)), var2 << 6):null;
   }
}
