import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bi")
public class class55 extends class71 {
   @ObfuscatedName("v")
   int field1033;
   @ObfuscatedName("n")
   public byte[] field1034;
   @ObfuscatedName("x")
   public int field1035;
   @ObfuscatedName("g")
   public int field1036;
   @ObfuscatedName("y")
   public boolean field1037;

   class55(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1035 = var1;
      this.field1034 = var2;
      this.field1036 = var3;
      this.field1033 = var4;
      this.field1037 = var5;
   }

   @ObfuscatedName("x")
   public class55 method1097(class65 var1) {
      this.field1034 = var1.method1248(this.field1034);
      this.field1035 = var1.method1243(this.field1035);
      if(this.field1036 == this.field1033) {
         this.field1036 = this.field1033 = var1.method1245(this.field1036);
      } else {
         this.field1036 = var1.method1245(this.field1036);
         this.field1033 = var1.method1245(this.field1033);
         if(this.field1036 == this.field1033) {
            --this.field1036;
         }
      }

      return this;
   }

   class55(int var1, byte[] var2, int var3, int var4) {
      this.field1035 = var1;
      this.field1034 = var2;
      this.field1036 = var3;
      this.field1033 = var4;
   }
}
