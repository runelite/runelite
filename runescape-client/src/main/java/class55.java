import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bl")
public class class55 extends class71 {
   @ObfuscatedName("y")
   public byte[] field1023;
   @ObfuscatedName("k")
   public int field1024;
   @ObfuscatedName("o")
   public int field1025;
   @ObfuscatedName("r")
   int field1026;
   @ObfuscatedName("w")
   public boolean field1027;

   class55(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1024 = var1;
      this.field1023 = var2;
      this.field1025 = var3;
      this.field1026 = var4;
      this.field1027 = var5;
   }

   @ObfuscatedName("k")
   public class55 method1026(class65 var1) {
      this.field1023 = var1.method1185(this.field1023);
      this.field1024 = var1.method1181(this.field1024);
      if(this.field1025 == this.field1026) {
         this.field1025 = this.field1026 = var1.method1182(this.field1025);
      } else {
         this.field1025 = var1.method1182(this.field1025);
         this.field1026 = var1.method1182(this.field1026);
         if(this.field1025 == this.field1026) {
            --this.field1025;
         }
      }

      return this;
   }

   class55(int var1, byte[] var2, int var3, int var4) {
      this.field1024 = var1;
      this.field1023 = var2;
      this.field1025 = var3;
      this.field1026 = var4;
   }
}
