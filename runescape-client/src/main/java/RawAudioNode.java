import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
@Implements("RawAudioNode")
public class RawAudioNode extends AbstractIntegerNode0 {
   @ObfuscatedName("g")
   @Export("sampleRate")
   public int sampleRate;
   @ObfuscatedName("e")
   @Export("audioBuffer")
   public byte[] audioBuffer;
   @ObfuscatedName("b")
   @Export("startPosition")
   public int startPosition;
   @ObfuscatedName("z")
   @Export("endPosition")
   int endPosition;
   @ObfuscatedName("n")
   public boolean field1522;

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
      this.field1522 = var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lde;)Ldt;"
   )
   @Export("applyResampler")
   public RawAudioNode applyResampler(Resampler var1) {
      this.audioBuffer = var1.resampleIfNecessary(this.audioBuffer);
      this.sampleRate = var1.method2392(this.sampleRate);
      if(this.startPosition == this.endPosition) {
         this.startPosition = this.endPosition = var1.method2388(this.startPosition);
      } else {
         this.startPosition = var1.method2388(this.startPosition);
         this.endPosition = var1.method2388(this.endPosition);
         if(this.startPosition == this.endPosition) {
            --this.startPosition;
         }
      }

      return this;
   }
}
