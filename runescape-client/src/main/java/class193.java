import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
public final class class193 {
   @ObfuscatedName("s")
   class204 field3088 = new class204();
   @ObfuscatedName("j")
   int field3089;
   @ObfuscatedName("x")
   class196 field3090;
   @ObfuscatedName("p")
   int field3091;
   @ObfuscatedName("d")
   class203 field3092 = new class203();

   @ObfuscatedName("j")
   public void method3742(long var1) {
      class204 var3 = (class204)this.field3090.method3777(var1);
      if(var3 != null) {
         var3.method3898();
         var3.method3876();
         ++this.field3091;
      }

   }

   @ObfuscatedName("s")
   public class204 method3743(long var1) {
      class204 var3 = (class204)this.field3090.method3777(var1);
      if(var3 != null) {
         this.field3092.method3860(var3);
      }

      return var3;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "128"
   )
   public class193(int var1) {
      this.field3089 = var1;
      this.field3091 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.field3090 = new class196(var2);
   }

   @ObfuscatedName("p")
   public void method3745(class204 var1, long var2) {
      if(this.field3091 == 0) {
         class204 var4 = this.field3092.method3871();
         var4.method3898();
         var4.method3876();
         if(var4 == this.field3088) {
            var4 = this.field3092.method3871();
            var4.method3898();
            var4.method3876();
         }
      } else {
         --this.field3091;
      }

      this.field3090.method3778(var1, var2);
      this.field3092.method3860(var1);
   }

   @ObfuscatedName("x")
   public void method3750() {
      this.field3092.method3864();
      this.field3090.method3779();
      this.field3088 = new class204();
      this.field3091 = this.field3089;
   }
}
