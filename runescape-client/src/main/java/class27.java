import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("ChatLineBuffer")
public class class27 {
   @ObfuscatedName("u")
   @Export("lines")
   class35[] field672 = new class35[100];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1975256125
   )
   @Export("length")
   int field673;
   @ObfuscatedName("l")
   public static File field674;
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = 1379356911
   )
   static int field677;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)Lclass35;",
      garbageValue = "-28"
   )
   class35 method681(int var1) {
      return var1 >= 0 && var1 < this.field673?this.field672[var1]:null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-912028200"
   )
   int method682() {
      return this.field673;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Lclass35;",
      garbageValue = "-44"
   )
   class35 method690(int var1, String var2, String var3, String var4) {
      class35 var5 = this.field672[99];

      for(int var6 = this.field673; var6 > 0; --var6) {
         if(var6 != 100) {
            this.field672[var6] = this.field672[var6 - 1];
         }
      }

      if(null == var5) {
         var5 = new class35(var1, var2, var4, var3);
      } else {
         var5.method3946();
         var5.method3922();
         var5.method776(var1, var2, var4, var3);
      }

      this.field672[0] = var5;
      if(this.field673 < 100) {
         ++this.field673;
      }

      return var5;
   }
}
