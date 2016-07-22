import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gi")
@Implements("NodeCache")
public final class class196 {
   @ObfuscatedName("w")
   int field3129;
   @ObfuscatedName("o")
   @Export("table")
   class199 field3130;
   @ObfuscatedName("m")
   class207 field3131 = new class207();
   @ObfuscatedName("e")
   int field3132;
   @ObfuscatedName("g")
   @Export("list")
   class206 field3133 = new class206();

   @ObfuscatedName("w")
   @Export("remove")
   public void method3813(long var1) {
      class207 var3 = (class207)this.field3130.method3856(var1);
      if(var3 != null) {
         var3.method3990();
         var3.method3960();
         ++this.field3132;
      }

   }

   public class196(int var1) {
      this.field3129 = var1;
      this.field3132 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.field3130 = new class199(var2);
   }

   @ObfuscatedName("o")
   @Export("reset")
   public void method3814() {
      this.field3133.method3940();
      this.field3130.method3851();
      this.field3131 = new class207();
      this.field3132 = this.field3129;
   }

   @ObfuscatedName("m")
   @Export("get")
   public class207 method3817(long var1) {
      class207 var3 = (class207)this.field3130.method3856(var1);
      if(var3 != null) {
         this.field3133.method3946(var3);
      }

      return var3;
   }

   @ObfuscatedName("e")
   @Export("put")
   public void method3823(class207 var1, long var2) {
      if(this.field3132 == 0) {
         class207 var4 = this.field3133.method3941();
         var4.method3990();
         var4.method3960();
         if(var4 == this.field3131) {
            var4 = this.field3133.method3941();
            var4.method3990();
            var4.method3960();
         }
      } else {
         --this.field3132;
      }

      this.field3130.method3849(var1, var2);
      this.field3133.method3946(var1);
   }
}
