import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("be")
public class class55 extends class71 {
   @ObfuscatedName("a")
   int field1014;
   @ObfuscatedName("x")
   public byte[] field1015;
   @ObfuscatedName("i")
   public int field1016;
   @ObfuscatedName("u")
   public int field1017;
   @ObfuscatedName("f")
   public boolean field1018;

   class55(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1017 = var1;
      this.field1015 = var2;
      this.field1016 = var3;
      this.field1014 = var4;
      this.field1018 = var5;
   }

   @ObfuscatedName("u")
   public class55 method994(class65 var1) {
      this.field1015 = var1.method1115(this.field1015);
      this.field1017 = var1.method1116(this.field1017);
      if(this.field1016 == this.field1014) {
         this.field1016 = this.field1014 = var1.method1117(this.field1016);
      } else {
         this.field1016 = var1.method1117(this.field1016);
         this.field1014 = var1.method1117(this.field1014);
         if(this.field1016 == this.field1014) {
            --this.field1016;
         }
      }

      return this;
   }

   class55(int var1, byte[] var2, int var3, int var4) {
      this.field1017 = var1;
      this.field1015 = var2;
      this.field1016 = var3;
      this.field1014 = var4;
   }
}
