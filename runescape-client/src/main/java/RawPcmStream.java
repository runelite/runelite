import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("RawPcmStream")
public class RawPcmStream extends PcmStream {
   @ObfuscatedName("m")
   int field744;
   @ObfuscatedName("f")
   int field745;
   @ObfuscatedName("q")
   int field746;
   @ObfuscatedName("o")
   int field747;
   @ObfuscatedName("u")
   int field748;
   @ObfuscatedName("g")
   int field749;
   @ObfuscatedName("l")
   int field750;
   @ObfuscatedName("e")
   @Export("numLoops")
   int numLoops;
   @ObfuscatedName("x")
   @Export("start")
   int start;
   @ObfuscatedName("d")
   @Export("end")
   int end;
   @ObfuscatedName("k")
   boolean field751;
   @ObfuscatedName("n")
   int field752;
   @ObfuscatedName("i")
   int field753;
   @ObfuscatedName("a")
   int field754;
   @ObfuscatedName("z")
   int field755;

   @ObfuscatedSignature(
      signature = "(Lcx;III)V"
   )
   RawPcmStream(RawSound var1, int var2, int var3, int var4) {
      super.sound = var1;
      this.start = var1.start;
      this.end = var1.end;
      this.field751 = var1.field756;
      this.field745 = var2;
      this.field746 = var3;
      this.field747 = var4;
      this.field744 = 0;
      this.method261();
   }

   @ObfuscatedSignature(
      signature = "(Lcx;II)V"
   )
   RawPcmStream(RawSound var1, int var2, int var3) {
      super.sound = var1;
      this.start = var1.start;
      this.end = var1.end;
      this.field751 = var1.field756;
      this.field745 = var2;
      this.field746 = var3;
      this.field747 = 8192;
      this.field744 = 0;
      this.method261();
   }

   @ObfuscatedName("o")
   void method261() {
      this.field748 = this.field746;
      this.field749 = method2603(this.field746, this.field747);
      this.field750 = method2494(this.field746, this.field747);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "()Ldc;"
   )
   @Export("firstSubStream")
   protected PcmStream firstSubStream() {
      return null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Ldc;"
   )
   @Export("nextSubStream")
   protected PcmStream nextSubStream() {
      return null;
   }

   @ObfuscatedName("l")
   protected int vmethod262() {
      return this.field746 == 0 && this.field752 == 0 ? 0 : 1;
   }

