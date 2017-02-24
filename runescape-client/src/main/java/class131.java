import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eg")
public class class131 {
   @ObfuscatedName("j")
   class131 field1889;
   @ObfuscatedName("p")
   class131 field1890;

   @ObfuscatedName("q")
   public void method2496() {
      if(this.field1889 != null) {
         this.field1889.field1890 = this.field1890;
         this.field1890.field1889 = this.field1889;
         this.field1890 = null;
         this.field1889 = null;
      }
   }
}
