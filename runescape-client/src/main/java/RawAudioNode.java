import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("RawAudioNode")
public class RawAudioNode extends AbstractIntegerNode0 {
   @ObfuscatedName("d")
   @Export("sampleRate")
   public int sampleRate;
   @ObfuscatedName("z")
   @Export("audioBuffer")
   public byte[] audioBuffer;
   @ObfuscatedName("n")
   @Export("startPosition")
   public int startPosition;
   @ObfuscatedName("r")
   @Export("endPosition")
   int endPosition;
   @ObfuscatedName("e")
   public boolean field1535;

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
      this.field1535 = var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ldn;)Ldd;"
   )
   @Export("applyResampler")
   public RawAudioNode applyResampler(Resampler var1) {
      this.audioBuffer = var1.resampleIfNecessary(this.audioBuffer);
      this.sampleRate = var1.method2350(this.sampleRate);
      if(this.startPosition == this.endPosition) {
         this.startPosition = this.endPosition = var1.method2351(this.startPosition);
      } else {
         this.startPosition = var1.method2351(this.startPosition);
         this.endPosition = var1.method2351(this.endPosition);
         if(this.startPosition == this.endPosition) {
            --this.startPosition;
         }
      }

      return this;
   }
}
