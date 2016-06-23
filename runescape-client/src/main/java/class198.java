import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gu")
public final class class198 implements Iterable {
   @ObfuscatedName("u")
   class208[] field3096;
   @ObfuscatedName("f")
   int field3097;
   @ObfuscatedName("x")
   class208 field3098;

   @ObfuscatedName("f")
   public class208 method3840(long var1) {
      class208 var3 = this.field3096[(int)(var1 & (long)(this.field3097 - 1))];

      for(this.field3098 = var3.field3116; this.field3098 != var3; this.field3098 = this.field3098.field3116) {
         if(this.field3098.field3115 == var1) {
            class208 var4 = this.field3098;
            this.field3098 = this.field3098.field3116;
            return var4;
         }
      }

      this.field3098 = null;
      return null;
   }

   @ObfuscatedName("u")
   public void method3842(class208 var1, long var2) {
      if(var1.field3117 != null) {
         var1.method3946();
      }

      class208 var4 = this.field3096[(int)(var2 & (long)(this.field3097 - 1))];
      var1.field3117 = var4.field3117;
      var1.field3116 = var4;
      var1.field3117.field3116 = var1;
      var1.field3116.field3117 = var1;
      var1.field3115 = var2;
   }

   @ObfuscatedName("x")
   public void method3843() {
      for(int var1 = 0; var1 < this.field3097; ++var1) {
         class208 var2 = this.field3096[var1];

         while(true) {
            class208 var3 = var2.field3116;
            if(var3 == var2) {
               break;
            }

            var3.method3946();
         }
      }

      this.field3098 = null;
   }

   public Iterator iterator() {
      return new class194(this);
   }

   public class198(int var1) {
      this.field3097 = var1;
      this.field3096 = new class208[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class208 var3 = this.field3096[var2] = new class208();
         var3.field3116 = var3;
         var3.field3117 = var3;
      }

   }
}
