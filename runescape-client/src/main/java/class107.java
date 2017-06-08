import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dh")
public class class107 extends class122 {
   @ObfuscatedName("j")
   int field1612;
   @ObfuscatedName("p")
   public byte[] field1613;
   @ObfuscatedName("i")
   public int field1614;
   @ObfuscatedName("n")
   public int field1615;
   @ObfuscatedName("f")
   public boolean field1616;

   class107(int var1, byte[] var2, int var3, int var4) {
      this.field1615 = var1;
      this.field1613 = var2;
      this.field1614 = var3;
      this.field1612 = var4;
   }

   class107(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1615 = var1;
      this.field1613 = var2;
      this.field1614 = var3;
      this.field1612 = var4;
      this.field1616 = var5;
   }

   @ObfuscatedName("n")
   public class107 method1958(class116 var1) {
      this.field1613 = var1.method2106(this.field1613);
      this.field1615 = var1.method2107(this.field1615);
      if(this.field1614 == this.field1612) {
         this.field1614 = this.field1612 = var1.method2108(this.field1614);
      } else {
         this.field1614 = var1.method2108(this.field1614);
         this.field1612 = var1.method2108(this.field1612);
         if(this.field1614 == this.field1612) {
            --this.field1614;
         }
      }

      return this;
   }
}
