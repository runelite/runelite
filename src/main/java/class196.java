import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gi")
@Implements("XHashTable")
public final class class196 {
   @ObfuscatedName("w")
   class208[] field3089;
   @ObfuscatedName("e")
   int field3090;
   @ObfuscatedName("f")
   class208 field3091;
   @ObfuscatedName("s")
   class208 field3092;
   @ObfuscatedName("p")
   int field3093 = 0;

   @ObfuscatedName("e")
   public class208 method3788(long var1) {
      class208 var3 = this.field3089[(int)(var1 & (long)(this.field3090 - 1))];

      for(this.field3091 = var3.field3114; this.field3091 != var3; this.field3091 = this.field3091.field3114) {
         if(this.field3091.field3115 == var1) {
            class208 var4 = this.field3091;
            this.field3091 = this.field3091.field3114;
            return var4;
         }
      }

      this.field3091 = null;
      return null;
   }

   @ObfuscatedName("w")
   public void method3789(class208 var1, long var2) {
      if(var1.field3116 != null) {
         var1.method3913();
      }

      class208 var4 = this.field3089[(int)(var2 & (long)(this.field3090 - 1))];
      var1.field3116 = var4.field3116;
      var1.field3114 = var4;
      var1.field3116.field3114 = var1;
      var1.field3114.field3116 = var1;
      var1.field3115 = var2;
   }

   @ObfuscatedName("f")
   void method3790() {
      for(int var1 = 0; var1 < this.field3090; ++var1) {
         class208 var2 = this.field3089[var1];

         while(true) {
            class208 var3 = var2.field3114;
            if(var3 == var2) {
               break;
            }

            var3.method3913();
         }
      }

      this.field3091 = null;
      this.field3092 = null;
   }

   @ObfuscatedName("p")
   public class208 method3791() {
      class208 var1;
      if(this.field3093 > 0 && this.field3092 != this.field3089[this.field3093 - 1]) {
         var1 = this.field3092;
         this.field3092 = var1.field3114;
         return var1;
      } else {
         do {
            if(this.field3093 >= this.field3090) {
               return null;
            }

            var1 = this.field3089[this.field3093++].field3114;
         } while(var1 == this.field3089[this.field3093 - 1]);

         this.field3092 = var1.field3114;
         return var1;
      }
   }

   @ObfuscatedName("s")
   public class208 method3794() {
      this.field3093 = 0;
      return this.method3791();
   }

   public class196(int var1) {
      this.field3090 = var1;
      this.field3089 = new class208[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class208 var3 = this.field3089[var2] = new class208();
         var3.field3114 = var3;
         var3.field3116 = var3;
      }

   }
}
