import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class98 {
   @ObfuscatedName("u")
   static final class201 field1518;
   @ObfuscatedName("h")
   static final class186 field1519;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -219163049
   )
   static int field1520;
   @ObfuscatedName("a")
   public static short[][] field1521;
   @ObfuscatedName("ee")
   static RSSocket field1523;
   @ObfuscatedName("i")
   @Export("chatLineMap")
   static final Map chatLineMap;

   static {
      chatLineMap = new HashMap();
      field1519 = new class186(1024);
      field1518 = new class201();
      field1520 = 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "38"
   )
   public static void method1866(Buffer var0, int var1) {
      if(class155.field2221 != null) {
         try {
            class155.field2221.method2358(0L);
            class155.field2221.method2356(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }
}
