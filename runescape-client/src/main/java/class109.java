import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public class class109 extends class124 {
   @ObfuscatedName("q")
   public byte[] field1598;
   @ObfuscatedName("d")
   public int field1599;
   @ObfuscatedName("e")
   public boolean field1601;
   @ObfuscatedName("x")
   public int field1597;
   @ObfuscatedName("y")
   int field1600;

   class109(int var1, byte[] var2, int var3, int var4) {
      this.field1599 = var1;
      this.field1598 = var2;
      this.field1597 = var3;
      this.field1600 = var4;
   }

   class109(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1599 = var1;
      this.field1598 = var2;
      this.field1597 = var3;
      this.field1600 = var4;
      this.field1601 = var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lde;)Ldv;"
   )
   public class109 method2049(class118 var1) {
      this.field1598 = var1.method2180(this.field1598);
      this.field1599 = var1.method2181(this.field1599);
      if(this.field1597 == this.field1600) {
         this.field1597 = this.field1600 = var1.method2188(this.field1597);
      } else {
         this.field1597 = var1.method2188(this.field1597);
         this.field1600 = var1.method2188(this.field1600);
         if(this.field1597 == this.field1600) {
            --this.field1597;
         }
      }

      return this;
   }
}
