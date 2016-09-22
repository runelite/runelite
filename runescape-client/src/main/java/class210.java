import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ho")
public class class210 {
   @ObfuscatedName("z")
   class210 field3167;
   @ObfuscatedName("r")
   class210 field3168;

   @ObfuscatedName("a")
   public void method3962() {
      if(this.field3167 != null) {
         this.field3167.field3168 = this.field3168;
         this.field3168.field3167 = this.field3167;
         this.field3168 = null;
         this.field3167 = null;
      }
   }
}
