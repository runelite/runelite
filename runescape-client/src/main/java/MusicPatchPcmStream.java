import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
@Implements("MusicPatchPcmStream")
public class MusicPatchPcmStream extends PcmStream {
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = -1367955455
   )
   static int field602;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   @Export("superStream")
   MidiPcmStream superStream;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   @Export("queue")
   NodeDeque queue;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lct;"
   )
   @Export("mixer")
   PcmStreamMixer mixer;

   @ObfuscatedSignature(
      signature = "(Lhm;)V"
   )
   MusicPatchPcmStream(MidiPcmStream var1) {
      this.queue = new NodeDeque();
      this.mixer = new PcmStreamMixer();
      this.superStream = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lha;[IIIII)V",
      garbageValue = "1988628167"
   )
   void method220(MusicPatchNode var1, int[] var2, int var3, int var4, int var5) {
      if ((this.superStream.field506[var1.field574] & 4) != 0 && var1.field586 < 0) {
         int var6 = this.superStream.field511[var1.field574] / class309.PcmPlayer_sampleRate;

         while (true) {
            int var7 = (var6 + 1048575 - var1.field591) / var6;
            if (var7 > var4) {
               var1.field591 += var4 * var6;
               break;
            }

            var1.stream.vmethod263(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field591 += var7 * var6 - 1048576;
            int var8 = class309.PcmPlayer_sampleRate / 100;
            int var9 = 262144 / var6;
            if (var9 < var8) {
               var8 = var9;
            }

            RawPcmStream var10 = var1.stream;
            if (this.superStream.field509[var1.field574] == 0) {
               var1.stream = RawPcmStream.method2524(var1.rawSound, var10.method277(), var10.method268(), var10.method269());
            } else {
               var1.stream = RawPcmStream.method2524(var1.rawSound, var10.method277(), 0, var10.method269());
               this.superStream.method178(var1, var1.patch.field568[var1.field577] < 0);
               var1.stream.method273(var8, var10.method268());
            }

            if (var1.patch.field568[var1.field577] < 0) {
               var1.stream.setNumLoops(-1);
            }

            var10.method275(var8);
            var10.vmethod263(var2, var3, var5 - var3);
            if (var10.method279()) {
               this.mixer.addSubStream(var10);
            }
         }
      }

      var1.stream.vmethod263(var2, var3, var4);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lha;II)V",
      garbageValue = "1882591412"
   )
   void method221(MusicPatchNode var1, int var2) {
      if ((this.superStream.field506[var1.field574] & 4) != 0 && var1.field586 < 0) {
         int var3 = this.superStream.field511[var1.field574] / class309.PcmPlayer_sampleRate;
         int var4 = (var3 + 1048575 - var1.field591) / var3;
         var1.field591 = var3 * var2 + var1.field591 & 1048575;
         if (var4 <= var2) {
            if (this.superStream.field509[var1.field574] == 0) {
               var1.stream = RawPcmStream.method2524(var1.rawSound, var1.stream.method277(), var1.stream.method268(), var1.stream.method269());
            } else {
               var1.stream = RawPcmStream.method2524(var1.rawSound, var1.stream.method277(), 0, var1.stream.method269());
               this.superStream.method178(var1, var1.patch.field568[var1.field577] < 0);
            }

            if (var1.patch.field568[var1.field577] < 0) {
               var1.stream.setNumLoops(-1);
            }

            var2 = var1.field591 / var3;
         }
      }

      var1.stream.vmethod264(var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "()Ldc;"
   )
   @Export("firstSubStream")
   protected PcmStream firstSubStream() {
      MusicPatchNode var1 = (MusicPatchNode)this.queue.last();
      return (PcmStream)(var1 == null ? null : (var1.stream != null ? var1.stream : this.nextSubStream()));
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Ldc;"
   )
   @Export("nextSubStream")
   protected PcmStream nextSubStream() {
      MusicPatchNode var1;
      do {
         var1 = (MusicPatchNode)this.queue.previous();
         if (var1 == null) {
            return null;
         }
      } while(var1.stream == null);

      return var1.stream;
   }

   @ObfuscatedName("l")
   protected int vmethod262() {
      return 0;
   }

   @ObfuscatedName("e")
   protected void vmethod263(int[] var1, int var2, int var3) {
      this.mixer.vmethod263(var1, var2, var3);

      for (MusicPatchNode var4 = (MusicPatchNode)this.queue.last(); var4 != null; var4 = (MusicPatchNode)this.queue.previous()) {
         if (!this.superStream.method195(var4)) {
            int var5 = var2;
            int var6 = var3;

            do {
               if (var6 <= var4.field590) {
                  this.method220(var4, var1, var5, var6, var6 + var5);
                  var4.field590 -= var6;
                  break;
               }

               this.method220(var4, var1, var5, var4.field590, var6 + var5);
               var5 += var4.field590;
               var6 -= var4.field590;
            } while(!this.superStream.method196(var4, var1, var5, var6));
         }
      }

   }

   @ObfuscatedName("d")
   protected void vmethod264(int var1) {
      this.mixer.vmethod264(var1);

      for (MusicPatchNode var2 = (MusicPatchNode)this.queue.last(); var2 != null; var2 = (MusicPatchNode)this.queue.previous()) {
         if (!this.superStream.method195(var2)) {
            int var3 = var1;

            do {
               if (var3 <= var2.field590) {
                  this.method221(var2, var3);
                  var2.field590 -= var3;
                  break;
               }

               this.method221(var2, var2.field590);
               var3 -= var2.field590;
            } while(!this.superStream.method196(var2, (int[])null, 0, var3));
         }
      }

   }
}
