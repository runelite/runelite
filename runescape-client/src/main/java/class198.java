import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public final class class198 implements Iterable {
   @ObfuscatedName("j")
   class208[] field3105;
   @ObfuscatedName("s")
   int field3106;
   @ObfuscatedName("p")
   class208 field3107;

   @ObfuscatedName("s")
   public class208 method3794(long var1) {
      class208 var3 = this.field3105[(int)(var1 & (long)(this.field3106 - 1))];

      for(this.field3107 = var3.field3124; this.field3107 != var3; this.field3107 = this.field3107.field3124) {
         if(this.field3107.field3125 == var1) {
            class208 var4 = this.field3107;
            this.field3107 = this.field3107.field3124;
            return var4;
         }
      }

      this.field3107 = null;
      return null;
   }

   @ObfuscatedName("j")
   public void method3795(class208 var1, long var2) {
      if(var1.field3126 != null) {
         var1.method3898();
      }

      class208 var4 = this.field3105[(int)(var2 & (long)(this.field3106 - 1))];
      var1.field3126 = var4.field3126;
      var1.field3124 = var4;
      var1.field3126.field3124 = var1;
      var1.field3124.field3126 = var1;
      var1.field3125 = var2;
   }

   @ObfuscatedName("p")
   public void method3796() {
      for(int var1 = 0; var1 < this.field3106; ++var1) {
         class208 var2 = this.field3105[var1];

         while(true) {
            class208 var3 = var2.field3124;
            if(var3 == var2) {
               break;
            }

            var3.method3898();
         }
      }

      this.field3107 = null;
   }

   public Iterator iterator() {
      return new class194(this);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1024"
   )
   public class198(int var1) {
      this.field3106 = var1;
      this.field3105 = new class208[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class208 var3 = this.field3105[var2] = new class208();
         var3.field3124 = var3;
         var3.field3126 = var3;
      }

   }
}
