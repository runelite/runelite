import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gz")
public class class200 implements Iterable {
   @ObfuscatedName("t")
   public class204 field3110 = new class204();

   @ObfuscatedName("t")
   public void method3806() {
      while(this.field3110.field3114 != this.field3110) {
         this.field3110.field3114.method3844();
      }

   }

   @ObfuscatedName("i")
   public void method3808(class204 var1) {
      if(var1.field3115 != null) {
         var1.method3844();
      }

      var1.field3115 = this.field3110.field3115;
      var1.field3114 = this.field3110;
      var1.field3115.field3114 = var1;
      var1.field3114.field3115 = var1;
   }

   public class200() {
      this.field3110.field3114 = this.field3110;
      this.field3110.field3115 = this.field3110;
   }

   public Iterator iterator() {
      return new class206(this);
   }
}
