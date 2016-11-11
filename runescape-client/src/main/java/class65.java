import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bd")
public class class65 extends class68 {
   @ObfuscatedName("n")
   public boolean field1284;
   @ObfuscatedName("i")
   public int field1285;
   @ObfuscatedName("e")
   public int field1286;
   @ObfuscatedName("g")
   int field1287;
   @ObfuscatedName("h")
   public byte[] field1288;

   class65(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1285 = var1;
      this.field1288 = var2;
      this.field1286 = var3;
      this.field1287 = var4;
      this.field1284 = var5;
   }

   @ObfuscatedName("i")
   public class65 method1325(class77 var1) {
      this.field1288 = var1.method1630(this.field1288);
      this.field1285 = var1.method1631(this.field1285);
      if(this.field1286 == this.field1287) {
         this.field1286 = this.field1287 = var1.method1632(this.field1286);
      } else {
         this.field1286 = var1.method1632(this.field1286);
         this.field1287 = var1.method1632(this.field1287);
         if(this.field1286 == this.field1287) {
            --this.field1286;
         }
      }

      return this;
   }

   class65(int var1, byte[] var2, int var3, int var4) {
      this.field1285 = var1;
      this.field1288 = var2;
      this.field1286 = var3;
      this.field1287 = var4;
   }
}
