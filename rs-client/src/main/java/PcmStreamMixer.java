import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("PcmStreamMixer")
public class PcmStreamMixer extends PcmStream {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   @Export("subStreams")
   NodeDeque subStreams;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   @Export("__f")
   NodeDeque __f;
   @ObfuscatedName("q")
   @Export("__q")
   int __q;
   @ObfuscatedName("o")
   @Export("__o")
   int __o;

   public PcmStreamMixer() {
      this.subStreams = new NodeDeque();
      this.__f = new NodeDeque();
      this.__q = 0;
      this.__o = -1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ldc;)V"
   )
   @Export("addSubStream")
   public final synchronized void addSubStream(PcmStream var1) {
      this.subStreams.addLast(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ldc;)V"
   )
   @Export("removeSubStream")
   public final synchronized void removeSubStream(PcmStream var1) {
      var1.remove();
   }

   @ObfuscatedName("q")
   @Export("__q_168")
   void __q_168() {
      if(this.__q > 0) {
         for(PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.__f.last(); var1 != null; var1 = (PcmStreamMixerListener)this.__f.previous()) {
            var1.__m -= this.__q;
         }

         this.__o -= this.__q;
         this.__q = 0;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgw;Ldf;)V"
   )
   @Export("__w_169")
   void __w_169(Node var1, PcmStreamMixerListener var2) {
      while(this.__f.sentinel != var1 && ((PcmStreamMixerListener)var1).__m <= var2.__m) {
         var1 = var1.previous;
      }

      NodeDeque.method5270(var2, var1);
      this.__o = ((PcmStreamMixerListener)this.__f.sentinel.previous).__m;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ldf;)V"
   )
   @Export("__o_170")
   void __o_170(PcmStreamMixerListener var1) {
      var1.remove();
      var1.remove2();
      Node var2 = this.__f.sentinel.previous;
      if(var2 == this.__f.sentinel) {
         this.__o = -1;
      } else {
         this.__o = ((PcmStreamMixerListener)var2).__m;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "()Ldc;"
   )
   @Export("firstSubStream")
   protected PcmStream firstSubStream() {
      return (PcmStream)this.subStreams.last();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Ldc;"
   )
   @Export("nextSubStream")
   protected PcmStream nextSubStream() {
      return (PcmStream)this.subStreams.previous();
   }

   @ObfuscatedName("l")
   @Export("__l_171")
   protected int __l_171() {
      return 0;
   }

   @ObfuscatedName("e")
   @Export("__e_172")
   public final synchronized void __e_172(int[] var1, int var2, int var3) {
      do {
         if(this.__o < 0) {
            this.updateSubStreams(var1, var2, var3);
            return;
         }

         if(var3 + this.__q < this.__o) {
            this.__q += var3;
            this.updateSubStreams(var1, var2, var3);
            return;
         }

         int var4 = this.__o - this.__q;
         this.updateSubStreams(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.__q += var4;
         this.__q_168();
         PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.__f.last();
         synchronized(var5) {
            int var7 = var5.update();
            if(var7 < 0) {
               var5.__m = 0;
               this.__o_170(var5);
            } else {
               var5.__m = var7;
               this.__w_169(var5.previous, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("x")
   @Export("updateSubStreams")
   void updateSubStreams(int[] var1, int var2, int var3) {
      for(PcmStream var4 = (PcmStream)this.subStreams.last(); var4 != null; var4 = (PcmStream)this.subStreams.previous()) {
         var4.update(var1, var2, var3);
      }

   }

   @ObfuscatedName("d")
   @Export("__d_173")
   public final synchronized void __d_173(int var1) {
      do {
         if(this.__o < 0) {
            this.skipSubStreams(var1);
            return;
         }

         if(this.__q + var1 < this.__o) {
            this.__q += var1;
            this.skipSubStreams(var1);
            return;
         }

         int var2 = this.__o - this.__q;
         this.skipSubStreams(var2);
         var1 -= var2;
         this.__q += var2;
         this.__q_168();
         PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.__f.last();
         synchronized(var3) {
            int var5 = var3.update();
            if(var5 < 0) {
               var3.__m = 0;
               this.__o_170(var3);
            } else {
               var3.__m = var5;
               this.__w_169(var3.previous, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("a")
   @Export("skipSubStreams")
   void skipSubStreams(int var1) {
      for(PcmStream var2 = (PcmStream)this.subStreams.last(); var2 != null; var2 = (PcmStream)this.subStreams.previous()) {
         var2.__d_173(var1);
      }

   }
}
