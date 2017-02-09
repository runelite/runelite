import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ec")
public class class131 {
   @ObfuscatedName("w")
   class131 field1881;
   @ObfuscatedName("r")
   class131 field1882;

   @ObfuscatedName("k")
   public void method2426() {
      if(this.field1881 != null) {
         this.field1881.field1882 = this.field1882;
         this.field1882.field1881 = this.field1881;
         this.field1882 = null;
         this.field1881 = null;
      }
   }
}
