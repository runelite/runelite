import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dk")
@Implements("AudioEnvelope")
public class AudioEnvelope {
   @ObfuscatedName("k")
   @Export("step")
   int step;
   @ObfuscatedName("w")
   int[] field1668;
   @ObfuscatedName("s")
   @Export("end")
   int end;
   @ObfuscatedName("t")
   @Export("start")
   int start;
   @ObfuscatedName("i")
   int field1671;
   @ObfuscatedName("r")
   int field1672;
   @ObfuscatedName("v")
   @Export("ticks")
   int ticks;
   @ObfuscatedName("j")
   @Export("phaseIndex")
   int phaseIndex;
   @ObfuscatedName("a")
   @Export("phases")
   int[] phases;
   @ObfuscatedName("e")
   @Export("amplitude")
   int amplitude;
   @ObfuscatedName("y")
   @Export("max")
   int max;

   @ObfuscatedName("i")
   final void method2066(Buffer var1) {
      this.field1672 = var1.readUnsignedByte();
      this.start = var1.readInt();
      this.end = var1.readInt();
      this.method2067(var1);
   }

   @ObfuscatedName("w")
   final void method2067(Buffer var1) {
      this.field1671 = var1.readUnsignedByte();
      this.field1668 = new int[this.field1671];
      this.phases = new int[this.field1671];

      for(int var2 = 0; var2 < this.field1671; ++var2) {
         this.field1668[var2] = var1.readUnsignedShort();
         this.phases[var2] = var1.readUnsignedShort();
      }

   }

   AudioEnvelope() {
      this.field1671 = 2;
      this.field1668 = new int[2];
      this.phases = new int[2];
      this.field1668[0] = 0;
      this.field1668[1] = '\uffff';
      this.phases[0] = 0;
      this.phases[1] = '\uffff';
   }

   @ObfuscatedName("t")
   final int method2068(int var1) {
      if(this.max >= this.ticks) {
         this.amplitude = this.phases[this.phaseIndex++] << 15;
         if(this.phaseIndex >= this.field1671) {
            this.phaseIndex = this.field1671 - 1;
         }

         this.ticks = (int)((double)this.field1668[this.phaseIndex] / 65536.0D * (double)var1);
         if(this.ticks > this.max) {
            this.step = ((this.phases[this.phaseIndex] << 15) - this.amplitude) / (this.ticks - this.max);
         }
      }

      this.amplitude += this.step;
      ++this.max;
      return this.amplitude - this.step >> 15;
   }

   @ObfuscatedName("a")
   final void method2079() {
      this.ticks = 0;
      this.phaseIndex = 0;
      this.step = 0;
      this.amplitude = 0;
      this.max = 0;
   }
}
