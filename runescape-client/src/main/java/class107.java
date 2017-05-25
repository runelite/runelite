import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dx")
public class class107 extends class122 {
   @ObfuscatedName("g")
   public boolean field1601;
   @ObfuscatedName("h")
   public byte[] field1602;
   @ObfuscatedName("u")
   public int field1603;
   @ObfuscatedName("q")
   int field1604;
   @ObfuscatedName("i")
   public int field1605;

   class107(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1605 = var1;
      this.field1602 = var2;
      this.field1603 = var3;
      this.field1604 = var4;
      this.field1601 = var5;
   }

   @ObfuscatedName("i")
   public class107 method2017(class116 var1) {
      this.field1602 = var1.method2144(this.field1602);
      this.field1605 = var1.method2145(this.field1605);
      if(this.field1603 == this.field1604) {
         this.field1603 = this.field1604 = var1.method2146(this.field1603);
      } else {
         this.field1603 = var1.method2146(this.field1603);
         this.field1604 = var1.method2146(this.field1604);
         if(this.field1603 == this.field1604) {
            --this.field1603;
         }
      }

      return this;
   }

   class107(int var1, byte[] var2, int var3, int var4) {
      this.field1605 = var1;
      this.field1602 = var2;
      this.field1603 = var3;
      this.field1604 = var4;
   }
}
