import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
final class class4 implements class0 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static AbstractIndexCache field1158;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;Lgr;I)V",
      garbageValue = "-223205903"
   )
   public void vmethod44(Object var1, Buffer var2) {
      this.method45((String)var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;I)Ljava/lang/Object;",
      garbageValue = "704451908"
   )
   public Object vmethod46(Buffer var1) {
      return var1.readStringCp1252NullTerminated();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lgr;B)V",
      garbageValue = "-17"
   )
   void method45(String var1, Buffer var2) {
      var2.writeStringCp1252NullTerminated(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[Lji;",
      garbageValue = "253581236"
   )
   public static ClientParameter[] method47() {
      return new ClientParameter[]{ClientParameter.field330, ClientParameter.field322, ClientParameter.field328, ClientParameter.field332, ClientParameter.field327, ClientParameter.field326, ClientParameter.field333, ClientParameter.field338, ClientParameter.field324, ClientParameter.field337, ClientParameter.field334, ClientParameter.field336, ClientParameter.field340, ClientParameter.field325, ClientParameter.field335, ClientParameter.field339, ClientParameter.field331, ClientParameter.field323, ClientParameter.field329};
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-843046456"
   )
   public static void method55() {
      OverlayDefinition.field664.clear();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILcg;ZB)I",
      garbageValue = "1"
   )
   static int method54(int var0, Script var1, boolean var2) {
      String var3;
      if (var0 == 3100) {
         var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
         WorldMapIcon1.method219(0, "", var3);
         return 1;
      } else if (var0 == 3101) {
         RouteStrategy.Interpreter_intStackSize -= 2;
         class234.method4534(Canvas.localPlayer, Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize], Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1]);
         return 1;
      } else if (var0 == 3103) {
         if (!Interpreter.field424) {
            Interpreter.field423 = true;
         }

         return 1;
      } else {
         int var4;
         PacketBufferNode var5;
         if (var0 == 3104) {
            var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            var4 = 0;
            if (UserComparator4.method3336(var3)) {
               var4 = MouseHandler.method1085(var3);
            }

            var5 = Interpreter.method1915(ClientPacket.field239, Client.packetWriter.isaacCipher);
            var5.packetBuffer.writeInt(var4);
            Client.packetWriter.method241(var5);
            return 1;
         } else if (var0 == 3105) {
            var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            var5 = Interpreter.method1915(ClientPacket.field317, Client.packetWriter.isaacCipher);
            var5.packetBuffer.writeByte(var3.length() + 1);
            var5.packetBuffer.writeStringCp1252NullTerminated(var3);
            Client.packetWriter.method241(var5);
            return 1;
         } else if (var0 == 3106) {
            var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            var5 = Interpreter.method1915(ClientPacket.field230, Client.packetWriter.isaacCipher);
            var5.packetBuffer.writeByte(var3.length() + 1);
            var5.packetBuffer.writeStringCp1252NullTerminated(var3);
            Client.packetWriter.method241(var5);
            return 1;
         } else {
            String var6;
            int var7;
            if (var0 == 3107) {
               var7 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
               var6 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               WorldMapSection2.method583(var7, var6);
               return 1;
            } else if (var0 == 3108) {
               RouteStrategy.Interpreter_intStackSize -= 3;
               var7 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
               var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
               int var13 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 2];
               Widget var11 = Huffman.getWidget(var13);
               Players.clickWidget(var11, var7, var4);
               return 1;
            } else if (var0 == 3109) {
               RouteStrategy.Interpreter_intStackSize -= 2;
               var7 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
               var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
               Widget var12 = var2 ? WorldMapIcon1.field1030 : class12.field1111;
               Players.clickWidget(var12, var7, var4);
               return 1;
            } else if (var0 == 3110) {
               AbstractRasterProvider.mouseCam = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
               return 1;
            } else if (var0 == 3111) {
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = ReflectionCheck.clientPreferences.roofsHidden ? 1 : 0;
               return 1;
            } else if (var0 == 3112) {
               ReflectionCheck.clientPreferences.roofsHidden = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
               WorldMapSection0.savePreferences();
               return 1;
            } else {
               boolean var8;
               if (var0 == 3113) {
                  var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                  var8 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                  WorldMapCacheName.method635(var3, var8, false);
                  return 1;
               } else if (var0 == 3115) {
                  var7 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                  var5 = Interpreter.method1915(ClientPacket.field264, Client.packetWriter.isaacCipher);
                  var5.packetBuffer.writeShort(var7);
                  Client.packetWriter.method241(var5);
                  return 1;
               } else if (var0 == 3116) {
                  var7 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                  Interpreter.Interpreter_stringStackSize -= 2;
                  var6 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
                  String var10 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
                  if (var6.length() > 500) {
                     return 1;
                  } else if (var10.length() > 500) {
                     return 1;
                  } else {
                     PacketBufferNode var9 = Interpreter.method1915(ClientPacket.field238, Client.packetWriter.isaacCipher);
                     var9.packetBuffer.writeShort(1 + WorldMapRegion.method550(var6) + WorldMapRegion.method550(var10));
                     var9.packetBuffer.writeStringCp1252NullTerminated(var6);
                     var9.packetBuffer.writeByte(var7);
                     var9.packetBuffer.writeStringCp1252NullTerminated(var10);
                     Client.packetWriter.method241(var9);
                     return 1;
                  }
               } else if (var0 == 3117) {
                  Client.shiftClickDrop = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3118) {
                  Client.showMouseOverText = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3119) {
                  Client.renderSelf = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3120) {
                  if (Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1) {
                     Client.field210 |= 1;
                  } else {
                     Client.field210 &= -2;
                  }

                  return 1;
               } else if (var0 == 3121) {
                  if (Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1) {
                     Client.field210 |= 2;
                  } else {
                     Client.field210 &= -3;
                  }

                  return 1;
               } else if (var0 == 3122) {
                  if (Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1) {
                     Client.field210 |= 4;
                  } else {
                     Client.field210 &= -5;
                  }

                  return 1;
               } else if (var0 == 3123) {
                  if (Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1) {
                     Client.field210 |= 8;
                  } else {
                     Client.field210 &= -9;
                  }

                  return 1;
               } else if (var0 == 3124) {
                  Client.field210 = 0;
                  return 1;
               } else if (var0 == 3125) {
                  Client.showMouseCross = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3126) {
                  Client.showLoadingMessages = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3127) {
                  WorldMapAreaData.method705(Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1);
                  return 1;
               } else if (var0 == 3128) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = class206.method4028() ? 1 : 0;
                  return 1;
               } else if (var0 == 3129) {
                  RouteStrategy.Interpreter_intStackSize -= 2;
                  Client.oculusOrbNormalSpeed = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
                  Client.field197 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
                  return 1;
               } else if (var0 == 3130) {
                  RouteStrategy.Interpreter_intStackSize -= 2;
                  return 1;
               } else if (var0 == 3131) {
                  --RouteStrategy.Interpreter_intStackSize;
                  return 1;
               } else if (var0 == 3132) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = SoundCache.canvasWidth;
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = Huffman.canvasHeight;
                  return 1;
               } else if (var0 == 3133) {
                  --RouteStrategy.Interpreter_intStackSize;
                  return 1;
               } else if (var0 == 3134) {
                  return 1;
               } else if (var0 == 3135) {
                  RouteStrategy.Interpreter_intStackSize -= 2;
                  return 1;
               } else if (var0 == 3136) {
                  Client.field151 = 3;
                  Client.field153 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                  return 1;
               } else if (var0 == 3137) {
                  Client.field151 = 2;
                  Client.field153 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                  return 1;
               } else if (var0 == 3138) {
                  Client.field151 = 0;
                  return 1;
               } else if (var0 == 3139) {
                  Client.field151 = 1;
                  return 1;
               } else if (var0 == 3140) {
                  Client.field151 = 3;
                  Client.field153 = var2 ? WorldMapIcon1.field1030.id : class12.field1111.id;
                  return 1;
               } else if (var0 == 3141) {
                  var8 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                  ReflectionCheck.clientPreferences.hideUsername = var8;
                  WorldMapSection0.savePreferences();
                  return 1;
               } else if (var0 == 3142) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = ReflectionCheck.clientPreferences.hideUsername ? 1 : 0;
                  return 1;
               } else if (var0 == 3143) {
                  var8 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                  Client.Login_isUsernameRemembered = var8;
                  if (!var8) {
                     ReflectionCheck.clientPreferences.rememberedUsername = "";
                     WorldMapSection0.savePreferences();
                  }

                  return 1;
               } else if (var0 == 3144) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = Client.Login_isUsernameRemembered ? 1 : 0;
                  return 1;
               } else if (var0 == 3145) {
                  return 1;
               } else if (var0 == 3146) {
                  var8 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                  if (var8 == ReflectionCheck.clientPreferences.titleMusicDisabled) {
                     ReflectionCheck.clientPreferences.titleMusicDisabled = !var8;
                     WorldMapSection0.savePreferences();
                  }

                  return 1;
               } else if (var0 == 3147) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = ReflectionCheck.clientPreferences.titleMusicDisabled ? 0 : 1;
                  return 1;
               } else if (var0 == 3148) {
                  return 1;
               } else if (var0 == 3149) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
                  return 1;
               } else if (var0 == 3150) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
                  return 1;
               } else if (var0 == 3151) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
                  return 1;
               } else if (var0 == 3152) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
                  return 1;
               } else if (var0 == 3153) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = Login.Login_loadingPercent;
                  return 1;
               } else if (var0 == 3154) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = GrandExchangeOffer.method101();
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }
}
