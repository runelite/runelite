import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public class class106 extends AbstractIntegerNode0 {
   @ObfuscatedName("a")
   public int field1511;
   @ObfuscatedName("w")
   public byte[] field1509;
   @ObfuscatedName("e")
   public int field1510;
   @ObfuscatedName("k")
   int field1508;
   @ObfuscatedName("u")
   public boolean field1512;

   class106(int var1, byte[] var2, int var3, int var4) {
      this.field1511 = var1;
      this.field1509 = var2;
      this.field1510 = var3;
      this.field1508 = var4;
   }

   class106(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1511 = var1;
      this.field1509 = var2;
      this.field1510 = var3;
      this.field1508 = var4;
      this.field1512 = var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ldz;)Ldx;"
   )
   public class106 method1979(class115 var1) {
      this.field1509 = var1.method2097(this.field1509);
      this.field1511 = var1.method2104(this.field1511);
      if(this.field1510 == this.field1508) {
         this.field1510 = this.field1508 = var1.method2099(this.field1510);
      } else {
         this.field1510 = var1.method2099(this.field1510);
         this.field1508 = var1.method2099(this.field1508);
         if(this.field1510 == this.field1508) {
            --this.field1510;
         }
      }

      return this;
   }
}
