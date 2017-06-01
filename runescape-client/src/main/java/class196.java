import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gj")
public class class196 {
   @ObfuscatedName("b")
   class196 field2488;
   @ObfuscatedName("v")
   class196 field2489;

   @ObfuscatedName("i")
   public void method3615() {
      if(this.field2488 != null) {
         this.field2488.field2489 = this.field2489;
         this.field2489.field2488 = this.field2488;
         this.field2489 = null;
         this.field2488 = null;
      }
   }
}
