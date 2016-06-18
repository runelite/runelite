import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bh")
public class class62 extends class65 {
   @ObfuscatedName("g")
   public byte[] field1198;
   @ObfuscatedName("b")
   public int field1199;
   @ObfuscatedName("j")
   public int field1200;
   @ObfuscatedName("d")
   int field1201;
   @ObfuscatedName("x")
   public boolean field1202;

   @ObfuscatedName("b")
   public class62 method1286(class74 var1) {
      this.field1198 = var1.method1618(this.field1198);
      this.field1199 = var1.method1617(this.field1199);
      if(this.field1200 == this.field1201) {
         this.field1200 = this.field1201 = var1.method1625(this.field1200);
      } else {
         this.field1200 = var1.method1625(this.field1200);
         this.field1201 = var1.method1625(this.field1201);
         if(this.field1200 == this.field1201) {
            --this.field1200;
         }
      }

      return this;
   }

   class62(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1199 = var1;
      this.field1198 = var2;
      this.field1200 = var3;
      this.field1201 = var4;
      this.field1202 = var5;
   }

   class62(int var1, byte[] var2, int var3, int var4) {
      this.field1199 = var1;
      this.field1198 = var2;
      this.field1200 = var3;
      this.field1201 = var4;
   }
}
