import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
public class class105 extends class120 {
   @ObfuscatedName("s")
   public byte[] field1600;
   @ObfuscatedName("w")
   public int field1602;
   @ObfuscatedName("g")
   public boolean field1603;
   @ObfuscatedName("q")
   public int field1599;
   @ObfuscatedName("o")
   int field1601;

   class105(int var1, byte[] var2, int var3, int var4) {
      this.field1602 = var1;
      this.field1600 = var2;
      this.field1599 = var3;
      this.field1601 = var4;
   }

   class105(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1602 = var1;
      this.field1600 = var2;
      this.field1599 = var3;
      this.field1601 = var4;
      this.field1603 = var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ldx;)Ldi;"
   )
   public class105 method2026(class114 var1) {
      this.field1600 = var1.method2156(this.field1600);
      this.field1602 = var1.method2157(this.field1602);
      if(this.field1599 == this.field1601) {
         this.field1599 = this.field1601 = var1.method2160(this.field1599);
      } else {
         this.field1599 = var1.method2160(this.field1599);
         this.field1601 = var1.method2160(this.field1601);
         if(this.field1599 == this.field1601) {
            --this.field1599;
         }
      }

      return this;
   }
}
