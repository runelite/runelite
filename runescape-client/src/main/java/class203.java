import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("go")
public class class203 implements Iterable {
   @ObfuscatedName("e")
   public class207 field3146 = new class207();

   public Iterator iterator() {
      return new class209(this);
   }

   @ObfuscatedName("e")
   public void method3926() {
      while(this.field3146.field3152 != this.field3146) {
         this.field3146.field3152.method3978();
      }

   }

   @ObfuscatedName("l")
   public void method3927(class207 var1) {
      if(var1.field3151 != null) {
         var1.method3978();
      }

      var1.field3151 = this.field3146.field3151;
      var1.field3152 = this.field3146;
      var1.field3151.field3152 = var1;
      var1.field3152.field3151 = var1;
   }

   public class203() {
      this.field3146.field3152 = this.field3146;
      this.field3146.field3151 = this.field3146;
   }
}
