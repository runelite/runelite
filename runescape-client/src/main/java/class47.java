import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class47 {
   @ObfuscatedName("i")
   static final class121 field949 = new class121(1024);
   @ObfuscatedName("j")
   static ModIcon field951;
   @ObfuscatedName("u")
   static final class136 field952 = new class136();
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1539242675
   )
   static int field953 = 0;
   @ObfuscatedName("l")
   public static IndexDataBase field956;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = -792964549
   )
   static int field957;
   @ObfuscatedName("f")
   @Export("chatLineMap")
   static final Map chatLineMap = new HashMap();
   @ObfuscatedName("mc")
   static byte field959;

   class47() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1701645463"
   )
   public static void method919() {
      class196.field2875.reset();
      class196.spriteCache.reset();
      class196.field2877.reset();
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIBI)V",
      garbageValue = "-467594523"
   )
   static final void method920(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.method207();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var9 = var0.method207();
            Client.field582.field1874 = var1;
            Client.field582.field1882 = var2;
            Client.field582.field1876 = 1;
            Client.field582.field1875 = 1;
            class22 var10 = Client.field582;
            int var11 = class109.method2098(var4, var5, var9, var10, Client.collisionMaps[var0.field276], true, Client.field583, Client.field584);
            if(var11 >= 1) {
               for(int var12 = 0; var12 < var11 - 1; ++var12) {
                  var0.method211(Client.field583[var12], Client.field584[var12], var3);
               }

            }
         }
      }
   }
}
