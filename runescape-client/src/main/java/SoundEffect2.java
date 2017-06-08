import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dd")
@Implements("SoundEffect2")
public class SoundEffect2 {
   @ObfuscatedName("h")
   int field1655;
   @ObfuscatedName("p")
   int[] field1656;
   @ObfuscatedName("i")
   int[] field1657;
   @ObfuscatedName("j")
   int field1658;
   @ObfuscatedName("f")
   int field1659;
   @ObfuscatedName("m")
   int field1660;
   @ObfuscatedName("c")
   int field1661;
   @ObfuscatedName("n")
   int field1662;
   @ObfuscatedName("z")
   int field1663;
   @ObfuscatedName("g")
   int field1664;
   @ObfuscatedName("e")
   int field1665;

   @ObfuscatedName("n")
   final void method2060(Buffer var1) {
      this.field1660 = var1.readUnsignedByte();
      this.field1658 = var1.readInt();
      this.field1659 = var1.readInt();
      this.method2061(var1);
   }

   @ObfuscatedName("p")
   final void method2061(Buffer var1) {
      this.field1662 = var1.readUnsignedByte();
      this.field1656 = new int[this.field1662];
      this.field1657 = new int[this.field1662];

      for(int var2 = 0; var2 < this.field1662; ++var2) {
         this.field1656[var2] = var1.readUnsignedShort();
         this.field1657[var2] = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("i")
   final void method2062() {
      this.field1661 = 0;
      this.field1663 = 0;
      this.field1655 = 0;
      this.field1664 = 0;
      this.field1665 = 0;
   }

   @ObfuscatedName("j")
   final int method2063(int var1) {
      if(this.field1665 >= this.field1661) {
         this.field1664 = this.field1657[this.field1663++] << 15;
         if(this.field1663 >= this.field1662) {
            this.field1663 = this.field1662 - 1;
         }

         this.field1661 = (int)((double)this.field1656[this.field1663] / 65536.0D * (double)var1);
         if(this.field1661 > this.field1665) {
            this.field1655 = ((this.field1657[this.field1663] << 15) - this.field1664) / (this.field1661 - this.field1665);
         }
      }

      this.field1664 += this.field1655;
      ++this.field1665;
      return this.field1664 - this.field1655 >> 15;
   }

   SoundEffect2() {
      this.field1662 = 2;
      this.field1656 = new int[2];
      this.field1657 = new int[2];
      this.field1656[0] = 0;
      this.field1656[1] = '\uffff';
      this.field1657[0] = 0;
      this.field1657[1] = '\uffff';
   }
}
