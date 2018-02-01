import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class40 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   public static final class40 field508;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   public static final class40 field505;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   public static final class40 field506;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   public static final class40 field512;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   public static final class40 field507;
   @ObfuscatedName("a")
   public final String field509;

   static {
      field508 = new class40("details");
      field505 = new class40("compositemap");
      field506 = new class40("compositetexture");
      field512 = new class40("area");
      field507 = new class40("labels");
   }

   class40(String var1) {
      this.field509 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lik;Lik;B)V",
      garbageValue = "1"
   )
   public static void method549(IndexDataBase var0, IndexDataBase var1) {
      class188.SpotAnimationDefinition_indexCache = var0;
      Spotanim.SpotAnimationDefinition_modelIndexCache = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-491731803"
   )
   static final int method548(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
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
