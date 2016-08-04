import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bz")
public class class65 extends class68 {
   @ObfuscatedName("r")
   public int field1301;
   @ObfuscatedName("l")
   public int field1302;
   @ObfuscatedName("e")
   int field1303;
   @ObfuscatedName("g")
   public byte[] field1304;
   @ObfuscatedName("h")
   public boolean field1305;

   class65(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1302 = var1;
      this.field1304 = var2;
      this.field1301 = var3;
      this.field1303 = var4;
      this.field1305 = var5;
   }

   @ObfuscatedName("l")
   public class65 method1407(class77 var1) {
      this.field1304 = var1.method1699(this.field1304);
      this.field1302 = var1.method1700(this.field1302);
      if(this.field1301 == this.field1303) {
         this.field1301 = this.field1303 = var1.method1701(this.field1301);
      } else {
         this.field1301 = var1.method1701(this.field1301);
         this.field1303 = var1.method1701(this.field1303);
         if(this.field1301 == this.field1303) {
            --this.field1301;
         }
      }

      return this;
   }

   class65(int var1, byte[] var2, int var3, int var4) {
      this.field1302 = var1;
      this.field1304 = var2;
      this.field1301 = var3;
      this.field1303 = var4;
   }
}
