import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
public class class203 implements Iterable {
   @ObfuscatedName("m")
   public class207 field3151 = new class207();

   @ObfuscatedName("w")
   public void method3912(class207 var1) {
      if(var1.field3157 != null) {
         var1.method3960();
      }

      var1.field3157 = this.field3151.field3157;
      var1.field3156 = this.field3151;
      var1.field3157.field3156 = var1;
      var1.field3156.field3157 = var1;
   }

   @ObfuscatedName("m")
   public void method3914() {
      while(this.field3151.field3156 != this.field3151) {
         this.field3151.field3156.method3960();
      }

   }

   public Iterator iterator() {
      return new class209(this);
   }

   public class203() {
      this.field3151.field3156 = this.field3151;
      this.field3151.field3157 = this.field3151;
   }
}
