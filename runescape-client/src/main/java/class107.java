import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("di")
public class class107 extends class122 {
   @ObfuscatedName("c")
   public byte[] field1620;
   @ObfuscatedName("e")
   public int field1621;
   @ObfuscatedName("i")
   public int field1622;
   @ObfuscatedName("v")
   int field1623;
   @ObfuscatedName("b")
   public boolean field1624;

   class107(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1622 = var1;
      this.field1620 = var2;
      this.field1621 = var3;
      this.field1623 = var4;
      this.field1624 = var5;
   }

   @ObfuscatedName("i")
   public class107 method1982(class116 var1) {
      this.field1620 = var1.method2092(this.field1620);
      this.field1622 = var1.method2091(this.field1622);
      if(this.field1621 == this.field1623) {
         this.field1621 = this.field1623 = var1.method2094(this.field1621);
      } else {
         this.field1621 = var1.method2094(this.field1621);
         this.field1623 = var1.method2094(this.field1623);
         if(this.field1621 == this.field1623) {
            --this.field1621;
         }
      }

      return this;
   }

   class107(int var1, byte[] var2, int var3, int var4) {
      this.field1622 = var1;
      this.field1620 = var2;
      this.field1621 = var3;
      this.field1623 = var4;
   }
}