   @ObfuscatedName("e")
   @Export("fill")
   public synchronized void fill(int[] var1, int var2, int var3) {
      if (this.field746 == 0 && this.field752 == 0) {
         this.skip(var3);
      } else {
         RawSound var4 = (RawSound)super.sound;
         int var5 = this.start << 8;
         int var6 = this.end << 8;
         int var7 = var4.samples.length << 8;
         int var8 = var6 - var5;
         if (var8 <= 0) {
            this.numLoops = 0;
         }

         int var9 = var2;
         var3 += var2;
         if (this.field744 < 0) {
            if (this.field745 <= 0) {
               this.method272();
               this.remove();
               return;
            }

            this.field744 = 0;
         }

         if (this.field744 >= var7) {
            if (this.field745 >= 0) {
               this.method272();
               this.remove();
               return;
            }

            this.field744 = var7 - 1;
         }

         if (this.numLoops < 0) {
            if (this.field751) {
               if (this.field745 < 0) {
                  var9 = this.method281(var1, var2, var5, var3, var4.samples[this.start]);
                  if (this.field744 >= var5) {
                     return;
                  }

                  this.field744 = var5 + var5 - 1 - this.field744;
                  this.field745 = -this.field745;
               }

               while (true) {
                  var9 = this.method280(var1, var9, var6, var3, var4.samples[this.end - 1]);
                  if (this.field744 < var6) {
                     return;
                  }

                  this.field744 = var6 + var6 - 1 - this.field744;
                  this.field745 = -this.field745;
                  var9 = this.method281(var1, var9, var5, var3, var4.samples[this.start]);
                  if (this.field744 >= var5) {
                     return;
                  }

                  this.field744 = var5 + var5 - 1 - this.field744;
                  this.field745 = -this.field745;
               }
            }

            if (this.field745 < 0) {
               while (true) {
                  var9 = this.method281(var1, var9, var5, var3, var4.samples[this.end - 1]);
                  if (this.field744 >= var5) {
                     return;
                  }

                  this.field744 = var6 - 1 - (var6 - 1 - this.field744) % var8;
               }
            }

            while (true) {
               var9 = this.method280(var1, var9, var6, var3, var4.samples[this.start]);
               if (this.field744 < var6) {
                  return;
               }

               this.field744 = var5 + (this.field744 - var5) % var8;
            }
         }

         if (this.numLoops > 0) {
            if (this.field751) {
               label118: {
                  if (this.field745 < 0) {
                     var9 = this.method281(var1, var2, var5, var3, var4.samples[this.start]);
                     if (this.field744 >= var5) {
                        return;
                     }

                     this.field744 = var5 + var5 - 1 - this.field744;
                     this.field745 = -this.field745;
                     if (--this.numLoops == 0) {
                        break label118;
                     }
                  }

                  do {
                     var9 = this.method280(var1, var9, var6, var3, var4.samples[this.end - 1]);
                     if (this.field744 < var6) {
                        return;
                     }

                     this.field744 = var6 + var6 - 1 - this.field744;
                     this.field745 = -this.field745;
                     if (--this.numLoops == 0) {
                        break;
                     }

                     var9 = this.method281(var1, var9, var5, var3, var4.samples[this.start]);
                     if (this.field744 >= var5) {
                        return;
                     }

                     this.field744 = var5 + var5 - 1 - this.field744;
                     this.field745 = -this.field745;
                  } while(--this.numLoops != 0);
               }
            } else {
               int var10;
               if (this.field745 < 0) {
                  while (true) {
                     var9 = this.method281(var1, var9, var5, var3, var4.samples[this.end - 1]);
                     if (this.field744 >= var5) {
                        return;
                     }

                     var10 = (var6 - 1 - this.field744) / var8;
                     if (var10 >= this.numLoops) {
                        this.field744 += var8 * this.numLoops;
                        this.numLoops = 0;
                        break;
                     }

                     this.field744 += var8 * var10;
                     this.numLoops -= var10;
                  }
               } else {
                  while (true) {
                     var9 = this.method280(var1, var9, var6, var3, var4.samples[this.start]);
                     if (this.field744 < var6) {
                        return;
                     }

                     var10 = (this.field744 - var5) / var8;
                     if (var10 >= this.numLoops) {
                        this.field744 -= var8 * this.numLoops;
                        this.numLoops = 0;
                        break;
                     }

                     this.field744 -= var8 * var10;
                     this.numLoops -= var10;
                  }
               }
            }
         }

         if (this.field745 < 0) {
            this.method281(var1, var9, 0, var3, 0);
            if (this.field744 < 0) {
               this.field744 = -1;
               this.method272();
               this.remove();
            }
         } else {
            this.method280(var1, var9, var7, var3, 0);
            if (this.field744 >= var7) {
               this.field744 = var7;
               this.method272();
               this.remove();
            }
         }
      }

   }

   @ObfuscatedName("x")
   @Export("setNumLoops")
   public synchronized void setNumLoops(int var1) {
      this.numLoops = var1;
   }

