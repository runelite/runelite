import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1154346919
   )
   @Export("authCodeForLogin")
   static int authCodeForLogin;
   @ObfuscatedName("c")
   @Export("name")
   String name;
   @ObfuscatedName("o")
   @Export("previousName")
   String previousName;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lby;B)V",
      garbageValue = "32"
   )
   public static void method1054(ScriptEvent var0) {
      class17.method123(var0, 200000);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lcx;I)V",
      garbageValue = "-2134044293"
   )
   public static final void method1055(class103 var0) {
      class22.field332 = var0;
   }
}
