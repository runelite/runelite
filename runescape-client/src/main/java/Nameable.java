import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
@Implements("Nameable")
public class Nameable implements Comparable {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("name")
   Name name;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   Name field3677;

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)Ljr;",
      garbageValue = "-212260818"
   )
   public Name method5001() {
      return this.name;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "75"
   )
   public String method5011() {
      return this.name == null?"":this.name.getName();
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1708322748"
   )
   public String method5002() {
      return this.field3677 == null?"":this.field3677.getName();
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;B)V",
      garbageValue = "31"
   )
   void method5017(Name var1, Name var2) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name = var1;
         this.field3677 = var2;
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lju;B)I",
      garbageValue = "1"
   )
   int vmethod5152(Nameable var1) {
      return this.name.method5135(var1.name);
   }

   public int compareTo(Object var1) {
      return this.vmethod5152((Nameable)var1);
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
