import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kt")
@Implements("FontName")
public class FontName {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   @Export("FontName_plain11")
   public static final FontName FontName_plain11;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   @Export("FontName_plain12")
   public static final FontName FontName_plain12;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   @Export("FontName_bold12")
   public static final FontName FontName_bold12;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   public static final FontName field3682;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   public static final FontName field3683;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   public static final FontName field3684;
   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   static Widget field3688;
   @ObfuscatedName("h")
   final String field3679;
   @ObfuscatedName("x")
   String field3686;

   static {
      FontName_plain11 = new FontName("PLAIN11", "p11_full");
      FontName_plain12 = new FontName("PLAIN12", "p12_full");
      FontName_bold12 = new FontName("BOLD12", "b12_full");
      field3682 = new FontName("VERDANA11", "verdana_11pt_regular");
      field3683 = new FontName("VERDANA13", "verdana_13pt_regular");
      field3684 = new FontName("VERDANA15", "verdana_15pt_regular");
   }

   FontName(String var1, String var2) {
      this.field3679 = var1;
      this.field3686 = var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lge;B)V",
      garbageValue = "2"
   )
   static final void method5521(PacketBuffer var0) {
      for(int var1 = 0; var1 < class81.field1176; ++var1) {
         int var2 = class81.field1188[var1];
         Player var3 = Client.cachedPlayers[var2];
         int var4 = var0.readUnsignedByte();
         if((var4 & 1) != 0) {
            var4 += var0.readUnsignedByte() << 8;
         }

         byte var5 = -1;
         int var6;
         if((var4 & 512) != 0) {
            var3.graphic = var0.method3676();
            var6 = var0.readInt();
            var3.field924 = var6 >> 16;
            var3.graphicsDelay = (var6 & 65535) + Client.gameCycle;
            var3.spotAnimFrame = 0;
            var3.spotAnimFrameCycle = 0;
            if(var3.graphicsDelay > Client.gameCycle) {
               var3.spotAnimFrame = -1;
            }

            if(var3.graphic == 65535) {
               var3.graphic = -1;
            }
         }

         if((var4 & 256) != 0) {
            var5 = var0.method3600();
         }

         if((var4 & 128) != 0) {
            var3.interacting = var0.method3562();
            if(var3.interacting == 65535) {
               var3.interacting = -1;
            }
         }

         if((var4 & 64) != 0) {
            var6 = var0.readUnsignedByte();
            byte[] var7 = new byte[var6];
            Buffer var8 = new Buffer(var7);
            var0.method3620(var7, 0, var6);
            class81.field1179[var2] = var8;
            var3.decodeApperance(var8);
         }

         int var9;
         int var10;
         int var13;
         int var14;
         if((var4 & 32) != 0) {
            var6 = var0.method3597();
            int var11;
            int var12;
            int var15;
            if(var6 > 0) {
               for(var14 = 0; var14 < var6; ++var14) {
                  var9 = -1;
                  var10 = -1;
                  var11 = -1;
                  var15 = var0.getUSmart();
                  if(var15 == 32767) {
                     var15 = var0.getUSmart();
                     var10 = var0.getUSmart();
                     var9 = var0.getUSmart();
                     var11 = var0.getUSmart();
                  } else if(var15 != 32766) {
                     var10 = var0.getUSmart();
                  } else {
                     var15 = -1;
                  }

                  var12 = var0.getUSmart();
                  var3.applyActorHitsplat(var15, var10, var9, var11, Client.gameCycle, var12);
               }
            }

            var14 = var0.readUnsignedByte();
            if(var14 > 0) {
               for(var15 = 0; var15 < var14; ++var15) {
                  var9 = var0.getUSmart();
                  var10 = var0.getUSmart();
                  if(var10 != 32767) {
                     var11 = var0.getUSmart();
                     var12 = var0.method3597();
                     var13 = var10 > 0?var0.method3553():var12;
                     var3.setCombatInfo(var9, Client.gameCycle, var10, var11, var12, var13);
                  } else {
                     var3.method1579(var9);
                  }
               }
            }
         }

         if((var4 & 4) != 0) {
            var3.field897 = var0.readUnsignedShort();
            if(var3.queueSize == 0) {
               var3.orientation = var3.field897;
               var3.field897 = -1;
            }
         }

         if((var4 & 4096) != 0) {
            class81.field1177[var2] = var0.method3600();
         }

         if((var4 & 2048) != 0) {
            var3.field925 = var0.readByte();
            var3.field927 = var0.method3600();
            var3.field926 = var0.readByte();
            var3.field888 = var0.readByte();
            var3.field896 = var0.readUnsignedShort() + Client.gameCycle;
            var3.field901 = var0.method3562() + Client.gameCycle;
            var3.field931 = var0.method3562();
            if(var3.field586) {
               var3.field925 += var3.field585;
               var3.field927 += var3.field588;
               var3.field926 += var3.field585;
               var3.field888 += var3.field588;
               var3.queueSize = 0;
            } else {
               var3.field925 += var3.pathX[0];
               var3.field927 += var3.pathY[0];
               var3.field926 += var3.pathX[0];
               var3.field888 += var3.pathY[0];
               var3.queueSize = 1;
            }

            var3.field942 = 0;
         }

         if((var4 & 16) != 0) {
            var6 = var0.method3562();
            Permission var17 = (Permission)class7.forOrdinal(class274.method5249(), var0.method3553());
            boolean var20 = var0.method3553() == 1;
            var9 = var0.method3553();
            var10 = var0.offset;
            if(var3.name != null && var3.composition != null) {
               boolean var19 = false;
               if(var17.field3136 && CacheFile.friendManager.isIgnored(var3.name)) {
                  var19 = true;
               }

               if(!var19 && Client.myPlayerIndex == 0 && !var3.hidden) {
                  class81.field1189.offset = 0;
                  var0.method3619(class81.field1189.payload, 0, var9);
                  class81.field1189.offset = 0;
                  String var16 = FontTypeFace.appendTags(MouseRecorder.method1089(class59.method1128(class81.field1189)));
                  var3.overhead = var16.trim();
                  var3.field899 = var6 >> 8;
                  var3.field887 = var6 & 255;
                  var3.overheadTextCyclesRemaining = 150;
                  var3.field938 = var20;
                  var3.field941 = var3 != MilliTimer.localPlayer && var17.field3136 && "" != Client.field808 && var16.toLowerCase().indexOf(Client.field808) == -1;
                  if(var17.field3143) {
                     var13 = var20?91:1;
                  } else {
                     var13 = var20?90:2;
                  }

                  if(var17.field3142 != -1) {
                     OwnWorldComparator.sendGameMessage(var13, MapIconReference.method687(var17.field3142) + var3.name.getName(), var16);
                  } else {
                     OwnWorldComparator.sendGameMessage(var13, var3.name.getName(), var16);
                  }
               }
            }

            var0.offset = var9 + var10;
         }

         if((var4 & 2) != 0) {
            var3.overhead = var0.readString();
            if(var3.overhead.charAt(0) == '~') {
               var3.overhead = var3.overhead.substring(1);
               OwnWorldComparator.sendGameMessage(2, var3.name.getName(), var3.overhead);
            } else if(var3 == MilliTimer.localPlayer) {
               OwnWorldComparator.sendGameMessage(2, var3.name.getName(), var3.overhead);
            }

            var3.field938 = false;
            var3.field899 = 0;
            var3.field887 = 0;
            var3.overheadTextCyclesRemaining = 150;
         }

         if((var4 & 8) != 0) {
            var6 = var0.method3562();
            if(var6 == 65535) {
               var6 = -1;
            }

            var14 = var0.readUnsignedShortOb1();
            class144.method3193(var3, var6, var14);
         }

         if((var4 & 1024) != 0) {
            for(var6 = 0; var6 < 3; ++var6) {
               var3.actions[var6] = var0.readString();
            }
         }

         if(var3.field586) {
            if(var5 == 127) {
               var3.method1173(var3.field585, var3.field588);
            } else {
               byte var18;
               if(var5 != -1) {
                  var18 = var5;
               } else {
                  var18 = class81.field1177[var2];
               }

               var3.method1134(var3.field585, var3.field588, var18);
            }
         }
      }

   }
}
