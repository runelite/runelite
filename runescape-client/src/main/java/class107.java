import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
public class class107 {
   @ObfuscatedName("lr")
   static class216 field1740;
   @ObfuscatedName("j")
   public static File field1741;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -1352195229
   )
   static int field1744;
   @ObfuscatedName("c")
   static Hashtable field1745 = new Hashtable(16);
   @ObfuscatedName("mf")
   static byte field1746;
   @ObfuscatedName("x")
   public static boolean field1747 = false;

   class107() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZB)V",
      garbageValue = "61"
   )
   static void method2100(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class178.method3289(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class178.method3289(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method2405((long)var1.id);
      if(null != var5) {
         int var6 = var5.id;
         if(class44.method892(var6)) {
            class178.method3289(Widget.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
