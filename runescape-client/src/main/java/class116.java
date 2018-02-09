import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public class class116 extends TaskDataNode {
   @ObfuscatedName("s")
   int field1609;
   @ObfuscatedName("g")
   int field1606;
   @ObfuscatedName("m")
   int field1600;
   @ObfuscatedName("h")
   int field1602;
   @ObfuscatedName("i")
   int field1599;
   @ObfuscatedName("t")
   int field1603;
   @ObfuscatedName("d")
   int field1604;
   @ObfuscatedName("z")
   int field1601;
   @ObfuscatedName("k")
   @Export("startPosition")
   int startPosition;
   @ObfuscatedName("c")
   @Export("endPosition")
   int endPosition;
   @ObfuscatedName("o")
   boolean field1608;
   @ObfuscatedName("l")
   int field1610;
   @ObfuscatedName("f")
   int field1605;
   @ObfuscatedName("q")
   int field1611;
   @ObfuscatedName("r")
   int field1612;

   @ObfuscatedSignature(
      signature = "(Ldz;III)V"
   )
   class116(RawAudioNode var1, int var2, int var3, int var4) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1608 = var1.field1528;
      this.field1606 = var2;
      this.field1600 = var3;
      this.field1602 = var4;
      this.field1609 = 0;
      this.method2386();
   }

   @ObfuscatedSignature(
      signature = "(Ldz;II)V"
   )
   class116(RawAudioNode var1, int var2, int var3) {
      super.data = var1;
      this.startPosition = var1.startPosition;
      this.endPosition = var1.endPosition;
      this.field1608 = var1.field1528;
      this.field1606 = var2;
      this.field1600 = var3;
      this.field1602 = 8192;
      this.field1609 = 0;
      this.method2386();
   }

   @ObfuscatedName("i")
   void method2386() {
      this.field1599 = this.field1600;
      this.field1603 = method2401(this.field1600, this.field1602);
      this.field1604 = method2382(this.field1600, this.field1602);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "()Ldb;"
   )
   protected TaskDataNode vmethod4311() {
      return null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "()Ldb;"
   )
   protected TaskDataNode vmethod4312() {
      return null;
   }

   @ObfuscatedName("d")
   protected int vmethod4313() {
      return this.field1600 == 0 && this.field1610 == 0?0:1;
   }

   @ObfuscatedName("z")
   public synchronized void vmethod4314(int[] var1, int var2, int var3) {
      if(this.field1600 == 0 && this.field1610 == 0) {
         this.vmethod4315(var3);
      } else {
         RawAudioNode var4 = (RawAudioNode)super.data;
         int var5 = this.startPosition << 8;
         int var6 = this.endPosition << 8;
         int var7 = var4.audioBuffer.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1601 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1609 < 0) {
            if(this.field1606 <= 0) {
               this.method2540();
               this.unlink();
               return;
            }

            this.field1609 = 0;
         }

         if(this.field1609 >= var7) {
            if(this.field1606 >= 0) {
               this.method2540();
               this.unlink();
               return;
            }

            this.field1609 = var7 - 1;
         }

         if(this.field1601 < 0) {
            if(this.field1608) {
               if(this.field1606 < 0) {
                  var9 = this.method2409(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1609 >= var5) {
                     return;
                  }

                  this.field1609 = var5 + var5 - 1 - this.field1609;
                  this.field1606 = -this.field1606;
               }

               while(true) {
                  var9 = this.method2408(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1609 < var6) {
                     return;
                  }

                  this.field1609 = var6 + var6 - 1 - this.field1609;
                  this.field1606 = -this.field1606;
                  var9 = this.method2409(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1609 >= var5) {
                     return;
                  }

                  this.field1609 = var5 + var5 - 1 - this.field1609;
                  this.field1606 = -this.field1606;
               }
            } else if(this.field1606 < 0) {
               while(true) {
                  var9 = this.method2409(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                  if(this.field1609 >= var5) {
                     return;
                  }

                  this.field1609 = var6 - 1 - (var6 - 1 - this.field1609) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2408(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                  if(this.field1609 < var6) {
                     return;
                  }

                  this.field1609 = var5 + (this.field1609 - var5) % var8;
               }
            }
         } else {
            if(this.field1601 > 0) {
               if(this.field1608) {
                  label134: {
                     if(this.field1606 < 0) {
                        var9 = this.method2409(var1, var2, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1609 >= var5) {
                           return;
                        }

                        this.field1609 = var5 + var5 - 1 - this.field1609;
                        this.field1606 = -this.field1606;
                        if(--this.field1601 == 0) {
                           break label134;
                        }
                     }

                     do {
                        var9 = this.method2408(var1, var9, var6, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1609 < var6) {
                           return;
                        }

                        this.field1609 = var6 + var6 - 1 - this.field1609;
                        this.field1606 = -this.field1606;
                        if(--this.field1601 == 0) {
                           break;
                        }

                        var9 = this.method2409(var1, var9, var5, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1609 >= var5) {
                           return;
                        }

                        this.field1609 = var5 + var5 - 1 - this.field1609;
                        this.field1606 = -this.field1606;
                     } while(--this.field1601 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1606 < 0) {
                     while(true) {
                        var9 = this.method2409(var1, var9, var5, var3, var4.audioBuffer[this.endPosition - 1]);
                        if(this.field1609 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1609) / var8;
                        if(var10 >= this.field1601) {
                           this.field1609 += var8 * this.field1601;
                           this.field1601 = 0;
                           break;
                        }

                        this.field1609 += var8 * var10;
                        this.field1601 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2408(var1, var9, var6, var3, var4.audioBuffer[this.startPosition]);
                        if(this.field1609 < var6) {
                           return;
                        }

                        var10 = (this.field1609 - var5) / var8;
                        if(var10 >= this.field1601) {
                           this.field1609 -= var8 * this.field1601;
                           this.field1601 = 0;
                           break;
                        }

                        this.field1609 -= var8 * var10;
                        this.field1601 -= var10;
                     }
                  }
               }
            }

            if(this.field1606 < 0) {
               this.method2409(var1, var9, 0, var3, 0);
               if(this.field1609 < 0) {
                  this.field1609 = -1;
                  this.method2540();
                  this.unlink();
               }
            } else {
               this.method2408(var1, var9, var7, var3, 0);
               if(this.field1609 >= var7) {
                  this.field1609 = var7;
                  this.method2540();
                  this.unlink();
               }
            }

         }
      }
   }

   @ObfuscatedName("k")
   public synchronized void method2387(int var1) {
      this.field1601 = var1;
   }

   @ObfuscatedName("c")
   public synchronized void vmethod4315(int var1) {
      if(this.field1610 > 0) {
         if(var1 >= this.field1610) {
            if(this.field1600 == Integer.MIN_VALUE) {
               this.field1600 = 0;
               this.field1604 = 0;
               this.field1603 = 0;
               this.field1599 = 0;
               this.unlink();
               var1 = this.field1610;
            }

            this.field1610 = 0;
            this.method2386();
         } else {
            this.field1599 += this.field1605 * var1;
            this.field1603 += this.field1611 * var1;
            this.field1604 += this.field1612 * var1;
            this.field1610 -= var1;
         }
      }

      RawAudioNode var2 = (RawAudioNode)super.data;
      int var3 = this.startPosition << 8;
      int var4 = this.endPosition << 8;
      int var5 = var2.audioBuffer.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1601 = 0;
      }

      if(this.field1609 < 0) {
         if(this.field1606 <= 0) {
            this.method2540();
            this.unlink();
            return;
         }

         this.field1609 = 0;
      }

      if(this.field1609 >= var5) {
         if(this.field1606 >= 0) {
            this.method2540();
            this.unlink();
            return;
         }

         this.field1609 = var5 - 1;
      }

      this.field1609 += this.field1606 * var1;
      if(this.field1601 < 0) {
         if(!this.field1608) {
            if(this.field1606 < 0) {
               if(this.field1609 >= var3) {
                  return;
               }

               this.field1609 = var4 - 1 - (var4 - 1 - this.field1609) % var6;
            } else {
               if(this.field1609 < var4) {
                  return;
               }

               this.field1609 = var3 + (this.field1609 - var3) % var6;
            }

         } else {
            if(this.field1606 < 0) {
               if(this.field1609 >= var3) {
                  return;
               }

               this.field1609 = var3 + var3 - 1 - this.field1609;
               this.field1606 = -this.field1606;
            }

            while(this.field1609 >= var4) {
               this.field1609 = var4 + var4 - 1 - this.field1609;
               this.field1606 = -this.field1606;
               if(this.field1609 >= var3) {
                  return;
               }

               this.field1609 = var3 + var3 - 1 - this.field1609;
               this.field1606 = -this.field1606;
            }

         }
      } else {
         if(this.field1601 > 0) {
            if(this.field1608) {
               label127: {
                  if(this.field1606 < 0) {
                     if(this.field1609 >= var3) {
                        return;
                     }

                     this.field1609 = var3 + var3 - 1 - this.field1609;
                     this.field1606 = -this.field1606;
                     if(--this.field1601 == 0) {
                        break label127;
                     }
                  }

                  do {
                     if(this.field1609 < var4) {
                        return;
                     }

                     this.field1609 = var4 + var4 - 1 - this.field1609;
                     this.field1606 = -this.field1606;
                     if(--this.field1601 == 0) {
                        break;
                     }

                     if(this.field1609 >= var3) {
                        return;
                     }

                     this.field1609 = var3 + var3 - 1 - this.field1609;
                     this.field1606 = -this.field1606;
                  } while(--this.field1601 != 0);
               }
            } else {
               int var7;
               if(this.field1606 < 0) {
                  if(this.field1609 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field1609) / var6;
                  if(var7 < this.field1601) {
                     this.field1609 += var6 * var7;
                     this.field1601 -= var7;
                     return;
                  }

                  this.field1609 += var6 * this.field1601;
                  this.field1601 = 0;
               } else {
                  if(this.field1609 < var4) {
                     return;
                  }

                  var7 = (this.field1609 - var3) / var6;
                  if(var7 < this.field1601) {
                     this.field1609 -= var6 * var7;
                     this.field1601 -= var7;
                     return;
                  }

                  this.field1609 -= var6 * this.field1601;
                  this.field1601 = 0;
               }
            }
         }

         if(this.field1606 < 0) {
            if(this.field1609 < 0) {
               this.field1609 = -1;
               this.method2540();
               this.unlink();
            }
         } else if(this.field1609 >= var5) {
            this.field1609 = var5;
            this.method2540();
            this.unlink();
         }

      }
   }

   @ObfuscatedName("o")
   public synchronized void method2388(int var1) {
      this.method2390(var1 << 6, this.method2399());
   }

   @ObfuscatedName("l")
   synchronized void method2389(int var1) {
      this.method2390(var1, this.method2399());
   }

   @ObfuscatedName("f")
   synchronized void method2390(int var1, int var2) {
      this.field1600 = var1;
      this.field1602 = var2;
      this.field1610 = 0;
      this.method2386();
   }

   @ObfuscatedName("q")
   public synchronized int method2391() {
      return this.field1600 == Integer.MIN_VALUE?0:this.field1600;
   }

   @ObfuscatedName("r")
   public synchronized int method2399() {
      return this.field1602 < 0?-1:this.field1602;
   }

   @ObfuscatedName("x")
   public synchronized void method2393(int var1) {
      int var2 = ((RawAudioNode)super.data).audioBuffer.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1609 = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method2520() {
      this.field1606 = (this.field1606 ^ this.field1606 >> 31) + (this.field1606 >>> 31);
      this.field1606 = -this.field1606;
   }

   @ObfuscatedName("a")
   void method2540() {
      if(this.field1610 != 0) {
         if(this.field1600 == Integer.MIN_VALUE) {
            this.field1600 = 0;
         }

         this.field1610 = 0;
         this.method2386();
      }

   }

   @ObfuscatedName("ad")
   public synchronized void method2396(int var1, int var2) {
      this.method2444(var1, var2, this.method2399());
   }

   @ObfuscatedName("al")
   public synchronized void method2444(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2390(var2, var3);
      } else {
         int var4 = method2401(var2, var3);
         int var5 = method2382(var2, var3);
         if(var4 == this.field1603 && var5 == this.field1604) {
            this.field1610 = 0;
         } else {
            int var6 = var2 - this.field1599;
            if(this.field1599 - var2 > var6) {
               var6 = this.field1599 - var2;
            }

            if(var4 - this.field1603 > var6) {
               var6 = var4 - this.field1603;
            }

            if(this.field1603 - var4 > var6) {
               var6 = this.field1603 - var4;
            }

            if(var5 - this.field1604 > var6) {
               var6 = var5 - this.field1604;
            }

            if(this.field1604 - var5 > var6) {
               var6 = this.field1604 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1610 = var1;
            this.field1600 = var2;
            this.field1602 = var3;
            this.field1605 = (var2 - this.field1599) / var1;
            this.field1611 = (var4 - this.field1603) / var1;
            this.field1612 = (var5 - this.field1604) / var1;
         }
      }
   }

   @ObfuscatedName("aq")
   public synchronized void method2493(int var1) {
      if(var1 == 0) {
         this.method2389(0);
         this.unlink();
      } else if(this.field1603 == 0 && this.field1604 == 0) {
         this.field1610 = 0;
         this.field1600 = 0;
         this.field1599 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1599;
         if(this.field1599 > var2) {
            var2 = this.field1599;
         }

         if(-this.field1603 > var2) {
            var2 = -this.field1603;
         }

         if(this.field1603 > var2) {
            var2 = this.field1603;
         }

         if(-this.field1604 > var2) {
            var2 = -this.field1604;
         }

         if(this.field1604 > var2) {
            var2 = this.field1604;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1610 = var1;
         this.field1600 = Integer.MIN_VALUE;
         this.field1605 = -this.field1599 / var1;
         this.field1611 = -this.field1603 / var1;
         this.field1612 = -this.field1604 / var1;
      }
   }

   @ObfuscatedName("ar")
   public synchronized void method2523(int var1) {
      if(this.field1606 < 0) {
         this.field1606 = -var1;
      } else {
         this.field1606 = var1;
      }

   }

   @ObfuscatedName("an")
   public synchronized int method2400() {
      return this.field1606 < 0?-this.field1606:this.field1606;
   }

   @ObfuscatedName("af")
   public boolean method2402() {
      return this.field1609 < 0 || this.field1609 >= ((RawAudioNode)super.data).audioBuffer.length << 8;
   }

   @ObfuscatedName("as")
   public boolean method2539() {
      return this.field1610 != 0;
   }

   @ObfuscatedName("ax")
   int method2408(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1610 > 0) {
            int var6 = var2 + this.field1610;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1610 += var2;
            if(this.field1606 == 256 && (this.field1609 & 255) == 0) {
               if(CombatInfo1.audioHighMemory) {
                  var2 = method2420(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1609, var2, this.field1603, this.field1604, this.field1611, this.field1612, 0, var6, var3, this);
               } else {
                  var2 = method2419(((RawAudioNode)super.data).audioBuffer, var1, this.field1609, var2, this.field1599, this.field1605, 0, var6, var3, this);
               }
            } else if(CombatInfo1.audioHighMemory) {
               var2 = method2424(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1609, var2, this.field1603, this.field1604, this.field1611, this.field1612, 0, var6, var3, this, this.field1606, var5);
            } else {
               var2 = method2449(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1609, var2, this.field1599, this.field1605, 0, var6, var3, this, this.field1606, var5);
            }

            this.field1610 -= var2;
            if(this.field1610 != 0) {
               return var2;
            }

            if(!this.method2479()) {
               continue;
            }

            return var4;
         }

         if(this.field1606 == 256 && (this.field1609 & 255) == 0) {
            if(CombatInfo1.audioHighMemory) {
               return method2457(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1609, var2, this.field1603, this.field1604, 0, var4, var3, this);
            }

            return method2442(((RawAudioNode)super.data).audioBuffer, var1, this.field1609, var2, this.field1599, 0, var4, var3, this);
         }

         if(CombatInfo1.audioHighMemory) {
            return method2455(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1609, var2, this.field1603, this.field1604, 0, var4, var3, this, this.field1606, var5);
         }

         return method2535(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1609, var2, this.field1599, 0, var4, var3, this, this.field1606, var5);
      }
   }

   @ObfuscatedName("ae")
   int method2409(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1610 > 0) {
            int var6 = var2 + this.field1610;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1610 += var2;
            if(this.field1606 == -256 && (this.field1609 & 255) == 0) {
               if(CombatInfo1.audioHighMemory) {
                  var2 = method2422(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1609, var2, this.field1603, this.field1604, this.field1611, this.field1612, 0, var6, var3, this);
               } else {
                  var2 = method2421(((RawAudioNode)super.data).audioBuffer, var1, this.field1609, var2, this.field1599, this.field1605, 0, var6, var3, this);
               }
            } else if(CombatInfo1.audioHighMemory) {
               var2 = method2426(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1609, var2, this.field1603, this.field1604, this.field1611, this.field1612, 0, var6, var3, this, this.field1606, var5);
            } else {
               var2 = method2425(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1609, var2, this.field1599, this.field1605, 0, var6, var3, this, this.field1606, var5);
            }

            this.field1610 -= var2;
            if(this.field1610 != 0) {
               return var2;
            }

            if(!this.method2479()) {
               continue;
            }

            return var4;
         }

         if(this.field1606 == -256 && (this.field1609 & 255) == 0) {
            if(CombatInfo1.audioHighMemory) {
               return method2414(0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1609, var2, this.field1603, this.field1604, 0, var4, var3, this);
            }

            return method2413(((RawAudioNode)super.data).audioBuffer, var1, this.field1609, var2, this.field1599, 0, var4, var3, this);
         }

         if(CombatInfo1.audioHighMemory) {
            return method2484(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1609, var2, this.field1603, this.field1604, 0, var4, var3, this, this.field1606, var5);
         }

         return method2381(0, 0, ((RawAudioNode)super.data).audioBuffer, var1, this.field1609, var2, this.field1599, 0, var4, var3, this, this.field1606, var5);
      }
   }

   @ObfuscatedName("ao")
   boolean method2479() {
      int var1 = this.field1600;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2401(var1, this.field1602);
         var3 = method2382(var1, this.field1602);
      }

      if(var1 == this.field1599 && var2 == this.field1603 && var3 == this.field1604) {
         if(this.field1600 == Integer.MIN_VALUE) {
            this.field1600 = 0;
            this.field1604 = 0;
            this.field1603 = 0;
            this.field1599 = 0;
            this.unlink();
            return true;
         } else {
            this.method2386();
            return false;
         }
      } else {
         if(this.field1599 < var1) {
            this.field1605 = 1;
            this.field1610 = var1 - this.field1599;
         } else if(this.field1599 > var1) {
            this.field1605 = -1;
            this.field1610 = this.field1599 - var1;
         } else {
            this.field1605 = 0;
         }

         if(this.field1603 < var2) {
            this.field1611 = 1;
            if(this.field1610 == 0 || this.field1610 > var2 - this.field1603) {
               this.field1610 = var2 - this.field1603;
            }
         } else if(this.field1603 > var2) {
            this.field1611 = -1;
            if(this.field1610 == 0 || this.field1610 > this.field1603 - var2) {
               this.field1610 = this.field1603 - var2;
            }
         } else {
            this.field1611 = 0;
         }

         if(this.field1604 < var3) {
            this.field1612 = 1;
            if(this.field1610 == 0 || this.field1610 > var3 - this.field1604) {
               this.field1610 = var3 - this.field1604;
            }
         } else if(this.field1604 > var3) {
            this.field1612 = -1;
            if(this.field1610 == 0 || this.field1610 > this.field1604 - var3) {
               this.field1610 = this.field1604 - var3;
            }
         } else {
            this.field1612 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("aa")
   int vmethod2558() {
      int var1 = this.field1599 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1601 == 0) {
         var1 -= var1 * this.field1609 / (((RawAudioNode)super.data).audioBuffer.length << 8);
      } else if(this.field1601 >= 0) {
         var1 -= var1 * this.startPosition / ((RawAudioNode)super.data).audioBuffer.length;
      }

      return var1 > 255?255:var1;
   }

   @ObfuscatedName("s")
   static int method2401(int var0, int var1) {
      return var1 < 0?var0:(int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("g")
   static int method2382(int var0, int var1) {
      return var1 < 0?-var0:(int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ldz;II)Ldt;"
   )
   public static class116 method2526(RawAudioNode var0, int var1, int var2) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class116(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(AbstractSoundSystem.sampleRate * 100)), var2 << 6):null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ldz;III)Ldt;"
   )
   public static class116 method2385(RawAudioNode var0, int var1, int var2, int var3) {
      return var0.audioBuffer != null && var0.audioBuffer.length != 0?new class116(var0, var1, var2, var3):null;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdt;)I"
   )
   static int method2442(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class116 var8) {
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

      var8.field1609 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdt;)I"
   )
   static int method2457(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10) {
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

      var10.field1609 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILdt;)I"
   )
   static int method2413(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class116 var8) {
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

      var8.field1609 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILdt;)I"
   )
   static int method2414(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10) {
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

      var10.field1609 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdt;II)I"
   )
   static int method2535(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10, int var11, int var12) {
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

      var10.field1609 = var4;
      return var5;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdt;II)I"
   )
   static int method2455(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
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

      var11.field1609 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILdt;II)I"
   )
   static int method2381(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class116 var10, int var11, int var12) {
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

      var10.field1609 = var4;
      return var5;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdt;II)I"
   )
   static int method2484(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
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

      var11.field1609 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdt;)I"
   )
   static int method2419(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class116 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1603 += var9.field1611 * (var6 - var3);
      var9.field1604 += var9.field1612 * (var6 - var3);

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

      var9.field1599 = var4 >> 2;
      var9.field1609 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdt;)I"
   )
   static int method2420(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class116 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1599 += var12.field1605 * (var9 - var4);
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

      var12.field1603 = var5 >> 2;
      var12.field1604 = var6 >> 2;
      var12.field1609 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILdt;)I"
   )
   static int method2421(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class116 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1603 += var9.field1611 * (var6 - var3);
      var9.field1604 += var9.field1612 * (var6 - var3);

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

      var9.field1599 = var4 >> 2;
      var9.field1609 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILdt;)I"
   )
   static int method2422(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class116 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1599 += var12.field1605 * (var9 - var4);
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

      var12.field1603 = var5 >> 2;
      var12.field1604 = var6 >> 2;
      var12.field1609 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdt;II)I"
   )
   static int method2449(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
      var11.field1603 -= var11.field1611 * var5;
      var11.field1604 -= var11.field1612 * var5;
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

      var11.field1603 += var11.field1611 * var5;
      var11.field1604 += var11.field1612 * var5;
      var11.field1599 = var6;
      var11.field1609 = var4;
      return var5;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdt;II)I"
   )
   static int method2424(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class116 var13, int var14, int var15) {
      var13.field1599 -= var5 * var13.field1605;
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
      var13.field1599 += var13.field1605 * var5;
      var13.field1603 = var6;
      var13.field1604 = var7;
      var13.field1609 = var4;
      return var5;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILdt;II)I"
   )
   static int method2425(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class116 var11, int var12, int var13) {
      var11.field1603 -= var11.field1611 * var5;
      var11.field1604 -= var11.field1612 * var5;
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

      var11.field1603 += var11.field1611 * var5;
      var11.field1604 += var11.field1612 * var5;
      var11.field1599 = var6;
      var11.field1609 = var4;
      return var5;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILdt;II)I"
   )
   static int method2426(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class116 var13, int var14, int var15) {
      var13.field1599 -= var5 * var13.field1605;
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
      var13.field1599 += var13.field1605 * var5;
      var13.field1603 = var6;
      var13.field1604 = var7;
      var13.field1609 = var4;
      return var5;
   }
}
