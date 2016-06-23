import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gp")
@Implements("NodeCache")
public final class class193 {
   @ObfuscatedName("l")
   @Export("list")
   class203 field3079 = new class203();
   @ObfuscatedName("u")
   int field3080;
   @ObfuscatedName("x")
   int field3081;
   @ObfuscatedName("b")
   @Export("table")
   class196 field3082;
   @ObfuscatedName("f")
   class204 field3083 = new class204();

   @ObfuscatedName("x")
   @Export("put")
   public void method3788(class204 var1, long var2) {
      if(this.field3081 == 0) {
         class204 var4 = this.field3079.method3902();
         var4.method3946();
         var4.method3922();
         if(var4 == this.field3083) {
            var4 = this.field3079.method3902();
            var4.method3946();
            var4.method3922();
         }
      } else {
         --this.field3081;
      }

      this.field3082.method3826(var1, var2);
      this.field3079.method3908(var1);
   }

   @ObfuscatedName("u")
   @Export("remove")
   public void method3789(long var1) {
      class204 var3 = (class204)this.field3082.method3822(var1);
      if(var3 != null) {
         var3.method3946();
         var3.method3922();
         ++this.field3081;
      }

   }

   public class193(int var1) {
      this.field3080 = var1;
      this.field3081 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.field3082 = new class196(var2);
   }

   @ObfuscatedName("b")
   @Export("reset")
   public void method3796() {
      this.field3079.method3904();
      this.field3082.method3824();
      this.field3083 = new class204();
      this.field3081 = this.field3080;
   }

   @ObfuscatedName("f")
   @Export("get")
   public class204 method3797(long var1) {
      class204 var3 = (class204)this.field3082.method3822(var1);
      if(var3 != null) {
         this.field3079.method3908(var3);
      }

      return var3;
   }
}
