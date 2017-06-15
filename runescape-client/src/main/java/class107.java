import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dc")
public class class107 extends class122 {
   @ObfuscatedName("p")
   public int field1604;
   @ObfuscatedName("m")
   public byte[] field1605;
   @ObfuscatedName("e")
   public int field1606;
   @ObfuscatedName("t")
   int field1607;
   @ObfuscatedName("w")
   public boolean field1608;

   class107(int var1, byte[] var2, int var3, int var4) {
      this.field1604 = var1;
      this.field1605 = var2;
      this.field1606 = var3;
      this.field1607 = var4;
   }

   class107(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1604 = var1;
      this.field1605 = var2;
      this.field1606 = var3;
      this.field1607 = var4;
      this.field1608 = var5;
   }

   @ObfuscatedName("p")
   public class107 method1881(class116 var1) {
      this.field1605 = var1.method2018(this.field1605);
      this.field1604 = var1.method2017(this.field1604);
      if(this.field1606 == this.field1607) {
         this.field1606 = this.field1607 = var1.method2019(this.field1606);
      } else {
         this.field1606 = var1.method2019(this.field1606);
         this.field1607 = var1.method2019(this.field1607);
         if(this.field1606 == this.field1607) {
            --this.field1606;
         }
      }

      return this;
   }
}
