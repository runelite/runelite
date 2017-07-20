import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public class class107 extends class122 {
   @ObfuscatedName("o")
   public byte[] field1576;
   @ObfuscatedName("c")
   public int field1579;
   @ObfuscatedName("g")
   public boolean field1575;
   @ObfuscatedName("i")
   public int field1577;
   @ObfuscatedName("u")
   int field1578;

   class107(int var1, byte[] var2, int var3, int var4) {
      this.field1579 = var1;
      this.field1576 = var2;
      this.field1577 = var3;
      this.field1578 = var4;
   }

   class107(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1579 = var1;
      this.field1576 = var2;
      this.field1577 = var3;
      this.field1578 = var4;
      this.field1575 = var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ldy;)Ldm;"
   )
   public class107 method1913(class116 var1) {
      this.field1576 = var1.method2043(this.field1576);
      this.field1579 = var1.method2044(this.field1579);
      if(this.field1577 == this.field1578) {
         this.field1577 = this.field1578 = var1.method2046(this.field1577);
      } else {
         this.field1577 = var1.method2046(this.field1577);
         this.field1578 = var1.method2046(this.field1578);
         if(this.field1577 == this.field1578) {
            --this.field1577;
         }
      }

      return this;
   }
}
