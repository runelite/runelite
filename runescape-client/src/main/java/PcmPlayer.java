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
   @Export("stream")
   PcmStream stream;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1125788887
   )
   int field680;
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
   int field681;
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
   int field682;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1624619697
   )
   int field683;
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
   long field684;
   @ObfuscatedName("v")
   boolean field685;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -645495803
   )
   int field686;
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "[Ldc;"
   )
   PcmStream[] field687;
   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "[Ldc;"
   )
   PcmStream[] field688;

   protected PcmPlayer() {
      this.field680 = 32;
      this.timeMs = class203.currentTimeMs();
      this.retryTimeMs = 0L;
      this.field682 = 0;
      this.field683 = 0;
      this.nextPosition = 0;
      this.field684 = 0L;
      this.field685 = true;
      this.field686 = 0;
      this.field687 = new PcmStream[8];
      this.field688 = new PcmStream[8];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "949670609"
   )
   @Export("init")
   protected void init() throws Exception {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1738349775"
   )
   @Export("open")
   protected void open(int bufferSize) throws Exception {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   @Export("position")
   protected int position() throws Exception {
      return this.capacity;
   }

   @ObfuscatedName("w")
   @Export("write")
   protected void write() throws Exception {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "244995961"
   )
   @Export("close")
   protected void close() {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-191421600"
   )
   @Export("discard")
   protected void discard() throws Exception {
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Ldc;I)V",
      garbageValue = "2106357590"
   )
   @Export("setStream")
   public final synchronized void setStream(PcmStream stream) {
      this.stream = stream;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "453523469"
   )
   @Export("run")
   public final synchronized void run() {
      if (this.samples != null) {
         long var1 = class203.currentTimeMs();

         try {
            if (0L != this.retryTimeMs) {
               if (var1 < this.retryTimeMs) {
                  return;
               }

               this.open(this.capacity);
               this.retryTimeMs = 0L;
               this.field685 = true;
            }

            int var3 = this.position();
            if (this.nextPosition - var3 > this.field682) {
               this.field682 = this.nextPosition - var3;
            }

            int var4 = this.field681 + this.frequency;
            if (var4 + 256 > 16384) {
               var4 = 16128;
            }

            if (var4 + 256 > this.capacity) {
               this.capacity += 1024;
               if (this.capacity > 16384) {
                  this.capacity = 16384;
               }

               this.close();
               this.open(this.capacity);
               var3 = 0;
               this.field685 = true;
               if (var4 + 256 > this.capacity) {
                  var4 = this.capacity - 256;
                  this.field681 = var4 - this.frequency;
               }
            }

            while (var3 < var4) {
               this.fill(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if (var1 > this.field684) {
               if (!this.field685) {
                  if (this.field682 == 0 && this.field683 == 0) {
                     this.close();
                     this.retryTimeMs = 2000L + var1;
                     return;
                  }

                  this.field681 = Math.min(this.field683, this.field682);
                  this.field683 = this.field682;
               } else {
                  this.field685 = false;
               }

               this.field682 = 0;
               this.field684 = 2000L + var1;
            }

            this.nextPosition = var3;
         } catch (Exception var6) {
            this.close();
            this.retryTimeMs = var1 + 2000L;
         }

         try {
            if (var1 > this.timeMs + 500000L) {
               var1 = this.timeMs;
            }

            while (var1 > 5000L + this.timeMs) {
               this.skip(256);
               this.timeMs += (long)(256000 / class309.PcmPlayer_sampleRate);
            }
         } catch (Exception var5) {
            this.timeMs = var1;
         }
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-922069005"
   )
   public final void method242() {
      this.field685 = true;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "50"
   )
   @Export("tryDiscard")
   public final synchronized void tryDiscard() {
      this.field685 = true;

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
      if (Messages.soundSystem != null) {
         boolean var1 = true;

         for (int var2 = 0; var2 < 2; ++var2) {
            if (this == Messages.soundSystem.players[var2]) {
               Messages.soundSystem.players[var2] = null;
            }

            if (Messages.soundSystem.players[var2] != null) {
               var1 = false;
            }
         }

         if (var1) {
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
   final void skip(int length) {
      this.field686 -= length;
      if (this.field686 < 0) {
         this.field686 = 0;
      }

      if (this.stream != null) {
         this.stream.skip(length);
      }

   }

   @ObfuscatedName("aw")
   @Export("fill")
   final void fill(int[] buffer, int length) {
      int var3 = length;
      if (isStereo) {
         var3 = length << 1;
      }

      class212.clearIntArray(buffer, 0, var3);
      this.field686 -= length;
      if (this.stream != null && this.field686 <= 0) {
         this.field686 += class309.PcmPlayer_sampleRate >> 4;
         MidiPcmStream.PcmStream_disable(this.stream);
         this.method243(this.stream, this.stream.vmethod282());
         int var4 = 0;
         int var5 = 255;

         int var6;
         PcmStream var7;
         label106:
         for (var6 = 7; var5 != 0; --var6) {
            int var8;
            int var9;
            if (var6 < 0) {
               var8 = var6 & 3;
               var9 = -(var6 >> 2);
            } else {
               var8 = var6;
               var9 = 0;
            }

            for (int var10 = var5 >>> var8 & 286331153; var10 != 0; var10 >>>= 4) {
               if ((var10 & 1) != 0) {
                  var5 &= ~(1 << var8);
                  var7 = null;
                  PcmStream var11 = this.field687[var8];

                  label100:
                  while (true) {
                     while (true) {
                        if (var11 == null) {
                           break label100;
                        }

                        AbstractSound var12 = var11.sound;
                        if (var12 != null && var12.position > var9) {
                           var5 |= 1 << var8;
                           var7 = var11;
                           var11 = var11.after;
                        } else {
                           var11.active = true;
                           int var13 = var11.vmethod262();
                           var4 += var13;
                           if (var12 != null) {
                              var12.position += var13;
                           }

                           if (var4 >= this.field680) {
                              break label106;
                           }

                           PcmStream var14 = var11.firstSubStream();
                           if (var14 != null) {
                              for (int var15 = var11.field689; var14 != null; var14 = var11.nextSubStream()) {
                                 this.method243(var14, var15 * var14.vmethod282() >> 8);
                              }
                           }

                           PcmStream var18 = var11.after;
                           var11.after = null;
                           if (var7 == null) {
                              this.field687[var8] = var18;
                           } else {
                              var7.after = var18;
                           }

                           if (var18 == null) {
                              this.field688[var8] = var7;
                           }

                           var11 = var18;
                        }
                     }
                  }
               }

               var8 += 4;
               ++var9;
            }
         }

         for (var6 = 0; var6 < 8; ++var6) {
            PcmStream var16 = this.field687[var6];
            PcmStream[] var17 = this.field687;
            this.field688[var6] = null;

            for (var17[var6] = null; var16 != null; var16 = var7) {
               var7 = var16.after;
               var16.after = null;
            }
         }
      }

      if (this.field686 < 0) {
         this.field686 = 0;
      }

      if (this.stream != null) {
         this.stream.fill(buffer, 0, length);
      }

      this.timeMs = class203.currentTimeMs();
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Ldc;II)V",
      garbageValue = "-1884182540"
   )
   final void method243(PcmStream var1, int var2) {
      int var3 = var2 >> 5;
      PcmStream var4 = this.field688[var3];
      if (var4 == null) {
         this.field687[var3] = var1;
      } else {
         var4.after = var1;
      }

      this.field688[var3] = var1;
      var1.field689 = var2;
   }
}
