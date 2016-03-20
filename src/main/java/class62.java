import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bl")
public class class62 extends class65 {
   @ObfuscatedName("f")
   public int field1230;
   @ObfuscatedName("r")
   public byte[] field1231;
   @ObfuscatedName("a")
   public int field1232;
   @ObfuscatedName("s")
   int field1233;
   @ObfuscatedName("y")
   public boolean field1234;

   class62(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1232 = var1;
      this.field1231 = var2;
      this.field1230 = var3;
      this.field1233 = var4;
      this.field1234 = var5;
   }

   class62(int var1, byte[] var2, int var3, int var4) {
      this.field1232 = var1;
      this.field1231 = var2;
      this.field1230 = var3;
      this.field1233 = var4;
   }

   @ObfuscatedName("a")
   public class62 method1305(class74 var1) {
      this.field1231 = var1.method1638(this.field1231);
      this.field1232 = var1.method1627(this.field1232);
      if(this.field1230 == this.field1233) {
         this.field1230 = this.field1233 = var1.method1631(this.field1230);
      } else {
         this.field1230 = var1.method1631(this.field1230);
         this.field1233 = var1.method1631(this.field1233);
         if(this.field1230 == this.field1233) {
            --this.field1230;
         }
      }

      return this;
   }
}
