import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("RawAudioNode")
public class RawAudioNode extends AbstractIntegerNode0 {
   @ObfuscatedName("w")
   @Export("sampleRate")
   public int sampleRate;
   @ObfuscatedName("m")
   @Export("audioBuffer")
   public byte[] audioBuffer;
   @ObfuscatedName("q")
   @Export("startPosition")
   public int startPosition;
   @ObfuscatedName("b")
   @Export("endPosition")
   int endPosition;
   @ObfuscatedName("f")
   public boolean field1304;

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
      this.field1304 = var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lcx;)Lcg;"
   )
   @Export("applyResampler")
   public RawAudioNode applyResampler(Resampler var1) {
      this.audioBuffer = var1.resampleIfNecessary(this.audioBuffer);
      this.sampleRate = var1.method2309(this.sampleRate);
      if(this.startPosition == this.endPosition) {
         this.startPosition = this.endPosition = var1.method2306(this.startPosition);
      } else {
         this.startPosition = var1.method2306(this.startPosition);
         this.endPosition = var1.method2306(this.endPosition);
         if(this.startPosition == this.endPosition) {
            --this.startPosition;
         }
      }

      return this;
   }
}
