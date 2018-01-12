import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
@Implements("SongMetadata")
public class SongMetadata extends TaskDataNode {
   @ObfuscatedName("a")
   int field1589;
   @ObfuscatedName("e")
   int field1585;
   @ObfuscatedName("k")
   int field1586;
   @ObfuscatedName("u")
   int field1597;
   @ObfuscatedName("z")
   int field1590;
   @ObfuscatedName("t")
   int field1588;
   @ObfuscatedName("f")
   int field1584;
   @ObfuscatedName("g")
   int field1591;
   @ObfuscatedName("j")
   int field1592;
   @ObfuscatedName("x")
   int field1593;
   @ObfuscatedName("c")
   boolean field1594;
   @ObfuscatedName("s")
   int field1598;
   @ObfuscatedName("n")
   int field1596;
   @ObfuscatedName("y")
   int field1595;
   @ObfuscatedName("o")
   int field1587;

   @ObfuscatedSignature(
      signature = "(Ldx;III)V"
   )
   SongMetadata(MusicTrack2 var1, int var2, int var3, int var4) {
      super.field1613 = var1;
      this.field1592 = var1.field1510;
      this.field1593 = var1.field1508;
      this.field1594 = var1.field1512;
      this.field1585 = var2;
      this.field1586 = var3;
      this.field1597 = var4;
      this.field1589 = 0;
      this.method2113();
   }

   @ObfuscatedSignature(
      signature = "(Ldx;II)V"
   )
   SongMetadata(MusicTrack2 var1, int var2, int var3) {
      super.field1613 = var1;
      this.field1592 = var1.field1510;
      this.field1593 = var1.field1508;
      this.field1594 = var1.field1512;
      this.field1585 = var2;
      this.field1586 = var3;
      this.field1597 = 8192;
      this.field1589 = 0;
      this.method2113();
   }

   @ObfuscatedName("u")
   void method2113() {
      this.field1590 = this.field1586;
      this.field1588 = method2248(this.field1586, this.field1597);
      this.field1584 = method2187(this.field1586, this.field1597);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "()Ldy;"
   )
   protected TaskDataNode vmethod4041() {
      return null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "()Ldy;"
   )
   protected TaskDataNode vmethod4040() {
      return null;
   }

   @ObfuscatedName("f")
   protected int vmethod4045() {
      return this.field1586 == 0 && this.field1598 == 0?0:1;
   }

