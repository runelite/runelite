import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bd")
public class class55 extends class71 {
   @ObfuscatedName("m")
   public int field1013;
   @ObfuscatedName("d")
   public byte[] field1014;
   @ObfuscatedName("n")
   public int field1015;
   @ObfuscatedName("h")
   int field1016;
   @ObfuscatedName("w")
   public boolean field1017;

   class55(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1015 = var1;
      this.field1014 = var2;
      this.field1013 = var3;
      this.field1016 = var4;
      this.field1017 = var5;
   }

   class55(int var1, byte[] var2, int var3, int var4) {
      this.field1015 = var1;
      this.field1014 = var2;
      this.field1013 = var3;
      this.field1016 = var4;
   }

   @ObfuscatedName("n")
   public class55 method1019(class65 var1) {
      this.field1014 = var1.method1158(this.field1014);
      this.field1015 = var1.method1159(this.field1015);
      if(this.field1013 == this.field1016) {
         this.field1013 = this.field1016 = var1.method1157(this.field1013);
      } else {
         this.field1013 = var1.method1157(this.field1013);
         this.field1016 = var1.method1157(this.field1016);
         if(this.field1013 == this.field1016) {
            --this.field1013;
         }
      }

      return this;
   }
}
