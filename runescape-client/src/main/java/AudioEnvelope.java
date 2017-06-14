import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dd")
@Implements("AudioEnvelope")
public class AudioEnvelope {
   @ObfuscatedName("h")
   @Export("step")
   int step;
   @ObfuscatedName("p")
   int[] field1656;
   @ObfuscatedName("i")
   @Export("phases")
   int[] phases;
   @ObfuscatedName("j")
   @Export("start")
   int start;
   @ObfuscatedName("f")
   @Export("end")
   int end;
   @ObfuscatedName("m")
   int field1660;
   @ObfuscatedName("c")
   @Export("ticks")
   int ticks;
   @ObfuscatedName("n")
   int field1662;
   @ObfuscatedName("z")
   @Export("phaseIndex")
   int phaseIndex;
   @ObfuscatedName("g")
   @Export("amplitude")
   int amplitude;
   @ObfuscatedName("e")
   @Export("max")
   int max;

   @ObfuscatedName("n")
   final void method2060(Buffer var1) {
      this.field1660 = var1.readUnsignedByte();
      this.start = var1.readInt();
      this.end = var1.readInt();
      this.method2061(var1);
   }

   @ObfuscatedName("p")
   final void method2061(Buffer var1) {
      this.field1662 = var1.readUnsignedByte();
      this.field1656 = new int[this.field1662];
      this.phases = new int[this.field1662];

      for(int var2 = 0; var2 < this.field1662; ++var2) {
         this.field1656[var2] = var1.readUnsignedShort();
         this.phases[var2] = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("i")
   final void method2062() {
      this.ticks = 0;
      this.phaseIndex = 0;
      this.step = 0;
      this.amplitude = 0;
      this.max = 0;
   }

   @ObfuscatedName("j")
   final int method2063(int var1) {
      if(this.max >= this.ticks) {
         this.amplitude = this.phases[this.phaseIndex++] << 15;
         if(this.phaseIndex >= this.field1662) {
            this.phaseIndex = this.field1662 - 1;
         }

         this.ticks = (int)((double)this.field1656[this.phaseIndex] / 65536.0D * (double)var1);
         if(this.ticks > this.max) {
            this.step = ((this.phases[this.phaseIndex] << 15) - this.amplitude) / (this.ticks - this.max);
         }
      }

      this.amplitude += this.step;
      ++this.max;
      return this.amplitude - this.step >> 15;
   }

   AudioEnvelope() {
      this.field1662 = 2;
      this.field1656 = new int[2];
      this.phases = new int[2];
      this.field1656[0] = 0;
      this.field1656[1] = '\uffff';
      this.phases[0] = 0;
      this.phases[1] = '\uffff';
   }
}
