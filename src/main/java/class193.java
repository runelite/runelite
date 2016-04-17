import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public final class class193 {
   @ObfuscatedName("y")
   class203 field3087 = new class203();
   @ObfuscatedName("w")
   int field3088;
   @ObfuscatedName("a")
   class204 field3089 = new class204();
   @ObfuscatedName("c")
   class196 field3090;
   @ObfuscatedName("d")
   int field3091;

   @ObfuscatedName("a")
   public class204 method3840(long var1) {
      class204 var3 = (class204)this.field3090.method3868(var1);
      if(var3 != null) {
         this.field3087.method3963(var3);
      }

      return var3;
   }

   @ObfuscatedName("w")
   public void method3841(long var1) {
      class204 var3 = (class204)this.field3090.method3868(var1);
      if(var3 != null) {
         var3.method3998();
         var3.method3979();
         ++this.field3091;
      }

   }

   @ObfuscatedName("d")
   public void method3842(class204 var1, long var2) {
      if(this.field3091 == 0) {
         class204 var4 = this.field3087.method3977();
         var4.method3998();
         var4.method3979();
         if(var4 == this.field3089) {
            var4 = this.field3087.method3977();
            var4.method3998();
            var4.method3979();
         }
      } else {
         --this.field3091;
      }

      this.field3090.method3875(var1, var2);
      this.field3087.method3963(var1);
   }

   @ObfuscatedName("c")
   public void method3843() {
      this.field3087.method3967();
      this.field3090.method3870();
      this.field3089 = new class204();
      this.field3091 = this.field3088;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "128"
   )
   public class193(int var1) {
      this.field3088 = var1;
      this.field3091 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.field3090 = new class196(var2);
   }
}
