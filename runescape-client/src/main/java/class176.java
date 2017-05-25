import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public abstract class class176 {
   @ObfuscatedName("rl")
   static class13 field2402;
   @ObfuscatedName("h")
   static boolean field2405;

   static {
      field2405 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "33"
   )
   abstract byte[] vmethod3421();

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1237361257"
   )
   abstract void vmethod3431(byte[] var1);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass219;I)Z",
      garbageValue = "93774295"
   )
   public static boolean method3440(class219 var0) {
      return var0 == class219.field2791 || class219.field2783 == var0 || var0 == class219.field2782 || class219.field2785 == var0 || var0 == class219.field2786 || var0 == class219.field2787 || class219.field2788 == var0 || var0 == class219.field2789;
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "2027456289"
   )
   @Export("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      class31.method269(var0, var1, var2, var3, var4, var5, false);
   }
}
