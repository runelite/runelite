import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bm")
public class class62 extends class65 {
   @ObfuscatedName("t")
   public int field1236;
   @ObfuscatedName("w")
   public int field1237;
   @ObfuscatedName("x")
   public byte[] field1238;
   @ObfuscatedName("p")
   int field1239;
   @ObfuscatedName("e")
   public boolean field1240;

   class62(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1237 = var1;
      this.field1238 = var2;
      this.field1236 = var3;
      this.field1239 = var4;
      this.field1240 = var5;
   }

   @ObfuscatedName("w")
   public class62 method1295(class74 var1) {
      this.field1238 = var1.method1587(this.field1238);
      this.field1237 = var1.method1588(this.field1237);
      if(this.field1236 == this.field1239) {
         this.field1236 = this.field1239 = var1.method1589(this.field1236);
      } else {
         this.field1236 = var1.method1589(this.field1236);
         this.field1239 = var1.method1589(this.field1239);
         if(this.field1236 == this.field1239) {
            --this.field1236;
         }
      }

      return this;
   }

   class62(int var1, byte[] var2, int var3, int var4) {
      this.field1237 = var1;
      this.field1238 = var2;
      this.field1236 = var3;
      this.field1239 = var4;
   }
}
