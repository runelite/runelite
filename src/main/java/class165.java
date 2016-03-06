import java.util.Date;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fb")
public class class165 {
   @ObfuscatedName("j")
   public static String method3208(long var0) {
      class110.field1957.setTime(new Date(var0));
      int var2 = class110.field1957.get(7);
      int var3 = class110.field1957.get(5);
      int var4 = class110.field1957.get(2);
      int var5 = class110.field1957.get(1);
      int var6 = class110.field1957.get(11);
      int var7 = class110.field1957.get(12);
      int var8 = class110.field1957.get(13);
      return class110.field1956[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class110.field1958[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }
}
