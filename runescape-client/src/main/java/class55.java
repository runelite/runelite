import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bj")
public class class55 extends class71 {
   @ObfuscatedName("p")
   int field1043;
   @ObfuscatedName("d")
   public byte[] field1044;
   @ObfuscatedName("q")
   public int field1045;
   @ObfuscatedName("h")
   public int field1046;
   @ObfuscatedName("j")
   public boolean field1047;

   class55(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1045 = var1;
      this.field1044 = var2;
      this.field1046 = var3;
      this.field1043 = var4;
      this.field1047 = var5;
   }

   @ObfuscatedName("q")
   public class55 method1084(class65 var1) {
      this.field1044 = var1.method1220(this.field1044);
      this.field1045 = var1.method1228(this.field1045);
      if(this.field1046 == this.field1043) {
         this.field1046 = this.field1043 = var1.method1219(this.field1046);
      } else {
         this.field1046 = var1.method1219(this.field1046);
         this.field1043 = var1.method1219(this.field1043);
         if(this.field1046 == this.field1043) {
            --this.field1046;
         }
      }

      return this;
   }

   class55(int var1, byte[] var2, int var3, int var4) {
      this.field1045 = var1;
      this.field1044 = var2;
      this.field1046 = var3;
      this.field1043 = var4;
   }
}
