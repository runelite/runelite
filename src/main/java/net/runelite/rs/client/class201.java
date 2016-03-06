import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("go")
public class class201 implements Iterable {
   @ObfuscatedName("j")
   class207 field3098 = new class207();

   @ObfuscatedName("j")
   public void method3806(class207 var1) {
      if(var1.field3110 != null) {
         var1.method3853();
      }

      var1.field3110 = this.field3098.field3110;
      var1.field3111 = this.field3098;
      var1.field3110.field3111 = var1;
      var1.field3111.field3110 = var1;
   }

   public class201() {
      this.field3098.field3111 = this.field3098;
      this.field3098.field3110 = this.field3098;
   }

   @ObfuscatedName("l")
   public class207 method3807() {
      return this.method3808((class207)null);
   }

   public Iterator iterator() {
      return new class204(this);
   }

   @ObfuscatedName("a")
   class207 method3808(class207 var1) {
      class207 var2;
      if(var1 == null) {
         var2 = this.field3098.field3111;
      } else {
         var2 = var1;
      }

      return var2 == this.field3098?null:var2;
   }
}
