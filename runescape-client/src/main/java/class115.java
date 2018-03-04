import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public class class115 extends TaskDataNode {
   @ObfuscatedName("d")
   int field1613;
   @ObfuscatedName("z")
   int field1623;
   @ObfuscatedName("n")
   int field1619;
   @ObfuscatedName("r")
   int field1614;
   @ObfuscatedName("e")
   int field1615;
   @ObfuscatedName("y")
   int field1616;
   @ObfuscatedName("k")
   int field1611;
   @ObfuscatedName("s")
   int field1618;
   @ObfuscatedName("p")
   @Export("startPosition")
   int startPosition;
   @ObfuscatedName("x")
   @Export("endPosition")
   int endPosition;
   @ObfuscatedName("m")
   boolean field1621;
   @ObfuscatedName("h")
   int field1622;
   @ObfuscatedName("t")
   int field1625;
   @ObfuscatedName("i")
   int field1624;
   @ObfuscatedName("u")
   int field1620;

   @ObfuscatedSignature(
      signature = "(Ldd;III)V"
   )
   class115(RawAudioNode var1, int var2, int var3, int var4) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1621 = var1.field1535;
      this.field1623 = var2;
      this.field1619 = var3;
      this.field1614 = var4;
      this.field1613 = 0;
      this.method2394();
   }

   @ObfuscatedSignature(
      signature = "(Ldd;II)V"
   )
   class115(RawAudioNode var1, int var2, int var3) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1621 = var1.field1535;
      this.field1623 = var2;
      this.field1619 = var3;
      this.field1614 = 8192;
      this.field1613 = 0;
      this.method2394();
   }

   @ObfuscatedName("e")
   void method2394() {
      this.field1615 = this.field1619;
      this.field1616 = method2377(this.field1619, this.field1614);
      this.field1611 = method2453(this.field1619, this.field1614);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "()Ldt;"
   )
   protected TaskDataNode vmethod4438() {
      return null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "()Ldt;"
   )
   protected TaskDataNode vmethod4433() {
      return null;
   }

   @ObfuscatedName("s")
   protected int vmethod4443() {
      return this.field1619 == 0 && this.field1622 == 0?0:1;
   }

   @ObfuscatedName("x")
   public synchronized void vmethod4435(int[] var1, int var2, int var3) {
      if(this.field1619 == 0 && this.field1622 == 0) {
         this.vmethod4436(var3);
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
         if(this.field1613 < 0) {
            if(this.field1623 <= 0) {
               this.method2374();
               this.unlink();
               return;
            }

            this.field1613 = 0;
         }

         if(this.field1613 >= var7) {
            if(this.field1623 >= 0) {
               this.method2374();
               this.unlink();
               return;
            }

            this.field1613 = var7 - 1;
         }

         if(this.field1618 < 0) {
            if(this.field1621) {
               if(this.field1623 < 0) {
                  var9 = this.method2516(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1613 >= var5) {
                     return;
                  }

                  this.field1613 = var5 + var5 - 1 - this.field1613;
                  this.field1623 = -this.field1623;
               }

               while(true) {
                  var9 = this.method2360(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1613 < var6) {
                     return;
                  }

                  this.field1613 = var6 + var6 - 1 - this.field1613;
                  this.field1623 = -this.field1623;
                  var9 = this.method2516(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1613 >= var5) {
                     return;
                  }

                  this.field1613 = var5 + var5 - 1 - this.field1613;
                  this.field1623 = -this.field1623;
               }
            } else if(this.field1623 < 0) {
               while(true) {
                  var9 = this.method2516(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1613 >= var5) {
                     return;
                  }

                  this.field1613 = var6 - 1 - (var6 - 1 - this.field1613) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2360(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1613 < var6) {
                     return;
                  }

                  this.field1613 = var5 + (this.field1613 - var5) % var8;
               }
            }
         } else {
            if(this.field1618 > 0) {
               if(this.field1621) {
                  label130: {
                     if(this.field1623 < 0) {
                        var9 = this.method2516(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1613 >= var5) {
                           return;
                        }

                        this.field1613 = var5 + var5 - 1 - this.field1613;
                        this.field1623 = -this.field1623;
                        if(--this.field1618 == 0) {
                           break label130;
                        }
                     }

                     do {
                        var9 = this.method2360(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1613 < var6) {
                           return;
                        }

                        this.field1613 = var6 + var6 - 1 - this.field1613;
                        this.field1623 = -this.field1623;
                        if(--this.field1618 == 0) {
                           break;
                        }

                        var9 = this.method2516(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1613 >= var5) {
                           return;
                        }

                        this.field1613 = var5 + var5 - 1 - this.field1613;
                        this.field1623 = -this.field1623;
                     } while(--this.field1618 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1623 < 0) {
                     while(true) {
                        var9 = this.method2516(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1613 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1613) / var8;
                        if(var10 >= this.field1618) {
                           this.field1613 += var8 * this.field1618;
                           this.field1618 = 0;
                           break;
                        }

                        this.field1613 += var8 * var10;
                        this.field1618 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2360(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1613 < var6) {
                           return;
                        }

                        var10 = (this.field1613 - var5) / var8;
                        if(var10 >= this.field1618) {
                           this.field1613 -= var8 * this.field1618;
                           this.field1618 = 0;
                           break;
                        }

                        this.field1613 -= var8 * var10;
                        this.field1618 -= var10;
                     }
                  }
               }
            }

            if(this.field1623 < 0) {
               this.method2516(var1, var9, 0, var3, 0);
               if(this.field1613 < 0) {
                  this.field1613 = -1;
                  this.method2374();
                  this.unlink();
               }
            } else {
               this.method2360(var1, var9, var7, var3, 0);
               if(this.field1613 >= var7) {
                  this.field1613 = var7;
                  this.method2374();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("h")
   public synchronized void method2366(int var1) {
      this.field1618 = var1;
   }

   @ObfuscatedName("t")
   public synchronized void vmethod4436(int var1) {
      if(this.field1622 > 0) {
         if(var1 >= this.field1622) {
            if(this.field1619 == Integer.MIN_VALUE) {
               this.field1619 = 0;
               this.field1611 = 0;
               this.field1616 = 0;
               this.field1615 = 0;
               this.unlink();
               var1 = this.field1622;
            }

            this.field1622 = 0;
            this.method2394();
         } else {
            this.field1615 += this.field1625 * var1;
            this.field1616 += this.field1624 * var1;
            this.field1611 += this.field1620 * var1;
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

      if(this.field1613 < 0) {
         if(this.field1623 <= 0) {
            this.method2374();
            this.unlink();
            return;
         }

         this.field1613 = 0;
      }

      if(this.field1613 >= var5) {
         if(this.field1623 >= 0) {
            this.method2374();
            this.unlink();
            return;
         }

         this.field1613 = var5 - 1;
      }

      this.field1613 += this.field1623 * var1;
      if(this.field1618 < 0) {
         if(!this.field1621) {
            if(this.field1623 < 0) {
               if(this.field1613 >= var3) {
                  return;
               }

               this.field1613 = var4 - 1 - (var4 - 1 - this.field1613) % var6;
            } else {
               if(this.field1613 < var4) {
                  return;
               }

               this.field1613 = var3 + (this.field1613 - var3) % var6;
            }

         } else {
            if(this.field1623 < 0) {
               if(this.field1613 >= var3) {
                  return;
               }

               this.field1613 = var3 + var3 - 1 - this.field1613;
               this.field1623 = -this.field1623;
            }

            while(this.field1613 >= var4) {
               this.field1613 = var4 + var4 - 1 - this.field1613;
               this.field1623 = -this.field1623;
               if(this.field1613 >= var3) {
                  return;
               }

               this.field1613 = var3 + var3 - 1 - this.field1613;
               this.field1623 = -this.field1623;
            }

         }
      } else {
         if(this.field1618 > 0) {
            if(this.field1621) {
               label124: {
                  if(this.field1623 < 0) {
                     if(this.field1613 >= var3) {
                        return;
                     }

                     this.field1613 = var3 + var3 - 1 - this.field1613;
                     this.field1623 = -this.field1623;
                     if(--this.field1618 == 0) {
                        break label124;
                     }
                  }

                  do {
                     if(this.field1613 < var4) {
                        return;
                     }

                     this.field1613 = var4 + var4 - 1 - this.field1613;
                     this.field1623 = -this.field1623;
                     if(--this.field1618 == 0) {
                        break;
                     }

                     if(this.field1613 >= var3) {
                        return;
                     }

                     this.field1613 = var3 + var3 - 1 - this.field1613;
                     this.field1623 = -this.field1623;
                  } while(--this.field1618 != 0);
               }
            } else {
               int var7;
               if(this.field1623 < 0) {
                  if(this.field1613 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1613) / var6;
                  if(var7 < this.field1618) {
                     this.field1613 += var6 * var7;
                     this.field1618 -= var7;
                     return;
                  }

                  this.field1613 += var6 * this.field1618;
                  this.field1618 = 0;
               } else {
                  if(this.field1613 < var4) {
                     return;
                  }

                  var7 = (this.field1613 - var3) / var6;
                  if(var7 < this.field1618) {
                     this.field1613 -= var6 * var7;
                     this.field1618 -= var7;
                     return;
                  }

                  this.field1613 -= var6 * this.field1618;
                  this.field1618 = 0;
               }
            }
         }

         if(this.field1623 < 0) {
            if(this.field1613 < 0) {
               this.field1613 = -1;
               this.method2374();
               this.unlink();
            }
         } else if(this.field1613 >= var5) {
            this.field1613 = var5;
            this.method2374();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("i")
   public synchronized void method2367(int var1) {
      this.method2419(var1 << 6, this.method2445());
   }

   @ObfuscatedName("u")
   synchronized void method2373(int var1) {
      this.method2419(var1, this.method2445());
   }

   @ObfuscatedName("q")
   synchronized void method2419(int var1, int var2) {
      this.field1619 = var1;
      this.field1614 = var2;
      this.field1622 = 0;
      this.method2394();
   }

   @ObfuscatedName("v")
   public synchronized int method2370() {
      return this.field1619 == Integer.MIN_VALUE?0:this.field1619;
   }

   @ObfuscatedName("f")
   public synchronized int method2445() {
      return this.field1614 < 0?-1:this.field1614;
   }

   @ObfuscatedName("b")
   public synchronized void method2482(int var1) {
      int var2 = ((RawAudioNode)super.data).audioBuffer.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1613 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2411() {
      this.field1623 = (this.field1623 ^ this.field1623 >> 31) + (this.field1623 >>> 31);
      this.field1623 = -this.field1623;
   }

   @ObfuscatedName("w")
   void method2374() {
      if(this.field1622 != 0) {
         if(this.field1619 == Integer.MIN_VALUE) {
            this.field1619 = 0;
         }

         this.field1622 = 0;
         this.method2394();
      }

   }

   @ObfuscatedName("o")
   public synchronized void method2375(int var1, int var2) {
      this.method2376(var1, var2, this.method2445());
   }

   @ObfuscatedName("a")
   public synchronized void method2376(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2419(var2, var3);
      } else {
         int var4 = method2377(var2, var3);
         int var5 = method2453(var2, var3);
         if(var4 == this.field1616 && var5 == this.field1611) {
            this.field1622 = 0;
         } else {
            int var6 = var2 - this.field1615;
            if(this.field1615 - var2 > var6) {
               var6 = this.field1615 - var2;
            }

            if(var4 - this.field1616 > var6) {
               var6 = var4 - this.field1616;
            }

            if(this.field1616 - var4 > var6) {
               var6 = this.field1616 - var4;
            }

            if(var5 - this.field1611 > var6) {
               var6 = var5 - this.field1611;
            }

            if(this.field1611 - var5 > var6) {
               var6 = this.field1611 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1622 = var1;
            this.field1619 = var2;
            this.field1614 = var3;
            this.field1625 = (var2 - this.field1615) / var1;
            this.field1624 = (var4 - this.field1616) / var1;
            this.field1620 = (var5 - this.field1611) / var1;
         }
      }
   }

   @ObfuscatedName("ak")
   public synchronized void method2421(int var1) {
      if(var1 == 0) {
         this.method2373(0);
         this.unlink();
      } else if(this.field1616 == 0 && this.field1611 == 0) {
         this.field1622 = 0;
         this.field1619 = 0;
         this.field1615 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1615;
         if(this.field1615 > var2) {
            var2 = this.field1615;
         }

         if(-this.field1616 > var2) {
            var2 = -this.field1616;
         }

         if(this.field1616 > var2) {
            var2 = this.field1616;
         }

         if(-this.field1611 > var2) {
            var2 = -this.field1611;
         }

         if(this.field1611 > var2) {
            var2 = this.field1611;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1622 = var1;
         this.field1619 = Integer.MIN_VALUE;
         this.field1625 = -this.field1615 / var1;
         this.field1624 = -this.field1616 / var1;
         this.field1620 = -this.field1611 / var1;
      }
   }

   @ObfuscatedName("ap")
   public synchronized void method2378(int var1) {
      if(this.field1623 < 0) {
         this.field1623 = -var1;
      } else {
         this.field1623 = var1;
      }

   }

   @ObfuscatedName("ac")
   public synchronized int method2490() {
      return this.field1623 < 0?-this.field1623:this.field1623;
   }

   @ObfuscatedName("ao")
   public boolean method2459() {
      return this.field1613 < 0 || this.field1613 >= ((RawAudioNode)super.data).audioBuffer.length << 8;
   }

   @ObfuscatedName("at")
   public boolean method2381() {
      return this.field1622 != 0;
   }

   @ObfuscatedName("ag")
   int method2360(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1622 > 0) {
            int var6 = var2 + this.field1622;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1622 += var2;
            if(this.field1623 == 256 && (this.field1613 & 255) == 0) {
               if(AbstractSoundSystem.audioHighMemory) {
                  var2 = method2399(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1613, var2, this.field1616, this.field1611, this.field1624, this.field1620, 0, var6, var3, this);
               } else {
                  var2 = method2433(((RawAudioNode)super.data).audioBuffer, var1, this.field1613, var2, this.field1615, this.field1625, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.audioHighMemory) {
               var2 = method2498(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1613, var2, this.field1616, this.field1611, this.field1624, this.field1620, 0, var6, var3, this, this.field1623, var5);
            } else {
               var2 = method2402(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1613, var2, this.field1615, this.field1625, 0, var6, var3, this, this.field1623, var5);
            }

            this.field1622 -= var2;
            if(this.field1622 != 0) {
               return var2;
            }

            if(!this.method2389()) {
               continue;
            }

            return var4;
         }

         if(this.field1623 == 256 && (this.field1613 & 255) == 0) {
            if(AbstractSoundSystem.audioHighMemory) {
               return method2391(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1613, var2, this.field1616, this.field1611, 0, var4, var3, this);
            }

            return method2390(((RawAudioNode)super.data).audioBuffer, var1, this.field1613, var2, this.field1615, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.audioHighMemory) {
            return method2395(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1613, var2, this.field1616, this.field1611, 0, var4, var3, this, this.field1623, var5);
         }

         return method2379(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1613, var2, this.field1615, 0, var4, var3, this, this.field1623, var5);
      }
   }

   @ObfuscatedName("am")
   int method2516(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1622 > 0) {
            int var6 = var2 + this.field1622;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1622 += var2;
            if(this.field1623 == -256 && (this.field1613 & 255) == 0) {
               if(AbstractSoundSystem.audioHighMemory) {
                  var2 = method2507(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1613, var2, this.field1616, this.field1611, this.field1624, this.field1620, 0, var6, var3, this);
               } else {
                  var2 = method2400(((RawAudioNode)super.data).audioBuffer, var1, this.field1613, var2, this.field1615, this.field1625, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.audioHighMemory) {
               var2 = method2405(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1613, var2, this.field1616, this.field1611, this.field1624, this.field1620, 0, var6, var3, this, this.field1623, var5);
            } else {
               var2 = method2404(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1613, var2, this.field1615, this.field1625, 0, var6, var3, this, this.field1623, var5);
            }

            this.field1622 -= var2;
            if(this.field1622 != 0) {
               return var2;
            }

            if(!this.method2389()) {
               continue;
            }

            return var4;
         }

         if(this.field1623 == -256 && (this.field1613 & 255) == 0) {
            if(AbstractSoundSystem.audioHighMemory) {
               return method2515(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1613, var2, this.field1616, this.field1611, 0, var4, var3, this);
            }

            return method2392(((RawAudioNode)super.data).audioBuffer, var1, this.field1613, var2, this.field1615, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.audioHighMemory) {
            return method2450(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1613, var2, this.field1616, this.field1611, 0, var4, var3, this, this.field1623, var5);
         }

         return method2396(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1613, var2, this.field1615, 0, var4, var3, this, this.field1623, var5);
      }
   }

   @ObfuscatedName("ay")
   boolean method2389() {
      int var1 = this.field1619;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2377(var1, this.field1614);
         var3 = method2453(var1, this.field1614);
      }

      if(var1 == this.field1615 && var2 == this.field1616 && var3 == this.field1611) {
         if(this.field1619 == Integer.MIN_VALUE) {
            this.field1619 = 0;
            this.field1611 = 0;
            this.field1616 = 0;
            this.field1615 = 0;
            this.unlink();
            return true;
         } else {
            this.method2394();
            return false;
         }
      } else {
         if(this.field1615 < var1) {
            this.field1625 = 1;
            this.field1622 = var1 - this.field1615;
         } else if(this.field1615 > var1) {
            this.field1625 = -1;
            this.field1622 = this.field1615 - var1;
         } else {
            this.field1625 = 0;
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

         if(this.field1611 < var3) {
            this.field1620 = 1;
            if(this.field1622 == 0 || this.field1622 > var3 - this.field1611) {
               this.field1622 = var3 - this.field1611;
            }
         } else if(this.field1611 > var3) {
            this.field1620 = -1;
            if(this.field1622 == 0 || this.field1622 > this.field1611 - var3) {
               this.field1622 = this.field1611 - var3;
            }
         } else {
            this.field1620 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("aj")
   int vmethod2542() {
      int var1 = this.field1615 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1618 == 0) {
         var1 -= var1 * this.field1613 / (((RawAudioNode)super.data).audioBuffer.length << 8);
      } else if(this.field1618 >= 0) {
         var1 -= var1 * this.startPosition / ((RawAudioNode)super.data).audioBuffer.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("d")
   static int method2377(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("z")
   static int method2453(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ldd;II)Ldp;"
   )
   public static class115 method2363(RawAudioNode var0, int var1, int var2) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class115(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(KeyFocusListener.sampleRate * 100)), var2 << 6):null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ldd;III)Ldp;"
   )
   public static class115 method2465(RawAudioNode var0, int var1, int var2, int var3) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class115(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdp;)I"
   )
   static int method2390(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class115 var8) {
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

      var8.field1613 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdp;)I"
   )
   static int method2391(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10) {
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

      var10.field1613 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdp;)I"
   )
   static int method2392(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class115 var8) {
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

      var8.field1613 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdp;)I"
   )
   static int method2515(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10) {
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

      var10.field1613 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdp;II)I"
   )
   static int method2379(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10, int var11, int var12) {
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

      var10.field1613 = var4;
      return var5;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdp;II)I"
   )
   static int method2395(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
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

      var11.field1613 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdp;II)I"
   )
   static int method2396(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10, int var11, int var12) {
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

      var10.field1613 = var4;
      return var5;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdp;II)I"
   )
   static int method2450(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
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

      var11.field1613 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdp;)I"
   )
   static int method2433(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class115 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1616 += var9.field1624 * (var6 - var3);
      var9.field1611 += var9.field1620 * (var6 - var3);

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

      var9.field1615 = var4 >> 2;
      var9.field1613 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdp;)I"
   )
   static int method2399(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class115 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1615 += var12.field1625 * (var9 - var4);
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
      var12.field1611 = var6 >> 2;
      var12.field1613 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdp;)I"
   )
   static int method2400(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class115 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1616 += var9.field1624 * (var6 - var3);
      var9.field1611 += var9.field1620 * (var6 - var3);

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

      var9.field1615 = var4 >> 2;
      var9.field1613 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdp;)I"
   )
   static int method2507(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class115 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1615 += var12.field1625 * (var9 - var4);
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
      var12.field1611 = var6 >> 2;
      var12.field1613 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdp;II)I"
   )
   static int method2402(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
      var11.field1616 -= var11.field1624 * var5;
      var11.field1611 -= var11.field1620 * var5;
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
      var11.field1611 += var11.field1620 * var5;
      var11.field1615 = var6;
      var11.field1613 = var4;
      return var5;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdp;II)I"
   )
   static int method2498(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class115 var13, int var14, int var15) {
      var13.field1615 -= var5 * var13.field1625;
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
      var13.field1615 += var13.field1625 * var5;
      var13.field1616 = var6;
      var13.field1611 = var7;
      var13.field1613 = var4;
      return var5;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdp;II)I"
   )
   static int method2404(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
      var11.field1616 -= var11.field1624 * var5;
      var11.field1611 -= var11.field1620 * var5;
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
      var11.field1611 += var11.field1620 * var5;
      var11.field1615 = var6;
      var11.field1613 = var4;
      return var5;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdp;II)I"
   )
   static int method2405(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class115 var13, int var14, int var15) {
      var13.field1615 -= var5 * var13.field1625;
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
      var13.field1615 += var13.field1625 * var5;
      var13.field1616 = var6;
      var13.field1611 = var7;
      var13.field1613 = var4;
      return var5;
   }
}
