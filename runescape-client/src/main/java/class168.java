import java.util.Date;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fq")
public class class168 {
   @ObfuscatedName("u")
   static boolean field2173;

   @ObfuscatedName("u")
   public static String method3162(long var0) {
      class162.field2132.setTime(new Date(var0));
      int var2 = class162.field2132.get(7);
      int var3 = class162.field2132.get(5);
      int var4 = class162.field2132.get(2);
      int var5 = class162.field2132.get(1);
      int var6 = class162.field2132.get(11);
      int var7 = class162.field2132.get(12);
      int var8 = class162.field2132.get(13);
      return class162.field2131[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class162.field2130[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }
}
