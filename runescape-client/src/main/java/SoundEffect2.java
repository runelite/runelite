import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dd")
@Implements("SoundEffect2")
public class SoundEffect2 {
   @ObfuscatedName("i")
   int field1663;
   @ObfuscatedName("v")
   int field1664;
   @ObfuscatedName("f")
   int field1665;
   @ObfuscatedName("n")
   int field1666;
   @ObfuscatedName("b")
   int field1667;
   @ObfuscatedName("h")
   int field1668;
   @ObfuscatedName("c")
   int[] field1669;
   @ObfuscatedName("e")
   int[] field1670;
   @ObfuscatedName("a")
   int field1671;
   @ObfuscatedName("o")
   int field1672;
   @ObfuscatedName("y")
   int field1673;

   @ObfuscatedName("i")
   final void method2059(Buffer var1) {
      this.field1668 = var1.readUnsignedByte();
      this.field1664 = var1.readInt();
      this.field1667 = var1.readInt();
      this.method2061(var1);
   }

   @ObfuscatedName("e")
   final void method2060() {
      this.field1665 = 0;
      this.field1666 = 0;
      this.field1671 = 0;
      this.field1672 = 0;
      this.field1673 = 0;
   }

   SoundEffect2() {
      this.field1663 = 2;
      this.field1669 = new int[2];
      this.field1670 = new int[2];
      this.field1669[0] = 0;
      this.field1669[1] = '\uffff';
      this.field1670[0] = 0;
      this.field1670[1] = '\uffff';
   }

   @ObfuscatedName("c")
   final void method2061(Buffer var1) {
      this.field1663 = var1.readUnsignedByte();
      this.field1669 = new int[this.field1663];
      this.field1670 = new int[this.field1663];

      for(int var2 = 0; var2 < this.field1663; ++var2) {
         this.field1669[var2] = var1.readUnsignedShort();
         this.field1670[var2] = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("v")
   final int method2062(int var1) {
      if(this.field1673 >= this.field1665) {
         this.field1672 = this.field1670[this.field1666++] << 15;
         if(this.field1666 >= this.field1663) {
            this.field1666 = this.field1663 - 1;
         }

         this.field1665 = (int)((double)this.field1669[this.field1666] / 65536.0D * (double)var1);
         if(this.field1665 > this.field1673) {
            this.field1671 = ((this.field1670[this.field1666] << 15) - this.field1672) / (this.field1665 - this.field1673);
         }
      }

      this.field1672 += this.field1671;
      ++this.field1673;
      return this.field1672 - this.field1671 >> 15;
   }
}
