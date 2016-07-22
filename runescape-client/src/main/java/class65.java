import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bn")
public class class65 extends class68 {
   @ObfuscatedName("g")
   public boolean field1304;
   @ObfuscatedName("w")
   public byte[] field1305;
   @ObfuscatedName("m")
   public int field1306;
   @ObfuscatedName("o")
   int field1307;
   @ObfuscatedName("e")
   public int field1308;

   class65(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1306 = var1;
      this.field1305 = var2;
      this.field1308 = var3;
      this.field1307 = var4;
      this.field1304 = var5;
   }

   class65(int var1, byte[] var2, int var3, int var4) {
      this.field1306 = var1;
      this.field1305 = var2;
      this.field1308 = var3;
      this.field1307 = var4;
   }

   @ObfuscatedName("m")
   public class65 method1365(class77 var1) {
      this.field1305 = var1.method1680(this.field1305);
      this.field1306 = var1.method1681(this.field1306);
      if(this.field1308 == this.field1307) {
         this.field1308 = this.field1307 = var1.method1685(this.field1308);
      } else {
         this.field1308 = var1.method1685(this.field1308);
         this.field1307 = var1.method1685(this.field1307);
         if(this.field1308 == this.field1307) {
            --this.field1308;
         }
      }

      return this;
   }
}
