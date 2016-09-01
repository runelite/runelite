import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bn")
public class class65 extends class68 {
   @ObfuscatedName("i")
   public boolean field1274;
   @ObfuscatedName("r")
   public byte[] field1275;
   @ObfuscatedName("j")
   public int field1276;
   @ObfuscatedName("x")
   public int field1277;
   @ObfuscatedName("z")
   int field1278;

   @ObfuscatedName("x")
   public class65 method1322(class77 var1) {
      this.field1275 = var1.method1625(this.field1275);
      this.field1277 = var1.method1638(this.field1277);
      if(this.field1276 == this.field1278) {
         this.field1276 = this.field1278 = var1.method1629(this.field1276);
      } else {
         this.field1276 = var1.method1629(this.field1276);
         this.field1278 = var1.method1629(this.field1278);
         if(this.field1276 == this.field1278) {
            --this.field1276;
         }
      }

      return this;
   }

   class65(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1277 = var1;
      this.field1275 = var2;
      this.field1276 = var3;
      this.field1278 = var4;
      this.field1274 = var5;
   }

   class65(int var1, byte[] var2, int var3, int var4) {
      this.field1277 = var1;
      this.field1275 = var2;
      this.field1276 = var3;
      this.field1278 = var4;
   }
}
