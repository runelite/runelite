import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public class class154 extends class297 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static IndexDataBase field2136;
   @ObfuscatedName("p")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("c")
   final boolean field2135;

   public class154(boolean var1) {
      this.field2135 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;I)I",
      garbageValue = "-1898531544"
   )
   int method3159(ChatPlayer var1, ChatPlayer var2) {
      if(var1.world != 0) {
         if(var2.world == 0) {
            return this.field2135?-1:1;
         }
      } else if(var2.world != 0) {
         return this.field2135?1:-1;
      }

      return this.method5288(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3159((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljm;I)V",
      garbageValue = "-1955080323"
   )
   public static void method3158(IndexDataBase var0) {
      VarCString.field3483 = var0;
   }
}
