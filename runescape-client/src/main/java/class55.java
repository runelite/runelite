import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ba")
public class class55 extends class71 {
   @ObfuscatedName("e")
   public byte[] field1022;
   @ObfuscatedName("f")
   public int field1023;
   @ObfuscatedName("g")
   public boolean field1024;
   @ObfuscatedName("k")
   int field1025;
   @ObfuscatedName("i")
   public int field1026;

   class55(int var1, byte[] var2, int var3, int var4) {
      this.field1026 = var1;
      this.field1022 = var2;
      this.field1023 = var3;
      this.field1025 = var4;
   }

   class55(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1026 = var1;
      this.field1022 = var2;
      this.field1023 = var3;
      this.field1025 = var4;
      this.field1024 = var5;
   }

   @ObfuscatedName("i")
   public class55 method989(class65 var1) {
      this.field1022 = var1.method1150(this.field1022);
      this.field1026 = var1.method1145(this.field1026);
      if(this.field1023 == this.field1025) {
         this.field1023 = this.field1025 = var1.method1146(this.field1023);
      } else {
         this.field1023 = var1.method1146(this.field1023);
         this.field1025 = var1.method1146(this.field1025);
         if(this.field1023 == this.field1025) {
            --this.field1023;
         }
      }

      return this;
   }
}
