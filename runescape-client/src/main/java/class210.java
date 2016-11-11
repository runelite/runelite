import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hd")
public class class210 {
   @ObfuscatedName("n")
   class210 field3171;
   @ObfuscatedName("g")
   class210 field3172;

   @ObfuscatedName("i")
   public void method3944() {
      if(this.field3171 != null) {
         this.field3171.field3172 = this.field3172;
         this.field3172.field3171 = this.field3171;
         this.field3172 = null;
         this.field3171 = null;
      }
   }
}
