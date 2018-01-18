import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("n")
   @Export("name")
   String name;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -932580155
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1849896869
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("d")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 311039859
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 58901581
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -75399819
   )
   int field843;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 59872103
   )
   @Export("animationCycleStart")
   int animationCycleStart;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 667267473
   )
   @Export("animationCycleEnd")
   int animationCycleEnd;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1732026087
   )
   int field845;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1323047343
   )
   int field846;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 179564707
   )
   int field847;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 39353673
   )
   int field849;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 725051437
   )
   int field850;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2107520257
   )
   int field851;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1809995707
   )
   int field852;
   @ObfuscatedName("x")
   @Export("isLowDetail")
   boolean isLowDetail;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1621366447
   )
   @Export("team")
   int team;
   @ObfuscatedName("j")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 216738643
   )
   int field856;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 183931407
   )
   int field842;
   @ObfuscatedName("k")
   boolean field858;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -972730425
   )
   int field839;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1336438965
   )
   int field835;

   Player() {
      this.skullIcon = -1;
      this.overheadIcon = -1;
      this.actions = new String[3];

      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.totalLevel = 0;
      this.animationCycleStart = 0;
      this.animationCycleEnd = 0;
      this.isLowDetail = false;
      this.team = 0;
      this.hidden = false;
      this.field858 = false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgv;I)V",
      garbageValue = "2140471717"
   )
   @Export("decodeApperance")
   final void decodeApperance(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.readUnsignedByte();
      this.skullIcon = var1.readByte();
      this.overheadIcon = var1.readByte();
      int var3 = -1;
      this.team = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.readUnsignedByte();
         if(var6 == 0) {
            var4[var5] = 0;
         } else {
            var7 = var1.readUnsignedByte();
            var4[var5] = var7 + (var6 << 8);
            if(var5 == 0 && var4[0] == 65535) {
               var3 = var1.readUnsignedShort();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = class115.getItemDefinition(var4[var5] - 512).int1;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= Huffman.colorsToReplace[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == 65535) {
         super.idlePoseAnimation = -1;
      }

      super.field1156 = var1.readUnsignedShort();
      if(super.field1156 == 65535) {
         super.field1156 = -1;
      }

      super.field1173 = super.field1156;
      super.field1168 = var1.readUnsignedShort();
      if(super.field1168 == 65535) {
         super.field1168 = -1;
      }

      super.field1158 = var1.readUnsignedShort();
      if(super.field1158 == 65535) {
         super.field1158 = -1;
      }

      super.field1175 = var1.readUnsignedShort();
      if(super.field1175 == 65535) {
         super.field1175 = -1;
      }

      super.field1160 = var1.readUnsignedShort();
      if(super.field1160 == 65535) {
         super.field1160 = -1;
      }

      super.field1161 = var1.readUnsignedShort();
      if(super.field1161 == 65535) {
         super.field1161 = -1;
      }

      this.name = var1.readString();
      if(this == GrandExchangeOffer.localPlayer) {
         RunException.localPlayerName = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.totalLevel = var1.readUnsignedShort();
      this.hidden = var1.readUnsignedByte() == 1;
      if(Client.socketType == 0 && Client.rights >= 2) {
         this.hidden = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method4167(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1121589593"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?class45.getNpcDefinition(this.composition.transformedNpcId).field3667:1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Les;",
      garbageValue = "-17"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class45.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.isLowDetail && (super.poseAnimation != super.idlePoseAnimation || var1 == null)?class45.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.field1199 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.isLowDetail && super.graphic != -1 && super.field1187 != -1) {
               var4 = NPCComposition.getSpotAnimType(super.graphic).getModel(super.field1187);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field1190, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.isLowDetail && this.model != null) {
               if(Client.gameCycle >= this.animationCycleEnd) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.animationCycleStart && Client.gameCycle < this.animationCycleEnd) {
                  var4 = this.model;
                  var4.offsetBy(this.field845 - super.x, this.field846 - this.field843, this.field847 - super.y);
                  if(super.orientation == 512) {
                     var4.rotateY90Ccw();
                     var4.rotateY90Ccw();
                     var4.rotateY90Ccw();
                  } else if(super.orientation == 1024) {
                     var4.rotateY90Ccw();
                     var4.rotateY90Ccw();
                  } else if(super.orientation == 1536) {
                     var4.rotateY90Ccw();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.orientation == 512) {
                     var4.rotateY90Ccw();
                  } else if(super.orientation == 1024) {
                     var4.rotateY90Ccw();
                     var4.rotateY90Ccw();
                  } else if(super.orientation == 1536) {
                     var4.rotateY90Ccw();
                     var4.rotateY90Ccw();
                     var4.rotateY90Ccw();
                  }

                  var4.offsetBy(super.x - this.field845, this.field843 - this.field846, super.y - this.field847);
               }
            }

            var3.field1854 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "303809588"
   )
   final void method1151(int var1, int var2, byte var3) {
      if(super.animation != -1 && class45.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1177 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Projectile.method1806(this, var1, var2, (byte)2);
            }

            this.method1140(var1, var2, var3);
         } else {
            this.method1154(var1, var2);
         }
      } else {
         this.method1154(var1, var2);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1474914518"
   )
   void method1154(int var1, int var2) {
      super.queueSize = 0;
      super.field1208 = 0;
      super.field1207 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = super.pathY[0] * 128 + var3 * 64;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "836325485"
   )
   final void method1140(int var1, int var2, byte var3) {
      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var4 = super.queueSize; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.pathTraversed[var4] = super.pathTraversed[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.pathTraversed[0] = var3;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1401638549"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;I)I",
      garbageValue = "-1885949725"
   )
   static final int method1137(long var0, String var2) {
      Random var3 = new Random();
      Buffer var4 = new Buffer(128);
      Buffer var5 = new Buffer(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.putByte(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.putInt(var3.nextInt());
      }

      var4.putInt(var6[0]);
      var4.putInt(var6[1]);
      var4.putLong(var0);
      var4.putLong(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.putInt(var3.nextInt());
      }

      var4.encryptRsa(class86.field1303, class86.field1307);
      var5.putByte(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.putInt(var3.nextInt());
      }

      var5.putLong(var3.nextLong());
      var5.method3323(var3.nextLong());
      if(Client.field1121 != null) {
         var5.putBytes(Client.field1121, 0, Client.field1121.length);
      } else {
         byte[] var16 = BoundingBox.method46();
         var5.putBytes(var16, 0, var16.length);
      }

      var5.putLong(var3.nextLong());
      var5.encryptRsa(class86.field1303, class86.field1307);
      var7 = Size.getLength(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var8 = new Buffer(var7);
      var8.putString(var2);
      var8.offset = var7;
      var8.encryptXtea2(var6);
      Buffer var9 = new Buffer(var4.offset + var5.offset + var8.offset + 5);
      var9.putByte(2);
      var9.putByte(var4.offset);
      var9.putBytes(var4.payload, 0, var4.offset);
      var9.putByte(var5.offset);
      var9.putBytes(var5.payload, 0, var5.offset);
      var9.putShort(var8.offset);
      var9.putBytes(var8.payload, 0, var8.offset);
      String var10 = class216.method4026(var9.payload);

      try {
         URL var11 = new URL(Actor.method1573("services", false) + "m=accountappeal/login.ws");
         URLConnection var12 = var11.openConnection();
         var12.setDoInput(true);
         var12.setDoOutput(true);
         var12.setConnectTimeout(5000);
         OutputStreamWriter var13 = new OutputStreamWriter(var12.getOutputStream());
         var13.write("data2=" + ObjectComposition.method4725(var10) + "&dest=" + ObjectComposition.method4725("passwordchoice.ws"));
         var13.flush();
         InputStream var14 = var12.getInputStream();
         var9 = new Buffer(new byte[1000]);

         do {
            int var15 = var14.read(var9.payload, var9.offset, 1000 - var9.offset);
            if(var15 == -1) {
               var13.close();
               var14.close();
               String var17 = new String(var9.payload);
               if(var17.startsWith("OFFLINE")) {
                  return 4;
               } else if(var17.startsWith("WRONG")) {
                  return 7;
               } else if(var17.startsWith("RELOAD")) {
                  return 3;
               } else if(var17.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var9.decryptXtea(var6);

                  while(var9.offset > 0 && var9.payload[var9.offset - 1] == 0) {
                     --var9.offset;
                  }

                  var17 = new String(var9.payload, 0, var9.offset);
                  if(World.method1617(var17)) {
                     GameObject.method2964(var17, true, false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var9.offset += var15;
         } while(var9.offset < 1000);

         return 5;
      } catch (Throwable var18) {
         var18.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1613859919"
   )
   static final void method1159(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field1108 - Client.field1107) * var5 / 100 + Client.field1107;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1113) {
         var15 = Client.field1113;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field1112) {
            var6 = Client.field1112;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field948) {
         var15 = Client.field948;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field1111) {
            var6 = Client.field1111;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field1110 - Client.field1046) * var5 / 100 + Client.field1046;
      Client.scale = var3 * var6 * var8 / 85504 << 1;
      if(var2 != Client.viewportHeight || var3 != Client.viewportWidth) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 15 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.method2781(var14, 500, 800, var2, var3);
      }

      Client.Viewport_xOffset = var0;
      Client.Viewport_yOffset = var1;
      Client.viewportHeight = var2;
      Client.viewportWidth = var3;
   }
}
