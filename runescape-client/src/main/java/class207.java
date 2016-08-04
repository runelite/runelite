import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
@Implements("CacheableNode")
public class class207 extends class211 {
   @ObfuscatedName("cb")
   @Export("next")
   public class207 field3163;
   @ObfuscatedName("cs")
   @Export("previous")
   public class207 field3164;

   @ObfuscatedName("fr")
   public void method4045() {
      if(this.field3163 != null) {
         this.field3163.field3164 = this.field3164;
         this.field3164.field3163 = this.field3163;
         this.field3164 = null;
         this.field3163 = null;
      }
   }
}
