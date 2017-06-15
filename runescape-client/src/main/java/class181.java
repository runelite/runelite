import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class181 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1428275751
   )
   public static int field2449;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "1550632128"
   )
   public static void method3329(IndexDataBase var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.method4055(var1);
      int var6 = var0.method4020(var5, var2);
      class13.method75(var0, var5, var6, var3, var4);
   }
}
