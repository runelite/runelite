import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("ChatLineBuffer")
public class class29 {
   @ObfuscatedName("l")
   @Export("lines")
   class37[] field706 = new class37[100];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1648523639
   )
   @Export("length")
   int field707;
   @ObfuscatedName("ay")
   static class81[] field708;
   @ObfuscatedName("o")
   static class83[] field712;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lclass37;",
      garbageValue = "1412914549"
   )
   class37 method649(int var1, String var2, String var3, String var4) {
      class37 var5 = this.field706[99];

      for(int var6 = this.field707; var6 > 0; --var6) {
         if(var6 != 100) {
            this.field706[var6] = this.field706[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new class37(var1, var2, var4, var3);
      } else {
         var5.method4000();
         var5.method3978();
         var5.method773(var1, var2, var4, var3);
      }

      this.field706[0] = var5;
      if(this.field707 < 100) {
         ++this.field707;
      }

      return var5;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1186901219"
   )
   public static int method650(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)Lclass37;",
      garbageValue = "46"
   )
   class37 method651(int var1) {
      return var1 >= 0 && var1 < this.field707?this.field706[var1]:null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1735632398"
   )
   int method654() {
      return this.field707;
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "-5142"
   )
   static final void method659(int var0, int var1) {
      if(class10.method112(var0)) {
         class28.method647(class176.field2811[var0], var1);
      }
   }
}
