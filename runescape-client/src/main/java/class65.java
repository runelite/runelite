import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bs")
public class class65 extends class68 {
   @ObfuscatedName("p")
   public boolean field1272;
   @ObfuscatedName("z")
   public byte[] field1273;
   @ObfuscatedName("t")
   public int field1274;
   @ObfuscatedName("y")
   int field1275;
   @ObfuscatedName("s")
   public int field1276;

   class65(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1276 = var1;
      this.field1273 = var2;
      this.field1274 = var3;
      this.field1275 = var4;
      this.field1272 = var5;
   }

   @ObfuscatedName("s")
   public class65 method1288(class77 var1) {
      this.field1273 = var1.method1601(this.field1273);
      this.field1276 = var1.method1602(this.field1276);
      if(this.field1274 == this.field1275) {
         this.field1274 = this.field1275 = var1.method1603(this.field1274);
      } else {
         this.field1274 = var1.method1603(this.field1274);
         this.field1275 = var1.method1603(this.field1275);
         if(this.field1274 == this.field1275) {
            --this.field1274;
         }
      }

      return this;
   }

   class65(int var1, byte[] var2, int var3, int var4) {
      this.field1276 = var1;
      this.field1273 = var2;
      this.field1274 = var3;
      this.field1275 = var4;
   }
}
