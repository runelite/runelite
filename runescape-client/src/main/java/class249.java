import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
public class class249 {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lit;III)Z",
      garbageValue = "-1684833447"
   )
   public static boolean method4517(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         Timer.decodeSprite(var3);
         return true;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "2112823440"
   )
   static void method4518(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(KeyFocusListener.keyboard);
      var0.addFocusListener(KeyFocusListener.keyboard);
   }
}
