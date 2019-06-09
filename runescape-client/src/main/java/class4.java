import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
final class class4 implements class0 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("__o_m")
   public static AbstractIndexCache __o_m;

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
      return new ClientParameter[]{ClientParameter.__ji_e, ClientParameter.__ji_m, ClientParameter.__ji_g, ClientParameter.__ji_d, ClientParameter.__ji_u, ClientParameter.__ji_o, ClientParameter.__ji_k, ClientParameter.__ji_j, ClientParameter.__ji_q, ClientParameter.__ji_z, ClientParameter.__ji_n, ClientParameter.__ji_a, ClientParameter.__ji_t, ClientParameter.__ji_w, ClientParameter.__ji_i, ClientParameter.__ji_s, ClientParameter.__ji_x, ClientParameter.__ji_f, ClientParameter.__ji_l};
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-843046456"
   )
   public static void method55() {
      OverlayDefinition.__jf_f.clear();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILcg;ZB)I",
      garbageValue = "1"
   )
   static int method54(int var0, Script var1, boolean var2) {
      String var3;
      if(var0 == 3100) {
         var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
         WorldMapIcon1.method219(0, "", var3);
         return 1;
      } else if(var0 == 3101) {
         class179.Interpreter_intStackSize -= 2;
         class234.method4534(Canvas.localPlayer, Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]);
         return 1;
      } else if(var0 == 3103) {
         if(!Interpreter.__bv_t) {
            Interpreter.__bv_s = true;
         }

         return 1;
      } else {
         int var10;
         if(var0 == 3104) {
            var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            var10 = 0;
            if(UserComparator4.method3336(var3)) {
               var10 = MouseHandler.method1085(var3);
            }

            PacketBufferNode var12 = Interpreter.method1915(ClientPacket.__gs_s, Client.packetWriter.isaacCipher);
            var12.packetBuffer.writeInt(var10);
            Client.packetWriter.__q_167(var12);
            return 1;
         } else {
            PacketBufferNode var14;
            if(var0 == 3105) {
               var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               var14 = Interpreter.method1915(ClientPacket.__gs_cl, Client.packetWriter.isaacCipher);
               var14.packetBuffer.writeByte(var3.length() + 1);
               var14.packetBuffer.writeStringCp1252NullTerminated(var3);
               Client.packetWriter.__q_167(var14);
               return 1;
            } else if(var0 == 3106) {
               var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               var14 = Interpreter.method1915(ClientPacket.__gs_e, Client.packetWriter.isaacCipher);
               var14.packetBuffer.writeByte(var3.length() + 1);
               var14.packetBuffer.writeStringCp1252NullTerminated(var3);
               Client.packetWriter.__q_167(var14);
               return 1;
            } else {
               String var7;
               int var15;
               if(var0 == 3107) {
                  var15 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  var7 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                  WorldMapSection2.method583(var15, var7);
                  return 1;
               } else if(var0 == 3108) {
                  class179.Interpreter_intStackSize -= 3;
                  var15 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
                  var10 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
                  int var9 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 2];
                  Widget var13 = Huffman.getWidget(var9);
                  Players.clickWidget(var13, var15, var10);
                  return 1;
               } else if(var0 == 3109) {
                  class179.Interpreter_intStackSize -= 2;
                  var15 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
                  var10 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
                  Widget var11 = var2?WorldMapIcon1.__t_i:class12.__n_n;
                  Players.clickWidget(var11, var15, var10);
                  return 1;
               } else if(var0 == 3110) {
                  AbstractRasterProvider.__lp_ca = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                  return 1;
               } else if(var0 == 3111) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = ReflectionCheck.clientPreferences.roofsHidden?1:0;
                  return 1;
               } else if(var0 == 3112) {
                  ReflectionCheck.clientPreferences.roofsHidden = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                  WorldMapSection0.method247();
                  return 1;
               } else if(var0 == 3113) {
                  var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                  boolean var4 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                  WorldMapCacheName.method635(var3, var4, false);
                  return 1;
               } else if(var0 == 3115) {
                  var15 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  var14 = Interpreter.method1915(ClientPacket.__gs_as, Client.packetWriter.isaacCipher);
                  var14.packetBuffer.writeShort(var15);
                  Client.packetWriter.__q_167(var14);
                  return 1;
               } else if(var0 == 3116) {
                  var15 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  Interpreter.Interpreter_stringStackSize -= 2;
                  var7 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
                  String var5 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
                  if(var7.length() > 500) {
                     return 1;
                  } else if(var5.length() > 500) {
                     return 1;
                  } else {
                     PacketBufferNode var6 = Interpreter.method1915(ClientPacket.__gs_j, Client.packetWriter.isaacCipher);
                     var6.packetBuffer.writeShort(1 + WorldMapRegion.method550(var7) + WorldMapRegion.method550(var5));
                     var6.packetBuffer.writeStringCp1252NullTerminated(var7);
                     var6.packetBuffer.writeByte(var15);
                     var6.packetBuffer.writeStringCp1252NullTerminated(var5);
                     Client.packetWriter.__q_167(var6);
                     return 1;
                  }
               } else if(var0 == 3117) {
                  Client.shiftClickDrop = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                  return 1;
               } else if(var0 == 3118) {
                  Client.showMouseOverText = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                  return 1;
               } else if(var0 == 3119) {
                  Client.renderSelf = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                  return 1;
               } else if(var0 == 3120) {
                  if(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1) {
                     Client.__client_ke |= 1;
                  } else {
                     Client.__client_ke &= -2;
                  }

                  return 1;
               } else if(var0 == 3121) {
                  if(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1) {
                     Client.__client_ke |= 2;
                  } else {
                     Client.__client_ke &= -3;
                  }

                  return 1;
               } else if(var0 == 3122) {
                  if(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1) {
                     Client.__client_ke |= 4;
                  } else {
                     Client.__client_ke &= -5;
                  }

                  return 1;
               } else if(var0 == 3123) {
                  if(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1) {
                     Client.__client_ke |= 8;
                  } else {
                     Client.__client_ke &= -9;
                  }

                  return 1;
               } else if(var0 == 3124) {
                  Client.__client_ke = 0;
                  return 1;
               } else if(var0 == 3125) {
                  Client.showMouseCross = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                  return 1;
               } else if(var0 == 3126) {
                  Client.showLoadingMessages = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                  return 1;
               } else if(var0 == 3127) {
                  WorldMapAreaData.method705(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1);
                  return 1;
               } else if(var0 == 3128) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = class206.method4028()?1:0;
                  return 1;
               } else if(var0 == 3129) {
                  class179.Interpreter_intStackSize -= 2;
                  Client.oculusOrbNormalSpeed = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
                  Client.__client_in = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
                  return 1;
               } else if(var0 == 3130) {
                  class179.Interpreter_intStackSize -= 2;
                  return 1;
               } else if(var0 == 3131) {
                  --class179.Interpreter_intStackSize;
                  return 1;
               } else if(var0 == 3132) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = SoundCache.canvasWidth;
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Huffman.canvasHeight;
                  return 1;
               } else if(var0 == 3133) {
                  --class179.Interpreter_intStackSize;
                  return 1;
               } else if(var0 == 3134) {
                  return 1;
               } else if(var0 == 3135) {
                  class179.Interpreter_intStackSize -= 2;
                  return 1;
               } else if(var0 == 3136) {
                  Client.__client_mf = 3;
                  Client.__client_ms = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  return 1;
               } else if(var0 == 3137) {
                  Client.__client_mf = 2;
                  Client.__client_ms = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  return 1;
               } else if(var0 == 3138) {
                  Client.__client_mf = 0;
                  return 1;
               } else if(var0 == 3139) {
                  Client.__client_mf = 1;
                  return 1;
               } else if(var0 == 3140) {
                  Client.__client_mf = 3;
                  Client.__client_ms = var2?WorldMapIcon1.__t_i.id:class12.__n_n.id;
                  return 1;
               } else {
                  boolean var8;
                  if(var0 == 3141) {
                     var8 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     ReflectionCheck.clientPreferences.hideUsername = var8;
                     WorldMapSection0.method247();
                     return 1;
                  } else if(var0 == 3142) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = ReflectionCheck.clientPreferences.hideUsername?1:0;
                     return 1;
                  } else if(var0 == 3143) {
                     var8 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     Client.Login_isUsernameRemembered = var8;
                     if(!var8) {
                        ReflectionCheck.clientPreferences.rememberedUsername = "";
                        WorldMapSection0.method247();
                     }

                     return 1;
                  } else if(var0 == 3144) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.Login_isUsernameRemembered?1:0;
                     return 1;
                  } else if(var0 == 3145) {
                     return 1;
                  } else if(var0 == 3146) {
                     var8 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     if(var8 == ReflectionCheck.clientPreferences.titleMusicDisabled) {
                        ReflectionCheck.clientPreferences.titleMusicDisabled = !var8;
                        WorldMapSection0.method247();
                     }

                     return 1;
                  } else if(var0 == 3147) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = ReflectionCheck.clientPreferences.titleMusicDisabled?0:1;
                     return 1;
                  } else if(var0 == 3148) {
                     return 1;
                  } else if(var0 == 3149) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if(var0 == 3150) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if(var0 == 3151) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if(var0 == 3152) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if(var0 == 3153) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Login.Login_loadingPercent;
                     return 1;
                  } else if(var0 == 3154) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = GrandExchangeOffer.method101();
                     return 1;
                  } else {
                     return 2;
                  }
               }
            }
         }
      }
   }
}
