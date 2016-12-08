import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ei")
public class class131 {
   @ObfuscatedName("h")
   class131 field1902;
   @ObfuscatedName("g")
   class131 field1903;

   @ObfuscatedName("o")
   public void method2395() {
      if(this.field1902 != null) {
         this.field1902.field1903 = this.field1903;
         this.field1903.field1902 = this.field1902;
         this.field1903 = null;
         this.field1902 = null;
      }
   }
}
