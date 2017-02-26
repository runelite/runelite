import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class161 {
   @ObfuscatedName("no")
   @ObfuscatedGetter(
      intValue = -932752509
   )
   static int field2149;

   class161() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILclass48;ZI)I",
      garbageValue = "-962381574"
   )
   static int method3114(int var0, Script var1, boolean var2) {
      if(var0 == 3200) {
         class103.scriptIntStackSize -= 3;
         VertexNormal.method1684(class32.scriptIntStack[class103.scriptIntStackSize], class32.scriptIntStack[1 + class103.scriptIntStackSize], class32.scriptIntStack[2 + class103.scriptIntStackSize]);
         return 1;
      } else {
         int var3;
         if(var0 != 3201) {
            if(var0 == 3202) {
               class103.scriptIntStackSize -= 2;
               var3 = class32.scriptIntStack[class103.scriptIntStackSize];
               int var4 = class32.scriptIntStack[1 + class103.scriptIntStackSize];
               if(Client.field542 != 0 && var3 != -1) {
                  class72.method1464(class150.field2044, var3, 0, Client.field542, false);
                  Client.field545 = true;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            var3 = class32.scriptIntStack[--class103.scriptIntStackSize];
            if(var3 == -1 && !Client.field545) {
               class138.field1916.method2620();
               class138.field1919 = 1;
               class167.field2182 = null;
            } else if(var3 != -1 && var3 != Client.field421 && Client.field542 != 0 && !Client.field545) {
               class152.method2815(2, ScriptState.field127, var3, 0, Client.field542, false);
            }

            Client.field421 = var3;
            return 1;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IS)LFrames;",
      garbageValue = "-28796"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field3055.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         var1 = class16.method185(NPC.field785, class210.field3124, var0, false);
         if(var1 != null) {
            Sequence.field3055.put(var1, (long)var0);
         }

         return var1;
      }
   }
}