   @ObfuscatedName("g")
   public synchronized void vmethod4062(int[] var1, int var2, int var3) {
      if(this.field1586 == 0 && this.field1598 == 0) {
         this.vmethod4046(var3);
      } else {
         MusicTrack2 var4 = (MusicTrack2)super.field1613;
         int var5 = this.field1592 << 8;
         int var6 = this.field1593 << 8;
         int var7 = var4.field1509.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1591 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1589 < 0) {
            if(this.field1585 <= 0) {
               this.method2122();
               this.unlink();
               return;
            }

            this.field1589 = 0;
         }

         if(this.field1589 >= var7) {
            if(this.field1585 >= 0) {
               this.method2122();
               this.unlink();
               return;
            }

            this.field1589 = var7 - 1;
         }

         if(this.field1591 < 0) {
            if(this.field1594) {
               if(this.field1585 < 0) {
                  var9 = this.method2136(var1, var2, var5, var3, var4.field1509[this.field1592]);
                  if(this.field1589 >= var5) {
                     return;
                  }

                  this.field1589 = var5 + var5 - 1 - this.field1589;
                  this.field1585 = -this.field1585;
               }

               while(true) {
                  var9 = this.method2135(var1, var9, var6, var3, var4.field1509[this.field1593 - 1]);
                  if(this.field1589 < var6) {
                     return;
                  }

                  this.field1589 = var6 + var6 - 1 - this.field1589;
                  this.field1585 = -this.field1585;
                  var9 = this.method2136(var1, var9, var5, var3, var4.field1509[this.field1592]);
                  if(this.field1589 >= var5) {
                     return;
                  }

                  this.field1589 = var5 + var5 - 1 - this.field1589;
                  this.field1585 = -this.field1585;
               }
            } else if(this.field1585 < 0) {
               while(true) {
                  var9 = this.method2136(var1, var9, var5, var3, var4.field1509[this.field1593 - 1]);
                  if(this.field1589 >= var5) {
                     return;
                  }

                  this.field1589 = var6 - 1 - (var6 - 1 - this.field1589) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2135(var1, var9, var6, var3, var4.field1509[this.field1592]);
                  if(this.field1589 < var6) {
                     return;
                  }

                  this.field1589 = var5 + (this.field1589 - var5) % var8;
               }
            }
         } else {
            if(this.field1591 > 0) {
               if(this.field1594) {
                  label156: {
                     if(this.field1585 < 0) {
                        var9 = this.method2136(var1, var2, var5, var3, var4.field1509[this.field1592]);
                        if(this.field1589 >= var5) {
                           return;
                        }

                        this.field1589 = var5 + var5 - 1 - this.field1589;
                        this.field1585 = -this.field1585;
                        if(--this.field1591 == 0) {
                           break label156;
                        }
                     }

                     do {
                        var9 = this.method2135(var1, var9, var6, var3, var4.field1509[this.field1593 - 1]);
                        if(this.field1589 < var6) {
                           return;
                        }

                        this.field1589 = var6 + var6 - 1 - this.field1589;
                        this.field1585 = -this.field1585;
                        if(--this.field1591 == 0) {
                           break;
                        }

                        var9 = this.method2136(var1, var9, var5, var3, var4.field1509[this.field1592]);
                        if(this.field1589 >= var5) {
                           return;
                        }

                        this.field1589 = var5 + var5 - 1 - this.field1589;
                        this.field1585 = -this.field1585;
                     } while(--this.field1591 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1585 < 0) {
                     while(true) {
                        var9 = this.method2136(var1, var9, var5, var3, var4.field1509[this.field1593 - 1]);
                        if(this.field1589 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1589) / var8;
                        if(var10 >= this.field1591) {
                           this.field1589 += var8 * this.field1591;
                           this.field1591 = 0;
                           break;
                        }

                        this.field1589 += var8 * var10;
                        this.field1591 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2135(var1, var9, var6, var3, var4.field1509[this.field1592]);
                        if(this.field1589 < var6) {
                           return;
                        }

                        var10 = (this.field1589 - var5) / var8;
                        if(var10 >= this.field1591) {
                           this.field1589 -= var8 * this.field1591;
                           this.field1591 = 0;
                           break;
                        }

                        this.field1589 -= var8 * var10;
                        this.field1591 -= var10;
                     }
                  }
               }
            }

            if(this.field1585 < 0) {
               this.method2136(var1, var9, 0, var3, 0);
               if(this.field1589 < 0) {
                  this.field1589 = -1;
                  this.method2122();
                  this.unlink();
               }
            } else {
               this.method2135(var1, var9, var7, var3, 0);
               if(this.field1589 >= var7) {
                  this.field1589 = var7;
                  this.method2122();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("x")
   public synchronized void method2114(int var1) {
      this.field1591 = var1;
   }

   @ObfuscatedName("c")
   public synchronized void vmethod4046(int var1) {
      if(this.field1598 > 0) {
         if(var1 >= this.field1598) {
            if(this.field1586 == Integer.MIN_VALUE) {
               this.field1586 = 0;
               this.field1584 = 0;
               this.field1588 = 0;
               this.field1590 = 0;
               this.unlink();
               var1 = this.field1598;
            }

            this.field1598 = 0;
            this.method2113();
         } else {
            this.field1590 += this.field1596 * var1;
            this.field1588 += this.field1595 * var1;
            this.field1584 += this.field1587 * var1;
            this.field1598 -= var1;
         }
      }

      MusicTrack2 var2 = (MusicTrack2)super.field1613;
      int var3 = this.field1592 << 8;
      int var4 = this.field1593 << 8;
      int var5 = var2.field1509.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1591 = 0;
      }

      if(this.field1589 < 0) {
         if(this.field1585 <= 0) {
            this.method2122();
            this.unlink();
            return;
         }

         this.field1589 = 0;
      }

      if(this.field1589 >= var5) {
         if(this.field1585 >= 0) {
            this.method2122();
            this.unlink();
            return;
         }

         this.field1589 = var5 - 1;
      }

      this.field1589 += this.field1585 * var1;
      if(this.field1591 < 0) {
         if(!this.field1594) {
            if(this.field1585 < 0) {
               if(this.field1589 >= var3) {
                  return;
               }

               this.field1589 = var4 - 1 - (var4 - 1 - this.field1589) % var6;
            } else {
               if(this.field1589 < var4) {
                  return;
               }

               this.field1589 = var3 + (this.field1589 - var3) % var6;
            }

         } else {
            if(this.field1585 < 0) {
               if(this.field1589 >= var3) {
                  return;
               }

               this.field1589 = var3 + var3 - 1 - this.field1589;
               this.field1585 = -this.field1585;
            }

            while(this.field1589 >= var4) {
               this.field1589 = var4 + var4 - 1 - this.field1589;
               this.field1585 = -this.field1585;
               if(this.field1589 >= var3) {
                  return;
               }

               this.field1589 = var3 + var3 - 1 - this.field1589;
               this.field1585 = -this.field1585;
            }

         }
      } else {
         if(this.field1591 > 0) {
            if(this.field1594) {
               label129: {
                  if(this.field1585 < 0) {
                     if(this.field1589 >= var3) {
                        return;
                     }

                     this.field1589 = var3 + var3 - 1 - this.field1589;
                     this.field1585 = -this.field1585;
                     if(--this.field1591 == 0) {
                        break label129;
                     }
                  }

                  do {
                     if(this.field1589 < var4) {
                        return;
                     }

                     this.field1589 = var4 + var4 - 1 - this.field1589;
                     this.field1585 = -this.field1585;
                     if(--this.field1591 == 0) {
                        break;
                     }

                     if(this.field1589 >= var3) {
                        return;
                     }

                     this.field1589 = var3 + var3 - 1 - this.field1589;
                     this.field1585 = -this.field1585;
                  } while(--this.field1591 != 0);
               }
            } else {
               label161: {
                  int var7;
                  if(this.field1585 < 0) {
                     if(this.field1589 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1589) / var6;
                     if(var7 >= this.field1591) {
                        this.field1589 += var6 * this.field1591;
                        this.field1591 = 0;
                        break label161;
                     }

                     this.field1589 += var6 * var7;
                     this.field1591 -= var7;
                  } else {
                     if(this.field1589 < var4) {
                        return;
                     }

                     var7 = (this.field1589 - var3) / var6;
                     if(var7 >= this.field1591) {
                        this.field1589 -= var6 * this.field1591;
                        this.field1591 = 0;
                        break label161;
                     }

                     this.field1589 -= var6 * var7;
                     this.field1591 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1585 < 0) {
            if(this.field1589 < 0) {
               this.field1589 = -1;
               this.method2122();
               this.unlink();
            }
         } else if(this.field1589 >= var5) {
            this.field1589 = var5;
            this.method2122();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("n")
   public synchronized void method2173(int var1) {
      this.method2117(var1 << 6, this.method2119());
   }

   @ObfuscatedName("y")
   synchronized void method2116(int var1) {
      this.method2117(var1, this.method2119());
   }

   @ObfuscatedName("o")
   synchronized void method2117(int var1, int var2) {
      this.field1586 = var1;
      this.field1597 = var2;
      this.field1598 = 0;
      this.method2113();
   }

   @ObfuscatedName("r")
   public synchronized int method2118() {
      return this.field1586 == Integer.MIN_VALUE?0:this.field1586;
   }

   @ObfuscatedName("i")
   public synchronized int method2119() {
      return this.field1597 < 0?-1:this.field1597;
   }

   @ObfuscatedName("q")
   public synchronized void method2218(int var1) {
      int var2 = ((MusicTrack2)super.field1613).field1509.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1589 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2234() {
      this.field1585 = (this.field1585 ^ this.field1585 >> 31) + (this.field1585 >>> 31);
      this.field1585 = -this.field1585;
   }

   @ObfuscatedName("h")
   void method2122() {
      if(this.field1598 != 0) {
         if(this.field1586 == Integer.MIN_VALUE) {
            this.field1586 = 0;
         }

         this.field1598 = 0;
         this.method2113();
      }

   }

   @ObfuscatedName("d")
   public synchronized void method2123(int var1, int var2) {
      this.method2124(var1, var2, this.method2119());
   }

   @ObfuscatedName("v")
   public synchronized void method2124(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2117(var2, var3);
      } else {
         int var4 = method2248(var2, var3);
         int var5 = method2187(var2, var3);
         if(var4 == this.field1588 && var5 == this.field1584) {
            this.field1598 = 0;
         } else {
            int var6 = var2 - this.field1590;
            if(this.field1590 - var2 > var6) {
               var6 = this.field1590 - var2;
            }

            if(var4 - this.field1588 > var6) {
               var6 = var4 - this.field1588;
            }

            if(this.field1588 - var4 > var6) {
               var6 = this.field1588 - var4;
            }

            if(var5 - this.field1584 > var6) {
               var6 = var5 - this.field1584;
            }

            if(this.field1584 - var5 > var6) {
               var6 = this.field1584 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1598 = var1;
            this.field1586 = var2;
            this.field1597 = var3;
            this.field1596 = (var2 - this.field1590) / var1;
            this.field1595 = (var4 - this.field1588) / var1;
            this.field1587 = (var5 - this.field1584) / var1;
         }
      }
   }

   @ObfuscatedName("p")
   public synchronized void method2169(int var1) {
      if(var1 == 0) {
         this.method2116(0);
         this.unlink();
      } else if(this.field1588 == 0 && this.field1584 == 0) {
         this.field1598 = 0;
         this.field1586 = 0;
         this.field1590 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1590;
         if(this.field1590 > var2) {
            var2 = this.field1590;
         }

         if(-this.field1588 > var2) {
            var2 = -this.field1588;
         }

         if(this.field1588 > var2) {
            var2 = this.field1588;
         }

         if(-this.field1584 > var2) {
            var2 = -this.field1584;
         }

         if(this.field1584 > var2) {
            var2 = this.field1584;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1598 = var1;
         this.field1586 = Integer.MIN_VALUE;
         this.field1596 = -this.field1590 / var1;
         this.field1595 = -this.field1588 / var1;
         this.field1587 = -this.field1584 / var1;
      }
   }

   @ObfuscatedName("ab")
   public synchronized void method2207(int var1) {
      if(this.field1585 < 0) {
         this.field1585 = -var1;
      } else {
         this.field1585 = var1;
      }

   }

   @ObfuscatedName("ad")
   public synchronized int method2127() {
      return this.field1585 < 0?-this.field1585:this.field1585;
   }

   @ObfuscatedName("ag")
   public boolean method2194() {
      return this.field1589 < 0 || this.field1589 >= ((MusicTrack2)super.field1613).field1509.length << 8;
   }

   @ObfuscatedName("ak")
   public boolean method2129() {
      return this.field1598 != 0;
   }

   @ObfuscatedName("as")
   int method2135(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1598 > 0) {
            int var6 = var2 + this.field1598;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1598 += var2;
            if(this.field1585 == 256 && (this.field1589 & 255) == 0) {
               if(ContextMenuRow.highMemory) {
                  var2 = method2147(0, ((MusicTrack2)super.field1613).field1509, var1, this.field1589, var2, this.field1588, this.field1584, this.field1595, this.field1587, 0, var6, var3, this);
               } else {
                  var2 = method2146(((MusicTrack2)super.field1613).field1509, var1, this.field1589, var2, this.field1590, this.field1596, 0, var6, var3, this);
               }
            } else if(ContextMenuRow.highMemory) {
               var2 = method2151(0, 0, ((MusicTrack2)super.field1613).field1509, var1, this.field1589, var2, this.field1588, this.field1584, this.field1595, this.field1587, 0, var6, var3, this, this.field1585, var5);
            } else {
               var2 = method2133(0, 0, ((MusicTrack2)super.field1613).field1509, var1, this.field1589, var2, this.field1590, this.field1596, 0, var6, var3, this, this.field1585, var5);
            }

            this.field1598 -= var2;
            if(this.field1598 != 0) {
               return var2;
            }

            if(!this.method2137()) {
               continue;
            }

            return var4;
         }

         if(this.field1585 == 256 && (this.field1589 & 255) == 0) {
            if(ContextMenuRow.highMemory) {
               return method2139(0, ((MusicTrack2)super.field1613).field1509, var1, this.field1589, var2, this.field1588, this.field1584, 0, var4, var3, this);
            }

            return method2138(((MusicTrack2)super.field1613).field1509, var1, this.field1589, var2, this.field1590, 0, var4, var3, this);
         }

         if(ContextMenuRow.highMemory) {
            return method2143(0, 0, ((MusicTrack2)super.field1613).field1509, var1, this.field1589, var2, this.field1588, this.field1584, 0, var4, var3, this, this.field1585, var5);
         }

         return method2142(0, 0, ((MusicTrack2)super.field1613).field1509, var1, this.field1589, var2, this.field1590, 0, var4, var3, this, this.field1585, var5);
      }
   }

   @ObfuscatedName("ai")
   int method2136(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1598 > 0) {
            int var6 = var2 + this.field1598;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1598 += var2;
            if(this.field1585 == -256 && (this.field1589 & 255) == 0) {
               if(ContextMenuRow.highMemory) {
                  var2 = method2128(0, ((MusicTrack2)super.field1613).field1509, var1, this.field1589, var2, this.field1588, this.field1584, this.field1595, this.field1587, 0, var6, var3, this);
               } else {
                  var2 = method2148(((MusicTrack2)super.field1613).field1509, var1, this.field1589, var2, this.field1590, this.field1596, 0, var6, var3, this);
               }
            } else if(ContextMenuRow.highMemory) {
               var2 = method2153(0, 0, ((MusicTrack2)super.field1613).field1509, var1, this.field1589, var2, this.field1588, this.field1584, this.field1595, this.field1587, 0, var6, var3, this, this.field1585, var5);
            } else {
               var2 = method2230(0, 0, ((MusicTrack2)super.field1613).field1509, var1, this.field1589, var2, this.field1590, this.field1596, 0, var6, var3, this, this.field1585, var5);
            }

            this.field1598 -= var2;
            if(this.field1598 != 0) {
               return var2;
            }

            if(!this.method2137()) {
               continue;
            }

            return var4;
         }

         if(this.field1585 == -256 && (this.field1589 & 255) == 0) {
            if(ContextMenuRow.highMemory) {
               return method2141(0, ((MusicTrack2)super.field1613).field1509, var1, this.field1589, var2, this.field1588, this.field1584, 0, var4, var3, this);
            }

            return method2204(((MusicTrack2)super.field1613).field1509, var1, this.field1589, var2, this.field1590, 0, var4, var3, this);
         }

         if(ContextMenuRow.highMemory) {
            return method2267(0, 0, ((MusicTrack2)super.field1613).field1509, var1, this.field1589, var2, this.field1588, this.field1584, 0, var4, var3, this, this.field1585, var5);
         }

         return method2266(0, 0, ((MusicTrack2)super.field1613).field1509, var1, this.field1589, var2, this.field1590, 0, var4, var3, this, this.field1585, var5);
      }
   }

   @ObfuscatedName("af")
   boolean method2137() {
      int var1 = this.field1586;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2248(var1, this.field1597);
         var3 = method2187(var1, this.field1597);
      }

      if(var1 == this.field1590 && var2 == this.field1588 && var3 == this.field1584) {
         if(this.field1586 == Integer.MIN_VALUE) {
            this.field1586 = 0;
            this.field1584 = 0;
            this.field1588 = 0;
            this.field1590 = 0;
            this.unlink();
            return true;
         } else {
            this.method2113();
            return false;
         }
      } else {
         if(this.field1590 < var1) {
            this.field1596 = 1;
            this.field1598 = var1 - this.field1590;
         } else if(this.field1590 > var1) {
            this.field1596 = -1;
            this.field1598 = this.field1590 - var1;
         } else {
            this.field1596 = 0;
         }

         if(this.field1588 < var2) {
            this.field1595 = 1;
            if(this.field1598 == 0 || this.field1598 > var2 - this.field1588) {
               this.field1598 = var2 - this.field1588;
            }
         } else if(this.field1588 > var2) {
            this.field1595 = -1;
            if(this.field1598 == 0 || this.field1598 > this.field1588 - var2) {
               this.field1598 = this.field1588 - var2;
            }
         } else {
            this.field1595 = 0;
         }

         if(this.field1584 < var3) {
            this.field1587 = 1;
            if(this.field1598 == 0 || this.field1598 > var3 - this.field1584) {
               this.field1598 = var3 - this.field1584;
            }
         } else if(this.field1584 > var3) {
            this.field1587 = -1;
            if(this.field1598 == 0 || this.field1598 > this.field1584 - var3) {
               this.field1598 = this.field1584 - var3;
            }
         } else {
            this.field1587 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("aa")
   int vmethod2290() {
      int var1 = this.field1590 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1591 == 0) {
         var1 -= var1 * this.field1589 / (((MusicTrack2)super.field1613).field1509.length << 8);
      } else if(this.field1591 >= 0) {
         var1 -= var1 * this.field1592 / ((MusicTrack2)super.field1613).field1509.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("a")
   static int method2248(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("w")
   static int method2187(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ldx;II)Ldg;"
   )
   public static SongMetadata method2160(MusicTrack2 var0, int var1, int var2) {
      return var0.field1509 != null && var0.field1509.length != 0?new SongMetadata(var0, (int)((long)var0.field1511 * 256L * (long)var1 / (long)(ScriptState.sampleRate * 100)), var2 << 6):null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ldx;III)Ldg;"
   )
   public static SongMetadata method2112(MusicTrack2 var0, int var1, int var2, int var3) {
      return var0.field1509 != null && var0.field1509.length != 0?new SongMetadata(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdg;)I"
   )
   static int method2138(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, SongMetadata var8) {
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

      var8.field1589 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdg;)I"
   )
   static int method2139(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, SongMetadata var10) {
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

      var10.field1589 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdg;)I"
   )
   static int method2204(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, SongMetadata var8) {
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

      var8.field1589 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdg;)I"
   )
   static int method2141(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, SongMetadata var10) {
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

      var10.field1589 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdg;II)I"
   )
   static int method2142(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, SongMetadata var10, int var11, int var12) {
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

      var10.field1589 = var4;
      return var5;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdg;II)I"
   )
   static int method2143(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, SongMetadata var11, int var12, int var13) {
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

      var11.field1589 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdg;II)I"
   )
   static int method2266(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, SongMetadata var10, int var11, int var12) {
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

      var10.field1589 = var4;
      return var5;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdg;II)I"
   )
   static int method2267(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, SongMetadata var11, int var12, int var13) {
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

      var11.field1589 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdg;)I"
   )
   static int method2146(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, SongMetadata var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1588 += var9.field1595 * (var6 - var3);
      var9.field1584 += var9.field1587 * (var6 - var3);

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

      var9.field1590 = var4 >> 2;
      var9.field1589 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdg;)I"
   )
   static int method2147(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, SongMetadata var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1590 += var12.field1596 * (var9 - var4);
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

      var12.field1588 = var5 >> 2;
      var12.field1584 = var6 >> 2;
      var12.field1589 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdg;)I"
   )
   static int method2148(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, SongMetadata var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1588 += var9.field1595 * (var6 - var3);
      var9.field1584 += var9.field1587 * (var6 - var3);

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

      var9.field1590 = var4 >> 2;
      var9.field1589 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdg;)I"
   )
   static int method2128(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, SongMetadata var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1590 += var12.field1596 * (var9 - var4);
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

      var12.field1588 = var5 >> 2;
      var12.field1584 = var6 >> 2;
      var12.field1589 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdg;II)I"
   )
   static int method2133(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, SongMetadata var11, int var12, int var13) {
      var11.field1588 -= var11.field1595 * var5;
      var11.field1584 -= var11.field1587 * var5;
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

      var11.field1588 += var11.field1595 * var5;
      var11.field1584 += var11.field1587 * var5;
      var11.field1590 = var6;
      var11.field1589 = var4;
      return var5;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdg;II)I"
   )
   static int method2151(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, SongMetadata var13, int var14, int var15) {
      var13.field1590 -= var5 * var13.field1596;
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
      var13.field1590 += var13.field1596 * var5;
      var13.field1588 = var6;
      var13.field1584 = var7;
      var13.field1589 = var4;
      return var5;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdg;II)I"
   )
   static int method2230(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, SongMetadata var11, int var12, int var13) {
      var11.field1588 -= var11.field1595 * var5;
      var11.field1584 -= var11.field1587 * var5;
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

      var11.field1588 += var11.field1595 * var5;
      var11.field1584 += var11.field1587 * var5;
      var11.field1590 = var6;
      var11.field1589 = var4;
      return var5;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdg;II)I"
   )
   static int method2153(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, SongMetadata var13, int var14, int var15) {
      var13.field1590 -= var5 * var13.field1596;
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
      var13.field1590 += var13.field1596 * var5;
      var13.field1588 = var6;
      var13.field1584 = var7;
      var13.field1589 = var4;
      return var5;
   }
}
