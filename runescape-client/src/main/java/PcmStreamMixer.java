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
   NodeDeque field690;
   @ObfuscatedName("q")
   int field691;
   @ObfuscatedName("o")
   int field692;

   public PcmStreamMixer() {
      this.subStreams = new NodeDeque();
      this.field690 = new NodeDeque();
      this.field691 = 0;
      this.field692 = -1;
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
   void method248() {
      if (this.field691 > 0) {
         for (PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.field690.last(); var1 != null; var1 = (PcmStreamMixerListener)this.field690.previous()) {
            var1.field693 -= this.field691;
         }

         this.field692 -= this.field691;
         this.field691 = 0;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgw;Ldf;)V"
   )
   void method249(Node var1, PcmStreamMixerListener var2) {
      while (this.field690.sentinel != var1 && ((PcmStreamMixerListener)var1).field693 <= var2.field693) {
         var1 = var1.previous;
      }

      NodeDeque.NodeDeque_addBefore(var2, var1);
      this.field692 = ((PcmStreamMixerListener)this.field690.sentinel.previous).field693;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ldf;)V"
   )
   void method250(PcmStreamMixerListener var1) {
      var1.remove();
      var1.remove2();
      Node var2 = this.field690.sentinel.previous;
      if (var2 == this.field690.sentinel) {
         this.field692 = -1;
      } else {
         this.field692 = ((PcmStreamMixerListener)var2).field693;
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
   protected int vmethod262() {
      return 0;
   }

   @ObfuscatedName("e")
   public final synchronized void vmethod263(int[] var1, int var2, int var3) {
      do {
         if (this.field692 < 0) {
            this.updateSubStreams(var1, var2, var3);
            return;
         }

         if (var3 + this.field691 < this.field692) {
            this.field691 += var3;
            this.updateSubStreams(var1, var2, var3);
            return;
         }

         int var4 = this.field692 - this.field691;
         this.updateSubStreams(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field691 += var4;
         this.method248();
         PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.field690.last();
         synchronized(var5) {
            int var7 = var5.update();
            if (var7 < 0) {
               var5.field693 = 0;
               this.method250(var5);
            } else {
               var5.field693 = var7;
               this.method249(var5.previous, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("x")
   @Export("updateSubStreams")
   void updateSubStreams(int[] var1, int var2, int var3) {
      for (PcmStream var4 = (PcmStream)this.subStreams.last(); var4 != null; var4 = (PcmStream)this.subStreams.previous()) {
         var4.update(var1, var2, var3);
      }

   }

   @ObfuscatedName("d")
   public final synchronized void vmethod264(int var1) {
      do {
         if (this.field692 < 0) {
            this.skipSubStreams(var1);
            return;
         }

         if (this.field691 + var1 < this.field692) {
            this.field691 += var1;
            this.skipSubStreams(var1);
            return;
         }

         int var2 = this.field692 - this.field691;
         this.skipSubStreams(var2);
         var1 -= var2;
         this.field691 += var2;
         this.method248();
         PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.field690.last();
         synchronized(var3) {
            int var5 = var3.update();
            if (var5 < 0) {
               var3.field693 = 0;
               this.method250(var3);
            } else {
               var3.field693 = var5;
               this.method249(var3.previous, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("a")
   @Export("skipSubStreams")
   void skipSubStreams(int var1) {
      for (PcmStream var2 = (PcmStream)this.subStreams.last(); var2 != null; var2 = (PcmStream)this.subStreams.previous()) {
         var2.vmethod264(var1);
      }

   }
}
