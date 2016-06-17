import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
@Implements("NodeCache")
public final class class193 {
   @ObfuscatedName("j")
   int field3077;
   @ObfuscatedName("g")
   int field3078;
   @ObfuscatedName("d")
   @Export("table")
   class196 field3079;
   @ObfuscatedName("b")
   class204 field3080 = new class204();
   @ObfuscatedName("x")
   @Export("list")
   class203 field3081 = new class203();

   @ObfuscatedName("d")
   @Export("reset")
   public void method3755() {
      this.field3081.method3877();
      this.field3079.method3798();
      this.field3080 = new class204();
      this.field3077 = this.field3078;
   }

   @ObfuscatedName("g")
   @Export("remove")
   public void method3757(long var1) {
      class204 var3 = (class204)this.field3079.method3807(var1);
      if(var3 != null) {
         var3.method3916();
         var3.method3889();
         ++this.field3077;
      }

   }

   @ObfuscatedName("j")
   @Export("put")
   public void method3759(class204 var1, long var2) {
      if(this.field3077 == 0) {
         class204 var4 = this.field3081.method3886();
         var4.method3916();
         var4.method3889();
         if(var4 == this.field3080) {
            var4 = this.field3081.method3886();
            var4.method3916();
            var4.method3889();
         }
      } else {
         --this.field3077;
      }

      this.field3079.method3797(var1, var2);
      this.field3081.method3873(var1);
   }

   @ObfuscatedName("b")
   @Export("get")
   public class204 method3764(long var1) {
      class204 var3 = (class204)this.field3079.method3807(var1);
      if(var3 != null) {
         this.field3081.method3873(var3);
      }

      return var3;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "128"
   )
   public class193(int var1) {
      this.field3078 = var1;
      this.field3077 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.field3079 = new class196(var2);
   }
}
