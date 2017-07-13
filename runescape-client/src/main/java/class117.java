import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
public class class117 extends class119 {
   @ObfuscatedName("r")
   int field1680;
   @ObfuscatedName("n")
   int field1691;
   @ObfuscatedName("v")
   int field1677;
   @ObfuscatedName("s")
   int field1681;
   @ObfuscatedName("g")
   int field1688;
   @ObfuscatedName("j")
   int field1678;
   @ObfuscatedName("a")
   int field1690;
   @ObfuscatedName("e")
   int field1682;
   @ObfuscatedName("p")
   int field1685;
   @ObfuscatedName("l")
   int field1683;
   @ObfuscatedName("m")
   int field1686;
   @ObfuscatedName("k")
   int field1689;
   @ObfuscatedName("t")
   int field1684;
   @ObfuscatedName("u")
   boolean field1687;
   @ObfuscatedName("c")
   int field1679;

   class117(class107 var1, int var2, int var3, int var4) {
      super.field1706 = var1;
      this.field1685 = var1.field1605;
      this.field1686 = var1.field1606;
      this.field1687 = var1.field1604;
      this.field1678 = var2;
      this.field1691 = var3;
      this.field1680 = var4;
      this.field1690 = 0;
      this.method2162();
   }

   class117(class107 var1, int var2, int var3) {
      super.field1706 = var1;
      this.field1685 = var1.field1605;
      this.field1686 = var1.field1606;
      this.field1687 = var1.field1604;
      this.field1678 = var2;
      this.field1691 = var3;
      this.field1680 = 8192;
      this.field1690 = 0;
      this.method2162();
   }

