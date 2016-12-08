import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bh")
public class class55 extends class71 {
   @ObfuscatedName("o")
   public int field1021;
   @ObfuscatedName("m")
   public byte[] field1022;
   @ObfuscatedName("h")
   public boolean field1023;
   @ObfuscatedName("g")
   int field1024;
   @ObfuscatedName("b")
   public int field1025;

   @ObfuscatedName("o")
   public class55 method990(class65 var1) {
      this.field1022 = var1.method1156(this.field1022);
      this.field1021 = var1.method1151(this.field1021);
      if(this.field1025 == this.field1024) {
         this.field1025 = this.field1024 = var1.method1152(this.field1025);
      } else {
         this.field1025 = var1.method1152(this.field1025);
         this.field1024 = var1.method1152(this.field1024);
         if(this.field1025 == this.field1024) {
            --this.field1025;
         }
      }

      return this;
   }

   class55(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1021 = var1;
      this.field1022 = var2;
      this.field1025 = var3;
      this.field1024 = var4;
      this.field1023 = var5;
   }

   class55(int var1, byte[] var2, int var3, int var4) {
      this.field1021 = var1;
      this.field1022 = var2;
      this.field1025 = var3;
      this.field1024 = var4;
   }
}
