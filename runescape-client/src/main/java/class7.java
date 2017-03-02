import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
final class class7 implements Comparator {
   @ObfuscatedName("a")
   static ModIcon[] field64;

   public int compare(Object var1, Object var2) {
      return this.method107((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "2032436748"
   )
   int method107(class2 var1, class2 var2) {
      return var1.field27 < var2.field27?-1:(var2.field27 == var1.field27?0:1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "61"
   )
   static final void method109() {
      if(Client.field337 > 0) {
         WidgetNode.method200();
      } else {
         GameObject.setGameState(40);
         class152.field2056 = class5.field46;
         class5.field46 = null;
      }
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1071733823"
   )
   static final int method110() {
      return Client.menuOptionCount <= 0?-1:(Client.field433 && class105.field1700[81] && Client.field432 != -1?Client.field432:Client.menuOptionCount - 1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZIZI)I",
      garbageValue = "832903493"
   )
   static int method111(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = WidgetNode.method202(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = WidgetNode.method202(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }
}
