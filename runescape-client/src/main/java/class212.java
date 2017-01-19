import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
public class class212 {
   @ObfuscatedName("gg")
   public static final int[] field3139 = new int[]{0, 0, 0, 0, 0, 6, 0, 0, 0, 0, -2, 0, -2, -2, 1, 0, 0, -2, 0, 0, 2, 5, 0, 0, 0, 0, 0, 6, 0, 0, -2, 0, -1, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 15, -2, 8, 0, -2, 0, -2, 0, 0, 4, 0, 8, 0, 7, -2, 0, 0, 5, 28, -2, 0, 0, 0, 2, 0, 4, 0, -2, 6, 6, 0, 7, 0, -2, 6, 0, 0, 0, 0, 0, 0, 6, 0, 1, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 5, 2, 0, 4, 6, -2, 0, 0, 0, 6, 8, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 3, 0, 0, 0, 8, 0, 0, 4, 3, 0, 4, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 2, 0, 1, 0, -1, 0, 6, 0, 0, 0, 0, 2, -1, 0, 0, -1, 0, 2, 0, 0, 6, 0, 0, 0, 0, -2, 0, 0, 6, -1, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0, 20, 0, 2, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 4, -2, 12, 0, 0, 0, 0, 0, 0, 0, 0};

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1738814350"
   )
   static final void method3826(boolean var0) {
      ChatMessages.method830();
      ++Client.field342;
      if(Client.field342 >= 50 || var0) {
         Client.field342 = 0;
         if(!Client.field473 && null != class30.field698) {
            Client.field336.method2963(71);

            try {
               class30.field698.method2015(Client.field336.payload, 0, Client.field336.offset);
               Client.field336.offset = 0;
            } catch (IOException var2) {
               Client.field473 = true;
            }
         }

      }
   }
}
