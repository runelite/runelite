import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gy")
public class class196 {
   @ObfuscatedName("s")
   class196 field2481;
   @ObfuscatedName("t")
   class196 field2482;

   @ObfuscatedName("i")
   public void method3615() {
      if(this.field2481 != null) {
         this.field2481.field2482 = this.field2482;
         this.field2482.field2481 = this.field2481;
         this.field2482 = null;
         this.field2481 = null;
      }

   }
}
