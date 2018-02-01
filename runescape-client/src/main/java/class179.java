import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class179 {
   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   @Export("mapscene")
   static IndexedSprite[] mapscene;

   static {
      new HashMap();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-371985669"
   )
   public static void method3371() {
      ObjectComposition.objects.reset();
      ObjectComposition.field3498.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3536.reset();
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1926894885"
   )
   static final void method3376(boolean var0) {
      if(var0) {
         Client.field860 = class89.field1329?class148.field2079:class148.field2074;
      } else {
         Client.field860 = class221.preferences.preferences.containsKey(Integer.valueOf(class185.method3623(class89.username)))?class148.field2080:class148.field2075;
      }

   }
}
