import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public class class115 extends class117 {
   @ObfuscatedName("s")
   int field1677;
   @ObfuscatedName("q")
   int field1688;
   @ObfuscatedName("o")
   int field1678;
   @ObfuscatedName("g")
   int field1679;
   @ObfuscatedName("v")
   int field1680;
   @ObfuscatedName("p")
   int field1687;
   @ObfuscatedName("e")
   int field1682;
   @ObfuscatedName("d")
   int field1683;
   @ObfuscatedName("x")
   int field1684;
   @ObfuscatedName("z")
   int field1685;
   @ObfuscatedName("n")
   boolean field1681;
   @ObfuscatedName("u")
   int field1676;
   @ObfuscatedName("t")
   int field1686;
   @ObfuscatedName("a")
   int field1689;
   @ObfuscatedName("i")
   int field1690;

   @ObfuscatedSignature(
      signature = "(Ldi;III)V"
   )
   class115(class105 var1, int var2, int var3, int var4) {
      super.field1705 = var1;
      this.field1684 = var1.field1599;
      this.field1685 = var1.field1601;
      this.field1681 = var1.field1603;
      this.field1688 = var2;
      this.field1678 = var3;
      this.field1679 = var4;
      this.field1677 = 0;
      this.method2174();
   }

   @ObfuscatedSignature(
      signature = "(Ldi;II)V"
   )
   class115(class105 var1, int var2, int var3) {
      super.field1705 = var1;
      this.field1684 = var1.field1599;
      this.field1685 = var1.field1601;
      this.field1681 = var1.field1603;
      this.field1688 = var2;
      this.field1678 = var3;
      this.field1679 = 8192;
      this.field1677 = 0;
      this.method2174();
   }

   @ObfuscatedName("g")
   void method2174() {
      this.field1680 = this.field1678;
      this.field1687 = method2269(this.field1678, this.field1679);
      this.field1682 = method2170(this.field1678, this.field1679);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Ldm;"
   )
   protected class117 vmethod3966() {
      return null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "()Ldm;"
   )
   protected class117 vmethod3967() {
      return null;
   }

   @ObfuscatedName("e")
   protected int vmethod3974() {
      return this.field1678 == 0 && this.field1676 == 0?0:1;
   }

   @ObfuscatedName("d")
   public synchronized void vmethod3968(int[] var1, int var2, int var3) {
      if(this.field1678 == 0 && this.field1676 == 0) {
         this.vmethod3981(var3);
      } else {
         class105 var4 = (class105)super.field1705;
         int var5 = this.field1684 << 8;
         int var6 = this.field1685 << 8;
         int var7 = var4.field1600.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1683 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1677 < 0) {
            if(this.field1688 <= 0) {
               this.method2183();
               this.unlink();
               return;
            }

            this.field1677 = 0;
         }

         if(this.field1677 >= var7) {
            if(this.field1688 >= 0) {
               this.method2183();
               this.unlink();
               return;
            }

            this.field1677 = var7 - 1;
         }

         if(this.field1683 < 0) {
            if(this.field1681) {
               if(this.field1688 < 0) {
                  var9 = this.method2197(var1, var2, var5, var3, var4.field1600[this.field1684]);
                  if(this.field1677 >= var5) {
                     return;
                  }

                  this.field1677 = var5 + var5 - 1 - this.field1677;
                  this.field1688 = -this.field1688;
               }

               while(true) {
                  var9 = this.method2196(var1, var9, var6, var3, var4.field1600[this.field1685 - 1]);
                  if(this.field1677 < var6) {
                     return;
                  }

                  this.field1677 = var6 + var6 - 1 - this.field1677;
                  this.field1688 = -this.field1688;
                  var9 = this.method2197(var1, var9, var5, var3, var4.field1600[this.field1684]);
                  if(this.field1677 >= var5) {
                     return;
                  }

                  this.field1677 = var5 + var5 - 1 - this.field1677;
                  this.field1688 = -this.field1688;
               }
            } else if(this.field1688 < 0) {
               while(true) {
                  var9 = this.method2197(var1, var9, var5, var3, var4.field1600[this.field1685 - 1]);
                  if(this.field1677 >= var5) {
                     return;
                  }

                  this.field1677 = var6 - 1 - (var6 - 1 - this.field1677) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2196(var1, var9, var6, var3, var4.field1600[this.field1684]);
                  if(this.field1677 < var6) {
                     return;
                  }

                  this.field1677 = var5 + (this.field1677 - var5) % var8;
               }
            }
         } else {
            if(this.field1683 > 0) {
               if(this.field1681) {
                  label120: {
                     if(this.field1688 < 0) {
                        var9 = this.method2197(var1, var2, var5, var3, var4.field1600[this.field1684]);
                        if(this.field1677 >= var5) {
                           return;
                        }

                        this.field1677 = var5 + var5 - 1 - this.field1677;
                        this.field1688 = -this.field1688;
                        if(--this.field1683 == 0) {
                           break label120;
                        }
                     }

                     do {
                        var9 = this.method2196(var1, var9, var6, var3, var4.field1600[this.field1685 - 1]);
                        if(this.field1677 < var6) {
                           return;
                        }

                        this.field1677 = var6 + var6 - 1 - this.field1677;
                        this.field1688 = -this.field1688;
                        if(--this.field1683 == 0) {
                           break;
                        }

                        var9 = this.method2197(var1, var9, var5, var3, var4.field1600[this.field1684]);
                        if(this.field1677 >= var5) {
                           return;
                        }

                        this.field1677 = var5 + var5 - 1 - this.field1677;
                        this.field1688 = -this.field1688;
                     } while(--this.field1683 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1688 < 0) {
                     while(true) {
                        var9 = this.method2197(var1, var9, var5, var3, var4.field1600[this.field1685 - 1]);
                        if(this.field1677 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1677) / var8;
                        if(var10 >= this.field1683) {
                           this.field1677 += var8 * this.field1683;
                           this.field1683 = 0;
                           break;
                        }

                        this.field1677 += var8 * var10;
                        this.field1683 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2196(var1, var9, var6, var3, var4.field1600[this.field1684]);
                        if(this.field1677 < var6) {
                           return;
                        }

                        var10 = (this.field1677 - var5) / var8;
                        if(var10 >= this.field1683) {
                           this.field1677 -= var8 * this.field1683;
                           this.field1683 = 0;
                           break;
                        }

                        this.field1677 -= var8 * var10;
                        this.field1683 -= var10;
                     }
                  }
               }
            }

            if(this.field1688 < 0) {
               this.method2197(var1, var9, 0, var3, 0);
               if(this.field1677 < 0) {
                  this.field1677 = -1;
                  this.method2183();
                  this.unlink();
               }
            } else {
               this.method2196(var1, var9, var7, var3, 0);
               if(this.field1677 >= var7) {
                  this.field1677 = var7;
                  this.method2183();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("x")
   public synchronized void method2175(int var1) {
      this.field1683 = var1;
   }

   @ObfuscatedName("u")
   public synchronized void vmethod3981(int var1) {
      if(this.field1676 > 0) {
         if(var1 >= this.field1676) {
            if(this.field1678 == Integer.MIN_VALUE) {
               this.field1678 = 0;
               this.field1682 = 0;
               this.field1687 = 0;
               this.field1680 = 0;
               this.unlink();
               var1 = this.field1676;
            }

            this.field1676 = 0;
            this.method2174();
         } else {
            this.field1680 += this.field1686 * var1;
            this.field1687 += this.field1689 * var1;
            this.field1682 += this.field1690 * var1;
            this.field1676 -= var1;
         }
      }

      class105 var2 = (class105)super.field1705;
      int var3 = this.field1684 << 8;
      int var4 = this.field1685 << 8;
      int var5 = var2.field1600.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1683 = 0;
      }

      if(this.field1677 < 0) {
         if(this.field1688 <= 0) {
            this.method2183();
            this.unlink();
            return;
         }

         this.field1677 = 0;
      }

      if(this.field1677 >= var5) {
         if(this.field1688 >= 0) {
            this.method2183();
            this.unlink();
            return;
         }

         this.field1677 = var5 - 1;
      }

      this.field1677 += this.field1688 * var1;
      if(this.field1683 < 0) {
         if(!this.field1681) {
            if(this.field1688 < 0) {
               if(this.field1677 >= var3) {
                  return;
               }

               this.field1677 = var4 - 1 - (var4 - 1 - this.field1677) % var6;
            } else {
               if(this.field1677 < var4) {
                  return;
               }

               this.field1677 = var3 + (this.field1677 - var3) % var6;
            }

         } else {
            if(this.field1688 < 0) {
               if(this.field1677 >= var3) {
                  return;
               }

               this.field1677 = var3 + var3 - 1 - this.field1677;
               this.field1688 = -this.field1688;
            }

            while(this.field1677 >= var4) {
               this.field1677 = var4 + var4 - 1 - this.field1677;
               this.field1688 = -this.field1688;
               if(this.field1677 >= var3) {
                  return;
               }

               this.field1677 = var3 + var3 - 1 - this.field1677;
               this.field1688 = -this.field1688;
            }

         }
      } else {
         if(this.field1683 > 0) {
            if(this.field1681) {
               label119: {
                  if(this.field1688 < 0) {
                     if(this.field1677 >= var3) {
                        return;
                     }

                     this.field1677 = var3 + var3 - 1 - this.field1677;
                     this.field1688 = -this.field1688;
                     if(--this.field1683 == 0) {
                        break label119;
                     }
                  }

                  do {
                     if(this.field1677 < var4) {
                        return;
                     }

                     this.field1677 = var4 + var4 - 1 - this.field1677;
                     this.field1688 = -this.field1688;
                     if(--this.field1683 == 0) {
                        break;
                     }

                     if(this.field1677 >= var3) {
                        return;
                     }

                     this.field1677 = var3 + var3 - 1 - this.field1677;
                     this.field1688 = -this.field1688;
                  } while(--this.field1683 != 0);
               }
            } else {
               int var7;
               if(this.field1688 < 0) {
                  if(this.field1677 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1677) / var6;
                  if(var7 < this.field1683) {
                     this.field1677 += var6 * var7;
                     this.field1683 -= var7;
                     return;
                  }

                  this.field1677 += var6 * this.field1683;
                  this.field1683 = 0;
               } else {
                  if(this.field1677 < var4) {
                     return;
                  }

                  var7 = (this.field1677 - var3) / var6;
                  if(var7 < this.field1683) {
                     this.field1677 -= var6 * var7;
                     this.field1683 -= var7;
                     return;
                  }

                  this.field1677 -= var6 * this.field1683;
                  this.field1683 = 0;
               }
            }
         }

         if(this.field1688 < 0) {
            if(this.field1677 < 0) {
               this.field1677 = -1;
               this.method2183();
               this.unlink();
            }
         } else if(this.field1677 >= var5) {
            this.field1677 = var5;
            this.method2183();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("i")
   public synchronized void method2176(int var1) {
      this.method2178(var1 << 6, this.method2244());
   }

   @ObfuscatedName("h")
   synchronized void method2237(int var1) {
      this.method2178(var1, this.method2244());
   }

   @ObfuscatedName("b")
   synchronized void method2178(int var1, int var2) {
      this.field1678 = var1;
      this.field1679 = var2;
      this.field1676 = 0;
      this.method2174();
   }

   @ObfuscatedName("j")
   public synchronized int method2299() {
      return this.field1678 == Integer.MIN_VALUE?0:this.field1678;
   }

   @ObfuscatedName("y")
   public synchronized int method2244() {
      return this.field1679 < 0?-1:this.field1679;
   }

   @ObfuscatedName("c")
   public synchronized void method2181(int var1) {
      int var2 = ((class105)super.field1705).field1600.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1677 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2251() {
      this.field1688 = (this.field1688 ^ this.field1688 >> 31) + (this.field1688 >>> 31);
      this.field1688 = -this.field1688;
   }

   @ObfuscatedName("m")
   void method2183() {
      if(this.field1676 != 0) {
         if(this.field1678 == Integer.MIN_VALUE) {
            this.field1678 = 0;
         }

         this.field1676 = 0;
         this.method2174();
      }

   }

   @ObfuscatedName("l")
   public synchronized void method2184(int var1, int var2) {
      this.method2185(var1, var2, this.method2244());
   }

   @ObfuscatedName("f")
   public synchronized void method2185(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2178(var2, var3);
      } else {
         int var4 = method2269(var2, var3);
         int var5 = method2170(var2, var3);
         if(var4 == this.field1687 && var5 == this.field1682) {
            this.field1676 = 0;
         } else {
            int var6 = var2 - this.field1680;
            if(this.field1680 - var2 > var6) {
               var6 = this.field1680 - var2;
            }

            if(var4 - this.field1687 > var6) {
               var6 = var4 - this.field1687;
            }

            if(this.field1687 - var4 > var6) {
               var6 = this.field1687 - var4;
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

            this.field1676 = var1;
            this.field1678 = var2;
            this.field1679 = var3;
            this.field1686 = (var2 - this.field1680) / var1;
            this.field1689 = (var4 - this.field1687) / var1;
            this.field1690 = (var5 - this.field1682) / var1;
         }
      }
   }

   @ObfuscatedName("ap")
   public synchronized void method2186(int var1) {
      if(var1 == 0) {
         this.method2237(0);
         this.unlink();
      } else if(this.field1687 == 0 && this.field1682 == 0) {
         this.field1676 = 0;
         this.field1678 = 0;
         this.field1680 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1680;
         if(this.field1680 > var2) {
            var2 = this.field1680;
         }

         if(-this.field1687 > var2) {
            var2 = -this.field1687;
         }

         if(this.field1687 > var2) {
            var2 = this.field1687;
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

         this.field1676 = var1;
         this.field1678 = Integer.MIN_VALUE;
         this.field1686 = -this.field1680 / var1;
         this.field1689 = -this.field1687 / var1;
         this.field1690 = -this.field1682 / var1;
      }
   }

   @ObfuscatedName("af")
   public synchronized void method2187(int var1) {
      if(this.field1688 < 0) {
         this.field1688 = -var1;
      } else {
         this.field1688 = var1;
      }

   }

   @ObfuscatedName("aa")
   public synchronized int method2188() {
      return this.field1688 < 0?-this.field1688:this.field1688;
   }

   @ObfuscatedName("ay")
   public boolean method2189() {
      return this.field1677 < 0 || this.field1677 >= ((class105)super.field1705).field1600.length << 8;
   }

   @ObfuscatedName("aw")
   public boolean method2259() {
      return this.field1676 != 0;
   }

   @ObfuscatedName("az")
   int method2196(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1676 > 0) {
            int var6 = var2 + this.field1676;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1676 += var2;
            if(this.field1688 == 256 && (this.field1677 & 255) == 0) {
               if(AbstractSoundSystem.highMemory) {
                  var2 = method2208(0, ((class105)super.field1705).field1600, var1, this.field1677, var2, this.field1687, this.field1682, this.field1689, this.field1690, 0, var6, var3, this);
               } else {
                  var2 = method2207(((class105)super.field1705).field1600, var1, this.field1677, var2, this.field1680, this.field1686, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.highMemory) {
               var2 = method2219(0, 0, ((class105)super.field1705).field1600, var1, this.field1677, var2, this.field1687, this.field1682, this.field1689, this.field1690, 0, var6, var3, this, this.field1688, var5);
            } else {
               var2 = method2211(0, 0, ((class105)super.field1705).field1600, var1, this.field1677, var2, this.field1680, this.field1686, 0, var6, var3, this, this.field1688, var5);
            }

            this.field1676 -= var2;
            if(this.field1676 != 0) {
               return var2;
            }

            if(!this.method2232()) {
               continue;
            }

            return var4;
         }

         if(this.field1688 == 256 && (this.field1677 & 255) == 0) {
            if(AbstractSoundSystem.highMemory) {
               return method2180(0, ((class105)super.field1705).field1600, var1, this.field1677, var2, this.field1687, this.field1682, 0, var4, var3, this);
            }

            return method2199(((class105)super.field1705).field1600, var1, this.field1677, var2, this.field1680, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.highMemory) {
            return method2204(0, 0, ((class105)super.field1705).field1600, var1, this.field1677, var2, this.field1687, this.field1682, 0, var4, var3, this, this.field1688, var5);
         }

         return method2267(0, 0, ((class105)super.field1705).field1600, var1, this.field1677, var2, this.field1680, 0, var4, var3, this, this.field1688, var5);
      }
   }

   @ObfuscatedName("ac")
   int method2197(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1676 > 0) {
            int var6 = var2 + this.field1676;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1676 += var2;
            if(this.field1688 == -256 && (this.field1677 & 255) == 0) {
               if(AbstractSoundSystem.highMemory) {
                  var2 = method2285(0, ((class105)super.field1705).field1600, var1, this.field1677, var2, this.field1687, this.field1682, this.field1689, this.field1690, 0, var6, var3, this);
               } else {
                  var2 = method2209(((class105)super.field1705).field1600, var1, this.field1677, var2, this.field1680, this.field1686, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.highMemory) {
               var2 = method2214(0, 0, ((class105)super.field1705).field1600, var1, this.field1677, var2, this.field1687, this.field1682, this.field1689, this.field1690, 0, var6, var3, this, this.field1688, var5);
            } else {
               var2 = method2182(0, 0, ((class105)super.field1705).field1600, var1, this.field1677, var2, this.field1680, this.field1686, 0, var6, var3, this, this.field1688, var5);
            }

            this.field1676 -= var2;
            if(this.field1676 != 0) {
               return var2;
            }

            if(!this.method2232()) {
               continue;
            }

            return var4;
         }

         if(this.field1688 == -256 && (this.field1677 & 255) == 0) {
            if(AbstractSoundSystem.highMemory) {
               return method2202(0, ((class105)super.field1705).field1600, var1, this.field1677, var2, this.field1687, this.field1682, 0, var4, var3, this);
            }

            return method2201(((class105)super.field1705).field1600, var1, this.field1677, var2, this.field1680, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.highMemory) {
            return method2206(0, 0, ((class105)super.field1705).field1600, var1, this.field1677, var2, this.field1687, this.field1682, 0, var4, var3, this, this.field1688, var5);
         }

         return method2205(0, 0, ((class105)super.field1705).field1600, var1, this.field1677, var2, this.field1680, 0, var4, var3, this, this.field1688, var5);
      }
   }

   @ObfuscatedName("ad")
   boolean method2232() {
      int var1 = this.field1678;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2269(var1, this.field1679);
         var3 = method2170(var1, this.field1679);
      }

      if(var1 == this.field1680 && var2 == this.field1687 && var3 == this.field1682) {
         if(this.field1678 == Integer.MIN_VALUE) {
            this.field1678 = 0;
            this.field1682 = 0;
            this.field1687 = 0;
            this.field1680 = 0;
            this.unlink();
            return true;
         } else {
            this.method2174();
            return false;
         }
      } else {
         if(this.field1680 < var1) {
            this.field1686 = 1;
            this.field1676 = var1 - this.field1680;
         } else if(this.field1680 > var1) {
            this.field1686 = -1;
            this.field1676 = this.field1680 - var1;
         } else {
            this.field1686 = 0;
         }

         if(this.field1687 < var2) {
            this.field1689 = 1;
            if(this.field1676 == 0 || this.field1676 > var2 - this.field1687) {
               this.field1676 = var2 - this.field1687;
            }
         } else if(this.field1687 > var2) {
            this.field1689 = -1;
            if(this.field1676 == 0 || this.field1676 > this.field1687 - var2) {
               this.field1676 = this.field1687 - var2;
            }
         } else {
            this.field1689 = 0;
         }

         if(this.field1682 < var3) {
            this.field1690 = 1;
            if(this.field1676 == 0 || this.field1676 > var3 - this.field1682) {
               this.field1676 = var3 - this.field1682;
            }
         } else if(this.field1682 > var3) {
            this.field1690 = -1;
            if(this.field1676 == 0 || this.field1676 > this.field1682 - var3) {
               this.field1676 = this.field1682 - var3;
            }
         } else {
            this.field1690 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ag")
   int vmethod2359() {
      int var1 = this.field1680 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1683 == 0) {
         var1 -= var1 * this.field1677 / (((class105)super.field1705).field1600.length << 8);
      } else if(this.field1683 >= 0) {
         var1 -= var1 * this.field1684 / ((class105)super.field1705).field1600.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("w")
   static int method2269(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("s")
   static int method2170(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ldi;II)Ldl;"
   )
   public static class115 method2314(class105 var0, int var1, int var2) {
      return var0.field1600 != null && var0.field1600.length != 0?new class115(var0, (int)((long)var0.field1602 * 256L * (long)var1 / (long)(AbstractSoundSystem.sampleRate * 100)), var2 << 6):null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ldi;III)Ldl;"
   )
   public static class115 method2173(class105 var0, int var1, int var2, int var3) {
      return var0.field1600 != null && var0.field1600.length != 0?new class115(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdl;)I"
   )
   static int method2199(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class115 var8) {
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

      var8.field1677 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdl;)I"
   )
   static int method2180(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10) {
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

      var10.field1677 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdl;)I"
   )
   static int method2201(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class115 var8) {
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

      var8.field1677 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdl;)I"
   )
   static int method2202(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10) {
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

      var10.field1677 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdl;II)I"
   )
   static int method2267(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10, int var11, int var12) {
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

      var10.field1677 = var4;
      return var5;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdl;II)I"
   )
   static int method2204(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      byte var14;
      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var0 = (var14 << 8) + (var4 & 255) * (var2[var1 + 1] - var14);
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

      var11.field1677 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdl;II)I"
   )
   static int method2205(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var11 + (var9 + 256 - var4)) / var11) > var8) {
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

      var10.field1677 = var4;
      return var5;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdl;II)I"
   )
   static int method2206(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
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

      var11.field1677 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdl;)I"
   )
   static int method2207(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class115 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1687 += var9.field1689 * (var6 - var3);
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
      var9.field1677 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdl;)I"
   )
   static int method2208(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class115 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1680 += var12.field1686 * (var9 - var4);
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

      var12.field1687 = var5 >> 2;
      var12.field1682 = var6 >> 2;
      var12.field1677 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdl;)I"
   )
   static int method2209(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class115 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1687 += var9.field1689 * (var6 - var3);
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
      var9.field1677 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdl;)I"
   )
   static int method2285(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class115 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1680 += var12.field1686 * (var9 - var4);
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

      var12.field1687 = var5 >> 2;
      var12.field1682 = var6 >> 2;
      var12.field1677 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdl;II)I"
   )
   static int method2211(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
      var11.field1687 -= var11.field1689 * var5;
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

      var11.field1687 += var11.field1689 * var5;
      var11.field1682 += var11.field1690 * var5;
      var11.field1680 = var6;
      var11.field1677 = var4;
      return var5;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdl;II)I"
   )
   static int method2219(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class115 var13, int var14, int var15) {
      var13.field1680 -= var5 * var13.field1686;
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
      var13.field1680 += var13.field1686 * var5;
      var13.field1687 = var6;
      var13.field1682 = var7;
      var13.field1677 = var4;
      return var5;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdl;II)I"
   )
   static int method2182(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
      var11.field1687 -= var11.field1689 * var5;
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

      var11.field1687 += var11.field1689 * var5;
      var11.field1682 += var11.field1690 * var5;
      var11.field1680 = var6;
      var11.field1677 = var4;
      return var5;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdl;II)I"
   )
   static int method2214(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class115 var13, int var14, int var15) {
      var13.field1680 -= var5 * var13.field1686;
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
      var13.field1680 += var13.field1686 * var5;
      var13.field1687 = var6;
      var13.field1682 = var7;
      var13.field1677 = var4;
      return var5;
   }
}
