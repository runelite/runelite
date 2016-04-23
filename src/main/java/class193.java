import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public final class class193 {
   @ObfuscatedName("h")
   int field3086;
   @ObfuscatedName("x")
   class203 field3087 = new class203();
   @ObfuscatedName("m")
   int field3088;
   @ObfuscatedName("z")
   class196 field3089;
   @ObfuscatedName("j")
   class204 field3090 = new class204();

   @ObfuscatedName("j")
   public class204 method3704(long var1) {
      class204 var3 = (class204)this.field3089.method3742(var1);
      if(var3 != null) {
         this.field3087.method3844(var3);
      }

      return var3;
   }

   @ObfuscatedName("m")
   public void method3706(class204 var1, long var2) {
      if(this.field3088 == 0) {
         class204 var4 = this.field3087.method3852();
         var4.method3883();
         var4.method3863();
         if(var4 == this.field3090) {
            var4 = this.field3087.method3852();
            var4.method3883();
            var4.method3863();
         }
      } else {
         --this.field3088;
      }

      this.field3089.method3743(var1, var2);
      this.field3087.method3844(var1);
   }

   @ObfuscatedName("z")
   public void method3707() {
      this.field3087.method3849();
      this.field3089.method3744();
      this.field3090 = new class204();
      this.field3088 = this.field3086;
   }

   @ObfuscatedName("h")
   public void method3709(long var1) {
      class204 var3 = (class204)this.field3089.method3742(var1);
      if(var3 != null) {
         var3.method3883();
         var3.method3863();
         ++this.field3088;
      }

   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "128"
   )
   public class193(int var1) {
      this.field3086 = var1;
      this.field3088 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.field3089 = new class196(var2);
   }
}
