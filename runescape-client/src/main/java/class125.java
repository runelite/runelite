import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
public class class125 {
   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "0"
   )
   static final void method2354(String var0) {
      if(Client.clanMembers != null) {
         Client.secretPacketBuffer1.putOpcode(124);
         Client.secretPacketBuffer1.putByte(class36.method753(var0));
         Client.secretPacketBuffer1.method2504(var0);
      }
   }

   class125() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1176192977"
   )
   static int method2355(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class128.method2364(class32.field720[--class32.field715]);
      } else {
         var3 = var2?class200.field2894:Script.field942;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class32.field720[--class32.field715] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.method3232(var4, class32.scriptStringStack[--class32.scriptStringStackSize]);
            return 1;
         } else {
            --class32.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class32.field715 -= 2;
         var4 = class32.field720[class32.field715];
         int var5 = class32.field720[class32.field715 + 1];
         var3.dragParent = class0.method13(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2290 = class32.field720[--class32.field715] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2283 = class32.field720[--class32.field715];
         return 1;
      } else if(var0 == 1304) {
         var3.field2284 = class32.field720[--class32.field715];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class32.scriptStringStack[--class32.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.field2286 = class32.scriptStringStack[--class32.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }
}
