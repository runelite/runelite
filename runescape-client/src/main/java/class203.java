import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gy")
public class class203 implements Iterable {
   @ObfuscatedName("l")
   public class207 field3158 = new class207();

   @ObfuscatedName("g")
   public void method4001(class207 var1) {
      if(var1.field3163 != null) {
         var1.method4045();
      }

      var1.field3163 = this.field3158.field3163;
      var1.field3164 = this.field3158;
      var1.field3163.field3164 = var1;
      var1.field3164.field3163 = var1;
   }

   @ObfuscatedName("l")
   public void method4002() {
      while(this.field3158.field3164 != this.field3158) {
         this.field3158.field3164.method4045();
      }

   }

   public class203() {
      this.field3158.field3164 = this.field3158;
      this.field3158.field3163 = this.field3158;
   }

   public Iterator iterator() {
      return new class209(this);
   }
}
