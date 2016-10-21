import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bu")
public class class65 extends class68 {
   @ObfuscatedName("n")
   public int field1277;
   @ObfuscatedName("e")
   public byte[] field1278;
   @ObfuscatedName("f")
   public int field1279;
   @ObfuscatedName("t")
   int field1280;
   @ObfuscatedName("v")
   public boolean field1281;

   class65(int var1, byte[] var2, int var3, int var4) {
      this.field1279 = var1;
      this.field1278 = var2;
      this.field1277 = var3;
      this.field1280 = var4;
   }

   class65(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1279 = var1;
      this.field1278 = var2;
      this.field1277 = var3;
      this.field1280 = var4;
      this.field1281 = var5;
   }

   @ObfuscatedName("f")
   public class65 method1331(class77 var1) {
      this.field1278 = var1.method1647(this.field1278);
      this.field1279 = var1.method1648(this.field1279);
      if(this.field1277 == this.field1280) {
         this.field1277 = this.field1280 = var1.method1646(this.field1277);
      } else {
         this.field1277 = var1.method1646(this.field1277);
         this.field1280 = var1.method1646(this.field1280);
         if(this.field1277 == this.field1280) {
            --this.field1277;
         }
      }

      return this;
   }
}
