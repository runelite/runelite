import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dv")
@Implements("SoundEffect2")
public class SoundEffect2 {
   @ObfuscatedName("i")
   int field1639;
   @ObfuscatedName("u")
   int[] field1640;
   @ObfuscatedName("l")
   int field1641;
   @ObfuscatedName("q")
   int field1642;
   @ObfuscatedName("g")
   int field1643;
   @ObfuscatedName("v")
   int field1644;
   @ObfuscatedName("t")
   int field1645;
   @ObfuscatedName("p")
   int field1646;
   @ObfuscatedName("a")
   int field1647;
   @ObfuscatedName("k")
   int field1648;
   @ObfuscatedName("h")
   int[] field1649;

   @ObfuscatedName("i")
   final void method2103(Buffer var1) {
      this.field1644 = var1.readUnsignedByte();
      this.field1642 = var1.readInt();
      this.field1643 = var1.readInt();
      this.method2104(var1);
   }

   @ObfuscatedName("h")
   final void method2104(Buffer var1) {
      this.field1639 = var1.readUnsignedByte();
      this.field1649 = new int[this.field1639];
      this.field1640 = new int[this.field1639];

      for(int var2 = 0; var2 < this.field1639; ++var2) {
         this.field1649[var2] = var1.readUnsignedShort();
         this.field1640[var2] = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("u")
   final void method2105() {
      this.field1645 = 0;
      this.field1646 = 0;
      this.field1641 = 0;
      this.field1647 = 0;
      this.field1648 = 0;
   }

   SoundEffect2() {
      this.field1639 = 2;
      this.field1649 = new int[2];
      this.field1640 = new int[2];
      this.field1649[0] = 0;
      this.field1649[1] = '\uffff';
      this.field1640[0] = 0;
      this.field1640[1] = '\uffff';
   }

   @ObfuscatedName("q")
   final int method2111(int var1) {
      if(this.field1648 >= this.field1645) {
         this.field1647 = this.field1640[this.field1646++] << 15;
         if(this.field1646 >= this.field1639) {
            this.field1646 = this.field1639 - 1;
         }

         this.field1645 = (int)((double)this.field1649[this.field1646] / 65536.0D * (double)var1);
         if(this.field1645 > this.field1648) {
            this.field1641 = ((this.field1640[this.field1646] << 15) - this.field1647) / (this.field1645 - this.field1648);
         }
      }

      this.field1647 += this.field1641;
      ++this.field1648;
      return this.field1647 - this.field1641 >> 15;
   }
}
