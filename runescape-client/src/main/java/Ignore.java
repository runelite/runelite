import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("h")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("ph")
   static short[] field145;
   @ObfuscatedName("i")
   @Export("name")
   String name;

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1176771647"
   )
   static final void method102(int var0, int var1) {
      if(Client.field306 == 2) {
         class116.method2468(Client.field540 + (Client.field321 - class193.baseX << 7), (Client.field529 - DecorativeObject.baseY << 7) + Client.field325, Client.field323 * 2);
         if(Client.field445 > -1 && Client.gameCycle % 20 < 10) {
            class137.field2130[0].method1810(Client.field445 + var0 - 12, Client.field418 + var1 - 28);
         }

      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BZB)Ljava/lang/Object;",
      garbageValue = "-15"
   )
   public static Object method103(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class128.field2084) {
            try {
               class121 var2 = new class121();
               var2.vmethod2823(var0);
               return var2;
            } catch (Throwable var3) {
               class128.field2084 = true;
            }
         }

         return var0;
      }
   }
}
