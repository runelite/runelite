import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gb")
public class class200 implements Iterable {
   @ObfuscatedName("j")
   public class204 field3108 = new class204();

   @ObfuscatedName("j")
   public void method3813() {
      while(this.field3108.field3112 != this.field3108) {
         this.field3108.field3112.method3863();
      }

   }

   public class200() {
      this.field3108.field3112 = this.field3108;
      this.field3108.field3113 = this.field3108;
   }

   @ObfuscatedName("h")
   public void method3822(class204 var1) {
      if(var1.field3113 != null) {
         var1.method3863();
      }

      var1.field3113 = this.field3108.field3113;
      var1.field3112 = this.field3108;
      var1.field3113.field3112 = var1;
      var1.field3112.field3113 = var1;
   }

   public Iterator iterator() {
      return new class206(this);
   }
}
