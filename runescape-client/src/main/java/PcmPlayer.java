import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("PcmPlayer")
public class PcmPlayer {
   @ObfuscatedName("u")
   @Export("isStereo")
   protected static boolean isStereo;
   @ObfuscatedName("i")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ldc;"
   )
   @Export("stream0")
   PcmStream stream0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1125788887
   )
   @Export("__z")
   int __z;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -8124323644430480811L
   )
   @Export("timeMs")
   long timeMs;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1671644011
   )
   @Export("capacity")
   int capacity;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 951871565
   )
   @Export("frequency")
   int frequency;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1907203055
   )
   @Export("__y")
   int __y;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -200656835998283411L
   )
   @Export("retryTimeMs")
   long retryTimeMs;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 48658021
   )
   @Export("__b")
   int __b;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1624619697
   )
   @Export("__c")
   int __c;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1586398263
   )
   @Export("nextPosition")
   int nextPosition;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -8188447292076890879L
   )
   @Export("__p")
   long __p;
   @ObfuscatedName("v")
   @Export("__v")
   boolean __v;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -645495803
   )
   @Export("__ac")
   int __ac;
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "[Ldc;"
   )
   @Export("__ay")
   PcmStream[] __ay;
   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "[Ldc;"
   )
   @Export("__ah")
   PcmStream[] __ah;

   protected PcmPlayer() {
      this.__z = 32;
      this.timeMs = class203.currentTimeMs();
      this.retryTimeMs = 0L;
      this.__b = 0;
      this.__c = 0;
      this.nextPosition = 0;
      this.__p = 0L;
      this.__v = true;
      this.__ac = 0;
      this.__ay = new PcmStream[8];
      this.__ah = new PcmStream[8];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "949670609"
   )
   protected void init() throws Exception {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1738349775"
   )
   protected void open(int var1) throws Exception {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   protected int position() throws Exception {
      return this.capacity;
   }

   @ObfuscatedName("w")
   protected void write() throws Exception {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "244995961"
   )
   protected void close() {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-191421600"
   )
   protected void discard() throws Exception {
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Ldc;I)V",
      garbageValue = "2106357590"
   )
   @Export("setStream")
   public final synchronized void setStream(PcmStream var1) {
      this.stream0 = var1;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "453523469"
   )
   @Export("run")
   public final synchronized void run() {
      if(this.samples != null) {
         long var1 = class203.currentTimeMs();

         try {
            if(0L != this.retryTimeMs) {
               if(var1 < this.retryTimeMs) {
                  return;
               }

               this.open(this.capacity);
               this.retryTimeMs = 0L;
               this.__v = true;
            }

            int var3 = this.position();
            if(this.nextPosition - var3 > this.__b) {
               this.__b = this.nextPosition - var3;
            }

            int var4 = this.__y + this.frequency;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.capacity) {
               this.capacity += 1024;
               if(this.capacity > 16384) {
                  this.capacity = 16384;
               }

               this.close();
               this.open(this.capacity);
               var3 = 0;
               this.__v = true;
               if(var4 + 256 > this.capacity) {
                  var4 = this.capacity - 256;
                  this.__y = var4 - this.frequency;
               }
            }

            while(var3 < var4) {
               this.fill(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.__p) {
               if(!this.__v) {
                  if(this.__b == 0 && this.__c == 0) {
                     this.close();
                     this.retryTimeMs = 2000L + var1;
                     return;
                  }

                  this.__y = Math.min(this.__c, this.__b);
                  this.__c = this.__b;
               } else {
                  this.__v = false;
               }

               this.__b = 0;
               this.__p = 2000L + var1;
            }

            this.nextPosition = var3;
         } catch (Exception var7) {
            this.close();
            this.retryTimeMs = var1 + 2000L;
         }

         try {
            if(var1 > this.timeMs + 500000L) {
               var1 = this.timeMs;
            }

            while(var1 > 5000L + this.timeMs) {
               this.skip(256);
               this.timeMs += (long)(256000 / class309.PcmPlayer_sampleRate);
            }
         } catch (Exception var6) {
            this.timeMs = var1;
         }

      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-922069005"
   )
   @Export("__ac_176")
   public final void __ac_176() {
      this.__v = true;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "50"
   )
   @Export("tryDiscard")
   public final synchronized void tryDiscard() {
      this.__v = true;

      try {
         this.discard();
      } catch (Exception var2) {
         this.close();
         this.retryTimeMs = class203.currentTimeMs() + 2000L;
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "300201744"
   )
   @Export("shutdown")
   public final synchronized void shutdown() {
      if(Messages.soundSystem != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == Messages.soundSystem.players[var2]) {
               Messages.soundSystem.players[var2] = null;
            }

            if(Messages.soundSystem.players[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            Friend.soundSystemExecutor.shutdownNow();
            Friend.soundSystemExecutor = null;
            Messages.soundSystem = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-424358259"
   )
   @Export("skip")
   final void skip(int var1) {
      this.__ac -= var1;
      if(this.__ac < 0) {
         this.__ac = 0;
      }

      if(this.stream0 != null) {
         this.stream0.__d_173(var1);
      }

   }

   @ObfuscatedName("aw")
   @Export("fill")
   final void fill(int[] var1, int var2) {
      int var3 = var2;
      if(isStereo) {
         var3 = var2 << 1;
      }

      class212.clearIntArray(var1, 0, var3);
      this.__ac -= var2;
      if(this.stream0 != null && this.__ac <= 0) {
         this.__ac += class309.PcmPlayer_sampleRate >> 4;
         MidiPcmStream.PcmStream_disable(this.stream0);
         this.__ab_177(this.stream0, this.stream0.__az_179());
         int var4 = 0;
         int var5 = 255;

         int var6;
         PcmStream var10;
         label104:
         for(var6 = 7; var5 != 0; --var6) {
            int var7;
            int var8;
            if(var6 < 0) {
               var7 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var7 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  PcmStream var11 = this.__ay[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        AbstractSound var12 = var11.sound;
                        if(var12 != null && var12.position > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.after;
                        } else {
                           var11.active = true;
                           int var13 = var11.__l_171();
                           var4 += var13;
                           if(var12 != null) {
                              var12.position += var13;
                           }

                           if(var4 >= this.__z) {
                              break label104;
                           }

                           PcmStream var14 = var11.firstSubStream();
                           if(var14 != null) {
                              for(int var15 = var11.__s; var14 != null; var14 = var11.nextSubStream()) {
                                 this.__ab_177(var14, var15 * var14.__az_179() >> 8);
                              }
                           }

                           PcmStream var18 = var11.after;
                           var11.after = null;
                           if(var10 == null) {
                              this.__ay[var7] = var18;
                           } else {
                              var10.after = var18;
                           }

                           if(var18 == null) {
                              this.__ah[var7] = var10;
                           }

                           var11 = var18;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            PcmStream var16 = this.__ay[var6];
            PcmStream[] var17 = this.__ay;
            this.__ah[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.after;
               var16.after = null;
            }
         }
      }

      if(this.__ac < 0) {
         this.__ac = 0;
      }

      if(this.stream0 != null) {
         this.stream0.__e_172(var1, 0, var2);
      }

      this.timeMs = class203.currentTimeMs();
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Ldc;II)V",
      garbageValue = "-1884182540"
   )
   @Export("__ab_177")
   final void __ab_177(PcmStream var1, int var2) {
      int var3 = var2 >> 5;
      PcmStream var4 = this.__ah[var3];
      if(var4 == null) {
         this.__ay[var3] = var1;
      } else {
         var4.after = var1;
      }

      this.__ah[var3] = var1;
      var1.__s = var2;
   }
}
