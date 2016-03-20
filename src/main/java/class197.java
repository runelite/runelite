import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gr")
public final class class197 implements Iterable {
   @ObfuscatedName("r")
   class207[] field3090;
   @ObfuscatedName("f")
   class207 field3091;
   @ObfuscatedName("a")
   int field3092;

   @ObfuscatedName("f")
   public void method3844() {
      for(int var1 = 0; var1 < this.field3092; ++var1) {
         class207 var2 = this.field3090[var1];

         while(true) {
            class207 var3 = var2.field3110;
            if(var3 == var2) {
               break;
            }

            var3.method3946();
         }
      }

      this.field3091 = null;
   }

   public Iterator iterator() {
      return new class193(this);
   }

   @ObfuscatedName("r")
   public void method3847(class207 var1, long var2) {
      if(var1.field3109 != null) {
         var1.method3946();
      }

      class207 var4 = this.field3090[(int)(var2 & (long)(this.field3092 - 1))];
      var1.field3109 = var4.field3109;
      var1.field3110 = var4;
      var1.field3109.field3110 = var1;
      var1.field3110.field3109 = var1;
      var1.field3111 = var2;
   }

   @ObfuscatedName("a")
   public class207 method3849(long var1) {
      class207 var3 = this.field3090[(int)(var1 & (long)(this.field3092 - 1))];

      for(this.field3091 = var3.field3110; this.field3091 != var3; this.field3091 = this.field3091.field3110) {
         if(this.field3091.field3111 == var1) {
            class207 var4 = this.field3091;
            this.field3091 = this.field3091.field3110;
            return var4;
         }
      }

      this.field3091 = null;
      return null;
   }

   public class197(int var1) {
      this.field3092 = var1;
      this.field3090 = new class207[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class207 var3 = this.field3090[var2] = new class207();
         var3.field3110 = var3;
         var3.field3109 = var3;
      }

   }
}
