import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ex")
public class class131 {
   @ObfuscatedName("y")
   class131 field1892;
   @ObfuscatedName("v")
   class131 field1893;

   @ObfuscatedName("x")
   public void method2525() {
      if(this.field1892 != null) {
         this.field1892.field1893 = this.field1893;
         this.field1893.field1892 = this.field1892;
         this.field1893 = null;
         this.field1892 = null;
      }
   }
}
