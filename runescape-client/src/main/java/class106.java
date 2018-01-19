import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public class class106 extends AbstractIntegerNode0 {
   @ObfuscatedName("n")
   public int field1523;
   @ObfuscatedName("v")
   public byte[] field1522;
   @ObfuscatedName("y")
   public int field1521;
   @ObfuscatedName("r")
   int field1524;
   @ObfuscatedName("h")
   public boolean field1525;

   class106(int var1, byte[] var2, int var3, int var4) {
      this.field1523 = var1;
      this.field1522 = var2;
      this.field1521 = var3;
      this.field1524 = var4;
   }

   class106(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1523 = var1;
      this.field1522 = var2;
      this.field1521 = var3;
      this.field1524 = var4;
      this.field1525 = var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ldc;)Ldp;"
   )
   public class106 method2030(class115 var1) {
      this.field1522 = var1.method2167(this.field1522);
      this.field1523 = var1.method2163(this.field1523);
      if(this.field1521 == this.field1524) {
         this.field1521 = this.field1524 = var1.method2162(this.field1521);
      } else {
         this.field1521 = var1.method2162(this.field1521);
         this.field1524 = var1.method2162(this.field1524);
         if(this.field1521 == this.field1524) {
            --this.field1521;
         }
      }

      return this;
   }
}
