import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
@Implements("OwnWorldComparator")
public class OwnWorldComparator implements Comparator {
   @ObfuscatedName("m")
   @Export("__m")
   boolean __m;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ll;Ll;B)I",
      garbageValue = "21"
   )
   @Export("__m_132")
   int __m_132(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      if(var2.world == var1.world) {
         return 0;
      } else {
         if(this.__m) {
            if(Client.worldId == var1.world) {
               return -1;
            }

            if(var2.world == Client.worldId) {
               return 1;
            }
         }

         return var1.world < var2.world?-1:1;
      }
   }

   @Export("__equals_134")
   @ObfuscatedName("equals")
   public boolean __equals_134(Object var1) {
      return super.equals(var1);
   }

   @Export("compare")
   @ObfuscatedName("compare")
   public int compare(Object var1, Object var2) {
      return this.__m_132((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "-662838966"
   )
   static int method1285(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 5504) {
         class179.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         int var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         if(!Client.isCameraLocked) {
            Client.cameraPitchTarget = var3;
            Client.minimapOrientation = var4;
         }

         return 1;
      } else if(var0 == 5505) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.cameraPitchTarget;
         return 1;
      } else if(var0 == 5506) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.minimapOrientation;
         return 1;
      } else if(var0 == 5530) {
         var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         if(var3 < 0) {
            var3 = 0;
         }

         Client.cameraFollowHeight = var3;
         return 1;
      } else if(var0 == 5531) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.cameraFollowHeight;
         return 1;
      } else {
         return 2;
      }
   }
}
