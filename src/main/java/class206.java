import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gl")
public class class206 {
   @ObfuscatedName("y")
   class206 field3107;
   @ObfuscatedName("s")
   class206 field3108;

   @ObfuscatedName("a")
   public void method3940() {
      if(this.field3107 != null) {
         this.field3107.field3108 = this.field3108;
         this.field3108.field3107 = this.field3107;
         this.field3108 = null;
         this.field3107 = null;
      }
   }
}
