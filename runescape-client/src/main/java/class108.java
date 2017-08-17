import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class108 extends class123 {
   @ObfuscatedName("h")
   public byte[] field1618;
   @ObfuscatedName("j")
   public int field1615;
   @ObfuscatedName("x")
   public boolean field1617;
   @ObfuscatedName("f")
   public int field1616;
   @ObfuscatedName("p")
   int field1614;

   class108(int var1, byte[] var2, int var3, int var4) {
      this.field1615 = var1;
      this.field1618 = var2;
      this.field1616 = var3;
      this.field1614 = var4;
   }

   class108(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1615 = var1;
      this.field1618 = var2;
      this.field1616 = var3;
      this.field1614 = var4;
      this.field1617 = var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ldj;)Lde;"
   )
   public class108 method2005(class117 var1) {
      this.field1618 = var1.method2137(this.field1618);
      this.field1615 = var1.method2129(this.field1615);
      if(this.field1616 == this.field1614) {
         this.field1616 = this.field1614 = var1.method2130(this.field1616);
      } else {
         this.field1616 = var1.method2130(this.field1616);
         this.field1614 = var1.method2130(this.field1614);
         if(this.field1616 == this.field1614) {
            --this.field1616;
         }
      }

      return this;
   }
}
