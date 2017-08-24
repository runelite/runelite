import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ki")
public class class288 {
   @ObfuscatedName("k")
   boolean field3800;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2060181289
   )
   int field3805;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   IndexDataBase field3806;
   @ObfuscatedName("n")
   String field3799;

   @ObfuscatedSignature(
      signature = "(Lii;)V"
   )
   class288(IndexDataBase var1) {
      this.field3805 = 0;
      this.field3800 = false;
      this.field3806 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2080623089"
   )
   int method5145() {
      if(this.field3805 < 25) {
         if(!this.field3806.method4155(class40.field559.field556, this.field3799)) {
            return this.field3805;
         }

         this.field3805 = 25;
      }

      if(this.field3805 == 25) {
         if(!this.field3806.method4155(this.field3799, class40.field558.field556)) {
            return 25 + this.field3806.method4158(this.field3799) * 25 / 100;
         }

         this.field3805 = 50;
      }

      if(this.field3805 == 50) {
         if(this.field3806.method4198(class40.field557.field556, this.field3799) && !this.field3806.method4155(class40.field557.field556, this.field3799)) {
            return 50;
         }

         this.field3805 = 75;
      }

      if(this.field3805 == 75) {
         if(!this.field3806.method4155(this.field3799, class40.field555.field556)) {
            return 75;
         }

         this.field3805 = 100;
         this.field3800 = true;
      }

      return this.field3805;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "820971644"
   )
   boolean method5146() {
      return this.field3800;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-883430947"
   )
   void method5143(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3799) {
            this.field3799 = var1;
            this.field3805 = 0;
            this.field3800 = false;
            this.method5145();
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-892820845"
   )
   int method5147() {
      return this.field3805;
   }
}
