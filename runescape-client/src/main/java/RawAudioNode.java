import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
@Implements("RawAudioNode")
public class RawAudioNode extends AbstractIntegerNode0 {
   @ObfuscatedName("t")
   @Export("sampleRate")
   public int sampleRate;
   @ObfuscatedName("q")
   @Export("audioBuffer")
   public byte[] audioBuffer;
   @ObfuscatedName("i")
   @Export("startPosition")
   public int startPosition;
   @ObfuscatedName("a")
   @Export("endPosition")
   int endPosition;
   @ObfuscatedName("l")
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ldt;)Ldp;"
   )
   @Export("applyResampler")
   public RawAudioNode applyResampler(Resampler var1) {
      this.audioBuffer = var1.resampleIfNecessary(this.audioBuffer);
      this.sampleRate = var1.method2312(this.sampleRate);
      if(this.startPosition == this.endPosition) {
         this.startPosition = this.endPosition = var1.method2309(this.startPosition);
      } else {
         this.startPosition = var1.method2309(this.startPosition);
         this.endPosition = var1.method2309(this.endPosition);
         if(this.startPosition == this.endPosition) {
            --this.startPosition;
         }
      }

      return this;
   }
}
