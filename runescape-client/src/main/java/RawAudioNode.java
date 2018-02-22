import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("RawAudioNode")
public class RawAudioNode extends AbstractIntegerNode0 {
   @ObfuscatedName("b")
   @Export("sampleRate")
   public int sampleRate;
   @ObfuscatedName("q")
   @Export("audioBuffer")
   public byte[] audioBuffer;
   @ObfuscatedName("o")
   @Export("startPosition")
   public int startPosition;
   @ObfuscatedName("p")
   @Export("endPosition")
   int endPosition;
   @ObfuscatedName("a")
   public boolean field1497;

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
      this.field1497 = var5;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ldl;)Ldb;"
   )
   @Export("applyResampler")
   public RawAudioNode applyResampler(Resampler var1) {
      this.audioBuffer = var1.resampleIfNecessary(this.audioBuffer);
      this.sampleRate = var1.method2297(this.sampleRate);
      if(this.startPosition == this.endPosition) {
         this.startPosition = this.endPosition = var1.method2294(this.startPosition);
      } else {
         this.startPosition = var1.method2294(this.startPosition);
         this.endPosition = var1.method2294(this.endPosition);
         if(this.startPosition == this.endPosition) {
            --this.startPosition;
         }
      }

      return this;
   }
}
