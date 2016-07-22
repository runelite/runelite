import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("ChatLineBuffer")
public class class29 {
   @ObfuscatedName("x")
   static class83[] field684;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1136035447
   )
   @Export("length")
   int field686;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = -1110979599
   )
   static int field687;
   @ObfuscatedName("w")
   @Export("lines")
   class37[] field692 = new class37[100];

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "200000"
   )
   int method649() {
      return this.field686;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Lclass37;",
      garbageValue = "-47"
   )
   class37 method651(int var1) {
      return var1 >= 0 && var1 < this.field686?this.field692[var1]:null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lclass37;",
      garbageValue = "-1260266393"
   )
   class37 method655(int var1, String var2, String var3, String var4) {
      class37 var5 = this.field692[99];

      for(int var6 = this.field686; var6 > 0; --var6) {
         if(var6 != 100) {
            this.field692[var6] = this.field692[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new class37(var1, var2, var4, var3);
      } else {
         var5.method3990();
         var5.method3960();
         var5.method755(var1, var2, var4, var3);
      }

      this.field692[0] = var5;
      if(this.field686 < 100) {
         ++this.field686;
      }

      return var5;
   }
}
