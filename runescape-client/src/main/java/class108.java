import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public class class108 extends class123 {
   @ObfuscatedName("n")
   public byte[] field1600;
   @ObfuscatedName("e")
   public int field1601;
   @ObfuscatedName("w")
   public boolean field1603;
   @ObfuscatedName("g")
   public int field1602;
   @ObfuscatedName("y")
   int field1599;

   class108(int var1, byte[] var2, int var3, int var4) {
      this.field1601 = var1;
      this.field1600 = var2;
      this.field1602 = var3;
      this.field1599 = var4;
   }

   class108(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1601 = var1;
      this.field1600 = var2;
      this.field1602 = var3;
      this.field1599 = var4;
      this.field1603 = var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ldu;)Ldb;"
   )
   public class108 method2011(class117 var1) {
      this.field1600 = var1.method2131(this.field1600);
      this.field1601 = var1.method2132(this.field1601);
      if(this.field1602 == this.field1599) {
         this.field1602 = this.field1599 = var1.method2133(this.field1602);
      } else {
         this.field1602 = var1.method2133(this.field1602);
         this.field1599 = var1.method2133(this.field1599);
         if(this.field1602 == this.field1599) {
            --this.field1602;
         }
      }

      return this;
   }
}
