import java.io.File;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public class class104 {
   @ObfuscatedName("k")
   public static class72 field1689 = null;
   @ObfuscatedName("v")
   static File field1692;
   @ObfuscatedName("o")
   public static class72 field1695 = null;
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = 1757424243
   )
   protected static int field1698;
   @ObfuscatedName("f")
   public static class72 field1699 = null;

   class104() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;I)V",
      garbageValue = "-2097742495"
   )
   public static void method2089(class182 var0, class182 var1) {
      NPCComposition.field3036 = var0;
      NPCComposition.field3007 = var1;
   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "68"
   )
   static final void method2090(int var0, int var1) {
      if(Projectile.method874(var0)) {
         class97.method2028(class231.widgets[var0], var1);
      }
   }
}
