import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ew")
public class class131 {
   @ObfuscatedName("g")
   class131 field1885;
   @ObfuscatedName("k")
   class131 field1886;

   @ObfuscatedName("i")
   public void method2406() {
      if(this.field1885 != null) {
         this.field1885.field1886 = this.field1886;
         this.field1886.field1885 = this.field1885;
         this.field1886 = null;
         this.field1885 = null;
      }
   }
}
