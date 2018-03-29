import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
@Implements("RawAudioNode")
public class RawAudioNode extends AbstractIntegerNode0 {
   @ObfuscatedName("c")
   @Export("sampleRate")
   public int sampleRate;
   @ObfuscatedName("i")
   @Export("audioBuffer")
   public byte[] audioBuffer;
   @ObfuscatedName("o")
   @Export("startPosition")
   public int startPosition;
   @ObfuscatedName("j")
   @Export("endPosition")
   int endPosition;
   @ObfuscatedName("k")
   public boolean field1539;

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
      this.field1539 = var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lds;)Lda;"
   )
   @Export("applyResampler")
   public RawAudioNode applyResampler(Resampler var1) {
      this.audioBuffer = var1.resampleIfNecessary(this.audioBuffer);
      this.sampleRate = var1.method2286(this.sampleRate);
      if(this.startPosition == this.endPosition) {
         this.startPosition = this.endPosition = var1.method2290(this.startPosition);
      } else {
         this.startPosition = var1.method2290(this.startPosition);
         this.endPosition = var1.method2290(this.endPosition);
         if(this.startPosition == this.endPosition) {
            --this.startPosition;
         }
      }

      return this;
   }
}
