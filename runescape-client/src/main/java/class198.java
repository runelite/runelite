import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public final class class198 implements Iterable {
   @ObfuscatedName("t")
   int field3105;
   @ObfuscatedName("i")
   class208[] field3106;
   @ObfuscatedName("g")
   class208 field3107;

   @ObfuscatedName("t")
   public class208 method3761(long var1) {
      class208 var3 = this.field3106[(int)(var1 & (long)(this.field3105 - 1))];

      for(this.field3107 = var3.field3126; this.field3107 != var3; this.field3107 = this.field3107.field3126) {
         if(this.field3107.field3125 == var1) {
            class208 var4 = this.field3107;
            this.field3107 = this.field3107.field3126;
            return var4;
         }
      }

      this.field3107 = null;
      return null;
   }

   @ObfuscatedName("i")
   public void method3762(class208 var1, long var2) {
      if(var1.field3124 != null) {
         var1.method3870();
      }

      class208 var4 = this.field3106[(int)(var2 & (long)(this.field3105 - 1))];
      var1.field3124 = var4.field3124;
      var1.field3126 = var4;
      var1.field3124.field3126 = var1;
      var1.field3126.field3124 = var1;
      var1.field3125 = var2;
   }

   public Iterator iterator() {
      return new class194(this);
   }

   @ObfuscatedName("g")
   public void method3764() {
      for(int var1 = 0; var1 < this.field3105; ++var1) {
         class208 var2 = this.field3106[var1];

         while(true) {
            class208 var3 = var2.field3126;
            if(var3 == var2) {
               break;
            }

            var3.method3870();
         }
      }

      this.field3107 = null;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1024"
   )
   public class198(int var1) {
      this.field3105 = var1;
      this.field3106 = new class208[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class208 var3 = this.field3106[var2] = new class208();
         var3.field3126 = var3;
         var3.field3124 = var3;
      }

   }
}
