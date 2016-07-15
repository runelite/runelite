import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class11 {
   @ObfuscatedName("c")
   static final class203 field184 = new class203();
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1853568791
   )
   static int field185 = 0;
   @ObfuscatedName("kp")
   @Export("chatMessages")
   static class19 field187;
   @ObfuscatedName("l")
   static final class201 field188 = new class201(1024);
   @ObfuscatedName("ih")
   static class32 field189;
   @ObfuscatedName("e")
   @Export("chatLineMap")
   static final Map field191 = new HashMap();
   @ObfuscatedName("r")
   public static int[] field192;

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "([Lclass176;Lclass176;ZS)V",
      garbageValue = "5379"
   )
   static void method138(class176[] var0, class176 var1, boolean var2) {
      int var3 = var1.field2817 != 0?var1.field2817:var1.field2866;
      int var4 = var1.field2867 != 0?var1.field2867:var1.field2810;
      class125.method2871(var0, var1.field2794, var3, var4, var2);
      if(null != var1.field2827) {
         class125.method2871(var1.field2827, var1.field2794, var3, var4, var2);
      }

      class3 var5 = (class3)client.field455.method3864((long)var1.field2794);
      if(null != var5) {
         class118.method2544(var5.field60, var3, var4, var2);
      }

      if(var1.field2916 == 1337) {
         ;
      }

   }
}
