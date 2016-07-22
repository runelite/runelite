import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gs")
@Implements("CacheableNode")
public class class207 extends class211 {
   @ObfuscatedName("cu")
   @Export("previous")
   public class207 field3156;
   @ObfuscatedName("cd")
   @Export("next")
   public class207 field3157;

   @ObfuscatedName("ft")
   public void method3960() {
      if(this.field3157 != null) {
         this.field3157.field3156 = this.field3156;
         this.field3156.field3157 = this.field3157;
         this.field3156 = null;
         this.field3157 = null;
      }
   }
}
