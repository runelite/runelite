import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public class class117 extends class119 {
   @ObfuscatedName("r")
   int field1698;
   @ObfuscatedName("l")
   int field1699;
   @ObfuscatedName("t")
   int field1700;
   @ObfuscatedName("s")
   int field1701;
   @ObfuscatedName("e")
   int field1702;
   @ObfuscatedName("v")
   int field1703;
   @ObfuscatedName("y")
   int field1704;
   @ObfuscatedName("j")
   int field1705;
   @ObfuscatedName("k")
   int field1706;
   @ObfuscatedName("a")
   int field1707;
   @ObfuscatedName("o")
   boolean field1708;
   @ObfuscatedName("z")
   int field1709;
   @ObfuscatedName("i")
   int field1710;
   @ObfuscatedName("c")
   int field1711;
   @ObfuscatedName("m")
   int field1712;

   class117(class107 var1, int var2, int var3) {
      super.field1726 = var1;
      this.field1706 = var1.field1629;
      this.field1702 = var1.field1631;
      this.field1708 = var1.field1632;
      this.field1707 = var2;
      this.field1700 = var3;
      this.field1701 = 8192;
      this.field1710 = 0;
      this.method2224();
   }

   class117(class107 var1, int var2, int var3, int var4) {
      super.field1726 = var1;
      this.field1706 = var1.field1629;
      this.field1702 = var1.field1631;
      this.field1708 = var1.field1632;
      this.field1707 = var2;
      this.field1700 = var3;
      this.field1701 = var4;
      this.field1710 = 0;
      this.method2224();
   }

   @ObfuscatedName("k")
   public synchronized void method2126(int var1) {
      this.field1705 = var1;
   }

   @ObfuscatedName("t")
   public static class117 method2127(class107 var0, int var1, int var2, int var3) {
      return var0.field1630 != null && var0.field1630.length != 0?new class117(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   synchronized void method2128(int var1) {
      this.method2231(var1, this.method2134());
   }

   @ObfuscatedName("f")
   public synchronized void method2129(int var1) {
      int var2 = ((class107)super.field1726).field1630.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1710 = var1;
   }

   @ObfuscatedName("o")
   public synchronized void method2130(int var1) {
      this.method2231(var1 << 6, this.method2134());
   }

   @ObfuscatedName("i")
   static int method2131(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("c")
   public synchronized int method2133() {
      return this.field1700 == Integer.MIN_VALUE?0:this.field1700;
   }

   @ObfuscatedName("b")
   public synchronized int method2134() {
      return this.field1701 < 0?-1:this.field1701;
   }

   @ObfuscatedName("x")
   public boolean method2135() {
      return this.field1710 < 0 || this.field1710 >= ((class107)super.field1726).field1630.length << 8;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2136() {
      this.field1707 = (this.field1707 ^ this.field1707 >> 31) + (this.field1707 >>> 31);
      this.field1707 = -this.field1707;
   }

   @ObfuscatedName("u")
   void method2137() {
      if(this.field1709 != 0) {
         if(this.field1700 == Integer.MIN_VALUE) {
            this.field1700 = 0;
         }

         this.field1709 = 0;
         this.method2224();
      }

   }

   @ObfuscatedName("p")
   public synchronized void method2138(int var1, int var2) {
      this.method2139(var1, var2, this.method2134());
   }

   @ObfuscatedName("q")
   public synchronized void method2139(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2231(var2, var3);
      } else {
         int var4 = method2131(var2, var3);
         int var5 = method2142(var2, var3);
         if(this.field1703 == var4 && var5 == this.field1704) {
            this.field1709 = 0;
         } else {
            int var6 = var2 - this.field1698;
            if(this.field1698 - var2 > var6) {
               var6 = this.field1698 - var2;
            }

            if(var4 - this.field1703 > var6) {
               var6 = var4 - this.field1703;
            }

            if(this.field1703 - var4 > var6) {
               var6 = this.field1703 - var4;
            }

            if(var5 - this.field1704 > var6) {
               var6 = var5 - this.field1704;
            }

            if(this.field1704 - var5 > var6) {
               var6 = this.field1704 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1709 = var1;
            this.field1700 = var2;
            this.field1701 = var3;
            this.field1699 = (var2 - this.field1698) / var1;
            this.field1711 = (var4 - this.field1703) / var1;
            this.field1712 = (var5 - this.field1704) / var1;
         }
      }

   }

   @ObfuscatedName("d")
   public synchronized void method2140(int var1) {
      if(var1 == 0) {
         this.method2128(0);
         this.unlink();
      } else if(this.field1703 == 0 && this.field1704 == 0) {
         this.field1709 = 0;
         this.field1700 = 0;
         this.field1698 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1698;
         if(this.field1698 > var2) {
            var2 = this.field1698;
         }

         if(-this.field1703 > var2) {
            var2 = -this.field1703;
         }

         if(this.field1703 > var2) {
            var2 = this.field1703;
         }

         if(-this.field1704 > var2) {
            var2 = -this.field1704;
         }

         if(this.field1704 > var2) {
            var2 = this.field1704;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1709 = var1;
         this.field1700 = Integer.MIN_VALUE;
         this.field1699 = -this.field1698 / var1;
         this.field1711 = -this.field1703 / var1;
         this.field1712 = -this.field1704 / var1;
      }

   }

   @ObfuscatedName("w")
   static int method2142(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("bc")
   static int method2143(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 257) / var11) > var8) {
         var7 = var8;
      }

      byte var13;
      int var14;
      while(var5 < var7) {
         var1 = var4 >> 8;
         var13 = var2[var1];
         var14 = var5++;
         var3[var14] += ((var13 << 8) + (var2[var1 + 1] - var13) * (var4 & 255)) * var6 >> 6;
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

      var10.field1710 = var4;
      return var5;
   }

   @ObfuscatedName("v")
   protected class119 vmethod3865() {
      return null;
   }

   @ObfuscatedName("y")
   protected int vmethod3888() {
      return this.field1700 == 0 && this.field1709 == 0?0:1;
   }

   @ObfuscatedName("j")
   public synchronized void vmethod3889(int[] var1, int var2, int var3) {
      if(this.field1700 == 0 && this.field1709 == 0) {
         this.vmethod3885(var3);
      } else {
         class107 var4 = (class107)super.field1726;
         int var5 = this.field1706 << 8;
         int var6 = this.field1702 << 8;
         int var7 = var4.field1630.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1705 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1710 < 0) {
            if(this.field1707 <= 0) {
               this.method2137();
               this.unlink();
               return;
            }

            this.field1710 = 0;
         }

         if(this.field1710 >= var7) {
            if(this.field1707 >= 0) {
               this.method2137();
               this.unlink();
               return;
            }

            this.field1710 = var7 - 1;
         }

         if(this.field1705 < 0) {
            if(this.field1708) {
               if(this.field1707 < 0) {
                  var9 = this.method2151(var1, var2, var5, var3, var4.field1630[this.field1706]);
                  if(this.field1710 >= var5) {
                     return;
                  }

                  this.field1710 = var5 + var5 - 1 - this.field1710;
                  this.field1707 = -this.field1707;
               }

               while(true) {
                  var9 = this.method2150(var1, var9, var6, var3, var4.field1630[this.field1702 - 1]);
                  if(this.field1710 < var6) {
                     return;
                  }

                  this.field1710 = var6 + var6 - 1 - this.field1710;
                  this.field1707 = -this.field1707;
                  var9 = this.method2151(var1, var9, var5, var3, var4.field1630[this.field1706]);
                  if(this.field1710 >= var5) {
                     return;
                  }

                  this.field1710 = var5 + var5 - 1 - this.field1710;
                  this.field1707 = -this.field1707;
               }
            }

            if(this.field1707 < 0) {
               while(true) {
                  var9 = this.method2151(var1, var9, var5, var3, var4.field1630[this.field1702 - 1]);
                  if(this.field1710 >= var5) {
                     return;
                  }

                  this.field1710 = var6 - 1 - (var6 - 1 - this.field1710) % var8;
               }
            }

            while(true) {
               var9 = this.method2150(var1, var9, var6, var3, var4.field1630[this.field1706]);
               if(this.field1710 < var6) {
                  return;
               }

               this.field1710 = var5 + (this.field1710 - var5) % var8;
            }
         }

         if(this.field1705 > 0) {
            if(this.field1708) {
               label118: {
                  if(this.field1707 < 0) {
                     var9 = this.method2151(var1, var2, var5, var3, var4.field1630[this.field1706]);
                     if(this.field1710 >= var5) {
                        return;
                     }

                     this.field1710 = var5 + var5 - 1 - this.field1710;
                     this.field1707 = -this.field1707;
                     if(--this.field1705 == 0) {
                        break label118;
                     }
                  }

                  do {
                     var9 = this.method2150(var1, var9, var6, var3, var4.field1630[this.field1702 - 1]);
                     if(this.field1710 < var6) {
                        return;
                     }

                     this.field1710 = var6 + var6 - 1 - this.field1710;
                     this.field1707 = -this.field1707;
                     if(--this.field1705 == 0) {
                        break;
                     }

                     var9 = this.method2151(var1, var9, var5, var3, var4.field1630[this.field1706]);
                     if(this.field1710 >= var5) {
                        return;
                     }

                     this.field1710 = var5 + var5 - 1 - this.field1710;
                     this.field1707 = -this.field1707;
                  } while(--this.field1705 != 0);
               }
            } else {
               int var10;
               if(this.field1707 < 0) {
                  while(true) {
                     var9 = this.method2151(var1, var9, var5, var3, var4.field1630[this.field1702 - 1]);
                     if(this.field1710 >= var5) {
                        return;
                     }

                     var10 = (var6 - 1 - this.field1710) / var8;
                     if(var10 >= this.field1705) {
                        this.field1710 += var8 * this.field1705;
                        this.field1705 = 0;
                        break;
                     }

                     this.field1710 += var10 * var8;
                     this.field1705 -= var10;
                  }
               } else {
                  while(true) {
                     var9 = this.method2150(var1, var9, var6, var3, var4.field1630[this.field1706]);
                     if(this.field1710 < var6) {
                        return;
                     }

                     var10 = (this.field1710 - var5) / var8;
                     if(var10 >= this.field1705) {
                        this.field1710 -= var8 * this.field1705;
                        this.field1705 = 0;
                        break;
                     }

                     this.field1710 -= var10 * var8;
                     this.field1705 -= var10;
                  }
               }
            }
         }

         if(this.field1707 < 0) {
            this.method2151(var1, var9, 0, var3, 0);
            if(this.field1710 < 0) {
               this.field1710 = -1;
               this.method2137();
               this.unlink();
            }
         } else {
            this.method2150(var1, var9, var7, var3, 0);
            if(this.field1710 >= var7) {
               this.field1710 = var7;
               this.method2137();
               this.unlink();
            }
         }
      }

   }

   @ObfuscatedName("e")
   public synchronized void vmethod3885(int var1) {
      if(this.field1709 > 0) {
         if(var1 >= this.field1709) {
            if(this.field1700 == Integer.MIN_VALUE) {
               this.field1700 = 0;
               this.field1704 = 0;
               this.field1703 = 0;
               this.field1698 = 0;
               this.unlink();
               var1 = this.field1709;
            }

            this.field1709 = 0;
            this.method2224();
         } else {
            this.field1698 += this.field1699 * var1;
            this.field1703 += this.field1711 * var1;
            this.field1704 += this.field1712 * var1;
            this.field1709 -= var1;
         }
      }

      class107 var2 = (class107)super.field1726;
      int var3 = this.field1706 << 8;
      int var4 = this.field1702 << 8;
      int var5 = var2.field1630.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1705 = 0;
      }

      if(this.field1710 < 0) {
         if(this.field1707 <= 0) {
            this.method2137();
            this.unlink();
            return;
         }

         this.field1710 = 0;
      }

      if(this.field1710 >= var5) {
         if(this.field1707 >= 0) {
            this.method2137();
            this.unlink();
            return;
         }

         this.field1710 = var5 - 1;
      }

      this.field1710 += this.field1707 * var1;
      if(this.field1705 < 0) {
         if(!this.field1708) {
            if(this.field1707 < 0) {
               if(this.field1710 >= var3) {
                  return;
               }

               this.field1710 = var4 - 1 - (var4 - 1 - this.field1710) % var6;
            } else {
               if(this.field1710 < var4) {
                  return;
               }

               this.field1710 = var3 + (this.field1710 - var3) % var6;
            }
         } else {
            if(this.field1707 < 0) {
               if(this.field1710 >= var3) {
                  return;
               }

               this.field1710 = var3 + var3 - 1 - this.field1710;
               this.field1707 = -this.field1707;
            }

            while(this.field1710 >= var4) {
               this.field1710 = var4 + var4 - 1 - this.field1710;
               this.field1707 = -this.field1707;
               if(this.field1710 >= var3) {
                  return;
               }

               this.field1710 = var3 + var3 - 1 - this.field1710;
               this.field1707 = -this.field1707;
            }
         }
      } else {
         if(this.field1705 > 0) {
            if(this.field1708) {
               label117: {
                  if(this.field1707 < 0) {
                     if(this.field1710 >= var3) {
                        return;
                     }

                     this.field1710 = var3 + var3 - 1 - this.field1710;
                     this.field1707 = -this.field1707;
                     if(--this.field1705 == 0) {
                        break label117;
                     }
                  }

                  do {
                     if(this.field1710 < var4) {
                        return;
                     }

                     this.field1710 = var4 + var4 - 1 - this.field1710;
                     this.field1707 = -this.field1707;
                     if(--this.field1705 == 0) {
                        break;
                     }

                     if(this.field1710 >= var3) {
                        return;
                     }

                     this.field1710 = var3 + var3 - 1 - this.field1710;
                     this.field1707 = -this.field1707;
                  } while(--this.field1705 != 0);
               }
            } else {
               label149: {
                  int var7;
                  if(this.field1707 < 0) {
                     if(this.field1710 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1710) / var6;
                     if(var7 >= this.field1705) {
                        this.field1710 += this.field1705 * var6;
                        this.field1705 = 0;
                        break label149;
                     }

                     this.field1710 += var7 * var6;
                     this.field1705 -= var7;
                  } else {
                     if(this.field1710 < var4) {
                        return;
                     }

                     var7 = (this.field1710 - var3) / var6;
                     if(var7 >= this.field1705) {
                        this.field1710 -= this.field1705 * var6;
                        this.field1705 = 0;
                        break label149;
                     }

                     this.field1710 -= var7 * var6;
                     this.field1705 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1707 < 0) {
            if(this.field1710 < 0) {
               this.field1710 = -1;
               this.method2137();
               this.unlink();
            }
         } else if(this.field1710 >= var5) {
            this.field1710 = var5;
            this.method2137();
            this.unlink();
         }
      }

   }

   @ObfuscatedName("ad")
   int method2150(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1709 > 0) {
            int var6 = var2 + this.field1709;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1709 += var2;
            if(this.field1707 == 256 && (this.field1710 & 255) == 0) {
               if(AbstractSoundSystem.highMemory) {
                  var2 = method2162(0, ((class107)super.field1726).field1630, var1, this.field1710, var2, this.field1703, this.field1704, this.field1711, this.field1712, 0, var6, var3, this);
               } else {
                  var2 = method2161(((class107)super.field1726).field1630, var1, this.field1710, var2, this.field1698, this.field1699, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.highMemory) {
               var2 = method2166(0, 0, ((class107)super.field1726).field1630, var1, this.field1710, var2, this.field1703, this.field1704, this.field1711, this.field1712, 0, var6, var3, this, this.field1707, var5);
            } else {
               var2 = method2165(0, 0, ((class107)super.field1726).field1630, var1, this.field1710, var2, this.field1698, this.field1699, 0, var6, var3, this, this.field1707, var5);
            }

            this.field1709 -= var2;
            if(this.field1709 != 0) {
               return var2;
            }

            if(!this.method2152()) {
               continue;
            }

            return var4;
         }

         if(this.field1707 == 256 && (this.field1710 & 255) == 0) {
            if(AbstractSoundSystem.highMemory) {
               return method2154(0, ((class107)super.field1726).field1630, var1, this.field1710, var2, this.field1703, this.field1704, 0, var4, var3, this);
            }

            return method2153(((class107)super.field1726).field1630, var1, this.field1710, var2, this.field1698, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.highMemory) {
            return method2158(0, 0, ((class107)super.field1726).field1630, var1, this.field1710, var2, this.field1703, this.field1704, 0, var4, var3, this, this.field1707, var5);
         }

         return method2143(0, 0, ((class107)super.field1726).field1630, var1, this.field1710, var2, this.field1698, 0, var4, var3, this, this.field1707, var5);
      }
   }

   @ObfuscatedName("ae")
   int method2151(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1709 > 0) {
            int var6 = var2 + this.field1709;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1709 += var2;
            if(this.field1707 == -256 && (this.field1710 & 255) == 0) {
               if(AbstractSoundSystem.highMemory) {
                  var2 = method2164(0, ((class107)super.field1726).field1630, var1, this.field1710, var2, this.field1703, this.field1704, this.field1711, this.field1712, 0, var6, var3, this);
               } else {
                  var2 = method2266(((class107)super.field1726).field1630, var1, this.field1710, var2, this.field1698, this.field1699, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.highMemory) {
               var2 = method2168(0, 0, ((class107)super.field1726).field1630, var1, this.field1710, var2, this.field1703, this.field1704, this.field1711, this.field1712, 0, var6, var3, this, this.field1707, var5);
            } else {
               var2 = method2167(0, 0, ((class107)super.field1726).field1630, var1, this.field1710, var2, this.field1698, this.field1699, 0, var6, var3, this, this.field1707, var5);
            }

            this.field1709 -= var2;
            if(this.field1709 != 0) {
               return var2;
            }

            if(!this.method2152()) {
               continue;
            }

            return var4;
         }

         if(this.field1707 == -256 && (this.field1710 & 255) == 0) {
            if(AbstractSoundSystem.highMemory) {
               return method2156(0, ((class107)super.field1726).field1630, var1, this.field1710, var2, this.field1703, this.field1704, 0, var4, var3, this);
            }

            return method2155(((class107)super.field1726).field1630, var1, this.field1710, var2, this.field1698, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.highMemory) {
            return method2160(0, 0, ((class107)super.field1726).field1630, var1, this.field1710, var2, this.field1703, this.field1704, 0, var4, var3, this, this.field1707, var5);
         }

         return method2159(0, 0, ((class107)super.field1726).field1630, var1, this.field1710, var2, this.field1698, 0, var4, var3, this, this.field1707, var5);
      }
   }

   @ObfuscatedName("ag")
   boolean method2152() {
      int var1 = this.field1700;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2131(var1, this.field1701);
         var3 = method2142(var1, this.field1701);
      }

      if(this.field1698 == var1 && var2 == this.field1703 && var3 == this.field1704) {
         if(this.field1700 == Integer.MIN_VALUE) {
            this.field1700 = 0;
            this.field1704 = 0;
            this.field1703 = 0;
            this.field1698 = 0;
            this.unlink();
            return true;
         } else {
            this.method2224();
            return false;
         }
      } else {
         if(this.field1698 < var1) {
            this.field1699 = 1;
            this.field1709 = var1 - this.field1698;
         } else if(this.field1698 > var1) {
            this.field1699 = -1;
            this.field1709 = this.field1698 - var1;
         } else {
            this.field1699 = 0;
         }

         if(this.field1703 < var2) {
            this.field1711 = 1;
            if(this.field1709 == 0 || this.field1709 > var2 - this.field1703) {
               this.field1709 = var2 - this.field1703;
            }
         } else if(this.field1703 > var2) {
            this.field1711 = -1;
            if(this.field1709 == 0 || this.field1709 > this.field1703 - var2) {
               this.field1709 = this.field1703 - var2;
            }
         } else {
            this.field1711 = 0;
         }

         if(this.field1704 < var3) {
            this.field1712 = 1;
            if(this.field1709 == 0 || this.field1709 > var3 - this.field1704) {
               this.field1709 = var3 - this.field1704;
            }
         } else if(this.field1704 > var3) {
            this.field1712 = -1;
            if(this.field1709 == 0 || this.field1709 > this.field1704 - var3) {
               this.field1709 = this.field1704 - var3;
            }
         } else {
            this.field1712 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("ap")
   static int method2153(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class117 var8) {
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

      var8.field1710 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("af")
   static int method2154(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10) {
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

      var10.field1710 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("aj")
   static int method2155(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class117 var8) {
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

      var8.field1710 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bb")
   static int method2156(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10) {
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

      var10.field1710 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("be")
   static int method2158(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      byte var14;
      int var15;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var0 = (var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255);
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
         var0 = (var14 << 8) + (var1 - var14) * (var4 & 255);
         var15 = var5++;
         var3[var15] += var0 * var6 >> 6;
         var15 = var5++;
         var3[var15] += var0 * var7 >> 6;
      }

      var11.field1710 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bv")
   static int method2159(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class117 var10, int var11, int var12) {
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

      var10.field1710 = var4;
      return var5;
   }

   @ObfuscatedName("bt")
   static int method2160(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
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

      var11.field1710 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bl")
   static int method2161(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class117 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1703 += var9.field1711 * (var6 - var3);
      var9.field1704 += var9.field1712 * (var6 - var3);

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

      var9.field1698 = var4 >> 2;
      var9.field1710 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bp")
   static int method2162(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class117 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1698 += (var9 - var4) * var12.field1699;
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var14;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var5 * var13;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var5 * var13;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var5 * var13;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var5 * var13;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var5 * var13;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      var12.field1703 = var5 >> 2;
      var12.field1704 = var6 >> 2;
      var12.field1710 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bg")
   static int method2164(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class117 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1698 += (var9 - var4) * var12.field1699;
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var14;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var5 * var13;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var5 * var13;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var5 * var13;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var5 * var13;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var5 * var13;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      var12.field1703 = var5 >> 2;
      var12.field1704 = var6 >> 2;
      var12.field1710 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bo")
   static int method2165(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
      var11.field1703 -= var11.field1711 * var5;
      var11.field1704 -= var11.field1712 * var5;
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      byte var14;
      int var15;
      while(var5 < var8) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var15 = var5++;
         var3[var15] += ((var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      for(var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var15 = var5++;
         var3[var15] += ((var14 << 8) + (var1 - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field1703 += var11.field1711 * var5;
      var11.field1704 += var11.field1712 * var5;
      var11.field1698 = var6;
      var11.field1710 = var4;
      return var5;
   }

   @ObfuscatedName("bw")
   static int method2166(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class117 var13, int var14, int var15) {
      var13.field1698 -= var5 * var13.field1699;
      if(var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      byte var16;
      int var17;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         var16 = var2[var1];
         var0 = (var16 << 8) + (var2[var1 + 1] - var16) * (var4 & 255);
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
         var0 = (var16 << 8) + (var1 - var16) * (var4 & 255);
         var17 = var5++;
         var3[var17] += var0 * var6 >> 6;
         var6 += var8;
         var17 = var5++;
         var3[var17] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field1698 += var5 * var13.field1699;
      var13.field1703 = var6;
      var13.field1704 = var7;
      var13.field1710 = var4;
      return var5;
   }

   @ObfuscatedName("bm")
   static int method2167(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class117 var11, int var12, int var13) {
      var11.field1703 -= var11.field1711 * var5;
      var11.field1704 -= var11.field1712 * var5;
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

      var11.field1703 += var11.field1711 * var5;
      var11.field1704 += var11.field1712 * var5;
      var11.field1698 = var6;
      var11.field1710 = var4;
      return var5;
   }

   @ObfuscatedName("bj")
   static int method2168(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class117 var13, int var14, int var15) {
      var13.field1698 -= var5 * var13.field1699;
      if(var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      int var16;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         byte var17 = var2[var1 - 1];
         var0 = (var2[var1] - var17) * (var4 & 255) + (var17 << 8);
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
      var13.field1698 += var5 * var13.field1699;
      var13.field1703 = var6;
      var13.field1704 = var7;
      var13.field1710 = var4;
      return var5;
   }

   @ObfuscatedName("h")
   public synchronized void method2203(int var1) {
      if(this.field1707 < 0) {
         this.field1707 = -var1;
      } else {
         this.field1707 = var1;
      }

   }

   @ObfuscatedName("g")
   public synchronized int method2207() {
      return this.field1707 < 0?-this.field1707:this.field1707;
   }

   @ObfuscatedName("s")
   void method2224() {
      this.field1698 = this.field1700;
      this.field1703 = method2131(this.field1700, this.field1701);
      this.field1704 = method2142(this.field1700, this.field1701);
   }

   @ObfuscatedName("al")
   int vmethod2291() {
      int var1 = this.field1698 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1705 == 0) {
         var1 -= this.field1710 * var1 / (((class107)super.field1726).field1630.length << 8);
      } else if(this.field1705 >= 0) {
         var1 -= this.field1706 * var1 / ((class107)super.field1726).field1630.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("a")
   public static class117 method2229(class107 var0, int var1, int var2) {
      return var0.field1630 != null && var0.field1630.length != 0?new class117(var0, (int)((long)var0.field1633 * 256L * (long)var1 / (long)(FileSystem.sampleRate * 100)), var2 << 6):null;
   }

   @ObfuscatedName("l")
   synchronized void method2231(int var1, int var2) {
      this.field1700 = var1;
      this.field1701 = var2;
      this.field1709 = 0;
      this.method2224();
   }

   @ObfuscatedName("av")
   public boolean method2251() {
      return this.field1709 != 0;
   }

   @ObfuscatedName("r")
   protected class119 vmethod3864() {
      return null;
   }

   @ObfuscatedName("br")
   static int method2266(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class117 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1703 += var9.field1711 * (var6 - var3);
      var9.field1704 += var9.field1712 * (var6 - var3);

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

      var9.field1698 = var4 >> 2;
      var9.field1710 = var2 << 8;
      return var3;
   }
}
