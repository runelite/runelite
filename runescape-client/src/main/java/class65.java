import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bx")
public class class65 extends class68 {
   @ObfuscatedName("z")
   public boolean field1302;
   @ObfuscatedName("a")
   public int field1303;
   @ObfuscatedName("v")
   public int field1304;
   @ObfuscatedName("d")
   public byte[] field1305;
   @ObfuscatedName("r")
   int field1306;

   class65(int var1, byte[] var2, int var3, int var4) {
      this.field1303 = var1;
      this.field1305 = var2;
      this.field1304 = var3;
      this.field1306 = var4;
   }

   class65(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1303 = var1;
      this.field1305 = var2;
      this.field1304 = var3;
      this.field1306 = var4;
      this.field1302 = var5;
   }

   @ObfuscatedName("a")
   public class65 method1330(class77 var1) {
      this.field1305 = var1.method1634(this.field1305);
      this.field1303 = var1.method1635(this.field1303);
      if(this.field1304 == this.field1306) {
         this.field1304 = this.field1306 = var1.method1636(this.field1304);
      } else {
         this.field1304 = var1.method1636(this.field1304);
         this.field1306 = var1.method1636(this.field1306);
         if(this.field1304 == this.field1306) {
            --this.field1304;
         }
      }

      return this;
   }
}
