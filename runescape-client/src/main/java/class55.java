import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("br")
public class class55 extends class71 {
   @ObfuscatedName("i")
   public byte[] field1044;
   @ObfuscatedName("u")
   public int field1045;
   @ObfuscatedName("h")
   int field1046;
   @ObfuscatedName("f")
   public int field1047;
   @ObfuscatedName("r")
   public boolean field1048;

   class55(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1047 = var1;
      this.field1044 = var2;
      this.field1045 = var3;
      this.field1046 = var4;
      this.field1048 = var5;
   }

   @ObfuscatedName("f")
   public class55 method1054(class65 var1) {
      this.field1044 = var1.method1194(this.field1044);
      this.field1047 = var1.method1198(this.field1047);
      if(this.field1045 == this.field1046) {
         this.field1045 = this.field1046 = var1.method1195(this.field1045);
      } else {
         this.field1045 = var1.method1195(this.field1045);
         this.field1046 = var1.method1195(this.field1046);
         if(this.field1045 == this.field1046) {
            --this.field1045;
         }
      }

      return this;
   }

   class55(int var1, byte[] var2, int var3, int var4) {
      this.field1047 = var1;
      this.field1044 = var2;
      this.field1045 = var3;
      this.field1046 = var4;
   }
}
