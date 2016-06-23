import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class154 implements class112 {
   @ObfuscatedName("d")
   public static final class154 field2276 = new class154("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("f")
   public static final class154 field2277 = new class154("runescape", "RuneScape", 0);
   @ObfuscatedName("x")
   public static final class154 field2278 = new class154("game3", "Game 3", 2);
   @ObfuscatedName("b")
   public static final class154 field2279 = new class154("game4", "Game 4", 3);
   @ObfuscatedName("n")
   public final String field2280;
   @ObfuscatedName("l")
   public static final class154 field2281 = new class154("game5", "Game 5", 4);
   @ObfuscatedName("u")
   public static final class154 field2282 = new class154("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1554647969
   )
   final int field2283;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "69"
   )
   public int vmethod3194() {
      return this.field2283;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class154(String var1, String var2, int var3) {
      this.field2280 = var1;
      this.field2283 = var3;
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "174189633"
   )
   @Export("addMenuEntry")
   static final void method3182(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!client.field310) {
         if(client.field429 < 500) {
            client.field459[client.field429] = var0;
            client.field435[client.field429] = var1;
            client.field329[client.field429] = var2;
            client.field433[client.field429] = var3;
            client.field434[client.field429] = var4;
            client.field431[client.field429] = var5;
            ++client.field429;
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-2000769789"
   )
   static final int method3183(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class7.method109(var3, var5);
      int var8 = class7.method109(var3 + 1, var5);
      int var9 = class7.method109(var3, var5 + 1);
      int var10 = class7.method109(var3 + 1, var5 + 1);
      int var11 = class26.method679(var7, var8, var4, var2);
      int var12 = class26.method679(var9, var10, var4, var2);
      int var14 = 65536 - class91.field1577[var6 * 1024 / var2] >> 1;
      int var13 = (var12 * var14 >> 16) + ((65536 - var14) * var11 >> 16);
      return var13;
   }
}
