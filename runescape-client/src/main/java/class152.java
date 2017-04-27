import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eo")
public class class152 {
   @ObfuscatedName("t")
   class152 field2040;
   @ObfuscatedName("q")
   class152 field2041;

   @ObfuscatedName("d")
   public void method2865() {
      if(this.field2040 != null) {
         this.field2040.field2041 = this.field2041;
         this.field2041.field2040 = this.field2040;
         this.field2041 = null;
         this.field2040 = null;
      }
   }
}
