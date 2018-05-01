import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public class class115 extends TaskDataNode {
   @ObfuscatedName("g")
   int field1605;
   @ObfuscatedName("e")
   int field1595;
   @ObfuscatedName("b")
   int field1596;
   @ObfuscatedName("z")
   int field1597;
   @ObfuscatedName("n")
   int field1608;
   @ObfuscatedName("l")
   int field1599;
   @ObfuscatedName("s")
   int field1594;
   @ObfuscatedName("y")
   int field1600;
   @ObfuscatedName("c")
   @Export("startPosition")
   int startPosition;
   @ObfuscatedName("h")
   @Export("endPosition")
   int endPosition;
   @ObfuscatedName("i")
   boolean field1604;
   @ObfuscatedName("o")
   int field1601;
   @ObfuscatedName("d")
   int field1606;
   @ObfuscatedName("r")
   int field1607;
   @ObfuscatedName("p")
   int field1598;

   @ObfuscatedSignature(
      signature = "(Ldt;III)V"
   )
   class115(RawAudioNode var1, int var2, int var3, int var4) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1604 = var1.field1522;
      this.field1595 = var2;
      this.field1596 = var3;
      this.field1597 = var4;
      this.field1605 = 0;
      this.method2400();
   }

   @ObfuscatedSignature(
      signature = "(Ldt;II)V"
   )
   class115(RawAudioNode var1, int var2, int var3) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1604 = var1.field1522;
      this.field1595 = var2;
      this.field1596 = var3;
      this.field1597 = 8192;
      this.field1605 = 0;
      this.method2400();
   }

   @ObfuscatedName("n")
   void method2400() {
      this.field1608 = this.field1596;
      this.field1599 = method2429(this.field1596, this.field1597);
      this.field1594 = method2447(this.field1596, this.field1597);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "()Ldh;"
   )
   protected TaskDataNode vmethod4437() {
      return null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldh;"
   )
   protected TaskDataNode vmethod4424() {
      return null;
   }

   @ObfuscatedName("y")
   protected int vmethod4425() {
      return this.field1596 == 0 && this.field1601 == 0?0:1;
   }

   @ObfuscatedName("c")
   public synchronized void vmethod4441(int[] var1, int var2, int var3) {
      if(this.field1596 == 0 && this.field1601 == 0) {
         this.vmethod4426(var3);
      } else {
         RawAudioNode var4 = (RawAudioNode)super.data;
         int var5 = this.startPosition << 8;
         int var6 = this.endPosition << 8;
         int var7 = var4.audioBuffer.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1600 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1605 < 0) {
            if(this.field1595 <= 0) {
               this.method2409();
               this.unlink();
               return;
            }

            this.field1605 = 0;
         }

         if(this.field1605 >= var7) {
            if(this.field1595 >= 0) {
               this.method2409();
               this.unlink();
               return;
            }

            this.field1605 = var7 - 1;
         }

         if(this.field1600 < 0) {
            if(this.field1604) {
               if(this.field1595 < 0) {
                  var9 = this.method2549(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1605 >= var5) {
                     return;
                  }

                  this.field1605 = var5 + var5 - 1 - this.field1605;
                  this.field1595 = -this.field1595;
               }

               while(true) {
                  var9 = this.method2422(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1605 < var6) {
                     return;
                  }

                  this.field1605 = var6 + var6 - 1 - this.field1605;
                  this.field1595 = -this.field1595;
                  var9 = this.method2549(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1605 >= var5) {
                     return;
                  }

                  this.field1605 = var5 + var5 - 1 - this.field1605;
                  this.field1595 = -this.field1595;
               }
            } else if(this.field1595 < 0) {
               while(true) {
                  var9 = this.method2549(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1605 >= var5) {
                     return;
                  }

                  this.field1605 = var6 - 1 - (var6 - 1 - this.field1605) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2422(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1605 < var6) {
                     return;
                  }

                  this.field1605 = var5 + (this.field1605 - var5) % var8;
               }
            }
         } else {
            if(this.field1600 > 0) {
               if(this.field1604) {
                  label120: {
                     if(this.field1595 < 0) {
                        var9 = this.method2549(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1605 >= var5) {
                           return;
                        }

                        this.field1605 = var5 + var5 - 1 - this.field1605;
                        this.field1595 = -this.field1595;
                        if(--this.field1600 == 0) {
                           break label120;
                        }
                     }

                     do {
                        var9 = this.method2422(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1605 < var6) {
                           return;
                        }

                        this.field1605 = var6 + var6 - 1 - this.field1605;
                        this.field1595 = -this.field1595;
                        if(--this.field1600 == 0) {
                           break;
                        }

                        var9 = this.method2549(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1605 >= var5) {
                           return;
                        }

                        this.field1605 = var5 + var5 - 1 - this.field1605;
                        this.field1595 = -this.field1595;
                     } while(--this.field1600 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1595 < 0) {
                     while(true) {
                        var9 = this.method2549(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1605 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1605) / var8;
                        if(var10 >= this.field1600) {
                           this.field1605 += var8 * this.field1600;
                           this.field1600 = 0;
                           break;
                        }

                        this.field1605 += var8 * var10;
                        this.field1600 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2422(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1605 < var6) {
                           return;
                        }

                        var10 = (this.field1605 - var5) / var8;
                        if(var10 >= this.field1600) {
                           this.field1605 -= var8 * this.field1600;
                           this.field1600 = 0;
                           break;
                        }

                        this.field1605 -= var8 * var10;
                        this.field1600 -= var10;
                     }
                  }
               }
            }

            if(this.field1595 < 0) {
               this.method2549(var1, var9, 0, var3, 0);
               if(this.field1605 < 0) {
                  this.field1605 = -1;
                  this.method2409();
                  this.unlink();
               }
            } else {
               this.method2422(var1, var9, var7, var3, 0);
               if(this.field1605 >= var7) {
                  this.field1605 = var7;
                  this.method2409();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("o")
   public synchronized void method2401(int var1) {
      this.field1600 = var1;
   }

   @ObfuscatedName("d")
   public synchronized void vmethod4426(int var1) {
      if(this.field1601 > 0) {
         if(var1 >= this.field1601) {
            if(this.field1596 == Integer.MIN_VALUE) {
               this.field1596 = 0;
               this.field1594 = 0;
               this.field1599 = 0;
               this.field1608 = 0;
               this.unlink();
               var1 = this.field1601;
            }

            this.field1601 = 0;
            this.method2400();
         } else {
            this.field1608 += this.field1606 * var1;
            this.field1599 += this.field1607 * var1;
            this.field1594 += this.field1598 * var1;
            this.field1601 -= var1;
         }
      }

      RawAudioNode var2 = (RawAudioNode)super.data;
      int var3 = this.startPosition << 8;
      int var4 = this.endPosition << 8;
      int var5 = var2.audioBuffer.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1600 = 0;
      }

      if(this.field1605 < 0) {
         if(this.field1595 <= 0) {
            this.method2409();
            this.unlink();
            return;
         }

         this.field1605 = 0;
      }

      if(this.field1605 >= var5) {
         if(this.field1595 >= 0) {
            this.method2409();
            this.unlink();
            return;
         }

         this.field1605 = var5 - 1;
      }

      this.field1605 += this.field1595 * var1;
      if(this.field1600 < 0) {
         if(!this.field1604) {
            if(this.field1595 < 0) {
               if(this.field1605 >= var3) {
                  return;
               }

               this.field1605 = var4 - 1 - (var4 - 1 - this.field1605) % var6;
            } else {
               if(this.field1605 < var4) {
                  return;
               }

               this.field1605 = var3 + (this.field1605 - var3) % var6;
            }

         } else {
            if(this.field1595 < 0) {
               if(this.field1605 >= var3) {
                  return;
               }

               this.field1605 = var3 + var3 - 1 - this.field1605;
               this.field1595 = -this.field1595;
            }

            while(this.field1605 >= var4) {
               this.field1605 = var4 + var4 - 1 - this.field1605;
               this.field1595 = -this.field1595;
               if(this.field1605 >= var3) {
                  return;
               }

               this.field1605 = var3 + var3 - 1 - this.field1605;
               this.field1595 = -this.field1595;
            }

         }
      } else {
         if(this.field1600 > 0) {
            if(this.field1604) {
               label124: {
                  if(this.field1595 < 0) {
                     if(this.field1605 >= var3) {
                        return;
                     }

                     this.field1605 = var3 + var3 - 1 - this.field1605;
                     this.field1595 = -this.field1595;
                     if(--this.field1600 == 0) {
                        break label124;
                     }
                  }

                  do {
                     if(this.field1605 < var4) {
                        return;
                     }

                     this.field1605 = var4 + var4 - 1 - this.field1605;
                     this.field1595 = -this.field1595;
                     if(--this.field1600 == 0) {
                        break;
                     }

                     if(this.field1605 >= var3) {
                        return;
                     }

                     this.field1605 = var3 + var3 - 1 - this.field1605;
                     this.field1595 = -this.field1595;
                  } while(--this.field1600 != 0);
               }
            } else {
               label156: {
                  int var7;
                  if(this.field1595 < 0) {
                     if(this.field1605 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1605) / var6;
                     if(var7 >= this.field1600) {
                        this.field1605 += var6 * this.field1600;
                        this.field1600 = 0;
                        break label156;
                     }

                     this.field1605 += var6 * var7;
                     this.field1600 -= var7;
                  } else {
                     if(this.field1605 < var4) {
                        return;
                     }

                     var7 = (this.field1605 - var3) / var6;
                     if(var7 >= this.field1600) {
                        this.field1605 -= var6 * this.field1600;
                        this.field1600 = 0;
                        break label156;
                     }

                     this.field1605 -= var6 * var7;
                     this.field1600 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1595 < 0) {
            if(this.field1605 < 0) {
               this.field1605 = -1;
               this.method2409();
               this.unlink();
            }
         } else if(this.field1605 >= var5) {
            this.field1605 = var5;
            this.method2409();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("r")
   public synchronized void method2532(int var1) {
      this.method2500(var1 << 6, this.method2406());
   }

   @ObfuscatedName("p")
   synchronized void method2426(int var1) {
      this.method2500(var1, this.method2406());
   }

   @ObfuscatedName("q")
   synchronized void method2500(int var1, int var2) {
      this.field1596 = var1;
      this.field1597 = var2;
      this.field1601 = 0;
      this.method2400();
   }

   @ObfuscatedName("f")
   public synchronized int method2405() {
      return this.field1596 == Integer.MIN_VALUE?0:this.field1596;
   }

   @ObfuscatedName("j")
   public synchronized int method2406() {
      return this.field1597 < 0?-1:this.field1597;
   }

   @ObfuscatedName("v")
   public synchronized void method2407(int var1) {
      int var2 = ((RawAudioNode)super.data).audioBuffer.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1605 = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2502() {
      this.field1595 = (this.field1595 ^ this.field1595 >> 31) + (this.field1595 >>> 31);
      this.field1595 = -this.field1595;
   }

   @ObfuscatedName("k")
   void method2409() {
      if(this.field1601 != 0) {
         if(this.field1596 == Integer.MIN_VALUE) {
            this.field1596 = 0;
         }

         this.field1601 = 0;
         this.method2400();
      }

   }

   @ObfuscatedName("w")
   public synchronized void method2410(int var1, int var2) {
      this.method2536(var1, var2, this.method2406());
   }

   @ObfuscatedName("x")
   public synchronized void method2536(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2500(var2, var3);
      } else {
         int var4 = method2429(var2, var3);
         int var5 = method2447(var2, var3);
         if(var4 == this.field1599 && var5 == this.field1594) {
            this.field1601 = 0;
         } else {
            int var6 = var2 - this.field1608;
            if(this.field1608 - var2 > var6) {
               var6 = this.field1608 - var2;
            }

            if(var4 - this.field1599 > var6) {
               var6 = var4 - this.field1599;
            }

            if(this.field1599 - var4 > var6) {
               var6 = this.field1599 - var4;
            }

            if(var5 - this.field1594 > var6) {
               var6 = var5 - this.field1594;
            }

            if(this.field1594 - var5 > var6) {
               var6 = this.field1594 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1601 = var1;
            this.field1596 = var2;
            this.field1597 = var3;
            this.field1606 = (var2 - this.field1608) / var1;
            this.field1607 = (var4 - this.field1599) / var1;
            this.field1598 = (var5 - this.field1594) / var1;
         }
      }
   }

   @ObfuscatedName("t")
   public synchronized void method2412(int var1) {
      if(var1 == 0) {
         this.method2426(0);
         this.unlink();
      } else if(this.field1599 == 0 && this.field1594 == 0) {
         this.field1601 = 0;
         this.field1596 = 0;
         this.field1608 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1608;
         if(this.field1608 > var2) {
            var2 = this.field1608;
         }

         if(-this.field1599 > var2) {
            var2 = -this.field1599;
         }

         if(this.field1599 > var2) {
            var2 = this.field1599;
         }

         if(-this.field1594 > var2) {
            var2 = -this.field1594;
         }

         if(this.field1594 > var2) {
            var2 = this.field1594;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1601 = var1;
         this.field1596 = Integer.MIN_VALUE;
         this.field1606 = -this.field1608 / var1;
         this.field1607 = -this.field1599 / var1;
         this.field1598 = -this.field1594 / var1;
      }
   }

   @ObfuscatedName("ax")
   public synchronized void method2413(int var1) {
      if(this.field1595 < 0) {
         this.field1595 = -var1;
      } else {
         this.field1595 = var1;
      }

   }

   @ObfuscatedName("ai")
   public synchronized int method2414() {
      return this.field1595 < 0?-this.field1595:this.field1595;
   }

   @ObfuscatedName("ah")
   public boolean method2415() {
      return this.field1605 < 0 || this.field1605 >= ((RawAudioNode)super.data).audioBuffer.length << 8;
   }

   @ObfuscatedName("au")
   public boolean method2423() {
      return this.field1601 != 0;
   }

   @ObfuscatedName("ap")
   int method2422(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1601 > 0) {
            int var6 = var2 + this.field1601;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1601 += var2;
            if(this.field1595 == 256 && (this.field1605 & 255) == 0) {
               if(AbstractSoundSystem.audioHighMemory) {
                  var2 = method2434(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1599, this.field1594, this.field1607, this.field1598, 0, var6, var3, this);
               } else {
                  var2 = method2546(((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1608, this.field1606, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.audioHighMemory) {
               var2 = method2435(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1599, this.field1594, this.field1607, this.field1598, 0, var6, var3, this, this.field1595, var5);
            } else {
               var2 = method2437(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1608, this.field1606, 0, var6, var3, this, this.field1595, var5);
            }

            this.field1601 -= var2;
            if(this.field1601 != 0) {
               return var2;
            }

            if(!this.method2424()) {
               continue;
            }

            return var4;
         }

         if(this.field1595 == 256 && (this.field1605 & 255) == 0) {
            if(AbstractSoundSystem.audioHighMemory) {
               return method2477(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1599, this.field1594, 0, var4, var3, this);
            }

            return method2425(((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1608, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.audioHighMemory) {
            return method2449(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1599, this.field1594, 0, var4, var3, this, this.field1595, var5);
         }

         return method2445(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1608, 0, var4, var3, this, this.field1595, var5);
      }
   }

   @ObfuscatedName("at")
   int method2549(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1601 > 0) {
            int var6 = var2 + this.field1601;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1601 += var2;
            if(this.field1595 == -256 && (this.field1605 & 255) == 0) {
               if(AbstractSoundSystem.audioHighMemory) {
                  var2 = method2436(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1599, this.field1594, this.field1607, this.field1598, 0, var6, var3, this);
               } else {
                  var2 = method2510(((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1608, this.field1606, 0, var6, var3, this);
               }
            } else if(AbstractSoundSystem.audioHighMemory) {
               var2 = method2537(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1599, this.field1594, this.field1607, this.field1598, 0, var6, var3, this, this.field1595, var5);
            } else {
               var2 = method2492(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1608, this.field1606, 0, var6, var3, this, this.field1595, var5);
            }

            this.field1601 -= var2;
            if(this.field1601 != 0) {
               return var2;
            }

            if(!this.method2424()) {
               continue;
            }

            return var4;
         }

         if(this.field1595 == -256 && (this.field1605 & 255) == 0) {
            if(AbstractSoundSystem.audioHighMemory) {
               return method2428(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1599, this.field1594, 0, var4, var3, this);
            }

            return method2438(((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1608, 0, var4, var3, this);
         }

         if(AbstractSoundSystem.audioHighMemory) {
            return method2511(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1599, this.field1594, 0, var4, var3, this, this.field1595, var5);
         }

         return method2431(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1605, var2, this.field1608, 0, var4, var3, this, this.field1595, var5);
      }
   }

   @ObfuscatedName("am")
   boolean method2424() {
      int var1 = this.field1596;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2429(var1, this.field1597);
         var3 = method2447(var1, this.field1597);
      }

      if(var1 == this.field1608 && var2 == this.field1599 && var3 == this.field1594) {
         if(this.field1596 == Integer.MIN_VALUE) {
            this.field1596 = 0;
            this.field1594 = 0;
            this.field1599 = 0;
            this.field1608 = 0;
            this.unlink();
            return true;
         } else {
            this.method2400();
            return false;
         }
      } else {
         if(this.field1608 < var1) {
            this.field1606 = 1;
            this.field1601 = var1 - this.field1608;
         } else if(this.field1608 > var1) {
            this.field1606 = -1;
            this.field1601 = this.field1608 - var1;
         } else {
            this.field1606 = 0;
         }

         if(this.field1599 < var2) {
            this.field1607 = 1;
            if(this.field1601 == 0 || this.field1601 > var2 - this.field1599) {
               this.field1601 = var2 - this.field1599;
            }
         } else if(this.field1599 > var2) {
            this.field1607 = -1;
            if(this.field1601 == 0 || this.field1601 > this.field1599 - var2) {
               this.field1601 = this.field1599 - var2;
            }
         } else {
            this.field1607 = 0;
         }

         if(this.field1594 < var3) {
            this.field1598 = 1;
            if(this.field1601 == 0 || this.field1601 > var3 - this.field1594) {
               this.field1601 = var3 - this.field1594;
            }
         } else if(this.field1594 > var3) {
            this.field1598 = -1;
            if(this.field1601 == 0 || this.field1601 > this.field1594 - var3) {
               this.field1601 = this.field1594 - var3;
            }
         } else {
            this.field1598 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("bo")
   int vmethod2570() {
      int var1 = this.field1608 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1600 == 0) {
         var1 -= var1 * this.field1605 / (((RawAudioNode)super.data).audioBuffer.length << 8);
      } else if(this.field1600 >= 0) {
         var1 -= var1 * this.startPosition / ((RawAudioNode)super.data).audioBuffer.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("g")
   static int method2429(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("e")
   static int method2447(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ldt;II)Ldn;"
   )
   public static class115 method2398(RawAudioNode var0, int var1, int var2) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class115(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(AbstractSoundSystem.sampleRate * 100)), var2 << 6):null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ldt;III)Ldn;"
   )
   public static class115 method2476(RawAudioNode var0, int var1, int var2, int var3) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class115(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdn;)I"
   )
   static int method2425(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class115 var8) {
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

      var8.field1605 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdn;)I"
   )
   static int method2477(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10) {
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

      var10.field1605 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdn;)I"
   )
   static int method2438(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class115 var8) {
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

      var8.field1605 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdn;)I"
   )
   static int method2428(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10) {
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

      var10.field1605 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdn;II)I"
   )
   static int method2445(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10, int var11, int var12) {
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

      var10.field1605 = var4;
      return var5;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdn;II)I"
   )
   static int method2449(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
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

      var11.field1605 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdn;II)I"
   )
   static int method2431(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class115 var10, int var11, int var12) {
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

      var10.field1605 = var4;
      return var5;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdn;II)I"
   )
   static int method2511(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
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

      var11.field1605 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdn;)I"
   )
   static int method2546(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class115 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1599 += var9.field1607 * (var6 - var3);
      var9.field1594 += var9.field1598 * (var6 - var3);

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

      var9.field1608 = var4 >> 2;
      var9.field1605 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdn;)I"
   )
   static int method2434(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class115 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1608 += var12.field1606 * (var9 - var4);
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

      var12.field1599 = var5 >> 2;
      var12.field1594 = var6 >> 2;
      var12.field1605 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdn;)I"
   )
   static int method2510(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class115 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1599 += var9.field1607 * (var6 - var3);
      var9.field1594 += var9.field1598 * (var6 - var3);

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

      var9.field1608 = var4 >> 2;
      var9.field1605 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdn;)I"
   )
   static int method2436(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class115 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1608 += var12.field1606 * (var9 - var4);
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

      var12.field1599 = var5 >> 2;
      var12.field1594 = var6 >> 2;
      var12.field1605 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdn;II)I"
   )
   static int method2437(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
      var11.field1599 -= var11.field1607 * var5;
      var11.field1594 -= var11.field1598 * var5;
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

      var11.field1599 += var11.field1607 * var5;
      var11.field1594 += var11.field1598 * var5;
      var11.field1608 = var6;
      var11.field1605 = var4;
      return var5;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdn;II)I"
   )
   static int method2435(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class115 var13, int var14, int var15) {
      var13.field1608 -= var5 * var13.field1606;
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
      var13.field1608 += var13.field1606 * var5;
      var13.field1599 = var6;
      var13.field1594 = var7;
      var13.field1605 = var4;
      return var5;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdn;II)I"
   )
   static int method2492(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class115 var11, int var12, int var13) {
      var11.field1599 -= var11.field1607 * var5;
      var11.field1594 -= var11.field1598 * var5;
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

      var11.field1599 += var11.field1607 * var5;
      var11.field1594 += var11.field1598 * var5;
      var11.field1608 = var6;
      var11.field1605 = var4;
      return var5;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdn;II)I"
   )
   static int method2537(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class115 var13, int var14, int var15) {
      var13.field1608 -= var5 * var13.field1606;
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
      var13.field1608 += var13.field1606 * var5;
      var13.field1599 = var6;
      var13.field1594 = var7;
      var13.field1605 = var4;
      return var5;
   }
}
