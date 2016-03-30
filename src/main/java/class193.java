import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gi")
public final class class193 {
   @ObfuscatedName("x")
   int field3087;
   @ObfuscatedName("p")
   class196 field3088;
   @ObfuscatedName("w")
   class204 field3089 = new class204();
   @ObfuscatedName("t")
   int field3090;
   @ObfuscatedName("e")
   class203 field3091 = new class203();

   @ObfuscatedName("x")
   public void method3770(long var1) {
      class204 var3 = (class204)this.field3088.method3806(var1);
      if(var3 != null) {
         var3.method3935();
         var3.method3909();
         ++this.field3090;
      }

   }

   @ObfuscatedName("w")
   public class204 method3771(long var1) {
      class204 var3 = (class204)this.field3088.method3806(var1);
      if(var3 != null) {
         this.field3091.method3905(var3);
      }

      return var3;
   }

   public class193(int var1) {
      this.field3087 = var1;
      this.field3090 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.field3088 = new class196(var2);
   }

   @ObfuscatedName("t")
   public void method3773(class204 var1, long var2) {
      if(this.field3090 == 0) {
         class204 var4 = this.field3091.method3894();
         var4.method3935();
         var4.method3909();
         if(var4 == this.field3089) {
            var4 = this.field3091.method3894();
            var4.method3935();
            var4.method3909();
         }
      } else {
         --this.field3090;
      }

      this.field3088.method3807(var1, var2);
      this.field3091.method3905(var1);
   }

   @ObfuscatedName("p")
   public void method3776() {
      this.field3091.method3897();
      this.field3088.method3808();
      this.field3089 = new class204();
      this.field3090 = this.field3087;
   }
}
