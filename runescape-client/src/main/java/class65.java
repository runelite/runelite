import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("be")
public class class65 extends class68 {
   @ObfuscatedName("c")
   int field1289;
   @ObfuscatedName("k")
   public int field1290;
   @ObfuscatedName("f")
   public int field1291;
   @ObfuscatedName("q")
   public byte[] field1292;
   @ObfuscatedName("v")
   public boolean field1293;

   class65(int var1, byte[] var2, int var3, int var4) {
      this.field1290 = var1;
      this.field1292 = var2;
      this.field1291 = var3;
      this.field1289 = var4;
   }

   class65(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1290 = var1;
      this.field1292 = var2;
      this.field1291 = var3;
      this.field1289 = var4;
      this.field1293 = var5;
   }

   @ObfuscatedName("k")
   public class65 method1322(class77 var1) {
      this.field1292 = var1.method1653(this.field1292);
      this.field1290 = var1.method1646(this.field1290);
      if(this.field1291 == this.field1289) {
         this.field1291 = this.field1289 = var1.method1648(this.field1291);
      } else {
         this.field1291 = var1.method1648(this.field1291);
         this.field1289 = var1.method1648(this.field1289);
         if(this.field1291 == this.field1289) {
            --this.field1291;
         }
      }

      return this;
   }
}
