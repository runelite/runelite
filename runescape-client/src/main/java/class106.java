import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public class class106 extends class121 {
   @ObfuscatedName("j")
   public byte[] field1616;
   @ObfuscatedName("i")
   public int field1618;
   @ObfuscatedName("o")
   public boolean field1619;
   @ObfuscatedName("a")
   public int field1617;
   @ObfuscatedName("r")
   int field1615;

   class106(int var1, byte[] var2, int var3, int var4) {
      this.field1618 = var1;
      this.field1616 = var2;
      this.field1617 = var3;
      this.field1615 = var4;
   }

   class106(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1618 = var1;
      this.field1616 = var2;
      this.field1617 = var3;
      this.field1615 = var4;
      this.field1619 = var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ldi;)Ldp;"
   )
   public class106 method1984(class115 var1) {
      this.field1616 = var1.method2114(this.field1616);
      this.field1618 = var1.method2124(this.field1618);
      if(this.field1617 == this.field1615) {
         this.field1617 = this.field1615 = var1.method2116(this.field1617);
      } else {
         this.field1617 = var1.method2116(this.field1617);
         this.field1615 = var1.method2116(this.field1615);
         if(this.field1617 == this.field1615) {
            --this.field1617;
         }
      }

      return this;
   }
}
