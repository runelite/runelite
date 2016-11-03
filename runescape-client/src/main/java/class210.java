import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hb")
public class class210 {
   @ObfuscatedName("v")
   class210 field3163;
   @ObfuscatedName("c")
   class210 field3164;

   @ObfuscatedName("k")
   public void method3945() {
      if(this.field3163 != null) {
         this.field3163.field3164 = this.field3164;
         this.field3164.field3163 = this.field3163;
         this.field3164 = null;
         this.field3163 = null;
      }
   }
}
