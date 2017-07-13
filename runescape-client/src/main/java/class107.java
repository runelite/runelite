import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dm")
public class class107 extends class122 {
   @ObfuscatedName("j")
   public byte[] field1607;
   @ObfuscatedName("a")
   public int field1603;
   @ObfuscatedName("v")
   public boolean field1604;
   @ObfuscatedName("n")
   public int field1605;
   @ObfuscatedName("r")
   int field1606;

   class107(int var1, byte[] var2, int var3, int var4) {
      this.field1603 = var1;
      this.field1607 = var2;
      this.field1605 = var3;
      this.field1606 = var4;
   }

   class107(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1603 = var1;
      this.field1607 = var2;
      this.field1605 = var3;
      this.field1606 = var4;
      this.field1604 = var5;
   }

   @ObfuscatedName("a")
   public class107 method1955(class116 var1) {
      this.field1607 = var1.method2092(this.field1607);
      this.field1603 = var1.method2100(this.field1603);
      if(this.field1605 == this.field1606) {
         this.field1605 = this.field1606 = var1.method2093(this.field1605);
      } else {
         this.field1605 = var1.method2093(this.field1605);
         this.field1606 = var1.method2093(this.field1606);
         if(this.field1605 == this.field1606) {
            --this.field1605;
         }
      }

      return this;
   }
}
