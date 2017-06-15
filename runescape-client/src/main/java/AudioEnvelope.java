import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("di")
@Implements("AudioEnvelope")
public class AudioEnvelope {
   @ObfuscatedName("i")
   @Export("phaseIndex")
   int phaseIndex;
   @ObfuscatedName("m")
   int[] field1648;
   @ObfuscatedName("e")
   @Export("phases")
   int[] phases;
   @ObfuscatedName("z")
   int field1650;
   @ObfuscatedName("w")
   @Export("end")
   int end;
   @ObfuscatedName("t")
   @Export("start")
   int start;
   @ObfuscatedName("j")
   @Export("ticks")
   int ticks;
   @ObfuscatedName("p")
   int field1654;
   @ObfuscatedName("f")
   @Export("step")
   int step;
   @ObfuscatedName("c")
   @Export("amplitude")
   int amplitude;
   @ObfuscatedName("o")
   @Export("max")
   int max;

   @ObfuscatedName("p")
   final void method1972(Buffer var1) {
      this.field1650 = var1.readUnsignedByte();
      this.start = var1.readInt();
      this.end = var1.readInt();
      this.method1981(var1);
   }

   @ObfuscatedName("e")
   final void method1974() {
      this.ticks = 0;
      this.phaseIndex = 0;
      this.step = 0;
      this.amplitude = 0;
      this.max = 0;
   }

   @ObfuscatedName("t")
   final int method1975(int var1) {
      if(this.max >= this.ticks) {
         this.amplitude = this.phases[this.phaseIndex++] << 15;
         if(this.phaseIndex >= this.field1654) {
            this.phaseIndex = this.field1654 - 1;
         }

         this.ticks = (int)((double)this.field1648[this.phaseIndex] / 65536.0D * (double)var1);
         if(this.ticks > this.max) {
            this.step = ((this.phases[this.phaseIndex] << 15) - this.amplitude) / (this.ticks - this.max);
         }
      }

      this.amplitude += this.step;
      ++this.max;
      return this.amplitude - this.step >> 15;
   }

   AudioEnvelope() {
      this.field1654 = 2;
      this.field1648 = new int[2];
      this.phases = new int[2];
      this.field1648[0] = 0;
      this.field1648[1] = '\uffff';
      this.phases[0] = 0;
      this.phases[1] = '\uffff';
   }

   @ObfuscatedName("m")
   final void method1981(Buffer var1) {
      this.field1654 = var1.readUnsignedByte();
      this.field1648 = new int[this.field1654];
      this.phases = new int[this.field1654];

      for(int var2 = 0; var2 < this.field1654; ++var2) {
         this.field1648[var2] = var1.readUnsignedShort();
         this.phases[var2] = var1.readUnsignedShort();
      }

   }
}
