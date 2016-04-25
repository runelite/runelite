import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class62 extends class65 {
   @ObfuscatedName("h")
   public byte[] field1213;
   @ObfuscatedName("j")
   public int field1214;
   @ObfuscatedName("m")
   public int field1215;
   @ObfuscatedName("z")
   int field1216;
   @ObfuscatedName("x")
   public boolean field1217;

   class62(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1214 = var1;
      this.field1213 = var2;
      this.field1215 = var3;
      this.field1216 = var4;
      this.field1217 = var5;
   }

   @ObfuscatedName("j")
   public class62 method1277(class74 var1) {
      this.field1213 = var1.method1592(this.field1213);
      this.field1214 = var1.method1587(this.field1214);
      if(this.field1215 == this.field1216) {
         this.field1215 = this.field1216 = var1.method1588(this.field1215);
      } else {
         this.field1215 = var1.method1588(this.field1215);
         this.field1216 = var1.method1588(this.field1216);
         if(this.field1215 == this.field1216) {
            --this.field1215;
         }
      }

      return this;
   }

   @ObfuscatedSignature(
      signature = "(I[BII)V",
      garbageValue = "22050"
   )
   class62(int var1, byte[] var2, int var3, int var4) {
      this.field1214 = var1;
      this.field1213 = var2;
      this.field1215 = var3;
      this.field1216 = var4;
   }
}
