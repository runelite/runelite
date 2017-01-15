import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ee")
public class class131 {
   @ObfuscatedName("f")
   class131 field1875;
   @ObfuscatedName("a")
   class131 field1876;

   @ObfuscatedName("u")
   public void method2431() {
      if(this.field1875 != null) {
         this.field1875.field1876 = this.field1876;
         this.field1876.field1875 = this.field1875;
         this.field1876 = null;
         this.field1875 = null;
      }

   }
}
