import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gc")
@Implements("NodeCache")
public final class class196 {
   @ObfuscatedName("g")
   int field3136;
   @ObfuscatedName("r")
   int field3137;
   @ObfuscatedName("h")
   @Export("list")
   class206 field3138 = new class206();
   @ObfuscatedName("e")
   @Export("table")
   class199 field3139;
   @ObfuscatedName("l")
   class207 field3140 = new class207();

   @ObfuscatedName("l")
   @Export("get")
   public class207 method3905(long var1) {
      class207 var3 = (class207)this.field3139.method3936(var1);
      if(var3 != null) {
         this.field3138.method4033(var3);
      }

      return var3;
   }

   @ObfuscatedName("g")
   @Export("remove")
   public void method3906(long var1) {
      class207 var3 = (class207)this.field3139.method3936(var1);
      if(var3 != null) {
         var3.method4067();
         var3.method4045();
         ++this.field3137;
      }

   }

   @ObfuscatedName("r")
   @Export("put")
   public void method3907(class207 var1, long var2) {
      if(this.field3137 == 0) {
         class207 var4 = this.field3138.method4032();
         var4.method4067();
         var4.method4045();
         if(var4 == this.field3140) {
            var4 = this.field3138.method4032();
            var4.method4067();
            var4.method4045();
         }
      } else {
         --this.field3137;
      }

      this.field3139.method3940(var1, var2);
      this.field3138.method4033(var1);
   }

   @ObfuscatedName("e")
   @Export("reset")
   public void method3910() {
      this.field3138.method4034();
      this.field3139.method3938();
      this.field3140 = new class207();
      this.field3137 = this.field3136;
   }

   public class196(int var1) {
      this.field3136 = var1;
      this.field3137 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.field3139 = new class199(var2);
   }
}
