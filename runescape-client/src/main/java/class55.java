import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bs")
public class class55 extends class71 {
   @ObfuscatedName("f")
   public int field1019;
   @ObfuscatedName("c")
   public byte[] field1020;
   @ObfuscatedName("s")
   public int field1021;
   @ObfuscatedName("h")
   int field1022;
   @ObfuscatedName("a")
   public boolean field1023;

   class55(int var1, byte[] var2, int var3, int var4) {
      this.field1021 = var1;
      this.field1020 = var2;
      this.field1019 = var3;
      this.field1022 = var4;
   }

   class55(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1021 = var1;
      this.field1020 = var2;
      this.field1019 = var3;
      this.field1022 = var4;
      this.field1023 = var5;
   }

   @ObfuscatedName("s")
   public class55 method963(class65 var1) {
      this.field1020 = var1.method1118(this.field1020);
      this.field1021 = var1.method1113(this.field1021);
      if(this.field1019 == this.field1022) {
         this.field1019 = this.field1022 = var1.method1116(this.field1019);
      } else {
         this.field1019 = var1.method1116(this.field1019);
         this.field1022 = var1.method1116(this.field1022);
         if(this.field1019 == this.field1022) {
            --this.field1019;
         }
      }

      return this;
   }
}
