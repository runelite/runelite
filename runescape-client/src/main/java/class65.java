import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bf")
public class class65 extends class68 {
   @ObfuscatedName("r")
   public boolean field1300;
   @ObfuscatedName("e")
   public int field1301;
   @ObfuscatedName("c")
   public int field1302;
   @ObfuscatedName("h")
   int field1303;
   @ObfuscatedName("l")
   public byte[] field1304;

   class65(int var1, byte[] var2, int var3, int var4) {
      this.field1301 = var1;
      this.field1304 = var2;
      this.field1302 = var3;
      this.field1303 = var4;
   }

   class65(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1301 = var1;
      this.field1304 = var2;
      this.field1302 = var3;
      this.field1303 = var4;
      this.field1300 = var5;
   }

   @ObfuscatedName("e")
   public class65 method1381(class77 var1) {
      this.field1304 = var1.method1685(this.field1304);
      this.field1301 = var1.method1691(this.field1301);
      if(this.field1302 == this.field1303) {
         this.field1302 = this.field1303 = var1.method1686(this.field1302);
      } else {
         this.field1302 = var1.method1686(this.field1302);
         this.field1303 = var1.method1686(this.field1303);
         if(this.field1302 == this.field1303) {
            --this.field1302;
         }
      }

      return this;
   }
}
