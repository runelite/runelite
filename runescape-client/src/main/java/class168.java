import java.awt.Component;
import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class168 {
   static {
      new HashMap();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "0"
   )
   static void method3057(Component var0) {
      var0.removeMouseListener(MouseInput.mouse);
      var0.removeMouseMotionListener(MouseInput.mouse);
      var0.removeFocusListener(MouseInput.mouse);
      MouseInput.field726 = 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lip;Lip;Lip;Lgl;I)Z",
      garbageValue = "1322937794"
   )
   public static boolean method3056(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, class204 var3) {
      class203.field2476 = var0;
      class203.field2469 = var1;
      class266.field3644 = var2;
      class203.field2470 = var3;
      return true;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "1856468625"
   )
   static int method3058(int var0, Script var1, boolean var2) {
      if(var0 == 5630) {
         Client.field967 = 250;
         return 1;
      } else {
         return 2;
      }
   }
}
