import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("ChatLineBuffer")
public class class29 {
   @ObfuscatedName("ad")
   static int[] field699;
   @ObfuscatedName("g")
   @Export("lines")
   class37[] field700 = new class37[100];
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 295762615
   )
   @Export("length")
   int field701;
   @ObfuscatedName("lh")
   static class133 field706;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-37"
   )
   int method669() {
      return this.field701;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lclass37;",
      garbageValue = "823588420"
   )
   class37 method670(int var1) {
      return var1 >= 0 && var1 < this.field701?this.field700[var1]:null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lclass37;",
      garbageValue = "-86023179"
   )
   class37 method674(int var1, String var2, String var3, String var4) {
      class37 var5 = this.field700[99];

      for(int var6 = this.field701; var6 > 0; --var6) {
         if(var6 != 100) {
            this.field700[var6] = this.field700[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new class37(var1, var2, var4, var3);
      } else {
         var5.method4067();
         var5.method4045();
         var5.method780(var1, var2, var4, var3);
      }

      this.field700[0] = var5;
      if(this.field701 < 100) {
         ++this.field701;
      }

      return var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lclass53;",
      garbageValue = "-1870535716"
   )
   public static class53 method679(int var0) {
      class53 var1 = (class53)class53.field1167.method3905((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class53.field1164.method3411(15, var0);
         var1 = new class53();
         if(var2 != null) {
            var1.method1134(new class122(var2));
         }

         class53.field1167.method3907(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "4032"
   )
   static final boolean method680(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = client.field438[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }
}
