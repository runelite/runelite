import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
public class class98 {
   @ObfuscatedName("p")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("m")
   static final class186 field1517;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 208651473
   )
   static int field1518;
   @ObfuscatedName("q")
   public static Track1 field1522;
   @ObfuscatedName("e")
   static final class201 field1523;

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "1"
   )
   static final String method1748(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class15.method105('ﾀ') + var1.substring(0, var1.length() - 8) + "M  (" + var1 + ")</col>":(var1.length() > 6?" " + class15.method105(16777215) + var1.substring(0, var1.length() - 4) + "K  (" + var1 + ")</col>":" " + class15.method105(16776960) + var1 + "</col>");
   }

   static {
      chatLineMap = new HashMap();
      field1517 = new class186(1024);
      field1523 = new class201();
      field1518 = 0;
   }
}
