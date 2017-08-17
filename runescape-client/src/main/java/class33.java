import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class33 {
   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("indexInterfaces")
   static IndexData indexInterfaces;
   @ObfuscatedName("j")
   String field483;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   class24 field480;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 321750515
   )
   int field477;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2081967947
   )
   int field479;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILn;)V"
   )
   class33(String var1, int var2, int var3, class24 var4) {
      this.field483 = var1;
      this.field477 = var2;
      this.field479 = var3;
      this.field480 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Lef;",
      garbageValue = "-2077985547"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.skeletons.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = XGrandExchangeOffer.method104(class18.skel_ref, Sequence.skin_ref, var0, false);
         if(var1 != null) {
            Sequence.skeletons.put(var1, (long)var0);
         }

         return var1;
      }
   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-113"
   )
   static final void method374() {
      if(VertexNormal.rssocket != null) {
         VertexNormal.rssocket.close();
         VertexNormal.rssocket = null;
      }

      class276.method4935();
      class36.region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      class204.field2507 = 1;
      class204.field2502 = null;
      class150.field2205 = -1;
      class153.field2222 = -1;
      class204.field2504 = 0;
      class99.field1532 = false;
      class204.field2505 = 2;
      Client.field1095 = -1;
      Client.field1163 = false;
      class56.method869();
      MouseInput.setGameState(10);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lia;Lia;Ljava/lang/String;Ljava/lang/String;I)Ljh;",
      garbageValue = "-625761073"
   )
   public static Font method375(IndexDataBase var0, IndexDataBase var1, String var2, String var3) {
      int var4 = var0.getFile(var2);
      int var5 = var0.getChild(var4, var3);
      return FileSystem.method4108(var0, var1, var4, var5);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-800569776"
   )
   static void method372() {
      FileOnDisk var0 = null;

      try {
         var0 = class12.getPreferencesFile("", class35.field505.field3183, true);
         Buffer var1 = class3.preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.close();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lhi;I)Ljava/lang/String;",
      garbageValue = "463349918"
   )
   static String method371(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = class182.method3456(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var7 = "";
            if(class69.field850 != null) {
               var7 = Occluder.method2916(class69.field850.field2232);
               if(class69.field850.value != null) {
                  var7 = (String)class69.field850.value;
               }
            }

            var0 = var0.substring(0, var2) + var7 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lfo;ILbz;IB)V",
      garbageValue = "-4"
   )
   static final void method373(PacketBuffer var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 1) != 0) {
         var5 = var0.readUnsignedByte();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.readBytes(var6, 0, var5);
         class97.field1519[var1] = var7;
         var2.decodeApperance(var7);
      }

      int var14;
      if((var3 & 16) != 0) {
         var5 = var0.readUnsignedShort();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var14 = var0.readUnsignedByte();
         class3.method6(var2, var5, var14);
      }

      if((var3 & 4) != 0) {
         var2.interacting = var0.readUnsignedShort();
         if(var2.interacting == '\uffff') {
            var2.interacting = -1;
         }
      }

      if((var3 & 128) != 0) {
         var2.overhead = var0.readString();
         if(var2.overhead.charAt(0) == 126) {
            var2.overhead = var2.overhead.substring(1);
            NPC.sendGameMessage(2, var2.name, var2.overhead);
         } else if(var2 == XGrandExchangeOffer.localPlayer) {
            NPC.sendGameMessage(2, var2.name, var2.overhead);
         }

         var2.field1273 = false;
         var2.field1235 = 0;
         var2.field1236 = 0;
         var2.field1274 = 150;
      }

      int var9;
      int var10;
      if((var3 & 8) != 0) {
         var5 = var0.readUnsignedByte();
         int var8;
         int var11;
         int var15;
         if(var5 > 0) {
            for(var14 = 0; var14 < var5; ++var14) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var15 = var0.getUSmart();
               if(var15 == 32767) {
                  var15 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  var8 = var0.getUSmart();
                  var10 = var0.getUSmart();
               } else if(var15 != 32766) {
                  var9 = var0.getUSmart();
               } else {
                  var15 = -1;
               }

               var11 = var0.getUSmart();
               var2.method1528(var15, var9, var8, var10, Client.gameCycle, var11);
            }
         }

         var14 = var0.readUnsignedByte();
         if(var14 > 0) {
            for(var15 = 0; var15 < var14; ++var15) {
               var8 = var0.getUSmart();
               var9 = var0.getUSmart();
               if(var9 != 32767) {
                  var10 = var0.getUSmart();
                  var11 = var0.readUnsignedByte();
                  int var12 = var9 > 0?var0.readUnsignedByte():var11;
                  var2.method1529(var8, Client.gameCycle, var9, var10, var11, var12);
               } else {
                  var2.method1530(var8);
               }
            }
         }
      }

      if((var3 & 32) != 0) {
         var2.field1246 = var0.readUnsignedShort();
         if(var2.queueSize == 0) {
            var2.orientation = var2.field1246;
            var2.field1246 = -1;
         }
      }

      if((var3 & 2) != 0) {
         var5 = var0.readUnsignedShort();
         Permission[] var17 = new Permission[]{Permission.field3168, Permission.field3169, Permission.field3164, Permission.field3167, Permission.field3166, Permission.field3165};
         Permission var18 = (Permission)PlayerComposition.forOrdinal(var17, var0.readUnsignedByte());
         boolean var20 = var0.readUnsignedByte() == 1;
         var9 = var0.readUnsignedByte();
         var10 = var0.offset;
         if(var2.name != null && var2.composition != null) {
            boolean var21 = false;
            if(var18.field3172 && class27.isIgnored(var2.name)) {
               var21 = true;
            }

            if(!var21 && Client.field1136 == 0 && !var2.hidden) {
               class97.field1509.offset = 0;
               var0.readBytes(class97.field1509.payload, 0, var9);
               class97.field1509.offset = 0;
               String var16 = FontTypeFace.appendTags(VarPlayerType.method4301(class229.method4091(class97.field1509)));
               var2.overhead = var16.trim();
               var2.field1235 = var5 >> 8;
               var2.field1236 = var5 & 255;
               var2.field1274 = 150;
               var2.field1273 = var20;
               var2.inSequence = var2 != XGrandExchangeOffer.localPlayer && var18.field3172 && "" != Client.field1144 && var16.toLowerCase().indexOf(Client.field1144) == -1;
               int var13;
               if(var18.field3171) {
                  var13 = var20?91:1;
               } else {
                  var13 = var20?90:2;
               }

               if(var18.field3170 != -1) {
                  NPC.sendGameMessage(var13, class89.method1717(var18.field3170) + var2.name, var16);
               } else {
                  NPC.sendGameMessage(var13, var2.name, var16);
               }
            }
         }

         var0.offset = var9 + var10;
      }

      if((var3 & 256) != 0) {
         var2.graphic = var0.readUnsignedShort();
         var5 = var0.readInt();
         var2.field1259 = var5 >> 16;
         var2.graphicsDelay = (var5 & '\uffff') + Client.gameCycle;
         var2.field1256 = 0;
         var2.field1257 = 0;
         if(var2.graphicsDelay > Client.gameCycle) {
            var2.field1256 = -1;
         }

         if(var2.graphic == '\uffff') {
            var2.graphic = -1;
         }
      }

      if((var3 & 2048) != 0) {
         var2.field1260 = var0.readByte();
         var2.field1262 = var0.readByte();
         var2.field1271 = var0.readByte();
         var2.field1263 = var0.readByte();
         var2.field1264 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field1265 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field1266 = var0.readUnsignedShort();
         if(var2.field903) {
            var2.field1260 += var2.field921;
            var2.field1262 += var2.field922;
            var2.field1271 += var2.field921;
            var2.field1263 += var2.field922;
            var2.queueSize = 0;
         } else {
            var2.field1260 += var2.pathX[0];
            var2.field1262 += var2.pathY[0];
            var2.field1271 += var2.pathX[0];
            var2.field1263 += var2.pathY[0];
            var2.queueSize = 1;
         }

         var2.field1277 = 0;
      }

      if((var3 & 512) != 0) {
         class97.field1508[var1] = var0.readByte();
      }

      if((var3 & 1024) != 0) {
         var4 = var0.readByte();
      }

      if((var3 & 4096) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readString();
         }
      }

      if(var2.field903) {
         if(var4 == 127) {
            var2.method1190(var2.field921, var2.field922);
         } else {
            byte var19;
            if(var4 != -1) {
               var19 = var4;
            } else {
               var19 = class97.field1508[var1];
            }

            var2.method1189(var2.field921, var2.field922, var19);
         }
      }

   }
}