   @ObfuscatedName("d")
   @Export("skip")
   public synchronized void skip(int var1) {
      if (this.field752 > 0) {
         if (var1 >= this.field752) {
            if (this.field746 == Integer.MIN_VALUE) {
               this.field746 = 0;
               this.field750 = 0;
               this.field749 = 0;
               this.field748 = 0;
               this.remove();
               var1 = this.field752;
            }

            this.field752 = 0;
            this.method261();
         } else {
            this.field748 += this.field753 * var1;
            this.field749 += this.field754 * var1;
            this.field750 += this.field755 * var1;
            this.field752 -= var1;
         }
      }

      RawSound var2 = (RawSound)super.sound;
      int var3 = this.start << 8;
      int var4 = this.end << 8;
      int var5 = var2.samples.length << 8;
      int var6 = var4 - var3;
      if (var6 <= 0) {
         this.numLoops = 0;
      }

      if (this.field744 < 0) {
         if (this.field745 <= 0) {
            this.method272();
            this.remove();
            return;
         }

         this.field744 = 0;
      }

      if (this.field744 >= var5) {
         if (this.field745 >= 0) {
            this.method272();
            this.remove();
            return;
         }

         this.field744 = var5 - 1;
      }

      this.field744 += this.field745 * var1;
      if (this.numLoops < 0) {
         if (!this.field751) {
            if (this.field745 < 0) {
               if (this.field744 >= var3) {
                  return;
               }

               this.field744 = var4 - 1 - (var4 - 1 - this.field744) % var6;
            } else {
               if (this.field744 < var4) {
                  return;
               }

               this.field744 = var3 + (this.field744 - var3) % var6;
            }
         } else {
            if (this.field745 < 0) {
               if (this.field744 >= var3) {
                  return;
               }

               this.field744 = var3 + var3 - 1 - this.field744;
               this.field745 = -this.field745;
            }

            while (this.field744 >= var4) {
               this.field744 = var4 + var4 - 1 - this.field744;
               this.field745 = -this.field745;
               if (this.field744 >= var3) {
                  return;
               }

               this.field744 = var3 + var3 - 1 - this.field744;
               this.field745 = -this.field745;
            }
         }
      } else {
         if (this.numLoops > 0) {
            if (this.field751) {
               label113: {
                  if (this.field745 < 0) {
                     if (this.field744 >= var3) {
                        return;
                     }

                     this.field744 = var3 + var3 - 1 - this.field744;
                     this.field745 = -this.field745;
                     if (--this.numLoops == 0) {
                        break label113;
                     }
                  }

                  do {
                     if (this.field744 < var4) {
                        return;
                     }

                     this.field744 = var4 + var4 - 1 - this.field744;
                     this.field745 = -this.field745;
                     if (--this.numLoops == 0) {
                        break;
                     }

                     if (this.field744 >= var3) {
                        return;
                     }

                     this.field744 = var3 + var3 - 1 - this.field744;
                     this.field745 = -this.field745;
                  } while(--this.numLoops != 0);
               }
            } else {
               int var7;
               if (this.field745 < 0) {
                  if (this.field744 >= var3) {
                     return;
                  }

                  var7 = (var4 - 1 - this.field744) / var6;
                  if (var7 < this.numLoops) {
                     this.field744 += var6 * var7;
                     this.numLoops -= var7;
                     return;
                  }

                  this.field744 += var6 * this.numLoops;
                  this.numLoops = 0;
               } else {
                  if (this.field744 < var4) {
                     return;
                  }

                  var7 = (this.field744 - var3) / var6;
                  if (var7 < this.numLoops) {
                     this.field744 -= var6 * var7;
                     this.numLoops -= var7;
                     return;
                  }

                  this.field744 -= var6 * this.numLoops;
                  this.numLoops = 0;
               }
            }
         }

         if (this.field745 < 0) {
            if (this.field744 < 0) {
               this.field744 = -1;
               this.method272();
               this.remove();
            }
         } else if (this.field744 >= var5) {
            this.field744 = var5;
            this.method272();
            this.remove();
         }
      }

   }

   @ObfuscatedName("a")
   public synchronized void method265(int var1) {
      this.method267(var1 << 6, this.method269());
   }

   @ObfuscatedName("z")
   synchronized void method266(int var1) {
      this.method267(var1, this.method269());
   }

   @ObfuscatedName("j")
   synchronized void method267(int var1, int var2) {
      this.field746 = var1;
      this.field747 = var2;
      this.field752 = 0;
      this.method261();
   }

