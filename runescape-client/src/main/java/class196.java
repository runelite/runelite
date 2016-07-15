import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gd")
@Implements("NodeCache")
public final class class196 {
   @ObfuscatedName("r")
   @Export("list")
   class206 field3124 = new class206();
   @ObfuscatedName("e")
   class207 field3125 = new class207();
   @ObfuscatedName("c")
   int field3126;
   @ObfuscatedName("h")
   @Export("table")
   class199 field3127;
   @ObfuscatedName("l")
   int field3128;

   @ObfuscatedName("l")
   @Export("remove")
   public void method3833(long var1) {
      class207 var3 = (class207)this.field3127.method3864(var1);
      if(var3 != null) {
         var3.method4000();
         var3.method3978();
         ++this.field3126;
      }

   }

   @ObfuscatedName("e")
   @Export("get")
   public class207 method3834(long var1) {
      class207 var3 = (class207)this.field3127.method3864(var1);
      if(var3 != null) {
         this.field3124.method3963(var3);
      }

      return var3;
   }

   @ObfuscatedName("h")
   @Export("reset")
   public void method3835() {
      this.field3124.method3966();
      this.field3127.method3877();
      this.field3125 = new class207();
      this.field3126 = this.field3128;
   }

   @ObfuscatedName("c")
   @Export("put")
   public void method3836(class207 var1, long var2) {
      if(this.field3126 == 0) {
         class207 var4 = this.field3124.method3969();
         var4.method4000();
         var4.method3978();
         if(var4 == this.field3125) {
            var4 = this.field3124.method3969();
            var4.method4000();
            var4.method3978();
         }
      } else {
         --this.field3126;
      }

      this.field3127.method3865(var1, var2);
      this.field3124.method3963(var1);
   }

   public class196(int var1) {
      this.field3128 = var1;
      this.field3126 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.field3127 = new class199(var2);
   }
}
