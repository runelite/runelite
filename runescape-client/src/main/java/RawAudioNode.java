import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
@Implements("RawAudioNode")
public class RawAudioNode extends AbstractIntegerNode0 {
   @ObfuscatedName("s")
   @Export("sampleRate")
   public int sampleRate;
   @ObfuscatedName("g")
   @Export("audioBuffer")
   public byte[] audioBuffer;
   @ObfuscatedName("m")
   @Export("startPosition")
   public int startPosition;
   @ObfuscatedName("h")
   @Export("endPosition")
   int endPosition;
   @ObfuscatedName("i")
   public boolean field1528;

   RawAudioNode(int var1, byte[] var2, int var3, int var4) {
      this.sampleRate = var1;
      this.audioBuffer = var2;
      this.startPosition = var3;
      this.endPosition = var4;
   }

   RawAudioNode(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.sampleRate = var1;
      this.audioBuffer = var2;
      this.startPosition = var3;
      this.endPosition = var4;
      this.field1528 = var5;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ldg;)Ldz;"
   )
   @Export("applyResampler")
   public RawAudioNode applyResampler(Resampler var1) {
      this.audioBuffer = var1.resampleIfNecessary(this.audioBuffer);
      this.sampleRate = var1.method2377(this.sampleRate);
      if(this.startPosition == this.endPosition) {
         this.startPosition = this.endPosition = var1.method2366(this.startPosition);
      } else {
         this.startPosition = var1.method2366(this.startPosition);
         this.endPosition = var1.method2366(this.endPosition);
         if(this.startPosition == this.endPosition) {
            --this.startPosition;
         }
      }

      return this;
   }
}