   @ObfuscatedName("s")
   public synchronized int method268() {
      return this.field746 == Integer.MIN_VALUE ? 0 : this.field746;
   }

   @ObfuscatedName("t")
   public synchronized int method269() {
      return this.field747 < 0 ? -1 : this.field747;
   }

   @ObfuscatedName("y")
   public synchronized void method270(int var1) {
      int var2 = ((RawSound)super.sound).samples.length << 8;
      if (var1 < -1) {
         var1 = -1;
      }

      if (var1 > var2) {
         var1 = var2;
      }

      this.field744 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method271() {
      this.field745 = (this.field745 ^ this.field745 >> 31) + (this.field745 >>> 31);
      this.field745 = -this.field745;
   }

   @ObfuscatedName("b")
   void method272() {
      if (this.field752 != 0) {
         if (this.field746 == Integer.MIN_VALUE) {
            this.field746 = 0;
         }

         this.field752 = 0;
         this.method261();
      }

   }

   @ObfuscatedName("c")
   public synchronized void method273(int var1, int var2) {
      this.method274(var1, var2, this.method269());
   }

   @ObfuscatedName("p")
   public synchronized void method274(int var1, int var2, int var3) {
      if (var1 == 0) {
         this.method267(var2, var3);
      } else {
         int var4 = method2603(var2, var3);
         int var5 = method2494(var2, var3);
         if (var4 == this.field749 && var5 == this.field750) {
            this.field752 = 0;
         } else {
            int var6 = var2 - this.field748;
            if (this.field748 - var2 > var6) {
               var6 = this.field748 - var2;
            }

            if (var4 - this.field749 > var6) {
               var6 = var4 - this.field749;
            }

            if (this.field749 - var4 > var6) {
               var6 = this.field749 - var4;
            }

            if (var5 - this.field750 > var6) {
               var6 = var5 - this.field750;
            }

            if (this.field750 - var5 > var6) {
               var6 = this.field750 - var5;
            }

            if (var1 > var6) {
               var1 = var6;
            }

            this.field752 = var1;
            this.field746 = var2;
            this.field747 = var3;
            this.field753 = (var2 - this.field748) / var1;
            this.field754 = (var4 - this.field749) / var1;
            this.field755 = (var5 - this.field750) / var1;
         }
      }

   }

   @ObfuscatedName("v")
   public synchronized void method275(int var1) {
      if (var1 == 0) {
         this.method266(0);
         this.remove();
      } else if (this.field749 == 0 && this.field750 == 0) {
         this.field752 = 0;
         this.field746 = 0;
         this.field748 = 0;
         this.remove();
      } else {
         int var2 = -this.field748;
         if (this.field748 > var2) {
            var2 = this.field748;
         }

         if (-this.field749 > var2) {
            var2 = -this.field749;
         }

         if (this.field749 > var2) {
            var2 = this.field749;
         }

         if (-this.field750 > var2) {
            var2 = -this.field750;
         }

         if (this.field750 > var2) {
            var2 = this.field750;
         }

         if (var1 > var2) {
            var1 = var2;
         }

         this.field752 = var1;
         this.field746 = Integer.MIN_VALUE;
         this.field753 = -this.field748 / var1;
         this.field754 = -this.field749 / var1;
         this.field755 = -this.field750 / var1;
      }

   }

   @ObfuscatedName("ah")
   public synchronized void method276(int var1) {
      if (this.field745 < 0) {
         this.field745 = -var1;
      } else {
         this.field745 = var1;
      }

   }

   @ObfuscatedName("ab")
   public synchronized int method277() {
      return this.field745 < 0 ? -this.field745 : this.field745;
   }

   @ObfuscatedName("ae")
   public boolean method278() {
      return this.field744 < 0 || this.field744 >= ((RawSound)super.sound).samples.length << 8;
   }

   @ObfuscatedName("at")
   public boolean method279() {
      return this.field752 != 0;
   }

   @ObfuscatedName("ad")
   int method280(int[] var1, int var2, int var3, int var4, int var5) {
      while (true) {
         if (this.field752 > 0) {
            int var6 = var2 + this.field752;
            if (var6 > var4) {
               var6 = var4;
            }

            this.field752 += var2;
            if (this.field745 == 256 && (this.field744 & 255) == 0) {
               if (PcmPlayer.isStereo) {
                  var2 = method2533(0, ((RawSound)super.sound).samples, var1, this.field744, var2, this.field749, this.field750, this.field754, this.field755, 0, var6, var3, this);
               } else {
                  var2 = method2532(((RawSound)super.sound).samples, var1, this.field744, var2, this.field748, this.field753, 0, var6, var3, this);
               }
            } else if (PcmPlayer.isStereo) {
               var2 = method2504(0, 0, ((RawSound)super.sound).samples, var1, this.field744, var2, this.field749, this.field750, this.field754, this.field755, 0, var6, var3, this, this.field745, var5);
            } else {
               var2 = method2536(0, 0, ((RawSound)super.sound).samples, var1, this.field744, var2, this.field748, this.field753, 0, var6, var3, this, this.field745, var5);
            }

            this.field752 -= var2;
            if (this.field752 != 0) {
               return var2;
            }

            if (!this.method283()) {
               continue;
            }

            return var4;
         }

         if (this.field745 == 256 && (this.field744 & 255) == 0) {
            if (PcmPlayer.isStereo) {
               return method2525(0, ((RawSound)super.sound).samples, var1, this.field744, var2, this.field749, this.field750, 0, var4, var3, this);
            }

            return method2563(((RawSound)super.sound).samples, var1, this.field744, var2, this.field748, 0, var4, var3, this);
         }

         if (PcmPlayer.isStereo) {
            return method2529(0, 0, ((RawSound)super.sound).samples, var1, this.field744, var2, this.field749, this.field750, 0, var4, var3, this, this.field745, var5);
         }

         return method2528(0, 0, ((RawSound)super.sound).samples, var1, this.field744, var2, this.field748, 0, var4, var3, this, this.field745, var5);
      }
   }

   @ObfuscatedName("ap")
   int method281(int[] var1, int var2, int var3, int var4, int var5) {
      while (true) {
         if (this.field752 > 0) {
            int var6 = var2 + this.field752;
            if (var6 > var4) {
               var6 = var4;
            }

            this.field752 += var2;
            if (this.field745 == -256 && (this.field744 & 255) == 0) {
               if (PcmPlayer.isStereo) {
                  var2 = method2547(0, ((RawSound)super.sound).samples, var1, this.field744, var2, this.field749, this.field750, this.field754, this.field755, 0, var6, var3, this);
               } else {
                  var2 = method2534(((RawSound)super.sound).samples, var1, this.field744, var2, this.field748, this.field753, 0, var6, var3, this);
               }
            } else if (PcmPlayer.isStereo) {
               var2 = method2624(0, 0, ((RawSound)super.sound).samples, var1, this.field744, var2, this.field749, this.field750, this.field754, this.field755, 0, var6, var3, this, this.field745, var5);
            } else {
               var2 = method2538(0, 0, ((RawSound)super.sound).samples, var1, this.field744, var2, this.field748, this.field753, 0, var6, var3, this, this.field745, var5);
            }

            this.field752 -= var2;
            if (this.field752 != 0) {
               return var2;
            }

            if (!this.method283()) {
               continue;
            }

            return var4;
         }

         if (this.field745 == -256 && (this.field744 & 255) == 0) {
            if (PcmPlayer.isStereo) {
               return method2496(0, ((RawSound)super.sound).samples, var1, this.field744, var2, this.field749, this.field750, 0, var4, var3, this);
            }

            return method2636(((RawSound)super.sound).samples, var1, this.field744, var2, this.field748, 0, var4, var3, this);
         }

         if (PcmPlayer.isStereo) {
            return method2531(0, 0, ((RawSound)super.sound).samples, var1, this.field744, var2, this.field749, this.field750, 0, var4, var3, this, this.field745, var5);
         }

         return method2509(0, 0, ((RawSound)super.sound).samples, var1, this.field744, var2, this.field748, 0, var4, var3, this, this.field745, var5);
      }
   }

   @ObfuscatedName("az")
   int vmethod282() {
      int var1 = this.field748 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if (this.numLoops == 0) {
         var1 -= var1 * this.field744 / (((RawSound)super.sound).samples.length << 8);
      } else if (this.numLoops >= 0) {
         var1 -= var1 * this.start / ((RawSound)super.sound).samples.length;
      }

      return var1 > 255 ? 255 : var1;
   }

   @ObfuscatedName("au")
   boolean method283() {
      int var1 = this.field746;
      int var2;
      int var3;
      if (var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2603(var1, this.field747);
         var3 = method2494(var1, this.field747);
      }

      if (var1 == this.field748 && var2 == this.field749 && var3 == this.field750) {
         if (this.field746 == Integer.MIN_VALUE) {
            this.field746 = 0;
            this.field750 = 0;
            this.field749 = 0;
            this.field748 = 0;
            this.remove();
            return true;
         } else {
            this.method261();
            return false;
         }
      } else {
         if (this.field748 < var1) {
            this.field753 = 1;
            this.field752 = var1 - this.field748;
         } else if (this.field748 > var1) {
            this.field753 = -1;
            this.field752 = this.field748 - var1;
         } else {
            this.field753 = 0;
         }

         if (this.field749 < var2) {
            this.field754 = 1;
            if (this.field752 == 0 || this.field752 > var2 - this.field749) {
               this.field752 = var2 - this.field749;
            }
         } else if (this.field749 > var2) {
            this.field754 = -1;
            if (this.field752 == 0 || this.field752 > this.field749 - var2) {
               this.field752 = this.field749 - var2;
            }
         } else {
            this.field754 = 0;
         }

         if (this.field750 < var3) {
            this.field755 = 1;
            if (this.field752 == 0 || this.field752 > var3 - this.field750) {
               this.field752 = var3 - this.field750;
            }
         } else if (this.field750 > var3) {
            this.field755 = -1;
            if (this.field752 == 0 || this.field752 > this.field750 - var3) {
               this.field752 = this.field750 - var3;
            }
         } else {
            this.field755 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("m")
   static int method2603(int var0, int var1) {
      return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("f")
   static int method2494(int var0, int var1) {
      return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lcx;II)Lds;"
   )
   @Export("createRawPcmStream")
   public static RawPcmStream createRawPcmStream(RawSound var0, int var1, int var2) {
      return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(class309.PcmPlayer_sampleRate * 100)), var2 << 6) : null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lcx;III)Lds;"
   )
   public static RawPcmStream method2524(RawSound var0, int var1, int var2, int var3) {
      return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILds;)I"
   )
   static int method2563(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if ((var5 = var3 + var7 - var2) > var6) {
         var5 = var6;
      }

      int var9;
      for (var5 -= 3; var3 < var5; var1[var9] += var0[var2++] * var4) {
         var9 = var3++;
         var1[var9] += var0[var2++] * var4;
         var9 = var3++;
         var1[var9] += var0[var2++] * var4;
         var9 = var3++;
         var1[var9] += var0[var2++] * var4;
         var9 = var3++;
      }

      for (var5 += 3; var3 < var5; var1[var9] += var0[var2++] * var4) {
         var9 = var3++;
      }

      var8.field744 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILds;)I"
   )
   static int method2525(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if ((var7 = var4 + var9 - var3) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var11;
      byte var12;
      for (var7 -= 6; var4 < var7; var2[var11] += var12 * var6) {
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
      }

      for (var7 += 6; var4 < var7; var2[var11] += var12 * var6) {
         var12 = var1[var3++];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
      }

      var10.field744 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIILds;)I"
   )
   static int method2636(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if ((var5 = var3 + var2 - (var7 - 1)) > var6) {
         var5 = var6;
      }

      int var9;
      for (var5 -= 3; var3 < var5; var1[var9] += var0[var2--] * var4) {
         var9 = var3++;
         var1[var9] += var0[var2--] * var4;
         var9 = var3++;
         var1[var9] += var0[var2--] * var4;
         var9 = var3++;
         var1[var9] += var0[var2--] * var4;
         var9 = var3++;
      }

      for (var5 += 3; var3 < var5; var1[var9] += var0[var2--] * var4) {
         var9 = var3++;
      }

      var8.field744 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIILds;)I"
   )
   static int method2496(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if ((var7 = var3 + var4 - (var9 - 1)) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var11;
      byte var12;
      for (var7 -= 6; var4 < var7; var2[var11] += var12 * var6) {
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
         var2[var11] += var12 * var6;
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
      }

      for (var7 += 6; var4 < var7; var2[var11] += var12 * var6) {
         var12 = var1[var3--];
         var11 = var4++;
         var2[var11] += var12 * var5;
         var11 = var4++;
      }

      var10.field744 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILds;II)I"
   )
   static int method2528(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
      if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 257) / var11) > var8) {
         var7 = var8;
      }

      byte var13;
      int var14;
      while (var5 < var7) {
         var1 = var4 >> 8;
         var13 = var2[var1];
         var14 = var5++;
         var3[var14] += ((var13 << 8) + (var2[var1 + 1] - var13) * (var4 & 255)) * var6 >> 6;
         var4 += var11;
      }

      if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 1) / var11) > var8) {
         var7 = var8;
      }

      for (var1 = var12; var5 < var7; var4 += var11) {
         var13 = var2[var4 >> 8];
         var14 = var5++;
         var3[var14] += ((var13 << 8) + (var1 - var13) * (var4 & 255)) * var6 >> 6;
      }

      var10.field744 = var4;
      return var5;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILds;II)I"
   )
   static int method2529(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
      if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      byte var14;
      int var15;
      for (var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var0 = (var14 << 8) + (var4 & 255) * (var2[var1 + 1] - var14);
         var15 = var5++;
         var3[var15] += var0 * var6 >> 6;
         var15 = var5++;
         var3[var15] += var0 * var7 >> 6;
      }

      if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for (var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var0 = (var14 << 8) + (var1 - var14) * (var4 & 255);
         var15 = var5++;
         var3[var15] += var0 * var6 >> 6;
         var15 = var5++;
         var3[var15] += var0 * var7 >> 6;
      }

      var11.field744 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIILds;II)I"
   )
   static int method2509(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
      if (var11 == 0 || (var7 = var5 + (var11 + (var9 + 256 - var4)) / var11) > var8) {
         var7 = var8;
      }

      int var13;
      while (var5 < var7) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var13 = var5++;
         var3[var13] += ((var14 << 8) + (var2[var1] - var14) * (var4 & 255)) * var6 >> 6;
         var4 += var11;
      }

      if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4)) / var11) > var8) {
         var7 = var8;
      }

      var0 = var12;

      for (var1 = var11; var5 < var7; var4 += var1) {
         var13 = var5++;
         var3[var13] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
      }

      var10.field744 = var4;
      return var5;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILds;II)I"
   )
   static int method2531(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
      if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      int var14;
      for (var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         byte var15 = var2[var1 - 1];
         var0 = (var2[var1] - var15) * (var4 & 255) + (var15 << 8);
         var14 = var5++;
         var3[var14] += var0 * var6 >> 6;
         var14 = var5++;
         var3[var14] += var0 * var7 >> 6;
      }

      if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for (var1 = var13; var5 < var8; var4 += var12) {
         var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
         var14 = var5++;
         var3[var14] += var0 * var6 >> 6;
         var14 = var5++;
         var3[var14] += var0 * var7 >> 6;
      }

      var11.field744 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILds;)I"
   )
   static int method2532(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if ((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field749 += var9.field754 * (var6 - var3);
      var9.field750 += var9.field755 * (var6 - var3);

      int var10;
      for (var6 -= 3; var3 < var6; var4 += var5) {
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

      for (var6 += 3; var3 < var6; var4 += var5) {
         var10 = var3++;
         var1[var10] += var0[var2++] * var4;
      }

      var9.field748 = var4 >> 2;
      var9.field744 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILds;)I"
   )
   static int method2533(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if ((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field748 += var12.field753 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var14;
      for (var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      for (var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      var12.field749 = var5 >> 2;
      var12.field750 = var6 >> 2;
      var12.field744 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "([B[IIIIIIIILds;)I"
   )
   static int method2534(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field749 += var9.field754 * (var6 - var3);
      var9.field750 += var9.field755 * (var6 - var3);

      int var10;
      for (var6 -= 3; var3 < var6; var4 += var5) {
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

      for (var6 += 3; var3 < var6; var4 += var5) {
         var10 = var3++;
         var1[var10] += var0[var2--] * var4;
      }

      var9.field748 = var4 >> 2;
      var9.field744 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I[B[IIIIIIIIIILds;)I"
   )
   static int method2547(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field748 += var12.field753 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var14;
      for (var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      for (var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var14 = var4++;
         var2[var14] += var13 * var5;
         var5 += var7;
         var14 = var4++;
         var2[var14] += var13 * var6;
      }

      var12.field749 = var5 >> 2;
      var12.field750 = var6 >> 2;
      var12.field744 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILds;II)I"
   )
   static int method2536(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
      var11.field749 -= var11.field754 * var5;
      var11.field750 -= var11.field755 * var5;
      if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      byte var14;
      int var15;
      while (var5 < var8) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var15 = var5++;
         var3[var15] += ((var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      for (var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var15 = var5++;
         var3[var15] += ((var14 << 8) + (var1 - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field749 += var11.field754 * var5;
      var11.field750 += var11.field755 * var5;
      var11.field748 = var6;
      var11.field744 = var4;
      return var5;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILds;II)I"
   )
   static int method2504(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
      var13.field748 -= var5 * var13.field753;
      if (var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      byte var16;
      int var17;
      for (var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         var16 = var2[var1];
         var0 = (var16 << 8) + (var4 & 255) * (var2[var1 + 1] - var16);
         var17 = var5++;
         var3[var17] += var0 * var6 >> 6;
         var6 += var8;
         var17 = var5++;
         var3[var17] += var0 * var7 >> 6;
         var7 += var9;
      }

      if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14 - 1) / var14) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for (var1 = var15; var5 < var10; var4 += var14) {
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
      var13.field748 += var13.field753 * var5;
      var13.field749 = var6;
      var13.field750 = var7;
      var13.field744 = var4;
      return var5;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIILds;II)I"
   )
   static int method2538(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
      var11.field749 -= var11.field754 * var5;
      var11.field750 -= var11.field755 * var5;
      if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      int var14;
      while (var5 < var8) {
         var1 = var4 >> 8;
         byte var15 = var2[var1 - 1];
         var14 = var5++;
         var3[var14] += ((var15 << 8) + (var2[var1] - var15) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var0 = var13;

      for (var1 = var12; var5 < var8; var4 += var1) {
         var14 = var5++;
         var3[var14] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field749 += var11.field754 * var5;
      var11.field750 += var11.field755 * var5;
      var11.field748 = var6;
      var11.field744 = var4;
      return var5;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(II[B[IIIIIIIIIILds;II)I"
   )
   static int method2624(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
      var13.field748 -= var5 * var13.field753;
      if (var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      int var16;
      for (var10 <<= 1; var5 < var10; var4 += var14) {
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

      if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for (var1 = var15; var5 < var10; var4 += var14) {
         var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
         var16 = var5++;
         var3[var16] += var0 * var6 >> 6;
         var6 += var8;
         var16 = var5++;
         var3[var16] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field748 += var13.field753 * var5;
      var13.field749 = var6;
      var13.field750 = var7;
      var13.field744 = var4;
      return var5;
   }
}
