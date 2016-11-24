import java.awt.Canvas;
import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class107 {
   @ObfuscatedName("ql")
   @Export("canvas")
   public static Canvas canvas;
   @ObfuscatedName("d")
   static File field1726;
   @ObfuscatedName("m")
   static Hashtable field1727 = new Hashtable(16);
   @ObfuscatedName("q")
   static int[] field1728;
   @ObfuscatedName("v")
   static class20 field1729;
   @ObfuscatedName("i")
   static int[] field1730;
   @ObfuscatedName("n")
   static boolean field1735 = false;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "-29"
   )
   public static final boolean method2082(String var0, String var1, String var2, String var3) {
      return null != var0 && null != var2?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "56"
   )
   static final void method2085(int var0) {
      if(class60.method1127(var0)) {
         class104.method2043(Widget.widgets[var0], -1);
      }
   }
}
