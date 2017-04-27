import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
final class class7 implements Comparator {
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = -477881173
   )
   static int field60;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = 1186280349
   )
   static int field63;
   @ObfuscatedName("s")
   static String field64;

   public int compare(Object var1, Object var2) {
      return this.method89((class2)var1, (class2)var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-1937463184"
   )
   int method89(class2 var1, class2 var2) {
      return var1.field25 < var2.field25?-1:(var1.field25 == var2.field25?0:1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "335901345"
   )
   public static void method91() {
      class198.field2871.reset();
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "([BII)V",
      garbageValue = "536148521"
   )
   static void method98(byte[] var0, int var1) {
      if(Client.field297 == null) {
         Client.field297 = new byte[24];
      }

      class139.method2678(var0, var1, Client.field297, 0, 24);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LWorld;I)V",
      garbageValue = "1845296922"
   )
   static void method100(World var0) {
      if(var0.method603() != Client.isMembers) {
         Client.isMembers = var0.method603();
         class45.method838(var0.method603());
      }

      Script.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class18.field194 = Client.field283 == 0?'ꩊ':var0.id + '鱀';
      RSSocket.field1747 = Client.field283 == 0?443:var0.id + '썐';
      class109.field1736 = class18.field194;
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-237762196"
   )
   static final void method101(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class112.method2112(var0)) {
         class132.method2624(class133.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZIZI)I",
      garbageValue = "-2007739801"
   )
   static int method102(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = class49.method913(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = class49.method913(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }
}
