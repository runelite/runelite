import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("ChatLineBuffer")
public class class27 {
   @ObfuscatedName("g")
   @Export("lines")
   class35[] field666 = new class35[100];
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 520189493
   )
   @Export("length")
   int field667;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lclass35;",
      garbageValue = "84646984"
   )
   class35 method639(int var1, String var2, String var3, String var4) {
      class35 var5 = this.field666[99];

      for(int var6 = this.field667; var6 > 0; --var6) {
         if(var6 != 100) {
            this.field666[var6] = this.field666[var6 - 1];
         }
      }

      if(null == var5) {
         var5 = new class35(var1, var2, var4, var3);
      } else {
         var5.method3916();
         var5.method3889();
         var5.method738(var1, var2, var4, var3);
      }

      this.field666[0] = var5;
      if(this.field667 < 100) {
         ++this.field667;
      }

      return var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Lclass35;",
      garbageValue = "38"
   )
   class35 method640(int var1) {
      return var1 >= 0 && var1 < this.field667?this.field666[var1]:null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "562320997"
   )
   int method641() {
      return this.field667;
   }
}
