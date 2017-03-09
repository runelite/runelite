import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bt")
public class class55 extends class71 {
   @ObfuscatedName("c")
   public int field1033;
   @ObfuscatedName("w")
   public boolean field1034;
   @ObfuscatedName("j")
   public byte[] field1035;
   @ObfuscatedName("d")
   int field1036;
   @ObfuscatedName("x")
   public int field1037;

   class55(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1037 = var1;
      this.field1035 = var2;
      this.field1033 = var3;
      this.field1036 = var4;
      this.field1034 = var5;
   }

   class55(int var1, byte[] var2, int var3, int var4) {
      this.field1037 = var1;
      this.field1035 = var2;
      this.field1033 = var3;
      this.field1036 = var4;
   }

   @ObfuscatedName("x")
   public class55 method1093(class65 var1) {
      this.field1035 = var1.method1237(this.field1035);
      this.field1037 = var1.method1238(this.field1037);
      if(this.field1033 == this.field1036) {
         this.field1033 = this.field1036 = var1.method1241(this.field1033);
      } else {
         this.field1033 = var1.method1241(this.field1033);
         this.field1036 = var1.method1241(this.field1036);
         if(this.field1033 == this.field1036) {
            --this.field1033;
         }
      }

      return this;
   }
}
