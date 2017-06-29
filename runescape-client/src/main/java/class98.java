import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
public class class98 {
   @ObfuscatedName("cu")
   static IndexData field1545;
   @ObfuscatedName("w")
   static final class186 field1546;
   @ObfuscatedName("i")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("a")
   static final class201 field1548;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -652468689
   )
   static int field1549;

   static {
      chatLineMap = new HashMap();
      field1546 = new class186(1024);
      field1548 = new class201();
      field1549 = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "1958401174"
   )
   public static void method1859(IndexDataBase var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.method4146(var1);
      int var6 = var0.method4131(var5, var2);
      class29.method232(var0, var5, var6, var3, var4);
   }
}
