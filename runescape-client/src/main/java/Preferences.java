import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1964376717
   )
   static int field1187;
   @ObfuscatedName("w")
   @Export("hideRoofs")
   boolean hideRoofs;
   @ObfuscatedName("s")
   @Export("muted")
   boolean muted;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 775193129
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("a")
   @Export("rememberedUsername")
   String rememberedUsername;
   @ObfuscatedName("t")
   @Export("hideUsername")
   boolean hideUsername;
   @ObfuscatedName("r")
   @Export("preferences")
   LinkedHashMap preferences;

   static {
      field1187 = 6;
   }

   Preferences() {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      this.method1647(true);
   }

   @ObfuscatedSignature(
      signature = "(Lgj;)V"
   )
   Preferences(Buffer var1) {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1187) {
            if(var1.readUnsignedByte() == 1) {
               this.hideRoofs = true;
            }

            if(var2 > 1) {
               this.muted = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.screenType = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.preferences.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }

            if(var2 > 4) {
               this.rememberedUsername = var1.getNullString();
            }

            if(var2 > 5) {
               this.hideUsername = var1.method3411();
            }
         } else {
            this.method1647(true);
         }
      } else {
         this.method1647(true);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-28320625"
   )
   void method1647(boolean var1) {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Lgj;",
      garbageValue = "-588566327"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1187);
      var1.putByte(this.hideRoofs?1:0);
      var1.putByte(this.muted?1:0);
      var1.putByte(this.screenType);
      var1.putByte(this.preferences.size());
      Iterator var2 = this.preferences.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putInt(((Integer)var3.getKey()).intValue());
         var1.putInt(((Integer)var3.getValue()).intValue());
      }

      var1.putString(this.rememberedUsername != null?this.rememberedUsername:"");
      var1.writeBooleanAsByte(this.hideUsername);
      return var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1229032326"
   )
   static long method1658() {
      try {
         URL var0 = new URL(ISAACCipher.method3697("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         Buffer var4 = new Buffer(new byte[1000]);

         do {
            int var5 = var3.read(var4.payload, var4.offset, 1000 - var4.offset);
            if(var5 == -1) {
               var4.offset = 0;
               long var7 = var4.readLong();
               return var7;
            }

            var4.offset += var5;
         } while(var4.offset < 1000);

         return 0L;
      } catch (Exception var9) {
         return 0L;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgd;II)V",
      garbageValue = "-1964157393"
   )
   static final void method1662(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class92.field1385 = 0;
      class89.method1867(var0);

      for(int var3 = 0; var3 < class92.field1385; ++var3) {
         int var4 = class92.field1376[var3];
         Player var5 = Client.cachedPlayers[var4];
         int var6 = var0.readUnsignedByte();
         if((var6 & 16) != 0) {
            var6 += var0.readUnsignedByte() << 8;
         }

         byte var7 = -1;
         int var8;
         int var12;
         int var13;
         if((var6 & 128) != 0) {
            var8 = var0.readUnsignedShort();
            Permission[] var9 = new Permission[]{Permission.field3257, Permission.field3253, Permission.field3248, Permission.field3252, Permission.field3251, Permission.field3250};
            Permission var10 = (Permission)ClanMember.forOrdinal(var9, var0.readUnsignedByte());
            boolean var11 = var0.method3432() == 1;
            var12 = var0.readUnsignedByte();
            var13 = var0.offset;
            if(var5.name != null && var5.composition != null) {
               boolean var14 = false;
               if(var10.field3256 && ServerPacket.friendManager.method1670(var5.name)) {
                  var14 = true;
               }

               if(!var14 && Client.myPlayerIndex == 0 && !var5.hidden) {
                  class92.field1387.offset = 0;
                  var0.readBytes(class92.field1387.payload, 0, var12);
                  class92.field1387.offset = 0;
                  Buffer var16 = class92.field1387;
                  String var15 = IndexData.method4484(var16, 32767);
                  String var17 = FontTypeFace.appendTags(PlayerComposition.method4246(var15));
                  var5.overhead = var17.trim();
                  var5.field1114 = var8 >> 8;
                  var5.field1115 = var8 & 255;
                  var5.overheadTextCyclesRemaining = 150;
                  var5.field1103 = var11;
                  var5.inSequence = var5 != class36.localPlayer && var10.field3256 && "" != Client.field857 && var17.toLowerCase().indexOf(Client.field857) == -1;
                  int var18;
                  if(var10.field3255) {
                     var18 = var11?91:1;
                  } else {
                     var18 = var11?90:2;
                  }

                  if(var10.field3254 != -1) {
                     int var21 = var10.field3254;
                     String var20 = "<img=" + var21 + ">";
                     class240.sendGameMessage(var18, var20 + var5.name.getName(), var17);
                  } else {
                     class240.sendGameMessage(var18, var5.name.getName(), var17);
                  }
               }
            }

            var0.offset = var13 + var12;
         }

         if((var6 & 4) != 0) {
            var5.field1125 = var0.method3442();
            if(var5.queueSize == 0) {
               var5.orientation = var5.field1125;
               var5.field1125 = -1;
            }
         }

         if((var6 & 512) != 0) {
            var5.graphic = var0.method3442();
            var8 = var0.method3451();
            var5.field1138 = var8 >> 16;
            var5.graphicsDelay = (var8 & 65535) + Client.gameCycle;
            var5.field1135 = 0;
            var5.field1131 = 0;
            if(var5.graphicsDelay > Client.gameCycle) {
               var5.field1135 = -1;
            }

            if(var5.graphic == 65535) {
               var5.graphic = -1;
            }
         }

         if((var6 & 4096) != 0) {
            var7 = var0.method3396();
         }

         if((var6 & 256) != 0) {
            var5.field1120 = var0.method3458();
            var5.field1141 = var0.method3458();
            var5.field1140 = var0.method3466();
            var5.field1142 = var0.readByte();
            var5.field1143 = var0.method3442() + Client.gameCycle;
            var5.field1107 = var0.method3440() + Client.gameCycle;
            var5.field1145 = var0.method3440();
            if(var5.field812) {
               var5.field1120 += var5.field813;
               var5.field1141 += var5.field814;
               var5.field1140 += var5.field813;
               var5.field1142 += var5.field814;
               var5.queueSize = 0;
            } else {
               var5.field1120 += var5.pathX[0];
               var5.field1141 += var5.pathY[0];
               var5.field1140 += var5.pathX[0];
               var5.field1142 += var5.pathY[0];
               var5.queueSize = 1;
            }

            var5.field1156 = 0;
         }

         if((var6 & 2048) != 0) {
            class92.field1383[var4] = var0.method3466();
         }

         if((var6 & 1) != 0) {
            var5.interacting = var0.method3440();
            if(var5.interacting == 65535) {
               var5.interacting = -1;
            }
         }

         if((var6 & 8) != 0) {
            var5.overhead = var0.readString();
            if(var5.overhead.charAt(0) == '~') {
               var5.overhead = var5.overhead.substring(1);
               class240.sendGameMessage(2, var5.name.getName(), var5.overhead);
            } else if(var5 == class36.localPlayer) {
               class240.sendGameMessage(2, var5.name.getName(), var5.overhead);
            }

            var5.field1103 = false;
            var5.field1114 = 0;
            var5.field1115 = 0;
            var5.overheadTextCyclesRemaining = 150;
         }

         int var22;
         if((var6 & 32) != 0) {
            var8 = var0.method3440();
            if(var8 == 65535) {
               var8 = -1;
            }

            var22 = var0.method3432();
            Size.method188(var5, var8, var22);
         }

         if((var6 & 1024) != 0) {
            for(var8 = 0; var8 < 3; ++var8) {
               var5.actions[var8] = var0.readString();
            }
         }

         if((var6 & 64) != 0) {
            var8 = var0.readUnsignedByteNegate();
            int var23;
            int var28;
            int var29;
            if(var8 > 0) {
               for(var22 = 0; var22 < var8; ++var22) {
                  var28 = -1;
                  var12 = -1;
                  var13 = -1;
                  var23 = var0.getUSmart();
                  if(var23 == 32767) {
                     var23 = var0.getUSmart();
                     var12 = var0.getUSmart();
                     var28 = var0.getUSmart();
                     var13 = var0.getUSmart();
                  } else if(var23 != 32766) {
                     var12 = var0.getUSmart();
                  } else {
                     var23 = -1;
                  }

                  var29 = var0.getUSmart();
                  var5.method1579(var23, var12, var28, var13, Client.gameCycle, var29);
               }
            }

            var22 = var0.method3432();
            if(var22 > 0) {
               for(var23 = 0; var23 < var22; ++var23) {
                  var28 = var0.getUSmart();
                  var12 = var0.getUSmart();
                  if(var12 != 32767) {
                     var13 = var0.getUSmart();
                     var29 = var0.method3432();
                     int var24 = var12 > 0?var0.method3433():var29;
                     var5.method1596(var28, Client.gameCycle, var12, var13, var29, var24);
                  } else {
                     var5.method1589(var28);
                  }
               }
            }
         }

         if((var6 & 2) != 0) {
            var8 = var0.method3433();
            byte[] var25 = new byte[var8];
            Buffer var26 = new Buffer(var25);
            var0.method3453(var25, 0, var8);
            class92.field1377[var4] = var26;
            var5.decodeApperance(var26);
         }

         if(var5.field812) {
            if(var7 == 127) {
               var5.method1138(var5.field813, var5.field814);
            } else {
               byte var27;
               if(var7 != -1) {
                  var27 = var7;
               } else {
                  var27 = class92.field1383[var4];
               }

               var5.method1128(var5.field813, var5.field814, var27);
            }
         }
      }

      if(var0.offset - var2 != var1) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-2035873546"
   )
   @Export("getSmoothNoise")
   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = TotalQuantityComparator.getSmoothNoise2D(var3, var5);
      int var8 = TotalQuantityComparator.getSmoothNoise2D(var3 + 1, var5);
      int var9 = TotalQuantityComparator.getSmoothNoise2D(var3, var5 + 1);
      int var10 = TotalQuantityComparator.getSmoothNoise2D(var3 + 1, var5 + 1);
      int var12 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var11 = ((65536 - var12) * var7 >> 16) + (var12 * var8 >> 16);
      int var14 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var13 = ((65536 - var14) * var9 >> 16) + (var14 * var10 >> 16);
      int var16 = 65536 - Graphics3D.COSINE[var6 * 1024 / var2] >> 1;
      int var15 = ((65536 - var16) * var11 >> 16) + (var13 * var16 >> 16);
      return var15;
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2089186954"
   )
   static final void method1661(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         Player.menuAction(var1, var2, var3, var4, var5, var6, MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
      }
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-1624868287"
   )
   static final void method1657(int var0, int var1, int var2, boolean var3) {
      if(class213.loadWidget(var0)) {
         class65.method1068(FileRequest.widgets[var0], -1, var1, var2, var3);
      }
   }
}
