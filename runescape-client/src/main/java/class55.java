import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("br")
public class class55 extends class71 {
   @ObfuscatedName("x")
   public int field1023;
   @ObfuscatedName("g")
   public byte[] field1024;
   @ObfuscatedName("p")
   public int field1025;
   @ObfuscatedName("q")
   int field1026;
   @ObfuscatedName("d")
   public boolean field1027;

   class55(int var1, byte[] var2, int var3, int var4) {
      this.field1025 = var1;
      this.field1024 = var2;
      this.field1023 = var3;
      this.field1026 = var4;
   }

   class55(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1025 = var1;
      this.field1024 = var2;
      this.field1023 = var3;
      this.field1026 = var4;
      this.field1027 = var5;
   }

   @ObfuscatedName("p")
   public class55 method995(class65 var1) {
      this.field1024 = var1.method1141(this.field1024);
      this.field1025 = var1.method1140(this.field1025);
      if(this.field1023 == this.field1026) {
         this.field1023 = this.field1026 = var1.method1145(this.field1023);
      } else {
         this.field1023 = var1.method1145(this.field1023);
         this.field1026 = var1.method1145(this.field1026);
         if(this.field1023 == this.field1026) {
            --this.field1023;
         }
      }

      return this;
   }
}
