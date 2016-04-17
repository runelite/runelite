import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class62 extends class65 {
   @ObfuscatedName("y")
   public boolean field1238;
   @ObfuscatedName("w")
   public byte[] field1239;
   @ObfuscatedName("d")
   public int field1240;
   @ObfuscatedName("a")
   public int field1241;
   @ObfuscatedName("c")
   int field1242;

   class62(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1241 = var1;
      this.field1239 = var2;
      this.field1240 = var3;
      this.field1242 = var4;
      this.field1238 = var5;
   }

   @ObfuscatedName("a")
   public class62 method1370(class74 var1) {
      this.field1239 = var1.method1701(this.field1239);
      this.field1241 = var1.method1691(this.field1241);
      if(this.field1240 == this.field1242) {
         this.field1240 = this.field1242 = var1.method1692(this.field1240);
      } else {
         this.field1240 = var1.method1692(this.field1240);
         this.field1242 = var1.method1692(this.field1242);
         if(this.field1240 == this.field1242) {
            --this.field1240;
         }
      }

      return this;
   }

   @ObfuscatedSignature(
      signature = "(I[BII)V",
      garbageValue = "22050"
   )
   class62(int var1, byte[] var2, int var3, int var4) {
      this.field1241 = var1;
      this.field1239 = var2;
      this.field1240 = var3;
      this.field1242 = var4;
   }
}
