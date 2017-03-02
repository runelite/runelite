import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bl")
public class class55 extends class71 {
   @ObfuscatedName("t")
   int field1008;
   @ObfuscatedName("l")
   public byte[] field1009;
   @ObfuscatedName("i")
   public int field1010;
   @ObfuscatedName("b")
   public int field1011;
   @ObfuscatedName("k")
   public boolean field1012;

   class55(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1011 = var1;
      this.field1009 = var2;
      this.field1010 = var3;
      this.field1008 = var4;
      this.field1012 = var5;
   }

   class55(int var1, byte[] var2, int var3, int var4) {
      this.field1011 = var1;
      this.field1009 = var2;
      this.field1010 = var3;
      this.field1008 = var4;
   }

   @ObfuscatedName("b")
   public class55 method1087(class65 var1) {
      this.field1009 = var1.method1222(this.field1009);
      this.field1011 = var1.method1223(this.field1011);
      if(this.field1010 == this.field1008) {
         this.field1010 = this.field1008 = var1.method1229(this.field1010);
      } else {
         this.field1010 = var1.method1229(this.field1010);
         this.field1008 = var1.method1229(this.field1008);
         if(this.field1010 == this.field1008) {
            --this.field1010;
         }
      }

      return this;
   }
}
