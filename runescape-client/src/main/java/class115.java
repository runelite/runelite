import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public class class115 extends class117 {
   @ObfuscatedName("p")
   int field1679;
   @ObfuscatedName("e")
   int field1678;
   @ObfuscatedName("q")
   int field1680;
   @ObfuscatedName("g")
   int field1683;
   @ObfuscatedName("o")
   int field1687;
   @ObfuscatedName("k")
   int field1676;
   @ObfuscatedName("d")
   int field1681;
   @ObfuscatedName("s")
   int field1690;
   @ObfuscatedName("v")
   int field1684;
   @ObfuscatedName("r")
   int field1682;
   @ObfuscatedName("t")
   int field1685;
   @ObfuscatedName("i")
   int field1689;
   @ObfuscatedName("u")
   int field1677;
   @ObfuscatedName("y")
   boolean field1688;
   @ObfuscatedName("b")
   int field1686;

   @ObfuscatedSignature(
      signature = "(Ldo;III)V"
   )
   class115(class105 var1, int var2, int var3, int var4) {
      super.field1705 = var1;
      this.field1684 = var1.field1598;
      this.field1685 = var1.field1595;
      this.field1688 = var1.field1599;
      this.field1676 = var2;
      this.field1678 = var3;
      this.field1679 = var4;
      this.field1681 = 0;
      this.method2209();
   }

   @ObfuscatedSignature(
      signature = "(Ldo;II)V"
   )
   class115(class105 var1, int var2, int var3) {
      super.field1705 = var1;
      this.field1684 = var1.field1598;
      this.field1685 = var1.field1595;
      this.field1688 = var1.field1599;
      this.field1676 = var2;
      this.field1678 = var3;
      this.field1679 = 8192;
      this.field1681 = 0;
      this.method2209();
   }

   @ObfuscatedName("c")
   public synchronized int method2251() {
      return this.field1679 < 0?-1:this.field1679;
   }

   @ObfuscatedName("i")
   synchronized void method2204(int var1) {
      this.method2207(var1, this.method2251());
   }

   @ObfuscatedName("u")
   synchronized void method2207(int var1, int var2) {
      this.field1678 = var1;
      this.field1679 = var2;
      this.field1687 = 0;
      this.method2209();
   }

   @ObfuscatedName("m")
   public synchronized void method2214(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2207(var2, var3);
      } else {
         int var4 = method2275(var2, var3);
         int var5 = method2228(var2, var3);
         if(var4 == this.field1690 && var5 == this.field1682) {
            this.field1687 = 0;
         } else {
            int var6 = var2 - this.field1680;
            if(this.field1680 - var2 > var6) {
               var6 = this.field1680 - var2;
            }

            if(var4 - this.field1690 > var6) {
               var6 = var4 - this.field1690;
            }

            if(this.field1690 - var4 > var6) {
               var6 = this.field1690 - var4;
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
            this.field1678 = var2;
            this.field1679 = var3;
            this.field1689 = (var2 - this.field1680) / var1;
            this.field1677 = (var4 - this.field1690) / var1;
            this.field1686 = (var5 - this.field1682) / var1;
         }
      }
   }

   @ObfuscatedName("v")
   public synchronized void vmethod4004(int[] var1, int var2, int var3) {
      if(this.field1678 == 0 && this.field1687 == 0) {
         this.vmethod4023(var3);
      } else {
         class105 var4 = (class105)super.field1705;
         int var5 = this.field1684 << 8;
         int var6 = this.field1685 << 8;
         int var7 = var4.field1596.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1683 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1681 < 0) {
            if(this.field1676 <= 0) {
               this.method2212();
               this.unlink();
               return;
            }

            this.field1681 = 0;
         }

         if(this.field1681 >= var7) {
            if(this.field1676 >= 0) {
               this.method2212();
               this.unlink();
               return;
            }

            this.field1681 = var7 - 1;
         }

         if(this.field1683 < 0) {
            if(this.field1688) {
               if(this.field1676 < 0) {
                  var9 = this.method2226(var1, var2, var5, var3, var4.field1596[this.field1684]);
                  if(this.field1681 >= var5) {
                     return;
                  }

                  this.field1681 = var5 + var5 - 1 - this.field1681;
                  this.field1676 = -this.field1676;
               }

               while(true) {
                  var9 = this.method2225(var1, var9, var6, var3, var4.field1596[this.field1685 - 1]);
                  if(this.field1681 < var6) {
                     return;
                  }

                  this.field1681 = var6 + var6 - 1 - this.field1681;
                  this.field1676 = -this.field1676;
                  var9 = this.method2226(var1, var9, var5, var3, var4.field1596[this.field1684]);
                  if(this.field1681 >= var5) {
                     return;
                  }

                  this.field1681 = var5 + var5 - 1 - this.field1681;
                  this.field1676 = -this.field1676;
               }
            } else if(this.field1676 < 0) {
               while(true) {
                  var9 = this.method2226(var1, var9, var5, var3, var4.field1596[this.field1685 - 1]);
                  if(this.field1681 >= var5) {
                     return;
                  }

                  this.field1681 = var6 - 1 - (var6 - 1 - this.field1681) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2225(var1, var9, var6, var3, var4.field1596[this.field1684]);
                  if(this.field1681 < var6) {
                     return;
                  }

                  this.field1681 = var5 + (this.field1681 - var5) % var8;
               }
            }
         } else {
            if(this.field1683 > 0) {
               if(this.field1688) {
                  label129: {
                     if(this.field1676 < 0) {
                        var9 = this.method2226(var1, var2, var5, var3, var4.field1596[this.field1684]);
                        if(this.field1681 >= var5) {
                           return;
                        }

                        this.field1681 = var5 + var5 - 1 - this.field1681;
                        this.field1676 = -this.field1676;
                        if(--this.field1683 == 0) {
                           break label129;
                        }
                     }

                     do {
                        var9 = this.method2225(var1, var9, var6, var3, var4.field1596[this.field1685 - 1]);
                        if(this.field1681 < var6) {
                           return;
                        }

                        this.field1681 = var6 + var6 - 1 - this.field1681;
                        this.field1676 = -this.field1676;
                        if(--this.field1683 == 0) {
                           break;
                        }

                        var9 = this.method2226(var1, var9, var5, var3, var4.field1596[this.field1684]);
                        if(this.field1681 >= var5) {
                           return;
                        }

                        this.field1681 = var5 + var5 - 1 - this.field1681;
                        this.field1676 = -this.field1676;
                     } while(--this.field1683 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1676 < 0) {
                     while(true) {
                        var9 = this.method2226(var1, var9, var5, var3, var4.field1596[this.field1685 - 1]);
                        if(this.field1681 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1681) / var8;
                        if(var10 >= this.field1683) {
                           this.field1681 += var8 * this.field1683;
                           this.field1683 = 0;
                           break;
                        }

                        this.field1681 += var8 * var10;
                        this.field1683 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2225(var1, var9, var6, var3, var4.field1596[this.field1684]);
                        if(this.field1681 < var6) {
                           return;
                        }

                        var10 = (this.field1681 - var5) / var8;
                        if(var10 >= this.field1683) {
                           this.field1681 -= var8 * this.field1683;
                           this.field1683 = 0;
                           break;
                        }

                        this.field1681 -= var8 * var10;
                        this.field1683 -= var10;
                     }
                  }
               }
            }

            if(this.field1676 < 0) {
               this.method2226(var1, var9, 0, var3, 0);
               if(this.field1681 < 0) {
                  this.field1681 = -1;
                  this.method2212();
                  this.unlink();
               }
            } else {
               this.method2225(var1, var9, var7, var3, 0);
               if(this.field1681 >= var7) {
                  this.field1681 = var7;
                  this.method2212();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("y")
   public synchronized void vmethod4023(int var1) {
      if(this.field1687 > 0) {
         if(var1 >= this.field1687) {
            if(this.field1678 == Integer.MIN_VALUE) {
               this.field1678 = 0;
               this.field1682 = 0;
               this.field1690 = 0;
               this.field1680 = 0;
               this.unlink();
               var1 = this.field1687;
            }

            this.field1687 = 0;
            this.method2209();
         } else {
            this.field1680 += this.field1689 * var1;
            this.field1690 += this.field1677 * var1;
            this.field1682 += this.field1686 * var1;
            this.field1687 -= var1;
         }
      }

      class105 var2 = (class105)super.field1705;
      int var3 = this.field1684 << 8;
      int var4 = this.field1685 << 8;
      int var5 = var2.field1596.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1683 = 0;
      }

      if(this.field1681 < 0) {
         if(this.field1676 <= 0) {
            this.method2212();
            this.unlink();
            return;
         }

         this.field1681 = 0;
      }

      if(this.field1681 >= var5) {
         if(this.field1676 >= 0) {
            this.method2212();
            this.unlink();
            return;
         }

         this.field1681 = var5 - 1;
      }

      this.field1681 += this.field1676 * var1;
      if(this.field1683 < 0) {
         if(!this.field1688) {
            if(this.field1676 < 0) {
               if(this.field1681 >= var3) {
                  return;
               }

               this.field1681 = var4 - 1 - (var4 - 1 - this.field1681) % var6;
            } else {
               if(this.field1681 < var4) {
                  return;
               }

               this.field1681 = var3 + (this.field1681 - var3) % var6;
            }

         } else {
            if(this.field1676 < 0) {
               if(this.field1681 >= var3) {
                  return;
               }

               this.field1681 = var3 + var3 - 1 - this.field1681;
               this.field1676 = -this.field1676;
            }

            while(this.field1681 >= var4) {
               this.field1681 = var4 + var4 - 1 - this.field1681;
               this.field1676 = -this.field1676;
               if(this.field1681 >= var3) {
                  return;
               }

               this.field1681 = var3 + var3 - 1 - this.field1681;
               this.field1676 = -this.field1676;
            }

         }
      } else {
         if(this.field1683 > 0) {
            if(this.field1688) {
               label120: {
                  if(this.field1676 < 0) {
                     if(this.field1681 >= var3) {
                        return;
                     }

                     this.field1681 = var3 + var3 - 1 - this.field1681;
                     this.field1676 = -this.field1676;
                     if(--this.field1683 == 0) {
                        break label120;
                     }
                  }

                  do {
                     if(this.field1681 < var4) {
                        return;
                     }

                     this.field1681 = var4 + var4 - 1 - this.field1681;
                     this.field1676 = -this.field1676;
                     if(--this.field1683 == 0) {
                        break;
                     }

                     if(this.field1681 >= var3) {
                        return;
                     }

                     this.field1681 = var3 + var3 - 1 - this.field1681;
                     this.field1676 = -this.field1676;
                  } while(--this.field1683 != 0);
               }
            } else {
               int var7;
               if(this.field1676 < 0) {
                  if(this.field1681 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1681) / var6;
                  if(var7 < this.field1683) {
                     this.field1681 += var6 * var7;
                     this.field1683 -= var7;
                     return;
                  }

                  this.field1681 += var6 * this.field1683;
                  this.field1683 = 0;
               } else {
                  if(this.field1681 < var4) {
                     return;
                  }

                  var7 = (this.field1681 - var3) / var6;
                  if(var7 < this.field1683) {
                     this.field1681 -= var6 * var7;
                     this.field1683 -= var7;
                     return;
                  }

                  this.field1681 -= var6 * this.field1683;
                  this.field1683 = 0;
               }
            }
         }

         if(this.field1676 < 0) {
            if(this.field1681 < 0) {
               this.field1681 = -1;
               this.method2212();
               this.unlink();
            }
         } else if(this.field1681 >= var5) {
            this.field1681 = var5;
            this.method2212();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("q")
   void method2209() {
      this.field1680 = this.field1678;
      this.field1690 = method2275(this.field1678, this.field1679);
      this.field1682 = method2228(this.field1678, this.field1679);
   }

   @ObfuscatedName("h")
   public synchronized void method2210(int var1) {
      int var2 = ((class105)super.field1705).field1596.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1681 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected class117 vmethod4002() {
      return null;
   }

   @ObfuscatedName("ab")
   public boolean method2219() {
      return this.field1681 < 0 || this.field1681 >= ((class105)super.field1705).field1596.length << 8;
   }

   @ObfuscatedName("ai")
   public synchronized void method2216(int var1) {
      if(this.field1676 < 0) {
         this.field1676 = -var1;
      } else {
         this.field1676 = var1;
      }

   }

   @ObfuscatedName("ae")
   public synchronized void method2198(int var1) {
      if(var1 == 0) {
         this.method2204(0);
         this.unlink();
      } else if(this.field1690 == 0 && this.field1682 == 0) {
         this.field1687 = 0;
         this.field1678 = 0;
         this.field1680 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1680;
         if(this.field1680 > var2) {
            var2 = this.field1680;
         }

         if(-this.field1690 > var2) {
            var2 = -this.field1690;
         }

         if(this.field1690 > var2) {
            var2 = this.field1690;
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
         this.field1678 = Integer.MIN_VALUE;
         this.field1689 = -this.field1680 / var1;
         this.field1677 = -this.field1690 / var1;
         this.field1686 = -this.field1682 / var1;
      }
   }

   @ObfuscatedName("w")
   void method2212() {
      if(this.field1687 != 0) {
         if(this.field1678 == Integer.MIN_VALUE) {
            this.field1678 = 0;
         }

         this.field1687 = 0;
         this.method2209();
      }

   }

   @ObfuscatedName("aa")
   public boolean method2340() {
      return this.field1687 != 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2297() {
      this.field1676 = (this.field1676 ^ this.field1676 >> 31) + (this.field1676 >>> 31);
      this.field1676 = -this.field1676;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected class117 vmethod4025() {
      return null;
   }

   @ObfuscatedName("ay")
   int vmethod2391() {
      int var1 = this.field1680 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1683 == 0) {
         var1 -= var1 * this.field1681 / (((class105)super.field1705).field1596.length << 8);
      } else if(this.field1683 >= 0) {
         var1 -= var1 * this.field1684 / ((class105)super.field1705).field1596.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("aw")
   int method2226(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1687 > 0) {
            int var6 = var2 + this.field1687;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1687 += var2;
            if(this.field1676 == -256 && (this.field1681 & 255) == 0) {
               if(class33.highMemory) {
                  var2 = method2328(0, ((class105)super.field1705).field1596, var1, this.field1681, var2, this.field1690, this.field1682, this.field1677, this.field1686, 0, var6, var3, this);
               } else {
                  var2 = method2237(((class105)super.field1705).field1596, var1, this.field1681, var2, this.field1680, this.field1689, 0, var6, var3, this);
               }
            } else if(class33.highMemory) {
               var2 = method2242(0, 0, ((class105)super.field1705).field1596, var1, this.field1681, var2, this.field1690, this.field1682, this.field1677, this.field1686, 0, var6, var3, this, this.field1676, var5);
            } else {
               var2 = method2267(0, 0, ((class105)super.field1705).field1596, var1, this.field1681, var2, this.field1680, this.field1689, 0, var6, var3, this, this.field1676, var5);
            }

            this.field1687 -= var2;
            if(this.field1687 != 0) {
               return var2;
            }

            if(!this.method2227()) {
               continue;
            }

            return var4;
         }

         if(this.field1676 == -256 && (this.field1681 & 255) == 0) {
            if(class33.highMemory) {
               return method2231(0, ((class105)super.field1705).field1596, var1, this.field1681, var2, this.field1690, this.field1682, 0, var4, var3, this);
            }

            return method2271(((class105)super.field1705).field1596, var1, this.field1681, var2, this.field1680, 0, var4, var3, this);
         }

         if(class33.highMemory) {
            return method2235(0, 0, ((class105)super.field1705).field1596, var1, this.field1681, var2, this.field1690, this.field1682, 0, var4, var3, this, this.field1676, var5);
         }

         return method2234(0, 0, ((class105)super.field1705).field1596, var1, this.field1681, var2, this.field1680, 0, var4, var3, this, this.field1676, var5);
      }
   }

   @ObfuscatedName("ah")
   public synchronized int method2248() {
      return this.field1676 < 0?-this.field1676:this.field1676;
   }

   @ObfuscatedName("ax")
   boolean method2227() {
      int var1 = this.field1678;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2275(var1, this.field1679);
         var3 = method2228(var1, this.field1679);
      }

      if(var1 == this.field1680 && var2 == this.field1690 && var3 == this.field1682) {
         if(this.field1678 == Integer.MIN_VALUE) {
            this.field1678 = 0;
            this.field1682 = 0;
            this.field1690 = 0;
            this.field1680 = 0;
            this.unlink();
            return true;
         } else {
            this.method2209();
            return false;
         }
      } else {
         if(this.field1680 < var1) {
            this.field1689 = 1;
            this.field1687 = var1 - this.field1680;
         } else if(this.field1680 > var1) {
            this.field1689 = -1;
            this.field1687 = this.field1680 - var1;
         } else {
            this.field1689 = 0;
         }

         if(this.field1690 < var2) {
            this.field1677 = 1;
            if(this.field1687 == 0 || this.field1687 > var2 - this.field1690) {
               this.field1687 = var2 - this.field1690;
            }
         } else if(this.field1690 > var2) {
            this.field1677 = -1;
            if(this.field1687 == 0 || this.field1687 > this.field1690 - var2) {
               this.field1687 = this.field1690 - var2;
            }
         } else {
            this.field1677 = 0;
         }

         if(this.field1682 < var3) {
            this.field1686 = 1;
            if(this.field1687 == 0 || this.field1687 > var3 - this.field1682) {
               this.field1687 = var3 - this.field1682;
            }
         } else if(this.field1682 > var3) {
            this.field1686 = -1;
            if(this.field1687 == 0 || this.field1687 > this.field1682 - var3) {
               this.field1687 = this.field1682 - var3;
            }
         } else {
            this.field1686 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("at")
   int method2225(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1687 > 0) {
            int var6 = var2 + this.field1687;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1687 += var2;
            if(this.field1676 == 256 && (this.field1681 & 255) == 0) {
               if(class33.highMemory) {
                  var2 = method2238(0, ((class105)super.field1705).field1596, var1, this.field1681, var2, this.field1690, this.field1682, this.field1677, this.field1686, 0, var6, var3, this);
               } else {
                  var2 = method2236(((class105)super.field1705).field1596, var1, this.field1681, var2, this.field1680, this.field1689, 0, var6, var3, this);
               }
            } else if(class33.highMemory) {
               var2 = method2240(0, 0, ((class105)super.field1705).field1596, var1, this.field1681, var2, this.field1690, this.field1682, this.field1677, this.field1686, 0, var6, var3, this, this.field1676, var5);
            } else {
               var2 = method2239(0, 0, ((class105)super.field1705).field1596, var1, this.field1681, var2, this.field1680, this.field1689, 0, var6, var3, this, this.field1676, var5);
            }

            this.field1687 -= var2;
            if(this.field1687 != 0) {
               return var2;
            }

            if(!this.method2227()) {
               continue;
            }

            return var4;
         }

         if(this.field1676 == 256 && (this.field1681 & 255) == 0) {
            if(class33.highMemory) {
               return method2229(0, ((class105)super.field1705).field1596, var1, this.field1681, var2, this.field1690, this.field1682, 0, var4, var3, this);
            }

            return method2215(((class105)super.field1705).field1596, var1, this.field1681, var2, this.field1680, 0, var4, var3, this);
         }

         if(class33.highMemory) {
            return method2233(0, 0, ((class105)super.field1705).field1596, var1, this.field1681, var2, this.field1690, this.field1682, 0, var4, var3, this, this.field1676, var5);
         }

         return method2232(0, 0, ((class105)super.field1705).field1596, var1, this.field1681, var2, this.field1680, 0, var4, var3, this, this.field1676, var5);
      }
   }

   @ObfuscatedName("x")
   public synchronized int method2350() {
      return this.field1678 == Integer.MIN_VALUE?0:this.field1678;
   }

   @ObfuscatedName("t")
   public synchronized void method2346(int var1) {
      this.field1683 = var1;
   }

   @ObfuscatedName("g")
   protected int vmethod4007() {
      return this.field1678 == 0 && this.field1687 == 0?0:1;
   }

   @ObfuscatedName("n")
   public synchronized void method2213(int var1, int var2) {
      this.method2214(var1, var2, this.method2251());
   }

   @ObfuscatedName("o")
   public synchronized void method2205(int var1) {
      this.method2207(var1 << 6, this.method2251());
   }

   @ObfuscatedName("d")
   static int method2275(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("k")
   static int method2228(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdx;II)I"
   )
   static int method2232(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 257) / var11) > var8) {
         var7 = var8;
      }

      byte var13;
      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         var13 = var2[var1];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var4 & 255) * (var2[var1 + 1] - var13)) * var6 >> 6;
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

      var10.field1681 = var4;
      return var5;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdx;II)I"
   )
   static int method2234(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var11 + (var9 + 256 - var4)) / var11) > var8) {
         var7 = var8;
      }

      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         byte var13 = var2[var1 - 1];
         var10001 = var5++;
         var3[var10001] += ((var2[var1] - var13) * (var4 & 255) + (var13 << 8)) * var6 >> 6;
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

      var10.field1681 = var4;
      return var5;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdx;)I"
   )
   static int method2215(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class115 var8) {
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

      var8.field1681 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdx;II)I"
   )
   static int method2233(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
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

      var11.field1681 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdx;)I"
   )
   static int method2271(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class115 var8) {
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

      var8.field1681 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdx;II)I"
   )
   static int method2235(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
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

      var11.field1681 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdx;)I"
   )
   static int method2229(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10) {
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

      var10.field1681 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdx;)I"
   )
   static int method2231(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10) {
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

      var10.field1681 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdx;II)I"
   )
   static int method2239(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
      var11.field1690 -= var11.field1677 * var5;
      var11.field1682 -= var11.field1686 * var5;
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

      var11.field1690 += var11.field1677 * var5;
      var11.field1682 += var11.field1686 * var5;
      var11.field1680 = var6;
      var11.field1681 = var4;
      return var5;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdx;II)I"
   )
   static int method2267(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
      var11.field1690 -= var11.field1677 * var5;
      var11.field1682 -= var11.field1686 * var5;
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

      var11.field1690 += var11.field1677 * var5;
      var11.field1682 += var11.field1686 * var5;
      var11.field1680 = var6;
      var11.field1681 = var4;
      return var5;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdx;)I"
   )
   static int method2236(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class115 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1690 += var9.field1677 * (var6 - var3);
      var9.field1682 += var9.field1686 * (var6 - var3);

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
      var9.field1681 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdx;)I"
   )
   static int method2237(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class115 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1690 += var9.field1677 * (var6 - var3);
      var9.field1682 += var9.field1686 * (var6 - var3);

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
      var9.field1681 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdx;II)I"
   )
   static int method2240(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class115 var13, int var14, int var15) {
      var13.field1680 -= var5 * var13.field1689;
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
      var13.field1680 += var5 * var13.field1689;
      var13.field1690 = var6;
      var13.field1682 = var7;
      var13.field1681 = var4;
      return var5;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdx;II)I"
   )
   static int method2242(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class115 var13, int var14, int var15) {
      var13.field1680 -= var5 * var13.field1689;
      if(var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         byte var16 = var2[var1 - 1];
         var0 = (var2[var1] - var16) * (var4 & 255) + (var16 << 8);
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
      var13.field1680 += var5 * var13.field1689;
      var13.field1690 = var6;
      var13.field1682 = var7;
      var13.field1681 = var4;
      return var5;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdx;)I"
   )
   static int method2238(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class115 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1680 += (var9 - var4) * var12.field1689;
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

      var12.field1690 = var5 >> 2;
      var12.field1682 = var6 >> 2;
      var12.field1681 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdx;)I"
   )
   static int method2328(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class115 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1680 += (var9 - var4) * var12.field1689;
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

      var12.field1690 = var5 >> 2;
      var12.field1682 = var6 >> 2;
      var12.field1681 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ldo;III)Ldx;"
   )
   public static class115 method2352(class105 var0, int var1, int var2, int var3) {
      return var0.field1596 != null && var0.field1596.length != 0?new class115(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ldo;II)Ldx;"
   )
   public static class115 method2201(class105 var0, int var1, int var2) {
      return var0.field1596 != null && var0.field1596.length != 0?new class115(var0, (int)((long)var0.field1597 * 256L * (long)var1 / (long)(class31.sampleRate * 100)), var2 << 6):null;
   }
}
