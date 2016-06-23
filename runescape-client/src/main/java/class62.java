import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("be")
public class class62 extends class65 {
   @ObfuscatedName("x")
   public int field1246;
   @ObfuscatedName("u")
   public byte[] field1247;
   @ObfuscatedName("f")
   public int field1248;
   @ObfuscatedName("b")
   int field1249;
   @ObfuscatedName("l")
   public boolean field1250;

   @ObfuscatedName("f")
   public class62 method1340(class74 var1) {
      this.field1247 = var1.method1649(this.field1247);
      this.field1248 = var1.method1651(this.field1248);
      if(this.field1246 == this.field1249) {
         this.field1246 = this.field1249 = var1.method1650(this.field1246);
      } else {
         this.field1246 = var1.method1650(this.field1246);
         this.field1249 = var1.method1650(this.field1249);
         if(this.field1246 == this.field1249) {
            --this.field1246;
         }
      }

      return this;
   }

   class62(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1248 = var1;
      this.field1247 = var2;
      this.field1246 = var3;
      this.field1249 = var4;
      this.field1250 = var5;
   }

   class62(int var1, byte[] var2, int var3, int var4) {
      this.field1248 = var1;
      this.field1247 = var2;
      this.field1246 = var3;
      this.field1249 = var4;
   }
}
