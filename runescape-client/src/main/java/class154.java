import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class154 extends class297 {
   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexTrack1")
   static IndexData indexTrack1;
   @ObfuscatedName("d")
   final boolean field2131;

   public class154(boolean var1) {
      this.field2131 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lkz;Lkz;B)I",
      garbageValue = "0"
   )
   int method3222(ChatPlayer var1, ChatPlayer var2) {
      if(var1.world != 0) {
         if(var2.world == 0) {
            return this.field2131?-1:1;
         }
      } else if(var2.world != 0) {
         return this.field2131?1:-1;
      }

      return this.method5387(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3222((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "-2037416165"
   )
   static int method3229(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 5504) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         int var4 = class81.intStack[class81.intStackSize + 1];
         if(!Client.field1092) {
            Client.cameraPitchTarget = var3;
            Client.mapAngle = var4;
         }

         return 1;
      } else if(var0 == 5505) {
         class81.intStack[++class81.intStackSize - 1] = Client.cameraPitchTarget;
         return 1;
      } else if(var0 == 5506) {
         class81.intStack[++class81.intStackSize - 1] = Client.mapAngle;
         return 1;
      } else if(var0 == 5530) {
         var3 = class81.intStack[--class81.intStackSize];
         if(var3 < 0) {
            var3 = 0;
         }

         Client.field928 = var3;
         return 1;
      } else if(var0 == 5531) {
         class81.intStack[++class81.intStackSize - 1] = Client.field928;
         return 1;
      } else {
         return 2;
      }
   }
}
