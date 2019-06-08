import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public class class229 {
   @ObfuscatedName("l")
   @Export("__hz_l")
   public static short[][] __hz_l;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Ljb;",
      garbageValue = "-41"
   )
   @Export("getParamKeyDefinition")
   public static ParamKeyDefinition getParamKeyDefinition(int var0) {
      ParamKeyDefinition var1 = (ParamKeyDefinition)ParamKeyDefinition.ParamKeyDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ParamKeyDefinition.__jb_m.takeRecord(11, var0);
         var1 = new ParamKeyDefinition();
         if(var2 != null) {
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
      if(var0 == 6200) {
         class179.Interpreter_intStackSize -= 2;
         Client.__client_rw = (short)class161.method3395(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize]);
         if(Client.__client_rw <= 0) {
            Client.__client_rw = 256;
         }

         Client.__client_rm = (short)class161.method3395(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]);
         if(Client.__client_rm <= 0) {
            Client.__client_rm = 256;
         }

         return 1;
      } else if(var0 == 6201) {
         class179.Interpreter_intStackSize -= 2;
         Client.__client_re = (short)Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         if(Client.__client_re <= 0) {
            Client.__client_re = 256;
         }

         Client.__client_rb = (short)Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         if(Client.__client_rb <= 0) {
            Client.__client_rb = 320;
         }

         return 1;
      } else if(var0 == 6202) {
         class179.Interpreter_intStackSize -= 4;
         Client.__client_rv = (short)Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         if(Client.__client_rv <= 0) {
            Client.__client_rv = 1;
         }

         Client.__client_ri = (short)Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         if(Client.__client_ri <= 0) {
            Client.__client_ri = 32767;
         } else if(Client.__client_ri < Client.__client_rv) {
            Client.__client_ri = Client.__client_rv;
         }

         Client.__client_rs = (short)Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 2];
         if(Client.__client_rs <= 0) {
            Client.__client_rs = 1;
         }

         Client.__client_rp = (short)Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 3];
         if(Client.__client_rp <= 0) {
            Client.__client_rp = 32767;
         } else if(Client.__client_rp < Client.__client_rs) {
            Client.__client_rp = Client.__client_rs;
         }

         return 1;
      } else if(var0 == 6203) {
         if(Client.viewportWidget != null) {
            FontName.setViewportShape(0, 0, Client.viewportWidget.width, Client.viewportWidget.height, false);
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.viewportWidth;
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.viewportHeight;
         } else {
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
         }

         return 1;
      } else if(var0 == 6204) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.__client_re;
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.__client_rb;
         return 1;
      } else if(var0 == 6205) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = class30.method571(Client.__client_rw);
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = class30.method571(Client.__client_rm);
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
      if(Canvas.localPlayer.x >> 7 == Client.destinationX && Canvas.localPlayer.y >> 7 == Client.destinationY) {
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
      if(PacketWriter.clanChat != null) {
         PacketWriter.clanChat.clearIgnoreds();
      }

   }
}
