import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dx")
public class class107 extends class122 {
   @ObfuscatedName("w")
   public byte[] field1630;
   @ObfuscatedName("i")
   public int field1633;
   @ObfuscatedName("s")
   public boolean field1632;
   @ObfuscatedName("a")
   public int field1629;
   @ObfuscatedName("t")
   int field1631;

   class107(int var1, byte[] var2, int var3, int var4) {
      this.field1633 = var1;
      this.field1630 = var2;
      this.field1629 = var3;
      this.field1631 = var4;
   }

   class107(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1633 = var1;
      this.field1630 = var2;
      this.field1629 = var3;
      this.field1631 = var4;
      this.field1632 = var5;
   }

   @ObfuscatedName("i")
   public class107 method1989(class116 var1) {
      this.field1630 = var1.method2115(this.field1630);
      this.field1633 = var1.method2113(this.field1633);
      if(this.field1629 == this.field1631) {
         this.field1629 = this.field1631 = var1.method2111(this.field1629);
      } else {
         this.field1629 = var1.method2111(this.field1629);
         this.field1631 = var1.method2111(this.field1631);
         if(this.field1629 == this.field1631) {
            --this.field1629;
         }
      }

      return this;
   }
}
