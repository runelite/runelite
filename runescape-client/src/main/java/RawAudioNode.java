import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
@Implements("RawAudioNode")
public class RawAudioNode extends AbstractIntegerNode0 {
   @ObfuscatedName("n")
   @Export("sampleRate")
   public int sampleRate;
   @ObfuscatedName("v")
   @Export("audioBuffer")
   public byte[] audioBuffer;
   @ObfuscatedName("y")
   @Export("startPosition")
   public int startPosition;
   @ObfuscatedName("r")
   @Export("endPosition")
   int endPosition;
   @ObfuscatedName("h")
   public boolean field1525;

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
      this.field1525 = var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ldc;)Ldp;"
   )
   @Export("applyResampler")
   public RawAudioNode applyResampler(Resampler var1) {
      this.audioBuffer = var1.resampleIfNecessary(this.audioBuffer);
      this.sampleRate = var1.convertSampleLocation(this.sampleRate);
      if(this.startPosition == this.endPosition) {
         this.startPosition = this.endPosition = var1.convertSampleLocationPlusSix(this.startPosition);
      } else {
         this.startPosition = var1.convertSampleLocationPlusSix(this.startPosition);
         this.endPosition = var1.convertSampleLocationPlusSix(this.endPosition);
         if(this.startPosition == this.endPosition) {
            --this.startPosition;
         }
      }

      return this;
   }
}
