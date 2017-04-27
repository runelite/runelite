import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bo")
public class class55 extends class71 {
   @ObfuscatedName("d")
   public int field1011;
   @ObfuscatedName("c")
   public byte[] field1012;
   @ObfuscatedName("q")
   int field1013;
   @ObfuscatedName("n")
   public int field1014;
   @ObfuscatedName("t")
   public boolean field1015;

   class55(int var1, byte[] var2, int var3, int var4) {
      this.field1011 = var1;
      this.field1012 = var2;
      this.field1014 = var3;
      this.field1013 = var4;
   }

   class55(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1011 = var1;
      this.field1012 = var2;
      this.field1014 = var3;
      this.field1013 = var4;
      this.field1015 = var5;
   }

   @ObfuscatedName("d")
   public class55 method1036(class65 var1) {
      this.field1012 = var1.method1185(this.field1012);
      this.field1011 = var1.method1186(this.field1011);
      if(this.field1014 == this.field1013) {
         this.field1014 = this.field1013 = var1.method1187(this.field1014);
      } else {
         this.field1014 = var1.method1187(this.field1014);
         this.field1013 = var1.method1187(this.field1013);
         if(this.field1014 == this.field1013) {
            --this.field1014;
         }
      }

      return this;
   }
}
