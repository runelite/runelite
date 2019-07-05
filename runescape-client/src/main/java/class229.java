import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public class class229 {
   @ObfuscatedName("l")
   public static short[][] field1137;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Ljb;",
      garbageValue = "-41"
   )
   @Export("getParamKeyDefinition")
   public static ParamKeyDefinition getParamKeyDefinition(int var0) {
      ParamKeyDefinition var1 = (ParamKeyDefinition)ParamKeyDefinition.ParamKeyDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = ParamKeyDefinition.field679.takeRecord(11, var0);
         var1 = new ParamKeyDefinition();
         if (var2 != null) {
            var1.read(new Buffer(var2));
         }

         var1.init();
         ParamKeyDefinition.ParamKeyDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "1886084106"
   )
   static int method4513(int var0, Script var1, boolean var2) {
      if (var0 == 6200) {
         RouteStrategy.Interpreter_intStackSize -= 2;
         Client.field130 = (short)class161.method3395(Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize]);
         if (Client.field130 <= 0) {
            Client.field130 = 256;
         }

         Client.field131 = (short)class161.method3395(Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1]);
         if (Client.field131 <= 0) {
            Client.field131 = 256;
         }

         return 1;
      } else if (var0 == 6201) {
         RouteStrategy.Interpreter_intStackSize -= 2;
         Client.field150 = (short)Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         if (Client.field150 <= 0) {
            Client.field150 = 256;
         }

         Client.field149 = (short)Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         if (Client.field149 <= 0) {
            Client.field149 = 320;
         }

         return 1;
      } else if (var0 == 6202) {
         RouteStrategy.Interpreter_intStackSize -= 4;
         Client.field135 = (short)Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         if (Client.field135 <= 0) {
            Client.field135 = 1;
         }

         Client.field134 = (short)Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         if (Client.field134 <= 0) {
            Client.field134 = 32767;
         } else if (Client.field134 < Client.field135) {
            Client.field134 = Client.field135;
         }

         Client.field132 = (short)Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 2];
         if (Client.field132 <= 0) {
            Client.field132 = 1;
         }

         Client.field133 = (short)Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 3];
         if (Client.field133 <= 0) {
            Client.field133 = 32767;
         } else if (Client.field133 < Client.field132) {
            Client.field133 = Client.field132;
         }

         return 1;
      } else if (var0 == 6203) {
         if (Client.viewportWidget != null) {
            FontName.setViewportShape(0, 0, Client.viewportWidget.width, Client.viewportWidget.height, false);
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = Client.viewportWidth;
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = Client.viewportHeight;
         } else {
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
         }

         return 1;
      } else if (var0 == 6204) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = Client.field150;
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = Client.field149;
         return 1;
      } else if (var0 == 6205) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = class30.method571(Client.field130);
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = class30.method571(Client.field131);
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-21"
   )
   static void method4514() {
      if (Canvas.localPlayer.x >> 7 == Client.destinationX && Canvas.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

   }

   @ObfuscatedName("kj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "20"
   )
   static final void method4512() {
      SecureRandomFuture.method2104();
      if (PacketWriter.clanChat != null) {
         PacketWriter.clanChat.clearIgnoreds();
      }

   }
}
