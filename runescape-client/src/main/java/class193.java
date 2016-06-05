import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
@Implements("NodeCache")
public final class class193 {
   @ObfuscatedName("g")
   int field3088;
   @ObfuscatedName("i")
   int field3089;
   @ObfuscatedName("h")
   @Export("table")
   class196 field3090;
   @ObfuscatedName("t")
   class204 field3091 = new class204();
   @ObfuscatedName("z")
   @Export("list")
   class203 field3092 = new class203();

   @ObfuscatedName("i")
   @Export("remove")
   public void method3715(long var1) {
      class204 var3 = (class204)this.field3090.method3748(var1);
      if(var3 != null) {
         var3.method3870();
         var3.method3844();
         ++this.field3088;
      }

   }

   @ObfuscatedName("t")
   @Export("get")
   public class204 method3716(long var1) {
      class204 var3 = (class204)this.field3090.method3748(var1);
      if(var3 != null) {
         this.field3092.method3837(var3);
      }

      return var3;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "128"
   )
   public class193(int var1) {
      this.field3089 = var1;
      this.field3088 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.field3090 = new class196(var2);
   }

   @ObfuscatedName("h")
   @Export("reset")
   public void method3717() {
      this.field3092.method3835();
      this.field3090.method3750();
      this.field3091 = new class204();
      this.field3088 = this.field3089;
   }

   @ObfuscatedName("g")
   @Export("put")
   public void method3724(class204 var1, long var2) {
      if(this.field3088 == 0) {
         class204 var4 = this.field3092.method3830();
         var4.method3870();
         var4.method3844();
         if(var4 == this.field3091) {
            var4 = this.field3092.method3830();
            var4.method3870();
            var4.method3844();
         }
      } else {
         --this.field3088;
      }

      this.field3090.method3749(var1, var2);
      this.field3092.method3837(var1);
   }
}
