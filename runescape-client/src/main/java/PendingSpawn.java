import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2007567981
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 271344379
   )
   @Export("hitpoints")
   int hitpoints;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1715079311
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2021442699
   )
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 607610401
   )
   @Export("level")
   int level;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 17787575
   )
   int field1177;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2005222605
   )
   int field1166;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1939599619
   )
   @Export("type")
   int type;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2018732539
   )
   int field1168;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1262223117
   )
   @Export("id")
   int id;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2114826035
   )
   int field1163;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 73684589
   )
   @Export("orientation")
   int orientation;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "79"
   )
   static void method1526(String var0, String var1, String var2) {
      class92.loginMessage1 = var0;
      class92.loginMessage2 = var1;
      class92.loginMessage3 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILhh;B)Lcd;",
      garbageValue = "3"
   )
   static Script method1527(int var0, class219 var1) {
      Script var2 = (Script)Script.field1501.get((long)(var0 << 16));
      if(var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = Client.indexScripts.getFile(var3);
         if(var4 == -1) {
            return null;
         } else {
            byte[] var5 = Client.indexScripts.method4119(var4);
            if(var5 != null) {
               if(var5.length <= 1) {
                  return null;
               }

               var2 = TextureProvider.method2414(var5);
               if(var2 != null) {
                  Script.field1501.put(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }
}
