import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public class class62 extends class65 {
   @ObfuscatedName("t")
   public int field1234;
   @ObfuscatedName("i")
   public byte[] field1235;
   @ObfuscatedName("z")
   public boolean field1236;
   @ObfuscatedName("h")
   int field1237;
   @ObfuscatedName("g")
   public int field1238;

   @ObfuscatedName("t")
   public class62 method1239(class74 var1) {
      this.field1235 = var1.method1545(this.field1235);
      this.field1234 = var1.method1555(this.field1234);
      if(this.field1238 == this.field1237) {
         this.field1238 = this.field1237 = var1.method1547(this.field1238);
      } else {
         this.field1238 = var1.method1547(this.field1238);
         this.field1237 = var1.method1547(this.field1237);
         if(this.field1238 == this.field1237) {
            --this.field1238;
         }
      }

      return this;
   }

   @ObfuscatedSignature(
      signature = "(I[BII)V",
      garbageValue = "22050"
   )
   class62(int var1, byte[] var2, int var3, int var4) {
      this.field1234 = var1;
      this.field1235 = var2;
      this.field1238 = var3;
      this.field1237 = var4;
   }

   class62(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1234 = var1;
      this.field1235 = var2;
      this.field1238 = var3;
      this.field1237 = var4;
      this.field1236 = var5;
   }
}
