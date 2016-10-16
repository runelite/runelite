import java.util.Comparator;
import java.util.Date;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
final class class221 implements Comparator {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "36"
   )
   int method3966(class217 var1, class217 var2) {
      return var1.field3198 < var2.field3198?-1:(var1.field3198 == var2.field3198?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3966((class217)var1, (class217)var2);
   }

   @ObfuscatedName("s")
   public static String method3973(long var0) {
      class114.field1989.setTime(new Date(var0));
      int var2 = class114.field1989.get(7);
      int var3 = class114.field1989.get(5);
      int var4 = class114.field1989.get(2);
      int var5 = class114.field1989.get(1);
      int var6 = class114.field1989.get(11);
      int var7 = class114.field1989.get(12);
      int var8 = class114.field1989.get(13);
      return class114.field1991[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class114.field1987[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }
}
