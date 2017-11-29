import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class106 extends AbstractIntegerNode0 {
   @ObfuscatedName("d")
   public int field1531;
   @ObfuscatedName("x")
   public byte[] field1527;
   @ObfuscatedName("k")
   public int field1529;
   @ObfuscatedName("z")
   int field1528;
   @ObfuscatedName("v")
   public boolean field1530;

   class106(int var1, byte[] var2, int var3, int var4) {
      this.field1531 = var1;
      this.field1527 = var2;
      this.field1529 = var3;
      this.field1528 = var4;
   }

   class106(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1531 = var1;
      this.field1527 = var2;
      this.field1529 = var3;
      this.field1528 = var4;
      this.field1530 = var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ldh;)Lda;"
   )
   public class106 method2066(class115 var1) {
      this.field1527 = var1.method2211(this.field1527);
      this.field1531 = var1.method2212(this.field1531);
      if(this.field1529 == this.field1528) {
         this.field1529 = this.field1528 = var1.method2210(this.field1529);
      } else {
         this.field1529 = var1.method2210(this.field1529);
         this.field1528 = var1.method2210(this.field1528);
         if(this.field1529 == this.field1528) {
            --this.field1529;
         }
      }

      return this;
   }
}