   @ObfuscatedName("o")
   public synchronized int method2135() {
      return this.field1680 < 0?-1:this.field1680;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method2255(int var1) {
      this.method2115(var1, this.method2135());
   }

   @ObfuscatedName("k")
   synchronized void method2115(int var1, int var2) {
      this.field1691 = var1;
      this.field1680 = var2;
      this.field1688 = 0;
      this.method2162();
   }

   @ObfuscatedName("d")
   public synchronized void method2113(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2115(var2, var3);
      } else {
         int var4 = method2134(var2, var3);
         int var5 = method2106(var2, var3);
         if(var4 == this.field1682 && var5 == this.field1683) {
            this.field1688 = 0;
         } else {
            int var6 = var2 - this.field1677;
            if(this.field1677 - var2 > var6) {
               var6 = this.field1677 - var2;
            }

            if(var4 - this.field1682 > var6) {
               var6 = var4 - this.field1682;
            }

            if(this.field1682 - var4 > var6) {
               var6 = this.field1682 - var4;
            }

            if(var5 - this.field1683 > var6) {
               var6 = var5 - this.field1683;
            }

            if(this.field1683 - var5 > var6) {
               var6 = this.field1683 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1688 = var1;
            this.field1691 = var2;
            this.field1680 = var3;
            this.field1689 = (var2 - this.field1677) / var1;
            this.field1684 = (var4 - this.field1682) / var1;
            this.field1679 = (var5 - this.field1683) / var1;
         }
      }
   }

   @ObfuscatedName("w")
   public synchronized void vmethod3872(int[] var1, int var2, int var3) {
      if(this.field1691 == 0 && this.field1688 == 0) {
         this.vmethod3869(var3);
      } else {
         class107 var4 = (class107)super.field1706;
         int var5 = this.field1685 << 8;
         int var6 = this.field1686 << 8;
         int var7 = var4.field1607.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1681 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1690 < 0) {
            if(this.field1678 <= 0) {
               this.method2120();
               this.unlink();
               return;
            }

            this.field1690 = 0;
         }

         if(this.field1690 >= var7) {
            if(this.field1678 >= 0) {
               this.method2120();
               this.unlink();
               return;
            }

            this.field1690 = var7 - 1;
         }

         if(this.field1681 < 0) {
            if(this.field1687) {
               if(this.field1678 < 0) {
                  var9 = this.method2191(var1, var2, var5, var3, var4.field1607[this.field1685]);
                  if(this.field1690 >= var5) {
                     return;
                  }

                  this.field1690 = var5 + var5 - 1 - this.field1690;
                  this.field1678 = -this.field1678;
               }

               while(true) {
                  var9 = this.method2133(var1, var9, var6, var3, var4.field1607[this.field1686 - 1]);
                  if(this.field1690 < var6) {
                     return;
                  }

                  this.field1690 = var6 + var6 - 1 - this.field1690;
                  this.field1678 = -this.field1678;
                  var9 = this.method2191(var1, var9, var5, var3, var4.field1607[this.field1685]);
                  if(this.field1690 >= var5) {
                     return;
                  }

                  this.field1690 = var5 + var5 - 1 - this.field1690;
                  this.field1678 = -this.field1678;
               }
            } else if(this.field1678 < 0) {
               while(true) {
                  var9 = this.method2191(var1, var9, var5, var3, var4.field1607[this.field1686 - 1]);
                  if(this.field1690 >= var5) {
                     return;
                  }

                  this.field1690 = var6 - 1 - (var6 - 1 - this.field1690) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2133(var1, var9, var6, var3, var4.field1607[this.field1685]);
                  if(this.field1690 < var6) {
                     return;
                  }

                  this.field1690 = var5 + (this.field1690 - var5) % var8;
               }
            }
         } else {
            if(this.field1681 > 0) {
               if(this.field1687) {
                  label135: {
                     if(this.field1678 < 0) {
                        var9 = this.method2191(var1, var2, var5, var3, var4.field1607[this.field1685]);
                        if(this.field1690 >= var5) {
                           return;
                        }

                        this.field1690 = var5 + var5 - 1 - this.field1690;
                        this.field1678 = -this.field1678;
                        if(--this.field1681 == 0) {
                           break label135;
                        }
                     }

                     do {
                        var9 = this.method2133(var1, var9, var6, var3, var4.field1607[this.field1686 - 1]);
                        if(this.field1690 < var6) {
                           return;
                        }

                        this.field1690 = var6 + var6 - 1 - this.field1690;
                        this.field1678 = -this.field1678;
                        if(--this.field1681 == 0) {
                           break;
                        }

                        var9 = this.method2191(var1, var9, var5, var3, var4.field1607[this.field1685]);
                        if(this.field1690 >= var5) {
                           return;
                        }

                        this.field1690 = var5 + var5 - 1 - this.field1690;
                        this.field1678 = -this.field1678;
                     } while(--this.field1681 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1678 < 0) {
                     while(true) {
                        var9 = this.method2191(var1, var9, var5, var3, var4.field1607[this.field1686 - 1]);
                        if(this.field1690 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1690) / var8;
                        if(var10 >= this.field1681) {
                           this.field1690 += var8 * this.field1681;
                           this.field1681 = 0;
                           break;
                        }

                        this.field1690 += var8 * var10;
                        this.field1681 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2133(var1, var9, var6, var3, var4.field1607[this.field1685]);
                        if(this.field1690 < var6) {
                           return;
                        }

                        var10 = (this.field1690 - var5) / var8;
                        if(var10 >= this.field1681) {
                           this.field1690 -= var8 * this.field1681;
                           this.field1681 = 0;
                           break;
                        }

                        this.field1690 -= var8 * var10;
                        this.field1681 -= var10;
                     }
                  }
               }
            }

            if(this.field1678 < 0) {
               this.method2191(var1, var9, 0, var3, 0);
               if(this.field1690 < 0) {
                  this.field1690 = -1;
                  this.method2120();
                  this.unlink();
               }
            } else {
               this.method2133(var1, var9, var7, var3, 0);
               if(this.field1690 >= var7) {
                  this.field1690 = var7;
                  this.method2120();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("m")
   public synchronized void vmethod3869(int var1) {
      if(this.field1688 > 0) {
         if(var1 >= this.field1688) {
            if(this.field1691 == Integer.MIN_VALUE) {
               this.field1691 = 0;
               this.field1683 = 0;
               this.field1682 = 0;
               this.field1677 = 0;
               this.unlink();
               var1 = this.field1688;
            }

            this.field1688 = 0;
            this.method2162();
         } else {
            this.field1677 += this.field1689 * var1;
            this.field1682 += this.field1684 * var1;
            this.field1683 += this.field1679 * var1;
            this.field1688 -= var1;
         }
      }

      class107 var2 = (class107)super.field1706;
      int var3 = this.field1685 << 8;
      int var4 = this.field1686 << 8;
      int var5 = var2.field1607.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1681 = 0;
      }

      if(this.field1690 < 0) {
         if(this.field1678 <= 0) {
            this.method2120();
            this.unlink();
            return;
         }

         this.field1690 = 0;
      }

      if(this.field1690 >= var5) {
         if(this.field1678 >= 0) {
            this.method2120();
            this.unlink();
            return;
         }

         this.field1690 = var5 - 1;
      }

      this.field1690 += this.field1678 * var1;
      if(this.field1681 < 0) {
         if(!this.field1687) {
            if(this.field1678 < 0) {
               if(this.field1690 >= var3) {
                  return;
               }

               this.field1690 = var4 - 1 - (var4 - 1 - this.field1690) % var6;
            } else {
               if(this.field1690 < var4) {
                  return;
               }

               this.field1690 = var3 + (this.field1690 - var3) % var6;
            }

         } else {
            if(this.field1678 < 0) {
               if(this.field1690 >= var3) {
                  return;
               }

               this.field1690 = var3 + var3 - 1 - this.field1690;
               this.field1678 = -this.field1678;
            }

            while(this.field1690 >= var4) {
               this.field1690 = var4 + var4 - 1 - this.field1690;
               this.field1678 = -this.field1678;
               if(this.field1690 >= var3) {
                  return;
               }

               this.field1690 = var3 + var3 - 1 - this.field1690;
               this.field1678 = -this.field1678;
            }

         }
      } else {
         if(this.field1681 > 0) {
            if(this.field1687) {
               label126: {
                  if(this.field1678 < 0) {
                     if(this.field1690 >= var3) {
                        return;
                     }

                     this.field1690 = var3 + var3 - 1 - this.field1690;
                     this.field1678 = -this.field1678;
                     if(--this.field1681 == 0) {
                        break label126;
                     }
                  }

                  do {
                     if(this.field1690 < var4) {
                        return;
                     }

                     this.field1690 = var4 + var4 - 1 - this.field1690;
                     this.field1678 = -this.field1678;
                     if(--this.field1681 == 0) {
                        break;
                     }

                     if(this.field1690 >= var3) {
                        return;
                     }

                     this.field1690 = var3 + var3 - 1 - this.field1690;
                     this.field1678 = -this.field1678;
                  } while(--this.field1681 != 0);
               }
            } else {
               int var7;
               if(this.field1678 < 0) {
                  if(this.field1690 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1690) / var6;
                  if(var7 < this.field1681) {
                     this.field1690 += var6 * var7;
                     this.field1681 -= var7;
                     return;
                  }

                  this.field1690 += var6 * this.field1681;
                  this.field1681 = 0;
               } else {
                  if(this.field1690 < var4) {
                     return;
                  }

                  var7 = (this.field1690 - var3) / var6;
                  if(var7 < this.field1681) {
                     this.field1690 -= var6 * var7;
                     this.field1681 -= var7;
                     return;
                  }

                  this.field1690 -= var6 * this.field1681;
                  this.field1681 = 0;
               }
            }
         }

         if(this.field1678 < 0) {
            if(this.field1690 < 0) {
               this.field1690 = -1;
               this.method2120();
               this.unlink();
            }
         } else if(this.field1690 >= var5) {
            this.field1690 = var5;
            this.method2120();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("x")
   public synchronized void method2165(int var1) {
      int var2 = ((class107)super.field1706).field1607.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1690 = var1;
   }

   @ObfuscatedName("v")
   void method2162() {
      this.field1677 = this.field1691;
      this.field1682 = method2134(this.field1691, this.field1680);
      this.field1683 = method2106(this.field1691, this.field1680);
   }

   @ObfuscatedName("l")
   protected class119 vmethod3882() {
      return null;
   }

   @ObfuscatedName("as")
   public boolean method2126() {
      return this.field1690 < 0 || this.field1690 >= ((class107)super.field1706).field1607.length << 8;
   }

   @ObfuscatedName("ag")
   public synchronized void method2124(int var1) {
      if(this.field1678 < 0) {
         this.field1678 = -var1;
      } else {
         this.field1678 = var1;
      }

   }

   @ObfuscatedName("aa")
   public synchronized void method2123(int var1) {
      if(var1 == 0) {
         this.method2255(0);
         this.unlink();
      } else if(this.field1682 == 0 && this.field1683 == 0) {
         this.field1688 = 0;
         this.field1691 = 0;
         this.field1677 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1677;
         if(this.field1677 > var2) {
            var2 = this.field1677;
         }

         if(-this.field1682 > var2) {
            var2 = -this.field1682;
         }

         if(this.field1682 > var2) {
            var2 = this.field1682;
         }

         if(-this.field1683 > var2) {
            var2 = -this.field1683;
         }

         if(this.field1683 > var2) {
            var2 = this.field1683;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1688 = var1;
         this.field1691 = Integer.MIN_VALUE;
         this.field1689 = -this.field1677 / var1;
         this.field1684 = -this.field1682 / var1;
         this.field1679 = -this.field1683 / var1;
      }
   }

   @ObfuscatedName("av")
   public boolean method2127() {
      return this.field1688 != 0;
   }

   @ObfuscatedName("z")
   void method2120() {
      if(this.field1688 != 0) {
         if(this.field1691 == Integer.MIN_VALUE) {
            this.field1691 = 0;
         }

         this.field1688 = 0;
         this.method2162();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2119() {
      this.field1678 = (this.field1678 ^ this.field1678 >> 31) + (this.field1678 >>> 31);
      this.field1678 = -this.field1678;
   }

   @ObfuscatedName("e")
   protected class119 vmethod3883() {
      return null;
   }

   @ObfuscatedName("al")
   int vmethod2292() {
      int var1 = this.field1677 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1681 == 0) {
         var1 -= var1 * this.field1690 / (((class107)super.field1706).field1607.length << 8);
      } else if(this.field1681 >= 0) {
         var1 -= var1 * this.field1685 / ((class107)super.field1706).field1607.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("aj")
   public synchronized int method2129() {
      return this.field1678 < 0?-this.field1678:this.field1678;
   }

   @ObfuscatedName("c")
   public synchronized int method2116() {
      return this.field1691 == Integer.MIN_VALUE?0:this.field1691;
   }

   @ObfuscatedName("ah")
   boolean method2122() {
      int var1 = this.field1691;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2134(var1, this.field1680);
         var3 = method2106(var1, this.field1680);
      }

      if(var1 == this.field1677 && var2 == this.field1682 && var3 == this.field1683) {
         if(this.field1691 == Integer.MIN_VALUE) {
            this.field1691 = 0;
            this.field1683 = 0;
            this.field1682 = 0;
            this.field1677 = 0;
            this.unlink();
            return true;
         } else {
            this.method2162();
            return false;
         }
      } else {
         if(this.field1677 < var1) {
            this.field1689 = 1;
            this.field1688 = var1 - this.field1677;
         } else if(this.field1677 > var1) {
            this.field1689 = -1;
            this.field1688 = this.field1677 - var1;
         } else {
            this.field1689 = 0;
         }

         if(this.field1682 < var2) {
            this.field1684 = 1;
            if(this.field1688 == 0 || this.field1688 > var2 - this.field1682) {
               this.field1688 = var2 - this.field1682;
            }
         } else if(this.field1682 > var2) {
            this.field1684 = -1;
            if(this.field1688 == 0 || this.field1688 > this.field1682 - var2) {
               this.field1688 = this.field1682 - var2;
            }
         } else {
            this.field1684 = 0;
         }

         if(this.field1683 < var3) {
            this.field1679 = 1;
            if(this.field1688 == 0 || this.field1688 > var3 - this.field1683) {
               this.field1688 = var3 - this.field1683;
            }
         } else if(this.field1683 > var3) {
            this.field1679 = -1;
            if(this.field1688 == 0 || this.field1688 > this.field1683 - var3) {
               this.field1688 = this.field1683 - var3;
            }
         } else {
            this.field1679 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ab")
   int method2133(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1688 > 0) {
            int var6 = var2 + this.field1688;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1688 += var2;
            if(this.field1678 == 256 && (this.field1690 & 255) == 0) {
               if(AbstractSoundSystem.highMemory) {
                  var2 = method2145(0, ((class107)super.field1706).field1607, var1, this.field1690, var2, this.field1682, this.field1683, this.field1684, this.field1679, 0, var6, var3, this);
               } else {
                  var2 = method2171(((class107)super.field1706).field1607, var1, this.field1690, var2, this.field1677, this.field1689, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.highMemory) {
               var2 = method2121(0, 0, ((class107)super.field1706).field1607, var1, this.field1690, var2, this.field1682, this.field1683, this.field1684, this.field1679, 0, var6, var3, this, this.field1678, var5);
            } else {
               var2 = method2148(0, 0, ((class107)super.field1706).field1607, var1, this.field1690, var2, this.field1677, this.field1689, 0, var6, var3, this, this.field1678, var5);
            }

            this.field1688 -= var2;
            if(this.field1688 != 0) {
               return var2;
            }

            if(!this.method2122()) {
               continue;
            }

            return var4;
         }

         if(this.field1678 == 256 && (this.field1690 & 255) == 0) {
            if(AbstractSoundSystem.highMemory) {
               return method2137(0, ((class107)super.field1706).field1607, var1, this.field1690, var2, this.field1682, this.field1683, 0, var4, var3, this);
            }

            return method2210(((class107)super.field1706).field1607, var1, this.field1690, var2, this.field1677, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.highMemory) {
            return method2169(0, 0, ((class107)super.field1706).field1607, var1, this.field1690, var2, this.field1682, this.field1683, 0, var4, var3, this, this.field1678, var5);
         }

         return method2140(0, 0, ((class107)super.field1706).field1607, var1, this.field1690, var2, this.field1677, 0, var4, var3, this, this.field1678, var5);
      }
   }

   @ObfuscatedName("at")
   int method2191(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1688 > 0) {
            int var6 = var2 + this.field1688;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1688 += var2;
            if(this.field1678 == -256 && (this.field1690 & 255) == 0) {
               if(AbstractSoundSystem.highMemory) {
                  var2 = method2147(0, ((class107)super.field1706).field1607, var1, this.field1690, var2, this.field1682, this.field1683, this.field1684, this.field1679, 0, var6, var3, this);
               } else {
                  var2 = method2146(((class107)super.field1706).field1607, var1, this.field1690, var2, this.field1677, this.field1689, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.highMemory) {
               var2 = method2151(0, 0, ((class107)super.field1706).field1607, var1, this.field1690, var2, this.field1682, this.field1683, this.field1684, this.field1679, 0, var6, var3, this, this.field1678, var5);
            } else {
               var2 = method2150(0, 0, ((class107)super.field1706).field1607, var1, this.field1690, var2, this.field1677, this.field1689, 0, var6, var3, this, this.field1678, var5);
            }

            this.field1688 -= var2;
            if(this.field1688 != 0) {
               return var2;
            }

            if(!this.method2122()) {
               continue;
            }

            return var4;
         }

         if(this.field1678 == -256 && (this.field1690 & 255) == 0) {
            if(AbstractSoundSystem.highMemory) {
               return method2139(0, ((class107)super.field1706).field1607, var1, this.field1690, var2, this.field1682, this.field1683, 0, var4, var3, this);
            }

            return method2138(((class107)super.field1706).field1607, var1, this.field1690, var2, this.field1677, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.highMemory) {
            return method2143(0, 0, ((class107)super.field1706).field1607, var1, this.field1690, var2, this.field1682, this.field1683, 0, var4, var3, this, this.field1678, var5);
         }

         return method2142(0, 0, ((class107)super.field1706).field1607, var1, this.field1690, var2, this.field1677, 0, var4, var3, this, this.field1678, var5);
      }
   }

   @ObfuscatedName("p")
   public synchronized void method2212(int var1) {
      this.field1681 = var1;
   }

   @ObfuscatedName("s")
   protected int vmethod3871() {
      return this.field1691 == 0 && this.field1688 == 0?0:1;
   }

   @ObfuscatedName("i")
   public synchronized void method2110(int var1, int var2) {
      this.method2113(var1, var2, this.method2135());
   }

   @ObfuscatedName("u")
   public synchronized void method2117(int var1) {
      this.method2115(var1 << 6, this.method2135());
   }

   @ObfuscatedName("a")
   static int method2134(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("j")
   static int method2106(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("af")
   static int method2140(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10, int var11, int var12) {
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

      var10.field1690 = var4;
      return var5;
   }

   @ObfuscatedName("bi")
   static int method2142(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10, int var11, int var12) {
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

      var10.field1690 = var4;
      return var5;
   }

   @ObfuscatedName("an")
   static int method2210(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class117 var8) {
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

      var8.field1690 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bp")
   static int method2169(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
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

      var11.field1690 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ao")
   static int method2138(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class117 var8) {
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

      var8.field1690 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ba")
   static int method2143(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
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

      var11.field1690 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ay")
   static int method2137(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10) {
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

      var10.field1690 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ac")
   static int method2139(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10) {
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

      var10.field1690 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bn")
   static int method2148(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
      var11.field1682 -= var11.field1684 * var5;
      var11.field1683 -= var11.field1679 * var5;
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

      var11.field1682 += var11.field1684 * var5;
      var11.field1683 += var11.field1679 * var5;
      var11.field1677 = var6;
      var11.field1690 = var4;
      return var5;
   }

   @ObfuscatedName("bh")
   static int method2150(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
      var11.field1682 -= var11.field1684 * var5;
      var11.field1683 -= var11.field1679 * var5;
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

      var11.field1682 += var11.field1684 * var5;
      var11.field1683 += var11.field1679 * var5;
      var11.field1677 = var6;
      var11.field1690 = var4;
      return var5;
   }

   @ObfuscatedName("bd")
   static int method2171(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class117 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1682 += var9.field1684 * (var6 - var3);
      var9.field1683 += var9.field1679 * (var6 - var3);

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

      var9.field1677 = var4 >> 2;
      var9.field1690 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bc")
   static int method2146(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class117 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1682 += var9.field1684 * (var6 - var3);
      var9.field1683 += var9.field1679 * (var6 - var3);

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

      var9.field1677 = var4 >> 2;
      var9.field1690 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bs")
   static int method2121(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class117 var13, int var14, int var15) {
      var13.field1677 -= var5 * var13.field1689;
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

      if(var14 == 0 || (var10 = (var12 - var4 + var14 - 1) / var14 + (var5 >> 1)) > var11) {
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
      var13.field1677 += var5 * var13.field1689;
      var13.field1682 = var6;
      var13.field1683 = var7;
      var13.field1690 = var4;
      return var5;
   }

   @ObfuscatedName("bo")
   static int method2151(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class117 var13, int var14, int var15) {
      var13.field1677 -= var5 * var13.field1689;
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
      var13.field1677 += var5 * var13.field1689;
      var13.field1682 = var6;
      var13.field1683 = var7;
      var13.field1690 = var4;
      return var5;
   }

   @ObfuscatedName("bl")
   static int method2145(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class117 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1677 += (var9 - var4) * var12.field1689;
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

      var12.field1682 = var5 >> 2;
      var12.field1683 = var6 >> 2;
      var12.field1690 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bb")
   static int method2147(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class117 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1677 += (var9 - var4) * var12.field1689;
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

      var12.field1682 = var5 >> 2;
      var12.field1683 = var6 >> 2;
      var12.field1690 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("r")
   public static class117 method2178(class107 var0, int var1, int var2, int var3) {
      return var0.field1607 != null && var0.field1607.length != 0?new class117(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("n")
   public static class117 method2195(class107 var0, int var1, int var2) {
      return var0.field1607 != null && var0.field1607.length != 0?new class117(var0, (int)((long)var0.field1603 * 256L * (long)var1 / (long)(ChatLineBuffer.sampleRate * 100)), var2 << 6):null;
   }
}
