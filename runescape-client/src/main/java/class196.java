import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gi")
public class class196 {
   @ObfuscatedName("f")
   class196 field2490;
   @ObfuscatedName("j")
   class196 field2491;

   @ObfuscatedName("n")
   public void method3655() {
      if(this.field2490 != null) {
         this.field2490.field2491 = this.field2491;
         this.field2491.field2490 = this.field2490;
         this.field2491 = null;
         this.field2490 = null;
      }
   }
}
