import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gw")
public final class class198 implements Iterable {
   @ObfuscatedName("e")
   int field3095;
   @ObfuscatedName("w")
   class208[] field3096;
   @ObfuscatedName("f")
   class208 field3097;

   @ObfuscatedName("w")
   public void method3806(class208 var1, long var2) {
      if(var1.field3116 != null) {
         var1.method3913();
      }

      class208 var4 = this.field3096[(int)(var2 & (long)(this.field3095 - 1))];
      var1.field3116 = var4.field3116;
      var1.field3114 = var4;
      var1.field3116.field3114 = var1;
      var1.field3114.field3116 = var1;
      var1.field3115 = var2;
   }

   public Iterator iterator() {
      return new class194(this);
   }

   @ObfuscatedName("e")
   public class208 method3809(long var1) {
      class208 var3 = this.field3096[(int)(var1 & (long)(this.field3095 - 1))];

      for(this.field3097 = var3.field3114; this.field3097 != var3; this.field3097 = this.field3097.field3114) {
         if(this.field3097.field3115 == var1) {
            class208 var4 = this.field3097;
            this.field3097 = this.field3097.field3114;
            return var4;
         }
      }

      this.field3097 = null;
      return null;
   }

   @ObfuscatedName("f")
   public void method3810() {
      for(int var1 = 0; var1 < this.field3095; ++var1) {
         class208 var2 = this.field3096[var1];

         while(true) {
            class208 var3 = var2.field3114;
            if(var3 == var2) {
               break;
            }

            var3.method3913();
         }
      }

      this.field3097 = null;
   }

   public class198(int var1) {
      this.field3095 = var1;
      this.field3096 = new class208[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class208 var3 = this.field3096[var2] = new class208();
         var3.field3114 = var3;
         var3.field3116 = var3;
      }

   }
}
