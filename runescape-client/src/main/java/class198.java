import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gd")
public final class class198 implements Iterable {
   @ObfuscatedName("g")
   class208[] field3094;
   @ObfuscatedName("j")
   class208 field3095;
   @ObfuscatedName("b")
   int field3096;

   public class198(int var1) {
      this.field3096 = var1;
      this.field3094 = new class208[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class208 var3 = this.field3094[var2] = new class208();
         var3.field3114 = var3;
         var3.field3115 = var3;
      }

   }

   @ObfuscatedName("b")
   public class208 method3808(long var1) {
      class208 var3 = this.field3094[(int)(var1 & (long)(this.field3096 - 1))];

      for(this.field3095 = var3.field3114; this.field3095 != var3; this.field3095 = this.field3095.field3114) {
         if(this.field3095.field3113 == var1) {
            class208 var4 = this.field3095;
            this.field3095 = this.field3095.field3114;
            return var4;
         }
      }

      this.field3095 = null;
      return null;
   }

   @ObfuscatedName("g")
   public void method3809(class208 var1, long var2) {
      if(var1.field3115 != null) {
         var1.method3916();
      }

      class208 var4 = this.field3094[(int)(var2 & (long)(this.field3096 - 1))];
      var1.field3115 = var4.field3115;
      var1.field3114 = var4;
      var1.field3115.field3114 = var1;
      var1.field3114.field3115 = var1;
      var1.field3113 = var2;
   }

   public Iterator iterator() {
      return new class194(this);
   }

   @ObfuscatedName("j")
   public void method3812() {
      for(int var1 = 0; var1 < this.field3096; ++var1) {
         class208 var2 = this.field3094[var1];

         while(true) {
            class208 var3 = var2.field3114;
            if(var3 == var2) {
               break;
            }

            var3.method3916();
         }
      }

      this.field3095 = null;
   }
}
