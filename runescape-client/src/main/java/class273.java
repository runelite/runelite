import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
public class class273 implements Comparable {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   class280 field3678;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   class280 field3677;

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)Ljr;",
      garbageValue = "-212260818"
   )
   public class280 method5001() {
      return this.field3678;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "75"
   )
   public String method5011() {
      return this.field3678 == null?"":this.field3678.method5137();
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1708322748"
   )
   public String method5002() {
      return this.field3677 == null?"":this.field3677.method5137();
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;B)V",
      garbageValue = "31"
   )
   void method5017(class280 var1, class280 var2) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.field3678 = var1;
         this.field3677 = var2;
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lju;B)I",
      garbageValue = "1"
   )
   int vmethod5152(class273 var1) {
      return this.field3678.method5135(var1.field3678);
   }

   public int compareTo(Object var1) {
      return this.vmethod5152((class273)var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1590251870"
   )
   static int method5019(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 0) {
            var1 = 0;
         } else if(var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
