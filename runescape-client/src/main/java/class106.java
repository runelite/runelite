import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class106 extends class121 {
   @ObfuscatedName("m")
   public int field1528;
   @ObfuscatedName("p")
   public byte[] field1527;
   @ObfuscatedName("i")
   public int field1529;
   @ObfuscatedName("j")
   int field1530;
   @ObfuscatedName("v")
   public boolean field1531;

   class106(int var1, byte[] var2, int var3, int var4) {
      this.field1528 = var1;
      this.field1527 = var2;
      this.field1529 = var3;
      this.field1530 = var4;
   }

   class106(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1528 = var1;
      this.field1527 = var2;
      this.field1529 = var3;
      this.field1530 = var4;
      this.field1531 = var5;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ldf;)Lde;"
   )
   public class106 method2080(class115 var1) {
      this.field1527 = var1.method2203(this.field1527);
      this.field1528 = var1.method2202(this.field1528);
      if(this.field1529 == this.field1530) {
         this.field1529 = this.field1530 = var1.method2208(this.field1529);
      } else {
         this.field1529 = var1.method2208(this.field1529);
         this.field1530 = var1.method2208(this.field1530);
         if(this.field1529 == this.field1530) {
            --this.field1529;
         }
      }

      return this;
   }
}
