import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public class class115 extends TaskDataNode {
   @ObfuscatedName("c")
   int field1614;
   @ObfuscatedName("i")
   int field1612;
   @ObfuscatedName("o")
   int field1613;
   @ObfuscatedName("j")
   int field1621;
   @ObfuscatedName("k")
   int field1611;
   @ObfuscatedName("x")
   int field1616;
   @ObfuscatedName("z")
   int field1617;
   @ObfuscatedName("p")
   int field1618;
   @ObfuscatedName("r")
   @Export("startPosition")
   int startPosition;
   @ObfuscatedName("d")
   @Export("endPosition")
   int endPosition;
   @ObfuscatedName("a")
   boolean field1620;
   @ObfuscatedName("e")
   int field1622;
   @ObfuscatedName("f")
   int field1623;
   @ObfuscatedName("l")
   int field1624;
   @ObfuscatedName("m")
   int field1625;

   @ObfuscatedSignature(
      signature = "(Lda;III)V"
   )
   class115(RawAudioNode var1, int var2, int var3, int var4) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1620 = var1.field1539;
      this.field1612 = var2;
      this.field1613 = var3;
      this.field1621 = var4;
      this.field1614 = 0;
      this.method2302();
   }

   @ObfuscatedSignature(
      signature = "(Lda;II)V"
   )
   class115(RawAudioNode var1, int var2, int var3) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1620 = var1.field1539;
      this.field1612 = var2;
      this.field1613 = var3;
      this.field1621 = 8192;
      this.field1614 = 0;
      this.method2302();
   }

   @ObfuscatedName("k")
   void method2302() {
      this.field1611 = this.field1613;
      this.field1616 = method2316(this.field1613, this.field1621);
      this.field1617 = method2396(this.field1613, this.field1621);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected TaskDataNode vmethod4336() {
      return null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected TaskDataNode vmethod4337() {
      return null;
   }

   @ObfuscatedName("p")
   protected int vmethod4338() {
      return this.field1613 == 0 && this.field1622 == 0?0:1;
   }

   @ObfuscatedName("w")
   public synchronized void vmethod4339(int[] var1, int var2, int var3) {
      if(this.field1613 == 0 && this.field1622 == 0) {
         this.vmethod4340(var3);
      } else {
         RawAudioNode var4 = (RawAudioNode)super.data;
         int var5 = this.startPosition << 8;
         int var6 = this.endPosition << 8;
         int var7 = var4.audioBuffer.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1618 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1614 < 0) {
            if(this.field1612 <= 0) {
               this.method2311();
               this.unlink();
               return;
            }

            this.field1614 = 0;
         }

         if(this.field1614 >= var7) {
            if(this.field1612 >= 0) {
               this.method2311();
               this.unlink();
               return;
            }

            this.field1614 = var7 - 1;
         }

         if(this.field1618 < 0) {
            if(this.field1620) {
               if(this.field1612 < 0) {
                  var9 = this.method2402(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1614 >= var5) {
                     return;
                  }

                  this.field1614 = var5 + var5 - 1 - this.field1614;
                  this.field1612 = -this.field1612;
               }

               while(true) {
                  var9 = this.method2324(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1614 < var6) {
                     return;
                  }

                  this.field1614 = var6 + var6 - 1 - this.field1614;
                  this.field1612 = -this.field1612;
                  var9 = this.method2402(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1614 >= var5) {
                     return;
                  }

                  this.field1614 = var5 + var5 - 1 - this.field1614;
                  this.field1612 = -this.field1612;
               }
            } else if(this.field1612 < 0) {
               while(true) {
                  var9 = this.method2402(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1614 >= var5) {
                     return;
                  }

                  this.field1614 = var6 - 1 - (var6 - 1 - this.field1614) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2324(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1614 < var6) {
                     return;
                  }

                  this.field1614 = var5 + (this.field1614 - var5) % var8;
               }
            }
         } else {
            if(this.field1618 > 0) {
               if(this.field1620) {
                  label135: {
                     if(this.field1612 < 0) {
                        var9 = this.method2402(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1614 >= var5) {
                           return;
                        }

                        this.field1614 = var5 + var5 - 1 - this.field1614;
                        this.field1612 = -this.field1612;
                        if(--this.field1618 == 0) {
                           break label135;
                        }
                     }

                     do {
                        var9 = this.method2324(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1614 < var6) {
                           return;
                        }

                        this.field1614 = var6 + var6 - 1 - this.field1614;
                        this.field1612 = -this.field1612;
                        if(--this.field1618 == 0) {
                           break;
                        }

                        var9 = this.method2402(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1614 >= var5) {
                           return;
                        }

                        this.field1614 = var5 + var5 - 1 - this.field1614;
                        this.field1612 = -this.field1612;
                     } while(--this.field1618 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1612 < 0) {
                     while(true) {
                        var9 = this.method2402(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1614 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1614) / var8;
                        if(var10 >= this.field1618) {
                           this.field1614 += var8 * this.field1618;
                           this.field1618 = 0;
                           break;
                        }

                        this.field1614 += var8 * var10;
                        this.field1618 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2324(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1614 < var6) {
                           return;
                        }

                        var10 = (this.field1614 - var5) / var8;
                        if(var10 >= this.field1618) {
                           this.field1614 -= var8 * this.field1618;
                           this.field1618 = 0;
                           break;
                        }

                        this.field1614 -= var8 * var10;
                        this.field1618 -= var10;
                     }
                  }
               }
            }

            if(this.field1612 < 0) {
               this.method2402(var1, var9, 0, var3, 0);
               if(this.field1614 < 0) {
                  this.field1614 = -1;
                  this.method2311();
                  this.unlink();
               }
            } else {
               this.method2324(var1, var9, var7, var3, 0);
               if(this.field1614 >= var7) {
                  this.field1614 = var7;
                  this.method2311();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("r")
   public synchronized void method2303(int var1) {
      this.field1618 = var1;
   }

   @ObfuscatedName("d")
   public synchronized void vmethod4340(int var1) {
      if(this.field1622 > 0) {
         if(var1 >= this.field1622) {
            if(this.field1613 == Integer.MIN_VALUE) {
               this.field1613 = 0;
               this.field1617 = 0;
               this.field1616 = 0;
               this.field1611 = 0;
               this.unlink();
               var1 = this.field1622;
            }

            this.field1622 = 0;
            this.method2302();
         } else {
            this.field1611 += this.field1623 * var1;
            this.field1616 += this.field1624 * var1;
            this.field1617 += this.field1625 * var1;
            this.field1622 -= var1;
         }
      }

      RawAudioNode var2 = (RawAudioNode)super.data;
      int var3 = this.startPosition << 8;
      int var4 = this.endPosition << 8;
      int var5 = var2.audioBuffer.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1618 = 0;
      }

      if(this.field1614 < 0) {
         if(this.field1612 <= 0) {
            this.method2311();
            this.unlink();
            return;
         }

         this.field1614 = 0;
      }

      if(this.field1614 >= var5) {
         if(this.field1612 >= 0) {
            this.method2311();
            this.unlink();
            return;
         }

         this.field1614 = var5 - 1;
      }

      this.field1614 += this.field1612 * var1;
      if(this.field1618 < 0) {
         if(!this.field1620) {
            if(this.field1612 < 0) {
               if(this.field1614 >= var3) {
                  return;
               }

               this.field1614 = var4 - 1 - (var4 - 1 - this.field1614) % var6;
            } else {
               if(this.field1614 < var4) {
                  return;
               }

               this.field1614 = var3 + (this.field1614 - var3) % var6;
            }

         } else {
            if(this.field1612 < 0) {
               if(this.field1614 >= var3) {
                  return;
               }

               this.field1614 = var3 + var3 - 1 - this.field1614;
               this.field1612 = -this.field1612;
            }

            while(this.field1614 >= var4) {
               this.field1614 = var4 + var4 - 1 - this.field1614;
               this.field1612 = -this.field1612;
               if(this.field1614 >= var3) {
                  return;
               }

               this.field1614 = var3 + var3 - 1 - this.field1614;
               this.field1612 = -this.field1612;
            }

         }
      } else {
         if(this.field1618 > 0) {
            if(this.field1620) {
               label125: {
                  if(this.field1612 < 0) {
                     if(this.field1614 >= var3) {
                        return;
                     }

                     this.field1614 = var3 + var3 - 1 - this.field1614;
                     this.field1612 = -this.field1612;
                     if(--this.field1618 == 0) {
                        break label125;
                     }
                  }

                  do {
                     if(this.field1614 < var4) {
                        return;
                     }

                     this.field1614 = var4 + var4 - 1 - this.field1614;
                     this.field1612 = -this.field1612;
                     if(--this.field1618 == 0) {
                        break;
                     }

                     if(this.field1614 >= var3) {
                        return;
                     }

                     this.field1614 = var3 + var3 - 1 - this.field1614;
                     this.field1612 = -this.field1612;
                  } while(--this.field1618 != 0);
               }
            } else {
               int var7;
               if(this.field1612 < 0) {
                  if(this.field1614 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1614) / var6;
                  if(var7 < this.field1618) {
                     this.field1614 += var6 * var7;
                     this.field1618 -= var7;
                     return;
                  }

                  this.field1614 += var6 * this.field1618;
                  this.field1618 = 0;
               } else {
                  if(this.field1614 < var4) {
                     return;
                  }

                  var7 = (this.field1614 - var3) / var6;
                  if(var7 < this.field1618) {
                     this.field1614 -= var6 * var7;
                     this.field1618 -= var7;
                     return;
                  }

                  this.field1614 -= var6 * this.field1618;
                  this.field1618 = 0;
               }
            }
         }

         if(this.field1612 < 0) {
            if(this.field1614 < 0) {
               this.field1614 = -1;
               this.method2311();
               this.unlink();
            }
         } else if(this.field1614 >= var5) {
            this.field1614 = var5;
            this.method2311();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("a")
   public synchronized void method2304(int var1) {
      this.method2306(var1 << 6, this.method2436());
   }

   @ObfuscatedName("b")
   synchronized void method2347(int var1) {
      this.method2306(var1, this.method2436());
   }

   @ObfuscatedName("h")
   synchronized void method2306(int var1, int var2) {
      this.field1613 = var1;
      this.field1621 = var2;
      this.field1622 = 0;
      this.method2302();
   }

   @ObfuscatedName("n")
   public synchronized int method2307() {
      return this.field1613 == Integer.MIN_VALUE?0:this.field1613;
   }

   @ObfuscatedName("u")
   public synchronized int method2436() {
      return this.field1621 < 0?-1:this.field1621;
   }

   @ObfuscatedName("q")
   public synchronized void method2323(int var1) {
      int var2 = ((RawAudioNode)super.data).audioBuffer.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1614 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2310() {
      this.field1612 = (this.field1612 ^ this.field1612 >> 31) + (this.field1612 >>> 31);
      this.field1612 = -this.field1612;
   }

   @ObfuscatedName("y")
   void method2311() {
      if(this.field1622 != 0) {
         if(this.field1613 == Integer.MIN_VALUE) {
            this.field1613 = 0;
         }

         this.field1622 = 0;
         this.method2302();
      }

   }

   @ObfuscatedName("s")
   public synchronized void method2312(int var1, int var2) {
      this.method2313(var1, var2, this.method2436());
   }

   @ObfuscatedName("ac")
   public synchronized void method2313(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2306(var2, var3);
      } else {
         int var4 = method2316(var2, var3);
         int var5 = method2396(var2, var3);
         if(var4 == this.field1616 && var5 == this.field1617) {
            this.field1622 = 0;
         } else {
            int var6 = var2 - this.field1611;
            if(this.field1611 - var2 > var6) {
               var6 = this.field1611 - var2;
            }

            if(var4 - this.field1616 > var6) {
               var6 = var4 - this.field1616;
            }

            if(this.field1616 - var4 > var6) {
               var6 = this.field1616 - var4;
            }

            if(var5 - this.field1617 > var6) {
               var6 = var5 - this.field1617;
            }

            if(this.field1617 - var5 > var6) {
               var6 = this.field1617 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1622 = var1;
            this.field1613 = var2;
            this.field1621 = var3;
            this.field1623 = (var2 - this.field1611) / var1;
            this.field1624 = (var4 - this.field1616) / var1;
            this.field1625 = (var5 - this.field1617) / var1;
         }
      }
   }

   @ObfuscatedName("ah")
   public synchronized void method2314(int var1) {
      if(var1 == 0) {
         this.method2347(0);
         this.unlink();
      } else if(this.field1616 == 0 && this.field1617 == 0) {
         this.field1622 = 0;
         this.field1613 = 0;
         this.field1611 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1611;
         if(this.field1611 > var2) {
            var2 = this.field1611;
         }

         if(-this.field1616 > var2) {
            var2 = -this.field1616;
         }

         if(this.field1616 > var2) {
            var2 = this.field1616;
         }

         if(-this.field1617 > var2) {
            var2 = -this.field1617;
         }

         if(this.field1617 > var2) {
            var2 = this.field1617;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1622 = var1;
         this.field1613 = Integer.MIN_VALUE;
         this.field1623 = -this.field1611 / var1;
         this.field1624 = -this.field1616 / var1;
         this.field1625 = -this.field1617 / var1;
      }
   }

   @ObfuscatedName("af")
   public synchronized void method2315(int var1) {
      if(this.field1612 < 0) {
         this.field1612 = -var1;
      } else {
         this.field1612 = var1;
      }

   }

   @ObfuscatedName("aw")
   public synchronized int method2296() {
      return this.field1612 < 0?-this.field1612:this.field1612;
   }

   @ObfuscatedName("ax")
   public boolean method2317() {
      return this.field1614 < 0 || this.field1614 >= ((RawAudioNode)super.data).audioBuffer.length << 8;
   }

   @ObfuscatedName("ag")
   public boolean method2318() {
      return this.field1622 != 0;
   }

   @ObfuscatedName("ay")
   int vmethod2472() {
      int var1 = this.field1611 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1618 == 0) {
         var1 -= var1 * this.field1614 / (((RawAudioNode)super.data).audioBuffer.length << 8);
      } else if(this.field1618 >= 0) {
         var1 -= var1 * this.startPosition / ((RawAudioNode)super.data).audioBuffer.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("ad")
   int method2324(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1622 > 0) {
            int var6 = var2 + this.field1622;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1622 += var2;
            if(this.field1612 == 256 && (this.field1614 & 255) == 0) {
               if(UnitPriceComparator.audioHighMemory) {
                  var2 = method2336(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1614, var2, this.field1616, this.field1617, this.field1624, this.field1625, 0, var6, var3, this);
               } else {
                  var2 = method2394(((RawAudioNode)super.data).audioBuffer, var1, this.field1614, var2, this.field1611, this.field1623, 0, var6, var3, this);
               }
            } else if(UnitPriceComparator.audioHighMemory) {
               var2 = method2367(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1614, var2, this.field1616, this.field1617, this.field1624, this.field1625, 0, var6, var3, this, this.field1612, var5);
            } else {
               var2 = method2339(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1614, var2, this.field1611, this.field1623, 0, var6, var3, this, this.field1612, var5);
            }

            this.field1622 -= var2;
            if(this.field1622 != 0) {
               return var2;
            }

            if(!this.method2301()) {
               continue;
            }

            return var4;
         }

         if(this.field1612 == 256 && (this.field1614 & 255) == 0) {
            if(UnitPriceComparator.audioHighMemory) {
               return method2328(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1614, var2, this.field1616, this.field1617, 0, var4, var3, this);
            }

            return method2326(((RawAudioNode)super.data).audioBuffer, var1, this.field1614, var2, this.field1611, 0, var4, var3, this);
         }

         if(UnitPriceComparator.audioHighMemory) {
            return method2443(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1614, var2, this.field1616, this.field1617, 0, var4, var3, this, this.field1612, var5);
         }

         return method2299(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1614, var2, this.field1611, 0, var4, var3, this, this.field1612, var5);
      }
   }

   @ObfuscatedName("at")
   int method2402(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1622 > 0) {
            int var6 = var2 + this.field1622;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1622 += var2;
            if(this.field1612 == -256 && (this.field1614 & 255) == 0) {
               if(UnitPriceComparator.audioHighMemory) {
                  var2 = method2338(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1614, var2, this.field1616, this.field1617, this.field1624, this.field1625, 0, var6, var3, this);
               } else {
                  var2 = method2337(((RawAudioNode)super.data).audioBuffer, var1, this.field1614, var2, this.field1611, this.field1623, 0, var6, var3, this);
               }
            } else if(UnitPriceComparator.audioHighMemory) {
               var2 = method2342(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1614, var2, this.field1616, this.field1617, this.field1624, this.field1625, 0, var6, var3, this, this.field1612, var5);
            } else {
               var2 = method2438(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1614, var2, this.field1611, this.field1623, 0, var6, var3, this, this.field1612, var5);
            }

            this.field1622 -= var2;
            if(this.field1622 != 0) {
               return var2;
            }

            if(!this.method2301()) {
               continue;
            }

            return var4;
         }

         if(this.field1612 == -256 && (this.field1614 & 255) == 0) {
            if(UnitPriceComparator.audioHighMemory) {
               return method2330(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1614, var2, this.field1616, this.field1617, 0, var4, var3, this);
            }

            return method2340(((RawAudioNode)super.data).audioBuffer, var1, this.field1614, var2, this.field1611, 0, var4, var3, this);
         }

         if(UnitPriceComparator.audioHighMemory) {
            return method2334(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1614, var2, this.field1616, this.field1617, 0, var4, var3, this, this.field1612, var5);
         }

         return method2359(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1614, var2, this.field1611, 0, var4, var3, this, this.field1612, var5);
      }
   }

   @ObfuscatedName("av")
   boolean method2301() {
      int var1 = this.field1613;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2316(var1, this.field1621);
         var3 = method2396(var1, this.field1621);
      }

      if(var1 == this.field1611 && var2 == this.field1616 && var3 == this.field1617) {
         if(this.field1613 == Integer.MIN_VALUE) {
            this.field1613 = 0;
            this.field1617 = 0;
            this.field1616 = 0;
            this.field1611 = 0;
            this.unlink();
            return true;
         } else {
            this.method2302();
            return false;
         }
      } else {
         if(this.field1611 < var1) {
            this.field1623 = 1;
            this.field1622 = var1 - this.field1611;
         } else if(this.field1611 > var1) {
            this.field1623 = -1;
            this.field1622 = this.field1611 - var1;
         } else {
            this.field1623 = 0;
         }

         if(this.field1616 < var2) {
            this.field1624 = 1;
            if(this.field1622 == 0 || this.field1622 > var2 - this.field1616) {
               this.field1622 = var2 - this.field1616;
            }
         } else if(this.field1616 > var2) {
            this.field1624 = -1;
            if(this.field1622 == 0 || this.field1622 > this.field1616 - var2) {
               this.field1622 = this.field1616 - var2;
            }
         } else {
            this.field1624 = 0;
         }

         if(this.field1617 < var3) {
            this.field1625 = 1;
            if(this.field1622 == 0 || this.field1622 > var3 - this.field1617) {
               this.field1622 = var3 - this.field1617;
            }
         } else if(this.field1617 > var3) {
            this.field1625 = -1;
            if(this.field1622 == 0 || this.field1622 > this.field1617 - var3) {
               this.field1622 = this.field1617 - var3;
            }
         } else {
            this.field1625 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("c")
   static int method2316(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("i")
   static int method2396(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lda;II)Ldx;"
   )
   public static class115 method2300(RawAudioNode var0, int var1, int var2) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class115(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(class317.sampleRate * 100)), var2 << 6):null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lda;III)Ldx;"
   )
   public static class115 method2446(RawAudioNode var0, int var1, int var2, int var3) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class115(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdx;)I"
   )
   static int method2326(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class115 var8) {
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

      var8.field1614 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdx;)I"
   )
   static int method2328(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10) {
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

      var10.field1614 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdx;)I"
   )
   static int method2340(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class115 var8) {
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

      var8.field1614 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdx;)I"
   )
   static int method2330(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10) {
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

      var10.field1614 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdx;II)I"
   )
   static int method2299(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10, int var11, int var12) {
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

      var10.field1614 = var4;
      return var5;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdx;II)I"
   )
   static int method2443(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
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

      var11.field1614 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdx;II)I"
   )
   static int method2359(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10, int var11, int var12) {
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

      var10.field1614 = var4;
      return var5;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdx;II)I"
   )
   static int method2334(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
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

      var11.field1614 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdx;)I"
   )
   static int method2394(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class115 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1616 += var9.field1624 * (var6 - var3);
      var9.field1617 += var9.field1625 * (var6 - var3);

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

      var9.field1611 = var4 >> 2;
      var9.field1614 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdx;)I"
   )
   static int method2336(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class115 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1611 += var12.field1623 * (var9 - var4);
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

      var12.field1616 = var5 >> 2;
      var12.field1617 = var6 >> 2;
      var12.field1614 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdx;)I"
   )
   static int method2337(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class115 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1616 += var9.field1624 * (var6 - var3);
      var9.field1617 += var9.field1625 * (var6 - var3);

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

      var9.field1611 = var4 >> 2;
      var9.field1614 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdx;)I"
   )
   static int method2338(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class115 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1611 += var12.field1623 * (var9 - var4);
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

      var12.field1616 = var5 >> 2;
      var12.field1617 = var6 >> 2;
      var12.field1614 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdx;II)I"
   )
   static int method2339(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
      var11.field1616 -= var11.field1624 * var5;
      var11.field1617 -= var11.field1625 * var5;
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

      var11.field1616 += var11.field1624 * var5;
      var11.field1617 += var11.field1625 * var5;
      var11.field1611 = var6;
      var11.field1614 = var4;
      return var5;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdx;II)I"
   )
   static int method2367(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class115 var13, int var14, int var15) {
      var13.field1611 -= var5 * var13.field1623;
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
      var13.field1611 += var13.field1623 * var5;
      var13.field1616 = var6;
      var13.field1617 = var7;
      var13.field1614 = var4;
      return var5;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdx;II)I"
   )
   static int method2438(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
      var11.field1616 -= var11.field1624 * var5;
      var11.field1617 -= var11.field1625 * var5;
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

      var11.field1616 += var11.field1624 * var5;
      var11.field1617 += var11.field1625 * var5;
      var11.field1611 = var6;
      var11.field1614 = var4;
      return var5;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdx;II)I"
   )
   static int method2342(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class115 var13, int var14, int var15) {
      var13.field1611 -= var5 * var13.field1623;
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
      var13.field1611 += var13.field1623 * var5;
      var13.field1616 = var6;
      var13.field1617 = var7;
      var13.field1614 = var4;
      return var5;
   }
}
