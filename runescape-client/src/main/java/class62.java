import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class62 extends class65 {
   @ObfuscatedName("p")
   public int field1236;
   @ObfuscatedName("j")
   public byte[] field1237;
   @ObfuscatedName("d")
   public boolean field1238;
   @ObfuscatedName("x")
   int field1239;
   @ObfuscatedName("s")
   public int field1240;

   class62(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1240 = var1;
      this.field1237 = var2;
      this.field1236 = var3;
      this.field1239 = var4;
      this.field1238 = var5;
   }

   @ObfuscatedName("s")
   public class62 method1256(class74 var1) {
      this.field1237 = var1.method1570(this.field1237);
      this.field1240 = var1.method1572(this.field1240);
      if(this.field1236 == this.field1239) {
         this.field1236 = this.field1239 = var1.method1573(this.field1236);
      } else {
         this.field1236 = var1.method1573(this.field1236);
         this.field1239 = var1.method1573(this.field1239);
         if(this.field1236 == this.field1239) {
            --this.field1236;
         }
      }

      return this;
   }

   @ObfuscatedSignature(
      signature = "(I[BII)V",
      garbageValue = "22050"
   )
   class62(int var1, byte[] var2, int var3, int var4) {
      this.field1240 = var1;
      this.field1237 = var2;
      this.field1236 = var3;
      this.field1239 = var4;
   }
}
