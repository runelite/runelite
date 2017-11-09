import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class158 {
   @ObfuscatedName("m")
   public static boolean field2169;
   @ObfuscatedName("p")
   public static File field2167;
   @ObfuscatedName("i")
   static Hashtable field2168;

   static {
      field2169 = false;
      field2168 = new Hashtable(16);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "-1865269288"
   )
   static final int method3084(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - Graphics3D.COSINE[var2 * 1024 / var3] >> 1;
      return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "([Lhk;IB)V",
      garbageValue = "43"
   )
   static final void method3085(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method3085(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  int var5 = var4.id;
                  if(CombatInfoListHolder.loadWidget(var5)) {
                     method3085(class243.widgets[var5], var1);
                  }
               }
            }

            ScriptEvent var6;
            if(var1 == 0 && var3.field2833 != null) {
               var6 = new ScriptEvent();
               var6.widget = var3;
               var6.field791 = var3.field2833;
               class111.method2177(var6);
            }

            if(var1 == 1 && var3.field2721 != null) {
               if(var3.index >= 0) {
                  Widget var7 = PendingSpawn.method1612(var3.id);
                  if(var7 == null || var7.children == null || var3.index >= var7.children.length || var3 != var7.children[var3.index]) {
                     continue;
                  }
               }

               var6 = new ScriptEvent();
               var6.widget = var3;
               var6.field791 = var3.field2721;
               class111.method2177(var6);
            }
         }
      }

   }
}
