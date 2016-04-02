import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bu")
public class class62 extends class65 {
   @ObfuscatedName("s")
   int field1202;
   @ObfuscatedName("w")
   public byte[] field1203;
   @ObfuscatedName("e")
   public int field1204;
   @ObfuscatedName("f")
   public int field1205;
   @ObfuscatedName("p")
   public boolean field1206;

   class62(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1204 = var1;
      this.field1203 = var2;
      this.field1205 = var3;
      this.field1202 = var4;
      this.field1206 = var5;
   }

   @ObfuscatedName("e")
   public class62 method1279(class74 var1) {
      this.field1203 = var1.method1593(this.field1203);
      this.field1204 = var1.method1595(this.field1204);
      if(this.field1205 == this.field1202) {
         this.field1205 = this.field1202 = var1.method1596(this.field1205);
      } else {
         this.field1205 = var1.method1596(this.field1205);
         this.field1202 = var1.method1596(this.field1202);
         if(this.field1205 == this.field1202) {
            --this.field1205;
         }
      }

      return this;
   }

   class62(int var1, byte[] var2, int var3, int var4) {
      this.field1204 = var1;
      this.field1203 = var2;
      this.field1205 = var3;
      this.field1202 = var4;
   }
}
