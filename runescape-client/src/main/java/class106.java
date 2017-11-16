import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public class class106 extends class121 {
   @ObfuscatedName("b")
   public int field1522;
   @ObfuscatedName("s")
   public byte[] field1519;
   @ObfuscatedName("r")
   public int field1520;
   @ObfuscatedName("g")
   int field1521;
   @ObfuscatedName("x")
   public boolean field1518;

   class106(int var1, byte[] var2, int var3, int var4) {
      this.field1522 = var1;
      this.field1519 = var2;
      this.field1520 = var3;
      this.field1521 = var4;
   }

   class106(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1522 = var1;
      this.field1519 = var2;
      this.field1520 = var3;
      this.field1521 = var4;
      this.field1518 = var5;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ldu;)Ldn;"
   )
   public class106 method1991(class115 var1) {
      this.field1519 = var1.method2121(this.field1519);
      this.field1522 = var1.method2119(this.field1522);
      if(this.field1520 == this.field1521) {
         this.field1520 = this.field1521 = var1.method2120(this.field1520);
      } else {
         this.field1520 = var1.method2120(this.field1520);
         this.field1521 = var1.method2120(this.field1521);
         if(this.field1520 == this.field1521) {
            --this.field1520;
         }
      }

      return this;
   }
}
