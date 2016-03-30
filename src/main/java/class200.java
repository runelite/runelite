import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gr")
public class class200 implements Iterable {
   @ObfuscatedName("w")
   public class204 field3109 = new class204();

   @ObfuscatedName("w")
   public void method3869() {
      while(this.field3109.field3114 != this.field3109) {
         this.field3109.field3114.method3909();
      }

   }

   @ObfuscatedName("x")
   public void method3870(class204 var1) {
      if(var1.field3113 != null) {
         var1.method3909();
      }

      var1.field3113 = this.field3109.field3113;
      var1.field3114 = this.field3109;
      var1.field3113.field3114 = var1;
      var1.field3114.field3113 = var1;
   }

   public class200() {
      this.field3109.field3114 = this.field3109;
      this.field3109.field3113 = this.field3109;
   }

   public Iterator iterator() {
      return new class206(this);
   }
}
