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
   @Export("__hq_qg")
   static int __hq_qg;
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
   @Export("__m_379")
   void __m_379(MusicPatchNode var1, int[] var2, int var3, int var4, int var5) {
      if((this.superStream.__y[var1.__m] & 4) != 0 && var1.__a < 0) {
         int var6 = this.superStream.__p[var1.__m] / class309.PcmPlayer_sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.__b) / var6;
            if(var7 > var4) {
               var1.__b += var4 * var6;
               break;
            }

            var1.stream.__e_172(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.__b += var7 * var6 - 1048576;
            int var8 = class309.PcmPlayer_sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            RawPcmStream var10 = var1.stream;
            if(this.superStream.__c[var1.__m] == 0) {
               var1.stream = RawPcmStream.method2524(var1.rawSound, var10.__ab_194(), var10.__s_185(), var10.__t_186());
            } else {
               var1.stream = RawPcmStream.method2524(var1.rawSound, var10.__ab_194(), 0, var10.__t_186());
               this.superStream.__h_346(var1, var1.patch.__q[var1.__u] < 0);
               var1.stream.__c_190(var8, var10.__s_185());
            }

            if(var1.patch.__q[var1.__u] < 0) {
               var1.stream.__x_181(-1);
            }

            var10.__v_192(var8);
            var10.__e_172(var2, var3, var5 - var3);
            if(var10.__at_196()) {
               this.mixer.addSubStream(var10);
            }
         }
      }

      var1.stream.__e_172(var2, var3, var4);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lha;II)V",
      garbageValue = "1882591412"
   )
   @Export("__f_380")
   void __f_380(MusicPatchNode var1, int var2) {
      if((this.superStream.__y[var1.__m] & 4) != 0 && var1.__a < 0) {
         int var3 = this.superStream.__p[var1.__m] / class309.PcmPlayer_sampleRate;
         int var4 = (var3 + 1048575 - var1.__b) / var3;
         var1.__b = var3 * var2 + var1.__b & 1048575;
         if(var4 <= var2) {
            if(this.superStream.__c[var1.__m] == 0) {
               var1.stream = RawPcmStream.method2524(var1.rawSound, var1.stream.__ab_194(), var1.stream.__s_185(), var1.stream.__t_186());
            } else {
               var1.stream = RawPcmStream.method2524(var1.rawSound, var1.stream.__ab_194(), 0, var1.stream.__t_186());
               this.superStream.__h_346(var1, var1.patch.__q[var1.__u] < 0);
            }

            if(var1.patch.__q[var1.__u] < 0) {
               var1.stream.__x_181(-1);
            }

            var2 = var1.__b / var3;
         }
      }

      var1.stream.__d_173(var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "()Ldc;"
   )
   protected PcmStream firstSubStream() {
      MusicPatchNode var1 = (MusicPatchNode)this.queue.last();
      return (PcmStream)(var1 == null?null:(var1.stream != null?var1.stream:this.nextSubStream()));
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Ldc;"
   )
   protected PcmStream nextSubStream() {
      MusicPatchNode var1;
      do {
         var1 = (MusicPatchNode)this.queue.previous();
         if(var1 == null) {
            return null;
         }
      } while(var1.stream == null);

      return var1.stream;
   }

   @ObfuscatedName("l")
   protected int __l_171() {
      return 0;
   }

   @ObfuscatedName("e")
   protected void __e_172(int[] var1, int var2, int var3) {
      this.mixer.__e_172(var1, var2, var3);

      for(MusicPatchNode var6 = (MusicPatchNode)this.queue.last(); var6 != null; var6 = (MusicPatchNode)this.queue.previous()) {
         if(!this.superStream.__ba_368(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.__y) {
                  this.__m_379(var6, var1, var4, var5, var5 + var4);
                  var6.__y -= var5;
                  break;
               }

               this.__m_379(var6, var1, var4, var6.__y, var5 + var4);
               var4 += var6.__y;
               var5 -= var6.__y;
            } while(!this.superStream.__bb_369(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("d")
   protected void __d_173(int var1) {
      this.mixer.__d_173(var1);

      for(MusicPatchNode var3 = (MusicPatchNode)this.queue.last(); var3 != null; var3 = (MusicPatchNode)this.queue.previous()) {
         if(!this.superStream.__ba_368(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.__y) {
                  this.__f_380(var3, var2);
                  var3.__y -= var2;
                  break;
               }

               this.__f_380(var3, var3.__y);
               var2 -= var3.__y;
            } while(!this.superStream.__bb_369(var3, (int[])null, 0, var2));
         }
      }

   }
}
