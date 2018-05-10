import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
final class class6 implements Comparator {
   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   @Export("indexCache15")
   static IndexData indexCache15;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lq;Lq;B)I",
      garbageValue = "70"
   )
   int method70(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.method16().compareTo(var2.method16());
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method70((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lbb;Lbb;IZIZI)I",
      garbageValue = "325414181"
   )
   static int method71(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = class219.method4361(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = class219.method4361(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }
}
